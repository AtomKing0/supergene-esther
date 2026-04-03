package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.platform.InspectorInfo;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollModifierKt$nestedScroll$$inlined$debugInspectorInfo$1 extends v implements l<InspectorInfo, k0> {
    final /* synthetic */ NestedScrollConnection $connection$inlined;
    final /* synthetic */ NestedScrollDispatcher $dispatcher$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollModifierKt$nestedScroll$$inlined$debugInspectorInfo$1(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        super(1);
        this.$connection$inlined = nestedScrollConnection;
        this.$dispatcher$inlined = nestedScrollDispatcher;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("nestedScroll");
        inspectorInfo.getProperties().set("connection", this.$connection$inlined);
        inspectorInfo.getProperties().set("dispatcher", this.$dispatcher$inlined);
    }
}
