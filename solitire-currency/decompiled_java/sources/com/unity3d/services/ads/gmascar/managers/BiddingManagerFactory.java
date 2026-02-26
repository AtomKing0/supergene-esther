package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.core.configuration.IExperiments;

/* JADX INFO: loaded from: classes4.dex */
public class BiddingManagerFactory {
    private static BiddingManagerFactory instance;

    /* JADX INFO: renamed from: com.unity3d.services.ads.gmascar.managers.BiddingManagerFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType;

        static {
            int[] iArr = new int[ScarBiddingManagerType.values().length];
            $SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType = iArr;
            try {
                iArr[ScarBiddingManagerType.EAGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType[ScarBiddingManagerType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private BiddingManagerFactory() {
    }

    private BiddingBaseManager getExperiment(IUnityAdsTokenListener iUnityAdsTokenListener, IExperiments iExperiments) {
        if (iExperiments == null || iExperiments.getScarBiddingManager() == null) {
            return new BiddingDisabledManager(iUnityAdsTokenListener);
        }
        return AnonymousClass1.$SwitchMap$com$unity3d$services$ads$gmascar$managers$ScarBiddingManagerType[ScarBiddingManagerType.fromName(iExperiments.getScarBiddingManager()).ordinal()] != 1 ? new BiddingDisabledManager(iUnityAdsTokenListener) : new BiddingEagerManager(iExperiments.isScarBannerHbEnabled(), iUnityAdsTokenListener);
    }

    public static BiddingManagerFactory getInstance() {
        if (instance == null) {
            instance = new BiddingManagerFactory();
        }
        return instance;
    }

    public BiddingBaseManager createManager(IUnityAdsTokenListener iUnityAdsTokenListener, IExperiments iExperiments) {
        return GMA.getInstance().hasSCARBiddingSupport() ? getExperiment(iUnityAdsTokenListener, iExperiments) : new BiddingDisabledManager(iUnityAdsTokenListener);
    }
}
