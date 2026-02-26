package androidx.compose.animation.core;

import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SpringEstimation.kt */
/* JADX INFO: loaded from: classes.dex */
final class SpringEstimationKt$estimateOverDamped$fnPrime$1 extends v implements l<Double, Double> {
    final /* synthetic */ double $c1;
    final /* synthetic */ double $c2;
    final /* synthetic */ double $r1;
    final /* synthetic */ double $r2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SpringEstimationKt$estimateOverDamped$fnPrime$1(double d10, double d11, double d12, double d13) {
        super(1);
        this.$c1 = d10;
        this.$r1 = d11;
        this.$c2 = d12;
        this.$r2 = d13;
    }

    @NotNull
    public final Double invoke(double d10) {
        double d11 = this.$c1;
        double d12 = this.$r1;
        double dExp = d11 * d12 * Math.exp(d12 * d10);
        double d13 = this.$c2;
        double d14 = this.$r2;
        return Double.valueOf(dExp + (d13 * d14 * Math.exp(d14 * d10)));
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Double invoke(Double d10) {
        return invoke(d10.doubleValue());
    }
}
