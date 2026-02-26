package androidx.compose.ui.graphics;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ColorMatrix.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ColorMatrix {

    @NotNull
    private final float[] values;

    private /* synthetic */ ColorMatrix(float[] fArr) {
        this.values = fArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m1654boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float[] m1655constructorimpl(@NotNull float[] values) {
        kotlin.jvm.internal.t.i(values, "values");
        return values;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ float[] m1656constructorimpl$default(float[] fArr, int i10, kotlin.jvm.internal.k kVar) {
        if ((i10 & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m1655constructorimpl(fArr);
    }

    /* JADX INFO: renamed from: convertRgbToYuv-impl, reason: not valid java name */
    public static final void m1657convertRgbToYuvimpl(float[] fArr) {
        m1664resetimpl(fArr);
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    /* JADX INFO: renamed from: convertYuvToRgb-impl, reason: not valid java name */
    public static final void m1658convertYuvToRgbimpl(float[] fArr) {
        m1664resetimpl(fArr);
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }

    /* JADX INFO: renamed from: dot-Me4OoYI, reason: not valid java name */
    private static final float m1659dotMe4OoYI(float[] fArr, float[] fArr2, int i10, float[] fArr3, int i11) {
        int i12 = i10 * 5;
        return (fArr2[i12 + 0] * fArr3[0 + i11]) + (fArr2[i12 + 1] * fArr3[5 + i11]) + (fArr2[i12 + 2] * fArr3[10 + i11]) + (fArr2[i12 + 3] * fArr3[15 + i11]);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1660equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && kotlin.jvm.internal.t.d(fArr, ((ColorMatrix) obj).m1675unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1661equalsimpl0(float[] fArr, float[] fArr2) {
        return kotlin.jvm.internal.t.d(fArr, fArr2);
    }

    /* JADX INFO: renamed from: get-impl, reason: not valid java name */
    public static final float m1662getimpl(float[] fArr, int i10, int i11) {
        return fArr[(i10 * 5) + i11];
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1663hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* JADX INFO: renamed from: reset-impl, reason: not valid java name */
    public static final void m1664resetimpl(float[] fArr) {
        kotlin.collections.o.t(fArr, 0.0f, 0, 0, 6, null);
        fArr[0] = 1.0f;
        fArr[12] = 1.0f;
        fArr[6] = 1.0f;
        fArr[18] = 1.0f;
    }

    /* JADX INFO: renamed from: rotateInternal-impl, reason: not valid java name */
    private static final void m1665rotateInternalimpl(float[] fArr, float f10, h9.p<? super Float, ? super Float, v8.k0> pVar) {
        m1664resetimpl(fArr);
        double d10 = (((double) f10) * 3.141592653589793d) / 180.0d;
        pVar.mo4invoke(Float.valueOf((float) Math.cos(d10)), Float.valueOf((float) Math.sin(d10)));
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m1666setimpl(float[] fArr, int i10, int i11, float f10) {
        fArr[(i10 * 5) + i11] = f10;
    }

    /* JADX INFO: renamed from: set-jHG-Opc, reason: not valid java name */
    public static final void m1667setjHGOpc(float[] fArr, @NotNull float[] src) {
        kotlin.jvm.internal.t.i(src, "src");
        kotlin.collections.o.k(src, fArr, 0, 0, 0, 14, null);
    }

    /* JADX INFO: renamed from: setToRotateBlue-impl, reason: not valid java name */
    public static final void m1668setToRotateBlueimpl(float[] fArr, float f10) {
        m1664resetimpl(fArr);
        double d10 = (((double) f10) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        fArr[6] = fCos;
        fArr[0] = fCos;
        fArr[1] = fSin;
        fArr[5] = -fSin;
    }

    /* JADX INFO: renamed from: setToRotateGreen-impl, reason: not valid java name */
    public static final void m1669setToRotateGreenimpl(float[] fArr, float f10) {
        m1664resetimpl(fArr);
        double d10 = (((double) f10) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        fArr[12] = fCos;
        fArr[0] = fCos;
        fArr[2] = -fSin;
        fArr[10] = fSin;
    }

    /* JADX INFO: renamed from: setToRotateRed-impl, reason: not valid java name */
    public static final void m1670setToRotateRedimpl(float[] fArr, float f10) {
        m1664resetimpl(fArr);
        double d10 = (((double) f10) * 3.141592653589793d) / 180.0d;
        float fCos = (float) Math.cos(d10);
        float fSin = (float) Math.sin(d10);
        fArr[12] = fCos;
        fArr[6] = fCos;
        fArr[7] = fSin;
        fArr[11] = -fSin;
    }

    /* JADX INFO: renamed from: setToSaturation-impl, reason: not valid java name */
    public static final void m1671setToSaturationimpl(float[] fArr, float f10) {
        m1664resetimpl(fArr);
        float f11 = 1 - f10;
        float f12 = 0.213f * f11;
        float f13 = 0.715f * f11;
        float f14 = f11 * 0.072f;
        fArr[0] = f12 + f10;
        fArr[1] = f13;
        fArr[2] = f14;
        fArr[5] = f12;
        fArr[6] = f13 + f10;
        fArr[7] = f14;
        fArr[10] = f12;
        fArr[11] = f13;
        fArr[12] = f14 + f10;
    }

    /* JADX INFO: renamed from: setToScale-impl, reason: not valid java name */
    public static final void m1672setToScaleimpl(float[] fArr, float f10, float f11, float f12, float f13) {
        m1664resetimpl(fArr);
        fArr[0] = f10;
        fArr[6] = f11;
        fArr[12] = f12;
        fArr[18] = f13;
    }

    /* JADX INFO: renamed from: timesAssign-jHG-Opc, reason: not valid java name */
    public static final void m1673timesAssignjHGOpc(float[] fArr, @NotNull float[] colorMatrix) {
        kotlin.jvm.internal.t.i(colorMatrix, "colorMatrix");
        float fM1659dotMe4OoYI = m1659dotMe4OoYI(fArr, fArr, 0, colorMatrix, 0);
        float fM1659dotMe4OoYI2 = m1659dotMe4OoYI(fArr, fArr, 0, colorMatrix, 1);
        float fM1659dotMe4OoYI3 = m1659dotMe4OoYI(fArr, fArr, 0, colorMatrix, 2);
        float fM1659dotMe4OoYI4 = m1659dotMe4OoYI(fArr, fArr, 0, colorMatrix, 3);
        float f10 = (fArr[0] * colorMatrix[4]) + (fArr[1] * colorMatrix[9]) + (fArr[2] * colorMatrix[14]) + (fArr[3] * colorMatrix[19]) + fArr[4];
        float fM1659dotMe4OoYI5 = m1659dotMe4OoYI(fArr, fArr, 1, colorMatrix, 0);
        float fM1659dotMe4OoYI6 = m1659dotMe4OoYI(fArr, fArr, 1, colorMatrix, 1);
        float fM1659dotMe4OoYI7 = m1659dotMe4OoYI(fArr, fArr, 1, colorMatrix, 2);
        float fM1659dotMe4OoYI8 = m1659dotMe4OoYI(fArr, fArr, 1, colorMatrix, 3);
        float f11 = (fArr[5] * colorMatrix[4]) + (fArr[6] * colorMatrix[9]) + (fArr[7] * colorMatrix[14]) + (fArr[8] * colorMatrix[19]) + fArr[9];
        float fM1659dotMe4OoYI9 = m1659dotMe4OoYI(fArr, fArr, 2, colorMatrix, 0);
        float fM1659dotMe4OoYI10 = m1659dotMe4OoYI(fArr, fArr, 2, colorMatrix, 1);
        float fM1659dotMe4OoYI11 = m1659dotMe4OoYI(fArr, fArr, 2, colorMatrix, 2);
        float fM1659dotMe4OoYI12 = m1659dotMe4OoYI(fArr, fArr, 2, colorMatrix, 3);
        float f12 = (fArr[10] * colorMatrix[4]) + (fArr[11] * colorMatrix[9]) + (fArr[12] * colorMatrix[14]) + (fArr[13] * colorMatrix[19]) + fArr[14];
        float fM1659dotMe4OoYI13 = m1659dotMe4OoYI(fArr, fArr, 3, colorMatrix, 0);
        float fM1659dotMe4OoYI14 = m1659dotMe4OoYI(fArr, fArr, 3, colorMatrix, 1);
        float fM1659dotMe4OoYI15 = m1659dotMe4OoYI(fArr, fArr, 3, colorMatrix, 2);
        float fM1659dotMe4OoYI16 = m1659dotMe4OoYI(fArr, fArr, 3, colorMatrix, 3);
        float f13 = (fArr[15] * colorMatrix[4]) + (fArr[16] * colorMatrix[9]) + (fArr[17] * colorMatrix[14]) + (fArr[18] * colorMatrix[19]) + fArr[19];
        fArr[0] = fM1659dotMe4OoYI;
        fArr[1] = fM1659dotMe4OoYI2;
        fArr[2] = fM1659dotMe4OoYI3;
        fArr[3] = fM1659dotMe4OoYI4;
        fArr[4] = f10;
        fArr[5] = fM1659dotMe4OoYI5;
        fArr[6] = fM1659dotMe4OoYI6;
        fArr[7] = fM1659dotMe4OoYI7;
        fArr[8] = fM1659dotMe4OoYI8;
        fArr[9] = f11;
        fArr[10] = fM1659dotMe4OoYI9;
        fArr[11] = fM1659dotMe4OoYI10;
        fArr[12] = fM1659dotMe4OoYI11;
        fArr[13] = fM1659dotMe4OoYI12;
        fArr[14] = f12;
        fArr[15] = fM1659dotMe4OoYI13;
        fArr[16] = fM1659dotMe4OoYI14;
        fArr[17] = fM1659dotMe4OoYI15;
        fArr[18] = fM1659dotMe4OoYI16;
        fArr[19] = f13;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1674toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    public boolean equals(Object obj) {
        return m1660equalsimpl(this.values, obj);
    }

    @NotNull
    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return m1663hashCodeimpl(this.values);
    }

    public String toString() {
        return m1674toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float[] m1675unboximpl() {
        return this.values;
    }
}
