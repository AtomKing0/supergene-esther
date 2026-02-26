package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Zip.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class w {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a<R> implements h<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f33918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f33919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h9.q f33920c;

        public a(h hVar, h hVar2, h9.q qVar) {
            this.f33918a = hVar;
            this.f33919b = hVar2;
            this.f33920c = qVar;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull i<? super R> iVar, @NotNull z8.d<? super v8.k0> dVar) {
            Object objA = t9.k.a(iVar, new h[]{this.f33918a, this.f33919b}, w.d(), new b(this.f33920c, null), dVar);
            return objA == a9.d.e() ? objA : v8.k0.f35197a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: Zip.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", l = {33, 33}, m = "invokeSuspend")
    static final class b<R> extends kotlin.coroutines.jvm.internal.l implements h9.q<i<? super R>, Object[], z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33921j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f33922k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f33923l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ h9.q<T1, T2, z8.d<? super R>, Object> f33924m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(h9.q<? super T1, ? super T2, ? super z8.d<? super R>, ? extends Object> qVar, z8.d<? super b> dVar) {
            super(3, dVar);
            this.f33924m = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            i iVar;
            Object objE = a9.d.e();
            int i10 = this.f33921j;
            if (i10 == 0) {
                v8.u.b(obj);
                iVar = (i) this.f33922k;
                Object[] objArr = (Object[]) this.f33923l;
                h9.q<T1, T2, z8.d<? super R>, Object> qVar = this.f33924m;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                this.f33922k = iVar;
                this.f33921j = 1;
                obj = qVar.invoke(obj2, obj3, this);
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
                iVar = (i) this.f33922k;
                v8.u.b(obj);
            }
            this.f33922k = null;
            this.f33921j = 2;
            if (iVar.emit(obj, this) == objE) {
                return objE;
            }
            return v8.k0.f35197a;
        }

        @Override // h9.q
        @Nullable
        public final Object invoke(@NotNull i<? super R> iVar, @NotNull Object[] objArr, @Nullable z8.d<? super v8.k0> dVar) {
            b bVar = new b(this.f33924m, dVar);
            bVar.f33922k = iVar;
            bVar.f33923l = objArr;
            return bVar.invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: compiled from: Zip.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f33925g = new c();

        c() {
            super(0);
        }

        @Override // h9.a
        @Nullable
        public final Void invoke() {
            return null;
        }
    }

    @NotNull
    public static final <T1, T2, R> h<R> b(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h9.q<? super T1, ? super T2, ? super z8.d<? super R>, ? extends Object> qVar) {
        return j.A(hVar, hVar2, qVar);
    }

    @NotNull
    public static final <T1, T2, R> h<R> c(@NotNull h<? extends T1> hVar, @NotNull h<? extends T2> hVar2, @NotNull h9.q<? super T1, ? super T2, ? super z8.d<? super R>, ? extends Object> qVar) {
        return new a(hVar, hVar2, qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> h9.a<T[]> d() {
        return c.f33925g;
    }
}
