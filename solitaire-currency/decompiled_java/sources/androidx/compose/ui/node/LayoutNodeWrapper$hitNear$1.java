package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNodeWrapper;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: LayoutNodeWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutNodeWrapper$hitNear$1 extends v implements h9.a<k0> {
    final /* synthetic */ float $distanceFromEdge;
    final /* synthetic */ HitTestResult<C> $hitTestResult;
    final /* synthetic */ LayoutNodeWrapper.HitTestSource<T, C, M> $hitTestSource;
    final /* synthetic */ boolean $isInLayer;
    final /* synthetic */ boolean $isTouchEvent;
    final /* synthetic */ long $pointerPosition;

    /* JADX INFO: Incorrect field signature: TT; */
    final /* synthetic */ LayoutNodeEntity $this_hitNear;
    final /* synthetic */ LayoutNodeWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/LayoutNodeWrapper;TT;Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource<TT;TC;TM;>;JLandroidx/compose/ui/node/HitTestResult<TC;>;ZZF)V */
    LayoutNodeWrapper$hitNear$1(LayoutNodeWrapper layoutNodeWrapper, LayoutNodeEntity layoutNodeEntity, LayoutNodeWrapper.HitTestSource hitTestSource, long j10, HitTestResult hitTestResult, boolean z10, boolean z11, float f10) {
        super(0);
        this.this$0 = layoutNodeWrapper;
        this.$this_hitNear = layoutNodeEntity;
        this.$hitTestSource = hitTestSource;
        this.$pointerPosition = j10;
        this.$hitTestResult = hitTestResult;
        this.$isTouchEvent = z10;
        this.$isInLayer = z11;
        this.$distanceFromEdge = f10;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.m3119hitNearJHbHoSQ(this.$this_hitNear.getNext(), this.$hitTestSource, this.$pointerPosition, this.$hitTestResult, this.$isTouchEvent, this.$isInLayer, this.$distanceFromEdge);
    }
}
