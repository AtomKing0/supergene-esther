package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Box.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BoxScopeInstance implements BoxScope {

    @NotNull
    public static final BoxScopeInstance INSTANCE = new BoxScopeInstance();

    private BoxScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    @Stable
    @NotNull
    public Modifier align(@NotNull Modifier modifier, @NotNull Alignment alignment) {
        t.i(modifier, "<this>");
        t.i(alignment, "alignment");
        return modifier.then(new BoxChildData(alignment, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BoxScopeInstance$align$$inlined$debugInspectorInfo$1(alignment) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    @Stable
    @NotNull
    public Modifier matchParentSize(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return modifier.then(new BoxChildData(Alignment.Companion.getCenter(), true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BoxScopeInstance$matchParentSize$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo()));
    }
}
