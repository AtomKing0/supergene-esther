package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: Lists.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 {

    /* JADX INFO: compiled from: Lists.java */
    private static class a<F, T> extends AbstractList<T> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<F> f10073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final e5.g<? super F, ? extends T> f10074b;

        /* JADX INFO: renamed from: com.google.common.collect.j0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Lists.java */
        class C0222a extends h1<F, T> {
            C0222a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.g1
            T a(F f10) {
                return a.this.f10074b.apply(f10);
            }
        }

        a(List<F> list, e5.g<? super F, ? extends T> gVar) {
            this.f10073a = (List) e5.o.j(list);
            this.f10074b = (e5.g) e5.o.j(gVar);
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i10) {
            return this.f10074b.apply(this.f10073a.get(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f10073a.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new C0222a(this.f10073a.listIterator(i10));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i10) {
            return this.f10074b.apply(this.f10073a.remove(i10));
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i10, int i11) {
            this.f10073a.subList(i10, i11).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f10073a.size();
        }
    }

    /* JADX INFO: compiled from: Lists.java */
    private static class b<F, T> extends AbstractSequentialList<T> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<F> f10076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final e5.g<? super F, ? extends T> f10077b;

        /* JADX INFO: compiled from: Lists.java */
        class a extends h1<F, T> {
            a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.g1
            T a(F f10) {
                return b.this.f10077b.apply(f10);
            }
        }

        b(List<F> list, e5.g<? super F, ? extends T> gVar) {
            this.f10076a = (List) e5.o.j(list);
            this.f10077b = (e5.g) e5.o.j(gVar);
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new a(this.f10076a.listIterator(i10));
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i10, int i11) {
            this.f10076a.subList(i10, i11).clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f10076a.size();
        }
    }

    static <T> List<T> a(Iterable<T> iterable) {
        return (List) iterable;
    }

    static int b(int i10) {
        k.b(i10, "arraySize");
        return g5.e.j(((long) i10) + 5 + ((long) (i10 / 10)));
    }

    static boolean c(List<?> list, Object obj) {
        if (obj == e5.o.j(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return h0.f(list.iterator(), list2.iterator());
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (!e5.k.a(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    static int d(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (e5.k.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, Object obj) {
        int size = list.size();
        int i10 = 0;
        if (obj == null) {
            while (i10 < size) {
                if (list.get(i10) == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        while (i10 < size) {
            if (obj.equals(list.get(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    static int f(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return g(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (e5.k.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int g(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> h() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> i(Iterator<? extends E> it) {
        ArrayList<E> arrayListH = h();
        h0.a(arrayListH, it);
        return arrayListH;
    }

    @SafeVarargs
    public static <E> ArrayList<E> j(E... eArr) {
        e5.o.j(eArr);
        ArrayList<E> arrayList = new ArrayList<>(b(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static <F, T> List<T> k(List<F> list, e5.g<? super F, ? extends T> gVar) {
        return list instanceof RandomAccess ? new a(list, gVar) : new b(list, gVar);
    }
}
