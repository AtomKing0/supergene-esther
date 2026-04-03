package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: EnterExitTransition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionKt {

    @NotNull
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(EnterExitTransitionKt$TransformOriginVectorConverter$1.INSTANCE, EnterExitTransitionKt$TransformOriginVectorConverter$2.INSTANCE);

    @NotNull
    private static final MutableState<Float> DefaultAlpha = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);

    @NotNull
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);

    @NotNull
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);

    @NotNull
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3825boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);

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

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$createModifier$1, reason: invalid class name */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class AnonymousClass1 extends v implements l<GraphicsLayerScope, k0> {
        final /* synthetic */ State<Float> $alpha$delegate;
        final /* synthetic */ State<Float> $scale$delegate;
        final /* synthetic */ State<TransformOrigin> $transformOrigin$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State<Float> state, State<Float> state2, State<TransformOrigin> state3) {
            super(1);
            this.$alpha$delegate = state;
            this.$scale$delegate = state2;
            this.$transformOrigin$delegate = state3;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(GraphicsLayerScope graphicsLayerScope) {
            invoke2(graphicsLayerScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull GraphicsLayerScope graphicsLayer) {
            t.i(graphicsLayer, "$this$graphicsLayer");
            graphicsLayer.setAlpha(EnterExitTransitionKt.m52createModifier$lambda8(this.$alpha$delegate));
            graphicsLayer.setScaleX(EnterExitTransitionKt.m47createModifier$lambda11(this.$scale$delegate));
            graphicsLayer.setScaleY(EnterExitTransitionKt.m47createModifier$lambda11(this.$scale$delegate));
            graphicsLayer.mo1743setTransformOrigin__ExYCQ(EnterExitTransitionKt.m48createModifier$lambda13(this.$transformOrigin$delegate));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$createModifier$2, reason: invalid class name */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class AnonymousClass2 extends v implements l<GraphicsLayerScope, k0> {
        final /* synthetic */ State<Float> $alpha$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(State<Float> state) {
            super(1);
            this.$alpha$delegate = state;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(GraphicsLayerScope graphicsLayerScope) {
            invoke2(graphicsLayerScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull GraphicsLayerScope graphicsLayer) {
            t.i(graphicsLayer, "$this$graphicsLayer");
            graphicsLayer.setAlpha(EnterExitTransitionKt.m52createModifier$lambda8(this.$alpha$delegate));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07841 extends v implements l<Integer, Integer> {
        public static final C07841 INSTANCE = new C07841();

        C07841() {
            super(1);
        }

        @NotNull
        public final Integer invoke(int i10) {
            return 0;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07852 extends v implements l<IntSize, IntSize> {
        final /* synthetic */ l<Integer, Integer> $initialWidth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07852(l<? super Integer, Integer> lVar) {
            super(1);
            this.$initialWidth = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
            return IntSize.m3825boximpl(m59invokemzRDjE0(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m59invokemzRDjE0(long j10) {
            return IntSizeKt.IntSize(this.$initialWidth.invoke(Integer.valueOf(IntSize.m3833getWidthimpl(j10))).intValue(), IntSize.m3832getHeightimpl(j10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$expandIn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07861 extends v implements l<IntSize, IntSize> {
        public static final C07861 INSTANCE = new C07861();

        C07861() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
            return IntSize.m3825boximpl(m60invokemzRDjE0(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m60invokemzRDjE0(long j10) {
            return IntSizeKt.IntSize(0, 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07871 extends v implements l<Integer, Integer> {
        public static final C07871 INSTANCE = new C07871();

        C07871() {
            super(1);
        }

        @NotNull
        public final Integer invoke(int i10) {
            return 0;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07882 extends v implements l<IntSize, IntSize> {
        final /* synthetic */ l<Integer, Integer> $initialHeight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07882(l<? super Integer, Integer> lVar) {
            super(1);
            this.$initialHeight = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
            return IntSize.m3825boximpl(m61invokemzRDjE0(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m61invokemzRDjE0(long j10) {
            return IntSizeKt.IntSize(IntSize.m3833getWidthimpl(j10), this.$initialHeight.invoke(Integer.valueOf(IntSize.m3832getHeightimpl(j10))).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07891 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ State<ChangeSize> $expand;
        final /* synthetic */ String $labelPrefix;
        final /* synthetic */ State<ChangeSize> $shrink;
        final /* synthetic */ Transition<EnterExitState> $transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07891(Transition<EnterExitState> transition, State<ChangeSize> state, State<ChangeSize> state2, String str) {
            super(3);
            this.$transition = transition;
            this.$expand = state;
            this.$shrink = state2;
            this.$labelPrefix = str;
        }

        /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
        private static final boolean m62invoke$lambda1(MutableState<Boolean> mutableState) {
            return mutableState.getValue().booleanValue();
        }

        /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
        private static final void m63invoke$lambda2(MutableState<Boolean> mutableState, boolean z10) {
            mutableState.setValue(Boolean.valueOf(z10));
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x016f  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0193  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0197  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01c3  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01df  */
        @androidx.compose.runtime.Composable
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23) {
            /*
                Method dump skipped, instruction units count: 495
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.C07891.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07901 extends v implements l<Integer, Integer> {
        public static final C07901 INSTANCE = new C07901();

        C07901() {
            super(1);
        }

        @NotNull
        public final Integer invoke(int i10) {
            return 0;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07912 extends v implements l<IntSize, IntSize> {
        final /* synthetic */ l<Integer, Integer> $targetWidth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07912(l<? super Integer, Integer> lVar) {
            super(1);
            this.$targetWidth = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
            return IntSize.m3825boximpl(m64invokemzRDjE0(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m64invokemzRDjE0(long j10) {
            return IntSizeKt.IntSize(this.$targetWidth.invoke(Integer.valueOf(IntSize.m3833getWidthimpl(j10))).intValue(), IntSize.m3832getHeightimpl(j10));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkOut$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07921 extends v implements l<IntSize, IntSize> {
        public static final C07921 INSTANCE = new C07921();

        C07921() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
            return IntSize.m3825boximpl(m65invokemzRDjE0(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m65invokemzRDjE0(long j10) {
            return IntSizeKt.IntSize(0, 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07931 extends v implements l<Integer, Integer> {
        public static final C07931 INSTANCE = new C07931();

        C07931() {
            super(1);
        }

        @NotNull
        public final Integer invoke(int i10) {
            return 0;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07942 extends v implements l<IntSize, IntSize> {
        final /* synthetic */ l<Integer, Integer> $targetHeight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07942(l<? super Integer, Integer> lVar) {
            super(1);
            this.$targetHeight = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
            return IntSize.m3825boximpl(m66invokemzRDjE0(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m66invokemzRDjE0(long j10) {
            return IntSizeKt.IntSize(IntSize.m3833getWidthimpl(j10), this.$targetHeight.invoke(Integer.valueOf(IntSize.m3832getHeightimpl(j10))).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07951 extends v implements l<Integer, Integer> {
        public static final C07951 INSTANCE = new C07951();

        C07951() {
            super(1);
        }

        @NotNull
        public final Integer invoke(int i10) {
            return Integer.valueOf((-i10) / 2);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07962 extends v implements l<IntSize, IntOffset> {
        final /* synthetic */ l<Integer, Integer> $initialOffsetX;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07962(l<? super Integer, Integer> lVar) {
            super(1);
            this.$initialOffsetX = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
            return IntOffset.m3782boximpl(m67invokemHKZG7I(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
        public final long m67invokemHKZG7I(long j10) {
            return IntOffsetKt.IntOffset(this.$initialOffsetX.invoke(Integer.valueOf(IntSize.m3833getWidthimpl(j10))).intValue(), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideInOut$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07971 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ String $labelPrefix;
        final /* synthetic */ State<Slide> $slideIn;
        final /* synthetic */ State<Slide> $slideOut;
        final /* synthetic */ Transition<EnterExitState> $transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07971(Transition<EnterExitState> transition, State<Slide> state, State<Slide> state2, String str) {
            super(3);
            this.$transition = transition;
            this.$slideIn = state;
            this.$slideOut = state2;
            this.$labelPrefix = str;
        }

        /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
        private static final boolean m68invoke$lambda1(MutableState<Boolean> mutableState) {
            return mutableState.getValue().booleanValue();
        }

        /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
        private static final void m69invoke$lambda2(MutableState<Boolean> mutableState, boolean z10) {
            mutableState.setValue(Boolean.valueOf(z10));
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(158379472);
            Transition<EnterExitState> transition = this.$transition;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(transition);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            if (this.$transition.getCurrentState() == this.$transition.getTargetState() && !this.$transition.isSeeking()) {
                m69invoke$lambda2(mutableState, false);
            } else if (this.$slideIn.getValue() != null || this.$slideOut.getValue() != null) {
                m69invoke$lambda2(mutableState, true);
            }
            if (m68invoke$lambda1(mutableState)) {
                Transition<EnterExitState> transition2 = this.$transition;
                TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
                String str = this.$labelPrefix;
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = str + " slide";
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition2, vectorConverter, (String) objRememberedValue2, composer, 448, 0);
                Transition<EnterExitState> transition3 = this.$transition;
                State<Slide> state = this.$slideIn;
                State<Slide> state2 = this.$slideOut;
                composer.startReplaceableGroup(1157296644);
                boolean zChanged2 = composer.changed(transition3);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new SlideModifier(deferredAnimationCreateDeferredAnimation, state, state2);
                    composer.updateRememberedValue(objRememberedValue3);
                }
                composer.endReplaceableGroup();
                composed = composed.then((SlideModifier) objRememberedValue3);
            }
            composer.endReplaceableGroup();
            return composed;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07981 extends v implements l<Integer, Integer> {
        public static final C07981 INSTANCE = new C07981();

        C07981() {
            super(1);
        }

        @NotNull
        public final Integer invoke(int i10) {
            return Integer.valueOf((-i10) / 2);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C07992 extends v implements l<IntSize, IntOffset> {
        final /* synthetic */ l<Integer, Integer> $initialOffsetY;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07992(l<? super Integer, Integer> lVar) {
            super(1);
            this.$initialOffsetY = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
            return IntOffset.m3782boximpl(m70invokemHKZG7I(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
        public final long m70invokemHKZG7I(long j10) {
            return IntOffsetKt.IntOffset(0, this.$initialOffsetY.invoke(Integer.valueOf(IntSize.m3832getHeightimpl(j10))).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C08001 extends v implements l<Integer, Integer> {
        public static final C08001 INSTANCE = new C08001();

        C08001() {
            super(1);
        }

        @NotNull
        public final Integer invoke(int i10) {
            return Integer.valueOf((-i10) / 2);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C08012 extends v implements l<IntSize, IntOffset> {
        final /* synthetic */ l<Integer, Integer> $targetOffsetX;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08012(l<? super Integer, Integer> lVar) {
            super(1);
            this.$targetOffsetX = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
            return IntOffset.m3782boximpl(m71invokemHKZG7I(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
        public final long m71invokemHKZG7I(long j10) {
            return IntOffsetKt.IntOffset(this.$targetOffsetX.invoke(Integer.valueOf(IntSize.m3833getWidthimpl(j10))).intValue(), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C08021 extends v implements l<Integer, Integer> {
        public static final C08021 INSTANCE = new C08021();

        C08021() {
            super(1);
        }

        @NotNull
        public final Integer invoke(int i10) {
            return Integer.valueOf((-i10) / 2);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EnterExitTransition.kt */
    static final class C08032 extends v implements l<IntSize, IntOffset> {
        final /* synthetic */ l<Integer, Integer> $targetOffsetY;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08032(l<? super Integer, Integer> lVar) {
            super(1);
            this.$targetOffsetY = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
            return IntOffset.m3782boximpl(m72invokemHKZG7I(intSize.m3837unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
        public final long m72invokemHKZG7I(long j10) {
            return IntOffsetKt.IntOffset(0, this.$targetOffsetY.invoke(Integer.valueOf(IntSize.m3832getHeightimpl(j10))).intValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02e5  */
    @androidx.compose.runtime.Composable
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.Modifier createModifier(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r24, @org.jetbrains.annotations.NotNull androidx.compose.animation.EnterTransition r25, @org.jetbrains.annotations.NotNull androidx.compose.animation.ExitTransition r26, @org.jetbrains.annotations.NotNull java.lang.String r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29) {
        /*
            Method dump skipped, instruction units count: 1224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createModifier(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    /* JADX INFO: renamed from: createModifier$lambda-1, reason: not valid java name */
    private static final boolean m46createModifier$lambda1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createModifier$lambda-11, reason: not valid java name */
    public static final float m47createModifier$lambda11(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createModifier$lambda-13, reason: not valid java name */
    public static final long m48createModifier$lambda13(State<TransformOrigin> state) {
        return state.getValue().m1922unboximpl();
    }

    /* JADX INFO: renamed from: createModifier$lambda-2, reason: not valid java name */
    private static final void m49createModifier$lambda2(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: renamed from: createModifier$lambda-4, reason: not valid java name */
    private static final boolean m50createModifier$lambda4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: renamed from: createModifier$lambda-5, reason: not valid java name */
    private static final void m51createModifier$lambda5(MutableState<Boolean> mutableState, boolean z10) {
        mutableState.setValue(Boolean.valueOf(z10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createModifier$lambda-8, reason: not valid java name */
    public static final float m52createModifier$lambda8(State<Float> state) {
        return state.getValue().floatValue();
    }

    @Stable
    @NotNull
    public static final EnterTransition expandHorizontally(@NotNull FiniteAnimationSpec<IntSize> animationSpec, @NotNull Alignment.Horizontal expandFrom, boolean z10, @NotNull l<? super Integer, Integer> initialWidth) {
        t.i(animationSpec, "animationSpec");
        t.i(expandFrom, "expandFrom");
        t.i(initialWidth, "initialWidth");
        return expandIn(animationSpec, toAlignment(expandFrom), z10, new C07852(initialWidth));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3825boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i10 & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            lVar = C07841.INSTANCE;
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z10, lVar);
    }

    @Stable
    @NotNull
    public static final EnterTransition expandIn(@NotNull FiniteAnimationSpec<IntSize> animationSpec, @NotNull Alignment expandFrom, boolean z10, @NotNull l<? super IntSize, IntSize> initialSize) {
        t.i(animationSpec, "animationSpec");
        t.i(expandFrom, "expandFrom");
        t.i(initialSize, "initialSize");
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(expandFrom, initialSize, animationSpec, z10), null, 11, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3825boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i10 & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            lVar = C07861.INSTANCE;
        }
        return expandIn(finiteAnimationSpec, alignment, z10, lVar);
    }

    @Stable
    @NotNull
    public static final EnterTransition expandVertically(@NotNull FiniteAnimationSpec<IntSize> animationSpec, @NotNull Alignment.Vertical expandFrom, boolean z10, @NotNull l<? super Integer, Integer> initialHeight) {
        t.i(animationSpec, "animationSpec");
        t.i(expandFrom, "expandFrom");
        t.i(initialHeight, "initialHeight");
        return expandIn(animationSpec, toAlignment(expandFrom), z10, new C07882(initialHeight));
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3825boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i10 & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            lVar = C07871.INSTANCE;
        }
        return expandVertically(finiteAnimationSpec, vertical, z10, lVar);
    }

    @Stable
    @NotNull
    public static final EnterTransition fadeIn(@NotNull FiniteAnimationSpec<Float> animationSpec, float f10) {
        t.i(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(f10, animationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f10);
    }

    @Stable
    @NotNull
    public static final ExitTransition fadeOut(@NotNull FiniteAnimationSpec<Float> animationSpec, float f10) {
        t.i(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(f10, animationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f10);
    }

    @Stable
    @ExperimentalAnimationApi
    @NotNull
    /* JADX INFO: renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m53scaleInL8ZKhE(@NotNull FiniteAnimationSpec<Float> animationSpec, float f10, long j10) {
        t.i(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(f10, j10, animationSpec, null), 7, null));
    }

    /* JADX INFO: renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m54scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f10, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            j10 = TransformOrigin.Companion.m1923getCenterSzJe1aQ();
        }
        return m53scaleInL8ZKhE(finiteAnimationSpec, f10, j10);
    }

    @Stable
    @ExperimentalAnimationApi
    @NotNull
    /* JADX INFO: renamed from: scaleOut-L8ZKh-E, reason: not valid java name */
    public static final ExitTransition m55scaleOutL8ZKhE(@NotNull FiniteAnimationSpec<Float> animationSpec, float f10, long j10) {
        t.i(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(f10, j10, animationSpec, null), 7, null));
    }

    /* JADX INFO: renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m56scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f10, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            j10 = TransformOrigin.Companion.m1923getCenterSzJe1aQ();
        }
        return m55scaleOutL8ZKhE(finiteAnimationSpec, f10, j10);
    }

    private static final Modifier shrinkExpand(Modifier modifier, Transition<EnterExitState> transition, State<ChangeSize> state, State<ChangeSize> state2, String str) {
        return ComposedModifierKt.composed$default(modifier, null, new C07891(transition, state, state2, str), 1, null);
    }

    @Stable
    @NotNull
    public static final ExitTransition shrinkHorizontally(@NotNull FiniteAnimationSpec<IntSize> animationSpec, @NotNull Alignment.Horizontal shrinkTowards, boolean z10, @NotNull l<? super Integer, Integer> targetWidth) {
        t.i(animationSpec, "animationSpec");
        t.i(shrinkTowards, "shrinkTowards");
        t.i(targetWidth, "targetWidth");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), z10, new C07912(targetWidth));
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3825boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i10 & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            lVar = C07901.INSTANCE;
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z10, lVar);
    }

    @Stable
    @NotNull
    public static final ExitTransition shrinkOut(@NotNull FiniteAnimationSpec<IntSize> animationSpec, @NotNull Alignment shrinkTowards, boolean z10, @NotNull l<? super IntSize, IntSize> targetSize) {
        t.i(animationSpec, "animationSpec");
        t.i(shrinkTowards, "shrinkTowards");
        t.i(targetSize, "targetSize");
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(shrinkTowards, targetSize, animationSpec, z10), null, 11, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3825boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i10 & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            lVar = C07921.INSTANCE;
        }
        return shrinkOut(finiteAnimationSpec, alignment, z10, lVar);
    }

    @Stable
    @NotNull
    public static final ExitTransition shrinkVertically(@NotNull FiniteAnimationSpec<IntSize> animationSpec, @NotNull Alignment.Vertical shrinkTowards, boolean z10, @NotNull l<? super Integer, Integer> targetHeight) {
        t.i(animationSpec, "animationSpec");
        t.i(shrinkTowards, "shrinkTowards");
        t.i(targetHeight, "targetHeight");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), z10, new C07942(targetHeight));
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m3825boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i10 & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            lVar = C07931.INSTANCE;
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z10, lVar);
    }

    @Stable
    @NotNull
    public static final EnterTransition slideIn(@NotNull FiniteAnimationSpec<IntOffset> animationSpec, @NotNull l<? super IntSize, IntOffset> initialOffset) {
        t.i(animationSpec, "animationSpec");
        t.i(initialOffset, "initialOffset");
        return new EnterTransitionImpl(new TransitionData(null, new Slide(initialOffset, animationSpec), null, null, 13, null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        return slideIn(finiteAnimationSpec, lVar);
    }

    @Stable
    @NotNull
    public static final EnterTransition slideInHorizontally(@NotNull FiniteAnimationSpec<IntOffset> animationSpec, @NotNull l<? super Integer, Integer> initialOffsetX) {
        t.i(animationSpec, "animationSpec");
        t.i(initialOffsetX, "initialOffsetX");
        return slideIn(animationSpec, new C07962(initialOffsetX));
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i10 & 2) != 0) {
            lVar = C07951.INSTANCE;
        }
        return slideInHorizontally(finiteAnimationSpec, lVar);
    }

    private static final Modifier slideInOut(Modifier modifier, Transition<EnterExitState> transition, State<Slide> state, State<Slide> state2, String str) {
        return ComposedModifierKt.composed$default(modifier, null, new C07971(transition, state, state2, str), 1, null);
    }

    @Stable
    @NotNull
    public static final EnterTransition slideInVertically(@NotNull FiniteAnimationSpec<IntOffset> animationSpec, @NotNull l<? super Integer, Integer> initialOffsetY) {
        t.i(animationSpec, "animationSpec");
        t.i(initialOffsetY, "initialOffsetY");
        return slideIn(animationSpec, new C07992(initialOffsetY));
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i10 & 2) != 0) {
            lVar = C07981.INSTANCE;
        }
        return slideInVertically(finiteAnimationSpec, lVar);
    }

    @Stable
    @NotNull
    public static final ExitTransition slideOut(@NotNull FiniteAnimationSpec<IntOffset> animationSpec, @NotNull l<? super IntSize, IntOffset> targetOffset) {
        t.i(animationSpec, "animationSpec");
        t.i(targetOffset, "targetOffset");
        return new ExitTransitionImpl(new TransitionData(null, new Slide(targetOffset, animationSpec), null, null, 13, null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        return slideOut(finiteAnimationSpec, lVar);
    }

    @Stable
    @NotNull
    public static final ExitTransition slideOutHorizontally(@NotNull FiniteAnimationSpec<IntOffset> animationSpec, @NotNull l<? super Integer, Integer> targetOffsetX) {
        t.i(animationSpec, "animationSpec");
        t.i(targetOffsetX, "targetOffsetX");
        return slideOut(animationSpec, new C08012(targetOffsetX));
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i10 & 2) != 0) {
            lVar = C08001.INSTANCE;
        }
        return slideOutHorizontally(finiteAnimationSpec, lVar);
    }

    @Stable
    @NotNull
    public static final ExitTransition slideOutVertically(@NotNull FiniteAnimationSpec<IntOffset> animationSpec, @NotNull l<? super Integer, Integer> targetOffsetY) {
        t.i(animationSpec, "animationSpec");
        t.i(targetOffsetY, "targetOffsetY");
        return slideOut(animationSpec, new C08032(targetOffsetY));
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m3782boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i10 & 2) != 0) {
            lVar = C08021.INSTANCE;
        }
        return slideOutVertically(finiteAnimationSpec, lVar);
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        Alignment.Companion companion = Alignment.Companion;
        return t.d(horizontal, companion.getStart()) ? companion.getCenterStart() : t.d(horizontal, companion.getEnd()) ? companion.getCenterEnd() : companion.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        Alignment.Companion companion = Alignment.Companion;
        return t.d(vertical, companion.getTop()) ? companion.getTopCenter() : t.d(vertical, companion.getBottom()) ? companion.getBottomCenter() : companion.getCenter();
    }
}
