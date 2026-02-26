package com.iab.omid.library.unity3d.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.media3.exoplayer.ExoPlayer;
import com.iab.omid.library.unity3d.adsession.AdSessionContext;
import com.iab.omid.library.unity3d.adsession.VerificationScriptResource;
import com.iab.omid.library.unity3d.internal.g;
import com.iab.omid.library.unity3d.utils.c;
import com.iab.omid.library.unity3d.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WebView f10974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f10975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f10976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f10977j;

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

    /* JADX INFO: renamed from: com.iab.omid.library.unity3d.publisher.b$b, reason: collision with other inner class name */
    class RunnableC0242b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebView f10979a;

        RunnableC0242b() {
            this.f10979a = b.this.f10974g;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10979a.destroy();
        }
    }

    public b(String str, Map<String, VerificationScriptResource> map, String str2) {
        super(str);
        this.f10975h = null;
        this.f10976i = map;
        this.f10977j = str2;
    }

    @Override // com.iab.omid.library.unity3d.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new RunnableC0242b(), Math.max(4000 - (this.f10975h == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.f10975h.longValue(), TimeUnit.NANOSECONDS)), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        this.f10974g = null;
    }

    @Override // com.iab.omid.library.unity3d.publisher.AdSessionStatePublisher
    public void i() {
        super.i();
        j();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    void j() {
        WebView webView = new WebView(com.iab.omid.library.unity3d.internal.f.b().a());
        this.f10974g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f10974g.getSettings().setAllowContentAccess(false);
        this.f10974g.getSettings().setAllowFileAccess(false);
        this.f10974g.setWebViewClient(new a());
        a(this.f10974g);
        g.a().c(this.f10974g, this.f10977j);
        for (String str : this.f10976i.keySet()) {
            g.a().c(this.f10974g, this.f10976i.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.f10975h = Long.valueOf(f.b());
    }

    @Override // com.iab.omid.library.unity3d.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.unity3d.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            c.a(jSONObject, str, injectedResourcesMap.get(str).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }
}
