package androidx.activity;

import androidx.annotation.MainThread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: OnBackPressedCallback.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class OnBackPressedCallback {

    @NotNull
    private final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();

    @Nullable
    private h9.a<k0> enabledChangedCallback;
    private boolean isEnabled;

    public OnBackPressedCallback(boolean z10) {
        this.isEnabled = z10;
    }

    public final void addCancellable(@NotNull Cancellable cancellable) {
        t.i(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    @Nullable
    public final h9.a<k0> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public void handleOnBackProgressed(@NotNull BackEventCompat backEvent) {
        t.i(backEvent, "backEvent");
    }

    @MainThread
    public void handleOnBackStarted(@NotNull BackEventCompat backEvent) {
        t.i(backEvent, "backEvent");
    }

    @MainThread
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void remove() {
        Iterator<T> it = this.cancellables.iterator();
        while (it.hasNext()) {
            ((Cancellable) it.next()).cancel();
        }
    }

    public final void removeCancellable(@NotNull Cancellable cancellable) {
        t.i(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z10) {
        this.isEnabled = z10;
        h9.a<k0> aVar = this.enabledChangedCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(@Nullable h9.a<k0> aVar) {
        this.enabledChangedCallback = aVar;
    }

    @MainThread
    public void handleOnBackCancelled() {
    }
}
