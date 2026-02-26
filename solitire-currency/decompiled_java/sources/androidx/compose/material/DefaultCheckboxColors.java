package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.state.ToggleableState;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
final class DefaultCheckboxColors implements CheckboxColors {
    private final long checkedBorderColor;
    private final long checkedBoxColor;
    private final long checkedCheckmarkColor;
    private final long disabledBorderColor;
    private final long disabledCheckedBoxColor;
    private final long disabledIndeterminateBorderColor;
    private final long disabledIndeterminateBoxColor;
    private final long disabledUncheckedBoxColor;
    private final long uncheckedBorderColor;
    private final long uncheckedBoxColor;
    private final long uncheckedCheckmarkColor;

    /* JADX INFO: compiled from: Checkbox.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Indeterminate.ordinal()] = 2;
            iArr[ToggleableState.Off.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ DefaultCheckboxColors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, k kVar) {
        this(j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20);
    }

    @Override // androidx.compose.material.CheckboxColors
    @Composable
    @NotNull
    public State<Color> borderColor(boolean z10, @NotNull ToggleableState state, @Nullable Composer composer, int i10) {
        long j10;
        State<Color> stateRememberUpdatedState;
        t.i(state, "state");
        composer.startReplaceableGroup(-1568341342);
        if (z10) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i11 == 1 || i11 == 2) {
                j10 = this.checkedBorderColor;
            } else {
                if (i11 != 3) {
                    throw new q();
                }
                j10 = this.uncheckedBorderColor;
            }
        } else {
            int i12 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i12 == 1) {
                j10 = this.disabledBorderColor;
            } else if (i12 != 2) {
                if (i12 != 3) {
                    throw new q();
                }
                j10 = this.disabledBorderColor;
            } else {
                j10 = this.disabledIndeterminateBorderColor;
            }
        }
        long j11 = j10;
        if (z10) {
            composer.startReplaceableGroup(-796405338);
            stateRememberUpdatedState = SingleValueAnimationKt.m82animateColorAsStateKTwxG1Y(j11, AnimationSpecKt.tween$default(state == ToggleableState.Off ? 100 : 50, 0, null, 6, null), null, composer, 0, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-796405152);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(j11), composer, 0);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.CheckboxColors
    @Composable
    @NotNull
    public State<Color> boxColor(boolean z10, @NotNull ToggleableState state, @Nullable Composer composer, int i10) {
        long j10;
        State<Color> stateRememberUpdatedState;
        t.i(state, "state");
        composer.startReplaceableGroup(840901029);
        if (z10) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i11 == 1 || i11 == 2) {
                j10 = this.checkedBoxColor;
            } else {
                if (i11 != 3) {
                    throw new q();
                }
                j10 = this.uncheckedBoxColor;
            }
        } else {
            int i12 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i12 == 1) {
                j10 = this.disabledCheckedBoxColor;
            } else if (i12 == 2) {
                j10 = this.disabledIndeterminateBoxColor;
            } else {
                if (i12 != 3) {
                    throw new q();
                }
                j10 = this.disabledUncheckedBoxColor;
            }
        }
        long j11 = j10;
        if (z10) {
            composer.startReplaceableGroup(-2010643579);
            stateRememberUpdatedState = SingleValueAnimationKt.m82animateColorAsStateKTwxG1Y(j11, AnimationSpecKt.tween$default(state == ToggleableState.Off ? 100 : 50, 0, null, 6, null), null, composer, 0, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-2010643393);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(j11), composer, 0);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.CheckboxColors
    @Composable
    @NotNull
    public State<Color> checkmarkColor(@NotNull ToggleableState state, @Nullable Composer composer, int i10) {
        t.i(state, "state");
        composer.startReplaceableGroup(544656267);
        ToggleableState toggleableState = ToggleableState.Off;
        State<Color> stateM82animateColorAsStateKTwxG1Y = SingleValueAnimationKt.m82animateColorAsStateKTwxG1Y(state == toggleableState ? this.uncheckedCheckmarkColor : this.checkedCheckmarkColor, AnimationSpecKt.tween$default(state == toggleableState ? 100 : 50, 0, null, 6, null), null, composer, 0, 4);
        composer.endReplaceableGroup();
        return stateM82animateColorAsStateKTwxG1Y;
    }

    private DefaultCheckboxColors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20) {
        this.checkedCheckmarkColor = j10;
        this.uncheckedCheckmarkColor = j11;
        this.checkedBoxColor = j12;
        this.uncheckedBoxColor = j13;
        this.disabledCheckedBoxColor = j14;
        this.disabledUncheckedBoxColor = j15;
        this.disabledIndeterminateBoxColor = j16;
        this.checkedBorderColor = j17;
        this.uncheckedBorderColor = j18;
        this.disabledBorderColor = j19;
        this.disabledIndeterminateBorderColor = j20;
    }
}
