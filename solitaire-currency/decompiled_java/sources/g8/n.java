package g8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DelegatingMutableSet.kt */
/* JADX INFO: loaded from: classes.dex */
public class n<From, To> implements Set<To>, i9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Set<From> f25897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.l<From, To> f25898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final h9.l<To, From> f25899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f25900d;

    /* JADX INFO: compiled from: DelegatingMutableSet.kt */
    public static final class a implements Iterator<To>, i9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Iterator<From> f25901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<From, To> f25902b;

        a(n<From, To> nVar) {
            this.f25902b = nVar;
            this.f25901a = ((n) nVar).f25897a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25901a.hasNext();
        }

        @Override // java.util.Iterator
        public To next() {
            return (To) ((n) this.f25902b).f25898b.invoke(this.f25901a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f25901a.remove();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(@NotNull Set<From> delegate, @NotNull h9.l<? super From, ? extends To> convertTo, @NotNull h9.l<? super To, ? extends From> convert) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        kotlin.jvm.internal.t.i(convertTo, "convertTo");
        kotlin.jvm.internal.t.i(convert, "convert");
        this.f25897a = delegate;
        this.f25898b = convertTo;
        this.f25899c = convert;
        this.f25900d = delegate.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(To to) {
        return this.f25897a.add(this.f25899c.invoke(to));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends To> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return this.f25897a.addAll(e(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f25897a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.f25897a.contains(this.f25899c.invoke(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return this.f25897a.containsAll(e(elements));
    }

    @NotNull
    public Collection<From> e(@NotNull Collection<? extends To> collection) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        Collection<? extends To> collection2 = collection;
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f25899c.invoke(it.next()));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof Set)) {
            return false;
        }
        Collection<To> collectionF = f(this.f25897a);
        return ((Set) obj).containsAll(collectionF) && collectionF.containsAll((Collection) obj);
    }

    @NotNull
    public Collection<To> f(@NotNull Collection<? extends From> collection) {
        kotlin.jvm.internal.t.i(collection, "<this>");
        Collection<? extends From> collection2 = collection;
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f25898b.invoke(it.next()));
        }
        return arrayList;
    }

    public int g() {
        return this.f25900d;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.f25897a.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f25897a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<To> iterator() {
        return new a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.f25897a.remove(this.f25899c.invoke(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return this.f25897a.removeAll(e(elements));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        return this.f25897a.retainAll(e(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return g();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.j.a(this);
    }

    @NotNull
    public String toString() {
        return f(this.f25897a).toString();
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.t.i(array, "array");
        return (T[]) kotlin.jvm.internal.j.b(this, array);
    }
}
