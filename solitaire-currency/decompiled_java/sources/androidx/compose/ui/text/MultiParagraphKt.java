package androidx.compose.ui.text;

import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MultiParagraph.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MultiParagraphKt {
    private static final <T> int fastBinarySearch(List<? extends T> list, l<? super T, Integer> lVar) {
        int size = list.size() - 1;
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            int iIntValue = lVar.invoke(list.get(i11)).intValue();
            if (iIntValue < 0) {
                i10 = i11 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i11;
                }
                size = i11 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final int findParagraphByIndex(@NotNull List<ParagraphInfo> paragraphInfoList, int i10) {
        t.i(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) >>> 1;
            ParagraphInfo paragraphInfo = paragraphInfoList.get(i12);
            byte b10 = paragraphInfo.getStartIndex() > i10 ? (byte) 1 : paragraphInfo.getEndIndex() <= i10 ? (byte) -1 : (byte) 0;
            if (b10 < 0) {
                i11 = i12 + 1;
            } else {
                if (b10 <= 0) {
                    return i12;
                }
                size = i12 - 1;
            }
        }
        return -(i11 + 1);
    }

    public static final int findParagraphByLineIndex(@NotNull List<ParagraphInfo> paragraphInfoList, int i10) {
        t.i(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) >>> 1;
            ParagraphInfo paragraphInfo = paragraphInfoList.get(i12);
            byte b10 = paragraphInfo.getStartLineIndex() > i10 ? (byte) 1 : paragraphInfo.getEndLineIndex() <= i10 ? (byte) -1 : (byte) 0;
            if (b10 < 0) {
                i11 = i12 + 1;
            } else {
                if (b10 <= 0) {
                    return i12;
                }
                size = i12 - 1;
            }
        }
        return -(i11 + 1);
    }

    public static final int findParagraphByY(@NotNull List<ParagraphInfo> paragraphInfoList, float f10) {
        t.i(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            ParagraphInfo paragraphInfo = paragraphInfoList.get(i11);
            byte b10 = paragraphInfo.getTop() > f10 ? (byte) 1 : paragraphInfo.getBottom() <= f10 ? (byte) -1 : (byte) 0;
            if (b10 < 0) {
                i10 = i11 + 1;
            } else {
                if (b10 <= 0) {
                    return i11;
                }
                size = i11 - 1;
            }
        }
        return -(i10 + 1);
    }
}
