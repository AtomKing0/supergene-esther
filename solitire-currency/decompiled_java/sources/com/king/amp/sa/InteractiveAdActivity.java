package com.king.amp.sa;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.webkit.ProxyConfig;
import com.king.amp.sa.r;
import com.king.usdk.localnotification.NotificationSchedulerKeys;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class InteractiveAdActivity extends AppCompatActivity implements h1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static String f16668v = "AbmInteractiveAdActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private i1 f16669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private AbmWebView f16670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private r f16671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private m0 f16672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private y f16673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private String f16674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private String f16675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Timer f16676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f16677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f16678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f16679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f16680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f16681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ImageButton f16682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Button f16683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f16684p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator f16685q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f16686r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f16687s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f16688t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f16689u;

    class a implements Runnable {

        /* JADX INFO: renamed from: com.king.amp.sa.InteractiveAdActivity$a$a, reason: collision with other inner class name */
        class RunnableC0277a implements Runnable {
            RunnableC0277a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                InteractiveAdActivity.this.f16680l = System.currentTimeMillis();
                InteractiveAdActivity.this.Q();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(InteractiveAdActivity.this.f16674f));
                byte[] bArr = new byte[fileInputStream.available()];
                if (fileInputStream.read(bArr) != -1) {
                    InteractiveAdActivity interactiveAdActivity = InteractiveAdActivity.this;
                    interactiveAdActivity.f16675g = interactiveAdActivity.J(new String(bArr));
                }
                InteractiveAdActivity.this.runOnUiThread(new RunnableC0277a());
            } catch (Exception e10) {
                Log.e(InteractiveAdActivity.f16668v, "Unable to read resource", e10);
                if (InteractiveAdActivity.this.f16669a != null) {
                    InteractiveAdActivity.this.f16669a.i(3, "Interactive ad error: can't load media from device.");
                }
                InteractiveAdActivity.this.finish();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InteractiveAdActivity.this.f16669a != null) {
                InteractiveAdActivity.this.f16669a.k("close", s1.d(new AdProviderNameValuePairs()));
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InteractiveAdActivity.this.f16669a.k("cta", s1.a());
        }
    }

    class d extends TimerTask {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (InteractiveAdActivity.this.f16679k <= InteractiveAdActivity.this.f16677i) {
                    if (!InteractiveAdActivity.this.f16689u) {
                        TextView textView = InteractiveAdActivity.this.f16684p;
                        InteractiveAdActivity interactiveAdActivity = InteractiveAdActivity.this;
                        textView.setText(interactiveAdActivity.getString(j6.i.f28756b, interactiveAdActivity.H(interactiveAdActivity.f16678j)));
                    }
                    double d10 = InteractiveAdActivity.this.f16679k / InteractiveAdActivity.this.f16677i;
                    if (InteractiveAdActivity.this.f16669a != null) {
                        InteractiveAdActivity.this.f16669a.l((int) (d10 * 100.0d), InteractiveAdActivity.this.f16679k);
                    }
                }
                if (InteractiveAdActivity.this.f16679k == InteractiveAdActivity.this.f16677i) {
                    InteractiveAdActivity.this.M();
                    if (InteractiveAdActivity.this.f16669a != null) {
                        InteractiveAdActivity.this.f16669a.l(100, InteractiveAdActivity.this.f16679k);
                    }
                }
            }
        }

        d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            InteractiveAdActivity.this.runOnUiThread(new a());
            InteractiveAdActivity.this.f16679k++;
            InteractiveAdActivity.this.f16678j--;
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            InteractiveAdActivity.this.f16681m.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            InteractiveAdActivity.this.f16681m.requestLayout();
        }
    }

    class f implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                InteractiveAdActivity.this.f16684p.setVisibility(0);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InteractiveAdActivity.this.f16684p.setText(InteractiveAdActivity.this.getString(j6.i.f28755a));
            InteractiveAdActivity.this.f16684p.animate().alpha(1.0f).setDuration(500L).withEndAction(new a()).start();
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {
        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            InteractiveAdActivity.this.f16681m.setBackgroundTintList(ColorStateList.valueOf(((Integer) valueAnimator.getAnimatedValue()).intValue()));
        }
    }

    private class h extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Log.d(InteractiveAdActivity.f16668v, "Console: " + consoleMessage.message());
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            Log.d(InteractiveAdActivity.f16668v, "JsAlert: " + str2 + " result: " + jsResult.toString());
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            Log.d(InteractiveAdActivity.f16668v, "received title: " + webView.getUrl());
        }

        private h() {
        }
    }

    private void I() {
        if (this.f16685q != null) {
            return;
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        ValueAnimator duration = ValueAnimator.ofInt(1, Math.min(point.x, point.y)).setDuration(this.f16677i * 1000);
        this.f16685q = duration;
        duration.addUpdateListener(new e());
        this.f16685q.setInterpolator(new LinearInterpolator());
        this.f16685q.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String J(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder("<script>\n");
        try {
            Scanner scannerUseDelimiter = new Scanner(getResources().openRawResource(j6.h.f28752a), "UTF-8").useDelimiter("\\A");
            if (scannerUseDelimiter.hasNext()) {
                sb.append(scannerUseDelimiter.next());
            }
            scannerUseDelimiter.close();
        } catch (Exception e10) {
            t1.e(f16668v, "Unable to read resource :" + e10.toString());
            i1 i1Var = this.f16669a;
            if (i1Var != null) {
                i1Var.i(3, "Interactive ad error: can't load media from device.");
            }
            finish();
        }
        sb.append("\n</script>\n");
        return sb.toString() + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        U();
        if (!this.f16689u) {
            S();
        }
        this.f16689u = true;
    }

    private void N() {
        this.f16671c.m();
        this.f16671c.p();
        O();
        this.f16671c.q(r.b.DEFAULT);
        this.f16671c.r(true);
        this.f16671c.d();
    }

    private void O() {
        float f10 = getResources().getDisplayMetrics().density;
        int i10 = (int) ((getResources().getDisplayMetrics().widthPixels / f10) + 0.5f);
        int i11 = (int) ((getResources().getDisplayMetrics().heightPixels / f10) + 0.5f);
        this.f16671c.n(i10, i11);
        this.f16671c.l(i10, i11);
        this.f16670b.getLocationOnScreen(new int[2]);
        int width = this.f16670b.getWidth();
        int height = this.f16670b.getHeight();
        Rect rect = new Rect();
        rect.set((int) ((r1[0] / f10) + 0.5f), (int) ((r1[1] / f10) + 0.5f), (int) ((width / f10) + 0.5f), (int) ((height / f10) + 0.5f));
        this.f16671c.j(rect);
        this.f16671c.k(rect);
        this.f16671c.o(rect);
    }

    private void P() {
        WebSettings settings = this.f16670b.getSettings();
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
            cookieManager.setAcceptThirdPartyCookies(this.f16670b, true);
        }
        this.f16670b.setScrollContainer(false);
        this.f16670b.setLayerType(2, null);
        this.f16670b.setHorizontalScrollBarEnabled(false);
        this.f16670b.setVerticalScrollBarEnabled(false);
        this.f16670b.setBackgroundColor(0);
        this.f16670b.setScrollBarStyle(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (this.f16675g.startsWith(ProxyConfig.MATCH_HTTP)) {
            this.f16670b.loadUrl(this.f16675g);
        } else {
            this.f16670b.loadDataWithBaseURL(AndroidWebViewClient.BLANK_PAGE, this.f16675g, "text/html", "UTF-8", null);
        }
    }

    private void R() {
        synchronized (this) {
            if (!this.f16687s) {
                I();
                T();
                N();
                this.f16687s = true;
                this.f16669a.j();
            }
        }
    }

    private void S() {
        this.f16684p.animate().alpha(0.0f).setDuration(500L).withEndAction(new f()).start();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(ContextCompat.getColor(this, j6.b.f28705a), ContextCompat.getColor(this, j6.b.f28706b));
        valueAnimatorOfInt.setDuration(500L);
        valueAnimatorOfInt.setEvaluator(new ArgbEvaluator());
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(new g());
        valueAnimatorOfInt.start();
    }

    private void T() {
        if (this.f16676h != null) {
            return;
        }
        Timer timer = new Timer();
        this.f16676h = timer;
        timer.schedule(new d(), 0L, 1000L);
    }

    private void U() {
        Timer timer = this.f16676h;
        if (timer != null) {
            timer.cancel();
            this.f16676h.purge();
            this.f16676h = null;
        }
    }

    String H(long j10) {
        return String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf((int) Math.floor((j10 % 3600) / 60.0d)), Integer.valueOf((int) Math.floor(r5 % 60)));
    }

    public void K() {
        M();
    }

    public void L(@NonNull String str) {
        Log.d(f16668v, "InteractiveActivty perform action called:" + str);
        str.hashCode();
        switch (str) {
            case "dismiss_prompt":
                y yVar = this.f16673e;
                if (yVar != null) {
                    yVar.dismiss();
                    break;
                }
                break;
            case "reward_granted":
                M();
                break;
            case "show_prompt":
                y yVar2 = this.f16673e;
                if (yVar2 != null && !yVar2.isAdded()) {
                    this.f16673e.show(getSupportFragmentManager(), "AbmMediaPlayerPromptDialogFragment");
                    break;
                }
                break;
            case "dismiss":
                this.f16671c.q(r.b.HIDDEN);
                this.f16687s = false;
                finish();
                break;
        }
    }

    @Override // com.king.amp.sa.h1
    public boolean e(RenderProcessGoneDetail renderProcessGoneDetail) {
        return false;
    }

    @Override // com.king.amp.sa.h1
    public WebResourceResponse g(Uri uri) {
        return this.f16671c.g(uri);
    }

    @Override // com.king.amp.sa.h1
    public void j(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        String str = "Http Error on interactive ad with code: " + webResourceResponse.getStatusCode();
        i1 i1Var = this.f16669a;
        if (i1Var != null) {
            i1Var.i(6, str);
        }
        finish();
    }

    @Override // com.king.amp.sa.h1
    public boolean k(Uri uri) {
        return this.f16671c.h(uri);
    }

    @Override // com.king.amp.sa.h1
    public void l(String str, @Nullable Bitmap bitmap) {
        if (str == null || str.equals(AndroidWebViewClient.BLANK_PAGE)) {
            return;
        }
        Log.i(f16668v, "Handle page started event for " + str + ", in " + (System.currentTimeMillis() - this.f16680l) + " ms");
    }

    @Override // com.king.amp.sa.h1
    public void n(String str) {
        Log.i(f16668v, "Handle page finished event for " + str + ", in " + (System.currentTimeMillis() - this.f16680l) + " ms");
        this.f16671c.f(str);
        if (this.f16670b.getProgress() == 100) {
            this.f16688t = true;
            if (this.f16686r) {
                R();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f16669a == null) {
            super.onBackPressed();
        } else {
            this.f16669a.k("close", s1.d(new AdProviderNameValuePairs()));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16687s = false;
        this.f16688t = false;
        this.f16686r = false;
        i1 i1VarE = i1.e();
        this.f16669a = i1VarE;
        i1VarE.n(this);
        Bundle extras = getIntent().getExtras();
        this.f16674f = extras.getString(NotificationSchedulerKeys.KEY_MEDIA_PATH);
        this.f16677i = extras.getLong("duration_sec");
        String string = extras.getString("layout_configuration");
        if (TextUtils.isEmpty(string)) {
            Log.e(f16668v, "Interactive ad error: layout config is empty.");
            i1 i1Var = this.f16669a;
            if (i1Var != null) {
                i1Var.i(4, "Interactive ad error: layout config is empty.");
            }
            finish();
            return;
        }
        new Thread(new a()).start();
        setRequestedOrientation(1);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(j6.g.f28750l);
        this.f16670b = (AbmWebView) findViewById(j6.f.L);
        this.f16671c = new r(this, this.f16670b, this.f16669a);
        this.f16681m = findViewById(j6.f.B);
        this.f16682n = (ImageButton) findViewById(j6.f.f28722j);
        Button button = (Button) findViewById(j6.f.f28725m);
        this.f16683o = button;
        button.setVisibility(8);
        TextView textView = (TextView) findViewById(j6.f.F);
        this.f16684p = textView;
        this.f16679k = 0L;
        this.f16680l = 0L;
        long j10 = this.f16677i;
        this.f16678j = j10;
        textView.setText(getString(j6.i.f28756b, H(j10)));
        P();
        m0 m0Var = new m0(this);
        this.f16672d = m0Var;
        this.f16670b.setWebViewClient(m0Var);
        this.f16670b.setWebChromeClient(new h());
        Bundle bundle2 = new Bundle();
        bundle2.putString("layout_configuration", string);
        this.f16673e = y.w(bundle2, AbmMediaPlayer.getInstance());
        this.f16682n.setOnClickListener(new b());
        this.f16683o.setOnClickListener(new c());
        this.f16689u = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        U();
        this.f16669a = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        i1 i1Var;
        if (isFinishing() && (i1Var = this.f16669a) != null) {
            i1Var.h(0, "");
        }
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        this.f16686r = z10;
        if (!z10) {
            this.f16671c.r(false);
            U();
            ValueAnimator valueAnimator = this.f16685q;
            if (valueAnimator != null) {
                valueAnimator.pause();
            }
            this.f16670b.onPause();
            if (this.f16687s) {
                this.f16669a.k("pause", s1.a());
                return;
            }
            return;
        }
        this.f16670b.onResume();
        if (!this.f16688t || this.f16687s) {
            this.f16671c.r(true);
            if (this.f16685q != null) {
                T();
                this.f16685q.resume();
            }
        } else {
            R();
        }
        if (this.f16687s) {
            this.f16669a.k("resume", s1.a());
        }
    }

    @Override // com.king.amp.sa.h1
    public void b(WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
    }

    @Override // com.king.amp.sa.h1
    public void i(SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // com.king.amp.sa.h1
    public void h(int i10, String str, String str2) {
    }
}
