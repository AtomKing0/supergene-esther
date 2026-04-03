package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Arrays;
import kotlin.collections.o;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: TrieNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrieNodeKt {
    public static final int ENTRY_SIZE = 2;
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    public static final int indexSegment(int i10, int i11) {
        return (i10 >> i11) & 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> Object[] insertEntryAtIndex(Object[] objArr, int i10, K k10, V v10) {
        Object[] objArr2 = new Object[objArr.length + 2];
        o.m(objArr, objArr2, 0, 0, i10, 6, null);
        o.i(objArr, objArr2, i10 + 2, i10, objArr.length);
        objArr2[i10] = k10;
        objArr2[i10 + 1] = v10;
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] removeEntryAtIndex(Object[] objArr, int i10) {
        Object[] objArr2 = new Object[objArr.length - 2];
        o.m(objArr, objArr2, 0, 0, i10, 6, null);
        o.i(objArr, objArr2, i10, i10 + 2, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] removeNodeAtIndex(Object[] objArr, int i10) {
        Object[] objArr2 = new Object[objArr.length - 1];
        o.m(objArr, objArr2, 0, 0, i10, 6, null);
        o.i(objArr, objArr2, i10, i10 + 1, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] replaceEntryWithNode(Object[] objArr, int i10, int i11, TrieNode<?, ?> trieNode) {
        int i12 = i11 - 2;
        Object[] objArr2 = new Object[(objArr.length - 2) + 1];
        o.m(objArr, objArr2, 0, 0, i10, 6, null);
        o.i(objArr, objArr2, i10, i10 + 2, i11);
        objArr2[i12] = trieNode;
        o.i(objArr, objArr2, i12 + 1, i11, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> Object[] replaceNodeWithEntry(Object[] objArr, int i10, int i11, K k10, V v10) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
        t.h(objArrCopyOf, "copyOf(this, newSize)");
        o.i(objArrCopyOf, objArrCopyOf, i10 + 2, i10 + 1, objArr.length);
        o.i(objArrCopyOf, objArrCopyOf, i11 + 2, i11, i10);
        objArrCopyOf[i11] = k10;
        objArrCopyOf[i11 + 1] = v10;
        return objArrCopyOf;
    }
}
