package defpackage;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.webkit.ProxyConfig;
import com.vungle.ads.internal.presenter.o;
import java.net.URISyntaxException;
import java.util.Arrays;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import p9.r;
import v8.k0;
import v8.z;

/* JADX INFO: compiled from: AdaWebViewClient.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends WebViewClient {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0000a f23e = new C0000a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private h9.a<k0> f26c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f27d;

    /* JADX INFO: renamed from: a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdaWebViewClient.kt */
    public static final class C0000a {

        /* JADX INFO: renamed from: a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdaWebViewClient.kt */
        static final class C0001a extends v implements h9.a<k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0001a f28g = new C0001a();

            C0001a() {
                super(0);
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                invoke2();
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Log.d("AdaWebView", "Error Loading AdaWebView");
            }
        }

        private C0000a() {
        }

        public /* synthetic */ C0000a(k kVar) {
            this();
        }

        @NotNull
        public final h9.a<k0> a() {
            return C0001a.f28g;
        }
    }

    /* JADX INFO: compiled from: AdaWebViewClient.kt */
    static final class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WebView f30b;

        b(WebView webView) {
            this.f30b = webView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.f24a || a.this.f25b) {
                return;
            }
            WebView webView = this.f30b;
            if (webView == null || webView.getProgress() != 100) {
                WebView webView2 = this.f30b;
                if (webView2 != null) {
                    webView2.stopLoading();
                }
                a.this.c().invoke();
            }
        }
    }

    public a(@NotNull h9.a<k0> webViewLoadingErrorCallback, int i10) {
        t.j(webViewLoadingErrorCallback, "webViewLoadingErrorCallback");
        this.f26c = webViewLoadingErrorCallback;
        this.f27d = i10;
    }

    private final void d(WebView webView, String str) {
        try {
            Intent uri = Intent.parseUri(str, 1);
            t.e(uri, "Intent.parseUri(url, Intent.URI_INTENT_SCHEME)");
            if (uri == null) {
                return;
            }
            Context context = webView.getContext();
            t.e(context, "view.context");
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(uri, 65536);
            if (resolveInfoResolveActivity != null) {
                try {
                    uri.addCategory("android.intent.category.BROWSABLE");
                    uri.setComponent(null);
                    uri.setSelector(null);
                    webView.getContext().startActivity(uri);
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(webView.getContext(), "A problem occurred and " + str + " could not be opened.", 1);
                }
            } else if (q.K(str, "intent://", false, 2, null)) {
                String stringExtra = uri.getStringExtra("browser_fallback_url");
                if (stringExtra != null) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringExtra));
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setComponent(null);
                    intent.setSelector(null);
                    webView.getContext().startActivity(intent);
                } else if (uri.getPackage() != null) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    String str2 = String.format("market://details?id=%s", Arrays.copyOf(new Object[]{uri.getPackage()}, 1));
                    t.e(str2, "java.lang.String.format(this, *args)");
                    Intent data = intent2.setData(Uri.parse(str2));
                    t.e(data, "Intent(Intent.ACTION_VIE…age()))\n                )");
                    Context context2 = webView.getContext();
                    t.e(context2, "view.context");
                    if (data.resolveActivity(context2.getPackageManager()) != null) {
                        data.addCategory("android.intent.category.BROWSABLE");
                        data.setComponent(null);
                        data.setSelector(null);
                        webView.getContext().startActivity(data);
                    }
                }
            }
            if (resolveInfoResolveActivity == null) {
                try {
                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (ActivityNotFoundException unused2) {
                    Toast.makeText(webView.getContext(), "A problem occurred and " + str + " could not be opened.", 1);
                }
            }
        } catch (URISyntaxException unused3) {
        }
    }

    private final boolean e(String str) {
        return r.P(str, com.vungle.ads.internal.model.b.FILE_SCHEME, false, 2, null) && str != "file:///android_asset/embed.html";
    }

    @NotNull
    public final h9.a<k0> c() {
        return this.f26c;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        this.f24a = true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        this.f24a = false;
        new Handler(Looper.getMainLooper()).postDelayed(new b(webView), this.f27d);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(@Nullable WebView webView, @NotNull WebResourceRequest request, @NotNull WebResourceError error) {
        t.j(request, "request");
        t.j(error, "error");
        Log.e("AdaWebView Error", error.getDescription().toString() + " Request URL:" + request.getUrl().toString());
        this.f25b = true;
        this.f26c.invoke();
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@NotNull WebView view, @NotNull String url) {
        t.j(view, "view");
        t.j(url, "url");
        return null;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@NotNull WebView view, @NotNull String url) {
        t.j(view, "view");
        t.j(url, "url");
        if (!r.N(url, ".pdf", true) && !r.N(url, ".txt", true)) {
            if (e(url)) {
                return true;
            }
            d(view, url);
            return true;
        }
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setNotificationVisibility(1);
        String strSubstring = url.substring(r.k0(url, "name=", 0, false, 6, null) + 5);
        t.e(strSubstring, "(this as java.lang.String).substring(startIndex)");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, strSubstring);
        Object systemService = view.getContext().getSystemService(o.DOWNLOAD);
        if (systemService == null) {
            throw new z("null cannot be cast to non-null type android.app.DownloadManager");
        }
        ((DownloadManager) systemService).enqueue(request);
        Toast.makeText(view.getContext(), "Downloading File", 1).show();
        return true;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@NotNull WebView view, @NotNull WebResourceRequest request) {
        t.j(view, "view");
        t.j(request, "request");
        Uri requestUri = request.getUrl();
        t.e(requestUri, "requestUri");
        if (t.d(requestUri.getScheme(), ProxyConfig.MATCH_HTTP)) {
            view.removeJavascriptInterface("AdaAndroid");
        }
        return super.shouldInterceptRequest(view, request);
    }
}
