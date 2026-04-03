package androidx.compose.ui.graphics;

import androidx.compose.ui.platform.InspectorInfo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayerModifierKt$graphicsLayer$$inlined$debugInspectorInfo$1 extends kotlin.jvm.internal.v implements h9.l<InspectorInfo, v8.k0> {
    final /* synthetic */ h9.l $block$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphicsLayerModifierKt$graphicsLayer$$inlined$debugInspectorInfo$1(h9.l lVar) {
        super(1);
        this.$block$inlined = lVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        kotlin.jvm.internal.t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("graphicsLayer");
        inspectorInfo.getProperties().set("block", this.$block$inlined);
    }
}
