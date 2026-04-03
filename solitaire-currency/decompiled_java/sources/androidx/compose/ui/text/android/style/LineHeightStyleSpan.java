package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.annotation.IntRange;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LineHeightStyleSpan.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {
    private int ascent;
    private int descent;
    private final int endIndex;
    private int firstAscent;
    private int firstAscentDiff;
    private int lastDescent;
    private int lastDescentDiff;
    private final float lineHeight;
    private final int startIndex;
    private final int topPercentage;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;

    public LineHeightStyleSpan(float f10, int i10, int i11, boolean z10, boolean z11, @IntRange(from = 0, to = AndroidComposeViewAccessibilityDelegateCompat.SendRecurringAccessibilityEventsIntervalMillis) int i12) {
        this.lineHeight = f10;
        this.startIndex = i10;
        this.endIndex = i11;
        this.trimFirstLineTop = z10;
        this.trimLastLineBottom = z11;
        this.topPercentage = i12;
        boolean z12 = true;
        if (!(i12 >= 0 && i12 < 101) && i12 != -1) {
            z12 = false;
        }
        if (!z12) {
            throw new IllegalStateException("topRatio should be in [0..100] range or -1".toString());
        }
    }

    private final void calculateTargetMetrics(Paint.FontMetricsInt fontMetricsInt) {
        int iCeil = (int) Math.ceil(this.lineHeight);
        int iLineHeight = iCeil - LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        int iAbs = this.topPercentage;
        if (iAbs == -1) {
            iAbs = (int) ((Math.abs(fontMetricsInt.ascent) / LineHeightStyleSpanKt.lineHeight(fontMetricsInt)) * 100.0f);
        }
        int iCeil2 = (int) (iLineHeight <= 0 ? Math.ceil((iLineHeight * iAbs) / 100.0f) : Math.ceil((iLineHeight * (100 - iAbs)) / 100.0f));
        int i10 = fontMetricsInt.descent;
        int i11 = iCeil2 + i10;
        this.descent = i11;
        int i12 = i11 - iCeil;
        this.ascent = i12;
        if (this.trimFirstLineTop) {
            i12 = fontMetricsInt.ascent;
        }
        this.firstAscent = i12;
        if (this.trimLastLineBottom) {
            i11 = i10;
        }
        this.lastDescent = i11;
        this.firstAscentDiff = fontMetricsInt.ascent - i12;
        this.lastDescentDiff = i11 - i10;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(@NotNull CharSequence text, int i10, int i11, int i12, int i13, @NotNull Paint.FontMetricsInt fontMetricsInt) {
        t.i(text, "text");
        t.i(fontMetricsInt, "fontMetricsInt");
        if (LineHeightStyleSpanKt.lineHeight(fontMetricsInt) <= 0) {
            return;
        }
        boolean z10 = i10 == this.startIndex;
        boolean z11 = i11 == this.endIndex;
        if (z10 && z11 && this.trimFirstLineTop && this.trimLastLineBottom) {
            return;
        }
        if (z10) {
            calculateTargetMetrics(fontMetricsInt);
        }
        fontMetricsInt.ascent = z10 ? this.firstAscent : this.ascent;
        fontMetricsInt.descent = z11 ? this.lastDescent : this.descent;
    }

    public final int getFirstAscentDiff() {
        return this.firstAscentDiff;
    }

    public final int getLastDescentDiff() {
        return this.lastDescentDiff;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }
}
