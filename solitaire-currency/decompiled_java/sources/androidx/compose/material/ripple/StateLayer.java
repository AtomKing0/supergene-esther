package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import h9.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: classes.dex */
final class StateLayer {

    @NotNull
    private final Animatable<Float, AnimationVector1D> animatedAlpha;
    private final boolean bounded;

    @Nullable
    private Interaction currentInteraction;

    @NotNull
    private final List<Interaction> interactions;

    @NotNull
    private final State<RippleAlpha> rippleAlpha;

    /* JADX INFO: renamed from: androidx.compose.material.ripple.StateLayer$handleInteraction$1, reason: invalid class name */
    /* JADX INFO: compiled from: Ripple.kt */
    @f(c = "androidx.compose.material.ripple.StateLayer$handleInteraction$1", f = "Ripple.kt", l = {290}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ AnimationSpec<Float> $incomingAnimationSpec;
        final /* synthetic */ float $targetAlpha;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(float f10, AnimationSpec<Float> animationSpec, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$targetAlpha = f10;
            this.$incomingAnimationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return StateLayer.this.new AnonymousClass1(this.$targetAlpha, this.$incomingAnimationSpec, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                Animatable animatable = StateLayer.this.animatedAlpha;
                Float fC = b.c(this.$targetAlpha);
                AnimationSpec<Float> animationSpec = this.$incomingAnimationSpec;
                this.label = 1;
                if (Animatable.animateTo$default(animatable, fC, animationSpec, null, null, this, 12, null) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ripple.StateLayer$handleInteraction$2, reason: invalid class name */
    /* JADX INFO: compiled from: Ripple.kt */
    @f(c = "androidx.compose.material.ripple.StateLayer$handleInteraction$2", f = "Ripple.kt", l = {296}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ AnimationSpec<Float> $outgoingAnimationSpec;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AnimationSpec<Float> animationSpec, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$outgoingAnimationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return StateLayer.this.new AnonymousClass2(this.$outgoingAnimationSpec, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                Animatable animatable = StateLayer.this.animatedAlpha;
                Float fC = b.c(0.0f);
                AnimationSpec<Float> animationSpec = this.$outgoingAnimationSpec;
                this.label = 1;
                if (Animatable.animateTo$default(animatable, fC, animationSpec, null, null, this, 12, null) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public StateLayer(boolean z10, @NotNull State<RippleAlpha> rippleAlpha) {
        t.i(rippleAlpha, "rippleAlpha");
        this.bounded = z10;
        this.rippleAlpha = rippleAlpha;
        this.animatedAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.interactions = new ArrayList();
    }

    /* JADX INFO: renamed from: drawStateLayer-H2RKhps, reason: not valid java name */
    public final void m1240drawStateLayerH2RKhps(@NotNull DrawScope drawStateLayer, float f10, long j10) {
        t.i(drawStateLayer, "$this$drawStateLayer");
        float fM1231getRippleEndRadiuscSwnlzA = Float.isNaN(f10) ? RippleAnimationKt.m1231getRippleEndRadiuscSwnlzA(drawStateLayer, this.bounded, drawStateLayer.mo1996getSizeNHjbRc()) : drawStateLayer.mo296toPx0680j_4(f10);
        float fFloatValue = this.animatedAlpha.getValue().floatValue();
        if (fFloatValue > 0.0f) {
            long jM1597copywmQWz5c$default = Color.m1597copywmQWz5c$default(j10, fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
            if (!this.bounded) {
                androidx.compose.ui.graphics.drawscope.b.x(drawStateLayer, jM1597copywmQWz5c$default, fM1231getRippleEndRadiuscSwnlzA, 0L, 0.0f, null, null, 0, 124, null);
                return;
            }
            float fM1436getWidthimpl = Size.m1436getWidthimpl(drawStateLayer.mo1996getSizeNHjbRc());
            float fM1433getHeightimpl = Size.m1433getHeightimpl(drawStateLayer.mo1996getSizeNHjbRc());
            int iM1587getIntersectrtfAjoo = ClipOp.Companion.m1587getIntersectrtfAjoo();
            DrawContext drawContext = drawStateLayer.getDrawContext();
            long jMo2002getSizeNHjbRc = drawContext.mo2002getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().mo2005clipRectN_I0leg(0.0f, 0.0f, fM1436getWidthimpl, fM1433getHeightimpl, iM1587getIntersectrtfAjoo);
            androidx.compose.ui.graphics.drawscope.b.x(drawStateLayer, jM1597copywmQWz5c$default, fM1231getRippleEndRadiuscSwnlzA, 0L, 0.0f, null, null, 0, 124, null);
            drawContext.getCanvas().restore();
            drawContext.mo2003setSizeuvyYCjk(jMo2002getSizeNHjbRc);
        }
    }

    public final void handleInteraction(@NotNull Interaction interaction, @NotNull o0 scope) {
        t.i(interaction, "interaction");
        t.i(scope, "scope");
        boolean z10 = interaction instanceof HoverInteraction.Enter;
        if (z10) {
            this.interactions.add(interaction);
        } else if (interaction instanceof HoverInteraction.Exit) {
            this.interactions.remove(((HoverInteraction.Exit) interaction).getEnter());
        } else if (interaction instanceof FocusInteraction.Focus) {
            this.interactions.add(interaction);
        } else if (interaction instanceof FocusInteraction.Unfocus) {
            this.interactions.remove(((FocusInteraction.Unfocus) interaction).getFocus());
        } else if (interaction instanceof DragInteraction.Start) {
            this.interactions.add(interaction);
        } else if (interaction instanceof DragInteraction.Stop) {
            this.interactions.remove(((DragInteraction.Stop) interaction).getStart());
        } else if (!(interaction instanceof DragInteraction.Cancel)) {
            return;
        } else {
            this.interactions.remove(((DragInteraction.Cancel) interaction).getStart());
        }
        Interaction interaction2 = (Interaction) d0.u0(this.interactions);
        if (t.d(this.currentInteraction, interaction2)) {
            return;
        }
        if (interaction2 != null) {
            k.d(scope, null, null, new AnonymousClass1(z10 ? this.rippleAlpha.getValue().getHoveredAlpha() : interaction instanceof FocusInteraction.Focus ? this.rippleAlpha.getValue().getFocusedAlpha() : interaction instanceof DragInteraction.Start ? this.rippleAlpha.getValue().getDraggedAlpha() : 0.0f, RippleKt.incomingStateLayerAnimationSpecFor(interaction2), null), 3, null);
        } else {
            k.d(scope, null, null, new AnonymousClass2(RippleKt.outgoingStateLayerAnimationSpecFor(this.currentInteraction), null), 3, null);
        }
        this.currentInteraction = interaction2;
    }
}
