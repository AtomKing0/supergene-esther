package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KeyInputModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyInputModifierKt {

    @NotNull
    private static final ProvidableModifierLocal<KeyInputModifier> ModifierLocalKeyInput = ModifierLocalKt.modifierLocalOf(KeyInputModifierKt$ModifierLocalKeyInput$1.INSTANCE);

    @NotNull
    public static final ProvidableModifierLocal<KeyInputModifier> getModifierLocalKeyInput() {
        return ModifierLocalKeyInput;
    }

    @NotNull
    public static final Modifier onKeyEvent(@NotNull Modifier modifier, @NotNull l<? super KeyEvent, Boolean> onKeyEvent) {
        t.i(modifier, "<this>");
        t.i(onKeyEvent, "onKeyEvent");
        l keyInputModifierKt$onKeyEvent$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new KeyInputModifierKt$onKeyEvent$$inlined$debugInspectorInfo$1(onKeyEvent) : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper(modifier, keyInputModifierKt$onKeyEvent$$inlined$debugInspectorInfo$1, new KeyInputModifier(onKeyEvent, null));
    }

    @NotNull
    public static final Modifier onPreviewKeyEvent(@NotNull Modifier modifier, @NotNull l<? super KeyEvent, Boolean> onPreviewKeyEvent) {
        t.i(modifier, "<this>");
        t.i(onPreviewKeyEvent, "onPreviewKeyEvent");
        l keyInputModifierKt$onPreviewKeyEvent$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new KeyInputModifierKt$onPreviewKeyEvent$$inlined$debugInspectorInfo$1(onPreviewKeyEvent) : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper(modifier, keyInputModifierKt$onPreviewKeyEvent$$inlined$debugInspectorInfo$1, new KeyInputModifier(null, onPreviewKeyEvent));
    }
}
