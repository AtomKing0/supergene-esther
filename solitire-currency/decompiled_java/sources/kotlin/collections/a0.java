package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: MutableCollections.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a0 extends z {
    public static <T> boolean B(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        kotlin.jvm.internal.t.i(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean C(@NotNull Collection<? super T> collection, @NotNull o9.g<? extends T> elements) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        kotlin.jvm.internal.t.i(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean D(@NotNull Collection<? super T> collection, @NotNull T[] elements) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        kotlin.jvm.internal.t.i(elements, "elements");
        return collection.addAll(o.c(elements));
    }

    @NotNull
    public static final <T> Collection<T> E(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            iterable = d0.P0(iterable);
        }
        return (Collection) iterable;
    }

    private static final <T> boolean F(Iterable<? extends T> iterable, h9.l<? super T, Boolean> lVar, boolean z10) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (lVar.invoke(it.next()).booleanValue() == z10) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    private static final <T> boolean G(List<T> list, h9.l<? super T, Boolean> lVar, boolean z10) {
        if (!(list instanceof RandomAccess)) {
            kotlin.jvm.internal.t.g(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return F(kotlin.jvm.internal.t0.b(list), lVar, z10);
        }
        l0 it = new n9.i(0, v.m(list)).iterator();
        int i10 = 0;
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            T t10 = list.get(iNextInt);
            if (lVar.invoke(t10).booleanValue() != z10) {
                if (i10 != iNextInt) {
                    list.set(i10, t10);
                }
                i10++;
            }
        }
        if (i10 >= list.size()) {
            return false;
        }
        int iM = v.m(list);
        if (i10 > iM) {
            return true;
        }
        while (true) {
            list.remove(iM);
            if (iM == i10) {
                return true;
            }
            iM--;
        }
    }

    public static <T> boolean H(@NotNull Iterable<? extends T> iterable, @NotNull h9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(predicate, "predicate");
        return F(iterable, predicate, true);
    }

    public static <T> boolean I(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        kotlin.jvm.internal.t.i(elements, "elements");
        return collection.removeAll(E(elements));
    }

    public static <T> boolean J(@NotNull Collection<? super T> collection, @NotNull o9.g<? extends T> elements) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        kotlin.jvm.internal.t.i(elements, "elements");
        List listW = o9.o.w(elements);
        return (listW.isEmpty() ^ true) && collection.removeAll(listW);
    }

    public static <T> boolean K(@NotNull Collection<? super T> collection, @NotNull T[] elements) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        kotlin.jvm.internal.t.i(elements, "elements");
        return ((elements.length == 0) ^ true) && collection.removeAll(o.c(elements));
    }

    public static <T> boolean L(@NotNull List<T> list, @NotNull h9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.t.i(list, "<this>");
        kotlin.jvm.internal.t.i(predicate, "predicate");
        return G(list, predicate, true);
    }

    public static <T> T M(@NotNull List<T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    @Nullable
    public static <T> T N(@NotNull List<T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public static <T> T O(@NotNull List<T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(v.m(list));
    }

    @Nullable
    public static <T> T P(@NotNull List<T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(v.m(list));
    }

    public static <T> boolean Q(@NotNull Iterable<? extends T> iterable, @NotNull h9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.t.i(iterable, "<this>");
        kotlin.jvm.internal.t.i(predicate, "predicate");
        return F(iterable, predicate, false);
    }

    public static <T> boolean R(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> elements) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        kotlin.jvm.internal.t.i(elements, "elements");
        return collection.retainAll(E(elements));
    }
}
