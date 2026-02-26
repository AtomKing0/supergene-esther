package androidx.datastore.core;

import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.n0;
import y9.a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SingleProcessDataStore$readAndInit$api$1<T> implements InitializerApi<T> {
    final /* synthetic */ n0<T> $initData;
    final /* synthetic */ i0 $initializationComplete;
    final /* synthetic */ a $updateLock;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    SingleProcessDataStore$readAndInit$api$1(a aVar, i0 i0Var, n0<T> n0Var, SingleProcessDataStore<T> singleProcessDataStore) {
        this.$updateLock = aVar;
        this.$initializationComplete = i0Var;
        this.$initData = n0Var;
        this.this$0 = singleProcessDataStore;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:21:0x0052, B:36:0x00b2, B:38:0x00ba), top: B:53:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.InitializerApi
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object updateData(@org.jetbrains.annotations.NotNull h9.p<? super T, ? super z8.d<? super T>, ? extends java.lang.Object> r11, @org.jetbrains.annotations.NotNull z8.d<? super T> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1.updateData(h9.p, z8.d):java.lang.Object");
    }
}
