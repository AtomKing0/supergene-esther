package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LifecycleController.kt */
/* JADX INFO: loaded from: classes.dex */
@MainThread
public final class LifecycleController {

    @NotNull
    private final DispatchQueue dispatchQueue;

    @NotNull
    private final Lifecycle lifecycle;

    @NotNull
    private final Lifecycle.State minState;

    @NotNull
    private final LifecycleEventObserver observer;

    public LifecycleController(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State minState, @NotNull DispatchQueue dispatchQueue, @NotNull final b2 parentJob) {
        t.i(lifecycle, "lifecycle");
        t.i(minState, "minState");
        t.i(dispatchQueue, "dispatchQueue");
        t.i(parentJob, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = minState;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.h
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LifecycleController.observer$lambda$0(this.f987a, parentJob, lifecycleOwner, event);
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            lifecycle.addObserver(lifecycleEventObserver);
        } else {
            b2.a.a(parentJob, null, 1, null);
            finish();
        }
    }

    private final void handleDestroy(b2 b2Var) {
        b2.a.a(b2Var, null, 1, null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController this$0, b2 parentJob, LifecycleOwner source, Lifecycle.Event event) {
        t.i(this$0, "this$0");
        t.i(parentJob, "$parentJob");
        t.i(source, "source");
        t.i(event, "<anonymous parameter 1>");
        if (source.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            b2.a.a(parentJob, null, 1, null);
            this$0.finish();
        } else if (source.getLifecycle().getCurrentState().compareTo(this$0.minState) < 0) {
            this$0.dispatchQueue.pause();
        } else {
            this$0.dispatchQueue.resume();
        }
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
