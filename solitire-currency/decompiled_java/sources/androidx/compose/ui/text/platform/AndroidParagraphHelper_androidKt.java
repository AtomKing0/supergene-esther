package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.text.SpannableString;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.platform.extensions.PlaceholderExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import h9.r;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidParagraphHelper.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraphHelper_androidKt {
    @NotNull
    public static final CharSequence createCharSequence(@NotNull String text, float f10, @NotNull TextStyle contextTextStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, @NotNull Density density, @NotNull r<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> resolveTypeface) {
        t.i(text, "text");
        t.i(contextTextStyle, "contextTextStyle");
        t.i(spanStyles, "spanStyles");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(resolveTypeface, "resolveTypeface");
        if (spanStyles.isEmpty() && placeholders.isEmpty() && t.d(contextTextStyle.getTextIndent(), TextIndent.Companion.getNone()) && TextUnitKt.m3872isUnspecifiedR2X_6o(contextTextStyle.m3356getLineHeightXSAIIZE())) {
            return text;
        }
        SpannableString spannableString = new SpannableString(text);
        if (isIncludeFontPaddingEnabled(contextTextStyle) && contextTextStyle.getLineHeightStyle() == null) {
            SpannableExtensions_androidKt.m3539setLineHeightr9BaKPg(spannableString, contextTextStyle.m3356getLineHeightXSAIIZE(), f10, density);
        } else {
            LineHeightStyle lineHeightStyle = contextTextStyle.getLineHeightStyle();
            if (lineHeightStyle == null) {
                lineHeightStyle = LineHeightStyle.Companion.getDefault();
            }
            SpannableExtensions_androidKt.m3538setLineHeightKmRG4DE(spannableString, contextTextStyle.m3356getLineHeightXSAIIZE(), f10, density, lineHeightStyle);
        }
        SpannableExtensions_androidKt.setTextIndent(spannableString, contextTextStyle.getTextIndent(), f10, density);
        SpannableExtensions_androidKt.setSpanStyles(spannableString, contextTextStyle, spanStyles, density, resolveTypeface);
        PlaceholderExtensions_androidKt.setPlaceholders(spannableString, placeholders, density);
        return spannableString;
    }

    public static final boolean isIncludeFontPaddingEnabled(@NotNull TextStyle textStyle) {
        PlatformParagraphStyle paragraphStyle;
        t.i(textStyle, "<this>");
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        if (platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) {
            return true;
        }
        return paragraphStyle.getIncludeFontPadding();
    }
}
