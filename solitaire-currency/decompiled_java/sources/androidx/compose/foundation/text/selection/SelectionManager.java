package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.platform.y1;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import h9.l;
import h9.p;
import h9.q;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: SelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionManager {

    @NotNull
    private final MutableState<Selection> _selection;

    @Nullable
    private ClipboardManager clipboardManager;

    @Nullable
    private LayoutCoordinates containerLayoutCoordinates;

    @NotNull
    private final MutableState currentDragPosition$delegate;

    @NotNull
    private final MutableState dragBeginPosition$delegate;

    @NotNull
    private final MutableState dragTotalDistance$delegate;

    @NotNull
    private final MutableState draggingHandle$delegate;

    @NotNull
    private final MutableState endHandlePosition$delegate;

    @NotNull
    private FocusRequester focusRequester;

    @Nullable
    private HapticFeedback hapticFeedBack;

    @NotNull
    private final MutableState hasFocus$delegate;

    @NotNull
    private l<? super Selection, k0> onSelectionChange;

    @Nullable
    private Offset previousPosition;

    @NotNull
    private final SelectionRegistrarImpl selectionRegistrar;

    @NotNull
    private final MutableState startHandlePosition$delegate;

    @Nullable
    private TextToolbar textToolbar;
    private boolean touchMode;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionManager.kt */
    static final class AnonymousClass1 extends v implements l<Long, k0> {
        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Long l10) {
            invoke(l10.longValue());
            return k0.f35197a;
        }

        public final void invoke(long j10) {
            Selection.AnchorInfo end;
            Selection.AnchorInfo start;
            Selection selection = SelectionManager.this.getSelection();
            if (!((selection == null || (start = selection.getStart()) == null || j10 != start.getSelectableId()) ? false : true)) {
                Selection selection2 = SelectionManager.this.getSelection();
                if (!((selection2 == null || (end = selection2.getEnd()) == null || j10 != end.getSelectableId()) ? false : true)) {
                    return;
                }
            }
            SelectionManager.this.updateHandleOffsets();
            SelectionManager.this.updateSelectionToolbarPosition();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$2, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionManager.kt */
    static final class AnonymousClass2 extends v implements q<LayoutCoordinates, Offset, SelectionAdjustment, k0> {
        AnonymousClass2() {
            super(3);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(LayoutCoordinates layoutCoordinates, Offset offset, SelectionAdjustment selectionAdjustment) {
            m812invoked4ec7I(layoutCoordinates, offset.m1377unboximpl(), selectionAdjustment);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final void m812invoked4ec7I(@NotNull LayoutCoordinates layoutCoordinates, long j10, @NotNull SelectionAdjustment selectionMode) {
            t.i(layoutCoordinates, "layoutCoordinates");
            t.i(selectionMode, "selectionMode");
            Offset offsetM797convertToContainerCoordinatesQ7Q5hAU = SelectionManager.this.m797convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j10);
            if (offsetM797convertToContainerCoordinatesQ7Q5hAU != null) {
                SelectionManager.this.m803startSelection9KIMszo(offsetM797convertToContainerCoordinatesQ7Q5hAU.m1377unboximpl(), false, selectionMode);
                SelectionManager.this.getFocusRequester().requestFocus();
                SelectionManager.this.hideSelectionToolbar$foundation_release();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$3, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionManager.kt */
    static final class AnonymousClass3 extends v implements l<Long, k0> {
        AnonymousClass3() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Long l10) {
            invoke(l10.longValue());
            return k0.f35197a;
        }

        public final void invoke(long j10) {
            SelectionManager selectionManager = SelectionManager.this;
            s<Selection, Map<Long, Selection>> sVarSelectAll$foundation_release = selectionManager.selectAll$foundation_release(j10, selectionManager.getSelection());
            Selection selectionA = sVarSelectAll$foundation_release.a();
            Map<Long, Selection> mapB = sVarSelectAll$foundation_release.b();
            if (!t.d(selectionA, SelectionManager.this.getSelection())) {
                SelectionManager.this.selectionRegistrar.setSubselections(mapB);
                SelectionManager.this.getOnSelectionChange().invoke(selectionA);
            }
            SelectionManager.this.getFocusRequester().requestFocus();
            SelectionManager.this.hideSelectionToolbar$foundation_release();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$4, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionManager.kt */
    static final class AnonymousClass4 extends v implements h9.s<LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean> {
        AnonymousClass4() {
            super(5);
        }

        @Override // h9.s
        public /* bridge */ /* synthetic */ Boolean invoke(LayoutCoordinates layoutCoordinates, Offset offset, Offset offset2, Boolean bool, SelectionAdjustment selectionAdjustment) {
            return m813invoke5iVPX68(layoutCoordinates, offset.m1377unboximpl(), offset2.m1377unboximpl(), bool.booleanValue(), selectionAdjustment);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-5iVPX68, reason: not valid java name */
        public final Boolean m813invoke5iVPX68(@NotNull LayoutCoordinates layoutCoordinates, long j10, long j11, boolean z10, @NotNull SelectionAdjustment selectionMode) {
            t.i(layoutCoordinates, "layoutCoordinates");
            t.i(selectionMode, "selectionMode");
            return Boolean.valueOf(SelectionManager.this.m811updateSelectionRHHTvR4$foundation_release(SelectionManager.this.m797convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j10), SelectionManager.this.m797convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j11), z10, selectionMode));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$5, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionManager.kt */
    static final class AnonymousClass5 extends v implements h9.a<k0> {
        AnonymousClass5() {
            super(0);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            SelectionManager.this.showSelectionToolbar$foundation_release();
            SelectionManager.this.setDraggingHandle(null);
            SelectionManager.this.m798setCurrentDragPosition_kEHs6E(null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$6, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionManager.kt */
    static final class AnonymousClass6 extends v implements l<Long, k0> {
        AnonymousClass6() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Long l10) {
            invoke(l10.longValue());
            return k0.f35197a;
        }

        public final void invoke(long j10) {
            if (SelectionManager.this.selectionRegistrar.getSubselections().containsKey(Long.valueOf(j10))) {
                SelectionManager.this.onRelease();
                SelectionManager.this.setSelection(null);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$7, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionManager.kt */
    static final class AnonymousClass7 extends v implements l<Long, k0> {
        AnonymousClass7() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Long l10) {
            invoke(l10.longValue());
            return k0.f35197a;
        }

        public final void invoke(long j10) {
            Selection.AnchorInfo end;
            Selection.AnchorInfo start;
            Selection selection = SelectionManager.this.getSelection();
            if (!((selection == null || (start = selection.getStart()) == null || j10 != start.getSelectableId()) ? false : true)) {
                Selection selection2 = SelectionManager.this.getSelection();
                if (!((selection2 == null || (end = selection2.getEnd()) == null || j10 != end.getSelectableId()) ? false : true)) {
                    return;
                }
            }
            SelectionManager.this.m802setStartHandlePosition_kEHs6E(null);
            SelectionManager.this.m801setEndHandlePosition_kEHs6E(null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelectionManager.kt */
    @f(c = "androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2", f = "SelectionManager.kt", l = {619}, m = "invokeSuspend")
    static final class C09132 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, d<? super k0>, Object> {
        final /* synthetic */ l<Offset, k0> $onTap;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SelectionManager.kt */
        @f(c = "androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2$1", f = "SelectionManager.kt", l = {IronSourceError.ERROR_DO_BN_LOAD_DURING_SHOW}, m = "invokeSuspend")
        static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ PointerInputScope $$this$forEachGesture;
            final /* synthetic */ l<Offset, k0> $onTap;
            int label;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SelectionManager.kt */
            @f(c = "androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2$1$1", f = "SelectionManager.kt", l = {621}, m = "invokeSuspend")
            static final class C00751 extends k implements p<AwaitPointerEventScope, d<? super k0>, Object> {
                final /* synthetic */ l<Offset, k0> $onTap;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00751(l<? super Offset, k0> lVar, d<? super C00751> dVar) {
                    super(2, dVar);
                    this.$onTap = lVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                    C00751 c00751 = new C00751(this.$onTap, dVar);
                    c00751.L$0 = obj;
                    return c00751;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable d<? super k0> dVar) {
                    return ((C00751) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        this.label = 1;
                        obj = TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope, this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        u.b(obj);
                    }
                    PointerInputChange pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange != null) {
                        this.$onTap.invoke(Offset.m1356boximpl(pointerInputChange.m2873getPositionF1C5BW0()));
                    }
                    return k0.f35197a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(PointerInputScope pointerInputScope, l<? super Offset, k0> lVar, d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$$this$forEachGesture = pointerInputScope;
                this.$onTap = lVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new AnonymousClass1(this.$$this$forEachGesture, this.$onTap, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    PointerInputScope pointerInputScope = this.$$this$forEachGesture;
                    C00751 c00751 = new C00751(this.$onTap, null);
                    this.label = 1;
                    if (pointerInputScope.awaitPointerEventScope(c00751, this) == objE) {
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
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09132(l<? super Offset, k0> lVar, d<? super C09132> dVar) {
            super(2, dVar);
            this.$onTap = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C09132 c09132 = new C09132(this.$onTap, dVar);
            c09132.L$0 = obj;
            return c09132;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((C09132) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1((PointerInputScope) this.L$0, this.$onTap, null);
                this.label = 1;
                if (p0.f(anonymousClass1, this) == objE) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelectionManager.kt */
    @f(c = "androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1", f = "SelectionManager.kt", l = {LevelPlayAdError.ERROR_CODE_SHOW_WHILE_SHOW}, m = "invokeSuspend")
    static final class C09151 extends kotlin.coroutines.jvm.internal.l implements p<PointerInputScope, d<? super k0>, Object> {
        final /* synthetic */ h9.a<k0> $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SelectionManager.kt */
        static final class C00761 extends v implements l<Offset, k0> {
            final /* synthetic */ h9.a<k0> $block;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00761(h9.a<k0> aVar) {
                super(1);
                this.$block = aVar;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Offset offset) {
                m815invokek4lQ0M(offset.m1377unboximpl());
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m815invokek4lQ0M(long j10) {
                this.$block.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09151(h9.a<k0> aVar, d<? super C09151> dVar) {
            super(2, dVar);
            this.$block = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            C09151 c09151 = SelectionManager.this.new C09151(this.$block, dVar);
            c09151.L$0 = obj;
            return c09151;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable d<? super k0> dVar) {
            return ((C09151) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                SelectionManager selectionManager = SelectionManager.this;
                C00761 c00761 = new C00761(this.$block);
                this.label = 1;
                if (selectionManager.detectNonConsumingTap(pointerInputScope, c00761, this) == objE) {
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

    public SelectionManager(@NotNull SelectionRegistrarImpl selectionRegistrar) {
        t.i(selectionRegistrar, "selectionRegistrar");
        this.selectionRegistrar = selectionRegistrar;
        this._selection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.touchMode = true;
        this.onSelectionChange = SelectionManager$onSelectionChange$1.INSTANCE;
        this.focusRequester = new FocusRequester();
        this.hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        Offset.Companion companion = Offset.Companion;
        this.dragBeginPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1356boximpl(companion.m1383getZeroF1C5BW0()), null, 2, null);
        this.dragTotalDistance$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1356boximpl(companion.m1383getZeroF1C5BW0()), null, 2, null);
        this.startHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.endHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        selectionRegistrar.setOnPositionChangeCallback$foundation_release(new AnonymousClass1());
        selectionRegistrar.setOnSelectionUpdateStartCallback$foundation_release(new AnonymousClass2());
        selectionRegistrar.setOnSelectionUpdateSelectAll$foundation_release(new AnonymousClass3());
        selectionRegistrar.setOnSelectionUpdateCallback$foundation_release(new AnonymousClass4());
        selectionRegistrar.setOnSelectionUpdateEndCallback$foundation_release(new AnonymousClass5());
        selectionRegistrar.setOnSelectableChangeCallback$foundation_release(new AnonymousClass6());
        selectionRegistrar.setAfterSelectableUnsubscribe$foundation_release(new AnonymousClass7());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: convertToContainerCoordinates-Q7Q5hAU, reason: not valid java name */
    public final Offset m797convertToContainerCoordinatesQ7Q5hAU(LayoutCoordinates layoutCoordinates, long j10) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return null;
        }
        return Offset.m1356boximpl(requireContainerCoordinates$foundation_release().mo2990localPositionOfR5De75A(layoutCoordinates, j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectNonConsumingTap(PointerInputScope pointerInputScope, l<? super Offset, k0> lVar, d<? super k0> dVar) {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new C09132(lVar, null), dVar);
        return objForEachGesture == a9.d.e() ? objForEachGesture : k0.f35197a;
    }

    private final Rect getContentRect() {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        Selection selection = getSelection();
        if (selection == null) {
            return Rect.Companion.getZero();
        }
        Selectable anchorSelectable$foundation_release = getAnchorSelectable$foundation_release(selection.getStart());
        Selectable anchorSelectable$foundation_release2 = getAnchorSelectable$foundation_release(selection.getEnd());
        if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
            return Rect.Companion.getZero();
        }
        if (anchorSelectable$foundation_release2 == null || (layoutCoordinates2 = anchorSelectable$foundation_release2.getLayoutCoordinates()) == null) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates layoutCoordinates3 = this.containerLayoutCoordinates;
        if (layoutCoordinates3 == null || !layoutCoordinates3.isAttached()) {
            return Rect.Companion.getZero();
        }
        long jMo2990localPositionOfR5De75A = layoutCoordinates3.mo2990localPositionOfR5De75A(layoutCoordinates, anchorSelectable$foundation_release.mo759getHandlePositiondBAh8RU(selection, true));
        long jMo2990localPositionOfR5De75A2 = layoutCoordinates3.mo2990localPositionOfR5De75A(layoutCoordinates2, anchorSelectable$foundation_release2.mo759getHandlePositiondBAh8RU(selection, false));
        long jMo2991localToRootMKHz9U = layoutCoordinates3.mo2991localToRootMKHz9U(jMo2990localPositionOfR5De75A);
        long jMo2991localToRootMKHz9U2 = layoutCoordinates3.mo2991localToRootMKHz9U(jMo2990localPositionOfR5De75A2);
        return new Rect(Math.min(Offset.m1367getXimpl(jMo2991localToRootMKHz9U), Offset.m1367getXimpl(jMo2991localToRootMKHz9U2)), Math.min(Offset.m1368getYimpl(layoutCoordinates3.mo2991localToRootMKHz9U(layoutCoordinates3.mo2990localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release.getBoundingBox(selection.getStart().getOffset()).getTop())))), Offset.m1368getYimpl(layoutCoordinates3.mo2991localToRootMKHz9U(layoutCoordinates3.mo2990localPositionOfR5De75A(layoutCoordinates2, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release2.getBoundingBox(selection.getEnd().getOffset()).getTop()))))), Math.max(Offset.m1367getXimpl(jMo2991localToRootMKHz9U), Offset.m1367getXimpl(jMo2991localToRootMKHz9U2)), Math.max(Offset.m1368getYimpl(jMo2991localToRootMKHz9U), Offset.m1368getYimpl(jMo2991localToRootMKHz9U2)) + ((float) (((double) SelectionHandlesKt.getHandleHeight()) * 4.0d)));
    }

    private final boolean getShouldShowMagnifier() {
        return getDraggingHandle() != null;
    }

    private final Modifier onClearSelectionRequested(Modifier modifier, h9.a<k0> aVar) {
        return getHasFocus() ? SuspendingPointerInputFilterKt.pointerInput(modifier, k0.f35197a, new C09151(aVar, null)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m798setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setDragBeginPosition-k-4lQ0M, reason: not valid java name */
    public final void m799setDragBeginPositionk4lQ0M(long j10) {
        this.dragBeginPosition$delegate.setValue(Offset.m1356boximpl(j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setDragTotalDistance-k-4lQ0M, reason: not valid java name */
    public final void m800setDragTotalDistancek4lQ0M(long j10) {
        this.dragTotalDistance$delegate.setValue(Offset.m1356boximpl(j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setEndHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m801setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setStartHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m802setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startSelection-9KIMszo, reason: not valid java name */
    public final void m803startSelection9KIMszo(long j10, boolean z10, SelectionAdjustment selectionAdjustment) {
        m810updateSelection3R_tFg$foundation_release(j10, j10, null, z10, selectionAdjustment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHandleOffsets() {
        Selection.AnchorInfo end;
        Selection.AnchorInfo start;
        Selection selection = getSelection();
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        Selectable anchorSelectable$foundation_release = (selection == null || (start = selection.getStart()) == null) ? null : getAnchorSelectable$foundation_release(start);
        Selectable anchorSelectable$foundation_release2 = (selection == null || (end = selection.getEnd()) == null) ? null : getAnchorSelectable$foundation_release(end);
        LayoutCoordinates layoutCoordinates2 = anchorSelectable$foundation_release != null ? anchorSelectable$foundation_release.getLayoutCoordinates() : null;
        LayoutCoordinates layoutCoordinates3 = anchorSelectable$foundation_release2 != null ? anchorSelectable$foundation_release2.getLayoutCoordinates() : null;
        if (selection == null || layoutCoordinates == null || !layoutCoordinates.isAttached() || layoutCoordinates2 == null || layoutCoordinates3 == null) {
            m802setStartHandlePosition_kEHs6E(null);
            m801setEndHandlePosition_kEHs6E(null);
            return;
        }
        long jMo2990localPositionOfR5De75A = layoutCoordinates.mo2990localPositionOfR5De75A(layoutCoordinates2, anchorSelectable$foundation_release.mo759getHandlePositiondBAh8RU(selection, true));
        long jMo2990localPositionOfR5De75A2 = layoutCoordinates.mo2990localPositionOfR5De75A(layoutCoordinates3, anchorSelectable$foundation_release2.mo759getHandlePositiondBAh8RU(selection, false));
        Rect rectVisibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates);
        m802setStartHandlePosition_kEHs6E(SelectionManagerKt.m817containsInclusiveUv8p0NA(rectVisibleBounds, jMo2990localPositionOfR5De75A) ? Offset.m1356boximpl(jMo2990localPositionOfR5De75A) : null);
        m801setEndHandlePosition_kEHs6E(SelectionManagerKt.m817containsInclusiveUv8p0NA(rectVisibleBounds, jMo2990localPositionOfR5De75A2) ? Offset.m1356boximpl(jMo2990localPositionOfR5De75A2) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionToolbarPosition() {
        if (getHasFocus()) {
            TextToolbar textToolbar = this.textToolbar;
            if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Shown) {
                showSelectionToolbar$foundation_release();
            }
        }
    }

    /* JADX INFO: renamed from: contextMenuOpenAdjustment-k-4lQ0M, reason: not valid java name */
    public final void m804contextMenuOpenAdjustmentk4lQ0M(long j10) {
        Selection selection = getSelection();
        if (selection != null ? TextRange.m3329getCollapsedimpl(selection.m767toTextRanged9O1mEE()) : true) {
            m803startSelection9KIMszo(j10, true, SelectionAdjustment.Companion.getWord());
        }
    }

    public final void copy$foundation_release() {
        ClipboardManager clipboardManager;
        AnnotatedString selectedText$foundation_release = getSelectedText$foundation_release();
        if (selectedText$foundation_release == null || (clipboardManager = this.clipboardManager) == null) {
            return;
        }
        clipboardManager.setText(selectedText$foundation_release);
    }

    @Nullable
    public final Selectable getAnchorSelectable$foundation_release(@NotNull Selection.AnchorInfo anchor) {
        t.i(anchor, "anchor");
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(anchor.getSelectableId()));
    }

    @Nullable
    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Nullable
    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* JADX INFO: renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m805getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getDragBeginPosition-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m806getDragBeginPositionF1C5BW0$foundation_release() {
        return ((Offset) this.dragBeginPosition$delegate.getValue()).m1377unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getDragTotalDistance-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m807getDragTotalDistanceF1C5BW0$foundation_release() {
        return ((Offset) this.dragTotalDistance$delegate.getValue()).m1377unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* JADX INFO: renamed from: getEndHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m808getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition$delegate.getValue();
    }

    @NotNull
    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    @Nullable
    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final Modifier getModifier() {
        Modifier modifierSelectionMagnifier = Modifier.Companion;
        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(modifierSelectionMagnifier, new SelectionManager$modifier$1(this)), new SelectionManager$modifier$2(this)), this.focusRequester), new SelectionManager$modifier$3(this)), false, null, 3, null), new SelectionManager$modifier$4(this));
        if (getShouldShowMagnifier()) {
            modifierSelectionMagnifier = SelectionManager_androidKt.selectionMagnifier(modifierSelectionMagnifier, this);
        }
        return modifierOnKeyEvent.then(modifierSelectionMagnifier);
    }

    @NotNull
    public final l<Selection, k0> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    @Nullable
    public final AnnotatedString getSelectedText$foundation_release() {
        AnnotatedString annotatedStringPlus;
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        Selection selection = getSelection();
        AnnotatedString annotatedString = null;
        if (selection == null) {
            return null;
        }
        int size = listSort.size();
        for (int i10 = 0; i10 < size; i10++) {
            Selectable selectable = listSort.get(i10);
            if (selectable.getSelectableId() == selection.getStart().getSelectableId() || selectable.getSelectableId() == selection.getEnd().getSelectableId() || annotatedString != null) {
                AnnotatedString currentSelectedText = SelectionManagerKt.getCurrentSelectedText(selectable, selection);
                if (annotatedString != null && (annotatedStringPlus = annotatedString.plus(currentSelectedText)) != null) {
                    currentSelectedText = annotatedStringPlus;
                }
                if ((selectable.getSelectableId() == selection.getEnd().getSelectableId() && !selection.getHandlesCrossed()) || (selectable.getSelectableId() == selection.getStart().getSelectableId() && selection.getHandlesCrossed())) {
                    return currentSelectedText;
                }
                annotatedString = currentSelectedText;
            }
        }
        return annotatedString;
    }

    @Nullable
    public final Selection getSelection() {
        return this._selection.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* JADX INFO: renamed from: getStartHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m809getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition$delegate.getValue();
    }

    @Nullable
    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final boolean getTouchMode() {
        return this.touchMode;
    }

    @NotNull
    public final TextDragObserver handleDragObserver(final boolean z10) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.SelectionManager.handleDragObserver.1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                SelectionManager.this.showSelectionToolbar$foundation_release();
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m798setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo709onDownk4lQ0M(long j10) {
                LayoutCoordinates layoutCoordinates;
                Selection selection = SelectionManager.this.getSelection();
                if (selection == null) {
                    return;
                }
                Selectable anchorSelectable$foundation_release = SelectionManager.this.getAnchorSelectable$foundation_release(z10 ? selection.getStart() : selection.getEnd());
                if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
                    return;
                }
                long jM780getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m780getAdjustedCoordinatesk4lQ0M(anchorSelectable$foundation_release.mo759getHandlePositiondBAh8RU(selection, z10));
                SelectionManager selectionManager = SelectionManager.this;
                selectionManager.m798setCurrentDragPosition_kEHs6E(Offset.m1356boximpl(selectionManager.requireContainerCoordinates$foundation_release().mo2990localPositionOfR5De75A(layoutCoordinates, jM780getAdjustedCoordinatesk4lQ0M)));
                SelectionManager.this.setDraggingHandle(z10 ? Handle.SelectionStart : Handle.SelectionEnd);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo710onDragk4lQ0M(long j10) {
                SelectionManager selectionManager = SelectionManager.this;
                selectionManager.m800setDragTotalDistancek4lQ0M(Offset.m1372plusMKHz9U(selectionManager.m807getDragTotalDistanceF1C5BW0$foundation_release(), j10));
                long jM1372plusMKHz9U = Offset.m1372plusMKHz9U(SelectionManager.this.m806getDragBeginPositionF1C5BW0$foundation_release(), SelectionManager.this.m807getDragTotalDistanceF1C5BW0$foundation_release());
                if (SelectionManager.this.m811updateSelectionRHHTvR4$foundation_release(Offset.m1356boximpl(jM1372plusMKHz9U), Offset.m1356boximpl(SelectionManager.this.m806getDragBeginPositionF1C5BW0$foundation_release()), z10, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
                    SelectionManager.this.m799setDragBeginPositionk4lQ0M(jM1372plusMKHz9U);
                    SelectionManager.this.m800setDragTotalDistancek4lQ0M(Offset.Companion.m1383getZeroF1C5BW0());
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-k-4lQ0M */
            public void mo711onStartk4lQ0M(long j10) {
                LayoutCoordinates layoutCoordinates;
                long jMo759getHandlePositiondBAh8RU;
                SelectionManager.this.hideSelectionToolbar$foundation_release();
                Selection selection = SelectionManager.this.getSelection();
                t.f(selection);
                Selectable selectable = SelectionManager.this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getStart().getSelectableId()));
                Selectable selectable2 = SelectionManager.this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getEnd().getSelectableId()));
                if (z10) {
                    layoutCoordinates = selectable != null ? selectable.getLayoutCoordinates() : null;
                    t.f(layoutCoordinates);
                } else {
                    layoutCoordinates = selectable2 != null ? selectable2.getLayoutCoordinates() : null;
                    t.f(layoutCoordinates);
                }
                if (z10) {
                    t.f(selectable);
                    jMo759getHandlePositiondBAh8RU = selectable.mo759getHandlePositiondBAh8RU(selection, true);
                } else {
                    t.f(selectable2);
                    jMo759getHandlePositiondBAh8RU = selectable2.mo759getHandlePositiondBAh8RU(selection, false);
                }
                long jM780getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m780getAdjustedCoordinatesk4lQ0M(jMo759getHandlePositiondBAh8RU);
                SelectionManager selectionManager = SelectionManager.this;
                selectionManager.m799setDragBeginPositionk4lQ0M(selectionManager.requireContainerCoordinates$foundation_release().mo2990localPositionOfR5De75A(layoutCoordinates, jM780getAdjustedCoordinatesk4lQ0M));
                SelectionManager.this.m800setDragTotalDistancek4lQ0M(Offset.Companion.m1383getZeroF1C5BW0());
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                SelectionManager.this.showSelectionToolbar$foundation_release();
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m798setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m798setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        if (getHasFocus()) {
            TextToolbar textToolbar2 = this.textToolbar;
            if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
                return;
            }
            textToolbar.hide();
        }
    }

    public final void onRelease() {
        this.selectionRegistrar.setSubselections(r0.g());
        hideSelectionToolbar$foundation_release();
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo2138performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2147getTextHandleMove5zf0vsI());
            }
        }
    }

    @NotNull
    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (!(layoutCoordinates != null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (layoutCoordinates.isAttached()) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @NotNull
    public final s<Selection, Map<Long, Selection>> selectAll$foundation_release(long j10, @Nullable Selection selection) {
        HapticFeedback hapticFeedback;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = listSort.size();
        Selection selectionMerge = null;
        for (int i10 = 0; i10 < size; i10++) {
            Selectable selectable = listSort.get(i10);
            Selection selectAllSelection = selectable.getSelectableId() == j10 ? selectable.getSelectAllSelection() : null;
            if (selectAllSelection != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selectAllSelection);
            }
            selectionMerge = SelectionManagerKt.merge(selectionMerge, selectAllSelection);
        }
        if (!t.d(selectionMerge, selection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo2138performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2147getTextHandleMove5zf0vsI());
        }
        return new s<>(selectionMerge, linkedHashMap);
    }

    public final void setClipboardManager(@Nullable ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final void setContainerLayoutCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.containerLayoutCoordinates = layoutCoordinates;
        if (!getHasFocus() || getSelection() == null) {
            return;
        }
        Offset offsetM1356boximpl = layoutCoordinates != null ? Offset.m1356boximpl(LayoutCoordinatesKt.positionInWindow(layoutCoordinates)) : null;
        if (t.d(this.previousPosition, offsetM1356boximpl)) {
            return;
        }
        this.previousPosition = offsetM1356boximpl;
        updateHandleOffsets();
        updateSelectionToolbarPosition();
    }

    public final void setFocusRequester(@NotNull FocusRequester focusRequester) {
        t.i(focusRequester, "<set-?>");
        this.focusRequester = focusRequester;
    }

    public final void setHapticFeedBack(@Nullable HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setHasFocus(boolean z10) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z10));
    }

    public final void setOnSelectionChange(@NotNull l<? super Selection, k0> lVar) {
        t.i(lVar, "<set-?>");
        this.onSelectionChange = lVar;
    }

    public final void setSelection(@Nullable Selection selection) {
        this._selection.setValue(selection);
        if (selection != null) {
            updateHandleOffsets();
        }
    }

    public final void setTextToolbar(@Nullable TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final void setTouchMode(boolean z10) {
        this.touchMode = z10;
    }

    public final void showSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        if (!getHasFocus() || getSelection() == null || (textToolbar = this.textToolbar) == null) {
            return;
        }
        y1.a(textToolbar, getContentRect(), new SelectionManager$showSelectionToolbar$1$1(this), null, null, null, 28, null);
    }

    /* JADX INFO: renamed from: updateSelection-3R_-tFg$foundation_release, reason: not valid java name */
    public final boolean m810updateSelection3R_tFg$foundation_release(long j10, long j11, @Nullable Offset offset, boolean z10, @NotNull SelectionAdjustment adjustment) {
        t.i(adjustment, "adjustment");
        setDraggingHandle(z10 ? Handle.SelectionStart : Handle.SelectionEnd);
        m798setCurrentDragPosition_kEHs6E(z10 ? Offset.m1356boximpl(j10) : Offset.m1356boximpl(j11));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = listSort.size();
        Selection selectionMerge = null;
        int i10 = 0;
        boolean z11 = false;
        while (i10 < size) {
            Selectable selectable = listSort.get(i10);
            int i11 = i10;
            Selection selection = selectionMerge;
            s<Selection, Boolean> sVarMo761updateSelectionqCDeeow = selectable.mo761updateSelectionqCDeeow(j10, j11, offset, z10, requireContainerCoordinates$foundation_release(), adjustment, this.selectionRegistrar.getSubselections().get(Long.valueOf(selectable.getSelectableId())));
            Selection selectionA = sVarMo761updateSelectionqCDeeow.a();
            z11 = z11 || sVarMo761updateSelectionqCDeeow.b().booleanValue();
            if (selectionA != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selectionA);
            }
            selectionMerge = SelectionManagerKt.merge(selection, selectionA);
            i10 = i11 + 1;
        }
        Selection selection2 = selectionMerge;
        if (!t.d(selection2, getSelection())) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo2138performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2147getTextHandleMove5zf0vsI());
            }
            this.selectionRegistrar.setSubselections(linkedHashMap);
            this.onSelectionChange.invoke(selection2);
        }
        return z11;
    }

    /* JADX INFO: renamed from: updateSelection-RHHTvR4$foundation_release, reason: not valid java name */
    public final boolean m811updateSelectionRHHTvR4$foundation_release(@Nullable Offset offset, @Nullable Offset offset2, boolean z10, @NotNull SelectionAdjustment adjustment) {
        Selection selection;
        Offset offsetM797convertToContainerCoordinatesQ7Q5hAU;
        t.i(adjustment, "adjustment");
        if (offset == null || (selection = getSelection()) == null) {
            return false;
        }
        Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(z10 ? selection.getEnd().getSelectableId() : selection.getStart().getSelectableId()));
        if (selectable == null) {
            offsetM797convertToContainerCoordinatesQ7Q5hAU = null;
        } else {
            LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
            t.f(layoutCoordinates);
            offsetM797convertToContainerCoordinatesQ7Q5hAU = m797convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, SelectionHandlesKt.m780getAdjustedCoordinatesk4lQ0M(selectable.mo759getHandlePositiondBAh8RU(selection, !z10)));
        }
        if (offsetM797convertToContainerCoordinatesQ7Q5hAU == null) {
            return false;
        }
        long jM1377unboximpl = offsetM797convertToContainerCoordinatesQ7Q5hAU.m1377unboximpl();
        long jM1377unboximpl2 = z10 ? offset.m1377unboximpl() : jM1377unboximpl;
        if (!z10) {
            jM1377unboximpl = offset.m1377unboximpl();
        }
        return m810updateSelection3R_tFg$foundation_release(jM1377unboximpl2, jM1377unboximpl, offset2, z10, adjustment);
    }
}
