package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import h9.l;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: OuterMeasurablePlaceable.kt */
/* JADX INFO: loaded from: classes.dex */
final class OuterMeasurablePlaceable$placeAt$1 extends v implements h9.a<k0> {
    final /* synthetic */ l<GraphicsLayerScope, k0> $layerBlock;
    final /* synthetic */ long $position;
    final /* synthetic */ float $zIndex;
    final /* synthetic */ OuterMeasurablePlaceable this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    OuterMeasurablePlaceable$placeAt$1(OuterMeasurablePlaceable outerMeasurablePlaceable, long j10, float f10, l<? super GraphicsLayerScope, k0> lVar) {
        super(0);
        this.this$0 = outerMeasurablePlaceable;
        this.$position = j10;
        this.$zIndex = f10;
        this.$layerBlock = lVar;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.m3139placeOuterWrapperf8xVGno(this.$position, this.$zIndex, this.$layerBlock);
    }
}
