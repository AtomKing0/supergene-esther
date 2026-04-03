package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentVectorIterator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentVectorIterator<T> extends AbstractListIterator<T> {

    @NotNull
    private final T[] tail;

    @NotNull
    private final TrieIterator<T> trieIterator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentVectorIterator(@NotNull Object[] root, @NotNull T[] tail, int i10, int i11, int i12) {
        super(i10, i11);
        t.i(root, "root");
        t.i(tail, "tail");
        this.tail = tail;
        int iRootSize = UtilsKt.rootSize(i11);
        this.trieIterator = new TrieIterator<>(root, o.j(i10, iRootSize), iRootSize, i12);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public T next() {
        checkHasNext$runtime_release();
        if (this.trieIterator.hasNext()) {
            setIndex(getIndex() + 1);
            return this.trieIterator.next();
        }
        T[] tArr = this.tail;
        int index = getIndex();
        setIndex(index + 1);
        return tArr[index - this.trieIterator.getSize()];
    }

    @Override // java.util.ListIterator
    public T previous() {
        checkHasPrevious$runtime_release();
        if (getIndex() <= this.trieIterator.getSize()) {
            setIndex(getIndex() - 1);
            return this.trieIterator.previous();
        }
        T[] tArr = this.tail;
        setIndex(getIndex() - 1);
        return tArr[getIndex() - this.trieIterator.getSize()];
    }
}
