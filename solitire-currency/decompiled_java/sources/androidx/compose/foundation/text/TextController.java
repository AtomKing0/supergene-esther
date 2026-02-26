package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.b;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import h9.l;
import h9.p;
import j9.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;
import v8.u;
import v8.y;
import z8.d;

/* JADX INFO: compiled from: CoreText.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextController implements RememberObserver {

    @NotNull
    private final Modifier coreModifiers;
    public TextDragObserver longPressDragObserver;

    @NotNull
    private final MeasurePolicy measurePolicy;

    @NotNull
    private Modifier selectionModifiers;

    @Nullable
    private SelectionRegistrar selectionRegistrar;

    @NotNull
    private Modifier semanticsModifier;

    @NotNull
    private final TextState state;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextController$createSemanticsModifierFor$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoreText.kt */
    static final class AnonymousClass1 extends v implements l<SemanticsPropertyReceiver, k0> {
        final /* synthetic */ AnnotatedString $text;
        final /* synthetic */ TextController this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextController$createSemanticsModifierFor$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CoreText.kt */
        static final class C00611 extends v implements l<List<TextLayoutResult>, Boolean> {
            final /* synthetic */ TextController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00611(TextController textController) {
                super(1);
                this.this$0 = textController;
            }

            @Override // h9.l
            @NotNull
            public final Boolean invoke(@NotNull List<TextLayoutResult> it) {
                boolean z10;
                t.i(it, "it");
                if (this.this$0.getState().getLayoutResult() != null) {
                    TextLayoutResult layoutResult = this.this$0.getState().getLayoutResult();
                    t.f(layoutResult);
                    it.add(layoutResult);
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnnotatedString annotatedString, TextController textController) {
            super(1);
            this.$text = annotatedString;
            this.this$0 = textController;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            SemanticsPropertiesKt.setText(semantics, this.$text);
            SemanticsPropertiesKt.getTextLayoutResult$default(semantics, null, new C00611(this.this$0), 1, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextController$drawTextAndSelectionBehind$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoreText.kt */
    static final class C09081 extends v implements l<DrawScope, k0> {
        C09081() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DrawScope drawBehind) {
            Map<Long, Selection> subselections;
            t.i(drawBehind, "$this$drawBehind");
            TextLayoutResult layoutResult = TextController.this.getState().getLayoutResult();
            if (layoutResult != null) {
                TextController textController = TextController.this;
                textController.getState().getDrawScopeInvalidation();
                SelectionRegistrar selectionRegistrar = textController.selectionRegistrar;
                Selection selection = (selectionRegistrar == null || (subselections = selectionRegistrar.getSubselections()) == null) ? null : subselections.get(Long.valueOf(textController.getState().getSelectableId()));
                if (selection != null) {
                    int offset = !selection.getHandlesCrossed() ? selection.getStart().getOffset() : selection.getEnd().getOffset();
                    int offset2 = !selection.getHandlesCrossed() ? selection.getEnd().getOffset() : selection.getStart().getOffset();
                    if (offset != offset2) {
                        b.G(drawBehind, layoutResult.getMultiParagraph().getPathForRange(offset, offset2), textController.getState().m750getSelectionBackgroundColor0d7_KjU(), 0.0f, null, null, 0, 60, null);
                    }
                }
                TextDelegate.Companion.paint(drawBehind.getDrawContext().getCanvas(), layoutResult);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextController$update$2, reason: invalid class name */
    /* JADX INFO: compiled from: CoreText.kt */
    @f(c = "androidx.compose.foundation.text.TextController$update$2", f = "CoreText.kt", l = {191}, m = "invokeSuspend")
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, d<? super k0>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass2 anonymousClass2 = TextController.this.new AnonymousClass2(dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass2) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                TextDragObserver longPressDragObserver = TextController.this.getLongPressDragObserver();
                this.label = 1;
                if (LongPressTextDragObserverKt.detectDragGesturesAfterLongPressWithObserver(pointerInputScope, longPressDragObserver, this) == objE) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextController$update$3, reason: invalid class name */
    /* JADX INFO: compiled from: CoreText.kt */
    @f(c = "androidx.compose.foundation.text.TextController$update$3", f = "CoreText.kt", l = {282}, m = "invokeSuspend")
    static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, d<? super k0>, Object> {
        final /* synthetic */ TextController$update$mouseSelectionObserver$1 $mouseSelectionObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(TextController$update$mouseSelectionObserver$1 textController$update$mouseSelectionObserver$1, d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$mouseSelectionObserver = textController$update$mouseSelectionObserver$1;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$mouseSelectionObserver, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass3) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                TextController$update$mouseSelectionObserver$1 textController$update$mouseSelectionObserver$1 = this.$mouseSelectionObserver;
                this.label = 1;
                if (TextSelectionMouseDetectorKt.mouseSelectionDetector(pointerInputScope, textController$update$mouseSelectionObserver$1, this) == objE) {
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

    public TextController(@NotNull TextState state) {
        t.i(state, "state");
        this.state = state;
        this.measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.TextController$measurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                return IntSize.m3832getHeightimpl(TextDelegate.m716layoutNN6EwU$default(this.this$0.getState().getTextDelegate(), ConstraintsKt.Constraints(0, i10, 0, Integer.MAX_VALUE), intrinsicMeasureScope.getLayoutDirection(), null, 4, null).m3321getSizeYbymL2g());
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                this.this$0.getState().getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                return this.this$0.getState().getTextDelegate().getMaxIntrinsicWidth();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo8measure3p2s80s(@NotNull MeasureScope measure, @NotNull List<? extends Measurable> measurables, long j10) {
                int i10;
                s sVar;
                SelectionRegistrar selectionRegistrar;
                t.i(measure, "$this$measure");
                t.i(measurables, "measurables");
                TextLayoutResult layoutResult = this.this$0.getState().getLayoutResult();
                TextLayoutResult textLayoutResultM719layoutNN6EwU = this.this$0.getState().getTextDelegate().m719layoutNN6EwU(j10, measure.getLayoutDirection(), layoutResult);
                if (!t.d(layoutResult, textLayoutResultM719layoutNN6EwU)) {
                    this.this$0.getState().getOnTextLayout().invoke(textLayoutResultM719layoutNN6EwU);
                    if (layoutResult != null) {
                        TextController textController = this.this$0;
                        if (!t.d(layoutResult.getLayoutInput().getText(), textLayoutResultM719layoutNN6EwU.getLayoutInput().getText()) && (selectionRegistrar = textController.selectionRegistrar) != null) {
                            selectionRegistrar.notifySelectableChange(textController.getState().getSelectableId());
                        }
                    }
                }
                this.this$0.getState().setLayoutResult(textLayoutResultM719layoutNN6EwU);
                if (!(measurables.size() >= textLayoutResultM719layoutNN6EwU.getPlaceholderRects().size())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                List<Rect> placeholderRects = textLayoutResultM719layoutNN6EwU.getPlaceholderRects();
                ArrayList arrayList = new ArrayList(placeholderRects.size());
                int size = placeholderRects.size();
                int i11 = 0;
                while (i11 < size) {
                    Rect rect = placeholderRects.get(i11);
                    if (rect != null) {
                        i10 = size;
                        sVar = new s(measurables.get(i11).mo2987measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getWidth()), 0, (int) Math.floor(rect.getHeight()), 5, null)), IntOffset.m3782boximpl(IntOffsetKt.IntOffset(c.c(rect.getLeft()), c.c(rect.getTop()))));
                    } else {
                        i10 = size;
                        sVar = null;
                    }
                    if (sVar != null) {
                        arrayList.add(sVar);
                    }
                    i11++;
                    size = i10;
                }
                return measure.layout(IntSize.m3833getWidthimpl(textLayoutResultM719layoutNN6EwU.m3321getSizeYbymL2g()), IntSize.m3832getHeightimpl(textLayoutResultM719layoutNN6EwU.m3321getSizeYbymL2g()), r0.j(y.a(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(c.c(textLayoutResultM719layoutNN6EwU.getFirstBaseline()))), y.a(AlignmentLineKt.getLastBaseline(), Integer.valueOf(c.c(textLayoutResultM719layoutNN6EwU.getLastBaseline())))), new TextController$measurePolicy$1$measure$2(arrayList));
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                return IntSize.m3832getHeightimpl(TextDelegate.m716layoutNN6EwU$default(this.this$0.getState().getTextDelegate(), ConstraintsKt.Constraints(0, i10, 0, Integer.MAX_VALUE), intrinsicMeasureScope.getLayoutDirection(), null, 4, null).m3321getSizeYbymL2g());
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                this.this$0.getState().getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                return this.this$0.getState().getTextDelegate().getMinIntrinsicWidth();
            }
        };
        Modifier.Companion companion = Modifier.Companion;
        this.coreModifiers = OnGloballyPositionedModifierKt.onGloballyPositioned(drawTextAndSelectionBehind(companion), new TextController$coreModifiers$1(this));
        this.semanticsModifier = createSemanticsModifierFor(state.getTextDelegate().getText());
        this.selectionModifiers = companion;
    }

    private final Modifier createSemanticsModifierFor(AnnotatedString annotatedString) {
        return SemanticsModifierKt.semantics$default(Modifier.Companion, false, new AnonymousClass1(annotatedString, this), 1, null);
    }

    @Stable
    private final Modifier drawTextAndSelectionBehind(Modifier modifier) {
        return DrawModifierKt.drawBehind(GraphicsLayerModifierKt.m1735graphicsLayerpANQ8Wg$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 65535, null), new C09081());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: outOfBoundary-0a9Yr6o, reason: not valid java name */
    public final boolean m708outOfBoundary0a9Yr6o(long j10, long j11) {
        TextLayoutResult layoutResult = this.state.getLayoutResult();
        if (layoutResult == null) {
            return false;
        }
        int length = layoutResult.getLayoutInput().getText().getText().length();
        int iM3320getOffsetForPositionk4lQ0M = layoutResult.m3320getOffsetForPositionk4lQ0M(j10);
        int iM3320getOffsetForPositionk4lQ0M2 = layoutResult.m3320getOffsetForPositionk4lQ0M(j11);
        int i10 = length - 1;
        return (iM3320getOffsetForPositionk4lQ0M >= i10 && iM3320getOffsetForPositionk4lQ0M2 >= i10) || (iM3320getOffsetForPositionk4lQ0M < 0 && iM3320getOffsetForPositionk4lQ0M2 < 0);
    }

    @NotNull
    public final TextDragObserver getLongPressDragObserver() {
        TextDragObserver textDragObserver = this.longPressDragObserver;
        if (textDragObserver != null) {
            return textDragObserver;
        }
        t.A("longPressDragObserver");
        return null;
    }

    @NotNull
    public final MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @NotNull
    public final Modifier getModifiers() {
        return this.coreModifiers.then(this.semanticsModifier).then(this.selectionModifiers);
    }

    @NotNull
    public final Modifier getSemanticsModifier$foundation_release() {
        return this.semanticsModifier;
    }

    @NotNull
    public final TextState getState() {
        return this.state;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        SelectionRegistrar selectionRegistrar;
        Selectable selectable = this.state.getSelectable();
        if (selectable == null || (selectionRegistrar = this.selectionRegistrar) == null) {
            return;
        }
        selectionRegistrar.unsubscribe(selectable);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        SelectionRegistrar selectionRegistrar;
        Selectable selectable = this.state.getSelectable();
        if (selectable == null || (selectionRegistrar = this.selectionRegistrar) == null) {
            return;
        }
        selectionRegistrar.unsubscribe(selectable);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        SelectionRegistrar selectionRegistrar = this.selectionRegistrar;
        if (selectionRegistrar != null) {
            TextState textState = this.state;
            textState.setSelectable(selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(textState.getSelectableId(), new TextController$onRemembered$1$1(this), new TextController$onRemembered$1$2(this))));
        }
    }

    public final void setLongPressDragObserver(@NotNull TextDragObserver textDragObserver) {
        t.i(textDragObserver, "<set-?>");
        this.longPressDragObserver = textDragObserver;
    }

    public final void setTextDelegate(@NotNull TextDelegate textDelegate) {
        t.i(textDelegate, "textDelegate");
        if (this.state.getTextDelegate() == textDelegate) {
            return;
        }
        this.state.setTextDelegate(textDelegate);
        this.semanticsModifier = createSemanticsModifierFor(this.state.getTextDelegate().getText());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.text.TextController$update$mouseSelectionObserver$1, java.lang.Object] */
    public final void update(@Nullable final SelectionRegistrar selectionRegistrar) {
        Modifier modifierPointerHoverIcon$default;
        this.selectionRegistrar = selectionRegistrar;
        if (selectionRegistrar == null) {
            modifierPointerHoverIcon$default = Modifier.Companion;
        } else if (TouchMode_androidKt.isInTouchMode()) {
            setLongPressDragObserver(new TextDragObserver() { // from class: androidx.compose.foundation.text.TextController.update.1
                private long dragTotalDistance;
                private long lastPosition;

                {
                    Offset.Companion companion = Offset.Companion;
                    this.lastPosition = companion.m1383getZeroF1C5BW0();
                    this.dragTotalDistance = companion.m1383getZeroF1C5BW0();
                }

                public final long getDragTotalDistance() {
                    return this.dragTotalDistance;
                }

                public final long getLastPosition() {
                    return this.lastPosition;
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onCancel() {
                    if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                        selectionRegistrar.notifySelectionUpdateEnd();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* JADX INFO: renamed from: onDrag-k-4lQ0M, reason: not valid java name */
                public void mo710onDragk4lQ0M(long j10) {
                    LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        TextController textController = TextController.this;
                        if (layoutCoordinates.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId())) {
                            long jM1372plusMKHz9U = Offset.m1372plusMKHz9U(this.dragTotalDistance, j10);
                            this.dragTotalDistance = jM1372plusMKHz9U;
                            long jM1372plusMKHz9U2 = Offset.m1372plusMKHz9U(this.lastPosition, jM1372plusMKHz9U);
                            if (textController.m708outOfBoundary0a9Yr6o(this.lastPosition, jM1372plusMKHz9U2) || !selectionRegistrar2.mo828notifySelectionUpdate5iVPX68(layoutCoordinates, jM1372plusMKHz9U2, this.lastPosition, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
                                return;
                            }
                            this.lastPosition = jM1372plusMKHz9U2;
                            this.dragTotalDistance = Offset.Companion.m1383getZeroF1C5BW0();
                        }
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* JADX INFO: renamed from: onStart-k-4lQ0M, reason: not valid java name */
                public void mo711onStartk4lQ0M(long j10) {
                    LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        TextController textController = TextController.this;
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        if (!layoutCoordinates.isAttached()) {
                            return;
                        }
                        if (textController.m708outOfBoundary0a9Yr6o(j10, j10)) {
                            selectionRegistrar2.notifySelectionUpdateSelectAll(textController.getState().getSelectableId());
                        } else {
                            selectionRegistrar2.mo829notifySelectionUpdateStartd4ec7I(layoutCoordinates, j10, SelectionAdjustment.Companion.getWord());
                        }
                        this.lastPosition = j10;
                    }
                    if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                        this.dragTotalDistance = Offset.Companion.m1383getZeroF1C5BW0();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onStop() {
                    if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                        selectionRegistrar.notifySelectionUpdateEnd();
                    }
                }

                public final void setDragTotalDistance(long j10) {
                    this.dragTotalDistance = j10;
                }

                public final void setLastPosition(long j10) {
                    this.lastPosition = j10;
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onUp() {
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* JADX INFO: renamed from: onDown-k-4lQ0M, reason: not valid java name */
                public void mo709onDownk4lQ0M(long j10) {
                }
            });
            modifierPointerHoverIcon$default = SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, getLongPressDragObserver(), new AnonymousClass2(null));
        } else {
            ?? r02 = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.TextController$update$mouseSelectionObserver$1
                private long lastPosition = Offset.Companion.m1383getZeroF1C5BW0();

                public final long getLastPosition() {
                    return this.lastPosition;
                }

                @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                /* JADX INFO: renamed from: onDrag-3MmeM6k, reason: not valid java name */
                public boolean mo712onDrag3MmeM6k(long j10, @NotNull SelectionAdjustment adjustment) {
                    t.i(adjustment, "adjustment");
                    LayoutCoordinates layoutCoordinates = this.this$0.getState().getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        TextController textController = this.this$0;
                        if (!layoutCoordinates.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId())) {
                            return false;
                        }
                        if (selectionRegistrar2.mo828notifySelectionUpdate5iVPX68(layoutCoordinates, j10, this.lastPosition, false, adjustment)) {
                            this.lastPosition = j10;
                        }
                    }
                    return true;
                }

                @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                /* JADX INFO: renamed from: onExtend-k-4lQ0M, reason: not valid java name */
                public boolean mo713onExtendk4lQ0M(long j10) {
                    LayoutCoordinates layoutCoordinates = this.this$0.getState().getLayoutCoordinates();
                    if (layoutCoordinates == null) {
                        return false;
                    }
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    TextController textController = this.this$0;
                    if (!layoutCoordinates.isAttached()) {
                        return false;
                    }
                    if (selectionRegistrar2.mo828notifySelectionUpdate5iVPX68(layoutCoordinates, j10, this.lastPosition, false, SelectionAdjustment.Companion.getNone())) {
                        this.lastPosition = j10;
                    }
                    return SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId());
                }

                @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
                public boolean mo714onExtendDragk4lQ0M(long j10) {
                    LayoutCoordinates layoutCoordinates = this.this$0.getState().getLayoutCoordinates();
                    if (layoutCoordinates == null) {
                        return true;
                    }
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    TextController textController = this.this$0;
                    if (!layoutCoordinates.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId())) {
                        return false;
                    }
                    if (!selectionRegistrar2.mo828notifySelectionUpdate5iVPX68(layoutCoordinates, j10, this.lastPosition, false, SelectionAdjustment.Companion.getNone())) {
                        return true;
                    }
                    this.lastPosition = j10;
                    return true;
                }

                @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                /* JADX INFO: renamed from: onStart-3MmeM6k, reason: not valid java name */
                public boolean mo715onStart3MmeM6k(long j10, @NotNull SelectionAdjustment adjustment) {
                    t.i(adjustment, "adjustment");
                    LayoutCoordinates layoutCoordinates = this.this$0.getState().getLayoutCoordinates();
                    if (layoutCoordinates == null) {
                        return false;
                    }
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    TextController textController = this.this$0;
                    if (!layoutCoordinates.isAttached()) {
                        return false;
                    }
                    selectionRegistrar2.mo829notifySelectionUpdateStartd4ec7I(layoutCoordinates, j10, adjustment);
                    this.lastPosition = j10;
                    return SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId());
                }

                public final void setLastPosition(long j10) {
                    this.lastPosition = j10;
                }
            };
            modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, (Object) r02, new AnonymousClass3(r02, null)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
        }
        this.selectionModifiers = modifierPointerHoverIcon$default;
    }
}
