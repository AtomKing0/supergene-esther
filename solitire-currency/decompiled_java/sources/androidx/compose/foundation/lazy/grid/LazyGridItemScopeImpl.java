package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridItemScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridItemScopeImpl implements LazyGridItemScope {

    @NotNull
    public static final LazyGridItemScopeImpl INSTANCE = new LazyGridItemScopeImpl();

    private LazyGridItemScopeImpl() {
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemScope
    @ExperimentalFoundationApi
    @NotNull
    public Modifier animateItemPlacement(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntOffset> animationSpec) {
        t.i(modifier, "<this>");
        t.i(animationSpec, "animationSpec");
        return modifier.then(new AnimateItemPlacementModifier(animationSpec, InspectableValueKt.isDebugInspectorInfoEnabled() ? new LazyGridItemScopeImpl$animateItemPlacement$$inlined$debugInspectorInfo$1(animationSpec) : InspectableValueKt.getNoInspectorInfo()));
    }
}
