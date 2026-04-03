package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class k1 extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f29932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f29933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private kotlin.collections.k<b1<?>> f29934c;

    public static /* synthetic */ void J0(k1 k1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        k1Var.I0(z10);
    }

    private final long K0(boolean z10) {
        return z10 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void O0(k1 k1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        k1Var.N0(z10);
    }

    public final void I0(boolean z10) {
        long jK0 = this.f29932a - K0(z10);
        this.f29932a = jK0;
        if (jK0 <= 0 && this.f29933b) {
            shutdown();
        }
    }

    public final void L0(@NotNull b1<?> b1Var) {
        kotlin.collections.k<b1<?>> kVar = this.f29934c;
        if (kVar == null) {
            kVar = new kotlin.collections.k<>();
            this.f29934c = kVar;
        }
        kVar.addLast(b1Var);
    }

    protected long M0() {
        kotlin.collections.k<b1<?>> kVar = this.f29934c;
        return (kVar == null || kVar.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void N0(boolean z10) {
        this.f29932a += K0(z10);
        if (z10) {
            return;
        }
        this.f29933b = true;
    }

    public final boolean P0() {
        return this.f29932a >= K0(true);
    }

    public final boolean Q0() {
        kotlin.collections.k<b1<?>> kVar = this.f29934c;
        if (kVar != null) {
            return kVar.isEmpty();
        }
        return true;
    }

    public long R0() {
        return !S0() ? Long.MAX_VALUE : 0L;
    }

    public final boolean S0() {
        b1<?> b1VarJ;
        kotlin.collections.k<b1<?>> kVar = this.f29934c;
        if (kVar == null || (b1VarJ = kVar.j()) == null) {
            return false;
        }
        b1VarJ.run();
        return true;
    }

    public boolean T0() {
        return false;
    }

    @Override // kotlinx.coroutines.k0
    @NotNull
    public final k0 limitedParallelism(int i10) {
        u9.p.a(i10);
        return this;
    }

    public void shutdown() {
    }
}
