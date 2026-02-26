package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.collections.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TrieNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrieNode<E> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final TrieNode EMPTY = new TrieNode(0, new Object[0]);
    private int bitmap;

    @NotNull
    private Object[] buffer;

    @Nullable
    private MutabilityOwnership ownedBy;

    /* JADX INFO: compiled from: TrieNode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.EMPTY;
        }
    }

    public TrieNode(int i10, @NotNull Object[] buffer, @Nullable MutabilityOwnership mutabilityOwnership) {
        t.i(buffer, "buffer");
        this.bitmap = i10;
        this.buffer = buffer;
        this.ownedBy = mutabilityOwnership;
    }

    private final TrieNode<E> addElementAt(int i10, E e10) {
        return new TrieNode<>(i10 | this.bitmap, TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release(i10), e10));
    }

    private final int calculateSize() {
        if (this.bitmap == 0) {
            return this.buffer.length;
        }
        int iCalculateSize = 0;
        for (Object obj : this.buffer) {
            iCalculateSize += obj instanceof TrieNode ? ((TrieNode) obj).calculateSize() : 1;
        }
        return iCalculateSize;
    }

    private final TrieNode<E> collisionAdd(E e10) {
        return collisionContainsElement(e10) ? this : new TrieNode<>(0, TrieNodeKt.addElementAtIndex(this.buffer, 0, e10));
    }

    private final boolean collisionContainsElement(E e10) {
        return p.H(this.buffer, e10);
    }

    private final TrieNode<E> collisionRemove(E e10) {
        int iY = p.Y(this.buffer, e10);
        return iY != -1 ? collisionRemoveElementAtIndex(iY) : this;
    }

    private final TrieNode<E> collisionRemoveElementAtIndex(int i10) {
        return new TrieNode<>(0, TrieNodeKt.removeCellAtIndex(this.buffer, i10));
    }

    private final E elementAtIndex(int i10) {
        return (E) this.buffer[i10];
    }

    private final boolean elementsIdentityEquals(TrieNode<E> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.bitmap != trieNode.bitmap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (this.buffer[i10] != trieNode.buffer[i10]) {
                return false;
            }
        }
        return true;
    }

    private final boolean hasNoCellAt(int i10) {
        return (i10 & this.bitmap) == 0;
    }

    private final TrieNode<E> makeNode(int i10, E e10, int i11, E e11, int i12, MutabilityOwnership mutabilityOwnership) {
        if (i12 > 30) {
            return new TrieNode<>(0, new Object[]{e10, e11}, mutabilityOwnership);
        }
        int iIndexSegment = TrieNodeKt.indexSegment(i10, i12);
        int iIndexSegment2 = TrieNodeKt.indexSegment(i11, i12);
        if (iIndexSegment != iIndexSegment2) {
            return new TrieNode<>((1 << iIndexSegment) | (1 << iIndexSegment2), iIndexSegment < iIndexSegment2 ? new Object[]{e10, e11} : new Object[]{e11, e10}, mutabilityOwnership);
        }
        return new TrieNode<>(1 << iIndexSegment, new Object[]{makeNode(i10, e10, i11, e11, i12 + 5, mutabilityOwnership)}, mutabilityOwnership);
    }

    private final TrieNode<E> makeNodeAtIndex(int i10, int i11, E e10, int i12, MutabilityOwnership mutabilityOwnership) {
        E eElementAtIndex = elementAtIndex(i10);
        return makeNode(eElementAtIndex != null ? eElementAtIndex.hashCode() : 0, eElementAtIndex, i11, e10, i12 + 5, mutabilityOwnership);
    }

    private final TrieNode<E> moveElementToNode(int i10, int i11, E e10, int i12) {
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        t.h(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i10] = makeNodeAtIndex(i10, i11, e10, i12, null);
        return new TrieNode<>(this.bitmap, objArrCopyOf);
    }

    private final TrieNode<E> mutableAddElementAt(int i10, E e10, MutabilityOwnership mutabilityOwnership) {
        int iIndexOfCellAt$runtime_release = indexOfCellAt$runtime_release(i10);
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(i10 | this.bitmap, TrieNodeKt.addElementAtIndex(this.buffer, iIndexOfCellAt$runtime_release, e10), mutabilityOwnership);
        }
        this.buffer = TrieNodeKt.addElementAtIndex(this.buffer, iIndexOfCellAt$runtime_release, e10);
        this.bitmap = i10 | this.bitmap;
        return this;
    }

    private final TrieNode<E> mutableCollisionAdd(E e10, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        if (collisionContainsElement(e10)) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
        if (this.ownedBy != persistentHashSetBuilder.getOwnership$runtime_release()) {
            return new TrieNode<>(0, TrieNodeKt.addElementAtIndex(this.buffer, 0, e10), persistentHashSetBuilder.getOwnership$runtime_release());
        }
        this.buffer = TrieNodeKt.addElementAtIndex(this.buffer, 0, e10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<E> mutableCollisionAddAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        Object[] objArr2 = trieNode.buffer;
        int length = this.buffer.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < objArr2.length) {
            CommonFunctionsKt.m1270assert(i11 <= i10);
            if (!collisionContainsElement(objArr2[i10])) {
                objArrCopyOf[length + i11] = objArr2[i10];
                i11++;
                CommonFunctionsKt.m1270assert(length + i11 <= objArrCopyOf.length);
            }
            i10++;
        }
        int length2 = i11 + this.buffer.length;
        deltaCounter.plusAssign(objArrCopyOf.length - length2);
        if (length2 == this.buffer.length) {
            return this;
        }
        if (length2 == trieNode.buffer.length) {
            return trieNode;
        }
        if (length2 != objArrCopyOf.length) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, length2);
            t.h(objArrCopyOf, "copyOf(this, newSize)");
        }
        if (!t.d(this.ownedBy, mutabilityOwnership)) {
            return new TrieNode<>(0, objArrCopyOf, mutabilityOwnership);
        }
        this.buffer = objArrCopyOf;
        return this;
    }

    private final TrieNode<E> mutableCollisionRemove(E e10, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        int iY = p.Y(this.buffer, e10);
        if (iY == -1) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() - 1);
        return mutableCollisionRemoveElementAtIndex(iY, persistentHashSetBuilder.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object mutableCollisionRemoveAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return EMPTY;
        }
        Object[] objArr = t.d(mutabilityOwnership, this.ownedBy) ? this.buffer : new Object[this.buffer.length];
        Object[] objArr2 = this.buffer;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.m1270assert(i11 <= i10);
            if (!trieNode.collisionContainsElement(objArr2[i10])) {
                objArr[0 + i11] = objArr2[i10];
                i11++;
                CommonFunctionsKt.m1270assert(0 + i11 <= objArr.length);
            }
            i10++;
        }
        deltaCounter.plusAssign(this.buffer.length - i11);
        if (i11 == 0) {
            return EMPTY;
        }
        if (i11 == 1) {
            return objArr[0];
        }
        if (i11 == this.buffer.length) {
            return this;
        }
        if (i11 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, i11);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        return new TrieNode(0, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode<E> mutableCollisionRemoveElementAtIndex(int i10, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(0, TrieNodeKt.removeCellAtIndex(this.buffer, i10), mutabilityOwnership);
        }
        this.buffer = TrieNodeKt.removeCellAtIndex(this.buffer, i10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object mutableCollisionRetainAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr = t.d(mutabilityOwnership, this.ownedBy) ? this.buffer : new Object[Math.min(this.buffer.length, trieNode.buffer.length)];
        Object[] objArr2 = this.buffer;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.m1270assert(i11 <= i10);
            if (trieNode.collisionContainsElement(objArr2[i10])) {
                objArr[0 + i11] = objArr2[i10];
                i11++;
                CommonFunctionsKt.m1270assert(0 + i11 <= objArr.length);
            }
            i10++;
        }
        deltaCounter.plusAssign(i11);
        if (i11 == 0) {
            return EMPTY;
        }
        if (i11 == 1) {
            return objArr[0];
        }
        if (i11 == this.buffer.length) {
            return this;
        }
        if (i11 == trieNode.buffer.length) {
            return trieNode;
        }
        if (i11 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, i11);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        return new TrieNode(0, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode<E> mutableMoveElementToNode(int i10, int i11, E e10, int i12, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer[i10] = makeNodeAtIndex(i10, i11, e10, i12, mutabilityOwnership);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        t.h(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i10] = makeNodeAtIndex(i10, i11, e10, i12, mutabilityOwnership);
        return new TrieNode<>(this.bitmap, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode<E> mutableRemoveCellAtIndex(int i10, int i11, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(i11 ^ this.bitmap, TrieNodeKt.removeCellAtIndex(this.buffer, i10), mutabilityOwnership);
        }
        this.buffer = TrieNodeKt.removeCellAtIndex(this.buffer, i10);
        this.bitmap ^= i11;
        return this;
    }

    private final TrieNode<E> mutableUpdateNodeAtIndex(int i10, TrieNode<E> trieNode, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = trieNode.buffer;
        if (objArr.length == 1) {
            Object obj = objArr[0];
            if (!(obj instanceof TrieNode)) {
                if (this.buffer.length == 1) {
                    trieNode.bitmap = this.bitmap;
                    return trieNode;
                }
                trieNode = (TrieNode<E>) obj;
            }
        }
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer[i10] = trieNode;
            return this;
        }
        Object[] objArr2 = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
        t.h(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i10] = trieNode;
        return new TrieNode<>(this.bitmap, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode<E> nodeAtIndex(int i10) {
        Object obj = this.buffer[i10];
        if (obj != null) {
            return (TrieNode) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
    }

    private final TrieNode<E> removeCellAtIndex(int i10, int i11) {
        return new TrieNode<>(i11 ^ this.bitmap, TrieNodeKt.removeCellAtIndex(this.buffer, i10));
    }

    private final TrieNode<E> updateNodeAtIndex(int i10, TrieNode<E> trieNode) {
        Object[] objArr = trieNode.buffer;
        if (objArr.length == 1) {
            Object obj = objArr[0];
            if (!(obj instanceof TrieNode)) {
                if (this.buffer.length == 1) {
                    trieNode.bitmap = this.bitmap;
                    return trieNode;
                }
                trieNode = (TrieNode<E>) obj;
            }
        }
        Object[] objArr2 = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
        t.h(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i10] = trieNode;
        return new TrieNode<>(this.bitmap, objArrCopyOf);
    }

    @NotNull
    public final TrieNode<E> add(int i10, E e10, int i11) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasNoCellAt(iIndexSegment)) {
            return addElementAt(iIndexSegment, e10);
        }
        int iIndexOfCellAt$runtime_release = indexOfCellAt$runtime_release(iIndexSegment);
        Object obj = this.buffer[iIndexOfCellAt$runtime_release];
        if (!(obj instanceof TrieNode)) {
            return t.d(e10, obj) ? this : moveElementToNode(iIndexOfCellAt$runtime_release, i10, e10, i11);
        }
        TrieNode<E> trieNodeNodeAtIndex = nodeAtIndex(iIndexOfCellAt$runtime_release);
        TrieNode<E> trieNodeCollisionAdd = i11 == 30 ? trieNodeNodeAtIndex.collisionAdd(e10) : trieNodeNodeAtIndex.add(i10, e10, i11 + 5);
        return trieNodeNodeAtIndex == trieNodeCollisionAdd ? this : updateNodeAtIndex(iIndexOfCellAt$runtime_release, trieNodeCollisionAdd);
    }

    public final boolean contains(int i10, E e10, int i11) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasNoCellAt(iIndexSegment)) {
            return false;
        }
        int iIndexOfCellAt$runtime_release = indexOfCellAt$runtime_release(iIndexSegment);
        Object obj = this.buffer[iIndexOfCellAt$runtime_release];
        if (!(obj instanceof TrieNode)) {
            return t.d(e10, obj);
        }
        TrieNode<E> trieNodeNodeAtIndex = nodeAtIndex(iIndexOfCellAt$runtime_release);
        return i11 == 30 ? trieNodeNodeAtIndex.collisionContainsElement(e10) : trieNodeNodeAtIndex.contains(i10, e10, i11 + 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(@NotNull TrieNode<E> otherNode, int i10) {
        t.i(otherNode, "otherNode");
        if (this == otherNode) {
            return true;
        }
        if (i10 > 30) {
            for (Object obj : otherNode.buffer) {
                if (!p.H(this.buffer, obj)) {
                    return false;
                }
            }
            return true;
        }
        int i11 = this.bitmap;
        int i12 = otherNode.bitmap;
        int i13 = i11 & i12;
        if (i13 != i12) {
            return false;
        }
        while (i13 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i13);
            int iIndexOfCellAt$runtime_release = indexOfCellAt$runtime_release(iLowestOneBit);
            int iIndexOfCellAt$runtime_release2 = otherNode.indexOfCellAt$runtime_release(iLowestOneBit);
            Object obj2 = this.buffer[iIndexOfCellAt$runtime_release];
            Object obj3 = otherNode.buffer[iIndexOfCellAt$runtime_release2];
            boolean z10 = obj2 instanceof TrieNode;
            boolean z11 = obj3 instanceof TrieNode;
            if (z10 && z11) {
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                }
                TrieNode trieNode = (TrieNode) obj2;
                if (obj3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                }
                if (!trieNode.containsAll((TrieNode) obj3, i10 + 5)) {
                    return false;
                }
            } else if (z10) {
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                }
                if (!((TrieNode) obj2).contains(obj3 != null ? obj3.hashCode() : 0, obj3, i10 + 5)) {
                    return false;
                }
            } else if (z11 || !t.d(obj2, obj3)) {
                return false;
            }
            i13 ^= iLowestOneBit;
        }
        return true;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    @NotNull
    public final Object[] getBuffer() {
        return this.buffer;
    }

    @Nullable
    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    public final int indexOfCellAt$runtime_release(int i10) {
        return Integer.bitCount((i10 - 1) & this.bitmap);
    }

    @NotNull
    public final TrieNode<E> mutableAdd(int i10, E e10, int i11, @NotNull PersistentHashSetBuilder<?> mutator) {
        t.i(mutator, "mutator");
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasNoCellAt(iIndexSegment)) {
            mutator.setSize(mutator.size() + 1);
            return mutableAddElementAt(iIndexSegment, e10, mutator.getOwnership$runtime_release());
        }
        int iIndexOfCellAt$runtime_release = indexOfCellAt$runtime_release(iIndexSegment);
        Object obj = this.buffer[iIndexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode<E> trieNodeNodeAtIndex = nodeAtIndex(iIndexOfCellAt$runtime_release);
            TrieNode<E> trieNodeMutableCollisionAdd = i11 == 30 ? trieNodeNodeAtIndex.mutableCollisionAdd(e10, mutator) : trieNodeNodeAtIndex.mutableAdd(i10, e10, i11 + 5, mutator);
            return trieNodeNodeAtIndex == trieNodeMutableCollisionAdd ? this : mutableUpdateNodeAtIndex(iIndexOfCellAt$runtime_release, trieNodeMutableCollisionAdd, mutator.getOwnership$runtime_release());
        }
        if (t.d(e10, obj)) {
            return this;
        }
        mutator.setSize(mutator.size() + 1);
        return mutableMoveElementToNode(iIndexOfCellAt$runtime_release, i10, e10, i11, mutator.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final TrieNode<E> mutableAddAll(@NotNull TrieNode<E> otherNode, int i10, @NotNull DeltaCounter intersectionSizeRef, @NotNull PersistentHashSetBuilder<?> mutator) {
        Object[] objArr;
        int i11;
        Object objMakeNode;
        TrieNode trieNodeMutableAdd;
        t.i(otherNode, "otherNode");
        t.i(intersectionSizeRef, "intersectionSizeRef");
        t.i(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.setCount(intersectionSizeRef.getCount() + calculateSize());
            return this;
        }
        if (i10 > 30) {
            return mutableCollisionAddAll(otherNode, intersectionSizeRef, mutator.getOwnership$runtime_release());
        }
        int i12 = this.bitmap;
        int i13 = otherNode.bitmap | i12;
        TrieNode<E> trieNode = (i13 == i12 && t.d(this.ownedBy, mutator.getOwnership$runtime_release())) ? this : new TrieNode<>(i13, new Object[Integer.bitCount(i13)], mutator.getOwnership$runtime_release());
        int i14 = i13;
        int i15 = 0;
        while (i14 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i14);
            int iIndexOfCellAt$runtime_release = indexOfCellAt$runtime_release(iLowestOneBit);
            int iIndexOfCellAt$runtime_release2 = otherNode.indexOfCellAt$runtime_release(iLowestOneBit);
            Object[] objArr2 = trieNode.buffer;
            if (hasNoCellAt(iLowestOneBit)) {
                objMakeNode = otherNode.buffer[iIndexOfCellAt$runtime_release2];
            } else if (otherNode.hasNoCellAt(iLowestOneBit)) {
                objMakeNode = this.buffer[iIndexOfCellAt$runtime_release];
            } else {
                Object obj = this.buffer[iIndexOfCellAt$runtime_release];
                Object obj2 = otherNode.buffer[iIndexOfCellAt$runtime_release2];
                boolean z10 = obj instanceof TrieNode;
                boolean z11 = obj2 instanceof TrieNode;
                if (!z10 || !z11) {
                    if (z10) {
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda-6>");
                        }
                        TrieNode trieNode2 = (TrieNode) obj;
                        int size = mutator.size();
                        trieNodeMutableAdd = trieNode2.mutableAdd(obj2 != null ? obj2.hashCode() : 0, obj2, i10 + 5, mutator);
                        if (mutator.size() == size) {
                            intersectionSizeRef.setCount(intersectionSizeRef.getCount() + 1);
                        }
                        k0 k0Var = k0.f35197a;
                    } else if (z11) {
                        if (obj2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda-6>");
                        }
                        TrieNode trieNode3 = (TrieNode) obj2;
                        int size2 = mutator.size();
                        trieNodeMutableAdd = trieNode3.mutableAdd(obj != null ? obj.hashCode() : 0, obj, i10 + 5, mutator);
                        if (mutator.size() == size2) {
                            intersectionSizeRef.setCount(intersectionSizeRef.getCount() + 1);
                        }
                        k0 k0Var2 = k0.f35197a;
                    } else if (t.d(obj, obj2)) {
                        intersectionSizeRef.setCount(intersectionSizeRef.getCount() + 1);
                        k0 k0Var3 = k0.f35197a;
                        objMakeNode = obj;
                    } else {
                        objArr = objArr2;
                        i11 = iLowestOneBit;
                        objMakeNode = makeNode(obj != null ? obj.hashCode() : 0, obj, obj2 != null ? obj2.hashCode() : 0, obj2, i10 + 5, mutator.getOwnership$runtime_release());
                        objArr[i15] = objMakeNode;
                        i15++;
                        i14 ^= i11;
                    }
                    objMakeNode = trieNodeMutableAdd;
                } else {
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda-6>");
                    }
                    TrieNode trieNode4 = (TrieNode) obj;
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda-6>");
                    }
                    objMakeNode = trieNode4.mutableAddAll((TrieNode) obj2, i10 + 5, intersectionSizeRef, mutator);
                }
            }
            objArr = objArr2;
            i11 = iLowestOneBit;
            objArr[i15] = objMakeNode;
            i15++;
            i14 ^= i11;
        }
        return elementsIdentityEquals(trieNode) ? this : otherNode.elementsIdentityEquals(trieNode) ? otherNode : trieNode;
    }

    @NotNull
    public final TrieNode<E> mutableRemove(int i10, E e10, int i11, @NotNull PersistentHashSetBuilder<?> mutator) {
        t.i(mutator, "mutator");
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasNoCellAt(iIndexSegment)) {
            return this;
        }
        int iIndexOfCellAt$runtime_release = indexOfCellAt$runtime_release(iIndexSegment);
        Object obj = this.buffer[iIndexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode<E> trieNodeNodeAtIndex = nodeAtIndex(iIndexOfCellAt$runtime_release);
            TrieNode<E> trieNodeMutableCollisionRemove = i11 == 30 ? trieNodeNodeAtIndex.mutableCollisionRemove(e10, mutator) : trieNodeNodeAtIndex.mutableRemove(i10, e10, i11 + 5, mutator);
            return (this.ownedBy == mutator.getOwnership$runtime_release() || trieNodeNodeAtIndex != trieNodeMutableCollisionRemove) ? mutableUpdateNodeAtIndex(iIndexOfCellAt$runtime_release, trieNodeMutableCollisionRemove, mutator.getOwnership$runtime_release()) : this;
        }
        if (!t.d(e10, obj)) {
            return this;
        }
        mutator.setSize(mutator.size() - 1);
        return mutableRemoveCellAtIndex(iIndexOfCellAt$runtime_release, iIndexSegment, mutator.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mutableRemoveAll(@org.jetbrains.annotations.NotNull androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r17, int r18, @org.jetbrains.annotations.NotNull androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter r19, @org.jetbrains.annotations.NotNull androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> r20) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, int, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Object mutableRetainAll(@NotNull TrieNode<E> otherNode, int i10, @NotNull DeltaCounter intersectionSizeRef, @NotNull PersistentHashSetBuilder<?> mutator) {
        TrieNode trieNode;
        t.i(otherNode, "otherNode");
        t.i(intersectionSizeRef, "intersectionSizeRef");
        t.i(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(calculateSize());
            return this;
        }
        if (i10 > 30) {
            return mutableCollisionRetainAll(otherNode, intersectionSizeRef, mutator.getOwnership$runtime_release());
        }
        int i11 = this.bitmap & otherNode.bitmap;
        if (i11 == 0) {
            return EMPTY;
        }
        TrieNode<E> trieNode2 = (t.d(this.ownedBy, mutator.getOwnership$runtime_release()) && i11 == this.bitmap) ? this : new TrieNode<>(i11, new Object[Integer.bitCount(i11)], mutator.getOwnership$runtime_release());
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        while (i12 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i12);
            int iIndexOfCellAt$runtime_release = indexOfCellAt$runtime_release(iLowestOneBit);
            int iIndexOfCellAt$runtime_release2 = otherNode.indexOfCellAt$runtime_release(iLowestOneBit);
            Object objMutableRetainAll = this.buffer[iIndexOfCellAt$runtime_release];
            Object obj = otherNode.buffer[iIndexOfCellAt$runtime_release2];
            boolean z10 = objMutableRetainAll instanceof TrieNode;
            boolean z11 = obj instanceof TrieNode;
            if (z10 && z11) {
                if (objMutableRetainAll == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                }
                TrieNode trieNode3 = (TrieNode) objMutableRetainAll;
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                }
                objMutableRetainAll = trieNode3.mutableRetainAll((TrieNode) obj, i10 + 5, intersectionSizeRef, mutator);
            } else if (z10) {
                if (objMutableRetainAll == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                }
                if (((TrieNode) objMutableRetainAll).contains(obj != null ? obj.hashCode() : 0, obj, i10 + 5)) {
                    intersectionSizeRef.plusAssign(1);
                    objMutableRetainAll = obj;
                } else {
                    objMutableRetainAll = EMPTY;
                }
            } else if (z11) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                }
                if (((TrieNode) obj).contains(objMutableRetainAll != null ? objMutableRetainAll.hashCode() : 0, objMutableRetainAll, i10 + 5)) {
                    intersectionSizeRef.plusAssign(1);
                } else {
                    objMutableRetainAll = EMPTY;
                }
            } else if (t.d(objMutableRetainAll, obj)) {
                intersectionSizeRef.plusAssign(1);
            } else {
                objMutableRetainAll = EMPTY;
            }
            if (objMutableRetainAll != EMPTY) {
                i13 |= iLowestOneBit;
            }
            trieNode2.buffer[i14] = objMutableRetainAll;
            i14++;
            i12 ^= iLowestOneBit;
        }
        int iBitCount = Integer.bitCount(i13);
        if (i13 == 0) {
            return EMPTY;
        }
        if (i13 == i11) {
            return trieNode2.elementsIdentityEquals(this) ? this : trieNode2.elementsIdentityEquals(otherNode) ? otherNode : trieNode2;
        }
        if (iBitCount != 1 || i10 == 0) {
            Object[] objArr = new Object[iBitCount];
            Object[] objArr2 = trieNode2.buffer;
            int i15 = 0;
            int i16 = 0;
            while (i15 < objArr2.length) {
                CommonFunctionsKt.m1270assert(i16 <= i15);
                if (objArr2[i15] != Companion.getEMPTY$runtime_release()) {
                    objArr[0 + i16] = objArr2[i15];
                    i16++;
                    CommonFunctionsKt.m1270assert(0 + i16 <= iBitCount);
                }
                i15++;
            }
            trieNode = new TrieNode(i13, objArr, mutator.getOwnership$runtime_release());
        } else {
            Object obj2 = trieNode2.buffer[trieNode2.indexOfCellAt$runtime_release(i13)];
            if (!(obj2 instanceof TrieNode)) {
                return obj2;
            }
            trieNode = new TrieNode(i13, new Object[]{obj2}, mutator.getOwnership$runtime_release());
        }
        return trieNode;
    }

    @NotNull
    public final TrieNode<E> remove(int i10, E e10, int i11) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasNoCellAt(iIndexSegment)) {
            return this;
        }
        int iIndexOfCellAt$runtime_release = indexOfCellAt$runtime_release(iIndexSegment);
        Object obj = this.buffer[iIndexOfCellAt$runtime_release];
        if (!(obj instanceof TrieNode)) {
            return t.d(e10, obj) ? removeCellAtIndex(iIndexOfCellAt$runtime_release, iIndexSegment) : this;
        }
        TrieNode<E> trieNodeNodeAtIndex = nodeAtIndex(iIndexOfCellAt$runtime_release);
        TrieNode<E> trieNodeCollisionRemove = i11 == 30 ? trieNodeNodeAtIndex.collisionRemove(e10) : trieNodeNodeAtIndex.remove(i10, e10, i11 + 5);
        return trieNodeNodeAtIndex == trieNodeCollisionRemove ? this : updateNodeAtIndex(iIndexOfCellAt$runtime_release, trieNodeCollisionRemove);
    }

    public final void setBitmap(int i10) {
        this.bitmap = i10;
    }

    public final void setBuffer(@NotNull Object[] objArr) {
        t.i(objArr, "<set-?>");
        this.buffer = objArr;
    }

    public final void setOwnedBy(@Nullable MutabilityOwnership mutabilityOwnership) {
        this.ownedBy = mutabilityOwnership;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrieNode(int i10, @NotNull Object[] buffer) {
        this(i10, buffer, null);
        t.i(buffer, "buffer");
    }
}
