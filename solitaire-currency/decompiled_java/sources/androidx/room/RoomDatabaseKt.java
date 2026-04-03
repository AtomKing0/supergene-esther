package androidx.room;

import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.a3;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: RoomDatabaseExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoomDatabaseKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final z8.g createTransactionContext(RoomDatabase roomDatabase, z8.e eVar) {
        TransactionElement transactionElement = new TransactionElement(eVar);
        return eVar.plus(transactionElement).plus(a3.a(roomDatabase.getSuspendingTransactionId(), Integer.valueOf(System.identityHashCode(transactionElement))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> Object startTransactionCoroutine(final RoomDatabase roomDatabase, final z8.g gVar, final h9.p<? super o0, ? super z8.d<? super R>, ? extends Object> pVar, z8.d<? super R> dVar) throws Throwable {
        final kotlinx.coroutines.p pVar2 = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar2.C();
        try {
            roomDatabase.getTransactionExecutor().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1

                /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: RoomDatabaseExt.kt */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1", f = "RoomDatabaseExt.kt", l = {97}, m = "invokeSuspend")
                static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
                    final /* synthetic */ kotlinx.coroutines.o<R> $continuation;
                    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
                    final /* synthetic */ h9.p<o0, z8.d<? super R>, Object> $transactionBlock;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(RoomDatabase roomDatabase, kotlinx.coroutines.o<? super R> oVar, h9.p<? super o0, ? super z8.d<? super R>, ? extends Object> pVar, z8.d<? super AnonymousClass1> dVar) {
                        super(2, dVar);
                        this.$this_startTransactionCoroutine = roomDatabase;
                        this.$continuation = oVar;
                        this.$transactionBlock = pVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, dVar);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        z8.d dVar;
                        Object objE = a9.d.e();
                        int i10 = this.label;
                        if (i10 == 0) {
                            v8.u.b(obj);
                            g.b bVar = ((o0) this.L$0).getCoroutineContext().get(z8.e.R7);
                            kotlin.jvm.internal.t.f(bVar);
                            z8.g gVarCreateTransactionContext = RoomDatabaseKt.createTransactionContext(this.$this_startTransactionCoroutine, (z8.e) bVar);
                            z8.d dVar2 = this.$continuation;
                            h9.p<o0, z8.d<? super R>, Object> pVar = this.$transactionBlock;
                            this.L$0 = dVar2;
                            this.label = 1;
                            obj = kotlinx.coroutines.i.g(gVarCreateTransactionContext, pVar, this);
                            if (obj == objE) {
                                return objE;
                            }
                            dVar = dVar2;
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            dVar = (z8.d) this.L$0;
                            v8.u.b(obj);
                        }
                        dVar.resumeWith(v8.t.b(obj));
                        return k0.f35197a;
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                        return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        kotlinx.coroutines.i.e(gVar.minusKey(z8.e.R7), new AnonymousClass1(roomDatabase, pVar2, pVar, null));
                    } catch (Throwable th) {
                        pVar2.b(th);
                    }
                }
            });
        } catch (RejectedExecutionException e10) {
            pVar2.b(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e10));
        }
        Object objZ = pVar2.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    @Nullable
    public static final <R> Object withTransaction(@NotNull RoomDatabase roomDatabase, @NotNull h9.l<? super z8.d<? super R>, ? extends Object> lVar, @NotNull z8.d<? super R> dVar) {
        RoomDatabaseKt$withTransaction$transactionBlock$1 roomDatabaseKt$withTransaction$transactionBlock$1 = new RoomDatabaseKt$withTransaction$transactionBlock$1(roomDatabase, lVar, null);
        TransactionElement transactionElement = (TransactionElement) dVar.getContext().get(TransactionElement.Key);
        z8.e transactionDispatcher$room_ktx_release = transactionElement != null ? transactionElement.getTransactionDispatcher$room_ktx_release() : null;
        return transactionDispatcher$room_ktx_release != null ? kotlinx.coroutines.i.g(transactionDispatcher$room_ktx_release, roomDatabaseKt$withTransaction$transactionBlock$1, dVar) : startTransactionCoroutine(roomDatabase, dVar.getContext(), roomDatabaseKt$withTransaction$transactionBlock$1, dVar);
    }
}
