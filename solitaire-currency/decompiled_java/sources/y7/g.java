package y7;

import e8.c;
import f8.b;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: DefaultTransform.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final xa.a f36674a = k8.a.a("io.ktor.client.plugins.defaultTransformers");

    /* JADX INFO: compiled from: DefaultTransform.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", l = {57}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<Object, a8.c>, Object, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f36675j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f36676k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f36677l;

        /* JADX INFO: renamed from: y7.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DefaultTransform.kt */
        public static final class C0743a extends b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            private final e8.c f36678a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f36679b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f36680c;

            C0743a(e8.c cVar, Object obj) {
                this.f36680c = obj;
                this.f36678a = cVar == null ? c.a.f25201a.a() : cVar;
                this.f36679b = ((byte[]) obj).length;
            }

            @Override // f8.b
            @NotNull
            public Long a() {
                return Long.valueOf(this.f36679b);
            }

            @Override // f8.b
            @NotNull
            public e8.c b() {
                return this.f36678a;
            }

            @Override // f8.b.a
            @NotNull
            public byte[] d() {
                return (byte[]) this.f36680c;
            }
        }

        /* JADX INFO: compiled from: DefaultTransform.kt */
        public static final class b extends b.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            private final Long f36681a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            private final e8.c f36682b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f36683c;

            b(l8.e<Object, a8.c> eVar, e8.c cVar, Object obj) {
                this.f36683c = obj;
                String strH = eVar.c().b().h(e8.o.f25274a.g());
                this.f36681a = strH != null ? Long.valueOf(Long.parseLong(strH)) : null;
                this.f36682b = cVar == null ? c.a.f25201a.a() : cVar;
            }

            @Override // f8.b
            @Nullable
            public Long a() {
                return this.f36681a;
            }

            @Override // f8.b
            @NotNull
            public e8.c b() {
                return this.f36682b;
            }

            @Override // f8.b.c
            @NotNull
            public io.ktor.utils.io.g d() {
                return (io.ktor.utils.io.g) this.f36683c;
            }
        }

        a(z8.d<? super a> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull l8.e<Object, a8.c> eVar, @NotNull Object obj, @Nullable z8.d<? super k0> dVar) {
            a aVar = new a(dVar);
            aVar.f36676k = eVar;
            aVar.f36677l = obj;
            return aVar.invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            f8.b c0743a;
            Object objE = a9.d.e();
            int i10 = this.f36675j;
            if (i10 == 0) {
                v8.u.b(obj);
                l8.e eVar = (l8.e) this.f36676k;
                Object obj2 = this.f36677l;
                e8.l lVarB = ((a8.c) eVar.c()).b();
                e8.o oVar = e8.o.f25274a;
                if (lVarB.h(oVar.c()) == null) {
                    ((a8.c) eVar.c()).b().f(oVar.c(), "*/*");
                }
                e8.c cVarD = e8.s.d((e8.r) eVar.c());
                if (obj2 instanceof String) {
                    String str = (String) obj2;
                    if (cVarD == null) {
                        cVarD = c.C0549c.f25223a.a();
                    }
                    c0743a = new f8.c(str, cVarD, null, 4, null);
                } else {
                    c0743a = obj2 instanceof byte[] ? new C0743a(cVarD, obj2) : obj2 instanceof io.ktor.utils.io.g ? new b(eVar, cVarD, obj2) : obj2 instanceof f8.b ? (f8.b) obj2 : h.a(cVarD, (a8.c) eVar.c(), obj2);
                }
                if ((c0743a != null ? c0743a.b() : null) != null) {
                    ((a8.c) eVar.c()).b().j(oVar.i());
                    g.f36674a.b("Transformed with default transformers request body for " + ((a8.c) eVar.c()).i() + " from " + o0.b(obj2.getClass()));
                    this.f36676k = null;
                    this.f36675j = 1;
                    if (eVar.e(c0743a, this) == objE) {
                        return objE;
                    }
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

    /* JADX INFO: compiled from: DefaultTransform.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2", f = "DefaultTransform.kt", l = {68, 72, 72, 78, 78, 82, 90, 116, 121}, m = "invokeSuspend")
    static final class b extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<b8.d, t7.b>, b8.d, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f36684j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f36685k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f36686l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private /* synthetic */ Object f36687m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f36688n;

        /* JADX INFO: compiled from: DefaultTransform.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$1", f = "DefaultTransform.kt", l = {100}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<io.ktor.utils.io.w, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36689j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36690k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ Object f36691l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ b8.c f36692m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, b8.c cVar, z8.d<? super a> dVar) {
                super(2, dVar);
                this.f36691l = obj;
                this.f36692m = cVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                a aVar = new a(this.f36691l, this.f36692m, dVar);
                aVar.f36690k = obj;
                return aVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull io.ktor.utils.io.w wVar, @Nullable z8.d<? super k0> dVar) {
                return ((a) create(wVar, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f36689j;
                try {
                    if (i10 != 0) {
                        try {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            v8.u.b(obj);
                        } catch (Throwable th) {
                            b8.e.d(this.f36692m);
                            throw th;
                        }
                    } else {
                        v8.u.b(obj);
                        io.ktor.utils.io.w wVar = (io.ktor.utils.io.w) this.f36690k;
                        io.ktor.utils.io.g gVar = (io.ktor.utils.io.g) this.f36691l;
                        io.ktor.utils.io.j jVarMo4209a = wVar.mo4209a();
                        this.f36689j = 1;
                        if (io.ktor.utils.io.h.b(gVar, jVarMo4209a, Long.MAX_VALUE, this) == objE) {
                            return objE;
                        }
                    }
                    b8.e.d(this.f36692m);
                    return k0.f35197a;
                } catch (CancellationException e10) {
                    p0.d(this.f36692m, e10);
                    throw e10;
                } catch (Throwable th2) {
                    p0.c(this.f36692m, "Receive failed", th2);
                    throw th2;
                }
            }
        }

        /* JADX INFO: renamed from: y7.g$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DefaultTransform.kt */
        static final class C0744b extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.a0 f36693g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0744b(kotlinx.coroutines.a0 a0Var) {
                super(1);
                this.f36693g = a0Var;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
                invoke2(th);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                this.f36693g.complete();
            }
        }

        b(z8.d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull l8.e<b8.d, t7.b> eVar, @NotNull b8.d dVar, @Nullable z8.d<? super k0> dVar2) {
            b bVar = new b(dVar2);
            bVar.f36687m = eVar;
            bVar.f36688n = dVar;
            return bVar.invokeSuspend(k0.f35197a);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x015e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x01b3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x01b4  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x01f7  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0229  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x022d  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0265 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0266  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x02f8  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 838
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: y7.g.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void b(@NotNull s7.a aVar) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        aVar.z().l(a8.f.f354h.b(), new a(null));
        aVar.B().l(b8.f.f2253h.a(), new b(null));
        h.b(aVar);
    }
}
