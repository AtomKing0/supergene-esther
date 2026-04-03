package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;

/* JADX INFO: compiled from: PersistentHashMapContentIterators.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrieNodeValuesIterator<K, V> extends TrieNodeBaseIterator<K, V, V> {
    @Override // java.util.Iterator
    public V next() {
        CommonFunctionsKt.m1270assert(hasNextKey());
        setIndex(getIndex() + 2);
        return (V) getBuffer()[getIndex() - 1];
    }
}
