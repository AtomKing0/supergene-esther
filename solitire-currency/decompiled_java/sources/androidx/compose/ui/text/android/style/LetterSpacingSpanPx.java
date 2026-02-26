package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.Px;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LetterSpacingSpanPx.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class LetterSpacingSpanPx extends MetricAffectingSpan {
    private final float letterSpacing;

    public LetterSpacingSpanPx(@Px float f10) {
        this.letterSpacing = f10;
    }

    private final void updatePaint(TextPaint textPaint) {
        float textSize = textPaint.getTextSize() * textPaint.getTextScaleX();
        if (textSize == 0.0f) {
            return;
        }
        textPaint.setLetterSpacing(this.letterSpacing / textSize);
    }

    public final float getLetterSpacing() {
        return this.letterSpacing;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        t.i(textPaint, "textPaint");
        updatePaint(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        t.i(textPaint, "textPaint");
        updatePaint(textPaint);
    }
}
