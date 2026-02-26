package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.impl.mediation.d;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class p2 extends MaxNativeAdListener implements MaxAdRevenueListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaxNativeAdLoader f6538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue f6539c = new LinkedList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6540d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f6541e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f6542f;

    public interface a {
        void onAdRevenuePaid(MaxAd maxAd);

        void onNativeAdClicked(MaxAd maxAd);

        void onNativeAdLoadFailed(String str, MaxError maxError);

        void onNativeAdLoaded();
    }

    public p2(MaxAdPlacerSettings maxAdPlacerSettings, Context context, a aVar) {
        this.f6537a = maxAdPlacerSettings.getMaxPreloadedAdCount();
        this.f6542f = aVar;
        MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(maxAdPlacerSettings.getAdUnitId(), context);
        this.f6538b = maxNativeAdLoader;
        maxNativeAdLoader.setNativeAdListener(this);
        maxNativeAdLoader.setRevenueListener(this);
        maxNativeAdLoader.setPlacement(maxAdPlacerSettings.getPlacement());
        maxNativeAdLoader.setLocalExtraParameter(MaxNativeAdLoaderImpl.KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE, d.b.NATIVE_AD_PLACER);
    }

    public void a(MaxAd maxAd) {
        this.f6538b.destroy(maxAd);
    }

    public MaxAd b() {
        MaxAd maxAd;
        synchronized (this.f6541e) {
            maxAd = null;
            while (!this.f6539c.isEmpty() && (maxAd == null || maxAd.getNativeAd().isExpired())) {
                maxAd = (MaxAd) this.f6539c.remove();
            }
            e();
        }
        return maxAd;
    }

    public void c() {
        this.f6542f = null;
        a();
        this.f6538b.destroy();
    }

    public boolean d() {
        boolean z10;
        synchronized (this.f6541e) {
            z10 = !this.f6539c.isEmpty();
        }
        return z10;
    }

    public void e() {
        synchronized (this.f6541e) {
            if (!this.f6540d && this.f6539c.size() < this.f6537a) {
                this.f6540d = true;
                this.f6538b.loadAd();
            }
        }
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(MaxAd maxAd) {
        a aVar = this.f6542f;
        if (aVar != null) {
            aVar.onAdRevenuePaid(maxAd);
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdClicked(MaxAd maxAd) {
        a aVar = this.f6542f;
        if (aVar != null) {
            aVar.onNativeAdClicked(maxAd);
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        a aVar = this.f6542f;
        if (aVar != null) {
            aVar.onNativeAdLoadFailed(str, maxError);
        }
    }

    @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
    public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        synchronized (this.f6541e) {
            this.f6539c.add(maxAd);
            this.f6540d = false;
            e();
        }
        a aVar = this.f6542f;
        if (aVar != null) {
            aVar.onNativeAdLoaded();
        }
    }

    public void a() {
        synchronized (this.f6541e) {
            Iterator it = this.f6539c.iterator();
            while (it.hasNext()) {
                a((MaxAd) it.next());
            }
            this.f6539c.clear();
        }
    }

    public boolean a(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        return this.f6538b.render(maxNativeAdView, maxAd);
    }
}
