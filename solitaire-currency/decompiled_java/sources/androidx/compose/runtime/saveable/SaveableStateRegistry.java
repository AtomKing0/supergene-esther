package androidx.compose.runtime.saveable;

import h9.a;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SaveableStateRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SaveableStateRegistry {

    /* JADX INFO: compiled from: SaveableStateRegistry.kt */
    public interface Entry {
        void unregister();
    }

    boolean canBeSaved(@NotNull Object obj);

    @Nullable
    Object consumeRestored(@NotNull String str);

    @NotNull
    Map<String, List<Object>> performSave();

    @NotNull
    Entry registerProvider(@NotNull String str, @NotNull a<? extends Object> aVar);
}
