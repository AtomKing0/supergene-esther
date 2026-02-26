package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;

/* JADX INFO: compiled from: MultiWidgetSelectionDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MultiWidgetSelectionDelegateKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAssembledSelectionInfo-vJH6DeI, reason: not valid java name */
    public static final Selection m763getAssembledSelectionInfovJH6DeI(long j10, boolean z10, long j11, TextLayoutResult textLayoutResult) {
        return new Selection(new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(TextRange.m3335getStartimpl(j10)), TextRange.m3335getStartimpl(j10), j11), new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(Math.max(TextRange.m3330getEndimpl(j10) - 1, 0)), TextRange.m3330getEndimpl(j10), j11), z10);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-0AR0LA0, reason: not valid java name */
    public static final int m764getOffsetForPosition0AR0LA0(@NotNull TextLayoutResult textLayoutResult, @NotNull Rect bounds, long j10) {
        t.i(textLayoutResult, "textLayoutResult");
        t.i(bounds, "bounds");
        int length = textLayoutResult.getLayoutInput().getText().length();
        if (bounds.m1393containsk4lQ0M(j10)) {
            return o.n(textLayoutResult.m3320getOffsetForPositionk4lQ0M(j10), 0, length);
        }
        if (SelectionMode.Vertical.mo826compare3MmeM6k$foundation_release(j10, bounds) < 0) {
            return 0;
        }
        return length;
    }

    @NotNull
    /* JADX INFO: renamed from: getTextSelectionInfo-yM0VcXU, reason: not valid java name */
    public static final s<Selection, Boolean> m765getTextSelectionInfoyM0VcXU(@NotNull TextLayoutResult textLayoutResult, long j10, long j11, @Nullable Offset offset, long j12, @NotNull SelectionAdjustment adjustment, @Nullable Selection selection, boolean z10) {
        t.i(textLayoutResult, "textLayoutResult");
        t.i(adjustment, "adjustment");
        Rect rect = new Rect(0.0f, 0.0f, IntSize.m3833getWidthimpl(textLayoutResult.m3321getSizeYbymL2g()), IntSize.m3832getHeightimpl(textLayoutResult.m3321getSizeYbymL2g()));
        if (!SelectionMode.Vertical.m827isSelected2x9bVx0$foundation_release(rect, j10, j11)) {
            return new s<>(null, Boolean.FALSE);
        }
        int iM764getOffsetForPosition0AR0LA0 = m764getOffsetForPosition0AR0LA0(textLayoutResult, rect, j10);
        int iM764getOffsetForPosition0AR0LA02 = m764getOffsetForPosition0AR0LA0(textLayoutResult, rect, j11);
        int iM764getOffsetForPosition0AR0LA03 = offset != null ? m764getOffsetForPosition0AR0LA0(textLayoutResult, rect, offset.m1377unboximpl()) : -1;
        long jMo768adjustZXO7KMw = adjustment.mo768adjustZXO7KMw(textLayoutResult, TextRangeKt.TextRange(iM764getOffsetForPosition0AR0LA0, iM764getOffsetForPosition0AR0LA02), iM764getOffsetForPosition0AR0LA03, z10, selection != null ? TextRange.m3323boximpl(selection.m767toTextRanged9O1mEE()) : null);
        Selection selectionM763getAssembledSelectionInfovJH6DeI = m763getAssembledSelectionInfovJH6DeI(jMo768adjustZXO7KMw, TextRange.m3334getReversedimpl(jMo768adjustZXO7KMw), j12, textLayoutResult);
        boolean z11 = true;
        boolean z12 = !t.d(selectionM763getAssembledSelectionInfovJH6DeI, selection);
        if (!(!z10 ? iM764getOffsetForPosition0AR0LA02 == iM764getOffsetForPosition0AR0LA03 : iM764getOffsetForPosition0AR0LA0 == iM764getOffsetForPosition0AR0LA03) && !z12) {
            z11 = false;
        }
        return new s<>(selectionM763getAssembledSelectionInfovJH6DeI, Boolean.valueOf(z11));
    }
}
