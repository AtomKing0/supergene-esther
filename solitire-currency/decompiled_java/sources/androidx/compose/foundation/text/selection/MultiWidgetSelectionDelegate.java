package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.s;

/* JADX INFO: compiled from: MultiWidgetSelectionDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MultiWidgetSelectionDelegate implements Selectable {

    @NotNull
    private final h9.a<LayoutCoordinates> coordinatesCallback;

    @NotNull
    private final h9.a<TextLayoutResult> layoutResultCallback;
    private final long selectableId;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiWidgetSelectionDelegate(long j10, @NotNull h9.a<? extends LayoutCoordinates> coordinatesCallback, @NotNull h9.a<TextLayoutResult> layoutResultCallback) {
        t.i(coordinatesCallback, "coordinatesCallback");
        t.i(layoutResultCallback, "layoutResultCallback");
        this.selectableId = j10;
        this.coordinatesCallback = coordinatesCallback;
        this.layoutResultCallback = layoutResultCallback;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @NotNull
    public Rect getBoundingBox(int i10) {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return Rect.Companion.getZero();
        }
        int length = textLayoutResultInvoke.getLayoutInput().getText().length();
        return length < 1 ? Rect.Companion.getZero() : textLayoutResultInvoke.getBoundingBox(o.n(i10, 0, length - 1));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* JADX INFO: renamed from: getHandlePosition-dBAh8RU, reason: not valid java name */
    public long mo759getHandlePositiondBAh8RU(@NotNull Selection selection, boolean z10) {
        t.i(selection, "selection");
        if ((z10 && selection.getStart().getSelectableId() != getSelectableId()) || (!z10 && selection.getEnd().getSelectableId() != getSelectableId())) {
            return Offset.Companion.m1383getZeroF1C5BW0();
        }
        if (getLayoutCoordinates() == null) {
            return Offset.Companion.m1383getZeroF1C5BW0();
        }
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return Offset.Companion.m1383getZeroF1C5BW0();
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(textLayoutResultInvoke, (z10 ? selection.getStart() : selection.getEnd()).getOffset(), z10, selection.getHandlesCrossed());
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @Nullable
    public LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinatesInvoke = this.coordinatesCallback.invoke();
        if (layoutCoordinatesInvoke == null || !layoutCoordinatesInvoke.isAttached()) {
            return null;
        }
        return layoutCoordinatesInvoke;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* JADX INFO: renamed from: getRangeOfLineContaining--jx7JFs, reason: not valid java name */
    public long mo760getRangeOfLineContainingjx7JFs(int i10) {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return TextRange.Companion.m3340getZerod9O1mEE();
        }
        int length = textLayoutResultInvoke.getLayoutInput().getText().length();
        if (length < 1) {
            return TextRange.Companion.m3340getZerod9O1mEE();
        }
        int lineForOffset = textLayoutResultInvoke.getLineForOffset(o.n(i10, 0, length - 1));
        return TextRangeKt.TextRange(textLayoutResultInvoke.getLineStart(lineForOffset), textLayoutResultInvoke.getLineEnd(lineForOffset, true));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @Nullable
    public Selection getSelectAllSelection() {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return null;
        }
        return MultiWidgetSelectionDelegateKt.m763getAssembledSelectionInfovJH6DeI(TextRangeKt.TextRange(0, textLayoutResultInvoke.getLayoutInput().getText().length()), false, getSelectableId(), textLayoutResultInvoke);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long getSelectableId() {
        return this.selectableId;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @NotNull
    public AnnotatedString getText() {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        return textLayoutResultInvoke == null ? new AnnotatedString("", null, null, 6, null) : textLayoutResultInvoke.getLayoutInput().getText();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @NotNull
    /* JADX INFO: renamed from: updateSelection-qCDeeow, reason: not valid java name */
    public s<Selection, Boolean> mo761updateSelectionqCDeeow(long j10, long j11, @Nullable Offset offset, boolean z10, @NotNull LayoutCoordinates containerLayoutCoordinates, @NotNull SelectionAdjustment adjustment, @Nullable Selection selection) {
        t.i(containerLayoutCoordinates, "containerLayoutCoordinates");
        t.i(adjustment, "adjustment");
        if (!(selection == null || (getSelectableId() == selection.getStart().getSelectableId() && getSelectableId() == selection.getEnd().getSelectableId()))) {
            throw new IllegalArgumentException("The given previousSelection doesn't belong to this selectable.".toString());
        }
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return new s<>(null, Boolean.FALSE);
        }
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return new s<>(null, Boolean.FALSE);
        }
        long jMo2990localPositionOfR5De75A = containerLayoutCoordinates.mo2990localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m1383getZeroF1C5BW0());
        return MultiWidgetSelectionDelegateKt.m765getTextSelectionInfoyM0VcXU(textLayoutResultInvoke, Offset.m1371minusMKHz9U(j10, jMo2990localPositionOfR5De75A), Offset.m1371minusMKHz9U(j11, jMo2990localPositionOfR5De75A), offset != null ? Offset.m1356boximpl(Offset.m1371minusMKHz9U(offset.m1377unboximpl(), jMo2990localPositionOfR5De75A)) : null, getSelectableId(), adjustment, selection, z10);
    }
}
