package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import h9.l;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DraggableKt$draggable$$inlined$debugInspectorInfo$1 extends v implements l<InspectorInfo, k0> {
    final /* synthetic */ l $canDrag$inlined;
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ q $onDragStarted$inlined;
    final /* synthetic */ q $onDragStopped$inlined;
    final /* synthetic */ Orientation $orientation$inlined;
    final /* synthetic */ boolean $reverseDirection$inlined;
    final /* synthetic */ h9.a $startDragImmediately$inlined;
    final /* synthetic */ p $stateFactory$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableKt$draggable$$inlined$debugInspectorInfo$1(l lVar, Orientation orientation, boolean z10, boolean z11, MutableInteractionSource mutableInteractionSource, h9.a aVar, q qVar, q qVar2, p pVar) {
        super(1);
        this.$canDrag$inlined = lVar;
        this.$orientation$inlined = orientation;
        this.$enabled$inlined = z10;
        this.$reverseDirection$inlined = z11;
        this.$interactionSource$inlined = mutableInteractionSource;
        this.$startDragImmediately$inlined = aVar;
        this.$onDragStarted$inlined = qVar;
        this.$onDragStopped$inlined = qVar2;
        this.$stateFactory$inlined = pVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("draggable");
        inspectorInfo.getProperties().set("canDrag", this.$canDrag$inlined);
        inspectorInfo.getProperties().set("orientation", this.$orientation$inlined);
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
        inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(this.$reverseDirection$inlined));
        inspectorInfo.getProperties().set("interactionSource", this.$interactionSource$inlined);
        inspectorInfo.getProperties().set("startDragImmediately", this.$startDragImmediately$inlined);
        inspectorInfo.getProperties().set("onDragStarted", this.$onDragStarted$inlined);
        inspectorInfo.getProperties().set("onDragStopped", this.$onDragStopped$inlined);
        inspectorInfo.getProperties().set("stateFactory", this.$stateFactory$inlined);
    }
}
