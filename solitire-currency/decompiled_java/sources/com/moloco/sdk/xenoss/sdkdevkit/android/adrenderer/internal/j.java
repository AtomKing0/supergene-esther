package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.ortb.model.c f19271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final o0 f19272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d f19273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final u f19274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f19275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> f19276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final s9.y<Boolean> f19277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public b2 f19279i;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1", f = "VastAdLoad.kt", l = {80, 94}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19280j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19281k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ b.a f19283m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ long f19284n;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$decDeferred$1", f = "VastAdLoad.kt", l = {70}, m = "invokeSuspend")
        public static final class C0367a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super s>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19285j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ long f19286k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ s f19287l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ j f19288m;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j$a$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$decDeferred$1$1", f = "VastAdLoad.kt", l = {72}, m = "invokeSuspend")
            public static final class C0368a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super s>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19289j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ s f19290k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ j f19291l;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0368a(s sVar, j jVar, z8.d<? super C0368a> dVar) {
                    super(2, dVar);
                    this.f19290k = sVar;
                    this.f19291l = jVar;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super s> dVar) {
                    return ((C0368a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C0368a(this.f19290k, this.f19291l, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.f19289j;
                    if (i10 == 0) {
                        v8.u.b(obj);
                        s sVar = this.f19290k;
                        if (sVar == null) {
                            return null;
                        }
                        j jVar = this.f19291l;
                        u uVar = jVar.f19274d;
                        com.moloco.sdk.internal.ortb.model.d dVarD = jVar.f19271a.d();
                        String strC = dVarD != null ? dVarD.c() : null;
                        this.f19289j = 1;
                        obj = uVar.a(sVar, strC, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v8.u.b(obj);
                    }
                    return (s) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0367a(long j10, s sVar, j jVar, z8.d<? super C0367a> dVar) {
                super(2, dVar);
                this.f19286k = j10;
                this.f19287l = sVar;
                this.f19288m = jVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super s> dVar) {
                return ((C0367a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0367a(this.f19286k, this.f19287l, this.f19288m, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19285j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    long j10 = this.f19286k;
                    C0368a c0368a = new C0368a(this.f19287l, this.f19288m, null);
                    this.f19285j = 1;
                    obj = f3.f(j10, c0368a, this);
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
                return sVar == null ? this.f19287l : sVar;
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$vastAdDeferred$1", f = "VastAdLoad.kt", l = {62}, m = "invokeSuspend")
        public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19292j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ long f19293k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ j f19294l;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j$a$b$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$vastAdDeferred$1$1", f = "VastAdLoad.kt", l = {63}, m = "invokeSuspend")
            public static final class C0369a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19295j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ j f19296k;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0369a(j jVar, z8.d<? super C0369a> dVar) {
                    super(2, dVar);
                    this.f19296k = jVar;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> dVar) {
                    return ((C0369a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C0369a(this.f19296k, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.f19295j;
                    if (i10 == 0) {
                        v8.u.b(obj);
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar = this.f19296k.f19273c;
                        String strA = this.f19296k.f19271a.a();
                        String strA2 = com.moloco.sdk.internal.ortb.model.f.a(this.f19296k.f19271a);
                        this.f19295j = 1;
                        obj = dVar.a(strA, strA2, false, this);
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
            public b(long j10, j jVar, z8.d<? super b> dVar) {
                super(2, dVar);
                this.f19293k = j10;
                this.f19294l = jVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> dVar) {
                return ((b) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new b(this.f19293k, this.f19294l, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19292j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    long j10 = this.f19293k;
                    C0369a c0369a = new C0369a(this.f19294l, null);
                    this.f19292j = 1;
                    obj = f3.d(j10, c0369a, this);
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
            this.f19283m = aVar;
            this.f19284n = j10;
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
            a aVar = j.this.new a(this.f19283m, this.f19284n, dVar);
            aVar.f19281k = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0117  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 285
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1", f = "VastAdLoad.kt", l = {118, 133, 135}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f19297j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f19298k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f19299l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ b.a f19301n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ long f19302o;

        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1$decDeferred$1", f = "VastAdLoad.kt", l = {122}, m = "invokeSuspend")
        public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super s>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f19303j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ long f19304k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ s f19305l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ j f19306m;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j$b$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1$decDeferred$1$1", f = "VastAdLoad.kt", l = {124}, m = "invokeSuspend")
            public static final class C0370a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super s>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public int f19307j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ s f19308k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ j f19309l;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0370a(s sVar, j jVar, z8.d<? super C0370a> dVar) {
                    super(2, dVar);
                    this.f19308k = sVar;
                    this.f19309l = jVar;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super s> dVar) {
                    return ((C0370a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C0370a(this.f19308k, this.f19309l, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.f19307j;
                    if (i10 == 0) {
                        v8.u.b(obj);
                        s sVar = this.f19308k;
                        if (sVar == null) {
                            return null;
                        }
                        j jVar = this.f19309l;
                        u uVar = jVar.f19274d;
                        com.moloco.sdk.internal.ortb.model.d dVarD = jVar.f19271a.d();
                        String strC = dVarD != null ? dVarD.c() : null;
                        this.f19307j = 1;
                        obj = uVar.a(sVar, strC, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v8.u.b(obj);
                    }
                    return (s) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j10, s sVar, j jVar, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f19304k = j10;
                this.f19305l = sVar;
                this.f19306m = jVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super s> dVar) {
                return ((a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new a(this.f19304k, this.f19305l, this.f19306m, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f19303j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    long j10 = this.f19304k;
                    C0370a c0370a = new C0370a(this.f19305l, this.f19306m, null);
                    this.f19303j = 1;
                    obj = f3.f(j10, c0370a, this);
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
                return sVar == null ? this.f19305l : sVar;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b.a aVar, long j10, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f19301n = aVar;
            this.f19302o = j10;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = j.this.new b(this.f19301n, this.f19302o, dVar);
            bVar.f19299l = obj;
            return bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0124  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 377
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public j(@NotNull com.moloco.sdk.internal.ortb.model.c bid, @NotNull o0 scope, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d loadVast, @NotNull u decLoader, boolean z10) {
        kotlin.jvm.internal.t.i(bid, "bid");
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(loadVast, "loadVast");
        kotlin.jvm.internal.t.i(decLoader, "decLoader");
        this.f19271a = bid;
        this.f19272b = scope;
        this.f19273c = loadVast;
        this.f19274d = decLoader;
        this.f19275e = z10;
        this.f19276f = new t.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_INCOMPLETE_ERROR);
        s9.y<Boolean> yVarA = s9.o0.a(Boolean.FALSE);
        this.f19277g = yVarA;
        this.f19278h = s9.j.c(yVarA);
    }

    @NotNull
    public final com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> b() {
        return this.f19276f;
    }

    public final void c(@NotNull com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> tVar) {
        kotlin.jvm.internal.t.i(tVar, "<set-?>");
        this.f19276f = tVar;
    }

    public final void e(v0<s> v0Var, b.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        MolocoLogger.error$default(MolocoLogger.INSTANCE, "VastAdLoad", "Vast AD failed to load: " + cVar, null, false, 12, null);
        b2.a.a(v0Var, null, 1, null);
        this.f19276f = new t.a(cVar);
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    public void g(long j10, @Nullable b.a aVar) {
        if (this.f19275e) {
            m(j10, aVar);
        } else {
            i(j10, aVar);
        }
    }

    public final void i(long j10, b.a aVar) {
        b2 b2Var = this.f19279i;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.f19279i = kotlinx.coroutines.k.d(this.f19272b, null, null, new a(aVar, j10, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b
    @NotNull
    public m0<Boolean> isLoaded() {
        return this.f19278h;
    }

    public final void k(v0<s> v0Var, b.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        b2.a.a(v0Var, null, 1, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.VAST_AD_LOAD_INTERNAL_TIMEOUT_ERROR;
        this.f19276f = new t.a(cVar);
        if (aVar != null) {
            aVar.b(aVar2);
        }
    }

    public final void m(long j10, b.a aVar) {
        b2 b2Var = this.f19279i;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.f19279i = kotlinx.coroutines.k.d(this.f19272b, null, null, new b(aVar, j10, null), 3, null);
    }
}
