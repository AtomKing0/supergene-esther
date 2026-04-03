package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: OnPlacedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OnPlacedModifierKt {
    @Stable
    @NotNull
    public static final Modifier onPlaced(@NotNull Modifier modifier, @NotNull h9.l<? super LayoutCoordinates, k0> onPlaced) {
        t.i(modifier, "<this>");
        t.i(onPlaced, "onPlaced");
        return modifier.then(new OnPlacedModifierImpl(onPlaced, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OnPlacedModifierKt$onPlaced$$inlined$debugInspectorInfo$1(onPlaced) : InspectableValueKt.getNoInspectorInfo()));
    }
}
