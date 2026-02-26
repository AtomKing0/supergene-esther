package androidx.compose.runtime.external.kotlinx.collections.immutable;

import i9.e;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImmutableMap.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PersistentMap<K, V> extends ImmutableMap<K, V> {

    /* JADX INFO: compiled from: ImmutableMap.kt */
    public interface Builder<K, V> extends Map<K, V>, e {
        @NotNull
        PersistentMap<K, V> build();
    }

    @NotNull
    Builder<K, V> builder();

    @Override // java.util.Map
    @NotNull
    PersistentMap<K, V> clear();

    @Override // java.util.Map
    @NotNull
    PersistentMap<K, V> put(K k10, V v10);

    @Override // java.util.Map
    @NotNull
    PersistentMap<K, V> putAll(@NotNull Map<? extends K, ? extends V> map);

    @Override // java.util.Map
    @NotNull
    PersistentMap<K, V> remove(K k10);

    @Override // java.util.Map
    @NotNull
    PersistentMap<K, V> remove(K k10, V v10);
}
