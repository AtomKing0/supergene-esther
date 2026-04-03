package v;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GlobalLifecycle.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends Lifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f34883a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final LifecycleOwner f34884b = new LifecycleOwner() { // from class: v.g
        @Override // androidx.lifecycle.LifecycleOwner
        public final Lifecycle getLifecycle() {
            return h.c();
        }
    };

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Lifecycle c() {
        return f34883a;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(@NotNull LifecycleObserver lifecycleObserver) {
        if (!(lifecycleObserver instanceof DefaultLifecycleObserver)) {
            throw new IllegalArgumentException((lifecycleObserver + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) lifecycleObserver;
        LifecycleOwner lifecycleOwner = f34884b;
        defaultLifecycleObserver.onCreate(lifecycleOwner);
        defaultLifecycleObserver.onStart(lifecycleOwner);
        defaultLifecycleObserver.onResume(lifecycleOwner);
    }

    @Override // androidx.lifecycle.Lifecycle
    @NotNull
    public Lifecycle.State getCurrentState() {
        return Lifecycle.State.RESUMED;
    }

    @NotNull
    public String toString() {
        return "coil.request.GlobalLifecycle";
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(@NotNull LifecycleObserver lifecycleObserver) {
    }
}
