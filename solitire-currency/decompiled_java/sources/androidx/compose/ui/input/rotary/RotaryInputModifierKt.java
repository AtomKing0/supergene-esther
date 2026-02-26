package androidx.compose.ui.input.rotary;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.focus.FocusAwareEvent;
import androidx.compose.ui.input.focus.FocusAwareInputModifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RotaryInputModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RotaryInputModifierKt {

    @NotNull
    private static final ProvidableModifierLocal<FocusAwareInputModifier<RotaryScrollEvent>> ModifierLocalRotaryScrollParent = ModifierLocalKt.modifierLocalOf(RotaryInputModifierKt$ModifierLocalRotaryScrollParent$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.ui.input.rotary.RotaryInputModifierKt$focusAwareCallback$1, reason: invalid class name */
    /* JADX INFO: compiled from: RotaryInputModifier.kt */
    static final class AnonymousClass1 extends v implements l<FocusAwareEvent, Boolean> {
        final /* synthetic */ l<RotaryScrollEvent, Boolean> $this_focusAwareCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(l<? super RotaryScrollEvent, Boolean> lVar) {
            super(1);
            this.$this_focusAwareCallback = lVar;
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull FocusAwareEvent e10) {
            t.i(e10, "e");
            if (e10 instanceof RotaryScrollEvent) {
                return this.$this_focusAwareCallback.invoke(e10);
            }
            throw new IllegalStateException("FocusAwareEvent is dispatched to the wrong FocusAwareParent.".toString());
        }
    }

    @ExperimentalComposeUiApi
    private static final l<FocusAwareEvent, Boolean> focusAwareCallback(l<? super RotaryScrollEvent, Boolean> lVar) {
        return new AnonymousClass1(lVar);
    }

    @NotNull
    public static final ProvidableModifierLocal<FocusAwareInputModifier<RotaryScrollEvent>> getModifierLocalRotaryScrollParent() {
        return ModifierLocalRotaryScrollParent;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier onPreRotaryScrollEvent(@NotNull Modifier modifier, @NotNull l<? super RotaryScrollEvent, Boolean> onPreRotaryScrollEvent) {
        t.i(modifier, "<this>");
        t.i(onPreRotaryScrollEvent, "onPreRotaryScrollEvent");
        l rotaryInputModifierKt$onPreRotaryScrollEvent$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new RotaryInputModifierKt$onPreRotaryScrollEvent$$inlined$debugInspectorInfo$1(onPreRotaryScrollEvent) : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper(modifier, rotaryInputModifierKt$onPreRotaryScrollEvent$$inlined$debugInspectorInfo$1, new FocusAwareInputModifier(null, focusAwareCallback(onPreRotaryScrollEvent), ModifierLocalRotaryScrollParent));
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Modifier onRotaryScrollEvent(@NotNull Modifier modifier, @NotNull l<? super RotaryScrollEvent, Boolean> onRotaryScrollEvent) {
        t.i(modifier, "<this>");
        t.i(onRotaryScrollEvent, "onRotaryScrollEvent");
        l rotaryInputModifierKt$onRotaryScrollEvent$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new RotaryInputModifierKt$onRotaryScrollEvent$$inlined$debugInspectorInfo$1(onRotaryScrollEvent) : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper(modifier, rotaryInputModifierKt$onRotaryScrollEvent$$inlined$debugInspectorInfo$1, new FocusAwareInputModifier(focusAwareCallback(onRotaryScrollEvent), null, ModifierLocalRotaryScrollParent));
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getModifierLocalRotaryScrollParent$annotations() {
    }
}
