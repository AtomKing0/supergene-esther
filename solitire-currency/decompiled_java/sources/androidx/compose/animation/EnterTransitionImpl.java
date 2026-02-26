package androidx.compose.animation;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
final class EnterTransitionImpl extends EnterTransition {

    @NotNull
    private final TransitionData data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterTransitionImpl(@NotNull TransitionData data) {
        super(null);
        t.i(data, "data");
        this.data = data;
    }

    @Override // androidx.compose.animation.EnterTransition
    @NotNull
    public TransitionData getData$animation_release() {
        return this.data;
    }
}
