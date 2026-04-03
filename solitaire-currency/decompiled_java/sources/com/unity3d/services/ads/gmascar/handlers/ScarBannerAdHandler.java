package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.g;
import com.unity3d.services.banners.BannerViewCache;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;

/* JADX INFO: loaded from: classes4.dex */
public class ScarBannerAdHandler implements g {
    private String _operationId;

    public ScarBannerAdHandler(String str) {
        this._operationId = str;
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdClicked() {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_CLICKED, this._operationId);
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdClosed() {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_CLOSED, this._operationId);
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdFailedToLoad(int i10, String str) {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_LOAD_FAILED, this._operationId, Integer.valueOf(i10), str);
    }

    @Override // com.unity3d.scar.adapter.common.g
    public void onAdImpression() {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_IMPRESSION, this._operationId);
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdLoaded() {
        BannerViewCache.getInstance().addScarContainer(this._operationId);
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_LOADED, this._operationId);
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdOpened() {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_OPENED, this._operationId);
    }
}
