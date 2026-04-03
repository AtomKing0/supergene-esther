package kotlin.collections;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: compiled from: AbstractMutableList.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class f<E> extends AbstractList<E> implements List<E>, i9.d {
    protected f() {
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i10, E e10);

    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i10) {
        return removeAt(i10);
    }

    public abstract E removeAt(int i10);

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i10, E e10);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
