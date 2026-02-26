package androidx.compose.runtime;

import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Effects.kt */
/* JADX INFO: loaded from: classes.dex */
final class DisposableEffectImpl implements RememberObserver {

    @NotNull
    private final l<DisposableEffectScope, DisposableEffectResult> effect;

    @Nullable
    private DisposableEffectResult onDispose;

    /* JADX WARN: Multi-variable type inference failed */
    public DisposableEffectImpl(@NotNull l<? super DisposableEffectScope, ? extends DisposableEffectResult> effect) {
        t.i(effect, "effect");
        this.effect = effect;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        DisposableEffectResult disposableEffectResult = this.onDispose;
        if (disposableEffectResult != null) {
            disposableEffectResult.dispose();
        }
        this.onDispose = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.onDispose = this.effect.invoke(EffectsKt.InternalDisposableEffectScope);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }
}
