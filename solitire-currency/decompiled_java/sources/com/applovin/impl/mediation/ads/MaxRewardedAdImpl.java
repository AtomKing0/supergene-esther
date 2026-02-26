package com.applovin.impl.mediation.ads;

import android.content.Context;
import com.applovin.impl.l2;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.t2;
import com.applovin.impl.y1;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;

/* JADX INFO: loaded from: classes2.dex */
public class MaxRewardedAdImpl extends MaxFullscreenAdImpl {

    private class b extends MaxFullscreenAdImpl.b implements MaxRewardedAdListener {
        private b() {
            super();
        }

        @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.b, com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            t2 t2Var = (t2) maxAd;
            if (!t2Var.l0().get()) {
                com.applovin.impl.sdk.n nVar = MaxRewardedAdImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxRewardedAdImpl maxRewardedAdImpl = MaxRewardedAdImpl.this;
                    maxRewardedAdImpl.logger.a(maxRewardedAdImpl.tag, "User not rewarded for ad: " + maxAd);
                }
                MaxRewardedAdImpl.this.sdk.J().a(y1.f7771a0, t2Var);
            }
            super.onAdHidden(maxAd);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            com.applovin.impl.sdk.n nVar = MaxRewardedAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxRewardedAdImpl maxRewardedAdImpl = MaxRewardedAdImpl.this;
                maxRewardedAdImpl.logger.a(maxRewardedAdImpl.tag, "MaxRewardedAdListener.onUserRewarded(ad=" + maxAd + ", reward=" + maxReward + "), listener=" + MaxRewardedAdImpl.this.adListener);
            }
            l2.a(MaxRewardedAdImpl.this.adListener, maxAd, maxReward, true);
        }
    }

    public MaxRewardedAdImpl(String str, MaxAdFormat maxAdFormat, MaxFullscreenAdImpl.a aVar, String str2, com.applovin.impl.sdk.j jVar, Context context) {
        super(str, maxAdFormat, aVar, str2, jVar, context);
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl
    protected MaxFullscreenAdImpl.b createAdListenerWrapper() {
        return new b();
    }
}
