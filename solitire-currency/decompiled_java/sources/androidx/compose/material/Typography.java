package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Typography.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Typography {

    @NotNull
    private final TextStyle body1;

    @NotNull
    private final TextStyle body2;

    @NotNull
    private final TextStyle button;

    @NotNull
    private final TextStyle caption;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    @NotNull
    private final TextStyle f760h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    @NotNull
    private final TextStyle f761h2;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    @NotNull
    private final TextStyle f762h3;

    /* JADX INFO: renamed from: h4, reason: collision with root package name */
    @NotNull
    private final TextStyle f763h4;

    /* JADX INFO: renamed from: h5, reason: collision with root package name */
    @NotNull
    private final TextStyle f764h5;

    /* JADX INFO: renamed from: h6, reason: collision with root package name */
    @NotNull
    private final TextStyle f765h6;

    @NotNull
    private final TextStyle overline;

    @NotNull
    private final TextStyle subtitle1;

    @NotNull
    private final TextStyle subtitle2;

    public Typography(@NotNull TextStyle h12, @NotNull TextStyle h22, @NotNull TextStyle h32, @NotNull TextStyle h42, @NotNull TextStyle h52, @NotNull TextStyle h62, @NotNull TextStyle subtitle1, @NotNull TextStyle subtitle2, @NotNull TextStyle body1, @NotNull TextStyle body2, @NotNull TextStyle button, @NotNull TextStyle caption, @NotNull TextStyle overline) {
        t.i(h12, "h1");
        t.i(h22, "h2");
        t.i(h32, "h3");
        t.i(h42, "h4");
        t.i(h52, "h5");
        t.i(h62, "h6");
        t.i(subtitle1, "subtitle1");
        t.i(subtitle2, "subtitle2");
        t.i(body1, "body1");
        t.i(body2, "body2");
        t.i(button, "button");
        t.i(caption, "caption");
        t.i(overline, "overline");
        this.f760h1 = h12;
        this.f761h2 = h22;
        this.f762h3 = h32;
        this.f763h4 = h42;
        this.f764h5 = h52;
        this.f765h6 = h62;
        this.subtitle1 = subtitle1;
        this.subtitle2 = subtitle2;
        this.body1 = body1;
        this.body2 = body2;
        this.button = button;
        this.caption = caption;
        this.overline = overline;
    }

    @NotNull
    public final Typography copy(@NotNull TextStyle h12, @NotNull TextStyle h22, @NotNull TextStyle h32, @NotNull TextStyle h42, @NotNull TextStyle h52, @NotNull TextStyle h62, @NotNull TextStyle subtitle1, @NotNull TextStyle subtitle2, @NotNull TextStyle body1, @NotNull TextStyle body2, @NotNull TextStyle button, @NotNull TextStyle caption, @NotNull TextStyle overline) {
        t.i(h12, "h1");
        t.i(h22, "h2");
        t.i(h32, "h3");
        t.i(h42, "h4");
        t.i(h52, "h5");
        t.i(h62, "h6");
        t.i(subtitle1, "subtitle1");
        t.i(subtitle2, "subtitle2");
        t.i(body1, "body1");
        t.i(body2, "body2");
        t.i(button, "button");
        t.i(caption, "caption");
        t.i(overline, "overline");
        return new Typography(h12, h22, h32, h42, h52, h62, subtitle1, subtitle2, body1, body2, button, caption, overline);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) obj;
        return t.d(this.f760h1, typography.f760h1) && t.d(this.f761h2, typography.f761h2) && t.d(this.f762h3, typography.f762h3) && t.d(this.f763h4, typography.f763h4) && t.d(this.f764h5, typography.f764h5) && t.d(this.f765h6, typography.f765h6) && t.d(this.subtitle1, typography.subtitle1) && t.d(this.subtitle2, typography.subtitle2) && t.d(this.body1, typography.body1) && t.d(this.body2, typography.body2) && t.d(this.button, typography.button) && t.d(this.caption, typography.caption) && t.d(this.overline, typography.overline);
    }

    @NotNull
    public final TextStyle getBody1() {
        return this.body1;
    }

    @NotNull
    public final TextStyle getBody2() {
        return this.body2;
    }

    @NotNull
    public final TextStyle getButton() {
        return this.button;
    }

    @NotNull
    public final TextStyle getCaption() {
        return this.caption;
    }

    @NotNull
    public final TextStyle getH1() {
        return this.f760h1;
    }

    @NotNull
    public final TextStyle getH2() {
        return this.f761h2;
    }

    @NotNull
    public final TextStyle getH3() {
        return this.f762h3;
    }

    @NotNull
    public final TextStyle getH4() {
        return this.f763h4;
    }

    @NotNull
    public final TextStyle getH5() {
        return this.f764h5;
    }

    @NotNull
    public final TextStyle getH6() {
        return this.f765h6;
    }

    @NotNull
    public final TextStyle getOverline() {
        return this.overline;
    }

    @NotNull
    public final TextStyle getSubtitle1() {
        return this.subtitle1;
    }

    @NotNull
    public final TextStyle getSubtitle2() {
        return this.subtitle2;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.f760h1.hashCode() * 31) + this.f761h2.hashCode()) * 31) + this.f762h3.hashCode()) * 31) + this.f763h4.hashCode()) * 31) + this.f764h5.hashCode()) * 31) + this.f765h6.hashCode()) * 31) + this.subtitle1.hashCode()) * 31) + this.subtitle2.hashCode()) * 31) + this.body1.hashCode()) * 31) + this.body2.hashCode()) * 31) + this.button.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.overline.hashCode();
    }

    @NotNull
    public String toString() {
        return "Typography(h1=" + this.f760h1 + ", h2=" + this.f761h2 + ", h3=" + this.f762h3 + ", h4=" + this.f763h4 + ", h5=" + this.f764h5 + ", h6=" + this.f765h6 + ", subtitle1=" + this.subtitle1 + ", subtitle2=" + this.subtitle2 + ", body1=" + this.body1 + ", body2=" + this.body2 + ", button=" + this.button + ", caption=" + this.caption + ", overline=" + this.overline + ')';
    }

    public /* synthetic */ Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, int i10, k kVar) {
        this((i10 & 1) != 0 ? FontFamily.Companion.getDefault() : fontFamily, (i10 & 2) != 0 ? new TextStyle(0L, TextUnitKt.getSp(96), FontWeight.Companion.getLight(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(-1.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle, (i10 & 4) != 0 ? new TextStyle(0L, TextUnitKt.getSp(60), FontWeight.Companion.getLight(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(-0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle2, (i10 & 8) != 0 ? new TextStyle(0L, TextUnitKt.getSp(48), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle3, (i10 & 16) != 0 ? new TextStyle(0L, TextUnitKt.getSp(34), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle4, (i10 & 32) != 0 ? new TextStyle(0L, TextUnitKt.getSp(24), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle5, (i10 & 64) != 0 ? new TextStyle(0L, TextUnitKt.getSp(20), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle6, (i10 & 128) != 0 ? new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.15d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle7, (i10 & 256) != 0 ? new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.1d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle8, (i10 & 512) != 0 ? new TextStyle(0L, TextUnitKt.getSp(16), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle9, (i10 & 1024) != 0 ? new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle10, (i10 & 2048) != 0 ? new TextStyle(0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(1.25d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle11, (i10 & 4096) != 0 ? new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0.4d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle12, (i10 & 8192) != 0 ? new TextStyle(0L, TextUnitKt.getSp(10), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(1.5d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0L, (TextIndent) null, 262009, (k) null) : textStyle13);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Typography(@NotNull FontFamily defaultFontFamily, @NotNull TextStyle h12, @NotNull TextStyle h22, @NotNull TextStyle h32, @NotNull TextStyle h42, @NotNull TextStyle h52, @NotNull TextStyle h62, @NotNull TextStyle subtitle1, @NotNull TextStyle subtitle2, @NotNull TextStyle body1, @NotNull TextStyle body2, @NotNull TextStyle button, @NotNull TextStyle caption, @NotNull TextStyle overline) {
        this(TypographyKt.withDefaultFontFamily(h12, defaultFontFamily), TypographyKt.withDefaultFontFamily(h22, defaultFontFamily), TypographyKt.withDefaultFontFamily(h32, defaultFontFamily), TypographyKt.withDefaultFontFamily(h42, defaultFontFamily), TypographyKt.withDefaultFontFamily(h52, defaultFontFamily), TypographyKt.withDefaultFontFamily(h62, defaultFontFamily), TypographyKt.withDefaultFontFamily(subtitle1, defaultFontFamily), TypographyKt.withDefaultFontFamily(subtitle2, defaultFontFamily), TypographyKt.withDefaultFontFamily(body1, defaultFontFamily), TypographyKt.withDefaultFontFamily(body2, defaultFontFamily), TypographyKt.withDefaultFontFamily(button, defaultFontFamily), TypographyKt.withDefaultFontFamily(caption, defaultFontFamily), TypographyKt.withDefaultFontFamily(overline, defaultFontFamily));
        t.i(defaultFontFamily, "defaultFontFamily");
        t.i(h12, "h1");
        t.i(h22, "h2");
        t.i(h32, "h3");
        t.i(h42, "h4");
        t.i(h52, "h5");
        t.i(h62, "h6");
        t.i(subtitle1, "subtitle1");
        t.i(subtitle2, "subtitle2");
        t.i(body1, "body1");
        t.i(body2, "body2");
        t.i(button, "button");
        t.i(caption, "caption");
        t.i(overline, "overline");
    }
}
