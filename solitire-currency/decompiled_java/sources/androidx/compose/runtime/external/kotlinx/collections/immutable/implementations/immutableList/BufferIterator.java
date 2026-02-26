package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BufferIterator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BufferIterator<T> extends AbstractListIterator<T> {

    @NotNull
    private final T[] buffer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferIterator(@NotNull T[] buffer, int i10, int i11) {
        super(i10, i11);
        t.i(buffer, "buffer");
        this.buffer = buffer;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T[] tArr = this.buffer;
        int index = getIndex();
        setIndex(index + 1);
        return tArr[index];
    }

    @Override // java.util.ListIterator
    public T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        T[] tArr = this.buffer;
        setIndex(getIndex() - 1);
        return tArr[getIndex()];
    }
}
