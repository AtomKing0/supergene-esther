package androidx.compose.ui.input.pointer;

import androidx.compose.ui.platform.InspectorInfo;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SuspendingPointerInputFilterKt$pointerInput$$inlined$debugInspectorInfo$3 extends v implements l<InspectorInfo, k0> {
    final /* synthetic */ p $block$inlined;
    final /* synthetic */ Object[] $keys$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuspendingPointerInputFilterKt$pointerInput$$inlined$debugInspectorInfo$3(Object[] objArr, p pVar) {
        super(1);
        this.$keys$inlined = objArr;
        this.$block$inlined = pVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("pointerInput");
        inspectorInfo.getProperties().set("keys", this.$keys$inlined);
        inspectorInfo.getProperties().set("block", this.$block$inlined);
    }
}
