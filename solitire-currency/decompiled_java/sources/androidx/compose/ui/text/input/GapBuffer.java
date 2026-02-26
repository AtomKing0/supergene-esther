package androidx.compose.ui.text.input;

import kotlin.collections.o;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GapBuffer.kt */
/* JADX INFO: loaded from: classes.dex */
final class GapBuffer {

    @NotNull
    private char[] buffer;
    private int capacity;
    private int gapEnd;
    private int gapStart;

    public GapBuffer(@NotNull char[] initBuffer, int i10, int i11) {
        t.i(initBuffer, "initBuffer");
        this.capacity = initBuffer.length;
        this.buffer = initBuffer;
        this.gapStart = i10;
        this.gapEnd = i11;
    }

    private final void delete(int i10, int i11) {
        int i12 = this.gapStart;
        if (i10 < i12 && i11 <= i12) {
            int i13 = i12 - i11;
            char[] cArr = this.buffer;
            o.e(cArr, cArr, this.gapEnd - i13, i11, i12);
            this.gapStart = i10;
            this.gapEnd -= i13;
            return;
        }
        if (i10 < i12 && i11 >= i12) {
            this.gapEnd = i11 + gapLength();
            this.gapStart = i10;
            return;
        }
        int iGapLength = i10 + gapLength();
        int iGapLength2 = i11 + gapLength();
        int i14 = this.gapEnd;
        int i15 = iGapLength - i14;
        char[] cArr2 = this.buffer;
        o.e(cArr2, cArr2, this.gapStart, i14, iGapLength);
        this.gapStart += i15;
        this.gapEnd = iGapLength2;
    }

    private final int gapLength() {
        return this.gapEnd - this.gapStart;
    }

    private final void makeSureAvailableSpace(int i10) {
        if (i10 <= gapLength()) {
            return;
        }
        int iGapLength = i10 - gapLength();
        int i11 = this.capacity;
        do {
            i11 *= 2;
        } while (i11 - this.capacity < iGapLength);
        char[] cArr = new char[i11];
        o.e(this.buffer, cArr, 0, 0, this.gapStart);
        int i12 = this.capacity;
        int i13 = this.gapEnd;
        int i14 = i12 - i13;
        int i15 = i11 - i14;
        o.e(this.buffer, cArr, i15, i13, i14 + i13);
        this.buffer = cArr;
        this.capacity = i11;
        this.gapEnd = i15;
    }

    public final void append(@NotNull StringBuilder builder) {
        t.i(builder, "builder");
        builder.append(this.buffer, 0, this.gapStart);
        char[] cArr = this.buffer;
        int i10 = this.gapEnd;
        builder.append(cArr, i10, this.capacity - i10);
    }

    public final char get(int i10) {
        int i11 = this.gapStart;
        return i10 < i11 ? this.buffer[i10] : this.buffer[(i10 - i11) + this.gapEnd];
    }

    public final int length() {
        return this.capacity - gapLength();
    }

    public final void replace(int i10, int i11, @NotNull String text) {
        t.i(text, "text");
        makeSureAvailableSpace(text.length() - (i11 - i10));
        delete(i10, i11);
        GapBufferKt.toCharArray$default(text, this.buffer, this.gapStart, 0, 0, 12, null);
        this.gapStart += text.length();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) sb);
        String string = sb.toString();
        t.h(string, "StringBuilder().apply { append(this) }.toString()");
        return string;
    }
}
