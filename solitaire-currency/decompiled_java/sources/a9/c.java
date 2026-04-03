package a9;

import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.j;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: IntrinsicsJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class a extends j {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f381j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ p f382k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Object f383l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(z8.d dVar, p pVar, Object obj) {
            super(dVar);
            this.f382k = pVar;
            this.f383l = obj;
            t.g(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        protected Object invokeSuspend(@NotNull Object obj) {
            int i10 = this.f381j;
            if (i10 == 0) {
                this.f381j = 1;
                u.b(obj);
                t.g(this.f382k, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) t0.f(this.f382k, 2)).mo4invoke(this.f383l, this);
            }
            if (i10 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f381j = 2;
            u.b(obj);
            return obj;
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f384j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ p f385k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Object f386l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(z8.d dVar, g gVar, p pVar, Object obj) {
            super(dVar, gVar);
            this.f385k = pVar;
            this.f386l = obj;
            t.g(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        protected Object invokeSuspend(@NotNull Object obj) {
            int i10 = this.f384j;
            if (i10 == 0) {
                this.f384j = 1;
                u.b(obj);
                t.g(this.f385k, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((p) t0.f(this.f385k, 2)).mo4invoke(this.f386l, this);
            }
            if (i10 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f384j = 2;
            u.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: a9.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class C0007c extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0007c(z8.d<? super T> dVar) {
            super(dVar);
            t.g(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        protected Object invokeSuspend(@NotNull Object obj) {
            u.b(obj);
            return obj;
        }
    }

    /* JADX INFO: compiled from: IntrinsicsJvm.kt */
    public static final class d extends kotlin.coroutines.jvm.internal.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(z8.d<? super T> dVar, g gVar) {
            super(dVar, gVar);
            t.g(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        protected Object invokeSuspend(@NotNull Object obj) {
            u.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <R, T> z8.d<k0> a(@NotNull p<? super R, ? super z8.d<? super T>, ? extends Object> pVar, R r10, @NotNull z8.d<? super T> completion) {
        t.i(pVar, "<this>");
        t.i(completion, "completion");
        z8.d<?> dVarA = h.a(completion);
        if (pVar instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) pVar).create(r10, dVarA);
        }
        g context = dVarA.getContext();
        return context == z8.h.f37608a ? new a(dVarA, pVar, r10) : new b(dVarA, context, pVar, r10);
    }

    private static final <T> z8.d<T> b(z8.d<? super T> dVar) {
        g context = dVar.getContext();
        return context == z8.h.f37608a ? new C0007c(dVar) : new d(dVar, context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> z8.d<T> c(@NotNull z8.d<? super T> dVar) {
        z8.d<T> dVar2;
        t.i(dVar, "<this>");
        kotlin.coroutines.jvm.internal.d dVar3 = dVar instanceof kotlin.coroutines.jvm.internal.d ? (kotlin.coroutines.jvm.internal.d) dVar : null;
        return (dVar3 == null || (dVar2 = (z8.d<T>) dVar3.intercepted()) == null) ? dVar : dVar2;
    }

    @Nullable
    public static <R, P, T> Object d(@NotNull q<? super R, ? super P, ? super z8.d<? super T>, ? extends Object> qVar, R r10, P p10, @NotNull z8.d<? super T> completion) {
        t.i(qVar, "<this>");
        t.i(completion, "completion");
        return ((q) t0.f(qVar, 3)).invoke(r10, p10, b(h.a(completion)));
    }
}
