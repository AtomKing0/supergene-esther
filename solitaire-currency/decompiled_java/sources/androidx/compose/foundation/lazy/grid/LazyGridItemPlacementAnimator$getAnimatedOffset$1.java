package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.unit.IntOffset;
import h9.p;
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
@f(c = "androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$getAnimatedOffset$1", f = "LazyGridItemPlacementAnimator.kt", l = {324}, m = "invokeSuspend")
final class LazyGridItemPlacementAnimator$getAnimatedOffset$1 extends l implements p<o0, d<? super k0>, Object> {
    final /* synthetic */ PlaceableInfo $item;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridItemPlacementAnimator$getAnimatedOffset$1(PlaceableInfo placeableInfo, d<? super LazyGridItemPlacementAnimator$getAnimatedOffset$1> dVar) {
        super(2, dVar);
        this.$item = placeableInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new LazyGridItemPlacementAnimator$getAnimatedOffset$1(this.$item, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            Animatable<IntOffset, AnimationVector2D> animatedOffset = this.$item.getAnimatedOffset();
            IntOffset intOffsetM3782boximpl = IntOffset.m3782boximpl(this.$item.m604getTargetOffsetnOccac());
            this.label = 1;
            if (animatedOffset.snapTo(intOffsetM3782boximpl, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        this.$item.setInProgress(false);
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
        return ((LazyGridItemPlacementAnimator$getAnimatedOffset$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
