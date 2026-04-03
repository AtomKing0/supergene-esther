package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import h9.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Selectable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectableKt {
    @NotNull
    /* JADX INFO: renamed from: selectable-O2vRcR0, reason: not valid java name */
    public static final Modifier m612selectableO2vRcR0(@NotNull Modifier selectable, boolean z10, @NotNull MutableInteractionSource interactionSource, @Nullable Indication indication, boolean z11, @Nullable Role role, @NotNull a<k0> onClick) {
        t.i(selectable, "$this$selectable");
        t.i(interactionSource, "interactionSource");
        t.i(onClick, "onClick");
        return InspectableValueKt.inspectableWrapper(selectable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SelectableKt$selectableO2vRcR0$$inlined$debugInspectorInfo$1(z10, interactionSource, indication, z11, role, onClick) : InspectableValueKt.getNoInspectorInfo(), SemanticsModifierKt.semantics$default(ClickableKt.m183clickableO2vRcR0$default(Modifier.Companion, interactionSource, indication, z11, null, role, onClick, 8, null), false, new SelectableKt$selectable$4$1(z10), 1, null));
    }

    /* JADX INFO: renamed from: selectable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m613selectableO2vRcR0$default(Modifier modifier, boolean z10, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z11, Role role, a aVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        boolean z12 = z11;
        if ((i10 & 16) != 0) {
            role = null;
        }
        return m612selectableO2vRcR0(modifier, z10, mutableInteractionSource, indication, z12, role, aVar);
    }

    @NotNull
    /* JADX INFO: renamed from: selectable-XHw0xAI, reason: not valid java name */
    public static final Modifier m614selectableXHw0xAI(@NotNull Modifier selectable, boolean z10, boolean z11, @Nullable Role role, @NotNull a<k0> onClick) {
        t.i(selectable, "$this$selectable");
        t.i(onClick, "onClick");
        return ComposedModifierKt.composed(selectable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SelectableKt$selectableXHw0xAI$$inlined$debugInspectorInfo$1(z10, z11, role, onClick) : InspectableValueKt.getNoInspectorInfo(), new SelectableKt$selectable$2(z10, z11, role, onClick));
    }

    /* JADX INFO: renamed from: selectable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m615selectableXHw0xAI$default(Modifier modifier, boolean z10, boolean z11, Role role, a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        if ((i10 & 4) != 0) {
            role = null;
        }
        return m614selectableXHw0xAI(modifier, z10, z11, role, aVar);
    }
}
