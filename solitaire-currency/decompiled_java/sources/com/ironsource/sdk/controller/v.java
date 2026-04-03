package com.ironsource.sdk.controller;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.drive.DriveFile;
import com.ironsource.ad;
import com.ironsource.b9;
import com.ironsource.bv;
import com.ironsource.c9;
import com.ironsource.ce;
import com.ironsource.cu;
import com.ironsource.dj;
import com.ironsource.el;
import com.ironsource.f9;
import com.ironsource.fj;
import com.ironsource.fy;
import com.ironsource.g1;
import com.ironsource.gl;
import com.ironsource.ha;
import com.ironsource.hg;
import com.ironsource.hn;
import com.ironsource.i0;
import com.ironsource.i9;
import com.ironsource.ia;
import com.ironsource.jd;
import com.ironsource.jf;
import com.ironsource.k9;
import com.ironsource.kn;
import com.ironsource.l3;
import com.ironsource.la;
import com.ironsource.ln;
import com.ironsource.m9;
import com.ironsource.md;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mj;
import com.ironsource.mn;
import com.ironsource.n9;
import com.ironsource.nb;
import com.ironsource.nd;
import com.ironsource.o9;
import com.ironsource.p8;
import com.ironsource.p9;
import com.ironsource.pf;
import com.ironsource.qf;
import com.ironsource.qj;
import com.ironsource.r8;
import com.ironsource.ra;
import com.ironsource.rf;
import com.ironsource.s2;
import com.ironsource.s8;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.k;
import com.ironsource.sdk.controller.l;
import com.ironsource.sdk.controller.m;
import com.ironsource.sdk.controller.p;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.sf;
import com.ironsource.t2;
import com.ironsource.un;
import com.ironsource.v3;
import com.ironsource.v8;
import com.ironsource.ve;
import com.ironsource.vf;
import com.ironsource.vn;
import com.ironsource.vp;
import com.ironsource.vt;
import com.ironsource.wp;
import com.ironsource.x8;
import com.ironsource.xf;
import com.ironsource.xu;
import com.ironsource.y8;
import com.ironsource.yq;
import com.ironsource.yu;
import com.ironsource.zf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class v implements com.ironsource.sdk.controller.l, hn, DownloadListener {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final String f15144a0 = "about:blank";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static int f15145b0 = 0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static String f15146c0 = "is_store";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static String f15147d0 = "external_url";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static String f15148e0 = "secondary_web_view";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static String f15149f0 = "success";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static String f15150g0 = "fail";
    private String A;
    private com.ironsource.sdk.controller.d B;
    private cu C;
    private t2 D;
    private ia G;
    private com.ironsource.sdk.controller.o H;
    private com.ironsource.sdk.controller.q I;
    private com.ironsource.sdk.controller.u J;
    private com.ironsource.sdk.controller.i K;
    private com.ironsource.sdk.controller.a L;
    private com.ironsource.sdk.controller.j M;
    private l3 N;
    private xu O;
    private com.ironsource.sdk.controller.c P;
    private p8 Q;
    private JSONObject R;
    private l.a S;
    private l.b T;
    private f9 U;
    private boolean V;
    y8 X;
    final fj Y;
    private kn Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ve f15151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b9 f15152b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f15157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ra f15158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private p f15160j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f15161k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CountDownTimer f15162l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CountDownTimer f15163m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final o f15167q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private View f15168r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private FrameLayout f15169s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private WebChromeClient.CustomViewCallback f15170t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private FrameLayout f15171u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private u f15172v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f15173w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private p9 f15174x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private o9 f15175y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private n9 f15176z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15153c = v.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15154d = "IronSource";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f15155e = "We're sorry, some error occurred. we will investigate it";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f15164n = 50;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f15165o = 50;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f15166p = v8.e.f15738b;
    private Object E = new Object();
    private boolean F = false;
    private final ce W = el.N().f();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(1);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ rf f15178a;

        b(rf rfVar) {
            this.f15178a = rfVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.P.b("controller html - failed to download - " + this.f15178a.b());
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15180a;

        c(Context context) {
            this.f15180a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.e(this.f15180a);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f15182a;

        d(Context context) {
            this.f15182a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.f(this.f15182a);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qf.e f15184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15185b;

        e(qf.e eVar, String str) {
            this.f15184a = eVar;
            this.f15185b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            m9 m9VarA;
            qf.e eVar = this.f15184a;
            if ((eVar == qf.e.RewardedVideo || eVar == qf.e.Interstitial) && (m9VarA = v.this.a(eVar)) != null) {
                m9VarA.a(this.f15184a, this.f15185b);
            }
        }
    }

    class f extends p8 {
        f(JSONObject jSONObject, Context context) {
            super(jSONObject, context);
        }

        @Override // com.ironsource.p8, com.ironsource.zd
        public void a() {
            if (v.this.f15159i) {
                v.this.m("none");
            }
        }

        @Override // com.ironsource.p8, com.ironsource.zd
        public void b(String str, JSONObject jSONObject) {
            if (jSONObject == null || !v.this.f15159i) {
                return;
            }
            try {
                jSONObject.put(v8.i.f15868t, str);
                v.this.e(jSONObject);
            } catch (JSONException e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @Override // com.ironsource.p8, com.ironsource.zd
        public void a(String str, JSONObject jSONObject) {
            if (v.this.f15159i) {
                v.this.m(str);
            }
        }
    }

    class g implements xu {
        g() {
        }

        @Override // com.ironsource.xu
        public void a(String str, JSONObject jSONObject) {
            v.this.i(v.this.e(str, jSONObject.toString()));
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f15189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WebView f15190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15191c;

        h(JSONObject jSONObject, WebView webView, String str) {
            this.f15189a = jSONObject;
            this.f15190b = webView;
            this.f15191c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(this.f15189a, this.f15190b);
            v.this.l("about:blank");
            v.this.l(this.f15191c);
        }
    }

    class i extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f15193a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.P.b(v8.c.f15707j);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long j10, long j11, int i10) {
            super(j10, j11);
            this.f15193a = i10;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(v.this.f15153c, "Loading Controller Timer Finish");
            int i10 = this.f15193a;
            if (i10 == 3) {
                v.this.b(new a());
            } else {
                v.this.a(i10 + 1);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            Logger.i(v.this.f15153c, "Loading Controller Timer Tick " + j10);
        }
    }

    class j implements s {
        j() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, qf.e eVar, ha haVar) {
            v.this.a(str, eVar, haVar);
        }
    }

    class k implements s {
        k() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, qf.e eVar, ha haVar) {
            v.this.a(str, eVar, haVar);
        }
    }

    class l implements s {
        l() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, qf.e eVar, ha haVar) {
            v.this.a(str, eVar, haVar);
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qf.e f15199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ha f15200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15201c;

        m(qf.e eVar, ha haVar, String str) {
            this.f15199a = eVar;
            this.f15200b = haVar;
            this.f15201c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ha haVar;
            qf.e eVar = qf.e.RewardedVideo;
            qf.e eVar2 = this.f15199a;
            if ((eVar != eVar2 && qf.e.Interstitial != eVar2 && qf.e.Banner != eVar2) || (haVar = this.f15200b) == null || TextUtils.isEmpty(haVar.h())) {
                return;
            }
            m9 m9VarA = v.this.a(this.f15199a);
            Log.d(v.this.f15153c, "onAdProductInitFailed (message:" + this.f15201c + ")(" + this.f15199a + ")");
            if (m9VarA != null) {
                m9VarA.a(this.f15199a, this.f15200b.h(), this.f15201c);
            }
        }
    }

    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(1);
        }
    }

    private class o extends WebChromeClient {
        private o() {
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(v.this.Y.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Logger.i("MyApplication", consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(this);
            webView2.setWebViewClient(new q(v.this, null));
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            Logger.i("Test", "onHideCustomView");
            if (v.this.f15168r == null) {
                return;
            }
            v.this.f15168r.setVisibility(8);
            v.this.f15169s.removeView(v.this.f15168r);
            v.this.f15168r = null;
            v.this.f15169s.setVisibility(8);
            v.this.f15170t.onCustomViewHidden();
            v.this.Y.setVisibility(0);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Logger.i("Test", "onShowCustomView");
            v.this.Y.setVisibility(8);
            if (v.this.f15168r != null) {
                Logger.i("Test", "mCustomView != null");
                customViewCallback.onCustomViewHidden();
                return;
            }
            Logger.i("Test", "mCustomView == null");
            v.this.f15169s.addView(view);
            v.this.f15168r = view;
            v.this.f15170t = customViewCallback;
            v.this.f15169s.setVisibility(0);
        }

        /* synthetic */ o(v vVar, f fVar) {
            this();
        }
    }

    static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        qf.e f15205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f15206b;

        public p(qf.e eVar, String str) {
            this.f15205a = eVar;
            this.f15206b = str;
        }

        String a() {
            return this.f15206b;
        }

        qf.e b() {
            return this.f15205a;
        }
    }

    private class q extends WebViewClient {
        private q() {
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(v.this.f15153c, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context contextQ = v.this.q();
            contextQ.startActivity(new OpenUrlActivity.e(new k.b()).a(str).b(false).a(contextQ));
            return true;
        }

        /* synthetic */ q(v vVar, f fVar) {
            this();
        }
    }

    public class r {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15209a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15210b;

            a(String str, String str2) {
                this.f15209a = str;
                this.f15210b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f15209a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.f15153c, "onRVShowFail(message:" + this.f15209a + ")");
                v.this.f15174x.d(this.f15210b, str);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15212a;

            b(String str) {
                this.f15212a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.f15153c, "onInterstitialInitSuccess()");
                v.this.f15175y.a(qf.e.Interstitial, this.f15212a, (s2) null);
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15214a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15215b;

            c(String str, String str2) {
                this.f15214a = str;
                this.f15215b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f15214a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.f15153c, "onInterstitialInitFail(message:" + str + ")");
                v.this.f15175y.a(qf.e.Interstitial, this.f15215b, str);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ m9 f15217a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ qf.e f15218b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f15219c;

            d(m9 m9Var, qf.e eVar, String str) {
                this.f15217a = m9Var;
                this.f15218b = eVar;
                this.f15219c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f15217a.c(this.f15218b, this.f15219c);
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15221a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ JSONObject f15222b;

            e(String str, JSONObject jSONObject) {
                this.f15221a = str;
                this.f15222b = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.f15175y.a(this.f15221a, this.f15222b);
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15224a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15225b;

            f(String str, String str2) {
                this.f15224a = str;
                this.f15225b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f15224a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.f15175y.c(this.f15225b, str);
            }
        }

        class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15227a;

            g(String str) {
                this.f15227a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.f15153c, "onBannerInitSuccess()");
                v.this.f15176z.a(qf.e.Banner, this.f15227a, (s2) null);
            }
        }

        class h implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15229a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15230b;

            h(String str, String str2) {
                this.f15229a = str;
                this.f15230b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f15229a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.f15153c, "onBannerInitFail(message:" + str + ")");
                v.this.f15176z.a(qf.e.Banner, this.f15230b, str);
            }
        }

        class i implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15232a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ jf f15233b;

            i(String str, jf jfVar) {
                this.f15232a = str;
                this.f15233b = jfVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.f15153c, "onBannerLoadSuccess()");
                v.this.f15176z.a(this.f15232a, this.f15233b);
            }
        }

        class j implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15235a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15236b;

            j(String str, String str2) {
                this.f15235a = str;
                this.f15236b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.f15153c, "onLoadBannerFail()");
                String str = this.f15235a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.f15176z.a(this.f15236b, str);
            }
        }

        class k implements Runnable {
            k() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.F();
            }
        }

        class l implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15239a;

            l(String str) {
                this.f15239a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (new JSONObject(this.f15239a).has(f.b.f15003b)) {
                        v.this.S.a(f.a.a(this.f15239a));
                    } else {
                        v.this.T.a(gl.a(this.f15239a));
                    }
                } catch (JSONException e10) {
                    i9.d().a(e10);
                    Logger.e(v.this.f15153c, "failed to parse received message");
                    IronLog.INTERNAL.error(e10.toString());
                }
            }
        }

        class m implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ qf.e f15241a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15242b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f15243c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ JSONObject f15244d;

            m(qf.e eVar, String str, String str2, JSONObject jSONObject) {
                this.f15241a = eVar;
                this.f15242b = str;
                this.f15243c = str2;
                this.f15244d = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                m9 m9VarA;
                qf.e eVar = this.f15241a;
                if ((eVar == qf.e.Interstitial || eVar == qf.e.RewardedVideo || eVar == qf.e.Banner) && (m9VarA = v.this.a(eVar)) != null) {
                    m9VarA.a(this.f15241a, this.f15242b, this.f15243c, this.f15244d);
                }
            }
        }

        class n implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15246a;

            n(String str) {
                this.f15246a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logger.i(v.this.f15153c, "omidAPI(" + this.f15246a + ")");
                    v.this.H.a(new wp(this.f15246a).toString(), r.this.new w());
                } catch (Exception e10) {
                    i9.d().a(e10);
                    IronLog.INTERNAL.error(e10.toString());
                    Logger.i(v.this.f15153c, "omidAPI failed with exception " + e10.getMessage());
                }
            }
        }

        class o implements Runnable {
            o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.B();
            }
        }

        class p implements Runnable {
            p() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Y.removeJavascriptInterface(v8.f15654e);
            }
        }

        class q implements Runnable {
            q() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Y.getSettings().setMixedContentMode(0);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.sdk.controller.v$r$r, reason: collision with other inner class name */
        class RunnableC0270r implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f15251a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15252b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ s2 f15253c;

            RunnableC0270r(int i10, String str, s2 s2Var) {
                this.f15251a = i10;
                this.f15252b = str;
                this.f15253c = s2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f15251a <= 0) {
                    v.this.f15174x.c(this.f15252b);
                } else {
                    Log.d(v.this.f15153c, "onRVInitSuccess()");
                    v.this.f15174x.a(qf.e.RewardedVideo, this.f15252b, this.f15253c);
                }
            }
        }

        class s implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15255a;

            s(String str) {
                this.f15255a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    v.this.M.a(new JSONObject(this.f15255a), r.this.new w());
                } catch (Exception e10) {
                    i9.d().a(e10);
                    IronLog.INTERNAL.error(e10.toString());
                    Logger.i(v.this.f15153c, "fileSystemAPI failed with exception " + e10.getMessage());
                }
            }
        }

        class t implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15257a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15258b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f15259c;

            t(String str, String str2, int i10) {
                this.f15257a = str;
                this.f15258b = str2;
                this.f15259c = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f15257a.equalsIgnoreCase(qf.e.RewardedVideo.toString())) {
                    v.this.f15174x.a(this.f15258b, this.f15259c);
                }
            }
        }

        class u implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15261a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f15262b;

            u(String str, int i10) {
                this.f15261a = str;
                this.f15262b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.f15175y.onInterstitialAdRewarded(this.f15261a, this.f15262b);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.sdk.controller.v$r$v, reason: collision with other inner class name */
        class RunnableC0271v implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f15264a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f15265b;

            RunnableC0271v(String str, String str2) {
                this.f15264a = str;
                this.f15265b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f15264a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.f15153c, "onRVInitFail(message:" + str + ")");
                v.this.f15174x.a(qf.e.RewardedVideo, this.f15265b, str);
            }
        }

        public class w implements mj {
            public w() {
            }

            @Override // com.ironsource.mj
            public void a(boolean z10, @NotNull String str, wp wpVar) {
                wpVar.b(z10 ? v.f15149f0 : v.f15150g0, str);
                v.this.a(wpVar.toString(), z10, (String) null, (String) null);
            }

            @Override // com.ironsource.mj
            public void a(boolean z10, @NotNull String str, @NotNull String str2) {
                wp wpVar = new wp();
                wpVar.b(z10 ? v.f15149f0 : v.f15150g0, str);
                wpVar.b("data", str2);
                v.this.a(wpVar.toString(), z10, (String) null, (String) null);
            }

            @Override // com.ironsource.mj
            public void a(boolean z10, @NotNull String str, JSONObject jSONObject) {
                try {
                    jSONObject.put(z10 ? v.f15149f0 : v.f15150g0, str);
                    v.this.a(jSONObject.toString(), z10, (String) null, (String) null);
                } catch (JSONException e10) {
                    i9.d().a(e10);
                    IronLog.INTERNAL.error(e10.toString());
                }
            }
        }

        public r() {
        }

        @JavascriptInterface
        public void adClicked(String str) {
            Logger.i(v.this.f15153c, "adClicked(" + str + ")");
            wp wpVar = new wp(str);
            String strD = wpVar.d(v8.h.f15803m);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                return;
            }
            qf.e eVarG = v.this.g(strD);
            m9 m9VarA = v.this.a(eVarG);
            if (eVarG == null || m9VarA == null) {
                return;
            }
            v.this.b(new d(m9VarA, eVarG, strFetchDemandSourceId));
        }

        @JavascriptInterface
        public void adCredited(String str) {
            Log.d(v.this.f15154d, "adCredited(" + str + ")");
            wp wpVar = new wp(str);
            String strD = wpVar.d(v8.h.f15799k);
            int i10 = strD != null ? Integer.parseInt(strD) : 0;
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            String strD2 = wpVar.d(v8.h.f15803m);
            if (TextUtils.isEmpty(strD2)) {
                Log.d(v.this.f15154d, "adCredited | product type is missing");
            }
            if (qf.e.Interstitial.toString().equalsIgnoreCase(strD2)) {
                a(strFetchDemandSourceId, i10);
            } else if (v.this.q(strD2)) {
                v.this.b(new t(strD2, strFetchDemandSourceId, i10));
            }
        }

        @JavascriptInterface
        public void adUnitsReady(String str) {
            Logger.i(v.this.f15153c, "adUnitsReady(" + str + ")");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new wp(str));
            s2 s2Var = new s2(str);
            if (!s2Var.g()) {
                v.this.a(str, false, v8.c.f15715r, (String) null);
                return;
            }
            v.this.a(str, true, (String) null, (String) null);
            String strD = s2Var.d();
            if (qf.e.RewardedVideo.toString().equalsIgnoreCase(strD) && v.this.q(strD)) {
                v.this.b(new RunnableC0270r(Integer.parseInt(s2Var.c()), strFetchDemandSourceId, s2Var));
            }
        }

        @JavascriptInterface
        public void adViewAPI(String str) {
            try {
                Logger.i(v.this.f15153c, "adViewAPI(" + str + ")");
                v.this.L.a(new wp(str).toString(), new w());
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
                Logger.i(v.this.f15153c, "adViewAPI failed with exception " + e10.getMessage());
            }
        }

        @JavascriptInterface
        public void androidSandboxApi(final String str) {
            ve.f15889a.b(new Runnable() { // from class: com.ironsource.sdk.controller.f0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15013a.b(str);
                }
            });
        }

        @JavascriptInterface
        public void bannerViewAPI(String str) {
            Logger.i(v.this.f15153c, "bannerViewAPI is not supported in this native version, only adview API");
        }

        @JavascriptInterface
        public void cleanAdInstance(String str) {
            qf.e eVarG;
            try {
                Logger.i(v.this.f15153c, "cleanAdInstance(" + str + ")");
                wp wpVar = new wp(str);
                String strD = wpVar.d(v8.h.f15803m);
                String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
                if (TextUtils.isEmpty(strFetchDemandSourceId) || (eVarG = v.this.g(strD)) == null) {
                    return;
                }
                v.this.G.b(eVarG, strFetchDemandSourceId);
            } catch (Exception e10) {
                i9.d().a(e10);
                v.this.a(str, false, e10.getMessage(), (String) null);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @JavascriptInterface
        public void clearLastUpdateTimeData(String str) {
            try {
                ArrayList<String> arrayListA = dj.e().a();
                wp wpVar = new wp(str);
                if (!arrayListA.isEmpty()) {
                    wpVar.b(v8.h.f15826x0, arrayListA.toString());
                }
                v.this.a(wpVar.toString(), true, (String) null, (String) null);
            } catch (Exception e10) {
                i9.d().a(e10);
                v.this.a(str, false, e10.getMessage(), (String) null);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @JavascriptInterface
        public void deleteFile(String str) {
            try {
                Logger.i(v.this.f15153c, "deleteFile(" + str + ")");
                wp wpVar = new wp(str);
                String strD = wpVar.d(v8.h.f15781b);
                String strD2 = wpVar.d("path");
                if (strD2 != null && !TextUtils.isEmpty(strD)) {
                    zf zfVar = new zf(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, strD2), strD);
                    IronSourceStorageUtils.ensurePathSafety(zfVar, v.this.A);
                    if (!zfVar.exists()) {
                        v.this.a(str, false, v8.c.f15703f, "1");
                        return;
                    } else {
                        v.this.a(str, IronSourceStorageUtils.deleteFile(zfVar), (String) null, (String) null);
                        return;
                    }
                }
                v.this.a(str, false, v8.c.f15704g, "1");
            } catch (Exception e10) {
                i9.d().a(e10);
                v.this.a(str, false, e10.getMessage(), (String) null);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @JavascriptInterface
        public void deleteFolder(String str) {
            try {
                Logger.i(v.this.f15153c, "deleteFolder(" + str + ")");
                String strD = new wp(str).d("path");
                if (strD == null) {
                    v.this.a(str, false, v8.c.f15704g, "1");
                    return;
                }
                zf zfVar = new zf(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, strD));
                IronSourceStorageUtils.ensurePathSafety(zfVar, v.this.A);
                if (!zfVar.exists()) {
                    v.this.a(str, false, v8.c.f15702e, "1");
                } else {
                    v.this.a(str, IronSourceStorageUtils.deleteFolder(zfVar.getPath()), (String) null, (String) null);
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                v.this.a(str, false, e10.getMessage(), (String) null);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @JavascriptInterface
        public void deviceDataAPI(String str) {
            try {
                Logger.i(v.this.f15153c, "deviceDataAPI(" + str + ")");
                v.this.K.a(new wp(str).toString(), new w());
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
                Logger.i(v.this.f15153c, "deviceDataAPI failed with exception " + e10.getMessage());
            }
        }

        @JavascriptInterface
        public void displayWebView(String str) {
            Logger.i(v.this.f15153c, "displayWebView(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
            wp wpVar = new wp(str);
            boolean zBooleanValue = ((Boolean) wpVar.b(v8.h.f15785d)).booleanValue();
            String strD = wpVar.d(v8.h.f15803m);
            boolean zC = wpVar.c(v8.h.f15819u);
            String strD2 = wpVar.d("adViewId");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            boolean zC2 = wpVar.c(v8.h.f15830z0);
            if (!zBooleanValue) {
                v.this.a(u.Gone);
                v.this.o();
                return;
            }
            v.this.F = wpVar.c(v8.h.f15821v);
            boolean zC3 = wpVar.c(v8.h.f15827y);
            u uVarV = v.this.v();
            u uVar = u.Display;
            if (uVarV == uVar) {
                Logger.i(v.this.f15153c, "State: " + v.this.f15172v);
                return;
            }
            v.this.a(uVar);
            Logger.i(v.this.f15153c, "State: " + v.this.f15172v);
            Context contextQ = v.this.q();
            String strT = v.this.t();
            int I = v.this.W.I(contextQ);
            if (zC) {
                com.ironsource.sdk.controller.h hVar = new com.ironsource.sdk.controller.h(contextQ);
                hVar.addView(v.this.f15171u);
                hVar.a(v.this);
                return;
            }
            Intent intent = zC3 ? new Intent(contextQ, (Class<?>) InterstitialActivity.class) : new Intent(contextQ, (Class<?>) ControllerActivity.class);
            qf.e eVar = qf.e.RewardedVideo;
            if (eVar.toString().equalsIgnoreCase(strD)) {
                if ("application".equals(strT)) {
                    strT = SDKUtils.translateRequestedOrientation(v.this.W.K(contextQ));
                }
                intent.putExtra(v8.h.f15803m, eVar.toString());
                v.this.D.a(eVar.ordinal());
                v.this.D.f(strFetchDemandSourceId);
                if (v.this.q(eVar.toString())) {
                    v.this.f15174x.b(eVar, strFetchDemandSourceId);
                }
            } else {
                qf.e eVar2 = qf.e.Interstitial;
                if (eVar2.toString().equalsIgnoreCase(strD)) {
                    if ("application".equals(strT)) {
                        strT = SDKUtils.translateRequestedOrientation(v.this.W.K(contextQ));
                    }
                    intent.putExtra(v8.h.f15803m, eVar2.toString());
                }
            }
            if (strD2 != null) {
                intent.putExtra("adViewId", strD2);
            }
            intent.putExtra(v8.h.f15830z0, zC2);
            intent.setFlags(536870912);
            intent.putExtra(v8.h.f15821v, v.this.F);
            intent.putExtra(v8.h.A, strT);
            intent.putExtra(v8.h.B, I);
            v vVar = v.this;
            vVar.f15160j = new p(vVar.g(strD), strFetchDemandSourceId);
            contextQ.startActivity(intent);
        }

        @JavascriptInterface
        public void fileSystemAPI(String str) {
            Logger.i(v.this.f15153c, "fileSystemAPI(" + str + ")");
            v.this.a(new s(str));
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void getApplicationInfo(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                java.lang.String r0 = com.ironsource.sdk.controller.v.z(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getApplicationInfo("
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.Logger.i(r0, r1)
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                java.lang.String r0 = com.ironsource.sdk.controller.v.a(r0, r5)
                com.ironsource.sdk.controller.v r1 = com.ironsource.sdk.controller.v.this
                java.lang.String r1 = com.ironsource.sdk.controller.v.b(r1, r5)
                com.ironsource.wp r2 = new com.ironsource.wp
                r2.<init>(r5)
                java.lang.String r5 = "productType"
                java.lang.String r5 = r2.d(r5)
                java.lang.String r2 = com.ironsource.sdk.utils.SDKUtils.fetchDemandSourceId(r2)
                com.ironsource.sdk.controller.v r3 = com.ironsource.sdk.controller.v.this
                java.lang.Object[] r5 = com.ironsource.sdk.controller.v.a(r3, r5, r2)
                r2 = 0
                r2 = r5[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r5 = r5[r3]
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L58
                boolean r5 = android.text.TextUtils.isEmpty(r1)
                if (r5 != 0) goto L5f
                r0 = r1
                goto L60
            L58:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L5f
                goto L60
            L5f:
                r0 = 0
            L60:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L75
                com.ironsource.sdk.controller.v r5 = com.ironsource.sdk.controller.v.this
                java.lang.String r1 = "onGetApplicationInfoSuccess"
                java.lang.String r3 = "onGetApplicationInfoFail"
                java.lang.String r5 = com.ironsource.sdk.controller.v.a(r5, r0, r2, r1, r3)
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                com.ironsource.sdk.controller.v.e(r0, r5)
            L75:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.v.r.getApplicationInfo(java.lang.String):void");
        }

        @JavascriptInterface
        public void getCachedFilesMap(String str) {
            v vVar;
            String str2;
            Logger.i(v.this.f15153c, "getCachedFilesMap(" + str + ")");
            String strE = v.this.e(str);
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            wp wpVar = new wp(str);
            if (wpVar.a("path")) {
                String str3 = (String) wpVar.b("path");
                if (IronSourceStorageUtils.isPathExist(v.this.A, str3)) {
                    v.this.i(v.this.a(strE, IronSourceStorageUtils.getCachedFilesMap(v.this.A, str3), v8.g.f15768r, v8.g.f15767q));
                    return;
                }
                vVar = v.this;
                str2 = v8.c.f15717t;
            } else {
                vVar = v.this;
                str2 = v8.c.f15716s;
            }
            vVar.a(str, false, str2, (String) null);
        }

        @JavascriptInterface
        public void getConnectivityInfo(String str) {
            String strE;
            Logger.i(v.this.f15153c, "getConnectivityInfo(" + str + ")");
            wp wpVar = new wp(str);
            String strD = wpVar.d(v.f15149f0);
            String strD2 = wpVar.d(v.f15150g0);
            JSONObject jSONObject = new JSONObject();
            if (v.this.Q != null) {
                jSONObject = v.this.Q.a(v.this.Y.getContext());
            }
            if (jSONObject.length() > 0) {
                strE = v.this.e(strD, jSONObject.toString());
            } else {
                strE = v.this.e(strD2, v.this.a("errMsg", v8.c.A, null, null, null, null, null, null, null, false));
            }
            v.this.i(strE);
        }

        @JavascriptInterface
        public void getControllerConfig(String str) {
            Logger.i(v.this.f15153c, "getControllerConfig(" + str + ")");
            String strD = new wp(str).d(v.f15149f0);
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
            c(controllerConfigAsJSONObject);
            v.this.i(v.this.e(strD, controllerConfigAsJSONObject.toString()));
        }

        @JavascriptInterface
        public void getDemandSourceState(String str) {
            String strD;
            Logger.i(v.this.f15153c, "getMediationState(" + str + ")");
            wp wpVar = new wp(str);
            String strD2 = wpVar.d("demandSourceName");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            String strD3 = wpVar.d(v8.h.f15803m);
            if (strD3 == null || strD2 == null) {
                return;
            }
            try {
                qf.e productType = SDKUtils.getProductType(strD3);
                if (productType != null) {
                    ha haVarA = v.this.G.a(productType, strFetchDemandSourceId);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(v8.h.f15803m, strD3);
                    jSONObject.put("demandSourceName", strD2);
                    jSONObject.put("demandSourceId", strFetchDemandSourceId);
                    if (haVarA == null || haVarA.a(-1)) {
                        strD = v.this.d(str);
                    } else {
                        strD = v.this.e(str);
                        jSONObject.put("state", haVarA.j());
                    }
                    a(strD, jSONObject.toString());
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                v.this.a(str, false, e10.getMessage(), (String) null);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void getDeviceStatus(java.lang.String r5) {
            /*
                r4 = this;
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                java.lang.String r0 = com.ironsource.sdk.controller.v.z(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getDeviceStatus("
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.ironsource.sdk.utils.Logger.i(r0, r1)
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                java.lang.String r0 = com.ironsource.sdk.controller.v.a(r0, r5)
                com.ironsource.sdk.controller.v r1 = com.ironsource.sdk.controller.v.this
                java.lang.String r5 = com.ironsource.sdk.controller.v.b(r1, r5)
                com.ironsource.sdk.controller.v r1 = com.ironsource.sdk.controller.v.this
                com.ironsource.fj r2 = r1.Y
                android.content.Context r2 = r2.getContext()
                java.lang.Object[] r1 = com.ironsource.sdk.controller.v.a(r1, r2)
                r2 = 0
                r2 = r1[r2]
                java.lang.String r2 = (java.lang.String) r2
                r3 = 1
                r1 = r1[r3]
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L4f
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                if (r0 != 0) goto L56
                r0 = r5
                goto L57
            L4f:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L56
                goto L57
            L56:
                r0 = 0
            L57:
                boolean r5 = android.text.TextUtils.isEmpty(r0)
                if (r5 != 0) goto L6c
                com.ironsource.sdk.controller.v r5 = com.ironsource.sdk.controller.v.this
                java.lang.String r1 = "onGetDeviceStatusSuccess"
                java.lang.String r3 = "onGetDeviceStatusFail"
                java.lang.String r5 = com.ironsource.sdk.controller.v.a(r5, r0, r2, r1, r3)
                com.ironsource.sdk.controller.v r0 = com.ironsource.sdk.controller.v.this
                com.ironsource.sdk.controller.v.e(r0, r5)
            L6c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.v.r.getDeviceStatus(java.lang.String):void");
        }

        @JavascriptInterface
        public void getDeviceVolume(String str) {
            Logger.i(v.this.f15153c, "getDeviceVolume(" + str + ")");
            try {
                Context context = v.this.Y.getContext();
                float fA = la.b(context).a(context);
                wp wpVar = new wp(str);
                wpVar.b(v8.i.P, String.valueOf(fA));
                v.this.a(wpVar.toString(), true, (String) null, (String) null);
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @JavascriptInterface
        public void getInitSummery(String str) {
            Logger.i(v.this.f15153c, "getInitSummery(" + str + ")");
            wp wpVar = new wp(str);
            wpVar.a(v8.i.f15866r0, v.this.R);
            v.this.a(wpVar.toString(), true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void getOrientation(String str) {
            xf.a(vp.f15958z, new sf().a(nb.f14127y, str).a());
            String strE = v.this.e(str);
            String string = SDKUtils.getOrientation(v.this.Y.getContext()).toString();
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            v.this.i(v.this.a(strE, string, v8.g.W, v8.g.X));
        }

        @JavascriptInterface
        public void getUserData(String str) {
            Logger.i(v.this.f15153c, "getUserData(" + str + ")");
            wp wpVar = new wp(str);
            if (!wpVar.a(v8.h.W)) {
                v.this.a(str, false, v8.c.F, (String) null);
                return;
            }
            String strE = v.this.e(str);
            String strD = wpVar.d(v8.h.W);
            v.this.i(v.this.e(strE, v.this.a(strD, dj.e().a(strD), null, null, null, null, null, null, null, false)));
        }

        @JavascriptInterface
        public void iabTokenAPI(String str) {
            try {
                Logger.i(v.this.f15153c, "iabTokenAPI(" + str + ")");
                v.this.J.a(new wp(str).toString(), new w());
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
                Logger.i(v.this.f15153c, "iabTokenAPI failed with exception " + e10.getMessage());
            }
        }

        @JavascriptInterface
        public void initController(String str) {
            Logger.i(v.this.f15153c, "initController(" + str + ")");
            wp wpVar = new wp(str);
            CountDownTimer countDownTimer = v.this.f15163m;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                v.this.f15163m = null;
            }
            if (wpVar.a(v8.h.f15811q)) {
                String strD = wpVar.d(v8.h.f15811q);
                if (v8.h.f15815s.equalsIgnoreCase(strD)) {
                    v.this.f15159i = true;
                    v.this.P.c();
                    return;
                }
                if (v8.h.f15813r.equalsIgnoreCase(strD)) {
                    v.this.P.b();
                    return;
                }
                if (!v8.h.f15817t.equalsIgnoreCase(strD)) {
                    Logger.i(v.this.f15153c, "No STAGE mentioned! should not get here!");
                    return;
                }
                String strD2 = wpVar.d("errMsg");
                v.this.P.b("controller js failed to initialize : " + strD2);
            }
        }

        @JavascriptInterface
        public void omidAPI(String str) {
            v.this.c(new n(str));
        }

        @JavascriptInterface
        public void onAdWindowsClosed(String str) {
            Logger.i(v.this.f15153c, "onAdWindowsClosed(" + str + ")");
            v.this.D.a();
            v.this.D.f(null);
            v.this.f15160j = null;
            wp wpVar = new wp(str);
            String strD = wpVar.d(v8.h.f15803m);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            qf.e eVarG = v.this.g(strD);
            Log.d(v.this.f15154d, "onAdClosed() with type " + eVarG);
            if (v.this.q(strD)) {
                v.this.a(eVarG, strFetchDemandSourceId);
            }
        }

        @JavascriptInterface
        public void onCleanUpNonDisplayBannersSuccess(String str) {
            Logger.i(v.this.f15153c, "onCleanUpNonDisplayBannersSuccess() value=" + str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoFail(String str) {
            Logger.i(v.this.f15153c, "onGetApplicationInfoFail(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetApplicationInfoSuccess(String str) {
            Logger.i(v.this.f15153c, "onGetApplicationInfoSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapFail(String str) {
            Logger.i(v.this.f15153c, "onGetCachedFilesMapFail(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapSuccess(String str) {
            Logger.i(v.this.f15153c, "onGetCachedFilesMapSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetDeviceStatusFail(String str) {
            Logger.i(v.this.f15153c, "onGetDeviceStatusFail(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetDeviceStatusSuccess(String str) {
            Logger.i(v.this.f15153c, "onGetDeviceStatusSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitBannerFail(String str) {
            Logger.i(v.this.f15153c, "onInitBannerFail(" + str + ")");
            wp wpVar = new wp(str);
            String strD = wpVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.f15153c, "onInitBannerFail failed with no demand source");
                return;
            }
            ia iaVar = v.this.G;
            qf.e eVar = qf.e.Banner;
            ha haVarA = iaVar.a(eVar, strFetchDemandSourceId);
            if (haVarA != null) {
                haVarA.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new h(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitBannerSuccess(String str) {
            Logger.i(v.this.f15153c, "onInitBannerSuccess()");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new wp(str));
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.f15153c, "onInitBannerSuccess failed with no demand source");
            } else if (v.this.q(qf.e.Banner.toString())) {
                v.this.b(new g(strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitInterstitialFail(String str) {
            Logger.i(v.this.f15153c, "onInitInterstitialFail(" + str + ")");
            wp wpVar = new wp(str);
            String strD = wpVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.f15153c, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            ia iaVar = v.this.G;
            qf.e eVar = qf.e.Interstitial;
            ha haVarA = iaVar.a(eVar, strFetchDemandSourceId);
            if (haVarA != null) {
                haVarA.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new c(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitInterstitialSuccess(String str) {
            Logger.i(v.this.f15153c, "onInitInterstitialSuccess()");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new wp(str));
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.f15153c, "onInitInterstitialSuccess failed with no demand source");
            } else if (v.this.q(qf.e.Interstitial.toString())) {
                v.this.b(new b(strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitRewardedVideoFail(String str) {
            Logger.i(v.this.f15153c, "onInitRewardedVideoFail(" + str + ")");
            wp wpVar = new wp(str);
            String strD = wpVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            ia iaVar = v.this.G;
            qf.e eVar = qf.e.RewardedVideo;
            ha haVarA = iaVar.a(eVar, strFetchDemandSourceId);
            if (haVarA != null) {
                haVarA.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new RunnableC0271v(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onLoadBannerFail(String str) {
            Logger.i(v.this.f15153c, "onLoadBannerFail()");
            wp wpVar = new wp(str);
            String strD = wpVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            v.this.a(str, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(strFetchDemandSourceId) && v.this.q(qf.e.Banner.toString())) {
                v.this.b(new j(strD, strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onLoadBannerSuccess(String str) {
            Logger.i(v.this.f15153c, "onLoadBannerSuccess()");
            wp wpVar = new wp(str);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            String strD = wpVar.d("adViewId");
            v.this.a(str, true, (String) null, (String) null);
            hg hgVarA = pf.a().a(strD);
            if (hgVarA == null) {
                v.this.f15176z.a(strFetchDemandSourceId, "not found view for the current adViewId= " + strD);
                return;
            }
            if (hgVarA instanceof jf) {
                jf jfVar = (jf) hgVarA;
                if (v.this.q(qf.e.Banner.toString())) {
                    v.this.b(new i(strFetchDemandSourceId, jfVar));
                }
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialFail(String str) {
            Logger.i(v.this.f15153c, "onLoadInterstitialFail(" + str + ")");
            wp wpVar = new wp(str);
            String strD = wpVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            v.this.a(str, true, (String) null, (String) null);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                return;
            }
            a(strFetchDemandSourceId, false);
            if (v.this.q(qf.e.Interstitial.toString())) {
                v.this.b(new f(strD, strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialSuccess(String str) {
            Logger.i(v.this.f15153c, "onLoadInterstitialSuccess(" + str + ")");
            wp wpVar = new wp(str);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            JSONObject jSONObjectA = wpVar.a();
            a(strFetchDemandSourceId, true);
            v.this.a(str, true, (String) null, (String) null);
            if (v.this.q(qf.e.Interstitial.toString())) {
                v.this.b(new e(strFetchDemandSourceId, jSONObjectA));
            }
        }

        @JavascriptInterface
        public void onReceivedMessage(String str) {
            Logger.i(v.this.f15153c, "onReceivedMessage(" + str + ")");
            ve.f15889a.b(new l(str));
        }

        @JavascriptInterface
        public void onShowInterstitialFail(String str) {
            Logger.i(v.this.f15153c, "onShowInterstitialFail(" + str + ")");
            wp wpVar = new wp(str);
            final String strD = wpVar.d("errMsg");
            final String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            v.this.a(str, true, (String) null, (String) null);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                return;
            }
            final boolean zQ = v.this.q(qf.e.Interstitial.toString());
            v.this.b(new Runnable() { // from class: com.ironsource.sdk.controller.d0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14926a.a(zQ, strD, strFetchDemandSourceId);
                }
            });
        }

        @JavascriptInterface
        public void onShowInterstitialSuccess(String str) {
            Logger.i(v.this.f15153c, "onShowInterstitialSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
            final String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new wp(str));
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.f15153c, "onShowInterstitialSuccess called with no demand");
                return;
            }
            t2 t2Var = v.this.D;
            qf.e eVar = qf.e.Interstitial;
            t2Var.a(eVar.ordinal());
            v.this.D.f(strFetchDemandSourceId);
            final boolean zQ = v.this.q(eVar.toString());
            v.this.b(new Runnable() { // from class: com.ironsource.sdk.controller.e0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14996a.a(zQ, strFetchDemandSourceId);
                }
            });
        }

        @JavascriptInterface
        public void onShowRewardedVideoFail(String str) {
            Logger.i(v.this.f15153c, "onShowRewardedVideoFail(" + str + ")");
            wp wpVar = new wp(str);
            String strD = wpVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
            if (v.this.q(qf.e.RewardedVideo.toString())) {
                v.this.b(new a(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onShowRewardedVideoSuccess(String str) {
            Logger.i(v.this.f15153c, "onShowRewardedVideoSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onVideoStatusChanged(String str) {
            Log.d(v.this.f15153c, "onVideoStatusChanged(" + str + ")");
            wp wpVar = new wp(str);
            String strD = wpVar.d(v8.h.f15803m);
            if (v.this.C == null || TextUtils.isEmpty(strD)) {
                return;
            }
            String strD2 = wpVar.d("status");
            if (v8.h.f15786d0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoStarted();
                return;
            }
            if (v8.h.f15788e0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoPaused();
                return;
            }
            if (v8.h.f15790f0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoResumed();
                return;
            }
            if (v8.h.f15792g0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoEnded();
                return;
            }
            if (v8.h.f15794h0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoStopped();
                return;
            }
            Logger.i(v.this.f15153c, "onVideoStatusChanged: unknown status: " + strD2);
        }

        @JavascriptInterface
        public void openUrl(String str) {
            Logger.i(v.this.f15153c, "openUrl(" + str + ")");
            wp wpVar = new wp(str);
            p.c cVarA = new p.a(wpVar.d("method"), new mn(v.this.F, DriveFile.MODE_READ_WRITE)).a(wpVar.c(v8.h.L0) ? v.this.Y.getContext() : v.this.q(), new ln(wpVar.d("url"), wpVar.d(v8.h.V)));
            if (cVarA instanceof p.c.a) {
                v.this.a(str, false, ((p.c.a) cVarA).b(), (String) null);
            } else {
                v.this.a(str, true, (String) null, (String) null);
            }
        }

        @JavascriptInterface
        public void pauseControllerWebview() {
            v.this.c(new o());
        }

        @JavascriptInterface
        public void permissionsAPI(String str) {
            try {
                Logger.i(v.this.f15153c, "permissionsAPI(" + str + ")");
                v.this.I.a(new wp(str).toString(), new w());
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
                Logger.i(v.this.f15153c, "permissionsAPI failed with exception " + e10.getMessage());
            }
        }

        @JavascriptInterface
        public void postAdEventNotification(String str) {
            try {
                Logger.i(v.this.f15153c, "postAdEventNotification(" + str + ")");
                wp wpVar = new wp(str);
                String strD = wpVar.d(v8.h.f15798j0);
                if (TextUtils.isEmpty(strD)) {
                    v.this.a(str, false, v8.c.f15720w, (String) null);
                    return;
                }
                String strD2 = wpVar.d(v8.h.f15800k0);
                String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(wpVar);
                String str2 = !TextUtils.isEmpty(strFetchDemandSourceId) ? strFetchDemandSourceId : strD2;
                JSONObject jSONObject = (JSONObject) wpVar.b(v8.h.f15802l0);
                String strD3 = wpVar.d(v8.h.f15803m);
                qf.e eVarG = v.this.g(strD3);
                if (!v.this.q(strD3)) {
                    v.this.a(str, false, v8.c.f15719v, (String) null);
                    return;
                }
                String strE = v.this.e(str);
                if (!TextUtils.isEmpty(strE)) {
                    v.this.i(v.this.a(strE, v.this.a(v8.h.f15803m, strD3, v8.h.f15798j0, strD, "demandSourceName", strD2, "demandSourceId", str2, null, false), v8.g.f15751b0, v8.g.f15752c0));
                }
                v.this.b(new m(eVarG, str2, strD, jSONObject));
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @JavascriptInterface
        public void removeCloseEventHandler(String str) {
            Logger.i(v.this.f15153c, "removeCloseEventHandler(" + str + ")");
            if (v.this.f15162l != null) {
                v.this.f15162l.cancel();
            }
            v.this.f15161k = true;
        }

        @JavascriptInterface
        public void removeMessagingInterface(String str) {
            v.this.c(new p());
        }

        @JavascriptInterface
        public void requestToDestroyBanner(String str) {
            Logger.i(v.this.f15153c, "onCleanUpNonDisplayBannersFail() value=" + str);
        }

        @JavascriptInterface
        public void resumeControllerWebview() {
            v.this.c(new k());
        }

        @JavascriptInterface
        public void saveFile(String str) {
            try {
                Logger.i(v.this.f15153c, "saveFile(" + str + ")");
                wp wpVar = new wp(str);
                String strD = wpVar.d("path");
                String strD2 = wpVar.d(v8.h.f15781b);
                if (TextUtils.isEmpty(strD2)) {
                    v.this.a(str, false, v8.c.f15704g, "1");
                    return;
                }
                zf zfVar = new zf(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, strD), SDKUtils.getFileName(strD2));
                IronSourceStorageUtils.ensurePathSafety(zfVar, v.this.A);
                if (v.this.W.a(v.this.A) <= 0) {
                    v.this.a(str, false, x8.A, (String) null);
                    return;
                }
                if (zfVar.exists()) {
                    v.this.a(str, false, x8.f16169z, (String) null);
                    return;
                }
                if (!r8.h(v.this.Y.getContext())) {
                    v.this.a(str, false, x8.C, (String) null);
                    return;
                }
                v.this.a(str, true, (String) null, (String) null);
                v.this.f15158h.a(zfVar, strD2, wpVar.a("connectionTimeout", 0), wpVar.a("readTimeout", 0));
            } catch (Exception e10) {
                i9.d().a(e10);
                v.this.a(str, false, e10.getMessage(), (String) null);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @JavascriptInterface
        public void setBackButtonState(String str) {
            Logger.i(v.this.f15153c, "setBackButtonState(" + str + ")");
            dj.e().c(new wp(str).d("state"));
        }

        @JavascriptInterface
        public void setForceClose(String str) {
            Logger.i(v.this.f15153c, "setForceClose(" + str + ")");
            wp wpVar = new wp(str);
            String strD = wpVar.d("width");
            String strD2 = wpVar.d("height");
            v.this.f15164n = Integer.parseInt(strD);
            v.this.f15165o = Integer.parseInt(strD2);
            v.this.f15166p = wpVar.d(v8.h.L);
        }

        @JavascriptInterface
        public void setMixedContentAlwaysAllow(String str) {
            Logger.i(v.this.f15153c, "setMixedContentAlwaysAllow(" + str + ")");
            v.this.c(new q());
        }

        @JavascriptInterface
        public void setOrientation(String str) {
            try {
                Logger.i(v.this.f15153c, "setOrientation(" + str + ")");
                String strD = new wp(str).d("orientation");
                v.this.n(strD);
                if (v.this.Z != null) {
                    v.this.Z.onOrientationChanged(strD, v.this.W.I(v.this.Y.getContext()));
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        @JavascriptInterface
        public void setStoreSearchKeys(String str) {
            Logger.i(v.this.f15153c, "setStoreSearchKeys(" + str + ")");
            dj.e().e(str);
        }

        @JavascriptInterface
        public void setUserData(String str) {
            Logger.i(v.this.f15153c, "setUserData(" + str + ")");
            wp wpVar = new wp(str);
            if (!wpVar.a(v8.h.W)) {
                v.this.a(str, false, v8.c.F, (String) null);
                return;
            }
            if (!wpVar.a("value")) {
                v.this.a(str, false, v8.c.G, (String) null);
                return;
            }
            String strD = wpVar.d(v8.h.W);
            String strD2 = wpVar.d("value");
            dj.e().a(strD, strD2);
            v.this.i(v.this.e(v.this.e(str), v.this.a(strD, strD2, null, null, null, null, null, null, null, false)));
        }

        @JavascriptInterface
        public void setWebviewBackgroundColor(String str) {
            Logger.i(v.this.f15153c, "setWebviewBackgroundColor(" + str + ")");
            v.this.p(str);
        }

        @JavascriptInterface
        public void stillAlive(String str) {
            Logger.i(v.this.f15153c, "stillAlive(" + str + ")");
            v.this.f15152b.a();
        }

        private void a(String str, int i10) {
            ha haVarA;
            v vVar = v.this;
            qf.e eVar = qf.e.Interstitial;
            if (vVar.q(eVar.toString()) && (haVarA = v.this.G.a(eVar, str)) != null && haVarA.k()) {
                v.this.b(new u(str, i10));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            try {
                l3.a aVarA = v.this.N.a(v.this.Y.getContext(), fy.a(str));
                v.this.i(v.this.e(aVarA.f(), aVarA.i().toString()));
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }

        void c(String str) {
            v.this.i(v.this.a(v8.g.f15753d, str, (String) null, (String) null));
        }

        private void a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            v.this.i(v.this.e(str, str2));
        }

        private void b(JSONObject jSONObject) {
            try {
                FeaturesManager featuresManager = FeaturesManager.getInstance();
                if (featuresManager.a().isEmpty()) {
                    return;
                }
                jSONObject.put(v8.a.f15680g, new JSONArray((Collection) featuresManager.a()));
            } catch (Exception e10) {
                i9.d().a(e10);
                xf.a(vp.f15948p, new sf().a(nb.A, e10.getMessage()).a());
                Logger.d(v.this.f15153c, "getControllerConfig Error while adding supported features data from FeaturesManager");
            }
        }

        private void c(JSONObject jSONObject) {
            b(jSONObject);
            a(jSONObject, SDKUtils.getTesterParameters());
            if (v.this.V) {
                return;
            }
            a(jSONObject);
        }

        private void a(String str, boolean z10) {
            ha haVarA = v.this.G.a(qf.e.Interstitial, str);
            if (haVarA != null) {
                haVarA.a(z10);
            }
        }

        private void a(JSONObject jSONObject) {
            try {
                jSONObject.put("controllerSourceData", v.this.B.f());
            } catch (Exception e10) {
                i9.d().a(e10);
                Logger.d(v.this.f15153c, "Unable to add controller source data into controllerConfig");
            }
        }

        private void a(JSONObject jSONObject, String str) {
            if (a(str)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.putOpt("testerABGroup", jSONObject2.get("testerABGroup"));
                    jSONObject.putOpt("testFriendlyName", jSONObject2.get("testFriendlyName"));
                } catch (JSONException e10) {
                    i9.d().a(e10);
                    Logger.d(v.this.f15153c, "getControllerConfig Error while parsing Tester AB Group parameters");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z10, String str) {
            if (z10) {
                v.this.f15175y.b(qf.e.Interstitial, str);
                v.this.f15175y.b(str);
            }
            a(str, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z10, String str, String str2) {
            if (z10) {
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.f15175y.b(str2, str);
            }
            a(str2, false);
        }

        boolean a(String str) {
            if (TextUtils.isEmpty(str) || str.contains("-1")) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("testerABGroup").isEmpty()) {
                    return false;
                }
                return !jSONObject.getString("testFriendlyName").isEmpty();
            } catch (JSONException e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
                return false;
            }
        }
    }

    private interface s {
        void a(String str, qf.e eVar, ha haVar);
    }

    static class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f15269b;

        t() {
        }
    }

    public enum u {
        Display,
        Gone
    }

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.v$v, reason: collision with other inner class name */
    private class C0272v extends WebViewClient {
        private C0272v() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.i("onPageFinished", str);
            if (str.contains("adUnit") || str.contains(com.vungle.ads.internal.l.AD_INDEX_FILE_NAME)) {
                v.this.A();
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.i("onPageStarted", str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            Logger.i("onReceivedError", str2 + " " + str);
            if (str2.contains(v8.f15655f) && v.this.P != null) {
                v.this.P.b("controller html - web-view receivedError on loading - " + str + " (errorCode: " + i10 + ")");
            }
            super.onReceivedError(webView, i10, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.e(v.this.f15153c, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            String str = renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system";
            if (v.this.P != null) {
                v.this.P.c(str);
            }
            v.this.w();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean zContains;
            Logger.i("shouldInterceptRequest", str);
            try {
                zContains = new URL(str).getFile().contains(com.vungle.ads.internal.l.AD_MRAID_JS_FILE_NAME);
            } catch (MalformedURLException e10) {
                i9.d().a(e10);
                zContains = false;
            }
            if (zContains) {
                String str2 = com.vungle.ads.internal.model.b.FILE_SCHEME + v.this.A + File.separator + com.vungle.ads.internal.l.AD_MRAID_JS_FILE_NAME;
                try {
                    new FileInputStream(new File(str2));
                    return new WebResourceResponse("text/javascript", "UTF-8", getClass().getResourceAsStream(str2));
                } catch (FileNotFoundException e11) {
                    i9.d().a(e11);
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.i("shouldOverrideUrlLoading", str);
            try {
                if (v.this.h(str)) {
                    v.this.z();
                    return true;
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        /* synthetic */ C0272v(v vVar, f fVar) {
            this();
        }
    }

    public v(Context context, ia iaVar, y8 y8Var, com.ironsource.sdk.controller.c cVar, ve veVar, int i10, ra raVar, String str, l.a aVar, l.b bVar, String str2, String str3) throws Throwable {
        fj fjVar = new fj(context, new qj.a());
        this.Y = fjVar;
        Logger.i(this.f15153c, "C'tor");
        this.X = y8Var;
        this.P = cVar;
        this.f15151a = veVar;
        this.G = iaVar;
        a(context, fjVar);
        this.A = str;
        this.D = new t2();
        this.R = new JSONObject();
        this.f15158h = raVar;
        this.S = aVar;
        this.T = bVar;
        boolean zOptBoolean = SDKUtils.getNetworkConfiguration().optBoolean(v8.a.f15681h, false);
        this.V = zOptBoolean;
        if (zOptBoolean) {
            this.U = new f9(new c9(SDKUtils.getControllerUrl(), this.A, SDKUtils.getNetworkConfiguration().optBoolean("useWebViewUserAgent", false), new vn(SDKUtils.getControllerUrl())), new h9.l() { // from class: com.ironsource.sdk.controller.z
                @Override // h9.l
                public final Object invoke(Object obj) {
                    return this.f15285a.c((zf) obj);
                }
            }, raVar, new k9.a());
        } else {
            raVar.a(this);
            this.B = new com.ironsource.sdk.controller.d(SDKUtils.getNetworkConfiguration(), this.A, SDKUtils.getControllerUrl(), raVar);
        }
        f fVar = null;
        o oVar = new o(this, fVar);
        this.f15167q = oVar;
        fjVar.setWebViewClient(new C0272v(this, fVar));
        fjVar.setWebChromeClient(oVar);
        yu.a(fjVar);
        a(fjVar);
        fjVar.setDownloadListener(this);
        this.Q = c(context);
        b(context);
        b(i10);
        this.f15156f = str2;
        this.f15157g = str3;
        this.f15152b = bv.a(FeaturesManager.getInstance().getFeatureFlagHealthCheck());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        return new wp(str).d(f15149f0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        try {
            Logger.i(this.f15153c, "load(): " + str);
            this.Y.loadUrl(str);
        } catch (Throwable th) {
            i9.d().a(th);
            Logger.e(this.f15153c, "WebViewController::load: " + th);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void destroy() {
        this.Y.destroy();
        ra raVar = this.f15158h;
        if (raVar != null) {
            raVar.d();
        }
        p8 p8Var = this.Q;
        if (p8Var != null) {
            p8Var.b();
        }
        CountDownTimer countDownTimer = this.f15163m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
        Logger.i(this.f15153c, str + " " + str4);
    }

    public xu p() {
        if (this.O == null) {
            this.O = new g();
        }
        return this.O;
    }

    public Context q() {
        return this.X.a();
    }

    public int r() {
        return f15145b0;
    }

    public FrameLayout s() {
        return this.f15171u;
    }

    public String t() {
        return this.f15173w;
    }

    @SuppressLint({"NewApi"})
    private void G() {
    }

    private p8 c(Context context) {
        return new f(SDKUtils.getControllerConfigAsJSONObject(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        return new wp(str).d(f15150g0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str, String str2) {
        return new m.a(str, str2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str) {
        this.Y.a(new m.b(str, r()).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        kn knVar = this.Z;
        if (knVar != null) {
            knVar.onCloseRequested();
        }
    }

    public void A() {
        i(f(v8.g.f15776z));
    }

    public void B() {
        try {
            this.Y.onPause();
        } catch (Throwable th) {
            i9.d().a(th);
            Logger.i(this.f15153c, "WebViewController: onPause() - " + th);
        }
    }

    public void C() {
        this.C = null;
    }

    public void D() {
        this.Z = null;
    }

    public void E() {
        this.Y.requestFocus();
    }

    public void F() {
        try {
            this.Y.onResume();
        } catch (Throwable th) {
            i9.d().a(th);
            Logger.i(this.f15153c, "WebViewController: onResume() - " + th);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public qf.c g() {
        return qf.c.Web;
    }

    public void k(String str) {
        i(e(v8.g.f15772v, a("action", str, null, null, null, null, null, null, null, false)));
    }

    public t2 u() {
        return this.D;
    }

    public u v() {
        return this.f15172v;
    }

    public void w() {
        if (this.f15160j == null) {
            return;
        }
        o();
        qf.e eVarB = this.f15160j.b();
        String strA = this.f15160j.a();
        if (q(eVarB.toString())) {
            a(eVarB, strA);
        }
    }

    public void x() {
        this.f15167q.onHideCustomView();
    }

    public boolean y() {
        return this.f15168r != null;
    }

    public void z() {
        i(f(v8.g.Y));
    }

    private String d(JSONObject jSONObject) {
        la laVarB = la.b(this.Y.getContext());
        StringBuilder sb = new StringBuilder();
        String sDKVersion = SDKUtils.getSDKVersion();
        if (!TextUtils.isEmpty(sDKVersion)) {
            sb.append(v8.i.f15863q);
            sb.append(v8.i.f15833b);
            sb.append(sDKVersion);
            sb.append(v8.i.f15835c);
        }
        String strE = laVarB.e();
        if (!TextUtils.isEmpty(strE)) {
            sb.append(v8.i.f15855m);
            sb.append(v8.i.f15833b);
            sb.append(strE);
        }
        Uri uri = Uri.parse(SDKUtils.getControllerUrl());
        if (uri != null) {
            String str = uri.getScheme() + ":";
            String host = uri.getHost();
            int port = uri.getPort();
            if (port != -1) {
                host = host + ":" + port;
            }
            sb.append(v8.i.f15835c);
            sb.append("protocol");
            sb.append(v8.i.f15833b);
            sb.append(str);
            sb.append(v8.i.f15835c);
            sb.append(v8.i.D);
            sb.append(v8.i.f15833b);
            sb.append(host);
            if (jSONObject.keys().hasNext()) {
                try {
                    String string = new JSONObject(jSONObject, new String[]{v8.i.Z, v8.i.f15843g}).toString();
                    if (!TextUtils.isEmpty(string)) {
                        sb.append(v8.i.f15835c);
                        sb.append("controllerConfig");
                        sb.append(v8.i.f15833b);
                        sb.append(string);
                    }
                } catch (JSONException e10) {
                    i9.d().a(e10);
                    IronLog.INTERNAL.error(e10.toString());
                }
            }
            sb.append(v8.i.f15835c);
            sb.append("debug");
            sb.append(v8.i.f15833b);
            sb.append(r());
        }
        return sb.toString();
    }

    private String f(String str) {
        return new m.a(str).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public qf.e g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        qf.e eVar = qf.e.Interstitial;
        if (str.equalsIgnoreCase(eVar.toString())) {
            return eVar;
        }
        qf.e eVar2 = qf.e.RewardedVideo;
        if (str.equalsIgnoreCase(eVar2.toString())) {
            return eVar2;
        }
        qf.e eVar3 = qf.e.Banner;
        if (str.equalsIgnoreCase(eVar3.toString())) {
            return eVar3;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(new Runnable() { // from class: com.ironsource.sdk.controller.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f14895a.j(str);
            }
        });
    }

    private void o(String str) {
        WebSettings settings;
        int i10;
        if (str.equalsIgnoreCase("0")) {
            settings = this.Y.getSettings();
            i10 = 2;
        } else {
            settings = this.Y.getSettings();
            i10 = -1;
        }
        settings.setCacheMode(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        WebView presentingView;
        wp wpVar = new wp(str);
        String strD = wpVar.d("color");
        String strD2 = wpVar.d("adViewId");
        int color = !v8.h.T.equalsIgnoreCase(strD) ? Color.parseColor(strD) : 0;
        if (strD2 != null) {
            presentingView = pf.a().a(strD2).getPresentingView();
            if (presentingView == null) {
                return;
            }
        } else {
            presentingView = this.Y;
        }
        presentingView.setBackgroundColor(color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(String str) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            Logger.d(this.f15153c, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (!str.equalsIgnoreCase(qf.e.Interstitial.toString()) ? !(!str.equalsIgnoreCase(qf.e.RewardedVideo.toString()) ? !str.equalsIgnoreCase(qf.e.Banner.toString()) || this.f15176z == null : this.f15174x == null) : this.f15175y != null) {
            z10 = true;
        }
        if (!z10) {
            Logger.d(this.f15153c, "Trying to trigger a listener - no listener was found for product " + str);
        }
        return z10;
    }

    @Override // com.ironsource.sdk.controller.l
    public void e() {
        a(this.D);
    }

    public boolean h(String str) {
        try {
            if (!new yq(str, dj.e().d(), FeaturesManager.getInstance().getFeatureFlagClickCheck().c()).a()) {
                return false;
            }
            vt.a(q(), str);
            return true;
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return false;
        }
    }

    public void m(String str) {
        try {
            String strD = s8.d(this.X.a());
            Logger.i(this.f15153c, "device status changed, connection type " + str);
            vf.a(str);
            vf.b(strD);
            i(e(v8.g.f15773w, a(v8.i.f15868t, str, v8.i.f15869u, strD, null, null, null, null, null, false)));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("Exception: " + Log.getStackTraceString(e10));
        }
    }

    public void n(String str) {
        this.f15173w = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c(zf zfVar) {
        this.f15158h.a(this);
        if (zfVar == null || !zfVar.exists()) {
            a(new zf(v8.f15655f), new rf(1, "Unable to download Html file"));
            return null;
        }
        a(zfVar);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        try {
            p8 p8Var = this.Q;
            if (p8Var == null) {
                return;
            }
            p8Var.b(context);
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    com.ironsource.sdk.controller.r b(com.ironsource.sdk.controller.s sVar) {
        return new com.ironsource.sdk.controller.r(sVar);
    }

    @Override // com.ironsource.sdk.controller.l
    public void d() {
        i(f(v8.g.f15769s));
    }

    @Override // com.ironsource.sdk.controller.l
    public void f() {
        i(f(v8.g.f15770t));
    }

    private String c(String str, String str2, String str3) {
        return new m.a(str, null, str2, str3).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context) {
        try {
            p8 p8Var = this.Q;
            if (p8Var == null) {
                return;
            }
            p8Var.c(context);
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = v8.c.f15723z;
        }
        i(e(v8.g.Z, a("errMsg", str, "url", str2, null, null, null, null, null, false)));
    }

    public void g(String str, String str2) {
        i(e(v8.g.V, a(v8.h.f15809p, str2, v8.h.f15803m, str, null, null, null, null, null, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m9 a(qf.e eVar) {
        if (eVar == qf.e.Interstitial) {
            return this.f15175y;
        }
        if (eVar == qf.e.RewardedVideo) {
            return this.f15174x;
        }
        if (eVar == qf.e.Banner) {
            return this.f15176z;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] f(String str, String str2) {
        boolean z10;
        JSONObject jSONObject = new JSONObject();
        Map<String, String> mapG = null;
        if (TextUtils.isEmpty(str)) {
            z10 = true;
        } else {
            ha haVarA = this.G.a(g(str), str2);
            if (haVarA != null) {
                mapG = haVarA.g();
                mapG.put("demandSourceName", haVarA.f());
                mapG.put("demandSourceId", haVarA.h());
            }
            try {
                jSONObject.put(v8.h.f15803m, str);
            } catch (JSONException e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
            try {
                Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
                if (initSDKParams != null) {
                    jSONObject = SDKUtils.mergeJSONObjects(jSONObject, new JSONObject(initSDKParams));
                }
            } catch (Exception e11) {
                i9.d().a(e11);
                IronLog.INTERNAL.error(e11.toString());
            }
            z10 = false;
        }
        if (!TextUtils.isEmpty(this.f15157g)) {
            try {
                jSONObject.put(SDKUtils.encodeString(v8.i.f15841f), SDKUtils.encodeString(this.f15157g));
            } catch (JSONException e12) {
                i9.d().a(e12);
                IronLog.INTERNAL.error(e12.toString());
            }
        }
        if (TextUtils.isEmpty(this.f15156f)) {
            z10 = true;
        } else {
            try {
                jSONObject.put(SDKUtils.encodeString(v8.i.f15843g), SDKUtils.encodeString(this.f15156f));
            } catch (JSONException e13) {
                i9.d().a(e13);
                IronLog.INTERNAL.error(e13.toString());
            }
        }
        if (mapG != null && !mapG.isEmpty()) {
            for (Map.Entry<String, String> entry : mapG.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("sdkWebViewCache")) {
                    o(entry.getValue());
                }
                try {
                    jSONObject.put(SDKUtils.encodeString(entry.getKey()), SDKUtils.encodeString(entry.getValue()));
                } catch (JSONException e14) {
                    i9.d().a(e14);
                    IronLog.INTERNAL.error(e14.toString());
                }
            }
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z10)};
    }

    public void e(JSONObject jSONObject) {
        Logger.i(this.f15153c, "device connection info changed: " + jSONObject.toString());
        i(e(v8.g.f15774x, a(v8.i.f15846h0, jSONObject.toString(), null, null, null, null, null, null, null, false)));
    }

    private String b(String str) {
        String str2 = this.A + File.separator;
        return str.contains(str2) ? str.substring(str2.length()) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] d(Context context) {
        boolean z10;
        la laVarB = la.b(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(v8.i.f15874z, "none");
            jSONObject.put(v8.i.A, SDKUtils.translateDeviceOrientation(this.W.E(context)));
            String strD = laVarB.d();
            if (strD != null) {
                jSONObject.put(SDKUtils.encodeString(v8.i.f15851k), SDKUtils.encodeString(strD));
            }
            String strC = laVarB.c();
            if (strC != null) {
                jSONObject.put(SDKUtils.encodeString(v8.i.f15853l), SDKUtils.encodeString(strC));
                z10 = false;
            } else {
                z10 = true;
            }
            try {
                SDKUtils.loadGoogleAdvertiserInfo(context);
                String advertiserId = SDKUtils.getAdvertiserId();
                if (!TextUtils.isEmpty(advertiserId)) {
                    Logger.i(this.f15153c, "add AID");
                    jSONObject.put("deviceIds" + v8.i.f15837d + v8.i.L + v8.i.f15839e, SDKUtils.encodeString(advertiserId));
                }
                String limitAdTracking = SDKUtils.getLimitAdTracking();
                if (!TextUtils.isEmpty(limitAdTracking)) {
                    Logger.i(this.f15153c, "add LAT");
                    jSONObject.put(v8.i.M, Boolean.parseBoolean(limitAdTracking));
                }
                String strE = laVarB.e();
                if (strE != null) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.f15855m), SDKUtils.encodeString(strE));
                } else {
                    z10 = true;
                }
                String strF = laVarB.f();
                if (strF != null) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.f15857n), strF.replaceAll("[^0-9/.]", ""));
                } else {
                    z10 = true;
                }
                String strF2 = laVarB.f();
                if (strF2 != null) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.f15859o), SDKUtils.encodeString(strF2));
                }
                String strValueOf = String.valueOf(laVarB.a());
                if (strValueOf != null) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.f15861p), strValueOf);
                } else {
                    z10 = true;
                }
                jSONObject.put(ad.Y, String.valueOf(g1.a()));
                String sDKVersion = SDKUtils.getSDKVersion();
                if (sDKVersion != null) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.f15863q), SDKUtils.encodeString(sDKVersion));
                }
                if (laVarB.b() != null && laVarB.b().length() > 0) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.f15865r), SDKUtils.encodeString(laVarB.b()));
                }
                String strB = s8.b(context);
                if (strB.equals("none")) {
                    z10 = true;
                } else {
                    jSONObject.put(SDKUtils.encodeString(v8.i.f15868t), SDKUtils.encodeString(strB));
                }
                String strD2 = s8.d(context);
                if (strD2 != null) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.f15869u), SDKUtils.encodeString(strD2));
                } else {
                    z10 = true;
                }
                jSONObject.put(SDKUtils.encodeString(v8.i.f15870v), s8.e(context));
                jSONObject.put("uxt", IronSourceStorageUtils.isUxt());
                String language = context.getResources().getConfiguration().locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.f15872x), SDKUtils.encodeString(language.toUpperCase(Locale.getDefault())));
                }
                jSONObject.put(v8.i.f15873y, SDKUtils.encodeString(String.valueOf(this.W.a(this.A))));
                String strValueOf2 = String.valueOf(this.W.r());
                if (TextUtils.isEmpty(strValueOf2)) {
                    z10 = true;
                } else {
                    jSONObject.put(SDKUtils.encodeString(v8.i.G) + v8.i.f15837d + SDKUtils.encodeString("width") + v8.i.f15839e, SDKUtils.encodeString(strValueOf2));
                }
                jSONObject.put(SDKUtils.encodeString(v8.i.G) + v8.i.f15837d + SDKUtils.encodeString("height") + v8.i.f15839e, SDKUtils.encodeString(String.valueOf(this.W.a())));
                String strG = v3.g(this.Y.getContext());
                if (!TextUtils.isEmpty(strG)) {
                    jSONObject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(strG));
                }
                String strValueOf3 = String.valueOf(this.W.h());
                if (!TextUtils.isEmpty(strValueOf3)) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.K), SDKUtils.encodeString(strValueOf3));
                }
                String strValueOf4 = String.valueOf(this.W.f());
                if (!TextUtils.isEmpty(strValueOf4)) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.O), SDKUtils.encodeString(strValueOf4));
                }
                jSONObject.put(SDKUtils.encodeString(v8.i.P), la.b(context).a(context));
                jSONObject.put(SDKUtils.encodeString(v8.i.Y), this.W.w(context));
                jSONObject.put(SDKUtils.encodeString("mcc"), r8.b(context));
                jSONObject.put(SDKUtils.encodeString("mnc"), r8.c(context));
                jSONObject.put(SDKUtils.encodeString(v8.i.S), r8.f(context));
                jSONObject.put(SDKUtils.encodeString(v8.i.R), SDKUtils.encodeString(r8.g(context)));
                jSONObject.put(SDKUtils.encodeString(v8.i.V), v3.f(context));
                jSONObject.put(SDKUtils.encodeString(v8.i.X), v3.d(context));
                jSONObject.put(SDKUtils.encodeString(v8.i.W), SDKUtils.encodeString(v3.b(context)));
                String strE2 = v3.e(context);
                if (!TextUtils.isEmpty(strE2)) {
                    jSONObject.put(SDKUtils.encodeString(v8.i.f15836c0), SDKUtils.encodeString(strE2));
                }
                c(jSONObject);
                jSONObject.put(SDKUtils.encodeString(v8.i.f15862p0), this.W.z(context));
            } catch (JSONException e10) {
                e = e10;
                i9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        } catch (JSONException e11) {
            e = e11;
            z10 = false;
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z10)};
    }

    void c(Runnable runnable) {
        ve veVar = this.f15151a;
        if (veVar != null) {
            veVar.d(runnable);
        }
    }

    private String b(String str, String str2) {
        return a(str, str2, "errMsg");
    }

    com.ironsource.sdk.controller.g a(com.ironsource.sdk.controller.s sVar) {
        return new com.ironsource.sdk.controller.g(new com.ironsource.sdk.controller.b(new r()), sVar);
    }

    public void c(String str) {
        if (str.equals(v8.h.f15795i)) {
            o();
        }
        i(e(v8.g.f15775y, a("action", str, null, null, null, null, null, null, null, false)));
    }

    public void b(int i10) {
        f15145b0 = i10;
    }

    public void c(String str, String str2) {
        try {
            i(e(v8.g.f15765o, a(v8.h.f15781b, str, "path", b(str2), null, null, null, null, null, false)));
        } catch (Exception e10) {
            i9.d().a(e10);
            b(str, str2, e10.getMessage());
        }
    }

    private t a(qf.e eVar, ha haVar) {
        t tVar = new t();
        if (eVar == qf.e.RewardedVideo || eVar == qf.e.Interstitial || eVar == qf.e.Banner) {
            HashMap map = new HashMap();
            map.put(v8.i.f15843g, this.f15156f);
            if (!TextUtils.isEmpty(this.f15157g)) {
                map.put(v8.i.f15841f, this.f15157g);
            }
            if (haVar != null) {
                if (haVar.g() != null) {
                    map.putAll(haVar.g());
                    map.put(v8.h.f15828y0, String.valueOf(i0.f12521a.c(haVar.h())));
                }
                map.put("demandSourceName", haVar.f());
                map.put("demandSourceId", haVar.h());
            }
            String strFlatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(map);
            v8.g gVarA = v8.g.a(eVar);
            String strA = a(gVarA.f15777a, strFlatMapToJsonAsString, gVarA.f15778b, gVarA.f15779c);
            tVar.f15268a = gVarA.f15777a;
            tVar.f15269b = strA;
        }
        return tVar;
    }

    private void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put(SDKUtils.encodeString("gpi"), un.d(this.Y.getContext()));
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Context context) {
        a(new c(context));
    }

    private String a(qf.e eVar, JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("sessionDepth", Integer.toString(jSONObject.optInt("sessionDepth")));
        String strOptString = jSONObject.optString("demandSourceName");
        String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(jSONObject);
        ha haVarA = this.G.a(eVar, strFetchDemandSourceId);
        if (haVarA != null) {
            if (haVarA.g() != null) {
                map.putAll(haVarA.g());
            }
            if (!TextUtils.isEmpty(strOptString)) {
                map.put("demandSourceName", strOptString);
            }
            if (!TextUtils.isEmpty(strFetchDemandSourceId)) {
                map.put("demandSourceId", strFetchDemandSourceId);
            }
        }
        String strFlatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(map);
        v8.g gVarB = v8.g.b(eVar);
        return a(gVarB.f15777a, strFlatMapToJsonAsString, gVarB.f15778b, gVarB.f15779c);
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(ha haVar) {
        Map<String, String> mapB = haVar.b();
        if (mapB != null) {
            i(e(v8.g.S, SDKUtils.flatMapToJsonAsString(mapB)));
        }
        this.G.b(qf.e.Interstitial, haVar.h());
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(ha haVar, Map<String, String> map, o9 o9Var) {
        a(haVar, map);
    }

    void b(Runnable runnable) {
        ve veVar = this.f15151a;
        if (veVar != null) {
            veVar.c(runnable);
        }
    }

    private String a(String str, String str2) {
        return a(str, str2, v8.h.f15791g);
    }

    public void b(String str, String str2, String str3) {
        try {
            i(e(v8.g.f15766p, a(v8.h.f15781b, str, "path", b(str2), "errMsg", str3, null, null, null, false)));
        } catch (Exception e10) {
            i9.d().a(e10);
        }
    }

    private String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            return new JSONObject(str).put(str3, str2).toString();
        } catch (JSONException e10) {
            i9.d().a(e10);
            return str;
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(JSONObject jSONObject) {
        i(e(v8.g.f15754d0, jSONObject != null ? jSONObject.toString() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, String str3, String str4) {
        return new m.a(str, str2, str3, str4).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                jSONObject.put(str, SDKUtils.encodeString(str2));
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                jSONObject.put(str3, SDKUtils.encodeString(str4));
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                jSONObject.put(str5, SDKUtils.encodeString(str6));
            }
            if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                jSONObject.put(str7, SDKUtils.encodeString(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put(str9, z10);
            }
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        return jSONObject.toString();
    }

    @Override // com.ironsource.sdk.controller.l
    public void a() {
        if (this.V) {
            this.U.a();
            return;
        }
        this.B.a(new sf());
        if (this.B.k()) {
            a(1);
        }
    }

    public void a(int i10) {
        if (!this.V && !this.B.m()) {
            Logger.i(this.f15153c, "load(): Mobile Controller HTML Does not exist");
            return;
        }
        JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
        String strD = d(controllerConfigAsJSONObject);
        Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
        if (initSDKParams != null && initSDKParams.containsKey("sessionid")) {
            strD = String.format("%s&sessionid=%s", strD, initSDKParams.get("sessionid"));
        }
        this.f15151a.d(new h(controllerConfigAsJSONObject, this.Y, (this.V ? this.U.b() : this.B.g()).toURI().toString() + "?" + strD));
        this.f15163m = new i(50000L, 1000L, i10).start();
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Activity activity) {
        this.X.a(activity);
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Context context) {
        a(new d(context));
    }

    private void a(Context context, WebView webView) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f15171u = new FrameLayout(context);
        this.f15169s = new FrameLayout(context);
        this.f15169s.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f15169s.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(webView);
        this.f15171u.addView(this.f15169s, layoutParams);
        this.f15171u.addView(frameLayout);
    }

    @SuppressLint({"NewApi"})
    private void a(WebSettings webSettings) {
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    @SuppressLint({"AddJavascriptInterface"})
    private void a(WebView webView) {
        com.ironsource.sdk.controller.s sVar = new com.ironsource.sdk.controller.s(com.ironsource.sdk.controller.s.a());
        webView.addJavascriptInterface(a(sVar), v8.f15653d);
        webView.addJavascriptInterface(b(sVar), v8.f15654e);
    }

    public void a(cu cuVar) {
        this.C = cuVar;
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(ha haVar) {
        Map<String, String> mapB = haVar.b();
        if (mapB != null) {
            i(a(v8.g.R, SDKUtils.flatMapToJsonAsString(mapB), v8.g.O, v8.g.P));
        }
        this.G.b(qf.e.Banner, haVar.h());
    }

    private void a(ha haVar, Map<String, String> map) {
        Map<String, String> mapMergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, haVar.b()});
        if (map.containsKey("adm")) {
            this.f15152b.a(new b9.d() { // from class: com.ironsource.sdk.controller.c0
                @Override // com.ironsource.b9.d
                public final void a(md mdVar) {
                    this.f14900a.a(mdVar);
                }
            });
        }
        this.D.d(haVar.h(), true);
        i(a(v8.g.D, SDKUtils.flatMapToJsonAsString(mapMergeHashMaps), v8.g.E, v8.g.F));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(ha haVar, Map<String, String> map, n9 n9Var) {
        Map<String, String> mapMergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, haVar.b()});
        if (map != null) {
            i(a(v8.g.M, SDKUtils.flatMapToJsonAsString(mapMergeHashMaps), v8.g.N, v8.g.Q));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(ha haVar, Map<String, String> map, o9 o9Var) {
        i(a(qf.e.Interstitial, new JSONObject(SDKUtils.mergeHashMaps(new Map[]{map, haVar.b()}))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(jd jdVar) {
        try {
            this.P.a(jdVar);
        } catch (Exception e10) {
            i9.d().a(e10);
            Logger.e(this.f15153c, "handleLoadAd: " + e10);
        }
    }

    public void a(kn knVar) {
        this.Z = knVar;
        this.Y.a(knVar);
    }

    public void a(l3 l3Var) {
        this.N = l3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(md mdVar) {
        mdVar.a(new nd() { // from class: com.ironsource.sdk.controller.b0
            @Override // com.ironsource.nd
            public final void a(jd jdVar) {
                this.f14899a.a(jdVar);
            }
        });
    }

    void a(qf.e eVar, String str) {
        b(new e(eVar, str));
    }

    public void a(com.ironsource.sdk.controller.a aVar) {
        this.L = aVar;
        aVar.a(p());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(f.c cVar, l.a aVar) {
        i(a(cVar.e(), cVar.h(), v8.g.T, v8.g.T));
    }

    public void a(com.ironsource.sdk.controller.i iVar) {
        this.K = iVar;
    }

    public void a(com.ironsource.sdk.controller.j jVar) {
        this.M = jVar;
    }

    public void a(com.ironsource.sdk.controller.o oVar) {
        this.H = oVar;
    }

    public void a(com.ironsource.sdk.controller.q qVar) {
        this.I = qVar;
    }

    public void a(com.ironsource.sdk.controller.u uVar) {
        this.J = uVar;
    }

    public void a(u uVar) {
        this.f15172v = uVar;
    }

    public void a(t2 t2Var) {
        String strB;
        m9 m9VarA;
        synchronized (this.E) {
            if (t2Var.j() && this.f15159i) {
                Log.d(this.f15153c, "restoreState(state:" + t2Var + ")");
                int iC = t2Var.c();
                if (iC != -1) {
                    qf.e eVar = qf.e.RewardedVideo;
                    if (iC == eVar.ordinal()) {
                        Log.d(this.f15153c, "onRVAdClosed()");
                        strB = t2Var.b();
                        m9VarA = a(eVar);
                        if (m9VarA != null && !TextUtils.isEmpty(strB)) {
                            m9VarA.a(eVar, strB);
                        }
                        t2Var.a(-1);
                        t2Var.f(null);
                    } else {
                        eVar = qf.e.Interstitial;
                        if (iC == eVar.ordinal()) {
                            Log.d(this.f15153c, "onInterstitialAdClosed()");
                            strB = t2Var.b();
                            m9VarA = a(eVar);
                            if (m9VarA != null && !TextUtils.isEmpty(strB)) {
                                m9VarA.a(eVar, strB);
                            }
                        }
                        t2Var.a(-1);
                        t2Var.f(null);
                    }
                }
                Log.d(this.f15153c, "No ad was opened");
                String strD = t2Var.d();
                String strF = t2Var.f();
                for (ha haVar : this.G.a(qf.e.Interstitial)) {
                    if (haVar.e() == 2) {
                        Log.d(this.f15153c, "initInterstitial(appKey:" + strD + ", userId:" + strF + ", demandSource:" + haVar.f() + ")");
                        a(strD, strF, haVar, this.f15175y);
                    }
                }
                String strG = t2Var.g();
                String strH = t2Var.h();
                for (ha haVar2 : this.G.a(qf.e.RewardedVideo)) {
                    if (haVar2.e() == 2) {
                        String strF2 = haVar2.f();
                        Log.d(this.f15153c, "onRVNoMoreOffers()");
                        this.f15174x.c(strF2);
                        Log.d(this.f15153c, "initRewardedVideo(appKey:" + strG + ", userId:" + strH + ", demandSource:" + strF2 + ")");
                        a(strG, strH, haVar2, this.f15174x);
                    }
                }
                t2Var.a(false);
            }
            this.D = t2Var;
        }
    }

    @Override // com.ironsource.hn
    public void a(zf zfVar) {
        if (this.V && this.U.a(zfVar)) {
            a(1);
        } else if (zfVar.getName().contains(v8.f15655f)) {
            this.B.a(new n());
        } else {
            c(zfVar.getName(), zfVar.getParent());
        }
    }

    @Override // com.ironsource.hn
    public void a(zf zfVar, rf rfVar) {
        if (!this.V || !this.U.a(zfVar)) {
            if (zfVar.getName().contains(v8.f15655f)) {
                this.B.a(new a(), new b(rfVar));
                return;
            } else {
                b(zfVar.getName(), zfVar.getParent(), rfVar.b());
                return;
            }
        }
        this.P.b("controller html - failed to download - " + rfVar.b());
    }

    void a(Runnable runnable) {
        ve veVar = this.f15151a;
        if (veVar != null) {
            veVar.b(runnable);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, o9 o9Var) {
        HashMap map = new HashMap();
        map.put("demandSourceName", str);
        String strFlatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(map);
        this.D.d(str, true);
        i(a(v8.g.D, strFlatMapToJsonAsString, v8.g.E, v8.g.F));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, qf.e eVar, ha haVar) {
        if (q(eVar.toString())) {
            b(new m(eVar, haVar, str));
        }
    }

    private void a(String str, qf.e eVar, ha haVar, s sVar) {
        if (TextUtils.isEmpty(str)) {
            sVar.a("Application key are missing", eVar, haVar);
        } else {
            i(a(eVar, haVar).f15269b);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, ha haVar, n9 n9Var) {
        this.f15156f = str;
        this.f15157g = str2;
        this.f15176z = n9Var;
        a(str, qf.e.Banner, haVar, new l());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, ha haVar, o9 o9Var) {
        this.f15156f = str;
        this.f15157g = str2;
        this.f15175y = o9Var;
        this.D.g(str);
        this.D.h(this.f15157g);
        a(this.f15156f, qf.e.Interstitial, haVar, new k());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, ha haVar, p9 p9Var) {
        this.f15156f = str;
        this.f15157g = str2;
        this.f15174x = p9Var;
        this.D.i(str);
        this.D.j(str2);
        a(str, qf.e.RewardedVideo, haVar, new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z10, String str2, String str3) {
        String strD = new wp(str).d(z10 ? f15149f0 : f15150g0);
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        i(e(strD, a(b(str, str2), str3)));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.R = jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, WebView webView) {
        boolean zOptBoolean = jSONObject.optBoolean("inspectWebview");
        if (zOptBoolean) {
            WebView.setWebContentsDebuggingEnabled(zOptBoolean);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, n9 n9Var) {
        i(a(v8.g.M, jSONObject.toString(), v8.g.N, v8.g.Q));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, o9 o9Var) {
        i(a(qf.e.Interstitial, jSONObject));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, p9 p9Var) {
        i(a(qf.e.RewardedVideo, jSONObject));
    }

    public void a(boolean z10, String str) {
        i(e(v8.g.U, a(v8.h.K, str, null, null, null, null, null, null, v8.h.f15807o, z10)));
    }

    @Override // com.ironsource.sdk.controller.l
    public boolean a(String str) {
        ha haVarA = this.G.a(qf.e.Interstitial, str);
        return haVarA != null && haVarA.d();
    }
}
