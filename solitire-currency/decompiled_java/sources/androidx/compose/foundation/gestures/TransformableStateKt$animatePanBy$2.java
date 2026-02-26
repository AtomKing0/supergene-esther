package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.geometry.Offset;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: TransformableState.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableStateKt$animatePanBy$2", f = "TransformableState.kt", l = {182}, m = "invokeSuspend")
final class TransformableStateKt$animatePanBy$2 extends l implements p<TransformScope, z8.d<? super k0>, Object> {
    final /* synthetic */ AnimationSpec<Offset> $animationSpec;
    final /* synthetic */ long $offset;
    final /* synthetic */ m0 $previous;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animatePanBy$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: TransformableState.kt */
    static final class AnonymousClass1 extends v implements h9.l<AnimationScope<Offset, AnimationVector2D>, k0> {
        final /* synthetic */ TransformScope $$this$transform;
        final /* synthetic */ m0 $previous;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(m0 m0Var, TransformScope transformScope) {
            super(1);
            this.$previous = m0Var;
            this.$$this$transform = transformScope;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(AnimationScope<Offset, AnimationVector2D> animationScope) {
            invoke2(animationScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull AnimationScope<Offset, AnimationVector2D> animateTo) {
            t.i(animateTo, "$this$animateTo");
            e.a(this.$$this$transform, 0.0f, Offset.m1371minusMKHz9U(animateTo.getValue().m1377unboximpl(), this.$previous.f29833a), 0.0f, 5, null);
            this.$previous.f29833a = animateTo.getValue().m1377unboximpl();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableStateKt$animatePanBy$2(m0 m0Var, long j10, AnimationSpec<Offset> animationSpec, z8.d<? super TransformableStateKt$animatePanBy$2> dVar) {
        super(2, dVar);
        this.$previous = m0Var;
        this.$offset = j10;
        this.$animationSpec = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        TransformableStateKt$animatePanBy$2 transformableStateKt$animatePanBy$2 = new TransformableStateKt$animatePanBy$2(this.$previous, this.$offset, this.$animationSpec, dVar);
        transformableStateKt$animatePanBy$2.L$0 = obj;
        return transformableStateKt$animatePanBy$2;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull TransformScope transformScope, @Nullable z8.d<? super k0> dVar) {
        return ((TransformableStateKt$animatePanBy$2) create(transformScope, dVar)).invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            TransformScope transformScope = (TransformScope) this.L$0;
            AnimationState animationState = new AnimationState(VectorConvertersKt.getVectorConverter(Offset.Companion), Offset.m1356boximpl(this.$previous.f29833a), null, 0L, 0L, false, 60, null);
            Offset offsetM1356boximpl = Offset.m1356boximpl(this.$offset);
            AnimationSpec<Offset> animationSpec = this.$animationSpec;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$previous, transformScope);
            this.label = 1;
            if (SuspendAnimationKt.animateTo$default(animationState, offsetM1356boximpl, animationSpec, false, anonymousClass1, this, 4, null) == objE) {
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
}
