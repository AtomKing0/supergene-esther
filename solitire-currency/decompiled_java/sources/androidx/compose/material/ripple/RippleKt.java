package androidx.compose.material.ripple;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RippleKt {

    @NotNull
    private static final TweenSpec<Float> DefaultTweenSpec = new TweenSpec<>(15, 0, EasingKt.getLinearEasing(), 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Float> incomingStateLayerAnimationSpecFor(Interaction interaction) {
        return interaction instanceof HoverInteraction.Enter ? DefaultTweenSpec : interaction instanceof FocusInteraction.Focus ? new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, null) : interaction instanceof DragInteraction.Start ? new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, null) : DefaultTweenSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Float> outgoingStateLayerAnimationSpecFor(Interaction interaction) {
        return interaction instanceof HoverInteraction.Enter ? DefaultTweenSpec : interaction instanceof FocusInteraction.Focus ? DefaultTweenSpec : interaction instanceof DragInteraction.Start ? new TweenSpec(150, 0, EasingKt.getLinearEasing(), 2, null) : DefaultTweenSpec;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: rememberRipple-9IZ8Weo, reason: not valid java name */
    public static final Indication m1237rememberRipple9IZ8Weo(boolean z10, float f10, long j10, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(1635163520);
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        if ((i11 & 2) != 0) {
            f10 = Dp.Companion.m3693getUnspecifiedD9Ej5fM();
        }
        if ((i11 & 4) != 0) {
            j10 = Color.Companion.m1634getUnspecified0d7_KjU();
        }
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(j10), composer, (i10 >> 6) & 14);
        Boolean boolValueOf = Boolean.valueOf(z10);
        Dp dpM3671boximpl = Dp.m3671boximpl(f10);
        composer.startReplaceableGroup(-3686552);
        boolean zChanged = composer.changed(boolValueOf) | composer.changed(dpM3671boximpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new PlatformRipple(z10, f10, stateRememberUpdatedState, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        PlatformRipple platformRipple = (PlatformRipple) objRememberedValue;
        composer.endReplaceableGroup();
        return platformRipple;
    }
}
