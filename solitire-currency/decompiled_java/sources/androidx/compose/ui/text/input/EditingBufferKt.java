package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m3455updateRangeAfterDeletepWDy79M(long j10, long j11) {
        int iM3331getLengthimpl;
        int iM3333getMinimpl = TextRange.m3333getMinimpl(j10);
        int iM3332getMaximpl = TextRange.m3332getMaximpl(j10);
        if (TextRange.m3337intersects5zctL8(j11, j10)) {
            if (TextRange.m3325contains5zctL8(j11, j10)) {
                iM3333getMinimpl = TextRange.m3333getMinimpl(j11);
                iM3332getMaximpl = iM3333getMinimpl;
            } else {
                if (TextRange.m3325contains5zctL8(j10, j11)) {
                    iM3331getLengthimpl = TextRange.m3331getLengthimpl(j11);
                } else if (TextRange.m3326containsimpl(j11, iM3333getMinimpl)) {
                    iM3333getMinimpl = TextRange.m3333getMinimpl(j11);
                    iM3331getLengthimpl = TextRange.m3331getLengthimpl(j11);
                } else {
                    iM3332getMaximpl = TextRange.m3333getMinimpl(j11);
                }
                iM3332getMaximpl -= iM3331getLengthimpl;
            }
        } else if (iM3332getMaximpl > TextRange.m3333getMinimpl(j11)) {
            iM3333getMinimpl -= TextRange.m3331getLengthimpl(j11);
            iM3331getLengthimpl = TextRange.m3331getLengthimpl(j11);
            iM3332getMaximpl -= iM3331getLengthimpl;
        }
        return TextRangeKt.TextRange(iM3333getMinimpl, iM3332getMaximpl);
    }
}
