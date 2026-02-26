package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class T7 implements S7 {
    public static byte[] A03;
    public static String[] A04 = {"mqH0C", "P", "Prv4rgxv4XvjDltPpSeqnrL7fWipLvZ8", "wRAQVkTW0Fdys8", "msKGEa7u", "", "70lhKNnmmmhMBIKZ0qoNvOWwjw91iHAS", "ylnG6cBHFe0YAiTdKU1DLGP7G6QidCUo"};
    public final /* synthetic */ C2683iN A00;
    public final /* synthetic */ C1930Qc A01;
    public final /* synthetic */ boolean A02;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{28, 55, 63, 66, 59, 58, -10, 74, 69, -10, 58, 69, 77, 68, 66, 69, 55, 58, -10, 55, -10, 67, 59, 58, 63, 55, 4};
    }

    static {
        A01();
    }

    public T7(C1930Qc c1930Qc, C2683iN c2683iN, boolean z10) {
        this.A01 = c1930Qc;
        this.A00 = c2683iN;
        this.A02 = z10;
    }

    @Override // com.facebook.ads.redexgen.core.S7
    public final void ACh() {
        if (this.A01.A0a != null) {
            this.A01.A0a.A0J();
            this.A01.A0a = null;
        }
        AdErrorType adErrorType = AdErrorType.CACHE_FAILURE_ERROR;
        String strA00 = A00(0, 27, 111);
        this.A01.A0c.A0F().A3F(XG.A01(this.A01.A00), adErrorType.getErrorCode(), strA00);
        if (this.A01.A0G != null) {
            this.A01.A0G.ADB(V1.A01(adErrorType, strA00));
        }
    }

    @Override // com.facebook.ads.redexgen.core.S7
    public final void ACq() {
        this.A01.A0a = this.A00;
        if (this.A02 && this.A01.A0A != null) {
            this.A01.A0A.A0L();
        }
        if (this.A01.A0G != null) {
            if (this.A01.A0E.equals(EnumC2041Ul.A04) && !this.A01.A0r()) {
                this.A01.A0G.AEB();
            }
            if (this.A02) {
                C1930Qc c1930Qc = this.A01;
                String[] strArr = A04;
                if (strArr[4].length() != strArr[0].length()) {
                    String[] strArr2 = A04;
                    strArr2[4] = "lirdd0Qr";
                    strArr2[0] = "muvxx";
                    if (U7.A1n(c1930Qc.A0c) && this.A01.A10() != null && this.A01.A10().A1Y()) {
                        this.A01.A0M = AbstractC2299bu.A01(this.A01.A0c, this.A01.A10(), 4, new T8(this));
                        return;
                    } else {
                        C1930Qc c1930Qc2 = this.A01;
                        if (A04[3].length() != 28) {
                            A04[6] = "Y1qaffLCA6OgZ6gO9VGOLjOrervRHVYN";
                            c1930Qc2.A0G.ACH();
                            return;
                        }
                    }
                }
                throw new RuntimeException();
            }
        }
    }
}
