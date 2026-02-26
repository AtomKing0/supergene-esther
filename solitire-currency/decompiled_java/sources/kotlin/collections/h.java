package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: compiled from: AbstractMutableSet.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class h<E> extends AbstractSet<E> implements Set<E>, i9.f {
    protected h() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e10);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
