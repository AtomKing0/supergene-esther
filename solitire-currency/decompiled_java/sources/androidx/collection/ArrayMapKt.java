package androidx.collection;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.s;

/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayMapKt {
    @NotNull
    public static final <K, V> ArrayMap<K, V> arrayMapOf() {
        return new ArrayMap<>();
    }

    @NotNull
    public static final <K, V> ArrayMap<K, V> arrayMapOf(@NotNull s<? extends K, ? extends V>... pairs) {
        t.j(pairs, "pairs");
        ArrayMap<K, V> arrayMap = new ArrayMap<>(pairs.length);
        for (s<? extends K, ? extends V> sVar : pairs) {
            arrayMap.put(sVar.c(), sVar.d());
        }
        return arrayMap;
    }
}
