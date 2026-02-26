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

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
final class DefaultButtonColors implements ButtonColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;

    public /* synthetic */ DefaultButtonColors(long j10, long j11, long j12, long j13, k kVar) {
        this(j10, j11, j12, j13);
    }

    @Override // androidx.compose.material.ButtonColors
    @Composable
    @NotNull
    public State<Color> backgroundColor(boolean z10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-655254499);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? this.backgroundColor : this.disabledBackgroundColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.ButtonColors
    @Composable
    @NotNull
    public State<Color> contentColor(boolean z10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-2133647540);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? this.contentColor : this.disabledContentColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(o0.b(DefaultButtonColors.class), o0.b(obj.getClass()))) {
            return false;
        }
        DefaultButtonColors defaultButtonColors = (DefaultButtonColors) obj;
        return Color.m1599equalsimpl0(this.backgroundColor, defaultButtonColors.backgroundColor) && Color.m1599equalsimpl0(this.contentColor, defaultButtonColors.contentColor) && Color.m1599equalsimpl0(this.disabledBackgroundColor, defaultButtonColors.disabledBackgroundColor) && Color.m1599equalsimpl0(this.disabledContentColor, defaultButtonColors.disabledContentColor);
    }

    public int hashCode() {
        return (((((Color.m1605hashCodeimpl(this.backgroundColor) * 31) + Color.m1605hashCodeimpl(this.contentColor)) * 31) + Color.m1605hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m1605hashCodeimpl(this.disabledContentColor);
    }

    private DefaultButtonColors(long j10, long j11, long j12, long j13) {
        this.backgroundColor = j10;
        this.contentColor = j11;
        this.disabledBackgroundColor = j12;
        this.disabledContentColor = j13;
    }
}
