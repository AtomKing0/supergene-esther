package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EditingBuffer {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int NOWHERE = -1;
    private int compositionEnd;
    private int compositionStart;

    @NotNull
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;

    /* JADX INFO: compiled from: EditingBuffer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j10, k kVar) {
        this(annotatedString, j10);
    }

    public final void cancelComposition$ui_text_release() {
        replace$ui_text_release(this.compositionStart, this.compositionEnd, "");
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void commitComposition$ui_text_release() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete$ui_text_release(int i10, int i11) {
        long jTextRange = TextRangeKt.TextRange(i10, i11);
        this.gapBuffer.replace(i10, i11, "");
        long jM3455updateRangeAfterDeletepWDy79M = EditingBufferKt.m3455updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), jTextRange);
        this.selectionStart = TextRange.m3333getMinimpl(jM3455updateRangeAfterDeletepWDy79M);
        this.selectionEnd = TextRange.m3332getMaximpl(jM3455updateRangeAfterDeletepWDy79M);
        if (hasComposition$ui_text_release()) {
            long jM3455updateRangeAfterDeletepWDy79M2 = EditingBufferKt.m3455updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), jTextRange);
            if (TextRange.m3329getCollapsedimpl(jM3455updateRangeAfterDeletepWDy79M2)) {
                commitComposition$ui_text_release();
            } else {
                this.compositionStart = TextRange.m3333getMinimpl(jM3455updateRangeAfterDeletepWDy79M2);
                this.compositionEnd = TextRange.m3332getMaximpl(jM3455updateRangeAfterDeletepWDy79M2);
            }
        }
    }

    public final char get$ui_text_release(int i10) {
        return this.gapBuffer.get(i10);
    }

    @Nullable
    /* JADX INFO: renamed from: getComposition-MzsxiRA$ui_text_release, reason: not valid java name */
    public final TextRange m3453getCompositionMzsxiRA$ui_text_release() {
        if (hasComposition$ui_text_release()) {
            return TextRange.m3323boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    public final int getCompositionEnd$ui_text_release() {
        return this.compositionEnd;
    }

    public final int getCompositionStart$ui_text_release() {
        return this.compositionStart;
    }

    public final int getCursor$ui_text_release() {
        int i10 = this.selectionStart;
        int i11 = this.selectionEnd;
        if (i10 == i11) {
            return i11;
        }
        return -1;
    }

    public final int getLength$ui_text_release() {
        return this.gapBuffer.getLength();
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE$ui_text_release, reason: not valid java name */
    public final long m3454getSelectiond9O1mEE$ui_text_release() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getSelectionEnd$ui_text_release() {
        return this.selectionEnd;
    }

    public final int getSelectionStart$ui_text_release() {
        return this.selectionStart;
    }

    public final boolean hasComposition$ui_text_release() {
        return this.compositionStart != -1;
    }

    public final void replace$ui_text_release(int i10, int i11, @NotNull AnnotatedString text) {
        t.i(text, "text");
        replace$ui_text_release(i10, i11, text.getText());
    }

    public final void setComposition$ui_text_release(int i10, int i11) {
        if (i10 < 0 || i10 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i10 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i11 < 0 || i11 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i11 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i10 < i11) {
            this.compositionStart = i10;
            this.compositionEnd = i11;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed or empty range: " + i10 + " > " + i11);
    }

    public final void setCursor$ui_text_release(int i10) {
        setSelection$ui_text_release(i10, i10);
    }

    public final void setSelection$ui_text_release(int i10, int i11) {
        if (i10 < 0 || i10 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i10 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i11 < 0 || i11 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i11 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i10 <= i11) {
            this.selectionStart = i10;
            this.selectionEnd = i11;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i10 + " > " + i11);
    }

    @NotNull
    public final AnnotatedString toAnnotatedString$ui_text_release() {
        return new AnnotatedString(toString(), null, null, 6, null);
    }

    @NotNull
    public String toString() {
        return this.gapBuffer.toString();
    }

    public /* synthetic */ EditingBuffer(String str, long j10, k kVar) {
        this(str, j10);
    }

    public final void replace$ui_text_release(int i10, int i11, @NotNull String text) {
        t.i(text, "text");
        if (i10 < 0 || i10 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("start (" + i10 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i11 < 0 || i11 > this.gapBuffer.getLength()) {
            throw new IndexOutOfBoundsException("end (" + i11 + ") offset is outside of text region " + this.gapBuffer.getLength());
        }
        if (i10 <= i11) {
            this.gapBuffer.replace(i10, i11, text);
            this.selectionStart = text.length() + i10;
            this.selectionEnd = i10 + text.length();
            this.compositionStart = -1;
            this.compositionEnd = -1;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i10 + " > " + i11);
    }

    private EditingBuffer(AnnotatedString annotatedString, long j10) {
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.selectionStart = TextRange.m3333getMinimpl(j10);
        this.selectionEnd = TextRange.m3332getMaximpl(j10);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int iM3333getMinimpl = TextRange.m3333getMinimpl(j10);
        int iM3332getMaximpl = TextRange.m3332getMaximpl(j10);
        if (iM3333getMinimpl >= 0 && iM3333getMinimpl <= annotatedString.length()) {
            if (iM3332getMaximpl < 0 || iM3332getMaximpl > annotatedString.length()) {
                throw new IndexOutOfBoundsException("end (" + iM3332getMaximpl + ") offset is outside of text region " + annotatedString.length());
            }
            if (iM3333getMinimpl <= iM3332getMaximpl) {
                return;
            }
            throw new IllegalArgumentException("Do not set reversed range: " + iM3333getMinimpl + " > " + iM3332getMaximpl);
        }
        throw new IndexOutOfBoundsException("start (" + iM3333getMinimpl + ") offset is outside of text region " + annotatedString.length());
    }

    private EditingBuffer(String str, long j10) {
        this(new AnnotatedString(str, null, null, 6, null), j10, (k) null);
    }
}
