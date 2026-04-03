package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashMapContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapValuesIterator<K, V> extends PersistentHashMapBaseIterator<K, V, V> {
    /* JADX WARN: Illegal instructions before constructor call */
    public PersistentHashMapValuesIterator(@NotNull TrieNode<K, V> node) {
        t.i(node, "node");
        TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
        for (int i10 = 0; i10 < 8; i10++) {
            trieNodeBaseIteratorArr[i10] = new TrieNodeValuesIterator();
        }
        super(node, trieNodeBaseIteratorArr);
    }
}
