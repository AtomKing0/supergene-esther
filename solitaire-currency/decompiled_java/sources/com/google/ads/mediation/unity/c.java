package com.google.ads.mediation.unity;

import android.content.Context;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MediationMetaData;

/* JADX INFO: compiled from: UnityAdsWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class c {
    c() {
    }

    public MediationMetaData a(Context context) {
        return new MediationMetaData(context);
    }

    public String b() {
        return UnityAds.getVersion();
    }

    public void c(Context context, String str, IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        UnityAds.initialize(context, str, false, iUnityAdsInitializationListener);
    }

    public boolean d() {
        return UnityAds.isInitialized();
    }
}
