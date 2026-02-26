package a0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.collections.r0;
import kotlin.collections.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    @NotNull
    public static final <T> List<T> a(@NotNull List<? extends T> list) {
        int size = list.size();
        return size != 0 ? size != 1 ? Collections.unmodifiableList(new ArrayList(list)) : Collections.singletonList(d0.i0(list)) : v.l();
    }

    @NotNull
    public static final <K, V> Map<K, V> b(@NotNull Map<K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return r0.g();
        }
        if (size != 1) {
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) d0.h0(map.entrySet());
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }
}
