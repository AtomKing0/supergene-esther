package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Lab.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Lab extends ColorSpace {
    private static final float A = 0.008856452f;
    private static final float B = 7.787037f;
    private static final float C = 0.13793103f;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final float D = 0.20689656f;

    /* JADX INFO: compiled from: Lab.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Lab(@NotNull String name, int i10) {
        super(name, ColorModel.Companion.m1945getLabxdoWZVw(), i10, null);
        t.i(name, "name");
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] fromXyz(@NotNull float[] v10) {
        t.i(v10, "v");
        float f10 = v10[0];
        Illuminant illuminant = Illuminant.INSTANCE;
        float f11 = f10 / illuminant.getD50Xyz$ui_graphics_release()[0];
        float f12 = v10[1] / illuminant.getD50Xyz$ui_graphics_release()[1];
        float f13 = v10[2] / illuminant.getD50Xyz$ui_graphics_release()[2];
        float fPow = f11 > A ? (float) Math.pow(f11, 0.33333334f) : (f11 * B) + C;
        float fPow2 = f12 > A ? (float) Math.pow(f12, 0.33333334f) : (f12 * B) + C;
        float fPow3 = f13 > A ? (float) Math.pow(f13, 0.33333334f) : (f13 * B) + C;
        v10[0] = o.m((116.0f * fPow2) - 16.0f, 0.0f, 100.0f);
        v10[1] = o.m((fPow - fPow2) * 500.0f, -128.0f, 128.0f);
        v10[2] = o.m((fPow2 - fPow3) * 200.0f, -128.0f, 128.0f);
        return v10;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i10) {
        return i10 == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i10) {
        return i10 == 0 ? 0.0f : -128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return true;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] toXyz(@NotNull float[] v10) {
        t.i(v10, "v");
        v10[0] = o.m(v10[0], 0.0f, 100.0f);
        v10[1] = o.m(v10[1], -128.0f, 128.0f);
        float fM = o.m(v10[2], -128.0f, 128.0f);
        v10[2] = fM;
        float f10 = (v10[0] + 16.0f) / 116.0f;
        float f11 = (v10[1] * 0.002f) + f10;
        float f12 = f10 - (fM * 0.005f);
        float f13 = f11 > D ? f11 * f11 * f11 : (f11 - C) * 0.12841855f;
        float f14 = f10 > D ? f10 * f10 * f10 : (f10 - C) * 0.12841855f;
        float f15 = f12 > D ? f12 * f12 * f12 : (f12 - C) * 0.12841855f;
        Illuminant illuminant = Illuminant.INSTANCE;
        v10[0] = f13 * illuminant.getD50Xyz$ui_graphics_release()[0];
        v10[1] = f14 * illuminant.getD50Xyz$ui_graphics_release()[1];
        v10[2] = f15 * illuminant.getD50Xyz$ui_graphics_release()[2];
        return v10;
    }
}
