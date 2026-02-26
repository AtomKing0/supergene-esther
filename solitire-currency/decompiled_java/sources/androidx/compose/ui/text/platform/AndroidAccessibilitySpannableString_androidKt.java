package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.RestrictTo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.InternalTextApi;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.c;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidAccessibilitySpannableString.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAccessibilitySpannableString_androidKt {
    private static final void setSpanStyle(SpannableString spannableString, SpanStyle spanStyle, int i10, int i11, Density density, FontFamily.Resolver resolver) {
        SpannableExtensions_androidKt.m3536setColorRPmYEkk(spannableString, spanStyle.m3308getColor0d7_KjU(), i10, i11);
        SpannableExtensions_androidKt.m3537setFontSizeKmRG4DE(spannableString, spanStyle.m3309getFontSizeXSAIIZE(), density, i10, i11);
        if (spanStyle.getFontWeight() != null || spanStyle.m3310getFontStyle4Lr2A7w() != null) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle fontStyleM3310getFontStyle4Lr2A7w = spanStyle.m3310getFontStyle4Lr2A7w();
            spannableString.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m3373getAndroidTypefaceStyleFO1MlWM(fontWeight, fontStyleM3310getFontStyle4Lr2A7w != null ? fontStyleM3310getFontStyle4Lr2A7w.m3416unboximpl() : FontStyle.Companion.m3418getNormal_LCdwA())), i10, i11, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                spannableString.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), i10, i11, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis fontSynthesisM3311getFontSynthesisZQGJjVo = spanStyle.m3311getFontSynthesisZQGJjVo();
                spannableString.setSpan(Api28Impl.INSTANCE.createTypefaceSpan((Typeface) c.a(resolver, fontFamily, null, 0, fontSynthesisM3311getFontSynthesisZQGJjVo != null ? fontSynthesisM3311getFontSynthesisZQGJjVo.m3427unboximpl() : FontSynthesis.Companion.m3428getAllGVVA2EU(), 6, null).getValue()), i10, i11, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            TextDecoration textDecoration = spanStyle.getTextDecoration();
            TextDecoration.Companion companion = TextDecoration.Companion;
            if (textDecoration.contains(companion.getUnderline())) {
                spannableString.setSpan(new UnderlineSpan(), i10, i11, 33);
            }
            if (spanStyle.getTextDecoration().contains(companion.getLineThrough())) {
                spannableString.setSpan(new StrikethroughSpan(), i10, i11, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            spannableString.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), i10, i11, 33);
        }
        SpannableExtensions_androidKt.setLocaleList(spannableString, spanStyle.getLocaleList(), i10, i11);
        SpannableExtensions_androidKt.m3534setBackgroundRPmYEkk(spannableString, spanStyle.m3306getBackground0d7_KjU(), i10, i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @InternalTextApi
    @NotNull
    public static final SpannableString toAccessibilitySpannableString(@NotNull AnnotatedString annotatedString, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        t.i(annotatedString, "<this>");
        t.i(density, "density");
        t.i(resourceLoader, "resourceLoader");
        return toAccessibilitySpannableString(annotatedString, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @InternalTextApi
    @NotNull
    public static final SpannableString toAccessibilitySpannableString(@NotNull AnnotatedString annotatedString, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver) {
        t.i(annotatedString, "<this>");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        SpannableString spannableString = new SpannableString(annotatedString.getText());
        List<AnnotatedString.Range<SpanStyle>> spanStyles = annotatedString.getSpanStyles();
        int size = spanStyles.size();
        for (int i10 = 0; i10 < size; i10++) {
            AnnotatedString.Range<SpanStyle> range = spanStyles.get(i10);
            SpanStyle spanStyleComponent1 = range.component1();
            setSpanStyle(spannableString, spanStyleComponent1.m3304copyIuqyXdg((16351 & 1) != 0 ? spanStyleComponent1.m3308getColor0d7_KjU() : 0L, (16351 & 2) != 0 ? spanStyleComponent1.fontSize : 0L, (16351 & 4) != 0 ? spanStyleComponent1.fontWeight : null, (16351 & 8) != 0 ? spanStyleComponent1.fontStyle : null, (16351 & 16) != 0 ? spanStyleComponent1.fontSynthesis : null, (16351 & 32) != 0 ? spanStyleComponent1.fontFamily : null, (16351 & 64) != 0 ? spanStyleComponent1.fontFeatureSettings : null, (16351 & 128) != 0 ? spanStyleComponent1.letterSpacing : 0L, (16351 & 256) != 0 ? spanStyleComponent1.baselineShift : null, (16351 & 512) != 0 ? spanStyleComponent1.textGeometricTransform : null, (16351 & 1024) != 0 ? spanStyleComponent1.localeList : null, (16351 & 2048) != 0 ? spanStyleComponent1.background : 0L, (16351 & 4096) != 0 ? spanStyleComponent1.textDecoration : null, (16351 & 8192) != 0 ? spanStyleComponent1.shadow : null), range.component2(), range.component3(), density, fontFamilyResolver);
        }
        List<AnnotatedString.Range<TtsAnnotation>> ttsAnnotations = annotatedString.getTtsAnnotations(0, annotatedString.length());
        int size2 = ttsAnnotations.size();
        for (int i11 = 0; i11 < size2; i11++) {
            AnnotatedString.Range<TtsAnnotation> range2 = ttsAnnotations.get(i11);
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan(range2.component1()), range2.component2(), range2.component3(), 33);
        }
        return spannableString;
    }
}
