package ma;

import ga.b0;
import ga.d0;
import ga.w;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RealInterceptorChain.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final la.e f31483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<w> f31484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f31485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final la.c f31486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final b0 f31487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f31488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f31489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f31490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31491i;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull la.e call, @NotNull List<? extends w> interceptors, int i10, @Nullable la.c cVar, @NotNull b0 request, int i11, int i12, int i13) {
        t.i(call, "call");
        t.i(interceptors, "interceptors");
        t.i(request, "request");
        this.f31483a = call;
        this.f31484b = interceptors;
        this.f31485c = i10;
        this.f31486d = cVar;
        this.f31487e = request;
        this.f31488f = i11;
        this.f31489g = i12;
        this.f31490h = i13;
    }

    public static /* synthetic */ g d(g gVar, int i10, la.c cVar, b0 b0Var, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = gVar.f31485c;
        }
        if ((i14 & 2) != 0) {
            cVar = gVar.f31486d;
        }
        la.c cVar2 = cVar;
        if ((i14 & 4) != 0) {
            b0Var = gVar.f31487e;
        }
        b0 b0Var2 = b0Var;
        if ((i14 & 8) != 0) {
            i11 = gVar.f31488f;
        }
        int i15 = i11;
        if ((i14 & 16) != 0) {
            i12 = gVar.f31489g;
        }
        int i16 = i12;
        if ((i14 & 32) != 0) {
            i13 = gVar.f31490h;
        }
        return gVar.c(i10, cVar2, b0Var2, i15, i16, i13);
    }

    @Override // ga.w.a
    @NotNull
    public b0 a() {
        return this.f31487e;
    }

    @Override // ga.w.a
    @NotNull
    public d0 b(@NotNull b0 request) throws IOException {
        t.i(request, "request");
        if (!(this.f31485c < this.f31484b.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f31491i++;
        la.c cVar = this.f31486d;
        if (cVar != null) {
            if (!cVar.j().g(request.k())) {
                throw new IllegalStateException(("network interceptor " + this.f31484b.get(this.f31485c - 1) + " must retain the same host and port").toString());
            }
            if (!(this.f31491i == 1)) {
                throw new IllegalStateException(("network interceptor " + this.f31484b.get(this.f31485c - 1) + " must call proceed() exactly once").toString());
            }
        }
        g gVarD = d(this, this.f31485c + 1, null, request, 0, 0, 0, 58, null);
        w wVar = this.f31484b.get(this.f31485c);
        d0 d0VarIntercept = wVar.intercept(gVarD);
        if (d0VarIntercept == null) {
            throw new NullPointerException("interceptor " + wVar + " returned null");
        }
        if (this.f31486d != null) {
            if (!(this.f31485c + 1 >= this.f31484b.size() || gVarD.f31491i == 1)) {
                throw new IllegalStateException(("network interceptor " + wVar + " must call proceed() exactly once").toString());
            }
        }
        if (d0VarIntercept.a() != null) {
            return d0VarIntercept;
        }
        throw new IllegalStateException(("interceptor " + wVar + " returned a response with no body").toString());
    }

    @NotNull
    public final g c(int i10, @Nullable la.c cVar, @NotNull b0 request, int i11, int i12, int i13) {
        t.i(request, "request");
        return new g(this.f31483a, this.f31484b, i10, cVar, request, i11, i12, i13);
    }

    @Override // ga.w.a
    @NotNull
    public ga.e call() {
        return this.f31483a;
    }

    @NotNull
    public final la.e e() {
        return this.f31483a;
    }

    public final int f() {
        return this.f31488f;
    }

    @Nullable
    public final la.c g() {
        return this.f31486d;
    }

    public final int h() {
        return this.f31489g;
    }

    @NotNull
    public final b0 i() {
        return this.f31487e;
    }

    public final int j() {
        return this.f31490h;
    }

    public int k() {
        return this.f31489g;
    }
}
