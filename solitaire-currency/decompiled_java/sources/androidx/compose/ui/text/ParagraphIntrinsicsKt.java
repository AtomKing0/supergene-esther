package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics_androidKt;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ParagraphIntrinsics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ParagraphIntrinsicsKt {
    @NotNull
    public static final ParagraphIntrinsics ParagraphIntrinsics(@NotNull String text, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        t.i(text, "text");
        t.i(style, "style");
        t.i(spanStyles, "spanStyles");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(resourceLoader, "resourceLoader");
        return AndroidParagraphIntrinsics_androidKt.ActualParagraphIntrinsics(text, style, spanStyles, placeholders, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
    }

    public static /* synthetic */ ParagraphIntrinsics ParagraphIntrinsics$default(String str, TextStyle textStyle, List list, List list2, Density density, Font.ResourceLoader resourceLoader, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list = v.l();
        }
        List list3 = list;
        if ((i10 & 8) != 0) {
            list2 = v.l();
        }
        return ParagraphIntrinsics(str, textStyle, (List<AnnotatedString.Range<SpanStyle>>) list3, (List<AnnotatedString.Range<Placeholder>>) list2, density, resourceLoader);
    }

    @NotNull
    public static final ParagraphIntrinsics ParagraphIntrinsics(@NotNull String text, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver) {
        t.i(text, "text");
        t.i(style, "style");
        t.i(spanStyles, "spanStyles");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        return AndroidParagraphIntrinsics_androidKt.ActualParagraphIntrinsics(text, style, spanStyles, placeholders, density, fontFamilyResolver);
    }

    public static /* synthetic */ ParagraphIntrinsics ParagraphIntrinsics$default(String str, TextStyle textStyle, List list, List list2, Density density, FontFamily.Resolver resolver, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list = v.l();
        }
        List list3 = list;
        if ((i10 & 8) != 0) {
            list2 = v.l();
        }
        return ParagraphIntrinsics(str, textStyle, (List<AnnotatedString.Range<SpanStyle>>) list3, (List<AnnotatedString.Range<Placeholder>>) list2, density, resolver);
    }
}
