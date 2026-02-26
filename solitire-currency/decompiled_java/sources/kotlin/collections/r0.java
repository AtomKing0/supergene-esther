package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Maps.kt */
/* JADX INFO: loaded from: classes5.dex */
public class r0 extends q0 {
    @NotNull
    public static <K, V> Map<K, V> g() {
        g0 g0Var = g0.f29775a;
        kotlin.jvm.internal.t.g(g0Var, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return g0Var;
    }

    public static <K, V> V h(@NotNull Map<K, ? extends V> map, K k10) {
        kotlin.jvm.internal.t.i(map, "<this>");
        return (V) p0.a(map, k10);
    }

    @NotNull
    public static <K, V> HashMap<K, V> i(@NotNull v8.s<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.t.i(pairs, "pairs");
        HashMap<K, V> map = new HashMap<>(q0.d(pairs.length));
        r(map, pairs);
        return map;
    }

    @NotNull
    public static <K, V> Map<K, V> j(@NotNull v8.s<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.t.i(pairs, "pairs");
        return pairs.length > 0 ? y(pairs, new LinkedHashMap(q0.d(pairs.length))) : g();
    }

    @NotNull
    public static <K, V> Map<K, V> k(@NotNull Map<? extends K, ? extends V> map, K k10) {
        kotlin.jvm.internal.t.i(map, "<this>");
        Map mapZ = z(map);
        mapZ.remove(k10);
        return m(mapZ);
    }

    @NotNull
    public static <K, V> Map<K, V> l(@NotNull v8.s<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.t.i(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(q0.d(pairs.length));
        r(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> m(@NotNull Map<K, ? extends V> map) {
        kotlin.jvm.internal.t.i(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : q0.f(map) : g();
    }

    @NotNull
    public static <K, V> Map<K, V> n(@NotNull Map<? extends K, ? extends V> map, @NotNull Map<? extends K, ? extends V> map2) {
        kotlin.jvm.internal.t.i(map, "<this>");
        kotlin.jvm.internal.t.i(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @NotNull
    public static <K, V> Map<K, V> o(@NotNull Map<? extends K, ? extends V> map, @NotNull v8.s<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.t.i(map, "<this>");
        kotlin.jvm.internal.t.i(pair, "pair");
        if (map.isEmpty()) {
            return q0.e(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.c(), pair.d());
        return linkedHashMap;
    }

    public static <K, V> void p(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends v8.s<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.t.i(map, "<this>");
        kotlin.jvm.internal.t.i(pairs, "pairs");
        for (v8.s<? extends K, ? extends V> sVar : pairs) {
            map.put(sVar.a(), sVar.b());
        }
    }

    public static <K, V> void q(@NotNull Map<? super K, ? super V> map, @NotNull o9.g<? extends v8.s<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.t.i(map, "<this>");
        kotlin.jvm.internal.t.i(pairs, "pairs");
        for (v8.s<? extends K, ? extends V> sVar : pairs) {
            map.put(sVar.a(), sVar.b());
        }
    }

    public static <K, V> void r(@NotNull Map<? super K, ? super V> map, @NotNull v8.s<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.t.i(map, "<this>");
        kotlin.jvm.internal.t.i(pairs, "pairs");
        for (v8.s<? extends K, ? extends V> sVar : pairs) {
            map.put(sVar.a(), sVar.b());
        }
    }

    @NotNull
    public static <K, V> Map<K, V> s(@NotNull Iterable<? extends v8.s<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m(t(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return g();
        }
        if (size != 1) {
            return t(iterable, new LinkedHashMap(q0.d(collection.size())));
        }
        return q0.e(iterable instanceof List ? (v8.s<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M t(@NotNull Iterable<? extends v8.s<? extends K, ? extends V>> iterable, @NotNull M destination) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(destination, "destination");
        p(destination, iterable);
        return destination;
    }

    @NotNull
    public static <K, V> Map<K, V> u(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.t.i(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? z(map) : q0.f(map) : g();
    }

    @NotNull
    public static <K, V> Map<K, V> v(@NotNull o9.g<? extends v8.s<? extends K, ? extends V>> gVar) {
        kotlin.jvm.internal.t.i(gVar, "<this>");
        return m(w(gVar, new LinkedHashMap()));
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M w(@NotNull o9.g<? extends v8.s<? extends K, ? extends V>> gVar, @NotNull M destination) {
        kotlin.jvm.internal.t.i(gVar, "<this>");
        kotlin.jvm.internal.t.i(destination, "destination");
        q(destination, gVar);
        return destination;
    }

    @NotNull
    public static <K, V> Map<K, V> x(@NotNull v8.s<? extends K, ? extends V>[] sVarArr) {
        kotlin.jvm.internal.t.i(sVarArr, "<this>");
        int length = sVarArr.length;
        return length != 0 ? length != 1 ? y(sVarArr, new LinkedHashMap(q0.d(sVarArr.length))) : q0.e(sVarArr[0]) : g();
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M y(@NotNull v8.s<? extends K, ? extends V>[] sVarArr, @NotNull M destination) {
        kotlin.jvm.internal.t.i(sVarArr, "<this>");
        kotlin.jvm.internal.t.i(destination, "destination");
        r(destination, sVarArr);
        return destination;
    }

    @NotNull
    public static <K, V> Map<K, V> z(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.t.i(map, "<this>");
        return new LinkedHashMap(map);
    }
}
