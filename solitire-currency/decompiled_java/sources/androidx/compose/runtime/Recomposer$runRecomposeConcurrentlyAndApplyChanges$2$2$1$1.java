package androidx.compose.runtime;

import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1", f = "Recomposer.kt", l = {}, m = "invokeSuspend")
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1 extends l implements p<o0, z8.d<? super k0>, Object> {
    final /* synthetic */ ControlledComposition $composition;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1(Recomposer recomposer, ControlledComposition controlledComposition, z8.d<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1> dVar) {
        super(2, dVar);
        this.this$0 = recomposer;
        this.$composition = controlledComposition;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1(this.this$0, this.$composition, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        o oVarDeriveStateLocked;
        a9.d.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u.b(obj);
        ControlledComposition controlledCompositionPerformRecompose = this.this$0.performRecompose(this.$composition, null);
        Object obj2 = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (obj2) {
            if (controlledCompositionPerformRecompose != null) {
                try {
                    recomposer.compositionsAwaitingApply.add(controlledCompositionPerformRecompose);
                } catch (Throwable th) {
                    throw th;
                }
            }
            recomposer.concurrentCompositionsOutstanding--;
            oVarDeriveStateLocked = recomposer.deriveStateLocked();
        }
        if (oVarDeriveStateLocked != null) {
            t.a aVar = t.f35208b;
            oVarDeriveStateLocked.resumeWith(t.b(k0.f35197a));
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
