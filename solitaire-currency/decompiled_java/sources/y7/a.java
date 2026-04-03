package y7;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BodyProgress.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final C0741a f36641a = new C0741a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final g8.a<a> f36642b = new g8.a<>("BodyProgress");

    /* JADX INFO: renamed from: y7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BodyProgress.kt */
    public static final class C0741a implements m<k0, a> {
        private C0741a() {
        }

        public /* synthetic */ C0741a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Override // y7.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull a plugin, @NotNull s7.a scope) throws l8.b {
            kotlin.jvm.internal.t.i(plugin, "plugin");
            kotlin.jvm.internal.t.i(scope, "scope");
            plugin.c(scope);
        }

        @Override // y7.m
        @NotNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a b(@NotNull h9.l<? super k0, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            return new a();
        }

        @Override // y7.m
        @NotNull
        public g8.a<a> getKey() {
            return a.f36642b;
        }
    }

    /* JADX INFO: compiled from: BodyProgress.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.BodyProgress$handle$1", f = "BodyProgress.kt", l = {38}, m = "invokeSuspend")
    static final class b extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<Object, a8.c>, Object, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f36643j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f36644k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f36645l;

        b(z8.d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull l8.e<Object, a8.c> eVar, @NotNull Object obj, @Nullable z8.d<? super k0> dVar) {
            b bVar = new b(dVar);
            bVar.f36644k = eVar;
            bVar.f36645l = obj;
            return bVar.invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f36643j;
            if (i10 == 0) {
                v8.u.b(obj);
                l8.e eVar = (l8.e) this.f36644k;
                Object obj2 = this.f36645l;
                h9.q qVar = (h9.q) ((a8.c) eVar.c()).c().d(y7.b.f36650a);
                if (qVar == null) {
                    return k0.f35197a;
                }
                kotlin.jvm.internal.t.g(obj2, "null cannot be cast to non-null type io.ktor.http.content.OutgoingContent");
                u7.a aVar = new u7.a((f8.b) obj2, ((a8.c) eVar.c()).g(), qVar);
                this.f36644k = null;
                this.f36643j = 1;
                if (eVar.e(aVar, this) == objE) {
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

    /* JADX INFO: compiled from: BodyProgress.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.BodyProgress$handle$2", f = "BodyProgress.kt", l = {45}, m = "invokeSuspend")
    static final class c extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<b8.c, k0>, b8.c, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f36646j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f36647k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f36648l;

        c(z8.d<? super c> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull l8.e<b8.c, k0> eVar, @NotNull b8.c cVar, @Nullable z8.d<? super k0> dVar) {
            c cVar2 = new c(dVar);
            cVar2.f36647k = eVar;
            cVar2.f36648l = cVar;
            return cVar2.invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f36646j;
            if (i10 == 0) {
                v8.u.b(obj);
                l8.e eVar = (l8.e) this.f36647k;
                b8.c cVar = (b8.c) this.f36648l;
                h9.q qVar = (h9.q) cVar.R().e().getAttributes().d(y7.b.f36651b);
                if (qVar == null) {
                    return k0.f35197a;
                }
                b8.c cVarC = y7.b.c(cVar, qVar);
                this.f36647k = null;
                this.f36646j = 1;
                if (eVar.e(cVarC, this) == objE) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(s7.a aVar) throws l8.b {
        l8.h hVar = new l8.h("ObservableContent");
        aVar.z().j(a8.f.f354h.b(), hVar);
        aVar.z().l(hVar, new b(null));
        aVar.x().l(b8.b.f2241h.a(), new c(null));
    }
}
