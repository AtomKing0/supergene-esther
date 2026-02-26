package com.facebook.ads.redexgen.core;

import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1675Gd {
    public static String[] A00 = {"o6dy0jxWVFoVpdfIHLQ5kJFOMlq1Sn1Q", "79oj", "9g10QGOLUMPWkkbPiEKlPZ6GdmncXBXa", "6fmIgIVXmOYY3cUB7ZYAXnWSgE20TitB", "v6a7Yb3DANDL70kkwlzLnkI1heNzynkm", "eDdjZQkAYxVEYJ3d9Q78IvgSo191T7ve", "sHmXnPOOobIrXpWrquJBTDw1maWJKk3u", "k0vF7vRBeJQaOBXZ"};

    public static int A00(C4J c4j, int i10) {
        switch (i10) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i10 - 2);
            case 6:
                return c4j.A0I() + 1;
            case 7:
                int iA0M = c4j.A0M();
                String[] strArr = A00;
                if (strArr[6].charAt(23) != strArr[4].charAt(23)) {
                    throw new RuntimeException();
                }
                A00[7] = "hcXiJWofr5Txci555yuma5X";
                return iA0M + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i10 - 8);
            default:
                return -1;
        }
    }

    public static long A01(InterfaceC2853lN interfaceC2853lN, C1679Gh c1679Gh) throws IOException {
        interfaceC2853lN.AI1();
        boolean z10 = true;
        interfaceC2853lN.A3z(1);
        byte[] bArr = new byte[1];
        interfaceC2853lN.AG9(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z10 = false;
        }
        interfaceC2853lN.A3z(2);
        int i10 = z10 ? 7 : 6;
        C4J c4j = new C4J(i10);
        c4j.A0e(GZ.A00(interfaceC2853lN, c4j.A0l(), 0, i10));
        interfaceC2853lN.AI1();
        C1674Gc c1674Gc = new C1674Gc();
        boolean isBlockSizeVariable = A08(c4j, c1679Gh, z10, c1674Gc);
        if (isBlockSizeVariable) {
            return c1674Gc.A00;
        }
        throw C13322i.A01(null, null);
    }

    public static boolean A02(int i10, C1679Gh c1679Gh) {
        if (i10 == 0) {
            return true;
        }
        int i11 = c1679Gh.A01;
        if (A00[7].length() == 8) {
            throw new RuntimeException();
        }
        A00[0] = "dnyA5Em4Vekc9hKZNMMqKWCBR5ivXppC";
        return i10 == i11;
    }

    public static boolean A03(int i10, C1679Gh c1679Gh) {
        if (i10 <= 7) {
            return i10 == c1679Gh.A02 - 1;
        }
        if (A00[3].charAt(10) != 'Y') {
            throw new RuntimeException();
        }
        A00[3] = "e0AkGTV6jhYRPjlSs9AVJSXBXenCNngQ";
        return i10 <= 10 && c1679Gh.A02 == 2;
    }

    public static boolean A04(C4J c4j, int i10) {
        int iA0I = c4j.A0I();
        int crc = c4j.A09();
        return iA0I == AbstractC13764a.A0J(c4j.A0l(), i10, crc + (-1), 0);
    }

    public static boolean A05(C4J c4j, C1679Gh c1679Gh, int i10) {
        int iA00 = A00(c4j, i10);
        if (iA00 != -1) {
            int blockSizeSamples = c1679Gh.A03;
            if (iA00 <= blockSizeSamples) {
                return true;
            }
        }
        return false;
    }

    public static boolean A06(C4J c4j, C1679Gh c1679Gh, int i10) {
        int sampleRate = c1679Gh.A07;
        if (i10 == 0) {
            return true;
        }
        if (i10 <= 11) {
            return i10 == c1679Gh.A08;
        }
        if (i10 == 12) {
            return c4j.A0I() * 1000 == sampleRate;
        }
        if (i10 > 14) {
            return false;
        }
        int expectedSampleRate = c4j.A0M();
        if (i10 == 14) {
            expectedSampleRate *= 10;
        }
        return expectedSampleRate == sampleRate;
    }

    public static boolean A07(C4J c4j, C1679Gh c1679Gh, int i10, C1674Gc c1674Gc) {
        int iA09 = c4j.A09();
        long jA0Q = c4j.A0Q();
        long frameHeaderBytes = jA0Q >>> 16;
        if (frameHeaderBytes != i10) {
            return false;
        }
        int blockSizeKey = (int) ((jA0Q >> 8) & 15);
        long frameHeaderBytes2 = jA0Q >> 1;
        int frameStartPosition = (int) (frameHeaderBytes2 & 7);
        return A03((int) ((jA0Q >> 4) & 15), c1679Gh) && A02(frameStartPosition, c1679Gh) && !(((jA0Q & 1) > 1L ? 1 : ((jA0Q & 1) == 1L ? 0 : -1)) == 0) && A08(c4j, c1679Gh, (((jA0Q >>> 16) & 1) > 1L ? 1 : (((jA0Q >>> 16) & 1) == 1L ? 0 : -1)) == 0, c1674Gc) && A05(c4j, c1679Gh, (int) ((jA0Q >> 12) & 15)) && A06(c4j, c1679Gh, blockSizeKey) && A04(c4j, iA09);
    }

    public static boolean A08(C4J c4j, C1679Gh c1679Gh, boolean z10, C1674Gc c1674Gc) {
        long utf8Value;
        try {
            long jA0S = c4j.A0S();
            if (z10) {
                utf8Value = jA0S;
            } else {
                long utf8Value2 = c1679Gh.A03;
                utf8Value = utf8Value2 * jA0S;
            }
            c1674Gc.A00 = utf8Value;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean A09(InterfaceC2853lN interfaceC2853lN, C1679Gh c1679Gh, int i10, C1674Gc c1674Gc) throws IOException {
        long jA8a = interfaceC2853lN.A8a();
        byte[] bArr = new byte[2];
        interfaceC2853lN.AG9(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i10) {
            interfaceC2853lN.AI1();
            interfaceC2853lN.A3z((int) (jA8a - interfaceC2853lN.A8f()));
            return false;
        }
        C4J c4j = new C4J(16);
        System.arraycopy(bArr, 0, c4j.A0l(), 0, 2);
        byte[] frameStartBytes = c4j.A0l();
        c4j.A0e(GZ.A00(interfaceC2853lN, frameStartBytes, 2, 14));
        interfaceC2853lN.AI1();
        interfaceC2853lN.A3z((int) (jA8a - interfaceC2853lN.A8f()));
        return A07(c4j, c1679Gh, i10, c1674Gc);
    }
}
