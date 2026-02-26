package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ Indication $indication$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ h9.a $onClick$inlined;
    final /* synthetic */ String $onClickLabel$inlined;
    final /* synthetic */ h9.a $onDoubleClick$inlined;
    final /* synthetic */ h9.a $onLongClick$inlined;
    final /* synthetic */ String $onLongClickLabel$inlined;
    final /* synthetic */ Role $role$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1(boolean z10, String str, Role role, h9.a aVar, h9.a aVar2, h9.a aVar3, String str2, Indication indication, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.$enabled$inlined = z10;
        this.$onClickLabel$inlined = str;
        this.$role$inlined = role;
        this.$onClick$inlined = aVar;
        this.$onDoubleClick$inlined = aVar2;
        this.$onLongClick$inlined = aVar3;
        this.$onLongClickLabel$inlined = str2;
        this.$indication$inlined = indication;
        this.$interactionSource$inlined = mutableInteractionSource;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("combinedClickable");
        inspectorInfo.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
        inspectorInfo.getProperties().set("onClickLabel", this.$onClickLabel$inlined);
        inspectorInfo.getProperties().set("role", this.$role$inlined);
        inspectorInfo.getProperties().set("onClick", this.$onClick$inlined);
        inspectorInfo.getProperties().set("onDoubleClick", this.$onDoubleClick$inlined);
        inspectorInfo.getProperties().set("onLongClick", this.$onLongClick$inlined);
        inspectorInfo.getProperties().set("onLongClickLabel", this.$onLongClickLabel$inlined);
        inspectorInfo.getProperties().set("indication", this.$indication$inlined);
        inspectorInfo.getProperties().set("interactionSource", this.$interactionSource$inlined);
    }
}
