package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: TextPreparedSelection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextPreparedSelection extends BaseTextPreparedSelection<TextPreparedSelection> {
    public /* synthetic */ TextPreparedSelection(AnnotatedString annotatedString, long j10, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState, k kVar) {
        this(annotatedString, j10, textLayoutResult, offsetMapping, textPreparedSelectionState);
    }

    public /* synthetic */ TextPreparedSelection(AnnotatedString annotatedString, long j10, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState, int i10, k kVar) {
        this(annotatedString, j10, (i10 & 4) != 0 ? null : textLayoutResult, (i10 & 8) != 0 ? OffsetMapping.Companion.getIdentity() : offsetMapping, (i10 & 16) != 0 ? new TextPreparedSelectionState() : textPreparedSelectionState, null);
    }

    private TextPreparedSelection(AnnotatedString annotatedString, long j10, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState) {
        super(annotatedString, j10, textLayoutResult, offsetMapping, textPreparedSelectionState, null);
    }
}
