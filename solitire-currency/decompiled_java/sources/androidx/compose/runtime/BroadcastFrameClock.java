package androidx.compose.runtime;

import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.StabilityInferred;
import h9.l;
import h9.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;
import z8.g;

/* JADX INFO: compiled from: BroadcastFrameClock.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class BroadcastFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;

    @NotNull
    private List<FrameAwaiter<?>> awaiters;

    @Nullable
    private Throwable failureCause;

    @NotNull
    private final Object lock;

    @Nullable
    private final h9.a<k0> onNewAwaiters;

    @NotNull
    private List<FrameAwaiter<?>> spareList;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: BroadcastFrameClock.kt */
    static final class FrameAwaiter<R> {

        @NotNull
        private final z8.d<R> continuation;

        @NotNull
        private final l<Long, R> onFrame;

        /* JADX WARN: Multi-variable type inference failed */
        public FrameAwaiter(@NotNull l<? super Long, ? extends R> onFrame, @NotNull z8.d<? super R> continuation) {
            t.i(onFrame, "onFrame");
            t.i(continuation, "continuation");
            this.onFrame = onFrame;
            this.continuation = continuation;
        }

        @NotNull
        public final z8.d<R> getContinuation() {
            return this.continuation;
        }

        @NotNull
        public final l<Long, R> getOnFrame() {
            return this.onFrame;
        }

        public final void resume(long j10) {
            Object objB;
            z8.d<R> dVar = this.continuation;
            try {
                t.a aVar = v8.t.f35208b;
                objB = v8.t.b(this.onFrame.invoke(Long.valueOf(j10)));
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(u.a(th));
            }
            dVar.resumeWith(objB);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BroadcastFrameClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void cancel$default(BroadcastFrameClock broadcastFrameClock, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = new CancellationException("clock cancelled");
        }
        broadcastFrameClock.cancel(cancellationException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fail(Throwable th) {
        synchronized (this.lock) {
            if (this.failureCause != null) {
                return;
            }
            this.failureCause = th;
            List<FrameAwaiter<?>> list = this.awaiters;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                z8.d<?> continuation = list.get(i10).getContinuation();
                t.a aVar = v8.t.f35208b;
                continuation.resumeWith(v8.t.b(u.a(th)));
            }
            this.awaiters.clear();
            k0 k0Var = k0.f35197a;
        }
    }

    public final void cancel(@NotNull CancellationException cancellationException) {
        kotlin.jvm.internal.t.i(cancellationException, "cancellationException");
        fail(cancellationException);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r10, pVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, cVar);
    }

    public final boolean getHasAwaiters() {
        boolean z10;
        synchronized (this.lock) {
            z10 = !this.awaiters.isEmpty();
        }
        return z10;
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, z8.g.b
    public /* synthetic */ g.c getKey() {
        return c.a(this);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, z8.g.b, z8.g
    @NotNull
    public g minusKey(@NotNull g.c<?> cVar) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, cVar);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, z8.g
    @NotNull
    public g plus(@NotNull g gVar) {
        return MonotonicFrameClock.DefaultImpls.plus(this, gVar);
    }

    public final void sendFrame(long j10) {
        synchronized (this.lock) {
            List<FrameAwaiter<?>> list = this.awaiters;
            this.awaiters = this.spareList;
            this.spareList = list;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                list.get(i10).resume(j10);
            }
            list.clear();
            k0 k0Var = k0.f35197a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, androidx.compose.runtime.BroadcastFrameClock$FrameAwaiter] */
    @Override // androidx.compose.runtime.MonotonicFrameClock
    @Nullable
    public <R> Object withFrameNanos(@NotNull l<? super Long, ? extends R> lVar, @NotNull z8.d<? super R> dVar) throws Throwable {
        FrameAwaiter frameAwaiter;
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.C();
        n0 n0Var = new n0();
        synchronized (this.lock) {
            Throwable th = this.failureCause;
            if (th != null) {
                t.a aVar = v8.t.f35208b;
                pVar.resumeWith(v8.t.b(u.a(th)));
            } else {
                n0Var.f29834a = new FrameAwaiter(lVar, pVar);
                boolean z10 = !this.awaiters.isEmpty();
                List list = this.awaiters;
                T t10 = n0Var.f29834a;
                if (t10 == 0) {
                    kotlin.jvm.internal.t.A("awaiter");
                    frameAwaiter = null;
                } else {
                    frameAwaiter = (FrameAwaiter) t10;
                }
                list.add(frameAwaiter);
                boolean z11 = !z10;
                pVar.m(new BroadcastFrameClock$withFrameNanos$2$1(this, n0Var));
                if (z11 && this.onNewAwaiters != null) {
                    try {
                        this.onNewAwaiters.invoke();
                    } catch (Throwable th2) {
                        fail(th2);
                    }
                }
            }
        }
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ;
    }

    public BroadcastFrameClock(@Nullable h9.a<k0> aVar) {
        this.onNewAwaiters = aVar;
        this.lock = new Object();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
    }

    public /* synthetic */ BroadcastFrameClock(h9.a aVar, int i10, k kVar) {
        this((i10 & 1) != 0 ? null : aVar);
    }
}
