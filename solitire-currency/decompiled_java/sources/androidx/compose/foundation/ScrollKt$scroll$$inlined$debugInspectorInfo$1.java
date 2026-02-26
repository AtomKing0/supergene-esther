package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollKt$scroll$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ FlingBehavior $flingBehavior$inlined;
    final /* synthetic */ boolean $isScrollable$inlined;
    final /* synthetic */ boolean $isVertical$inlined;
    final /* synthetic */ boolean $reverseScrolling$inlined;
    final /* synthetic */ ScrollState $state$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollKt$scroll$$inlined$debugInspectorInfo$1(ScrollState scrollState, boolean z10, FlingBehavior flingBehavior, boolean z11, boolean z12) {
        super(1);
        this.$state$inlined = scrollState;
        this.$reverseScrolling$inlined = z10;
        this.$flingBehavior$inlined = flingBehavior;
        this.$isScrollable$inlined = z11;
        this.$isVertical$inlined = z12;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("scroll");
        inspectorInfo.getProperties().set("state", this.$state$inlined);
        inspectorInfo.getProperties().set("reverseScrolling", Boolean.valueOf(this.$reverseScrolling$inlined));
        inspectorInfo.getProperties().set("flingBehavior", this.$flingBehavior$inlined);
        inspectorInfo.getProperties().set("isScrollable", Boolean.valueOf(this.$isScrollable$inlined));
        inspectorInfo.getProperties().set("isVertical", Boolean.valueOf(this.$isVertical$inlined));
    }
}
