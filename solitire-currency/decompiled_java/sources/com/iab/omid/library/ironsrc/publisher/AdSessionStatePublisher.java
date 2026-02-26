package com.iab.omid.library.ironsrc.publisher;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.iab.omid.library.ironsrc.adsession.AdEvents;
import com.iab.omid.library.ironsrc.adsession.AdSessionConfiguration;
import com.iab.omid.library.ironsrc.adsession.AdSessionContext;
import com.iab.omid.library.ironsrc.adsession.ErrorType;
import com.iab.omid.library.ironsrc.adsession.VerificationScriptResource;
import com.iab.omid.library.ironsrc.adsession.media.MediaEvents;
import com.iab.omid.library.ironsrc.internal.g;
import com.iab.omid.library.ironsrc.utils.c;
import com.iab.omid.library.ironsrc.utils.f;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import io.sentry.protocol.App;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.iab.omid.library.ironsrc.weakreference.b f10838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AdEvents f10839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediaEvents f10840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f10841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10842e;

    enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        a();
        this.f10838a = new com.iab.omid.library.ironsrc.weakreference.b(null);
    }

    public void a() {
        this.f10842e = f.b();
        this.f10841d = a.AD_STATE_IDLE;
    }

    public void b() {
        this.f10838a.clear();
    }

    public AdEvents c() {
        return this.f10839b;
    }

    public MediaEvents d() {
        return this.f10840c;
    }

    public boolean e() {
        return this.f10838a.get() != null;
    }

    public void f() {
        g.a().a(getWebView());
    }

    public void g() {
        g.a().b(getWebView());
    }

    public WebView getWebView() {
        return this.f10838a.get();
    }

    public void h() {
        g.a().c(getWebView());
    }

    public void a(float f10) {
        g.a().a(getWebView(), f10);
    }

    public void b(String str, long j10) {
        if (j10 >= this.f10842e) {
            this.f10841d = a.AD_STATE_VISIBLE;
            g.a().a(getWebView(), str);
        }
    }

    void a(WebView webView) {
        this.f10838a = new com.iab.omid.library.ironsrc.weakreference.b(webView);
    }

    public void a(AdEvents adEvents) {
        this.f10839b = adEvents;
    }

    public void a(AdSessionConfiguration adSessionConfiguration) {
        g.a().a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    public void a(ErrorType errorType, String str) {
        g.a().a(getWebView(), errorType, str);
    }

    public void a(com.iab.omid.library.ironsrc.adsession.a aVar, AdSessionContext adSessionContext) {
        a(aVar, adSessionContext, null);
    }

    protected void a(com.iab.omid.library.ironsrc.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        c.a(jSONObject2, "environment", App.TYPE);
        c.a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        c.a(jSONObject2, "deviceInfo", com.iab.omid.library.ironsrc.utils.b.d());
        c.a(jSONObject2, "deviceCategory", com.iab.omid.library.ironsrc.utils.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        c.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, adSessionContext.getPartner().getName());
        c.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, adSessionContext.getPartner().getVersion());
        c.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.a(jSONObject4, "libraryVersion", "1.4.2-Ironsrc");
        c.a(jSONObject4, "appId", com.iab.omid.library.ironsrc.internal.f.b().a().getApplicationContext().getPackageName());
        c.a(jSONObject2, App.TYPE, jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            c.a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            c.a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource verificationScriptResource : adSessionContext.getVerificationScriptResources()) {
            c.a(jSONObject5, verificationScriptResource.getVendorKey(), verificationScriptResource.getVerificationParameters());
        }
        g.a().a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(MediaEvents mediaEvents) {
        this.f10840c = mediaEvents;
    }

    public void a(String str) {
        g.a().a(getWebView(), str, (JSONObject) null);
    }

    public void a(String str, long j10) {
        if (j10 >= this.f10842e) {
            a aVar = this.f10841d;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.f10841d = aVar2;
                g.a().a(getWebView(), str);
            }
        }
    }

    public void a(String str, JSONObject jSONObject) {
        g.a().a(getWebView(), str, jSONObject);
    }

    public void a(@NonNull Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        g.a().c(getWebView(), jSONObject);
    }

    public void a(@NonNull JSONObject jSONObject) {
        g.a().b(getWebView(), jSONObject);
    }

    public void a(boolean z10) {
        if (e()) {
            g.a().b(getWebView(), z10 ? "foregrounded" : "backgrounded");
        }
    }

    public void i() {
    }
}
