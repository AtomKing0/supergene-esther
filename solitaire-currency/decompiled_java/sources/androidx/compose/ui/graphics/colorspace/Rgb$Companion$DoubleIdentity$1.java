package androidx.compose.ui.graphics.colorspace;

import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Rgb.kt */
/* JADX INFO: loaded from: classes.dex */
final class Rgb$Companion$DoubleIdentity$1 extends v implements l<Double, Double> {
    public static final Rgb$Companion$DoubleIdentity$1 INSTANCE = new Rgb$Companion$DoubleIdentity$1();

    Rgb$Companion$DoubleIdentity$1() {
        super(1);
    }

    @NotNull
    public final Double invoke(double d10) {
        return Double.valueOf(d10);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Double invoke(Double d10) {
        return invoke(d10.doubleValue());
    }
}
