package androidx.lifecycle;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LifecycleOwner.kt */
/* JADX INFO: loaded from: classes.dex */
public interface LifecycleOwner {
    @NotNull
    Lifecycle getLifecycle();
}
