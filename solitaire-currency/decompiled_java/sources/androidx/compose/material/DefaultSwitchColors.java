package androidx.compose.material;

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

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
final class DefaultSwitchColors implements SwitchColors {
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ DefaultSwitchColors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, k kVar) {
        this(j10, j11, j12, j13, j14, j15, j16, j17);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(o0.b(DefaultSwitchColors.class), o0.b(obj.getClass()))) {
            return false;
        }
        DefaultSwitchColors defaultSwitchColors = (DefaultSwitchColors) obj;
        return Color.m1599equalsimpl0(this.checkedThumbColor, defaultSwitchColors.checkedThumbColor) && Color.m1599equalsimpl0(this.checkedTrackColor, defaultSwitchColors.checkedTrackColor) && Color.m1599equalsimpl0(this.uncheckedThumbColor, defaultSwitchColors.uncheckedThumbColor) && Color.m1599equalsimpl0(this.uncheckedTrackColor, defaultSwitchColors.uncheckedTrackColor) && Color.m1599equalsimpl0(this.disabledCheckedThumbColor, defaultSwitchColors.disabledCheckedThumbColor) && Color.m1599equalsimpl0(this.disabledCheckedTrackColor, defaultSwitchColors.disabledCheckedTrackColor) && Color.m1599equalsimpl0(this.disabledUncheckedThumbColor, defaultSwitchColors.disabledUncheckedThumbColor) && Color.m1599equalsimpl0(this.disabledUncheckedTrackColor, defaultSwitchColors.disabledUncheckedTrackColor);
    }

    public int hashCode() {
        return (((((((((((((Color.m1605hashCodeimpl(this.checkedThumbColor) * 31) + Color.m1605hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m1605hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m1605hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m1605hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m1605hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m1605hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m1605hashCodeimpl(this.disabledUncheckedTrackColor);
    }

    @Override // androidx.compose.material.SwitchColors
    @Composable
    @NotNull
    public State<Color> thumbColor(boolean z10, boolean z11, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-66424183);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? z11 ? this.checkedThumbColor : this.uncheckedThumbColor : z11 ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.SwitchColors
    @Composable
    @NotNull
    public State<Color> trackColor(boolean z10, boolean z11, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1176343362);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? z11 ? this.checkedTrackColor : this.uncheckedTrackColor : z11 ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    private DefaultSwitchColors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
        this.checkedThumbColor = j10;
        this.checkedTrackColor = j11;
        this.uncheckedThumbColor = j12;
        this.uncheckedTrackColor = j13;
        this.disabledCheckedThumbColor = j14;
        this.disabledCheckedTrackColor = j15;
        this.disabledUncheckedThumbColor = j16;
        this.disabledUncheckedTrackColor = j17;
    }
}
