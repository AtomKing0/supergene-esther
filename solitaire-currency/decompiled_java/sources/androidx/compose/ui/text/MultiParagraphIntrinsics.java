package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: MultiParagraphIntrinsics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MultiParagraphIntrinsics implements ParagraphIntrinsics {

    @NotNull
    private final AnnotatedString annotatedString;

    @NotNull
    private final List<ParagraphIntrinsicInfo> infoList;

    @NotNull
    private final l maxIntrinsicWidth$delegate;

    @NotNull
    private final l minIntrinsicWidth$delegate;

    @NotNull
    private final List<AnnotatedString.Range<Placeholder>> placeholders;

    public MultiParagraphIntrinsics(@NotNull AnnotatedString annotatedString, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver) {
        AnnotatedString annotatedString2 = annotatedString;
        t.i(annotatedString2, "annotatedString");
        t.i(style, "style");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        this.annotatedString = annotatedString2;
        this.placeholders = placeholders;
        p pVar = p.f35203c;
        this.minIntrinsicWidth$delegate = n.b(pVar, new MultiParagraphIntrinsics$minIntrinsicWidth$2(this));
        this.maxIntrinsicWidth$delegate = n.b(pVar, new MultiParagraphIntrinsics$maxIntrinsicWidth$2(this));
        ParagraphStyle paragraphStyle = style.toParagraphStyle();
        List<AnnotatedString.Range<ParagraphStyle>> listNormalizedParagraphStyles = AnnotatedStringKt.normalizedParagraphStyles(annotatedString2, paragraphStyle);
        ArrayList arrayList = new ArrayList(listNormalizedParagraphStyles.size());
        int size = listNormalizedParagraphStyles.size();
        int i10 = 0;
        while (i10 < size) {
            AnnotatedString.Range<ParagraphStyle> range = listNormalizedParagraphStyles.get(i10);
            AnnotatedString annotatedStringSubstringWithoutParagraphStyles = AnnotatedStringKt.substringWithoutParagraphStyles(annotatedString2, range.getStart(), range.getEnd());
            arrayList.add(new ParagraphIntrinsicInfo(ParagraphIntrinsicsKt.ParagraphIntrinsics(annotatedStringSubstringWithoutParagraphStyles.getText(), style.merge(resolveTextDirection(range.getItem(), paragraphStyle)), annotatedStringSubstringWithoutParagraphStyles.getSpanStyles(), (List<AnnotatedString.Range<Placeholder>>) MultiParagraphIntrinsicsKt.getLocalPlaceholders(getPlaceholders(), range.getStart(), range.getEnd()), density, fontFamilyResolver), range.getStart(), range.getEnd()));
            i10++;
            annotatedString2 = annotatedString;
        }
        this.infoList = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParagraphStyle resolveTextDirection(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2) {
        TextDirection textDirectionM3270getTextDirectionmmuk1to = paragraphStyle.m3270getTextDirectionmmuk1to();
        if (textDirectionM3270getTextDirectionmmuk1to == null) {
            return ParagraphStyle.m3264copyElsmlbk$default(paragraphStyle, null, paragraphStyle2.m3270getTextDirectionmmuk1to(), 0L, null, 13, null);
        }
        textDirectionM3270getTextDirectionmmuk1to.m3605unboximpl();
        return paragraphStyle;
    }

    @NotNull
    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        List<ParagraphIntrinsicInfo> list = this.infoList;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (list.get(i10).getIntrinsics().getHasStaleResolvedFonts()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<ParagraphIntrinsicInfo> getInfoList$ui_text_release() {
        return this.infoList;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return ((Number) this.maxIntrinsicWidth$delegate.getValue()).floatValue();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return ((Number) this.minIntrinsicWidth$delegate.getValue()).floatValue();
    }

    @NotNull
    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiParagraphIntrinsics(@NotNull AnnotatedString annotatedString, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        this(annotatedString, style, placeholders, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
        t.i(annotatedString, "annotatedString");
        t.i(style, "style");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(resourceLoader, "resourceLoader");
    }
}
