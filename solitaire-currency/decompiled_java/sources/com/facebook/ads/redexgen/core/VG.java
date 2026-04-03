package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VG implements US {
    public static US A03;
    public static byte[] A04;
    public static final String A05;
    public static volatile boolean A06;
    public final C2361cu A00;
    public final InterfaceC2013Tj A01;
    public final UR A02;

    public static String A02(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{50, 119, 100, 119, 124, 102, 60, 54, 3, 3, 18, 26, 7, 3, 30, 25, 16, 87, 3, 24, 87, 27, 24, 16, 87, 22, 25, 87, 30, 25, 1, 22, 27, 30, 19, 87, 66, 100, 119, 117, 115, 87, 85, 94, 85, 66, 89, 83, 29, 16, 25, 12};
    }

    static {
        A03();
        A05 = VG.class.getSimpleName();
        A06 = false;
    }

    public VG(C2361cu c2361cu) {
        UQ dispatchCallback;
        this.A00 = c2361cu;
        if (U9.A0T(c2361cu)) {
            this.A01 = AbstractC2012Th.A00(c2361cu);
            dispatchCallback = UX.A00(c2361cu, this.A01);
        } else {
            C6J c6jA01 = AbstractC2012Th.A01(c2361cu);
            dispatchCallback = UX.A01(c2361cu, c6jA01);
            this.A01 = c6jA01;
        }
        this.A02 = new VJ(c2361cu, dispatchCallback);
        XU.A08.execute(new VI(this));
        A04(c2361cu);
    }

    public static synchronized US A01(C2361cu c2361cu) {
        if (A03 == null) {
            A03 = new VG(c2361cu);
        }
        return A03;
    }

    public static synchronized void A04(C2361cu c2361cu) {
        if (A06) {
            return;
        }
        c2361cu.A04().ACE();
        A06 = true;
    }

    private void A05(UP up) {
        if (!up.A0A()) {
            Log.e(A05, A02(7, 29, 55) + up.A06() + A02(0, 7, 82));
        } else {
            A06(up);
            this.A01.AKL(up, new VH(this, up));
        }
    }

    private void A06(UP up) {
        switch (UT.A00[up.A06().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                C2001Sw c2001Sw = new C2001Sw(new Exception(A02(36, 5, 86)));
                c2001Sw.A05(1);
                try {
                    c2001Sw.A07(new JSONObject().put(A02(48, 4, 41), up.A06().toString()));
                    break;
                } catch (JSONException unused) {
                }
                this.A00.A08().AAz(A02(41, 7, 112), AbstractC2000Sv.A1H, c2001Sw);
                break;
        }
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AAp(String str, Map<String, String> data) {
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A04).A02(UV.A04).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AAr(String str, Map<String, String> data) {
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A04).A02(UV.A06).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AAs(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A04).A02(UV.A07).A06(AbstractC2032Uc.A0A(str, UZ.A0I)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AAt(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A04).A02(UV.A08).A06(AbstractC2032Uc.A0A(str, UZ.A06)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AAx(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A04).A02(UV.A0B).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AB1(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A04).A02(UV.A0C).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AB5(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A05).A02(UV.A0D).A06(AbstractC2032Uc.A0A(str, UZ.A0T)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AB6(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A05).A02(UV.A0E).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AB7(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A05).A02(UV.A0F).A06(AbstractC2032Uc.A0A(str, UZ.A0V)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AB8(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A05).A02(UV.A0K).A06(AbstractC2032Uc.A0A(str, UZ.A0W)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABH(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A05).A02(UV.A0H).A06(AbstractC2032Uc.A0A(str, UZ.A0X)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABJ(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A04).A02(UV.A0J).A06(AbstractC2032Uc.A0A(str, UZ.A0a)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABK(String str, Map<String, String> data, String str2, UU uu) {
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(uu).A02(UV.A00(str2)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABL(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UP adEvent = new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A04).A02(UV.A0L).A07(this.A00);
        A05(adEvent);
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABP(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A05).A02(UV.A0N).A06(AbstractC2032Uc.A0A(str, UZ.A0i)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABQ(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A05).A02(UV.A0O).A06(AbstractC2032Uc.A0A(str, UZ.A0j)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABS(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A01(UU.A04).A02(UV.A0P).A06(AbstractC2032Uc.A0A(str, UZ.A0k)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABT(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A04).A02(UV.A0G).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABX(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A05).A02(UV.A0Q).A06(AbstractC2032Uc.A0A(str, UZ.A0o)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABY(String str, Map<String, String> data) {
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A05).A02(UV.A0V).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void ABa(String str, Map<String, String> data) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new UO().A04(str).A00(this.A00.A09().A01()).A03(this.A00.A09().A02()).A05(data).A01(UU.A05).A02(UV.A0W).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.core.US
    public final void AGF(String str) {
        new AsyncTaskC2486ex(this.A00).execute(str);
    }
}
