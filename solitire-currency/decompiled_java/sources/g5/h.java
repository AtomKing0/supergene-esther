package g5;

import e5.o;

/* JADX INFO: compiled from: UnsignedBytes.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static byte a(long j10) {
        o.g((j10 >> 8) == 0, "out of range: %s", j10);
        return (byte) j10;
    }

    public static int b(byte b10) {
        return b10 & 255;
    }
}
