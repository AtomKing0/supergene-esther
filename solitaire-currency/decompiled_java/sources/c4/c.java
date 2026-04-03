package c4;

import a4.k0;
import a4.o;
import android.opengl.Matrix;

/* JADX INFO: compiled from: FrameRotationQueue.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f4512a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f4513b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k0<float[]> f4514c = new k0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4515d;

    public static void a(float[] fArr, float[] fArr2) {
        o.j(fArr);
        float f10 = fArr2[10];
        float f11 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11));
        float f12 = fArr2[10];
        fArr[0] = f12 / fSqrt;
        float f13 = fArr2[8];
        fArr[2] = f13 / fSqrt;
        fArr[8] = (-f13) / fSqrt;
        fArr[10] = f12 / fSqrt;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f10 = fArr2[0];
        float f11 = -fArr2[1];
        float f12 = -fArr2[2];
        float length = Matrix.length(f10, f11, f12);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f10 / length, f11 / length, f12 / length);
        } else {
            o.j(fArr);
        }
    }

    public boolean c(float[] fArr, long j10) {
        float[] fArrJ = this.f4514c.j(j10);
        if (fArrJ == null) {
            return false;
        }
        b(this.f4513b, fArrJ);
        if (!this.f4515d) {
            a(this.f4512a, this.f4513b);
            this.f4515d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f4512a, 0, this.f4513b, 0);
        return true;
    }

    public void d() {
        this.f4514c.c();
        this.f4515d = false;
    }

    public void e(long j10, float[] fArr) {
        this.f4514c.a(j10, fArr);
    }
}
