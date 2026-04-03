package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LetterSpacingSpanEm.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class LetterSpacingSpanEm extends MetricAffectingSpan {
    private final float letterSpacing;

    public LetterSpacingSpanEm(float f10) {
        this.letterSpacing = f10;
    }

    public final float getLetterSpacing() {
        return this.letterSpacing;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        t.i(textPaint, "textPaint");
        textPaint.setLetterSpacing(this.letterSpacing);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        t.i(textPaint, "textPaint");
        textPaint.setLetterSpacing(this.letterSpacing);
    }
}
