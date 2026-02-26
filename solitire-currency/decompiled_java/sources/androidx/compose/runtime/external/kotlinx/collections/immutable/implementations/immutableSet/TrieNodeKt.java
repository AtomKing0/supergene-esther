package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import h9.l;
import kotlin.collections.o;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TrieNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrieNodeKt {
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    /* JADX INFO: renamed from: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeKt$filterTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrieNode.kt */
    public static final class AnonymousClass1 extends v implements l<Object, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.l
        @NotNull
        public final Boolean invoke(@Nullable Object obj) {
            return Boolean.valueOf(obj != TrieNode.Companion.getEMPTY$runtime_release());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> Object[] addElementAtIndex(Object[] objArr, int i10, E e10) {
        Object[] objArr2 = new Object[objArr.length + 1];
        o.m(objArr, objArr2, 0, 0, i10, 6, null);
        o.i(objArr, objArr2, i10 + 1, i10, objArr.length);
        objArr2[i10] = e10;
        return objArr2;
    }

    private static final int filterTo(Object[] objArr, Object[] objArr2, int i10, l<Object, Boolean> lVar) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < objArr.length) {
            CommonFunctionsKt.m1270assert(i12 <= i11);
            if (lVar.invoke(objArr[i11]).booleanValue()) {
                objArr2[i10 + i12] = objArr[i11];
                i12++;
                CommonFunctionsKt.m1270assert(i10 + i12 <= objArr2.length);
            }
            i11++;
        }
        return i12;
    }

    static /* synthetic */ int filterTo$default(Object[] objArr, Object[] objArr2, int i10, l lVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < objArr.length) {
            CommonFunctionsKt.m1270assert(i13 <= i12);
            if (((Boolean) lVar.invoke(objArr[i12])).booleanValue()) {
                objArr2[i10 + i13] = objArr[i12];
                i13++;
                CommonFunctionsKt.m1270assert(i10 + i13 <= objArr2.length);
            }
            i12++;
        }
        return i13;
    }

    public static final int indexSegment(int i10, int i11) {
        return (i10 >> i11) & 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] removeCellAtIndex(Object[] objArr, int i10) {
        Object[] objArr2 = new Object[objArr.length - 1];
        o.m(objArr, objArr2, 0, 0, i10, 6, null);
        o.i(objArr, objArr2, i10, i10 + 1, objArr.length);
        return objArr2;
    }
}
