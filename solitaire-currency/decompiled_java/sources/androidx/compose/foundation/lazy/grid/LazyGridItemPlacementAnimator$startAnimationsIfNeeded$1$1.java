package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import h9.p;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: LazyGridItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1", f = "LazyGridItemPlacementAnimator.kt", l = {TypedValues.CycleType.TYPE_EASING}, m = "invokeSuspend")
final class LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1 extends l implements p<o0, d<? super k0>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $animationSpec;
    final /* synthetic */ PlaceableInfo $placeableInfo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1(PlaceableInfo placeableInfo, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, d<? super LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1> dVar) {
        super(2, dVar);
        this.$placeableInfo = placeableInfo;
        this.$animationSpec = finiteAnimationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1(this.$placeableInfo, this.$animationSpec, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AnimationSpec animationSpec;
        Object objE = a9.d.e();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                u.b(obj);
                if (this.$placeableInfo.getAnimatedOffset().isRunning()) {
                    FiniteAnimationSpec<IntOffset> finiteAnimationSpec = this.$animationSpec;
                    animationSpec = finiteAnimationSpec instanceof SpringSpec ? (SpringSpec) finiteAnimationSpec : LazyGridItemPlacementAnimatorKt.InterruptionSpec;
                } else {
                    animationSpec = this.$animationSpec;
                }
                AnimationSpec animationSpec2 = animationSpec;
                Animatable<IntOffset, AnimationVector2D> animatedOffset = this.$placeableInfo.getAnimatedOffset();
                IntOffset intOffsetM3782boximpl = IntOffset.m3782boximpl(this.$placeableInfo.m604getTargetOffsetnOccac());
                this.label = 1;
                if (Animatable.animateTo$default(animatedOffset, intOffsetM3782boximpl, animationSpec2, null, null, this, 12, null) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            this.$placeableInfo.setInProgress(false);
        } catch (CancellationException unused) {
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
        return ((LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
