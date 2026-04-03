package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ParagraphStyle.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ParagraphStyle {
    private final long lineHeight;

    @Nullable
    private final LineHeightStyle lineHeightStyle;

    @Nullable
    private final PlatformParagraphStyle platformStyle;

    @Nullable
    private final TextAlign textAlign;

    @Nullable
    private final TextDirection textDirection;

    @Nullable
    private final TextIndent textIndent;

    @ExperimentalTextApi
    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j10, TextIndent textIndent, @ExperimentalTextApi PlatformParagraphStyle platformParagraphStyle, @ExperimentalTextApi LineHeightStyle lineHeightStyle, k kVar) {
        this(textAlign, textDirection, j10, textIndent, platformParagraphStyle, lineHeightStyle);
    }

    /* JADX INFO: renamed from: copy-Elsmlbk$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m3264copyElsmlbk$default(ParagraphStyle paragraphStyle, TextAlign textAlign, TextDirection textDirection, long j10, TextIndent textIndent, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            textAlign = paragraphStyle.textAlign;
        }
        if ((i10 & 2) != 0) {
            textDirection = paragraphStyle.textDirection;
        }
        TextDirection textDirection2 = textDirection;
        if ((i10 & 4) != 0) {
            j10 = paragraphStyle.lineHeight;
        }
        long j11 = j10;
        if ((i10 & 8) != 0) {
            textIndent = paragraphStyle.textIndent;
        }
        return paragraphStyle.m3266copyElsmlbk(textAlign, textDirection2, j11, textIndent);
    }

    /* JADX INFO: renamed from: copy-xPh5V4g$default, reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m3265copyxPh5V4g$default(ParagraphStyle paragraphStyle, TextAlign textAlign, TextDirection textDirection, long j10, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            textAlign = paragraphStyle.textAlign;
        }
        if ((i10 & 2) != 0) {
            textDirection = paragraphStyle.textDirection;
        }
        TextDirection textDirection2 = textDirection;
        if ((i10 & 4) != 0) {
            j10 = paragraphStyle.lineHeight;
        }
        long j11 = j10;
        if ((i10 & 8) != 0) {
            textIndent = paragraphStyle.textIndent;
        }
        TextIndent textIndent2 = textIndent;
        if ((i10 & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        PlatformParagraphStyle platformParagraphStyle2 = platformParagraphStyle;
        if ((i10 & 32) != 0) {
            lineHeightStyle = paragraphStyle.lineHeightStyle;
        }
        return paragraphStyle.m3267copyxPh5V4g(textAlign, textDirection2, j11, textIndent2, platformParagraphStyle2, lineHeightStyle);
    }

    public static /* synthetic */ ParagraphStyle merge$default(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            paragraphStyle2 = null;
        }
        return paragraphStyle.merge(paragraphStyle2);
    }

    private final PlatformParagraphStyle mergePlatformStyle(PlatformParagraphStyle platformParagraphStyle) {
        PlatformParagraphStyle platformParagraphStyle2 = this.platformStyle;
        return platformParagraphStyle2 == null ? platformParagraphStyle : platformParagraphStyle == null ? platformParagraphStyle2 : platformParagraphStyle2.merge(platformParagraphStyle);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-Elsmlbk, reason: not valid java name */
    public final ParagraphStyle m3266copyElsmlbk(@Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j10, @Nullable TextIndent textIndent) {
        return new ParagraphStyle(textAlign, textDirection, j10, textIndent, this.platformStyle, this.lineHeightStyle, null);
    }

    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: copy-xPh5V4g, reason: not valid java name */
    public final ParagraphStyle m3267copyxPh5V4g(@Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j10, @Nullable TextIndent textIndent, @Nullable PlatformParagraphStyle platformParagraphStyle, @Nullable LineHeightStyle lineHeightStyle) {
        return new ParagraphStyle(textAlign, textDirection, j10, textIndent, platformParagraphStyle, lineHeightStyle, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        return t.d(this.textAlign, paragraphStyle.textAlign) && t.d(this.textDirection, paragraphStyle.textDirection) && TextUnit.m3851equalsimpl0(this.lineHeight, paragraphStyle.lineHeight) && t.d(this.textIndent, paragraphStyle.textIndent) && t.d(this.platformStyle, paragraphStyle.platformStyle) && t.d(this.lineHeightStyle, paragraphStyle.lineHeightStyle);
    }

    /* JADX INFO: renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m3268getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    @ExperimentalTextApi
    @Nullable
    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    @ExperimentalTextApi
    @Nullable
    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    @Nullable
    /* JADX INFO: renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final TextAlign m3269getTextAlignbuA522U() {
        return this.textAlign;
    }

    @Nullable
    /* JADX INFO: renamed from: getTextDirection-mmuk1to, reason: not valid java name */
    public final TextDirection m3270getTextDirectionmmuk1to() {
        return this.textDirection;
    }

    @Nullable
    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public int hashCode() {
        TextAlign textAlign = this.textAlign;
        int iM3590hashCodeimpl = (textAlign != null ? TextAlign.m3590hashCodeimpl(textAlign.m3592unboximpl()) : 0) * 31;
        TextDirection textDirection = this.textDirection;
        int iM3603hashCodeimpl = (((iM3590hashCodeimpl + (textDirection != null ? TextDirection.m3603hashCodeimpl(textDirection.m3605unboximpl()) : 0)) * 31) + TextUnit.m3855hashCodeimpl(this.lineHeight)) * 31;
        TextIndent textIndent = this.textIndent;
        int iHashCode = (iM3603hashCodeimpl + (textIndent != null ? textIndent.hashCode() : 0)) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        int iHashCode2 = (iHashCode + (platformParagraphStyle != null ? platformParagraphStyle.hashCode() : 0)) * 31;
        LineHeightStyle lineHeightStyle = this.lineHeightStyle;
        return iHashCode2 + (lineHeightStyle != null ? lineHeightStyle.hashCode() : 0);
    }

    @Stable
    @NotNull
    public final ParagraphStyle merge(@Nullable ParagraphStyle paragraphStyle) {
        if (paragraphStyle == null) {
            return this;
        }
        long j10 = TextUnitKt.m3872isUnspecifiedR2X_6o(paragraphStyle.lineHeight) ? this.lineHeight : paragraphStyle.lineHeight;
        TextIndent textIndent = paragraphStyle.textIndent;
        if (textIndent == null) {
            textIndent = this.textIndent;
        }
        TextIndent textIndent2 = textIndent;
        TextAlign textAlign = paragraphStyle.textAlign;
        if (textAlign == null) {
            textAlign = this.textAlign;
        }
        TextAlign textAlign2 = textAlign;
        TextDirection textDirection = paragraphStyle.textDirection;
        if (textDirection == null) {
            textDirection = this.textDirection;
        }
        TextDirection textDirection2 = textDirection;
        PlatformParagraphStyle platformParagraphStyleMergePlatformStyle = mergePlatformStyle(paragraphStyle.platformStyle);
        LineHeightStyle lineHeightStyle = paragraphStyle.lineHeightStyle;
        if (lineHeightStyle == null) {
            lineHeightStyle = this.lineHeightStyle;
        }
        return new ParagraphStyle(textAlign2, textDirection2, j10, textIndent2, platformParagraphStyleMergePlatformStyle, lineHeightStyle, null);
    }

    @Stable
    @NotNull
    public final ParagraphStyle plus(@NotNull ParagraphStyle other) {
        t.i(other, "other");
        return merge(other);
    }

    @NotNull
    public String toString() {
        return "ParagraphStyle(textAlign=" + this.textAlign + ", textDirection=" + this.textDirection + ", lineHeight=" + ((Object) TextUnit.m3861toStringimpl(this.lineHeight)) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ')';
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j10, TextIndent textIndent, k kVar) {
        this(textAlign, textDirection, j10, textIndent);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j10, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle) {
        this.textAlign = textAlign;
        this.textDirection = textDirection;
        this.lineHeight = j10;
        this.textIndent = textIndent;
        this.platformStyle = platformParagraphStyle;
        this.lineHeightStyle = lineHeightStyle;
        if (TextUnit.m3851equalsimpl0(j10, TextUnit.Companion.m3865getUnspecifiedXSAIIZE())) {
            return;
        }
        if (TextUnit.m3854getValueimpl(j10) >= 0.0f) {
            return;
        }
        throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.m3854getValueimpl(j10) + ')').toString());
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j10, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i10, k kVar) {
        this((i10 & 1) != 0 ? null : textAlign, (i10 & 2) != 0 ? null : textDirection, (i10 & 4) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j10, (i10 & 8) != 0 ? null : textIndent, (i10 & 16) != 0 ? null : platformParagraphStyle, (i10 & 32) == 0 ? lineHeightStyle : null, null);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j10, TextIndent textIndent, int i10, k kVar) {
        this((i10 & 1) != 0 ? null : textAlign, (i10 & 2) != 0 ? null : textDirection, (i10 & 4) != 0 ? TextUnit.Companion.m3865getUnspecifiedXSAIIZE() : j10, (i10 & 8) != 0 ? null : textIndent, null);
    }

    private ParagraphStyle(TextAlign textAlign, TextDirection textDirection, long j10, TextIndent textIndent) {
        this(textAlign, textDirection, j10, textIndent, null, null, null);
    }
}
