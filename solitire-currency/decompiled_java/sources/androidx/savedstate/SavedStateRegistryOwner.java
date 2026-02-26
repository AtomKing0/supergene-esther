package androidx.savedstate;

import androidx.lifecycle.LifecycleOwner;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SavedStateRegistryOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface SavedStateRegistryOwner extends LifecycleOwner {
    @NotNull
    SavedStateRegistry getSavedStateRegistry();
}
