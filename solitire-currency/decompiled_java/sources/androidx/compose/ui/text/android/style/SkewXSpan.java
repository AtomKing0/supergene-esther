package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SkewXSpan.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public class SkewXSpan extends MetricAffectingSpan {
    private final float skewX;

    public SkewXSpan(float f10) {
        this.skewX = f10;
    }

    public final float getSkewX() {
        return this.skewX;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        t.i(textPaint, "textPaint");
        textPaint.setTextSkewX(this.skewX + textPaint.getTextSkewX());
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        t.i(textPaint, "textPaint");
        textPaint.setTextSkewX(this.skewX + textPaint.getTextSkewX());
    }
}
