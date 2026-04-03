package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextFieldSelectionDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionDelegateKt {
    /* JADX INFO: renamed from: getTextFieldSelection-bb3KNj8, reason: not valid java name */
    public static final long m831getTextFieldSelectionbb3KNj8(@Nullable TextLayoutResult textLayoutResult, int i10, int i11, @Nullable TextRange textRange, boolean z10, @NotNull SelectionAdjustment adjustment) {
        t.i(adjustment, "adjustment");
        if (textLayoutResult == null) {
            return TextRangeKt.TextRange(0, 0);
        }
        long jTextRange = TextRangeKt.TextRange(i10, i11);
        return (textRange == null && t.d(adjustment, SelectionAdjustment.Companion.getCharacter())) ? jTextRange : adjustment.mo768adjustZXO7KMw(textLayoutResult, jTextRange, -1, z10, textRange);
    }
}
