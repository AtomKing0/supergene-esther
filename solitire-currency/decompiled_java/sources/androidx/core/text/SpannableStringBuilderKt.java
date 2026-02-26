package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SpannableStringBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpannableStringBuilderKt {
    @NotNull
    public static final SpannableStringBuilder backgroundColor(@NotNull SpannableStringBuilder spannableStringBuilder, @ColorInt int i10, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i10);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder bold(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannedString buildSpannedString(@NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        lVar.invoke(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    @NotNull
    public static final SpannableStringBuilder color(@NotNull SpannableStringBuilder spannableStringBuilder, @ColorInt int i10, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i10);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder inSpans(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Object[] objArr, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        for (Object obj : objArr) {
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder italic(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder scale(@NotNull SpannableStringBuilder spannableStringBuilder, float f10, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f10);
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder strikeThrough(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder subscript(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder superscript(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder underline(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder inSpans(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Object obj, @NotNull h9.l<? super SpannableStringBuilder, k0> lVar) {
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
