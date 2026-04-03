package androidx.compose.ui.text.input;

import androidx.compose.ui.text.InternalTextApi;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GapBuffer.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalTextApi
public final class PartialGapBuffer {
    public static final int BUF_SIZE = 255;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd;
    private int bufStart;

    @Nullable
    private GapBuffer buffer;

    @NotNull
    private String text;

    /* JADX INFO: compiled from: GapBuffer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public PartialGapBuffer(@NotNull String text) {
        t.i(text, "text");
        this.text = text;
        this.bufStart = -1;
        this.bufEnd = -1;
    }

    public final char get(int i10) {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.charAt(i10);
        }
        if (i10 < this.bufStart) {
            return this.text.charAt(i10);
        }
        int length = gapBuffer.length();
        int i11 = this.bufStart;
        return i10 < length + i11 ? gapBuffer.get(i10 - i11) : this.text.charAt(i10 - ((length - this.bufEnd) + i11));
    }

    public final int getLength() {
        GapBuffer gapBuffer = this.buffer;
        return gapBuffer == null ? this.text.length() : (this.text.length() - (this.bufEnd - this.bufStart)) + gapBuffer.length();
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final void replace(int i10, int i11, @NotNull String text) {
        t.i(text, "text");
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer != null) {
            int i12 = this.bufStart;
            int i13 = i10 - i12;
            int i14 = i11 - i12;
            if (i13 >= 0 && i14 <= gapBuffer.length()) {
                gapBuffer.replace(i13, i14, text);
                return;
            }
            this.text = toString();
            this.buffer = null;
            this.bufStart = -1;
            this.bufEnd = -1;
            replace(i10, i11, text);
            return;
        }
        int iMax = Math.max(255, text.length() + 128);
        char[] cArr = new char[iMax];
        int iMin = Math.min(i10, 64);
        int iMin2 = Math.min(this.text.length() - i11, 64);
        int i15 = i10 - iMin;
        GapBufferKt.toCharArray(this.text, cArr, 0, i15, i10);
        int i16 = iMax - iMin2;
        int i17 = i11 + iMin2;
        GapBufferKt.toCharArray(this.text, cArr, i16, i11, i17);
        GapBufferKt.toCharArray$default(text, cArr, iMin, 0, 0, 12, null);
        this.buffer = new GapBuffer(cArr, iMin + text.length(), i16);
        this.bufStart = i15;
        this.bufEnd = i17;
    }

    public final void setText(@NotNull String str) {
        t.i(str, "<set-?>");
        this.text = str;
    }

    @NotNull
    public String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this.text, 0, this.bufStart);
        gapBuffer.append(sb);
        String str = this.text;
        sb.append((CharSequence) str, this.bufEnd, str.length());
        String string = sb.toString();
        t.h(string, "sb.toString()");
        return string;
    }
}
