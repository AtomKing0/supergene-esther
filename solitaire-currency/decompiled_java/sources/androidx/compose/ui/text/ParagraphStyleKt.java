package androidx.compose.ui.text;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ParagraphStyle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.Companion.m3865getUnspecifiedXSAIIZE();

    @Stable
    @NotNull
    public static final ParagraphStyle lerp(@NotNull ParagraphStyle start, @NotNull ParagraphStyle stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        TextAlign textAlign = (TextAlign) SpanStyleKt.lerpDiscrete(start.m3269getTextAlignbuA522U(), stop.m3269getTextAlignbuA522U(), f10);
        TextDirection textDirection = (TextDirection) SpanStyleKt.lerpDiscrete(start.m3270getTextDirectionmmuk1to(), stop.m3270getTextDirectionmmuk1to(), f10);
        long jM3313lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m3313lerpTextUnitInheritableC3pnCVY(start.m3268getLineHeightXSAIIZE(), stop.m3268getLineHeightXSAIIZE(), f10);
        TextIndent textIndent = start.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = stop.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(textAlign, textDirection, jM3313lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f10), lerpPlatformStyle(start.getPlatformStyle(), stop.getPlatformStyle(), f10), (LineHeightStyle) SpanStyleKt.lerpDiscrete(start.getLineHeightStyle(), stop.getLineHeightStyle(), f10), null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f10) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.Companion.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f10);
    }

    @NotNull
    public static final ParagraphStyle resolveParagraphStyleDefaults(@NotNull ParagraphStyle style, @NotNull LayoutDirection direction) {
        t.i(style, "style");
        t.i(direction, "direction");
        TextAlign textAlignM3269getTextAlignbuA522U = style.m3269getTextAlignbuA522U();
        TextAlign textAlignM3586boximpl = TextAlign.m3586boximpl(textAlignM3269getTextAlignbuA522U != null ? textAlignM3269getTextAlignbuA522U.m3592unboximpl() : TextAlign.Companion.m3598getStarte0LSkKk());
        TextDirection textDirectionM3599boximpl = TextDirection.m3599boximpl(TextStyleKt.m3359resolveTextDirectionYj3eThk(direction, style.m3270getTextDirectionmmuk1to()));
        long jM3268getLineHeightXSAIIZE = TextUnitKt.m3872isUnspecifiedR2X_6o(style.m3268getLineHeightXSAIIZE()) ? DefaultLineHeight : style.m3268getLineHeightXSAIIZE();
        TextIndent textIndent = style.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(textAlignM3586boximpl, textDirectionM3599boximpl, jM3268getLineHeightXSAIIZE, textIndent, style.getPlatformStyle(), style.getLineHeightStyle(), null);
    }
}
