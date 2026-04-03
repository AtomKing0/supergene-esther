package y7;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: HttpRedirect.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final b f36769c = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final g8.a<q> f36770d = new g8.a<>("HttpRedirect");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final d8.a<b8.c> f36771e = new d8.a<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f36772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f36773b;

    /* JADX INFO: compiled from: HttpRedirect.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f36774a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f36775b;

        public final boolean a() {
            return this.f36775b;
        }

        public final boolean b() {
            return this.f36774a;
        }
    }

    /* JADX INFO: compiled from: HttpRedirect.kt */
    public static final class b implements m<a, q> {

        /* JADX INFO: compiled from: HttpRedirect.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpRedirect$Plugin", f = "HttpRedirect.kt", l = {113}, m = "handleCall")
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f36776j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            Object f36777k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            Object f36778l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            Object f36779m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            Object f36780n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            Object f36781o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            Object f36782p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            Object f36783q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            Object f36784r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            boolean f36785s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            /* synthetic */ Object f36786t;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            int f36788v;

            a(z8.d<? super a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f36786t = obj;
                this.f36788v |= Integer.MIN_VALUE;
                return b.this.e(null, null, null, false, null, this);
            }
        }

        /* JADX INFO: renamed from: y7.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpRedirect.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpRedirect$Plugin$install$1", f = "HttpRedirect.kt", l = {64, 69}, m = "invokeSuspend")
        static final class C0748b extends kotlin.coroutines.jvm.internal.l implements h9.q<e0, a8.c, z8.d<? super t7.b>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36789j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36790k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f36791l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ q f36792m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            final /* synthetic */ s7.a f36793n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0748b(q qVar, s7.a aVar, z8.d<? super C0748b> dVar) {
                super(3, dVar);
                this.f36792m = qVar;
                this.f36793n = aVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull e0 e0Var, @NotNull a8.c cVar, @Nullable z8.d<? super t7.b> dVar) {
                C0748b c0748b = new C0748b(this.f36792m, this.f36793n, dVar);
                c0748b.f36790k = e0Var;
                c0748b.f36791l = cVar;
                return c0748b.invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                e0 e0Var;
                a8.c cVar;
                Object objE = a9.d.e();
                int i10 = this.f36789j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    e0 e0Var2 = (e0) this.f36790k;
                    a8.c cVar2 = (a8.c) this.f36791l;
                    this.f36790k = e0Var2;
                    this.f36791l = cVar2;
                    this.f36789j = 1;
                    Object objA = e0Var2.a(cVar2, this);
                    if (objA == objE) {
                        return objE;
                    }
                    e0Var = e0Var2;
                    cVar = cVar2;
                    obj = objA;
                } else {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            v8.u.b(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a8.c cVar3 = (a8.c) this.f36791l;
                    e0 e0Var3 = (e0) this.f36790k;
                    v8.u.b(obj);
                    cVar = cVar3;
                    e0Var = e0Var3;
                }
                t7.b bVar = (t7.b) obj;
                if (this.f36792m.f36772a && !r.f36794a.contains(bVar.e().getMethod())) {
                    return bVar;
                }
                b bVar2 = q.f36769c;
                boolean z10 = this.f36792m.f36773b;
                s7.a aVar = this.f36793n;
                this.f36790k = null;
                this.f36791l = null;
                this.f36789j = 2;
                obj = bVar2.e(e0Var, cVar, bVar, z10, aVar, this);
                return obj == objE ? objE : obj;
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:20:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x016b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x01b1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x01b2  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01cf  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, y7.e0] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r1v11, types: [T] */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r21v0, types: [T, java.lang.Object, t7.b] */
        /* JADX WARN: Type inference failed for: r3v6, types: [T, a8.c] */
        /* JADX WARN: Type inference failed for: r7v0, types: [T] */
        /* JADX WARN: Type inference failed for: r7v1, types: [a8.c, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x01b2 -> B:35:0x01b8). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object e(y7.e0 r19, a8.c r20, t7.b r21, boolean r22, s7.a r23, z8.d<? super t7.b> r24) {
            /*
                Method dump skipped, instruction units count: 471
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: y7.q.b.e(y7.e0, a8.c, t7.b, boolean, s7.a, z8.d):java.lang.Object");
        }

        @NotNull
        public final d8.a<b8.c> d() {
            return q.f36771e;
        }

        @Override // y7.m
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull q plugin, @NotNull s7.a scope) {
            kotlin.jvm.internal.t.i(plugin, "plugin");
            kotlin.jvm.internal.t.i(scope, "scope");
            ((x) n.b(scope, x.f36861c)).d(new C0748b(plugin, scope, null));
        }

        @Override // y7.m
        @NotNull
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public q b(@NotNull h9.l<? super a, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            a aVar = new a();
            block.invoke(aVar);
            return new q(aVar.b(), aVar.a(), null);
        }

        @Override // y7.m
        @NotNull
        public g8.a<q> getKey() {
            return q.f36770d;
        }
    }

    public /* synthetic */ q(boolean z10, boolean z11, kotlin.jvm.internal.k kVar) {
        this(z10, z11);
    }

    private q(boolean z10, boolean z11) {
        this.f36772a = z10;
        this.f36773b = z11;
    }
}
