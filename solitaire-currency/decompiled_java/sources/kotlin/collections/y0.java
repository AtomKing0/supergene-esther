package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: SetsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class y0 {
    @NotNull
    public static <E> Set<E> a(@NotNull Set<E> builder) {
        kotlin.jvm.internal.t.i(builder, "builder");
        return ((w8.h) builder).a();
    }

    @NotNull
    public static <E> Set<E> b() {
        return new w8.h();
    }

    @NotNull
    public static <T> Set<T> c(T t10) {
        Set<T> setSingleton = Collections.singleton(t10);
        kotlin.jvm.internal.t.h(setSingleton, "singleton(element)");
        return setSingleton;
    }

    @NotNull
    public static <T> TreeSet<T> d(@NotNull T... elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return (TreeSet) p.n0(elements, new TreeSet());
    }
}
