package androidx.compose.animation.core;

import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpringEstimation.kt */
/* JADX INFO: loaded from: classes.dex */
final class SpringEstimationKt$estimateCriticallyDamped$fnPrime$1 extends v implements l<Double, Double> {
    final /* synthetic */ double $c1;
    final /* synthetic */ double $c2;
    final /* synthetic */ double $r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SpringEstimationKt$estimateCriticallyDamped$fnPrime$1(double d10, double d11, double d12) {
        super(1);
        this.$c2 = d10;
        this.$r = d11;
        this.$c1 = d12;
    }

    @NotNull
    public final Double invoke(double d10) {
        double d11 = this.$c2;
        double d12 = this.$r;
        return Double.valueOf(((d11 * ((d12 * d10) + ((double) 1))) + (this.$c1 * d12)) * Math.exp(d12 * d10));
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Double invoke(Double d10) {
        return invoke(d10.doubleValue());
    }
}
