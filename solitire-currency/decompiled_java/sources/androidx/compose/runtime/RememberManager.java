package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Composer.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RememberManager {
    void forgetting(@NotNull RememberObserver rememberObserver);

    void remembering(@NotNull RememberObserver rememberObserver);

    void sideEffect(@NotNull h9.a<k0> aVar);
}
