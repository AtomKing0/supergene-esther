package com.iab.omid.library.activision.publisher;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.activision.adsession.AdEvents;
import com.iab.omid.library.activision.adsession.AdSessionConfiguration;
import com.iab.omid.library.activision.adsession.AdSessionContext;
import com.iab.omid.library.activision.adsession.ErrorType;
import com.iab.omid.library.activision.adsession.VerificationScriptResource;
import com.iab.omid.library.activision.adsession.media.MediaEvents;
import com.iab.omid.library.activision.internal.g;
import com.iab.omid.library.activision.internal.h;
import com.iab.omid.library.activision.utils.c;
import com.iab.omid.library.activision.utils.f;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import io.sentry.protocol.App;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.iab.omid.library.activision.weakreference.b f10576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AdEvents f10577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediaEvents f10578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f10579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f10580f;

    enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher(String str) {
        a();
        this.f10575a = str;
        this.f10576b = new com.iab.omid.library.activision.weakreference.b(null);
    }

    public void a() {
        this.f10580f = f.b();
        this.f10579e = a.AD_STATE_IDLE;
    }

    public void b() {
        this.f10576b.clear();
    }

    public AdEvents c() {
        return this.f10577c;
    }

    public MediaEvents d() {
        return this.f10578d;
    }

    public boolean e() {
        return this.f10576b.get() != null;
    }

    public void f() {
        h.a().a(getWebView(), this.f10575a);
    }

    public void g() {
        h.a().b(getWebView(), this.f10575a);
    }

    public WebView getWebView() {
        return this.f10576b.get();
    }

    public void h() {
        a((JSONObject) null);
    }

    public void a(float f10) {
        h.a().a(getWebView(), this.f10575a, f10);
    }

    public void b(String str, long j10) {
        if (j10 >= this.f10580f) {
            this.f10579e = a.AD_STATE_VISIBLE;
            h.a().b(getWebView(), this.f10575a, str);
        }
    }

    void a(WebView webView) {
        this.f10576b = new com.iab.omid.library.activision.weakreference.b(webView);
    }

    public void b(boolean z10) {
        if (e()) {
            h.a().a(getWebView(), this.f10575a, z10 ? "locked" : "unlocked");
        }
    }

    public void a(AdEvents adEvents) {
        this.f10577c = adEvents;
    }

    public void a(AdSessionConfiguration adSessionConfiguration) {
        h.a().a(getWebView(), this.f10575a, adSessionConfiguration.toJsonObject());
    }

    public void a(ErrorType errorType, String str) {
        h.a().a(getWebView(), this.f10575a, errorType, str);
    }

    public void a(com.iab.omid.library.activision.adsession.a aVar, AdSessionContext adSessionContext) {
        a(aVar, adSessionContext, null);
    }

    protected void a(com.iab.omid.library.activision.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        c.a(jSONObject2, "environment", App.TYPE);
        c.a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        c.a(jSONObject2, "deviceInfo", com.iab.omid.library.activision.utils.b.d());
        c.a(jSONObject2, "deviceCategory", com.iab.omid.library.activision.utils.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        c.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, adSessionContext.getPartner().getName());
        c.a(jSONObject3, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, adSessionContext.getPartner().getVersion());
        c.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.a(jSONObject4, "libraryVersion", "1.5.2-Activision");
        c.a(jSONObject4, "appId", g.b().a().getApplicationContext().getPackageName());
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
        h.a().a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(MediaEvents mediaEvents) {
        this.f10578d = mediaEvents;
    }

    public void a(String str) {
        a(str, (JSONObject) null);
    }

    public void a(String str, long j10) {
        if (j10 >= this.f10580f) {
            a aVar = this.f10579e;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.f10579e = aVar2;
                h.a().b(getWebView(), this.f10575a, str);
            }
        }
    }

    public void a(String str, @Nullable JSONObject jSONObject) {
        h.a().a(getWebView(), this.f10575a, str, jSONObject);
    }

    public void a(@NonNull Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        h.a().a(getWebView(), jSONObject);
    }

    public void a(@Nullable JSONObject jSONObject) {
        h.a().b(getWebView(), this.f10575a, jSONObject);
    }

    public void a(boolean z10) {
        if (e()) {
            h.a().c(getWebView(), this.f10575a, z10 ? "foregrounded" : "backgrounded");
        }
    }

    public void i() {
    }
}
