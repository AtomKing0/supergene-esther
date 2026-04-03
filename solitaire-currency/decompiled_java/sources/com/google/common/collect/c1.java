package com.google.common.collect;

import com.google.common.collect.l;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: Sets.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: compiled from: Sets.java */
    class a<E> extends e<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f10012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f10013b;

        /* JADX INFO: renamed from: com.google.common.collect.c1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Sets.java */
        class C0220a extends com.google.common.collect.b<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Iterator<E> f10014c;

            C0220a() {
                this.f10014c = a.this.f10012a.iterator();
            }

            @Override // com.google.common.collect.b
            protected E a() {
                while (this.f10014c.hasNext()) {
                    E next = this.f10014c.next();
                    if (a.this.f10013b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super(null);
            this.f10012a = set;
            this.f10013b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i1<E> iterator() {
            return new C0220a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f10012a.contains(obj) && this.f10013b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f10012a.containsAll(collection) && this.f10013b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f10013b, this.f10012a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f10012a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (this.f10013b.contains(it.next())) {
                    i10++;
                }
            }
            return i10;
        }
    }

    /* JADX INFO: compiled from: Sets.java */
    private static class b<E> extends l.a<E> implements Set<E> {
        b(Set<E> set, e5.p<? super E> pVar) {
            super(set, pVar);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return c1.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return c1.d(this);
        }
    }

    /* JADX INFO: compiled from: Sets.java */
    private static class c<E> extends b<E> implements SortedSet<E> {
        c(SortedSet<E> sortedSet, e5.p<? super E> pVar) {
            super(sortedSet, pVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.f10086a).comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) h0.k(this.f10086a.iterator(), this.f10087b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e10) {
            return new c(((SortedSet) this.f10086a).headSet(e10), this.f10087b);
        }

        @Override // java.util.SortedSet
        public E last() {
            SortedSet sortedSetHeadSet = (SortedSet) this.f10086a;
            while (true) {
                E e10 = (Object) sortedSetHeadSet.last();
                if (this.f10087b.apply(e10)) {
                    return e10;
                }
                sortedSetHeadSet = sortedSetHeadSet.headSet(e10);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e10, E e11) {
            return new c(((SortedSet) this.f10086a).subSet(e10, e11), this.f10087b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e10) {
            return new c(((SortedSet) this.f10086a).tailSet(e10), this.f10087b);
        }
    }

    /* JADX INFO: compiled from: Sets.java */
    static abstract class d<E> extends AbstractSet<E> {
        d() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return c1.i(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) e5.o.j(collection));
        }
    }

    /* JADX INFO: compiled from: Sets.java */
    public static abstract class e<E> extends AbstractSet<E> {
        /* synthetic */ e(b1 b1Var) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean add(E e10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        private e() {
        }
    }

    static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <E> Set<E> b(Set<E> set, e5.p<? super E> pVar) {
        if (set instanceof SortedSet) {
            return c((SortedSet) set, pVar);
        }
        if (!(set instanceof b)) {
            return new b((Set) e5.o.j(set), (e5.p) e5.o.j(pVar));
        }
        b bVar = (b) set;
        return new b((Set) bVar.f10086a, e5.q.b(bVar.f10087b, pVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> c(SortedSet<E> sortedSet, e5.p<? super E> pVar) {
        if (!(sortedSet instanceof b)) {
            return new c((SortedSet) e5.o.j(sortedSet), (e5.p) e5.o.j(pVar));
        }
        b bVar = (b) sortedSet;
        return new c((SortedSet) bVar.f10086a, e5.q.b(bVar.f10087b, pVar));
    }

    static int d(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i10 = ~(~(i10 + (next != null ? next.hashCode() : 0)));
        }
        return i10;
    }

    public static <E> e<E> e(Set<E> set, Set<?> set2) {
        e5.o.k(set, "set1");
        e5.o.k(set2, "set2");
        return new a(set, set2);
    }

    public static <E> HashSet<E> f() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> g(int i10) {
        return new HashSet<>(k0.a(i10));
    }

    public static <E> Set<E> h() {
        return Collections.newSetFromMap(k0.i());
    }

    static boolean i(Set<?> set, Collection<?> collection) {
        e5.o.j(collection);
        if (collection instanceof o0) {
            collection = ((o0) collection).elementSet();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? j(set, collection.iterator()) : h0.r(set.iterator(), collection);
    }

    static boolean j(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
