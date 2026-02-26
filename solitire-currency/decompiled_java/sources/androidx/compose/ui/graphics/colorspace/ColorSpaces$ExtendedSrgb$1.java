package androidx.compose.ui.graphics.colorspace;

import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ColorSpaces.kt */
/* JADX INFO: loaded from: classes.dex */
final class ColorSpaces$ExtendedSrgb$1 extends v implements l<Double, Double> {
    public static final ColorSpaces$ExtendedSrgb$1 INSTANCE = new ColorSpaces$ExtendedSrgb$1();

    ColorSpaces$ExtendedSrgb$1() {
        super(1);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Double invoke(Double d10) {
        return invoke(d10.doubleValue());
    }

    @NotNull
    public final Double invoke(double d10) {
        return Double.valueOf(ColorSpaceKt.absRcpResponse(d10, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d));
    }
}
