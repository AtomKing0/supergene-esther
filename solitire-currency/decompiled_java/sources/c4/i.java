package c4;

import a4.k0;
import a4.o;
import a4.t;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.o1;

/* JADX INFO: compiled from: SceneRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
final class i implements b4.l, a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SurfaceTexture f4560j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private byte[] f4563m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f4551a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f4552b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f4553c = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f4554d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k0<Long> f4555e = new k0<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k0<e> f4556f = new k0<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float[] f4557g = new float[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f4558h = new float[16];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile int f4561k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f4562l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        this.f4551a.set(true);
    }

    private void g(@Nullable byte[] bArr, int i10, long j10) {
        byte[] bArr2 = this.f4563m;
        int i11 = this.f4562l;
        this.f4563m = bArr;
        if (i10 == -1) {
            i10 = this.f4561k;
        }
        this.f4562l = i10;
        if (i11 == i10 && Arrays.equals(bArr2, this.f4563m)) {
            return;
        }
        byte[] bArr3 = this.f4563m;
        e eVarA = bArr3 != null ? f.a(bArr3, this.f4562l) : null;
        if (eVarA == null || !g.c(eVarA)) {
            eVarA = e.b(this.f4562l);
        }
        this.f4556f.a(j10, eVarA);
    }

    @Override // b4.l
    public void a(long j10, long j11, o1 o1Var, @Nullable MediaFormat mediaFormat) {
        this.f4555e.a(j11, Long.valueOf(j10));
        g(o1Var.f29357v, o1Var.f29358w, j11);
    }

    public void c(float[] fArr, boolean z10) {
        GLES20.glClear(16384);
        try {
            o.b();
        } catch (o.a e10) {
            t.d("SceneRenderer", "Failed to draw a frame", e10);
        }
        if (this.f4551a.compareAndSet(true, false)) {
            ((SurfaceTexture) a4.a.e(this.f4560j)).updateTexImage();
            try {
                o.b();
            } catch (o.a e11) {
                t.d("SceneRenderer", "Failed to draw a frame", e11);
            }
            if (this.f4552b.compareAndSet(true, false)) {
                o.j(this.f4557g);
            }
            long timestamp = this.f4560j.getTimestamp();
            Long lG = this.f4555e.g(timestamp);
            if (lG != null) {
                this.f4554d.c(this.f4557g, lG.longValue());
            }
            e eVarJ = this.f4556f.j(timestamp);
            if (eVarJ != null) {
                this.f4553c.d(eVarJ);
            }
        }
        Matrix.multiplyMM(this.f4558h, 0, fArr, 0, this.f4557g, 0);
        this.f4553c.a(this.f4559i, this.f4558h, z10);
    }

    public SurfaceTexture d() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            o.b();
            this.f4553c.b();
            o.b();
            this.f4559i = o.f();
        } catch (o.a e10) {
            t.d("SceneRenderer", "Failed to initialize the renderer", e10);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f4559i);
        this.f4560j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: c4.h
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f4550a.e(surfaceTexture2);
            }
        });
        return this.f4560j;
    }

    public void f(int i10) {
        this.f4561k = i10;
    }

    @Override // c4.a
    public void onCameraMotion(long j10, float[] fArr) {
        this.f4554d.e(j10, fArr);
    }

    @Override // c4.a
    public void onCameraMotionReset() {
        this.f4555e.c();
        this.f4554d.d();
        this.f4552b.set(true);
    }
}
