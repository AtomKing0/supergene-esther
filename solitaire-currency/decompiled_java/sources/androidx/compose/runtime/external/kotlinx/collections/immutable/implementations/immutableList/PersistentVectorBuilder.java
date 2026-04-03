package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import h9.l;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.f;
import kotlin.collections.o;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistentVectorBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentVectorBuilder<E> extends f<E> implements PersistentList.Builder<E> {

    @NotNull
    private MutabilityOwnership ownership;

    @Nullable
    private Object[] root;
    private int rootShift;
    private int size;

    @NotNull
    private Object[] tail;

    @NotNull
    private PersistentList<? extends E> vector;

    @Nullable
    private Object[] vectorRoot;

    @NotNull
    private Object[] vectorTail;

    /* JADX INFO: renamed from: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder$removeAll$1, reason: invalid class name */
    /* JADX INFO: compiled from: PersistentVectorBuilder.kt */
    static final class AnonymousClass1 extends v implements l<E, Boolean> {
        final /* synthetic */ Collection<E> $elements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Collection<? extends E> collection) {
            super(1);
            this.$elements = collection;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.l
        @NotNull
        public final Boolean invoke(E e10) {
            return Boolean.valueOf(this.$elements.contains(e10));
        }
    }

    public PersistentVectorBuilder(@NotNull PersistentList<? extends E> vector, @Nullable Object[] objArr, @NotNull Object[] vectorTail, int i10) {
        t.i(vector, "vector");
        t.i(vectorTail, "vectorTail");
        this.vector = vector;
        this.vectorRoot = objArr;
        this.vectorTail = vectorTail;
        this.rootShift = i10;
        this.ownership = new MutabilityOwnership();
        this.root = this.vectorRoot;
        this.tail = this.vectorTail;
        this.size = this.vector.size();
    }

    private final Object[] bufferFor(int i10) {
        if (rootSize() <= i10) {
            return this.tail;
        }
        Object[] objArr = this.root;
        t.f(objArr);
        for (int i11 = this.rootShift; i11 > 0; i11 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.indexSegment(i10, i11)];
            if (objArr2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr = objArr2;
        }
        return objArr;
    }

    private final Object[] copyToBuffer(Object[] objArr, int i10, Iterator<? extends Object> it) {
        while (i10 < 32 && it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
        return objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object[] insertIntoRoot(java.lang.Object[] r9, int r10, int r11, java.lang.Object r12, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef r13) {
        /*
            r8 = this;
            int r0 = androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt.indexSegment(r11, r10)
            if (r10 != 0) goto L1a
            r10 = 31
            r11 = r9[r10]
            r13.setValue(r11)
            java.lang.Object[] r11 = r8.makeMutable(r9)
            int r13 = r0 + 1
            java.lang.Object[] r9 = kotlin.collections.l.i(r9, r11, r13, r0, r10)
            r9[r0] = r12
            return r9
        L1a:
            java.lang.Object[] r9 = r8.makeMutable(r9)
            int r10 = r10 + (-5)
            r1 = r9[r0]
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>"
            if (r1 == 0) goto L59
            r2 = r1
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r1 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            java.lang.Object[] r11 = r1.insertIntoRoot(r2, r3, r4, r5, r6)
            r9[r0] = r11
        L34:
            int r0 = r0 + 1
            r11 = 32
            if (r0 >= r11) goto L58
            r11 = r9[r0]
            if (r11 == 0) goto L58
            if (r11 == 0) goto L52
            r2 = r11
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r4 = 0
            java.lang.Object r5 = r13.getValue()
            r1 = r8
            r3 = r10
            r6 = r13
            java.lang.Object[] r11 = r1.insertIntoRoot(r2, r3, r4, r5, r6)
            r9[r0] = r11
            goto L34
        L52:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r7)
            throw r9
        L58:
            return r9
        L59:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder.insertIntoRoot(java.lang.Object[], int, int, java.lang.Object, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef):java.lang.Object[]");
    }

    private final void insertIntoTail(Object[] objArr, int i10, E e10) {
        int iTailSize = tailSize();
        Object[] objArrMakeMutable = makeMutable(this.tail);
        if (iTailSize < 32) {
            o.i(this.tail, objArrMakeMutable, i10 + 1, i10, iTailSize);
            objArrMakeMutable[i10] = e10;
            this.root = objArr;
            this.tail = objArrMakeMutable;
            this.size = size() + 1;
            return;
        }
        Object[] objArr2 = this.tail;
        Object obj = objArr2[31];
        o.i(objArr2, objArrMakeMutable, i10 + 1, i10, 31);
        objArrMakeMutable[i10] = e10;
        pushFilledTail(objArr, objArrMakeMutable, mutableBufferWith(obj));
    }

    private final boolean isMutable(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.ownership;
    }

    private final ListIterator<Object[]> leafBufferIterator(int i10) {
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int iRootSize = rootSize() >> 5;
        ListImplementation.checkPositionIndex$runtime_release(i10, iRootSize);
        int i11 = this.rootShift;
        if (i11 == 0) {
            Object[] objArr = this.root;
            t.f(objArr);
            return new SingleElementListIterator(objArr, i10);
        }
        Object[] objArr2 = this.root;
        t.f(objArr2);
        return new TrieIterator(objArr2, i10, iRootSize, i11 / 5);
    }

    private final Object[] makeMutable(Object[] objArr) {
        return objArr == null ? mutableBuffer() : isMutable(objArr) ? objArr : o.m(objArr, mutableBuffer(), 0, 0, n9.o.j(objArr.length, 32), 6, null);
    }

    private final Object[] makeMutableShiftingRight(Object[] objArr, int i10) {
        return isMutable(objArr) ? o.i(objArr, objArr, i10, 0, 32 - i10) : o.i(objArr, mutableBuffer(), i10, 0, 32 - i10);
    }

    private final Object[] mutableBuffer() {
        Object[] objArr = new Object[33];
        objArr[32] = this.ownership;
        return objArr;
    }

    private final Object[] mutableBufferWith(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.ownership;
        return objArr;
    }

    private final Object[] nullifyAfter(Object[] objArr, int i10, int i11) {
        if (!(i11 >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (i11 == 0) {
            return objArr;
        }
        int iIndexSegment = UtilsKt.indexSegment(i10, i11);
        Object obj = objArr[iIndexSegment];
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        Object objNullifyAfter = nullifyAfter((Object[]) obj, i10, i11 - 5);
        if (iIndexSegment < 31) {
            int i12 = iIndexSegment + 1;
            if (objArr[i12] != null) {
                if (isMutable(objArr)) {
                    o.s(objArr, null, i12, 32);
                }
                objArr = o.i(objArr, mutableBuffer(), 0, 0, i12);
            }
        }
        if (objNullifyAfter == objArr[iIndexSegment]) {
            return objArr;
        }
        Object[] objArrMakeMutable = makeMutable(objArr);
        objArrMakeMutable[iIndexSegment] = objNullifyAfter;
        return objArrMakeMutable;
    }

    private final Object[] pullLastBuffer(Object[] objArr, int i10, int i11, ObjectRef objectRef) {
        Object[] objArrPullLastBuffer;
        int iIndexSegment = UtilsKt.indexSegment(i11 - 1, i10);
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
        Object[] objArrMakeMutable = makeMutable(objArr);
        objArrMakeMutable[iIndexSegment] = objArrPullLastBuffer;
        return objArrMakeMutable;
    }

    private final void pullLastBufferFromRoot(Object[] objArr, int i10, int i11) {
        if (i11 == 0) {
            this.root = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.tail = objArr;
            this.size = i10;
            this.rootShift = i11;
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        t.f(objArr);
        Object[] objArrPullLastBuffer = pullLastBuffer(objArr, i11, i10, objectRef);
        t.f(objArrPullLastBuffer);
        Object value = objectRef.getValue();
        if (value == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        this.tail = (Object[]) value;
        this.size = i10;
        if (objArrPullLastBuffer[1] == null) {
            this.root = (Object[]) objArrPullLastBuffer[0];
            this.rootShift = i11 - 5;
        } else {
            this.root = objArrPullLastBuffer;
            this.rootShift = i11;
        }
    }

    private final Object[] pushBuffers(Object[] objArr, int i10, int i11, Iterator<Object[]> it) {
        if (!it.hasNext()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(i11 >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (i11 == 0) {
            return it.next();
        }
        Object[] objArrMakeMutable = makeMutable(objArr);
        int iIndexSegment = UtilsKt.indexSegment(i10, i11);
        int i12 = i11 - 5;
        objArrMakeMutable[iIndexSegment] = pushBuffers((Object[]) objArrMakeMutable[iIndexSegment], i10, i12, it);
        while (true) {
            iIndexSegment++;
            if (iIndexSegment >= 32 || !it.hasNext()) {
                break;
            }
            objArrMakeMutable[iIndexSegment] = pushBuffers((Object[]) objArrMakeMutable[iIndexSegment], 0, i12, it);
        }
        return objArrMakeMutable;
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] objArr, int i10, Object[][] objArr2) {
        Iterator<Object[]> itA = c.a(objArr2);
        int i11 = i10 >> 5;
        int i12 = this.rootShift;
        Object[] objArrPushBuffers = i11 < (1 << i12) ? pushBuffers(objArr, i10, i12, itA) : makeMutable(objArr);
        while (itA.hasNext()) {
            this.rootShift += 5;
            objArrPushBuffers = mutableBufferWith(objArrPushBuffers);
            int i13 = this.rootShift;
            pushBuffers(objArrPushBuffers, 1 << i13, i13, itA);
        }
        return objArrPushBuffers;
    }

    private final void pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i10 = this.rootShift;
        if (size > (1 << i10)) {
            this.root = pushTail(mutableBufferWith(objArr), objArr2, this.rootShift + 5);
            this.tail = objArr3;
            this.rootShift += 5;
            this.size = size() + 1;
            return;
        }
        if (objArr == null) {
            this.root = objArr2;
            this.tail = objArr3;
            this.size = size() + 1;
        } else {
            this.root = pushTail(objArr, objArr2, i10);
            this.tail = objArr3;
            this.size = size() + 1;
        }
    }

    private final Object[] pushTail(Object[] objArr, Object[] objArr2, int i10) {
        int iIndexSegment = UtilsKt.indexSegment(size() - 1, i10);
        Object[] objArrMakeMutable = makeMutable(objArr);
        if (i10 == 5) {
            objArrMakeMutable[iIndexSegment] = objArr2;
        } else {
            objArrMakeMutable[iIndexSegment] = pushTail((Object[]) objArrMakeMutable[iIndexSegment], objArr2, i10 - 5);
        }
        return objArrMakeMutable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int recyclableRemoveAll(l<? super E, Boolean> lVar, Object[] objArr, int i10, int i11, ObjectRef objectRef, List<Object[]> list, List<Object[]> list2) {
        if (isMutable(objArr)) {
            list.add(objArr);
        }
        Object value = objectRef.getValue();
        if (value == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        Object[] objArr2 = (Object[]) value;
        Object[] objArrRemove = objArr2;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (!lVar.invoke(obj).booleanValue()) {
                if (i11 == 32) {
                    objArrRemove = list.isEmpty() ^ true ? list.remove(list.size() - 1) : mutableBuffer();
                    i11 = 0;
                }
                objArrRemove[i11] = obj;
                i11++;
            }
        }
        objectRef.setValue(objArrRemove);
        if (objArr2 != objectRef.getValue()) {
            list2.add(objArr2);
        }
        return i11;
    }

    private final int removeAllFromTail(l<? super E, Boolean> lVar, int i10, ObjectRef objectRef) {
        int iRemoveAll = removeAll(lVar, this.tail, i10, objectRef);
        if (iRemoveAll == i10) {
            CommonFunctionsKt.m1270assert(objectRef.getValue() == this.tail);
            return i10;
        }
        Object value = objectRef.getValue();
        if (value == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        Object[] objArr = (Object[]) value;
        o.s(objArr, null, iRemoveAll, i10);
        this.tail = objArr;
        this.size = size() - (i10 - iRemoveAll);
        return iRemoveAll;
    }

    private final Object[] removeFromRootAt(Object[] objArr, int i10, int i11, ObjectRef objectRef) {
        int iIndexSegment = UtilsKt.indexSegment(i11, i10);
        if (i10 == 0) {
            Object obj = objArr[iIndexSegment];
            Object[] objArrI = o.i(objArr, makeMutable(objArr), iIndexSegment, iIndexSegment + 1, 32);
            objArrI[31] = objectRef.getValue();
            objectRef.setValue(obj);
            return objArrI;
        }
        int iIndexSegment2 = objArr[31] == null ? UtilsKt.indexSegment(rootSize() - 1, i10) : 31;
        Object[] objArrMakeMutable = makeMutable(objArr);
        int i12 = i10 - 5;
        int i13 = iIndexSegment + 1;
        if (i13 <= iIndexSegment2) {
            while (true) {
                Object obj2 = objArrMakeMutable[iIndexSegment2];
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
                objArrMakeMutable[iIndexSegment2] = removeFromRootAt((Object[]) obj2, i12, 0, objectRef);
                if (iIndexSegment2 == i13) {
                    break;
                }
                iIndexSegment2--;
            }
        }
        Object obj3 = objArrMakeMutable[iIndexSegment];
        if (obj3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        objArrMakeMutable[iIndexSegment] = removeFromRootAt((Object[]) obj3, i12, i11, objectRef);
        return objArrMakeMutable;
    }

    private final Object removeFromTailAt(Object[] objArr, int i10, int i11, int i12) {
        int size = size() - i10;
        CommonFunctionsKt.m1270assert(i12 < size);
        if (size == 1) {
            Object obj = this.tail[0];
            pullLastBufferFromRoot(objArr, i10, i11);
            return obj;
        }
        Object[] objArr2 = this.tail;
        Object obj2 = objArr2[i12];
        Object[] objArrI = o.i(objArr2, makeMutable(objArr2), i12, i12 + 1, size);
        objArrI[size - 1] = null;
        this.root = objArr;
        this.tail = objArrI;
        this.size = (i10 + size) - 1;
        this.rootShift = i11;
        return obj2;
    }

    private final Object[] retainFirst(Object[] objArr, int i10) {
        if (!((i10 & 31) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (i10 == 0) {
            this.rootShift = 0;
            return null;
        }
        int i11 = i10 - 1;
        while (true) {
            int i12 = this.rootShift;
            if ((i11 >> i12) != 0) {
                return nullifyAfter(objArr, i11, i12);
            }
            this.rootShift = i12 - 5;
            Object[] objArr2 = objArr[0];
            if (objArr2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr = objArr2;
        }
    }

    private final int rootSize() {
        if (size() <= 32) {
            return 0;
        }
        return UtilsKt.rootSize(size());
    }

    private final Object[] setInRoot(Object[] objArr, int i10, int i11, E e10, ObjectRef objectRef) {
        int iIndexSegment = UtilsKt.indexSegment(i11, i10);
        Object[] objArrMakeMutable = makeMutable(objArr);
        if (i10 == 0) {
            if (objArrMakeMutable != objArr) {
                ((AbstractList) this).modCount++;
            }
            objectRef.setValue(objArrMakeMutable[iIndexSegment]);
            objArrMakeMutable[iIndexSegment] = e10;
            return objArrMakeMutable;
        }
        Object obj = objArrMakeMutable[iIndexSegment];
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        objArrMakeMutable[iIndexSegment] = setInRoot((Object[]) obj, i10 - 5, i11, e10, objectRef);
        return objArrMakeMutable;
    }

    private final Object[] shiftLeafBuffers(int i10, int i11, Object[][] objArr, int i12, Object[] objArr2) {
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        ListIterator<Object[]> listIteratorLeafBufferIterator = leafBufferIterator(rootSize() >> 5);
        while (listIteratorLeafBufferIterator.previousIndex() != i10) {
            Object[] objArrPrevious = listIteratorLeafBufferIterator.previous();
            o.i(objArrPrevious, objArr2, 0, 32 - i11, 32);
            objArr2 = makeMutableShiftingRight(objArrPrevious, i11);
            i12--;
            objArr[i12] = objArr2;
        }
        return listIteratorLeafBufferIterator.previous();
    }

    private final void splitToBuffers(Collection<? extends E> collection, int i10, Object[] objArr, int i11, Object[][] objArr2, int i12, Object[] objArr3) {
        Object[] objArrMutableBuffer;
        if (!(i12 >= 1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Object[] objArrMakeMutable = makeMutable(objArr);
        objArr2[0] = objArrMakeMutable;
        int i13 = i10 & 31;
        int size = ((i10 + collection.size()) - 1) & 31;
        int i14 = (i11 - i13) + size;
        if (i14 < 32) {
            o.i(objArrMakeMutable, objArr3, size + 1, i13, i11);
        } else {
            int i15 = (i14 - 32) + 1;
            if (i12 == 1) {
                objArrMutableBuffer = objArrMakeMutable;
            } else {
                objArrMutableBuffer = mutableBuffer();
                i12--;
                objArr2[i12] = objArrMutableBuffer;
            }
            int i16 = i11 - i15;
            o.i(objArrMakeMutable, objArr3, 0, i16, i11);
            o.i(objArrMakeMutable, objArrMutableBuffer, size + 1, i13, i16);
            objArr3 = objArrMutableBuffer;
        }
        Iterator<? extends E> it = collection.iterator();
        copyToBuffer(objArrMakeMutable, i13, it);
        for (int i17 = 1; i17 < i12; i17++) {
            objArr2[i17] = copyToBuffer(mutableBuffer(), 0, it);
        }
        copyToBuffer(objArr3, 0, it);
    }

    private final int tailSize(int i10) {
        return i10 <= 32 ? i10 : i10 - UtilsKt.rootSize(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        ((AbstractList) this).modCount++;
        int iTailSize = tailSize();
        if (iTailSize < 32) {
            Object[] objArrMakeMutable = makeMutable(this.tail);
            objArrMakeMutable[iTailSize] = e10;
            this.tail = objArrMakeMutable;
            this.size = size() + 1;
        } else {
            pushFilledTail(this.root, this.tail, mutableBufferWith(e10));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        t.i(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int iTailSize = tailSize();
        Iterator<? extends E> it = elements.iterator();
        if (32 - iTailSize >= elements.size()) {
            this.tail = copyToBuffer(makeMutable(this.tail), iTailSize, it);
            this.size = size() + elements.size();
        } else {
            int size = ((elements.size() + iTailSize) - 1) / 32;
            Object[][] objArr = new Object[size][];
            objArr[0] = copyToBuffer(makeMutable(this.tail), iTailSize, it);
            for (int i10 = 1; i10 < size; i10++) {
                objArr[i10] = copyToBuffer(mutableBuffer(), 0, it);
            }
            this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), objArr);
            this.tail = copyToBuffer(mutableBuffer(), 0, it);
            this.size = size() + elements.size();
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        ListImplementation.checkElementIndex$runtime_release(i10, size());
        return (E) bufferFor(i10)[i10 & 31];
    }

    public final int getModCount$runtime_release() {
        return ((AbstractList) this).modCount;
    }

    @Nullable
    public final Object[] getRoot$runtime_release() {
        return this.root;
    }

    public final int getRootShift$runtime_release() {
        return this.rootShift;
    }

    @Override // kotlin.collections.f
    public int getSize() {
        return this.size;
    }

    @NotNull
    public final Object[] getTail$runtime_release() {
        return this.tail;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        return removeAllWithPredicate(new AnonymousClass1(elements));
    }

    public final boolean removeAllWithPredicate(@NotNull l<? super E, Boolean> predicate) {
        t.i(predicate, "predicate");
        boolean zRemoveAll = removeAll(predicate);
        if (zRemoveAll) {
            ((AbstractList) this).modCount++;
        }
        return zRemoveAll;
    }

    @Override // kotlin.collections.f
    public E removeAt(int i10) {
        ListImplementation.checkElementIndex$runtime_release(i10, size());
        ((AbstractList) this).modCount++;
        int iRootSize = rootSize();
        if (i10 >= iRootSize) {
            return (E) removeFromTailAt(this.root, iRootSize, this.rootShift, i10 - iRootSize);
        }
        ObjectRef objectRef = new ObjectRef(this.tail[0]);
        Object[] objArr = this.root;
        t.f(objArr);
        removeFromTailAt(removeFromRootAt(objArr, this.rootShift, i10, objectRef), iRootSize, this.rootShift, 0);
        return (E) objectRef.getValue();
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public E set(int i10, E e10) {
        ListImplementation.checkElementIndex$runtime_release(i10, size());
        if (rootSize() > i10) {
            ObjectRef objectRef = new ObjectRef(null);
            Object[] objArr = this.root;
            t.f(objArr);
            this.root = setInRoot(objArr, this.rootShift, i10, e10, objectRef);
            return (E) objectRef.getValue();
        }
        Object[] objArrMakeMutable = makeMutable(this.tail);
        if (objArrMakeMutable != this.tail) {
            ((AbstractList) this).modCount++;
        }
        int i11 = i10 & 31;
        E e11 = (E) objArrMakeMutable[i11];
        objArrMakeMutable[i11] = e10;
        this.tail = objArrMakeMutable;
        return e11;
    }

    public final void setRootShift$runtime_release(int i10) {
        this.rootShift = i10;
    }

    private final boolean removeAll(l<? super E, Boolean> lVar) {
        Object[] objArrPushBuffers;
        int iTailSize = tailSize();
        ObjectRef objectRef = new ObjectRef(null);
        if (this.root == null) {
            return removeAllFromTail(lVar, iTailSize, objectRef) != iTailSize;
        }
        ListIterator<Object[]> listIteratorLeafBufferIterator = leafBufferIterator(0);
        int iRemoveAll = 32;
        while (iRemoveAll == 32 && listIteratorLeafBufferIterator.hasNext()) {
            iRemoveAll = removeAll(lVar, listIteratorLeafBufferIterator.next(), 32, objectRef);
        }
        if (iRemoveAll == 32) {
            CommonFunctionsKt.m1270assert(!listIteratorLeafBufferIterator.hasNext());
            int iRemoveAllFromTail = removeAllFromTail(lVar, iTailSize, objectRef);
            if (iRemoveAllFromTail == 0) {
                pullLastBufferFromRoot(this.root, size(), this.rootShift);
            }
            return iRemoveAllFromTail != iTailSize;
        }
        int iPreviousIndex = listIteratorLeafBufferIterator.previousIndex() << 5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iRecyclableRemoveAll = iRemoveAll;
        while (listIteratorLeafBufferIterator.hasNext()) {
            iRecyclableRemoveAll = recyclableRemoveAll(lVar, listIteratorLeafBufferIterator.next(), 32, iRecyclableRemoveAll, objectRef, arrayList2, arrayList);
            iPreviousIndex = iPreviousIndex;
        }
        int i10 = iPreviousIndex;
        int iRecyclableRemoveAll2 = recyclableRemoveAll(lVar, this.tail, iTailSize, iRecyclableRemoveAll, objectRef, arrayList2, arrayList);
        Object value = objectRef.getValue();
        if (value == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        Object[] objArr = (Object[]) value;
        o.s(objArr, null, iRecyclableRemoveAll2, 32);
        if (arrayList.isEmpty()) {
            objArrPushBuffers = this.root;
            t.f(objArrPushBuffers);
        } else {
            objArrPushBuffers = pushBuffers(this.root, i10, this.rootShift, arrayList.iterator());
        }
        int size = i10 + (arrayList.size() << 5);
        this.root = retainFirst(objArrPushBuffers, size);
        this.tail = objArr;
        this.size = size + iRecyclableRemoveAll2;
        return true;
    }

    private final int tailSize() {
        return tailSize(size());
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    @NotNull
    public PersistentList<E> build() {
        PersistentVector persistentVector;
        if (this.root == this.vectorRoot && this.tail == this.vectorTail) {
            persistentVector = this.vector;
        } else {
            this.ownership = new MutabilityOwnership();
            Object[] objArr = this.root;
            this.vectorRoot = objArr;
            Object[] objArr2 = this.tail;
            this.vectorTail = objArr2;
            if (objArr == null) {
                if (objArr2.length == 0) {
                    persistentVector = UtilsKt.persistentVectorOf();
                } else {
                    Object[] objArrCopyOf = Arrays.copyOf(this.tail, size());
                    t.h(objArrCopyOf, "copyOf(this, newSize)");
                    persistentVector = new SmallPersistentVector(objArrCopyOf);
                }
            } else {
                Object[] objArr3 = this.root;
                t.f(objArr3);
                persistentVector = new PersistentVector(objArr3, this.tail, size(), this.rootShift);
            }
        }
        this.vector = persistentVector;
        return (PersistentList<E>) persistentVector;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i10) {
        ListImplementation.checkPositionIndex$runtime_release(i10, size());
        return new PersistentVectorMutableIterator(this, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public void add(int i10, E e10) {
        ListImplementation.checkPositionIndex$runtime_release(i10, size());
        if (i10 == size()) {
            add(e10);
            return;
        }
        ((AbstractList) this).modCount++;
        int iRootSize = rootSize();
        if (i10 >= iRootSize) {
            insertIntoTail(this.root, i10 - iRootSize, e10);
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.root;
        t.f(objArr);
        insertIntoTail(insertIntoRoot(objArr, this.rootShift, i10, e10, objectRef), 0, objectRef.getValue());
    }

    private final void insertIntoRoot(Collection<? extends E> collection, int i10, int i11, Object[][] objArr, int i12, Object[] objArr2) {
        if (this.root != null) {
            int i13 = i10 >> 5;
            Object[] objArrShiftLeafBuffers = shiftLeafBuffers(i13, i11, objArr, i12, objArr2);
            int iRootSize = i12 - (((rootSize() >> 5) - 1) - i13);
            if (iRootSize < i12) {
                objArr2 = objArr[iRootSize];
                t.f(objArr2);
            }
            splitToBuffers(collection, i10, objArrShiftLeafBuffers, 32, objArr, iRootSize, objArr2);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, @NotNull Collection<? extends E> elements) {
        Object[] objArrI;
        t.i(elements, "elements");
        ListImplementation.checkPositionIndex$runtime_release(i10, size());
        if (i10 == size()) {
            return addAll(elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i11 = (i10 >> 5) << 5;
        int size = (((size() - i11) + elements.size()) - 1) / 32;
        if (size == 0) {
            CommonFunctionsKt.m1270assert(i10 >= rootSize());
            int i12 = i10 & 31;
            int size2 = ((i10 + elements.size()) - 1) & 31;
            Object[] objArr = this.tail;
            Object[] objArrI2 = o.i(objArr, makeMutable(objArr), size2 + 1, i12, tailSize());
            copyToBuffer(objArrI2, i12, elements.iterator());
            this.tail = objArrI2;
            this.size = size() + elements.size();
            return true;
        }
        Object[][] objArr2 = new Object[size][];
        int iTailSize = tailSize();
        int iTailSize2 = tailSize(size() + elements.size());
        if (i10 >= rootSize()) {
            objArrI = mutableBuffer();
            splitToBuffers(elements, i10, this.tail, iTailSize, objArr2, size, objArrI);
        } else if (iTailSize2 <= iTailSize) {
            int i13 = iTailSize - iTailSize2;
            objArrI = o.i(this.tail, mutableBuffer(), 0, i13, iTailSize);
            int i14 = 32 - i13;
            Object[] objArrMakeMutableShiftingRight = makeMutableShiftingRight(this.tail, i14);
            int i15 = size - 1;
            objArr2[i15] = objArrMakeMutableShiftingRight;
            insertIntoRoot(elements, i10, i14, objArr2, i15, objArrMakeMutableShiftingRight);
        } else {
            int i16 = iTailSize2 - iTailSize;
            objArrI = makeMutableShiftingRight(this.tail, i16);
            insertIntoRoot(elements, i10, i16, objArr2, size, objArrI);
        }
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, i11, objArr2);
        this.tail = objArrI;
        this.size = size() + elements.size();
        return true;
    }

    private final int removeAll(l<? super E, Boolean> lVar, Object[] objArr, int i10, ObjectRef objectRef) {
        Object[] objArrMakeMutable = objArr;
        int i11 = i10;
        boolean z10 = false;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (lVar.invoke(obj).booleanValue()) {
                if (!z10) {
                    objArrMakeMutable = makeMutable(objArr);
                    z10 = true;
                    i11 = i12;
                }
            } else if (z10) {
                objArrMakeMutable[i11] = obj;
                i11++;
            }
        }
        objectRef.setValue(objArrMakeMutable);
        return i11;
    }
}
