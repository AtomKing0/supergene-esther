package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.InternalPlatformTextApi;
import java.util.Locale;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WordBoundary.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalPlatformTextApi
public final class WordBoundary {

    @NotNull
    private final WordIterator wordIterator;

    public WordBoundary(@NotNull Locale locale, @NotNull CharSequence text) {
        t.i(locale, "locale");
        t.i(text, "text");
        this.wordIterator = new WordIterator(text, 0, text.length(), locale);
    }

    public final int getWordEnd(int i10) {
        int punctuationEnd = this.wordIterator.isAfterPunctuation(this.wordIterator.nextBoundary(i10)) ? this.wordIterator.getPunctuationEnd(i10) : this.wordIterator.getNextWordEndOnTwoWordBoundary(i10);
        return punctuationEnd == -1 ? i10 : punctuationEnd;
    }

    public final int getWordStart(int i10) {
        int punctuationBeginning = this.wordIterator.isOnPunctuation(this.wordIterator.prevBoundary(i10)) ? this.wordIterator.getPunctuationBeginning(i10) : this.wordIterator.getPrevWordBeginningOnTwoWordsBoundary(i10);
        return punctuationBeginning == -1 ? i10 : punctuationBeginning;
    }
}
