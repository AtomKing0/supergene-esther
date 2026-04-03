package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import h9.l;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentVector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentVector<E> extends AbstractPersistentList<E> {

    @NotNull
    private final Object[] root;
    private final int rootShift;
    private final int size;

    @NotNull
    private final Object[] tail;

    public PersistentVector(@NotNull Object[] root, @NotNull Object[] tail, int i10, int i11) {
        t.i(root, "root");
        t.i(tail, "tail");
        this.root = root;
        this.tail = tail;
        this.size = i10;
        this.rootShift = i11;
        if (size() > 32) {
            CommonFunctionsKt.m1270assert(size() - UtilsKt.rootSize(size()) <= o.j(tail.length, 32));
            return;
        }
        throw new IllegalArgumentException(("Trie-based persistent vector should have at least 33 elements, got " + size()).toString());
    }

    private final Object[] bufferFor(int i10) {
        if (rootSize() <= i10) {
            return this.tail;
        }
        Object[] objArr = this.root;
        for (int i11 = this.rootShift; i11 > 0; i11 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.indexSegment(i10, i11)];
            if (objArr2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr = objArr2;
        }
        return objArr;
    }

    private final Object[] insertIntoRoot(Object[] objArr, int i10, int i11, Object obj, ObjectRef objectRef) {
        Object[] objArrCopyOf;
        int iIndexSegment = UtilsKt.indexSegment(i11, i10);
        if (i10 == 0) {
            if (iIndexSegment == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                t.h(objArrCopyOf, "copyOf(this, newSize)");
            }
            kotlin.collections.o.i(objArr, objArrCopyOf, iIndexSegment + 1, iIndexSegment, 31);
            objectRef.setValue(objArr[31]);
            objArrCopyOf[iIndexSegment] = obj;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        t.h(objArrCopyOf2, "copyOf(this, newSize)");
        int i12 = i10 - 5;
        Object obj2 = objArr[iIndexSegment];
        String str = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        objArrCopyOf2[iIndexSegment] = insertIntoRoot((Object[]) obj2, i12, i11, obj, objectRef);
        int i13 = iIndexSegment + 1;
        while (i13 < 32 && objArrCopyOf2[i13] != null) {
            Object obj3 = objArr[i13];
            if (obj3 == null) {
                throw new NullPointerException(str);
            }
            Object[] objArr2 = objArrCopyOf2;
            objArr2[i13] = insertIntoRoot((Object[]) obj3, i12, 0, objectRef.getValue(), objectRef);
            i13++;
            objArrCopyOf2 = objArr2;
            str = str;
        }
        return objArrCopyOf2;
    }

    private final PersistentVector<E> insertIntoTail(Object[] objArr, int i10, Object obj) {
        int size = size() - rootSize();
        Object[] objArrCopyOf = Arrays.copyOf(this.tail, 32);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        if (size < 32) {
            kotlin.collections.o.i(this.tail, objArrCopyOf, i10 + 1, i10, size);
            objArrCopyOf[i10] = obj;
            return new PersistentVector<>(objArr, objArrCopyOf, size() + 1, this.rootShift);
        }
        Object[] objArr2 = this.tail;
        Object obj2 = objArr2[31];
        kotlin.collections.o.i(objArr2, objArrCopyOf, i10 + 1, i10, size - 1);
        objArrCopyOf[i10] = obj;
        return pushFilledTail(objArr, objArrCopyOf, UtilsKt.presizedBufferWith(obj2));
    }

    private final Object[] pullLastBuffer(Object[] objArr, int i10, int i11, ObjectRef objectRef) {
        Object[] objArrPullLastBuffer;
        int iIndexSegment = UtilsKt.indexSegment(i11, i10);
        if (i10 == 5) {
            objectRef.setValue(objArr[iIndexSegment]);
            objArrPullLastBuffer = null;
        } else {
            Object obj = objArr[iIndexSegment];
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArrPullLastBuffer = pullLastBuffer((Object[]) obj, i10 - 5, i11, objectRef);
        }
        if (objArrPullLastBuffer == null && iIndexSegment == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        objArrCopyOf[iIndexSegment] = objArrPullLastBuffer;
        return objArrCopyOf;
    }

    private final PersistentList<E> pullLastBufferFromRoot(Object[] objArr, int i10, int i11) {
        if (i11 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
                t.h(objArr, "copyOf(this, newSize)");
            }
            return new SmallPersistentVector(objArr);
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArrPullLastBuffer = pullLastBuffer(objArr, i11, i10 - 1, objectRef);
        t.f(objArrPullLastBuffer);
        Object value = objectRef.getValue();
        if (value == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        Object[] objArr2 = (Object[]) value;
        if (objArrPullLastBuffer[1] != null) {
            return new PersistentVector(objArrPullLastBuffer, objArr2, i10, i11);
        }
        Object obj = objArrPullLastBuffer[0];
        if (obj != null) {
            return new PersistentVector((Object[]) obj, objArr2, i10, i11 - 5);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    private final PersistentVector<E> pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i10 = this.rootShift;
        if (size <= (1 << i10)) {
            return new PersistentVector<>(pushTail(objArr, i10, objArr2), objArr3, size() + 1, this.rootShift);
        }
        Object[] objArrPresizedBufferWith = UtilsKt.presizedBufferWith(objArr);
        int i11 = this.rootShift + 5;
        return new PersistentVector<>(pushTail(objArrPresizedBufferWith, i11, objArr2), objArr3, size() + 1, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object[] pushTail(java.lang.Object[] r4, int r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            int r0 = r3.size()
            int r0 = r0 + (-1)
            int r0 = androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt.indexSegment(r0, r5)
            r1 = 32
            if (r4 == 0) goto L19
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r1)
            java.lang.String r2 = "copyOf(this, newSize)"
            kotlin.jvm.internal.t.h(r4, r2)
            if (r4 != 0) goto L1b
        L19:
            java.lang.Object[] r4 = new java.lang.Object[r1]
        L1b:
            r1 = 5
            if (r5 != r1) goto L21
            r4[r0] = r6
            goto L2c
        L21:
            r2 = r4[r0]
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            int r5 = r5 - r1
            java.lang.Object[] r5 = r3.pushTail(r2, r5, r6)
            r4[r0] = r5
        L2c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVector.pushTail(java.lang.Object[], int, java.lang.Object[]):java.lang.Object[]");
    }

    private final Object[] removeFromRootAt(Object[] objArr, int i10, int i11, ObjectRef objectRef) {
        Object[] objArrCopyOf;
        int iIndexSegment = UtilsKt.indexSegment(i11, i10);
        if (i10 == 0) {
            if (iIndexSegment == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                t.h(objArrCopyOf, "copyOf(this, newSize)");
            }
            kotlin.collections.o.i(objArr, objArrCopyOf, iIndexSegment, iIndexSegment + 1, 32);
            objArrCopyOf[31] = objectRef.getValue();
            objectRef.setValue(objArr[iIndexSegment]);
            return objArrCopyOf;
        }
        int iIndexSegment2 = objArr[31] == null ? UtilsKt.indexSegment(rootSize() - 1, i10) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        t.h(objArrCopyOf2, "copyOf(this, newSize)");
        int i12 = i10 - 5;
        int i13 = iIndexSegment + 1;
        if (i13 <= iIndexSegment2) {
            while (true) {
                Object obj = objArrCopyOf2[iIndexSegment2];
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
                objArrCopyOf2[iIndexSegment2] = removeFromRootAt((Object[]) obj, i12, 0, objectRef);
                if (iIndexSegment2 == i13) {
                    break;
                }
                iIndexSegment2--;
            }
        }
        Object obj2 = objArrCopyOf2[iIndexSegment];
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        objArrCopyOf2[iIndexSegment] = removeFromRootAt((Object[]) obj2, i12, i11, objectRef);
        return objArrCopyOf2;
    }

    private final PersistentList<E> removeFromTailAt(Object[] objArr, int i10, int i11, int i12) {
        int size = size() - i10;
        CommonFunctionsKt.m1270assert(i12 < size);
        if (size == 1) {
            return pullLastBufferFromRoot(objArr, i10, i11);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.tail, 32);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        int i13 = size - 1;
        if (i12 < i13) {
            kotlin.collections.o.i(this.tail, objArrCopyOf, i12, i12 + 1, size);
        }
        objArrCopyOf[i13] = null;
        return new PersistentVector(objArr, objArrCopyOf, (i10 + size) - 1, i11);
    }

    private final int rootSize() {
        return UtilsKt.rootSize(size());
    }

    private final Object[] setInRoot(Object[] objArr, int i10, int i11, Object obj) {
        int iIndexSegment = UtilsKt.indexSegment(i11, i10);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        if (i10 == 0) {
            objArrCopyOf[iIndexSegment] = obj;
        } else {
            Object obj2 = objArrCopyOf[iIndexSegment];
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArrCopyOf[iIndexSegment] = setInRoot((Object[]) obj2, i10 - 5, i11, obj);
        }
        return objArrCopyOf;
    }

    @Override // kotlin.collections.c, java.util.List
    public E get(int i10) {
        ListImplementation.checkElementIndex$runtime_release(i10, size());
        return (E) bufferFor(i10)[i10 & 31];
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.c, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i10) {
        ListImplementation.checkPositionIndex$runtime_release(i10, size());
        return new PersistentVectorIterator(this.root, this.tail, i10, size(), (this.rootShift / 5) + 1);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    @NotNull
    public PersistentList<E> removeAt(int i10) {
        ListImplementation.checkElementIndex$runtime_release(i10, size());
        int iRootSize = rootSize();
        return i10 >= iRootSize ? removeFromTailAt(this.root, iRootSize, this.rootShift, i10 - iRootSize) : removeFromTailAt(removeFromRootAt(this.root, this.rootShift, i10, new ObjectRef(this.tail[0])), iRootSize, this.rootShift, 0);
    }

    @Override // kotlin.collections.c, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    @NotNull
    public PersistentList<E> set(int i10, E e10) {
        ListImplementation.checkElementIndex$runtime_release(i10, size());
        if (rootSize() > i10) {
            return new PersistentVector(setInRoot(this.root, this.rootShift, i10, e10), this.tail, size(), this.rootShift);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.tail, 32);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        objArrCopyOf[i10 & 31] = e10;
        return new PersistentVector(this.root, objArrCopyOf, size(), this.rootShift);
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList<E> add(E e10) {
        int size = size() - rootSize();
        if (size >= 32) {
            return pushFilledTail(this.root, this.tail, UtilsKt.presizedBufferWith(e10));
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.tail, 32);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        objArrCopyOf[size] = e10;
        return new PersistentVector(this.root, objArrCopyOf, size() + 1, this.rootShift);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentList<E> removeAll(@NotNull l<? super E, Boolean> predicate) {
        t.i(predicate, "predicate");
        PersistentVectorBuilder<E> persistentVectorBuilderBuilder = builder();
        persistentVectorBuilderBuilder.removeAllWithPredicate(predicate);
        return persistentVectorBuilderBuilder.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    public PersistentVectorBuilder<E> builder() {
        return new PersistentVectorBuilder<>(this, this.root, this.tail, this.rootShift);
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    @NotNull
    public PersistentList<E> add(int i10, E e10) {
        ListImplementation.checkPositionIndex$runtime_release(i10, size());
        if (i10 == size()) {
            return add((Object) e10);
        }
        int iRootSize = rootSize();
        if (i10 >= iRootSize) {
            return insertIntoTail(this.root, i10 - iRootSize, e10);
        }
        ObjectRef objectRef = new ObjectRef(null);
        return insertIntoTail(insertIntoRoot(this.root, this.rootShift, i10, e10, objectRef), 0, objectRef.getValue());
    }
}
