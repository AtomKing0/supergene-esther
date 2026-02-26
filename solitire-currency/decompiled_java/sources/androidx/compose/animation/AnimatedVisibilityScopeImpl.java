package androidx.compose.animation;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimatedVisibility.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalAnimationApi
public final class AnimatedVisibilityScopeImpl implements AnimatedVisibilityScope {

    @NotNull
    private final MutableState<IntSize> targetSize;

    @NotNull
    private Transition<EnterExitState> transition;

    public AnimatedVisibilityScopeImpl(@NotNull Transition<EnterExitState> transition) {
        t.i(transition, "transition");
        this.transition = transition;
        this.targetSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m3825boximpl(IntSize.Companion.m3838getZeroYbymL2g()), null, 2, null);
    }

    @Override // androidx.compose.animation.AnimatedVisibilityScope
    public /* synthetic */ Modifier animateEnterExit(Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str) {
        return AnimatedVisibilityScope.CC.a(this, modifier, enterTransition, exitTransition, str);
    }

    @NotNull
    public final MutableState<IntSize> getTargetSize$animation_release() {
        return this.targetSize;
    }

    @Override // androidx.compose.animation.AnimatedVisibilityScope
    @NotNull
    public Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    public void setTransition(@NotNull Transition<EnterExitState> transition) {
        t.i(transition, "<set-?>");
        this.transition = transition;
    }
}
