package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InlineTextContent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InlineTextContentKt {

    @NotNull
    public static final String INLINE_CONTENT_TAG = "androidx.compose.foundation.text.inlineContent";

    @NotNull
    private static final String REPLACEMENT_CHAR = "�";

    public static final void appendInlineContent(@NotNull AnnotatedString.Builder builder, @NotNull String id, @NotNull String alternateText) {
        t.i(builder, "<this>");
        t.i(id, "id");
        t.i(alternateText, "alternateText");
        if (!(alternateText.length() > 0)) {
            throw new IllegalArgumentException("alternateText can't be an empty string.".toString());
        }
        builder.pushStringAnnotation(INLINE_CONTENT_TAG, id);
        builder.append(alternateText);
        builder.pop();
    }

    public static /* synthetic */ void appendInlineContent$default(AnnotatedString.Builder builder, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = REPLACEMENT_CHAR;
        }
        appendInlineContent(builder, str, str2);
    }
}
