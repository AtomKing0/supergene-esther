package c4;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.annotation.BinderThread;

/* JADX INFO: compiled from: OrientationListener.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f4516a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f4517b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f4518c = new float[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f4519d = new float[3];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Display f4520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a[] f4521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4522g;

    /* JADX INFO: compiled from: OrientationListener.java */
    public interface a {
        void onOrientationChange(float[] fArr, float f10);
    }

    public d(Display display, a... aVarArr) {
        this.f4520e = display;
        this.f4521f = aVarArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f4517b);
        SensorManager.getOrientation(this.f4517b, this.f4519d);
        return this.f4519d[2];
    }

    private void b(float[] fArr, float f10) {
        for (a aVar : this.f4521f) {
            aVar.onOrientationChange(fArr, f10);
        }
    }

    private void c(float[] fArr) {
        if (!this.f4522g) {
            c.a(this.f4518c, fArr);
            this.f4522g = true;
        }
        float[] fArr2 = this.f4517b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f4517b, 0, this.f4518c, 0);
    }

    private void d(float[] fArr, int i10) {
        if (i10 != 0) {
            int i11 = 129;
            int i12 = 1;
            if (i10 == 1) {
                i12 = 129;
                i11 = 2;
            } else if (i10 == 2) {
                i12 = 130;
            } else {
                if (i10 != 3) {
                    throw new IllegalStateException();
                }
                i11 = 130;
            }
            float[] fArr2 = this.f4517b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f4517b, i11, i12, fArr);
        }
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    @Override // android.hardware.SensorEventListener
    @BinderThread
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f4516a, sensorEvent.values);
        d(this.f4516a, this.f4520e.getRotation());
        float fA = a(this.f4516a);
        e(this.f4516a);
        c(this.f4516a);
        b(this.f4516a, fA);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }
}
