package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Oklab.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Oklab extends ColorSpace {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final float[] InverseM1;

    @NotNull
    private static final float[] InverseM2;

    @NotNull
    private static final float[] M1;

    @NotNull
    private static final float[] M2;

    /* JADX INFO: compiled from: Oklab.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    static {
        float[] transform$ui_graphics_release = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
        Illuminant illuminant = Illuminant.INSTANCE;
        float[] fArrMul3x3 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release, illuminant.getD50().toXyz$ui_graphics_release(), illuminant.getD65().toXyz$ui_graphics_release()));
        M1 = fArrMul3x3;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        M2 = fArr;
        InverseM1 = ColorSpaceKt.inverse3x3(fArrMul3x3);
        InverseM2 = ColorSpaceKt.inverse3x3(fArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oklab(@NotNull String name, int i10) {
        super(name, ColorModel.Companion.m1945getLabxdoWZVw(), i10, null);
        t.i(name, "name");
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] fromXyz(@NotNull float[] v10) {
        t.i(v10, "v");
        ColorSpaceKt.mul3x3Float3(M1, v10);
        double d10 = 0.33333334f;
        v10[0] = Math.signum(v10[0]) * ((float) Math.pow(Math.abs(v10[0]), d10));
        v10[1] = Math.signum(v10[1]) * ((float) Math.pow(Math.abs(v10[1]), d10));
        v10[2] = Math.signum(v10[2]) * ((float) Math.pow(Math.abs(v10[2]), d10));
        ColorSpaceKt.mul3x3Float3(M2, v10);
        return v10;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i10) {
        return i10 == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i10) {
        return i10 == 0 ? 0.0f : -0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return true;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] toXyz(@NotNull float[] v10) {
        t.i(v10, "v");
        v10[0] = o.m(v10[0], 0.0f, 1.0f);
        v10[1] = o.m(v10[1], -0.5f, 0.5f);
        v10[2] = o.m(v10[2], -0.5f, 0.5f);
        ColorSpaceKt.mul3x3Float3(InverseM2, v10);
        float f10 = v10[0];
        v10[0] = f10 * f10 * f10;
        float f11 = v10[1];
        v10[1] = f11 * f11 * f11;
        float f12 = v10[2];
        v10[2] = f12 * f12 * f12;
        ColorSpaceKt.mul3x3Float3(InverseM1, v10);
        return v10;
    }
}
