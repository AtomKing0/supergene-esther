package io.ktor.utils.io;

import kotlinx.coroutines.b2;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: Coroutines.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: compiled from: Coroutines.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f26933g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c cVar) {
            super(1);
            this.f26933g = cVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            this.f26933g.d(th);
        }
    }

    /* JADX INFO: compiled from: Coroutines.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.CoroutinesKt$launchChannel$job$1", f = "Coroutines.kt", l = {147}, m = "invokeSuspend")
    static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f26934j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f26935k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f26936l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ c f26937m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ h9.p<S, z8.d<? super k0>, Object> f26938n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.k0 f26939o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(boolean z10, c cVar, h9.p<? super S, ? super z8.d<? super k0>, ? extends Object> pVar, kotlinx.coroutines.k0 k0Var, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f26936l = z10;
            this.f26937m = cVar;
            this.f26938n = pVar;
            this.f26939o = k0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = new b(this.f26936l, this.f26937m, this.f26938n, this.f26939o, dVar);
            bVar.f26935k = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f26934j;
            try {
                if (i10 == 0) {
                    v8.u.b(obj);
                    o0 o0Var = (o0) this.f26935k;
                    if (this.f26936l) {
                        c cVar = this.f26937m;
                        g.b bVar = o0Var.getCoroutineContext().get(b2.O7);
                        kotlin.jvm.internal.t.f(bVar);
                        cVar.a((b2) bVar);
                    }
                    m mVar = new m(o0Var, this.f26937m);
                    h9.p<S, z8.d<? super k0>, Object> pVar = this.f26938n;
                    this.f26934j = 1;
                    if (pVar.mo4invoke(mVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
            } catch (Throwable th) {
                if (!kotlin.jvm.internal.t.d(this.f26939o, e1.d()) && this.f26939o != null) {
                    throw th;
                }
                this.f26937m.b(th);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    private static final <S extends o0> l a(o0 o0Var, z8.g gVar, c cVar, boolean z10, h9.p<? super S, ? super z8.d<? super k0>, ? extends Object> pVar) {
        b2 b2VarD = kotlinx.coroutines.k.d(o0Var, gVar, null, new b(z10, cVar, pVar, (kotlinx.coroutines.k0) o0Var.getCoroutineContext().get(kotlinx.coroutines.k0.Key), null), 2, null);
        b2VarD.J(new a(cVar));
        return new l(b2VarD, cVar);
    }

    @NotNull
    public static final t b(@NotNull o0 o0Var, @NotNull z8.g coroutineContext, boolean z10, @NotNull h9.p<? super u, ? super z8.d<? super k0>, ? extends Object> block) {
        kotlin.jvm.internal.t.i(o0Var, "<this>");
        kotlin.jvm.internal.t.i(coroutineContext, "coroutineContext");
        kotlin.jvm.internal.t.i(block, "block");
        return a(o0Var, coroutineContext, e.a(z10), true, block);
    }

    @NotNull
    public static final v c(@NotNull o0 o0Var, @NotNull z8.g coroutineContext, @NotNull c channel, @NotNull h9.p<? super w, ? super z8.d<? super k0>, ? extends Object> block) {
        kotlin.jvm.internal.t.i(o0Var, "<this>");
        kotlin.jvm.internal.t.i(coroutineContext, "coroutineContext");
        kotlin.jvm.internal.t.i(channel, "channel");
        kotlin.jvm.internal.t.i(block, "block");
        return a(o0Var, coroutineContext, channel, false, block);
    }

    @NotNull
    public static final v d(@NotNull o0 o0Var, @NotNull z8.g coroutineContext, boolean z10, @NotNull h9.p<? super w, ? super z8.d<? super k0>, ? extends Object> block) {
        kotlin.jvm.internal.t.i(o0Var, "<this>");
        kotlin.jvm.internal.t.i(coroutineContext, "coroutineContext");
        kotlin.jvm.internal.t.i(block, "block");
        return a(o0Var, coroutineContext, e.a(z10), true, block);
    }

    public static /* synthetic */ v e(o0 o0Var, z8.g gVar, c cVar, h9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        return c(o0Var, gVar, cVar, pVar);
    }

    public static /* synthetic */ v f(o0 o0Var, z8.g gVar, boolean z10, h9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return d(o0Var, gVar, z10, pVar);
    }
}
