package androidx.room;

import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: RoomDatabaseExt.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.room.RoomDatabaseKt$withTransaction$transactionBlock$1", f = "RoomDatabaseExt.kt", l = {56}, m = "invokeSuspend")
final class RoomDatabaseKt$withTransaction$transactionBlock$1<R> extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super R>, Object> {
    final /* synthetic */ h9.l<z8.d<? super R>, Object> $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RoomDatabaseKt$withTransaction$transactionBlock$1(RoomDatabase roomDatabase, h9.l<? super z8.d<? super R>, ? extends Object> lVar, z8.d<? super RoomDatabaseKt$withTransaction$transactionBlock$1> dVar) {
        super(2, dVar);
        this.$this_withTransaction = roomDatabase;
        this.$block = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        RoomDatabaseKt$withTransaction$transactionBlock$1 roomDatabaseKt$withTransaction$transactionBlock$1 = new RoomDatabaseKt$withTransaction$transactionBlock$1(this.$this_withTransaction, this.$block, dVar);
        roomDatabaseKt$withTransaction$transactionBlock$1.L$0 = obj;
        return roomDatabaseKt$withTransaction$transactionBlock$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Throwable th;
        TransactionElement transactionElement;
        TransactionElement transactionElementE = a9.d.e();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                v8.u.b(obj);
                g.b bVar = ((o0) this.L$0).getCoroutineContext().get(TransactionElement.Key);
                kotlin.jvm.internal.t.f(bVar);
                TransactionElement transactionElement2 = (TransactionElement) bVar;
                transactionElement2.acquire();
                try {
                    this.$this_withTransaction.beginTransaction();
                    try {
                        h9.l<z8.d<? super R>, Object> lVar = this.$block;
                        this.L$0 = transactionElement2;
                        this.label = 1;
                        Object objInvoke = lVar.invoke(this);
                        if (objInvoke == transactionElementE) {
                            return transactionElementE;
                        }
                        transactionElement = transactionElement2;
                        obj = objInvoke;
                    } catch (Throwable th2) {
                        th = th2;
                        this.$this_withTransaction.endTransaction();
                        throw th;
                    }
                } catch (Throwable th3) {
                    transactionElementE = transactionElement2;
                    th = th3;
                    transactionElementE.release();
                    throw th;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                transactionElement = (TransactionElement) this.L$0;
                try {
                    v8.u.b(obj);
                } catch (Throwable th4) {
                    th = th4;
                    this.$this_withTransaction.endTransaction();
                    throw th;
                }
            }
            this.$this_withTransaction.setTransactionSuccessful();
            this.$this_withTransaction.endTransaction();
            transactionElement.release();
            return obj;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super R> dVar) {
        return ((RoomDatabaseKt$withTransaction$transactionBlock$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
