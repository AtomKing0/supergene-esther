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
final class DefaultChipColors implements ChipColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconContentColor;
    private final long leadingIconContentColor;

    public /* synthetic */ DefaultChipColors(long j10, long j11, long j12, long j13, long j14, long j15, k kVar) {
        this(j10, j11, j12, j13, j14, j15);
    }

    @Override // androidx.compose.material.ChipColors
    @Composable
    @NotNull
    public State<Color> backgroundColor(boolean z10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1593588247);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? this.backgroundColor : this.disabledBackgroundColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.ChipColors
    @Composable
    @NotNull
    public State<Color> contentColor(boolean z10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(483145880);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? this.contentColor : this.disabledContentColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(o0.b(DefaultChipColors.class), o0.b(obj.getClass()))) {
            return false;
        }
        DefaultChipColors defaultChipColors = (DefaultChipColors) obj;
        return Color.m1599equalsimpl0(this.backgroundColor, defaultChipColors.backgroundColor) && Color.m1599equalsimpl0(this.contentColor, defaultChipColors.contentColor) && Color.m1599equalsimpl0(this.leadingIconContentColor, defaultChipColors.leadingIconContentColor) && Color.m1599equalsimpl0(this.disabledBackgroundColor, defaultChipColors.disabledBackgroundColor) && Color.m1599equalsimpl0(this.disabledContentColor, defaultChipColors.disabledContentColor) && Color.m1599equalsimpl0(this.disabledLeadingIconContentColor, defaultChipColors.disabledLeadingIconContentColor);
    }

    public int hashCode() {
        return (((((((((Color.m1605hashCodeimpl(this.backgroundColor) * 31) + Color.m1605hashCodeimpl(this.contentColor)) * 31) + Color.m1605hashCodeimpl(this.leadingIconContentColor)) * 31) + Color.m1605hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m1605hashCodeimpl(this.disabledContentColor)) * 31) + Color.m1605hashCodeimpl(this.disabledLeadingIconContentColor);
    }

    @Override // androidx.compose.material.ChipColors
    @Composable
    @NotNull
    public State<Color> leadingIconContentColor(boolean z10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(1955749013);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? this.leadingIconContentColor : this.disabledLeadingIconContentColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    private DefaultChipColors(long j10, long j11, long j12, long j13, long j14, long j15) {
        this.backgroundColor = j10;
        this.contentColor = j11;
        this.leadingIconContentColor = j12;
        this.disabledBackgroundColor = j13;
        this.disabledContentColor = j14;
        this.disabledLeadingIconContentColor = j15;
    }
}
