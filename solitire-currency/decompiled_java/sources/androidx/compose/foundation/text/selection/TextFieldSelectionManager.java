package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldSelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager {

    @Nullable
    private ClipboardManager clipboardManager;

    @NotNull
    private final MutableState currentDragPosition$delegate;

    @Nullable
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;

    @NotNull
    private final MutableState draggingHandle$delegate;

    @NotNull
    private final MutableState editable$delegate;

    @Nullable
    private FocusRequester focusRequester;

    @Nullable
    private HapticFeedback hapticFeedBack;

    @NotNull
    private final MouseSelectionObserver mouseSelectionObserver;

    @NotNull
    private OffsetMapping offsetMapping;

    @NotNull
    private TextFieldValue oldValue;

    @NotNull
    private l<? super TextFieldValue, k0> onValueChange;

    @Nullable
    private TextFieldState state;

    @Nullable
    private TextToolbar textToolbar;

    @NotNull
    private final TextDragObserver touchSelectionObserver;

    @Nullable
    private final UndoManager undoManager;

    @NotNull
    private final MutableState value$delegate;

    @NotNull
    private VisualTransformation visualTransformation;

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldSelectionManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        textFieldSelectionManager.copy$foundation_release(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public final TextFieldValue m834createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j10) {
        return new TextFieldValue(annotatedString, j10, (TextRange) null, 4, (k) null);
    }

    /* JADX INFO: renamed from: deselect-_kEHs6E$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ void m835deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m838deselect_kEHs6E$foundation_release(offset);
    }

    private final Rect getContentRect() {
        float fM1368getYimpl;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        TextFieldState textFieldState = this.state;
        if (textFieldState == null) {
            return Rect.Companion.getZero();
        }
        long jM1383getZeroF1C5BW0 = (textFieldState == null || (layoutCoordinates4 = textFieldState.getLayoutCoordinates()) == null) ? Offset.Companion.m1383getZeroF1C5BW0() : layoutCoordinates4.mo2991localToRootMKHz9U(m841getHandlePositiontuRUvjQ$foundation_release(true));
        TextFieldState textFieldState2 = this.state;
        long jM1383getZeroF1C5BW02 = (textFieldState2 == null || (layoutCoordinates3 = textFieldState2.getLayoutCoordinates()) == null) ? Offset.Companion.m1383getZeroF1C5BW0() : layoutCoordinates3.mo2991localToRootMKHz9U(m841getHandlePositiontuRUvjQ$foundation_release(false));
        TextFieldState textFieldState3 = this.state;
        float fM1368getYimpl2 = 0.0f;
        if (textFieldState3 == null || (layoutCoordinates2 = textFieldState3.getLayoutCoordinates()) == null) {
            fM1368getYimpl = 0.0f;
        } else {
            TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
            fM1368getYimpl = Offset.m1368getYimpl(layoutCoordinates2.mo2991localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(o.n(TextRange.m3335getStartimpl(getValue$foundation_release().m3510getSelectiond9O1mEE()), 0, Math.max(0, getValue$foundation_release().getText().length() - 1)))) == null) ? 0.0f : cursorRect2.getTop())));
        }
        TextFieldState textFieldState4 = this.state;
        if (textFieldState4 != null && (layoutCoordinates = textFieldState4.getLayoutCoordinates()) != null) {
            TextLayoutResultProxy layoutResult2 = textFieldState.getLayoutResult();
            fM1368getYimpl2 = Offset.m1368getYimpl(layoutCoordinates.mo2991localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(o.n(TextRange.m3330getEndimpl(getValue$foundation_release().m3510getSelectiond9O1mEE()), 0, Math.max(0, getValue$foundation_release().getText().length() - 1)))) == null) ? 0.0f : cursorRect.getTop())));
        }
        return new Rect(Math.min(Offset.m1367getXimpl(jM1383getZeroF1C5BW0), Offset.m1367getXimpl(jM1383getZeroF1C5BW02)), Math.min(fM1368getYimpl, fM1368getYimpl2), Math.max(Offset.m1367getXimpl(jM1383getZeroF1C5BW0), Offset.m1367getXimpl(jM1383getZeroF1C5BW02)), Math.max(Offset.m1368getYimpl(jM1383getZeroF1C5BW0), Offset.m1368getYimpl(jM1383getZeroF1C5BW02)) + (Dp.m3673constructorimpl(25) * textFieldState.getTextDelegate().getDensity().getDensity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m836setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    private final void setHandleState(HandleState handleState) {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setHandleState(handleState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelection(TextFieldValue textFieldValue, int i10, int i11, boolean z10, SelectionAdjustment selectionAdjustment) {
        TextLayoutResultProxy layoutResult;
        long jTextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m3335getStartimpl(textFieldValue.m3510getSelectiond9O1mEE())), this.offsetMapping.originalToTransformed(TextRange.m3330getEndimpl(textFieldValue.m3510getSelectiond9O1mEE())));
        TextFieldState textFieldState = this.state;
        long jM831getTextFieldSelectionbb3KNj8 = TextFieldSelectionDelegateKt.m831getTextFieldSelectionbb3KNj8((textFieldState == null || (layoutResult = textFieldState.getLayoutResult()) == null) ? null : layoutResult.getValue(), i10, i11, TextRange.m3329getCollapsedimpl(jTextRange) ? null : TextRange.m3323boximpl(jTextRange), z10, selectionAdjustment);
        long jTextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(TextRange.m3335getStartimpl(jM831getTextFieldSelectionbb3KNj8)), this.offsetMapping.transformedToOriginal(TextRange.m3330getEndimpl(jM831getTextFieldSelectionbb3KNj8)));
        if (TextRange.m3328equalsimpl0(jTextRange2, textFieldValue.m3510getSelectiond9O1mEE())) {
            return;
        }
        HapticFeedback hapticFeedback = this.hapticFeedBack;
        if (hapticFeedback != null) {
            hapticFeedback.mo2138performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2147getTextHandleMove5zf0vsI());
        }
        this.onValueChange.invoke(m834createTextFieldValueFDrldGo(textFieldValue.getAnnotatedString(), jTextRange2));
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        TextFieldState textFieldState3 = this.state;
        if (textFieldState3 == null) {
            return;
        }
        textFieldState3.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
    }

    /* JADX INFO: renamed from: contextMenuOpenAdjustment-k-4lQ0M, reason: not valid java name */
    public final void m837contextMenuOpenAdjustmentk4lQ0M(long j10) {
        TextLayoutResultProxy layoutResult;
        TextFieldState textFieldState = this.state;
        if (textFieldState == null || (layoutResult = textFieldState.getLayoutResult()) == null) {
            return;
        }
        int iM743getOffsetForPosition3MmeM6k$default = TextLayoutResultProxy.m743getOffsetForPosition3MmeM6k$default(layoutResult, j10, false, 2, null);
        if (TextRange.m3326containsimpl(getValue$foundation_release().m3510getSelectiond9O1mEE(), iM743getOffsetForPosition3MmeM6k$default)) {
            return;
        }
        updateSelection(getValue$foundation_release(), iM743getOffsetForPosition3MmeM6k$default, iM743getOffsetForPosition3MmeM6k$default, false, SelectionAdjustment.Companion.getWord());
    }

    public final void copy$foundation_release(boolean z10) {
        if (TextRange.m3329getCollapsedimpl(getValue$foundation_release().m3510getSelectiond9O1mEE())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        if (z10) {
            int iM3332getMaximpl = TextRange.m3332getMaximpl(getValue$foundation_release().m3510getSelectiond9O1mEE());
            this.onValueChange.invoke(m834createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(iM3332getMaximpl, iM3332getMaximpl)));
            setHandleState(HandleState.None);
        }
    }

    @NotNull
    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo709onDownk4lQ0M(long j10) {
                this.this$0.setDraggingHandle(Handle.Cursor);
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.m836setCurrentDragPosition_kEHs6E(Offset.m1356boximpl(SelectionHandlesKt.m780getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m841getHandlePositiontuRUvjQ$foundation_release(true))));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo710onDragk4lQ0M(long j10) {
                TextLayoutResultProxy layoutResult;
                TextLayoutResult value;
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m1372plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j10);
                TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m836setCurrentDragPosition_kEHs6E(Offset.m1356boximpl(Offset.m1372plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                Offset offsetM839getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m839getCurrentDragPosition_m7T9E();
                t.f(offsetM839getCurrentDragPosition_m7T9E);
                int iM3320getOffsetForPositionk4lQ0M = value.m3320getOffsetForPositionk4lQ0M(offsetM839getCurrentDragPosition_m7T9E.m1377unboximpl());
                long jTextRange = TextRangeKt.TextRange(iM3320getOffsetForPositionk4lQ0M, iM3320getOffsetForPositionk4lQ0M);
                if (TextRange.m3328equalsimpl0(jTextRange, textFieldSelectionManager2.getValue$foundation_release().m3510getSelectiond9O1mEE())) {
                    return;
                }
                HapticFeedback hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack();
                if (hapticFeedBack != null) {
                    hapticFeedBack.mo2138performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2147getTextHandleMove5zf0vsI());
                }
                textFieldSelectionManager2.getOnValueChange$foundation_release().invoke(textFieldSelectionManager2.m834createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), jTextRange));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-k-4lQ0M */
            public void mo711onStartk4lQ0M(long j10) {
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragBeginPosition = SelectionHandlesKt.m780getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m841getHandlePositiontuRUvjQ$foundation_release(true));
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m836setCurrentDragPosition_kEHs6E(Offset.m1356boximpl(textFieldSelectionManager2.dragBeginPosition));
                this.this$0.dragTotalDistance = Offset.Companion.m1383getZeroF1C5BW0();
                this.this$0.setDraggingHandle(Handle.Cursor);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m836setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m836setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }
        };
    }

    public final void cut$foundation_release() {
        if (TextRange.m3329getCollapsedimpl(getValue$foundation_release().m3510getSelectiond9O1mEE())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        AnnotatedString annotatedStringPlus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int iM3333getMinimpl = TextRange.m3333getMinimpl(getValue$foundation_release().m3510getSelectiond9O1mEE());
        this.onValueChange.invoke(m834createTextFieldValueFDrldGo(annotatedStringPlus, TextRangeKt.TextRange(iM3333getMinimpl, iM3333getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX INFO: renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m838deselect_kEHs6E$foundation_release(@org.jetbrains.annotations.Nullable androidx.compose.ui.geometry.Offset r9) {
        /*
            r8 = this;
            androidx.compose.ui.text.input.TextFieldValue r0 = r8.getValue$foundation_release()
            long r0 = r0.m3510getSelectiond9O1mEE()
            boolean r0 = androidx.compose.ui.text.TextRange.m3329getCollapsedimpl(r0)
            if (r0 != 0) goto L50
            androidx.compose.foundation.text.TextFieldState r0 = r8.state
            if (r0 == 0) goto L17
            androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
            goto L18
        L17:
            r0 = 0
        L18:
            r1 = r0
            if (r9 == 0) goto L2f
            if (r1 == 0) goto L2f
            androidx.compose.ui.text.input.OffsetMapping r0 = r8.offsetMapping
            long r2 = r9.m1377unboximpl()
            r4 = 0
            r5 = 2
            r6 = 0
            int r1 = androidx.compose.foundation.text.TextLayoutResultProxy.m743getOffsetForPosition3MmeM6k$default(r1, r2, r4, r5, r6)
            int r0 = r0.transformedToOriginal(r1)
            goto L3b
        L2f:
            androidx.compose.ui.text.input.TextFieldValue r0 = r8.getValue$foundation_release()
            long r0 = r0.m3510getSelectiond9O1mEE()
            int r0 = androidx.compose.ui.text.TextRange.m3332getMaximpl(r0)
        L3b:
            androidx.compose.ui.text.input.TextFieldValue r1 = r8.getValue$foundation_release()
            r2 = 0
            long r3 = androidx.compose.ui.text.TextRangeKt.TextRange(r0)
            r5 = 0
            r6 = 5
            r7 = 0
            androidx.compose.ui.text.input.TextFieldValue r0 = androidx.compose.ui.text.input.TextFieldValue.m3505copy3r_uNRQ$default(r1, r2, r3, r5, r6, r7)
            h9.l<? super androidx.compose.ui.text.input.TextFieldValue, v8.k0> r1 = r8.onValueChange
            r1.invoke(r0)
        L50:
            if (r9 == 0) goto L68
            androidx.compose.ui.text.input.TextFieldValue r9 = r8.getValue$foundation_release()
            java.lang.String r9 = r9.getText()
            int r9 = r9.length()
            if (r9 <= 0) goto L62
            r9 = 1
            goto L63
        L62:
            r9 = 0
        L63:
            if (r9 == 0) goto L68
            androidx.compose.foundation.text.HandleState r9 = androidx.compose.foundation.text.HandleState.Cursor
            goto L6a
        L68:
            androidx.compose.foundation.text.HandleState r9 = androidx.compose.foundation.text.HandleState.None
        L6a:
            r8.setHandleState(r9)
            r8.hideSelectionToolbar$foundation_release()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.m838deselect_kEHs6E$foundation_release(androidx.compose.ui.geometry.Offset):void");
    }

    public final void enterSelectionMode$foundation_release() {
        FocusRequester focusRequester;
        TextFieldState textFieldState = this.state;
        boolean z10 = false;
        if (textFieldState != null && !textFieldState.getHasFocus()) {
            z10 = true;
        }
        if (z10 && (focusRequester = this.focusRequester) != null) {
            focusRequester.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setShowFloatingToolbar(true);
        }
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(false);
        }
        setHandleState(HandleState.None);
    }

    @Nullable
    public final ClipboardManager getClipboardManager$foundation_release() {
        return this.clipboardManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* JADX INFO: renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m839getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    /* JADX INFO: renamed from: getCursorPosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m840getCursorPositiontuRUvjQ$foundation_release(@NotNull Density density) {
        t.i(density, "density");
        int iOriginalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m3335getStartimpl(getValue$foundation_release().m3510getSelectiond9O1mEE()));
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
        t.f(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(o.n(iOriginalToTransformed, 0, value.getLayoutInput().getText().length()));
        return OffsetKt.Offset(cursorRect.getLeft() + (density.mo296toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / 2), cursorRect.getBottom());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    /* JADX INFO: renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m841getHandlePositiontuRUvjQ$foundation_release(boolean z10) {
        long jM3510getSelectiond9O1mEE = getValue$foundation_release().m3510getSelectiond9O1mEE();
        int iM3335getStartimpl = z10 ? TextRange.m3335getStartimpl(jM3510getSelectiond9O1mEE) : TextRange.m3330getEndimpl(jM3510getSelectiond9O1mEE);
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState != null ? textFieldState.getLayoutResult() : null;
        t.f(layoutResult);
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult.getValue(), this.offsetMapping.originalToTransformed(iM3335getStartimpl), z10, TextRange.m3334getReversedimpl(getValue$foundation_release().m3510getSelectiond9O1mEE()));
    }

    @Nullable
    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @NotNull
    public final MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    @NotNull
    public final OffsetMapping getOffsetMapping$foundation_release() {
        return this.offsetMapping;
    }

    @NotNull
    public final l<TextFieldValue, k0> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    @Nullable
    public final TextFieldState getState$foundation_release() {
        return this.state;
    }

    @Nullable
    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    @NotNull
    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    @Nullable
    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value$delegate.getValue();
    }

    @NotNull
    public final VisualTransformation getVisualTransformation$foundation_release() {
        return this.visualTransformation;
    }

    @NotNull
    public final TextDragObserver handleDragObserver$foundation_release(final boolean z10) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo709onDownk4lQ0M(long j10) {
                this.this$0.setDraggingHandle(z10 ? Handle.SelectionStart : Handle.SelectionEnd);
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.m836setCurrentDragPosition_kEHs6E(Offset.m1356boximpl(SelectionHandlesKt.m780getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m841getHandlePositiontuRUvjQ$foundation_release(z10))));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo710onDragk4lQ0M(long j10) {
                TextLayoutResultProxy layoutResult;
                TextLayoutResult value;
                int iOriginalToTransformed;
                int iM3320getOffsetForPositionk4lQ0M;
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m1372plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j10);
                TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                    boolean z11 = z10;
                    textFieldSelectionManager2.m836setCurrentDragPosition_kEHs6E(Offset.m1356boximpl(Offset.m1372plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                    if (z11) {
                        Offset offsetM839getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m839getCurrentDragPosition_m7T9E();
                        t.f(offsetM839getCurrentDragPosition_m7T9E);
                        iOriginalToTransformed = value.m3320getOffsetForPositionk4lQ0M(offsetM839getCurrentDragPosition_m7T9E.m1377unboximpl());
                    } else {
                        iOriginalToTransformed = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m3335getStartimpl(textFieldSelectionManager2.getValue$foundation_release().m3510getSelectiond9O1mEE()));
                    }
                    int i10 = iOriginalToTransformed;
                    if (z11) {
                        iM3320getOffsetForPositionk4lQ0M = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m3330getEndimpl(textFieldSelectionManager2.getValue$foundation_release().m3510getSelectiond9O1mEE()));
                    } else {
                        Offset offsetM839getCurrentDragPosition_m7T9E2 = textFieldSelectionManager2.m839getCurrentDragPosition_m7T9E();
                        t.f(offsetM839getCurrentDragPosition_m7T9E2);
                        iM3320getOffsetForPositionk4lQ0M = value.m3320getOffsetForPositionk4lQ0M(offsetM839getCurrentDragPosition_m7T9E2.m1377unboximpl());
                    }
                    textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), i10, iM3320getOffsetForPositionk4lQ0M, z11, SelectionAdjustment.Companion.getCharacter());
                }
                TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
                if (state$foundation_release2 == null) {
                    return;
                }
                state$foundation_release2.setShowFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-k-4lQ0M */
            public void mo711onStartk4lQ0M(long j10) {
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragBeginPosition = SelectionHandlesKt.m780getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m841getHandlePositiontuRUvjQ$foundation_release(z10));
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m836setCurrentDragPosition_kEHs6E(Offset.m1356boximpl(textFieldSelectionManager2.dragBeginPosition));
                this.this$0.dragTotalDistance = Offset.Companion.m1383getZeroF1C5BW0();
                this.this$0.setDraggingHandle(z10 ? Handle.SelectionStart : Handle.SelectionEnd);
                TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release == null) {
                    return;
                }
                state$foundation_release.setShowFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m836setCurrentDragPosition_kEHs6E(null);
                TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release != null) {
                    state$foundation_release.setShowFloatingToolbar(true);
                }
                TextToolbar textToolbar = this.this$0.getTextToolbar();
                if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Hidden) {
                    this.this$0.showSelectionToolbar$foundation_release();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m836setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }
        };
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    public final boolean isTextChanged$foundation_release() {
        return !t.d(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null) {
            return;
        }
        AnnotatedString annotatedStringPlus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int iM3333getMinimpl = TextRange.m3333getMinimpl(getValue$foundation_release().m3510getSelectiond9O1mEE()) + text.length();
        this.onValueChange.invoke(m834createTextFieldValueFDrldGo(annotatedStringPlus, TextRangeKt.TextRange(iM3333getMinimpl, iM3333getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue textFieldValueM834createTextFieldValueFDrldGo = m834createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(textFieldValueM834createTextFieldValueFDrldGo);
        this.oldValue = TextFieldValue.m3505copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, textFieldValueM834createTextFieldValueFDrldGo.m3510getSelectiond9O1mEE(), (TextRange) null, 5, (Object) null);
        TextFieldState textFieldState = this.state;
        if (textFieldState == null) {
            return;
        }
        textFieldState.setShowFloatingToolbar(true);
    }

    public final void setClipboardManager$foundation_release(@Nullable ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final void setEditable(boolean z10) {
        this.editable$delegate.setValue(Boolean.valueOf(z10));
    }

    public final void setFocusRequester(@Nullable FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    public final void setHapticFeedBack(@Nullable HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setOffsetMapping$foundation_release(@NotNull OffsetMapping offsetMapping) {
        t.i(offsetMapping, "<set-?>");
        this.offsetMapping = offsetMapping;
    }

    public final void setOnValueChange$foundation_release(@NotNull l<? super TextFieldValue, k0> lVar) {
        t.i(lVar, "<set-?>");
        this.onValueChange = lVar;
    }

    public final void setState$foundation_release(@Nullable TextFieldState textFieldState) {
        this.state = textFieldState;
    }

    public final void setTextToolbar(@Nullable TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final void setValue$foundation_release(@NotNull TextFieldValue textFieldValue) {
        t.i(textFieldValue, "<set-?>");
        this.value$delegate.setValue(textFieldValue);
    }

    public final void setVisualTransformation$foundation_release(@NotNull VisualTransformation visualTransformation) {
        t.i(visualTransformation, "<set-?>");
        this.visualTransformation = visualTransformation;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void showSelectionToolbar$foundation_release() {
        /*
            r9 = this;
            androidx.compose.ui.text.input.VisualTransformation r0 = r9.visualTransformation
            boolean r0 = r0 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r1 = r1.m3510getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m3329getCollapsedimpl(r1)
            r2 = 0
            if (r1 != 0) goto L1c
            if (r0 != 0) goto L1c
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
            r1.<init>(r9)
            r5 = r1
            goto L1d
        L1c:
            r5 = r2
        L1d:
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r3 = r1.m3510getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m3329getCollapsedimpl(r3)
            if (r1 != 0) goto L3a
            boolean r1 = r9.getEditable()
            if (r1 == 0) goto L3a
            if (r0 != 0) goto L3a
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1 r0 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
            r0.<init>(r9)
            r7 = r0
            goto L3b
        L3a:
            r7 = r2
        L3b:
            boolean r0 = r9.getEditable()
            if (r0 == 0) goto L54
            androidx.compose.ui.platform.ClipboardManager r0 = r9.clipboardManager
            if (r0 == 0) goto L4a
            androidx.compose.ui.text.AnnotatedString r0 = r0.getText()
            goto L4b
        L4a:
            r0 = r2
        L4b:
            if (r0 == 0) goto L54
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1 r0 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
            r0.<init>(r9)
            r6 = r0
            goto L55
        L54:
            r6 = r2
        L55:
            androidx.compose.ui.text.input.TextFieldValue r0 = r9.getValue$foundation_release()
            long r0 = r0.m3510getSelectiond9O1mEE()
            int r0 = androidx.compose.ui.text.TextRange.m3331getLengthimpl(r0)
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            java.lang.String r1 = r1.getText()
            int r1 = r1.length()
            if (r0 == r1) goto L74
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1 r2 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
            r2.<init>(r9)
        L74:
            r8 = r2
            androidx.compose.ui.platform.TextToolbar r3 = r9.textToolbar
            if (r3 == 0) goto L80
            androidx.compose.ui.geometry.Rect r4 = r9.getContentRect()
            r3.showMenu(r4, r5, r6, r7, r8)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar$foundation_release():void");
    }

    public TextFieldSelectionManager(@Nullable UndoManager undoManager) {
        this.undoManager = undoManager;
        this.offsetMapping = OffsetMapping.Companion.getIdentity();
        this.onValueChange = TextFieldSelectionManager$onValueChange$1.INSTANCE;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (k) null), null, 2, null);
        this.visualTransformation = VisualTransformation.Companion.getNone();
        this.editable$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        Offset.Companion companion = Offset.Companion;
        this.dragBeginPosition = companion.m1383getZeroF1C5BW0();
        this.dragTotalDistance = companion.m1383getZeroF1C5BW0();
        this.draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (k) null);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo710onDragk4lQ0M(long j10) {
                TextLayoutResultProxy layoutResult;
                if (this.this$0.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m1372plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j10);
                TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                    textFieldSelectionManager2.m836setCurrentDragPosition_kEHs6E(Offset.m1356boximpl(Offset.m1372plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                    Integer num = textFieldSelectionManager2.dragBeginOffsetInText;
                    int iIntValue = num != null ? num.intValue() : layoutResult.m745getOffsetForPosition3MmeM6k(textFieldSelectionManager2.dragBeginPosition, false);
                    Offset offsetM839getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m839getCurrentDragPosition_m7T9E();
                    t.f(offsetM839getCurrentDragPosition_m7T9E);
                    textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), iIntValue, layoutResult.m745getOffsetForPosition3MmeM6k(offsetM839getCurrentDragPosition_m7T9E.m1377unboximpl(), false), false, SelectionAdjustment.Companion.getWord());
                }
                TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
                if (state$foundation_release2 == null) {
                    return;
                }
                state$foundation_release2.setShowFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-k-4lQ0M */
            public void mo711onStartk4lQ0M(long j10) {
                TextLayoutResultProxy layoutResult;
                TextFieldState state$foundation_release;
                TextLayoutResultProxy layoutResult2;
                TextLayoutResultProxy layoutResult3;
                if (this.this$0.getDraggingHandle() != null) {
                    return;
                }
                this.this$0.setDraggingHandle(Handle.SelectionEnd);
                this.this$0.hideSelectionToolbar$foundation_release();
                TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
                if (!((state$foundation_release2 == null || (layoutResult3 = state$foundation_release2.getLayoutResult()) == null || !layoutResult3.m746isPositionOnTextk4lQ0M(j10)) ? false : true) && (state$foundation_release = this.this$0.getState$foundation_release()) != null && (layoutResult2 = state$foundation_release.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                    int iTransformedToOriginal = textFieldSelectionManager.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.getLineEnd$default(layoutResult2, layoutResult2.getLineForVerticalPosition(Offset.m1368getYimpl(j10)), false, 2, null));
                    HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                    if (hapticFeedBack != null) {
                        hapticFeedBack.mo2138performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2147getTextHandleMove5zf0vsI());
                    }
                    TextFieldValue textFieldValueM834createTextFieldValueFDrldGo = textFieldSelectionManager.m834createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(iTransformedToOriginal, iTransformedToOriginal));
                    textFieldSelectionManager.enterSelectionMode$foundation_release();
                    textFieldSelectionManager.getOnValueChange$foundation_release().invoke(textFieldValueM834createTextFieldValueFDrldGo);
                    return;
                }
                if (this.this$0.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                this.this$0.enterSelectionMode$foundation_release();
                TextFieldState state$foundation_release3 = this.this$0.getState$foundation_release();
                if (state$foundation_release3 != null && (layoutResult = state$foundation_release3.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                    int iM743getOffsetForPosition3MmeM6k$default = TextLayoutResultProxy.m743getOffsetForPosition3MmeM6k$default(layoutResult, j10, false, 2, null);
                    textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), iM743getOffsetForPosition3MmeM6k$default, iM743getOffsetForPosition3MmeM6k$default, false, SelectionAdjustment.Companion.getWord());
                    textFieldSelectionManager2.dragBeginOffsetInText = Integer.valueOf(iM743getOffsetForPosition3MmeM6k$default);
                }
                this.this$0.dragBeginPosition = j10;
                TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
                textFieldSelectionManager3.m836setCurrentDragPosition_kEHs6E(Offset.m1356boximpl(textFieldSelectionManager3.dragBeginPosition));
                this.this$0.dragTotalDistance = Offset.Companion.m1383getZeroF1C5BW0();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m836setCurrentDragPosition_kEHs6E(null);
                TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release != null) {
                    state$foundation_release.setShowFloatingToolbar(true);
                }
                TextToolbar textToolbar = this.this$0.getTextToolbar();
                if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Hidden) {
                    this.this$0.showSelectionToolbar$foundation_release();
                }
                this.this$0.dragBeginOffsetInText = null;
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo709onDownk4lQ0M(long j10) {
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onDrag-3MmeM6k */
            public boolean mo712onDrag3MmeM6k(long j10, @NotNull SelectionAdjustment adjustment) {
                TextFieldState state$foundation_release;
                TextLayoutResultProxy layoutResult;
                t.i(adjustment, "adjustment");
                if ((this.this$0.getValue$foundation_release().getText().length() == 0) || (state$foundation_release = this.this$0.getState$foundation_release()) == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                int iM745getOffsetForPosition3MmeM6k = layoutResult.m745getOffsetForPosition3MmeM6k(j10, false);
                TextFieldValue value$foundation_release = textFieldSelectionManager.getValue$foundation_release();
                Integer num = textFieldSelectionManager.dragBeginOffsetInText;
                t.f(num);
                textFieldSelectionManager.updateSelection(value$foundation_release, num.intValue(), iM745getOffsetForPosition3MmeM6k, false, adjustment);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onExtend-k-4lQ0M */
            public boolean mo713onExtendk4lQ0M(long j10) {
                TextLayoutResultProxy layoutResult;
                TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m3335getStartimpl(textFieldSelectionManager.getValue$foundation_release().m3510getSelectiond9O1mEE())), TextLayoutResultProxy.m743getOffsetForPosition3MmeM6k$default(layoutResult, j10, false, 2, null), false, SelectionAdjustment.Companion.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo714onExtendDragk4lQ0M(long j10) {
                TextFieldState state$foundation_release;
                TextLayoutResultProxy layoutResult;
                if ((this.this$0.getValue$foundation_release().getText().length() == 0) || (state$foundation_release = this.this$0.getState$foundation_release()) == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m3335getStartimpl(textFieldSelectionManager.getValue$foundation_release().m3510getSelectiond9O1mEE())), layoutResult.m745getOffsetForPosition3MmeM6k(j10, false), false, SelectionAdjustment.Companion.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onStart-3MmeM6k */
            public boolean mo715onStart3MmeM6k(long j10, @NotNull SelectionAdjustment adjustment) {
                TextLayoutResultProxy layoutResult;
                t.i(adjustment, "adjustment");
                FocusRequester focusRequester = this.this$0.getFocusRequester();
                if (focusRequester != null) {
                    focusRequester.requestFocus();
                }
                this.this$0.dragBeginPosition = j10;
                TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return false;
                }
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragBeginOffsetInText = Integer.valueOf(TextLayoutResultProxy.m743getOffsetForPosition3MmeM6k$default(layoutResult, j10, false, 2, null));
                int iM743getOffsetForPosition3MmeM6k$default = TextLayoutResultProxy.m743getOffsetForPosition3MmeM6k$default(layoutResult, textFieldSelectionManager.dragBeginPosition, false, 2, null);
                textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), iM743getOffsetForPosition3MmeM6k$default, iM743getOffsetForPosition3MmeM6k$default, false, adjustment);
                return true;
            }
        };
    }

    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager, int i10, k kVar) {
        this((i10 & 1) != 0 ? null : undoManager);
    }
}
