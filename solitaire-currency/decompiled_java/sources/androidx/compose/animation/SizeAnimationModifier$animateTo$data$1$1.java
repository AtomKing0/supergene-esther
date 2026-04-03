package androidx.compose.animation;

import androidx.compose.animation.SizeAnimationModifier;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationEndReason;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.unit.IntSize;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: AnimationModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.animation.SizeAnimationModifier$animateTo$data$1$1", f = "AnimationModifier.kt", l = {121}, m = "invokeSuspend")
final class SizeAnimationModifier$animateTo$data$1$1 extends l implements p<o0, d<? super k0>, Object> {
    final /* synthetic */ long $targetSize;
    final /* synthetic */ SizeAnimationModifier.AnimData $this_apply;
    int label;
    final /* synthetic */ SizeAnimationModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SizeAnimationModifier$animateTo$data$1$1(SizeAnimationModifier.AnimData animData, long j10, SizeAnimationModifier sizeAnimationModifier, d<? super SizeAnimationModifier$animateTo$data$1$1> dVar) {
        super(2, dVar);
        this.$this_apply = animData;
        this.$targetSize = j10;
        this.this$0 = sizeAnimationModifier;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new SizeAnimationModifier$animateTo$data$1$1(this.$this_apply, this.$targetSize, this.this$0, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        p<IntSize, IntSize, k0> listener;
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            Animatable<IntSize, AnimationVector2D> anim = this.$this_apply.getAnim();
            IntSize intSizeM3825boximpl = IntSize.m3825boximpl(this.$targetSize);
            AnimationSpec<IntSize> animSpec = this.this$0.getAnimSpec();
            this.label = 1;
            obj = Animatable.animateTo$default(anim, intSizeM3825boximpl, animSpec, null, null, this, 12, null);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        AnimationResult animationResult = (AnimationResult) obj;
        if (animationResult.getEndReason() == AnimationEndReason.Finished && (listener = this.this$0.getListener()) != 0) {
            listener.mo4invoke(IntSize.m3825boximpl(this.$this_apply.m87getStartSizeYbymL2g()), animationResult.getEndState().getValue());
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
        return ((SizeAnimationModifier$animateTo$data$1$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
