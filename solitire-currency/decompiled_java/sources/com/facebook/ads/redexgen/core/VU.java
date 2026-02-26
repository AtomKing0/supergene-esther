package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Pair;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VU {
    public static byte[] A08;
    public static String[] A09 = {"gkSyaXwR", "2VU3Nz3voiV1lmdRee4U2QJOpqB0EmXx", "l2PJ1mhNLKomP6h8XAPCJTvwOfm7DNfm", "U14uMoZpedA5MoqMp8wF", "ZGFJtzG5houIZuhA5wVIi53yZAjLLlX2", "TKuU0S0TRmpOZ7a0gUh222TH0KiJMCsX", "Ntgwe7QRVjptK5Vt0gMbvLxTukJluaCr", "4nIPbhAhAn1Dg8Q4wgXTfE5Yoh5xfpBP"};
    public static final XS A0A;
    public static final Executor A0B;
    public static final AtomicReference<VY> A0C;
    public long A00;
    public long A01;
    public VT A02;
    public Map<String, String> A03;
    public final O2 A04;
    public final C2387dL A05;
    public final VV A06;
    public final String A07;

    public static String A06(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A08 = new byte[]{108, 107, 113, -99, 111, -99, -100, 115, -32, -15, -17, -21, -19, -25, -16, -19, -23, -14, -8, 3, -10, -23, -11, -7, -23, -9, -8, 3, -19, -24, -126, -84, 89, -117, -121, 115, 89, -62, -61, -108, -70, -67, -64, -64, -108, -26, -39, -41, -39, -35, -22, -39, -40, -39, -6, -85, -47, -12, -9, -9, -85, -16, -3, -3, -6, -3, -85, -18, -6, -17, -16, -85, -26, -80, -2, -24, -85, -80, -2, -33, -35, -26, -35, -22, -31, -37, -57, -66, -51, -48, -56, -53, -60, 10, 11, -30, 5, 8, 8, -28, 11, 11, 7, -35, -33, -36, -29, -42, -47, -46};
    }

    static {
        A0B();
        A0A = new XS();
        A0B = Executors.newCachedThreadPool(A0A);
        A0C = new AtomicReference<>();
    }

    public VU(C2387dL c2387dL) {
        this(c2387dL, O3.A00(c2387dL.A02()));
    }

    public VU(C2387dL c2387dL, O2 o22) {
        this.A01 = -1L;
        this.A00 = -1L;
        this.A05 = c2387dL;
        this.A06 = VV.A00();
        this.A07 = VZ.A01(c2387dL);
        this.A04 = o22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1906Pe A03(long j10, VR vr) {
        return new C1906Pe(this, vr, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        if (this.A05 == null || !C2484ev.A0A(this.A05)) {
            return;
        }
        C2001Sw c2001Sw = new C2001Sw(A06(8, 5, 102));
        c2001Sw.A05(1);
        this.A05.A08().AAy(A06(86, 7, 32), AbstractC2000Sv.A1x, c2001Sw);
    }

    private void A0C(int i10, String str) {
        String strA06 = A06(37, 16, 59);
        String strA062 = A06(0, 8, 1);
        String strA063 = A06(93, 10, 99);
        VF.A05(strA063, strA06, strA062);
        VF.A04(strA063, String.format(Locale.US, A06(53, 26, 82), Integer.valueOf(i10), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(V1 v12) {
        if (this.A02 != null) {
            this.A02.ADB(v12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(V1 v12) {
        XJ.A00(new PX(this, v12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L(PW pw) {
        if (this.A02 != null) {
            this.A02.AFO(pw);
        } else {
            if (pw.A00() == null || pw.A00().A06() == null) {
                return;
            }
            W2.A00(this.A05).A0D(pw.A00().A06().toString(), pw.A00().A0B());
        }
    }

    private void A0M(PW pw) {
        SW syncModule;
        XJ.A00(new C1903Pb(this, pw));
        if (U7.A2W(this.A05) && (syncModule = this.A05.A06()) != null) {
            syncModule.A6V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N(String str, long j10, VR vr) {
        String clientChallenge;
        try {
        } catch (Exception e10) {
            e = e10;
        }
        try {
            VX vxA07 = this.A06.A07(this.A05, str, j10);
            TE teA00 = vxA07.A00();
            if (teA00 != null) {
                U7.A0V(this.A05).A2y(teA00.A0A());
                if (U7.A0x(this.A05) && teA00.A08() != null) {
                    TO.A04(this.A05.A02(), teA00.A08());
                }
                if (U7.A0y(this.A05) && teA00.A0D() != null) {
                    TO.A05(this.A05.A02(), teA00.A0D());
                }
                this.A05.A08().ABq();
                this.A04.A0N(teA00.A07());
                VQ.A05(teA00.A05().A0B(), vr);
                C2108Xd.A01(this.A05, A0B, teA00);
                C2001Sw c2001Sw = new C2001Sw(A06(30, 7, 0) + C2091Wm.A02());
                c2001Sw.A06(1);
                c2001Sw.A0A(false);
                this.A05.A08().ABZ(A06(79, 7, 63), AbstractC2000Sv.A1W, c2001Sw);
            }
            switch (vxA07.A01()) {
                case A02:
                    PW pw = (PW) vxA07;
                    if (teA00 != null) {
                        if (teA00.A05().A0E()) {
                            VQ.A07(str, vr);
                        }
                        if (this.A03 != null) {
                            clientChallenge = this.A03.get(A06(13, 17, 107));
                        } else {
                            clientChallenge = null;
                        }
                        if (!TextUtils.isEmpty(vxA07.A02()) && !TextUtils.isEmpty(clientChallenge)) {
                            this.A05.A03().AHy(this.A05, clientChallenge, vxA07.A02());
                        }
                    }
                    this.A05.A0F().A3P(XG.A01(this.A01), XG.A02(this.A01, this.A00));
                    A0M(pw);
                    return;
                case A03:
                    PV pv = (PV) vxA07;
                    String strA04 = pv.A04();
                    AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(pv.A03(), AdErrorType.ERROR_MESSAGE);
                    A0C(pv.A03(), strA04);
                    if (strA04 == null) {
                        strA04 = str;
                    }
                    this.A05.A0F().A3O(XG.A01(this.A01), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA04, adErrorTypeAdErrorTypeFromCode.isPublicError());
                    A0E(V1.A01(adErrorTypeAdErrorTypeFromCode, strA04));
                    return;
                default:
                    AdErrorType adErrorType = AdErrorType.UNKNOWN_RESPONSE;
                    this.A05.A0F().A3O(XG.A01(this.A01), adErrorType.getErrorCode(), str, adErrorType.isPublicError());
                    A0E(V1.A01(adErrorType, str));
                    return;
            }
        } catch (Exception e11) {
            e = e11;
            String message = e.getMessage();
            AdErrorType adErrorType2 = AdErrorType.PARSER_FAILURE;
            C2387dL c2387dL = this.A05;
            if (A09[0].length() == 29) {
                throw new RuntimeException();
            }
            A09[0] = "STn1t4NLUPoQ";
            c2387dL.A0F().A3O(XG.A01(this.A01), adErrorType2.getErrorCode(), message, adErrorType2.isPublicError());
            A0E(V1.A01(adErrorType2, message));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O(String str, long j10, VR vr) {
        A0B.execute(new C1907Pf(this, str, j10, vr));
    }

    private boolean A0P(VR vr) {
        String string = vr.A06().toString();
        if (W2.A00(this.A05).A0F(string)) {
            return false;
        }
        int iA0A = W2.A00(this.A05).A0A(string);
        int storedAdsCount = U7.A0J(this.A05);
        int iA09 = W2.A00(this.A05).A09(string);
        if (iA0A >= storedAdsCount || iA0A > iA09) {
            W2 w2A00 = W2.A00(this.A05);
            String type = vr.A06().toString();
            Pair<String, String> pairA0B = w2A00.A0B(type);
            if (pairA0B != null) {
                Object obj = pairA0B.second;
                String[] strArr = A09;
                String str = strArr[1];
                String str2 = strArr[4];
                int storedAdsCount2 = str.charAt(27);
                if (storedAdsCount2 == str2.charAt(27)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A09;
                strArr2[5] = "wxWvHA1chxzz72CPhzVDSI5kTKVxH7gh";
                strArr2[2] = "qa9WwGn6xu1bvFfukLGFlV7cMdAOaohF";
                if (obj != null && pairA0B.first != null) {
                    A0O(pairA0B.second.toString(), 0L, vr);
                    return true;
                }
            }
        }
        return false;
    }

    public final void A0Q(VR vr) {
        this.A01 = System.currentTimeMillis();
        T5.A0B(this.A05);
        A0C.get();
        if (0 != 0) {
            throw new NullPointerException(A06(103, 7, 52));
        }
        if (U7.A02(this.A05) > 0 && A0P(vr)) {
            return;
        }
        if (VQ.A08(vr)) {
            XU.A06.execute(new C1909Ph(this));
            String strA02 = VQ.A02(vr);
            if (strA02 != null) {
                this.A05.A0F().AJv();
                A0O(strA02, 0L, vr);
                return;
            } else {
                AdErrorType error = AdErrorType.LOAD_TOO_FREQUENTLY;
                this.A05.A0F().A3O(XG.A01(this.A01), error.getErrorCode(), error.getDefaultErrorMessage(), error.isPublicError());
                A0E(V1.A01(error, null));
                return;
            }
        }
        A0B.execute(new C1908Pg(this, vr));
    }

    public final void A0R(VT vt) {
        this.A02 = vt;
    }
}
