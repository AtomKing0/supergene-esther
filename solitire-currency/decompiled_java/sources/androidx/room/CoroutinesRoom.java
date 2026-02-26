package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Callable;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutinesRoom.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CoroutinesRoom {

    @NotNull
    public static final Companion Companion = new Companion(null);

    private CoroutinesRoom() {
    }

    @NotNull
    public static final <R> s9.h<R> createFlow(@NotNull RoomDatabase roomDatabase, boolean z10, @NotNull String[] strArr, @NotNull Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z10, strArr, callable);
    }

    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z10, @NotNull CancellationSignal cancellationSignal, @NotNull Callable<R> callable, @NotNull z8.d<? super R> dVar) {
        return Companion.execute(roomDatabase, z10, cancellationSignal, callable, dVar);
    }

    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z10, @NotNull Callable<R> callable, @NotNull z8.d<? super R> dVar) {
        return Companion.execute(roomDatabase, z10, callable, dVar);
    }

    /* JADX INFO: compiled from: CoroutinesRoom.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final <R> s9.h<R> createFlow(@NotNull RoomDatabase db2, boolean z10, @NotNull String[] tableNames, @NotNull Callable<R> callable) {
            kotlin.jvm.internal.t.i(db2, "db");
            kotlin.jvm.internal.t.i(tableNames, "tableNames");
            kotlin.jvm.internal.t.i(callable, "callable");
            return s9.j.z(new CoroutinesRoom$Companion$createFlow$1(z10, db2, tableNames, callable, null));
        }

        @Nullable
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z10, @NotNull Callable<R> callable, @NotNull z8.d<? super R> dVar) {
            z8.e transactionDispatcher;
            if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) dVar.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z10 ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return kotlinx.coroutines.i.g(transactionDispatcher, new CoroutinesRoom$Companion$execute$2(callable, null), dVar);
        }

        @Nullable
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z10, @NotNull CancellationSignal cancellationSignal, @NotNull Callable<R> callable, @NotNull z8.d<? super R> dVar) throws Throwable {
            z8.e transactionDispatcher;
            if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) dVar.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z10 ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            z8.e eVar = transactionDispatcher;
            kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
            pVar.C();
            pVar.m(new CoroutinesRoom$Companion$execute$4$1(cancellationSignal, kotlinx.coroutines.k.d(t1.f29982a, eVar, null, new CoroutinesRoom$Companion$execute$4$job$1(callable, pVar, null), 2, null)));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objZ;
        }
    }
}
