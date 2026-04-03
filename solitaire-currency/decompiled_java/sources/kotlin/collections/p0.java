package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: MapWithDefault.kt */
/* JADX INFO: loaded from: classes5.dex */
public class p0 {
    public static <K, V> V a(@NotNull Map<K, ? extends V> map, K k10) {
        kotlin.jvm.internal.t.i(map, "<this>");
        if (map instanceof n0) {
            return (V) ((n0) map).d(k10);
        }
        V v10 = map.get(k10);
        if (v10 != null || map.containsKey(k10)) {
            return v10;
        }
        throw new NoSuchElementException("Key " + k10 + " is missing in the map.");
    }
}
