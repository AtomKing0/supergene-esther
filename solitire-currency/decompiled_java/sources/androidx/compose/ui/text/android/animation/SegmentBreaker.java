package androidx.compose.ui.text.android.animation;

import android.text.Layout;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import androidx.compose.ui.text.android.LayoutCompatKt;
import androidx.compose.ui.text.android.LayoutHelper;
import java.text.Bidi;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import kotlin.collections.d0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: compiled from: SegmentBreaker.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class SegmentBreaker {

    @NotNull
    public static final SegmentBreaker INSTANCE = new SegmentBreaker();

    /* JADX INFO: compiled from: SegmentBreaker.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SegmentType.values().length];
            iArr[SegmentType.Document.ordinal()] = 1;
            iArr[SegmentType.Paragraph.ordinal()] = 2;
            iArr[SegmentType.Line.ordinal()] = 3;
            iArr[SegmentType.Word.ordinal()] = 4;
            iArr[SegmentType.Character.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SegmentBreaker() {
    }

    private final List<Integer> breakInWords(LayoutHelper layoutHelper) {
        CharSequence text = layoutHelper.getLayout().getText();
        t.h(text, "text");
        BreakIterator lineInstance = BreakIterator.getLineInstance(Locale.getDefault());
        t.h(lineInstance, "getLineInstance(Locale.getDefault())");
        List<Integer> listBreakWithBreakIterator = breakWithBreakIterator(text, lineInstance);
        TreeSet treeSet = new TreeSet();
        int size = listBreakWithBreakIterator.size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(Integer.valueOf(listBreakWithBreakIterator.get(i10).intValue()));
        }
        int paragraphCount = layoutHelper.getParagraphCount();
        for (int i11 = 0; i11 < paragraphCount; i11++) {
            Bidi bidiAnalyzeBidi = layoutHelper.analyzeBidi(i11);
            if (bidiAnalyzeBidi != null) {
                int paragraphStart = layoutHelper.getParagraphStart(i11);
                int runCount = bidiAnalyzeBidi.getRunCount();
                for (int i12 = 0; i12 < runCount; i12++) {
                    treeSet.add(Integer.valueOf(bidiAnalyzeBidi.getRunStart(i12) + paragraphStart));
                }
            }
        }
        return d0.P0(treeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<androidx.compose.ui.text.android.animation.Segment> breakSegmentWithChar(androidx.compose.ui.text.android.LayoutHelper r21, boolean r22) {
        /*
            r20 = this;
            r0 = r21
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            androidx.compose.ui.text.android.animation.SegmentType r2 = androidx.compose.ui.text.android.animation.SegmentType.Character
            r3 = r20
            java.util.List r2 = r3.breakOffsets(r0, r2)
            int r4 = r2.size()
            if (r4 == 0) goto Lba
            int r4 = r2.size()
            r5 = 1
            if (r4 != r5) goto L1e
            goto Lba
        L1e:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r6 = 0
            java.lang.Object r7 = r2.get(r6)
            int r8 = kotlin.collections.t.m(r2)
            r9 = r6
        L2d:
            if (r9 >= r8) goto Lbd
            int r9 = r9 + 1
            java.lang.Object r10 = r2.get(r9)
            r11 = r10
            java.lang.Number r11 = (java.lang.Number) r11
            int r14 = r11.intValue()
            java.lang.Number r7 = (java.lang.Number) r7
            int r13 = r7.intValue()
            android.text.Layout r7 = r21.getLayout()
            if (r22 == 0) goto L5d
            int r11 = r13 + 1
            if (r14 != r11) goto L5d
            java.lang.CharSequence r11 = r7.getText()
            char r11 = r11.charAt(r13)
            boolean r11 = r0.isLineEndSpace(r11)
            if (r11 == 0) goto L5d
            r19 = r8
            goto Lae
        L5d:
            int r11 = androidx.compose.ui.text.android.LayoutCompatKt.getLineForOffset(r7, r13, r6)
            int r12 = r7.getParagraphDirection(r11)
            r15 = -1
            if (r12 != r15) goto L6a
            r12 = r5
            goto L6b
        L6a:
            r12 = r6
        L6b:
            boolean r15 = r7.isRtlCharAt(r13)
            if (r15 != r12) goto L72
            goto L73
        L72:
            r5 = r6
        L73:
            float r5 = r0.getHorizontalPosition(r13, r5, r6)
            r16 = r7
            double r6 = (double) r5
            double r5 = java.lang.Math.ceil(r6)
            float r5 = (float) r5
            int r5 = (int) r5
            if (r15 != r12) goto L84
            r6 = 1
            goto L85
        L84:
            r6 = 0
        L85:
            r7 = 1
            float r6 = r0.getHorizontalPosition(r14, r6, r7)
            r19 = r8
            double r7 = (double) r6
            double r6 = java.lang.Math.ceil(r7)
            float r6 = (float) r6
            int r6 = (int) r6
            androidx.compose.ui.text.android.animation.Segment r7 = new androidx.compose.ui.text.android.animation.Segment
            int r15 = java.lang.Math.min(r5, r6)
            r8 = r16
            int r16 = r8.getLineTop(r11)
            int r17 = java.lang.Math.max(r5, r6)
            int r18 = r8.getLineBottom(r11)
            r12 = r7
            r12.<init>(r13, r14, r15, r16, r17, r18)
            r1.add(r7)
        Lae:
            v8.k0 r5 = v8.k0.f35197a
            r4.add(r5)
            r7 = r10
            r8 = r19
            r5 = 1
            r6 = 0
            goto L2d
        Lba:
            kotlin.collections.t.l()
        Lbd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.animation.SegmentBreaker.breakSegmentWithChar(androidx.compose.ui.text.android.LayoutHelper, boolean):java.util.List");
    }

    private final List<Segment> breakSegmentWithDocument(LayoutHelper layoutHelper) {
        return u.e(new Segment(0, layoutHelper.getLayout().getText().length(), 0, 0, layoutHelper.getLayout().getWidth(), layoutHelper.getLayout().getHeight()));
    }

    private final List<Segment> breakSegmentWithLine(LayoutHelper layoutHelper, boolean z10) {
        ArrayList arrayList = new ArrayList();
        Layout layout = layoutHelper.getLayout();
        int lineCount = layoutHelper.getLayout().getLineCount();
        for (int i10 = 0; i10 < lineCount; i10++) {
            arrayList.add(new Segment(layout.getLineStart(i10), layout.getLineEnd(i10), z10 ? (int) Math.ceil(layout.getLineLeft(i10)) : 0, layout.getLineTop(i10), z10 ? (int) Math.ceil(layout.getLineRight(i10)) : layout.getWidth(), layout.getLineBottom(i10)));
        }
        return arrayList;
    }

    private final List<Segment> breakSegmentWithParagraph(LayoutHelper layoutHelper) {
        ArrayList arrayList = new ArrayList();
        Layout layout = layoutHelper.getLayout();
        int paragraphCount = layoutHelper.getParagraphCount();
        for (int i10 = 0; i10 < paragraphCount; i10++) {
            int paragraphStart = layoutHelper.getParagraphStart(i10);
            int paragraphEnd = layoutHelper.getParagraphEnd(i10);
            arrayList.add(new Segment(paragraphStart, paragraphEnd, 0, layout.getLineTop(LayoutCompatKt.getLineForOffset(layout, paragraphStart, false)), layout.getWidth(), layout.getLineBottom(LayoutCompatKt.getLineForOffset(layout, paragraphEnd, true))));
        }
        return arrayList;
    }

    private final List<Segment> breakSegmentWithWord(LayoutHelper layoutHelper, boolean z10) {
        int i10;
        Layout layout = layoutHelper.getLayout();
        int iCeil = (int) Math.ceil(layout.getPaint().measureText(" "));
        List<Integer> listBreakOffsets = breakOffsets(layoutHelper, SegmentType.Word);
        if (listBreakOffsets.size() != 0) {
            boolean z11 = true;
            if (listBreakOffsets.size() != 1) {
                ArrayList arrayList = new ArrayList();
                boolean z12 = false;
                Integer num = listBreakOffsets.get(0);
                int iM = v.m(listBreakOffsets);
                int i11 = 0;
                while (i11 < iM) {
                    i11++;
                    Integer num2 = listBreakOffsets.get(i11);
                    int iIntValue = num2.intValue();
                    int iIntValue2 = num.intValue();
                    int lineForOffset = LayoutCompatKt.getLineForOffset(layout, iIntValue2, z12);
                    boolean z13 = layout.getParagraphDirection(lineForOffset) == -1 ? z11 : z12;
                    boolean zIsRtlCharAt = layout.isRtlCharAt(iIntValue2);
                    if (zIsRtlCharAt != z13) {
                        z11 = z12;
                    }
                    int iCeil2 = (int) Math.ceil(layoutHelper.getHorizontalPosition(iIntValue2, z11, z12));
                    boolean z14 = zIsRtlCharAt == z13;
                    int i12 = iM;
                    int iCeil3 = (int) Math.ceil(layoutHelper.getHorizontalPosition(iIntValue, z14, true));
                    int iMin = Math.min(iCeil2, iCeil3);
                    int iMax = Math.max(iCeil2, iCeil3);
                    if (z10 && iIntValue != 0 && layout.getText().charAt(iIntValue - 1) == ' ') {
                        i10 = lineForOffset;
                        if (layout.getLineEnd(i10) != iIntValue) {
                            if (zIsRtlCharAt) {
                                iMin += iCeil;
                            } else {
                                iMax -= iCeil;
                            }
                        }
                    } else {
                        i10 = lineForOffset;
                    }
                    arrayList.add(new Segment(iIntValue2, iIntValue, iMin, layout.getLineTop(i10), iMax, layout.getLineBottom(i10)));
                    num = num2;
                    iM = i12;
                    z11 = true;
                    z12 = false;
                }
                return arrayList;
            }
        }
        return v.l();
    }

    private final List<Integer> breakWithBreakIterator(CharSequence charSequence, BreakIterator breakIterator) {
        CharSequenceCharacterIterator charSequenceCharacterIterator = new CharSequenceCharacterIterator(charSequence, 0, charSequence.length());
        List<Integer> listQ = v.q(0);
        breakIterator.setText(charSequenceCharacterIterator);
        while (breakIterator.next() != -1) {
            listQ.add(Integer.valueOf(breakIterator.current()));
        }
        return listQ;
    }

    @NotNull
    public final List<Integer> breakOffsets(@NotNull LayoutHelper layoutHelper, @NotNull SegmentType segmentType) {
        t.i(layoutHelper, "layoutHelper");
        t.i(segmentType, "segmentType");
        Layout layout = layoutHelper.getLayout();
        CharSequence text = layout.getText();
        int i10 = WhenMappings.$EnumSwitchMapping$0[segmentType.ordinal()];
        int i11 = 0;
        if (i10 == 1) {
            return v.n(0, Integer.valueOf(text.length()));
        }
        if (i10 == 2) {
            List<Integer> listQ = v.q(0);
            int paragraphCount = layoutHelper.getParagraphCount();
            while (i11 < paragraphCount) {
                listQ.add(Integer.valueOf(layoutHelper.getParagraphEnd(i11)));
                i11++;
            }
            return listQ;
        }
        if (i10 == 3) {
            List<Integer> listQ2 = v.q(0);
            int lineCount = layout.getLineCount();
            while (i11 < lineCount) {
                listQ2.add(Integer.valueOf(layout.getLineEnd(i11)));
                i11++;
            }
            return listQ2;
        }
        if (i10 == 4) {
            return breakInWords(layoutHelper);
        }
        if (i10 != 5) {
            throw new q();
        }
        t.h(text, "text");
        BreakIterator characterInstance = BreakIterator.getCharacterInstance(Locale.getDefault());
        t.h(characterInstance, "getCharacterInstance(Locale.getDefault())");
        return breakWithBreakIterator(text, characterInstance);
    }

    @NotNull
    public final List<Segment> breakSegments(@NotNull LayoutHelper layoutHelper, @NotNull SegmentType segmentType, boolean z10) {
        t.i(layoutHelper, "layoutHelper");
        t.i(segmentType, "segmentType");
        int i10 = WhenMappings.$EnumSwitchMapping$0[segmentType.ordinal()];
        if (i10 == 1) {
            return breakSegmentWithDocument(layoutHelper);
        }
        if (i10 == 2) {
            return breakSegmentWithParagraph(layoutHelper);
        }
        if (i10 == 3) {
            return breakSegmentWithLine(layoutHelper, z10);
        }
        if (i10 == 4) {
            return breakSegmentWithWord(layoutHelper, z10);
        }
        if (i10 == 5) {
            return breakSegmentWithChar(layoutHelper, z10);
        }
        throw new q();
    }
}
