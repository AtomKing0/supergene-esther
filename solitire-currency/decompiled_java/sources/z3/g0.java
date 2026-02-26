package z3;

import a4.o0;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: Loader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f37400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f37401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f37402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f37403g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f37404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private d<? extends e> f37405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private IOException f37406c;

    /* JADX INFO: compiled from: Loader.java */
    public interface b<T extends e> {
        c c(T t10, long j10, long j11, IOException iOException, int i10);

        void d(T t10, long j10, long j11);

        void e(T t10, long j10, long j11, boolean z10);
    }

    /* JADX INFO: compiled from: Loader.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f37407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f37408b;

        public boolean c() {
            int i10 = this.f37407a;
            return i10 == 0 || i10 == 1;
        }

        private c(int i10, long j10) {
            this.f37407a = i10;
            this.f37408b = j10;
        }
    }

    /* JADX INFO: compiled from: Loader.java */
    @SuppressLint({"HandlerLeak"})
    private final class d<T extends e> extends Handler implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f37409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f37410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f37411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private b<T> f37412d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private IOException f37413e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f37414f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private Thread f37415g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f37416h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private volatile boolean f37417i;

        public d(Looper looper, T t10, b<T> bVar, int i10, long j10) {
            super(looper);
            this.f37410b = t10;
            this.f37412d = bVar;
            this.f37409a = i10;
            this.f37411c = j10;
        }

        private void b() {
            this.f37413e = null;
            g0.this.f37404a.execute((Runnable) a4.a.e(g0.this.f37405b));
        }

        private void c() {
            g0.this.f37405b = null;
        }

        private long d() {
            return Math.min((this.f37414f - 1) * 1000, 5000);
        }

        public void a(boolean z10) {
            this.f37417i = z10;
            this.f37413e = null;
            if (hasMessages(0)) {
                this.f37416h = true;
                removeMessages(0);
                if (!z10) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.f37416h = true;
                    this.f37410b.cancelLoad();
                    Thread thread = this.f37415g;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z10) {
                c();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((b) a4.a.e(this.f37412d)).e(this.f37410b, jElapsedRealtime, jElapsedRealtime - this.f37411c, true);
                this.f37412d = null;
            }
        }

        public void e(int i10) throws IOException {
            IOException iOException = this.f37413e;
            if (iOException != null && this.f37414f > i10) {
                throw iOException;
            }
        }

        public void f(long j10) {
            a4.a.g(g0.this.f37405b == null);
            g0.this.f37405b = this;
            if (j10 > 0) {
                sendEmptyMessageDelayed(0, j10);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f37417i) {
                return;
            }
            int i10 = message.what;
            if (i10 == 0) {
                b();
                return;
            }
            if (i10 == 3) {
                throw ((Error) message.obj);
            }
            c();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = jElapsedRealtime - this.f37411c;
            b bVar = (b) a4.a.e(this.f37412d);
            if (this.f37416h) {
                bVar.e(this.f37410b, jElapsedRealtime, j10, false);
                return;
            }
            int i11 = message.what;
            if (i11 == 1) {
                try {
                    bVar.d(this.f37410b, jElapsedRealtime, j10);
                    return;
                } catch (RuntimeException e10) {
                    a4.t.d("LoadTask", "Unexpected exception handling load completed", e10);
                    g0.this.f37406c = new h(e10);
                    return;
                }
            }
            if (i11 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f37413e = iOException;
            int i12 = this.f37414f + 1;
            this.f37414f = i12;
            c cVarC = bVar.c(this.f37410b, jElapsedRealtime, j10, iOException, i12);
            if (cVarC.f37407a == 3) {
                g0.this.f37406c = this.f37413e;
            } else if (cVarC.f37407a != 2) {
                if (cVarC.f37407a == 1) {
                    this.f37414f = 1;
                }
                f(cVarC.f37408b != C.TIME_UNSET ? cVarC.f37408b : d());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            try {
                synchronized (this) {
                    z10 = !this.f37416h;
                    this.f37415g = Thread.currentThread();
                }
                if (z10) {
                    a4.m0.a("load:" + this.f37410b.getClass().getSimpleName());
                    try {
                        this.f37410b.load();
                        a4.m0.c();
                    } catch (Throwable th) {
                        a4.m0.c();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f37415g = null;
                    Thread.interrupted();
                }
                if (this.f37417i) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e10) {
                if (this.f37417i) {
                    return;
                }
                obtainMessage(2, e10).sendToTarget();
            } catch (Error e11) {
                if (!this.f37417i) {
                    a4.t.d("LoadTask", "Unexpected error loading stream", e11);
                    obtainMessage(3, e11).sendToTarget();
                }
                throw e11;
            } catch (Exception e12) {
                if (this.f37417i) {
                    return;
                }
                a4.t.d("LoadTask", "Unexpected exception loading stream", e12);
                obtainMessage(2, new h(e12)).sendToTarget();
            } catch (OutOfMemoryError e13) {
                if (this.f37417i) {
                    return;
                }
                a4.t.d("LoadTask", "OutOfMemory error loading stream", e13);
                obtainMessage(2, new h(e13)).sendToTarget();
            }
        }
    }

    /* JADX INFO: compiled from: Loader.java */
    public interface e {
        void cancelLoad();

        void load() throws IOException;
    }

    /* JADX INFO: compiled from: Loader.java */
    public interface f {
        void onLoaderReleased();
    }

    /* JADX INFO: compiled from: Loader.java */
    private static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f37419a;

        public g(f fVar) {
            this.f37419a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37419a.onLoaderReleased();
        }
    }

    /* JADX INFO: compiled from: Loader.java */
    public static final class h extends IOException {
        public h(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    static {
        long j10 = C.TIME_UNSET;
        f37400d = g(false, C.TIME_UNSET);
        f37401e = g(true, C.TIME_UNSET);
        f37402f = new c(2, j10);
        f37403g = new c(3, j10);
    }

    public g0(String str) {
        this.f37404a = o0.x0("ExoPlayer:Loader:" + str);
    }

    public static c g(boolean z10, long j10) {
        return new c(z10 ? 1 : 0, j10);
    }

    public void e() {
        ((d) a4.a.i(this.f37405b)).a(false);
    }

    public void f() {
        this.f37406c = null;
    }

    public boolean h() {
        return this.f37406c != null;
    }

    public boolean i() {
        return this.f37405b != null;
    }

    public void j() throws IOException {
        k(Integer.MIN_VALUE);
    }

    public void k(int i10) throws IOException {
        IOException iOException = this.f37406c;
        if (iOException != null) {
            throw iOException;
        }
        d<? extends e> dVar = this.f37405b;
        if (dVar != null) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = dVar.f37409a;
            }
            dVar.e(i10);
        }
    }

    public void l() {
        m(null);
    }

    public void m(@Nullable f fVar) {
        d<? extends e> dVar = this.f37405b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.f37404a.execute(new g(fVar));
        }
        this.f37404a.shutdown();
    }

    public <T extends e> long n(T t10, b<T> bVar, int i10) {
        Looper looper = (Looper) a4.a.i(Looper.myLooper());
        this.f37406c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new d(looper, t10, bVar, i10, jElapsedRealtime).f(0L);
        return jElapsedRealtime;
    }
}
