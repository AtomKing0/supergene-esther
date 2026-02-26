package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: OnRemeasuredModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OnRemeasuredModifierKt {
    @Stable
    @NotNull
    public static final Modifier onSizeChanged(@NotNull Modifier modifier, @NotNull h9.l<? super IntSize, k0> onSizeChanged) {
        t.i(modifier, "<this>");
        t.i(onSizeChanged, "onSizeChanged");
        return modifier.then(new OnSizeChangedModifier(onSizeChanged, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OnRemeasuredModifierKt$onSizeChanged$$inlined$debugInspectorInfo$1(onSizeChanged) : InspectableValueKt.getNoInspectorInfo()));
    }
}
