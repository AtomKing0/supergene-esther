package com.applovin.impl;

import android.webkit.WebView;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

/* JADX INFO: loaded from: classes2.dex */
public class t3 extends s3 {
    public t3(com.applovin.impl.sdk.ad.a aVar) {
        super(aVar);
    }

    @Override // com.applovin.impl.s3
    protected AdSessionContext a(WebView webView) {
        try {
            return this.f6798a.getOpenMeasurementVerificationScriptResources().size() > 0 ? AdSessionContext.createNativeAdSessionContext(this.f6799b.W().b(), this.f6799b.W().a(), this.f6798a.getOpenMeasurementVerificationScriptResources(), this.f6798a.getOpenMeasurementContentUrl(), this.f6798a.getOpenMeasurementCustomReferenceData()) : AdSessionContext.createHtmlAdSessionContext(this.f6799b.W().b(), webView, this.f6798a.getOpenMeasurementContentUrl(), this.f6798a.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6800c.a(this.f6801d, "Failed to create ad session context", th);
            }
            return null;
        }
    }

    @Override // com.applovin.impl.s3
    protected AdSessionConfiguration a() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.LOADED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6800c.a(this.f6801d, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }
}
