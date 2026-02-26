package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ColumnScopeInstance$alignBy$$inlined$debugInspectorInfo$2 extends v implements h9.l<InspectorInfo, k0> {
    final /* synthetic */ h9.l $alignmentLineBlock$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColumnScopeInstance$alignBy$$inlined$debugInspectorInfo$2(h9.l lVar) {
        super(1);
        this.$alignmentLineBlock$inlined = lVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("alignBy");
        inspectorInfo.setValue(this.$alignmentLineBlock$inlined);
    }
}
