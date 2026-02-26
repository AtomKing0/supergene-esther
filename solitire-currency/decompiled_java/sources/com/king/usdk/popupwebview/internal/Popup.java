package com.king.usdk.popupwebview.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.UiThread;
import com.king.usdk.popupwebview.ILoadingListener;
import com.king.usdk.popupwebview.IMessageListener;
import com.king.usdk.popupwebview.IPopup;
import com.king.usdk.popupwebview.IResponseCallback;
import com.king.usdk.popupwebview.PageState;
import com.unity3d.services.UnityAdsConstants;
import io.sentry.protocol.SentryThread;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
@Keep
class Popup implements IPopup {
    private static final String BACK_BUTTON_PRESSED_MESSAGE = "systemBackButton";
    private static final String BLANK_PAGE_URL = "about:blank";
    private static final String ERROR_INVALID_JAVASCRIPT = "invalid javascript";
    private static final String ERROR_WEB_PAGE_NOT_LOADED = "web page is not loaded";
    private final ActivityWrapper activityWrapper;
    private boolean forceFullscreen;
    private final MessageBus messageBus;
    private WebView webView = null;
    private String loadingTargetUrl = "about:blank";
    private boolean autoShowOnLoaded = false;
    private volatile PopupDialog popupDialog = null;
    private volatile PageState pageState = null;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Popup.this.pageState != null) {
                PageState pageState = Popup.this.pageState;
                PageState pageState2 = PageState.BLANK;
                if (pageState != pageState2) {
                    Popup.this.loadingTargetUrl = "about:blank";
                    if (Popup.this.pageState != PageState.LOADING) {
                        Popup.this.messageBus.cancelAllResponses();
                    }
                    Popup.this.pageState = pageState2;
                    Popup.this.webView.loadUrl("about:blank");
                    Popup.this.recycleIfBlankAndHidden();
                }
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IResponseCallback f17264c;

        b(String str, String str2, IResponseCallback iResponseCallback) {
            this.f17262a = str;
            this.f17263b = str2;
            this.f17264c = iResponseCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Popup.this.pageState == PageState.LOADED) {
                Popup.this.messageBus.postMessage(this.f17262a, this.f17263b, this.f17264c);
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f17266a;

        c(boolean z10) {
            this.f17266a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Popup.this.popupDialog == null) {
                Popup popup = Popup.this;
                popup.webView = popup.activityWrapper.createWebView();
                if (Popup.this.webView != null) {
                    c cVar = null;
                    Popup.this.webView.setLayerType(2, null);
                    Popup.this.webView.setBackgroundColor(0);
                    Popup.this.webView.setOverScrollMode(2);
                    WebSettings settings = Popup.this.webView.getSettings();
                    settings.setJavaScriptEnabled(true);
                    settings.setAllowFileAccess(true);
                    settings.setAllowFileAccessFromFileURLs(true);
                    settings.setDomStorageEnabled(true);
                    settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
                    settings.setMediaPlaybackRequiresUserGesture(false);
                    settings.setUseWideViewPort(true);
                    Popup.this.messageBus.registerJavascriptInterface(Popup.this.webView);
                    settings.setSupportMultipleWindows(true);
                    Popup.this.webView.setWebChromeClient(new l(Popup.this, cVar));
                    Popup.this.webView.setWebViewClient(new m(Popup.this, cVar));
                    Popup popup2 = Popup.this;
                    popup2.popupDialog = new PopupDialog(popup2.webView, this.f17266a);
                    Popup.this.loadingTargetUrl = "about:blank";
                    Popup.this.pageState = PageState.BLANK;
                    Popup.this.webView.loadUrl("about:blank");
                }
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Popup.this.messageBus.cancelAllResponses();
            Popup.this.loadingTargetUrl = "about:blank";
            Popup.this.pageState = null;
            Popup.this.autoShowOnLoaded = false;
            if (Popup.this.popupDialog != null) {
                Popup.this.popupDialog.destroy();
                Popup.this.popupDialog = null;
            }
            if (Popup.this.webView != null) {
                Popup.this.webView.destroy();
                Popup.this.webView = null;
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ValueCallback f17270b;

        e(String str, ValueCallback valueCallback) {
            this.f17269a = str;
            this.f17270b = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Popup.this.executeJavascript(this.f17269a, this.f17270b);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f17273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f17274c;

        class a implements ValueCallback<String> {
            a() {
            }

            private String b(String str) {
                if (str == null) {
                    return "";
                }
                if (str.startsWith("\"") && str.endsWith("\"")) {
                    str = str.substring(1, str.length() - 1);
                }
                return str.replace("\\\"", "\"");
            }

            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                String strB = b(str);
                f fVar = f.this;
                Popup.this.onEvalJavascriptFinished(fVar.f17273b, fVar.f17274c, strB);
            }
        }

        f(String str, long j10, long j11) {
            this.f17272a = str;
            this.f17273b = j10;
            this.f17274c = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Popup.this.webView == null) {
                Popup popup = Popup.this;
                popup.initializeWebResources(popup.forceFullscreen);
            }
            Popup.this.webView.evaluateJavascript(this.f17272a, new a());
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Popup.this.webView == null) {
                Popup popup = Popup.this;
                popup.initializeWebResources(popup.forceFullscreen);
            }
            if (Popup.this.pageState == PageState.LOADED) {
                Popup.this.popupDialog.open(Popup.this);
                if (Popup.this.popupDialog.isOpened()) {
                    return;
                }
                Popup.this.recycleWebResources();
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Popup.this.autoShowOnLoaded = false;
            if (Popup.this.popupDialog != null) {
                Popup.this.popupDialog.close();
            }
            Popup.this.recycleIfBlankAndHidden();
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Popup.this.webView != null) {
                Popup.this.webView.clearCache(true);
            }
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Popup.this.webView != null) {
                Popup.this.webView.loadUrl("about:blank");
            }
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f17281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17282b;

        k(boolean z10, String str) {
            this.f17281a = z10;
            this.f17282b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Popup.this.webView == null) {
                Popup popup = Popup.this;
                popup.initializeWebResources(popup.forceFullscreen);
            }
            if (Popup.this.pageState != null) {
                Popup.this.autoShowOnLoaded = this.f17281a;
                PageState pageState = Popup.this.pageState;
                PageState pageState2 = PageState.LOADING;
                if (pageState != pageState2) {
                    Popup.this.messageBus.cancelAllResponses();
                    Popup.this.pageState = pageState2;
                } else if (this.f17282b.equals(Popup.this.loadingTargetUrl)) {
                    return;
                }
                Popup.this.loadingTargetUrl = this.f17282b;
                Popup.this.webView.loadUrl(this.f17282b);
            }
        }
    }

    private final class l extends WebChromeClient {
        private l() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z10, boolean z11, Message message) {
            if (!z11) {
                return false;
            }
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(webView.getHitTestResult().getExtra())));
            return false;
        }

        /* synthetic */ l(Popup popup, c cVar) {
            this();
        }
    }

    private final class m extends WebViewClient {
        private m() {
        }

        private void a(String str) {
            Popup.this.messageBus.firePageError(str);
        }

        @Override // android.webkit.WebViewClient
        @UiThread
        public void onPageFinished(WebView webView, String str) {
            if (Popup.this.pageState == null || Popup.this.pageState == PageState.BLANK) {
                if (Popup.this.popupDialog != null) {
                    Popup.this.popupDialog.close();
                }
            } else if (webView == Popup.this.webView && Popup.this.pageState == PageState.LOADING && webView.getProgress() >= 100 && Popup.this.loadingTargetUrl.equals(webView.getOriginalUrl())) {
                Popup.this.pageState = PageState.LOADED;
                Popup.this.messageBus.firePageLoaded(Popup.this.loadingTargetUrl);
                if (Popup.this.autoShowOnLoaded) {
                    Popup.this.show();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        @UiThread
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            if (webView == Popup.this.webView) {
                a(str);
            }
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 26)
        @UiThread
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView != Popup.this.webView) {
                return false;
            }
            Popup.this.clearWebView();
            StringBuilder sb = new StringBuilder();
            sb.append("onRenderProcessGone: ");
            sb.append(renderProcessGoneDetail.didCrash() ? SentryThread.JsonKeys.CRASHED : "killed by the system");
            a(sb.toString());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (URLUtil.isValidUrl(str)) {
                return false;
            }
            try {
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (ActivityNotFoundException | NullPointerException e10) {
                e10.printStackTrace();
                return true;
            }
        }

        /* synthetic */ m(Popup popup, c cVar) {
            this();
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 23)
        @UiThread
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webView == Popup.this.webView) {
                a(webResourceError.getDescription().toString());
            }
        }
    }

    Popup(ActivityWrapper activityWrapper, boolean z10) {
        this.forceFullscreen = z10;
        if (activityWrapper == null) {
            throw new IllegalArgumentException("invalid null activity wrapper");
        }
        this.activityWrapper = activityWrapper;
        this.messageBus = new MessageBus(this);
        initializeWebResources(this.forceFullscreen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresPermission("android.permission.INTERNET")
    public void initializeWebResources(boolean z10) {
        this.activityWrapper.runOnUIThread(new c(z10));
    }

    private static String normalizeUrl(String str) {
        if (str != null && !str.isEmpty() && !str.equalsIgnoreCase("about:blank")) {
            try {
                if (str.startsWith(com.vungle.ads.internal.model.b.FILE_SCHEME)) {
                    String strSubstring = str.substring(7);
                    if (!strSubstring.startsWith(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH)) {
                        str = "file:///android_asset/" + strSubstring;
                    }
                }
                URL url = new URL(str);
                String userInfo = url.getUserInfo();
                if (userInfo != null) {
                    int iIndexOf = userInfo.indexOf(58);
                    if (iIndexOf >= 0) {
                        userInfo = URLEncoder.encode(userInfo.substring(0, iIndexOf), "UTF-8") + ":" + URLEncoder.encode(userInfo.substring(iIndexOf + 1), "UTF-8");
                    } else {
                        userInfo = URLEncoder.encode(userInfo, "UTF-8");
                    }
                }
                String str2 = userInfo;
                String path = url.getPath();
                String str3 = (path == null || path.isEmpty()) ? UnityAdsConstants.DefaultUrls.AD_ASSET_PATH : path;
                int port = url.getPort();
                String protocol = url.getProtocol();
                Locale locale = Locale.ROOT;
                String lowerCase = protocol.toLowerCase(locale);
                String lowerCase2 = url.getHost().toLowerCase(locale);
                if (port == url.getDefaultPort()) {
                    port = -1;
                }
                return new URI(lowerCase, str2, lowerCase2, port, str3, url.getQuery(), url.getRef()).normalize().toASCIIString();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void onEvalJavascriptFinished(long j10, long j11, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public void recycleIfBlankAndHidden() {
        if (this.webView == null || isVisible() || this.loadingTargetUrl != "about:blank") {
            return;
        }
        recycleWebResources();
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void backButtonPressed() {
        postMessage(BACK_BUTTON_PRESSED_MESSAGE, null);
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void clearCache() {
        this.activityWrapper.runOnUIThread(new i());
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void clearWebView() {
        this.messageBus.cancelAllResponses();
        this.loadingTargetUrl = "about:blank";
        this.pageState = PageState.BLANK;
        this.activityWrapper.runOnUIThread(new j());
    }

    public void evalJavascript(long j10, long j11, String str) {
        this.activityWrapper.runOnUIThread(new f(str, j10, j11));
    }

    @UiThread
    void executeJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.webView == null) {
            initializeWebResources(this.forceFullscreen);
        }
        if (str == null || str.isEmpty()) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue(ERROR_INVALID_JAVASCRIPT);
            }
        } else if (this.pageState == PageState.LOADED || this.pageState == PageState.LOADING) {
            this.webView.evaluateJavascript(str, valueCallback);
        } else if (valueCallback != null) {
            valueCallback.onReceiveValue(ERROR_WEB_PAGE_NOT_LOADED);
        }
    }

    void executeJavascriptOnUIThread(String str, ValueCallback<String> valueCallback) {
        this.activityWrapper.runOnUIThread(new e(str, valueCallback));
    }

    protected void finalize() throws Throwable {
        recycleWebResources();
        super.finalize();
    }

    ActivityWrapper getActivityWrapper() {
        return this.activityWrapper;
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public PageState getPageState() {
        PageState pageState = this.pageState;
        return pageState == null ? PageState.BLANK : pageState;
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void hide() {
        this.activityWrapper.runOnUIThread(new h());
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public boolean isVisible() {
        PopupDialog popupDialog = this.popupDialog;
        if (popupDialog != null) {
            return popupDialog.isOpened();
        }
        return false;
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void loadPage(String str) {
        loadPage(str, true);
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void postMessage(String str, String str2) {
        postMessage(str, str2, null);
    }

    protected void recycleWebResources() {
        this.activityWrapper.runOnUIThread(new d());
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void setLoadingListener(ILoadingListener iLoadingListener) {
        this.messageBus.setLoadingListener(iLoadingListener);
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void setMessageListener(IMessageListener iMessageListener) {
        this.messageBus.setMessageListener(iMessageListener);
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void show() {
        this.activityWrapper.runOnUIThread(new g());
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void unloadPage() {
        this.activityWrapper.runOnUIThread(new a());
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void loadPage(String str, boolean z10) {
        String strNormalizeUrl = normalizeUrl(str);
        if (strNormalizeUrl == null) {
            unloadPage();
        } else {
            this.activityWrapper.runOnUIThread(new k(z10, strNormalizeUrl));
        }
    }

    @Override // com.king.usdk.popupwebview.IPopup
    public void postMessage(String str, String str2, IResponseCallback iResponseCallback) {
        this.activityWrapper.runOnUIThread(new b(str, str2, iResponseCallback));
    }
}
