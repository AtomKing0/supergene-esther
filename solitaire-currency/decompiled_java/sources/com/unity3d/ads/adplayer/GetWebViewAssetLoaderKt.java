package com.unity3d.ads.adplayer;

import android.content.Context;
import android.webkit.WebResourceResponse;
import androidx.webkit.WebViewAssetLoader;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.log.DeviceLog;
import java.io.InputStream;
import java.net.URLConnection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetWebViewAssetLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetWebViewAssetLoaderKt {
    @NotNull
    public static final String guessMimeType(@NotNull String filePath) {
        t.i(filePath, "filePath");
        String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(filePath);
        t.h(strGuessContentTypeFromName, "guessContentTypeFromName(filePath)");
        return strGuessContentTypeFromName;
    }

    @NotNull
    public static final GetWebViewCacheAssetLoader provideGetWebViewCacheAssetLoader(@NotNull final Context context) {
        t.i(context, "context");
        return new GetWebViewCacheAssetLoader() { // from class: com.unity3d.ads.adplayer.d
            @Override // com.unity3d.ads.adplayer.GetWebViewCacheAssetLoader, h9.a
            public final WebViewAssetLoader invoke() {
                return GetWebViewAssetLoaderKt.provideGetWebViewCacheAssetLoader$lambda$1(context);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebViewAssetLoader provideGetWebViewCacheAssetLoader$lambda$1(final Context context) {
        t.i(context, "$context");
        WebViewAssetLoader webViewAssetLoaderBuild = new WebViewAssetLoader.Builder().addPathHandler(UnityAdsConstants.DefaultUrls.WEBVIEW_ASSET_PATH, new WebViewAssetLoader.PathHandler() { // from class: com.unity3d.ads.adplayer.e
            @Override // androidx.webkit.WebViewAssetLoader.PathHandler
            public final WebResourceResponse handle(String str) {
                return GetWebViewAssetLoaderKt.provideGetWebViewCacheAssetLoader$lambda$1$lambda$0(context, str);
            }
        }).setDomain(UnityAdsConstants.DefaultUrls.WEBVIEW_DOMAIN).build();
        t.h(webViewAssetLoaderBuild, "Builder()\n        .addPa…_DOMAIN)\n        .build()");
        return webViewAssetLoaderBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebResourceResponse provideGetWebViewCacheAssetLoader$lambda$1$lambda$0(Context context, String path) {
        t.i(context, "$context");
        t.i(path, "path");
        try {
            InputStream inputStreamOpen = context.getAssets().open(path);
            t.h(inputStreamOpen, "context.assets.open(path)");
            return new WebResourceResponse(guessMimeType(path), null, inputStreamOpen);
        } catch (Exception unused) {
            DeviceLog.debug("Webview Asset not found: %s", path);
            return null;
        }
    }
}
