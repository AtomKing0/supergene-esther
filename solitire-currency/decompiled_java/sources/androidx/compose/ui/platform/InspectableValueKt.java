package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InspectableValueKt {

    @NotNull
    private static final h9.l<InspectorInfo, v8.k0> NoInspectorInfo = InspectableValueKt$NoInspectorInfo$1.INSTANCE;
    private static boolean isDebugInspectorInfoEnabled;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.InspectableValueKt$debugInspectorInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: InspectableValue.kt */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.v implements h9.l<InspectorInfo, v8.k0> {
        final /* synthetic */ h9.l<InspectorInfo, v8.k0> $definitions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(h9.l<? super InspectorInfo, v8.k0> lVar) {
            super(1);
            this.$definitions = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(InspectorInfo inspectorInfo) {
            invoke2(inspectorInfo);
            return v8.k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
            kotlin.jvm.internal.t.i(inspectorInfo, "$this$null");
            this.$definitions.invoke(inspectorInfo);
        }
    }

    @NotNull
    public static final h9.l<InspectorInfo, v8.k0> debugInspectorInfo(@NotNull h9.l<? super InspectorInfo, v8.k0> definitions) {
        kotlin.jvm.internal.t.i(definitions, "definitions");
        return isDebugInspectorInfoEnabled() ? new AnonymousClass1(definitions) : getNoInspectorInfo();
    }

    @NotNull
    public static final h9.l<InspectorInfo, v8.k0> getNoInspectorInfo() {
        return NoInspectorInfo;
    }

    @NotNull
    public static final Modifier inspectable(@NotNull Modifier modifier, @NotNull h9.l<? super InspectorInfo, v8.k0> inspectorInfo, @NotNull h9.l<? super Modifier, ? extends Modifier> factory) {
        kotlin.jvm.internal.t.i(modifier, "<this>");
        kotlin.jvm.internal.t.i(inspectorInfo, "inspectorInfo");
        kotlin.jvm.internal.t.i(factory, "factory");
        return inspectableWrapper(modifier, inspectorInfo, factory.invoke(Modifier.Companion));
    }

    @NotNull
    public static final Modifier inspectableWrapper(@NotNull Modifier modifier, @NotNull h9.l<? super InspectorInfo, v8.k0> inspectorInfo, @NotNull Modifier wrapped) {
        kotlin.jvm.internal.t.i(modifier, "<this>");
        kotlin.jvm.internal.t.i(inspectorInfo, "inspectorInfo");
        kotlin.jvm.internal.t.i(wrapped, "wrapped");
        InspectableModifier inspectableModifier = new InspectableModifier(inspectorInfo);
        return modifier.then(inspectableModifier).then(wrapped).then(inspectableModifier.getEnd());
    }

    public static final boolean isDebugInspectorInfoEnabled() {
        return isDebugInspectorInfoEnabled;
    }

    public static final void setDebugInspectorInfoEnabled(boolean z10) {
        isDebugInspectorInfoEnabled = z10;
    }
}
