package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WordIterator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WordIterator {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int WINDOW_WIDTH = 50;

    @NotNull
    private final CharSequence charSequence;
    private final int end;

    @NotNull
    private final BreakIterator iterator;
    private final int start;

    /* JADX INFO: compiled from: WordIterator.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final boolean isPunctuation$ui_text_release(int i10) {
            int type = Character.getType(i10);
            return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
        }
    }

    public WordIterator(@NotNull CharSequence charSequence, int i10, int i11, @Nullable Locale locale) {
        t.i(charSequence, "charSequence");
        this.charSequence = charSequence;
        if (!(i10 >= 0 && i10 <= charSequence.length())) {
            throw new IllegalArgumentException("input start index is outside the CharSequence".toString());
        }
        if (!(i11 >= 0 && i11 <= charSequence.length())) {
            throw new IllegalArgumentException("input end index is outside the CharSequence".toString());
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        t.h(wordInstance, "getWordInstance(locale)");
        this.iterator = wordInstance;
        this.start = Math.max(0, i10 - 50);
        this.end = Math.min(charSequence.length(), i11 + 50);
        wordInstance.setText(new CharSequenceCharacterIterator(charSequence, i10, i11));
    }

    private final void checkOffsetIsValid(int i10) {
        int i11 = this.start;
        boolean z10 = false;
        if (i10 <= this.end && i11 <= i10) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        throw new IllegalArgumentException(("Invalid offset: " + i10 + ". Valid range is [" + this.start + " , " + this.end + ']').toString());
    }

    private final int getBeginning(int i10, boolean z10) {
        checkOffsetIsValid(i10);
        if (isOnLetterOrDigit(i10)) {
            return (!this.iterator.isBoundary(i10) || (isAfterLetterOrDigit(i10) && z10)) ? this.iterator.preceding(i10) : i10;
        }
        if (isAfterLetterOrDigit(i10)) {
            return this.iterator.preceding(i10);
        }
        return -1;
    }

    private final int getEnd(int i10, boolean z10) {
        checkOffsetIsValid(i10);
        if (isAfterLetterOrDigit(i10)) {
            return (!this.iterator.isBoundary(i10) || (isOnLetterOrDigit(i10) && z10)) ? this.iterator.following(i10) : i10;
        }
        if (isOnLetterOrDigit(i10)) {
            return this.iterator.following(i10);
        }
        return -1;
    }

    private final boolean isAfterLetterOrDigit(int i10) {
        return (i10 <= this.end && this.start + 1 <= i10) && Character.isLetterOrDigit(Character.codePointBefore(this.charSequence, i10));
    }

    private final boolean isOnLetterOrDigit(int i10) {
        return (i10 < this.end && this.start <= i10) && Character.isLetterOrDigit(Character.codePointAt(this.charSequence, i10));
    }

    private final boolean isPunctuationEndBoundary(int i10) {
        return !isOnPunctuation(i10) && isAfterPunctuation(i10);
    }

    private final boolean isPunctuationStartBoundary(int i10) {
        return isOnPunctuation(i10) && !isAfterPunctuation(i10);
    }

    public final int getNextWordEndOnTwoWordBoundary(int i10) {
        return getEnd(i10, true);
    }

    public final int getPrevWordBeginningOnTwoWordsBoundary(int i10) {
        return getBeginning(i10, true);
    }

    public final int getPunctuationBeginning(int i10) {
        checkOffsetIsValid(i10);
        while (i10 != -1 && !isPunctuationStartBoundary(i10)) {
            i10 = prevBoundary(i10);
        }
        return i10;
    }

    public final int getPunctuationEnd(int i10) {
        checkOffsetIsValid(i10);
        while (i10 != -1 && !isPunctuationEndBoundary(i10)) {
            i10 = nextBoundary(i10);
        }
        return i10;
    }

    public final boolean isAfterPunctuation(int i10) {
        if (i10 <= this.end && this.start + 1 <= i10) {
            return Companion.isPunctuation$ui_text_release(Character.codePointBefore(this.charSequence, i10));
        }
        return false;
    }

    public final boolean isOnPunctuation(int i10) {
        if (i10 < this.end && this.start <= i10) {
            return Companion.isPunctuation$ui_text_release(Character.codePointAt(this.charSequence, i10));
        }
        return false;
    }

    public final int nextBoundary(int i10) {
        checkOffsetIsValid(i10);
        return this.iterator.following(i10);
    }

    public final int prevBoundary(int i10) {
        checkOffsetIsValid(i10);
        return this.iterator.preceding(i10);
    }
}
