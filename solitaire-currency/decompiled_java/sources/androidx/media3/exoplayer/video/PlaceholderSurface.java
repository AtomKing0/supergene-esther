package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.EGLSurfaceTexture;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(17)
@UnstableApi
public final class PlaceholderSurface extends Surface {
    private static final String TAG = "PlaceholderSurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final PlaceholderSurfaceThread thread;
    private boolean threadReleased;

    private static class PlaceholderSurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;

        @Nullable
        private Error initError;

        @Nullable
        private RuntimeException initException;

        @Nullable
        private PlaceholderSurface surface;

        public PlaceholderSurfaceThread() {
            super("ExoPlayer:PlaceholderSurface");
        }

        private void initInternal(int i10) throws GlUtil.GlException {
            Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.init(i10);
            this.surface = new PlaceholderSurface(this, this.eglSurfaceTexture.getSurfaceTexture(), i10 != 0);
        }

        private void releaseInternal() {
            Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.release();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            try {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return true;
                    }
                    try {
                        releaseInternal();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    initInternal(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (GlUtil.GlException e10) {
                    Log.e(PlaceholderSurface.TAG, "Failed to initialize placeholder surface", e10);
                    this.initException = new IllegalStateException(e10);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e11) {
                    Log.e(PlaceholderSurface.TAG, "Failed to initialize placeholder surface", e11);
                    this.initError = e11;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e12) {
                    Log.e(PlaceholderSurface.TAG, "Failed to initialize placeholder surface", e12);
                    this.initException = e12;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }

        public PlaceholderSurface init(int i10) {
            boolean z10;
            start();
            this.handler = new Handler(getLooper(), this);
            this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z10 = false;
                this.handler.obtainMessage(1, i10, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.initError;
            if (error == null) {
                return (PlaceholderSurface) Assertions.checkNotNull(this.surface);
            }
            throw error;
        }

        public void release() {
            Assertions.checkNotNull(this.handler);
            this.handler.sendEmptyMessage(2);
        }
    }

    private static int getSecureMode(Context context) {
        if (GlUtil.isProtectedContentExtensionSupported(context)) {
            return GlUtil.isSurfacelessContextExtensionSupported() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        if (!secureModeInitialized) {
            secureMode = getSecureMode(context);
            secureModeInitialized = true;
        }
        return secureMode != 0;
    }

    public static PlaceholderSurface newInstanceV17(Context context, boolean z10) {
        Assertions.checkState(!z10 || isSecureSupported(context));
        return new PlaceholderSurfaceThread().init(z10 ? secureMode : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    private PlaceholderSurface(PlaceholderSurfaceThread placeholderSurfaceThread, SurfaceTexture surfaceTexture, boolean z10) {
        super(surfaceTexture);
        this.thread = placeholderSurfaceThread;
        this.secure = z10;
    }
}
