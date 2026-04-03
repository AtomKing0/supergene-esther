package androidx.compose.ui.text.android;

import android.graphics.Rect;
import android.text.Spanned;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.s;

/* JADX INFO: compiled from: TextLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutKt {

    @NotNull
    private static final s<Integer, Integer> EmptyPair = new s<>(0, 0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final s<Integer, Integer> getLineHeightPaddings(TextLayout textLayout) {
        int iMax = 0;
        int iMax2 = 0;
        for (LineHeightStyleSpan lineHeightStyleSpan : getLineHeightSpans(textLayout)) {
            if (lineHeightStyleSpan.getFirstAscentDiff() < 0) {
                iMax = Math.max(iMax, Math.abs(lineHeightStyleSpan.getFirstAscentDiff()));
            }
            if (lineHeightStyleSpan.getLastDescentDiff() < 0) {
                iMax2 = Math.max(iMax, Math.abs(lineHeightStyleSpan.getLastDescentDiff()));
            }
        }
        return (iMax == 0 && iMax2 == 0) ? EmptyPair : new s<>(Integer.valueOf(iMax), Integer.valueOf(iMax2));
    }

    private static final LineHeightStyleSpan[] getLineHeightSpans(TextLayout textLayout) {
        if (!(textLayout.getText() instanceof Spanned)) {
            return new LineHeightStyleSpan[0];
        }
        LineHeightStyleSpan[] lineHeightStyleSpans = (LineHeightStyleSpan[]) ((Spanned) textLayout.getText()).getSpans(0, textLayout.getText().length(), LineHeightStyleSpan.class);
        t.h(lineHeightStyleSpans, "lineHeightStyleSpans");
        return lineHeightStyleSpans.length == 0 ? new LineHeightStyleSpan[0] : lineHeightStyleSpans;
    }

    @NotNull
    public static final TextDirectionHeuristic getTextDirectionHeuristic(int i10) {
        if (i10 == 0) {
            TextDirectionHeuristic LTR = TextDirectionHeuristics.LTR;
            t.h(LTR, "LTR");
            return LTR;
        }
        if (i10 == 1) {
            TextDirectionHeuristic RTL = TextDirectionHeuristics.RTL;
            t.h(RTL, "RTL");
            return RTL;
        }
        if (i10 == 2) {
            TextDirectionHeuristic FIRSTSTRONG_LTR = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            t.h(FIRSTSTRONG_LTR, "FIRSTSTRONG_LTR");
            return FIRSTSTRONG_LTR;
        }
        if (i10 == 3) {
            TextDirectionHeuristic FIRSTSTRONG_RTL = TextDirectionHeuristics.FIRSTSTRONG_RTL;
            t.h(FIRSTSTRONG_RTL, "FIRSTSTRONG_RTL");
            return FIRSTSTRONG_RTL;
        }
        if (i10 == 4) {
            TextDirectionHeuristic ANYRTL_LTR = TextDirectionHeuristics.ANYRTL_LTR;
            t.h(ANYRTL_LTR, "ANYRTL_LTR");
            return ANYRTL_LTR;
        }
        if (i10 != 5) {
            TextDirectionHeuristic FIRSTSTRONG_LTR2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            t.h(FIRSTSTRONG_LTR2, "FIRSTSTRONG_LTR");
            return FIRSTSTRONG_LTR2;
        }
        TextDirectionHeuristic LOCALE = TextDirectionHeuristics.LOCALE;
        t.h(LOCALE, "LOCALE");
        return LOCALE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final s<Integer, Integer> getVerticalPaddings(TextLayout textLayout) {
        if (textLayout.getIncludePadding() || textLayout.isFallbackLinespacingApplied$ui_text_release()) {
            return new s<>(0, 0);
        }
        TextPaint paint = textLayout.getLayout().getPaint();
        CharSequence text = textLayout.getLayout().getText();
        t.h(paint, "paint");
        t.h(text, "text");
        Rect charSequenceBounds = PaintExtensionsKt.getCharSequenceBounds(paint, text, textLayout.getLayout().getLineStart(0), textLayout.getLayout().getLineEnd(0));
        int lineAscent = textLayout.getLayout().getLineAscent(0);
        int i10 = charSequenceBounds.top;
        int topPadding = i10 < lineAscent ? lineAscent - i10 : textLayout.getLayout().getTopPadding();
        if (textLayout.getLineCount() != 1) {
            int lineCount = textLayout.getLayout().getLineCount() - 1;
            charSequenceBounds = PaintExtensionsKt.getCharSequenceBounds(paint, text, textLayout.getLayout().getLineStart(lineCount), textLayout.getLayout().getLineEnd(lineCount));
        }
        int lineDescent = textLayout.getLayout().getLineDescent(textLayout.getLayout().getLineCount() - 1);
        int i11 = charSequenceBounds.bottom;
        int bottomPadding = i11 > lineDescent ? i11 - lineDescent : textLayout.getLayout().getBottomPadding();
        return (topPadding == 0 && bottomPadding == 0) ? EmptyPair : new s<>(Integer.valueOf(topPadding), Integer.valueOf(bottomPadding));
    }
}
