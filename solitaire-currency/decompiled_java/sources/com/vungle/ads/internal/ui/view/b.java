package com.vungle.ads.internal.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.VisibleForTesting;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import com.vungle.ads.internal.util.j;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.internal.util.x;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MRAIDAdWidget.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends RelativeLayout {

    @NotNull
    public static final C0533b Companion = new C0533b(null);

    @NotNull
    private static final String TAG = "MRAIDAdWidget";

    @Nullable
    private a closeDelegate;

    @Nullable
    private d onViewTouchListener;

    @Nullable
    private e orientationDelegate;

    @NotNull
    private final WebView webView;

    /* JADX INFO: compiled from: MRAIDAdWidget.kt */
    public interface a {
        void close();
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.ui.view.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MRAIDAdWidget.kt */
    public static final class C0533b {
        private C0533b() {
        }

        public /* synthetic */ C0533b(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: MRAIDAdWidget.kt */
    private static final class c implements Runnable {

        @NotNull
        private final WebView webView;

        public c(@NotNull WebView webView) {
            t.i(webView, "webView");
            this.webView = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.webView.stopLoading();
                if (Build.VERSION.SDK_INT >= 29) {
                    this.webView.setWebViewRenderProcessClient(null);
                }
                this.webView.loadUrl(AndroidWebViewClient.BLANK_PAGE);
                this.webView.destroy();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: MRAIDAdWidget.kt */
    public interface d {
        boolean onTouch(@Nullable MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: MRAIDAdWidget.kt */
    public interface e {
        void setOrientation(int i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context) throws InstantiationException {
        super(context);
        t.i(context, "context");
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(layoutParams);
        WebView webView = x.INSTANCE.getWebView(context);
        this.webView = webView;
        webView.setLayoutParams(layoutParams);
        webView.setTag("VungleWebView");
        addView(webView, layoutParams);
        bindListeners();
        prepare();
    }

    private final void applyDefault(WebView webView) {
        WebSettings settings = webView.getSettings();
        t.h(settings, "webView.settings");
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSaveFormData(true);
        settings.setUseWideViewPort(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        webView.setVisibility(4);
        settings.setMediaPlaybackRequiresUserGesture(false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void bindListeners() {
        this.webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.vungle.ads.internal.ui.view.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return b.m4113bindListeners$lambda0(this.f24400a, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: bindListeners$lambda-0, reason: not valid java name */
    public static final boolean m4113bindListeners$lambda0(b this$0, View view, MotionEvent motionEvent) {
        t.i(this$0, "this$0");
        d dVar = this$0.onViewTouchListener;
        if (dVar != null) {
            return dVar.onTouch(motionEvent);
        }
        return false;
    }

    private final void prepare() {
        WebView webView = this.webView;
        webView.setLayerType(2, null);
        webView.setBackgroundColor(0);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.setVisibility(8);
    }

    public final void close() {
        a aVar = this.closeDelegate;
        if (aVar != null) {
            aVar.close();
        }
    }

    public final void destroyWebView(long j10) {
        WebView webView = this.webView;
        webView.setWebChromeClient(null);
        removeAllViews();
        if (j10 <= 0) {
            new c(webView).run();
        } else {
            new j().schedule(new c(webView), j10);
        }
    }

    @Nullable
    public final a getCloseDelegate$vungle_ads_release() {
        return this.closeDelegate;
    }

    @Nullable
    public final d getOnViewTouchListener$vungle_ads_release() {
        return this.onViewTouchListener;
    }

    @Nullable
    public final e getOrientationDelegate$vungle_ads_release() {
        return this.orientationDelegate;
    }

    @Nullable
    public final String getUrl() {
        return this.webView.getUrl();
    }

    public final void linkWebView(@NotNull WebViewClient vngWebViewClient) {
        t.i(vngWebViewClient, "vngWebViewClient");
        WebView webView = this.webView;
        applyDefault(webView);
        webView.setWebViewClient(vngWebViewClient);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        ViewGroup.LayoutParams layoutParams2 = this.webView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = -1;
            layoutParams2.width = -1;
        }
    }

    public final void pauseWeb() {
        this.webView.onPause();
    }

    public final void resumeWeb() {
        this.webView.onResume();
    }

    public final void setCloseDelegate(@NotNull a closeDelegate) {
        t.i(closeDelegate, "closeDelegate");
        this.closeDelegate = closeDelegate;
    }

    public final void setCloseDelegate$vungle_ads_release(@Nullable a aVar) {
        this.closeDelegate = aVar;
    }

    public final void setOnViewTouchListener(@Nullable d dVar) {
        this.onViewTouchListener = dVar;
    }

    public final void setOnViewTouchListener$vungle_ads_release(@Nullable d dVar) {
        this.onViewTouchListener = dVar;
    }

    public final void setOrientation(int i10) {
        e eVar = this.orientationDelegate;
        if (eVar != null) {
            eVar.setOrientation(i10);
        }
    }

    public final void setOrientationDelegate(@Nullable e eVar) {
        this.orientationDelegate = eVar;
    }

    public final void setOrientationDelegate$vungle_ads_release(@Nullable e eVar) {
        this.orientationDelegate = eVar;
    }

    public final void showWebsite(@NotNull String url) {
        t.i(url, "url");
        p.Companion.d(TAG, "loadUrl: " + url);
        WebView webView = this.webView;
        webView.setVisibility(0);
        webView.loadUrl(url);
    }

    @VisibleForTesting
    public static /* synthetic */ void getCloseDelegate$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getOnViewTouchListener$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getOrientationDelegate$vungle_ads_release$annotations() {
    }
}
