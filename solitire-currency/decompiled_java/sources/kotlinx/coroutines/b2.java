package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface b2 extends g.b {

    @NotNull
    public static final b O7 = b.f29861a;

    /* JADX INFO: compiled from: Job.kt */
    public static final class a {
        public static /* synthetic */ void a(b2 b2Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            b2Var.cancel(cancellationException);
        }

        public static <R> R b(@NotNull b2 b2Var, R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> pVar) {
            return (R) g.b.a.a(b2Var, r10, pVar);
        }

        @Nullable
        public static <E extends g.b> E c(@NotNull b2 b2Var, @NotNull g.c<E> cVar) {
            return (E) g.b.a.b(b2Var, cVar);
        }

        public static /* synthetic */ g1 d(b2 b2Var, boolean z10, boolean z11, h9.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            return b2Var.h0(z10, z11, lVar);
        }

        @NotNull
        public static z8.g e(@NotNull b2 b2Var, @NotNull g.c<?> cVar) {
            return g.b.a.c(b2Var, cVar);
        }

        @NotNull
        public static z8.g f(@NotNull b2 b2Var, @NotNull z8.g gVar) {
            return g.b.a.d(b2Var, gVar);
        }
    }

    /* JADX INFO: compiled from: Job.kt */
    public static final class b implements g.c<b2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f29861a = new b();

        private b() {
        }
    }

    @NotNull
    u G0(@NotNull w wVar);

    @NotNull
    g1 J(@NotNull h9.l<? super Throwable, v8.k0> lVar);

    void cancel(@Nullable CancellationException cancellationException);

    @Nullable
    b2 getParent();

    @NotNull
    g1 h0(boolean z10, boolean z11, @NotNull h9.l<? super Throwable, v8.k0> lVar);

    boolean i();

    boolean isActive();

    boolean isCancelled();

    @NotNull
    o9.g<b2> q();

    boolean start();

    @NotNull
    CancellationException x();

    @Nullable
    Object z(@NotNull z8.d<? super v8.k0> dVar);
}
