package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Maps.kt */
/* JADX INFO: loaded from: classes5.dex */
public class t0 extends s0 {
    @NotNull
    public static <K, V> List<v8.s<K, V>> A(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.t.i(map, "<this>");
        if (map.size() == 0) {
            return v.l();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return v.l();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return u.e(new v8.s(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new v8.s(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new v8.s(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }
}
