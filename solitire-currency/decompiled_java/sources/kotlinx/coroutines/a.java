package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractCoroutine.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> extends j2 implements z8.d<T>, o0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final z8.g f29849c;

    public a(@NotNull z8.g gVar, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            k0((b2) gVar.get(b2.O7));
        }
        this.f29849c = gVar.plus(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.j2
    @NotNull
    public String M() {
        return s0.a(this) + " was cancelled";
    }

    protected void Q0(@Nullable Object obj) {
        C(obj);
    }

    public final <R> void T0(@NotNull q0 q0Var, R r10, @NotNull h9.p<? super R, ? super z8.d<? super T>, ? extends Object> pVar) {
        q0Var.c(pVar, r10, this);
    }

    @Override // z8.d
    @NotNull
    public final z8.g getContext() {
        return this.f29849c;
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.f29849c;
    }

    @Override // kotlinx.coroutines.j2, kotlinx.coroutines.b2
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.j2
    public final void j0(@NotNull Throwable th) {
        m0.a(this.f29849c, th);
    }

    @Override // z8.d
    public final void resumeWith(@NotNull Object obj) {
        Object objR0 = r0(g0.d(obj, null, 1, null));
        if (objR0 == k2.f29936b) {
            return;
        }
        Q0(objR0);
    }

    @Override // kotlinx.coroutines.j2
    @NotNull
    public String t0() {
        String strB = j0.b(this.f29849c);
        if (strB == null) {
            return super.t0();
        }
        return '\"' + strB + "\":" + super.t0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.j2
    protected final void y0(@Nullable Object obj) {
        if (!(obj instanceof c0)) {
            S0(obj);
        } else {
            c0 c0Var = (c0) obj;
            R0(c0Var.f29865a, c0Var.a());
        }
    }

    protected void S0(T t10) {
    }

    protected void R0(@NotNull Throwable th, boolean z10) {
    }
}
