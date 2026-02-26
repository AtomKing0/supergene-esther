package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f33848a = u9.i0.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: compiled from: Merge.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {217, 217}, m = "invokeSuspend")
    static final class a<R, T> extends kotlin.coroutines.jvm.internal.l implements h9.q<i<? super R>, T, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33849j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f33850k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f33851l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ h9.p<T, z8.d<? super R>, Object> f33852m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(h9.p<? super T, ? super z8.d<? super R>, ? extends Object> pVar, z8.d<? super a> dVar) {
            super(3, dVar);
            this.f33852m = pVar;
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull i<? super R> iVar, T t10, @Nullable z8.d<? super v8.k0> dVar) {
            a aVar = new a(this.f33852m, dVar);
            aVar.f33850k = iVar;
            aVar.f33851l = t10;
            return aVar.invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            i iVar;
            Object objE = a9.d.e();
            int i10 = this.f33849j;
            if (i10 == 0) {
                v8.u.b(obj);
                i iVar2 = (i) this.f33850k;
                Object obj2 = this.f33851l;
                h9.p<T, z8.d<? super R>, Object> pVar = this.f33852m;
                this.f33850k = iVar2;
                this.f33849j = 1;
                obj = pVar.mo4invoke(obj2, this);
                iVar = iVar2;
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                    return v8.k0.f35197a;
                }
                i iVar3 = (i) this.f33850k;
                v8.u.b(obj);
                iVar = iVar3;
            }
            this.f33850k = null;
            this.f33849j = 2;
            if (iVar.emit(obj, this) == objE) {
                return objE;
            }
            return v8.k0.f35197a;
        }
    }

    @NotNull
    public static final <T, R> h<R> a(@NotNull h<? extends T> hVar, @NotNull h9.p<? super T, ? super z8.d<? super R>, ? extends Object> pVar) {
        return j.O(hVar, new a(pVar, null));
    }

    @NotNull
    public static final <T, R> h<R> b(@NotNull h<? extends T> hVar, @NotNull h9.q<? super i<? super R>, ? super T, ? super z8.d<? super v8.k0>, ? extends Object> qVar) {
        return new t9.i(qVar, hVar, null, 0, null, 28, null);
    }
}
