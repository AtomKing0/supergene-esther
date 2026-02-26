package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BoxWithConstraints.kt */
/* JADX INFO: loaded from: classes.dex */
final class BoxWithConstraintsKt$BoxWithConstraints$1$1 extends v implements p<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ q<BoxWithConstraintsScope, Composer, Integer, k0> $content;
    final /* synthetic */ MeasurePolicy $measurePolicy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BoxWithConstraintsKt$BoxWithConstraints$1$1(MeasurePolicy measurePolicy, q<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, k0> qVar, int i10) {
        super(2);
        this.$measurePolicy = measurePolicy;
        this.$content = qVar;
        this.$$dirty = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ MeasureResult mo4invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        return m370invoke0kLqBqw(subcomposeMeasureScope, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m370invoke0kLqBqw(@NotNull SubcomposeMeasureScope SubcomposeLayout, long j10) {
        t.i(SubcomposeLayout, "$this$SubcomposeLayout");
        return this.$measurePolicy.mo8measure3p2s80s(SubcomposeLayout, SubcomposeLayout.subcompose(k0.f35197a, ComposableLambdaKt.composableLambdaInstance(-1945019079, true, new BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1(this.$content, new BoxWithConstraintsScopeImpl(SubcomposeLayout, j10, null), this.$$dirty))), j10);
    }
}
