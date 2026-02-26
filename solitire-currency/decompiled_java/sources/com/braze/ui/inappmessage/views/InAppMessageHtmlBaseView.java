package com.braze.ui.inappmessage.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.net.MailTo;
import androidx.core.view.WindowInsetsCompat;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.listeners.IWebViewClientStateListener;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import com.braze.ui.support.ViewUtils;
import com.ironsource.nb;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InAppMessageHtmlBaseView.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InAppMessageHtmlBaseView extends RelativeLayout implements IInAppMessageView {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private WebView configuredMessageWebView;
    private boolean hasAppliedWindowInsets;

    @Nullable
    private InAppMessageWebViewClient inAppMessageWebViewClient;
    private boolean isFinished;

    /* JADX INFO: compiled from: InAppMessageHtmlBaseView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView$finishWebViewDisplay$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageHtmlBaseView.kt */
    static final class AnonymousClass1 extends v implements h9.a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Finishing WebView display";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView$setWebViewContent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageHtmlBaseView.kt */
    static final class C12641 extends v implements h9.a<String> {
        public static final C12641 INSTANCE = new C12641();

        C12641() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Cannot load WebView. htmlBody was null.";
        }
    }

    public InAppMessageHtmlBaseView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ void setWebViewContent$default(InAppMessageHtmlBaseView inAppMessageHtmlBaseView, String str, String str2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWebViewContent");
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        inAppMessageHtmlBaseView.setWebViewContent(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDirectionalNavigation$lambda$1(WebView webView) {
        t.i(webView, "$webView");
        webView.requestFocus();
    }

    @Override // com.braze.ui.inappmessage.views.IInAppMessageView
    public void applyWindowInsets(@NotNull WindowInsetsCompat insets) {
        t.i(insets, "insets");
        setHasAppliedWindowInsets(true);
        Context context = getContext();
        t.h(context, "this.context");
        if (new BrazeConfigurationProvider(context).isHtmlInAppMessageApplyWindowInsetsEnabled() && getLayoutParams() != null && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            t.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(ViewUtils.getMaxSafeLeftInset(insets) + marginLayoutParams.leftMargin, ViewUtils.getMaxSafeTopInset(insets) + marginLayoutParams.topMargin, ViewUtils.getMaxSafeRightInset(insets) + marginLayoutParams.rightMargin, ViewUtils.getMaxSafeBottomInset(insets) + marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        t.i(event, "event");
        if (isInTouchMode() || event.getKeyCode() != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            return super.dispatchKeyEvent(event);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }

    public void finishWebViewDisplay() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) AnonymousClass1.INSTANCE, 7, (Object) null);
        this.isFinished = true;
        WebView webView = this.configuredMessageWebView;
        if (webView != null) {
            webView.loadUrl(AndroidWebViewClient.BLANK_PAGE);
            webView.onPause();
            webView.removeAllViews();
            this.configuredMessageWebView = null;
        }
    }

    @Override // com.braze.ui.inappmessage.views.IInAppMessageView
    public boolean getHasAppliedWindowInsets() {
        return this.hasAppliedWindowInsets;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @Nullable
    public WebView getMessageWebView() {
        if (this.isFinished) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) InAppMessageHtmlBaseView$messageWebView$1.INSTANCE, 6, (Object) null);
            return null;
        }
        int webViewViewId = getWebViewViewId();
        if (webViewViewId == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) InAppMessageHtmlBaseView$messageWebView$2.INSTANCE, 7, (Object) null);
            return null;
        }
        WebView webView = this.configuredMessageWebView;
        if (webView != null) {
            return webView;
        }
        WebView webView2 = (WebView) findViewById(webViewViewId);
        if (webView2 == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new InAppMessageHtmlBaseView$messageWebView$3(webViewViewId), 7, (Object) null);
            return null;
        }
        WebSettings settings = webView2.getSettings();
        t.h(settings, "webView.settings");
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        webView2.setLayerType(2, null);
        webView2.setBackgroundColor(0);
        try {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                Context context = getContext();
                t.h(context, "context");
                if (ViewUtils.isDeviceInNightMode(context)) {
                    WebSettingsCompat.setForceDark(settings, 2);
                }
            }
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
                WebSettingsCompat.setForceDarkStrategy(settings, 1);
            }
        } catch (Throwable th) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th, false, (h9.a) InAppMessageHtmlBaseView$messageWebView$4.INSTANCE, 4, (Object) null);
        }
        Context context2 = getContext();
        t.h(context2, "this.context");
        final boolean zIsHtmlInAppMessageHtmlLinkTargetEnabled = new BrazeConfigurationProvider(context2).isHtmlInAppMessageHtmlLinkTargetEnabled();
        if (zIsHtmlInAppMessageHtmlLinkTargetEnabled) {
            webView2.getSettings().setSupportMultipleWindows(true);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) InAppMessageHtmlBaseView$messageWebView$5.INSTANCE, 6, (Object) null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) InAppMessageHtmlBaseView$messageWebView$6.INSTANCE, 6, (Object) null);
        }
        webView2.setWebChromeClient(new WebChromeClient() { // from class: com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView$messageWebView$7
            @Override // android.webkit.WebChromeClient
            @NotNull
            public Bitmap getDefaultVideoPoster() {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                t.h(bitmapCreateBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
                return bitmapCreateBitmap;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(@NotNull ConsoleMessage cm) {
                t.i(cm, "cm");
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.this$0, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new InAppMessageHtmlBaseView$messageWebView$7$onConsoleMessage$1(cm), 7, (Object) null);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(@Nullable WebView webView3, boolean z10, boolean z11, @Nullable Message message) {
                if (!zIsHtmlInAppMessageHtmlLinkTargetEnabled) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$1.INSTANCE, 6, (Object) null);
                    return super.onCreateWindow(webView3, z10, z11, message);
                }
                if (webView3 == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$2.INSTANCE, 6, (Object) null);
                } else {
                    WebView.HitTestResult hitTestResult = webView3.getHitTestResult();
                    t.h(hitTestResult, "view.hitTestResult");
                    BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                    BrazeLogger.Priority priority = BrazeLogger.Priority.V;
                    BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$3(hitTestResult), 6, (Object) null);
                    try {
                        int type = hitTestResult.getType();
                        if (type == 2) {
                            this.this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tel:" + hitTestResult.getExtra())));
                        } else if (type == 4) {
                            this.this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(MailTo.MAILTO_SCHEME + hitTestResult.getExtra())));
                        } else if (type != 7) {
                            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$4(hitTestResult), 6, (Object) null);
                        } else {
                            this.this$0.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(hitTestResult.getExtra())));
                        }
                    } catch (Exception e10) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new InAppMessageHtmlBaseView$messageWebView$7$onCreateWindow$5(hitTestResult), 4, (Object) null);
                    }
                }
                return false;
            }
        });
        this.configuredMessageWebView = webView2;
        return webView2;
    }

    public abstract int getWebViewViewId();

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, @NotNull KeyEvent event) {
        t.i(event, "event");
        if (i10 == 4 && BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
            return true;
        }
        WebView webView = this.configuredMessageWebView;
        if (webView != null) {
            ViewUtils.setFocusableInTouchModeAndRequestFocus(webView);
        }
        return super.onKeyDown(i10, event);
    }

    public void setHasAppliedWindowInsets(boolean z10) {
        this.hasAppliedWindowInsets = z10;
    }

    public void setHtmlPageFinishedListener(@Nullable IWebViewClientStateListener iWebViewClientStateListener) {
        InAppMessageWebViewClient inAppMessageWebViewClient = this.inAppMessageWebViewClient;
        if (inAppMessageWebViewClient != null) {
            inAppMessageWebViewClient.setWebViewClientStateListener(iWebViewClientStateListener);
        }
    }

    public void setInAppMessageWebViewClient(@NotNull InAppMessageWebViewClient inAppMessageWebViewClient) {
        t.i(inAppMessageWebViewClient, "inAppMessageWebViewClient");
        WebView messageWebView = getMessageWebView();
        if (messageWebView != null) {
            messageWebView.setWebViewClient(inAppMessageWebViewClient);
        }
        this.inAppMessageWebViewClient = inAppMessageWebViewClient;
    }

    public final void setWebViewContent(@Nullable String str) {
        setWebViewContent$default(this, str, null, 2, null);
    }

    public final void setupDirectionalNavigation() {
        final WebView messageWebView = getMessageWebView();
        if (messageWebView == null) {
            return;
        }
        messageWebView.setNextFocusDownId(messageWebView.getId());
        messageWebView.setNextFocusLeftId(messageWebView.getId());
        messageWebView.setNextFocusRightId(messageWebView.getId());
        messageWebView.setNextFocusUpId(messageWebView.getId());
        messageWebView.requestFocus();
        if (Build.VERSION.SDK_INT >= 26) {
            messageWebView.setFocusedByDefault(true);
        }
        messageWebView.post(new Runnable() { // from class: com.braze.ui.inappmessage.views.c
            @Override // java.lang.Runnable
            public final void run() {
                InAppMessageHtmlBaseView.setupDirectionalNavigation$lambda$1(messageWebView);
            }
        });
    }

    public void setWebViewContent(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) C12641.INSTANCE, 7, (Object) null);
            return;
        }
        WebView messageWebView = getMessageWebView();
        if (messageWebView != null) {
            messageWebView.loadDataWithBaseURL("https://iamcache.braze/", str, "text/html", nb.N, null);
        }
    }

    @Override // com.braze.ui.inappmessage.views.IInAppMessageView
    @Nullable
    public View getMessageClickableView() {
        return this;
    }
}
