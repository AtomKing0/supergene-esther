package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextFieldSize.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldSize {

    @NotNull
    private Density density;

    @NotNull
    private FontFamily.Resolver fontFamilyResolver;

    @NotNull
    private LayoutDirection layoutDirection;
    private long minSize;

    @NotNull
    private TextStyle resolvedStyle;

    @NotNull
    private Object typeface;

    public TextFieldSize(@NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver, @NotNull TextStyle resolvedStyle, @NotNull Object typeface) {
        t.i(layoutDirection, "layoutDirection");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        t.i(resolvedStyle, "resolvedStyle");
        t.i(typeface, "typeface");
        this.layoutDirection = layoutDirection;
        this.density = density;
        this.fontFamilyResolver = fontFamilyResolver;
        this.resolvedStyle = resolvedStyle;
        this.typeface = typeface;
        this.minSize = m735computeMinSizeYbymL2g();
    }

    /* JADX INFO: renamed from: computeMinSize-YbymL2g, reason: not valid java name */
    private final long m735computeMinSizeYbymL2g() {
        return TextFieldDelegateKt.computeSizeForDefaultText$default(this.resolvedStyle, this.density, this.fontFamilyResolver, null, 0, 24, null);
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

    /* JADX INFO: renamed from: getMinSize-YbymL2g, reason: not valid java name */
    public final long m736getMinSizeYbymL2g() {
        return this.minSize;
    }

    @NotNull
    public final TextStyle getResolvedStyle() {
        return this.resolvedStyle;
    }

    @NotNull
    public final Object getTypeface() {
        return this.typeface;
    }

    public final void setDensity(@NotNull Density density) {
        t.i(density, "<set-?>");
        this.density = density;
    }

    public final void setFontFamilyResolver(@NotNull FontFamily.Resolver resolver) {
        t.i(resolver, "<set-?>");
        this.fontFamilyResolver = resolver;
    }

    public final void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    public final void setResolvedStyle(@NotNull TextStyle textStyle) {
        t.i(textStyle, "<set-?>");
        this.resolvedStyle = textStyle;
    }

    public final void setTypeface(@NotNull Object obj) {
        t.i(obj, "<set-?>");
        this.typeface = obj;
    }

    public final void update(@NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver, @NotNull TextStyle resolvedStyle, @NotNull Object typeface) {
        t.i(layoutDirection, "layoutDirection");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        t.i(resolvedStyle, "resolvedStyle");
        t.i(typeface, "typeface");
        if (layoutDirection == this.layoutDirection && t.d(density, this.density) && t.d(fontFamilyResolver, this.fontFamilyResolver) && t.d(resolvedStyle, this.resolvedStyle) && t.d(typeface, this.typeface)) {
            return;
        }
        this.layoutDirection = layoutDirection;
        this.density = density;
        this.fontFamilyResolver = fontFamilyResolver;
        this.resolvedStyle = resolvedStyle;
        this.typeface = typeface;
        this.minSize = m735computeMinSizeYbymL2g();
    }
}
