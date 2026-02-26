package com.facebook.ads.redexgen.core;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1855Nd implements InterstitialAdListener {
    public final /* synthetic */ AbstractC2662hy A00;
    public final /* synthetic */ C2612h4 A01;

    public C1855Nd(C2612h4 c2612h4, AbstractC2662hy abstractC2662hy) {
        this.A01 = c2612h4;
        this.A00 = abstractC2662hy;
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdClicked(Ad ad) {
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdLoaded(Ad ad) {
        this.A01.A00.A07.onAdLoaded(this.A01.A00.A08.A6c());
    }

    @Override // com.facebook.ads.AdListener
    public final void onError(Ad ad, AdError adError) {
        this.A01.A00.A01 = null;
        this.A00.A2A(false);
        this.A01.A00.A07.onAdLoaded(this.A01.A00.A08.A6c());
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public final void onInterstitialDismissed(Ad ad) {
        this.A01.A00.A04 = false;
        if (this.A01.A00.A03 != null) {
            this.A01.A00.A03.A0S(new C2614h6(this));
            this.A01.A00.A03.A0N();
            this.A01.A00.A03.A0K();
            this.A01.A00.A03 = null;
        }
        this.A01.A00.A07.onInterstitialDismissed(this.A01.A00.A08.A6c());
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public final void onInterstitialDisplayed(Ad ad) {
    }

    @Override // com.facebook.ads.AdListener
    public final void onLoggingImpression(Ad ad) {
    }
}
