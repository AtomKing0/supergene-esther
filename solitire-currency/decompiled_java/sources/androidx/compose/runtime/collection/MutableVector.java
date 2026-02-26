package androidx.compose.runtime.collection;

import androidx.compose.runtime.internal.StabilityInferred;
import h9.l;
import h9.p;
import h9.q;
import i9.a;
import i9.d;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.o;
import kotlin.collections.v;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.t;
import n9.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import v8.k0;

/* JADX INFO: compiled from: MutableVector.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class MutableVector<T> implements RandomAccess {
    public static final int $stable = 8;

    @NotNull
    private T[] content;

    @Nullable
    private List<T> list;
    private int size;

    /* JADX INFO: compiled from: MutableVector.kt */
    private static final class MutableVectorList<T> implements List<T>, d {

        @NotNull
        private final MutableVector<T> vector;

        public MutableVectorList(@NotNull MutableVector<T> vector) {
            t.i(vector, "vector");
            this.vector = vector;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t10) {
            return this.vector.add(t10);
        }

        @Override // java.util.List
        public boolean addAll(int i10, @NotNull Collection<? extends T> elements) {
            t.i(elements, "elements");
            return this.vector.addAll(i10, elements);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.vector.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.vector.contains(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(@NotNull Collection<? extends Object> elements) {
            t.i(elements, "elements");
            return this.vector.containsAll(elements);
        }

        @Override // java.util.List
        public T get(int i10) {
            MutableVectorKt.checkIndex(this, i10);
            return this.vector.getContent()[i10];
        }

        public int getSize() {
            return this.vector.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.vector.indexOf(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.vector.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.vector.lastIndexOf(obj);
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i10) {
            return removeAt(i10);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(@NotNull Collection<? extends Object> elements) {
            t.i(elements, "elements");
            return this.vector.removeAll(elements);
        }

        public T removeAt(int i10) {
            MutableVectorKt.checkIndex(this, i10);
            return this.vector.removeAt(i10);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(@NotNull Collection<? extends Object> elements) {
            t.i(elements, "elements");
            return this.vector.retainAll(elements);
        }

        @Override // java.util.List
        public T set(int i10, T t10) {
            MutableVectorKt.checkIndex(this, i10);
            return this.vector.set(i10, t10);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        @NotNull
        public List<T> subList(int i10, int i11) {
            MutableVectorKt.checkSubIndex(this, i10, i11);
            return new SubList(this, i10, i11);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return j.a(this);
        }

        @Override // java.util.List
        public void add(int i10, T t10) {
            this.vector.add(i10, t10);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(@NotNull Collection<? extends T> elements) {
            t.i(elements, "elements");
            return this.vector.addAll(elements);
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<T> listIterator(int i10) {
            return new VectorListIterator(this, i10);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.vector.remove(obj);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            t.i(array, "array");
            return (T[]) j.b(this, array);
        }
    }

    /* JADX INFO: compiled from: MutableVector.kt */
    private static final class SubList<T> implements List<T>, d {
        private int end;

        @NotNull
        private final List<T> list;
        private final int start;

        public SubList(@NotNull List<T> list, int i10, int i11) {
            t.i(list, "list");
            this.list = list;
            this.start = i10;
            this.end = i11;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t10) {
            List<T> list = this.list;
            int i10 = this.end;
            this.end = i10 + 1;
            list.add(i10, t10);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i10, @NotNull Collection<? extends T> elements) {
            t.i(elements, "elements");
            this.list.addAll(i10 + this.start, elements);
            this.end += elements.size();
            return elements.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i10 = this.end - 1;
            int i11 = this.start;
            if (i11 <= i10) {
                while (true) {
                    this.list.remove(i10);
                    if (i10 == i11) {
                        break;
                    } else {
                        i10--;
                    }
                }
            }
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i10 = this.end;
            for (int i11 = this.start; i11 < i10; i11++) {
                if (t.d(this.list.get(i11), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(@NotNull Collection<? extends Object> elements) {
            t.i(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public T get(int i10) {
            MutableVectorKt.checkIndex(this, i10);
            return this.list.get(i10 + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i10 = this.end;
            for (int i11 = this.start; i11 < i10; i11++) {
                if (t.d(this.list.get(i11), obj)) {
                    return i11 - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.end == this.start;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i10 = this.end - 1;
            int i11 = this.start;
            if (i11 > i10) {
                return -1;
            }
            while (!t.d(this.list.get(i10), obj)) {
                if (i10 == i11) {
                    return -1;
                }
                i10--;
            }
            return i10 - this.start;
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i10) {
            return removeAt(i10);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(@NotNull Collection<? extends Object> elements) {
            t.i(elements, "elements");
            int i10 = this.end;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i10 != this.end;
        }

        public T removeAt(int i10) {
            MutableVectorKt.checkIndex(this, i10);
            this.end--;
            return this.list.remove(i10 + this.start);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(@NotNull Collection<? extends Object> elements) {
            t.i(elements, "elements");
            int i10 = this.end;
            int i11 = i10 - 1;
            int i12 = this.start;
            if (i12 <= i11) {
                while (true) {
                    if (!elements.contains(this.list.get(i11))) {
                        this.list.remove(i11);
                        this.end--;
                    }
                    if (i11 == i12) {
                        break;
                    }
                    i11--;
                }
            }
            return i10 != this.end;
        }

        @Override // java.util.List
        public T set(int i10, T t10) {
            MutableVectorKt.checkIndex(this, i10);
            return this.list.set(i10 + this.start, t10);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        @NotNull
        public List<T> subList(int i10, int i11) {
            MutableVectorKt.checkSubIndex(this, i10, i11);
            return new SubList(this, i10, i11);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return j.a(this);
        }

        @Override // java.util.List
        public void add(int i10, T t10) {
            this.list.add(i10 + this.start, t10);
            this.end++;
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<T> listIterator(int i10) {
            return new VectorListIterator(this, i10);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i10 = this.end;
            for (int i11 = this.start; i11 < i10; i11++) {
                if (t.d(this.list.get(i11), obj)) {
                    this.list.remove(i11);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            t.i(array, "array");
            return (T[]) j.b(this, array);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(@NotNull Collection<? extends T> elements) {
            t.i(elements, "elements");
            this.list.addAll(this.end, elements);
            this.end += elements.size();
            return elements.size() > 0;
        }
    }

    /* JADX INFO: compiled from: MutableVector.kt */
    private static final class VectorListIterator<T> implements ListIterator<T>, a {
        private int index;

        @NotNull
        private final List<T> list;

        public VectorListIterator(@NotNull List<T> list, int i10) {
            t.i(list, "list");
            this.list = list;
            this.index = i10;
        }

        @Override // java.util.ListIterator
        public void add(T t10) {
            this.list.add(this.index, t10);
            this.index++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < this.list.size();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i10 = this.index;
            this.index = i10 + 1;
            return list.get(i10);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int i10 = this.index - 1;
            this.index = i10;
            return this.list.get(i10);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i10 = this.index - 1;
            this.index = i10;
            this.list.remove(i10);
        }

        @Override // java.util.ListIterator
        public void set(T t10) {
            this.list.set(this.index, t10);
        }
    }

    public MutableVector(@NotNull T[] content, int i10) {
        t.i(content, "content");
        this.content = content;
        this.size = i10;
    }

    public final boolean add(T t10) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int i10 = this.size;
        tArr[i10] = t10;
        this.size = i10 + 1;
        return true;
    }

    public final boolean addAll(int i10, @NotNull List<? extends T> elements) {
        t.i(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + elements.size());
        T[] tArr = this.content;
        if (i10 != this.size) {
            o.i(tArr, tArr, elements.size() + i10, i10, this.size);
        }
        int size = elements.size();
        for (int i11 = 0; i11 < size; i11++) {
            tArr[i10 + i11] = elements.get(i11);
        }
        this.size += elements.size();
        return true;
    }

    public final boolean any(@NotNull l<? super T, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        if (size > 0) {
            T[] content = getContent();
            int i10 = 0;
            while (!predicate.invoke(content[i10]).booleanValue()) {
                i10++;
                if (i10 >= size) {
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    public final List<T> asMutableList() {
        List<T> list = this.list;
        if (list != null) {
            return list;
        }
        MutableVectorList mutableVectorList = new MutableVectorList(this);
        this.list = mutableVectorList;
        return mutableVectorList;
    }

    public final void clear() {
        T[] tArr = this.content;
        int size = getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                this.size = 0;
                return;
            }
            tArr[size] = null;
        }
    }

    public final boolean contains(T t10) {
        int size = getSize() - 1;
        if (size >= 0) {
            for (int i10 = 0; !t.d(getContent()[i10], t10); i10++) {
                if (i10 != size) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean containsAll(@NotNull List<? extends T> elements) {
        t.i(elements, "elements");
        int size = elements.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!contains(elements.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public final boolean contentEquals(@NotNull MutableVector<T> other) {
        t.i(other, "other");
        if (other.size != this.size) {
            return false;
        }
        int size = getSize() - 1;
        if (size >= 0) {
            for (int i10 = 0; t.d(other.getContent()[i10], getContent()[i10]); i10++) {
                if (i10 != size) {
                }
            }
            return false;
        }
        return true;
    }

    public final void ensureCapacity(int i10) {
        T[] tArr = this.content;
        if (tArr.length < i10) {
            T[] tArr2 = (T[]) Arrays.copyOf(tArr, Math.max(i10, tArr.length * 2));
            t.h(tArr2, "copyOf(this, newSize)");
            this.content = tArr2;
        }
    }

    public final T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return getContent()[0];
    }

    @Nullable
    public final T firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return getContent()[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> R fold(R r10, @NotNull p<? super R, ? super T, ? extends R> operation) {
        t.i(operation, "operation");
        int size = getSize();
        if (size > 0) {
            T[] content = getContent();
            int i10 = 0;
            do {
                r10 = operation.mo4invoke(r10, content[i10]);
                i10++;
            } while (i10 < size);
        }
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> R foldIndexed(R r10, @NotNull q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        t.i(operation, "operation");
        int size = getSize();
        if (size > 0) {
            T[] content = getContent();
            int i10 = 0;
            do {
                r10 = operation.invoke(Integer.valueOf(i10), r10, content[i10]);
                i10++;
            } while (i10 < size);
        }
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> R foldRight(R r10, @NotNull p<? super T, ? super R, ? extends R> operation) {
        t.i(operation, "operation");
        int size = getSize();
        if (size > 0) {
            int i10 = size - 1;
            T[] content = getContent();
            do {
                r10 = operation.mo4invoke(content[i10], r10);
                i10--;
            } while (i10 >= 0);
        }
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> R foldRightIndexed(R r10, @NotNull q<? super Integer, ? super T, ? super R, ? extends R> operation) {
        t.i(operation, "operation");
        int size = getSize();
        if (size > 0) {
            int i10 = size - 1;
            T[] content = getContent();
            do {
                r10 = operation.invoke(Integer.valueOf(i10), content[i10], r10);
                i10--;
            } while (i10 >= 0);
        }
        return r10;
    }

    public final void forEach(@NotNull l<? super T, k0> block) {
        t.i(block, "block");
        int size = getSize();
        if (size > 0) {
            T[] content = getContent();
            int i10 = 0;
            do {
                block.invoke(content[i10]);
                i10++;
            } while (i10 < size);
        }
    }

    public final void forEachIndexed(@NotNull p<? super Integer, ? super T, k0> block) {
        t.i(block, "block");
        int size = getSize();
        if (size > 0) {
            T[] content = getContent();
            int i10 = 0;
            do {
                block.mo4invoke(Integer.valueOf(i10), content[i10]);
                i10++;
            } while (i10 < size);
        }
    }

    public final void forEachReversed(@NotNull l<? super T, k0> block) {
        t.i(block, "block");
        int size = getSize();
        if (size > 0) {
            int i10 = size - 1;
            T[] content = getContent();
            do {
                block.invoke(content[i10]);
                i10--;
            } while (i10 >= 0);
        }
    }

    public final void forEachReversedIndexed(@NotNull p<? super Integer, ? super T, k0> block) {
        t.i(block, "block");
        if (getSize() > 0) {
            int size = getSize() - 1;
            T[] content = getContent();
            do {
                block.mo4invoke(Integer.valueOf(size), content[size]);
                size--;
            } while (size >= 0);
        }
    }

    public final T get(int i10) {
        return getContent()[i10];
    }

    @NotNull
    public final T[] getContent() {
        return this.content;
    }

    @NotNull
    public final i getIndices() {
        return new i(0, getSize() - 1);
    }

    public final int getLastIndex() {
        return getSize() - 1;
    }

    public final int getSize() {
        return this.size;
    }

    public final int indexOf(T t10) {
        int i10 = this.size;
        if (i10 <= 0) {
            return -1;
        }
        T[] tArr = this.content;
        int i11 = 0;
        while (!t.d(t10, tArr[i11])) {
            i11++;
            if (i11 >= i10) {
                return -1;
            }
        }
        return i11;
    }

    public final int indexOfFirst(@NotNull l<? super T, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        if (size <= 0) {
            return -1;
        }
        T[] content = getContent();
        int i10 = 0;
        while (!predicate.invoke(content[i10]).booleanValue()) {
            i10++;
            if (i10 >= size) {
                return -1;
            }
        }
        return i10;
    }

    public final int indexOfLast(@NotNull l<? super T, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        if (size <= 0) {
            return -1;
        }
        int i10 = size - 1;
        T[] content = getContent();
        while (!predicate.invoke(content[i10]).booleanValue()) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
        }
        return i10;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size != 0;
    }

    public final T last() {
        if (isEmpty()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return getContent()[getSize() - 1];
    }

    public final int lastIndexOf(T t10) {
        int i10 = this.size;
        if (i10 <= 0) {
            return -1;
        }
        int i11 = i10 - 1;
        T[] tArr = this.content;
        while (!t.d(t10, tArr[i11])) {
            i11--;
            if (i11 < 0) {
                return -1;
            }
        }
        return i11;
    }

    @Nullable
    public final T lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return getContent()[getSize() - 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> R[] map(l<? super T, ? extends R> transform) {
        t.i(transform, "transform");
        int size = getSize();
        t.o(0, "R");
        R[] rArr = (R[]) new Object[size];
        for (int i10 = 0; i10 < size; i10++) {
            rArr[i10] = transform.invoke(getContent()[i10]);
        }
        return rArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> R[] mapIndexed(p<? super Integer, ? super T, ? extends R> transform) {
        t.i(transform, "transform");
        int size = getSize();
        t.o(0, "R");
        R[] rArr = (R[]) new Object[size];
        for (int i10 = 0; i10 < size; i10++) {
            rArr[i10] = transform.mo4invoke(Integer.valueOf(i10), getContent()[i10]);
        }
        return rArr;
    }

    public final /* synthetic */ <R> MutableVector<R> mapIndexedNotNull(p<? super Integer, ? super T, ? extends R> transform) {
        t.i(transform, "transform");
        int size = getSize();
        int i10 = 0;
        t.o(0, "R?");
        Object[] objArr = new Object[size];
        if (size > 0) {
            T[] content = getContent();
            int i11 = 0;
            do {
                R rMo4invoke = transform.mo4invoke(Integer.valueOf(i10), content[i10]);
                if (rMo4invoke != null) {
                    objArr[i11] = rMo4invoke;
                    i11++;
                }
                i10++;
            } while (i10 < size);
            i10 = i11;
        }
        return new MutableVector<>(objArr, i10);
    }

    public final /* synthetic */ <R> MutableVector<R> mapNotNull(l<? super T, ? extends R> transform) {
        t.i(transform, "transform");
        int size = getSize();
        int i10 = 0;
        t.o(0, "R?");
        Object[] objArr = new Object[size];
        if (size > 0) {
            T[] content = getContent();
            int i11 = 0;
            do {
                R rInvoke = transform.invoke(content[i10]);
                if (rInvoke != null) {
                    objArr[i11] = rInvoke;
                    i11++;
                }
                i10++;
            } while (i10 < size);
            i10 = i11;
        }
        return new MutableVector<>(objArr, i10);
    }

    public final void minusAssign(T t10) {
        remove(t10);
    }

    public final void plusAssign(T t10) {
        add(t10);
    }

    public final boolean remove(T t10) {
        int iIndexOf = indexOf(t10);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(@NotNull List<? extends T> elements) {
        t.i(elements, "elements");
        int i10 = this.size;
        int size = elements.size();
        for (int i11 = 0; i11 < size; i11++) {
            remove(elements.get(i11));
        }
        return i10 != this.size;
    }

    public final T removeAt(int i10) {
        T[] tArr = this.content;
        T t10 = tArr[i10];
        if (i10 != getSize() - 1) {
            o.i(tArr, tArr, i10, i10 + 1, this.size);
        }
        int i11 = this.size - 1;
        this.size = i11;
        tArr[i11] = null;
        return t10;
    }

    public final void removeRange(int i10, int i11) {
        if (i11 > i10) {
            int i12 = this.size;
            if (i11 < i12) {
                T[] tArr = this.content;
                o.i(tArr, tArr, i10, i11, i12);
            }
            int i13 = this.size - (i11 - i10);
            int size = getSize() - 1;
            if (i13 <= size) {
                int i14 = i13;
                while (true) {
                    this.content[i14] = null;
                    if (i14 == size) {
                        break;
                    } else {
                        i14++;
                    }
                }
            }
            this.size = i13;
        }
    }

    public final boolean retainAll(@NotNull Collection<? extends T> elements) {
        t.i(elements, "elements");
        int i10 = this.size;
        for (int size = getSize() - 1; -1 < size; size--) {
            if (!elements.contains(getContent()[size])) {
                removeAt(size);
            }
        }
        return i10 != this.size;
    }

    public final boolean reversedAny(@NotNull l<? super T, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        if (size <= 0) {
            return false;
        }
        int i10 = size - 1;
        T[] content = getContent();
        while (!predicate.invoke(content[i10]).booleanValue()) {
            i10--;
            if (i10 < 0) {
                return false;
            }
        }
        return true;
    }

    public final T set(int i10, T t10) {
        T[] tArr = this.content;
        T t11 = tArr[i10];
        tArr[i10] = t10;
        return t11;
    }

    public final void setContent(@NotNull T[] tArr) {
        t.i(tArr, "<set-?>");
        this.content = tArr;
    }

    public final void sortWith(@NotNull Comparator<T> comparator) {
        t.i(comparator, "comparator");
        o.B(this.content, comparator, 0, this.size);
    }

    public final int sumBy(@NotNull l<? super T, Integer> selector) {
        t.i(selector, "selector");
        int size = getSize();
        int iIntValue = 0;
        if (size > 0) {
            T[] content = getContent();
            int i10 = 0;
            do {
                iIntValue += selector.invoke(content[i10]).intValue();
                i10++;
            } while (i10 < size);
        }
        return iIntValue;
    }

    @NotNull
    public final Void throwNoSuchElementException() {
        throw new NoSuchElementException("MutableVector contains no element matching the predicate.");
    }

    public final boolean containsAll(@NotNull Collection<? extends T> elements) {
        t.i(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final T firstOrNull(@NotNull l<? super T, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        if (size <= 0) {
            return null;
        }
        T[] content = getContent();
        int i10 = 0;
        do {
            T t10 = content[i10];
            if (predicate.invoke(t10).booleanValue()) {
                return t10;
            }
            i10++;
        } while (i10 < size);
        return null;
    }

    public final void add(int i10, T t10) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int i11 = this.size;
        if (i10 != i11) {
            o.i(tArr, tArr, i10 + 1, i10, i11);
        }
        tArr[i10] = t10;
        this.size++;
    }

    public final T first(@NotNull l<? super T, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        if (size > 0) {
            T[] content = getContent();
            int i10 = 0;
            do {
                T t10 = content[i10];
                if (predicate.invoke(t10).booleanValue()) {
                    return t10;
                }
                i10++;
            } while (i10 < size);
        }
        throwNoSuchElementException();
        throw new h();
    }

    @Nullable
    public final T lastOrNull(@NotNull l<? super T, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        if (size <= 0) {
            return null;
        }
        int i10 = size - 1;
        T[] content = getContent();
        do {
            T t10 = content[i10];
            if (predicate.invoke(t10).booleanValue()) {
                return t10;
            }
            i10--;
        } while (i10 >= 0);
        return null;
    }

    public final T last(@NotNull l<? super T, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = getSize();
        if (size > 0) {
            int i10 = size - 1;
            T[] content = getContent();
            do {
                T t10 = content[i10];
                if (predicate.invoke(t10).booleanValue()) {
                    return t10;
                }
                i10--;
            } while (i10 >= 0);
        }
        throwNoSuchElementException();
        throw new h();
    }

    public final boolean removeAll(@NotNull MutableVector<T> elements) {
        t.i(elements, "elements");
        int i10 = this.size;
        int size = elements.getSize() - 1;
        if (size >= 0) {
            int i11 = 0;
            while (true) {
                remove(elements.getContent()[i11]);
                if (i11 == size) {
                    break;
                }
                i11++;
            }
        }
        return i10 != this.size;
    }

    public final boolean containsAll(@NotNull MutableVector<T> elements) {
        t.i(elements, "elements");
        i iVar = new i(0, elements.getSize() - 1);
        int iB = iVar.b();
        int iE = iVar.e();
        if (iB <= iE) {
            while (contains(elements.getContent()[iB])) {
                if (iB != iE) {
                    iB++;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean removeAll(@NotNull Collection<? extends T> elements) {
        t.i(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        int i10 = this.size;
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return i10 != this.size;
    }

    public final boolean addAll(int i10, @NotNull MutableVector<T> elements) {
        t.i(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + elements.size);
        T[] tArr = this.content;
        int i11 = this.size;
        if (i10 != i11) {
            o.i(tArr, tArr, elements.size + i10, i10, i11);
        }
        o.i(elements.content, tArr, i10, 0, elements.size);
        this.size += elements.size;
        return true;
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public final boolean addAll(@NotNull List<? extends T> elements) {
        t.i(elements, "elements");
        return addAll(getSize(), (List) elements);
    }

    public final boolean addAll(@NotNull MutableVector<T> elements) {
        t.i(elements, "elements");
        return addAll(getSize(), elements);
    }

    public final boolean addAll(@NotNull T[] elements) {
        t.i(elements, "elements");
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(this.size + elements.length);
        o.m(elements, this.content, this.size, 0, 0, 12, null);
        this.size += elements.length;
        return true;
    }

    public final boolean addAll(int i10, @NotNull Collection<? extends T> elements) {
        t.i(elements, "elements");
        int i11 = 0;
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + elements.size());
        T[] tArr = this.content;
        if (i10 != this.size) {
            o.i(tArr, tArr, elements.size() + i10, i10, this.size);
        }
        for (T t10 : elements) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                v.u();
            }
            tArr[i11 + i10] = t10;
            i11 = i12;
        }
        this.size += elements.size();
        return true;
    }

    public final boolean addAll(@NotNull Collection<? extends T> elements) {
        t.i(elements, "elements");
        return addAll(this.size, elements);
    }
}
