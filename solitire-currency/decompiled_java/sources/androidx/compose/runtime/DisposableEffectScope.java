package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Effects.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class DisposableEffectScope {
    public static final int $stable = 0;

    @NotNull
    public final DisposableEffectResult onDispose(@NotNull final h9.a<k0> onDisposeEffect) {
        t.i(onDisposeEffect, "onDisposeEffect");
        return new DisposableEffectResult() { // from class: androidx.compose.runtime.DisposableEffectScope.onDispose.1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                onDisposeEffect.invoke();
            }
        };
    }
}
