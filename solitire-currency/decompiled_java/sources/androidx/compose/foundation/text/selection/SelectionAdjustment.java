package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import h9.l;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;

/* JADX INFO: compiled from: SelectionAdjustment.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SelectionAdjustment {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: SelectionAdjustment.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final SelectionAdjustment None = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$None$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* JADX INFO: renamed from: adjust-ZXO7KMw */
            public long mo768adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j10, int i10, boolean z10, @Nullable TextRange textRange) {
                t.i(textLayoutResult, "textLayoutResult");
                return j10;
            }
        };

        @NotNull
        private static final SelectionAdjustment Character = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Character$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* JADX INFO: renamed from: adjust-ZXO7KMw */
            public long mo768adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j10, int i10, boolean z10, @Nullable TextRange textRange) {
                t.i(textLayoutResult, "textLayoutResult");
                if (TextRange.m3329getCollapsedimpl(j10)) {
                    return SelectionAdjustmentKt.ensureAtLeastOneChar(TextRange.m3335getStartimpl(j10), r.Y(textLayoutResult.getLayoutInput().getText()), z10, textRange != null ? TextRange.m3334getReversedimpl(textRange.m3339unboximpl()) : false);
                }
                return j10;
            }
        };

        @NotNull
        private static final SelectionAdjustment Word = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Word$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* JADX INFO: renamed from: adjust-ZXO7KMw */
            public long mo768adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j10, int i10, boolean z10, @Nullable TextRange textRange) {
                t.i(textLayoutResult, "textLayoutResult");
                return SelectionAdjustment.Companion.$$INSTANCE.m770adjustByBoundaryDvylE(textLayoutResult, j10, new SelectionAdjustment$Companion$Word$1$adjust$1(textLayoutResult));
            }
        };

        @NotNull
        private static final SelectionAdjustment Paragraph = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$Paragraph$1
            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* JADX INFO: renamed from: adjust-ZXO7KMw */
            public long mo768adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j10, int i10, boolean z10, @Nullable TextRange textRange) {
                t.i(textLayoutResult, "textLayoutResult");
                return SelectionAdjustment.Companion.$$INSTANCE.m770adjustByBoundaryDvylE(textLayoutResult, j10, new SelectionAdjustment$Companion$Paragraph$1$adjust$boundaryFun$1(textLayoutResult.getLayoutInput().getText()));
            }
        };

        @NotNull
        private static final SelectionAdjustment CharacterWithWordAccelerate = new SelectionAdjustment() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$CharacterWithWordAccelerate$1
            private final boolean isAtWordBoundary(TextLayoutResult textLayoutResult, int i10) {
                long jM3322getWordBoundaryjx7JFs = textLayoutResult.m3322getWordBoundaryjx7JFs(i10);
                return i10 == TextRange.m3335getStartimpl(jM3322getWordBoundaryjx7JFs) || i10 == TextRange.m3330getEndimpl(jM3322getWordBoundaryjx7JFs);
            }

            private final boolean isExpanding(int i10, int i11, boolean z10, boolean z11) {
                if (i11 == -1) {
                    return true;
                }
                if (i10 == i11) {
                    return false;
                }
                if (z10 ^ z11) {
                    if (i10 < i11) {
                        return true;
                    }
                } else if (i10 > i11) {
                    return true;
                }
                return false;
            }

            private final int snapToWordBoundary(TextLayoutResult textLayoutResult, int i10, int i11, int i12, boolean z10, boolean z11) {
                long jM3322getWordBoundaryjx7JFs = textLayoutResult.m3322getWordBoundaryjx7JFs(i10);
                int iM3335getStartimpl = textLayoutResult.getLineForOffset(TextRange.m3335getStartimpl(jM3322getWordBoundaryjx7JFs)) == i11 ? TextRange.m3335getStartimpl(jM3322getWordBoundaryjx7JFs) : textLayoutResult.getLineStart(i11);
                int iM3330getEndimpl = textLayoutResult.getLineForOffset(TextRange.m3330getEndimpl(jM3322getWordBoundaryjx7JFs)) == i11 ? TextRange.m3330getEndimpl(jM3322getWordBoundaryjx7JFs) : TextLayoutResult.getLineEnd$default(textLayoutResult, i11, false, 2, null);
                if (iM3335getStartimpl == i12) {
                    return iM3330getEndimpl;
                }
                if (iM3330getEndimpl == i12) {
                    return iM3335getStartimpl;
                }
                int i13 = (iM3335getStartimpl + iM3330getEndimpl) / 2;
                if (z10 ^ z11) {
                    if (i10 <= i13) {
                        return iM3335getStartimpl;
                    }
                } else if (i10 < i13) {
                    return iM3335getStartimpl;
                }
                return iM3330getEndimpl;
            }

            private final int updateSelectionBoundary(TextLayoutResult textLayoutResult, int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
                if (i10 == i11) {
                    return i12;
                }
                int lineForOffset = textLayoutResult.getLineForOffset(i10);
                return lineForOffset != textLayoutResult.getLineForOffset(i12) ? snapToWordBoundary(textLayoutResult, i10, lineForOffset, i13, z10, z11) : (isExpanding(i10, i11, z10, z11) && isAtWordBoundary(textLayoutResult, i12)) ? snapToWordBoundary(textLayoutResult, i10, lineForOffset, i13, z10, z11) : i10;
            }

            @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
            /* JADX INFO: renamed from: adjust-ZXO7KMw */
            public long mo768adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j10, int i10, boolean z10, @Nullable TextRange textRange) {
                int iUpdateSelectionBoundary;
                int iUpdateSelectionBoundary2;
                t.i(textLayoutResult, "textLayoutResult");
                if (textRange == null) {
                    return SelectionAdjustment.Companion.$$INSTANCE.getWord().mo768adjustZXO7KMw(textLayoutResult, j10, i10, z10, textRange);
                }
                if (TextRange.m3329getCollapsedimpl(j10)) {
                    return SelectionAdjustmentKt.ensureAtLeastOneChar(TextRange.m3335getStartimpl(j10), r.Y(textLayoutResult.getLayoutInput().getText()), z10, TextRange.m3334getReversedimpl(textRange.m3339unboximpl()));
                }
                if (z10) {
                    iUpdateSelectionBoundary2 = updateSelectionBoundary(textLayoutResult, TextRange.m3335getStartimpl(j10), i10, TextRange.m3335getStartimpl(textRange.m3339unboximpl()), TextRange.m3330getEndimpl(j10), true, TextRange.m3334getReversedimpl(j10));
                    iUpdateSelectionBoundary = TextRange.m3330getEndimpl(j10);
                } else {
                    int iM3335getStartimpl = TextRange.m3335getStartimpl(j10);
                    iUpdateSelectionBoundary = updateSelectionBoundary(textLayoutResult, TextRange.m3330getEndimpl(j10), i10, TextRange.m3330getEndimpl(textRange.m3339unboximpl()), TextRange.m3335getStartimpl(j10), false, TextRange.m3334getReversedimpl(j10));
                    iUpdateSelectionBoundary2 = iM3335getStartimpl;
                }
                return TextRangeKt.TextRange(iUpdateSelectionBoundary2, iUpdateSelectionBoundary);
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: adjustByBoundary--Dv-ylE, reason: not valid java name */
        public final long m770adjustByBoundaryDvylE(TextLayoutResult textLayoutResult, long j10, l<? super Integer, TextRange> lVar) {
            if (textLayoutResult.getLayoutInput().getText().length() == 0) {
                return TextRange.Companion.m3340getZerod9O1mEE();
            }
            int iY = r.Y(textLayoutResult.getLayoutInput().getText());
            long jM3339unboximpl = lVar.invoke(Integer.valueOf(o.n(TextRange.m3335getStartimpl(j10), 0, iY))).m3339unboximpl();
            long jM3339unboximpl2 = lVar.invoke(Integer.valueOf(o.n(TextRange.m3330getEndimpl(j10), 0, iY))).m3339unboximpl();
            return TextRangeKt.TextRange(TextRange.m3334getReversedimpl(j10) ? TextRange.m3330getEndimpl(jM3339unboximpl) : TextRange.m3335getStartimpl(jM3339unboximpl), TextRange.m3334getReversedimpl(j10) ? TextRange.m3335getStartimpl(jM3339unboximpl2) : TextRange.m3330getEndimpl(jM3339unboximpl2));
        }

        @NotNull
        public final SelectionAdjustment getCharacter() {
            return Character;
        }

        @NotNull
        public final SelectionAdjustment getCharacterWithWordAccelerate() {
            return CharacterWithWordAccelerate;
        }

        @NotNull
        public final SelectionAdjustment getNone() {
            return None;
        }

        @NotNull
        public final SelectionAdjustment getParagraph() {
            return Paragraph;
        }

        @NotNull
        public final SelectionAdjustment getWord() {
            return Word;
        }
    }

    /* JADX INFO: renamed from: adjust-ZXO7KMw, reason: not valid java name */
    long mo768adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j10, int i10, boolean z10, @Nullable TextRange textRange);
}
