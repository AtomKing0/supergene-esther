package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h3<T> extends u9.d0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final ThreadLocal<v8.s<z8.g, Object>> f29904e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public h3(@NotNull z8.g gVar, @NotNull z8.d<? super T> dVar) {
        i3 i3Var = i3.f29907a;
        super(gVar.get(i3Var) == null ? gVar.plus(i3Var) : gVar, dVar);
        this.f29904e = new ThreadLocal<>();
        if (dVar.getContext().get(z8.e.R7) instanceof k0) {
            return;
        }
        Object objC = u9.l0.c(gVar, null);
        u9.l0.a(gVar, objC);
        V0(gVar, objC);
    }

    @Override // u9.d0, kotlinx.coroutines.a
    protected void Q0(@Nullable Object obj) {
        if (this.threadLocalIsSet) {
            v8.s<z8.g, Object> sVar = this.f29904e.get();
            if (sVar != null) {
                u9.l0.a(sVar.a(), sVar.b());
            }
            this.f29904e.remove();
        }
        Object objA = g0.a(obj, this.f34650d);
        z8.d<T> dVar = this.f34650d;
        z8.g context = dVar.getContext();
        Object objC = u9.l0.c(context, null);
        h3<?> h3VarG = objC != u9.l0.f34671a ? j0.g(dVar, context, objC) : null;
        try {
            this.f34650d.resumeWith(objA);
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            if (h3VarG == null || h3VarG.U0()) {
                u9.l0.a(context, objC);
            }
        }
    }

    public final boolean U0() {
        boolean z10 = this.threadLocalIsSet && this.f29904e.get() == null;
        this.f29904e.remove();
        return !z10;
    }

    public final void V0(@NotNull z8.g gVar, @Nullable Object obj) {
        this.threadLocalIsSet = true;
        this.f29904e.set(v8.y.a(gVar, obj));
    }
}
