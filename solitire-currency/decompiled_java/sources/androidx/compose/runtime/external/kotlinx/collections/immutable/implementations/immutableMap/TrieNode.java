package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import h9.l;
import h9.s;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.g;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TrieNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrieNode<K, V> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final TrieNode EMPTY = new TrieNode(0, 0, new Object[0]);

    @NotNull
    private Object[] buffer;
    private int dataMap;
    private int nodeMap;

    @Nullable
    private final MutabilityOwnership ownedBy;

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

    /* JADX INFO: compiled from: TrieNode.kt */
    public static final class ModificationResult<K, V> {

        @NotNull
        private TrieNode<K, V> node;
        private final int sizeDelta;

        public ModificationResult(@NotNull TrieNode<K, V> node, int i10) {
            t.i(node, "node");
            this.node = node;
            this.sizeDelta = i10;
        }

        @NotNull
        public final TrieNode<K, V> getNode() {
            return this.node;
        }

        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        @NotNull
        public final ModificationResult<K, V> replaceNode(@NotNull l<? super TrieNode<K, V>, TrieNode<K, V>> operation) {
            t.i(operation, "operation");
            setNode(operation.invoke(getNode()));
            return this;
        }

        public final void setNode(@NotNull TrieNode<K, V> trieNode) {
            t.i(trieNode, "<set-?>");
            this.node = trieNode;
        }
    }

    public TrieNode(int i10, int i11, @NotNull Object[] buffer, @Nullable MutabilityOwnership mutabilityOwnership) {
        t.i(buffer, "buffer");
        this.dataMap = i10;
        this.nodeMap = i11;
        this.ownedBy = mutabilityOwnership;
        this.buffer = buffer;
    }

    private final void accept(s<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, k0> sVar, int i10, int i11) {
        sVar.invoke(this, Integer.valueOf(i11), Integer.valueOf(i10), Integer.valueOf(this.dataMap), Integer.valueOf(this.nodeMap));
        int i12 = this.nodeMap;
        while (i12 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i12);
            nodeAtIndex$runtime_release(nodeIndex$runtime_release(iLowestOneBit)).accept(sVar, (Integer.numberOfTrailingZeros(iLowestOneBit) << i11) + i10, i11 + 5);
            i12 -= iLowestOneBit;
        }
    }

    private final ModificationResult<K, V> asInsertResult() {
        return new ModificationResult<>(this, 1);
    }

    private final ModificationResult<K, V> asUpdateResult() {
        return new ModificationResult<>(this, 0);
    }

    private final Object[] bufferMoveEntryToNode(int i10, int i11, int i12, K k10, V v10, int i13, MutabilityOwnership mutabilityOwnership) {
        K kKeyAtIndex = keyAtIndex(i10);
        return TrieNodeKt.replaceEntryWithNode(this.buffer, i10, nodeIndex$runtime_release(i11) + 1, makeNode(kKeyAtIndex != null ? kKeyAtIndex.hashCode() : 0, kKeyAtIndex, valueAtKeyIndex(i10), i12, k10, v10, i13 + 5, mutabilityOwnership));
    }

    private final int calculateSize() {
        if (this.nodeMap == 0) {
            return this.buffer.length / 2;
        }
        int iBitCount = Integer.bitCount(this.dataMap);
        int length = this.buffer.length;
        for (int i10 = iBitCount * 2; i10 < length; i10++) {
            iBitCount += nodeAtIndex$runtime_release(i10).calculateSize();
        }
        return iBitCount;
    }

    private final boolean collisionContainsKey(K k10) {
        g gVarT = o.t(o.u(0, this.buffer.length), 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
            while (!t.d(k10, this.buffer[iB])) {
                if (iB != iE) {
                    iB += iF;
                }
            }
            return true;
        }
        return false;
    }

    private final V collisionGet(K k10) {
        g gVarT = o.t(o.u(0, this.buffer.length), 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF <= 0 || iB > iE) && (iF >= 0 || iE > iB)) {
            return null;
        }
        while (!t.d(k10, keyAtIndex(iB))) {
            if (iB == iE) {
                return null;
            }
            iB += iF;
        }
        return valueAtKeyIndex(iB);
    }

    private final ModificationResult<K, V> collisionPut(K k10, V v10) {
        g gVarT = o.t(o.u(0, this.buffer.length), 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
            while (!t.d(k10, keyAtIndex(iB))) {
                if (iB != iE) {
                    iB += iF;
                }
            }
            if (v10 == valueAtKeyIndex(iB)) {
                return null;
            }
            Object[] objArr = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            t.h(objArrCopyOf, "copyOf(this, size)");
            objArrCopyOf[iB + 1] = v10;
            return new TrieNode(0, 0, objArrCopyOf).asUpdateResult();
        }
        return new TrieNode(0, 0, TrieNodeKt.insertEntryAtIndex(this.buffer, 0, k10, v10)).asInsertResult();
    }

    private final TrieNode<K, V> collisionRemove(K k10) {
        g gVarT = o.t(o.u(0, this.buffer.length), 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
            while (!t.d(k10, keyAtIndex(iB))) {
                if (iB != iE) {
                    iB += iF;
                }
            }
            return collisionRemoveEntryAtIndex(iB);
        }
        return this;
    }

    private final TrieNode<K, V> collisionRemoveEntryAtIndex(int i10) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(0, 0, TrieNodeKt.removeEntryAtIndex(objArr, i10));
    }

    private final boolean elementsIdentityEquals(TrieNode<K, V> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.nodeMap != trieNode.nodeMap || this.dataMap != trieNode.dataMap) {
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

    private final boolean hasNodeAt(int i10) {
        return (i10 & this.nodeMap) != 0;
    }

    private final TrieNode<K, V> insertEntryAt(int i10, K k10, V v10) {
        return new TrieNode<>(i10 | this.dataMap, this.nodeMap, TrieNodeKt.insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release(i10), k10, v10));
    }

    private final K keyAtIndex(int i10) {
        return (K) this.buffer[i10];
    }

    private final TrieNode<K, V> makeNode(int i10, K k10, V v10, int i11, K k11, V v11, int i12, MutabilityOwnership mutabilityOwnership) {
        if (i12 > 30) {
            return new TrieNode<>(0, 0, new Object[]{k10, v10, k11, v11}, mutabilityOwnership);
        }
        int iIndexSegment = TrieNodeKt.indexSegment(i10, i12);
        int iIndexSegment2 = TrieNodeKt.indexSegment(i11, i12);
        if (iIndexSegment != iIndexSegment2) {
            return new TrieNode<>((1 << iIndexSegment) | (1 << iIndexSegment2), 0, iIndexSegment < iIndexSegment2 ? new Object[]{k10, v10, k11, v11} : new Object[]{k11, v11, k10, v10}, mutabilityOwnership);
        }
        return new TrieNode<>(0, 1 << iIndexSegment, new Object[]{makeNode(i10, k10, v10, i11, k11, v11, i12 + 5, mutabilityOwnership)}, mutabilityOwnership);
    }

    private final TrieNode<K, V> moveEntryToNode(int i10, int i11, int i12, K k10, V v10, int i13) {
        return new TrieNode<>(this.dataMap ^ i11, i11 | this.nodeMap, bufferMoveEntryToNode(i10, i11, i12, k10, v10, i13, null));
    }

    private final TrieNode<K, V> mutableCollisionPut(K k10, V v10, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        g gVarT = o.t(o.u(0, this.buffer.length), 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
            while (!t.d(k10, keyAtIndex(iB))) {
                if (iB != iE) {
                    iB += iF;
                }
            }
            persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(iB));
            if (this.ownedBy == persistentHashMapBuilder.getOwnership$runtime_release()) {
                this.buffer[iB + 1] = v10;
                return this;
            }
            persistentHashMapBuilder.setModCount$runtime_release(persistentHashMapBuilder.getModCount$runtime_release() + 1);
            Object[] objArr = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            t.h(objArrCopyOf, "copyOf(this, size)");
            objArrCopyOf[iB + 1] = v10;
            return new TrieNode<>(0, 0, objArrCopyOf, persistentHashMapBuilder.getOwnership$runtime_release());
        }
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() + 1);
        return new TrieNode<>(0, 0, TrieNodeKt.insertEntryAtIndex(this.buffer, 0, k10, v10), persistentHashMapBuilder.getOwnership$runtime_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<K, V> mutableCollisionPutAll(TrieNode<K, V> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        CommonFunctionsKt.m1270assert(this.nodeMap == 0);
        CommonFunctionsKt.m1270assert(this.dataMap == 0);
        CommonFunctionsKt.m1270assert(trieNode.nodeMap == 0);
        CommonFunctionsKt.m1270assert(trieNode.dataMap == 0);
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        int length = this.buffer.length;
        g gVarT = o.t(o.u(0, trieNode.buffer.length), 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
            while (true) {
                if (collisionContainsKey(trieNode.buffer[iB])) {
                    deltaCounter.setCount(deltaCounter.getCount() + 1);
                } else {
                    Object[] objArr2 = trieNode.buffer;
                    objArrCopyOf[length] = objArr2[iB];
                    objArrCopyOf[length + 1] = objArr2[iB + 1];
                    length += 2;
                }
                if (iB == iE) {
                    break;
                }
                iB += iF;
            }
        }
        if (length == this.buffer.length) {
            return this;
        }
        if (length == trieNode.buffer.length) {
            return trieNode;
        }
        if (length == objArrCopyOf.length) {
            return new TrieNode<>(0, 0, objArrCopyOf, mutabilityOwnership);
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, length);
        t.h(objArrCopyOf2, "copyOf(this, newSize)");
        return new TrieNode<>(0, 0, objArrCopyOf2, mutabilityOwnership);
    }

    private final TrieNode<K, V> mutableCollisionRemove(K k10, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        g gVarT = o.t(o.u(0, this.buffer.length), 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
            while (!t.d(k10, keyAtIndex(iB))) {
                if (iB != iE) {
                    iB += iF;
                }
            }
            return mutableCollisionRemoveEntryAtIndex(iB, persistentHashMapBuilder);
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionRemoveEntryAtIndex(int i10, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(i10));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != persistentHashMapBuilder.getOwnership$runtime_release()) {
            return new TrieNode<>(0, 0, TrieNodeKt.removeEntryAtIndex(this.buffer, i10), persistentHashMapBuilder.getOwnership$runtime_release());
        }
        this.buffer = TrieNodeKt.removeEntryAtIndex(this.buffer, i10);
        return this;
    }

    private final TrieNode<K, V> mutableInsertEntryAt(int i10, K k10, V v10, MutabilityOwnership mutabilityOwnership) {
        int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i10);
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(i10 | this.dataMap, this.nodeMap, TrieNodeKt.insertEntryAtIndex(this.buffer, iEntryKeyIndex$runtime_release, k10, v10), mutabilityOwnership);
        }
        this.buffer = TrieNodeKt.insertEntryAtIndex(this.buffer, iEntryKeyIndex$runtime_release, k10, v10);
        this.dataMap = i10 | this.dataMap;
        return this;
    }

    private final TrieNode<K, V> mutableMoveEntryToNode(int i10, int i11, int i12, K k10, V v10, int i13, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(this.dataMap ^ i11, i11 | this.nodeMap, bufferMoveEntryToNode(i10, i11, i12, k10, v10, i13, mutabilityOwnership), mutabilityOwnership);
        }
        this.buffer = bufferMoveEntryToNode(i10, i11, i12, k10, v10, i13, mutabilityOwnership);
        this.dataMap ^= i11;
        this.nodeMap |= i11;
        return this;
    }

    private final TrieNode<K, V> mutablePutAllFromOtherNodeCell(TrieNode<K, V> trieNode, int i10, int i11, DeltaCounter deltaCounter, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        if (hasNodeAt(i10)) {
            TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(i10));
            if (trieNode.hasNodeAt(i10)) {
                return trieNodeNodeAtIndex$runtime_release.mutablePutAll(trieNode.nodeAtIndex$runtime_release(trieNode.nodeIndex$runtime_release(i10)), i11 + 5, deltaCounter, persistentHashMapBuilder);
            }
            if (!trieNode.hasEntryAt$runtime_release(i10)) {
                return trieNodeNodeAtIndex$runtime_release;
            }
            int iEntryKeyIndex$runtime_release = trieNode.entryKeyIndex$runtime_release(i10);
            K kKeyAtIndex = trieNode.keyAtIndex(iEntryKeyIndex$runtime_release);
            V vValueAtKeyIndex = trieNode.valueAtKeyIndex(iEntryKeyIndex$runtime_release);
            int size = persistentHashMapBuilder.size();
            TrieNode<K, V> trieNodeMutablePut = trieNodeNodeAtIndex$runtime_release.mutablePut(kKeyAtIndex != null ? kKeyAtIndex.hashCode() : 0, kKeyAtIndex, vValueAtKeyIndex, i11 + 5, persistentHashMapBuilder);
            if (persistentHashMapBuilder.size() != size) {
                return trieNodeMutablePut;
            }
            deltaCounter.setCount(deltaCounter.getCount() + 1);
            return trieNodeMutablePut;
        }
        if (!trieNode.hasNodeAt(i10)) {
            int iEntryKeyIndex$runtime_release2 = entryKeyIndex$runtime_release(i10);
            K kKeyAtIndex2 = keyAtIndex(iEntryKeyIndex$runtime_release2);
            V vValueAtKeyIndex2 = valueAtKeyIndex(iEntryKeyIndex$runtime_release2);
            int iEntryKeyIndex$runtime_release3 = trieNode.entryKeyIndex$runtime_release(i10);
            K kKeyAtIndex3 = trieNode.keyAtIndex(iEntryKeyIndex$runtime_release3);
            return makeNode(kKeyAtIndex2 != null ? kKeyAtIndex2.hashCode() : 0, kKeyAtIndex2, vValueAtKeyIndex2, kKeyAtIndex3 != null ? kKeyAtIndex3.hashCode() : 0, kKeyAtIndex3, trieNode.valueAtKeyIndex(iEntryKeyIndex$runtime_release3), i11 + 5, persistentHashMapBuilder.getOwnership$runtime_release());
        }
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release2 = trieNode.nodeAtIndex$runtime_release(trieNode.nodeIndex$runtime_release(i10));
        if (hasEntryAt$runtime_release(i10)) {
            int iEntryKeyIndex$runtime_release4 = entryKeyIndex$runtime_release(i10);
            K kKeyAtIndex4 = keyAtIndex(iEntryKeyIndex$runtime_release4);
            int i12 = i11 + 5;
            if (!trieNodeNodeAtIndex$runtime_release2.containsKey(kKeyAtIndex4 != null ? kKeyAtIndex4.hashCode() : 0, kKeyAtIndex4, i12)) {
                return trieNodeNodeAtIndex$runtime_release2.mutablePut(kKeyAtIndex4 != null ? kKeyAtIndex4.hashCode() : 0, kKeyAtIndex4, valueAtKeyIndex(iEntryKeyIndex$runtime_release4), i12, persistentHashMapBuilder);
            }
            deltaCounter.setCount(deltaCounter.getCount() + 1);
        }
        return trieNodeNodeAtIndex$runtime_release2;
    }

    private final TrieNode<K, V> mutableRemoveEntryAtIndex(int i10, int i11, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(i10));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != persistentHashMapBuilder.getOwnership$runtime_release()) {
            return new TrieNode<>(i11 ^ this.dataMap, this.nodeMap, TrieNodeKt.removeEntryAtIndex(this.buffer, i10), persistentHashMapBuilder.getOwnership$runtime_release());
        }
        this.buffer = TrieNodeKt.removeEntryAtIndex(this.buffer, i10);
        this.dataMap ^= i11;
        return this;
    }

    private final TrieNode<K, V> mutableRemoveNodeAtIndex(int i10, int i11, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(this.dataMap, i11 ^ this.nodeMap, TrieNodeKt.removeNodeAtIndex(objArr, i10), mutabilityOwnership);
        }
        this.buffer = TrieNodeKt.removeNodeAtIndex(objArr, i10);
        this.nodeMap ^= i11;
        return this;
    }

    private final TrieNode<K, V> mutableReplaceNode(TrieNode<K, V> trieNode, TrieNode<K, V> trieNode2, int i10, int i11, MutabilityOwnership mutabilityOwnership) {
        return trieNode2 == null ? mutableRemoveNodeAtIndex(i10, i11, mutabilityOwnership) : (this.ownedBy == mutabilityOwnership || trieNode != trieNode2) ? mutableUpdateNodeAtIndex(i10, trieNode2, mutabilityOwnership) : this;
    }

    private final TrieNode<K, V> mutableUpdateNodeAtIndex(int i10, TrieNode<K, V> trieNode, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1 && trieNode.buffer.length == 2 && trieNode.nodeMap == 0) {
            trieNode.dataMap = this.nodeMap;
            return trieNode;
        }
        if (this.ownedBy == mutabilityOwnership) {
            objArr[i10] = trieNode;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        t.h(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i10] = trieNode;
        return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode<K, V> mutableUpdateValueAtIndex(int i10, V v10, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        if (this.ownedBy == persistentHashMapBuilder.getOwnership$runtime_release()) {
            this.buffer[i10 + 1] = v10;
            return this;
        }
        persistentHashMapBuilder.setModCount$runtime_release(persistentHashMapBuilder.getModCount$runtime_release() + 1);
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        t.h(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i10 + 1] = v10;
        return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf, persistentHashMapBuilder.getOwnership$runtime_release());
    }

    private final TrieNode<K, V> removeEntryAtIndex(int i10, int i11) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(i11 ^ this.dataMap, this.nodeMap, TrieNodeKt.removeEntryAtIndex(objArr, i10));
    }

    private final TrieNode<K, V> removeNodeAtIndex(int i10, int i11) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        return new TrieNode<>(this.dataMap, i11 ^ this.nodeMap, TrieNodeKt.removeNodeAtIndex(objArr, i10));
    }

    private final TrieNode<K, V> replaceNode(TrieNode<K, V> trieNode, TrieNode<K, V> trieNode2, int i10, int i11) {
        return trieNode2 == null ? removeNodeAtIndex(i10, i11) : trieNode != trieNode2 ? updateNodeAtIndex(i10, i11, trieNode2) : this;
    }

    private final TrieNode<K, V> updateNodeAtIndex(int i10, int i11, TrieNode<K, V> trieNode) {
        Object[] objArr = trieNode.buffer;
        if (objArr.length != 2 || trieNode.nodeMap != 0) {
            Object[] objArr2 = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            t.h(objArrCopyOf, "copyOf(this, newSize)");
            objArrCopyOf[i10] = trieNode;
            return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf);
        }
        if (this.buffer.length == 1) {
            trieNode.dataMap = this.nodeMap;
            return trieNode;
        }
        return new TrieNode<>(this.dataMap ^ i11, i11 ^ this.nodeMap, TrieNodeKt.replaceNodeWithEntry(this.buffer, i10, entryKeyIndex$runtime_release(i11), objArr[0], objArr[1]));
    }

    private final TrieNode<K, V> updateValueAtIndex(int i10, V v10) {
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        t.h(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i10 + 1] = v10;
        return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf);
    }

    private final V valueAtKeyIndex(int i10) {
        return (V) this.buffer[i10 + 1];
    }

    public final void accept$runtime_release(@NotNull s<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, k0> visitor) {
        t.i(visitor, "visitor");
        accept(visitor, 0, 0);
    }

    public final boolean containsKey(int i10, K k10, int i11) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            return t.d(k10, keyAtIndex(entryKeyIndex$runtime_release(iIndexSegment)));
        }
        if (!hasNodeAt(iIndexSegment)) {
            return false;
        }
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(iIndexSegment));
        return i11 == 30 ? trieNodeNodeAtIndex$runtime_release.collisionContainsKey(k10) : trieNodeNodeAtIndex$runtime_release.containsKey(i10, k10, i11 + 5);
    }

    public final int entryCount$runtime_release() {
        return Integer.bitCount(this.dataMap);
    }

    public final int entryKeyIndex$runtime_release(int i10) {
        return Integer.bitCount((i10 - 1) & this.dataMap) * 2;
    }

    @Nullable
    public final V get(int i10, K k10, int i11) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (t.d(k10, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                return valueAtKeyIndex(iEntryKeyIndex$runtime_release);
            }
            return null;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return null;
        }
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(iIndexSegment));
        return i11 == 30 ? trieNodeNodeAtIndex$runtime_release.collisionGet(k10) : trieNodeNodeAtIndex$runtime_release.get(i10, k10, i11 + 5);
    }

    @NotNull
    public final Object[] getBuffer$runtime_release() {
        return this.buffer;
    }

    public final boolean hasEntryAt$runtime_release(int i10) {
        return (i10 & this.dataMap) != 0;
    }

    @NotNull
    public final TrieNode<K, V> mutablePut(int i10, K k10, V v10, int i11, @NotNull PersistentHashMapBuilder<K, V> mutator) {
        t.i(mutator, "mutator");
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (t.d(k10, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                mutator.setOperationResult$runtime_release(valueAtKeyIndex(iEntryKeyIndex$runtime_release));
                return valueAtKeyIndex(iEntryKeyIndex$runtime_release) == v10 ? this : mutableUpdateValueAtIndex(iEntryKeyIndex$runtime_release, v10, mutator);
            }
            mutator.setSize(mutator.size() + 1);
            return mutableMoveEntryToNode(iEntryKeyIndex$runtime_release, iIndexSegment, i10, k10, v10, i11, mutator.getOwnership$runtime_release());
        }
        if (!hasNodeAt(iIndexSegment)) {
            mutator.setSize(mutator.size() + 1);
            return mutableInsertEntryAt(iIndexSegment, k10, v10, mutator.getOwnership$runtime_release());
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        TrieNode<K, V> trieNodeMutableCollisionPut = i11 == 30 ? trieNodeNodeAtIndex$runtime_release.mutableCollisionPut(k10, v10, mutator) : trieNodeNodeAtIndex$runtime_release.mutablePut(i10, k10, v10, i11 + 5, mutator);
        return trieNodeNodeAtIndex$runtime_release == trieNodeMutableCollisionPut ? this : mutableUpdateNodeAtIndex(iNodeIndex$runtime_release, trieNodeMutableCollisionPut, mutator.getOwnership$runtime_release());
    }

    @NotNull
    public final TrieNode<K, V> mutablePutAll(@NotNull TrieNode<K, V> otherNode, int i10, @NotNull DeltaCounter intersectionCounter, @NotNull PersistentHashMapBuilder<K, V> mutator) {
        t.i(otherNode, "otherNode");
        t.i(intersectionCounter, "intersectionCounter");
        t.i(mutator, "mutator");
        if (this == otherNode) {
            intersectionCounter.plusAssign(calculateSize());
            return this;
        }
        if (i10 > 30) {
            return mutableCollisionPutAll(otherNode, intersectionCounter, mutator.getOwnership$runtime_release());
        }
        int i11 = this.nodeMap | otherNode.nodeMap;
        int i12 = this.dataMap;
        int i13 = otherNode.dataMap;
        int i14 = (i12 ^ i13) & (~i11);
        int i15 = i12 & i13;
        int i16 = i14;
        while (i15 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i15);
            if (t.d(keyAtIndex(entryKeyIndex$runtime_release(iLowestOneBit)), otherNode.keyAtIndex(otherNode.entryKeyIndex$runtime_release(iLowestOneBit)))) {
                i16 |= iLowestOneBit;
            } else {
                i11 |= iLowestOneBit;
            }
            i15 ^= iLowestOneBit;
        }
        int i17 = 0;
        if (!((i11 & i16) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        TrieNode<K, V> trieNode = (t.d(this.ownedBy, mutator.getOwnership$runtime_release()) && this.dataMap == i16 && this.nodeMap == i11) ? this : new TrieNode<>(i16, i11, new Object[(Integer.bitCount(i16) * 2) + Integer.bitCount(i11)]);
        int i18 = i11;
        int i19 = 0;
        while (i18 != 0) {
            int iLowestOneBit2 = Integer.lowestOneBit(i18);
            Object[] objArr = trieNode.buffer;
            objArr[(objArr.length - 1) - i19] = mutablePutAllFromOtherNodeCell(otherNode, iLowestOneBit2, i10, intersectionCounter, mutator);
            i19++;
            i18 ^= iLowestOneBit2;
        }
        while (i16 != 0) {
            int iLowestOneBit3 = Integer.lowestOneBit(i16);
            int i20 = i17 * 2;
            if (otherNode.hasEntryAt$runtime_release(iLowestOneBit3)) {
                int iEntryKeyIndex$runtime_release = otherNode.entryKeyIndex$runtime_release(iLowestOneBit3);
                trieNode.buffer[i20] = otherNode.keyAtIndex(iEntryKeyIndex$runtime_release);
                trieNode.buffer[i20 + 1] = otherNode.valueAtKeyIndex(iEntryKeyIndex$runtime_release);
                if (hasEntryAt$runtime_release(iLowestOneBit3)) {
                    intersectionCounter.setCount(intersectionCounter.getCount() + 1);
                }
            } else {
                int iEntryKeyIndex$runtime_release2 = entryKeyIndex$runtime_release(iLowestOneBit3);
                trieNode.buffer[i20] = keyAtIndex(iEntryKeyIndex$runtime_release2);
                trieNode.buffer[i20 + 1] = valueAtKeyIndex(iEntryKeyIndex$runtime_release2);
            }
            i17++;
            i16 ^= iLowestOneBit3;
        }
        return elementsIdentityEquals(trieNode) ? this : otherNode.elementsIdentityEquals(trieNode) ? otherNode : trieNode;
    }

    @Nullable
    public final TrieNode<K, V> mutableRemove(int i10, K k10, int i11, @NotNull PersistentHashMapBuilder<K, V> mutator) {
        t.i(mutator, "mutator");
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            return t.d(k10, keyAtIndex(iEntryKeyIndex$runtime_release)) ? mutableRemoveEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment, mutator) : this;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return this;
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        return mutableReplaceNode(trieNodeNodeAtIndex$runtime_release, i11 == 30 ? trieNodeNodeAtIndex$runtime_release.mutableCollisionRemove(k10, mutator) : trieNodeNodeAtIndex$runtime_release.mutableRemove(i10, k10, i11 + 5, mutator), iNodeIndex$runtime_release, iIndexSegment, mutator.getOwnership$runtime_release());
    }

    @NotNull
    public final TrieNode<K, V> nodeAtIndex$runtime_release(int i10) {
        Object obj = this.buffer[i10];
        if (obj != null) {
            return (TrieNode) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
    }

    public final int nodeIndex$runtime_release(int i10) {
        return (this.buffer.length - 1) - Integer.bitCount((i10 - 1) & this.nodeMap);
    }

    @Nullable
    public final ModificationResult<K, V> put(int i10, K k10, V v10, int i11) {
        ModificationResult<K, V> modificationResultPut;
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (!t.d(k10, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                return moveEntryToNode(iEntryKeyIndex$runtime_release, iIndexSegment, i10, k10, v10, i11).asInsertResult();
            }
            if (valueAtKeyIndex(iEntryKeyIndex$runtime_release) == v10) {
                return null;
            }
            return updateValueAtIndex(iEntryKeyIndex$runtime_release, v10).asUpdateResult();
        }
        if (!hasNodeAt(iIndexSegment)) {
            return insertEntryAt(iIndexSegment, k10, v10).asInsertResult();
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        if (i11 == 30) {
            modificationResultPut = trieNodeNodeAtIndex$runtime_release.collisionPut(k10, v10);
            if (modificationResultPut == null) {
                return null;
            }
        } else {
            modificationResultPut = trieNodeNodeAtIndex$runtime_release.put(i10, k10, v10, i11 + 5);
            if (modificationResultPut == null) {
                return null;
            }
        }
        modificationResultPut.setNode(updateNodeAtIndex(iNodeIndex$runtime_release, iIndexSegment, modificationResultPut.getNode()));
        return modificationResultPut;
    }

    @Nullable
    public final TrieNode<K, V> remove(int i10, K k10, int i11) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            return t.d(k10, keyAtIndex(iEntryKeyIndex$runtime_release)) ? removeEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment) : this;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return this;
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        return replaceNode(trieNodeNodeAtIndex$runtime_release, i11 == 30 ? trieNodeNodeAtIndex$runtime_release.collisionRemove(k10) : trieNodeNodeAtIndex$runtime_release.remove(i10, k10, i11 + 5), iNodeIndex$runtime_release, iIndexSegment);
    }

    private final TrieNode<K, V> collisionRemove(K k10, V v10) {
        g gVarT = o.t(o.u(0, this.buffer.length), 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
            while (true) {
                if (!t.d(k10, keyAtIndex(iB)) || !t.d(v10, valueAtKeyIndex(iB))) {
                    if (iB == iE) {
                        break;
                    }
                    iB += iF;
                } else {
                    return collisionRemoveEntryAtIndex(iB);
                }
            }
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionRemove(K k10, V v10, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        g gVarT = o.t(o.u(0, this.buffer.length), 2);
        int iB = gVarT.b();
        int iE = gVarT.e();
        int iF = gVarT.f();
        if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
            while (true) {
                if (!t.d(k10, keyAtIndex(iB)) || !t.d(v10, valueAtKeyIndex(iB))) {
                    if (iB == iE) {
                        break;
                    }
                    iB += iF;
                } else {
                    return mutableCollisionRemoveEntryAtIndex(iB, persistentHashMapBuilder);
                }
            }
        }
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrieNode(int i10, int i11, @NotNull Object[] buffer) {
        this(i10, i11, buffer, null);
        t.i(buffer, "buffer");
    }

    @Nullable
    public final TrieNode<K, V> mutableRemove(int i10, K k10, V v10, int i11, @NotNull PersistentHashMapBuilder<K, V> mutator) {
        TrieNode<K, V> trieNodeMutableRemove;
        t.i(mutator, "mutator");
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            return (t.d(k10, keyAtIndex(iEntryKeyIndex$runtime_release)) && t.d(v10, valueAtKeyIndex(iEntryKeyIndex$runtime_release))) ? mutableRemoveEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment, mutator) : this;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return this;
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        if (i11 == 30) {
            trieNodeMutableRemove = trieNodeNodeAtIndex$runtime_release.mutableCollisionRemove(k10, v10, mutator);
        } else {
            trieNodeMutableRemove = trieNodeNodeAtIndex$runtime_release.mutableRemove(i10, k10, v10, i11 + 5, mutator);
        }
        return mutableReplaceNode(trieNodeNodeAtIndex$runtime_release, trieNodeMutableRemove, iNodeIndex$runtime_release, iIndexSegment, mutator.getOwnership$runtime_release());
    }

    @Nullable
    public final TrieNode<K, V> remove(int i10, K k10, V v10, int i11) {
        TrieNode<K, V> trieNodeRemove;
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(i10, i11);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            return (t.d(k10, keyAtIndex(iEntryKeyIndex$runtime_release)) && t.d(v10, valueAtKeyIndex(iEntryKeyIndex$runtime_release))) ? removeEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment) : this;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return this;
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        if (i11 == 30) {
            trieNodeRemove = trieNodeNodeAtIndex$runtime_release.collisionRemove(k10, v10);
        } else {
            trieNodeRemove = trieNodeNodeAtIndex$runtime_release.remove(i10, k10, v10, i11 + 5);
        }
        return replaceNode(trieNodeNodeAtIndex$runtime_release, trieNodeRemove, iNodeIndex$runtime_release, iIndexSegment);
    }
}
