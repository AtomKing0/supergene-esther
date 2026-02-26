package com.unity3d.ads.core.domain;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.unity3d.ads.adplayer.GetWebViewAssetLoaderKt;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.services.UnityAdsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;

/* JADX INFO: compiled from: GetCachedAsset.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetCachedAsset {

    @NotNull
    private final CacheRepository cacheRepository;

    @NotNull
    private final Context context;

    public GetCachedAsset(@NotNull CacheRepository cacheRepository, @NotNull Context context) {
        t.i(cacheRepository, "cacheRepository");
        t.i(context, "context");
        this.cacheRepository = cacheRepository;
        this.context = context;
    }

    private final WebResourceResponse getBundledAsset(Uri uri) {
        String strN0 = r.N0(String.valueOf(uri.getPath()), UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, null, 2, null);
        try {
            InputStream inputStreamOpen = this.context.getAssets().open(strN0);
            t.h(inputStreamOpen, "context.assets.open(fileName)");
            return new WebResourceResponse(GetWebViewAssetLoaderKt.guessMimeType(strN0), null, inputStreamOpen);
        } catch (Exception unused) {
            return null;
        }
    }

    private final WebResourceResponse getCachedAsset(Uri uri) {
        String string = uri.toString();
        t.h(string, "uri.toString()");
        CacheResult cacheResultRetrieveFile = this.cacheRepository.retrieveFile(r.Z0(r.R0(string, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, null, 2, null), ".", null, 2, null));
        if (!(cacheResultRetrieveFile instanceof CacheResult.Success)) {
            return null;
        }
        CacheResult.Success success = (CacheResult.Success) cacheResultRetrieveFile;
        File file = success.getCachedFile().getFile();
        if (file == null) {
            return null;
        }
        return new WebResourceResponse(GetWebViewAssetLoaderKt.guessMimeType(file.getAbsolutePath() + '.' + success.getCachedFile().getExtension()), null, new FileInputStream(file));
    }

    @Nullable
    public final WebResourceResponse invoke(@NotNull Uri uri) {
        t.i(uri, "uri");
        String host = uri.getHost();
        if (host != null) {
            int iHashCode = host.hashCode();
            if (iHashCode != -1921537799) {
                if (iHashCode == -1920242293 && host.equals(UnityAdsConstants.DefaultUrls.AD_CACHE_DOMAIN)) {
                    return getCachedAsset(uri);
                }
            } else if (host.equals(UnityAdsConstants.DefaultUrls.AD_ASSET_DOMAIN)) {
                return getBundledAsset(uri);
            }
        }
        return null;
    }
}
