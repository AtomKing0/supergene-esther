package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ConstraintTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ConstraintTracker<T> {

    @NotNull
    private final Context appContext;

    @Nullable
    private T currentState;

    @NotNull
    private final LinkedHashSet<ConstraintListener<T>> listeners;

    @NotNull
    private final Object lock;

    @NotNull
    private final TaskExecutor taskExecutor;

    protected ConstraintTracker(@NotNull Context context, @NotNull TaskExecutor taskExecutor) {
        t.i(context, "context");
        t.i(taskExecutor, "taskExecutor");
        this.taskExecutor = taskExecutor;
        Context applicationContext = context.getApplicationContext();
        t.h(applicationContext, "context.applicationContext");
        this.appContext = applicationContext;
        this.lock = new Object();
        this.listeners = new LinkedHashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _set_state_$lambda$4$lambda$3(List listenersList, ConstraintTracker this$0) {
        t.i(listenersList, "$listenersList");
        t.i(this$0, "this$0");
        Iterator<T> it = listenersList.iterator();
        while (it.hasNext()) {
            ((ConstraintListener) it.next()).onConstraintChanged(this$0.currentState);
        }
    }

    public final void addListener(@NotNull ConstraintListener<T> listener) {
        t.i(listener, "listener");
        synchronized (this.lock) {
            if (this.listeners.add(listener)) {
                if (this.listeners.size() == 1) {
                    this.currentState = readSystemState();
                    Logger.get().debug(ConstraintTrackerKt.TAG, getClass().getSimpleName() + ": initial state = " + this.currentState);
                    startTracking();
                }
                listener.onConstraintChanged(this.currentState);
            }
            k0 k0Var = k0.f35197a;
        }
    }

    @NotNull
    protected final Context getAppContext() {
        return this.appContext;
    }

    public final T getState() {
        T t10 = this.currentState;
        return t10 == null ? readSystemState() : t10;
    }

    public abstract T readSystemState();

    public final void removeListener(@NotNull ConstraintListener<T> listener) {
        t.i(listener, "listener");
        synchronized (this.lock) {
            if (this.listeners.remove(listener) && this.listeners.isEmpty()) {
                stopTracking();
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public final void setState(T t10) {
        synchronized (this.lock) {
            T t11 = this.currentState;
            if (t11 == null || !t.d(t11, t10)) {
                this.currentState = t10;
                final List listP0 = d0.P0(this.listeners);
                this.taskExecutor.getMainThreadExecutor().execute(new Runnable() { // from class: androidx.work.impl.constraints.trackers.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConstraintTracker._set_state_$lambda$4$lambda$3(listP0, this);
                    }
                });
                k0 k0Var = k0.f35197a;
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
