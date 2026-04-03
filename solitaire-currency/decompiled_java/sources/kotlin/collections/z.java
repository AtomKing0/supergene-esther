package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MutableCollectionsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
class z extends y {
    public static <T> void A(@NotNull List<T> list, @NotNull Comparator<? super T> comparator) {
        kotlin.jvm.internal.t.i(list, "<this>");
        kotlin.jvm.internal.t.i(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    public static <T extends Comparable<? super T>> void z(@NotNull List<T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
