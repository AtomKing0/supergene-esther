package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusOrderModifierToProperties;
import androidx.compose.ui.platform.InspectorInfo;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: renamed from: androidx.compose.ui.node.LayoutNode$setModifierLocals$1$invoke$lambda-1$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNode$setModifierLocals$1$invoke$lambda1$$inlined$debugInspectorInfo$1 extends v implements l<InspectorInfo, k0> {
    final /* synthetic */ FocusOrderModifierToProperties $scope$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutNode$setModifierLocals$1$invoke$lambda1$$inlined$debugInspectorInfo$1(FocusOrderModifierToProperties focusOrderModifierToProperties) {
        super(1);
        this.$scope$inlined = focusOrderModifierToProperties;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("focusProperties");
        inspectorInfo.getProperties().set("scope", this.$scope$inlined);
    }
}
