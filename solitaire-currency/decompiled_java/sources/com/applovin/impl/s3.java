package com.applovin.impl;

import android.view.View;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.ErrorType;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AppLovinAdBase f6798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f6799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f6800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f6801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f6802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected AdSession f6803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected AdEvents f6804g;

    public s3(AppLovinAdBase appLovinAdBase) {
        this.f6798a = appLovinAdBase;
        this.f6799b = appLovinAdBase.getSdk();
        this.f6800c = appLovinAdBase.getSdk().I();
        String str = "AdEventTracker:" + appLovinAdBase.getAdIdNumber();
        if (StringUtils.isValidString(appLovinAdBase.getDspName())) {
            str = str + ":" + appLovinAdBase.getDspName();
        }
        this.f6801d = str;
    }

    protected abstract AdSessionConfiguration a();

    protected abstract AdSessionContext a(WebView webView);

    public void h() {
        b("track loaded", new Runnable() { // from class: com.applovin.impl.gd
            @Override // java.lang.Runnable
            public final void run() {
                this.f5286a.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WebView webView) {
        AdSessionContext adSessionContextA;
        if (!this.f6798a.isOpenMeasurementEnabled()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6800c.d(this.f6801d, "Skip starting session - Open Measurement disabled");
                return;
            }
            return;
        }
        if (this.f6803f != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6800c.k(this.f6801d, "Attempting to start session again for ad: " + this.f6798a);
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f6800c.a(this.f6801d, "Starting session");
        }
        AdSessionConfiguration adSessionConfigurationA = a();
        if (adSessionConfigurationA == null || (adSessionContextA = a(webView)) == null) {
            return;
        }
        try {
            AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationA, adSessionContextA);
            this.f6803f = adSessionCreateAdSession;
            try {
                this.f6804g = AdEvents.createAdEvents(adSessionCreateAdSession);
                a(this.f6803f);
                this.f6803f.start();
                this.f6802e = true;
                if (com.applovin.impl.sdk.n.a()) {
                    this.f6800c.a(this.f6801d, "Session started");
                }
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f6800c.a(this.f6801d, "Failed to create ad events", th);
                }
            }
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6800c.a(this.f6801d, "Failed to create session", th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f6804g.loaded();
    }

    protected void a(AdSession adSession) {
    }

    public void c(final WebView webView) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.jd
            @Override // java.lang.Runnable
            public final void run() {
                this.f5504a.b(webView);
            }
        });
    }

    public void e() {
        c(null);
    }

    public void f() {
        b("stop session", new Runnable() { // from class: com.applovin.impl.id
            @Override // java.lang.Runnable
            public final void run() {
                this.f5408a.b();
            }
        });
    }

    public void g() {
        b("track impression event", new Runnable() { // from class: com.applovin.impl.fd
            @Override // java.lang.Runnable
            public final void run() {
                this.f5218a.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f6804g.impressionOccurred();
    }

    public void a(View view) {
        b(view, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, List list) {
        this.f6803f.registerAdView(view);
        this.f6803f.removeAllFriendlyObstructions();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            u3 u3Var = (u3) it.next();
            if (u3Var.c() != null) {
                try {
                    this.f6803f.addFriendlyObstruction(u3Var.c(), u3Var.b(), u3Var.a());
                } catch (Throwable th) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f6800c.a(this.f6801d, "Failed to add friendly obstruction (" + u3Var + ")", th);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        this.f6803f.error(ErrorType.VIDEO, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Runnable runnable) {
        try {
            if (this.f6802e) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f6800c.a(this.f6801d, "Running operation: " + str);
                }
                runnable.run();
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6800c.a(this.f6801d, "Failed to run operation: " + str, th);
            }
        }
    }

    public void b(final View view, final List list) {
        b("update main view: " + view, new Runnable() { // from class: com.applovin.impl.hd
            @Override // java.lang.Runnable
            public final void run() {
                this.f5352a.a(view, list);
            }
        });
    }

    public void b(final String str) {
        b("track error", new Runnable() { // from class: com.applovin.impl.ed
            @Override // java.lang.Runnable
            public final void run() {
                this.f5158a.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f6802e = false;
        this.f6803f.finish();
        this.f6803f = null;
        this.f6804g = null;
    }

    protected void b(final String str, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.dd
            @Override // java.lang.Runnable
            public final void run() {
                this.f5049a.a(str, runnable);
            }
        });
    }
}
