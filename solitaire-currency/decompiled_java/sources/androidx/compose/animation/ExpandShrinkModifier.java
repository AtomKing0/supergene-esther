package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
final class ExpandShrinkModifier extends LayoutModifierWithPassThroughIntrinsics {

    @NotNull
    private final State<Alignment> alignment;

    @Nullable
    private Alignment currentAlignment;

    @NotNull
    private final State<ChangeSize> expand;

    @NotNull
    private final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;

    @NotNull
    private final State<ChangeSize> shrink;

    @NotNull
    private final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;

    @NotNull
    private final l<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec;

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

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandShrinkModifier(@NotNull Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation, @NotNull Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation, @NotNull State<ChangeSize> expand, @NotNull State<ChangeSize> shrink, @NotNull State<? extends Alignment> alignment) {
        t.i(sizeAnimation, "sizeAnimation");
        t.i(offsetAnimation, "offsetAnimation");
        t.i(expand, "expand");
        t.i(shrink, "shrink");
        t.i(alignment, "alignment");
        this.sizeAnimation = sizeAnimation;
        this.offsetAnimation = offsetAnimation;
        this.expand = expand;
        this.shrink = shrink;
        this.alignment = alignment;
        this.sizeTransitionSpec = new ExpandShrinkModifier$sizeTransitionSpec$1(this);
    }

    @NotNull
    public final State<Alignment> getAlignment() {
        return this.alignment;
    }

    @Nullable
    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    @NotNull
    public final State<ChangeSize> getExpand() {
        return this.expand;
    }

    @NotNull
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    @NotNull
    public final State<ChangeSize> getShrink() {
        return this.shrink;
    }

    @NotNull
    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    @NotNull
    public final l<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
        t.i(measure, "$this$measure");
        t.i(measurable, "measurable");
        Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
        long jIntSize = IntSizeKt.IntSize(placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight());
        long jM3837unboximpl = this.sizeAnimation.animate(this.sizeTransitionSpec, new ExpandShrinkModifier$measure$currentSize$1(this, jIntSize)).getValue().m3837unboximpl();
        long jM3800unboximpl = this.offsetAnimation.animate(ExpandShrinkModifier$measure$offsetDelta$1.INSTANCE, new ExpandShrinkModifier$measure$offsetDelta$2(this, jIntSize)).getValue().m3800unboximpl();
        Alignment alignment = this.currentAlignment;
        return MeasureScope.CC.p(measure, IntSize.m3833getWidthimpl(jM3837unboximpl), IntSize.m3832getHeightimpl(jM3837unboximpl), null, new ExpandShrinkModifier$measure$1(placeableMo2987measureBRTryo0, alignment != null ? alignment.mo1275alignKFBX0sM(jIntSize, jM3837unboximpl, LayoutDirection.Ltr) : IntOffset.Companion.m3801getZeronOccac(), jM3800unboximpl), 4, null);
    }

    public final void setCurrentAlignment(@Nullable Alignment alignment) {
        this.currentAlignment = alignment;
    }

    /* JADX INFO: renamed from: sizeByState-Uzc_VyU, reason: not valid java name */
    public final long m73sizeByStateUzc_VyU(@NotNull EnterExitState targetState, long j10) {
        t.i(targetState, "targetState");
        ChangeSize value = this.expand.getValue();
        long jM3837unboximpl = value != null ? value.getSize().invoke(IntSize.m3825boximpl(j10)).m3837unboximpl() : j10;
        ChangeSize value2 = this.shrink.getValue();
        long jM3837unboximpl2 = value2 != null ? value2.getSize().invoke(IntSize.m3825boximpl(j10)).m3837unboximpl() : j10;
        int i10 = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i10 == 1) {
            return j10;
        }
        if (i10 == 2) {
            return jM3837unboximpl;
        }
        if (i10 == 3) {
            return jM3837unboximpl2;
        }
        throw new q();
    }

    /* JADX INFO: renamed from: targetOffsetByState-oFUgxo0, reason: not valid java name */
    public final long m74targetOffsetByStateoFUgxo0(@NotNull EnterExitState targetState, long j10) {
        t.i(targetState, "targetState");
        if (this.currentAlignment == null) {
            return IntOffset.Companion.m3801getZeronOccac();
        }
        if (this.alignment.getValue() == null) {
            return IntOffset.Companion.m3801getZeronOccac();
        }
        if (t.d(this.currentAlignment, this.alignment.getValue())) {
            return IntOffset.Companion.m3801getZeronOccac();
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i10 == 1) {
            return IntOffset.Companion.m3801getZeronOccac();
        }
        if (i10 == 2) {
            return IntOffset.Companion.m3801getZeronOccac();
        }
        if (i10 != 3) {
            throw new q();
        }
        ChangeSize value = this.shrink.getValue();
        if (value == null) {
            return IntOffset.Companion.m3801getZeronOccac();
        }
        long jM3837unboximpl = value.getSize().invoke(IntSize.m3825boximpl(j10)).m3837unboximpl();
        Alignment value2 = this.alignment.getValue();
        t.f(value2);
        Alignment alignment = value2;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        long jMo1275alignKFBX0sM = alignment.mo1275alignKFBX0sM(j10, jM3837unboximpl, layoutDirection);
        Alignment alignment2 = this.currentAlignment;
        t.f(alignment2);
        long jMo1275alignKFBX0sM2 = alignment2.mo1275alignKFBX0sM(j10, jM3837unboximpl, layoutDirection);
        return IntOffsetKt.IntOffset(IntOffset.m3791getXimpl(jMo1275alignKFBX0sM) - IntOffset.m3791getXimpl(jMo1275alignKFBX0sM2), IntOffset.m3792getYimpl(jMo1275alignKFBX0sM) - IntOffset.m3792getYimpl(jMo1275alignKFBX0sM2));
    }
}
