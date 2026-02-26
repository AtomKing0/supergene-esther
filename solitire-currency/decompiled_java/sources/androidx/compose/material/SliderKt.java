package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Strings;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.b;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.w;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import n9.e;
import n9.n;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;
import z8.h;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SliderKt {

    @NotNull
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;

    @NotNull
    private static final TweenSpec<Float> SliderToTickAnimation;
    private static final float ThumbRadius = Dp.m3673constructorimpl(10);
    private static final float ThumbRippleRadius = Dp.m3673constructorimpl(24);
    private static final float ThumbDefaultElevation = Dp.m3673constructorimpl(1);
    private static final float ThumbPressedElevation = Dp.m3673constructorimpl(6);
    private static final float TrackHeight = Dp.m3673constructorimpl(4);

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$CorrectValueSideEffect$2, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ l<Float, Float> $scaleToOffset;
        final /* synthetic */ e<Float> $trackRange;
        final /* synthetic */ float $value;
        final /* synthetic */ e<Float> $valueRange;
        final /* synthetic */ MutableState<Float> $valueState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(l<? super Float, Float> lVar, e<Float> eVar, e<Float> eVar2, MutableState<Float> mutableState, float f10, int i10) {
            super(2);
            this.$scaleToOffset = lVar;
            this.$valueRange = eVar;
            this.$trackRange = eVar2;
            this.$valueState = mutableState;
            this.$value = f10;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SliderKt.CorrectValueSideEffect(this.$scaleToOffset, this.$valueRange, this.$trackRange, this.$valueState, this.$value, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    static final class C09312 extends v implements q<BoxWithConstraintsScope, Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ a<k0> $onValueChangeFinished;
        final /* synthetic */ State<l<e<Float>, k0>> $onValueChangeState;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ int $steps;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ e<Float> $valueRange;
        final /* synthetic */ e<Float> $values;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Slider.kt */
        /* synthetic */ class C01032 extends kotlin.jvm.internal.q implements l<Float, Float> {
            final /* synthetic */ kotlin.jvm.internal.k0 $maxPx;
            final /* synthetic */ kotlin.jvm.internal.k0 $minPx;
            final /* synthetic */ e<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01032(e<Float> eVar, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2) {
                super(1, t.a.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = eVar;
                this.$minPx = k0Var;
                this.$maxPx = k0Var2;
            }

            @NotNull
            public final Float invoke(float f10) {
                return Float.valueOf(C09312.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f10));
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ Float invoke(Float f10) {
                return invoke(f10.floatValue());
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Slider.kt */
        /* synthetic */ class AnonymousClass3 extends kotlin.jvm.internal.q implements l<Float, Float> {
            final /* synthetic */ kotlin.jvm.internal.k0 $maxPx;
            final /* synthetic */ kotlin.jvm.internal.k0 $minPx;
            final /* synthetic */ e<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(e<Float> eVar, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2) {
                super(1, t.a.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = eVar;
                this.$minPx = k0Var;
                this.$maxPx = k0Var2;
            }

            @NotNull
            public final Float invoke(float f10) {
                return Float.valueOf(C09312.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f10));
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ Float invoke(Float f10) {
                return invoke(f10.floatValue());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09312(e<Float> eVar, e<Float> eVar2, int i10, State<? extends l<? super e<Float>, k0>> state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z10, List<Float> list, int i11, SliderColors sliderColors, a<k0> aVar) {
            super(3);
            this.$valueRange = eVar;
            this.$values = eVar2;
            this.$$dirty = i10;
            this.$onValueChangeState = state;
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$enabled = z10;
            this.$tickFractions = list;
            this.$steps = i11;
            this.$colors = sliderColors;
            this.$onValueChangeFinished = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToOffset(e<Float> eVar, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, float f10) {
            return SliderKt.scale(eVar.getStart().floatValue(), eVar.getEndInclusive().floatValue(), f10, k0Var.f29829a, k0Var2.f29829a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final e<Float> invoke$scaleToUserValue(kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, e<Float> eVar, e<Float> eVar2) {
            return SliderKt.scale(k0Var.f29829a, k0Var2.f29829a, eVar2, eVar.getStart().floatValue(), eVar.getEndInclusive().floatValue());
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
            invoke(boxWithConstraintsScope, composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer, int i10) {
            t.i(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((((i10 & 14) == 0 ? i10 | (composer.changed(BoxWithConstraints) ? 4 : 2) : i10) & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            boolean z10 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            float fM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(BoxWithConstraints.mo371getConstraintsmsEJaDk());
            kotlin.jvm.internal.k0 k0Var = new kotlin.jvm.internal.k0();
            kotlin.jvm.internal.k0 k0Var2 = new kotlin.jvm.internal.k0();
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            k0Var.f29829a = fM3641getMaxWidthimpl - density.mo296toPx0680j_4(SliderKt.getThumbRadius());
            k0Var2.f29829a = density.mo296toPx0680j_4(SliderKt.getThumbRadius());
            k0 k0Var3 = k0.f35197a;
            e<Float> eVar = this.$values;
            e<Float> eVar2 = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(eVar2, k0Var2, k0Var, eVar.getStart().floatValue())), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            e<Float> eVar3 = this.$values;
            e<Float> eVar4 = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(eVar4, k0Var2, k0Var, eVar3.getEndInclusive().floatValue())), null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            SliderKt.CorrectValueSideEffect(new C01032(this.$valueRange, k0Var2, k0Var), this.$valueRange, n.b(k0Var2.f29829a, k0Var.f29829a), mutableState, this.$values.getStart().floatValue(), composer, ((this.$$dirty >> 9) & 112) | 3072);
            SliderKt.CorrectValueSideEffect(new AnonymousClass3(this.$valueRange, k0Var2, k0Var), this.$valueRange, n.b(k0Var2.f29829a, k0Var.f29829a), mutableState2, this.$values.getEndInclusive().floatValue(), composer, ((this.$$dirty >> 9) & 112) | 3072);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(h.f37608a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue3 = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue3).getCoroutineScope();
            composer.endReplaceableGroup();
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new SliderKt$RangeSlider$2$gestureEndAction$1(mutableState, mutableState2, this.$tickFractions, k0Var2, k0Var, this.$onValueChangeFinished, coroutineScope, this.$onValueChangeState, this.$valueRange), composer, 0);
            e<Float> eVar5 = this.$values;
            State<l<e<Float>, k0>> state = this.$onValueChangeState;
            Object[] objArr = {mutableState, mutableState2, this.$valueRange, Float.valueOf(k0Var2.f29829a), Float.valueOf(k0Var.f29829a), eVar5, state};
            e<Float> eVar6 = this.$valueRange;
            composer.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i11 = 0; i11 < 7; i11++) {
                zChanged |= composer.changed(objArr[i11]);
            }
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new SliderKt$RangeSlider$2$onDrag$1$1(mutableState, mutableState2, eVar5, k0Var2, k0Var, state, eVar6);
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(objRememberedValue4, composer, 0);
            Modifier.Companion companion2 = Modifier.Companion;
            Modifier modifierRangeSliderPressDragModifier = SliderKt.rangeSliderPressDragModifier(companion2, this.$startInteractionSource, this.$endInteractionSource, mutableState, mutableState2, this.$enabled, z10, fM3641getMaxWidthimpl, this.$valueRange, stateRememberUpdatedState, stateRememberUpdatedState2);
            float fM = o.m(this.$values.getStart().floatValue(), this.$valueRange.getStart().floatValue(), this.$values.getEndInclusive().floatValue());
            float fM2 = o.m(this.$values.getEndInclusive().floatValue(), this.$values.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
            float fCalcFraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), fM);
            float fCalcFraction2 = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), fM2);
            List<Float> list = this.$tickFractions;
            boolean z11 = this.$enabled;
            Object obj = this.$onValueChangeState;
            Object objValueOf = Float.valueOf(fM2);
            State<l<e<Float>, k0>> state2 = this.$onValueChangeState;
            composer.startReplaceableGroup(511388516);
            boolean zChanged2 = composer.changed(obj) | composer.changed(objValueOf);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new SliderKt$RangeSlider$2$startThumbSemantics$1$1(state2, fM2);
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            Modifier modifierSliderSemantics = SliderKt.sliderSemantics(companion2, fM, list, z11, (l) objRememberedValue5, n.b(this.$valueRange.getStart().floatValue(), fM2), this.$steps);
            List<Float> list2 = this.$tickFractions;
            boolean z12 = this.$enabled;
            Object obj2 = this.$onValueChangeState;
            Object objValueOf2 = Float.valueOf(fM);
            State<l<e<Float>, k0>> state3 = this.$onValueChangeState;
            composer.startReplaceableGroup(511388516);
            boolean zChanged3 = composer.changed(obj2) | composer.changed(objValueOf2);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                objRememberedValue6 = new SliderKt$RangeSlider$2$endThumbSemantics$1$1(state3, fM);
                composer.updateRememberedValue(objRememberedValue6);
            }
            composer.endReplaceableGroup();
            Modifier modifierSliderSemantics2 = SliderKt.sliderSemantics(companion2, fM2, list2, z12, (l) objRememberedValue6, n.b(fM, this.$valueRange.getEndInclusive().floatValue()), this.$steps);
            boolean z13 = this.$enabled;
            List<Float> list3 = this.$tickFractions;
            SliderColors sliderColors = this.$colors;
            float f10 = k0Var.f29829a - k0Var2.f29829a;
            MutableInteractionSource mutableInteractionSource = this.$startInteractionSource;
            MutableInteractionSource mutableInteractionSource2 = this.$endInteractionSource;
            int i12 = this.$$dirty;
            SliderKt.RangeSliderImpl(z13, fCalcFraction, fCalcFraction2, list3, sliderColors, f10, mutableInteractionSource, mutableInteractionSource2, modifierRangeSliderPressDragModifier, modifierSliderSemantics, modifierSliderSemantics2, composer, ((i12 >> 9) & 14) | 14159872 | ((i12 >> 9) & 57344), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$3, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<e<Float>, k0> $onValueChange;
        final /* synthetic */ a<k0> $onValueChangeFinished;
        final /* synthetic */ int $steps;
        final /* synthetic */ e<Float> $valueRange;
        final /* synthetic */ e<Float> $values;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(e<Float> eVar, l<? super e<Float>, k0> lVar, Modifier modifier, boolean z10, e<Float> eVar2, int i10, a<k0> aVar, SliderColors sliderColors, int i11, int i12) {
            super(2);
            this.$values = eVar;
            this.$onValueChange = lVar;
            this.$modifier = modifier;
            this.$enabled = z10;
            this.$valueRange = eVar2;
            this.$steps = i10;
            this.$onValueChangeFinished = aVar;
            this.$colors = sliderColors;
            this.$$changed = i11;
            this.$$default = i12;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SliderKt.RangeSlider(this.$values, this.$onValueChange, this.$modifier, this.$enabled, this.$valueRange, this.$steps, this.$onValueChangeFinished, this.$colors, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSliderImpl$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    static final class C09322 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ Modifier $endThumbSemantics;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ float $positionFractionEnd;
        final /* synthetic */ float $positionFractionStart;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ Modifier $startThumbSemantics;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09322(boolean z10, float f10, float f11, List<Float> list, SliderColors sliderColors, float f12, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, int i10, int i11) {
            super(2);
            this.$enabled = z10;
            this.$positionFractionStart = f10;
            this.$positionFractionEnd = f11;
            this.$tickFractions = list;
            this.$colors = sliderColors;
            this.$width = f12;
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$modifier = modifier;
            this.$startThumbSemantics = modifier2;
            this.$endThumbSemantics = modifier3;
            this.$$changed = i10;
            this.$$changed1 = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SliderKt.RangeSliderImpl(this.$enabled, this.$positionFractionStart, this.$positionFractionEnd, this.$tickFractions, this.$colors, this.$width, this.$startInteractionSource, this.$endInteractionSource, this.$modifier, this.$startThumbSemantics, this.$endThumbSemantics, composer, this.$$changed | 1, this.$$changed1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    static final class C09333 extends v implements q<BoxWithConstraintsScope, Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ a<k0> $onValueChangeFinished;
        final /* synthetic */ State<l<Float, k0>> $onValueChangeState;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $value;
        final /* synthetic */ e<Float> $valueRange;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: Slider.kt */
        /* synthetic */ class AnonymousClass2 extends kotlin.jvm.internal.q implements l<Float, Float> {
            final /* synthetic */ kotlin.jvm.internal.k0 $maxPx;
            final /* synthetic */ kotlin.jvm.internal.k0 $minPx;
            final /* synthetic */ e<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(e<Float> eVar, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2) {
                super(1, t.a.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
                this.$valueRange = eVar;
                this.$minPx = k0Var;
                this.$maxPx = k0Var2;
            }

            @NotNull
            public final Float invoke(float f10) {
                return Float.valueOf(C09333.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, f10));
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ Float invoke(Float f10) {
                return invoke(f10.floatValue());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09333(e<Float> eVar, int i10, float f10, MutableInteractionSource mutableInteractionSource, boolean z10, List<Float> list, SliderColors sliderColors, State<? extends l<? super Float, k0>> state, a<k0> aVar) {
            super(3);
            this.$valueRange = eVar;
            this.$$dirty = i10;
            this.$value = f10;
            this.$interactionSource = mutableInteractionSource;
            this.$enabled = z10;
            this.$tickFractions = list;
            this.$colors = sliderColors;
            this.$onValueChangeState = state;
            this.$onValueChangeFinished = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToOffset(e<Float> eVar, kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, float f10) {
            return SliderKt.scale(eVar.getStart().floatValue(), eVar.getEndInclusive().floatValue(), f10, k0Var.f29829a, k0Var2.f29829a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$scaleToUserValue(kotlin.jvm.internal.k0 k0Var, kotlin.jvm.internal.k0 k0Var2, e<Float> eVar, float f10) {
            return SliderKt.scale(k0Var.f29829a, k0Var2.f29829a, f10, eVar.getStart().floatValue(), eVar.getEndInclusive().floatValue());
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
            invoke(boxWithConstraintsScope, composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer, int i10) {
            int i11;
            t.i(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i10 & 14) == 0) {
                i11 = i10 | (composer.changed(BoxWithConstraints) ? 4 : 2);
            } else {
                i11 = i10;
            }
            if ((i11 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            boolean z10 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            float fM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(BoxWithConstraints.mo371getConstraintsmsEJaDk());
            kotlin.jvm.internal.k0 k0Var = new kotlin.jvm.internal.k0();
            kotlin.jvm.internal.k0 k0Var2 = new kotlin.jvm.internal.k0();
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            k0Var.f29829a = Math.max(fM3641getMaxWidthimpl - density.mo296toPx0680j_4(SliderKt.getThumbRadius()), 0.0f);
            k0Var2.f29829a = Math.min(density.mo296toPx0680j_4(SliderKt.getThumbRadius()), k0Var.f29829a);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(h.f37608a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            float f10 = this.$value;
            e<Float> eVar = this.$valueRange;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(invoke$scaleToOffset(eVar, k0Var2, k0Var, f10)), null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue2;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            MutableState mutableState2 = (MutableState) objRememberedValue3;
            Object objValueOf = Float.valueOf(k0Var2.f29829a);
            Object objValueOf2 = Float.valueOf(k0Var.f29829a);
            e<Float> eVar2 = this.$valueRange;
            State<l<Float, k0>> state = this.$onValueChangeState;
            composer.startReplaceableGroup(1618982084);
            boolean zChanged = composer.changed(objValueOf) | composer.changed(objValueOf2) | composer.changed(eVar2);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new SliderDraggableState(new SliderKt$Slider$3$draggableState$1$1(mutableState, mutableState2, k0Var2, k0Var, state, eVar2));
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            SliderDraggableState sliderDraggableState = (SliderDraggableState) objRememberedValue4;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$valueRange, k0Var2, k0Var);
            e<Float> eVar3 = this.$valueRange;
            e eVarB = n.b(k0Var2.f29829a, k0Var.f29829a);
            float f11 = this.$value;
            int i12 = this.$$dirty;
            SliderKt.CorrectValueSideEffect(anonymousClass2, eVar3, eVarB, mutableState, f11, composer, ((i12 >> 9) & 112) | 3072 | ((i12 << 12) & 57344));
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new SliderKt$Slider$3$gestureEndAction$1(mutableState, this.$tickFractions, k0Var2, k0Var, coroutineScope, sliderDraggableState, this.$onValueChangeFinished), composer, 0);
            Modifier.Companion companion2 = Modifier.Companion;
            Modifier modifierSliderTapModifier = SliderKt.sliderTapModifier(companion2, sliderDraggableState, this.$interactionSource, fM3641getMaxWidthimpl, z10, mutableState, stateRememberUpdatedState, mutableState2, this.$enabled);
            Orientation orientation = Orientation.Horizontal;
            boolean zIsDragging = sliderDraggableState.isDragging();
            boolean z11 = this.$enabled;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged2 = composer.changed(stateRememberUpdatedState);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new SliderKt$Slider$3$drag$1$1(stateRememberUpdatedState, null);
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            Modifier modifierDraggable = DraggableKt.draggable(companion2, sliderDraggableState, orientation, (32 & 4) != 0 ? true : z11, (32 & 8) != 0 ? null : mutableInteractionSource, (32 & 16) != 0 ? false : zIsDragging, (32 & 32) != 0 ? new DraggableKt.C08411(null) : null, (32 & 64) != 0 ? new DraggableKt.AnonymousClass2(null) : (q) objRememberedValue5, (32 & 128) != 0 ? false : z10);
            float fCalcFraction = SliderKt.calcFraction(this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue(), o.m(this.$value, this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue()));
            boolean z12 = this.$enabled;
            List<Float> list = this.$tickFractions;
            SliderColors sliderColors = this.$colors;
            float f12 = k0Var.f29829a - k0Var2.f29829a;
            MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            Modifier modifierThen = modifierSliderTapModifier.then(modifierDraggable);
            int i13 = this.$$dirty;
            SliderKt.SliderImpl(z12, fCalcFraction, list, sliderColors, f12, mutableInteractionSource2, modifierThen, composer, ((i13 >> 9) & 14) | 512 | ((i13 >> 15) & 7168) | ((i13 >> 6) & 458752));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$4, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<Float, k0> $onValueChange;
        final /* synthetic */ a<k0> $onValueChangeFinished;
        final /* synthetic */ int $steps;
        final /* synthetic */ float $value;
        final /* synthetic */ e<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(float f10, l<? super Float, k0> lVar, Modifier modifier, boolean z10, e<Float> eVar, int i10, a<k0> aVar, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, int i11, int i12) {
            super(2);
            this.$value = f10;
            this.$onValueChange = lVar;
            this.$modifier = modifier;
            this.$enabled = z10;
            this.$valueRange = eVar;
            this.$steps = i10;
            this.$onValueChangeFinished = aVar;
            this.$interactionSource = mutableInteractionSource;
            this.$colors = sliderColors;
            this.$$changed = i11;
            this.$$default = i12;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SliderKt.Slider(this.$value, this.$onValueChange, this.$modifier, this.$enabled, this.$valueRange, this.$steps, this.$onValueChangeFinished, this.$interactionSource, this.$colors, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$SliderImpl$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    static final class C09342 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ float $positionFraction;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $width;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09342(boolean z10, float f10, List<Float> list, SliderColors sliderColors, float f11, MutableInteractionSource mutableInteractionSource, Modifier modifier, int i10) {
            super(2);
            this.$enabled = z10;
            this.$positionFraction = f10;
            this.$tickFractions = list;
            this.$colors = sliderColors;
            this.$width = f11;
            this.$interactionSource = mutableInteractionSource;
            this.$modifier = modifier;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SliderKt.SliderImpl(this.$enabled, this.$positionFraction, this.$tickFractions, this.$colors, this.$width, this.$interactionSource, this.$modifier, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Track$1, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    static final class AnonymousClass1 extends v implements l<DrawScope, k0> {
        final /* synthetic */ State<Color> $activeTickColor;
        final /* synthetic */ State<Color> $activeTrackColor;
        final /* synthetic */ State<Color> $inactiveTickColor;
        final /* synthetic */ State<Color> $inactiveTrackColor;
        final /* synthetic */ float $positionFractionEnd;
        final /* synthetic */ float $positionFractionStart;
        final /* synthetic */ float $thumbPx;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $trackStrokeWidth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(float f10, State<Color> state, float f11, float f12, float f13, State<Color> state2, List<Float> list, State<Color> state3, State<Color> state4) {
            super(1);
            this.$thumbPx = f10;
            this.$inactiveTrackColor = state;
            this.$trackStrokeWidth = f11;
            this.$positionFractionEnd = f12;
            this.$positionFractionStart = f13;
            this.$activeTrackColor = state2;
            this.$tickFractions = list;
            this.$inactiveTickColor = state3;
            this.$activeTickColor = state4;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DrawScope Canvas) {
            t.i(Canvas, "$this$Canvas");
            boolean z10 = Canvas.getLayoutDirection() == LayoutDirection.Rtl;
            long jOffset = OffsetKt.Offset(this.$thumbPx, Offset.m1368getYimpl(Canvas.mo1995getCenterF1C5BW0()));
            long jOffset2 = OffsetKt.Offset(Size.m1436getWidthimpl(Canvas.mo1996getSizeNHjbRc()) - this.$thumbPx, Offset.m1368getYimpl(Canvas.mo1995getCenterF1C5BW0()));
            long j10 = z10 ? jOffset2 : jOffset;
            long j11 = z10 ? jOffset : jOffset2;
            long jM1608unboximpl = this.$inactiveTrackColor.getValue().m1608unboximpl();
            float f10 = this.$trackStrokeWidth;
            StrokeCap.Companion companion = StrokeCap.Companion;
            long j12 = j11;
            long j13 = j10;
            b.C(Canvas, jM1608unboximpl, j10, j11, f10, companion.m1886getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
            b.C(Canvas, this.$activeTrackColor.getValue().m1608unboximpl(), OffsetKt.Offset(Offset.m1367getXimpl(j13) + ((Offset.m1367getXimpl(j12) - Offset.m1367getXimpl(j13)) * this.$positionFractionStart), Offset.m1368getYimpl(Canvas.mo1995getCenterF1C5BW0())), OffsetKt.Offset(Offset.m1367getXimpl(j13) + ((Offset.m1367getXimpl(j12) - Offset.m1367getXimpl(j13)) * this.$positionFractionEnd), Offset.m1368getYimpl(Canvas.mo1995getCenterF1C5BW0())), this.$trackStrokeWidth, companion.m1886getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
            List<Float> list = this.$tickFractions;
            float f11 = this.$positionFractionEnd;
            float f12 = this.$positionFractionStart;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                float fFloatValue = ((Number) obj).floatValue();
                Boolean boolValueOf = Boolean.valueOf(fFloatValue > f11 || fFloatValue < f12);
                Object arrayList = linkedHashMap.get(boolValueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(boolValueOf, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            State<Color> state = this.$inactiveTickColor;
            State<Color> state2 = this.$activeTickColor;
            float f13 = this.$trackStrokeWidth;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
                List list2 = (List) entry.getValue();
                ArrayList arrayList2 = new ArrayList(w.v(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Offset.m1356boximpl(OffsetKt.Offset(Offset.m1367getXimpl(OffsetKt.m1390lerpWko1d7g(j13, j12, ((Number) it.next()).floatValue())), Offset.m1368getYimpl(Canvas.mo1995getCenterF1C5BW0()))));
                }
                long j14 = j12;
                long j15 = j13;
                b.H(Canvas, arrayList2, PointMode.Companion.m1847getPointsr_lszbg(), (zBooleanValue ? state : state2).getValue().m1608unboximpl(), f13, StrokeCap.Companion.m1886getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                j13 = j15;
                f13 = f13;
                j12 = j14;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Track$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    static final class C09352 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ float $positionFractionEnd;
        final /* synthetic */ float $positionFractionStart;
        final /* synthetic */ float $thumbPx;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $trackStrokeWidth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09352(Modifier modifier, SliderColors sliderColors, boolean z10, float f10, float f11, List<Float> list, float f12, float f13, int i10) {
            super(2);
            this.$modifier = modifier;
            this.$colors = sliderColors;
            this.$enabled = z10;
            this.$positionFractionStart = f10;
            this.$positionFractionEnd = f11;
            this.$tickFractions = list;
            this.$thumbPx = f12;
            this.$trackStrokeWidth = f13;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SliderKt.Track(this.$modifier, this.$colors, this.$enabled, this.$positionFractionStart, this.$positionFractionEnd, this.$tickFractions, this.$thumbPx, this.$trackStrokeWidth, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$animateToTarget$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    @f(c = "androidx.compose.material.SliderKt$animateToTarget$2", f = "Slider.kt", l = {927}, m = "invokeSuspend")
    static final class C09362 extends kotlin.coroutines.jvm.internal.l implements p<DragScope, d<? super k0>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$animateToTarget$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Slider.kt */
        static final class AnonymousClass1 extends v implements l<Animatable<Float, AnimationVector1D>, k0> {
            final /* synthetic */ DragScope $$this$drag;
            final /* synthetic */ kotlin.jvm.internal.k0 $latestValue;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DragScope dragScope, kotlin.jvm.internal.k0 k0Var) {
                super(1);
                this.$$this$drag = dragScope;
                this.$latestValue = k0Var;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Animatable<Float, AnimationVector1D> animatable) {
                invoke2(animatable);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Animatable<Float, AnimationVector1D> animateTo) {
                t.i(animateTo, "$this$animateTo");
                this.$$this$drag.dragBy(animateTo.getValue().floatValue() - this.$latestValue.f29829a);
                this.$latestValue.f29829a = animateTo.getValue().floatValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09362(float f10, float f11, float f12, d<? super C09362> dVar) {
            super(2, dVar);
            this.$current = f10;
            this.$target = f11;
            this.$velocity = f12;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C09362 c09362 = new C09362(this.$current, this.$target, this.$velocity, dVar);
            c09362.L$0 = obj;
            return c09362;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull DragScope dragScope, @Nullable d<? super k0> dVar) {
            return ((C09362) create(dragScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                DragScope dragScope = (DragScope) this.L$0;
                kotlin.jvm.internal.k0 k0Var = new kotlin.jvm.internal.k0();
                float f10 = this.$current;
                k0Var.f29829a = f10;
                Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(f10, 0.0f, 2, null);
                Float fC = kotlin.coroutines.jvm.internal.b.c(this.$target);
                TweenSpec tweenSpec = SliderKt.SliderToTickAnimation;
                Float fC2 = kotlin.coroutines.jvm.internal.b.c(this.$velocity);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(dragScope, k0Var);
                this.label = 1;
                if (animatableAnimatable$default.animateTo(fC, tweenSpec, fC2, anonymousClass1, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    @f(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1", f = "Slider.kt", l = {955}, m = "invokeSuspend")
    static final class C09371 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, d<? super k0>, Object> {
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ State<l<Boolean, k0>> $gestureEndAction;
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ float $maxPx;
        final /* synthetic */ State<p<Boolean, Float, k0>> $onDrag;
        final /* synthetic */ State<Float> $rawOffsetEnd;
        final /* synthetic */ State<Float> $rawOffsetStart;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Slider.kt */
        @f(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", l = {956}, m = "invokeSuspend")
        static final class C01051 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ State<l<Boolean, k0>> $gestureEndAction;
            final /* synthetic */ boolean $isRtl;
            final /* synthetic */ float $maxPx;
            final /* synthetic */ State<p<Boolean, Float, k0>> $onDrag;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ State<Float> $rawOffsetEnd;
            final /* synthetic */ State<Float> $rawOffsetStart;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            @f(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", l = {957}, m = "invokeSuspend")
            static final class C01061 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, d<? super k0>, Object> {
                final /* synthetic */ o0 $$this$coroutineScope;
                final /* synthetic */ State<l<Boolean, k0>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ State<p<Boolean, Float, k0>> $onDrag;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ State<Float> $rawOffsetEnd;
                final /* synthetic */ State<Float> $rawOffsetStart;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Slider.kt */
                @f(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1", f = "Slider.kt", l = {958, 968, 987}, m = "invokeSuspend")
                static final class C01071 extends k implements p<AwaitPointerEventScope, d<? super k0>, Object> {
                    final /* synthetic */ o0 $$this$coroutineScope;
                    final /* synthetic */ State<l<Boolean, k0>> $gestureEndAction;
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ float $maxPx;
                    final /* synthetic */ State<p<Boolean, Float, k0>> $onDrag;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    final /* synthetic */ State<Float> $rawOffsetEnd;
                    final /* synthetic */ State<Float> $rawOffsetStart;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Slider.kt */
                    @f(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$1$2", f = "Slider.kt", l = {1004}, m = "invokeSuspend")
                    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
                        final /* synthetic */ i0 $draggingStart;
                        final /* synthetic */ DragInteraction $finishInteraction;
                        final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(RangeSliderLogic rangeSliderLogic, i0 i0Var, DragInteraction dragInteraction, d<? super AnonymousClass2> dVar) {
                            super(2, dVar);
                            this.$rangeSliderLogic = rangeSliderLogic;
                            this.$draggingStart = i0Var;
                            this.$finishInteraction = dragInteraction;
                        }

                        @Override // kotlin.coroutines.jvm.internal.a
                        @NotNull
                        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                            return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, dVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object objE = a9.d.e();
                            int i10 = this.label;
                            if (i10 == 0) {
                                u.b(obj);
                                MutableInteractionSource mutableInteractionSourceActiveInteraction = this.$rangeSliderLogic.activeInteraction(this.$draggingStart.f29826a);
                                DragInteraction dragInteraction = this.$finishInteraction;
                                this.label = 1;
                                if (mutableInteractionSourceActiveInteraction.emit(dragInteraction, this) == objE) {
                                    return objE;
                                }
                            } else {
                                if (i10 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                u.b(obj);
                            }
                            return k0.f35197a;
                        }

                        @Override // h9.p
                        @Nullable
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C01071(boolean z10, float f10, RangeSliderLogic rangeSliderLogic, State<Float> state, o0 o0Var, State<? extends l<? super Boolean, k0>> state2, State<Float> state3, State<? extends p<? super Boolean, ? super Float, k0>> state4, d<? super C01071> dVar) {
                        super(2, dVar);
                        this.$isRtl = z10;
                        this.$maxPx = f10;
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$rawOffsetStart = state;
                        this.$$this$coroutineScope = o0Var;
                        this.$gestureEndAction = state2;
                        this.$rawOffsetEnd = state3;
                        this.$onDrag = state4;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                        C01071 c01071 = new C01071(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, dVar);
                        c01071.L$0 = obj;
                        return c01071;
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable d<? super k0> dVar) {
                        return ((C01071) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:35:0x00d9  */
                    /* JADX WARN: Removed duplicated region for block: B:55:0x0172 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x0173  */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x017d A[Catch: CancellationException -> 0x018b, TryCatch #0 {CancellationException -> 0x018b, blocks: (B:8:0x001d, B:57:0x0175, B:59:0x017d, B:60:0x0183), top: B:67:0x001d }] */
                    /* JADX WARN: Removed duplicated region for block: B:60:0x0183 A[Catch: CancellationException -> 0x018b, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x018b, blocks: (B:8:0x001d, B:57:0x0175, B:59:0x017d, B:60:0x0183), top: B:67:0x001d }] */
                    @Override // kotlin.coroutines.jvm.internal.a
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
                        /*
                            Method dump skipped, instruction units count: 436
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.C09371.C01051.C01061.C01071.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C01061(boolean z10, float f10, RangeSliderLogic rangeSliderLogic, State<Float> state, o0 o0Var, State<? extends l<? super Boolean, k0>> state2, State<Float> state3, State<? extends p<? super Boolean, ? super Float, k0>> state4, d<? super C01061> dVar) {
                    super(2, dVar);
                    this.$isRtl = z10;
                    this.$maxPx = f10;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$rawOffsetStart = state;
                    this.$$this$coroutineScope = o0Var;
                    this.$gestureEndAction = state2;
                    this.$rawOffsetEnd = state3;
                    this.$onDrag = state4;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                    C01061 c01061 = new C01061(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, dVar);
                    c01061.L$0 = obj;
                    return c01061;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
                    return ((C01061) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                        C01071 c01071 = new C01071(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
                        this.label = 1;
                        if (pointerInputScope.awaitPointerEventScope(c01071, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        u.b(obj);
                    }
                    return k0.f35197a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01051(PointerInputScope pointerInputScope, boolean z10, float f10, RangeSliderLogic rangeSliderLogic, State<Float> state, State<? extends l<? super Boolean, k0>> state2, State<Float> state3, State<? extends p<? super Boolean, ? super Float, k0>> state4, d<? super C01051> dVar) {
                super(2, dVar);
                this.$$this$pointerInput = pointerInputScope;
                this.$isRtl = z10;
                this.$maxPx = f10;
                this.$rangeSliderLogic = rangeSliderLogic;
                this.$rawOffsetStart = state;
                this.$gestureEndAction = state2;
                this.$rawOffsetEnd = state3;
                this.$onDrag = state4;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                C01051 c01051 = new C01051(this.$$this$pointerInput, this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, dVar);
                c01051.L$0 = obj;
                return c01051;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    o0 o0Var = (o0) this.L$0;
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C01061 c01061 = new C01061(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, o0Var, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
                    this.label = 1;
                    if (ForEachGestureKt.forEachGesture(pointerInputScope, c01061, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((C01051) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09371(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, State<? extends p<? super Boolean, ? super Float, k0>> state3, boolean z10, float f10, State<? extends l<? super Boolean, k0>> state4, d<? super C09371> dVar) {
            super(2, dVar);
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
            this.$rawOffsetStart = state;
            this.$rawOffsetEnd = state2;
            this.$onDrag = state3;
            this.$isRtl = z10;
            this.$maxPx = f10;
            this.$gestureEndAction = state4;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C09371 c09371 = new C09371(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag, this.$isRtl, this.$maxPx, this.$gestureEndAction, dVar);
            c09371.L$0 = obj;
            return c09371;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((C09371) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                C01051 c01051 = new C01051((PointerInputScope) this.L$0, this.$isRtl, this.$maxPx, new RangeSliderLogic(this.$startInteractionSource, this.$endInteractionSource, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onDrag), this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null);
                this.label = 1;
                if (p0.f(c01051, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderSemantics$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    static final class C09381 extends v implements l<SemanticsPropertyReceiver, k0> {
        final /* synthetic */ float $coerced;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ l<Float, k0> $onValueChange;
        final /* synthetic */ int $steps;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ e<Float> $valueRange;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderSemantics$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Slider.kt */
        static final class C01081 extends v implements l<Float, Boolean> {
            final /* synthetic */ float $coerced;
            final /* synthetic */ l<Float, k0> $onValueChange;
            final /* synthetic */ int $steps;
            final /* synthetic */ List<Float> $tickFractions;
            final /* synthetic */ e<Float> $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01081(e<Float> eVar, int i10, List<Float> list, float f10, l<? super Float, k0> lVar) {
                super(1);
                this.$valueRange = eVar;
                this.$steps = i10;
                this.$tickFractions = list;
                this.$coerced = f10;
                this.$onValueChange = lVar;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Float f10) {
                return invoke(f10.floatValue());
            }

            @NotNull
            public final Boolean invoke(float f10) {
                Object obj;
                float fM = o.m(f10, this.$valueRange.getStart().floatValue(), this.$valueRange.getEndInclusive().floatValue());
                if (this.$steps > 0) {
                    List<Float> list = this.$tickFractions;
                    e<Float> eVar = this.$valueRange;
                    ArrayList arrayList = new ArrayList(w.v(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Float.valueOf(MathHelpersKt.lerp(eVar.getStart().floatValue(), eVar.getEndInclusive().floatValue(), ((Number) it.next()).floatValue())));
                    }
                    Iterator it2 = arrayList.iterator();
                    if (it2.hasNext()) {
                        Object next = it2.next();
                        if (it2.hasNext()) {
                            float fAbs = Math.abs(((Number) next).floatValue() - fM);
                            do {
                                Object next2 = it2.next();
                                float fAbs2 = Math.abs(((Number) next2).floatValue() - fM);
                                if (Float.compare(fAbs, fAbs2) > 0) {
                                    next = next2;
                                    fAbs = fAbs2;
                                }
                            } while (it2.hasNext());
                        }
                        obj = next;
                    } else {
                        obj = null;
                    }
                    Float f11 = (Float) obj;
                    if (f11 != null) {
                        fM = f11.floatValue();
                    }
                }
                boolean z10 = true;
                if (fM == this.$coerced) {
                    z10 = false;
                } else {
                    this.$onValueChange.invoke(Float.valueOf(fM));
                }
                return Boolean.valueOf(z10);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09381(boolean z10, e<Float> eVar, int i10, List<Float> list, float f10, l<? super Float, k0> lVar) {
            super(1);
            this.$enabled = z10;
            this.$valueRange = eVar;
            this.$steps = i10;
            this.$tickFractions = list;
            this.$coerced = f10;
            this.$onValueChange = lVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            if (!this.$enabled) {
                SemanticsPropertiesKt.disabled(semantics);
            }
            SemanticsPropertiesKt.setProgress$default(semantics, null, new C01081(this.$valueRange, this.$steps, this.$tickFractions, this.$coerced, this.$onValueChange), 1, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    static final class C09392 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ DraggableState $draggableState;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ State<l<Float, k0>> $gestureEndAction;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ boolean $isRtl;
        final /* synthetic */ float $maxPx;
        final /* synthetic */ MutableState<Float> $pressOffset;
        final /* synthetic */ State<Float> $rawOffset;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Slider.kt */
        @f(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1", f = "Slider.kt", l = {882}, m = "invokeSuspend")
        static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, d<? super k0>, Object> {
            final /* synthetic */ DraggableState $draggableState;
            final /* synthetic */ State<l<Float, k0>> $gestureEndAction;
            final /* synthetic */ boolean $isRtl;
            final /* synthetic */ float $maxPx;
            final /* synthetic */ MutableState<Float> $pressOffset;
            final /* synthetic */ State<Float> $rawOffset;
            final /* synthetic */ o0 $scope;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            @f(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1", f = "Slider.kt", l = {887}, m = "invokeSuspend")
            static final class C01091 extends kotlin.coroutines.jvm.internal.l implements q<PressGestureScope, Offset, d<? super k0>, Object> {
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ MutableState<Float> $pressOffset;
                final /* synthetic */ State<Float> $rawOffset;
                /* synthetic */ long J$0;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01091(boolean z10, float f10, MutableState<Float> mutableState, State<Float> state, d<? super C01091> dVar) {
                    super(3, dVar);
                    this.$isRtl = z10;
                    this.$maxPx = f10;
                    this.$pressOffset = mutableState;
                    this.$rawOffset = state;
                }

                @Override // h9.q
                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, d<? super k0> dVar) {
                    return m1127invoked4ec7I(pressGestureScope, offset.m1377unboximpl(), dVar);
                }

                @Nullable
                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                public final Object m1127invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j10, @Nullable d<? super k0> dVar) {
                    C01091 c01091 = new C01091(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, dVar);
                    c01091.L$0 = pressGestureScope;
                    c01091.J$0 = j10;
                    return c01091.invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    try {
                        if (i10 == 0) {
                            u.b(obj);
                            PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                            long j10 = this.J$0;
                            this.$pressOffset.setValue(kotlin.coroutines.jvm.internal.b.c((this.$isRtl ? this.$maxPx - Offset.m1367getXimpl(j10) : Offset.m1367getXimpl(j10)) - this.$rawOffset.getValue().floatValue()));
                            this.label = 1;
                            if (pressGestureScope.awaitRelease(this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u.b(obj);
                        }
                    } catch (GestureCancellationException unused) {
                        this.$pressOffset.setValue(kotlin.coroutines.jvm.internal.b.c(0.0f));
                    }
                    return k0.f35197a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            static final class C01102 extends v implements l<Offset, k0> {
                final /* synthetic */ DraggableState $draggableState;
                final /* synthetic */ State<l<Float, k0>> $gestureEndAction;
                final /* synthetic */ o0 $scope;

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Slider.kt */
                @f(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1", f = "Slider.kt", l = {894}, m = "invokeSuspend")
                static final class C01111 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
                    final /* synthetic */ DraggableState $draggableState;
                    final /* synthetic */ State<l<Float, k0>> $gestureEndAction;
                    int label;

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: Slider.kt */
                    @f(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1", f = "Slider.kt", l = {}, m = "invokeSuspend")
                    static final class C01121 extends kotlin.coroutines.jvm.internal.l implements p<DragScope, d<? super k0>, Object> {
                        private /* synthetic */ Object L$0;
                        int label;

                        C01121(d<? super C01121> dVar) {
                            super(2, dVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.a
                        @NotNull
                        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                            C01121 c01121 = new C01121(dVar);
                            c01121.L$0 = obj;
                            return c01121;
                        }

                        @Override // h9.p
                        @Nullable
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                        public final Object mo4invoke(@NotNull DragScope dragScope, @Nullable d<? super k0> dVar) {
                            return ((C01121) create(dragScope, dVar)).invokeSuspend(k0.f35197a);
                        }

                        @Override // kotlin.coroutines.jvm.internal.a
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            a9.d.e();
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u.b(obj);
                            ((DragScope) this.L$0).dragBy(0.0f);
                            return k0.f35197a;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C01111(DraggableState draggableState, State<? extends l<? super Float, k0>> state, d<? super C01111> dVar) {
                        super(2, dVar);
                        this.$draggableState = draggableState;
                        this.$gestureEndAction = state;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                        return new C01111(this.$draggableState, this.$gestureEndAction, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object objE = a9.d.e();
                        int i10 = this.label;
                        if (i10 == 0) {
                            u.b(obj);
                            DraggableState draggableState = this.$draggableState;
                            MutatePriority mutatePriority = MutatePriority.UserInput;
                            C01121 c01121 = new C01121(null);
                            this.label = 1;
                            if (draggableState.drag(mutatePriority, c01121, this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u.b(obj);
                        }
                        this.$gestureEndAction.getValue().invoke(kotlin.coroutines.jvm.internal.b.c(0.0f));
                        return k0.f35197a;
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                        return ((C01111) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C01102(o0 o0Var, DraggableState draggableState, State<? extends l<? super Float, k0>> state) {
                    super(1);
                    this.$scope = o0Var;
                    this.$draggableState = draggableState;
                    this.$gestureEndAction = state;
                }

                @Override // h9.l
                public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
                    m1128invokek4lQ0M(offset.m1377unboximpl());
                    return k0.f35197a;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m1128invokek4lQ0M(long j10) {
                    kotlinx.coroutines.k.d(this.$scope, null, null, new C01111(this.$draggableState, this.$gestureEndAction, null), 3, null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(boolean z10, float f10, MutableState<Float> mutableState, State<Float> state, o0 o0Var, DraggableState draggableState, State<? extends l<? super Float, k0>> state2, d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$isRtl = z10;
                this.$maxPx = f10;
                this.$pressOffset = mutableState;
                this.$rawOffset = state;
                this.$scope = o0Var;
                this.$draggableState = draggableState;
                this.$gestureEndAction = state2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, this.$scope, this.$draggableState, this.$gestureEndAction, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
                return ((AnonymousClass1) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    C01091 c01091 = new C01091(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, null);
                    C01102 c01102 = new C01102(this.$scope, this.$draggableState, this.$gestureEndAction);
                    this.label = 1;
                    if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, c01091, c01102, this, 3, null) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09392(boolean z10, DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f10, boolean z11, MutableState<Float> mutableState, State<Float> state, State<? extends l<? super Float, k0>> state2) {
            super(3);
            this.$enabled = z10;
            this.$draggableState = draggableState;
            this.$interactionSource = mutableInteractionSource;
            this.$maxPx = f10;
            this.$isRtl = z11;
            this.$pressOffset = mutableState;
            this.$rawOffset = state;
            this.$gestureEndAction = state2;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(1945228890);
            if (this.$enabled) {
                composer.startReplaceableGroup(773894976);
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(h.f37608a, composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                composer.endReplaceableGroup();
                o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                composer.endReplaceableGroup();
                composed = SuspendingPointerInputFilterKt.pointerInput(composed, new Object[]{this.$draggableState, this.$interactionSource, Float.valueOf(this.$maxPx), Boolean.valueOf(this.$isRtl)}, (p<? super PointerInputScope, ? super d<? super k0>, ? extends Object>) new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, coroutineScope, this.$draggableState, this.$gestureEndAction, null));
            }
            composer.endReplaceableGroup();
            return composed;
        }
    }

    static {
        float fM3673constructorimpl = Dp.m3673constructorimpl(48);
        SliderHeight = fM3673constructorimpl;
        float fM3673constructorimpl2 = Dp.m3673constructorimpl(144);
        SliderMinWidth = fM3673constructorimpl2;
        DefaultSliderConstraints = SizeKt.m428heightInVpY3zN4$default(SizeKt.m447widthInVpY3zN4$default(Modifier.Companion, fM3673constructorimpl2, 0.0f, 2, null), 0.0f, fM3673constructorimpl, 1, null);
        SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v0 ??, still in use, count: 1, list:
          (r14v0 ?? I:java.lang.Object) from 0x00c0: INVOKE (r11v0 ?? I:androidx.compose.runtime.Composer), (r14v0 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:193)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @androidx.compose.runtime.Composable
    public static final void CorrectValueSideEffect(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r14v0 ??, still in use, count: 1, list:
          (r14v0 ?? I:java.lang.Object) from 0x00c0: INVOKE (r11v0 ?? I:androidx.compose.runtime.Composer), (r14v0 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:193)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r15v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    /* JADX WARN: Removed duplicated region for block: B:106:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0119  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RangeSlider(@org.jetbrains.annotations.NotNull n9.e<java.lang.Float> r42, @org.jetbrains.annotations.NotNull h9.l<? super n9.e<java.lang.Float>, v8.k0> r43, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r44, boolean r45, @org.jetbrains.annotations.Nullable n9.e<java.lang.Float> r46, int r47, @org.jetbrains.annotations.Nullable h9.a<v8.k0> r48, @org.jetbrains.annotations.Nullable androidx.compose.material.SliderColors r49, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r50, int r51, int r52) {
        /*
            Method dump skipped, instruction units count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.RangeSlider(n9.e, h9.l, androidx.compose.ui.Modifier, boolean, n9.e, int, h9.a, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RangeSliderImpl(boolean z10, float f10, float f11, List<Float> list, SliderColors sliderColors, float f12, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, Composer composer, int i10, int i11) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-278895713);
        Strings.Companion companion = Strings.Companion;
        String strM1145getString4foXLRw = Strings_androidKt.m1145getString4foXLRw(companion.m1144getSliderRangeStartUdPEhr4(), composerStartRestartGroup, 6);
        String strM1145getString4foXLRw2 = Strings_androidKt.m1145getString4foXLRw(companion.m1143getSliderRangeEndUdPEhr4(), composerStartRestartGroup, 6);
        Modifier modifierThen = modifier.then(DefaultSliderConstraints);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion2 = Alignment.Companion;
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
        a<ComposeUiNode> constructor = companion3.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierThen);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion3.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(2044256857);
        Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        float fMo296toPx0680j_4 = density2.mo296toPx0680j_4(TrackHeight);
        float f13 = ThumbRadius;
        float fMo296toPx0680j_42 = density2.mo296toPx0680j_4(f13);
        float fMo292toDpu2uoSUM = density2.mo292toDpu2uoSUM(f12);
        k0 k0Var = k0.f35197a;
        float fM3673constructorimpl = Dp.m3673constructorimpl(f13 * 2);
        float fM3673constructorimpl2 = Dp.m3673constructorimpl(fMo292toDpu2uoSUM * f10);
        float fM3673constructorimpl3 = Dp.m3673constructorimpl(fMo292toDpu2uoSUM * f11);
        Modifier.Companion companion4 = Modifier.Companion;
        int i12 = i10 >> 9;
        int i13 = i10 << 6;
        Track(SizeKt.fillMaxSize$default(boxScopeInstance.align(companion4, companion2.getCenterStart()), 0.0f, 1, null), sliderColors, z10, f10, f11, list, fMo296toPx0680j_42, fMo296toPx0680j_4, composerStartRestartGroup, (i12 & 112) | 262144 | (i13 & 896) | (i13 & 7168) | (i13 & 57344));
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(strM1145getString4foXLRw);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new SliderKt$RangeSliderImpl$1$2$1(strM1145getString4foXLRw);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        int i14 = i10 & 57344;
        int i15 = (i10 << 15) & 458752;
        m1123SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion4, true, (l) objRememberedValue), true, mutableInteractionSource).then(modifier2), fM3673constructorimpl2, mutableInteractionSource, sliderColors, z10, fM3673constructorimpl, composerStartRestartGroup, (i12 & 7168) | 1572870 | i14 | i15);
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged2 = composerStartRestartGroup.changed(strM1145getString4foXLRw2);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new SliderKt$RangeSliderImpl$1$3$1(strM1145getString4foXLRw2);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        m1123SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion4, true, (l) objRememberedValue2), true, mutableInteractionSource2).then(modifier3), fM3673constructorimpl3, mutableInteractionSource2, sliderColors, z10, fM3673constructorimpl, composerStartRestartGroup, ((i10 >> 12) & 7168) | 1572870 | i14 | i15);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C09322(z10, f10, f11, list, sliderColors, f12, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier3, i10, i11));
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0117  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Slider(float r39, @org.jetbrains.annotations.NotNull h9.l<? super java.lang.Float, v8.k0> r40, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r41, boolean r42, @org.jetbrains.annotations.Nullable n9.e<java.lang.Float> r43, int r44, @org.jetbrains.annotations.Nullable h9.a<v8.k0> r45, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r46, @org.jetbrains.annotations.Nullable androidx.compose.material.SliderColors r47, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            Method dump skipped, instruction units count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.Slider(float, h9.l, androidx.compose.ui.Modifier, boolean, n9.e, int, h9.a, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SliderImpl(boolean z10, float f10, List<Float> list, SliderColors sliderColors, float f11, MutableInteractionSource mutableInteractionSource, Modifier modifier, Composer composer, int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1679682785);
        Modifier modifierThen = modifier.then(DefaultSliderConstraints);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        a<ComposeUiNode> constructor = companion.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierThen);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(231316251);
        Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        float fMo296toPx0680j_4 = density2.mo296toPx0680j_4(TrackHeight);
        float f12 = ThumbRadius;
        float fMo296toPx0680j_42 = density2.mo296toPx0680j_4(f12);
        float fMo292toDpu2uoSUM = density2.mo292toDpu2uoSUM(f11);
        float fM3673constructorimpl = Dp.m3673constructorimpl(f12 * 2);
        float fM3673constructorimpl2 = Dp.m3673constructorimpl(fMo292toDpu2uoSUM * f10);
        Modifier.Companion companion2 = Modifier.Companion;
        int i11 = i10 >> 6;
        Track(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), sliderColors, z10, 0.0f, f10, list, fMo296toPx0680j_42, fMo296toPx0680j_4, composerStartRestartGroup, (i11 & 112) | 265222 | ((i10 << 6) & 896) | ((i10 << 9) & 57344));
        m1123SliderThumbPcYyNuk(boxScopeInstance, companion2, fM3673constructorimpl2, mutableInteractionSource, sliderColors, z10, fM3673constructorimpl, composerStartRestartGroup, (i11 & 7168) | 1572918 | ((i10 << 3) & 57344) | ((i10 << 15) & 458752));
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C09342(z10, f10, list, sliderColors, f11, mutableInteractionSource, modifier, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: SliderThumb-PcYyNuk, reason: not valid java name */
    public static final void m1123SliderThumbPcYyNuk(BoxScope boxScope, Modifier modifier, float f10, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z10, float f11, Composer composer, int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(428907178);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(f10) ? 256 : 128;
        }
        if ((i10 & 7168) == 0) {
            i11 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((57344 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((458752 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 131072 : 65536;
        }
        if ((3670016 & i10) == 0) {
            i11 |= composerStartRestartGroup.changed(f11) ? 1048576 : 524288;
        }
        if ((2995931 & i11) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            Modifier modifierM403paddingqDBjuR0$default = PaddingKt.m403paddingqDBjuR0$default(Modifier.Companion, f10, 0.0f, 0.0f, 0.0f, 14, null);
            Alignment.Companion companion = Alignment.Companion;
            Modifier modifierAlign = boxScope.align(modifierM403paddingqDBjuR0$default, companion.getCenterStart());
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion2.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierAlign);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
            Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-587645648);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.Companion;
            if (objRememberedValue == companion3.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            int i12 = i11 >> 9;
            int i13 = i12 & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(mutableInteractionSource) | composerStartRestartGroup.changed(snapshotStateList);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion3.getEmpty()) {
                objRememberedValue2 = new SliderKt$SliderThumb$1$1$1(mutableInteractionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(mutableInteractionSource, (p<? super o0, ? super d<? super k0>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, i13);
            SpacerKt.Spacer(BackgroundKt.m165backgroundbw27NRU(ShadowKt.m1296shadows4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m442sizeVpY3zN4(modifier, f11, f11), mutableInteractionSource, RippleKt.m1237rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, composerStartRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null), z10 ? snapshotStateList.isEmpty() ^ true ? ThumbPressedElevation : ThumbDefaultElevation : Dp.m3673constructorimpl(0), RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), sliderColors.thumbColor(z10, composerStartRestartGroup, ((i11 >> 15) & 14) | (i12 & 112)).getValue().m1608unboximpl(), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new SliderKt$SliderThumb$2(boxScope, modifier, f10, mutableInteractionSource, sliderColors, z10, f11, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Track(Modifier modifier, SliderColors sliderColors, boolean z10, float f10, float f11, List<Float> list, float f12, float f13, Composer composer, int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1833126050);
        int i11 = ((i10 >> 6) & 14) | 48 | ((i10 << 3) & 896);
        CanvasKt.Canvas(modifier, new AnonymousClass1(f12, sliderColors.trackColor(z10, false, composerStartRestartGroup, i11), f13, f11, f10, sliderColors.trackColor(z10, true, composerStartRestartGroup, i11), list, sliderColors.tickColor(z10, false, composerStartRestartGroup, i11), sliderColors.tickColor(z10, true, composerStartRestartGroup, i11)), composerStartRestartGroup, i10 & 14);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C09352(modifier, sliderColors, z10, f10, f11, list, f12, f13, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float f10, float f11, float f12, d<? super k0> dVar) {
        Object objA = androidx.compose.foundation.gestures.a.a(draggableState, null, new C09362(f10, f11, f12, null), dVar, 1, null);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m1126awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, z8.d<? super v8.s<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material.SliderKt$awaitSlop$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = (androidx.compose.material.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = new androidx.compose.material.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L18:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = a9.b.e()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r8 = r6.L$0
            kotlin.jvm.internal.k0 r8 = (kotlin.jvm.internal.k0) r8
            v8.u.b(r12)
            goto L54
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            v8.u.b(r12)
            kotlin.jvm.internal.k0 r12 = new kotlin.jvm.internal.k0
            r12.<init>()
            androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1 r5 = new androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
            r5.<init>(r12)
            r6.L$0 = r12
            r6.label = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material.DragGestureDetectorCopyKt.m992awaitHorizontalPointerSlopOrCancellationgDDlDlE(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L51
            return r0
        L51:
            r7 = r12
            r12 = r8
            r8 = r7
        L54:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L63
            float r8 = r8.f29829a
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.b.c(r8)
            v8.s r8 = v8.y.a(r12, r8)
            goto L64
        L63:
            r8 = 0
        L64:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.m1126awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float f10, float f11, float f12) {
        float f13 = f11 - f10;
        return o.m((f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1)) == 0 ? 0.0f : (f12 - f10) / f13, 0.0f, 1.0f);
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier modifier, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, boolean z10, boolean z11, float f10, e<Float> eVar, State<? extends l<? super Boolean, k0>> state3, State<? extends p<? super Boolean, ? super Float, k0>> state4) {
        return z10 ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, Float.valueOf(f10), Boolean.valueOf(z11), eVar}, (p<? super PointerInputScope, ? super d<? super k0>, ? extends Object>) new C09371(mutableInteractionSource, mutableInteractionSource2, state, state2, state4, z11, f10, state3, null)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float f10, float f11, float f12, float f13, float f14) {
        return MathHelpersKt.lerp(f13, f14, calcFraction(f10, f11, f12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier modifier, float f10, List<Float> list, boolean z10, l<? super Float, k0> lVar, e<Float> eVar, int i10) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new C09381(z10, eVar, i10, list, o.m(f10, eVar.getStart().floatValue(), eVar.getEndInclusive().floatValue()), lVar), 1, null), f10, eVar, i10);
    }

    static /* synthetic */ Modifier sliderSemantics$default(Modifier modifier, float f10, List list, boolean z10, l lVar, e eVar, int i10, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            eVar = n.b(0.0f, 1.0f);
        }
        e eVar2 = eVar;
        if ((i11 & 32) != 0) {
            i10 = 0;
        }
        return sliderSemantics(modifier, f10, list, z10, lVar, eVar2, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderTapModifier(Modifier modifier, DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f10, boolean z10, State<Float> state, State<? extends l<? super Float, k0>> state2, MutableState<Float> mutableState, boolean z11) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1(draggableState, mutableInteractionSource, f10, z10, state, state2, mutableState, z11) : InspectableValueKt.getNoInspectorInfo(), new C09392(z11, draggableState, mutableInteractionSource, f10, z10, mutableState, state, state2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float snapValueToTick(float f10, List<Float> list, float f11, float f12) {
        Object obj;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                float fAbs = Math.abs(MathHelpersKt.lerp(f11, f12, ((Number) next).floatValue()) - f10);
                do {
                    Object next2 = it.next();
                    float fAbs2 = Math.abs(MathHelpersKt.lerp(f11, f12, ((Number) next2).floatValue()) - f10);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Float f13 = (Float) obj;
        return f13 != null ? MathHelpersKt.lerp(f11, f12, f13.floatValue()) : f10;
    }

    private static final List<Float> stepsToTickFractions(int i10) {
        if (i10 == 0) {
            return kotlin.collections.v.l();
        }
        int i11 = i10 + 2;
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(Float.valueOf(i12 / (i10 + 1)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e<Float> scale(float f10, float f11, e<Float> eVar, float f12, float f13) {
        return n.b(scale(f10, f11, eVar.getStart().floatValue(), f12, f13), scale(f10, f11, eVar.getEndInclusive().floatValue(), f12, f13));
    }
}
