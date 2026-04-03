package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: MapsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class q0 extends p0 {
    @NotNull
    public static <K, V> Map<K, V> b(@NotNull Map<K, V> builder) {
        kotlin.jvm.internal.t.i(builder, "builder");
        return ((w8.d) builder).k();
    }

    @NotNull
    public static <K, V> Map<K, V> c() {
        return new w8.d();
    }

    public static int d(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public static <K, V> Map<K, V> e(@NotNull v8.s<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.t.i(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.c(), pair.d());
        kotlin.jvm.internal.t.h(mapSingletonMap, "singletonMap(pair.first, pair.second)");
        return mapSingletonMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> f(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.t.i(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.t.h(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
