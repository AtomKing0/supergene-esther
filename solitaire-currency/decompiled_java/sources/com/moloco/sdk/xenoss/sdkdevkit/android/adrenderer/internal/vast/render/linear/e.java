package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import android.content.Context;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.p;
import h9.q;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.e0;
import s9.i0;
import s9.m0;
import s9.x;
import s9.y;
import v8.k0;
import v8.s;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f f21361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f21363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f21364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final z f21365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final o0 f21366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final x<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d> f21367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final s9.h<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d> f21368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final String f21369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final y<Boolean> f21370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f21371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final y<m<Long>> f21372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final m0<m<Long>> f21373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f21374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final String f21375o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f21376p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.b f21377q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    public final n f21378r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    public final y<Boolean> f21379s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    public final m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> f21380t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    public final y<Boolean> f21381u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f21382v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NotNull
    public final j f21383w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotNull
    public final g f21384x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f21385y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f21386z;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearControllerImpl$1", f = "LinearControllerImpl.kt", l = {}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements p<Boolean, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21387j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f21388k;

        public a(z8.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = e.this.new a(dVar);
            aVar.f21388k = ((Boolean) obj).booleanValue();
            return aVar;
        }

        @Nullable
        public final Object f(boolean z10, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(Boolean.valueOf(z10), dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super k0> dVar) {
            return f(bool.booleanValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f21387j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            if (this.f21388k) {
                e.this.f21383w.g(kotlin.coroutines.jvm.internal.b.d(e.this.R()), e.this.f21369i);
            } else {
                e.this.f21383w.f(kotlin.coroutines.jvm.internal.b.d(e.this.R()), e.this.f21369i);
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearControllerImpl$onEvent$1", f = "LinearControllerImpl.kt", l = {53}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21390j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d f21392l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar, z8.d<? super b> dVar2) {
            super(2, dVar2);
            this.f21392l = dVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return e.this.new b(this.f21392l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21390j;
            if (i10 == 0) {
                u.b(obj);
                x xVar = e.this.f21367g;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar = this.f21392l;
                this.f21390j = 1;
                if (xVar.emit(dVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearControllerImpl$vastPrivacyIcon$1", f = "LinearControllerImpl.kt", l = {}, m = "invokeSuspend")
    public static final class c extends kotlin.coroutines.jvm.internal.l implements q<Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21393j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f21394k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f21395l;

        public c(z8.d<? super c> dVar) {
            super(3, dVar);
        }

        @Nullable
        public final Object f(boolean z10, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, @Nullable z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> dVar) {
            c cVar = new c(dVar);
            cVar.f21394k = z10;
            cVar.f21395l = jVar;
            return cVar.invokeSuspend(k0.f35197a);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> dVar) {
            return f(bool.booleanValue(), jVar, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f21393j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            boolean z10 = this.f21394k;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j) this.f21395l;
            if (z10) {
                return jVar;
            }
            return null;
        }
    }

    public static final class d extends v implements h9.a<k0> {
        public d() {
            super(0);
        }

        public final void b() {
            e.this.f21377q.a(Integer.valueOf(e.this.R()), e.this.f21369i);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.e$e, reason: collision with other inner class name */
    public static final class C0465e extends v implements h9.a<k0> {
        public C0465e() {
            super(0);
        }

        public final void b() {
            e.this.f21377q.b(Integer.valueOf(e.this.R()), e.this.f21369i);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }
    }

    public e(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f linear, int i10, boolean z10, @Nullable Boolean bool, int i11, boolean z11, boolean z12, @NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull z externalLinkHandler) {
        String absolutePath;
        t.i(linear, "linear");
        t.i(context, "context");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(externalLinkHandler, "externalLinkHandler");
        this.f21361a = linear;
        this.f21362b = z11;
        this.f21363c = z12;
        this.f21364d = customUserEventBuilderService;
        this.f21365e = externalLinkHandler;
        o0 o0VarA = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f21366f = o0VarA;
        x<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d> xVarB = e0.b(0, 0, null, 7, null);
        this.f21367g = xVarB;
        this.f21368h = xVarB;
        this.f21369i = linear.g();
        y<Boolean> yVarA = s9.o0.a(Boolean.valueOf(z10));
        this.f21370j = yVarA;
        this.f21371k = yVarA;
        y<m<Long>> yVarA2 = s9.o0.a(new m(Long.valueOf(i10)));
        this.f21372l = yVarA2;
        this.f21373m = s9.j.c(yVarA2);
        this.f21374n = a.g.f18914a.b().d();
        if (E()) {
            absolutePath = linear.g();
        } else {
            absolutePath = linear.e().getAbsolutePath();
            t.h(absolutePath, "linear.localMediaResource.absolutePath");
        }
        this.f21375o = absolutePath;
        this.f21376p = linear.c() != null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarD = linear.d();
        List<String> listB = eVarD != null ? eVarD.b() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarD2 = linear.d();
        this.f21377q = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.b(listB, eVarD2 != null ? eVarD2.g() : null, null, 4, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarD3 = linear.d();
        a0 a0VarF = eVarD3 != null ? eVarD3.f() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarD4 = linear.d();
        Integer numValueOf = eVarD4 != null ? Integer.valueOf(eVarD4.h()) : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarD5 = linear.d();
        Integer numValueOf2 = eVarD5 != null ? Integer.valueOf(eVarD5.d()) : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarD6 = linear.d();
        n nVarA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.p.a(a0VarF, numValueOf, numValueOf2, eVarD6 != null ? eVarD6.a() : null, o0VarA, context, customUserEventBuilderService, externalLinkHandler, new d(), new C0465e());
        this.f21378r = nVarA;
        Boolean bool2 = Boolean.FALSE;
        y<Boolean> yVarA3 = s9.o0.a(bool2);
        this.f21379s = yVarA3;
        this.f21380t = s9.j.L(s9.j.m(yVarA3, nVarA.G(), new c(null)), o0VarA, i0.a.b(i0.f33702a, 0L, 0L, 3, null), null);
        y<Boolean> yVarA4 = s9.o0.a(bool2);
        this.f21381u = yVarA4;
        this.f21382v = yVarA4;
        this.f21383w = j.f21411p.a(linear.i(), customUserEventBuilderService);
        s9.j.D(s9.j.G(isPlaying(), new a(null)), o0VarA);
        this.f21384x = i.d(bool, i11, linear.h());
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public boolean C() {
        return this.f21376p;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public boolean E() {
        return this.f21374n;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    @NotNull
    public m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> G() {
        return this.f21380t;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void H(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress) {
        s sVarA;
        t.i(progress, "progress");
        boolean z10 = progress instanceof i.a;
        if (z10) {
            int iA = (int) ((i.a) progress).a();
            sVarA = v8.y.a(Integer.valueOf(iA), Integer.valueOf(iA));
        } else if (progress instanceof i.c) {
            i.c cVar = (i.c) progress;
            sVarA = v8.y.a(Integer.valueOf((int) cVar.a()), Integer.valueOf((int) cVar.b()));
        } else {
            if (!(progress instanceof i.d)) {
                if (!t.d(progress, i.b.f21315a)) {
                    throw new v8.q();
                }
                return;
            }
            sVarA = v8.y.a(0, Integer.valueOf((int) ((i.d) progress).a()));
        }
        int iIntValue = ((Number) sVarA.a()).intValue();
        int iIntValue2 = ((Number) sVarA.b()).intValue();
        this.f21386z = iIntValue;
        if (!this.f21385y && !(progress instanceof i.d)) {
            this.f21383w.d(this.f21369i, iIntValue, iIntValue2);
        }
        if (z10) {
            if (!this.f21385y) {
                W(d.b.f21357a);
                T();
            }
            this.f21385y = false;
        }
        this.f21384x.a(iIntValue, iIntValue2);
        Z(iIntValue, iIntValue2);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void I(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l error) {
        t.i(error, "error");
        W(new d.C0464d(error));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    @NotNull
    public m0<m<Long>> J() {
        return this.f21373m;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public void L(@NotNull a.AbstractC0481a.f position) {
        t.i(position, "position");
        X(true, position);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void N(boolean z10) {
        this.f21381u.setValue(Boolean.valueOf(z10));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void O() {
        this.f21384x.t();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void P() {
        this.f21384x.pause();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    @NotNull
    public String Q() {
        return this.f21375o;
    }

    public int R() {
        return this.f21386z;
    }

    public final void S() {
        this.f21379s.setValue(Boolean.FALSE);
    }

    public final void T() {
        if (this.f21363c) {
            X(false, f.a());
        }
    }

    public final void U() {
        if (this.f21362b) {
            X(false, f.a());
        }
    }

    public final b2 W(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar) {
        return kotlinx.coroutines.k.d(this.f21366f, null, null, new b(dVar, null), 3, null);
    }

    public final void X(boolean z10, a.AbstractC0481a.f fVar) {
        String strC = this.f21361a.c();
        if (strC != null) {
            if (z10) {
                this.f21383w.c(fVar, Integer.valueOf(R()), this.f21369i);
            }
            this.f21365e.a(strC);
            W(d.a.f21356a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z(int r9, int r10) {
        /*
            r8 = this;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f r0 = r8.f21361a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e r0 = r0.d()
            if (r0 != 0) goto L9
            return
        L9:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t r1 = r0.e()
            java.lang.Long r0 = r0.c()
            boolean r2 = r1 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t.a
            r3 = 0
            if (r2 == 0) goto L20
            int r2 = r10 / 100
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t$a r1 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t.a) r1
            int r1 = r1.a()
            int r2 = r2 * r1
            goto L2d
        L20:
            boolean r2 = r1 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t.b
            if (r2 == 0) goto L2c
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t$b r1 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t.b) r1
            long r1 = r1.a()
            int r2 = (int) r1
            goto L2d
        L2c:
            r2 = r3
        L2d:
            n9.i r1 = new n9.i
            r1.<init>(r3, r10)
            int r10 = n9.m.o(r2, r1)
            s9.y<java.lang.Boolean> r1 = r8.f21379s
            if (r0 != 0) goto L3d
            if (r9 < r10) goto L4d
            goto L4c
        L3d:
            long r4 = (long) r10
            long r6 = r0.longValue()
            long r6 = r6 + r4
            long r9 = (long) r9
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 > 0) goto L4d
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 > 0) goto L4d
        L4c:
            r3 = 1
        L4d:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r3)
            r1.setValue(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.e.Z(int, int):void");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    @NotNull
    public s9.h<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d> a() {
        return this.f21368h;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void b(boolean z10) {
        this.f21370j.setValue(Boolean.valueOf(z10));
        j jVar = this.f21383w;
        if (z10) {
            jVar.e(Integer.valueOf(R()), this.f21369i);
        } else {
            jVar.j(Integer.valueOf(R()), this.f21369i);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        p0.e(this.f21366f, null, 1, null);
        this.f21378r.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void g() {
        this.f21385y = true;
        this.f21383w.i(Integer.valueOf(R()), this.f21369i);
        W(d.e.f21360a);
        U();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void h() {
        this.f21378r.h();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    @NotNull
    public m0<Boolean> isPlaying() {
        return this.f21382v;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void j(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        t.i(buttonType, "buttonType");
        this.f21383w.a(buttonType);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    @NotNull
    public m0<d.a> l() {
        return this.f21384x.l();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    @NotNull
    public m0<Boolean> q() {
        return this.f21371k;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    public void r() {
        if (!isPlaying().getValue().booleanValue() && this.f21372l.getValue().a().longValue() == 0 && R() == 0) {
            return;
        }
        this.f21372l.setValue(new m<>(0L));
        this.f21383w.h(Integer.valueOf(R()), this.f21369i);
        this.f21385y = false;
        this.f21386z = 0;
        this.f21384x.m();
        S();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void v() {
        this.f21378r.v();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void b() {
        W(d.c.f21358a);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void g(@NotNull a.AbstractC0481a.c button) {
        t.i(button, "button");
        this.f21383w.b(button);
    }
}
