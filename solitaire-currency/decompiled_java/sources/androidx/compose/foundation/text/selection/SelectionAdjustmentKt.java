package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRangeKt;

/* JADX INFO: compiled from: SelectionAdjustment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionAdjustmentKt {
    public static final long ensureAtLeastOneChar(int i10, int i11, boolean z10, boolean z11) {
        return i11 == 0 ? TextRangeKt.TextRange(i10, i10) : i10 == 0 ? z10 ? TextRangeKt.TextRange(1, 0) : TextRangeKt.TextRange(0, 1) : i10 == i11 ? z10 ? TextRangeKt.TextRange(i11 - 1, i11) : TextRangeKt.TextRange(i11, i11 - 1) : z10 ? !z11 ? TextRangeKt.TextRange(i10 - 1, i10) : TextRangeKt.TextRange(i10 + 1, i10) : !z11 ? TextRangeKt.TextRange(i10, i10 + 1) : TextRangeKt.TextRange(i10, i10 - 1);
    }
}
