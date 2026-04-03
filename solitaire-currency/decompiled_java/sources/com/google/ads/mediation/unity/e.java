package com.google.ads.mediation.unity;

import androidx.annotation.NonNull;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.banners.BannerView;

/* JADX INFO: compiled from: UnityBannerViewWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BannerView f8365a;

    e(@NonNull BannerView bannerView) {
        this.f8365a = bannerView;
    }

    public BannerView a() {
        return this.f8365a;
    }

    public void b(UnityAdsLoadOptions unityAdsLoadOptions) {
        this.f8365a.load(unityAdsLoadOptions);
    }

    public void c(BannerView.IListener iListener) {
        this.f8365a.setListener(iListener);
    }
}
