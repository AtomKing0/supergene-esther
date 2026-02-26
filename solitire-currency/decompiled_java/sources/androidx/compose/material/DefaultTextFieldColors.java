package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
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

/* JADX INFO: compiled from: TextFieldDefaults.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
final class DefaultTextFieldColors implements TextFieldColors {
    private final long backgroundColor;
    private final long cursorColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorTrailingIconColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long leadingIconColor;
    private final long placeholderColor;
    private final long textColor;
    private final long trailingIconColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;

    public /* synthetic */ DefaultTextFieldColors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, k kVar) {
        this(j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30);
    }

    /* JADX INFO: renamed from: indicatorColor$lambda-0, reason: not valid java name */
    private static final boolean m986indicatorColor$lambda0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: renamed from: labelColor$lambda-1, reason: not valid java name */
    private static final boolean m987labelColor$lambda1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    @Override // androidx.compose.material.TextFieldColors
    @Composable
    @NotNull
    public State<Color> backgroundColor(boolean z10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1423938813);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(this.backgroundColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    @Composable
    @NotNull
    public State<Color> cursorColor(boolean z10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1446422485);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? this.errorCursorColor : this.cursorColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(o0.b(DefaultTextFieldColors.class), o0.b(obj.getClass()))) {
            return false;
        }
        DefaultTextFieldColors defaultTextFieldColors = (DefaultTextFieldColors) obj;
        return Color.m1599equalsimpl0(this.textColor, defaultTextFieldColors.textColor) && Color.m1599equalsimpl0(this.disabledTextColor, defaultTextFieldColors.disabledTextColor) && Color.m1599equalsimpl0(this.cursorColor, defaultTextFieldColors.cursorColor) && Color.m1599equalsimpl0(this.errorCursorColor, defaultTextFieldColors.errorCursorColor) && Color.m1599equalsimpl0(this.focusedIndicatorColor, defaultTextFieldColors.focusedIndicatorColor) && Color.m1599equalsimpl0(this.unfocusedIndicatorColor, defaultTextFieldColors.unfocusedIndicatorColor) && Color.m1599equalsimpl0(this.errorIndicatorColor, defaultTextFieldColors.errorIndicatorColor) && Color.m1599equalsimpl0(this.disabledIndicatorColor, defaultTextFieldColors.disabledIndicatorColor) && Color.m1599equalsimpl0(this.leadingIconColor, defaultTextFieldColors.leadingIconColor) && Color.m1599equalsimpl0(this.disabledLeadingIconColor, defaultTextFieldColors.disabledLeadingIconColor) && Color.m1599equalsimpl0(this.errorLeadingIconColor, defaultTextFieldColors.errorLeadingIconColor) && Color.m1599equalsimpl0(this.trailingIconColor, defaultTextFieldColors.trailingIconColor) && Color.m1599equalsimpl0(this.disabledTrailingIconColor, defaultTextFieldColors.disabledTrailingIconColor) && Color.m1599equalsimpl0(this.errorTrailingIconColor, defaultTextFieldColors.errorTrailingIconColor) && Color.m1599equalsimpl0(this.backgroundColor, defaultTextFieldColors.backgroundColor) && Color.m1599equalsimpl0(this.focusedLabelColor, defaultTextFieldColors.focusedLabelColor) && Color.m1599equalsimpl0(this.unfocusedLabelColor, defaultTextFieldColors.unfocusedLabelColor) && Color.m1599equalsimpl0(this.disabledLabelColor, defaultTextFieldColors.disabledLabelColor) && Color.m1599equalsimpl0(this.errorLabelColor, defaultTextFieldColors.errorLabelColor) && Color.m1599equalsimpl0(this.placeholderColor, defaultTextFieldColors.placeholderColor) && Color.m1599equalsimpl0(this.disabledPlaceholderColor, defaultTextFieldColors.disabledPlaceholderColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((Color.m1605hashCodeimpl(this.textColor) * 31) + Color.m1605hashCodeimpl(this.disabledTextColor)) * 31) + Color.m1605hashCodeimpl(this.cursorColor)) * 31) + Color.m1605hashCodeimpl(this.errorCursorColor)) * 31) + Color.m1605hashCodeimpl(this.focusedIndicatorColor)) * 31) + Color.m1605hashCodeimpl(this.unfocusedIndicatorColor)) * 31) + Color.m1605hashCodeimpl(this.errorIndicatorColor)) * 31) + Color.m1605hashCodeimpl(this.disabledIndicatorColor)) * 31) + Color.m1605hashCodeimpl(this.leadingIconColor)) * 31) + Color.m1605hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m1605hashCodeimpl(this.errorLeadingIconColor)) * 31) + Color.m1605hashCodeimpl(this.trailingIconColor)) * 31) + Color.m1605hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m1605hashCodeimpl(this.errorTrailingIconColor)) * 31) + Color.m1605hashCodeimpl(this.backgroundColor)) * 31) + Color.m1605hashCodeimpl(this.focusedLabelColor)) * 31) + Color.m1605hashCodeimpl(this.unfocusedLabelColor)) * 31) + Color.m1605hashCodeimpl(this.disabledLabelColor)) * 31) + Color.m1605hashCodeimpl(this.errorLabelColor)) * 31) + Color.m1605hashCodeimpl(this.placeholderColor)) * 31) + Color.m1605hashCodeimpl(this.disabledPlaceholderColor);
    }

    @Override // androidx.compose.material.TextFieldColors
    @Composable
    @NotNull
    public State<Color> indicatorColor(boolean z10, boolean z11, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10) {
        State<Color> stateRememberUpdatedState;
        t.i(interactionSource, "interactionSource");
        composer.startReplaceableGroup(998675979);
        long j10 = !z10 ? this.disabledIndicatorColor : z11 ? this.errorIndicatorColor : m986indicatorColor$lambda0(FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i10 >> 6) & 14)) ? this.focusedIndicatorColor : this.unfocusedIndicatorColor;
        if (z10) {
            composer.startReplaceableGroup(-2054190426);
            stateRememberUpdatedState = SingleValueAnimationKt.m82animateColorAsStateKTwxG1Y(j10, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, composer, 48, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-2054190321);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(j10), composer, 0);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    @Composable
    @NotNull
    public State<Color> labelColor(boolean z10, boolean z11, @NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10) {
        t.i(interactionSource, "interactionSource");
        composer.startReplaceableGroup(727091888);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(!z10 ? this.disabledLabelColor : z11 ? this.errorLabelColor : m987labelColor$lambda1(FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i10 >> 6) & 14)) ? this.focusedLabelColor : this.unfocusedLabelColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    @Composable
    @NotNull
    public State<Color> leadingIconColor(boolean z10, boolean z11, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(1016171324);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(!z10 ? this.disabledLeadingIconColor : z11 ? this.errorLeadingIconColor : this.leadingIconColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    @Composable
    @NotNull
    public State<Color> placeholderColor(boolean z10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(264799724);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? this.placeholderColor : this.disabledPlaceholderColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    @Composable
    @NotNull
    public State<Color> textColor(boolean z10, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(9804418);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(z10 ? this.textColor : this.disabledTextColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.TextFieldColors
    @Composable
    @NotNull
    public State<Color> trailingIconColor(boolean z10, boolean z11, @Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(225259054);
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(!z10 ? this.disabledTrailingIconColor : z11 ? this.errorTrailingIconColor : this.trailingIconColor), composer, 0);
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    private DefaultTextFieldColors(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30) {
        this.textColor = j10;
        this.disabledTextColor = j11;
        this.cursorColor = j12;
        this.errorCursorColor = j13;
        this.focusedIndicatorColor = j14;
        this.unfocusedIndicatorColor = j15;
        this.errorIndicatorColor = j16;
        this.disabledIndicatorColor = j17;
        this.leadingIconColor = j18;
        this.disabledLeadingIconColor = j19;
        this.errorLeadingIconColor = j20;
        this.trailingIconColor = j21;
        this.disabledTrailingIconColor = j22;
        this.errorTrailingIconColor = j23;
        this.backgroundColor = j24;
        this.focusedLabelColor = j25;
        this.unfocusedLabelColor = j26;
        this.disabledLabelColor = j27;
        this.errorLabelColor = j28;
        this.placeholderColor = j29;
        this.disabledPlaceholderColor = j30;
    }
}
