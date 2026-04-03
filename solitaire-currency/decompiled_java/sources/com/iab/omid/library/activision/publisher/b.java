package com.iab.omid.library.activision.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.media3.exoplayer.ExoPlayer;
import com.iab.omid.library.activision.adsession.AdSessionContext;
import com.iab.omid.library.activision.adsession.VerificationScriptResource;
import com.iab.omid.library.activision.internal.g;
import com.iab.omid.library.activision.internal.h;
import com.iab.omid.library.activision.utils.c;
import com.iab.omid.library.activision.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WebView f10585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f10586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f10587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f10588j;

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

    /* JADX INFO: renamed from: com.iab.omid.library.activision.publisher.b$b, reason: collision with other inner class name */
    class RunnableC0231b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebView f10590a;

        RunnableC0231b() {
            this.f10590a = b.this.f10585g;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10590a.destroy();
        }
    }

    public b(String str, Map<String, VerificationScriptResource> map, String str2) {
        super(str);
        this.f10586h = null;
        this.f10587i = map;
        this.f10588j = str2;
    }

    @Override // com.iab.omid.library.activision.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new RunnableC0231b(), Math.max(4000 - (this.f10586h == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.f10586h.longValue(), TimeUnit.NANOSECONDS)), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        this.f10585g = null;
    }

    @Override // com.iab.omid.library.activision.publisher.AdSessionStatePublisher
    public void i() {
        super.i();
        j();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    void j() {
        WebView webView = new WebView(g.b().a());
        this.f10585g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f10585g.getSettings().setAllowContentAccess(false);
        this.f10585g.getSettings().setAllowFileAccess(false);
        this.f10585g.setWebViewClient(new a());
        a(this.f10585g);
        h.a().c(this.f10585g, this.f10588j);
        for (String str : this.f10587i.keySet()) {
            h.a().d(this.f10585g, this.f10587i.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.f10586h = Long.valueOf(f.b());
    }

    @Override // com.iab.omid.library.activision.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.activision.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            c.a(jSONObject, str, injectedResourcesMap.get(str).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }
}
