package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
final class DefaultRadioButtonColors implements RadioButtonColors {
    private final long disabledColor;
    private final long selectedColor;
    private final long unselectedColor;

    public /* synthetic */ DefaultRadioButtonColors(long j10, long j11, long j12, k kVar) {
        this(j10, j11, j12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(o0.b(DefaultRadioButtonColors.class), o0.b(obj.getClass()))) {
            return false;
        }
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) obj;
        return Color.m1599equalsimpl0(this.selectedColor, defaultRadioButtonColors.selectedColor) && Color.m1599equalsimpl0(this.unselectedColor, defaultRadioButtonColors.unselectedColor) && Color.m1599equalsimpl0(this.disabledColor, defaultRadioButtonColors.disabledColor);
    }

    public int hashCode() {
        return (((Color.m1605hashCodeimpl(this.selectedColor) * 31) + Color.m1605hashCodeimpl(this.unselectedColor)) * 31) + Color.m1605hashCodeimpl(this.disabledColor);
    }

    @Override // androidx.compose.material.RadioButtonColors
    @Composable
    @NotNull
    public State<Color> radioColor(boolean z10, boolean z11, @Nullable Composer composer, int i10) {
        State<Color> stateRememberUpdatedState;
        composer.startReplaceableGroup(1243421834);
        long j10 = !z10 ? this.disabledColor : !z11 ? this.unselectedColor : this.selectedColor;
        if (z10) {
            composer.startReplaceableGroup(-1052799218);
            stateRememberUpdatedState = SingleValueAnimationKt.m82animateColorAsStateKTwxG1Y(j10, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, composer, 48, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1052799113);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(j10), composer, 0);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    private DefaultRadioButtonColors(long j10, long j11, long j12) {
        this.selectedColor = j10;
        this.unselectedColor = j11;
        this.disabledColor = j12;
    }
}
