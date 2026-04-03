package b4;

import a4.o;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: PlaceholderSurface.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(17)
public final class i extends Surface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f2138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f2139e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f2141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2142c;

    /* JADX INFO: compiled from: PlaceholderSurface.java */
    private static class b extends HandlerThread implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private a4.j f2143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Handler f2144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Error f2145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private RuntimeException f2146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private i f2147e;

        public b() {
            super("ExoPlayer:PlaceholderSurface");
        }

        private void b(int i10) throws o.a {
            a4.a.e(this.f2143a);
            this.f2143a.h(i10);
            this.f2147e = new i(this, this.f2143a.g(), i10 != 0);
        }

        private void d() {
            a4.a.e(this.f2143a);
            this.f2143a.i();
        }

        public i a(int i10) {
            boolean z10;
            start();
            this.f2144b = new Handler(getLooper(), this);
            this.f2143a = new a4.j(this.f2144b);
            synchronized (this) {
                z10 = false;
                this.f2144b.obtainMessage(1, i10, 0).sendToTarget();
                while (this.f2147e == null && this.f2146d == null && this.f2145c == null) {
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
            RuntimeException runtimeException = this.f2146d;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f2145c;
            if (error == null) {
                return (i) a4.a.e(this.f2147e);
            }
            throw error;
        }

        public void c() {
            a4.a.e(this.f2144b);
            this.f2144b.sendEmptyMessage(2);
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
                        d();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (o.a e10) {
                    a4.t.d("PlaceholderSurface", "Failed to initialize placeholder surface", e10);
                    this.f2146d = new IllegalStateException(e10);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e11) {
                    a4.t.d("PlaceholderSurface", "Failed to initialize placeholder surface", e11);
                    this.f2145c = e11;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e12) {
                    a4.t.d("PlaceholderSurface", "Failed to initialize placeholder surface", e12);
                    this.f2146d = e12;
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
    }

    private static int a(Context context) {
        if (a4.o.h(context)) {
            return a4.o.i() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean b(Context context) {
        if (!f2139e) {
            f2138d = a(context);
            f2139e = true;
        }
        return f2138d != 0;
    }

    public static i c(Context context, boolean z10) {
        a4.a.g(!z10 || b(context));
        return new b().a(z10 ? f2138d : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f2141b) {
            if (!this.f2142c) {
                this.f2141b.c();
                this.f2142c = true;
            }
        }
    }

    private i(b bVar, SurfaceTexture surfaceTexture, boolean z10) {
        super(surfaceTexture);
        this.f2141b = bVar;
        this.f2140a = z10;
    }
}
