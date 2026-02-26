package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ArrayDeque.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k<E> extends f<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f29782d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Object[] f29783e = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f29784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private Object[] f29785b = f29783e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29786c;

    /* JADX INFO: compiled from: ArrayDeque.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final int a(int i10, int i11) {
            int i12 = i10 + (i10 >> 1);
            if (i12 - i11 < 0) {
                i12 = i11;
            }
            return i12 - 2147483639 > 0 ? i11 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i12;
        }
    }

    private final void a(int i10, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f29785b.length;
        while (i10 < length && it.hasNext()) {
            this.f29785b[i10] = it.next();
            i10++;
        }
        int i11 = this.f29784a;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f29785b[i12] = it.next();
        }
        this.f29786c = size() + collection.size();
    }

    private final void b(int i10) {
        Object[] objArr = new Object[i10];
        Object[] objArr2 = this.f29785b;
        o.i(objArr2, objArr, 0, this.f29784a, objArr2.length);
        Object[] objArr3 = this.f29785b;
        int length = objArr3.length;
        int i11 = this.f29784a;
        o.i(objArr3, objArr, length - i11, 0, i11);
        this.f29784a = 0;
        this.f29785b = objArr;
    }

    private final int e(int i10) {
        return i10 == 0 ? p.S(this.f29785b) : i10 - 1;
    }

    private final void f(int i10) {
        if (i10 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f29785b;
        if (i10 <= objArr.length) {
            return;
        }
        if (objArr == f29783e) {
            this.f29785b = new Object[n9.o.e(i10, 10)];
        } else {
            b(f29782d.a(objArr.length, i10));
        }
    }

    private final int g(int i10) {
        if (i10 == p.S(this.f29785b)) {
            return 0;
        }
        return i10 + 1;
    }

    private final int h(int i10) {
        return i10 < 0 ? i10 + this.f29785b.length : i10;
    }

    private final int i(int i10) {
        Object[] objArr = this.f29785b;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        addLast(e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        f(size() + elements.size());
        a(i(this.f29784a + size()), elements);
        return true;
    }

    public final void addFirst(E e10) {
        f(size() + 1);
        int iE = e(this.f29784a);
        this.f29784a = iE;
        this.f29785b[iE] = e10;
        this.f29786c = size() + 1;
    }

    public final void addLast(E e10) {
        f(size() + 1);
        this.f29785b[i(this.f29784a + size())] = e10;
        this.f29786c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int i10 = i(this.f29784a + size());
        int i11 = this.f29784a;
        if (i11 < i10) {
            o.s(this.f29785b, null, i11, i10);
        } else if (!isEmpty()) {
            Object[] objArr = this.f29785b;
            o.s(objArr, null, this.f29784a, objArr.length);
            o.s(this.f29785b, null, 0, i10);
        }
        this.f29784a = 0;
        this.f29786c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        c.Companion.b(i10, size());
        return (E) this.f29785b[i(this.f29784a + i10)];
    }

    @Override // kotlin.collections.f
    public int getSize() {
        return this.f29786c;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i10;
        int i11 = i(this.f29784a + size());
        int length = this.f29784a;
        if (length < i11) {
            while (length < i11) {
                if (kotlin.jvm.internal.t.d(obj, this.f29785b[length])) {
                    i10 = this.f29784a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < i11) {
            return -1;
        }
        int length2 = this.f29785b.length;
        while (true) {
            if (length >= length2) {
                for (int i12 = 0; i12 < i11; i12++) {
                    if (kotlin.jvm.internal.t.d(obj, this.f29785b[i12])) {
                        length = i12 + this.f29785b.length;
                        i10 = this.f29784a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.t.d(obj, this.f29785b[length])) {
                i10 = this.f29784a;
                break;
            }
            length++;
        }
        return length - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Nullable
    public final E j() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Nullable
    public final E k() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iS;
        int i10;
        int i11 = i(this.f29784a + size());
        int i12 = this.f29784a;
        if (i12 < i11) {
            iS = i11 - 1;
            if (i12 <= iS) {
                while (!kotlin.jvm.internal.t.d(obj, this.f29785b[iS])) {
                    if (iS != i12) {
                        iS--;
                    }
                }
                i10 = this.f29784a;
                return iS - i10;
            }
            return -1;
        }
        if (i12 > i11) {
            int i13 = i11 - 1;
            while (true) {
                if (-1 >= i13) {
                    iS = p.S(this.f29785b);
                    int i14 = this.f29784a;
                    if (i14 <= iS) {
                        while (!kotlin.jvm.internal.t.d(obj, this.f29785b[iS])) {
                            if (iS != i14) {
                                iS--;
                            }
                        }
                        i10 = this.f29784a;
                    }
                } else {
                    if (kotlin.jvm.internal.t.d(obj, this.f29785b[i13])) {
                        iS = i13 + this.f29785b.length;
                        i10 = this.f29784a;
                        break;
                    }
                    i13--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        int i10;
        kotlin.jvm.internal.t.i(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if ((this.f29785b.length == 0) == false) {
                int i11 = i(this.f29784a + size());
                int i12 = this.f29784a;
                if (i12 < i11) {
                    i10 = i12;
                    while (i12 < i11) {
                        Object obj = this.f29785b[i12];
                        if (!elements.contains(obj)) {
                            this.f29785b[i10] = obj;
                            i10++;
                        } else {
                            z10 = true;
                        }
                        i12++;
                    }
                    o.s(this.f29785b, null, i10, i11);
                } else {
                    int length = this.f29785b.length;
                    boolean z11 = false;
                    int i13 = i12;
                    while (i12 < length) {
                        Object[] objArr = this.f29785b;
                        Object obj2 = objArr[i12];
                        objArr[i12] = null;
                        if (!elements.contains(obj2)) {
                            this.f29785b[i13] = obj2;
                            i13++;
                        } else {
                            z11 = true;
                        }
                        i12++;
                    }
                    i10 = i(i13);
                    for (int i14 = 0; i14 < i11; i14++) {
                        Object[] objArr2 = this.f29785b;
                        Object obj3 = objArr2[i14];
                        objArr2[i14] = null;
                        if (!elements.contains(obj3)) {
                            this.f29785b[i10] = obj3;
                            i10 = g(i10);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    this.f29786c = h(i10 - this.f29784a);
                }
            }
        }
        return z10;
    }

    @Override // kotlin.collections.f
    public E removeAt(int i10) {
        c.Companion.b(i10, size());
        if (i10 == v.m(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        int i11 = i(this.f29784a + i10);
        E e10 = (E) this.f29785b[i11];
        if (i10 < (size() >> 1)) {
            int i12 = this.f29784a;
            if (i11 >= i12) {
                Object[] objArr = this.f29785b;
                o.i(objArr, objArr, i12 + 1, i12, i11);
            } else {
                Object[] objArr2 = this.f29785b;
                o.i(objArr2, objArr2, 1, 0, i11);
                Object[] objArr3 = this.f29785b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i13 = this.f29784a;
                o.i(objArr3, objArr3, i13 + 1, i13, objArr3.length - 1);
            }
            Object[] objArr4 = this.f29785b;
            int i14 = this.f29784a;
            objArr4[i14] = null;
            this.f29784a = g(i14);
        } else {
            int i15 = i(this.f29784a + v.m(this));
            if (i11 <= i15) {
                Object[] objArr5 = this.f29785b;
                o.i(objArr5, objArr5, i11, i11 + 1, i15 + 1);
            } else {
                Object[] objArr6 = this.f29785b;
                o.i(objArr6, objArr6, i11, i11 + 1, objArr6.length);
                Object[] objArr7 = this.f29785b;
                objArr7[objArr7.length - 1] = objArr7[0];
                o.i(objArr7, objArr7, 0, 1, i15 + 1);
            }
            this.f29785b[i15] = null;
        }
        this.f29786c = size() - 1;
        return e10;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f29785b;
        int i10 = this.f29784a;
        E e10 = (E) objArr[i10];
        objArr[i10] = null;
        this.f29784a = g(i10);
        this.f29786c = size() - 1;
        return e10;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int i10 = i(this.f29784a + v.m(this));
        Object[] objArr = this.f29785b;
        E e10 = (E) objArr[i10];
        objArr[i10] = null;
        this.f29786c = size() - 1;
        return e10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        int i10;
        kotlin.jvm.internal.t.i(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty()) {
            if ((this.f29785b.length == 0) == false) {
                int i11 = i(this.f29784a + size());
                int i12 = this.f29784a;
                if (i12 < i11) {
                    i10 = i12;
                    while (i12 < i11) {
                        Object obj = this.f29785b[i12];
                        if (elements.contains(obj)) {
                            this.f29785b[i10] = obj;
                            i10++;
                        } else {
                            z10 = true;
                        }
                        i12++;
                    }
                    o.s(this.f29785b, null, i10, i11);
                } else {
                    int length = this.f29785b.length;
                    boolean z11 = false;
                    int i13 = i12;
                    while (i12 < length) {
                        Object[] objArr = this.f29785b;
                        Object obj2 = objArr[i12];
                        objArr[i12] = null;
                        if (elements.contains(obj2)) {
                            this.f29785b[i13] = obj2;
                            i13++;
                        } else {
                            z11 = true;
                        }
                        i12++;
                    }
                    i10 = i(i13);
                    for (int i14 = 0; i14 < i11; i14++) {
                        Object[] objArr2 = this.f29785b;
                        Object obj3 = objArr2[i14];
                        objArr2[i14] = null;
                        if (elements.contains(obj3)) {
                            this.f29785b[i10] = obj3;
                            i10 = g(i10);
                        } else {
                            z11 = true;
                        }
                    }
                    z10 = z11;
                }
                if (z10) {
                    this.f29786c = h(i10 - this.f29784a);
                }
            }
        }
        return z10;
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        c.Companion.b(i10, size());
        int i11 = i(this.f29784a + i10);
        Object[] objArr = this.f29785b;
        E e11 = (E) objArr[i11];
        objArr[i11] = e10;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.t.i(array, "array");
        if (array.length < size()) {
            array = (T[]) m.a(array, size());
        }
        int i10 = i(this.f29784a + size());
        int i11 = this.f29784a;
        if (i11 < i10) {
            o.m(this.f29785b, array, 0, i11, i10, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f29785b;
            o.i(objArr, array, 0, this.f29784a, objArr.length);
            Object[] objArr2 = this.f29785b;
            o.i(objArr2, array, objArr2.length - this.f29784a, 0, i10);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        c.Companion.c(i10, size());
        if (i10 == size()) {
            addLast(e10);
            return;
        }
        if (i10 == 0) {
            addFirst(e10);
            return;
        }
        f(size() + 1);
        int i11 = i(this.f29784a + i10);
        if (i10 < ((size() + 1) >> 1)) {
            int iE = e(i11);
            int iE2 = e(this.f29784a);
            int i12 = this.f29784a;
            if (iE >= i12) {
                Object[] objArr = this.f29785b;
                objArr[iE2] = objArr[i12];
                o.i(objArr, objArr, i12, i12 + 1, iE + 1);
            } else {
                Object[] objArr2 = this.f29785b;
                o.i(objArr2, objArr2, i12 - 1, i12, objArr2.length);
                Object[] objArr3 = this.f29785b;
                objArr3[objArr3.length - 1] = objArr3[0];
                o.i(objArr3, objArr3, 0, 1, iE + 1);
            }
            this.f29785b[iE] = e10;
            this.f29784a = iE2;
        } else {
            int i13 = i(this.f29784a + size());
            if (i11 < i13) {
                Object[] objArr4 = this.f29785b;
                o.i(objArr4, objArr4, i11 + 1, i11, i13);
            } else {
                Object[] objArr5 = this.f29785b;
                o.i(objArr5, objArr5, 1, 0, i13);
                Object[] objArr6 = this.f29785b;
                objArr6[0] = objArr6[objArr6.length - 1];
                o.i(objArr6, objArr6, i11 + 1, i11, objArr6.length - 1);
            }
            this.f29785b[i11] = e10;
        }
        this.f29786c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, @NotNull Collection<? extends E> elements) {
        kotlin.jvm.internal.t.i(elements, "elements");
        c.Companion.c(i10, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i10 == size()) {
            return addAll(elements);
        }
        f(size() + elements.size());
        int i11 = i(this.f29784a + size());
        int i12 = i(this.f29784a + i10);
        int size = elements.size();
        if (i10 < ((size() + 1) >> 1)) {
            int i13 = this.f29784a;
            int length = i13 - size;
            if (i12 < i13) {
                Object[] objArr = this.f29785b;
                o.i(objArr, objArr, length, i13, objArr.length);
                if (size >= i12) {
                    Object[] objArr2 = this.f29785b;
                    o.i(objArr2, objArr2, objArr2.length - size, 0, i12);
                } else {
                    Object[] objArr3 = this.f29785b;
                    o.i(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f29785b;
                    o.i(objArr4, objArr4, 0, size, i12);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f29785b;
                o.i(objArr5, objArr5, length, i13, i12);
            } else {
                Object[] objArr6 = this.f29785b;
                length += objArr6.length;
                int i14 = i12 - i13;
                int length2 = objArr6.length - length;
                if (length2 >= i14) {
                    o.i(objArr6, objArr6, length, i13, i12);
                } else {
                    o.i(objArr6, objArr6, length, i13, i13 + length2);
                    Object[] objArr7 = this.f29785b;
                    o.i(objArr7, objArr7, 0, this.f29784a + length2, i12);
                }
            }
            this.f29784a = length;
            a(h(i12 - size), elements);
        } else {
            int i15 = i12 + size;
            if (i12 < i11) {
                int i16 = size + i11;
                Object[] objArr8 = this.f29785b;
                if (i16 <= objArr8.length) {
                    o.i(objArr8, objArr8, i15, i12, i11);
                } else if (i15 >= objArr8.length) {
                    o.i(objArr8, objArr8, i15 - objArr8.length, i12, i11);
                } else {
                    int length3 = i11 - (i16 - objArr8.length);
                    o.i(objArr8, objArr8, 0, length3, i11);
                    Object[] objArr9 = this.f29785b;
                    o.i(objArr9, objArr9, i15, i12, length3);
                }
            } else {
                Object[] objArr10 = this.f29785b;
                o.i(objArr10, objArr10, size, 0, i11);
                Object[] objArr11 = this.f29785b;
                if (i15 >= objArr11.length) {
                    o.i(objArr11, objArr11, i15 - objArr11.length, i12, objArr11.length);
                } else {
                    o.i(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f29785b;
                    o.i(objArr12, objArr12, i15, i12, objArr12.length - size);
                }
            }
            a(i12, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
