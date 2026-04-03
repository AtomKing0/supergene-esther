package com.facebook.ads.redexgen.core;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2015Tl implements Closeable {
    public static byte[] A03;
    public static String[] A04 = {"t11y9BgCyC0qQkG3mYUymtEDmEyKV4hc", "7ce9erzyyNrxlxET0sEMje4IREmhCp4i", "4ENs57XqgWmyHBJWN23MJhXXMCaaLz6e", "dr2xNsWDGhc5qlQtklfNqpJl8", "q35Tkz9qNjTEzRlngCIyL7KdK6wO30wH", "vPiuZupP6WnF44bZrTOwEQFi3wuHod3P", "O8XwwgRKslyLqfo5O4ZQvZ7SdPHYsu5Q", ""};
    public C2016Tm A00;
    public boolean A01;
    public final RandomAccessFile A02;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{26, 76, 73, 74, 70, 73, 29, 64, 67, 60, -9, 64, 74, -9, 56, 67, 73, 60, 56, 59, 80, -9, 58, 67, 70, 74, 60, 59, 39, 76, 84, 63, 74, 71, 66, -2, 78, 77, 81, 71, 82, 71, 77, 76, 24, -2, 6, 3, 66, 10, 3, 66, 7, 32, 37, 33};
    }

    static {
        A02();
    }

    public C2015Tl(File file) throws IOException {
        this.A02 = new RandomAccessFile(file, A00(53, 3, 59));
        if (this.A02.length() != 8) {
            this.A02.setLength(8L);
            this.A00 = new C2016Tm(0, 0);
            A01();
            return;
        }
        int i10 = this.A02.readInt();
        int index = this.A02.readInt();
        if (i10 < 0 || index < 0) {
            i10 = 0;
            index = 0;
        }
        this.A00 = new C2016Tm(i10, index);
    }

    private void A01() throws IOException {
        this.A02.seek(0L);
        this.A02.writeInt(this.A00.A02());
        this.A02.writeInt(this.A00.A03());
        this.A02.getFD().sync();
    }

    public final C2016Tm A03() throws IOException {
        if (!this.A01) {
            return this.A00;
        }
        throw new IOException(A00(0, 28, 100));
    }

    public final void A04(C2016Tm c2016Tm) throws IOException {
        if (!this.A01) {
            int iA02 = c2016Tm.A02();
            String[] strArr = A04;
            if (strArr[6].charAt(3) == strArr[1].charAt(3)) {
                throw new RuntimeException();
            }
            A04[2] = "wZJ8kWRxyYeI3b89D2ZfjwX8MEoFWOZU";
            if (iA02 >= 0 && c2016Tm.A03() >= 0) {
                this.A00 = c2016Tm;
                A01();
                return;
            }
            throw new IOException(String.format(Locale.US, A00(28, 25, 107), Integer.valueOf(c2016Tm.A02()), Integer.valueOf(c2016Tm.A03())));
        }
        throw new IOException(A00(0, 28, 100));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.A01) {
            return;
        }
        this.A01 = true;
        this.A02.close();
    }
}
