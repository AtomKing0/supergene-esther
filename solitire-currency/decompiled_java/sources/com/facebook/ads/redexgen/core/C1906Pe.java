package com.facebook.ads.redexgen.core;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1906Pe implements InterfaceC2467ee {
    public static byte[] A03;
    public static String[] A04 = {"vUQacvUb1jgaOB1nXCILUaEr4ItZ5QEs", "N", "ozPzI", "iemFS7qx3ItQSdDQeBrvuJ9y9CMkfIqY", "EwROMxnfRd6F7268i4EpvPtVg3hQf", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "qVu8", "3RxrE6NsEsLt8TXu"};
    public final /* synthetic */ long A00;
    public final /* synthetic */ VR A01;
    public final /* synthetic */ VU A02;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{85, 80, 5, 87, 81, 3, 7, 0, 57, 108, 104, 63, 104, 57, 59, 44, 53, 41, 40, 35, 30, 5, 3, 22, 18, 15, 9, 8, 92, 70, 78, 120, 111, 107, 120, 111, 61, 120, 111, 111, 114, 111, 61, 114, 126, 126, 104, 111, 111, 120, 121, 124, 74, 93, 89, 74, 93, 15, 93, 74, 95, 67, 70, 74, 75, 15, 92, 90, 76, 76, 74, 92, 92, 73, 90, 67, 67, 86, 63, 62, 19, 63, 61, 32, 60, 53, 36, 53, 16, 17, 58, 13, 13, 16, 13};
    }

    static {
        A01();
    }

    public C1906Pe(VU vu, VR vr, long j10) {
        this.A02 = vu;
        this.A01 = vr;
        this.A00 = j10;
    }

    private final void A02(C2479eq c2479eq) {
        VQ.A06(this.A01);
        try {
            InterfaceC2465ec response = c2479eq.A00();
            if (response != null) {
                String strA6v = response.A6v();
                VX serverResponse = this.A02.A06.A07(this.A02.A05, strA6v, this.A00);
                if (serverResponse.A01() == VW.A03) {
                    PV pv = (PV) serverResponse;
                    String strA04 = pv.A04();
                    AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(pv.A03(), AdErrorType.ERROR_MESSAGE);
                    if (strA04 != null) {
                        strA6v = strA04;
                    }
                    this.A02.A05.A0F().A3O(XG.A01(this.A02.A01), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA6v, adErrorTypeAdErrorTypeFromCode.isPublicError());
                    this.A02.A0E(V1.A01(adErrorTypeAdErrorTypeFromCode, strA6v));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String message = c2479eq.getMessage();
            LH lhA0F = this.A02.A05.A0F();
            long jA01 = XG.A01(this.A02.A01);
            int errorCode = adErrorType.getErrorCode();
            boolean zIsPublicError = adErrorType.isPublicError();
            if (A04[2].length() == 29) {
                throw new RuntimeException();
            }
            A04[4] = "NZ18w";
            lhA0F.A3O(jA01, errorCode, message, zIsPublicError);
            this.A02.A0E(V1.A01(adErrorType, message));
        } catch (JSONException e10) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String errorMessage = c2479eq.getMessage();
            this.A02.A05.A0F().A3O(XG.A01(this.A02.A01), adErrorType2.getErrorCode(), A00(15, 15, 30) + e10.getMessage(), adErrorType2.isPublicError());
            this.A02.A0E(V1.A01(adErrorType2, errorMessage));
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2467ee
    public final void ACo(InterfaceC2465ec interfaceC2465ec) {
        VF.A05(A00(78, 10, 40), A00(51, 27, 87), A00(8, 7, 114));
        if (interfaceC2465ec != null) {
            String strA6v = interfaceC2465ec.A6v();
            int iA02 = U7.A02(this.A02.A05);
            String[] strArr = A04;
            String str = strArr[5];
            String response = strArr[1];
            if (str.length() != response.length()) {
                throw new RuntimeException();
            }
            A04[2] = "kblvpkFa8oUK1ItVGqcsW93nH";
            if (iA02 > 0) {
                W2.A00(this.A02.A05).A0C(strA6v);
            }
            VQ.A06(this.A01);
            this.A02.A0O(strA6v, this.A00, this.A01);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2467ee
    public final void ADC(Exception exc) {
        VF.A05(A00(88, 7, 7), A00(30, 21, 101), A00(0, 8, 30));
        if (C2479eq.class.equals(exc.getClass())) {
            A02((C2479eq) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String errorMessage = exc.getMessage();
        this.A02.A05.A0F().A3O(XG.A01(this.A02.A01), adErrorType.getErrorCode(), errorMessage, adErrorType.isPublicError());
        this.A02.A0E(V1.A01(adErrorType, errorMessage));
    }
}
