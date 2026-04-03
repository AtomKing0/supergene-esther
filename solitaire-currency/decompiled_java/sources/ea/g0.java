package ea;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonToStringWriter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g0 implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private char[] f25433a = h.f25435a.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f25434b;

    private final void d(int i10, int i11, String str) {
        byte b10;
        int length = str.length();
        while (i10 < length) {
            int iF = f(i11, 2);
            char cCharAt = str.charAt(i10);
            if (cCharAt >= v0.a().length || (b10 = v0.a()[cCharAt]) == 0) {
                int i12 = iF + 1;
                this.f25433a[iF] = cCharAt;
                i11 = i12;
                i10++;
            } else {
                if (b10 == 1) {
                    String str2 = v0.b()[cCharAt];
                    kotlin.jvm.internal.t.f(str2);
                    int iF2 = f(iF, str2.length());
                    str2.getChars(0, str2.length(), this.f25433a, iF2);
                    i11 = iF2 + str2.length();
                    this.f25434b = i11;
                } else {
                    char[] cArr = this.f25433a;
                    cArr[iF] = '\\';
                    cArr[iF + 1] = (char) b10;
                    i11 = iF + 2;
                    this.f25434b = i11;
                }
                i10++;
            }
        }
        int iF3 = f(i11, 1);
        this.f25433a[iF3] = '\"';
        this.f25434b = iF3 + 1;
    }

    private final void e(int i10) {
        f(this.f25434b, i10);
    }

    private final int f(int i10, int i11) {
        int i12 = i11 + i10;
        char[] cArr = this.f25433a;
        if (cArr.length <= i12) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, n9.o.e(i12, i10 * 2));
            kotlin.jvm.internal.t.h(cArrCopyOf, "copyOf(this, newSize)");
            this.f25433a = cArrCopyOf;
        }
        return i10;
    }

    @Override // ea.o0
    public void a(char c10) {
        e(1);
        char[] cArr = this.f25433a;
        int i10 = this.f25434b;
        this.f25434b = i10 + 1;
        cArr[i10] = c10;
    }

    @Override // ea.o0
    public void b(@NotNull String text) {
        kotlin.jvm.internal.t.i(text, "text");
        e(text.length() + 2);
        char[] cArr = this.f25433a;
        int i10 = this.f25434b;
        int i11 = i10 + 1;
        cArr[i10] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i11);
        int i12 = length + i11;
        for (int i13 = i11; i13 < i12; i13++) {
            char c10 = cArr[i13];
            if (c10 < v0.a().length && v0.a()[c10] != 0) {
                d(i13 - i11, i13, text);
                return;
            }
        }
        cArr[i12] = '\"';
        this.f25434b = i12 + 1;
    }

    @Override // ea.o0
    public void c(@NotNull String text) {
        kotlin.jvm.internal.t.i(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        e(length);
        text.getChars(0, text.length(), this.f25433a, this.f25434b);
        this.f25434b += length;
    }

    public void g() {
        h.f25435a.a(this.f25433a);
    }

    @NotNull
    public String toString() {
        return new String(this.f25433a, 0, this.f25434b);
    }

    @Override // ea.o0
    public void writeLong(long j10) {
        c(String.valueOf(j10));
    }
}
