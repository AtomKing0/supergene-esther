package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Effects.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CompositionScopedCoroutineScopeCanceller implements RememberObserver {

    @NotNull
    private final o0 coroutineScope;

    public CompositionScopedCoroutineScopeCanceller(@NotNull o0 coroutineScope) {
        t.i(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
    }

    @NotNull
    public final o0 getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        p0.e(this.coroutineScope, null, 1, null);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        p0.e(this.coroutineScope, null, 1, null);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }
}
