package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PaintExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PaintExtensionsKt {
    private static final void extendWith(Rect rect, Rect rect2) {
        rect.right += rect2.width();
        rect.top = Math.min(rect.top, rect2.top);
        rect.bottom = Math.max(rect.bottom, rect2.bottom);
    }

    private static final void fillStringBounds(Paint paint, CharSequence charSequence, int i10, int i11, Rect rect) {
        if (Build.VERSION.SDK_INT >= 29) {
            Paint29.getTextBounds(paint, charSequence, i10, i11, rect);
        } else {
            paint.getTextBounds(charSequence.toString(), i10, i11, rect);
        }
    }

    @NotNull
    public static final Rect getCharSequenceBounds(@NotNull TextPaint textPaint, @NotNull CharSequence text, int i10, int i11) {
        t.i(textPaint, "<this>");
        t.i(text, "text");
        if (text instanceof Spanned) {
            Spanned spanned = (Spanned) text;
            if (SpannedExtensionsKt.hasSpan(spanned, MetricAffectingSpan.class, i10, i11)) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                while (i10 < i11) {
                    int iNextSpanTransition = spanned.nextSpanTransition(i10, i11, MetricAffectingSpan.class);
                    MetricAffectingSpan[] spans = (MetricAffectingSpan[]) spanned.getSpans(i10, iNextSpanTransition, MetricAffectingSpan.class);
                    textPaint2.set(textPaint);
                    t.h(spans, "spans");
                    for (MetricAffectingSpan metricAffectingSpan : spans) {
                        if (spanned.getSpanStart(metricAffectingSpan) != spanned.getSpanEnd(metricAffectingSpan)) {
                            metricAffectingSpan.updateMeasureState(textPaint2);
                        }
                    }
                    fillStringBounds(textPaint2, text, i10, iNextSpanTransition, rect2);
                    extendWith(rect, rect2);
                    i10 = iNextSpanTransition;
                }
                return rect;
            }
        }
        return getStringBounds(textPaint, text, i10, i11);
    }

    @VisibleForTesting
    @NotNull
    public static final Rect getStringBounds(@NotNull Paint paint, @NotNull CharSequence text, int i10, int i11) {
        t.i(paint, "<this>");
        t.i(text, "text");
        Rect rect = new Rect();
        fillStringBounds(paint, text, i10, i11, rect);
        return rect;
    }
}
