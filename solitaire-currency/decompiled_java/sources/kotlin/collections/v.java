package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes5.dex */
public class v extends u {
    @NotNull
    public static <T> ArrayList<T> f(@NotNull T... elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new j(elements, true));
    }

    @NotNull
    public static final <T> Collection<T> g(@NotNull T[] tArr) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        return new j(tArr, false);
    }

    public static final <T> int h(@NotNull List<? extends T> list, int i10, int i11, @NotNull h9.l<? super T, Integer> comparison) {
        kotlin.jvm.internal.t.i(list, "<this>");
        kotlin.jvm.internal.t.i(comparison, "comparison");
        s(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iIntValue = comparison.invoke(list.get(i13)).intValue();
            if (iIntValue < 0) {
                i10 = i13 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final <T extends Comparable<? super T>> int i(@NotNull List<? extends T> list, @Nullable T t10, int i10, int i11) {
        kotlin.jvm.internal.t.i(list, "<this>");
        s(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iA = x8.b.a(list.get(i13), t10);
            if (iA < 0) {
                i10 = i13 + 1;
            } else {
                if (iA <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int j(List list, int i10, int i11, h9.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = list.size();
        }
        return h(list, i10, i11, lVar);
    }

    public static /* synthetic */ int k(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return i(list, comparable, i10, i11);
    }

    @NotNull
    public static <T> List<T> l() {
        return f0.f29774a;
    }

    public static <T> int m(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        return list.size() - 1;
    }

    @NotNull
    public static <T> List<T> n(@NotNull T... elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return elements.length > 0 ? o.c(elements) : l();
    }

    @NotNull
    public static <T> List<T> o(@Nullable T t10) {
        return t10 != null ? u.e(t10) : l();
    }

    @NotNull
    public static <T> List<T> p(@NotNull T... elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return p.K(elements);
    }

    @NotNull
    public static <T> List<T> q(@NotNull T... elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new j(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> r(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : u.e(list.get(0)) : l();
    }

    private static final void s(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i11 + ") is less than zero.");
        }
        if (i12 <= i10) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
    }

    public static void t() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void u() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
