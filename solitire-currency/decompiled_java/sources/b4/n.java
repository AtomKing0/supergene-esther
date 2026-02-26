package b4;

import a4.o0;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import com.ironsource.v8;

/* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b4.e f2166a = new b4.e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final b f2167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final e f2168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Surface f2170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f2172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f2173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f2174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f2176k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f2177l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f2178m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f2179n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f2180o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f2181p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f2182q;

    /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
    @RequiresApi(30)
    private static final class a {
        @DoNotInline
        public static void a(Surface surface, float f10) {
            try {
                surface.setFrameRate(f10, f10 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e10) {
                a4.t.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
    interface b {

        /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
        public interface a {
            void onDefaultDisplayChanged(@Nullable Display display);
        }

        void a(a aVar);

        void unregister();
    }

    /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
    private static final class e implements Choreographer.FrameCallback, Handler.Callback {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final e f2186f = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f2187a = C.TIME_UNSET;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f2188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HandlerThread f2189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Choreographer f2190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2191e;

        private e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f2189c = handlerThread;
            handlerThread.start();
            Handler handlerT = o0.t(handlerThread.getLooper(), this);
            this.f2188b = handlerT;
            handlerT.sendEmptyMessage(0);
        }

        private void b() {
            Choreographer choreographer = this.f2190d;
            if (choreographer != null) {
                int i10 = this.f2191e + 1;
                this.f2191e = i10;
                if (i10 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        private void c() {
            try {
                this.f2190d = Choreographer.getInstance();
            } catch (RuntimeException e10) {
                a4.t.j("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e10);
            }
        }

        public static e d() {
            return f2186f;
        }

        private void f() {
            Choreographer choreographer = this.f2190d;
            if (choreographer != null) {
                int i10 = this.f2191e - 1;
                this.f2191e = i10;
                if (i10 == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f2187a = C.TIME_UNSET;
                }
            }
        }

        public void a() {
            this.f2188b.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j10) {
            this.f2187a = j10;
            ((Choreographer) a4.a.e(this.f2190d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f2188b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c();
                return true;
            }
            if (i10 == 1) {
                b();
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public n(@Nullable Context context) {
        b bVarF = f(context);
        this.f2167b = bVarF;
        this.f2168c = bVarF != null ? e.d() : null;
        this.f2176k = C.TIME_UNSET;
        this.f2177l = C.TIME_UNSET;
        this.f2171f = -1.0f;
        this.f2174i = 1.0f;
        this.f2175j = 0;
    }

    private static boolean c(long j10, long j11) {
        return Math.abs(j10 - j11) <= 20000000;
    }

    private void d() {
        Surface surface;
        if (o0.f214a < 30 || (surface = this.f2170e) == null || this.f2175j == Integer.MIN_VALUE || this.f2173h == 0.0f) {
            return;
        }
        this.f2173h = 0.0f;
        a.a(surface, 0.0f);
    }

    private static long e(long j10, long j11, long j12) {
        long j13;
        long j14 = j11 + (((j10 - j11) / j12) * j12);
        if (j10 <= j14) {
            j13 = j14 - j12;
        } else {
            j14 = j12 + j14;
            j13 = j14;
        }
        return j14 - j10 < j10 - j13 ? j14 : j13;
    }

    @Nullable
    private static b f(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        b bVarC = o0.f214a >= 17 ? d.c(applicationContext) : null;
        return bVarC == null ? c.b(applicationContext) : bVarC;
    }

    private void n() {
        this.f2178m = 0L;
        this.f2181p = -1L;
        this.f2179n = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(@Nullable Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.f2176k = refreshRate;
            this.f2177l = (refreshRate * 80) / 100;
        } else {
            a4.t.i("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.f2176k = C.TIME_UNSET;
            this.f2177l = C.TIME_UNSET;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q() {
        /*
            r7 = this;
            int r0 = a4.o0.f214a
            r1 = 30
            if (r0 < r1) goto L73
            android.view.Surface r0 = r7.f2170e
            if (r0 != 0) goto Lc
            goto L73
        Lc:
            b4.e r0 = r7.f2166a
            boolean r0 = r0.e()
            if (r0 == 0) goto L1b
            b4.e r0 = r7.f2166a
            float r0 = r0.b()
            goto L1d
        L1b:
            float r0 = r7.f2171f
        L1d:
            float r2 = r7.f2172g
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L24
            return
        L24:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L61
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L61
            b4.e r1 = r7.f2166a
            boolean r1 = r1.e()
            if (r1 == 0) goto L49
            b4.e r1 = r7.f2166a
            long r1 = r1.d()
            r3 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L49
            r1 = r6
            goto L4a
        L49:
            r1 = r5
        L4a:
            if (r1 == 0) goto L50
            r1 = 1017370378(0x3ca3d70a, float:0.02)
            goto L52
        L50:
            r1 = 1065353216(0x3f800000, float:1.0)
        L52:
            float r2 = r7.f2172g
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L5f
            goto L6c
        L5f:
            r6 = r5
            goto L6c
        L61:
            if (r4 == 0) goto L64
            goto L6c
        L64:
            b4.e r2 = r7.f2166a
            int r2 = r2.c()
            if (r2 < r1) goto L5f
        L6c:
            if (r6 == 0) goto L73
            r7.f2172g = r0
            r7.r(r5)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.n.q():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void r(boolean r4) {
        /*
            r3 = this;
            int r0 = a4.o0.f214a
            r1 = 30
            if (r0 < r1) goto L30
            android.view.Surface r0 = r3.f2170e
            if (r0 == 0) goto L30
            int r1 = r3.f2175j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L11
            goto L30
        L11:
            boolean r1 = r3.f2169d
            if (r1 == 0) goto L21
            float r1 = r3.f2172g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L21
            float r2 = r3.f2174i
            float r1 = r1 * r2
            goto L22
        L21:
            r1 = 0
        L22:
            if (r4 != 0) goto L2b
            float r4 = r3.f2173h
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L2b
            return
        L2b:
            r3.f2173h = r1
            b4.n.a.a(r0, r1)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.n.r(boolean):void");
    }

    public long b(long j10) {
        long j11;
        if (this.f2181p == -1 || !this.f2166a.e()) {
            j11 = j10;
        } else {
            long jA = this.f2182q + ((long) ((this.f2166a.a() * (this.f2178m - this.f2181p)) / this.f2174i));
            if (c(j10, jA)) {
                j11 = jA;
            } else {
                n();
                j11 = j10;
            }
        }
        this.f2179n = this.f2178m;
        this.f2180o = j11;
        e eVar = this.f2168c;
        if (eVar == null || this.f2176k == C.TIME_UNSET) {
            return j11;
        }
        long j12 = eVar.f2187a;
        return j12 == C.TIME_UNSET ? j11 : e(j11, j12, this.f2176k) - this.f2177l;
    }

    public void g(float f10) {
        this.f2171f = f10;
        this.f2166a.g();
        q();
    }

    public void h(long j10) {
        long j11 = this.f2179n;
        if (j11 != -1) {
            this.f2181p = j11;
            this.f2182q = this.f2180o;
        }
        this.f2178m++;
        this.f2166a.f(j10 * 1000);
        q();
    }

    public void i(float f10) {
        this.f2174i = f10;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f2169d = true;
        n();
        if (this.f2167b != null) {
            ((e) a4.a.e(this.f2168c)).a();
            this.f2167b.a(new b.a() { // from class: b4.m
                @Override // b4.n.b.a
                public final void onDefaultDisplayChanged(Display display) {
                    this.f2165a.p(display);
                }
            });
        }
        r(false);
    }

    public void l() {
        this.f2169d = false;
        b bVar = this.f2167b;
        if (bVar != null) {
            bVar.unregister();
            ((e) a4.a.e(this.f2168c)).e();
        }
        d();
    }

    public void m(@Nullable Surface surface) {
        if (surface instanceof i) {
            surface = null;
        }
        if (this.f2170e == surface) {
            return;
        }
        d();
        this.f2170e = surface;
        r(true);
    }

    public void o(int i10) {
        if (this.f2175j == i10) {
            return;
        }
        this.f2175j = i10;
        r(true);
    }

    /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
    private static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WindowManager f2183a;

        private c(WindowManager windowManager) {
            this.f2183a = windowManager;
        }

        @Nullable
        public static b b(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        @Override // b4.n.b
        public void a(b.a aVar) {
            aVar.onDefaultDisplayChanged(this.f2183a.getDefaultDisplay());
        }

        @Override // b4.n.b
        public void unregister() {
        }
    }

    /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
    @RequiresApi(17)
    private static final class d implements b, DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayManager f2184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private b.a f2185b;

        private d(DisplayManager displayManager) {
            this.f2184a = displayManager;
        }

        private Display b() {
            return this.f2184a.getDisplay(0);
        }

        @Nullable
        public static b c(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(v8.h.f15785d);
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        @Override // b4.n.b
        public void a(b.a aVar) {
            this.f2185b = aVar;
            this.f2184a.registerDisplayListener(this, o0.u());
            aVar.onDefaultDisplayChanged(b());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i10) {
            b.a aVar = this.f2185b;
            if (aVar == null || i10 != 0) {
                return;
            }
            aVar.onDefaultDisplayChanged(b());
        }

        @Override // b4.n.b
        public void unregister() {
            this.f2184a.unregisterDisplayListener(this);
            this.f2185b = null;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i10) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i10) {
        }
    }
}
