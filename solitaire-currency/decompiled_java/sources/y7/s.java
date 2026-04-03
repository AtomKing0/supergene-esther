package y7;

import kotlinx.coroutines.b2;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: HttpRequestLifecycle.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f36796a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final g8.a<s> f36797b = new g8.a<>("RequestLifecycle");

    /* JADX INFO: compiled from: HttpRequestLifecycle.kt */
    public static final class a implements m<k0, s> {

        /* JADX INFO: renamed from: y7.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpRequestLifecycle.kt */
        @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.HttpRequestLifecycle$Plugin$install$1", f = "HttpRequestLifecycle.kt", l = {38}, m = "invokeSuspend")
        static final class C0749a extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<Object, a8.c>, Object, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f36798j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private /* synthetic */ Object f36799k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ s7.a f36800l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0749a(s7.a aVar, z8.d<? super C0749a> dVar) {
                super(3, dVar);
                this.f36800l = aVar;
            }

            @Override // h9.q
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object invoke(@NotNull l8.e<Object, a8.c> eVar, @NotNull Object obj, @Nullable z8.d<? super k0> dVar) {
                C0749a c0749a = new C0749a(this.f36800l, dVar);
                c0749a.f36799k = eVar;
                return c0749a.invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlinx.coroutines.a0 a0Var;
                Object objE = a9.d.e();
                int i10 = this.f36798j;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a0Var = (kotlinx.coroutines.a0) this.f36799k;
                    try {
                        v8.u.b(obj);
                        a0Var.complete();
                        return k0.f35197a;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            a0Var.c(th);
                            throw th;
                        } catch (Throwable th2) {
                            a0Var.complete();
                            throw th2;
                        }
                    }
                }
                v8.u.b(obj);
                l8.e eVar = (l8.e) this.f36799k;
                kotlinx.coroutines.a0 a0VarA = y2.a(((a8.c) eVar.c()).g());
                g.b bVar = this.f36800l.getCoroutineContext().get(b2.O7);
                kotlin.jvm.internal.t.f(bVar);
                t.c(a0VarA, (b2) bVar);
                try {
                    ((a8.c) eVar.c()).m(a0VarA);
                    this.f36799k = a0VarA;
                    this.f36798j = 1;
                    if (eVar.d(this) == objE) {
                        return objE;
                    }
                    a0Var = a0VarA;
                    a0Var.complete();
                    return k0.f35197a;
                } catch (Throwable th3) {
                    th = th3;
                    a0Var = a0VarA;
                    a0Var.c(th);
                    throw th;
                }
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Override // y7.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull s plugin, @NotNull s7.a scope) {
            kotlin.jvm.internal.t.i(plugin, "plugin");
            kotlin.jvm.internal.t.i(scope, "scope");
            scope.z().l(a8.f.f354h.a(), new C0749a(scope, null));
        }

        @Override // y7.m
        @NotNull
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public s b(@NotNull h9.l<? super k0, k0> block) {
            kotlin.jvm.internal.t.i(block, "block");
            return new s(null);
        }

        @Override // y7.m
        @NotNull
        public g8.a<s> getKey() {
            return s.f36797b;
        }
    }

    private s() {
    }

    public /* synthetic */ s(kotlin.jvm.internal.k kVar) {
        this();
    }
}
