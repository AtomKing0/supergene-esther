package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyLayout.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyLayoutKt$LazyLayout$2$1 extends v implements p<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ LazyLayoutItemContentFactory $itemContentFactory;
    final /* synthetic */ p<LazyLayoutMeasureScope, Constraints, MeasureResult> $measurePolicy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LazyLayoutKt$LazyLayout$2$1(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, p<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> pVar) {
        super(2);
        this.$itemContentFactory = lazyLayoutItemContentFactory;
        this.$measurePolicy = pVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ MeasureResult mo4invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        return m607invoke0kLqBqw(subcomposeMeasureScope, constraints.m3647unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m607invoke0kLqBqw(@NotNull SubcomposeMeasureScope subcomposeMeasureScope, long j10) {
        t.i(subcomposeMeasureScope, "$this$null");
        this.$itemContentFactory.m606onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j10);
        return this.$measurePolicy.mo4invoke(new LazyLayoutMeasureScopeImpl(this.$itemContentFactory, subcomposeMeasureScope), Constraints.m3629boximpl(j10));
    }
}
