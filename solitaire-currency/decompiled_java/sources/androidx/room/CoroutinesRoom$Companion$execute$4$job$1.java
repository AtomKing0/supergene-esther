package androidx.room;

import java.util.concurrent.Callable;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: CoroutinesRoom.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", l = {}, m = "invokeSuspend")
final class CoroutinesRoom$Companion$execute$4$job$1 extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ kotlinx.coroutines.o<R> $continuation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, kotlinx.coroutines.o<? super R> oVar, z8.d<? super CoroutinesRoom$Companion$execute$4$job$1> dVar) {
        super(2, dVar);
        this.$callable = callable;
        this.$continuation = oVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a9.d.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        v8.u.b(obj);
        try {
            this.$continuation.resumeWith(v8.t.b(this.$callable.call()));
        } catch (Throwable th) {
            z8.d dVar = this.$continuation;
            t.a aVar = v8.t.f35208b;
            dVar.resumeWith(v8.t.b(v8.u.a(th)));
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
