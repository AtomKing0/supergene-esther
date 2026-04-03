package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class WW implements Runnable {
    public static String[] A04 = {"nCRFoG2V5rxtp9CJ0zj2vqX2pOjohwfk", "4wjnoNx3VOTWdL7VvzY4PdOFwDa8aAyk", "NZwRvgeKfVOQj3OAbWBZydUCa0", "QhytIBUnuaSIq9HsTJzjLcd0Gyd", "BSNgfeEt9bBv41mFKDcPuiwW51mPbBL", "ThuVKQMdtpTlOVe04IgNONUKoYEgRLHM", "EXwZjrYuwLfsbcbpnacjwuDYCB43acny", "AVskEroBo8UlfYPInQ7Yx5KSddGfFQyi"};
    public final /* synthetic */ C2361cu A00;
    public final /* synthetic */ InterfaceC2100Wv A01;
    public final /* synthetic */ String A02;
    public final /* synthetic */ int[] A03;

    public WW(int[] iArr, String str, C2361cu c2361cu, InterfaceC2100Wv interfaceC2100Wv) {
        this.A03 = iArr;
        this.A02 = str;
        this.A00 = c2361cu;
        this.A01 = interfaceC2100Wv;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            int[] iArr = this.A03;
            iArr[0] = iArr[0] + 1000;
            int i10 = this.A03[0];
            if (A04[5].charAt(0) == 'R') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "K9ogtrTQz9r2EYsYEG2F5l0cYywtmYZ4";
            strArr[7] = "6mL3lrEUp2ULAISFIzSh85ZjlbRVvlWv";
            if (i10 > 600000) {
                WX.A02.removeCallbacks(this);
                WX.A03.remove(this.A02);
            } else {
                if (WX.A08(this.A00.getPackageManager(), this.A02)) {
                    WX.A02.removeCallbacks(this);
                    WX.A03.remove(this.A02);
                    this.A01.AER(this.A02);
                    return;
                }
                WX.A02.postDelayed(this, 1000L);
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
            if (A04[2].length() != 26) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "FQThdvyXjGVQZyAeyGp3f4l1pRfTgr0";
            strArr2[3] = "sqm3iAA5OiJF7R8ZxJPsoNc3WTf";
        }
    }
}
