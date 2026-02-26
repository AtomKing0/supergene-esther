package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.animation.core.e;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.b;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import h9.p;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimatedContent.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalAnimationApi
public final class AnimatedContentScope<S> implements Transition.Segment<S> {
    public static final int $stable = 8;

    @Nullable
    private State<IntSize> animatedSize;

    @NotNull
    private Alignment contentAlignment;

    @NotNull
    private LayoutDirection layoutDirection;

    @NotNull
    private final MutableState measuredSize$delegate;

    @NotNull
    private final Map<S, State<IntSize>> targetSizeMap;

    @NotNull
    private final Transition<S> transition;

    /* JADX INFO: compiled from: AnimatedContent.kt */
    public static final class ChildData implements ParentDataModifier {
        private boolean isTarget;

        public ChildData(boolean z10) {
            this.isTarget = z10;
        }

        public static /* synthetic */ ChildData copy$default(ChildData childData, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = childData.isTarget;
            }
            return childData.copy(z10);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean all(l lVar) {
            return b.a(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean any(l lVar) {
            return b.b(this, lVar);
        }

        public final boolean component1() {
            return this.isTarget;
        }

        @NotNull
        public final ChildData copy(boolean z10) {
            return new ChildData(z10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ChildData) && this.isTarget == ((ChildData) obj).isTarget;
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldIn(Object obj, p pVar) {
            return b.c(this, obj, pVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldOut(Object obj, p pVar) {
            return b.d(this, obj, pVar);
        }

        public int hashCode() {
            boolean z10 = this.isTarget;
            if (z10) {
                return 1;
            }
            return z10 ? 1 : 0;
        }

        public final boolean isTarget() {
            return this.isTarget;
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        @NotNull
        public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
            t.i(density, "<this>");
            return this;
        }

        public final void setTarget(boolean z10) {
            this.isTarget = z10;
        }

        @Override // androidx.compose.ui.Modifier
        public /* synthetic */ Modifier then(Modifier modifier) {
            return androidx.compose.ui.a.a(this, modifier);
        }

        @NotNull
        public String toString() {
            return "ChildData(isTarget=" + this.isTarget + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AnimatedContent.kt */
    @ExperimentalAnimationApi
    final class SizeModifier extends LayoutModifierWithPassThroughIntrinsics {

        @NotNull
        private final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;

        @NotNull
        private final State<SizeTransform> sizeTransform;
        final /* synthetic */ AnimatedContentScope<S> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public SizeModifier(@NotNull AnimatedContentScope animatedContentScope, @NotNull Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation, State<? extends SizeTransform> sizeTransform) {
            t.i(sizeAnimation, "sizeAnimation");
            t.i(sizeTransform, "sizeTransform");
            this.this$0 = animatedContentScope;
            this.sizeAnimation = sizeAnimation;
            this.sizeTransform = sizeTransform;
        }

        @NotNull
        public final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
            return this.sizeAnimation;
        }

        @NotNull
        public final State<SizeTransform> getSizeTransform() {
            return this.sizeTransform;
        }

        @Override // androidx.compose.ui.layout.LayoutModifier
        @NotNull
        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
        public MeasureResult mo23measure3p2s80s(@NotNull MeasureScope measure, @NotNull Measurable measurable, long j10) {
            t.i(measure, "$this$measure");
            t.i(measurable, "measurable");
            Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
            State<IntSize> stateAnimate = this.sizeAnimation.animate(new AnimatedContentScope$SizeModifier$measure$size$1(this.this$0, this), new AnimatedContentScope$SizeModifier$measure$size$2(this.this$0));
            this.this$0.setAnimatedSize$animation_release(stateAnimate);
            return MeasureScope.CC.p(measure, IntSize.m3833getWidthimpl(stateAnimate.getValue().m3837unboximpl()), IntSize.m3832getHeightimpl(stateAnimate.getValue().m3837unboximpl()), null, new AnimatedContentScope$SizeModifier$measure$1(placeableMo2987measureBRTryo0, this.this$0.getContentAlignment$animation_release().mo1275alignKFBX0sM(IntSizeKt.IntSize(placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight()), stateAnimate.getValue().m3837unboximpl(), LayoutDirection.Ltr)), 4, null);
        }
    }

    public AnimatedContentScope(@NotNull Transition<S> transition, @NotNull Alignment contentAlignment, @NotNull LayoutDirection layoutDirection) {
        t.i(transition, "transition");
        t.i(contentAlignment, "contentAlignment");
        t.i(layoutDirection, "layoutDirection");
        this.transition = transition;
        this.contentAlignment = contentAlignment;
        this.layoutDirection = layoutDirection;
        this.measuredSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m3825boximpl(IntSize.Companion.m3838getZeroYbymL2g()), null, 2, null);
        this.targetSizeMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateOffset-emnUabE, reason: not valid java name */
    public final long m11calculateOffsetemnUabE(long j10, long j11) {
        return this.contentAlignment.mo1275alignKFBX0sM(j10, j11, LayoutDirection.Ltr);
    }

    /* JADX INFO: renamed from: createSizeAnimationModifier$lambda-2, reason: not valid java name */
    private static final boolean m12createSizeAnimationModifier$lambda2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: renamed from: createSizeAnimationModifier$lambda-3, reason: not valid java name */
    private static final void m13createSizeAnimationModifier$lambda3(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getCurrentSize-YbymL2g, reason: not valid java name */
    public final long m14getCurrentSizeYbymL2g() {
        State<IntSize> state = this.animatedSize;
        return state != null ? state.getValue().m3837unboximpl() : m19getMeasuredSizeYbymL2g$animation_release();
    }

    /* JADX INFO: renamed from: isLeft-9jb1Dl8, reason: not valid java name */
    private final boolean m15isLeft9jb1Dl8(int i10) {
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.m28equalsimpl0(i10, companion.m34getLeftaUPqQNE()) || (SlideDirection.m28equalsimpl0(i10, companion.m36getStartaUPqQNE()) && this.layoutDirection == LayoutDirection.Ltr) || (SlideDirection.m28equalsimpl0(i10, companion.m33getEndaUPqQNE()) && this.layoutDirection == LayoutDirection.Rtl);
    }

    /* JADX INFO: renamed from: isRight-9jb1Dl8, reason: not valid java name */
    private final boolean m16isRight9jb1Dl8(int i10) {
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.m28equalsimpl0(i10, companion.m35getRightaUPqQNE()) || (SlideDirection.m28equalsimpl0(i10, companion.m36getStartaUPqQNE()) && this.layoutDirection == LayoutDirection.Rtl) || (SlideDirection.m28equalsimpl0(i10, companion.m33getEndaUPqQNE()) && this.layoutDirection == LayoutDirection.Ltr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: slideIntoContainer-HTTW7Ok$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m17slideIntoContainerHTTW7Ok$default(AnimatedContentScope animatedContentScope, int i10, FiniteAnimationSpec finiteAnimationSpec, l lVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m3782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
        }
        if ((i11 & 4) != 0) {
            lVar = AnimatedContentScope$slideIntoContainer$1.INSTANCE;
        }
        return animatedContentScope.m21slideIntoContainerHTTW7Ok(i10, finiteAnimationSpec, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: slideOutOfContainer-HTTW7Ok$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m18slideOutOfContainerHTTW7Ok$default(AnimatedContentScope animatedContentScope, int i10, FiniteAnimationSpec finiteAnimationSpec, l lVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m3782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
        }
        if ((i11 & 4) != 0) {
            lVar = AnimatedContentScope$slideOutOfContainer$1.INSTANCE;
        }
        return animatedContentScope.m22slideOutOfContainerHTTW7Ok(i10, finiteAnimationSpec, lVar);
    }

    @Composable
    @NotNull
    public final Modifier createSizeAnimationModifier$animation_release(@NotNull ContentTransform contentTransform, @Nullable Composer composer, int i10) {
        Modifier modifier;
        t.i(contentTransform, "contentTransform");
        composer.startReplaceableGroup(-1349251863);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(this);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        boolean z10 = false;
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(contentTransform.getSizeTransform(), composer, 0);
        if (t.d(this.transition.getCurrentState(), this.transition.getTargetState())) {
            m13createSizeAnimationModifier$lambda3(mutableState, false);
        } else if (stateRememberUpdatedState.getValue() != null) {
            m13createSizeAnimationModifier$lambda3(mutableState, true);
        }
        if (m12createSizeAnimationModifier$lambda2(mutableState)) {
            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(this.transition, VectorConvertersKt.getVectorConverter(IntSize.Companion), null, composer, 64, 2);
            composer.startReplaceableGroup(1157296644);
            boolean zChanged2 = composer.changed(deferredAnimationCreateDeferredAnimation);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                SizeTransform sizeTransform = (SizeTransform) stateRememberUpdatedState.getValue();
                if (sizeTransform != null && !sizeTransform.getClip()) {
                    z10 = true;
                }
                Modifier modifierClipToBounds = Modifier.Companion;
                if (!z10) {
                    modifierClipToBounds = ClipKt.clipToBounds(modifierClipToBounds);
                }
                objRememberedValue2 = modifierClipToBounds.then(new SizeModifier(this, deferredAnimationCreateDeferredAnimation, stateRememberUpdatedState));
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            modifier = (Modifier) objRememberedValue2;
        } else {
            this.animatedSize = null;
            modifier = Modifier.Companion;
        }
        composer.endReplaceableGroup();
        return modifier;
    }

    @Nullable
    public final State<IntSize> getAnimatedSize$animation_release() {
        return this.animatedSize;
    }

    @NotNull
    public final Alignment getContentAlignment$animation_release() {
        return this.contentAlignment;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public S getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    @NotNull
    public final LayoutDirection getLayoutDirection$animation_release() {
        return this.layoutDirection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getMeasuredSize-YbymL2g$animation_release, reason: not valid java name */
    public final long m19getMeasuredSizeYbymL2g$animation_release() {
        return ((IntSize) this.measuredSize$delegate.getValue()).m3837unboximpl();
    }

    @NotNull
    public final Map<S, State<IntSize>> getTargetSizeMap$animation_release() {
        return this.targetSizeMap;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public S getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    @NotNull
    public final Transition<S> getTransition$animation_release() {
        return this.transition;
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public /* synthetic */ boolean isTransitioningTo(Object obj, Object obj2) {
        return e.a(this, obj, obj2);
    }

    public final void setAnimatedSize$animation_release(@Nullable State<IntSize> state) {
        this.animatedSize = state;
    }

    public final void setContentAlignment$animation_release(@NotNull Alignment alignment) {
        t.i(alignment, "<set-?>");
        this.contentAlignment = alignment;
    }

    public final void setLayoutDirection$animation_release(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    /* JADX INFO: renamed from: setMeasuredSize-ozmzZPI$animation_release, reason: not valid java name */
    public final void m20setMeasuredSizeozmzZPI$animation_release(long j10) {
        this.measuredSize$delegate.setValue(IntSize.m3825boximpl(j10));
    }

    @NotNull
    /* JADX INFO: renamed from: slideIntoContainer-HTTW7Ok, reason: not valid java name */
    public final EnterTransition m21slideIntoContainerHTTW7Ok(int i10, @NotNull FiniteAnimationSpec<IntOffset> animationSpec, @NotNull l<? super Integer, Integer> initialOffset) {
        t.i(animationSpec, "animationSpec");
        t.i(initialOffset, "initialOffset");
        if (m15isLeft9jb1Dl8(i10)) {
            return EnterExitTransitionKt.slideInHorizontally(animationSpec, new AnimatedContentScope$slideIntoContainer$2(initialOffset, this));
        }
        if (m16isRight9jb1Dl8(i10)) {
            return EnterExitTransitionKt.slideInHorizontally(animationSpec, new AnimatedContentScope$slideIntoContainer$3(initialOffset, this));
        }
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.m28equalsimpl0(i10, companion.m37getUpaUPqQNE()) ? EnterExitTransitionKt.slideInVertically(animationSpec, new AnimatedContentScope$slideIntoContainer$4(initialOffset, this)) : SlideDirection.m28equalsimpl0(i10, companion.m32getDownaUPqQNE()) ? EnterExitTransitionKt.slideInVertically(animationSpec, new AnimatedContentScope$slideIntoContainer$5(initialOffset, this)) : EnterTransition.Companion.getNone();
    }

    @NotNull
    /* JADX INFO: renamed from: slideOutOfContainer-HTTW7Ok, reason: not valid java name */
    public final ExitTransition m22slideOutOfContainerHTTW7Ok(int i10, @NotNull FiniteAnimationSpec<IntOffset> animationSpec, @NotNull l<? super Integer, Integer> targetOffset) {
        t.i(animationSpec, "animationSpec");
        t.i(targetOffset, "targetOffset");
        if (m15isLeft9jb1Dl8(i10)) {
            return EnterExitTransitionKt.slideOutHorizontally(animationSpec, new AnimatedContentScope$slideOutOfContainer$2(this, targetOffset));
        }
        if (m16isRight9jb1Dl8(i10)) {
            return EnterExitTransitionKt.slideOutHorizontally(animationSpec, new AnimatedContentScope$slideOutOfContainer$3(this, targetOffset));
        }
        SlideDirection.Companion companion = SlideDirection.Companion;
        return SlideDirection.m28equalsimpl0(i10, companion.m37getUpaUPqQNE()) ? EnterExitTransitionKt.slideOutVertically(animationSpec, new AnimatedContentScope$slideOutOfContainer$4(this, targetOffset)) : SlideDirection.m28equalsimpl0(i10, companion.m32getDownaUPqQNE()) ? EnterExitTransitionKt.slideOutVertically(animationSpec, new AnimatedContentScope$slideOutOfContainer$5(this, targetOffset)) : ExitTransition.Companion.getNone();
    }

    @ExperimentalAnimationApi
    @NotNull
    public final ContentTransform using(@NotNull ContentTransform contentTransform, @Nullable SizeTransform sizeTransform) {
        t.i(contentTransform, "<this>");
        contentTransform.setSizeTransform$animation_release(sizeTransform);
        return contentTransform;
    }

    /* JADX INFO: compiled from: AnimatedContent.kt */
    @Immutable
    public static final class SlideDirection {
        private final int value;

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int Left = m26constructorimpl(0);
        private static final int Right = m26constructorimpl(1);
        private static final int Up = m26constructorimpl(2);
        private static final int Down = m26constructorimpl(3);
        private static final int Start = m26constructorimpl(4);
        private static final int End = m26constructorimpl(5);

        /* JADX INFO: compiled from: AnimatedContent.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            /* JADX INFO: renamed from: getDown-aUPqQNE, reason: not valid java name */
            public final int m32getDownaUPqQNE() {
                return SlideDirection.Down;
            }

            /* JADX INFO: renamed from: getEnd-aUPqQNE, reason: not valid java name */
            public final int m33getEndaUPqQNE() {
                return SlideDirection.End;
            }

            /* JADX INFO: renamed from: getLeft-aUPqQNE, reason: not valid java name */
            public final int m34getLeftaUPqQNE() {
                return SlideDirection.Left;
            }

            /* JADX INFO: renamed from: getRight-aUPqQNE, reason: not valid java name */
            public final int m35getRightaUPqQNE() {
                return SlideDirection.Right;
            }

            /* JADX INFO: renamed from: getStart-aUPqQNE, reason: not valid java name */
            public final int m36getStartaUPqQNE() {
                return SlideDirection.Start;
            }

            /* JADX INFO: renamed from: getUp-aUPqQNE, reason: not valid java name */
            public final int m37getUpaUPqQNE() {
                return SlideDirection.Up;
            }
        }

        private /* synthetic */ SlideDirection(int i10) {
            this.value = i10;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ SlideDirection m25boximpl(int i10) {
            return new SlideDirection(i10);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m27equalsimpl(int i10, Object obj) {
            return (obj instanceof SlideDirection) && i10 == ((SlideDirection) obj).m31unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m28equalsimpl0(int i10, int i11) {
            return i10 == i11;
        }

        @NotNull
        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m30toStringimpl(int i10) {
            return m28equalsimpl0(i10, Left) ? "Left" : m28equalsimpl0(i10, Right) ? "Right" : m28equalsimpl0(i10, Up) ? "Up" : m28equalsimpl0(i10, Down) ? "Down" : m28equalsimpl0(i10, Start) ? "Start" : m28equalsimpl0(i10, End) ? "End" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m27equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m29hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m30toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m31unboximpl() {
            return this.value;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m26constructorimpl(int i10) {
            return i10;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m29hashCodeimpl(int i10) {
            return i10;
        }
    }
}
