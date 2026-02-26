package com.iab.omid.library.applovin.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.media3.exoplayer.ExoPlayer;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.internal.g;
import com.iab.omid.library.applovin.internal.h;
import com.iab.omid.library.applovin.utils.c;
import com.iab.omid.library.applovin.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WebView f10720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f10721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f10722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f10723j;

    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (b.this.getWebView() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                b.this.a((WebView) null);
            }
            webView.destroy();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.iab.omid.library.applovin.publisher.b$b, reason: collision with other inner class name */
    class RunnableC0235b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebView f10725a;

        RunnableC0235b() {
            this.f10725a = b.this.f10720g;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10725a.destroy();
        }
    }

    public b(String str, Map<String, VerificationScriptResource> map, String str2) {
        super(str);
        this.f10721h = null;
        this.f10722i = map;
        this.f10723j = str2;
    }

    @Override // com.iab.omid.library.applovin.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new RunnableC0235b(), Math.max(4000 - (this.f10721h == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.f10721h.longValue(), TimeUnit.NANOSECONDS)), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        this.f10720g = null;
    }

    @Override // com.iab.omid.library.applovin.publisher.AdSessionStatePublisher
    public void i() {
        super.i();
        j();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    void j() {
        WebView webView = new WebView(g.b().a());
        this.f10720g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f10720g.getSettings().setAllowContentAccess(false);
        this.f10720g.getSettings().setAllowFileAccess(false);
        this.f10720g.setWebViewClient(new a());
        a(this.f10720g);
        h.a().c(this.f10720g, this.f10723j);
        for (String str : this.f10722i.keySet()) {
            h.a().d(this.f10720g, this.f10722i.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.f10721h = Long.valueOf(f.b());
    }

    @Override // com.iab.omid.library.applovin.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.applovin.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            c.a(jSONObject, str, injectedResourcesMap.get(str).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }
}
