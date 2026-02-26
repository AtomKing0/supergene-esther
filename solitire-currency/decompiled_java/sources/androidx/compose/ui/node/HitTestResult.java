package androidx.compose.ui.node;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.collections.o;
import kotlin.collections.v;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: HitTestResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HitTestResult<T> implements List<T>, i9.a {
    private int size;

    @NotNull
    private Object[] values = new Object[16];

    @NotNull
    private long[] distanceFromEdgeAndInLayer = new long[16];
    private int hitDepth = -1;

    /* JADX INFO: compiled from: HitTestResult.kt */
    private final class SubList implements List<T>, i9.a {
        private final int maxIndex;
        private final int minIndex;

        public SubList(int i10, int i11) {
            this.minIndex = i10;
            this.maxIndex = i11;
        }

        @Override // java.util.List
        public void add(int i10, T t10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends T> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return indexOf(obj) != -1;
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
            return (T) ((HitTestResult) HitTestResult.this).values[i10 + this.minIndex];
        }

        public final int getMaxIndex() {
            return this.maxIndex;
        }

        public final int getMinIndex() {
            return this.minIndex;
        }

        public int getSize() {
            return this.maxIndex - this.minIndex;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i10 = this.minIndex;
            int i11 = this.maxIndex;
            if (i10 > i11) {
                return -1;
            }
            while (!t.d(((HitTestResult) HitTestResult.this).values[i10], obj)) {
                if (i10 == i11) {
                    return -1;
                }
                i10++;
            }
            return i10 - this.minIndex;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            HitTestResult<T> hitTestResult = HitTestResult.this;
            int i10 = this.minIndex;
            return hitTestResult.new HitTestResultIterator(i10, i10, this.maxIndex);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i10 = this.maxIndex;
            int i11 = this.minIndex;
            if (i11 > i10) {
                return -1;
            }
            while (!t.d(((HitTestResult) HitTestResult.this).values[i10], obj)) {
                if (i10 == i11) {
                    return -1;
                }
                i10--;
            }
            return i10 - this.minIndex;
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<T> listIterator() {
            HitTestResult<T> hitTestResult = HitTestResult.this;
            int i10 = this.minIndex;
            return hitTestResult.new HitTestResultIterator(i10, i10, this.maxIndex);
        }

        @Override // java.util.List
        public T remove(int i10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<T> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public T set(int i10, T t10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public void sort(Comparator<? super T> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        @NotNull
        public List<T> subList(int i10, int i11) {
            HitTestResult<T> hitTestResult = HitTestResult.this;
            int i12 = this.minIndex;
            return hitTestResult.new SubList(i10 + i12, i12 + i11);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return j.a(this);
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<T> listIterator(int i10) {
            HitTestResult<T> hitTestResult = HitTestResult.this;
            int i11 = this.minIndex;
            return hitTestResult.new HitTestResultIterator(i10 + i11, i11, this.maxIndex);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            t.i(array, "array");
            return (T[]) j.b(this, array);
        }
    }

    private final void ensureContainerSize() {
        int i10 = this.hitDepth;
        Object[] objArr = this.values;
        if (i10 >= objArr.length) {
            int length = objArr.length + 16;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, length);
            t.h(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
            long[] jArrCopyOf = Arrays.copyOf(this.distanceFromEdgeAndInLayer, length);
            t.h(jArrCopyOf, "copyOf(this, newSize)");
            this.distanceFromEdgeAndInLayer = jArrCopyOf;
        }
    }

    /* JADX INFO: renamed from: findBestHitDistance-ptXAw2c, reason: not valid java name */
    private final long m3094findBestHitDistanceptXAw2c() {
        long jDistanceAndInLayer = HitTestResultKt.DistanceAndInLayer(Float.POSITIVE_INFINITY, false);
        int i10 = this.hitDepth + 1;
        int iM = v.m(this);
        if (i10 <= iM) {
            while (true) {
                long jM3055constructorimpl = DistanceAndInLayer.m3055constructorimpl(this.distanceFromEdgeAndInLayer[i10]);
                if (DistanceAndInLayer.m3054compareToS_HNhKs(jM3055constructorimpl, jDistanceAndInLayer) < 0) {
                    jDistanceAndInLayer = jM3055constructorimpl;
                }
                if (DistanceAndInLayer.m3058getDistanceimpl(jDistanceAndInLayer) < 0.0f && DistanceAndInLayer.m3060isInLayerimpl(jDistanceAndInLayer)) {
                    return jDistanceAndInLayer;
                }
                if (i10 == iM) {
                    break;
                }
                i10++;
            }
        }
        return jDistanceAndInLayer;
    }

    private final void resizeToHitDepth() {
        int i10 = this.hitDepth + 1;
        int iM = v.m(this);
        if (i10 <= iM) {
            while (true) {
                this.values[i10] = null;
                if (i10 == iM) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        this.size = this.hitDepth + 1;
    }

    public final void acceptHits() {
        this.hitDepth = size() - 1;
    }

    @Override // java.util.List
    public void add(int i10, T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.hitDepth = -1;
        resizeToHitDepth();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
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
        return (T) this.values[i10];
    }

    public int getSize() {
        return this.size;
    }

    public final boolean hasHit() {
        long jM3094findBestHitDistanceptXAw2c = m3094findBestHitDistanceptXAw2c();
        return DistanceAndInLayer.m3058getDistanceimpl(jM3094findBestHitDistanceptXAw2c) < 0.0f && DistanceAndInLayer.m3060isInLayerimpl(jM3094findBestHitDistanceptXAw2c);
    }

    public final void hit(T t10, boolean z10, @NotNull h9.a<k0> childHitTest) {
        t.i(childHitTest, "childHitTest");
        hitInMinimumTouchTarget(t10, -1.0f, z10, childHitTest);
    }

    public final void hitInMinimumTouchTarget(T t10, float f10, boolean z10, @NotNull h9.a<k0> childHitTest) {
        t.i(childHitTest, "childHitTest");
        int i10 = this.hitDepth;
        this.hitDepth = i10 + 1;
        ensureContainerSize();
        Object[] objArr = this.values;
        int i11 = this.hitDepth;
        objArr[i11] = t10;
        this.distanceFromEdgeAndInLayer[i11] = HitTestResultKt.DistanceAndInLayer(f10, z10);
        resizeToHitDepth();
        childHitTest.invoke();
        this.hitDepth = i10;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int iM = v.m(this);
        if (iM < 0) {
            return -1;
        }
        int i10 = 0;
        while (!t.d(this.values[i10], obj)) {
            if (i10 == iM) {
                return -1;
            }
            i10++;
        }
        return i10;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isHitInMinimumTouchTargetBetter(float f10, boolean z10) {
        if (this.hitDepth == v.m(this)) {
            return true;
        }
        return DistanceAndInLayer.m3054compareToS_HNhKs(m3094findBestHitDistanceptXAw2c(), HitTestResultKt.DistanceAndInLayer(f10, z10)) > 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        for (int iM = v.m(this); -1 < iM; iM--) {
            if (t.d(this.values[iM], obj)) {
                return iM;
            }
        }
        return -1;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public T remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<T> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public T set(int i10, T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void siblingHits(@NotNull h9.a<k0> block) {
        t.i(block, "block");
        int i10 = this.hitDepth;
        block.invoke();
        this.hitDepth = i10;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public void sort(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void speculativeHit(T t10, float f10, boolean z10, @NotNull h9.a<k0> childHitTest) {
        t.i(childHitTest, "childHitTest");
        if (this.hitDepth == v.m(this)) {
            hitInMinimumTouchTarget(t10, f10, z10, childHitTest);
            if (this.hitDepth + 1 == v.m(this)) {
                resizeToHitDepth();
                return;
            }
            return;
        }
        long jM3094findBestHitDistanceptXAw2c = m3094findBestHitDistanceptXAw2c();
        int i10 = this.hitDepth;
        this.hitDepth = v.m(this);
        hitInMinimumTouchTarget(t10, f10, z10, childHitTest);
        if (this.hitDepth + 1 < v.m(this) && DistanceAndInLayer.m3054compareToS_HNhKs(jM3094findBestHitDistanceptXAw2c, m3094findBestHitDistanceptXAw2c()) > 0) {
            int i11 = this.hitDepth + 1;
            int i12 = i10 + 1;
            Object[] objArr = this.values;
            o.i(objArr, objArr, i12, i11, size());
            long[] jArr = this.distanceFromEdgeAndInLayer;
            o.h(jArr, jArr, i12, i11, size());
            this.hitDepth = ((size() + i10) - this.hitDepth) - 1;
        }
        resizeToHitDepth();
        this.hitDepth = i10;
    }

    @Override // java.util.List
    @NotNull
    public List<T> subList(int i10, int i11) {
        return new SubList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return j.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator(int i10) {
        return new HitTestResultIterator(this, i10, 0, 0, 6, null);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        t.i(array, "array");
        return (T[]) j.b(this, array);
    }

    /* JADX INFO: compiled from: HitTestResult.kt */
    private final class HitTestResultIterator implements ListIterator<T>, i9.a {
        private int index;
        private final int maxIndex;
        private final int minIndex;

        public HitTestResultIterator(int i10, int i11, int i12) {
            this.index = i10;
            this.minIndex = i11;
            this.maxIndex = i12;
        }

        @Override // java.util.ListIterator
        public void add(T t10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final int getIndex() {
            return this.index;
        }

        public final int getMaxIndex() {
            return this.maxIndex;
        }

        public final int getMinIndex() {
            return this.minIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < this.maxIndex;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > this.minIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            Object[] objArr = ((HitTestResult) HitTestResult.this).values;
            int i10 = this.index;
            this.index = i10 + 1;
            return (T) objArr[i10];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index - this.minIndex;
        }

        @Override // java.util.ListIterator
        public T previous() {
            Object[] objArr = ((HitTestResult) HitTestResult.this).values;
            int i10 = this.index - 1;
            this.index = i10;
            return (T) objArr[i10];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return (this.index - this.minIndex) - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(T t10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }

        public /* synthetic */ HitTestResultIterator(HitTestResult hitTestResult, int i10, int i11, int i12, int i13, k kVar) {
            this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? hitTestResult.size() : i12);
        }
    }
}
