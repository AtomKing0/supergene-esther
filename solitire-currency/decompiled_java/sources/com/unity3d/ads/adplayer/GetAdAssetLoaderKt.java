package com.unity3d.ads.adplayer;

import android.content.Context;
import android.webkit.WebResourceResponse;
import androidx.webkit.WebViewAssetLoader;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetAdAssetLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetAdAssetLoaderKt {
    @NotNull
    public static final GetAdAssetLoader provideGetAdCacheAssetLoader(@NotNull final Context context) {
        t.i(context, "context");
        return new GetAdAssetLoader() { // from class: com.unity3d.ads.adplayer.c
            @Override // com.unity3d.ads.adplayer.GetAdAssetLoader, h9.a
            public final WebViewAssetLoader invoke() {
                return GetAdAssetLoaderKt.provideGetAdCacheAssetLoader$lambda$1(context);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebViewAssetLoader provideGetAdCacheAssetLoader$lambda$1(final Context context) {
        t.i(context, "$context");
        WebViewAssetLoader webViewAssetLoaderBuild = new WebViewAssetLoader.Builder().addPathHandler(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, new WebViewAssetLoader.PathHandler() { // from class: com.unity3d.ads.adplayer.b
            @Override // androidx.webkit.WebViewAssetLoader.PathHandler
            public final WebResourceResponse handle(String str) {
                return GetAdAssetLoaderKt.provideGetAdCacheAssetLoader$lambda$1$lambda$0(context, str);
            }
        }).setDomain("cdn-creatives-cf-prd.acquire.unity3dusercontent.com").build();
        t.h(webViewAssetLoaderBuild, "Builder()\n        .addPa…_DOMAIN)\n        .build()");
        return webViewAssetLoaderBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebResourceResponse provideGetAdCacheAssetLoader$lambda$1$lambda$0(Context context, String path) {
        t.i(context, "$context");
        t.i(path, "path");
        try {
            return new WebResourceResponse(GetWebViewAssetLoaderKt.guessMimeType(path), null, new FileInputStream(new File(context.getFilesDir(), "unityads/" + path)));
        } catch (Exception unused) {
            DeviceLog.debug("Ad Asset not found: %s", path);
            return null;
        }
    }
}
