package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraph_androidKt;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Paragraph.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ParagraphKt {
    public static final int DefaultMaxLines = Integer.MAX_VALUE;

    @NotNull
    public static final Paragraph Paragraph(@NotNull String text, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, int i10, boolean z10, float f10, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        t.i(text, "text");
        t.i(style, "style");
        t.i(spanStyles, "spanStyles");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(resourceLoader, "resourceLoader");
        return AndroidParagraph_androidKt.ActualParagraph(text, style, spanStyles, placeholders, i10, z10, f10, density, resourceLoader);
    }

    @NotNull
    /* JADX INFO: renamed from: Paragraph-UdtVg6A, reason: not valid java name */
    public static final Paragraph m3260ParagraphUdtVg6A(@NotNull String text, @NotNull TextStyle style, long j10, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, int i10, boolean z10) {
        t.i(text, "text");
        t.i(style, "style");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        t.i(spanStyles, "spanStyles");
        t.i(placeholders, "placeholders");
        return AndroidParagraph_androidKt.m3522ActualParagraphO3s9Psw(text, style, spanStyles, placeholders, i10, z10, j10, density, fontFamilyResolver);
    }

    @NotNull
    /* JADX INFO: renamed from: Paragraph-_EkL_-Y, reason: not valid java name */
    public static final Paragraph m3262Paragraph_EkL_Y(@NotNull ParagraphIntrinsics paragraphIntrinsics, long j10, int i10, boolean z10) {
        t.i(paragraphIntrinsics, "paragraphIntrinsics");
        return AndroidParagraph_androidKt.m3521ActualParagraphhBUhpc(paragraphIntrinsics, i10, z10, j10);
    }

    /* JADX INFO: renamed from: Paragraph-_EkL_-Y$default, reason: not valid java name */
    public static /* synthetic */ Paragraph m3263Paragraph_EkL_Y$default(ParagraphIntrinsics paragraphIntrinsics, long j10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        return m3262Paragraph_EkL_Y(paragraphIntrinsics, j10, i10, z10);
    }

    public static final int ceilToInt(float f10) {
        return (int) Math.ceil(f10);
    }

    @NotNull
    public static final Paragraph Paragraph(@NotNull String text, @NotNull TextStyle style, float f10, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, int i10, boolean z10) {
        t.i(text, "text");
        t.i(style, "style");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        t.i(spanStyles, "spanStyles");
        t.i(placeholders, "placeholders");
        return AndroidParagraph_androidKt.m3522ActualParagraphO3s9Psw(text, style, spanStyles, placeholders, i10, z10, ConstraintsKt.Constraints$default(0, ceilToInt(f10), 0, 0, 13, null), density, fontFamilyResolver);
    }

    @NotNull
    public static final Paragraph Paragraph(@NotNull ParagraphIntrinsics paragraphIntrinsics, int i10, boolean z10, float f10) {
        t.i(paragraphIntrinsics, "paragraphIntrinsics");
        return AndroidParagraph_androidKt.m3521ActualParagraphhBUhpc(paragraphIntrinsics, i10, z10, ConstraintsKt.Constraints$default(0, ceilToInt(f10), 0, 0, 13, null));
    }

    public static /* synthetic */ Paragraph Paragraph$default(ParagraphIntrinsics paragraphIntrinsics, int i10, boolean z10, float f10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return Paragraph(paragraphIntrinsics, i10, z10, f10);
    }
}
