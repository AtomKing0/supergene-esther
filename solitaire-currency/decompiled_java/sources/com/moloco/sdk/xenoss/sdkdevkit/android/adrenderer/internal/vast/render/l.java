package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.x;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt", f = "PreparedVastResource.kt", l = {74, 137}, m = "prepareVastResource")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f21325j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f21326k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f21327l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f21328m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f21329n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f21330o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Object f21331p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f21332q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public /* synthetic */ Object f21333r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f21334s;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21333r = obj;
            this.f21334s |= Integer.MIN_VALUE;
            return l.b(null, null, null, null, 0, 0, null, null, false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$2", f = "PreparedVastResource.kt", l = {}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21335j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ n0<String> f21336k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ a0 f21337l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n0<String> n0Var, a0 a0Var, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f21336k = n0Var;
            this.f21337l = a0Var;
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
            return new b(this.f21336k, this.f21337l, dVar);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f21335j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.f21336k.f29834a = l.d(this.f21337l);
            return k0.f35197a;
        }
    }

    public static final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Integer f21338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m> f21339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i> f21340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ n0<o0> f21341d;

        public c(Integer num, n0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m> n0Var, n0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i> n0Var2, n0<o0> n0Var3) {
            this.f21338a = num;
            this.f21339b = n0Var;
            this.f21340c = n0Var2;
            this.f21341d = n0Var3;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
        public void destroy() {
            Integer num = this.f21338a;
            if (num != null) {
                x.f21624a.c(num.intValue());
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m mVar = this.f21339b.f29834a;
            if (mVar != null) {
                mVar.destroy();
            }
            this.f21339b.f29834a = null;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i iVar = this.f21340c.f29834a;
            if (iVar != null) {
                iVar.destroy();
            }
            this.f21340c.f29834a = null;
            o0 o0Var = this.f21341d.f29834a;
            if (o0Var != null) {
                p0.e(o0Var, null, 1, null);
            }
            this.f21341d.f29834a = null;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$webView$1$1", f = "PreparedVastResource.kt", l = {}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements h9.p<k0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21342j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21343k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(h9.a<k0> aVar, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f21343k = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new d(this.f21343k, dVar);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull k0 k0Var, @Nullable z8.d<? super k0> dVar) {
            return ((d) create(k0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f21342j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.f21343k.invoke();
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$webView$1$2", f = "PreparedVastResource.kt", l = {107}, m = "invokeSuspend")
    public static final class e extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21344j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a f21345k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, k0> f21346l;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.PreparedVastResourceKt$prepareVastResource$webView$1$2$1", f = "PreparedVastResource.kt", l = {}, m = "invokeSuspend")
        public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f21347j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public /* synthetic */ Object f21348k;

            public a(z8.d<? super a> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                a aVar = new a(dVar);
                aVar.f21348k = obj;
                return aVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar, @Nullable z8.d<? super Boolean> dVar) {
                return ((a) create(gVar, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f21347j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) this.f21348k) != null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar, h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, k0> lVar, z8.d<? super e> dVar) {
            super(2, dVar);
            this.f21345k = aVar;
            this.f21346l = lVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((e) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new e(this.f21345k, this.f21346l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f21344j;
            if (i10 == 0) {
                u.b(obj);
                m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> unrecoverableError = this.f21345k.getUnrecoverableError();
                a aVar = new a(null);
                this.f21344j = 1;
                obj = s9.j.v(unrecoverableError, aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) obj;
            if (gVar != null) {
                this.f21346l.invoke(gVar);
            }
            return k0.f35197a;
        }
    }

    @Nullable
    public static final j a(@NotNull a0 a0Var, int i10, int i11) {
        t.i(a0Var, "<this>");
        if (a0Var instanceof a0.c) {
            a0.c cVar = (a0.c) a0Var;
            if (cVar.a().a() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k.Image) {
                return new j.b(cVar.a().b(), i10, i11);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.m] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i] */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, kotlinx.coroutines.o0] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.x] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(@org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0 r27, @org.jetbrains.annotations.NotNull android.content.Context r28, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a r29, @org.jetbrains.annotations.NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z r30, int r31, int r32, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r33, @org.jetbrains.annotations.NotNull h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c, v8.k0> r34, boolean r35, @org.jetbrains.annotations.NotNull z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.k> r36) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.l.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0, android.content.Context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z, int, int, h9.a, h9.l, boolean, z8.d):java.lang.Object");
    }

    @Nullable
    public static final String d(@NotNull a0 a0Var) {
        t.i(a0Var, "<this>");
        if (a0Var instanceof a0.a) {
            a0.a aVar = (a0.a) a0Var;
            if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.q.f19696a.a(aVar.a().a())) {
                return aVar.a().a();
            }
        } else if (a0Var instanceof a0.b) {
            a0.b bVar = (a0.b) a0Var;
            if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.q.f19696a.a(bVar.a().a())) {
                return bVar.a().a();
            }
        } else {
            if (!(a0Var instanceof a0.c)) {
                throw new v8.q();
            }
            a0.c cVar = (a0.c) a0Var;
            if (cVar.a().a() == com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k.JS && com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.q.f19696a.a(cVar.a().b())) {
                return cVar.a().b();
            }
        }
        return null;
    }

    public static final class f extends v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final f f21349g = new f();

        public f() {
            super(0);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }

        public final void b() {
        }
    }

    public static final class g extends v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final g f21350g = new g();

        public g() {
            super(0);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }

        public final void b() {
        }
    }
}
