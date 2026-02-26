package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SpanStyle.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class SpanStyle {
    private final long background;

    @Nullable
    private final BaselineShift baselineShift;

    @Nullable
    private final FontFamily fontFamily;

    @Nullable
    private final String fontFeatureSettings;
    private final long fontSize;

    @Nullable
    private final FontStyle fontStyle;

    @Nullable
    private final FontSynthesis fontSynthesis;

    @Nullable
    private final FontWeight fontWeight;
    private final long letterSpacing;

    @Nullable
    private final LocaleList localeList;

    @Nullable
    private final PlatformSpanStyle platformStyle;

    @Nullable
    private final Shadow shadow;

    @Nullable
    private final TextDecoration textDecoration;

    @NotNull
    private final TextDrawStyle textDrawStyle;

    @Nullable
    private final TextGeometricTransform textGeometricTransform;

    @ExperimentalTextApi
    public /* synthetic */ SpanStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, k kVar) {
        this(j10, j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, platformSpanStyle);
    }

    private final boolean hasSameNonLayoutAttributes(SpanStyle spanStyle) {
        return t.d(this.textDrawStyle, spanStyle.textDrawStyle) && t.d(this.textDecoration, spanStyle.textDecoration) && t.d(this.shadow, spanStyle.shadow);
    }

    public static /* synthetic */ SpanStyle merge$default(SpanStyle spanStyle, SpanStyle spanStyle2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            spanStyle2 = null;
        }
        return spanStyle.merge(spanStyle2);
    }

    private final PlatformSpanStyle mergePlatformStyle(PlatformSpanStyle platformSpanStyle) {
        PlatformSpanStyle platformSpanStyle2 = this.platformStyle;
        return platformSpanStyle2 == null ? platformSpanStyle : platformSpanStyle == null ? platformSpanStyle2 : platformSpanStyle2.merge(platformSpanStyle);
    }

    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: copy-2BkPm_w, reason: not valid java name */
    public final SpanStyle m3303copy2BkPm_w(long j10, long j11, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j12, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j13, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable PlatformSpanStyle platformSpanStyle) {
        return new SpanStyle(Color.m1599equalsimpl0(j10, m3308getColor0d7_KjU()) ? this.textDrawStyle : TextDrawStyle.Companion.m3611from8_81llA(j10), j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, platformSpanStyle, (k) null);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-IuqyXdg, reason: not valid java name */
    public final SpanStyle m3304copyIuqyXdg(long j10, long j11, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j12, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j13, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow) {
        return new SpanStyle(Color.m1599equalsimpl0(j10, m3308getColor0d7_KjU()) ? this.textDrawStyle : TextDrawStyle.Companion.m3611from8_81llA(j10), j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, this.platformStyle, (k) null);
    }

    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: copy-YSq14V0, reason: not valid java name */
    public final SpanStyle m3305copyYSq14V0(@Nullable Brush brush, long j10, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j11, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j12, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable PlatformSpanStyle platformSpanStyle) {
        return new SpanStyle(TextDrawStyle.Companion.from(brush), j10, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j11, baselineShift, textGeometricTransform, localeList, j12, textDecoration, shadow, platformSpanStyle, (k) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanStyle)) {
            return false;
        }
        SpanStyle spanStyle = (SpanStyle) obj;
        return hasSameLayoutAffectingAttributes$ui_text_release(spanStyle) && hasSameNonLayoutAttributes(spanStyle);
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m3306getBackground0d7_KjU() {
        return this.background;
    }

    @Nullable
    /* JADX INFO: renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m3307getBaselineShift5SSeXJ0() {
        return this.baselineShift;
    }

    @ExperimentalTextApi
    @Nullable
    public final Brush getBrush() {
        return this.textDrawStyle.getBrush();
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m3308getColor0d7_KjU() {
        return this.textDrawStyle.mo3556getColor0d7_KjU();
    }

    @Nullable
    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Nullable
    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m3309getFontSizeXSAIIZE() {
        return this.fontSize;
    }

    @Nullable
    /* JADX INFO: renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m3310getFontStyle4Lr2A7w() {
        return this.fontStyle;
    }

    @Nullable
    /* JADX INFO: renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m3311getFontSynthesisZQGJjVo() {
        return this.fontSynthesis;
    }

    @Nullable
    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m3312getLetterSpacingXSAIIZE() {
        return this.letterSpacing;
    }

    @Nullable
    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    @ExperimentalTextApi
    @Nullable
    public final PlatformSpanStyle getPlatformStyle() {
        return this.platformStyle;
    }

    @Nullable
    public final Shadow getShadow() {
        return this.shadow;
    }

    @Nullable
    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    @NotNull
    public final TextDrawStyle getTextDrawStyle$ui_text_release() {
        return this.textDrawStyle;
    }

    @Nullable
    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text_release(@NotNull SpanStyle other) {
        t.i(other, "other");
        if (this == other) {
            return true;
        }
        return TextUnit.m3851equalsimpl0(this.fontSize, other.fontSize) && t.d(this.fontWeight, other.fontWeight) && t.d(this.fontStyle, other.fontStyle) && t.d(this.fontSynthesis, other.fontSynthesis) && t.d(this.fontFamily, other.fontFamily) && t.d(this.fontFeatureSettings, other.fontFeatureSettings) && TextUnit.m3851equalsimpl0(this.letterSpacing, other.letterSpacing) && t.d(this.baselineShift, other.baselineShift) && t.d(this.textGeometricTransform, other.textGeometricTransform) && t.d(this.localeList, other.localeList) && Color.m1599equalsimpl0(this.background, other.background) && t.d(this.platformStyle, other.platformStyle);
    }

    public int hashCode() {
        int iM1605hashCodeimpl = Color.m1605hashCodeimpl(m3308getColor0d7_KjU()) * 31;
        Brush brush = getBrush();
        int iHashCode = (((iM1605hashCodeimpl + (brush != null ? brush.hashCode() : 0)) * 31) + TextUnit.m3855hashCodeimpl(this.fontSize)) * 31;
        FontWeight fontWeight = this.fontWeight;
        int iHashCode2 = (iHashCode + (fontWeight != null ? fontWeight.hashCode() : 0)) * 31;
        FontStyle fontStyle = this.fontStyle;
        int iM3414hashCodeimpl = (iHashCode2 + (fontStyle != null ? FontStyle.m3414hashCodeimpl(fontStyle.m3416unboximpl()) : 0)) * 31;
        FontSynthesis fontSynthesis = this.fontSynthesis;
        int iM3423hashCodeimpl = (iM3414hashCodeimpl + (fontSynthesis != null ? FontSynthesis.m3423hashCodeimpl(fontSynthesis.m3427unboximpl()) : 0)) * 31;
        FontFamily fontFamily = this.fontFamily;
        int iHashCode3 = (iM3423hashCodeimpl + (fontFamily != null ? fontFamily.hashCode() : 0)) * 31;
        String str = this.fontFeatureSettings;
        int iHashCode4 = (((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + TextUnit.m3855hashCodeimpl(this.letterSpacing)) * 31;
        BaselineShift baselineShift = this.baselineShift;
        int iM3546hashCodeimpl = (iHashCode4 + (baselineShift != null ? BaselineShift.m3546hashCodeimpl(baselineShift.m3548unboximpl()) : 0)) * 31;
        TextGeometricTransform textGeometricTransform = this.textGeometricTransform;
        int iHashCode5 = (iM3546hashCodeimpl + (textGeometricTransform != null ? textGeometricTransform.hashCode() : 0)) * 31;
        LocaleList localeList = this.localeList;
        int iHashCode6 = (((iHashCode5 + (localeList != null ? localeList.hashCode() : 0)) * 31) + Color.m1605hashCodeimpl(this.background)) * 31;
        TextDecoration textDecoration = this.textDecoration;
        int iHashCode7 = (iHashCode6 + (textDecoration != null ? textDecoration.hashCode() : 0)) * 31;
        Shadow shadow = this.shadow;
        int iHashCode8 = (iHashCode7 + (shadow != null ? shadow.hashCode() : 0)) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        return iHashCode8 + (platformSpanStyle != null ? platformSpanStyle.hashCode() : 0);
    }

    @Stable
    @NotNull
    public final SpanStyle merge(@Nullable SpanStyle spanStyle) {
        if (spanStyle == null) {
            return this;
        }
        TextDrawStyle textDrawStyleMerge = this.textDrawStyle.merge(spanStyle.textDrawStyle);
        FontFamily fontFamily = spanStyle.fontFamily;
        if (fontFamily == null) {
            fontFamily = this.fontFamily;
        }
        FontFamily fontFamily2 = fontFamily;
        long j10 = !TextUnitKt.m3872isUnspecifiedR2X_6o(spanStyle.fontSize) ? spanStyle.fontSize : this.fontSize;
        FontWeight fontWeight = spanStyle.fontWeight;
        if (fontWeight == null) {
            fontWeight = this.fontWeight;
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = spanStyle.fontStyle;
        if (fontStyle == null) {
            fontStyle = this.fontStyle;
        }
        FontStyle fontStyle2 = fontStyle;
        FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
        if (fontSynthesis == null) {
            fontSynthesis = this.fontSynthesis;
        }
        FontSynthesis fontSynthesis2 = fontSynthesis;
        String str = spanStyle.fontFeatureSettings;
        if (str == null) {
            str = this.fontFeatureSettings;
        }
        String str2 = str;
        long j11 = !TextUnitKt.m3872isUnspecifiedR2X_6o(spanStyle.letterSpacing) ? spanStyle.letterSpacing : this.letterSpacing;
        BaselineShift baselineShift = spanStyle.baselineShift;
        if (baselineShift == null) {
            baselineShift = this.baselineShift;
        }
        BaselineShift baselineShift2 = baselineShift;
        TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
        if (textGeometricTransform == null) {
            textGeometricTransform = this.textGeometricTransform;
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.localeList;
        if (localeList == null) {
            localeList = this.localeList;
        }
        LocaleList localeList2 = localeList;
        long j12 = spanStyle.background;
        if (!(j12 != Color.Companion.m1634getUnspecified0d7_KjU())) {
            j12 = this.background;
        }
        long j13 = j12;
        TextDecoration textDecoration = spanStyle.textDecoration;
        if (textDecoration == null) {
            textDecoration = this.textDecoration;
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.shadow;
        if (shadow == null) {
            shadow = this.shadow;
        }
        return new SpanStyle(textDrawStyleMerge, j10, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j11, baselineShift2, textGeometricTransform2, localeList2, j13, textDecoration2, shadow, mergePlatformStyle(spanStyle.platformStyle), (k) null);
    }

    @Stable
    @NotNull
    public final SpanStyle plus(@NotNull SpanStyle other) {
        t.i(other, "other");
        return merge(other);
    }

    @NotNull
    public String toString() {
        return "SpanStyle(color=" + ((Object) Color.m1606toStringimpl(m3308getColor0d7_KjU())) + ", brush=" + getBrush() + ", fontSize=" + ((Object) TextUnit.m3861toStringimpl(this.fontSize)) + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", fontSynthesis=" + this.fontSynthesis + ", fontFamily=" + this.fontFamily + ", fontFeatureSettings=" + this.fontFeatureSettings + ", letterSpacing=" + ((Object) TextUnit.m3861toStringimpl(this.letterSpacing)) + ", baselineShift=" + this.baselineShift + ", textGeometricTransform=" + this.textGeometricTransform + ", localeList=" + this.localeList + ", background=" + ((Object) Color.m1606toStringimpl(this.background)) + ", textDecoration=" + this.textDecoration + ", shadow=" + this.shadow + ", platformStyle=" + this.platformStyle + ')';
    }

    public /* synthetic */ SpanStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, k kVar) {
        this(j10, j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow);
    }

    @ExperimentalTextApi
    public /* synthetic */ SpanStyle(Brush brush, long j10, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j11, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j12, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, k kVar) {
        this(brush, j10, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j11, baselineShift, textGeometricTransform, localeList, j12, textDecoration, shadow, platformSpanStyle);
    }

    public /* synthetic */ SpanStyle(TextDrawStyle textDrawStyle, long j10, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j11, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j12, TextDecoration textDecoration, Shadow shadow, @ExperimentalTextApi PlatformSpanStyle platformSpanStyle, k kVar) {
        this(textDrawStyle, j10, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j11, baselineShift, textGeometricTransform, localeList, j12, textDecoration, shadow, platformSpanStyle);
    }

    private SpanStyle(TextDrawStyle textDrawStyle, long j10, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j11, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j12, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle) {
        this.textDrawStyle = textDrawStyle;
        this.fontSize = j10;
        this.fontWeight = fontWeight;
        this.fontStyle = fontStyle;
        this.fontSynthesis = fontSynthesis;
        this.fontFamily = fontFamily;
        this.fontFeatureSettings = str;
        this.letterSpacing = j11;
        this.baselineShift = baselineShift;
        this.textGeometricTransform = textGeometricTransform;
        this.localeList = localeList;
        this.background = j12;
        this.textDecoration = textDecoration;
        this.shadow = shadow;
        this.platformStyle = platformSpanStyle;
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getBrush$annotations() {
    }

    public /* synthetic */ SpanStyle(TextDrawStyle textDrawStyle, long j10, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j11, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j12, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, int i10, k kVar) {
        this(textDrawStyle, (i10 & 2) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j10, (i10 & 4) != 0 ? null : fontWeight, (i10 & 8) != 0 ? null : fontStyle, (i10 & 16) != 0 ? null : fontSynthesis, (i10 & 32) != 0 ? null : fontFamily, (i10 & 64) != 0 ? null : str, (i10 & 128) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j11, (i10 & 256) != 0 ? null : baselineShift, (i10 & 512) != 0 ? null : textGeometricTransform, (i10 & 1024) != 0 ? null : localeList, (i10 & 2048) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j12, (i10 & 4096) != 0 ? null : textDecoration, (i10 & 8192) != 0 ? null : shadow, (i10 & 16384) != 0 ? null : platformSpanStyle, (k) null);
    }

    public /* synthetic */ SpanStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, int i10, k kVar) {
        this((i10 & 1) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j10, (i10 & 2) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j11, (i10 & 4) != 0 ? null : fontWeight, (i10 & 8) != 0 ? null : fontStyle, (i10 & 16) != 0 ? null : fontSynthesis, (i10 & 32) != 0 ? null : fontFamily, (i10 & 64) != 0 ? null : str, (i10 & 128) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j12, (i10 & 256) != 0 ? null : baselineShift, (i10 & 512) != 0 ? null : textGeometricTransform, (i10 & 1024) != 0 ? null : localeList, (i10 & 2048) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j13, (i10 & 4096) != 0 ? null : textDecoration, (i10 & 8192) != 0 ? null : shadow, (k) null);
    }

    private SpanStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow) {
        this(TextDrawStyle.Companion.m3611from8_81llA(j10), j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, (PlatformSpanStyle) null, (k) null);
    }

    public /* synthetic */ SpanStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, int i10, k kVar) {
        this((i10 & 1) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j10, (i10 & 2) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j11, (i10 & 4) != 0 ? null : fontWeight, (i10 & 8) != 0 ? null : fontStyle, (i10 & 16) != 0 ? null : fontSynthesis, (i10 & 32) != 0 ? null : fontFamily, (i10 & 64) != 0 ? null : str, (i10 & 128) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j12, (i10 & 256) != 0 ? null : baselineShift, (i10 & 512) != 0 ? null : textGeometricTransform, (i10 & 1024) != 0 ? null : localeList, (i10 & 2048) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j13, (i10 & 4096) != 0 ? null : textDecoration, (i10 & 8192) != 0 ? null : shadow, (i10 & 16384) != 0 ? null : platformSpanStyle, (k) null);
    }

    private SpanStyle(long j10, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle) {
        this(TextDrawStyle.Companion.m3611from8_81llA(j10), j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, platformSpanStyle, (k) null);
    }

    public /* synthetic */ SpanStyle(Brush brush, long j10, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j11, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j12, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, int i10, k kVar) {
        this(brush, (i10 & 2) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j10, (i10 & 4) != 0 ? null : fontWeight, (i10 & 8) != 0 ? null : fontStyle, (i10 & 16) != 0 ? null : fontSynthesis, (i10 & 32) != 0 ? null : fontFamily, (i10 & 64) != 0 ? null : str, (i10 & 128) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j11, (i10 & 256) != 0 ? null : baselineShift, (i10 & 512) != 0 ? null : textGeometricTransform, (i10 & 1024) != 0 ? null : localeList, (i10 & 2048) != 0 ? Color.Companion.m1634getUnspecified0d7_KjU() : j12, (i10 & 4096) != 0 ? null : textDecoration, (i10 & 8192) != 0 ? null : shadow, (i10 & 16384) != 0 ? null : platformSpanStyle, (k) null);
    }

    private SpanStyle(Brush brush, long j10, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j11, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j12, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle) {
        this(TextDrawStyle.Companion.from(brush), j10, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j11, baselineShift, textGeometricTransform, localeList, j12, textDecoration, shadow, platformSpanStyle, (k) null);
    }
}
