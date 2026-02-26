package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: Iterables.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 {
    public static <T> boolean a(Iterable<T> iterable, e5.p<? super T> pVar) {
        return h0.b(iterable.iterator(), pVar);
    }

    private static <E> Collection<E> b(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : j0.i(iterable.iterator());
    }

    public static <T> T c(Iterable<? extends T> iterable, T t10) {
        return (T) h0.n(iterable.iterator(), t10);
    }

    public static <T> T d(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) h0.l(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) f(list);
    }

    public static <T> T e(Iterable<? extends T> iterable, T t10) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t10;
            }
            if (iterable instanceof List) {
                return (T) f(j0.a(iterable));
            }
        }
        return (T) h0.m(iterable.iterator(), t10);
    }

    private static <T> T f(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T g(Iterable<T> iterable) {
        return (T) h0.o(iterable.iterator());
    }

    public static <T> boolean h(Iterable<T> iterable, e5.p<? super T> pVar) {
        return ((iterable instanceof RandomAccess) && (iterable instanceof List)) ? i((List) iterable, (e5.p) e5.o.j(pVar)) : h0.s(iterable.iterator(), pVar);
    }

    private static <T> boolean i(List<T> list, e5.p<? super T> pVar) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < list.size()) {
            T t10 = list.get(i10);
            if (!pVar.apply(t10)) {
                if (i10 > i11) {
                    try {
                        list.set(i11, t10);
                    } catch (IllegalArgumentException unused) {
                        j(list, pVar, i11, i10);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        j(list, pVar, i11, i10);
                        return true;
                    }
                }
                i11++;
            }
            i10++;
        }
        list.subList(i11, list.size()).clear();
        return i10 != i11;
    }

    private static <T> void j(List<T> list, e5.p<? super T> pVar, int i10, int i11) {
        for (int size = list.size() - 1; size > i11; size--) {
            if (pVar.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            list.remove(i12);
        }
    }

    static Object[] k(Iterable<?> iterable) {
        return b(iterable).toArray();
    }
}
