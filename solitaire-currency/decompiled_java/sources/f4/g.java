package f4;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: MatrixEvaluator.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f25678a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f25679b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f25680c = new Matrix();

    @NonNull
    public Matrix a(float f10, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.f25678a);
        matrix2.getValues(this.f25679b);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.f25679b;
            float f11 = fArr[i10];
            float f12 = this.f25678a[i10];
            fArr[i10] = f12 + ((f11 - f12) * f10);
        }
        this.f25680c.setValues(this.f25679b);
        return this.f25680c;
    }
}
