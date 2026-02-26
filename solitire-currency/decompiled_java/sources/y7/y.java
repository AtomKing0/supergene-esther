package y7;

import e8.m0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: HttpTimeout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f36881d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final g8.a<y> f36882e = new g8.a<>("TimeoutPlugin");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Long f36883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Long f36884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final Long f36885c;

    /* JADX INFO: compiled from: HttpTimeout.kt */
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final C0751a f36886d = new C0751a(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private static final g8.a<a> f36887e = new g8.a<>("TimeoutConfiguration");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private Long f36888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private Long f36889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Long f36890c;

        /* JADX INFO: renamed from: y7.y$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpTimeout.kt */
        public static final class C0751a {
            private C0751a() {
            }

            public /* synthetic */ C0751a(kotlin.jvm.internal.k kVar) {
                this();
            }
        }

        public /* synthetic */ a(Long l10, Long l11, Long l12, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : l11, (i10 & 4) != 0 ? null : l12);
        }

        private final Long b(Long l10) {
            if (l10 == null || l10.longValue() > 0) {
                return l10;
            }
            throw new IllegalArgumentException("Only positive timeout values are allowed, for infinite timeout use HttpTimeout.INFINITE_TIMEOUT_MS".toString());
        }

        @NotNull
        public final y a() {
            return new y(d(), c(), e(), null);
        }

        @Nullable
        public final Long c() {
            return this.f36889b;
        }

        @Nullable
        public final Long d() {
            return this.f36888a;
        }

        @Nullable
        public final Long e() {
            return this.f36890c;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.t.d(this.f36888a, aVar.f36888a) && kotlin.jvm.internal.t.d(this.f36889b, aVar.f36889b) && kotlin.jvm.internal.t.d(this.f36890c, aVar.f36890c);
        }

        public final void f(@Nullable Long l10) {
            this.f36889b = b(l10);
        }

        public final void g(@Nullable Long l10) {
            this.f36888a = b(l10);
        }

        public final void h(@Nullable Long l10) {
            this.f36890c = b(l10);
        }

        public int hashCode() {
            Long l10 = this.f36888a;
            int iHashCode = (l10 != null ? l10.hashCode() : 0) * 31;
            Long l11 = this.f36889b;
            int iHashCode2 = (iHashCode + (l11 != null ? l11.hashCode() : 0)) * 31;
            Long l12 = this.f36890c;
            return iHashCode2 + (l12 != null ? l12.hashCode() : 0);
        }

        public a(@Nullable Long l10, @Nullable Long l11, @Nullable Long l12) {
            this.f36888a = 0L;
            this.f36889b = 0L;
            this.f36890c = 0L;
            g(l10);
            f(l11);
            h(l12);
        }
    }

    /* JADX INFO: compiled from: HttpTimeout.kt */
    public static final class b implements m<a, y>, v7.e<a> {

        /* JADX INFO: compiled from: HttpTimeout.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpTimeout$Plugin$install$1", f = "HttpTimeout.kt", l = {146, 174}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements h9.q<e0, a8.c, z8.d<? super t7.b>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36891j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36892k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f36893l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ y f36894m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            final /* synthetic */ s7.a f36895n;

            /* JADX INFO: renamed from: y7.y$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: HttpTimeout.kt */
            static final class C0752a extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ b2 f36896g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0752a(b2 b2Var) {
                    super(1);
                    this.f36896g = b2Var;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
                    invoke2(th);
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    b2.a.a(this.f36896g, null, 1, null);
                }
            }

            /* JADX INFO: renamed from: y7.y$b$a$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: HttpTimeout.kt */
            @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpTimeout$Plugin$install$1$1$killer$1", f = "HttpTimeout.kt", l = {164}, m = "invokeSuspend")
            static final class C0753b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                int f36897j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                final /* synthetic */ Long f36898k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                final /* synthetic */ a8.c f36899l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                final /* synthetic */ b2 f36900m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0753b(Long l10, a8.c cVar, b2 b2Var, z8.d<? super C0753b> dVar) {
                    super(2, dVar);
                    this.f36898k = l10;
                    this.f36899l = cVar;
                    this.f36900m = b2Var;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C0753b(this.f36898k, this.f36899l, this.f36900m, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.f36897j;
                    if (i10 == 0) {
                        v8.u.b(obj);
                        long jLongValue = this.f36898k.longValue();
                        this.f36897j = 1;
                        if (y0.a(jLongValue, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v8.u.b(obj);
                    }
                    w wVar = new w(this.f36899l);
                    z.f36901a.b("Request timeout: " + this.f36899l.i());
                    b2 b2Var = this.f36900m;
                    String message = wVar.getMessage();
                    kotlin.jvm.internal.t.f(message);
                    f2.c(b2Var, message, wVar);
                    return k0.f35197a;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((C0753b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(y yVar, s7.a aVar, z8.d<? super a> dVar) {
                super(3, dVar);
                this.f36894m = yVar;
                this.f36895n = aVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull e0 e0Var, @NotNull a8.c cVar, @Nullable z8.d<? super t7.b> dVar) {
                a aVar = new a(this.f36894m, this.f36895n, dVar);
                aVar.f36892k = e0Var;
                aVar.f36893l = cVar;
                return aVar.invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f36891j;
                if (i10 != 0) {
                    if (i10 == 1) {
                        v8.u.b(obj);
                    }
                    if (i10 == 2) {
                        v8.u.b(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                e0 e0Var = (e0) this.f36892k;
                a8.c cVar = (a8.c) this.f36893l;
                if (m0.b(cVar.i().o())) {
                    this.f36892k = null;
                    this.f36891j = 1;
                    obj = e0Var.a(cVar, this);
                    return obj == objE ? objE : obj;
                }
                cVar.d();
                b bVar = y.f36881d;
                a aVar = (a) cVar.f(bVar);
                if (aVar == null && this.f36894m.f()) {
                    aVar = new a(null, null, null, 7, null);
                    cVar.l(bVar, aVar);
                }
                if (aVar != null) {
                    y yVar = this.f36894m;
                    s7.a aVar2 = this.f36895n;
                    Long lC = aVar.c();
                    if (lC == null) {
                        lC = yVar.f36884b;
                    }
                    aVar.f(lC);
                    Long lE = aVar.e();
                    if (lE == null) {
                        lE = yVar.f36885c;
                    }
                    aVar.h(lE);
                    Long lD = aVar.d();
                    if (lD == null) {
                        lD = yVar.f36883a;
                    }
                    aVar.g(lD);
                    Long lD2 = aVar.d();
                    if (lD2 == null) {
                        lD2 = yVar.f36883a;
                    }
                    if (lD2 != null && lD2.longValue() != Long.MAX_VALUE) {
                        cVar.g().J(new C0752a(kotlinx.coroutines.k.d(aVar2, null, null, new C0753b(lD2, cVar, cVar.g(), null), 3, null)));
                    }
                }
                this.f36892k = null;
                this.f36891j = 2;
                obj = e0Var.a(cVar, this);
                return obj == objE ? objE : obj;
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Override // y7.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull y plugin, @NotNull s7.a scope) {
            kotlin.jvm.internal.t.i(plugin, "plugin");
            kotlin.jvm.internal.t.i(scope, "scope");
            ((x) n.b(scope, x.f36861c)).d(new a(plugin, scope, null));
        }

        @Override // y7.m
        @NotNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public y b(@NotNull h9.l<? super a, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            a aVar = new a(null, null, null, 7, null);
            block.invoke(aVar);
            return aVar.a();
        }

        @Override // y7.m
        @NotNull
        public g8.a<y> getKey() {
            return y.f36882e;
        }
    }

    public /* synthetic */ y(Long l10, Long l11, Long l12, kotlin.jvm.internal.k kVar) {
        this(l10, l11, l12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f() {
        return (this.f36883a == null && this.f36884b == null && this.f36885c == null) ? false : true;
    }

    private y(Long l10, Long l11, Long l12) {
        this.f36883a = l10;
        this.f36884b = l11;
        this.f36885c = l12;
    }
}
