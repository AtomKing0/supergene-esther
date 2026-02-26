package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidParagraph.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraph_androidKt {
    @NotNull
    public static final Paragraph ActualParagraph(@NotNull String text, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, int i10, boolean z10, float f10, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        t.i(text, "text");
        t.i(style, "style");
        t.i(spanStyles, "spanStyles");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(resourceLoader, "resourceLoader");
        return new AndroidParagraph(new AndroidParagraphIntrinsics(text, style, spanStyles, placeholders, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader), density), i10, z10, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f10), 0, 0, 13, null), null);
    }

    @NotNull
    /* JADX INFO: renamed from: ActualParagraph--hBUhpc, reason: not valid java name */
    public static final Paragraph m3521ActualParagraphhBUhpc(@NotNull ParagraphIntrinsics paragraphIntrinsics, int i10, boolean z10, long j10) {
        t.i(paragraphIntrinsics, "paragraphIntrinsics");
        return new AndroidParagraph((AndroidParagraphIntrinsics) paragraphIntrinsics, i10, z10, j10, null);
    }

    @NotNull
    /* JADX INFO: renamed from: ActualParagraph-O3s9Psw, reason: not valid java name */
    public static final Paragraph m3522ActualParagraphO3s9Psw(@NotNull String text, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, int i10, boolean z10, long j10, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver) {
        t.i(text, "text");
        t.i(style, "style");
        t.i(spanStyles, "spanStyles");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        return new AndroidParagraph(new AndroidParagraphIntrinsics(text, style, spanStyles, placeholders, fontFamilyResolver, density), i10, z10, j10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i10) {
        int lineCount = textLayout.getLineCount();
        for (int i11 = 0; i11 < lineCount; i11++) {
            if (textLayout.getLineBottom(i11) > i10) {
                return i11;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutAlign-AMY3VfE, reason: not valid java name */
    public static final int m3524toLayoutAlignAMY3VfE(TextAlign textAlign) {
        TextAlign.Companion companion = TextAlign.Companion;
        if (textAlign == null ? false : TextAlign.m3589equalsimpl0(textAlign.m3592unboximpl(), companion.m3596getLefte0LSkKk())) {
            return 3;
        }
        if (textAlign == null ? false : TextAlign.m3589equalsimpl0(textAlign.m3592unboximpl(), companion.m3597getRighte0LSkKk())) {
            return 4;
        }
        if (textAlign == null ? false : TextAlign.m3589equalsimpl0(textAlign.m3592unboximpl(), companion.m3593getCentere0LSkKk())) {
            return 2;
        }
        if (textAlign == null ? false : TextAlign.m3589equalsimpl0(textAlign.m3592unboximpl(), companion.m3598getStarte0LSkKk())) {
            return 0;
        }
        return textAlign == null ? false : TextAlign.m3589equalsimpl0(textAlign.m3592unboximpl(), companion.m3594getEnde0LSkKk()) ? 1 : 0;
    }
}
