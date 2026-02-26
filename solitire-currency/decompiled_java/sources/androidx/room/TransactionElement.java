package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: RoomDatabaseExt.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TransactionElement implements g.b {

    @NotNull
    public static final Key Key = new Key(null);

    @NotNull
    private final AtomicInteger referenceCount;

    @NotNull
    private final z8.e transactionDispatcher;

    /* JADX INFO: compiled from: RoomDatabaseExt.kt */
    public static final class Key implements g.c<TransactionElement> {
        private Key() {
        }

        public /* synthetic */ Key(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public TransactionElement(@NotNull z8.e transactionDispatcher) {
        kotlin.jvm.internal.t.i(transactionDispatcher, "transactionDispatcher");
        this.transactionDispatcher = transactionDispatcher;
        this.referenceCount = new AtomicInteger(0);
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r10, pVar);
    }

    @Override // z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // z8.g.b
    @NotNull
    public g.c<TransactionElement> getKey() {
        return Key;
    }

    @NotNull
    public final z8.e getTransactionDispatcher$room_ktx_release() {
        return this.transactionDispatcher;
    }

    @Override // z8.g.b, z8.g
    @NotNull
    public z8.g minusKey(@NotNull g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // z8.g
    @NotNull
    public z8.g plus(@NotNull z8.g gVar) {
        return g.b.a.d(this, gVar);
    }

    public final void release() {
        if (this.referenceCount.decrementAndGet() < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
    }
}
