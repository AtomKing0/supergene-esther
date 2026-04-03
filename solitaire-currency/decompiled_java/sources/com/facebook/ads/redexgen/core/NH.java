package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NH {
    public static byte[] A05;
    public static String[] A06 = {"SwW", "nKJOmWTx3LjNZvOp7YbBROgXIyGkfXUh", "cNvS8LZQYgXEdOP85dYAvAy4C3J", "ICxq6EmLG0dgZi7UJ5PBV2wBsvrmCfpb", "tKedy3gZYTLe", "bmz0vq", "hvIAQTYE0cdtFIL2", "tj9oqRvQS19ndgZTuA"};
    public SF A00;
    public EnumC2176Zt A01 = EnumC2176Zt.A05;
    public ArrayList<C2298bt> A02 = new ArrayList<>();
    public final AbstractC1840Mo A03;
    public final NG A04;

    public static String A04(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-35, 23, 35, 28, 27, -66, -29, -23, -38, -25, -29, -42, -31, -107, -70, -25, -25, -28, -25, -107, -89, -91, -91, -85, -107, -20, -34, -23, -35, -28, -22, -23, -107, -42, -107, -21, -42, -31, -34, -39, -107, -74, -39, -66, -29, -37, -28, -93, 21, 24, 19, 24, 21, 40, 21, 19, 22, 41, 34, 24, 32, 25, -29, -14, -21, -36, -31, -38, -30, -25, -40, -23, -38, -21, -38, -26, -20, 18, 23, 16, 24, 29, 20, 19, -16, 19, -13, 16, 35, 16, -15, 36, 29, 19, 27, 20, 63, 68, 74, 59, 72, 73, 74, 63, 74, 63, 55, 66};
    }

    static {
        A06();
    }

    public NH(C2387dL c2387dL, NU nu, NG ng, String str) {
        JSONObject dataObject = nu.A03();
        this.A03 = A01(c2387dL, nu, str, dataObject);
        this.A04 = ng;
    }

    private AdError A00(C2387dL c2387dL, AbstractC2662hy abstractC2662hy) {
        if (abstractC2662hy == null || abstractC2662hy.A27().isEmpty()) {
            c2387dL.A08().AAy(A04(62, 3, 33), AbstractC2000Sv.A0Z, new C2001Sw(A04(5, 43, 20)));
            return AdError.internalError(2006);
        }
        return null;
    }

    public static AbstractC1840Mo A01(C2387dL c2387dL, NU nu, String str, JSONObject jSONObject) {
        AbstractC1840Mo abstractC1840MoA00 = null;
        if (jSONObject.has(A04(65, 12, 24))) {
            try {
                abstractC1840MoA00 = C2660hw.A01(jSONObject, c2387dL, true);
                abstractC1840MoA00.A1L(true);
                abstractC1840MoA00.A1I(A04(96, 12, 117));
            } catch (JSONException unused) {
            }
        }
        if (abstractC1840MoA00 == null) {
            abstractC1840MoA00 = AnonymousClass77.A00(jSONObject, c2387dL);
        }
        abstractC1840MoA00.A1H(str);
        TF tfA01 = nu.A01();
        if (tfA01 != null) {
            abstractC1840MoA00.A1D(tfA01.A06());
        }
        return abstractC1840MoA00;
    }

    private SF A03(C2387dL c2387dL) {
        return this.A00 != null ? this.A00 : new SF(c2387dL);
    }

    private void A08(C2387dL c2387dL, AnonymousClass77 anonymousClass77) {
        NB playableData = anonymousClass77.A20().A0H().A07();
        A0B(playableData != null ? playableData.A0B() : EnumC2176Zt.A05);
        C2644hb c2644hb = new C2644hb(this);
        SF sf = new SF(c2387dL);
        boolean z10 = U7.A2A(c2387dL) && C1959Rf.A0A(anonymousClass77.A1C());
        if (z10) {
            C1959Rf unifiedAssetsLoader = new C1959Rf(sf, anonymousClass77.A1C(), anonymousClass77.A0v(), anonymousClass77.A17(), z10, new C2643ha(this));
            sf.A0e(new C2030Ua(anonymousClass77.A25(), c2387dL.A0A()));
            unifiedAssetsLoader.A0B();
            return;
        }
        NR.A02(c2387dL, anonymousClass77, true, c2644hb);
    }

    private void A09(C2387dL c2387dL, EnumSet<CacheFlag> enumSet, AbstractC2662hy abstractC2662hy, int i10, NG ng) {
        boolean zA1Y = abstractC2662hy.A1Y();
        SF sfA03 = A03(c2387dL);
        sfA03.A0e(new C2030Ua(abstractC2662hy.A25(), c2387dL.A0A()));
        boolean z10 = U7.A2A(c2387dL) && C1959Rf.A0A(abstractC2662hy.A1C());
        if (z10) {
            new C1959Rf(sfA03, abstractC2662hy.A1C(), abstractC2662hy.A0v(), abstractC2662hy.A17(), z10, new C2649hi(this, c2387dL, zA1Y, abstractC2662hy, ng)).A0B();
            return;
        }
        String strA04 = A04(96, 12, 117);
        if (zA1Y) {
            SB sb = new SB(abstractC2662hy.A0s(), abstractC2662hy.A17(), strA04);
            sb.A04 = true;
            sb.A03 = A04(0, 5, 78);
            sfA03.A0Y(sb);
        }
        sfA03.A0d(new SD(abstractC2662hy.A23().A01(), C2353cm.A04, C2353cm.A04, abstractC2662hy.A17(), A04(96, 12, 117)));
        boolean zContains = enumSet.contains(CacheFlag.VIDEO);
        int i11 = 0;
        boolean zA2s = U7.A2s(c2387dL, C2442eF.A03());
        for (C1841Mp adInfo : abstractC2662hy.A27()) {
            SD sd = new SD(adInfo.A0H().A08(), NN.A00(adInfo.A0H()), NN.A01(adInfo.A0H()), abstractC2662hy.A17(), A04(96, 12, 117));
            if (i11 == 0) {
                sfA03.A0c(sd);
            } else {
                sfA03.A0d(sd);
            }
            Iterator<String> it = adInfo.A0K().A02().iterator();
            while (it.hasNext()) {
                sfA03.A0d(new SD(it.next(), -1, -1, abstractC2662hy.A17(), A04(96, 12, 117)));
            }
            if (zContains && !TextUtils.isEmpty(adInfo.A0H().A09())) {
                SB sb2 = new SB(adInfo.A0H().A09(), abstractC2662hy.A17(), A04(96, 12, 117), adInfo.A0H().A06());
                sb2.A04 = false;
                if (i11 == 0) {
                    if (zA1Y && !zA2s) {
                        sfA03.A0Y(sb2);
                    } else {
                        sfA03.A0b(sb2);
                    }
                } else if (zA1Y && !zA2s) {
                    sfA03.A0Z(sb2);
                } else {
                    sfA03.A0a(sb2);
                }
            }
            i11++;
        }
        sfA03.A0X(new C2647hg(this, c2387dL, zA1Y, abstractC2662hy, ng), new S8(abstractC2662hy.A17(), strA04, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(C2387dL c2387dL, EnumSet<CacheFlag> enumSet, C2660hw c2660hw, AbstractC2662hy abstractC2662hy, int i10, NG ng) {
        A09(c2387dL, enumSet, abstractC2662hy, i10, new C2651hk(this, c2387dL, abstractC2662hy, c2660hw, i10, ng, enumSet));
    }

    private void A0B(EnumC2176Zt enumC2176Zt) {
        this.A01 = enumC2176Zt;
    }

    private boolean A0C(C2387dL c2387dL, AbstractC2662hy abstractC2662hy) {
        AdError adErrorA00 = A00(c2387dL, abstractC2662hy);
        if (adErrorA00 != null) {
            this.A04.ACF(adErrorA00);
            return true;
        }
        return false;
    }

    public final AbstractC1840Mo A0D() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        return com.facebook.ads.redexgen.core.EnumC2057Vb.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        return com.facebook.ads.redexgen.core.EnumC2057Vb.A0B;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.ads.redexgen.core.EnumC2057Vb A0E() {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.Mo r0 = r5.A03
            boolean r0 = r0.A1T()
            if (r0 == 0) goto Lb
            com.facebook.ads.redexgen.X.Vb r0 = com.facebook.ads.redexgen.core.EnumC2057Vb.A04
            return r0
        Lb:
            com.facebook.ads.redexgen.X.Mo r4 = r5.A03
            com.facebook.ads.redexgen.X.hy r4 = (com.facebook.ads.redexgen.core.AbstractC2662hy) r4
            boolean r0 = r4.A1Y()
            if (r0 == 0) goto L18
            com.facebook.ads.redexgen.X.Vb r0 = com.facebook.ads.redexgen.core.EnumC2057Vb.A06
            return r0
        L18:
            java.util.List r0 = r4.A27()
            int r1 = r0.size()
            r0 = 1
            if (r1 <= r0) goto L26
            com.facebook.ads.redexgen.X.Vb r0 = com.facebook.ads.redexgen.core.EnumC2057Vb.A0A
            return r0
        L26:
            com.facebook.ads.redexgen.X.Mp r0 = r4.A20()
            com.facebook.ads.redexgen.X.Ms r0 = r0.A0H()
            com.facebook.ads.redexgen.X.NB r3 = r0.A07()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.NH.A06
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 14
            if (r1 == r0) goto L77
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.NH.A06
            java.lang.String r1 = "HO5lN2vl3hawZ3xdOTbB4PXxItmZOFKM"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "QabHGQsenJFHZf5mHftqzVXi6FXcwsQx"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L50
            com.facebook.ads.redexgen.X.Vb r0 = com.facebook.ads.redexgen.core.EnumC2057Vb.A0C
            return r0
        L50:
            boolean r3 = r5.A0L(r4)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.NH.A06
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 2
            if (r1 == r0) goto L71
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.NH.A06
            java.lang.String r1 = "iV2CDA2M2IfUZLXvhnmiNr1pV0Sur2CQ"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "GDT4frbvCKvkZrCQcOaJTMqN9T6RIdn0"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L74
        L6e:
            com.facebook.ads.redexgen.X.Vb r0 = com.facebook.ads.redexgen.core.EnumC2057Vb.A0D
            return r0
        L71:
            if (r3 == 0) goto L74
            goto L6e
        L74:
            com.facebook.ads.redexgen.X.Vb r0 = com.facebook.ads.redexgen.core.EnumC2057Vb.A0B
            return r0
        L77:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.NH.A0E():com.facebook.ads.redexgen.X.Vb");
    }

    public final EnumC2176Zt A0F() {
        return this.A01;
    }

    public final String A0G() {
        if (this.A03.A1T()) {
            return ((C2660hw) this.A03).A20();
        }
        return ((AbstractC2662hy) this.A03).A25();
    }

    public final void A0H() {
        this.A04.AJm();
    }

    public final void A0I(Intent intent, RewardData rewardData, String str) {
        this.A03.A1F(rewardData);
        this.A03.A1J(str);
        if (A0D().A1T()) {
            intent.putExtra(A04(77, 19, 78), this.A03);
        }
        intent.putExtra(A04(48, 14, 83), this.A03);
    }

    public final void A0J(C2387dL c2387dL, EnumSet<CacheFlag> enumSet) {
        if (A0E() == EnumC2057Vb.A04) {
            C2660hw c2660hw = (C2660hw) this.A03;
            AbstractC2662hy abstractC2662hyA1w = c2660hw.A1w();
            if (A0C(c2387dL, abstractC2662hyA1w) || abstractC2662hyA1w == null) {
                return;
            }
            this.A04.AGo();
            A0A(c2387dL, enumSet, c2660hw, abstractC2662hyA1w, 0, this.A04);
            return;
        }
        AbstractC2662hy abstractC2662hy = (AbstractC2662hy) this.A03;
        if (A06[5].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "h3j4XQE4N9RDZ4AU6tvjsFYKX3e30HKG";
        strArr[3] = "lDhcJ7lgFtqhZjTb781X3zaoWDc2BWUc";
        if (A0C(c2387dL, abstractC2662hy)) {
            return;
        }
        this.A04.AGo();
        if (A0E() == EnumC2057Vb.A0C) {
            AnonymousClass77 anonymousClass77 = (AnonymousClass77) this.A03;
            String[] strArr2 = A06;
            if (strArr2[2].length() != strArr2[6].length()) {
                A06[7] = "0uVLF1bkkTEn2WeYm46QMmOd1A6";
                A08(c2387dL, anonymousClass77);
                return;
            } else {
                A08(c2387dL, anonymousClass77);
                return;
            }
        }
        A09(c2387dL, enumSet, (AnonymousClass77) this.A03, -1, this.A04);
    }

    public final boolean A0K() {
        return this.A03.A1P();
    }

    public final boolean A0L(AbstractC2662hy abstractC2662hy) {
        return !TextUtils.isEmpty(abstractC2662hy.A20().A0H().A09());
    }
}
