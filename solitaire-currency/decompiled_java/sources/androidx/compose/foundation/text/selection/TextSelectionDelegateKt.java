package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextSelectionDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextSelectionDelegateKt {
    public static final float getHorizontalPosition(@NotNull TextLayoutResult textLayoutResult, int i10, boolean z10, boolean z11) {
        t.i(textLayoutResult, "<this>");
        return textLayoutResult.getHorizontalPosition(i10, textLayoutResult.getBidiRunDirection(((!z10 || z11) && (z10 || !z11)) ? Math.max(i10 + (-1), 0) : i10) == textLayoutResult.getParagraphDirection(i10));
    }

    public static final long getSelectionHandleCoordinates(@NotNull TextLayoutResult textLayoutResult, int i10, boolean z10, boolean z11) {
        t.i(textLayoutResult, "textLayoutResult");
        return OffsetKt.Offset(getHorizontalPosition(textLayoutResult, i10, z10, z11), textLayoutResult.getLineBottom(textLayoutResult.getLineForOffset(i10)));
    }
}
