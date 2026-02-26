package androidx.compose.ui.graphics.colorspace;

import h9.l;
import java.util.Arrays;
import kotlin.collections.o;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Rgb.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Rgb extends ColorSpace {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final l<Double, Double> DoubleIdentity = Rgb$Companion$DoubleIdentity$1.INSTANCE;

    @NotNull
    private final l<Double, Double> eotf;

    @NotNull
    private final l<Double, Double> eotfOrig;

    @NotNull
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    private final float max;
    private final float min;

    @NotNull
    private final l<Double, Double> oetf;

    @NotNull
    private final l<Double, Double> oetfOrig;

    @NotNull
    private final float[] primaries;

    @Nullable
    private final TransferParameters transferParameters;

    @NotNull
    private final float[] transform;

    @NotNull
    private final WhitePoint whitePoint;

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.colorspace.Rgb$1, reason: invalid class name */
    /* JADX INFO: compiled from: Rgb.kt */
    static final class AnonymousClass1 extends v implements l<Double, Double> {
        final /* synthetic */ TransferParameters $function;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TransferParameters transferParameters) {
            super(1);
            this.$function = transferParameters;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Double invoke(Double d10) {
            return invoke(d10.doubleValue());
        }

        @NotNull
        public final Double invoke(double d10) {
            return Double.valueOf(ColorSpaceKt.rcpResponse(d10, this.$function.getA(), this.$function.getB(), this.$function.getC(), this.$function.getD(), this.$function.getGamma()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.colorspace.Rgb$2, reason: invalid class name */
    /* JADX INFO: compiled from: Rgb.kt */
    static final class AnonymousClass2 extends v implements l<Double, Double> {
        final /* synthetic */ TransferParameters $function;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TransferParameters transferParameters) {
            super(1);
            this.$function = transferParameters;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Double invoke(Double d10) {
            return invoke(d10.doubleValue());
        }

        @NotNull
        public final Double invoke(double d10) {
            return Double.valueOf(ColorSpaceKt.rcpResponse(d10, this.$function.getA(), this.$function.getB(), this.$function.getC(), this.$function.getD(), this.$function.getE(), this.$function.getF(), this.$function.getGamma()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.colorspace.Rgb$3, reason: invalid class name */
    /* JADX INFO: compiled from: Rgb.kt */
    static final class AnonymousClass3 extends v implements l<Double, Double> {
        final /* synthetic */ TransferParameters $function;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(TransferParameters transferParameters) {
            super(1);
            this.$function = transferParameters;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Double invoke(Double d10) {
            return invoke(d10.doubleValue());
        }

        @NotNull
        public final Double invoke(double d10) {
            return Double.valueOf(ColorSpaceKt.response(d10, this.$function.getA(), this.$function.getB(), this.$function.getC(), this.$function.getD(), this.$function.getGamma()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.colorspace.Rgb$4, reason: invalid class name */
    /* JADX INFO: compiled from: Rgb.kt */
    static final class AnonymousClass4 extends v implements l<Double, Double> {
        final /* synthetic */ TransferParameters $function;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(TransferParameters transferParameters) {
            super(1);
            this.$function = transferParameters;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Double invoke(Double d10) {
            return invoke(d10.doubleValue());
        }

        @NotNull
        public final Double invoke(double d10) {
            return Double.valueOf(ColorSpaceKt.response(d10, this.$function.getA(), this.$function.getB(), this.$function.getC(), this.$function.getD(), this.$function.getE(), this.$function.getF(), this.$function.getGamma()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.colorspace.Rgb$5, reason: invalid class name */
    /* JADX INFO: compiled from: Rgb.kt */
    static final class AnonymousClass5 extends v implements l<Double, Double> {
        final /* synthetic */ double $gamma;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(double d10) {
            super(1);
            this.$gamma = d10;
        }

        @NotNull
        public final Double invoke(double d10) {
            if (d10 < 0.0d) {
                d10 = 0.0d;
            }
            return Double.valueOf(Math.pow(d10, 1.0d / this.$gamma));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Double invoke(Double d10) {
            return invoke(d10.doubleValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.colorspace.Rgb$6, reason: invalid class name */
    /* JADX INFO: compiled from: Rgb.kt */
    static final class AnonymousClass6 extends v implements l<Double, Double> {
        final /* synthetic */ double $gamma;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(double d10) {
            super(1);
            this.$gamma = d10;
        }

        @NotNull
        public final Double invoke(double d10) {
            if (d10 < 0.0d) {
                d10 = 0.0d;
            }
            return Double.valueOf(Math.pow(d10, this.$gamma));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Double invoke(Double d10) {
            return invoke(d10.doubleValue());
        }
    }

    /* JADX INFO: compiled from: Rgb.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        private final float area(float[] fArr) {
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            float f13 = fArr[3];
            float f14 = fArr[4];
            float f15 = fArr[5];
            float f16 = ((((((f10 * f13) + (f11 * f14)) + (f12 * f15)) - (f13 * f14)) - (f11 * f12)) - (f10 * f15)) * 0.5f;
            return f16 < 0.0f ? -f16 : f16;
        }

        private final boolean compare(double d10, l<? super Double, Double> lVar, l<? super Double, Double> lVar2) {
            return Math.abs(lVar.invoke(Double.valueOf(d10)).doubleValue() - lVar2.invoke(Double.valueOf(d10)).doubleValue()) <= 0.001d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final WhitePoint computeWhitePoint(float[] fArr) {
            float[] fArrMul3x3Float3 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{1.0f, 1.0f, 1.0f});
            float f10 = fArrMul3x3Float3[0];
            float f11 = fArrMul3x3Float3[1];
            float f12 = f10 + f11 + fArrMul3x3Float3[2];
            return new WhitePoint(f10 / f12, f11 / f12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] computeXYZMatrix(float[] fArr, WhitePoint whitePoint) {
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            float f13 = fArr[3];
            float f14 = fArr[4];
            float f15 = fArr[5];
            float x10 = whitePoint.getX();
            float y10 = whitePoint.getY();
            float f16 = 1;
            float f17 = (f16 - f10) / f11;
            float f18 = (f16 - f12) / f13;
            float f19 = (f16 - f14) / f15;
            float f20 = (f16 - x10) / y10;
            float f21 = f10 / f11;
            float f22 = (f12 / f13) - f21;
            float f23 = (x10 / y10) - f21;
            float f24 = f18 - f17;
            float f25 = (f14 / f15) - f21;
            float f26 = (((f20 - f17) * f22) - (f23 * f24)) / (((f19 - f17) * f22) - (f24 * f25));
            float f27 = (f23 - (f25 * f26)) / f22;
            float f28 = (1.0f - f27) - f26;
            float f29 = f28 / f11;
            float f30 = f27 / f13;
            float f31 = f26 / f15;
            return new float[]{f29 * f10, f28, f29 * ((1.0f - f10) - f11), f30 * f12, f27, f30 * ((1.0f - f12) - f13), f31 * f14, f26, f31 * ((1.0f - f14) - f15)};
        }

        private final boolean contains(float[] fArr, float[] fArr2) {
            float f10 = fArr[0] - fArr2[0];
            float f11 = fArr[1] - fArr2[1];
            float[] fArr3 = {f10, f11, fArr[2] - fArr2[2], fArr[3] - fArr2[3], fArr[4] - fArr2[4], fArr[5] - fArr2[5]};
            return cross(f10, f11, fArr2[0] - fArr2[4], fArr2[1] - fArr2[5]) >= 0.0f && cross(fArr2[0] - fArr2[2], fArr2[1] - fArr2[3], fArr3[0], fArr3[1]) >= 0.0f && cross(fArr3[2], fArr3[3], fArr2[2] - fArr2[0], fArr2[3] - fArr2[1]) >= 0.0f && cross(fArr2[2] - fArr2[4], fArr2[3] - fArr2[5], fArr3[2], fArr3[3]) >= 0.0f && cross(fArr3[4], fArr3[5], fArr2[4] - fArr2[2], fArr2[5] - fArr2[3]) >= 0.0f && cross(fArr2[4] - fArr2[0], fArr2[5] - fArr2[1], fArr3[4], fArr3[5]) >= 0.0f;
        }

        private final float cross(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSrgb(float[] fArr, WhitePoint whitePoint, l<? super Double, Double> lVar, l<? super Double, Double> lVar2, float f10, float f11, int i10) {
            if (i10 == 0) {
                return true;
            }
            ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
            if (!ColorSpaceKt.compare(fArr, colorSpaces.getSrgbPrimaries$ui_graphics_release()) || !ColorSpaceKt.compare(whitePoint, Illuminant.INSTANCE.getD65())) {
                return false;
            }
            if (!(f10 == 0.0f)) {
                return false;
            }
            if (!(f11 == 1.0f)) {
                return false;
            }
            Rgb srgb = colorSpaces.getSrgb();
            for (double d10 = 0.0d; d10 <= 1.0d; d10 += 0.00392156862745098d) {
                if (!compare(d10, lVar, srgb.getOetfOrig$ui_graphics_release()) || !compare(d10, lVar2, srgb.getEotfOrig$ui_graphics_release())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isWideGamut(float[] fArr, float f10, float f11) {
            float fArea = area(fArr);
            ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
            return (fArea / area(colorSpaces.getNtsc1953Primaries$ui_graphics_release()) > 0.9f && contains(fArr, colorSpaces.getSrgbPrimaries$ui_graphics_release())) || (f10 < 0.0f && f11 > 1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] xyPrimaries(float[] fArr) {
            float[] fArr2 = new float[6];
            if (fArr.length == 9) {
                float f10 = fArr[0];
                float f11 = fArr[1];
                float f12 = f10 + f11 + fArr[2];
                fArr2[0] = f10 / f12;
                fArr2[1] = f11 / f12;
                float f13 = fArr[3];
                float f14 = fArr[4];
                float f15 = f13 + f14 + fArr[5];
                fArr2[2] = f13 / f15;
                fArr2[3] = f14 / f15;
                float f16 = fArr[6];
                float f17 = fArr[7];
                float f18 = f16 + f17 + fArr[8];
                fArr2[4] = f16 / f18;
                fArr2[5] = f17 / f18;
            } else {
                o.k(fArr, fArr2, 0, 0, 6, 6, null);
            }
            return fArr2;
        }

        @NotNull
        public final float[] computePrimaries$ui_graphics_release(@NotNull float[] toXYZ) {
            t.i(toXYZ, "toXYZ");
            float[] fArrMul3x3Float3 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{1.0f, 0.0f, 0.0f});
            float[] fArrMul3x3Float32 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{0.0f, 1.0f, 0.0f});
            float[] fArrMul3x3Float33 = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{0.0f, 0.0f, 1.0f});
            float f10 = fArrMul3x3Float3[0];
            float f11 = fArrMul3x3Float3[1];
            float f12 = f10 + f11 + fArrMul3x3Float3[2];
            float f13 = fArrMul3x3Float32[0] + fArrMul3x3Float32[1] + fArrMul3x3Float32[2];
            float f14 = fArrMul3x3Float33[0] + fArrMul3x3Float33[1] + fArrMul3x3Float33[2];
            return new float[]{f10 / f12, f11 / f12, fArrMul3x3Float32[0] / f13, fArrMul3x3Float32[1] / f13, fArrMul3x3Float33[0] / f14, fArrMul3x3Float33[1] / f14};
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Rgb(@NotNull String name, @NotNull float[] primaries, @NotNull WhitePoint whitePoint, @Nullable float[] fArr, @NotNull l<? super Double, Double> oetf, @NotNull l<? super Double, Double> eotf, float f10, float f11, @Nullable TransferParameters transferParameters, int i10) {
        super(name, ColorModel.Companion.m1946getRgbxdoWZVw(), i10, null);
        t.i(name, "name");
        t.i(primaries, "primaries");
        t.i(whitePoint, "whitePoint");
        t.i(oetf, "oetf");
        t.i(eotf, "eotf");
        this.whitePoint = whitePoint;
        this.min = f10;
        this.max = f11;
        this.transferParameters = transferParameters;
        this.oetfOrig = oetf;
        this.oetf = new Rgb$oetf$1(this);
        this.eotfOrig = eotf;
        this.eotf = new Rgb$eotf$1(this);
        if (primaries.length != 6 && primaries.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f10 >= f11) {
            throw new IllegalArgumentException("Invalid range: min=" + f10 + ", max=" + f11 + "; min must be strictly < max");
        }
        Companion companion = Companion;
        float[] fArrXyPrimaries = companion.xyPrimaries(primaries);
        this.primaries = fArrXyPrimaries;
        if (fArr == null) {
            this.transform = companion.computeXYZMatrix(fArrXyPrimaries, whitePoint);
        } else {
            if (fArr.length != 9) {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr.length);
            }
            this.transform = fArr;
        }
        this.inverseTransform = ColorSpaceKt.inverse3x3(this.transform);
        this.isWideGamut = companion.isWideGamut(fArrXyPrimaries, f10, f11);
        this.isSrgb = companion.isSrgb(fArrXyPrimaries, whitePoint, oetf, eotf, f10, f11, i10);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(o0.b(Rgb.class), o0.b(obj.getClass())) || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !t.d(this.whitePoint, rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters = this.transferParameters;
        if (transferParameters != null) {
            return t.d(transferParameters, rgb.transferParameters);
        }
        if (rgb.transferParameters == null) {
            return true;
        }
        if (t.d(this.oetfOrig, rgb.oetfOrig)) {
            return t.d(this.eotfOrig, rgb.eotfOrig);
        }
        return false;
    }

    @NotNull
    public final float[] fromLinear(float f10, float f11, float f12) {
        return fromLinear(new float[]{f10, f11, f12});
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] fromXyz(@NotNull float[] v10) {
        t.i(v10, "v");
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, v10);
        v10[0] = (float) this.oetf.invoke(Double.valueOf(v10[0])).doubleValue();
        v10[1] = (float) this.oetf.invoke(Double.valueOf(v10[1])).doubleValue();
        v10[2] = (float) this.oetf.invoke(Double.valueOf(v10[2])).doubleValue();
        return v10;
    }

    @NotNull
    public final l<Double, Double> getEotf() {
        return this.eotf;
    }

    @NotNull
    public final l<Double, Double> getEotfOrig$ui_graphics_release() {
        return this.eotfOrig;
    }

    @NotNull
    public final float[] getInverseTransform() {
        float[] fArr = this.inverseTransform;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        t.h(fArrCopyOf, "copyOf(this, size)");
        return fArrCopyOf;
    }

    @NotNull
    public final float[] getInverseTransform$ui_graphics_release() {
        return this.inverseTransform;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i10) {
        return this.max;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i10) {
        return this.min;
    }

    @NotNull
    public final l<Double, Double> getOetf() {
        return this.oetf;
    }

    @NotNull
    public final l<Double, Double> getOetfOrig$ui_graphics_release() {
        return this.oetfOrig;
    }

    @NotNull
    public final float[] getPrimaries() {
        float[] fArr = this.primaries;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        t.h(fArrCopyOf, "copyOf(this, size)");
        return fArrCopyOf;
    }

    @NotNull
    public final float[] getPrimaries$ui_graphics_release() {
        return this.primaries;
    }

    @Nullable
    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    @NotNull
    public final float[] getTransform() {
        float[] fArr = this.transform;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        t.h(fArrCopyOf, "copyOf(this, size)");
        return fArrCopyOf;
    }

    @NotNull
    public final float[] getTransform$ui_graphics_release() {
        return this.transform;
    }

    @NotNull
    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public int hashCode() {
        int iHashCode = ((((super.hashCode() * 31) + this.whitePoint.hashCode()) * 31) + Arrays.hashCode(this.primaries)) * 31;
        float f10 = this.min;
        int iFloatToIntBits = (iHashCode + (!((f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1)) == 0) ? Float.floatToIntBits(f10) : 0)) * 31;
        float f11 = this.max;
        int iFloatToIntBits2 = (iFloatToIntBits + (!(f11 == 0.0f) ? Float.floatToIntBits(f11) : 0)) * 31;
        TransferParameters transferParameters = this.transferParameters;
        int iHashCode2 = iFloatToIntBits2 + (transferParameters != null ? transferParameters.hashCode() : 0);
        return this.transferParameters == null ? (((iHashCode2 * 31) + this.oetfOrig.hashCode()) * 31) + this.eotfOrig.hashCode() : iHashCode2;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isSrgb() {
        return this.isSrgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return this.isWideGamut;
    }

    @NotNull
    public final float[] toLinear(float f10, float f11, float f12) {
        return toLinear(new float[]{f10, f11, f12});
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] toXyz(@NotNull float[] v10) {
        t.i(v10, "v");
        v10[0] = (float) this.eotf.invoke(Double.valueOf(v10[0])).doubleValue();
        v10[1] = (float) this.eotf.invoke(Double.valueOf(v10[1])).doubleValue();
        v10[2] = (float) this.eotf.invoke(Double.valueOf(v10[2])).doubleValue();
        return ColorSpaceKt.mul3x3Float3(this.transform, v10);
    }

    @NotNull
    public final float[] fromLinear(@NotNull float[] v10) {
        t.i(v10, "v");
        v10[0] = (float) this.oetf.invoke(Double.valueOf(v10[0])).doubleValue();
        v10[1] = (float) this.oetf.invoke(Double.valueOf(v10[1])).doubleValue();
        v10[2] = (float) this.oetf.invoke(Double.valueOf(v10[2])).doubleValue();
        return v10;
    }

    @NotNull
    public final float[] getInverseTransform(@NotNull float[] inverseTransform) {
        t.i(inverseTransform, "inverseTransform");
        return o.k(this.inverseTransform, inverseTransform, 0, 0, 0, 14, null);
    }

    @NotNull
    public final float[] getPrimaries(@NotNull float[] primaries) {
        t.i(primaries, "primaries");
        return o.k(this.primaries, primaries, 0, 0, 0, 14, null);
    }

    @NotNull
    public final float[] getTransform(@NotNull float[] transform) {
        t.i(transform, "transform");
        return o.k(this.transform, transform, 0, 0, 0, 14, null);
    }

    @NotNull
    public final float[] toLinear(@NotNull float[] v10) {
        t.i(v10, "v");
        v10[0] = (float) this.eotf.invoke(Double.valueOf(v10[0])).doubleValue();
        v10[1] = (float) this.eotf.invoke(Double.valueOf(v10[1])).doubleValue();
        v10[2] = (float) this.eotf.invoke(Double.valueOf(v10[2])).doubleValue();
        return v10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(@NotNull String name, @NotNull float[] toXYZ, @NotNull l<? super Double, Double> oetf, @NotNull l<? super Double, Double> eotf) {
        t.i(name, "name");
        t.i(toXYZ, "toXYZ");
        t.i(oetf, "oetf");
        t.i(eotf, "eotf");
        Companion companion = Companion;
        this(name, companion.computePrimaries$ui_graphics_release(toXYZ), companion.computeWhitePoint(toXYZ), null, oetf, eotf, 0.0f, 1.0f, null, -1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull String name, @NotNull float[] primaries, @NotNull WhitePoint whitePoint, @NotNull l<? super Double, Double> oetf, @NotNull l<? super Double, Double> eotf, float f10, float f11) {
        this(name, primaries, whitePoint, null, oetf, eotf, f10, f11, null, -1);
        t.i(name, "name");
        t.i(primaries, "primaries");
        t.i(whitePoint, "whitePoint");
        t.i(oetf, "oetf");
        t.i(eotf, "eotf");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(@NotNull String name, @NotNull float[] toXYZ, @NotNull TransferParameters function) {
        t.i(name, "name");
        t.i(toXYZ, "toXYZ");
        t.i(function, "function");
        Companion companion = Companion;
        this(name, companion.computePrimaries$ui_graphics_release(toXYZ), companion.computeWhitePoint(toXYZ), function, -1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull String name, @NotNull float[] primaries, @NotNull WhitePoint whitePoint, @NotNull TransferParameters function) {
        this(name, primaries, whitePoint, function, -1);
        t.i(name, "name");
        t.i(primaries, "primaries");
        t.i(whitePoint, "whitePoint");
        t.i(function, "function");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Rgb(@org.jetbrains.annotations.NotNull java.lang.String r14, @org.jetbrains.annotations.NotNull float[] r15, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.WhitePoint r16, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.colorspace.TransferParameters r17, int r18) {
        /*
            r13 = this;
            r9 = r17
            java.lang.String r0 = "name"
            r1 = r14
            kotlin.jvm.internal.t.i(r14, r0)
            java.lang.String r0 = "primaries"
            r2 = r15
            kotlin.jvm.internal.t.i(r15, r0)
            java.lang.String r0 = "whitePoint"
            r3 = r16
            kotlin.jvm.internal.t.i(r3, r0)
            java.lang.String r0 = "function"
            kotlin.jvm.internal.t.i(r9, r0)
            r4 = 0
            double r5 = r17.getE()
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r0 != 0) goto L29
            r0 = r5
            goto L2a
        L29:
            r0 = r6
        L2a:
            if (r0 == 0) goto L3f
            double r10 = r17.getF()
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L36
            r0 = r5
            goto L37
        L36:
            r0 = r6
        L37:
            if (r0 == 0) goto L3f
            androidx.compose.ui.graphics.colorspace.Rgb$1 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$1
            r0.<init>(r9)
            goto L44
        L3f:
            androidx.compose.ui.graphics.colorspace.Rgb$2 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$2
            r0.<init>(r9)
        L44:
            r10 = r0
            double r11 = r17.getE()
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 != 0) goto L4f
            r0 = r5
            goto L50
        L4f:
            r0 = r6
        L50:
            if (r0 == 0) goto L64
            double r11 = r17.getF()
            int r0 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r0 != 0) goto L5b
            goto L5c
        L5b:
            r5 = r6
        L5c:
            if (r5 == 0) goto L64
            androidx.compose.ui.graphics.colorspace.Rgb$3 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$3
            r0.<init>(r9)
            goto L69
        L64:
            androidx.compose.ui.graphics.colorspace.Rgb$4 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$4
            r0.<init>(r9)
        L69:
            r6 = r0
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r10
            r9 = r17
            r10 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, androidx.compose.ui.graphics.colorspace.TransferParameters, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(@NotNull String name, @NotNull float[] toXYZ, double d10) {
        t.i(name, "name");
        t.i(toXYZ, "toXYZ");
        Companion companion = Companion;
        this(name, companion.computePrimaries$ui_graphics_release(toXYZ), companion.computeWhitePoint(toXYZ), d10, 0.0f, 1.0f, -1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull String name, @NotNull float[] primaries, @NotNull WhitePoint whitePoint, double d10) {
        this(name, primaries, whitePoint, d10, 0.0f, 1.0f, -1);
        t.i(name, "name");
        t.i(primaries, "primaries");
        t.i(whitePoint, "whitePoint");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Rgb(@NotNull String name, @NotNull float[] primaries, @NotNull WhitePoint whitePoint, double d10, float f10, float f11, int i10) {
        l anonymousClass5;
        l anonymousClass6;
        t.i(name, "name");
        t.i(primaries, "primaries");
        t.i(whitePoint, "whitePoint");
        if (d10 == 1.0d) {
            anonymousClass5 = DoubleIdentity;
        } else {
            anonymousClass5 = new AnonymousClass5(d10);
        }
        l lVar = anonymousClass5;
        if (d10 == 1.0d) {
            anonymousClass6 = DoubleIdentity;
        } else {
            anonymousClass6 = new AnonymousClass6(d10);
        }
        this(name, primaries, whitePoint, null, lVar, anonymousClass6, f10, f11, new TransferParameters(d10, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 96, null), i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rgb(@NotNull Rgb colorSpace, @NotNull float[] transform, @NotNull WhitePoint whitePoint) {
        this(colorSpace.getName(), colorSpace.primaries, whitePoint, transform, colorSpace.oetfOrig, colorSpace.eotfOrig, colorSpace.min, colorSpace.max, colorSpace.transferParameters, -1);
        t.i(colorSpace, "colorSpace");
        t.i(transform, "transform");
        t.i(whitePoint, "whitePoint");
    }
}
