package q;

import java.util.List;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q.b;
import v.i;
import v.k;

/* JADX INFO: compiled from: RealInterceptorChain.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final i f33059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<b> f33060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f33061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final i f33062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final w.i f33063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final j.c f33064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f33065g;

    /* JADX INFO: compiled from: RealInterceptorChain.kt */
    @f(c = "coil.intercept.RealInterceptorChain", f = "RealInterceptorChain.kt", l = {25}, m = "proceed")
    static final class a extends d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33066j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33067k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f33068l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f33070n;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33068l = obj;
            this.f33070n |= Integer.MIN_VALUE;
            return c.this.f(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull i iVar, @NotNull List<? extends b> list, int i10, @NotNull i iVar2, @NotNull w.i iVar3, @NotNull j.c cVar, boolean z10) {
        this.f33059a = iVar;
        this.f33060b = list;
        this.f33061c = i10;
        this.f33062d = iVar2;
        this.f33063e = iVar3;
        this.f33064f = cVar;
        this.f33065g = z10;
    }

    private final void a(i iVar, b bVar) {
        if (!(iVar.l() == this.f33059a.l())) {
            throw new IllegalStateException(("Interceptor '" + bVar + "' cannot modify the request's context.").toString());
        }
        if (!(iVar.m() != k.f34937a)) {
            throw new IllegalStateException(("Interceptor '" + bVar + "' cannot set the request's data to null.").toString());
        }
        if (!(iVar.M() == this.f33059a.M())) {
            throw new IllegalStateException(("Interceptor '" + bVar + "' cannot modify the request's target.").toString());
        }
        if (!(iVar.z() == this.f33059a.z())) {
            throw new IllegalStateException(("Interceptor '" + bVar + "' cannot modify the request's lifecycle.").toString());
        }
        if (iVar.K() == this.f33059a.K()) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + bVar + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    private final c b(int i10, i iVar, w.i iVar2) {
        return new c(this.f33059a, this.f33060b, i10, iVar, iVar2, this.f33064f, this.f33065g);
    }

    static /* synthetic */ c c(c cVar, int i10, i iVar, w.i iVar2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = cVar.f33061c;
        }
        if ((i11 & 2) != 0) {
            iVar = cVar.getRequest();
        }
        if ((i11 & 4) != 0) {
            iVar2 = cVar.getSize();
        }
        return cVar.b(i10, iVar, iVar2);
    }

    @NotNull
    public final j.c d() {
        return this.f33064f;
    }

    public final boolean e() {
        return this.f33065g;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(@org.jetbrains.annotations.NotNull v.i r12, @org.jetbrains.annotations.NotNull z8.d<? super v.j> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof q.c.a
            if (r0 == 0) goto L13
            r0 = r13
            q.c$a r0 = (q.c.a) r0
            int r1 = r0.f33070n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33070n = r1
            goto L18
        L13:
            q.c$a r0 = new q.c$a
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f33068l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33070n
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r12 = r0.f33067k
            q.b r12 = (q.b) r12
            java.lang.Object r0 = r0.f33066j
            q.c r0 = (q.c) r0
            v8.u.b(r13)
            goto L74
        L31:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L39:
            v8.u.b(r13)
            int r13 = r11.f33061c
            if (r13 <= 0) goto L4c
            java.util.List<q.b> r2 = r11.f33060b
            int r13 = r13 - r3
            java.lang.Object r13 = r2.get(r13)
            q.b r13 = (q.b) r13
            r11.a(r12, r13)
        L4c:
            java.util.List<q.b> r13 = r11.f33060b
            int r2 = r11.f33061c
            java.lang.Object r13 = r13.get(r2)
            q.b r13 = (q.b) r13
            int r2 = r11.f33061c
            int r5 = r2 + 1
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r11
            r6 = r12
            q.c r12 = c(r4, r5, r6, r7, r8, r9)
            r0.f33066j = r11
            r0.f33067k = r13
            r0.f33070n = r3
            java.lang.Object r12 = r13.a(r12, r0)
            if (r12 != r1) goto L70
            return r1
        L70:
            r0 = r11
            r10 = r13
            r13 = r12
            r12 = r10
        L74:
            v.j r13 = (v.j) r13
            v.i r1 = r13.b()
            r0.a(r1, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: q.c.f(v.i, z8.d):java.lang.Object");
    }

    @Override // q.b.a
    @NotNull
    public i getRequest() {
        return this.f33062d;
    }

    @Override // q.b.a
    @NotNull
    public w.i getSize() {
        return this.f33063e;
    }
}
