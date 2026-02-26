package y7;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: UserAgent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f36694b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final g8.a<g0> f36695c = new g8.a<>("UserAgent");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f36696a;

    /* JADX INFO: compiled from: UserAgent.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private String f36697a;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        public final String a() {
            return this.f36697a;
        }

        public final void b(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<set-?>");
            this.f36697a = str;
        }

        public a(@NotNull String agent) {
            kotlin.jvm.internal.t.i(agent, "agent");
            this.f36697a = agent;
        }

        public /* synthetic */ a(String str, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? "Ktor http-client" : str);
        }
    }

    /* JADX INFO: compiled from: UserAgent.kt */
    public static final class b implements m<a, g0> {

        /* JADX INFO: compiled from: UserAgent.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.UserAgent$Plugin$install$1", f = "UserAgent.kt", l = {}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<Object, a8.c>, Object, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36698j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36699k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ g0 f36700l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g0 g0Var, z8.d<? super a> dVar) {
                super(3, dVar);
                this.f36700l = g0Var;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull l8.e<Object, a8.c> eVar, @NotNull Object obj, @Nullable z8.d<? super k0> dVar) {
                a aVar = new a(this.f36700l, dVar);
                aVar.f36699k = eVar;
                return aVar.invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f36698j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                l8.e eVar = (l8.e) this.f36699k;
                h0.f36709a.b("Adding User-Agent header: " + this.f36700l.b() + " for " + ((a8.c) eVar.c()).i());
                a8.j.a((e8.r) eVar.c(), e8.o.f25274a.w(), this.f36700l.b());
                return k0.f35197a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Override // y7.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull g0 plugin, @NotNull s7.a scope) {
            kotlin.jvm.internal.t.i(plugin, "plugin");
            kotlin.jvm.internal.t.i(scope, "scope");
            scope.z().l(a8.f.f354h.d(), new a(plugin, null));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // y7.m
        @NotNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public g0 b(@NotNull h9.l<? super a, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            a aVar = new a(null, 1, 0 == true ? 1 : 0);
            block.invoke(aVar);
            return new g0(aVar.a(), 0 == true ? 1 : 0);
        }

        @Override // y7.m
        @NotNull
        public g8.a<g0> getKey() {
            return g0.f36695c;
        }
    }

    public /* synthetic */ g0(String str, kotlin.jvm.internal.k kVar) {
        this(str);
    }

    @NotNull
    public final String b() {
        return this.f36696a;
    }

    private g0(String str) {
        this.f36696a = str;
    }
}
