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

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
final class DefaultSliderColors implements SliderColors {
    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;

    public /* synthetic */ DefaultSliderColors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, k kVar) {
        this(j10, j11, j12, j13, j14, j15, j16, j17, j18, j19);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(o0.b(DefaultSliderColors.class), o0.b(obj.getClass()))) {
            return false;
        }
        DefaultSliderColors defaultSliderColors = (DefaultSliderColors) obj;
        return Color.m1599equalsimpl0(this.thumbColor, defaultSliderColors.thumbColor) && Color.m1599equalsimpl0(this.disabledThumbColor, defaultSliderColors.disabledThumbColor) && Color.m1599equalsimpl0(this.activeTrackColor, defaultSliderColors.activeTrackColor) && Color.m1599equalsimpl0(this.inactiveTrackColor, defaultSliderColors.inactiveTrackColor) && Color.m1599equalsimpl0(this.disabledActiveTrackColor, defaultSliderColors.disabledActiveTrackColor) && Color.m1599equalsimpl0(this.disabledInactiveTrackColor, defaultSliderColors.disabledInactiveTrackColor) && Color.m1599equalsimpl0(this.activeTickColor, defaultSliderColors.activeTickColor) && Color.m1599equalsimpl0(this.inactiveTickColor, defaultSliderColors.inactiveTickColor) && Color.m1599equalsimpl0(this.disabledActiveTickColor, defaultSliderColors.disabledActiveTickColor) && Color.m1599equalsimpl0(this.disabledInactiveTickColor, defaultSliderColors.disabledInactiveTickColor);
    }

    public int hashCode() {
        return (((((((((((((((((Color.m1605hashCodeimpl(this.thumbColor) * 31) + Color.m1605hashCodeimpl(this.disabledThumbColor)) * 31) + Color.m1605hashCodeimpl(this.activeTrackColor)) * 31) + Color.m1605hashCodeimpl(this.inactiveTrackColor)) * 31) + Color.m1605hashCodeimpl(this.disabledActiveTrackColor)) * 31) + Color.m1605hashCodeimpl(this.disabledInactiveTrackColor)) * 31) + Color.m1605hashCodeimpl(this.activeTickColor)) * 31) + Color.m1605hashCodeimpl(this.inactiveTickColor)) * 31) + Color.m1605hashCodeimpl(this.disabledActiveTickColor)) * 31) + Color.m1605hashCodeimpl(this.disabledInactiveTickColor);
    }

    @Override // androidx.compose.material.SliderColors
    @Composable
    @NotNull
    public State<Color> thumbColor(boolean z10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1733795637);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? this.thumbColor : this.disabledThumbColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.SliderColors
    @Composable
    @NotNull
    public State<Color> tickColor(boolean z10, boolean z11, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1491563694);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? z11 ? this.activeTickColor : this.inactiveTickColor : z11 ? this.disabledActiveTickColor : this.disabledInactiveTickColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.SliderColors
    @Composable
    @NotNull
    public State<Color> trackColor(boolean z10, boolean z11, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(1575395620);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? z11 ? this.activeTrackColor : this.inactiveTrackColor : z11 ? this.disabledActiveTrackColor : this.disabledInactiveTrackColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    private DefaultSliderColors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19) {
        this.thumbColor = j10;
        this.disabledThumbColor = j11;
        this.activeTrackColor = j12;
        this.inactiveTrackColor = j13;
        this.disabledActiveTrackColor = j14;
        this.disabledInactiveTrackColor = j15;
        this.activeTickColor = j16;
        this.inactiveTickColor = j17;
        this.disabledActiveTickColor = j18;
        this.disabledInactiveTickColor = j19;
    }
}
