package androidx.media3.exoplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class Loader implements LoaderErrorThrower {
    private static final int ACTION_TYPE_DONT_RETRY = 2;
    private static final int ACTION_TYPE_DONT_RETRY_FATAL = 3;
    private static final int ACTION_TYPE_RETRY = 0;
    private static final int ACTION_TYPE_RETRY_AND_RESET_ERROR_COUNT = 1;
    public static final LoadErrorAction DONT_RETRY;
    public static final LoadErrorAction DONT_RETRY_FATAL;
    public static final LoadErrorAction RETRY;
    public static final LoadErrorAction RETRY_RESET_ERROR_COUNT;
    private static final String THREAD_NAME_PREFIX = "ExoPlayer:Loader:";

    @Nullable
    private LoadTask<? extends Loadable> currentTask;
    private final ExecutorService downloadExecutorService;

    @Nullable
    private IOException fatalError;

    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t10, long j10, long j11, boolean z10);

        void onLoadCompleted(T t10, long j10, long j11);

        LoadErrorAction onLoadError(T t10, long j10, long j11, IOException iOException, int i10);
    }

    public static final class LoadErrorAction {
        private final long retryDelayMillis;
        private final int type;

        public boolean isRetry() {
            int i10 = this.type;
            return i10 == 0 || i10 == 1;
        }

        private LoadErrorAction(int i10, long j10) {
            this.type = i10;
            this.retryDelayMillis = j10;
        }
    }

    @SuppressLint({"HandlerLeak"})
    private final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        private static final int MSG_FATAL_ERROR = 3;
        private static final int MSG_FINISH = 1;
        private static final int MSG_IO_EXCEPTION = 2;
        private static final int MSG_START = 0;
        private static final String TAG = "LoadTask";

        @Nullable
        private Callback<T> callback;
        private boolean canceled;

        @Nullable
        private IOException currentError;
        public final int defaultMinRetryCount;
        private int errorCount;

        @Nullable
        private Thread executorThread;
        private final T loadable;
        private volatile boolean released;
        private final long startTimeMs;

        public LoadTask(Looper looper, T t10, Callback<T> callback, int i10, long j10) {
            super(looper);
            this.loadable = t10;
            this.callback = callback;
            this.defaultMinRetryCount = i10;
            this.startTimeMs = j10;
        }

        private void execute() {
            this.currentError = null;
            Loader.this.downloadExecutorService.execute((Runnable) Assertions.checkNotNull(Loader.this.currentTask));
        }

        private void finish() {
            Loader.this.currentTask = null;
        }

        private long getRetryDelayMillis() {
            return Math.min((this.errorCount - 1) * 1000, 5000);
        }

        public void cancel(boolean z10) {
            this.released = z10;
            this.currentError = null;
            if (hasMessages(0)) {
                this.canceled = true;
                removeMessages(0);
                if (!z10) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.canceled = true;
                    this.loadable.cancelLoad();
                    Thread thread = this.executorThread;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z10) {
                finish();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((Callback) Assertions.checkNotNull(this.callback)).onLoadCanceled(this.loadable, jElapsedRealtime, jElapsedRealtime - this.startTimeMs, true);
                this.callback = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.released) {
                return;
            }
            int i10 = message.what;
            if (i10 == 0) {
                execute();
                return;
            }
            if (i10 == 3) {
                throw ((Error) message.obj);
            }
            finish();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = jElapsedRealtime - this.startTimeMs;
            Callback callback = (Callback) Assertions.checkNotNull(this.callback);
            if (this.canceled) {
                callback.onLoadCanceled(this.loadable, jElapsedRealtime, j10, false);
                return;
            }
            int i11 = message.what;
            if (i11 == 1) {
                try {
                    callback.onLoadCompleted(this.loadable, jElapsedRealtime, j10);
                    return;
                } catch (RuntimeException e10) {
                    Log.e(TAG, "Unexpected exception handling load completed", e10);
                    Loader.this.fatalError = new UnexpectedLoaderException(e10);
                    return;
                }
            }
            if (i11 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.currentError = iOException;
            int i12 = this.errorCount + 1;
            this.errorCount = i12;
            LoadErrorAction loadErrorActionOnLoadError = callback.onLoadError(this.loadable, jElapsedRealtime, j10, iOException, i12);
            if (loadErrorActionOnLoadError.type == 3) {
                Loader.this.fatalError = this.currentError;
            } else if (loadErrorActionOnLoadError.type != 2) {
                if (loadErrorActionOnLoadError.type == 1) {
                    this.errorCount = 1;
                }
                start(loadErrorActionOnLoadError.retryDelayMillis != C.TIME_UNSET ? loadErrorActionOnLoadError.retryDelayMillis : getRetryDelayMillis());
            }
        }

        public void maybeThrowError(int i10) throws IOException {
            IOException iOException = this.currentError;
            if (iOException != null && this.errorCount > i10) {
                throw iOException;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            try {
                synchronized (this) {
                    z10 = !this.canceled;
                    this.executorThread = Thread.currentThread();
                }
                if (z10) {
                    TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                    try {
                        this.loadable.load();
                        TraceUtil.endSection();
                    } catch (Throwable th) {
                        TraceUtil.endSection();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.executorThread = null;
                    Thread.interrupted();
                }
                if (this.released) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e10) {
                if (this.released) {
                    return;
                }
                obtainMessage(2, e10).sendToTarget();
            } catch (Error e11) {
                if (!this.released) {
                    Log.e(TAG, "Unexpected error loading stream", e11);
                    obtainMessage(3, e11).sendToTarget();
                }
                throw e11;
            } catch (Exception e12) {
                if (this.released) {
                    return;
                }
                Log.e(TAG, "Unexpected exception loading stream", e12);
                obtainMessage(2, new UnexpectedLoaderException(e12)).sendToTarget();
            } catch (OutOfMemoryError e13) {
                if (this.released) {
                    return;
                }
                Log.e(TAG, "OutOfMemory error loading stream", e13);
                obtainMessage(2, new UnexpectedLoaderException(e13)).sendToTarget();
            }
        }

        public void start(long j10) {
            Assertions.checkState(Loader.this.currentTask == null);
            Loader.this.currentTask = this;
            if (j10 > 0) {
                sendEmptyMessageDelayed(0, j10);
            } else {
                execute();
            }
        }
    }

    public interface Loadable {
        void cancelLoad();

        void load() throws IOException;
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    private static final class ReleaseTask implements Runnable {
        private final ReleaseCallback callback;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.callback = releaseCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.callback.onLoaderReleased();
        }
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected ");
            sb.append(th.getClass().getSimpleName());
            if (th.getMessage() != null) {
                str = ": " + th.getMessage();
            } else {
                str = "";
            }
            sb.append(str);
            super(sb.toString(), th);
        }
    }

    static {
        long j10 = C.TIME_UNSET;
        RETRY = createRetryAction(false, C.TIME_UNSET);
        RETRY_RESET_ERROR_COUNT = createRetryAction(true, C.TIME_UNSET);
        DONT_RETRY = new LoadErrorAction(2, j10);
        DONT_RETRY_FATAL = new LoadErrorAction(3, j10);
    }

    public Loader(String str) {
        this.downloadExecutorService = Util.newSingleThreadExecutor(THREAD_NAME_PREFIX + str);
    }

    public static LoadErrorAction createRetryAction(boolean z10, long j10) {
        return new LoadErrorAction(z10 ? 1 : 0, j10);
    }

    public void cancelLoading() {
        ((LoadTask) Assertions.checkStateNotNull(this.currentTask)).cancel(false);
    }

    public void clearFatalError() {
        this.fatalError = null;
    }

    public boolean hasFatalError() {
        return this.fatalError != null;
    }

    public boolean isLoading() {
        return this.currentTask != null;
    }

    @Override // androidx.media3.exoplayer.upstream.LoaderErrorThrower
    public void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    public void release() {
        release(null);
    }

    public <T extends Loadable> long startLoading(T t10, Callback<T> callback, int i10) {
        Looper looper = (Looper) Assertions.checkStateNotNull(Looper.myLooper());
        this.fatalError = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(looper, t10, callback, i10, jElapsedRealtime).start(0L);
        return jElapsedRealtime;
    }

    @Override // androidx.media3.exoplayer.upstream.LoaderErrorThrower
    public void maybeThrowError(int i10) throws IOException {
        IOException iOException = this.fatalError;
        if (iOException != null) {
            throw iOException;
        }
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = loadTask.defaultMinRetryCount;
            }
            loadTask.maybeThrowError(i10);
        }
    }

    public void release(@Nullable ReleaseCallback releaseCallback) {
        LoadTask<? extends Loadable> loadTask = this.currentTask;
        if (loadTask != null) {
            loadTask.cancel(true);
        }
        if (releaseCallback != null) {
            this.downloadExecutorService.execute(new ReleaseTask(releaseCallback));
        }
        this.downloadExecutorService.shutdown();
    }
}
