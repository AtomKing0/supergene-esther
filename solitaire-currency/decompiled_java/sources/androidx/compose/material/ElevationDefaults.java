package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Elevation.kt */
/* JADX INFO: loaded from: classes.dex */
final class ElevationDefaults {

    @NotNull
    public static final ElevationDefaults INSTANCE = new ElevationDefaults();

    private ElevationDefaults() {
    }

    @Nullable
    public final AnimationSpec<Dp> incomingAnimationSpecForInteraction(@NotNull Interaction interaction) {
        t.i(interaction, "interaction");
        if ((interaction instanceof PressInteraction.Press) || (interaction instanceof DragInteraction.Start) || (interaction instanceof HoverInteraction.Enter) || (interaction instanceof FocusInteraction.Focus)) {
            return ElevationKt.DefaultIncomingSpec;
        }
        return null;
    }

    @Nullable
    public final AnimationSpec<Dp> outgoingAnimationSpecForInteraction(@NotNull Interaction interaction) {
        t.i(interaction, "interaction");
        if (!(interaction instanceof PressInteraction.Press) && !(interaction instanceof DragInteraction.Start)) {
            if (interaction instanceof HoverInteraction.Enter) {
                return ElevationKt.HoveredOutgoingSpec;
            }
            if (interaction instanceof FocusInteraction.Focus) {
                return ElevationKt.DefaultOutgoingSpec;
            }
            return null;
        }
        return ElevationKt.DefaultOutgoingSpec;
    }
}
