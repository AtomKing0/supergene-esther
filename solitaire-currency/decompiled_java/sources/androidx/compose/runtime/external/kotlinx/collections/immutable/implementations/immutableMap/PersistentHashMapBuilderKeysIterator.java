package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PersistentHashMapBuilderContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapBuilderKeysIterator<K, V> extends PersistentHashMapBuilderBaseIterator<K, V, K> {
    /* JADX WARN: Illegal instructions before constructor call */
    public PersistentHashMapBuilderKeysIterator(@NotNull PersistentHashMapBuilder<K, V> builder) {
        t.i(builder, "builder");
        TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
        for (int i10 = 0; i10 < 8; i10++) {
            trieNodeBaseIteratorArr[i10] = new TrieNodeKeysIterator();
        }
        super(builder, trieNodeBaseIteratorArr);
    }
}
