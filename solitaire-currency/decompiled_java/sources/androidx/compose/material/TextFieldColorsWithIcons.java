package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterialApi
public interface TextFieldColorsWithIcons extends TextFieldColors {

    /* JADX INFO: compiled from: TextFieldDefaults.kt */
    public static final class DefaultImpls {
        @Composable
        @NotNull
        public static State<Color> leadingIconColor(@NotNull TextFieldColorsWithIcons textFieldColorsWithIcons, boolean z10, boolean z11, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10) {
            t.i(interactionSource, "interactionSource");
            composer.startReplaceableGroup(1279189910);
            State<Color> stateLeadingIconColor = textFieldColorsWithIcons.leadingIconColor(z10, z11, composer, (i10 & 14) | (i10 & 112) | ((i10 >> 3) & 896));
            composer.endReplaceableGroup();
            return stateLeadingIconColor;
        }

        @Composable
        @NotNull
        public static State<Color> trailingIconColor(@NotNull TextFieldColorsWithIcons textFieldColorsWithIcons, boolean z10, boolean z11, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10) {
            t.i(interactionSource, "interactionSource");
            composer.startReplaceableGroup(-712140408);
            State<Color> stateTrailingIconColor = textFieldColorsWithIcons.trailingIconColor(z10, z11, composer, (i10 & 14) | (i10 & 112) | ((i10 >> 3) & 896));
            composer.endReplaceableGroup();
            return stateTrailingIconColor;
        }
    }

    @Composable
    @NotNull
    State<Color> leadingIconColor(boolean z10, boolean z11, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10);

    @Composable
    @NotNull
    State<Color> trailingIconColor(boolean z10, boolean z11, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10);
}
