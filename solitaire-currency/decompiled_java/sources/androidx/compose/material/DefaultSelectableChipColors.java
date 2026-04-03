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

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalMaterialApi
final class DefaultSelectableChipColors implements SelectableChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconColor;
    private final long leadingIconColor;
    private final long selectedBackgroundColor;
    private final long selectedContentColor;
    private final long selectedLeadingIconColor;

    public /* synthetic */ DefaultSelectableChipColors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, k kVar) {
        this(j10, j11, j12, j13, j14, j15, j16, j17, j18);
    }

    @Override // androidx.compose.material.SelectableChipColors
    @Composable
    @NotNull
    public State<Color> backgroundColor(boolean z10, boolean z11, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-403836585);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(!z10 ? this.disabledBackgroundColor : !z11 ? this.backgroundColor : this.selectedBackgroundColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.SelectableChipColors
    @Composable
    @NotNull
    public State<Color> contentColor(boolean z10, boolean z11, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(2025240134);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(!z10 ? this.disabledContentColor : !z11 ? this.contentColor : this.selectedContentColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(o0.b(DefaultSelectableChipColors.class), o0.b(obj.getClass()))) {
            return false;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = (DefaultSelectableChipColors) obj;
        return Color.m1599equalsimpl0(this.backgroundColor, defaultSelectableChipColors.backgroundColor) && Color.m1599equalsimpl0(this.contentColor, defaultSelectableChipColors.contentColor) && Color.m1599equalsimpl0(this.leadingIconColor, defaultSelectableChipColors.leadingIconColor) && Color.m1599equalsimpl0(this.disabledBackgroundColor, defaultSelectableChipColors.disabledBackgroundColor) && Color.m1599equalsimpl0(this.disabledContentColor, defaultSelectableChipColors.disabledContentColor) && Color.m1599equalsimpl0(this.disabledLeadingIconColor, defaultSelectableChipColors.disabledLeadingIconColor) && Color.m1599equalsimpl0(this.selectedBackgroundColor, defaultSelectableChipColors.selectedBackgroundColor) && Color.m1599equalsimpl0(this.selectedContentColor, defaultSelectableChipColors.selectedContentColor) && Color.m1599equalsimpl0(this.selectedLeadingIconColor, defaultSelectableChipColors.selectedLeadingIconColor);
    }

    public int hashCode() {
        return (((((((((((((((Color.m1605hashCodeimpl(this.backgroundColor) * 31) + Color.m1605hashCodeimpl(this.contentColor)) * 31) + Color.m1605hashCodeimpl(this.leadingIconColor)) * 31) + Color.m1605hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m1605hashCodeimpl(this.disabledContentColor)) * 31) + Color.m1605hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m1605hashCodeimpl(this.selectedBackgroundColor)) * 31) + Color.m1605hashCodeimpl(this.selectedContentColor)) * 31) + Color.m1605hashCodeimpl(this.selectedLeadingIconColor);
    }

    @Override // androidx.compose.material.SelectableChipColors
    @Composable
    @NotNull
    public State<Color> leadingIconColor(boolean z10, boolean z11, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(189838188);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(!z10 ? this.disabledLeadingIconColor : !z11 ? this.leadingIconColor : this.selectedLeadingIconColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    private DefaultSelectableChipColors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18) {
        this.backgroundColor = j10;
        this.contentColor = j11;
        this.leadingIconColor = j12;
        this.disabledBackgroundColor = j13;
        this.disabledContentColor = j14;
        this.disabledLeadingIconColor = j15;
        this.selectedBackgroundColor = j16;
        this.selectedContentColor = j17;
        this.selectedLeadingIconColor = j18;
    }
}
