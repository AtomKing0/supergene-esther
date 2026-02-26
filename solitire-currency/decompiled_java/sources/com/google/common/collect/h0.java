package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Iterators.java */
    class a<T> extends com.google.common.collect.b<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Iterator f10062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e5.p f10063d;

        a(Iterator it, e5.p pVar) {
            this.f10062c = it;
            this.f10063d = pVar;
        }

        @Override // com.google.common.collect.b
        protected T a() {
            while (this.f10062c.hasNext()) {
                T t10 = (T) this.f10062c.next();
                if (this.f10063d.apply(t10)) {
                    return t10;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Iterators.java */
    class b<T> extends i1<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f10064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f10065b;

        b(Object obj) {
            this.f10065b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f10064a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f10064a) {
                throw new NoSuchElementException();
            }
            this.f10064a = true;
            return (T) this.f10065b;
        }
    }

    /* JADX INFO: compiled from: Iterators.java */
    private static final class c<T> extends com.google.common.collect.a<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final j1<Object> f10066e = new c(new Object[0], 0, 0, 0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final T[] f10067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f10068d;

        c(T[] tArr, int i10, int i11, int i12) {
            super(i11, i12);
            this.f10067c = tArr;
            this.f10068d = i10;
        }

        @Override // com.google.common.collect.a
        protected T a(int i10) {
            return this.f10067c[this.f10068d + i10];
        }
    }

    /* JADX INFO: compiled from: Iterators.java */
    private enum d implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            k.c(false);
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        e5.o.j(collection);
        e5.o.j(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static <T> boolean b(Iterator<T> it, e5.p<? super T> pVar) {
        return p(it, pVar) != -1;
    }

    static <T> ListIterator<T> c(Iterator<T> it) {
        return (ListIterator) it;
    }

    static void d(Iterator<?> it) {
        e5.o.j(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static boolean e(Iterator<?> it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !e5.k.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    static <T> i1<T> g() {
        return h();
    }

    static <T> j1<T> h() {
        return (j1<T>) c.f10066e;
    }

    static <T> Iterator<T> i() {
        return d.INSTANCE;
    }

    public static <T> i1<T> j(Iterator<T> it, e5.p<? super T> pVar) {
        e5.o.j(it);
        e5.o.j(pVar);
        return new a(it, pVar);
    }

    public static <T> T k(Iterator<T> it, e5.p<? super T> pVar) {
        e5.o.j(it);
        e5.o.j(pVar);
        while (it.hasNext()) {
            T next = it.next();
            if (pVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static <T> T l(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T m(Iterator<? extends T> it, T t10) {
        return it.hasNext() ? (T) l(it) : t10;
    }

    public static <T> T n(Iterator<? extends T> it, T t10) {
        return it.hasNext() ? it.next() : t10;
    }

    public static <T> T o(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i10 = 0; i10 < 4 && it.hasNext(); i10++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> int p(Iterator<T> it, e5.p<? super T> pVar) {
        e5.o.k(pVar, "predicate");
        int i10 = 0;
        while (it.hasNext()) {
            if (pVar.apply(it.next())) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    static <T> T q(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static boolean r(Iterator<?> it, Collection<?> collection) {
        e5.o.j(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean s(Iterator<T> it, e5.p<? super T> pVar) {
        e5.o.j(pVar);
        boolean z10 = false;
        while (it.hasNext()) {
            if (pVar.apply(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> i1<T> t(T t10) {
        return new b(t10);
    }
}
