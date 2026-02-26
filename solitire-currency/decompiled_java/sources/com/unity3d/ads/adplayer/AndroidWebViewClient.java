package com.unity3d.ads.adplayer;

import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import androidx.media3.common.MimeTypes;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;
import androidx.webkit.WebViewFeature;
import com.unity3d.ads.adplayer.model.ErrorReason;
import com.unity3d.ads.adplayer.model.WebViewClientError;
import com.unity3d.ads.core.domain.GetCachedAsset;
import com.unity3d.ads.core.extensions.IntExtensionKt;
import com.unity3d.ads.core.extensions.ViewExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.x;
import kotlinx.coroutines.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.j;
import s9.m0;
import s9.o0;
import s9.y;

/* JADX INFO: compiled from: AndroidWebViewClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidWebViewClient extends WebViewClientCompat {

    @NotNull
    public static final String BLANK_PAGE = "about:blank";

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final y<Boolean> _isRenderProcessGone;

    @NotNull
    private final x<List<WebViewClientError>> _onLoadFinished;

    @NotNull
    private final WebViewAssetLoader adAssetLoader;

    @NotNull
    private final GetCachedAsset getCachedAsset;

    @NotNull
    private final m0<Boolean> isRenderProcessGone;

    @NotNull
    private final y<List<WebViewClientError>> loadErrors;

    @NotNull
    private final v0<List<WebViewClientError>> onLoadFinished;

    @NotNull
    private final WebViewAssetLoader webViewAssetLoader;

    /* JADX INFO: compiled from: AndroidWebViewClient.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    public AndroidWebViewClient(@NotNull GetWebViewCacheAssetLoader getWebViewAssetLoader, @NotNull GetAdAssetLoader getAdAssetLoader, @NotNull GetCachedAsset getCachedAsset) {
        t.i(getWebViewAssetLoader, "getWebViewAssetLoader");
        t.i(getAdAssetLoader, "getAdAssetLoader");
        t.i(getCachedAsset, "getCachedAsset");
        this.getCachedAsset = getCachedAsset;
        this.webViewAssetLoader = (WebViewAssetLoader) getWebViewAssetLoader.invoke();
        this.adAssetLoader = (WebViewAssetLoader) getAdAssetLoader.invoke();
        this.loadErrors = o0.a(v.l());
        x<List<WebViewClientError>> xVarB = z.b(null, 1, null);
        this._onLoadFinished = xVarB;
        this.onLoadFinished = xVarB;
        y<Boolean> yVarA = o0.a(Boolean.FALSE);
        this._isRenderProcessGone = yVarA;
        this.isRenderProcessGone = j.c(yVarA);
    }

    @NotNull
    public final v0<List<WebViewClientError>> getOnLoadFinished() {
        return this.onLoadFinished;
    }

    @NotNull
    public final m0<Boolean> isRenderProcessGone() {
        return this.isRenderProcessGone;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(@NotNull WebView view, @NotNull String url) {
        List<WebViewClientError> value;
        t.i(view, "view");
        t.i(url, "url");
        if (t.d(url, BLANK_PAGE)) {
            y<List<WebViewClientError>> yVar = this.loadErrors;
            do {
                value = yVar.getValue();
            } while (!yVar.d(value, d0.B0(value, new WebViewClientError(url, ErrorReason.REASON_WEB_BLANK, null, 4, null))));
        }
        super.onPageFinished(view, url);
        this._onLoadFinished.O(this.loadErrors.getValue());
    }

    @Override // androidx.webkit.WebViewClientCompat
    @RequiresApi(21)
    public void onReceivedError(@NotNull WebView view, @NotNull WebResourceRequest request, @NotNull WebResourceErrorCompat error) {
        List<WebViewClientError> value;
        t.i(view, "view");
        t.i(request, "request");
        t.i(error, "error");
        super.onReceivedError(view, request, error);
        ErrorReason errorReasonWebResourceToErrorReason = WebViewFeature.isFeatureSupported(WebViewFeature.WEB_RESOURCE_ERROR_GET_CODE) ? IntExtensionKt.webResourceToErrorReason(error.getErrorCode()) : ErrorReason.REASON_UNKNOWN;
        y<List<WebViewClientError>> yVar = this.loadErrors;
        do {
            value = yVar.getValue();
        } while (!yVar.d(value, d0.B0(value, new WebViewClientError(request.getUrl().toString(), errorReasonWebResourceToErrorReason, null, 4, null))));
    }

    @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onReceivedHttpError(@NotNull WebView view, @NotNull WebResourceRequest request, @NotNull WebResourceResponse errorResponse) {
        List<WebViewClientError> value;
        t.i(view, "view");
        t.i(request, "request");
        t.i(errorResponse, "errorResponse");
        super.onReceivedHttpError(view, request, errorResponse);
        WebViewClientError webViewClientError = new WebViewClientError(request.getUrl().toString(), ErrorReason.REASON_WEB_ERROR_RECEIVED_HTTP, Integer.valueOf(errorResponse.getStatusCode()));
        y<List<WebViewClientError>> yVar = this.loadErrors;
        do {
            value = yVar.getValue();
        } while (!yVar.d(value, d0.B0(value, webViewClientError)));
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(@NotNull WebView view, @NotNull RenderProcessGoneDetail detail) {
        List<WebViewClientError> value;
        t.i(view, "view");
        t.i(detail, "detail");
        ViewExtensionsKt.removeViewFromParent(view);
        view.destroy();
        if (this._onLoadFinished.i()) {
            this._isRenderProcessGone.setValue(Boolean.TRUE);
            return true;
        }
        y<List<WebViewClientError>> yVar = this.loadErrors;
        do {
            value = yVar.getValue();
        } while (!yVar.d(value, d0.B0(value, new WebViewClientError(String.valueOf(view.getUrl()), ErrorReason.REASON_WEBVIEW_RENDER_PROCESS_GONE, null, 4, null))));
        this._onLoadFinished.O(this.loadErrors.getValue());
        return true;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@NotNull WebView view, @NotNull WebResourceRequest request) {
        t.i(view, "view");
        t.i(request, "request");
        Uri url = request.getUrl();
        if (url == null) {
            return super.shouldInterceptRequest(view, request);
        }
        if (t.d(url.getLastPathSegment(), "favicon.ico")) {
            return new WebResourceResponse(MimeTypes.IMAGE_PNG, null, null);
        }
        if (t.d(url.getScheme(), UnityAdsConstants.Cache.CACHE_SCHEME)) {
            GetCachedAsset getCachedAsset = this.getCachedAsset;
            Uri url2 = request.getUrl();
            t.h(url2, "request.url");
            return getCachedAsset.invoke(url2);
        }
        String host = url.getHost();
        if (host != null) {
            int iHashCode = host.hashCode();
            if (iHashCode != -598289184) {
                if (iHashCode == 380656434 && host.equals(UnityAdsConstants.DefaultUrls.WEBVIEW_DOMAIN)) {
                    return this.webViewAssetLoader.shouldInterceptRequest(url);
                }
            } else if (host.equals("cdn-creatives-cf-prd.acquire.unity3dusercontent.com")) {
                return this.adAssetLoader.shouldInterceptRequest(url);
            }
        }
        return super.shouldInterceptRequest(view, request);
    }
}
