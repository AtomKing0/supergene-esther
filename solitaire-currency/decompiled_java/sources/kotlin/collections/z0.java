package kotlin.collections;

import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Sets.kt */
/* JADX INFO: loaded from: classes5.dex */
public class z0 extends y0 {
    @NotNull
    public static <T> Set<T> e() {
        return h0.f29776a;
    }

    @NotNull
    public static <T> Set<T> f(@NotNull T... elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return (Set) p.n0(elements, new LinkedHashSet(q0.d(elements.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Set<T> g(@NotNull Set<? extends T> set) {
        kotlin.jvm.internal.t.i(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : y0.c(set.iterator().next()) : e();
    }

    @NotNull
    public static <T> Set<T> h(@NotNull T... elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return elements.length > 0 ? p.r0(elements) : e();
    }
}
