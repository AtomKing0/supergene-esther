package w8;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final d<K, V> f35496a;

    public e(@NotNull d<K, V> backing) {
        t.i(backing, "backing");
        this.f35496a = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends Map.Entry<K, V>> elements) {
        t.i(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f35496a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        return this.f35496a.n(elements);
    }

    @Override // w8.a
    public boolean containsEntry(@NotNull Map.Entry<? extends K, ? extends V> element) {
        t.i(element, "element");
        return this.f35496a.o(element);
    }

    @Override // kotlin.collections.h
    public int getSize() {
        return this.f35496a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f35496a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f35496a.s();
    }

    @Override // w8.a
    public boolean remove(@NotNull Map.Entry element) {
        t.i(element, "element");
        return this.f35496a.H(element);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        this.f35496a.l();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        this.f35496a.l();
        return super.retainAll(elements);
    }

    @Override // kotlin.collections.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(@NotNull Map.Entry<K, V> element) {
        t.i(element, "element");
        throw new UnsupportedOperationException();
    }
}
