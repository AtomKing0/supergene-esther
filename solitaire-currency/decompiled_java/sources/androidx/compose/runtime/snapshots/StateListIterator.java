package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SnapshotStateList.kt */
/* JADX INFO: loaded from: classes.dex */
final class StateListIterator<T> implements ListIterator<T>, i9.a {
    private int index;

    @NotNull
    private final SnapshotStateList<T> list;
    private int modification;

    public StateListIterator(@NotNull SnapshotStateList<T> list, int i10) {
        t.i(list, "list");
        this.list = list;
        this.index = i10 - 1;
        this.modification = list.getModification$runtime_release();
    }

    private final void validateModification() {
        if (this.list.getModification$runtime_release() != this.modification) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public void add(T t10) {
        validateModification();
        this.list.add(this.index + 1, t10);
        this.index++;
        this.modification = this.list.getModification$runtime_release();
    }

    @NotNull
    public final SnapshotStateList<T> getList() {
        return this.list;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.index < this.list.size() - 1;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.index >= 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        validateModification();
        int i10 = this.index + 1;
        SnapshotStateListKt.validateRange(i10, this.list.size());
        T t10 = this.list.get(i10);
        this.index = i10;
        return t10;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index + 1;
    }

    @Override // java.util.ListIterator
    public T previous() {
        validateModification();
        SnapshotStateListKt.validateRange(this.index, this.list.size());
        this.index--;
        return this.list.get(this.index);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.index;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        validateModification();
        this.list.remove(this.index);
        this.index--;
        this.modification = this.list.getModification$runtime_release();
    }

    @Override // java.util.ListIterator
    public void set(T t10) {
        validateModification();
        this.list.set(this.index, t10);
        this.modification = this.list.getModification$runtime_release();
    }
}
