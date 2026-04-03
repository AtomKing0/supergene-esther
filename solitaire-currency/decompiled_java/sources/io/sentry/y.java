package io.sentry;

import androidx.webkit.ProxyConfig;
import com.unity3d.services.UnityAdsConstants;
import java.net.URI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Dsn.java */
/* JADX INFO: loaded from: classes5.dex */
final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f28496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f28497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f28498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f28499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final URI f28500e;

    y(@Nullable String str) throws IllegalArgumentException {
        try {
            io.sentry.util.w.c(str, "The DSN is required.");
            URI uriNormalize = new URI(str).normalize();
            String scheme = uriNormalize.getScheme();
            if (!ProxyConfig.MATCH_HTTP.equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                throw new IllegalArgumentException("Invalid DSN scheme: " + scheme);
            }
            String userInfo = uriNormalize.getUserInfo();
            if (userInfo == null || userInfo.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            String[] strArrSplit = userInfo.split(":", -1);
            String str2 = strArrSplit[0];
            this.f28499d = str2;
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            this.f28498c = strArrSplit.length > 1 ? strArrSplit[1] : null;
            String path = uriNormalize.getPath();
            path = path.endsWith(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH) ? path.substring(0, path.length() - 1) : path;
            int iLastIndexOf = path.lastIndexOf(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH) + 1;
            String strSubstring = path.substring(0, iLastIndexOf);
            if (!strSubstring.endsWith(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH)) {
                strSubstring = strSubstring + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH;
            }
            this.f28497b = strSubstring;
            String strSubstring2 = path.substring(iLastIndexOf);
            this.f28496a = strSubstring2;
            if (strSubstring2.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
            }
            this.f28500e = new URI(scheme, null, uriNormalize.getHost(), uriNormalize.getPort(), strSubstring + "api/" + strSubstring2, null, null);
        } catch (Throwable th) {
            throw new IllegalArgumentException(th);
        }
    }

    @NotNull
    public String a() {
        return this.f28499d;
    }

    @Nullable
    public String b() {
        return this.f28498c;
    }

    @NotNull
    URI c() {
        return this.f28500e;
    }
}
