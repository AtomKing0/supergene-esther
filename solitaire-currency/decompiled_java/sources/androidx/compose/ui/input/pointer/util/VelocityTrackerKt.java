package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VelocityTracker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static final int MinSampleSize = 3;

    public static final void addPointerInputChange(@NotNull VelocityTracker velocityTracker, @NotNull PointerInputChange event) {
        t.i(velocityTracker, "<this>");
        t.i(event, "event");
        List<HistoricalChange> historical = event.getHistorical();
        int size = historical.size();
        for (int i10 = 0; i10 < size; i10++) {
            HistoricalChange historicalChange = historical.get(i10);
            velocityTracker.m2962addPositionUv8p0NA(historicalChange.getUptimeMillis(), historicalChange.m2805getPositionF1C5BW0());
        }
        velocityTracker.m2962addPositionUv8p0NA(event.getUptimeMillis(), event.m2873getPositionF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float kineticEnergyToVelocity(float f10) {
        return Math.signum(f10) * ((float) Math.sqrt(2 * Math.abs(f10)));
    }

    @NotNull
    public static final PolynomialFit polyFitLeastSquares(@NotNull List<Float> x10, @NotNull List<Float> y10, int i10) {
        float f10;
        t.i(x10, "x");
        t.i(y10, "y");
        if (i10 < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        }
        if (x10.size() != y10.size()) {
            throw new IllegalArgumentException("x and y must be the same length");
        }
        if (x10.isEmpty()) {
            throw new IllegalArgumentException("At least one point must be provided");
        }
        int size = i10 >= x10.size() ? x10.size() - 1 : i10;
        int i11 = i10 + 1;
        ArrayList arrayList = new ArrayList(i11);
        int i12 = 0;
        while (true) {
            f10 = 0.0f;
            if (i12 >= i11) {
                break;
            }
            arrayList.add(Float.valueOf(0.0f));
            i12++;
        }
        int size2 = x10.size();
        int i13 = size + 1;
        Matrix matrix = new Matrix(i13, size2);
        int i14 = 0;
        while (true) {
            if (i14 >= size2) {
                break;
            }
            matrix.set(0, i14, 1.0f);
            for (int i15 = 1; i15 < i13; i15++) {
                matrix.set(i15, i14, matrix.get(i15 - 1, i14) * x10.get(i14).floatValue());
            }
            i14++;
        }
        Matrix matrix2 = new Matrix(i13, size2);
        Matrix matrix3 = new Matrix(i13, i13);
        int i16 = 0;
        while (i16 < i13) {
            for (int i17 = 0; i17 < size2; i17++) {
                matrix2.set(i16, i17, matrix.get(i16, i17));
            }
            for (int i18 = 0; i18 < i16; i18++) {
                float fTimes = matrix2.getRow(i16).times(matrix2.getRow(i18));
                for (int i19 = 0; i19 < size2; i19++) {
                    matrix2.set(i16, i19, matrix2.get(i16, i19) - (matrix2.get(i18, i19) * fTimes));
                }
            }
            float fNorm = matrix2.getRow(i16).norm();
            if (fNorm < 1.0E-6d) {
                throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
            }
            float f11 = 1.0f / fNorm;
            for (int i20 = 0; i20 < size2; i20++) {
                matrix2.set(i16, i20, matrix2.get(i16, i20) * f11);
            }
            int i21 = 0;
            while (i21 < i13) {
                matrix3.set(i16, i21, i21 < i16 ? 0.0f : matrix2.getRow(i16).times(matrix.getRow(i21)));
                i21++;
            }
            i16++;
        }
        Vector vector = new Vector(size2);
        for (int i22 = 0; i22 < size2; i22++) {
            vector.set(i22, y10.get(i22).floatValue() * 1.0f);
        }
        int i23 = i13 - 1;
        for (int i24 = i23; -1 < i24; i24--) {
            arrayList.set(i24, Float.valueOf(matrix2.getRow(i24).times(vector)));
            int i25 = i24 + 1;
            if (i25 <= i23) {
                int i26 = i23;
                while (true) {
                    arrayList.set(i24, Float.valueOf(((Number) arrayList.get(i24)).floatValue() - (matrix3.get(i24, i26) * ((Number) arrayList.get(i26)).floatValue())));
                    if (i26 != i25) {
                        i26--;
                    }
                }
            }
            arrayList.set(i24, Float.valueOf(((Number) arrayList.get(i24)).floatValue() / matrix3.get(i24, i24)));
        }
        float fFloatValue = 0.0f;
        for (int i27 = 0; i27 < size2; i27++) {
            fFloatValue += y10.get(i27).floatValue();
        }
        float f12 = fFloatValue / size2;
        float f13 = 0.0f;
        for (int i28 = 0; i28 < size2; i28++) {
            float fFloatValue2 = y10.get(i28).floatValue() - ((Number) arrayList.get(0)).floatValue();
            float fFloatValue3 = 1.0f;
            for (int i29 = 1; i29 < i13; i29++) {
                fFloatValue3 *= x10.get(i28).floatValue();
                fFloatValue2 -= ((Number) arrayList.get(i29)).floatValue() * fFloatValue3;
            }
            f13 += fFloatValue2 * 1.0f * fFloatValue2;
            float fFloatValue4 = y10.get(i28).floatValue() - f12;
            f10 += fFloatValue4 * 1.0f * fFloatValue4;
        }
        return new PolynomialFit(arrayList, f10 > 1.0E-6f ? 1.0f - (f13 / f10) : 1.0f);
    }
}
