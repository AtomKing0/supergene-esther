package androidx.lifecycle;

import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PausingDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcher extends k0 {

    @NotNull
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.k0
    public void dispatch(@NotNull z8.g context, @NotNull Runnable block) {
        t.i(context, "context");
        t.i(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // kotlinx.coroutines.k0
    public boolean isDispatchNeeded(@NotNull z8.g context) {
        t.i(context, "context");
        if (e1.c().getImmediate().isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
