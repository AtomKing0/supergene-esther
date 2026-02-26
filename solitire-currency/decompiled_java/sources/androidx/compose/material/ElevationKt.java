package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: Elevation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ElevationKt {

    @NotNull
    private static final TweenSpec<Dp> DefaultIncomingSpec = new TweenSpec<>(120, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    @NotNull
    private static final TweenSpec<Dp> DefaultOutgoingSpec = new TweenSpec<>(150, 0, new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f), 2, null);

    @NotNull
    private static final TweenSpec<Dp> HoveredOutgoingSpec = new TweenSpec<>(120, 0, new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f), 2, null);

    @Nullable
    /* JADX INFO: renamed from: animateElevation-rAjV9yQ, reason: not valid java name */
    public static final Object m1016animateElevationrAjV9yQ(@NotNull Animatable<Dp, ?> animatable, float f10, @Nullable Interaction interaction, @Nullable Interaction interaction2, @NotNull d<? super k0> dVar) {
        AnimationSpec<Dp> animationSpecIncomingAnimationSpecForInteraction = interaction2 != null ? ElevationDefaults.INSTANCE.incomingAnimationSpecForInteraction(interaction2) : interaction != null ? ElevationDefaults.INSTANCE.outgoingAnimationSpecForInteraction(interaction) : null;
        if (animationSpecIncomingAnimationSpecForInteraction != null) {
            Object objAnimateTo$default = Animatable.animateTo$default(animatable, Dp.m3671boximpl(f10), animationSpecIncomingAnimationSpecForInteraction, null, null, dVar, 12, null);
            return objAnimateTo$default == a9.d.e() ? objAnimateTo$default : k0.f35197a;
        }
        Object objSnapTo = animatable.snapTo(Dp.m3671boximpl(f10), dVar);
        return objSnapTo == a9.d.e() ? objSnapTo : k0.f35197a;
    }

    /* JADX INFO: renamed from: animateElevation-rAjV9yQ$default, reason: not valid java name */
    public static /* synthetic */ Object m1017animateElevationrAjV9yQ$default(Animatable animatable, float f10, Interaction interaction, Interaction interaction2, d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interaction = null;
        }
        if ((i10 & 4) != 0) {
            interaction2 = null;
        }
        return m1016animateElevationrAjV9yQ(animatable, f10, interaction, interaction2, dVar);
    }
}
