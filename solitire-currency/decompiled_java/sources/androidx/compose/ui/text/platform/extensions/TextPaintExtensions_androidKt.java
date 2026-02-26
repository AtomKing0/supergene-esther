package androidx.compose.ui.text.platform.extensions;

import androidx.compose.ui.text.SpanStyle;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextPaintExtensions.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextPaintExtensions_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a5  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.text.SpanStyle applySpanStyle(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.platform.AndroidTextPaint r24, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.SpanStyle r25, @org.jetbrains.annotations.NotNull h9.r<? super androidx.compose.ui.text.font.FontFamily, ? super androidx.compose.ui.text.font.FontWeight, ? super androidx.compose.ui.text.font.FontStyle, ? super androidx.compose.ui.text.font.FontSynthesis, ? extends android.graphics.Typeface> r26, @org.jetbrains.annotations.NotNull androidx.compose.ui.unit.Density r27) {
        /*
            Method dump skipped, instruction units count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt.applySpanStyle(androidx.compose.ui.text.platform.AndroidTextPaint, androidx.compose.ui.text.SpanStyle, h9.r, androidx.compose.ui.unit.Density):androidx.compose.ui.text.SpanStyle");
    }

    public static final boolean hasFontAttributes(@NotNull SpanStyle spanStyle) {
        t.i(spanStyle, "<this>");
        return (spanStyle.getFontFamily() == null && spanStyle.m3310getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) ? false : true;
    }
}
