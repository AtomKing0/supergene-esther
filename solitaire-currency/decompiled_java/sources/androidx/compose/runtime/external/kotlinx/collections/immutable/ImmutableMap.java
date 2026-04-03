package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImmutableMap.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ImmutableMap<K, V> extends Map<K, V>, i9.a {
    @NotNull
    ImmutableSet<Map.Entry<K, V>> getEntries();

    @NotNull
    ImmutableSet<K> getKeys();

    @NotNull
    ImmutableCollection<V> getValues();
}
