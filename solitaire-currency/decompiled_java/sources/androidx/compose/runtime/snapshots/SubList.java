package androidx.compose.runtime.snapshots;

import i9.d;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import v8.h;

/* JADX INFO: compiled from: SnapshotStateList.kt */
/* JADX INFO: loaded from: classes.dex */
final class SubList<T> implements List<T>, d {
    private int modification;
    private final int offset;

    @NotNull
    private final SnapshotStateList<T> parentList;
    private int size;

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SubList$listIterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnapshotStateList.kt */
    public static final class AnonymousClass1 implements ListIterator<T>, i9.a {
        final /* synthetic */ l0 $current;
        final /* synthetic */ SubList<T> this$0;

        AnonymousClass1(l0 l0Var, SubList<T> subList) {
            this.$current = l0Var;
            this.this$0 = subList;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.$current.f29831a < this.this$0.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.$current.f29831a >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            int i10 = this.$current.f29831a + 1;
            SnapshotStateListKt.validateRange(i10, this.this$0.size());
            this.$current.f29831a = i10;
            return this.this$0.get(i10);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.$current.f29831a + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int i10 = this.$current.f29831a;
            SnapshotStateListKt.validateRange(i10, this.this$0.size());
            this.$current.f29831a = i10 - 1;
            return this.this$0.get(i10);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.$current.f29831a;
        }

        @Override // java.util.ListIterator
        @NotNull
        public Void add(T t10) {
            SnapshotStateListKt.modificationError();
            throw new h();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @NotNull
        public Void remove() {
            SnapshotStateListKt.modificationError();
            throw new h();
        }

        @Override // java.util.ListIterator
        @NotNull
        public Void set(T t10) {
            SnapshotStateListKt.modificationError();
            throw new h();
        }
    }

    public SubList(@NotNull SnapshotStateList<T> parentList, int i10, int i11) {
        t.i(parentList, "parentList");
        this.parentList = parentList;
        this.offset = i10;
        this.modification = parentList.getModification$runtime_release();
        this.size = i11 - i10;
    }

    private final void validateModification() {
        if (this.parentList.getModification$runtime_release() != this.modification) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t10) {
        validateModification();
        this.parentList.add(this.offset + size(), t10);
        this.size = size() + 1;
        this.modification = this.parentList.getModification$runtime_release();
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i10, @NotNull Collection<? extends T> elements) {
        t.i(elements, "elements");
        validateModification();
        boolean zAddAll = this.parentList.addAll(i10 + this.offset, elements);
        if (zAddAll) {
            this.size = size() + elements.size();
            this.modification = this.parentList.getModification$runtime_release();
        }
        return zAddAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() > 0) {
            validateModification();
            SnapshotStateList<T> snapshotStateList = this.parentList;
            int i10 = this.offset;
            snapshotStateList.removeRange(i10, size() + i10);
            this.size = 0;
            this.modification = this.parentList.getModification$runtime_release();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public T get(int i10) {
        validateModification();
        SnapshotStateListKt.validateRange(i10, size());
        return this.parentList.get(this.offset + i10);
    }

    @NotNull
    public final SnapshotStateList<T> getParentList() {
        return this.parentList;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        validateModification();
        int i10 = this.offset;
        Iterator<Integer> it = o.u(i10, size() + i10).iterator();
        while (it.hasNext()) {
            int iNextInt = ((kotlin.collections.l0) it).nextInt();
            if (t.d(obj, this.parentList.get(iNextInt))) {
                return iNextInt - this.offset;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        validateModification();
        int size = this.offset + size();
        do {
            size--;
            if (size < this.offset) {
                return -1;
            }
        } while (!t.d(obj, this.parentList.get(size)));
        return size - this.offset;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i10) {
        return removeAt(i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    public T removeAt(int i10) {
        validateModification();
        T tRemove = this.parentList.remove(this.offset + i10);
        this.size = size() - 1;
        this.modification = this.parentList.getModification$runtime_release();
        return tRemove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        validateModification();
        SnapshotStateList<T> snapshotStateList = this.parentList;
        int i10 = this.offset;
        int iRetainAllInRange$runtime_release = snapshotStateList.retainAllInRange$runtime_release(elements, i10, size() + i10);
        if (iRetainAllInRange$runtime_release > 0) {
            this.modification = this.parentList.getModification$runtime_release();
            this.size = size() - iRetainAllInRange$runtime_release;
        }
        return iRetainAllInRange$runtime_release > 0;
    }

    @Override // java.util.List
    public T set(int i10, T t10) {
        SnapshotStateListKt.validateRange(i10, size());
        validateModification();
        T t11 = this.parentList.set(i10 + this.offset, t10);
        this.modification = this.parentList.getModification$runtime_release();
        return t11;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    @NotNull
    public List<T> subList(int i10, int i11) {
        if (!((i10 >= 0 && i10 <= i11) && i11 <= size())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        validateModification();
        SnapshotStateList<T> snapshotStateList = this.parentList;
        int i12 = this.offset;
        return new SubList(snapshotStateList, i10 + i12, i11 + i12);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return j.a(this);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator(int i10) {
        validateModification();
        l0 l0Var = new l0();
        l0Var.f29831a = i10 - 1;
        return new AnonymousClass1(l0Var, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        t.i(array, "array");
        return (T[]) j.b(this, array);
    }

    @Override // java.util.List
    public void add(int i10, T t10) {
        validateModification();
        this.parentList.add(this.offset + i10, t10);
        this.size = size() + 1;
        this.modification = this.parentList.getModification$runtime_release();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends T> elements) {
        t.i(elements, "elements");
        return addAll(size(), elements);
    }
}
