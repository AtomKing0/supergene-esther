package y7;

import androidx.core.app.FrameMetricsAggregator;
import e8.l0;
import e8.n0;
import e8.p0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: DefaultRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f36655b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final g8.a<d> f36656c = new g8.a<>("DefaultRequest");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h9.l<a, k0> f36657a;

    /* JADX INFO: compiled from: DefaultRequest.kt */
    public static final class a implements e8.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final e8.l f36658a = new e8.l(0, 1, null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final e8.f0 f36659b = new e8.f0(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final g8.b f36660c = g8.d.a(true);

        @NotNull
        public final g8.b a() {
            return this.f36660c;
        }

        @Override // e8.r
        @NotNull
        public e8.l b() {
            return this.f36658a;
        }

        @NotNull
        public final e8.f0 c() {
            return this.f36659b;
        }
    }

    /* JADX INFO: compiled from: DefaultRequest.kt */
    public static final class b implements m<a, d> {

        /* JADX INFO: compiled from: DefaultRequest.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.DefaultRequest$Plugin$install$1", f = "DefaultRequest.kt", l = {}, m = "invokeSuspend")
        static final class a extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<Object, a8.c>, Object, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36661j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36662k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ d f36663l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar, z8.d<? super a> dVar2) {
                super(3, dVar2);
                this.f36663l = dVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull l8.e<Object, a8.c> eVar, @NotNull Object obj, @Nullable z8.d<? super k0> dVar) {
                a aVar = new a(this.f36663l, dVar);
                aVar.f36662k = eVar;
                return aVar.invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f36661j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                l8.e eVar = (l8.e) this.f36662k;
                String string = ((a8.c) eVar.c()).i().toString();
                a aVar = new a();
                d dVar = this.f36663l;
                g8.x.c(aVar.b(), ((a8.c) eVar.c()).b());
                dVar.f36657a.invoke(aVar);
                d.f36655b.f(aVar.c().b(), ((a8.c) eVar.c()).i());
                for (g8.a<?> aVar2 : aVar.a().f()) {
                    if (!((a8.c) eVar.c()).c().e(aVar2)) {
                        g8.b bVarC = ((a8.c) eVar.c()).c();
                        kotlin.jvm.internal.t.g(aVar2, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                        bVarC.c(aVar2, aVar.a().a(aVar2));
                    }
                }
                ((a8.c) eVar.c()).b().clear();
                ((a8.c) eVar.c()).b().e(aVar.b().n());
                e.f36664a.b("Applied DefaultRequest to " + string + ". New url: " + ((a8.c) eVar.c()).i());
                return k0.f35197a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        private final List<String> d(List<String> list, List<String> list2) {
            if (list2.isEmpty()) {
                return list;
            }
            if (list.isEmpty()) {
                return list2;
            }
            if (((CharSequence) kotlin.collections.d0.i0(list2)).length() == 0) {
                return list2;
            }
            List listD = kotlin.collections.u.d((list.size() + list2.size()) - 1);
            int size = list.size() - 1;
            for (int i10 = 0; i10 < size; i10++) {
                listD.add(list.get(i10));
            }
            listD.addAll(list2);
            return kotlin.collections.u.a(listD);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(p0 p0Var, e8.f0 f0Var) {
            if (kotlin.jvm.internal.t.d(f0Var.o(), l0.f25262c.c())) {
                f0Var.y(p0Var.k());
            }
            if (f0Var.j().length() > 0) {
                return;
            }
            e8.f0 f0VarA = n0.a(p0Var);
            f0VarA.y(f0Var.o());
            if (f0Var.n() != 0) {
                f0VarA.x(f0Var.n());
            }
            f0VarA.u(d.f36655b.d(f0VarA.g(), f0Var.g()));
            if (f0Var.d().length() > 0) {
                f0VarA.r(f0Var.d());
            }
            e8.a0 a0VarB = e8.d0.b(0, 1, null);
            g8.x.c(a0VarB, f0VarA.e());
            f0VarA.s(f0Var.e());
            Iterator<T> it = a0VarB.a().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (!f0VarA.e().contains(str)) {
                    f0VarA.e().d(str, list);
                }
            }
            n0.g(f0Var, f0VarA);
        }

        @Override // y7.m
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull d plugin, @NotNull s7.a scope) {
            kotlin.jvm.internal.t.i(plugin, "plugin");
            kotlin.jvm.internal.t.i(scope, "scope");
            scope.z().l(a8.f.f354h.a(), new a(plugin, null));
        }

        @Override // y7.m
        @NotNull
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public d b(@NotNull h9.l<? super a, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            return new d(block, null);
        }

        @Override // y7.m
        @NotNull
        public g8.a<d> getKey() {
            return d.f36656c;
        }
    }

    public /* synthetic */ d(h9.l lVar, kotlin.jvm.internal.k kVar) {
        this(lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d(h9.l<? super a, k0> lVar) {
        this.f36657a = lVar;
    }
}
