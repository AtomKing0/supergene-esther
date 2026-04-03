package w8;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SetBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h<E> extends kotlin.collections.h<E> implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f35499b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final h f35500c = new h(d.f35477m.e());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final d<E, ?> f35501a;

    /* JADX INFO: compiled from: SetBuilder.kt */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public h(@NotNull d<E, ?> backing) {
        t.i(backing, "backing");
        this.f35501a = backing;
    }

    @NotNull
    public final Set<E> a() {
        this.f35501a.k();
        return size() > 0 ? this : f35500c;
    }

    @Override // kotlin.collections.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e10) {
        return this.f35501a.i(e10) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        this.f35501a.l();
        return super.addAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f35501a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f35501a.containsKey(obj);
    }

    @Override // kotlin.collections.h
    public int getSize() {
        return this.f35501a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f35501a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<E> iterator() {
        return this.f35501a.C();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f35501a.J(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        this.f35501a.l();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        this.f35501a.l();
        return super.retainAll(elements);
    }

    public h() {
        this(new d());
    }
}
