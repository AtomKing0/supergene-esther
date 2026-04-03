package com.google.ads.mediation.unity;

import android.app.Activity;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

/* JADX INFO: compiled from: UnityBannerViewFactory.java */
/* JADX INFO: loaded from: classes2.dex */
class d {
    d() {
    }

    e a(Activity activity, String str, UnityBannerSize unityBannerSize) {
        return new e(new BannerView(activity, str, unityBannerSize));
    }
}
