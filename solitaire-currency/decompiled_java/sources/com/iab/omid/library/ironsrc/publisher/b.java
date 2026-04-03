package com.iab.omid.library.ironsrc.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import androidx.media3.exoplayer.ExoPlayer;
import com.iab.omid.library.ironsrc.adsession.AdSessionContext;
import com.iab.omid.library.ironsrc.adsession.VerificationScriptResource;
import com.iab.omid.library.ironsrc.internal.g;
import com.iab.omid.library.ironsrc.utils.c;
import com.iab.omid.library.ironsrc.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebView f10847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Long f10848g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f10849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f10850i;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebView f10851a;

        a() {
            this.f10851a = b.this.f10847f;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10851a.destroy();
        }
    }

    public b(Map<String, VerificationScriptResource> map, String str) {
        this.f10849h = map;
        this.f10850i = str;
    }

    @Override // com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new a(), Math.max(4000 - (this.f10848g == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.f10848g.longValue(), TimeUnit.NANOSECONDS)), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        this.f10847f = null;
    }

    @Override // com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher
    public void i() {
        super.i();
        j();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    void j() {
        WebView webView = new WebView(com.iab.omid.library.ironsrc.internal.f.b().a());
        this.f10847f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f10847f.getSettings().setAllowContentAccess(false);
        a(this.f10847f);
        g.a().c(this.f10847f, this.f10850i);
        for (String str : this.f10849h.keySet()) {
            g.a().a(this.f10847f, this.f10849h.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.f10848g = Long.valueOf(f.b());
    }

    @Override // com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.ironsrc.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            c.a(jSONObject, str, injectedResourcesMap.get(str).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }
}
