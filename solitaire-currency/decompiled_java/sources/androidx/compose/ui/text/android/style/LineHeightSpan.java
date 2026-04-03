package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LineHeightSpan.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class LineHeightSpan implements android.text.style.LineHeightSpan {
    private final float lineHeight;

    public LineHeightSpan(float f10) {
        this.lineHeight = f10;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(@NotNull CharSequence text, int i10, int i11, int i12, int i13, @NotNull Paint.FontMetricsInt fontMetricsInt) {
        t.i(text, "text");
        t.i(fontMetricsInt, "fontMetricsInt");
        int iLineHeight = LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        if (iLineHeight <= 0) {
            return;
        }
        int iCeil = (int) Math.ceil(this.lineHeight);
        int iCeil2 = (int) Math.ceil(((double) fontMetricsInt.descent) * ((double) ((iCeil * 1.0f) / iLineHeight)));
        fontMetricsInt.descent = iCeil2;
        fontMetricsInt.ascent = iCeil2 - iCeil;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }
}
