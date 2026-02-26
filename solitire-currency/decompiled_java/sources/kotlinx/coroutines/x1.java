package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Interruptible.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class x1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Interruptible.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", l = {}, m = "invokeSuspend")
    static final class a<T> extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super T>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f29992j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f29993k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ h9.a<T> f29994l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(h9.a<? extends T> aVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f29994l = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f29994l, dVar);
            aVar.f29993k = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f29992j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            return x1.d(((o0) this.f29993k).getCoroutineContext(), this.f29994l);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super T> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    @Nullable
    public static final <T> Object b(@NotNull z8.g gVar, @NotNull h9.a<? extends T> aVar, @NotNull z8.d<? super T> dVar) {
        return i.g(gVar, new a(aVar, null), dVar);
    }

    public static /* synthetic */ Object c(z8.g gVar, h9.a aVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        return b(gVar, aVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T d(z8.g gVar, h9.a<? extends T> aVar) throws Throwable {
        try {
            c3 c3Var = new c3(f2.l(gVar));
            c3Var.d();
            try {
                return aVar.invoke();
            } finally {
                c3Var.a();
            }
        } catch (InterruptedException e10) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e10);
        }
    }
}
