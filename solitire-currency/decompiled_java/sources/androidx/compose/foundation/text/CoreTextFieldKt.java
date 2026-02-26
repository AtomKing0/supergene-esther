package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.d;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import j9.c;
import java.util.List;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import v8.x;
import v8.y;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass1 extends v implements l<TextLayoutResult, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull TextLayoutResult it) {
            t.i(it, "it");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(TextLayoutResult textLayoutResult) {
            invoke2(textLayoutResult);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass2 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ TextFieldState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TextFieldState textFieldState) {
            super(1);
            this.$state = textFieldState;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            final TextFieldState textFieldState = this.$state;
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    if (textFieldState.getHasFocus()) {
                        CoreTextFieldKt.onBlur(textFieldState);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass3 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ TextFieldSelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(TextFieldSelectionManager textFieldSelectionManager) {
            super(1);
            this.$manager = textFieldSelectionManager;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass4 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ ImeOptions $imeOptions;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ TextInputService $textInputService;
        final /* synthetic */ TextFieldValue $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions) {
            super(1);
            this.$textInputService = textInputService;
            this.$state = textFieldState;
            this.$value = textFieldValue;
            this.$imeOptions = imeOptions;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            if (this.$textInputService != null && this.$state.getHasFocus()) {
                TextFieldState textFieldState = this.$state;
                textFieldState.setInputSession(TextFieldDelegate.Companion.restartInput$foundation_release(this.$textInputService, this.$value, textFieldState.getProcessor(), this.$imeOptions, this.$state.getOnValueChange(), this.$state.getOnImeActionPerformed()));
            }
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass5 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
        final /* synthetic */ Modifier $cursorModifier;
        final /* synthetic */ q<p<? super Composer, ? super Integer, k0>, Composer, Integer, k0> $decorationBox;
        final /* synthetic */ Modifier $drawModifier;
        final /* synthetic */ Modifier $magnifierModifier;
        final /* synthetic */ TextFieldSelectionManager $manager;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ Modifier $onPositionedModifier;
        final /* synthetic */ l<TextLayoutResult, k0> $onTextLayout;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
        final /* synthetic */ boolean $showHandleAndMagnifier;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ TextStyle $textStyle;
        final /* synthetic */ TextFieldValue $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: CoreTextField.kt */
        static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
            final /* synthetic */ Modifier $cursorModifier;
            final /* synthetic */ Modifier $drawModifier;
            final /* synthetic */ Modifier $magnifierModifier;
            final /* synthetic */ TextFieldSelectionManager $manager;
            final /* synthetic */ int $maxLines;
            final /* synthetic */ Modifier $onPositionedModifier;
            final /* synthetic */ l<TextLayoutResult, k0> $onTextLayout;
            final /* synthetic */ boolean $readOnly;
            final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
            final /* synthetic */ boolean $showHandleAndMagnifier;
            final /* synthetic */ TextFieldState $state;
            final /* synthetic */ TextStyle $textStyle;
            final /* synthetic */ TextFieldValue $value;
            final /* synthetic */ VisualTransformation $visualTransformation;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: CoreTextField.kt */
            static final class C00591 extends v implements p<Composer, Integer, k0> {
                final /* synthetic */ TextFieldSelectionManager $manager;
                final /* synthetic */ l<TextLayoutResult, k0> $onTextLayout;
                final /* synthetic */ boolean $readOnly;
                final /* synthetic */ boolean $showHandleAndMagnifier;
                final /* synthetic */ TextFieldState $state;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00591(TextFieldSelectionManager textFieldSelectionManager, TextFieldState textFieldState, boolean z10, boolean z11, l<? super TextLayoutResult, k0> lVar) {
                    super(2);
                    this.$manager = textFieldSelectionManager;
                    this.$state = textFieldState;
                    this.$showHandleAndMagnifier = z10;
                    this.$readOnly = z11;
                    this.$onTextLayout = lVar;
                }

                @Override // h9.p
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return k0.f35197a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i10) {
                    if ((i10 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    final TextFieldState textFieldState = this.$state;
                    final l<TextLayoutResult, k0> lVar = this.$onTextLayout;
                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                            return d.a(this, intrinsicMeasureScope, list, i11);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i11) {
                            t.i(intrinsicMeasureScope, "<this>");
                            t.i(measurables, "measurables");
                            textFieldState.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                            return textFieldState.getTextDelegate().getMaxIntrinsicWidth();
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        @NotNull
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public MeasureResult mo8measure3p2s80s(@NotNull MeasureScope measure, @NotNull List<? extends Measurable> measurables, long j10) {
                            t.i(measure, "$this$measure");
                            t.i(measurables, "measurables");
                            Snapshot.Companion companion = Snapshot.Companion;
                            TextFieldState textFieldState2 = textFieldState;
                            Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
                            try {
                                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                                try {
                                    TextLayoutResultProxy layoutResult = textFieldState2.getLayoutResult();
                                    TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                    snapshotCreateNonObservableSnapshot.dispose();
                                    x<Integer, Integer, TextLayoutResult> xVarM724layout_EkL_Y$foundation_release = TextFieldDelegate.Companion.m724layout_EkL_Y$foundation_release(textFieldState.getTextDelegate(), j10, measure.getLayoutDirection(), value);
                                    int iIntValue = xVarM724layout_EkL_Y$foundation_release.a().intValue();
                                    int iIntValue2 = xVarM724layout_EkL_Y$foundation_release.b().intValue();
                                    TextLayoutResult textLayoutResultC = xVarM724layout_EkL_Y$foundation_release.c();
                                    if (!t.d(value, textLayoutResultC)) {
                                        textFieldState.setLayoutResult(new TextLayoutResultProxy(textLayoutResultC));
                                        lVar.invoke(textLayoutResultC);
                                    }
                                    return measure.layout(iIntValue, iIntValue2, r0.j(y.a(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(c.c(textLayoutResultC.getFirstBaseline()))), y.a(AlignmentLineKt.getLastBaseline(), Integer.valueOf(c.c(textLayoutResultC.getLastBaseline())))), CoreTextFieldKt$CoreTextField$5$1$1$2$measure$1.INSTANCE);
                                } finally {
                                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                                }
                            } catch (Throwable th) {
                                snapshotCreateNonObservableSnapshot.dispose();
                                throw th;
                            }
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                            return d.c(this, intrinsicMeasureScope, list, i11);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                            return d.d(this, intrinsicMeasureScope, list, i11);
                        }
                    };
                    composer.startReplaceableGroup(-1323940314);
                    Modifier.Companion companion = Modifier.Companion;
                    Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    a<ComposeUiNode> constructor = companion2.getConstructor();
                    q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(companion);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    composer.disableReusing();
                    Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composer);
                    Updater.m1265setimpl(composerM1258constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
                    Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                    Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                    composer.enableReusing();
                    boolean z10 = false;
                    qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
                    composer.startReplaceableGroup(2058660585);
                    composer.startReplaceableGroup(1714611517);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    TextFieldSelectionManager textFieldSelectionManager = this.$manager;
                    if (this.$state.getHandleState() == HandleState.Selection && this.$state.getLayoutCoordinates() != null) {
                        LayoutCoordinates layoutCoordinates = this.$state.getLayoutCoordinates();
                        t.f(layoutCoordinates);
                        if (layoutCoordinates.isAttached() && this.$showHandleAndMagnifier) {
                            z10 = true;
                        }
                    }
                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager, z10, composer, 8);
                    if (this.$state.getHandleState() == HandleState.Cursor && !this.$readOnly && this.$showHandleAndMagnifier) {
                        CoreTextFieldKt.TextFieldCursorHandle(this.$manager, composer, 8);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(int i10, TextStyle textStyle, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, boolean z10, boolean z11, l<? super TextLayoutResult, k0> lVar) {
                super(2);
                this.$maxLines = i10;
                this.$textStyle = textStyle;
                this.$scrollerPosition = textFieldScrollerPosition;
                this.$value = textFieldValue;
                this.$visualTransformation = visualTransformation;
                this.$cursorModifier = modifier;
                this.$drawModifier = modifier2;
                this.$onPositionedModifier = modifier3;
                this.$magnifierModifier = modifier4;
                this.$bringIntoViewRequester = bringIntoViewRequester;
                this.$state = textFieldState;
                this.$manager = textFieldSelectionManager;
                this.$showHandleAndMagnifier = z10;
                this.$readOnly = z11;
                this.$onTextLayout = lVar;
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return k0.f35197a;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer, int i10) {
                if ((i10 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                } else {
                    SimpleLayoutKt.SimpleLayout(BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(MaxLinesHeightModifierKt.maxLinesHeight(Modifier.Companion, this.$maxLines, this.$textStyle), this.$scrollerPosition, this.$value, this.$visualTransformation, new CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1(this.$state)).then(this.$cursorModifier).then(this.$drawModifier), this.$textStyle).then(this.$onPositionedModifier).then(this.$magnifierModifier), this.$bringIntoViewRequester), ComposableLambdaKt.composableLambda(composer, 19580180, true, new C00591(this.$manager, this.$state, this.$showHandleAndMagnifier, this.$readOnly, this.$onTextLayout)), composer, 48, 0);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(q<? super p<? super Composer, ? super Integer, k0>, ? super Composer, ? super Integer, k0> qVar, int i10, int i11, TextStyle textStyle, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, boolean z10, boolean z11, l<? super TextLayoutResult, k0> lVar) {
            super(2);
            this.$decorationBox = qVar;
            this.$$dirty1 = i10;
            this.$maxLines = i11;
            this.$textStyle = textStyle;
            this.$scrollerPosition = textFieldScrollerPosition;
            this.$value = textFieldValue;
            this.$visualTransformation = visualTransformation;
            this.$cursorModifier = modifier;
            this.$drawModifier = modifier2;
            this.$onPositionedModifier = modifier3;
            this.$magnifierModifier = modifier4;
            this.$bringIntoViewRequester = bringIntoViewRequester;
            this.$state = textFieldState;
            this.$manager = textFieldSelectionManager;
            this.$showHandleAndMagnifier = z10;
            this.$readOnly = z11;
            this.$onTextLayout = lVar;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                this.$decorationBox.invoke(ComposableLambdaKt.composableLambda(composer, 207445534, true, new AnonymousClass1(this.$maxLines, this.$textStyle, this.$scrollerPosition, this.$value, this.$visualTransformation, this.$cursorModifier, this.$drawModifier, this.$onPositionedModifier, this.$magnifierModifier, this.$bringIntoViewRequester, this.$state, this.$manager, this.$showHandleAndMagnifier, this.$readOnly, this.$onTextLayout)), composer, Integer.valueOf(((this.$$dirty1 >> 9) & 112) | 6));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6, reason: invalid class name */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class AnonymousClass6 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ Brush $cursorBrush;
        final /* synthetic */ q<p<? super Composer, ? super Integer, k0>, Composer, Integer, k0> $decorationBox;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ ImeOptions $imeOptions;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ KeyboardActions $keyboardActions;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<TextLayoutResult, k0> $onTextLayout;
        final /* synthetic */ l<TextFieldValue, k0> $onValueChange;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ boolean $softWrap;
        final /* synthetic */ TextStyle $textStyle;
        final /* synthetic */ TextFieldValue $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass6(TextFieldValue textFieldValue, l<? super TextFieldValue, k0> lVar, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, l<? super TextLayoutResult, k0> lVar2, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z10, int i10, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z11, boolean z12, q<? super p<? super Composer, ? super Integer, k0>, ? super Composer, ? super Integer, k0> qVar, int i11, int i12, int i13) {
            super(2);
            this.$value = textFieldValue;
            this.$onValueChange = lVar;
            this.$modifier = modifier;
            this.$textStyle = textStyle;
            this.$visualTransformation = visualTransformation;
            this.$onTextLayout = lVar2;
            this.$interactionSource = mutableInteractionSource;
            this.$cursorBrush = brush;
            this.$softWrap = z10;
            this.$maxLines = i10;
            this.$imeOptions = imeOptions;
            this.$keyboardActions = keyboardActions;
            this.$enabled = z11;
            this.$readOnly = z12;
            this.$decorationBox = qVar;
            this.$$changed = i11;
            this.$$changed1 = i12;
            this.$$default = i13;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            CoreTextFieldKt.CoreTextField(this.$value, this.$onValueChange, this.$modifier, this.$textStyle, this.$visualTransformation, this.$onTextLayout, this.$interactionSource, this.$cursorBrush, this.$softWrap, this.$maxLines, this.$imeOptions, this.$keyboardActions, this.$enabled, this.$readOnly, this.$decorationBox, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class C08972 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ TextFieldSelectionManager $manager;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08972(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.$modifier = modifier;
            this.$manager = textFieldSelectionManager;
            this.$content = pVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            CoreTextFieldKt.CoreTextFieldRootBox(this.$modifier, this.$manager, this.$content, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$SelectionToolbarAndHandles$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class C08982 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TextFieldSelectionManager $manager;
        final /* synthetic */ boolean $show;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08982(TextFieldSelectionManager textFieldSelectionManager, boolean z10, int i10) {
            super(2);
            this.$manager = textFieldSelectionManager;
            this.$show = z10;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            CoreTextFieldKt.SelectionToolbarAndHandles(this.$manager, this.$show, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoreTextField.kt */
    @f(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1", f = "CoreTextField.kt", l = {947}, m = "invokeSuspend")
    static final class C08991 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ TextDragObserver $observer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08991(TextDragObserver textDragObserver, z8.d<? super C08991> dVar) {
            super(2, dVar);
            this.$observer = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08991 c08991 = new C08991(this.$observer, dVar);
            c08991.L$0 = obj;
            return c08991;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((C08991) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                TextDragObserver textDragObserver = this.$observer;
                this.label = 1;
                if (LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(pointerInputScope, textDragObserver, this) == objE) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class C09003 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TextFieldSelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09003(TextFieldSelectionManager textFieldSelectionManager, int i10) {
            super(2);
            this.$manager = textFieldSelectionManager;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            CoreTextFieldKt.TextFieldCursorHandle(this.$manager, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$previewKeyEventToDeselectOnBack$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoreTextField.kt */
    static final class C09011 extends v implements l<KeyEvent, Boolean> {
        final /* synthetic */ TextFieldSelectionManager $manager;
        final /* synthetic */ TextFieldState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09011(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager) {
            super(1);
            this.$state = textFieldState;
            this.$manager = textFieldSelectionManager;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
            return m666invokeZmokQxo(keyEvent.m2749unboximpl());
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
        public final Boolean m666invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
            boolean z10;
            t.i(keyEvent, "keyEvent");
            if (this.$state.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m671cancelsTextSelectionZmokQxo(keyEvent)) {
                z10 = true;
                TextFieldSelectionManager.m835deselect_kEHs6E$foundation_release$default(this.$manager, null, 1, null);
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x069d  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0719  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0134  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CoreTextField(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.TextFieldValue r43, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.ui.text.input.TextFieldValue, v8.k0> r44, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r45, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r46, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r47, @org.jetbrains.annotations.Nullable h9.l<? super androidx.compose.ui.text.TextLayoutResult, v8.k0> r48, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r49, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Brush r50, boolean r51, int r52, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.ImeOptions r53, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r54, boolean r55, boolean r56, @org.jetbrains.annotations.Nullable h9.q<? super h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r57, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r58, int r59, int r60, int r61) {
        /*
            Method dump skipped, instruction units count: 1845
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, h9.l, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, h9.l, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, h9.q, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, p<? super Composer, ? super Integer, k0> pVar, Composer composer, int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-20551815);
        int i11 = (i10 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK;
        composerStartRestartGroup.startReplaceableGroup(733328855);
        int i12 = i11 >> 3;
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composerStartRestartGroup, (i12 & 112) | (i12 & 14));
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        a<ComposeUiNode> constructor = companion.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifier);
        int i13 = ((((i11 << 3) & 112) << 9) & 7168) | 6;
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
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, Integer.valueOf((i13 >> 3) & 112));
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        if (((i13 >> 9) & 14 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1524757375);
            if (((((i11 >> 6) & 112) | 6) & 81) == 16 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, pVar, composerStartRestartGroup, ((i10 >> 3) & 112) | 8);
            }
            composerStartRestartGroup.endReplaceableGroup();
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C08972(modifier, textFieldSelectionManager, pVar, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager textFieldSelectionManager, boolean z10, Composer composer, int i10) {
        TextLayoutResultProxy layoutResult;
        Composer composerStartRestartGroup = composer.startRestartGroup(626339208);
        if (z10) {
            TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
            TextLayoutResult value = (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) ? null : layoutResult.getValue();
            if (value != null) {
                if (!TextRange.m3329getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().m3510getSelectiond9O1mEE())) {
                    int iOriginalToTransformed = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m3335getStartimpl(textFieldSelectionManager.getValue$foundation_release().m3510getSelectiond9O1mEE()));
                    int iOriginalToTransformed2 = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m3330getEndimpl(textFieldSelectionManager.getValue$foundation_release().m3510getSelectiond9O1mEE()));
                    ResolvedTextDirection bidiRunDirection = value.getBidiRunDirection(iOriginalToTransformed);
                    ResolvedTextDirection bidiRunDirection2 = value.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                    composerStartRestartGroup.startReplaceableGroup(-498396421);
                    TextFieldState state$foundation_release2 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release2 != null && state$foundation_release2.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, composerStartRestartGroup, 518);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldState state$foundation_release3 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release3 != null && state$foundation_release3.getShowSelectionHandleEnd()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, composerStartRestartGroup, 518);
                    }
                }
                TextFieldState state$foundation_release4 = textFieldSelectionManager.getState$foundation_release();
                if (state$foundation_release4 != null) {
                    if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                        state$foundation_release4.setShowFloatingToolbar(false);
                    }
                    if (state$foundation_release4.getHasFocus()) {
                        if (state$foundation_release4.getShowFloatingToolbar()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C08982(textFieldSelectionManager, z10, i10));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextFieldCursorHandle(@NotNull TextFieldSelectionManager manager, @Nullable Composer composer, int i10) {
        t.i(manager, "manager");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1436003720);
        TextFieldState state$foundation_release = manager.getState$foundation_release();
        if (state$foundation_release != null && state$foundation_release.getShowCursorHandle()) {
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(manager);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = manager.cursorDragObserver$foundation_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
            long jM840getCursorPositiontuRUvjQ$foundation_release = manager.m840getCursorPositiontuRUvjQ$foundation_release((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, textDragObserver, new C08991(textDragObserver, null));
            Offset offsetM1356boximpl = Offset.m1356boximpl(jM840getCursorPositiontuRUvjQ$foundation_release);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(offsetM1356boximpl);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(jM840getCursorPositiontuRUvjQ$foundation_release);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m649CursorHandleULxng0E(jM840getCursorPositiontuRUvjQ$foundation_release, SemanticsModifierKt.semantics$default(modifierPointerInput, false, (l) objRememberedValue2, 1, null), null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C09003(manager, i10));
    }

    @Nullable
    public static final Object bringSelectionEndIntoView(@NotNull BringIntoViewRequester bringIntoViewRequester, @NotNull TextFieldValue textFieldValue, @NotNull TextDelegate textDelegate, @NotNull TextLayoutResult textLayoutResult, @NotNull OffsetMapping offsetMapping, @NotNull z8.d<? super k0> dVar) {
        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m3332getMaximpl(textFieldValue.m3510getSelectiond9O1mEE()));
        Object objBringIntoView = bringIntoViewRequester.bringIntoView(iOriginalToTransformed < textLayoutResult.getLayoutInput().getText().length() ? textLayoutResult.getBoundingBox(iOriginalToTransformed) : iOriginalToTransformed != 0 ? textLayoutResult.getBoundingBox(iOriginalToTransformed - 1) : new Rect(0.0f, 0.0f, 1.0f, IntSize.m3832getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null))), dVar);
        return objBringIntoView == a9.d.e() ? objBringIntoView : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyTextInputServiceOnFocusChange(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions) {
        if (textFieldState.getHasFocus()) {
            textFieldState.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, textFieldValue, textFieldState.getProcessor(), imeOptions, textFieldState.getOnValueChange(), textFieldState.getOnImeActionPerformed()));
        } else {
            onBlur(textFieldState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBlur(TextFieldState textFieldState) {
        TextInputSession inputSession = textFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.Companion.onBlur$foundation_release(inputSession, textFieldState.getProcessor(), textFieldState.getOnValueChange());
        }
        textFieldState.setInputSession(null);
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new C09011(textFieldState, textFieldSelectionManager));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState textFieldState, FocusRequester focusRequester, boolean z10) {
        TextInputSession inputSession;
        if (!textFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!z10 || (inputSession = textFieldState.getInputSession()) == null) {
                return;
            }
            inputSession.showSoftwareKeyboard();
        }
    }
}
