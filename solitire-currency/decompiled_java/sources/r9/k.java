package r9;

import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.h;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class k {

    /* JADX INFO: compiled from: Channels.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", l = {39}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super h<? extends k0>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33398j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f33399k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ u<E> f33400l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ E f33401m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(u<? super E> uVar, E e10, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f33400l = uVar;
            this.f33401m = e10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f33400l, this.f33401m, dVar);
            aVar.f33399k = obj;
            return aVar;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(o0 o0Var, z8.d<? super h<? extends k0>> dVar) {
            return invoke2(o0Var, (z8.d<? super h<k0>>) dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objB;
            Object objE = a9.d.e();
            int i10 = this.f33398j;
            try {
                if (i10 == 0) {
                    v8.u.b(obj);
                    u<E> uVar = this.f33400l;
                    E e10 = this.f33401m;
                    t.a aVar = v8.t.f35208b;
                    this.f33398j = 1;
                    if (uVar.p(e10, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                objB = v8.t.b(k0.f35197a);
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(th));
            }
            return h.b(v8.t.h(objB) ? h.f33392b.c(k0.f35197a) : h.f33392b.a(v8.t.e(objB)));
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull o0 o0Var, @Nullable z8.d<? super h<k0>> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <E> Object a(@NotNull u<? super E> uVar, E e10) {
        Object objF = uVar.f(e10);
        if (objF instanceof h.c) {
            return ((h) kotlinx.coroutines.j.b(null, new a(uVar, e10, null), 1, null)).k();
        }
        return h.f33392b.c(k0.f35197a);
    }
}
