package y7;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: HttpRequestRetry.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final d f36804g = new d(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final g8.a<u> f36805h = new g8.a<>("RetryFeature");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final d8.a<e> f36806i = new d8.a<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.q<f, a8.b, b8.c, Boolean> f36807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.q<f, a8.c, Throwable, Boolean> f36808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final h9.p<b, Integer, Long> f36809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final h9.p<Long, z8.d<? super k0>, Object> f36810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f36811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final h9.p<c, a8.c, k0> f36812f;

    /* JADX INFO: compiled from: HttpRequestRetry.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.q<? super f, ? super a8.b, ? super b8.c, Boolean> f36813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h9.q<? super f, ? super a8.c, ? super Throwable, Boolean> f36814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h9.p<? super b, ? super Integer, Long> f36815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private h9.p<? super c, ? super a8.c, k0> f36816d = d.f36827g;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private h9.p<? super Long, ? super z8.d<? super k0>, ? extends Object> f36817e = new C0750a(null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f36818f;

        /* JADX INFO: renamed from: y7.u$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpRequestRetry.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpRequestRetry$Configuration$delay$1", f = "HttpRequestRetry.kt", l = {111}, m = "invokeSuspend")
        static final class C0750a extends kotlin.coroutines.jvm.internal.l implements h9.p<Long, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36819j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            /* synthetic */ long f36820k;

            C0750a(z8.d<? super C0750a> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                C0750a c0750a = new C0750a(dVar);
                c0750a.f36820k = ((Number) obj).longValue();
                return c0750a;
            }

            @Nullable
            public final Object f(long j10, @Nullable z8.d<? super k0> dVar) {
                return ((C0750a) create(Long.valueOf(j10), dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Long l10, z8.d<? super k0> dVar) {
                return f(l10.longValue(), dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f36819j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    long j10 = this.f36820k;
                    this.f36819j = 1;
                    if (y0.a(j10, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                return k0.f35197a;
            }
        }

        /* JADX INFO: compiled from: HttpRequestRetry.kt */
        static final class b extends kotlin.jvm.internal.v implements h9.p<b, Integer, Long> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ boolean f36821g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ h9.p<b, Integer, Long> f36822h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(boolean z10, h9.p<? super b, ? super Integer, Long> pVar) {
                super(2);
                this.f36821g = z10;
                this.f36822h = pVar;
            }

            @NotNull
            public final Long a(@NotNull b bVar, int i10) {
                long jLongValue;
                e8.k kVarB;
                String str;
                Long lN;
                kotlin.jvm.internal.t.i(bVar, "$this$null");
                if (this.f36821g) {
                    b8.c cVarA = bVar.a();
                    Long lValueOf = (cVarA == null || (kVarB = cVarA.b()) == null || (str = kVarB.get(e8.o.f25274a.t())) == null || (lN = p9.p.n(str)) == null) ? null : Long.valueOf(lN.longValue() * ((long) 1000));
                    jLongValue = Math.max(this.f36822h.mo4invoke(bVar, Integer.valueOf(i10)).longValue(), lValueOf != null ? lValueOf.longValue() : 0L);
                } else {
                    jLongValue = this.f36822h.mo4invoke(bVar, Integer.valueOf(i10)).longValue();
                }
                return Long.valueOf(jLongValue);
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Long mo4invoke(b bVar, Integer num) {
                return a(bVar, num.intValue());
            }
        }

        /* JADX INFO: compiled from: HttpRequestRetry.kt */
        static final class c extends kotlin.jvm.internal.v implements h9.p<b, Integer, Long> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ double f36823g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f36824h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ a f36825i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ long f36826j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(double d10, long j10, a aVar, long j11) {
                super(2);
                this.f36823g = d10;
                this.f36824h = j10;
                this.f36825i = aVar;
                this.f36826j = j11;
            }

            @NotNull
            public final Long a(@NotNull b delayMillis, int i10) {
                kotlin.jvm.internal.t.i(delayMillis, "$this$delayMillis");
                return Long.valueOf(Math.min(((long) Math.pow(this.f36823g, i10)) * 1000, this.f36824h) + this.f36825i.m(this.f36826j));
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Long mo4invoke(b bVar, Integer num) {
                return a(bVar, num.intValue());
            }
        }

        /* JADX INFO: compiled from: HttpRequestRetry.kt */
        static final class d extends kotlin.jvm.internal.v implements h9.p<c, a8.c, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final d f36827g = new d();

            d() {
                super(2);
            }

            public final void a(@NotNull c cVar, @NotNull a8.c it) {
                kotlin.jvm.internal.t.i(cVar, "$this$null");
                kotlin.jvm.internal.t.i(it, "it");
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(c cVar, a8.c cVar2) {
                a(cVar, cVar2);
                return k0.f35197a;
            }
        }

        /* JADX INFO: compiled from: HttpRequestRetry.kt */
        static final class e extends kotlin.jvm.internal.v implements h9.q<f, a8.c, Throwable, Boolean> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ boolean f36828g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(boolean z10) {
                super(3);
                this.f36828g = z10;
            }

            @Override // h9.q
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(@NotNull f retryOnExceptionIf, @NotNull a8.c cVar, @NotNull Throwable cause) {
                kotlin.jvm.internal.t.i(retryOnExceptionIf, "$this$retryOnExceptionIf");
                kotlin.jvm.internal.t.i(cVar, "<anonymous parameter 0>");
                kotlin.jvm.internal.t.i(cause, "cause");
                return Boolean.valueOf(v.h(cause) ? this.f36828g : !(cause instanceof CancellationException));
            }
        }

        /* JADX INFO: compiled from: HttpRequestRetry.kt */
        static final class f extends kotlin.jvm.internal.v implements h9.q<f, a8.b, b8.c, Boolean> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final f f36829g = new f();

            f() {
                super(3);
            }

            @Override // h9.q
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(@NotNull f retryIf, @NotNull a8.b bVar, @NotNull b8.c response) {
                kotlin.jvm.internal.t.i(retryIf, "$this$retryIf");
                kotlin.jvm.internal.t.i(bVar, "<anonymous parameter 0>");
                kotlin.jvm.internal.t.i(response, "response");
                int iE0 = response.f().e0();
                boolean z10 = false;
                if (500 <= iE0 && iE0 < 600) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        }

        public a() {
            r(3);
            e(this, 0.0d, 0L, 0L, false, 15, null);
        }

        public static /* synthetic */ void c(a aVar, boolean z10, h9.p pVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = true;
            }
            aVar.b(z10, pVar);
        }

        public static /* synthetic */ void e(a aVar, double d10, long j10, long j11, boolean z10, int i10, Object obj) {
            aVar.d((i10 & 1) != 0 ? 2.0d : d10, (i10 & 2) != 0 ? 60000L : j10, (i10 & 4) != 0 ? 1000L : j11, (i10 & 8) != 0 ? true : z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long m(long j10) {
            if (j10 == 0) {
                return 0L;
            }
            return l9.c.f30972a.g(j10);
        }

        public static /* synthetic */ void p(a aVar, int i10, boolean z10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = -1;
            }
            if ((i11 & 2) != 0) {
                z10 = false;
            }
            aVar.o(i10, z10);
        }

        public final void b(boolean z10, @NotNull h9.p<? super b, ? super Integer, Long> block) {
            kotlin.jvm.internal.t.i(block, "block");
            t(new b(z10, block));
        }

        public final void d(double d10, long j10, long j11, boolean z10) {
            if (!(d10 > 0.0d)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(j10 > 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(j11 >= 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            b(z10, new c(d10, j10, this, j11));
        }

        @NotNull
        public final h9.p<Long, z8.d<? super k0>, Object> f() {
            return this.f36817e;
        }

        @NotNull
        public final h9.p<b, Integer, Long> g() {
            h9.p pVar = this.f36815c;
            if (pVar != null) {
                return pVar;
            }
            kotlin.jvm.internal.t.A("delayMillis");
            return null;
        }

        public final int h() {
            return this.f36818f;
        }

        @NotNull
        public final h9.p<c, a8.c, k0> i() {
            return this.f36816d;
        }

        @NotNull
        public final h9.q<f, a8.b, b8.c, Boolean> j() {
            h9.q qVar = this.f36813a;
            if (qVar != null) {
                return qVar;
            }
            kotlin.jvm.internal.t.A("shouldRetry");
            return null;
        }

        @NotNull
        public final h9.q<f, a8.c, Throwable, Boolean> k() {
            h9.q qVar = this.f36814b;
            if (qVar != null) {
                return qVar;
            }
            kotlin.jvm.internal.t.A("shouldRetryOnException");
            return null;
        }

        public final void l(@NotNull h9.p<? super c, ? super a8.c, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            this.f36816d = block;
        }

        public final void n(int i10, @NotNull h9.q<? super f, ? super a8.b, ? super b8.c, Boolean> block) {
            kotlin.jvm.internal.t.i(block, "block");
            if (i10 != -1) {
                this.f36818f = i10;
            }
            v(block);
        }

        public final void o(int i10, boolean z10) {
            q(i10, new e(z10));
        }

        public final void q(int i10, @NotNull h9.q<? super f, ? super a8.c, ? super Throwable, Boolean> block) {
            kotlin.jvm.internal.t.i(block, "block");
            if (i10 != -1) {
                this.f36818f = i10;
            }
            w(block);
        }

        public final void r(int i10) {
            s(i10);
            p(this, i10, false, 2, null);
        }

        public final void s(int i10) {
            n(i10, f.f36829g);
        }

        public final void t(@NotNull h9.p<? super b, ? super Integer, Long> pVar) {
            kotlin.jvm.internal.t.i(pVar, "<set-?>");
            this.f36815c = pVar;
        }

        public final void u(int i10) {
            this.f36818f = i10;
        }

        public final void v(@NotNull h9.q<? super f, ? super a8.b, ? super b8.c, Boolean> qVar) {
            kotlin.jvm.internal.t.i(qVar, "<set-?>");
            this.f36813a = qVar;
        }

        public final void w(@NotNull h9.q<? super f, ? super a8.c, ? super Throwable, Boolean> qVar) {
            kotlin.jvm.internal.t.i(qVar, "<set-?>");
            this.f36814b = qVar;
        }
    }

    /* JADX INFO: compiled from: HttpRequestRetry.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final a8.c f36830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final b8.c f36831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private final Throwable f36832c;

        public b(@NotNull a8.c request, @Nullable b8.c cVar, @Nullable Throwable th) {
            kotlin.jvm.internal.t.i(request, "request");
            this.f36830a = request;
            this.f36831b = cVar;
            this.f36832c = th;
        }

        @Nullable
        public final b8.c a() {
            return this.f36831b;
        }
    }

    /* JADX INFO: compiled from: HttpRequestRetry.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final a8.c f36833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final b8.c f36834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private final Throwable f36835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f36836d;

        public c(@NotNull a8.c request, @Nullable b8.c cVar, @Nullable Throwable th, int i10) {
            kotlin.jvm.internal.t.i(request, "request");
            this.f36833a = request;
            this.f36834b = cVar;
            this.f36835c = th;
            this.f36836d = i10;
        }

        @NotNull
        public final a8.c a() {
            return this.f36833a;
        }

        public final int b() {
            return this.f36836d;
        }
    }

    /* JADX INFO: compiled from: HttpRequestRetry.kt */
    public static final class d implements m<a, u> {
        private d() {
        }

        public /* synthetic */ d(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final d8.a<e> c() {
            return u.f36806i;
        }

        @Override // y7.m
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull u plugin, @NotNull s7.a scope) {
            kotlin.jvm.internal.t.i(plugin, "plugin");
            kotlin.jvm.internal.t.i(scope, "scope");
            plugin.l(scope);
        }

        @Override // y7.m
        @NotNull
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public u b(@NotNull h9.l<? super a, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            a aVar = new a();
            block.invoke(aVar);
            return new u(aVar);
        }

        @Override // y7.m
        @NotNull
        public g8.a<u> getKey() {
            return u.f36805h;
        }
    }

    /* JADX INFO: compiled from: HttpRequestRetry.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final a8.c f36837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f36838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private final b8.c f36839c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private final Throwable f36840d;

        public e(@NotNull a8.c request, int i10, @Nullable b8.c cVar, @Nullable Throwable th) {
            kotlin.jvm.internal.t.i(request, "request");
            this.f36837a = request;
            this.f36838b = i10;
            this.f36839c = cVar;
            this.f36840d = th;
        }

        @Nullable
        public final Throwable a() {
            return this.f36840d;
        }

        @NotNull
        public final a8.c b() {
            return this.f36837a;
        }

        @Nullable
        public final b8.c c() {
            return this.f36839c;
        }

        public final int d() {
            return this.f36838b;
        }
    }

    /* JADX INFO: compiled from: HttpRequestRetry.kt */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36841a;

        public f(int i10) {
            this.f36841a = i10;
        }
    }

    /* JADX INFO: compiled from: HttpRequestRetry.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpRequestRetry$intercept$1", f = "HttpRequestRetry.kt", l = {298, 314}, m = "invokeSuspend")
    static final class g extends kotlin.coroutines.jvm.internal.l implements h9.q<e0, a8.c, z8.d<? super t7.b>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f36842j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f36843k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f36844l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f36845m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f36846n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f36847o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f36848p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f36849q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private /* synthetic */ Object f36850r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        /* synthetic */ Object f36851s;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ s7.a f36853u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(s7.a aVar, z8.d<? super g> dVar) {
            super(3, dVar);
            this.f36853u = aVar;
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull e0 e0Var, @NotNull a8.c cVar, @Nullable z8.d<? super t7.b> dVar) {
            g gVar = u.this.new g(this.f36853u, dVar);
            gVar.f36850r = e0Var;
            gVar.f36851s = cVar;
            return gVar.invokeSuspend(k0.f35197a);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:6|62|31|(4:73|33|65|34)|69|40|41|71|42|(1:44)|45|(1:47)(4:48|49|58|(1:60)(12:61|62|31|(0)|69|40|41|71|42|(0)|45|(0)(0)))) */
        /* JADX WARN: Can't wrap try/catch for region: R(4:(1:73)|33|65|34) */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0136, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0137, code lost:
        
            r16 = r12;
            r17 = r13;
            r18 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x017f, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x018e, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x01a1, code lost:
        
            r10 = r10 + 1;
            r4 = new y7.u.e(r15, r10, null, r21);
            r7 = r10;
            r8 = r11;
            r9 = r12;
            r10 = r13;
            r11 = r16;
            r12 = r17;
            r13 = r18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0236, code lost:
        
            throw r21;
         */
        /* JADX WARN: Path cross not found for [B:69:0x0142, B:73:0x0121], limit reached: 74 */
        /* JADX WARN: Path cross not found for [B:73:0x0121, B:69:0x0142], limit reached: 74 */
        /* JADX WARN: Removed duplicated region for block: B:44:0x015d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0168 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0169 A[Catch: all -> 0x017f, TRY_LEAVE, TryCatch #3 {all -> 0x017f, blocks: (B:42:0x0155, B:45:0x015e, B:48:0x0169), top: B:71:0x0155 }] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x01fe A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x01ff  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0234  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x01ff -> B:62:0x0208). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 567
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: y7.u.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: HttpRequestRetry.kt */
    static final class h extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a8.c f36854g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(a8.c cVar) {
            super(1);
            this.f36854g = cVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            b2 b2VarG = this.f36854g.g();
            kotlin.jvm.internal.t.g(b2VarG, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
            kotlinx.coroutines.a0 a0Var = (kotlinx.coroutines.a0) b2VarG;
            if (th == null) {
                a0Var.complete();
            } else {
                a0Var.c(th);
            }
        }
    }

    public u(@NotNull a configuration) {
        kotlin.jvm.internal.t.i(configuration, "configuration");
        this.f36807a = configuration.j();
        this.f36808b = configuration.k();
        this.f36809c = configuration.g();
        this.f36810d = configuration.f();
        this.f36811e = configuration.h();
        this.f36812f = configuration.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a8.c m(a8.c cVar) {
        a8.c cVarO = new a8.c().o(cVar);
        cVar.g().J(new h(cVarO));
        return cVarO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(int i10, int i11, h9.q<? super f, ? super a8.b, ? super b8.c, Boolean> qVar, t7.b bVar) {
        return i10 < i11 && qVar.invoke(new f(i10 + 1), bVar.e(), bVar.f()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(int i10, int i11, h9.q<? super f, ? super a8.c, ? super Throwable, Boolean> qVar, a8.c cVar, Throwable th) {
        return i10 < i11 && qVar.invoke(new f(i10 + 1), cVar, th).booleanValue();
    }

    public final void l(@NotNull s7.a client) {
        kotlin.jvm.internal.t.i(client, "client");
        ((x) n.b(client, x.f36861c)).d(new g(client, null));
    }
}
