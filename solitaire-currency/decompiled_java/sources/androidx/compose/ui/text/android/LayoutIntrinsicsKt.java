package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import java.text.BreakIterator;
import java.util.Comparator;
import java.util.PriorityQueue;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.s;

/* JADX INFO: compiled from: LayoutIntrinsics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutIntrinsicsKt {
    public static final float minIntrinsicWidth(@NotNull CharSequence text, @NotNull TextPaint paint) {
        t.i(text, "text");
        t.i(paint, "paint");
        BreakIterator lineInstance = BreakIterator.getLineInstance(paint.getTextLocale());
        int i10 = 0;
        lineInstance.setText(new CharSequenceCharacterIterator(text, 0, text.length()));
        PriorityQueue<s> priorityQueue = new PriorityQueue(10, new Comparator() { // from class: androidx.compose.ui.text.android.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return LayoutIntrinsicsKt.m3360minIntrinsicWidth$lambda0((s) obj, (s) obj2);
            }
        });
        int next = lineInstance.next();
        while (true) {
            int i11 = i10;
            i10 = next;
            if (i10 == -1) {
                break;
            }
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new s(Integer.valueOf(i11), Integer.valueOf(i10)));
            } else {
                s sVar = (s) priorityQueue.peek();
                if (sVar != null && ((Number) sVar.d()).intValue() - ((Number) sVar.c()).intValue() < i10 - i11) {
                    priorityQueue.poll();
                    priorityQueue.add(new s(Integer.valueOf(i11), Integer.valueOf(i10)));
                }
            }
            next = lineInstance.next();
        }
        float fMax = 0.0f;
        for (s sVar2 : priorityQueue) {
            fMax = Math.max(fMax, Layout.getDesiredWidth(text, ((Number) sVar2.a()).intValue(), ((Number) sVar2.b()).intValue(), paint));
        }
        return fMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: minIntrinsicWidth$lambda-0, reason: not valid java name */
    public static final int m3360minIntrinsicWidth$lambda0(s sVar, s sVar2) {
        return (((Number) sVar.d()).intValue() - ((Number) sVar.c()).intValue()) - (((Number) sVar2.d()).intValue() - ((Number) sVar2.c()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldIncreaseMaxIntrinsic(float f10, CharSequence charSequence, TextPaint textPaint) {
        if (!(f10 == 0.0f) && (charSequence instanceof Spanned)) {
            if (!(textPaint.getLetterSpacing() == 0.0f)) {
                return true;
            }
            Spanned spanned = (Spanned) charSequence;
            if (SpannedExtensionsKt.hasSpan(spanned, LetterSpacingSpanPx.class) || SpannedExtensionsKt.hasSpan(spanned, LetterSpacingSpanEm.class)) {
                return true;
            }
        }
        return false;
    }
}
