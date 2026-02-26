package com.google.ads.mediation.unity;

import android.app.Activity;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;

/* JADX INFO: compiled from: UnityAdsLoader.java */
/* JADX INFO: loaded from: classes2.dex */
class b {
    b() {
    }

    public UnityAdsLoadOptions a() {
        return new UnityAdsLoadOptions();
    }

    public UnityAdsLoadOptions b(String str) {
        UnityAdsLoadOptions unityAdsLoadOptionsA = a();
        unityAdsLoadOptionsA.setObjectId(str);
        return unityAdsLoadOptionsA;
    }

    public UnityAdsShowOptions c(String str) {
        UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
        unityAdsShowOptions.setObjectId(str);
        return unityAdsShowOptions;
    }

    public void d(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener) {
        UnityAds.load(str, unityAdsLoadOptions, iUnityAdsLoadListener);
    }

    public void e(Activity activity, String str, UnityAdsShowOptions unityAdsShowOptions, IUnityAdsShowListener iUnityAdsShowListener) {
        UnityAds.show(activity, str, unityAdsShowOptions, iUnityAdsShowListener);
    }
}
