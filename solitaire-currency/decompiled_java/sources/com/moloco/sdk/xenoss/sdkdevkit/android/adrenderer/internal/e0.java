package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.moloco.sdk.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
public final class e0 implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final o0 f19098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final com.moloco.sdk.internal.ortb.model.c f19099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final u f19100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final h9.l<z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> f19101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> f19104g;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1", f = "MraidAdLoad.kt", l = {60, 80}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f19105j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f19106k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f19107l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ b.a f19109n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ long f19110o;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e0$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$decDeferred$1", f = "MraidAdLoad.kt", l = {48}, m = "invokeSuspend")
        public static final class C0362a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super s>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19111j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ long f19112k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ s f19113l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ e0 f19114m;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e0$a$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$decDeferred$1$1", f = "MraidAdLoad.kt", l = {51}, m = "invokeSuspend")
            public static final class C0363a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super s>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public Object f19115j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public int f19116k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ s f19117l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ e0 f19118m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0363a(s sVar, e0 e0Var, z8.d<? super C0363a> dVar) {
                    super(2, dVar);
                    this.f19117l = sVar;
                    this.f19118m = e0Var;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super s> dVar) {
                    return ((C0363a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C0363a(this.f19117l, this.f19118m, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    s sVar;
                    com.moloco.sdk.internal.ortb.model.d dVarD;
                    Object objE = a9.d.e();
                    int i10 = this.f19116k;
                    if (i10 == 0) {
                        v8.u.b(obj);
                        s sVar2 = this.f19117l;
                        String strC = null;
                        if (sVar2 == null) {
                            return null;
                        }
                        e0 e0Var = this.f19118m;
                        try {
                            u uVar = e0Var.f19100c;
                            com.moloco.sdk.internal.ortb.model.c cVar = e0Var.f19099b;
                            if (cVar != null && (dVarD = cVar.d()) != null) {
                                strC = dVarD.c();
                            }
                            this.f19115j = sVar2;
                            this.f19116k = 1;
                            Object objA = uVar.a(sVar2, strC, this);
                            if (objA == objE) {
                                return objE;
                            }
                            sVar = sVar2;
                            obj = objA;
                        } catch (Exception unused) {
                            return sVar2;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        sVar = (s) this.f19115j;
                        try {
                            v8.u.b(obj);
                        } catch (Exception unused2) {
                            return sVar;
                        }
                    }
                    return (s) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0362a(long j10, s sVar, e0 e0Var, z8.d<? super C0362a> dVar) {
                super(2, dVar);
                this.f19112k = j10;
                this.f19113l = sVar;
                this.f19114m = e0Var;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super s> dVar) {
                return ((C0362a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0362a(this.f19112k, this.f19113l, this.f19114m, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19111j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    long j10 = this.f19112k;
                    C0363a c0363a = new C0363a(this.f19113l, this.f19114m, null);
                    this.f19111j = 1;
                    obj = f3.f(j10, c0363a, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                s sVar = (s) obj;
                return sVar == null ? this.f19113l : sVar;
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$mraidLoadResultDeferred$1", f = "MraidAdLoad.kt", l = {39}, m = "invokeSuspend")
        public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19119j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ long f19120k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ e0 f19121l;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e0$a$b$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$mraidLoadResultDeferred$1$1", f = "MraidAdLoad.kt", l = {40}, m = "invokeSuspend")
            public static final class C0364a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19122j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ e0 f19123k;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0364a(e0 e0Var, z8.d<? super C0364a> dVar) {
                    super(2, dVar);
                    this.f19123k = e0Var;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar) {
                    return ((C0364a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C0364a(this.f19123k, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.f19122j;
                    if (i10 == 0) {
                        v8.u.b(obj);
                        h9.l lVar = this.f19123k.f19101d;
                        this.f19122j = 1;
                        obj = lVar.invoke(this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v8.u.b(obj);
                    }
                    return obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j10, e0 e0Var, z8.d<? super b> dVar) {
                super(2, dVar);
                this.f19120k = j10;
                this.f19121l = e0Var;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar) {
                return ((b) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new b(this.f19120k, this.f19121l, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19119j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    long j10 = this.f19120k;
                    C0364a c0364a = new C0364a(this.f19121l, null);
                    this.f19119j = 1;
                    obj = f3.f(j10, c0364a, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b.a aVar, long j10, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f19109n = aVar;
            this.f19110o = j10;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = e0.this.new a(this.f19109n, this.f19110o, dVar);
            aVar.f19107l = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x011c  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 290
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e0(@NotNull o0 scope, @Nullable com.moloco.sdk.internal.ortb.model.c cVar, @NotNull u decLoader, @NotNull h9.l<? super z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, ? extends Object> loadAndReadyMraid) {
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(decLoader, "decLoader");
        kotlin.jvm.internal.t.i(loadAndReadyMraid, "loadAndReadyMraid");
        this.f19098a = scope;
        this.f19099b = cVar;
        this.f19100c = decLoader;
        this.f19101d = loadAndReadyMraid;
        s9.y<Boolean> yVarA = s9.o0.a(Boolean.FALSE);
        this.f19102e = yVarA;
        this.f19103f = yVarA;
        this.f19104g = new t.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.MRAID_FULLSCREEN_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR);
    }

    @NotNull
    public final com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> b() {
        return this.f19104g;
    }

    public final void c(@NotNull com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> tVar) {
        kotlin.jvm.internal.t.i(tVar, "<set-?>");
        this.f19104g = tVar;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void g(long j10, @Nullable b.a aVar) {
        kotlinx.coroutines.k.d(this.f19098a, null, null, new a(aVar, j10, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    @NotNull
    public m0<Boolean> isLoaded() {
        return this.f19103f;
    }
}
