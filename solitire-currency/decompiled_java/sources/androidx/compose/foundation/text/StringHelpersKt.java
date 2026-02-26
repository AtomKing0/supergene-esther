package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StringHelpers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StringHelpersKt {
    public static final int findParagraphEnd(@NotNull CharSequence charSequence, int i10) {
        t.i(charSequence, "<this>");
        int length = charSequence.length();
        for (int i11 = i10 + 1; i11 < length; i11++) {
            if (charSequence.charAt(i11) == '\n') {
                return i11;
            }
        }
        return charSequence.length();
    }

    public static final int findParagraphStart(@NotNull CharSequence charSequence, int i10) {
        t.i(charSequence, "<this>");
        for (int i11 = i10 - 1; i11 > 0; i11--) {
            if (charSequence.charAt(i11 - 1) == '\n') {
                return i11;
            }
        }
        return 0;
    }

    public static final long getParagraphBoundary(@NotNull CharSequence charSequence, int i10) {
        t.i(charSequence, "<this>");
        return TextRangeKt.TextRange(findParagraphStart(charSequence, i10), findParagraphEnd(charSequence, i10));
    }
}
