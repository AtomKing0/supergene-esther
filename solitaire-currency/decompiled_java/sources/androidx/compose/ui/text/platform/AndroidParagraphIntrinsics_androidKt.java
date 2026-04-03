package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.intl.AndroidLocale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import androidx.core.text.TextUtilsCompat;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidParagraphIntrinsics.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraphIntrinsics_androidKt {
    @NotNull
    public static final ParagraphIntrinsics ActualParagraphIntrinsics(@NotNull String text, @NotNull TextStyle style, @NotNull List<AnnotatedString.Range<SpanStyle>> spanStyles, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver) {
        t.i(text, "text");
        t.i(style, "style");
        t.i(spanStyles, "spanStyles");
        t.i(placeholders, "placeholders");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        return new AndroidParagraphIntrinsics(text, style, spanStyles, placeholders, fontFamilyResolver, density);
    }

    /* JADX INFO: renamed from: resolveTextDirectionHeuristics-9GRLPo0, reason: not valid java name */
    public static final int m3519resolveTextDirectionHeuristics9GRLPo0(@Nullable TextDirection textDirection, @Nullable LocaleList localeList) {
        Locale javaLocale;
        int iM3605unboximpl = textDirection != null ? textDirection.m3605unboximpl() : TextDirection.Companion.m3606getContents_7Xco();
        TextDirection.Companion companion = TextDirection.Companion;
        if (TextDirection.m3602equalsimpl0(iM3605unboximpl, companion.m3607getContentOrLtrs_7Xco())) {
            return 2;
        }
        if (!TextDirection.m3602equalsimpl0(iM3605unboximpl, companion.m3608getContentOrRtls_7Xco())) {
            if (TextDirection.m3602equalsimpl0(iM3605unboximpl, companion.m3609getLtrs_7Xco())) {
                return 0;
            }
            if (TextDirection.m3602equalsimpl0(iM3605unboximpl, companion.m3610getRtls_7Xco())) {
                return 1;
            }
            if (!TextDirection.m3602equalsimpl0(iM3605unboximpl, companion.m3606getContents_7Xco())) {
                throw new IllegalStateException("Invalid TextDirection.".toString());
            }
            if (localeList == null || (javaLocale = ((AndroidLocale) localeList.get(0).getPlatformLocale$ui_text_release()).getJavaLocale()) == null) {
                javaLocale = Locale.getDefault();
            }
            int layoutDirectionFromLocale = TextUtilsCompat.getLayoutDirectionFromLocale(javaLocale);
            if (layoutDirectionFromLocale == 0 || layoutDirectionFromLocale != 1) {
                return 2;
            }
        }
        return 3;
    }

    /* JADX INFO: renamed from: resolveTextDirectionHeuristics-9GRLPo0$default, reason: not valid java name */
    public static /* synthetic */ int m3520resolveTextDirectionHeuristics9GRLPo0$default(TextDirection textDirection, LocaleList localeList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            textDirection = null;
        }
        if ((i10 & 2) != 0) {
            localeList = null;
        }
        return m3519resolveTextDirectionHeuristics9GRLPo0(textDirection, localeList);
    }
}
