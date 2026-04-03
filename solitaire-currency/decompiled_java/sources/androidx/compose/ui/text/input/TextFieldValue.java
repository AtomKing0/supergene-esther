package androidx.compose.ui.text.input;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextFieldValue.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextFieldValue {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Saver<TextFieldValue, Object> Saver = SaverKt.Saver(TextFieldValue$Companion$Saver$1.INSTANCE, TextFieldValue$Companion$Saver$2.INSTANCE);

    @NotNull
    private final AnnotatedString annotatedString;

    @Nullable
    private final TextRange composition;
    private final long selection;

    /* JADX INFO: compiled from: TextFieldValue.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Saver<TextFieldValue, Object> getSaver() {
            return TextFieldValue.Saver;
        }
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j10, TextRange textRange, k kVar) {
        this(annotatedString, j10, textRange);
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static /* synthetic */ TextFieldValue m3505copy3r_uNRQ$default(TextFieldValue textFieldValue, AnnotatedString annotatedString, long j10, TextRange textRange, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            annotatedString = textFieldValue.annotatedString;
        }
        if ((i10 & 2) != 0) {
            j10 = textFieldValue.selection;
        }
        if ((i10 & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m3507copy3r_uNRQ(annotatedString, j10, textRange);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-3r_uNRQ, reason: not valid java name */
    public final TextFieldValue m3507copy3r_uNRQ(@NotNull AnnotatedString annotatedString, long j10, @Nullable TextRange textRange) {
        t.i(annotatedString, "annotatedString");
        return new TextFieldValue(annotatedString, j10, textRange, (k) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) obj;
        return TextRange.m3328equalsimpl0(this.selection, textFieldValue.selection) && t.d(this.composition, textFieldValue.composition) && t.d(this.annotatedString, textFieldValue.annotatedString);
    }

    @NotNull
    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    @Nullable
    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m3509getCompositionMzsxiRA() {
        return this.composition;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m3510getSelectiond9O1mEE() {
        return this.selection;
    }

    @NotNull
    public final String getText() {
        return this.annotatedString.getText();
    }

    public int hashCode() {
        int iHashCode = ((this.annotatedString.hashCode() * 31) + TextRange.m3336hashCodeimpl(this.selection)) * 31;
        TextRange textRange = this.composition;
        return iHashCode + (textRange != null ? TextRange.m3336hashCodeimpl(textRange.m3339unboximpl()) : 0);
    }

    @NotNull
    public String toString() {
        return "TextFieldValue(text='" + ((Object) this.annotatedString) + "', selection=" + ((Object) TextRange.m3338toStringimpl(this.selection)) + ", composition=" + this.composition + ')';
    }

    public /* synthetic */ TextFieldValue(String str, long j10, TextRange textRange, k kVar) {
        this(str, j10, textRange);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-3r_uNRQ, reason: not valid java name */
    public final TextFieldValue m3508copy3r_uNRQ(@NotNull String text, long j10, @Nullable TextRange textRange) {
        t.i(text, "text");
        return new TextFieldValue(new AnnotatedString(text, null, null, 6, null), j10, textRange, (k) null);
    }

    private TextFieldValue(AnnotatedString annotatedString, long j10, TextRange textRange) {
        this.annotatedString = annotatedString;
        this.selection = TextRangeKt.m3341constrain8ffj60Q(j10, 0, getText().length());
        this.composition = textRange != null ? TextRange.m3323boximpl(TextRangeKt.m3341constrain8ffj60Q(textRange.m3339unboximpl(), 0, getText().length())) : null;
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static /* synthetic */ TextFieldValue m3506copy3r_uNRQ$default(TextFieldValue textFieldValue, String str, long j10, TextRange textRange, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = textFieldValue.selection;
        }
        if ((i10 & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m3508copy3r_uNRQ(str, j10, textRange);
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j10, TextRange textRange, int i10, k kVar) {
        this(annotatedString, (i10 & 2) != 0 ? TextRange.Companion.m3340getZerod9O1mEE() : j10, (i10 & 4) != 0 ? null : textRange, (k) null);
    }

    public /* synthetic */ TextFieldValue(String str, long j10, TextRange textRange, int i10, k kVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? TextRange.Companion.m3340getZerod9O1mEE() : j10, (i10 & 4) != 0 ? null : textRange, (k) null);
    }

    private TextFieldValue(String str, long j10, TextRange textRange) {
        this(new AnnotatedString(str, null, null, 6, null), j10, textRange, (k) null);
    }
}
