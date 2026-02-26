package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FZ extends AbstractRunnableC2074Vt {
    public static byte[] A02;
    public static String[] A03 = {"dab4fRnX0jwVtTCdppjyxAzmLS4bXJsv", "tx88Rmris0qAnIQYPQwCDQk09feKvYvd", "zx5uuvDAcytcTb9ViP21DGr2Ir", "iFOXUW5dAcR78ORAksMxLEmjU8chlyrY", "cH6E6XWheDX0I5qudQa8gCuUDMH3DwGR", "ZrH1xVhvr", "HcVkU72Pv92AZpKffx9OD1kZyJiX0ZmG", "FRYXqcD3MsRMpqiQBVhoHwYMYH2ko3dl"};
    public final /* synthetic */ C13673r A00;
    public final /* synthetic */ C3Q A01;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i10, i10 + i11);
        int i13 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[7].charAt(20) == 'R') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[6] = "mmZKkJ0qdyfdoCPbfy2YKuwlL3WBbVIn";
            strArr[0] = "dwlf7VAy7NoW0pl9cb0nbAZtUrVGpkqt";
            if (i13 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 57);
            i13++;
        }
    }

    public static void A01() {
        A02 = new byte[]{-8, 43, 28, 28, 27, 40, 31, 36, 29, -42, 31, 36, 26, 27, 28, 31, 36, 31, 42, 27, 34, 47};
    }

    static {
        A01();
    }

    public FZ(C13673r c13673r, C3Q c3q) {
        this.A00 = c13673r;
        this.A01 = c3q;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        if (this.A00.A0L.getState() == EnumC2457eU.A02 && this.A00.A0L.getCurrentPositionInMillis() == A00()) {
            this.A00.A0R(A00(0, 22, 125));
        }
    }
}
