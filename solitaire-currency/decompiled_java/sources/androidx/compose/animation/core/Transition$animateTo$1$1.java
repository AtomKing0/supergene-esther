package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.Transition$animateTo$1$1", f = "Transition.kt", l = {434}, m = "invokeSuspend")
final class Transition$animateTo$1$1 extends l implements p<o0, z8.d<? super k0>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Transition<S> this$0;

    /* JADX INFO: renamed from: androidx.compose.animation.core.Transition$animateTo$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    static final class AnonymousClass1 extends v implements h9.l<Long, k0> {
        final /* synthetic */ float $durationScale;
        final /* synthetic */ Transition<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Transition<S> transition, float f10) {
            super(1);
            this.this$0 = transition;
            this.$durationScale = f10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Long l10) {
            invoke(l10.longValue());
            return k0.f35197a;
        }

        public final void invoke(long j10) {
            if (this.this$0.isSeeking()) {
                return;
            }
            this.this$0.onFrame$animation_core_release(j10 / 1, this.$durationScale);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Transition$animateTo$1$1(Transition<S> transition, z8.d<? super Transition$animateTo$1$1> dVar) {
        super(2, dVar);
        this.this$0 = transition;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        Transition$animateTo$1$1 transition$animateTo$1$1 = new Transition$animateTo$1$1(this.this$0, dVar);
        transition$animateTo$1$1.L$0 = obj;
        return transition$animateTo$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        o0 o0Var;
        AnonymousClass1 anonymousClass1;
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            o0Var = (o0) this.L$0;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o0Var = (o0) this.L$0;
            u.b(obj);
        }
        do {
            anonymousClass1 = new AnonymousClass1(this.this$0, SuspendAnimationKt.getDurationScale(o0Var.getCoroutineContext()));
            this.L$0 = o0Var;
            this.label = 1;
        } while (MonotonicFrameClockKt.withFrameNanos(anonymousClass1, this) != objE);
        return objE;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((Transition$animateTo$1$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
