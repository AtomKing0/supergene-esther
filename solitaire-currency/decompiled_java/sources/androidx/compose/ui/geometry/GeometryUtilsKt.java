package androidx.compose.ui.geometry;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GeometryUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GeometryUtilsKt {
    @NotNull
    public static final String toStringAsFixed(float f10, int i10) {
        int iMax = Math.max(i10, 0);
        float fPow = (float) Math.pow(10.0f, iMax);
        float f11 = f10 * fPow;
        int i11 = (int) f11;
        if (f11 - i11 >= 0.5f) {
            i11++;
        }
        float f12 = i11 / fPow;
        return iMax > 0 ? String.valueOf(f12) : String.valueOf((int) f12);
    }
}
