package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: OnGloballyPositionedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OnGloballyPositionedModifierKt {
    @Stable
    @NotNull
    public static final Modifier onGloballyPositioned(@NotNull Modifier modifier, @NotNull h9.l<? super LayoutCoordinates, k0> onGloballyPositioned) {
        t.i(modifier, "<this>");
        t.i(onGloballyPositioned, "onGloballyPositioned");
        return modifier.then(new OnGloballyPositionedModifierImpl(onGloballyPositioned, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OnGloballyPositionedModifierKt$onGloballyPositioned$$inlined$debugInspectorInfo$1(onGloballyPositioned) : InspectableValueKt.getNoInspectorInfo()));
    }
}
