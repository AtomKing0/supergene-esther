package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class SlideModifier extends LayoutModifierWithPassThroughIntrinsics {

    @NotNull
    private final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> lazyAnimation;

    @NotNull
    private final State<Slide> slideIn;

    @NotNull
    private final State<Slide> slideOut;

    @NotNull
    private final l<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> transitionSpec;

    /* JADX INFO: compiled from: EnterExitTransition.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            iArr[EnterExitState.Visible.ordinal()] = 1;
            iArr[EnterExitState.PreEnter.ordinal()] = 2;
            iArr[EnterExitState.PostExit.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SlideModifier(@NotNull Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> lazyAnimation, @NotNull State<Slide> slideIn, @NotNull State<Slide> slideOut) {
        t.i(lazyAnimation, "lazyAnimation");
        t.i(slideIn, "slideIn");
        t.i(slideOut, "slideOut");
        this.lazyAnimation = lazyAnimation;
        this.slideIn = slideIn;
        this.slideOut = slideOut;
        this.transitionSpec = new SlideModifier$transitionSpec$1(this);
    }

    @NotNull
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getLazyAnimation() {
        return this.lazyAnimation;
    }

    @NotNull
    public final State<Slide> getSlideIn() {
        return this.slideIn;
    }

    @NotNull
    public final State<Slide> getSlideOut() {
        return this.slideOut;
    }

    @NotNull
    public final l<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>> getTransitionSpec() {
        return this.transitionSpec;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
        return MeasureScope.CC.p(measure, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new SlideModifier$measure$1(this, placeableMo2987measureBRTryo0, IntSizeKt.IntSize(placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight())), 4, null);
    }

    /* JADX INFO: renamed from: targetValueByState-oFUgxo0, reason: not valid java name */
    public final long m90targetValueByStateoFUgxo0(@NotNull EnterExitState targetState, long j10) {
        l<IntSize, IntOffset> slideOffset;
        l<IntSize, IntOffset> slideOffset2;
        t.i(targetState, "targetState");
        Slide value = this.slideIn.getValue();
        long jM3801getZeronOccac = (value == null || (slideOffset2 = value.getSlideOffset()) == null) ? IntOffset.Companion.m3801getZeronOccac() : slideOffset2.invoke(IntSize.m3825boximpl(j10)).m3800unboximpl();
        Slide value2 = this.slideOut.getValue();
        long jM3801getZeronOccac2 = (value2 == null || (slideOffset = value2.getSlideOffset()) == null) ? IntOffset.Companion.m3801getZeronOccac() : slideOffset.invoke(IntSize.m3825boximpl(j10)).m3800unboximpl();
        int i10 = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i10 == 1) {
            return IntOffset.Companion.m3801getZeronOccac();
        }
        if (i10 == 2) {
            return jM3801getZeronOccac;
        }
        if (i10 == 3) {
            return jM3801getZeronOccac2;
        }
        throw new q();
    }
}
