package androidx.compose.ui.text.input;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KeyboardCapitalization.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyboardCapitalization {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int None = m3479constructorimpl(0);
    private static final int Characters = m3479constructorimpl(1);
    private static final int Words = m3479constructorimpl(2);
    private static final int Sentences = m3479constructorimpl(3);

    /* JADX INFO: compiled from: KeyboardCapitalization.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getCharacters-IUNYP9k, reason: not valid java name */
        public final int m3485getCharactersIUNYP9k() {
            return KeyboardCapitalization.Characters;
        }

        /* JADX INFO: renamed from: getNone-IUNYP9k, reason: not valid java name */
        public final int m3486getNoneIUNYP9k() {
            return KeyboardCapitalization.None;
        }

        /* JADX INFO: renamed from: getSentences-IUNYP9k, reason: not valid java name */
        public final int m3487getSentencesIUNYP9k() {
            return KeyboardCapitalization.Sentences;
        }

        /* JADX INFO: renamed from: getWords-IUNYP9k, reason: not valid java name */
        public final int m3488getWordsIUNYP9k() {
            return KeyboardCapitalization.Words;
        }
    }

    private /* synthetic */ KeyboardCapitalization(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardCapitalization m3478boximpl(int i10) {
        return new KeyboardCapitalization(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3480equalsimpl(int i10, Object obj) {
        return (obj instanceof KeyboardCapitalization) && i10 == ((KeyboardCapitalization) obj).m3484unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3481equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3483toStringimpl(int i10) {
        return m3481equalsimpl0(i10, None) ? "None" : m3481equalsimpl0(i10, Characters) ? "Characters" : m3481equalsimpl0(i10, Words) ? "Words" : m3481equalsimpl0(i10, Sentences) ? "Sentences" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3480equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3482hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3483toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3484unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3479constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3482hashCodeimpl(int i10) {
        return i10;
    }
}
