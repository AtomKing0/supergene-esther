package s9;

import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Collect.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class m {

    /* JADX INFO: compiled from: Collect.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", l = {50}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33735j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ h<T> f33736k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(h<? extends T> hVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f33736k = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new a(this.f33736k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f33735j;
            if (i10 == 0) {
                v8.u.b(obj);
                h<T> hVar = this.f33736k;
                this.f33735j = 1;
                if (j.k(hVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    @Nullable
    public static final Object a(@NotNull h<?> hVar, @NotNull z8.d<? super v8.k0> dVar) {
        Object objCollect = hVar.collect(t9.r.f34170a, dVar);
        return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
    }

    @Nullable
    public static final <T> Object b(@NotNull h<? extends T> hVar, @NotNull h9.p<? super T, ? super z8.d<? super v8.k0>, ? extends Object> pVar, @NotNull z8.d<? super v8.k0> dVar) {
        Object objK = j.k(n.b(j.E(hVar, pVar), 0, null, 2, null), dVar);
        return objK == a9.d.e() ? objK : v8.k0.f35197a;
    }

    @Nullable
    public static final <T> Object c(@NotNull i<? super T> iVar, @NotNull h<? extends T> hVar, @NotNull z8.d<? super v8.k0> dVar) {
        j.t(iVar);
        Object objCollect = hVar.collect(iVar, dVar);
        return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
    }

    @NotNull
    public static final <T> b2 d(@NotNull h<? extends T> hVar, @NotNull kotlinx.coroutines.o0 o0Var) {
        return kotlinx.coroutines.k.d(o0Var, null, null, new a(hVar, null), 3, null);
    }
}
