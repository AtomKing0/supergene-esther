package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.u;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidParagraphIntrinsics.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {

    @NotNull
    private final CharSequence charSequence;

    @NotNull
    private final Density density;

    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;

    @NotNull
    private final LayoutIntrinsics layoutIntrinsics;

    @NotNull
    private final List<AnnotatedString.Range<Placeholder>> placeholders;

    @NotNull
    private final List<TypefaceDirtyTracker> resolvedTypefaces;

    @NotNull
    private final List<AnnotatedString.Range<SpanStyle>> spanStyles;

    @NotNull
    private final TextStyle style;

    @NotNull
    private final String text;
    private final int textDirectionHeuristic;

    @NotNull
    private final AndroidTextPaint textPaint;

    public AndroidParagraphIntrinsics(@NotNull String text, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, @NotNull FontFamily.Resolver fontFamilyResolver, @NotNull Density density) {
        t.i(text, "text");
        t.i(style, "style");
        t.i(spanStyles, "spanStyles");
        t.i(placeholders, "placeholders");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        t.i(density, "density");
        this.text = text;
        this.style = style;
        this.spanStyles = spanStyles;
        this.placeholders = placeholders;
        this.fontFamilyResolver = fontFamilyResolver;
        this.density = density;
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(1, density.getDensity());
        this.textPaint = androidTextPaint;
        this.resolvedTypefaces = new ArrayList();
        int iM3519resolveTextDirectionHeuristics9GRLPo0 = AndroidParagraphIntrinsics_androidKt.m3519resolveTextDirectionHeuristics9GRLPo0(style.m3358getTextDirectionmmuk1to(), style.getLocaleList());
        this.textDirectionHeuristic = iM3519resolveTextDirectionHeuristics9GRLPo0;
        AndroidParagraphIntrinsics$resolveTypeface$1 androidParagraphIntrinsics$resolveTypeface$1 = new AndroidParagraphIntrinsics$resolveTypeface$1(this);
        CharSequence charSequenceCreateCharSequence = AndroidParagraphHelper_androidKt.createCharSequence(text, androidTextPaint.getTextSize(), style, d0.A0(u.e(new AnnotatedString.Range(TextPaintExtensions_androidKt.applySpanStyle(androidTextPaint, style.toSpanStyle(), androidParagraphIntrinsics$resolveTypeface$1, density), 0, text.length())), spanStyles), placeholders, density, androidParagraphIntrinsics$resolveTypeface$1);
        this.charSequence = charSequenceCreateCharSequence;
        this.layoutIntrinsics = new LayoutIntrinsics(charSequenceCreateCharSequence, androidTextPaint, iM3519resolveTextDirectionHeuristics9GRLPo0);
    }

    @NotNull
    public final CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        List<TypefaceDirtyTracker> list = this.resolvedTypefaces;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (list.get(i10).isStaleResolvedFont()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final LayoutIntrinsics getLayoutIntrinsics$ui_text_release() {
        return this.layoutIntrinsics;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    @NotNull
    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    @NotNull
    public final List<AnnotatedString.Range<SpanStyle>> getSpanStyles() {
        return this.spanStyles;
    }

    @NotNull
    public final TextStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final int getTextDirectionHeuristic$ui_text_release() {
        return this.textDirectionHeuristic;
    }

    @NotNull
    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.textPaint;
    }
}
