package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.h;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashMapBuilderContentViews.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMapBuilderEntries<E extends Map.Entry<? extends K, ? extends V>, K, V> extends h<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    public abstract boolean containsEntry(@NotNull Map.Entry<? extends K, ? extends V> entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return remove((Map.Entry) obj);
        }
        return false;
    }

    public abstract boolean removeEntry(@NotNull Map.Entry<? extends K, ? extends V> entry);

    public final boolean contains(@NotNull E element) {
        t.i(element, "element");
        if ((element instanceof Object ? element : null) instanceof Map.Entry) {
            return containsEntry(element);
        }
        return false;
    }

    public final boolean remove(@NotNull E element) {
        t.i(element, "element");
        if ((element instanceof Object ? element : null) instanceof Map.Entry) {
            return removeEntry(element);
        }
        return false;
    }
}
