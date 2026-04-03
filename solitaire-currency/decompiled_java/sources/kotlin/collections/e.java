package kotlin.collections;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: compiled from: AbstractMutableCollection.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e<E> extends AbstractCollection<E> implements Collection<E>, i9.b {
    protected e() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E e10);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
