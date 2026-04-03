package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LifecycleEventObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event);
}
