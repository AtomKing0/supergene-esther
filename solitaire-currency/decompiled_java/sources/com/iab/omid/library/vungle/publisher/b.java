package com.iab.omid.library.vungle.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.media3.exoplayer.ExoPlayer;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.iab.omid.library.vungle.internal.g;
import com.iab.omid.library.vungle.internal.h;
import com.iab.omid.library.vungle.utils.c;
import com.iab.omid.library.vungle.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WebView f11108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f11109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f11110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f11111j;

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

    /* JADX INFO: renamed from: com.iab.omid.library.vungle.publisher.b$b, reason: collision with other inner class name */
    class RunnableC0246b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebView f11113a;

        RunnableC0246b() {
            this.f11113a = b.this.f11108g;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11113a.destroy();
        }
    }

    public b(String str, Map<String, VerificationScriptResource> map, String str2) {
        super(str);
        this.f11109h = null;
        this.f11110i = map;
        this.f11111j = str2;
    }

    @Override // com.iab.omid.library.vungle.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new RunnableC0246b(), Math.max(4000 - (this.f11109h == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.f11109h.longValue(), TimeUnit.NANOSECONDS)), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        this.f11108g = null;
    }

    @Override // com.iab.omid.library.vungle.publisher.AdSessionStatePublisher
    public void i() {
        super.i();
        j();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    void j() {
        WebView webView = new WebView(g.b().a());
        this.f11108g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f11108g.getSettings().setAllowContentAccess(false);
        this.f11108g.getSettings().setAllowFileAccess(false);
        this.f11108g.setWebViewClient(new a());
        a(this.f11108g);
        h.a().c(this.f11108g, this.f11111j);
        for (String str : this.f11110i.keySet()) {
            h.a().d(this.f11108g, this.f11110i.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.f11109h = Long.valueOf(f.b());
    }

    @Override // com.iab.omid.library.vungle.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.vungle.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            c.a(jSONObject, str, injectedResourcesMap.get(str).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }
}
