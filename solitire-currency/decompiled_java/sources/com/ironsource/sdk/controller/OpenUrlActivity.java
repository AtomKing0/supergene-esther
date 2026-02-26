package com.ironsource.sdk.controller;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.dj;
import com.ironsource.i8;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.qi;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.v8;
import com.ironsource.vt;
import com.ironsource.yq;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class OpenUrlActivity extends Activity {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f14850j = "OpenUrlActivity";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f14851k = SDKUtils.generateViewId();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f14852l = SDKUtils.generateViewId();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v f14854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ProgressBar f14855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f14856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RelativeLayout f14857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14858f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f14853a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler f14859g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14860h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f14861i = new b();

    class a implements View.OnSystemUiVisibilityChangeListener {
        a() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            if ((i10 & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                OpenUrlActivity.this.f14859g.removeCallbacks(OpenUrlActivity.this.f14861i);
                OpenUrlActivity.this.f14859g.postDelayed(OpenUrlActivity.this.f14861i, 500L);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OpenUrlActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(OpenUrlActivity.this.f14860h));
        }
    }

    private class c extends WebViewClient {
        private c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            OpenUrlActivity.this.f14855c.setVisibility(4);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            OpenUrlActivity.this.f14855c.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            try {
                i8 featureFlagCatchUrlError = FeaturesManager.getInstance().getFeatureFlagCatchUrlError();
                if (featureFlagCatchUrlError.c()) {
                    if (featureFlagCatchUrlError.e() && OpenUrlActivity.this.f14854b != null) {
                        OpenUrlActivity.this.f14854b.d(str, str2);
                    }
                    if (featureFlagCatchUrlError.d()) {
                        OpenUrlActivity.this.finish();
                    }
                }
            } catch (Throwable th) {
                i9.d().a(th);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(OpenUrlActivity.f14850j, "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            OpenUrlActivity.this.finish();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!new yq(str, dj.e().d(), FeaturesManager.getInstance().getFeatureFlagClickCheck().c()).a()) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                vt.a(OpenUrlActivity.this, str);
                OpenUrlActivity.this.f14854b.z();
            } catch (Exception e10) {
                i9.d().a(e10);
                StringBuilder sb = new StringBuilder();
                sb.append(e10 instanceof ActivityNotFoundException ? v8.c.f15721x : v8.c.f15722y);
                if (OpenUrlActivity.this.f14854b != null) {
                    OpenUrlActivity.this.f14854b.d(sb.toString(), str);
                }
            }
            OpenUrlActivity.this.finish();
            return true;
        }

        /* synthetic */ c(OpenUrlActivity openUrlActivity, a aVar) {
            this();
        }
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final String f14865a = "is_store";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final String f14866b = "external_url";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final String f14867c = "secondary_web_view";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final String f14868d = "immersive";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final String f14869e = "no activity to handle url";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final String f14870f = "activity failed to open with unspecified reason";

        private d() {
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.ironsource.h f14871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f14873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f14874d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f14875e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f14876f = false;

        public e(com.ironsource.h hVar) {
            this.f14871a = hVar;
        }

        public Intent a(Context context) {
            Intent intentA = this.f14871a.a(context);
            intentA.putExtra("external_url", this.f14873c);
            intentA.putExtra("secondary_web_view", this.f14874d);
            intentA.putExtra("is_store", this.f14875e);
            intentA.putExtra(v8.h.f15821v, this.f14876f);
            if (!(context instanceof Activity)) {
                intentA.setFlags(this.f14872b);
            }
            return intentA;
        }

        @NotNull
        public e b(boolean z10) {
            this.f14874d = z10;
            return this;
        }

        @NotNull
        public e c(boolean z10) {
            this.f14875e = z10;
            return this;
        }

        @NotNull
        e a(int i10) {
            this.f14872b = i10;
            return this;
        }

        @NotNull
        public e a(String str) {
            this.f14873c = str;
            return this;
        }

        @NotNull
        e a(boolean z10) {
            this.f14876f = z10;
            return this;
        }
    }

    private void e() {
        requestWindowFeature(1);
    }

    private void f() {
        getWindow().setFlags(1024, 1024);
    }

    private void g() {
        ViewGroup viewGroup;
        v vVar = this.f14854b;
        if (vVar != null) {
            vVar.a(false, v8.h.Y);
            if (this.f14857e == null || (viewGroup = (ViewGroup) this.f14853a.getParent()) == null) {
                return;
            }
            if (viewGroup.findViewById(f14851k) != null) {
                viewGroup.removeView(this.f14853a);
            }
            if (viewGroup.findViewById(f14852l) != null) {
                viewGroup.removeView(this.f14855c);
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        v vVar;
        if (this.f14856d && (vVar = this.f14854b) != null) {
            vVar.c(v8.h.f15797j);
        }
        super.finish();
    }

    public void loadUrl(String str) {
        this.f14853a.stopLoading();
        this.f14853a.clearHistory();
        try {
            this.f14853a.loadUrl(str);
        } catch (Throwable th) {
            i9.d().a(th);
            Logger.e(f14850j, "OpenUrlActivity:: loadUrl: " + th.toString());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f14853a.canGoBack()) {
            this.f14853a.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(f14850j, "onCreate()");
        try {
            this.f14854b = (v) qi.a((Context) this).a().j();
            e();
            f();
            Bundle extras = getIntent().getExtras();
            this.f14858f = extras.getString("external_url");
            this.f14856d = extras.getBoolean("secondary_web_view");
            boolean booleanExtra = getIntent().getBooleanExtra(v8.h.f15821v, false);
            this.f14860h = booleanExtra;
            if (booleanExtra) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new a());
                runOnUiThread(this.f14861i);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f14857e = relativeLayout;
            setContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.f14860h && (i10 == 25 || i10 == 24)) {
            this.f14859g.postDelayed(this.f14861i, 500L);
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        g();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (this.f14860h && z10) {
            runOnUiThread(this.f14861i);
        }
    }

    private void a() {
        if (this.f14855c == null) {
            ProgressBar progressBar = new ProgressBar(new ContextThemeWrapper(this, R.style.Theme.Holo.Light.Dialog));
            this.f14855c = progressBar;
            progressBar.setId(f14852l);
        }
        if (findViewById(f14852l) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f14855c.setLayoutParams(layoutParams);
            this.f14855c.setVisibility(4);
            this.f14857e.addView(this.f14855c);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        if (this.f14853a == null) {
            WebView webView = new WebView(getApplicationContext());
            this.f14853a = webView;
            webView.setId(f14851k);
            this.f14853a.getSettings().setJavaScriptEnabled(true);
            this.f14853a.setWebViewClient(new c(this, null));
            loadUrl(this.f14858f);
        }
        if (findViewById(f14851k) == null) {
            this.f14857e.addView(this.f14853a, new RelativeLayout.LayoutParams(-1, -1));
        }
        a();
        v vVar = this.f14854b;
        if (vVar != null) {
            vVar.a(true, v8.h.Y);
        }
    }

    private void c() {
        WebView webView = this.f14853a;
        if (webView != null) {
            webView.destroy();
        }
    }

    private void d() {
        getWindow().addFlags(16);
    }
}
