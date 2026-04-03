package androidx.compose.runtime;

import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1", f = "Recomposer.kt", l = {590}, m = "invokeSuspend")
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1 extends l implements p<o0, z8.d<? super k0>, Object> {
    final /* synthetic */ ProduceFrameSignal $frameSignal;
    final /* synthetic */ MonotonicFrameClock $parentFrameClock;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(Recomposer recomposer, MonotonicFrameClock monotonicFrameClock, ProduceFrameSignal produceFrameSignal, z8.d<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1> dVar) {
        super(2, dVar);
        this.this$0 = recomposer;
        this.$parentFrameClock = monotonicFrameClock;
        this.$frameSignal = produceFrameSignal;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(this.this$0, this.$parentFrameClock, this.$frameSignal, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            Recomposer recomposer = this.this$0;
            MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
            ProduceFrameSignal produceFrameSignal = this.$frameSignal;
            this.label = 1;
            if (recomposer.runFrameLoop(monotonicFrameClock, produceFrameSignal, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
