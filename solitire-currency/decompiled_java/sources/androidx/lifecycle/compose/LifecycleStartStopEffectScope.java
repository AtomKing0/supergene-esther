package androidx.lifecycle.compose;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import h9.l;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LifecycleEffect.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class LifecycleStartStopEffectScope implements LifecycleOwner {
    public static final int $stable = 8;

    @NotNull
    private final Lifecycle lifecycle;

    public LifecycleStartStopEffectScope(@NotNull Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @NotNull
    public final LifecycleStopOrDisposeEffectResult onStopOrDispose(@NotNull final l<? super LifecycleOwner, k0> lVar) {
        return new LifecycleStopOrDisposeEffectResult() { // from class: androidx.lifecycle.compose.LifecycleStartStopEffectScope.onStopOrDispose.1
            @Override // androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult
            public void runStopOrDisposeEffect() {
                lVar.invoke(this);
            }
        };
    }
}
