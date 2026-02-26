package v7;

import h9.p;
import h9.q;
import java.io.Closeable;
import java.util.Set;
import kotlin.collections.z0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: HttpClientEngine.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface b extends o0, Closeable {

    /* JADX INFO: compiled from: HttpClientEngine.kt */
    public static final class a {

        /* JADX INFO: renamed from: v7.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpClientEngine.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.engine.HttpClientEngine$DefaultImpls", f = "HttpClientEngine.kt", l = {91, 100}, m = "executeWithinCallContext")
        static final class C0712a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f35129j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            Object f35130k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f35131l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            int f35132m;

            C0712a(z8.d<? super C0712a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f35131l = obj;
                this.f35132m |= Integer.MIN_VALUE;
                return a.e(null, null, this);
            }
        }

        /* JADX INFO: renamed from: v7.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpClientEngine.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2", f = "HttpClientEngine.kt", l = {99}, m = "invokeSuspend")
        static final class C0713b extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super a8.g>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f35133j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ b f35134k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ a8.d f35135l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0713b(b bVar, a8.d dVar, z8.d<? super C0713b> dVar2) {
                super(2, dVar2);
                this.f35134k = bVar;
                this.f35135l = dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0713b(this.f35134k, this.f35135l, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f35133j;
                if (i10 == 0) {
                    u.b(obj);
                    if (a.f(this.f35134k)) {
                        throw new v7.a(null, 1, null);
                    }
                    b bVar = this.f35134k;
                    a8.d dVar = this.f35135l;
                    this.f35133j = 1;
                    obj = bVar.B0(dVar, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                return obj;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super a8.g> dVar) {
                return ((C0713b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: compiled from: HttpClientEngine.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.engine.HttpClientEngine$install$1", f = "HttpClientEngine.kt", l = {70, 82}, m = "invokeSuspend")
        static final class c extends kotlin.coroutines.jvm.internal.l implements q<l8.e<Object, a8.c>, Object, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f35136j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f35137k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f35138l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ s7.a f35139m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            final /* synthetic */ b f35140n;

            /* JADX INFO: renamed from: v7.b$a$c$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: HttpClientEngine.kt */
            static final class C0714a extends v implements h9.l<Throwable, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ s7.a f35141g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ b8.c f35142h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0714a(s7.a aVar, b8.c cVar) {
                    super(1);
                    this.f35141g = aVar;
                    this.f35142h = cVar;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
                    invoke2(th);
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    if (th != null) {
                        this.f35141g.q().a(c8.b.c(), this.f35142h);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(s7.a aVar, b bVar, z8.d<? super c> dVar) {
                super(3, dVar);
                this.f35139m = aVar;
                this.f35140n = bVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull l8.e<Object, a8.c> eVar, @NotNull Object obj, @Nullable z8.d<? super k0> dVar) {
                c cVar = new c(this.f35139m, this.f35140n, dVar);
                cVar.f35137k = eVar;
                cVar.f35138l = obj;
                return cVar.invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a8.d dVarA;
                l8.e eVar;
                Object objE = a9.d.e();
                int i10 = this.f35136j;
                if (i10 == 0) {
                    u.b(obj);
                    l8.e eVar2 = (l8.e) this.f35137k;
                    Object obj2 = this.f35138l;
                    a8.c cVar = new a8.c();
                    cVar.p((a8.c) eVar2.c());
                    if (obj2 == null) {
                        cVar.j(f8.a.f25730a);
                        KType kTypeJ = kotlin.jvm.internal.o0.j(Object.class);
                        cVar.k(m8.b.b(TypesJVMKt.getJavaType(kTypeJ), kotlin.jvm.internal.o0.b(Object.class), kTypeJ));
                    } else if (obj2 instanceof f8.b) {
                        cVar.j(obj2);
                        cVar.k(null);
                    } else {
                        cVar.j(obj2);
                        KType kTypeJ2 = kotlin.jvm.internal.o0.j(Object.class);
                        cVar.k(m8.b.b(TypesJVMKt.getJavaType(kTypeJ2), kotlin.jvm.internal.o0.b(Object.class), kTypeJ2));
                    }
                    this.f35139m.q().a(c8.b.b(), cVar);
                    dVarA = cVar.a();
                    dVarA.a().c(i.c(), this.f35139m.i());
                    i.d(dVarA);
                    a.d(this.f35140n, dVarA);
                    b bVar = this.f35140n;
                    this.f35137k = eVar2;
                    this.f35138l = dVarA;
                    this.f35136j = 1;
                    Object objE2 = a.e(bVar, dVarA, this);
                    if (objE2 == objE) {
                        return objE;
                    }
                    eVar = eVar2;
                    obj = objE2;
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        u.b(obj);
                        return k0.f35197a;
                    }
                    dVarA = (a8.d) this.f35138l;
                    eVar = (l8.e) this.f35137k;
                    u.b(obj);
                }
                t7.b bVar2 = new t7.b(this.f35139m, dVarA, (a8.g) obj);
                b8.c cVarF = bVar2.f();
                this.f35139m.q().a(c8.b.e(), cVarF);
                f2.l(cVarF.getCoroutineContext()).J(new C0714a(this.f35139m, cVarF));
                this.f35137k = null;
                this.f35138l = null;
                this.f35136j = 2;
                if (eVar.e(bVar2, this) == objE) {
                    return objE;
                }
                return k0.f35197a;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void d(b bVar, a8.d dVar) {
            for (e<?> eVar : dVar.g()) {
                if (!bVar.n0().contains(eVar)) {
                    throw new IllegalArgumentException(("Engine doesn't support " + eVar).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object e(v7.b r10, a8.d r11, z8.d<? super a8.g> r12) {
            /*
                boolean r0 = r12 instanceof v7.b.a.C0712a
                if (r0 == 0) goto L13
                r0 = r12
                v7.b$a$a r0 = (v7.b.a.C0712a) r0
                int r1 = r0.f35132m
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f35132m = r1
                goto L18
            L13:
                v7.b$a$a r0 = new v7.b$a$a
                r0.<init>(r12)
            L18:
                java.lang.Object r12 = r0.f35131l
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f35132m
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L41
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                v8.u.b(r12)
                goto L7b
            L2c:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L34:
                java.lang.Object r10 = r0.f35130k
                r11 = r10
                a8.d r11 = (a8.d) r11
                java.lang.Object r10 = r0.f35129j
                v7.b r10 = (v7.b) r10
                v8.u.b(r12)
                goto L55
            L41:
                v8.u.b(r12)
                kotlinx.coroutines.b2 r12 = r11.d()
                r0.f35129j = r10
                r0.f35130k = r11
                r0.f35132m = r4
                java.lang.Object r12 = v7.i.b(r10, r12, r0)
                if (r12 != r1) goto L55
                return r1
            L55:
                r4 = r10
                z8.g r12 = (z8.g) r12
                v7.j r10 = new v7.j
                r10.<init>(r12)
                z8.g r5 = r12.plus(r10)
                r6 = 0
                v7.b$a$b r7 = new v7.b$a$b
                r10 = 0
                r7.<init>(r4, r11, r10)
                r8 = 2
                r9 = 0
                kotlinx.coroutines.v0 r11 = kotlinx.coroutines.i.b(r4, r5, r6, r7, r8, r9)
                r0.f35129j = r10
                r0.f35130k = r10
                r0.f35132m = r3
                java.lang.Object r12 = r11.i0(r0)
                if (r12 != r1) goto L7b
                return r1
            L7b:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: v7.b.a.e(v7.b, a8.d, z8.d):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean f(b bVar) {
            return !(((b2) bVar.getCoroutineContext().get(b2.O7)) != null ? r1.isActive() : false);
        }

        @NotNull
        public static Set<e<?>> g(@NotNull b bVar) {
            return z0.e();
        }

        public static void h(@NotNull b bVar, @NotNull s7.a client) {
            t.i(client, "client");
            client.J().l(a8.h.f368h.a(), new c(client, bVar, null));
        }
    }

    @Nullable
    Object B0(@NotNull a8.d dVar, @NotNull z8.d<? super a8.g> dVar2);

    void c0(@NotNull s7.a aVar);

    @NotNull
    Set<e<?>> n0();

    @NotNull
    g r();
}
