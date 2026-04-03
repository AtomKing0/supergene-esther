package androidx.compose.runtime;

import h9.p;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: Effects.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LaunchedEffectImpl implements RememberObserver {

    @Nullable
    private b2 job;

    @NotNull
    private final o0 scope;

    @NotNull
    private final p<o0, z8.d<? super k0>, Object> task;

    /* JADX WARN: Multi-variable type inference failed */
    public LaunchedEffectImpl(@NotNull g parentCoroutineContext, @NotNull p<? super o0, ? super z8.d<? super k0>, ? extends Object> task) {
        t.i(parentCoroutineContext, "parentCoroutineContext");
        t.i(task, "task");
        this.task = task;
        this.scope = p0.a(parentCoroutineContext);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        b2 b2Var = this.job;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        b2 b2Var = this.job;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        b2 b2Var = this.job;
        if (b2Var != null) {
            h2.e(b2Var, "Old job was still running!", null, 2, null);
        }
        this.job = k.d(this.scope, null, null, this.task, 3, null);
    }
}
