package y7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: HttpSend.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final d f36861c = new d(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final g8.a<x> f36862d = new g8.a<>("HttpSend");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f36863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<h9.q<e0, a8.c, z8.d<? super t7.b>, Object>> f36864b;

    /* JADX INFO: compiled from: HttpSend.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f36865a = 20;

        public final int a() {
            return this.f36865a;
        }
    }

    /* JADX INFO: compiled from: HttpSend.kt */
    private static final class b implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final s7.a f36867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f36868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private t7.b f36869d;

        /* JADX INFO: compiled from: HttpSend.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpSend$DefaultSender", f = "HttpSend.kt", l = {138}, m = "execute")
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f36870j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            /* synthetic */ Object f36871k;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            int f36873m;

            a(z8.d<? super a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f36871k = obj;
                this.f36873m |= Integer.MIN_VALUE;
                return b.this.a(null, this);
            }
        }

        public b(int i10, @NotNull s7.a client) {
            kotlin.jvm.internal.t.i(client, "client");
            this.f36866a = i10;
            this.f36867b = client;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // y7.e0
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object a(@org.jetbrains.annotations.NotNull a8.c r6, @org.jetbrains.annotations.NotNull z8.d<? super t7.b> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof y7.x.b.a
                if (r0 == 0) goto L13
                r0 = r7
                y7.x$b$a r0 = (y7.x.b.a) r0
                int r1 = r0.f36873m
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f36873m = r1
                goto L18
            L13:
                y7.x$b$a r0 = new y7.x$b$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f36871k
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f36873m
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L36
                if (r2 != r4) goto L2e
                java.lang.Object r6 = r0.f36870j
                y7.x$b r6 = (y7.x.b) r6
                v8.u.b(r7)
                goto L5f
            L2e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L36:
                v8.u.b(r7)
                t7.b r7 = r5.f36869d
                if (r7 == 0) goto L40
                kotlinx.coroutines.p0.e(r7, r3, r4, r3)
            L40:
                int r7 = r5.f36868c
                int r2 = r5.f36866a
                if (r7 >= r2) goto L86
                int r7 = r7 + r4
                r5.f36868c = r7
                s7.a r7 = r5.f36867b
                a8.h r7 = r7.J()
                java.lang.Object r2 = r6.d()
                r0.f36870j = r5
                r0.f36873m = r4
                java.lang.Object r7 = r7.d(r6, r2, r0)
                if (r7 != r1) goto L5e
                return r1
            L5e:
                r6 = r5
            L5f:
                boolean r0 = r7 instanceof t7.b
                if (r0 == 0) goto L66
                r3 = r7
                t7.b r3 = (t7.b) r3
            L66:
                if (r3 == 0) goto L6b
                r6.f36869d = r3
                return r3
            L6b:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Failed to execute send pipeline. Expected [HttpClientCall], but received "
                r0.append(r1)
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                java.lang.String r7 = r7.toString()
                r6.<init>(r7)
                throw r6
            L86:
                y7.d0 r6 = new y7.d0
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r0 = "Max send count "
                r7.append(r0)
                int r0 = r5.f36866a
                r7.append(r0)
                java.lang.String r0 = " exceeded. Consider increasing the property maxSendCount if more is required."
                r7.append(r0)
                java.lang.String r7 = r7.toString()
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: y7.x.b.a(a8.c, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: HttpSend.kt */
    private static final class c implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final h9.q<e0, a8.c, z8.d<? super t7.b>, Object> f36874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final e0 f36875b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull h9.q<? super e0, ? super a8.c, ? super z8.d<? super t7.b>, ? extends Object> interceptor, @NotNull e0 nextSender) {
            kotlin.jvm.internal.t.i(interceptor, "interceptor");
            kotlin.jvm.internal.t.i(nextSender, "nextSender");
            this.f36874a = interceptor;
            this.f36875b = nextSender;
        }

        @Override // y7.e0
        @Nullable
        public Object a(@NotNull a8.c cVar, @NotNull z8.d<? super t7.b> dVar) {
            return this.f36874a.invoke(this.f36875b, cVar, dVar);
        }
    }

    /* JADX INFO: compiled from: HttpSend.kt */
    public static final class d implements m<a, x> {

        /* JADX INFO: compiled from: HttpSend.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpSend$Plugin$install$1", f = "HttpSend.kt", l = {104, 105}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<Object, a8.c>, Object, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36876j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36877k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f36878l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ x f36879m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            final /* synthetic */ s7.a f36880n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(x xVar, s7.a aVar, z8.d<? super a> dVar) {
                super(3, dVar);
                this.f36879m = xVar;
                this.f36880n = aVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull l8.e<Object, a8.c> eVar, @NotNull Object obj, @Nullable z8.d<? super k0> dVar) {
                a aVar = new a(this.f36879m, this.f36880n, dVar);
                aVar.f36877k = eVar;
                aVar.f36878l = obj;
                return aVar.invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Type inference failed for: r11v15, types: [T, y7.x$b] */
            /* JADX WARN: Type inference failed for: r8v1, types: [T, y7.x$c] */
            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                l8.e eVar;
                Object objE = a9.d.e();
                int i10 = this.f36876j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    eVar = (l8.e) this.f36877k;
                    Object obj2 = this.f36878l;
                    if (!(obj2 instanceof f8.b)) {
                        throw new IllegalStateException(p9.j.h("\n|Fail to prepare request body for sending. \n|The body type is: " + o0.b(obj2.getClass()) + ", with Content-Type: " + e8.s.d((e8.r) eVar.c()) + ".\n|\n|If you expect serialized body, please check that you have installed the corresponding plugin(like `ContentNegotiation`) and set `Content-Type` header.", null, 1, null).toString());
                    }
                    a8.c cVar = (a8.c) eVar.c();
                    if (obj2 == null) {
                        cVar.j(f8.a.f25730a);
                        KType kTypeJ = o0.j(f8.b.class);
                        cVar.k(m8.b.b(TypesJVMKt.getJavaType(kTypeJ), o0.b(f8.b.class), kTypeJ));
                    } else if (obj2 instanceof f8.b) {
                        cVar.j(obj2);
                        cVar.k(null);
                    } else {
                        cVar.j(obj2);
                        KType kTypeJ2 = o0.j(f8.b.class);
                        cVar.k(m8.b.b(TypesJVMKt.getJavaType(kTypeJ2), o0.b(f8.b.class), kTypeJ2));
                    }
                    ?? bVar = new b(this.f36879m.f36863a, this.f36880n);
                    n0 n0Var = new n0();
                    n0Var.f29834a = bVar;
                    n9.g gVarR = n9.o.r(kotlin.collections.v.m(this.f36879m.f36864b), 0);
                    x xVar = this.f36879m;
                    Iterator<Integer> it = gVarR.iterator();
                    while (it.hasNext()) {
                        n0Var.f29834a = new c((h9.q) xVar.f36864b.get(((l0) it).nextInt()), (e0) n0Var.f29834a);
                    }
                    e0 e0Var = (e0) n0Var.f29834a;
                    a8.c cVar2 = (a8.c) eVar.c();
                    this.f36877k = eVar;
                    this.f36876j = 1;
                    obj = e0Var.a(cVar2, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v8.u.b(obj);
                        return k0.f35197a;
                    }
                    eVar = (l8.e) this.f36877k;
                    v8.u.b(obj);
                }
                this.f36877k = null;
                this.f36876j = 2;
                if (eVar.e((t7.b) obj, this) == objE) {
                    return objE;
                }
                return k0.f35197a;
            }
        }

        private d() {
        }

        public /* synthetic */ d(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Override // y7.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull x plugin, @NotNull s7.a scope) {
            kotlin.jvm.internal.t.i(plugin, "plugin");
            kotlin.jvm.internal.t.i(scope, "scope");
            scope.z().l(a8.f.f354h.c(), new a(plugin, scope, null));
        }

        @Override // y7.m
        @NotNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public x b(@NotNull h9.l<? super a, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            a aVar = new a();
            block.invoke(aVar);
            return new x(aVar.a(), null);
        }

        @Override // y7.m
        @NotNull
        public g8.a<x> getKey() {
            return x.f36862d;
        }
    }

    public /* synthetic */ x(int i10, kotlin.jvm.internal.k kVar) {
        this(i10);
    }

    public final void d(@NotNull h9.q<? super e0, ? super a8.c, ? super z8.d<? super t7.b>, ? extends Object> block) {
        kotlin.jvm.internal.t.i(block, "block");
        this.f36864b.add(block);
    }

    private x(int i10) {
        this.f36863a = i10;
        this.f36864b = new ArrayList();
    }
}
