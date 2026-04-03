package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontFeatureSpan.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class FontFeatureSpan extends MetricAffectingSpan {

    @NotNull
    private final String fontFeatureSettings;

    public FontFeatureSpan(@NotNull String fontFeatureSettings) {
        t.i(fontFeatureSettings, "fontFeatureSettings");
        this.fontFeatureSettings = fontFeatureSettings;
    }

    @NotNull
    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        t.i(textPaint, "textPaint");
        textPaint.setFontFeatureSettings(this.fontFeatureSettings);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        t.i(textPaint, "textPaint");
        textPaint.setFontFeatureSettings(this.fontFeatureSettings);
    }
}
