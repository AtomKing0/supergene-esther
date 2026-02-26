package androidx.compose.ui.text;

import androidx.compose.foundation.e;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextLayoutResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutInput {

    @Nullable
    private Font.ResourceLoader _developerSuppliedResourceLoader;
    private final long constraints;

    @NotNull
    private final Density density;

    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;

    @NotNull
    private final LayoutDirection layoutDirection;
    private final int maxLines;
    private final int overflow;

    @NotNull
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;

    @NotNull
    private final TextStyle style;

    @NotNull
    private final AnnotatedString text;

    public /* synthetic */ TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i10, boolean z10, int i11, Density density, LayoutDirection layoutDirection, Font.ResourceLoader resourceLoader, long j10, k kVar) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) list, i10, z10, i11, density, layoutDirection, resourceLoader, j10);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-hu-1Yfo, reason: not valid java name */
    public final TextLayoutInput m3315copyhu1Yfo(@NotNull AnnotatedString text, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, int i10, boolean z10, int i11, @NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Font.ResourceLoader resourceLoader, long j10) {
        t.i(text, "text");
        t.i(style, "style");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        t.i(resourceLoader, "resourceLoader");
        return new TextLayoutInput(text, style, placeholders, i10, z10, i11, density, layoutDirection, resourceLoader, this.fontFamilyResolver, j10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = (TextLayoutInput) obj;
        return t.d(this.text, textLayoutInput.text) && t.d(this.style, textLayoutInput.style) && t.d(this.placeholders, textLayoutInput.placeholders) && this.maxLines == textLayoutInput.maxLines && this.softWrap == textLayoutInput.softWrap && TextOverflow.m3619equalsimpl0(this.overflow, textLayoutInput.overflow) && t.d(this.density, textLayoutInput.density) && this.layoutDirection == textLayoutInput.layoutDirection && t.d(this.fontFamilyResolver, textLayoutInput.fontFamilyResolver) && Constraints.m3634equalsimpl0(this.constraints, textLayoutInput.constraints);
    }

    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
    public final long m3316getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    @NotNull
    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    /* JADX INFO: renamed from: getOverflow-gIe3tQ8, reason: not valid java name */
    public final int m3317getOverflowgIe3tQ8() {
        return this.overflow;
    }

    @NotNull
    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    @NotNull
    public final Font.ResourceLoader getResourceLoader() {
        Font.ResourceLoader resourceLoader = this._developerSuppliedResourceLoader;
        return resourceLoader == null ? DeprecatedBridgeFontResourceLoader.Companion.from(this.fontFamilyResolver) : resourceLoader;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    @NotNull
    public final TextStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final AnnotatedString getText() {
        return this.text;
    }

    public int hashCode() {
        return (((((((((((((((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.placeholders.hashCode()) * 31) + this.maxLines) * 31) + e.a(this.softWrap)) * 31) + TextOverflow.m3620hashCodeimpl(this.overflow)) * 31) + this.density.hashCode()) * 31) + this.layoutDirection.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31) + Constraints.m3644hashCodeimpl(this.constraints);
    }

    @NotNull
    public String toString() {
        return "TextLayoutInput(text=" + ((Object) this.text) + ", style=" + this.style + ", placeholders=" + this.placeholders + ", maxLines=" + this.maxLines + ", softWrap=" + this.softWrap + ", overflow=" + ((Object) TextOverflow.m3621toStringimpl(this.overflow)) + ", density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + ((Object) Constraints.m3646toStringimpl(this.constraints)) + ')';
    }

    public /* synthetic */ TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i10, boolean z10, int i11, Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j10, k kVar) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) list, i10, z10, i11, density, layoutDirection, resolver, j10);
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i10, boolean z10, int i11, Density density, LayoutDirection layoutDirection, Font.ResourceLoader resourceLoader, FontFamily.Resolver resolver, long j10) {
        this.text = annotatedString;
        this.style = textStyle;
        this.placeholders = list;
        this.maxLines = i10;
        this.softWrap = z10;
        this.overflow = i11;
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.fontFamilyResolver = resolver;
        this.constraints = j10;
        this._developerSuppliedResourceLoader = resourceLoader;
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i10, boolean z10, int i11, Density density, LayoutDirection layoutDirection, Font.ResourceLoader resourceLoader, long j10) {
        this(annotatedString, textStyle, list, i10, z10, i11, density, layoutDirection, resourceLoader, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader), j10);
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i10, boolean z10, int i11, Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j10) {
        this(annotatedString, textStyle, list, i10, z10, i11, density, layoutDirection, (Font.ResourceLoader) null, resolver, j10);
    }

    public static /* synthetic */ void getResourceLoader$annotations() {
    }
}
