package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldDefaultsKt {
    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    /* JADX INFO: renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final State<BorderStroke> m1202animateBorderStrokeAsStateNuRrP5Q(boolean z10, boolean z11, InteractionSource interactionSource, TextFieldColors textFieldColors, float f10, float f11, Composer composer, int i10) {
        State<Dp> stateRememberUpdatedState;
        composer.startReplaceableGroup(1097899920);
        State<Boolean> stateCollectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i10 >> 6) & 14);
        State<Color> stateIndicatorColor = textFieldColors.indicatorColor(z10, z11, interactionSource, composer, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168));
        float f12 = m1203animateBorderStrokeAsState_NuRrP5Q$lambda0(stateCollectIsFocusedAsState) ? f10 : f11;
        if (z10) {
            composer.startReplaceableGroup(1685712037);
            stateRememberUpdatedState = AnimateAsStateKt.m95animateDpAsStateKz89ssw(f12, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, composer, 48, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1685712135);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Dp.m3671boximpl(f11), composer, (i10 >> 15) & 14);
            composer.endReplaceableGroup();
        }
        State<BorderStroke> stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(new BorderStroke(stateRememberUpdatedState.getValue().m3687unboximpl(), new SolidColor(stateIndicatorColor.getValue().m1608unboximpl(), null), null), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState2;
    }

    /* JADX INFO: renamed from: animateBorderStrokeAsState_NuRrP5Q$lambda-0, reason: not valid java name */
    private static final boolean m1203animateBorderStrokeAsState_NuRrP5Q$lambda0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
