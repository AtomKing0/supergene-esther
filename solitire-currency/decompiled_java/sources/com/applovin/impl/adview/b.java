package com.applovin.impl.adview;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.applovin.impl.a7;
import com.applovin.impl.a8;
import com.applovin.impl.d7;
import com.applovin.impl.h4;
import com.applovin.impl.i7;
import com.applovin.impl.k0;
import com.applovin.impl.l4;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.z6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.applovin.impl.f0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Set f4806j = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f4807k = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f4808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f4809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.applovin.impl.sdk.ad.b f4810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f4813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f4814i;

    public b(c cVar, com.applovin.impl.sdk.j jVar, Context context) {
        super(context);
        this.f4813h = new ArrayList();
        this.f4814i = new Object();
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f4809d = jVar;
        this.f4808c = jVar.I();
        Integer num = (Integer) jVar.a(l4.U5);
        if (num.intValue() > 0) {
            synchronized (f4807k) {
                Set set = f4806j;
                set.add(this);
                z6.a("AdWebView", set.size(), num.intValue(), jVar.A());
            }
        }
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(cVar != null ? cVar : new h4());
        setWebChromeClient(new com.applovin.impl.r(cVar != null ? cVar.c() : null, jVar));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        if (k0.i() && ((Boolean) jVar.a(l4.f5724q5)).booleanValue()) {
            setWebViewRenderProcessClient(new d(jVar).a());
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.adview.b0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return b.a(view, motionEvent);
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.applovin.impl.adview.c0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f4818a.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f4811f = true;
        this.f4812g = false;
        super.destroy();
    }

    public com.applovin.impl.sdk.ad.b getCurrentAd() {
        return this.f4810e;
    }

    public void setAdHtmlLoaded(boolean z10) {
        this.f4812g = z10;
        if (z10 && ((Boolean) this.f4809d.a(l4.M5)).booleanValue()) {
            b();
        }
    }

    private void b() {
        synchronized (this.f4814i) {
            Iterator it = this.f4813h.iterator();
            while (it.hasNext()) {
                a8.a(this, (String) it.next(), "AdWebView", this.f4809d);
            }
            this.f4813h.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f4808c.a("AdWebView", "Received a LongClick event.");
        return true;
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        if (!this.f4811f) {
            this.f4810e = bVar;
            try {
                applySettings(bVar);
                if (z6.a(bVar.getSize())) {
                    setVisibility(0);
                }
                if (bVar instanceof com.applovin.impl.sdk.ad.a) {
                    loadDataWithBaseURL(bVar.h(), ((com.applovin.impl.sdk.ad.a) bVar).f1(), "text/html", null, "");
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f4808c.a("AdWebView", "AppLovinAd rendered");
                        return;
                    }
                    return;
                }
                if (bVar instanceof a7) {
                    a7 a7Var = (a7) bVar;
                    d7 d7VarF1 = a7Var.f1();
                    if (d7VarF1 != null) {
                        i7 i7VarE = d7VarF1.e();
                        Uri uriC = i7VarE.c();
                        String string = uriC != null ? uriC.toString() : "";
                        String strB = i7VarE.b();
                        String strH1 = a7Var.h1();
                        if (!StringUtils.isValidString(string) && !StringUtils.isValidString(strB)) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f4808c.b("AdWebView", "Unable to load companion ad. No resources provided.");
                                return;
                            }
                            return;
                        }
                        if (i7VarE.d() == i7.a.STATIC) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f4808c.a("AdWebView", "Rendering WebView for static VAST ad");
                            }
                            String strA = a((String) this.f4809d.a(l4.f5659i4), string);
                            if (a7Var.w1() && a7Var.isOpenMeasurementEnabled() && a7Var.x1()) {
                                strA = this.f4809d.W().a(strA);
                            }
                            loadDataWithBaseURL(bVar.h(), strA, "text/html", null, "");
                            return;
                        }
                        if (i7VarE.d() == i7.a.HTML) {
                            if (StringUtils.isValidString(strB)) {
                                String strA2 = a(strH1, strB);
                                String str = StringUtils.isValidString(strA2) ? strA2 : strB;
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f4808c.a("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str);
                                }
                                loadDataWithBaseURL(bVar.h(), str, "text/html", null, "");
                                return;
                            }
                            if (StringUtils.isValidString(string)) {
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f4808c.a("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                }
                                a(string, bVar.h(), strH1, this.f4809d, a7Var);
                                return;
                            }
                            return;
                        }
                        if (i7VarE.d() == i7.a.IFRAME) {
                            if (StringUtils.isValidString(string)) {
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f4808c.a("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                                }
                                a(string, bVar.h(), strH1, this.f4809d, a7Var);
                                return;
                            } else {
                                if (StringUtils.isValidString(strB)) {
                                    String strA3 = a(strH1, strB);
                                    String str2 = StringUtils.isValidString(strA3) ? strA3 : strB;
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.f4808c.a("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str2);
                                    }
                                    loadDataWithBaseURL(bVar.h(), str2, "text/html", null, "");
                                    return;
                                }
                                return;
                            }
                        }
                        if (com.applovin.impl.sdk.n.a()) {
                            this.f4808c.b("AdWebView", "Failed to render VAST companion ad of invalid type");
                            return;
                        }
                        return;
                    }
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f4808c.a("AdWebView", "No companion ad provided.");
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                throw new RuntimeException("Unable to render AppLovin ad (" + (bVar != null ? String.valueOf(bVar.getAdIdNumber()) : "null") + ") - " + th);
            }
        }
        com.applovin.impl.sdk.n.h("AdWebView", "Ad can not be loaded in a destroyed webview");
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
    }

    public void a(String str) {
        if (((Boolean) this.f4809d.a(l4.M5)).booleanValue()) {
            if (this.f4812g) {
                a8.a(this, str, "AdWebView", this.f4809d);
                return;
            }
            synchronized (this.f4813h) {
                this.f4813h.add(str);
            }
            return;
        }
        a8.a(this, str, "AdWebView", this.f4809d);
    }

    private void a(String str, String str2, String str3, com.applovin.impl.sdk.j jVar, a7 a7Var) {
        String strA = a(str3, str);
        if (StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f4808c.a("AdWebView", "Rendering webview for VAST ad with resourceContents : " + strA);
            }
            loadDataWithBaseURL(str2, strA, "text/html", null, "");
            return;
        }
        String strA2 = a((String) jVar.a(l4.f5667j4), str);
        if (StringUtils.isValidString(strA2)) {
            if (a7Var.w1() && a7Var.isOpenMeasurementEnabled()) {
                strA2 = jVar.W().a(strA2);
            }
            String str4 = strA2;
            if (com.applovin.impl.sdk.n.a()) {
                this.f4808c.a("AdWebView", "Rendering webview for VAST ad with resourceContents : " + str4);
            }
            loadDataWithBaseURL(str2, str4, "text/html", null, "");
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f4808c.a("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        }
        loadUrl(str);
    }

    private String a(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return str.replace("{SOURCE}", str2);
        }
        return null;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i10, int i11, int i12, int i13) {
    }
}
