package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import h9.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SingleValueAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SingleValueAnimationKt {

    @NotNull
    private static final SpringSpec<Color> colorDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);

    @NotNull
    /* JADX INFO: renamed from: Animatable-8_81llA, reason: not valid java name */
    public static final Animatable<Color, AnimationVector4D> m81Animatable8_81llA(long j10) {
        return new Animatable<>(Color.m1588boximpl(j10), ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m1602getColorSpaceimpl(j10)), null, 4, null);
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: animateColorAsState-KTwxG1Y, reason: not valid java name */
    public static final State<Color> m82animateColorAsStateKTwxG1Y(long j10, @Nullable AnimationSpec<Color> animationSpec, @Nullable l<? super Color, k0> lVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-1942442407);
        if ((i11 & 2) != 0) {
            animationSpec = colorDefaultSpring;
        }
        AnimationSpec<Color> animationSpec2 = animationSpec;
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        l<? super Color, k0> lVar2 = lVar;
        ColorSpace colorSpaceM1602getColorSpaceimpl = Color.m1602getColorSpaceimpl(j10);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(colorSpaceM1602getColorSpaceimpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m1602getColorSpaceimpl(j10));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        State<Color> stateAnimateValueAsState = AnimateAsStateKt.animateValueAsState(Color.m1588boximpl(j10), (TwoWayConverter) objRememberedValue, animationSpec2, null, lVar2, composer, (i10 & 14) | 576 | ((i10 << 6) & 57344), 8);
        composer.endReplaceableGroup();
        return stateAnimateValueAsState;
    }
}
