package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d extends a {

    @Nullable
    private final z8.g _context;

    @Nullable
    private transient z8.d<Object> intercepted;

    public d(@Nullable z8.d<Object> dVar, @Nullable z8.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // z8.d
    @NotNull
    public z8.g getContext() {
        z8.g gVar = this._context;
        t.f(gVar);
        return gVar;
    }

    @NotNull
    public final z8.d<Object> intercepted() {
        z8.d<Object> dVarInterceptContinuation = this.intercepted;
        if (dVarInterceptContinuation == null) {
            z8.e eVar = (z8.e) getContext().get(z8.e.R7);
            if (eVar == null || (dVarInterceptContinuation = eVar.interceptContinuation(this)) == null) {
                dVarInterceptContinuation = this;
            }
            this.intercepted = dVarInterceptContinuation;
        }
        return dVarInterceptContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    protected void releaseIntercepted() {
        z8.d<?> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            g.b bVar = getContext().get(z8.e.R7);
            t.f(bVar);
            ((z8.e) bVar).releaseInterceptedContinuation(dVar);
        }
        this.intercepted = c.f29804a;
    }

    public d(@Nullable z8.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
