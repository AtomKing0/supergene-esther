package kotlin.collections;

import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Sets.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a1 extends z0 {
    @NotNull
    public static <T> Set<T> i(@NotNull Set<? extends T> set, T t10) {
        kotlin.jvm.internal.t.i(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(q0.d(set.size()));
        boolean z10 = false;
        for (T t11 : set) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.t.d(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                linkedHashSet.add(t11);
            }
        }
        return linkedHashSet;
    }

    @NotNull
    public static <T> Set<T> j(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> elements) {
        int size;
        kotlin.jvm.internal.t.i(set, "<this>");
        kotlin.jvm.internal.t.i(elements, "elements");
        Integer numW = w.w(elements);
        if (numW != null) {
            size = set.size() + numW.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(q0.d(size));
        linkedHashSet.addAll(set);
        a0.B(linkedHashSet, elements);
        return linkedHashSet;
    }

    @NotNull
    public static <T> Set<T> k(@NotNull Set<? extends T> set, T t10) {
        kotlin.jvm.internal.t.i(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(q0.d(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t10);
        return linkedHashSet;
    }
}
