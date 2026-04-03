package y7;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import y7.l;

/* JADX INFO: compiled from: HttpCallValidator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f36711d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final g8.a<k> f36712e = new g8.a<>("HttpResponseValidator");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<h9.p<b8.c, z8.d<? super k0>, Object>> f36713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<j> f36714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f36715c;

    /* JADX INFO: compiled from: HttpCallValidator.kt */
    public static final class a implements m<b, k> {

        /* JADX INFO: renamed from: y7.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpCallValidator.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$1", f = "HttpCallValidator.kt", l = {130, 133}, m = "invokeSuspend")
        static final class C0745a extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<Object, a8.c>, Object, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36716j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36717k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f36718l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ k f36719m;

            /* JADX INFO: renamed from: y7.k$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: HttpCallValidator.kt */
            static final class C0746a extends kotlin.jvm.internal.v implements h9.a<Boolean> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ k f36720g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0746a(k kVar) {
                    super(0);
                    this.f36720g = kVar;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // h9.a
                @NotNull
                public final Boolean invoke() {
                    return Boolean.valueOf(this.f36720g.f36715c);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0745a(k kVar, z8.d<? super C0745a> dVar) {
                super(3, dVar);
                this.f36719m = kVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull l8.e<Object, a8.c> eVar, @NotNull Object obj, @Nullable z8.d<? super k0> dVar) {
                C0745a c0745a = new C0745a(this.f36719m, dVar);
                c0745a.f36717k = eVar;
                c0745a.f36718l = obj;
                return c0745a.invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [l8.e] */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v12 */
            /* JADX WARN: Type inference failed for: r1v8 */
            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                Object objE = a9.d.e();
                ?? r12 = this.f36716j;
                try {
                    if (r12 == 0) {
                        v8.u.b(obj);
                        l8.e eVar = (l8.e) this.f36717k;
                        Object obj2 = this.f36718l;
                        ((a8.c) eVar.c()).c().g(l.e(), new C0746a(this.f36719m));
                        this.f36717k = eVar;
                        this.f36716j = 1;
                        Object objE2 = eVar.e(obj2, this);
                        r12 = eVar;
                        if (objE2 == objE) {
                            return objE;
                        }
                    } else {
                        if (r12 != 1) {
                            if (r12 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Throwable th = (Throwable) this.f36717k;
                            v8.u.b(obj);
                            throw th;
                        }
                        l8.e eVar2 = (l8.e) this.f36717k;
                        v8.u.b(obj);
                        r12 = eVar2;
                    }
                    return k0.f35197a;
                } catch (Throwable th2) {
                    Throwable thA = c8.d.a(th2);
                    k kVar = this.f36719m;
                    l.a aVarA = l.a((a8.c) r12.c());
                    this.f36717k = thA;
                    this.f36716j = 2;
                    if (kVar.e(thA, aVarA, this) == objE) {
                        return objE;
                    }
                    throw thA;
                }
            }
        }

        /* JADX INFO: compiled from: HttpCallValidator.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$2", f = "HttpCallValidator.kt", l = {142, 145}, m = "invokeSuspend")
        static final class b extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<b8.d, t7.b>, b8.d, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36721j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36722k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f36723l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ k f36724m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(k kVar, z8.d<? super b> dVar) {
                super(3, dVar);
                this.f36724m = kVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull l8.e<b8.d, t7.b> eVar, @NotNull b8.d dVar, @Nullable z8.d<? super k0> dVar2) {
                b bVar = new b(this.f36724m, dVar2);
                bVar.f36722k = eVar;
                bVar.f36723l = dVar;
                return bVar.invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [l8.e] */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v12 */
            /* JADX WARN: Type inference failed for: r1v8 */
            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
                Object objE = a9.d.e();
                ?? r12 = this.f36721j;
                try {
                    if (r12 == 0) {
                        v8.u.b(obj);
                        l8.e eVar = (l8.e) this.f36722k;
                        b8.d dVar = (b8.d) this.f36723l;
                        this.f36722k = eVar;
                        this.f36721j = 1;
                        Object objE2 = eVar.e(dVar, this);
                        r12 = eVar;
                        if (objE2 == objE) {
                            return objE;
                        }
                    } else {
                        if (r12 != 1) {
                            if (r12 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Throwable th = (Throwable) this.f36722k;
                            v8.u.b(obj);
                            throw th;
                        }
                        l8.e eVar2 = (l8.e) this.f36722k;
                        v8.u.b(obj);
                        r12 = eVar2;
                    }
                    return k0.f35197a;
                } catch (Throwable th2) {
                    Throwable thA = c8.d.a(th2);
                    k kVar = this.f36724m;
                    a8.b bVarE = ((t7.b) r12.c()).e();
                    this.f36722k = thA;
                    this.f36721j = 2;
                    if (kVar.e(thA, bVarE, this) == objE) {
                        return objE;
                    }
                    throw thA;
                }
            }
        }

        /* JADX INFO: compiled from: HttpCallValidator.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$3", f = "HttpCallValidator.kt", l = {151, 152}, m = "invokeSuspend")
        static final class c extends kotlin.coroutines.jvm.internal.l implements h9.q<e0, a8.c, z8.d<? super t7.b>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36725j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36726k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f36727l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ k f36728m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(k kVar, z8.d<? super c> dVar) {
                super(3, dVar);
                this.f36728m = kVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull e0 e0Var, @NotNull a8.c cVar, @Nullable z8.d<? super t7.b> dVar) {
                c cVar2 = new c(this.f36728m, dVar);
                cVar2.f36726k = e0Var;
                cVar2.f36727l = cVar;
                return cVar2.invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f36725j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    e0 e0Var = (e0) this.f36726k;
                    a8.c cVar = (a8.c) this.f36727l;
                    this.f36726k = null;
                    this.f36725j = 1;
                    obj = e0Var.a(cVar, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        t7.b bVar = (t7.b) this.f36726k;
                        v8.u.b(obj);
                        return bVar;
                    }
                    v8.u.b(obj);
                }
                t7.b bVar2 = (t7.b) obj;
                k kVar = this.f36728m;
                b8.c cVarF = bVar2.f();
                this.f36726k = bVar2;
                this.f36725j = 2;
                return kVar.f(cVarF, this) == objE ? objE : bVar2;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Override // y7.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull k plugin, @NotNull s7.a scope) throws l8.b {
            kotlin.jvm.internal.t.i(plugin, "plugin");
            kotlin.jvm.internal.t.i(scope, "scope");
            scope.z().l(a8.f.f354h.a(), new C0745a(plugin, null));
            l8.h hVar = new l8.h("BeforeReceive");
            scope.B().k(b8.f.f2253h.b(), hVar);
            scope.B().l(hVar, new b(plugin, null));
            ((x) n.b(scope, x.f36861c)).d(new c(plugin, null));
        }

        @Override // y7.m
        @NotNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public k b(@NotNull h9.l<? super b, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            b bVar = new b();
            block.invoke(bVar);
            return new k(kotlin.collections.d0.C0(bVar.c()), kotlin.collections.d0.C0(bVar.b()), bVar.a());
        }

        @Override // y7.m
        @NotNull
        public g8.a<k> getKey() {
            return k.f36712e;
        }
    }

    /* JADX INFO: compiled from: HttpCallValidator.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<h9.p<b8.c, z8.d<? super k0>, Object>> f36729a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<j> f36730b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f36731c = true;

        public final boolean a() {
            return this.f36731c;
        }

        @NotNull
        public final List<j> b() {
            return this.f36730b;
        }

        @NotNull
        public final List<h9.p<b8.c, z8.d<? super k0>, Object>> c() {
            return this.f36729a;
        }

        public final void d(boolean z10) {
            this.f36731c = z10;
        }

        public final void e(@NotNull h9.p<? super b8.c, ? super z8.d<? super k0>, ? extends Object> block) {
            kotlin.jvm.internal.t.i(block, "block");
            this.f36729a.add(block);
        }
    }

    /* JADX INFO: compiled from: HttpCallValidator.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", l = {58, 59}, m = "processException")
    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f36732j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f36733k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f36734l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        /* synthetic */ Object f36735m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f36737o;

        c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f36735m = obj;
            this.f36737o |= Integer.MIN_VALUE;
            return k.this.e(null, null, this);
        }
    }

    /* JADX INFO: compiled from: HttpCallValidator.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", l = {51}, m = "validateResponse")
    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f36738j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f36739k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f36740l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f36742n;

        d(z8.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f36740l = obj;
            this.f36742n |= Integer.MIN_VALUE;
            return k.this.f(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull List<? extends h9.p<? super b8.c, ? super z8.d<? super k0>, ? extends Object>> responseValidators, @NotNull List<? extends j> callExceptionHandlers, boolean z10) {
        kotlin.jvm.internal.t.i(responseValidators, "responseValidators");
        kotlin.jvm.internal.t.i(callExceptionHandlers, "callExceptionHandlers");
        this.f36713a = responseValidators;
        this.f36714b = callExceptionHandlers;
        this.f36715c = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
    
        r2 = r9;
        r9 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.Throwable r8, a8.b r9, z8.d<? super v8.k0> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof y7.k.c
            if (r0 == 0) goto L13
            r0 = r10
            y7.k$c r0 = (y7.k.c) r0
            int r1 = r0.f36737o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36737o = r1
            goto L18
        L13:
            y7.k$c r0 = new y7.k$c
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f36735m
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f36737o
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            goto L31
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            java.lang.Object r8 = r0.f36734l
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.f36733k
            a8.b r9 = (a8.b) r9
            java.lang.Object r2 = r0.f36732j
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            v8.u.b(r10)
            goto L9b
        L41:
            v8.u.b(r10)
            xa.a r10 = y7.l.d()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Processing exception "
            r2.append(r5)
            r2.append(r8)
            java.lang.String r5 = " for request "
            r2.append(r5)
            e8.p0 r5 = r9.getUrl()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r10.b(r2)
            java.util.List<y7.j> r10 = r7.f36714b
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
            r6 = r9
            r9 = r8
            r8 = r10
            r10 = r6
        L74:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lb7
            java.lang.Object r2 = r8.next()
            y7.j r2 = (y7.j) r2
            boolean r5 = r2 instanceof y7.i
            if (r5 == 0) goto L9e
            y7.i r2 = (y7.i) r2
            h9.p r2 = r2.a()
            r0.f36732j = r9
            r0.f36733k = r10
            r0.f36734l = r8
            r0.f36737o = r4
            java.lang.Object r2 = r2.mo4invoke(r9, r0)
            if (r2 != r1) goto L99
            return r1
        L99:
            r2 = r9
            r9 = r10
        L9b:
            r10 = r9
            r9 = r2
            goto L74
        L9e:
            boolean r5 = r2 instanceof y7.b0
            if (r5 == 0) goto L74
            y7.b0 r2 = (y7.b0) r2
            h9.q r2 = r2.a()
            r0.f36732j = r9
            r0.f36733k = r10
            r0.f36734l = r8
            r0.f36737o = r3
            java.lang.Object r2 = r2.invoke(r9, r10, r0)
            if (r2 != r1) goto L99
            return r1
        Lb7:
            v8.k0 r8 = v8.k0.f35197a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.k.e(java.lang.Throwable, a8.b, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(b8.c r7, z8.d<? super v8.k0> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof y7.k.d
            if (r0 == 0) goto L13
            r0 = r8
            y7.k$d r0 = (y7.k.d) r0
            int r1 = r0.f36742n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36742n = r1
            goto L18
        L13:
            y7.k$d r0 = new y7.k$d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f36740l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f36742n
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r7 = r0.f36739k
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.f36738j
            b8.c r2 = (b8.c) r2
            v8.u.b(r8)
            r8 = r2
            goto L6c
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            v8.u.b(r8)
            xa.a r8 = y7.l.d()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Validating response for request "
            r2.append(r4)
            t7.b r4 = r7.R()
            a8.b r4 = r4.e()
            e8.p0 r4 = r4.getUrl()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r8.b(r2)
            java.util.List<h9.p<b8.c, z8.d<? super v8.k0>, java.lang.Object>> r8 = r6.f36713a
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
            r5 = r8
            r8 = r7
            r7 = r5
        L6c:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L85
            java.lang.Object r2 = r7.next()
            h9.p r2 = (h9.p) r2
            r0.f36738j = r8
            r0.f36739k = r7
            r0.f36742n = r3
            java.lang.Object r2 = r2.mo4invoke(r8, r0)
            if (r2 != r1) goto L6c
            return r1
        L85:
            v8.k0 r7 = v8.k0.f35197a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.k.f(b8.c, z8.d):java.lang.Object");
    }
}
