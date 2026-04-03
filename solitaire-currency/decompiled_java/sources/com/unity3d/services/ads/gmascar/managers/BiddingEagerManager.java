package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

/* JADX INFO: loaded from: classes4.dex */
public class BiddingEagerManager extends BiddingBaseManager {
    public BiddingEagerManager(boolean z10, IUnityAdsTokenListener iUnityAdsTokenListener) {
        super(z10, iUnityAdsTokenListener);
    }

    @Override // com.unity3d.services.ads.gmascar.managers.BiddingBaseManager
    public void start() {
        permitSignalsUpload();
        fetchSignals();
    }
}
