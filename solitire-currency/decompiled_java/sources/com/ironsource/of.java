package com.ironsource;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.hg;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.controller.k;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v8;
import com.unity3d.services.UnityAdsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class of implements hg {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f14230g = "loadWithUrl | webView is not null";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f14231h = "of";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f14232i = "file://";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f14235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private mf f14236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private hf f14237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f14238f;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f14240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14241c;

        a(String str, JSONObject jSONObject, String str2) {
            this.f14239a = str;
            this.f14240b = jSONObject;
            this.f14241c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (of.this.f14235c != null) {
                xf.a(vp.f15949q, new sf().a(nb.A, of.f14230g).a());
            }
            try {
                of.this.b(this.f14239a);
                of.this.f14235c.loadUrl(of.this.a(this.f14240b.getString("urlForWebView")));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adViewId", of.this.f14233a);
                of.this.f14236d.a(this.f14241c, jSONObject);
            } catch (Exception e10) {
                i9.d().a(e10);
                of.this.b(this.f14239a, e10.getMessage());
                xf.a(vp.f15949q, new sf().a(nb.A, e10.getMessage()).a());
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14244b;

        b(String str, String str2) {
            this.f14243a = str;
            this.f14244b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (of.this.f14235c != null) {
                    of.this.f14235c.destroy();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adViewId", of.this.f14233a);
                if (of.this.f14236d != null) {
                    of.this.f14236d.a(this.f14243a, jSONObject);
                    of.this.f14236d.b();
                }
                of.this.f14236d = null;
                of.this.f14238f = null;
            } catch (Exception e10) {
                i9.d().a(e10);
                Log.e(of.f14231h, "performCleanup | could not destroy ISNAdView webView ID: " + of.this.f14233a);
                xf.a(vp.f15950r, new sf().a(nb.A, e10.getMessage()).a());
                of.this.b(this.f14244b, e10.getMessage());
            }
        }
    }

    class c implements hg.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14246a;

        c(String str) {
            this.f14246a = str;
        }

        @Override // com.ironsource.hg.a
        public void a(String str) {
            Logger.i(of.f14231h, "ISNAdViewWebPresenter | WebViewClient | reportOnError: " + str);
            of.this.b(this.f14246a, str);
        }

        @Override // com.ironsource.hg.a
        public void b(String str) {
            Logger.i(of.f14231h, "ISNAdViewWebPresenter | WebViewClient | onRenderProcessGone: " + str);
            try {
                ((ViewGroup) of.this.f14235c.getParent()).removeView(of.this.f14235c);
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
            of.this.e();
        }
    }

    private class d extends WebChromeClient {
        private d() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(of.this.new d());
            webView2.setWebViewClient(new e(of.this, null));
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }

        /* synthetic */ d(of ofVar, a aVar) {
            this();
        }
    }

    private class e extends WebViewClient {
        private e() {
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(of.f14231h, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context context = webView.getContext();
            Intent intentA = new OpenUrlActivity.e(new k.b()).a(str).b(false).a(context);
            intentA.addFlags(268435456);
            context.startActivity(intentA);
            return true;
        }

        /* synthetic */ e(of ofVar, a aVar) {
            this();
        }
    }

    public of(kf kfVar, Context context, String str, hf hfVar) {
        this.f14238f = context;
        mf mfVar = new mf();
        this.f14236d = mfVar;
        mfVar.g(str);
        this.f14233a = str;
        this.f14236d.a(kfVar);
        this.f14237e = hfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        a("", "");
    }

    public String b() {
        return this.f14233a;
    }

    public mf c() {
        return this.f14236d;
    }

    public hf d() {
        return this.f14237e;
    }

    @Override // com.ironsource.hg
    public WebView getPresentingView() {
        return this.f14235c;
    }

    @JavascriptInterface
    public void handleMessageFromAd(String str) {
        this.f14236d.c(str);
    }

    private String d(String str) {
        String strSubstring = str.substring(str.indexOf(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH) + 1);
        return strSubstring.substring(strSubstring.indexOf(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH));
    }

    public void e(String str) {
        this.f14234b = str;
    }

    @Override // com.ironsource.hg
    public void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        try {
            this.f14236d.a(jSONObject.getString("params"), str, str2);
        } catch (Exception e10) {
            i9.d().a(e10);
            Logger.i(f14231h, "sendMessageToAd fail message: " + e10.getMessage());
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"AddJavascriptInterface"})
    public void b(String str) {
        Logger.i(f14231h, "ISNAdViewWebPresenter | createWebView");
        WebView webView = new WebView(this.f14238f);
        this.f14235c = webView;
        webView.addJavascriptInterface(new lf(this), Cif.f12596e);
        this.f14235c.setWebViewClient(new nf(new c(str)));
        this.f14235c.setWebChromeClient(new d(this, null));
        yu.a(this.f14235c);
        this.f14236d.a(this.f14235c);
    }

    private boolean c(String str) {
        return str.startsWith(".");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (!c(str)) {
            return str;
        }
        return "file://" + this.f14234b + d(str);
    }

    public void b(String str, String str2) {
        mf mfVar = this.f14236d;
        if (mfVar != null) {
            mfVar.a(str, str2);
        }
    }

    @Override // com.ironsource.hg
    public void b(JSONObject jSONObject, String str, String str2) {
        ve.f15889a.d(new a(str2, jSONObject, str));
    }

    @Override // com.ironsource.hg
    public synchronized void a(String str, String str2) {
        if (this.f14238f == null) {
            return;
        }
        Logger.i(f14231h, "performCleanup");
        ve.f15889a.d(new b(str, str2));
    }

    @Override // com.ironsource.hg
    public void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b(str3, v8.c.D);
            return;
        }
        Logger.i(f14231h, "trying to perform WebView Action: " + str);
        try {
            if (str.equals(v8.h.f15818t0)) {
                this.f14235c.onPause();
            } else {
                if (!str.equals(v8.h.f15820u0)) {
                    b(str3, v8.c.C);
                    return;
                }
                this.f14235c.onResume();
            }
            this.f14236d.f(str2);
        } catch (Exception e10) {
            i9.d().a(e10);
            b(str3, v8.c.E);
        }
    }

    @Override // com.ironsource.hg
    public void a(JSONObject jSONObject, String str, String str2) {
        try {
            this.f14236d.e(str);
        } catch (Exception e10) {
            i9.d().a(e10);
            Logger.i(f14231h, "sendHandleGetViewVisibility fail with reason: " + e10.getMessage());
        }
    }
}
