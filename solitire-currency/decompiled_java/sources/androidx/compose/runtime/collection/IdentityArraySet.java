package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import h9.l;
import i9.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.o;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: IdentityArraySet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IdentityArraySet<T> implements Set<T>, a {
    private int size;

    @NotNull
    private Object[] values = new Object[16];

    /* JADX INFO: renamed from: androidx.compose.runtime.collection.IdentityArraySet$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: IdentityArraySet.kt */
    public static final class AnonymousClass1 implements Iterator<T>, a {
        private int index;
        final /* synthetic */ IdentityArraySet<T> this$0;

        AnonymousClass1(IdentityArraySet<T> identityArraySet) {
            this.this$0 = identityArraySet;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.this$0.size();
        }

        @Override // java.util.Iterator
        @NotNull
        public T next() {
            Object[] values = this.this$0.getValues();
            int i10 = this.index;
            this.index = i10 + 1;
            T t10 = (T) values[i10];
            if (t10 != null) {
                return t10;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }
    }

    private final int find(Object obj) {
        int size = size() - 1;
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            T t10 = get(i11);
            int iIdentityHashCode2 = ActualJvm_jvmKt.identityHashCode(t10);
            if (iIdentityHashCode2 < iIdentityHashCode) {
                i10 = i11 + 1;
            } else {
                if (iIdentityHashCode2 <= iIdentityHashCode) {
                    return t10 == obj ? i11 : findExactIndex(i11, obj, iIdentityHashCode);
                }
                size = i11 - 1;
            }
        }
        return -(i10 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        return -(r3 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int findExactIndex(int r3, java.lang.Object r4, int r5) {
        /*
            r2 = this;
            int r0 = r3 + (-1)
        L2:
            r1 = -1
            if (r1 >= r0) goto L16
            java.lang.Object[] r1 = r2.values
            r1 = r1[r0]
            if (r1 != r4) goto Lc
            return r0
        Lc:
            int r1 = androidx.compose.runtime.ActualJvm_jvmKt.identityHashCode(r1)
            if (r1 == r5) goto L13
            goto L16
        L13:
            int r0 = r0 + (-1)
            goto L2
        L16:
            int r3 = r3 + 1
            int r0 = r2.size()
        L1c:
            if (r3 >= r0) goto L32
            java.lang.Object[] r1 = r2.values
            r1 = r1[r3]
            if (r1 != r4) goto L25
            return r3
        L25:
            int r1 = androidx.compose.runtime.ActualJvm_jvmKt.identityHashCode(r1)
            if (r1 == r5) goto L2f
        L2b:
            int r3 = r3 + 1
            int r3 = -r3
            return r3
        L2f:
            int r3 = r3 + 1
            goto L1c
        L32:
            int r3 = r2.size()
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityArraySet.findExactIndex(int, java.lang.Object, int):int");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(@NotNull T value) {
        int iFind;
        t.i(value, "value");
        if (size() > 0) {
            iFind = find(value);
            if (iFind >= 0) {
                return false;
            }
        } else {
            iFind = -1;
        }
        int i10 = -(iFind + 1);
        int size = size();
        Object[] objArr = this.values;
        if (size == objArr.length) {
            Object[] objArr2 = new Object[objArr.length * 2];
            o.i(objArr, objArr2, i10 + 1, i10, size());
            o.m(this.values, objArr2, 0, 0, i10, 6, null);
            this.values = objArr2;
        } else {
            o.i(objArr, objArr, i10 + 1, i10, size());
        }
        this.values[i10] = value;
        setSize(size() + 1);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            this.values[i10] = null;
        }
        setSize(0);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        return obj != null && find(obj) >= 0;
    }

    @Override // java.util.Set, java.util.Collection
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

    public final void forEach(@NotNull l<? super T, k0> block) {
        t.i(block, "block");
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            block.invoke(get(i10));
        }
    }

    @NotNull
    public final T get(int i10) {
        T t10 = (T) this.values[i10];
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isNotEmpty() {
        return size() > 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(@Nullable T t10) {
        int iFind;
        if (t10 == null || (iFind = find(t10)) < 0) {
            return false;
        }
        if (iFind < size() - 1) {
            Object[] objArr = this.values;
            o.i(objArr, objArr, iFind, iFind + 1, size());
        }
        setSize(size() - 1);
        this.values[size()] = null;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void removeValueIf(@NotNull l<? super T, Boolean> predicate) {
        t.i(predicate, "predicate");
        int size = size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = getValues()[i11];
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            }
            if (!predicate.invoke(obj).booleanValue()) {
                if (i10 != i11) {
                    getValues()[i10] = obj;
                }
                i10++;
            }
        }
        int size2 = size();
        for (int i12 = i10; i12 < size2; i12++) {
            getValues()[i12] = null;
        }
        setSize(i10);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void setSize(int i10) {
        this.size = i10;
    }

    public final void setValues(@NotNull Object[] objArr) {
        t.i(objArr, "<set-?>");
        this.values = objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return j.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        t.i(array, "array");
        return (T[]) j.b(this, array);
    }

    public static /* synthetic */ void getValues$annotations() {
    }
}
