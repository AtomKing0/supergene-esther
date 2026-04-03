package com.applovin.impl;

import com.applovin.impl.mediation.ads.a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z2 implements MaxAdListener, MaxRewardedAdListener, MaxAdViewAdListener, MaxAdRevenueListener, a.InterfaceC0165a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a.InterfaceC0165a f7891a;

    public z2(a.InterfaceC0165a interfaceC0165a) {
        this.f7891a = interfaceC0165a;
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdClicked(MaxAd maxAd) {
        l2.a((MaxAdListener) this.f7891a, maxAd);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdCollapsed(MaxAd maxAd) {
        l2.b(this.f7891a, maxAd);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        l2.a(this.f7891a, maxAd, maxError);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayed(MaxAd maxAd) {
        l2.c(this.f7891a, maxAd);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdExpanded(MaxAd maxAd) {
        l2.d(this.f7891a, maxAd);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdHidden(MaxAd maxAd) {
        l2.e(this.f7891a, maxAd);
    }

    @Override // com.applovin.mediation.MaxAdRequestListener
    public void onAdRequestStarted(String str) {
        l2.a(this.f7891a, str);
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(MaxAd maxAd) {
        l2.a((MaxAdRevenueListener) this.f7891a, maxAd);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        l2.a(this.f7891a, maxAd, maxReward);
    }
}
