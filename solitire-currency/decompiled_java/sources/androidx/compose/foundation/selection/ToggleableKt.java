package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import h9.a;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Toggleable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ToggleableKt {
    @NotNull
    /* JADX INFO: renamed from: toggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m617toggleableO2vRcR0(@NotNull Modifier toggleable, boolean z10, @NotNull MutableInteractionSource interactionSource, @Nullable Indication indication, boolean z11, @Nullable Role role, @NotNull l<? super Boolean, k0> onValueChange) {
        t.i(toggleable, "$this$toggleable");
        t.i(interactionSource, "interactionSource");
        t.i(onValueChange, "onValueChange");
        return InspectableValueKt.inspectableWrapper(toggleable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableO2vRcR0$$inlined$debugInspectorInfo$1(z10, interactionSource, indication, z11, role, onValueChange) : InspectableValueKt.getNoInspectorInfo(), m621toggleableImpl3WzHGRc(Modifier.Companion, ToggleableStateKt.ToggleableState(z10), z11, role, interactionSource, indication, new ToggleableKt$toggleable$4$1(onValueChange, z10)));
    }

    /* JADX INFO: renamed from: toggleable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m618toggleableO2vRcR0$default(Modifier modifier, boolean z10, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z11, Role role, l lVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        boolean z12 = z11;
        if ((i10 & 16) != 0) {
            role = null;
        }
        return m617toggleableO2vRcR0(modifier, z10, mutableInteractionSource, indication, z12, role, lVar);
    }

    @NotNull
    /* JADX INFO: renamed from: toggleable-XHw0xAI, reason: not valid java name */
    public static final Modifier m619toggleableXHw0xAI(@NotNull Modifier toggleable, boolean z10, boolean z11, @Nullable Role role, @NotNull l<? super Boolean, k0> onValueChange) {
        t.i(toggleable, "$this$toggleable");
        t.i(onValueChange, "onValueChange");
        return ComposedModifierKt.composed(toggleable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableXHw0xAI$$inlined$debugInspectorInfo$1(z10, z11, role, onValueChange) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$toggleable$2(z10, z11, role, onValueChange));
    }

    /* JADX INFO: renamed from: toggleable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m620toggleableXHw0xAI$default(Modifier modifier, boolean z10, boolean z11, Role role, l lVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        if ((i10 & 4) != 0) {
            role = null;
        }
        return m619toggleableXHw0xAI(modifier, z10, z11, role, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toggleableImpl-3WzHGRc, reason: not valid java name */
    public static final Modifier m621toggleableImpl3WzHGRc(Modifier modifier, ToggleableState toggleableState, boolean z10, Role role, MutableInteractionSource mutableInteractionSource, Indication indication, a<k0> aVar) {
        return ComposedModifierKt.composed$default(modifier, null, new ToggleableKt$toggleableImpl$1(aVar, z10, mutableInteractionSource, indication, role, toggleableState), 1, null);
    }

    /* JADX INFO: renamed from: toggleableImpl-3WzHGRc$default, reason: not valid java name */
    static /* synthetic */ Modifier m622toggleableImpl3WzHGRc$default(Modifier modifier, ToggleableState toggleableState, boolean z10, Role role, MutableInteractionSource mutableInteractionSource, Indication indication, a aVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            role = null;
        }
        return m621toggleableImpl3WzHGRc(modifier, toggleableState, z10, role, mutableInteractionSource, indication, aVar);
    }

    @NotNull
    /* JADX INFO: renamed from: triStateToggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m623triStateToggleableO2vRcR0(@NotNull Modifier triStateToggleable, @NotNull ToggleableState state, @NotNull MutableInteractionSource interactionSource, @Nullable Indication indication, boolean z10, @Nullable Role role, @NotNull a<k0> onClick) {
        t.i(triStateToggleable, "$this$triStateToggleable");
        t.i(state, "state");
        t.i(interactionSource, "interactionSource");
        t.i(onClick, "onClick");
        return InspectableValueKt.inspectableWrapper(triStateToggleable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableO2vRcR0$$inlined$debugInspectorInfo$1(state, z10, role, interactionSource, indication, onClick) : InspectableValueKt.getNoInspectorInfo(), m621toggleableImpl3WzHGRc(Modifier.Companion, state, z10, role, interactionSource, indication, onClick));
    }

    /* JADX INFO: renamed from: triStateToggleable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m624triStateToggleableO2vRcR0$default(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z10, Role role, a aVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        if ((i10 & 16) != 0) {
            role = null;
        }
        return m623triStateToggleableO2vRcR0(modifier, toggleableState, mutableInteractionSource, indication, z11, role, aVar);
    }

    @NotNull
    /* JADX INFO: renamed from: triStateToggleable-XHw0xAI, reason: not valid java name */
    public static final Modifier m625triStateToggleableXHw0xAI(@NotNull Modifier triStateToggleable, @NotNull ToggleableState state, boolean z10, @Nullable Role role, @NotNull a<k0> onClick) {
        t.i(triStateToggleable, "$this$triStateToggleable");
        t.i(state, "state");
        t.i(onClick, "onClick");
        return ComposedModifierKt.composed(triStateToggleable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableXHw0xAI$$inlined$debugInspectorInfo$1(state, z10, role, onClick) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$triStateToggleable$2(state, z10, role, onClick));
    }

    /* JADX INFO: renamed from: triStateToggleable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m626triStateToggleableXHw0xAI$default(Modifier modifier, ToggleableState toggleableState, boolean z10, Role role, a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            role = null;
        }
        return m625triStateToggleableXHw0xAI(modifier, toggleableState, z10, role, aVar);
    }
}
