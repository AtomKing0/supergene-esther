package ua;

import org.jetbrains.annotations.NotNull;
import ua.c;

/* JADX INFO: compiled from: -Util.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final c.a f34760a = new c.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f34761b = -1234567890;

    public static final boolean a(@NotNull byte[] a10, int i10, @NotNull byte[] b10, int i11, int i12) {
        kotlin.jvm.internal.t.i(a10, "a");
        kotlin.jvm.internal.t.i(b10, "b");
        for (int i13 = 0; i13 < i12; i13++) {
            if (a10[i13 + i10] != b10[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    public static final int c() {
        return f34761b;
    }

    public static final int d(@NotNull f fVar, int i10) {
        kotlin.jvm.internal.t.i(fVar, "<this>");
        return i10 == f34761b ? fVar.B() : i10;
    }

    public static final int e(@NotNull byte[] bArr, int i10) {
        kotlin.jvm.internal.t.i(bArr, "<this>");
        return i10 == f34761b ? bArr.length : i10;
    }

    public static final int f(int i10) {
        return ((i10 & 255) << 24) | (((-16777216) & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public static final long g(long j10) {
        return ((j10 & 255) << 56) | (((-72057594037927936L) & j10) >>> 56) | ((71776119061217280L & j10) >>> 40) | ((280375465082880L & j10) >>> 24) | ((1095216660480L & j10) >>> 8) | ((4278190080L & j10) << 8) | ((16711680 & j10) << 24) | ((65280 & j10) << 40);
    }

    public static final short h(short s10) {
        int i10 = s10 & 65535;
        return (short) (((i10 & 255) << 8) | ((65280 & i10) >>> 8));
    }

    @NotNull
    public static final String i(byte b10) {
        return p9.q.p(new char[]{va.g.f()[(b10 >> 4) & 15], va.g.f()[b10 & 15]});
    }

    @NotNull
    public static final String j(int i10) {
        if (i10 == 0) {
            return "0";
        }
        int i11 = 0;
        char[] cArr = {va.g.f()[(i10 >> 28) & 15], va.g.f()[(i10 >> 24) & 15], va.g.f()[(i10 >> 20) & 15], va.g.f()[(i10 >> 16) & 15], va.g.f()[(i10 >> 12) & 15], va.g.f()[(i10 >> 8) & 15], va.g.f()[(i10 >> 4) & 15], va.g.f()[i10 & 15]};
        while (i11 < 8 && cArr[i11] == '0') {
            i11++;
        }
        return p9.q.q(cArr, i11, 8);
    }
}
