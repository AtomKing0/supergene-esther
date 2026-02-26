package androidx.compose.ui.graphics.colorspace;

import h9.l;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Rgb.kt */
/* JADX INFO: loaded from: classes.dex */
final class Rgb$oetf$1 extends v implements l<Double, Double> {
    final /* synthetic */ Rgb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Rgb$oetf$1(Rgb rgb) {
        super(1);
        this.this$0 = rgb;
    }

    @NotNull
    public final Double invoke(double d10) {
        return Double.valueOf(o.l(this.this$0.getOetfOrig$ui_graphics_release().invoke(Double.valueOf(d10)).doubleValue(), this.this$0.min, this.this$0.max));
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Double invoke(Double d10) {
        return invoke(d10.doubleValue());
    }
}
