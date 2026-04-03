package androidx.compose.animation.core;

import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpringEstimation.kt */
/* JADX INFO: loaded from: classes.dex */
final class SpringEstimationKt$estimateCriticallyDamped$fn$1 extends v implements l<Double, Double> {
    final /* synthetic */ double $c1;
    final /* synthetic */ double $c2;
    final /* synthetic */ double $r;
    final /* synthetic */ double $signedDelta;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SpringEstimationKt$estimateCriticallyDamped$fn$1(double d10, double d11, double d12, double d13) {
        super(1);
        this.$c1 = d10;
        this.$c2 = d11;
        this.$r = d12;
        this.$signedDelta = d13;
    }

    @NotNull
    public final Double invoke(double d10) {
        return Double.valueOf(((this.$c1 + (this.$c2 * d10)) * Math.exp(this.$r * d10)) + this.$signedDelta);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Double invoke(Double d10) {
        return invoke(d10.doubleValue());
    }
}
