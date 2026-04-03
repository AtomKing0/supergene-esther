package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ColorKt {
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059  */
    @androidx.compose.runtime.Stable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long Color(float r9, float r10, float r11, float r12, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.ColorSpace r13) {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static /* synthetic */ long Color$default(float f10, float f11, float f12, float f13, ColorSpace colorSpace, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            f13 = 1.0f;
        }
        if ((i10 & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f10, f11, f12, f13, colorSpace);
    }

    private static final float compositeComponent(float f10, float f11, float f12, float f13, float f14) {
        if (f14 == 0.0f) {
            return 0.0f;
        }
        return ((f10 * f12) + ((f11 * f13) * (1.0f - f12))) / f14;
    }

    @Stable
    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m1644compositeOverOWjLjI(long j10, long j11) {
        long jM1595convertvNxB06k = Color.m1595convertvNxB06k(j10, Color.m1602getColorSpaceimpl(j11));
        float fM1600getAlphaimpl = Color.m1600getAlphaimpl(j11);
        float fM1600getAlphaimpl2 = Color.m1600getAlphaimpl(jM1595convertvNxB06k);
        float f10 = 1.0f - fM1600getAlphaimpl2;
        float f11 = (fM1600getAlphaimpl * f10) + fM1600getAlphaimpl2;
        return Color((f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((Color.m1604getRedimpl(jM1595convertvNxB06k) * fM1600getAlphaimpl2) + ((Color.m1604getRedimpl(j11) * fM1600getAlphaimpl) * f10)) / f11, (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((Color.m1603getGreenimpl(jM1595convertvNxB06k) * fM1600getAlphaimpl2) + ((Color.m1603getGreenimpl(j11) * fM1600getAlphaimpl) * f10)) / f11, f11 == 0.0f ? 0.0f : ((Color.m1601getBlueimpl(jM1595convertvNxB06k) * fM1600getAlphaimpl2) + ((Color.m1601getBlueimpl(j11) * fM1600getAlphaimpl) * f10)) / f11, f11, Color.m1602getColorSpaceimpl(j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getComponents-8_81llA, reason: not valid java name */
    public static final float[] m1645getComponents8_81llA(long j10) {
        return new float[]{Color.m1604getRedimpl(j10), Color.m1603getGreenimpl(j10), Color.m1601getBlueimpl(j10), Color.m1600getAlphaimpl(j10)};
    }

    /* JADX INFO: renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m1646isSpecified8_81llA(long j10) {
        return j10 != Color.Companion.m1634getUnspecified0d7_KjU();
    }

    /* JADX INFO: renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m1648isUnspecified8_81llA(long j10) {
        return j10 == Color.Companion.m1634getUnspecified0d7_KjU();
    }

    @Stable
    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m1650lerpjxsXWHM(long j10, long j11, float f10) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long jM1595convertvNxB06k = Color.m1595convertvNxB06k(j10, oklab);
        long jM1595convertvNxB06k2 = Color.m1595convertvNxB06k(j11, oklab);
        float fM1600getAlphaimpl = Color.m1600getAlphaimpl(jM1595convertvNxB06k);
        float fM1604getRedimpl = Color.m1604getRedimpl(jM1595convertvNxB06k);
        float fM1603getGreenimpl = Color.m1603getGreenimpl(jM1595convertvNxB06k);
        float fM1601getBlueimpl = Color.m1601getBlueimpl(jM1595convertvNxB06k);
        float fM1600getAlphaimpl2 = Color.m1600getAlphaimpl(jM1595convertvNxB06k2);
        float fM1604getRedimpl2 = Color.m1604getRedimpl(jM1595convertvNxB06k2);
        float fM1603getGreenimpl2 = Color.m1603getGreenimpl(jM1595convertvNxB06k2);
        float fM1601getBlueimpl2 = Color.m1601getBlueimpl(jM1595convertvNxB06k2);
        return Color.m1595convertvNxB06k(Color(MathHelpersKt.lerp(fM1604getRedimpl, fM1604getRedimpl2, f10), MathHelpersKt.lerp(fM1603getGreenimpl, fM1603getGreenimpl2, f10), MathHelpersKt.lerp(fM1601getBlueimpl, fM1601getBlueimpl2, f10), MathHelpersKt.lerp(fM1600getAlphaimpl, fM1600getAlphaimpl2, f10), oklab), Color.m1602getColorSpaceimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m1651luminance8_81llA(long j10) {
        ColorSpace colorSpaceM1602getColorSpaceimpl = Color.m1602getColorSpaceimpl(j10);
        if (ColorModel.m1939equalsimpl0(colorSpaceM1602getColorSpaceimpl.m1948getModelxdoWZVw(), ColorModel.Companion.m1946getRgbxdoWZVw())) {
            h9.l<Double, Double> eotf = ((Rgb) colorSpaceM1602getColorSpaceimpl).getEotf();
            return saturate((float) ((eotf.invoke(Double.valueOf(Color.m1604getRedimpl(j10))).doubleValue() * 0.2126d) + (eotf.invoke(Double.valueOf(Color.m1603getGreenimpl(j10))).doubleValue() * 0.7152d) + (eotf.invoke(Double.valueOf(Color.m1601getBlueimpl(j10))).doubleValue() * 0.0722d)));
        }
        throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m1942toStringimpl(colorSpaceM1602getColorSpaceimpl.m1948getModelxdoWZVw()))).toString());
    }

    private static final float saturate(float f10) {
        float f11 = 0.0f;
        if (f10 > 0.0f) {
            f11 = 1.0f;
            if (f10 < 1.0f) {
                return f10;
            }
        }
        return f11;
    }

    /* JADX INFO: renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m1652takeOrElseDxMtmZc(long j10, @NotNull h9.a<Color> block) {
        kotlin.jvm.internal.t.i(block, "block");
        return (j10 > Color.Companion.m1634getUnspecified0d7_KjU() ? 1 : (j10 == Color.Companion.m1634getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? j10 : block.invoke().m1608unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m1653toArgb8_81llA(long j10) {
        ColorSpace colorSpaceM1602getColorSpaceimpl = Color.m1602getColorSpaceimpl(j10);
        if (colorSpaceM1602getColorSpaceimpl.isSrgb()) {
            return (int) v8.e0.c(j10 >>> 32);
        }
        float[] fArrM1645getComponents8_81llA = m1645getComponents8_81llA(j10);
        ColorSpaceKt.m1950connectYBCOT_4$default(colorSpaceM1602getColorSpaceimpl, null, 0, 3, null).transform(fArrM1645getComponents8_81llA);
        return ((int) ((fArrM1645getComponents8_81llA[2] * 255.0f) + 0.5f)) | (((int) ((fArrM1645getComponents8_81llA[3] * 255.0f) + 0.5f)) << 24) | (((int) ((fArrM1645getComponents8_81llA[0] * 255.0f) + 0.5f)) << 16) | (((int) ((fArrM1645getComponents8_81llA[1] * 255.0f) + 0.5f)) << 8);
    }

    public static /* synthetic */ long Color$default(int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 8) != 0) {
            i13 = 255;
        }
        return Color(i10, i11, i12, i13);
    }

    @Stable
    public static final long Color(int i10) {
        return Color.m1594constructorimpl(v8.e0.c(v8.e0.c(i10) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1647isSpecified8_81llA$annotations(long j10) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1649isUnspecified8_81llA$annotations(long j10) {
    }

    @Stable
    public static final long Color(long j10) {
        return Color.m1594constructorimpl(v8.e0.c(v8.e0.c(v8.e0.c(j10) & 4294967295L) << 32));
    }

    @Stable
    public static final long Color(int i10, int i11, int i12, int i13) {
        return Color(((i10 & 255) << 16) | ((i13 & 255) << 24) | ((i11 & 255) << 8) | (i12 & 255));
    }
}
