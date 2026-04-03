package com.king.amp.sa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.webkit.ProxyConfig;
import com.king.amp.sa.r;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: AbmHtmlFragment.java */
/* JADX INFO: loaded from: classes4.dex */
public class s extends r0 implements r.a, h1 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private k6.d f16927p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Context f16928q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AbmWebView f16929r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private r f16930s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f16931t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f16932u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f16933v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f16934w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f16935x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f16936y = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Timer f16937z;

    /* JADX INFO: compiled from: AbmHtmlFragment.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.L();
        }
    }

    /* JADX INFO: compiled from: AbmHtmlFragment.java */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Integer numG;
            s sVar = s.this;
            if (sVar.f16878b == null || (numG = sVar.G((String) sVar.s(sVar.f16879c, "ad_index", ""))) == null) {
                return;
            }
            s.this.f16878b.onPlayerContentPreloadCompleted(numG.intValue(), 6, "Webview loading timeout");
        }
    }

    public s() {
    }

    private String K(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder("<script>\n");
        try {
            Scanner scannerUseDelimiter = new Scanner(this.f16928q.getResources().openRawResource(j6.h.f28752a), "UTF-8").useDelimiter("\\A");
            if (scannerUseDelimiter.hasNext()) {
                sb.append(scannerUseDelimiter.next());
            }
            scannerUseDelimiter.close();
        } catch (Exception e10) {
            t1.e("AbmHtmlFragment", "Unable to read resource :" + e10.toString());
            w(3, "Interactive ad error: can't load media from device.");
        }
        sb.append("\n</script>\n");
        return ((Object) sb) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (TextUtils.isEmpty(this.f16932u)) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f16932u = arguments.getString("interactive_data");
            }
            if (TextUtils.isEmpty(this.f16932u)) {
                Log.e("AbmHtmlFragment", "Interactive ad error: media data is empty.");
                AbmAdPlayer abmAdPlayer = this.f16878b;
                if (abmAdPlayer != null) {
                    abmAdPlayer.onPlayerDismissed(6, "Empty content ");
                    return;
                }
                return;
            }
        }
        if (this.f16937z != null) {
            W();
        }
        V();
        this.f16933v = System.currentTimeMillis();
        if (this.f16929r == null) {
            Log.d("AbmHtmlFragment", "Create Webview");
            this.f16929r = new AbmWebView(this.f16928q);
        }
        this.f16930s = new r(this.f16928q, this.f16929r, this);
        T();
        if (this.f16932u.startsWith(ProxyConfig.MATCH_HTTP)) {
            this.f16929r.loadUrl(this.f16932u);
        } else {
            this.f16929r.loadDataWithBaseURL(AndroidWebViewClient.BLANK_PAGE, this.f16932u, "text/html", "UTF-8", null);
        }
    }

    public static s M(@NonNull Map<String, String> map, long j10) {
        s sVar = new s();
        Bundle bundle = new Bundle();
        bundle.putSerializable("custom_map", new HashMap(map));
        bundle.putSerializable("player_id", Long.valueOf(j10));
        sVar.setArguments(bundle);
        return sVar;
    }

    private void N() {
        Log.d("AbmHtmlFragment", "pauseHtml called");
        if (this.f16934w) {
            r rVar = this.f16930s;
            if (rVar != null) {
                rVar.r(false);
            }
            AbmWebView abmWebView = this.f16929r;
            if (abmWebView != null) {
                abmWebView.onPause();
            }
            B();
        }
    }

    private void P() {
        Integer numG;
        Integer numG2;
        Log.d("AbmHtmlFragment", "prepareData called for webview");
        String str = (String) s(this.f16879c, "content_file_path", "");
        this.f16931t = str;
        if (TextUtils.isEmpty(str)) {
            Log.e("AbmHtmlFragment", "Interactive ad error: media path is empty.");
            if (this.f16878b == null || (numG2 = G((String) s(this.f16879c, "ad_index", ""))) == null) {
                return;
            }
            this.f16878b.onPlayerContentPreloadCompleted(numG2.intValue(), 3, "Interactive ad error: media config is empty.");
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(this.f16931t));
            byte[] bArr = new byte[fileInputStream.available()];
            if (fileInputStream.read(bArr) != -1) {
                this.f16932u = K(new String(bArr));
                Bundle bundle = getArguments() == null ? new Bundle() : getArguments();
                bundle.putString("interactive_data", this.f16932u);
                setArguments(bundle);
            }
        } catch (Exception e10) {
            Log.e("AbmHtmlFragment", "Interactive Ad Error: Unable to read resource : ", e10);
            if (this.f16878b == null || (numG = G((String) s(this.f16879c, "ad_index", ""))) == null) {
                return;
            }
            this.f16878b.onPlayerContentPreloadCompleted(numG.intValue(), 3, "Interactive ad error: can't load media from device.");
        }
    }

    private void Q() {
        Log.d("AbmHtmlFragment", "resumeHtml called");
        if (!this.f16934w) {
            if (this.f16935x) {
                Log.d("AbmHtmlFragment", "startAdDisplay from resumeHtml");
                U();
                return;
            }
            return;
        }
        r rVar = this.f16930s;
        if (rVar != null) {
            rVar.r(true);
        }
        AbmWebView abmWebView = this.f16929r;
        if (abmWebView != null) {
            abmWebView.resumeTimers();
            this.f16929r.onResume();
        }
        E();
    }

    private void R() {
        r rVar = this.f16930s;
        if (rVar == null) {
            Log.d("AbmHtmlFragment", "setMraidProperties called on null web view");
            return;
        }
        rVar.m();
        this.f16930s.p();
        S();
        this.f16930s.q(r.b.DEFAULT);
        this.f16930s.r(true);
        this.f16930s.d();
    }

    private void S() {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) ((getResources().getDisplayMetrics().widthPixels / f10) + 0.5f);
        int i11 = (int) ((getResources().getDisplayMetrics().heightPixels / f10) + 0.5f);
        this.f16930s.n(i10, i11);
        this.f16930s.l(i10, i11);
        this.f16929r.getLocationOnScreen(new int[2]);
        int width = this.f16929r.getWidth();
        int height = this.f16929r.getHeight();
        Rect rect = new Rect();
        rect.set((int) ((r1[0] / f10) + 0.5f), (int) ((r1[1] / f10) + 0.5f), (int) ((width / f10) + 0.5f), (int) ((height / f10) + 0.5f));
        this.f16930s.j(rect);
        this.f16930s.k(rect);
        this.f16930s.o(rect);
    }

    private void U() {
        n nVar;
        synchronized (this) {
            if (!this.f16934w) {
                if (!this.f16882f && (nVar = this.f16880d) != null) {
                    nVar.r();
                }
                R();
                this.f16934w = true;
            }
        }
    }

    private void V() {
        int i10 = Integer.parseInt((String) s(this.f16879c, "webview_loading_timeout", "5"));
        int i11 = i10 == 0 ? 5000 : i10 * 1000;
        Timer timer = new Timer();
        this.f16937z = timer;
        timer.schedule(new b(), i11);
    }

    private void W() {
        Timer timer = this.f16937z;
        if (timer != null) {
            timer.cancel();
            this.f16937z = null;
        }
    }

    public void J(String str) {
        AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
        adProviderNameValuePairs.add("url", str);
        z("open_url", s1.d(adProviderNameValuePairs));
    }

    public void O() {
        new Handler(Looper.getMainLooper()).post(new a());
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void T() {
        AbmWebView abmWebView = this.f16929r;
        if (abmWebView == null) {
            Log.d("AbmHtmlFragment", "setup Webview called on null web view");
            return;
        }
        WebSettings settings = abmWebView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBuiltInZoomControls(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(false);
        settings.setSaveFormData(false);
        settings.setDatabaseEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.acceptCookie();
            cookieManager.setAcceptThirdPartyCookies(this.f16929r, true);
        }
        this.f16929r.setScrollContainer(false);
        this.f16929r.setLayerType(2, null);
        this.f16929r.setHorizontalScrollBarEnabled(false);
        this.f16929r.setVerticalScrollBarEnabled(false);
        this.f16929r.setBackgroundColor(0);
        this.f16929r.setScrollBarStyle(0);
        this.f16929r.setWebViewClient(new m0(this));
        this.f16929r.onResume();
    }

    @Override // com.king.amp.sa.r.a
    public void a(String str) {
        Log.d("AbmHtmlFragment", "onCtaClick called with URL: " + str);
        J(str);
    }

    @Override // com.king.amp.sa.h1
    public void b(WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        String str = "The webview received error: " + webResourceError.toString();
        if (this.f16878b != null) {
            Integer numG = G((String) s(this.f16879c, "ad_index", ""));
            if (numG != null) {
                this.f16878b.onPlayerContentPreloadCompleted(numG.intValue(), 6, str);
            } else {
                Log.w("AbmHtmlFragment", "onReceivedSslError: ad_index is null");
            }
        }
    }

    @Override // com.king.amp.sa.r.a
    public void c(String str) {
        Log.d("AbmHtmlFragment", "onOpen called with URL: " + str);
        J(str);
    }

    @Override // com.king.amp.sa.r.a
    public void d(String str) {
        Log.d("AbmHtmlFragment", "onEngagementEvent called with: " + str);
        AdProviderNameValuePairs adProviderNameValuePairs = new AdProviderNameValuePairs();
        adProviderNameValuePairs.add(NotificationCompat.CATEGORY_EVENT, str);
        if (this.f16882f) {
            return;
        }
        z(AbmAdPlayer.USER_ACTION_ENGAGEMENT, s1.d(adProviderNameValuePairs));
    }

    @Override // com.king.amp.sa.h1
    public boolean e(RenderProcessGoneDetail renderProcessGoneDetail) {
        String string = "The webview progress was gone";
        if (Build.VERSION.SDK_INT >= 26) {
            StringBuilder sb = new StringBuilder();
            sb.append("The webview progress was gone");
            sb.append(renderProcessGoneDetail.didCrash() ? ", it's crashed" : ", it's killed by system: ");
            string = sb.toString();
        }
        if (this.f16878b == null) {
            return true;
        }
        Integer numG = G((String) s(this.f16879c, "ad_index", ""));
        if (numG != null) {
            this.f16878b.onPlayerContentPreloadCompleted(numG.intValue(), 6, string);
            return true;
        }
        Log.w("AbmHtmlFragment", "onRenderProcessGone: ad_index is null");
        return true;
    }

    @Override // com.king.amp.sa.r.a
    public void f(String str) {
        Log.d("AbmHtmlFragment", "onCriticalError called with: " + str);
        w(6, str);
    }

    @Override // com.king.amp.sa.h1
    public WebResourceResponse g(Uri uri) {
        return this.f16930s.g(uri);
    }

    @Override // com.king.amp.sa.h1
    public void h(int i10, String str, String str2) {
        String str3 = "The webview received error: " + i10 + " :" + str + " from: " + str2;
        if (this.f16878b != null) {
            Integer numG = G((String) s(this.f16879c, "ad_index", ""));
            if (numG != null) {
                this.f16878b.onPlayerContentPreloadCompleted(numG.intValue(), 6, str3);
            } else {
                Log.w("AbmHtmlFragment", "onReceivedError: ad_index is null");
            }
        }
    }

    @Override // com.king.amp.sa.h1
    public void i(SslErrorHandler sslErrorHandler, SslError sslError) {
        String str = "The webview received ssl error: " + sslError.toString();
        if (this.f16878b != null) {
            Integer numG = G((String) s(this.f16879c, "ad_index", ""));
            if (numG != null) {
                this.f16878b.onPlayerContentPreloadCompleted(numG.intValue(), 6, str);
            } else {
                Log.w("AbmHtmlFragment", "onReceivedSslError: ad_index is null");
            }
        }
    }

    @Override // com.king.amp.sa.h1
    public void j(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        String str = "Http Error on interactive ad with code: " + webResourceResponse.getStatusCode();
        if (this.f16878b != null) {
            Integer numG = G((String) s(this.f16879c, "ad_index", ""));
            if (numG != null) {
                this.f16878b.onPlayerContentPreloadCompleted(numG.intValue(), 6, str);
            } else {
                Log.w("AbmHtmlFragment", "onReceivedHttpError: ad_index is null");
            }
        }
    }

    @Override // com.king.amp.sa.h1
    public boolean k(Uri uri) {
        return this.f16930s.h(uri);
    }

    @Override // com.king.amp.sa.h1
    public void l(String str, @Nullable Bitmap bitmap) {
        Log.i("AbmHtmlFragment", "Handle page started event for " + str + ", in " + (System.currentTimeMillis() - this.f16933v) + " ms");
    }

    @Override // com.king.amp.sa.r.a
    public void m() {
        Log.d("AbmHtmlFragment", "onReward called");
        if (this.f16882f) {
            return;
        }
        z(AbmAdPlayer.USER_ACTION_REWARD, s1.a());
    }

    @Override // com.king.amp.sa.h1
    public void n(String str) {
        Log.i("AbmHtmlFragment", "Handle page finished event for " + str + ", in " + (System.currentTimeMillis() - this.f16933v) + " ms");
        W();
        if (this.f16878b != null) {
            Integer numG = G((String) s(this.f16879c, "ad_index", ""));
            if (numG != null) {
                this.f16878b.onPlayerContentPreloadCompleted(numG.intValue(), 0, "");
            } else {
                Log.w("AbmHtmlFragment", "onPageFinished: ad_index is null");
            }
        }
        r rVar = this.f16930s;
        if (rVar != null) {
            rVar.f(str);
        }
        Log.i("AbmHtmlFragment", "Handle page finished with mIsOnTop " + this.f16885i + " mHasWindowFocus " + this.f16936y);
        AbmWebView abmWebView = this.f16929r;
        if (abmWebView == null || abmWebView.getProgress() != 100) {
            return;
        }
        this.f16935x = true;
        if (this.f16885i && this.f16936y) {
            U();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.f16928q = context;
    }

    @Override // com.king.amp.sa.r.a
    public void onClose() {
        Log.d("AbmHtmlFragment", "onClose called");
        z("close", s1.a());
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        S();
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getActivity().setRequestedOrientation(1);
        this.f16882f = Boolean.parseBoolean((String) s(this.f16879c, "is_end_card", "false"));
        this.f16884h = false;
        if (this.f16932u == null) {
            P();
        }
    }

    @Override // com.king.amp.sa.r0, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f16936y = true;
        k6.d dVarC = k6.d.c(layoutInflater, viewGroup, false);
        this.f16927p = dVarC;
        AbmWebView abmWebView = this.f16929r;
        if (abmWebView == null) {
            this.f16929r = dVarC.f29704c;
            L();
        } else {
            if (abmWebView.getParent() != null) {
                ((ViewGroup) this.f16929r.getParent()).removeView(this.f16929r);
            }
            this.f16927p.f29703b.addView(this.f16929r, (ConstraintLayout.LayoutParams) this.f16927p.f29704c.getLayoutParams());
            Q();
        }
        return this.f16927p.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AbmWebView abmWebView = this.f16929r;
        if (abmWebView != null) {
            abmWebView.destroy();
            this.f16930s = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        N();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Q();
    }

    @Override // com.king.amp.sa.r0, android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z10) {
        Log.d("AbmHtmlFragment", "onWindowFocusChanged called with " + z10);
        super.onWindowFocusChanged(z10);
        this.f16936y = z10;
        if (this.f16885i) {
            if (z10) {
                Q();
            } else {
                N();
            }
        }
    }

    @Override // com.king.amp.sa.r0
    public String p() {
        return AbmAdPlayer.HTML;
    }

    @Override // com.king.amp.sa.r0
    String r() {
        return "AbmHtmlFragment";
    }

    @Override // com.king.amp.sa.r0
    public void u() {
        super.u();
        this.f16936y = false;
    }

    @Override // com.king.amp.sa.r0
    public void v() {
        super.v();
        this.f16936y = true;
    }

    public s(@NonNull Map<String, String> map, AbmAdPlayer abmAdPlayer, Context context) {
        this.f16879c = map;
        this.f16878b = abmAdPlayer;
        this.f16928q = context;
        Bundle bundle = new Bundle();
        bundle.putSerializable("custom_map", new HashMap(map));
        bundle.putLong("player_id", abmAdPlayer.getPlayerId());
        setArguments(bundle);
        P();
    }
}
