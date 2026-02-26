package io.sentry.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CollectionUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class c {
    @Nullable
    public static <T> List<T> a(@Nullable List<T> list) {
        if (list != null) {
            return new ArrayList(list);
        }
        return null;
    }

    @Nullable
    public static <K, V> Map<K, V> b(@Nullable Map<K, V> map) {
        if (map == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                concurrentHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return concurrentHashMap;
    }

    @Nullable
    public static <K, V> Map<K, V> c(@Nullable Map<K, V> map) {
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    @NotNull
    public static <T> ListIterator<T> d(@NotNull CopyOnWriteArrayList<T> copyOnWriteArrayList) {
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(copyOnWriteArrayList);
        return copyOnWriteArrayList2.listIterator(copyOnWriteArrayList2.size());
    }

    public static int e(@NotNull Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator<?> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
        }
        return i10;
    }
}
