package androidx.compose.ui.layout;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OnPlacedModifierKt$onPlaced$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ h9.l $onPlaced$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnPlacedModifierKt$onPlaced$$inlined$debugInspectorInfo$1(h9.l lVar) {
        super(1);
        this.$onPlaced$inlined = lVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("onPlaced");
        inspectorInfo.getProperties().set("onPlaced", this.$onPlaced$inlined);
    }
}
