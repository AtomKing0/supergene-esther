package androidx.compose.ui.platform;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
final class InspectableValueKt$NoInspectorInfo$1 extends kotlin.jvm.internal.v implements h9.l<InspectorInfo, v8.k0> {
    public static final InspectableValueKt$NoInspectorInfo$1 INSTANCE = new InspectableValueKt$NoInspectorInfo$1();

    InspectableValueKt$NoInspectorInfo$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        kotlin.jvm.internal.t.i(inspectorInfo, "$this$null");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return v8.k0.f35197a;
    }
}
