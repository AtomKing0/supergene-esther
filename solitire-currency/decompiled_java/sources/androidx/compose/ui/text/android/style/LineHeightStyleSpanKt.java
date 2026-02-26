package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LineHeightStyleSpan.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LineHeightStyleSpanKt {
    public static final int lineHeight(@NotNull Paint.FontMetricsInt fontMetricsInt) {
        t.i(fontMetricsInt, "<this>");
        return fontMetricsInt.descent - fontMetricsInt.ascent;
    }
}
