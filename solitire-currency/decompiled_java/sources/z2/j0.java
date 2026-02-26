package z2;

import androidx.media3.common.C;
import androidx.media3.extractor.ts.TsExtractor;

/* JADX INFO: compiled from: TsUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j0 {
    public static int a(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && bArr[i10] != 71) {
            i10++;
        }
        return i10;
    }

    public static boolean b(byte[] bArr, int i10, int i11, int i12) {
        int i13 = 0;
        for (int i14 = -4; i14 <= 4; i14++) {
            int i15 = (i14 * TsExtractor.TS_PACKET_SIZE) + i12;
            if (i15 < i10 || i15 >= i11 || bArr[i15] != 71) {
                i13 = 0;
            } else {
                i13++;
                if (i13 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(a4.c0 c0Var, int i10, int i11) {
        c0Var.P(i10);
        if (c0Var.a() < 5) {
            return C.TIME_UNSET;
        }
        int iN = c0Var.n();
        if ((8388608 & iN) != 0 || ((2096896 & iN) >> 8) != i11) {
            return C.TIME_UNSET;
        }
        if (((iN & 32) != 0) && c0Var.D() >= 7 && c0Var.a() >= 7) {
            if ((c0Var.D() & 16) == 16) {
                byte[] bArr = new byte[6];
                c0Var.j(bArr, 0, 6);
                return d(bArr);
            }
        }
        return C.TIME_UNSET;
    }

    private static long d(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
