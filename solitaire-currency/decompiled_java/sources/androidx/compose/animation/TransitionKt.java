package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt {

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: androidx.compose.animation.TransitionKt$animateColor$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class AnonymousClass1<S> extends v implements q<Transition.Segment<S>, Composer, Integer, SpringSpec<Color>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Composable
        @NotNull
        public final SpringSpec<Color> invoke(@NotNull Transition.Segment<S> segment, @Nullable Composer composer, int i10) {
            t.i(segment, "$this$null");
            composer.startReplaceableGroup(-1457805428);
            SpringSpec<Color> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ SpringSpec<Color> invoke(Object obj, Composer composer, Integer num) {
            return invoke((Transition.Segment) obj, composer, num.intValue());
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    @NotNull
    public static final <S> State<Color> animateColor(@NotNull Transition<S> transition, @Nullable q<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Color>> qVar, @Nullable String str, @NotNull q<? super S, ? super Composer, ? super Integer, Color> targetValueByState, @Nullable Composer composer, int i10, int i11) {
        t.i(transition, "<this>");
        t.i(targetValueByState, "targetValueByState");
        composer.startReplaceableGroup(-1939694975);
        if ((i11 & 1) != 0) {
            qVar = AnonymousClass1.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            str = "ColorAnimation";
        }
        String str2 = str;
        ColorSpace colorSpaceM1602getColorSpaceimpl = Color.m1602getColorSpaceimpl(targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf((i10 >> 6) & 112)).m1608unboximpl());
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(colorSpaceM1602getColorSpaceimpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM1602getColorSpaceimpl);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
        int i12 = (i10 & 14) | 64;
        int i13 = i10 << 3;
        int i14 = i12 | (i13 & 896) | (i13 & 7168) | (i13 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i15 = (i14 >> 9) & 112;
        State<Color> stateCreateTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, targetValueByState.invoke(transition.getCurrentState(), composer, Integer.valueOf(i15)), targetValueByState.invoke(transition.getTargetState(), composer, Integer.valueOf(i15)), qVar.invoke(transition.getSegment(), composer, Integer.valueOf((i14 >> 3) & 112)), twoWayConverter, str2, composer, (i14 & 14) | ((i14 << 9) & 57344) | ((i14 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: animateColor-RIQooxk, reason: not valid java name */
    public static final State<Color> m92animateColorRIQooxk(@NotNull InfiniteTransition animateColor, long j10, long j11, @NotNull InfiniteRepeatableSpec<Color> animationSpec, @Nullable Composer composer, int i10) {
        t.i(animateColor, "$this$animateColor");
        t.i(animationSpec, "animationSpec");
        composer.startReplaceableGroup(1400583834);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m1602getColorSpaceimpl(j11));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        State<Color> stateAnimateValue = InfiniteTransitionKt.animateValue(animateColor, Color.m1588boximpl(j10), Color.m1588boximpl(j11), (TwoWayConverter) objRememberedValue, animationSpec, composer, InfiniteTransition.$stable | 4096 | (i10 & 14) | (i10 & 112) | (i10 & 896) | (InfiniteRepeatableSpec.$stable << 12) | ((i10 << 3) & 57344));
        composer.endReplaceableGroup();
        return stateAnimateValue;
    }
}
