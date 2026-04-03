package androidx.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import androidx.webkit.internal.AssetHelper;
import com.unity3d.services.UnityAdsConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class WebViewAssetLoader {
    public static final String DEFAULT_DOMAIN = "appassets.androidplatform.net";
    private static final String TAG = "WebViewAssetLoader";
    private final List<PathMatcher> mMatchers;

    public static final class Builder {
        private String mDomain = WebViewAssetLoader.DEFAULT_DOMAIN;

        @NonNull
        private final List<Pair<String, PathHandler>> mHandlerList = new ArrayList();
        private boolean mHttpAllowed;

        @NonNull
        public Builder addPathHandler(@NonNull String str, @NonNull PathHandler pathHandler) {
            this.mHandlerList.add(Pair.create(str, pathHandler));
            return this;
        }

        @NonNull
        public WebViewAssetLoader build() {
            ArrayList arrayList = new ArrayList();
            for (Pair<String, PathHandler> pair : this.mHandlerList) {
                arrayList.add(new PathMatcher(this.mDomain, pair.first, this.mHttpAllowed, pair.second));
            }
            return new WebViewAssetLoader(arrayList);
        }

        @NonNull
        public Builder setDomain(@NonNull String str) {
            this.mDomain = str;
            return this;
        }

        @NonNull
        public Builder setHttpAllowed(boolean z10) {
            this.mHttpAllowed = z10;
            return this;
        }
    }

    public static final class InternalStoragePathHandler implements PathHandler {
        private static final String[] FORBIDDEN_DATA_DIRS = {"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};

        @NonNull
        private final File mDirectory;

        public InternalStoragePathHandler(@NonNull Context context, @NonNull File file) {
            try {
                this.mDirectory = new File(AssetHelper.getCanonicalDirPath(file));
                if (isAllowedInternalStorageDir(context)) {
                    return;
                }
                throw new IllegalArgumentException("The given directory \"" + file + "\" doesn't exist under an allowed app internal storage directory");
            } catch (IOException e10) {
                throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + file.getPath(), e10);
            }
        }

        private boolean isAllowedInternalStorageDir(@NonNull Context context) throws IOException {
            String canonicalDirPath = AssetHelper.getCanonicalDirPath(this.mDirectory);
            String canonicalDirPath2 = AssetHelper.getCanonicalDirPath(context.getCacheDir());
            String canonicalDirPath3 = AssetHelper.getCanonicalDirPath(AssetHelper.getDataDir(context));
            if ((!canonicalDirPath.startsWith(canonicalDirPath2) && !canonicalDirPath.startsWith(canonicalDirPath3)) || canonicalDirPath.equals(canonicalDirPath2) || canonicalDirPath.equals(canonicalDirPath3)) {
                return false;
            }
            for (String str : FORBIDDEN_DATA_DIRS) {
                if (canonicalDirPath.startsWith(canonicalDirPath3 + str)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @NonNull
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            File canonicalFileIfChild;
            try {
                canonicalFileIfChild = AssetHelper.getCanonicalFileIfChild(this.mDirectory, str);
            } catch (IOException e10) {
                Log.e(WebViewAssetLoader.TAG, "Error opening the requested path: " + str, e10);
            }
            if (canonicalFileIfChild != null) {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), null, AssetHelper.openFile(canonicalFileIfChild));
            }
            Log.e(WebViewAssetLoader.TAG, String.format("The requested file: %s is outside the mounted directory: %s", str, this.mDirectory));
            return new WebResourceResponse(null, null, null);
        }
    }

    public interface PathHandler {
        @Nullable
        @WorkerThread
        WebResourceResponse handle(@NonNull String str);
    }

    @VisibleForTesting
    static class PathMatcher {
        static final String HTTPS_SCHEME = "https";
        static final String HTTP_SCHEME = "http";

        @NonNull
        final String mAuthority;

        @NonNull
        final PathHandler mHandler;
        final boolean mHttpEnabled;

        @NonNull
        final String mPath;

        PathMatcher(@NonNull String str, @NonNull String str2, boolean z10, @NonNull PathHandler pathHandler) {
            if (str2.isEmpty() || str2.charAt(0) != '/') {
                throw new IllegalArgumentException("Path should start with a slash '/'.");
            }
            if (!str2.endsWith(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH)) {
                throw new IllegalArgumentException("Path should end with a slash '/'");
            }
            this.mAuthority = str;
            this.mPath = str2;
            this.mHttpEnabled = z10;
            this.mHandler = pathHandler;
        }

        @NonNull
        @WorkerThread
        public String getSuffixPath(@NonNull String str) {
            return str.replaceFirst(this.mPath, "");
        }

        @Nullable
        @WorkerThread
        public PathHandler match(@NonNull Uri uri) {
            if (uri.getScheme().equals("http") && !this.mHttpEnabled) {
                return null;
            }
            if ((uri.getScheme().equals("http") || uri.getScheme().equals("https")) && uri.getAuthority().equals(this.mAuthority) && uri.getPath().startsWith(this.mPath)) {
                return this.mHandler;
            }
            return null;
        }
    }

    WebViewAssetLoader(@NonNull List<PathMatcher> list) {
        this.mMatchers = list;
    }

    @Nullable
    @WorkerThread
    public WebResourceResponse shouldInterceptRequest(@NonNull Uri uri) {
        WebResourceResponse webResourceResponseHandle;
        for (PathMatcher pathMatcher : this.mMatchers) {
            PathHandler pathHandlerMatch = pathMatcher.match(uri);
            if (pathHandlerMatch != null && (webResourceResponseHandle = pathHandlerMatch.handle(pathMatcher.getSuffixPath(uri.getPath()))) != null) {
                return webResourceResponseHandle;
            }
        }
        return null;
    }

    public static final class AssetsPathHandler implements PathHandler {
        private AssetHelper mAssetHelper;

        public AssetsPathHandler(@NonNull Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @Nullable
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            try {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), null, this.mAssetHelper.openAsset(str));
            } catch (IOException e10) {
                Log.e(WebViewAssetLoader.TAG, "Error opening asset path: " + str, e10);
                return new WebResourceResponse(null, null, null);
            }
        }

        @VisibleForTesting
        AssetsPathHandler(@NonNull AssetHelper assetHelper) {
            this.mAssetHelper = assetHelper;
        }
    }

    public static final class ResourcesPathHandler implements PathHandler {
        private AssetHelper mAssetHelper;

        public ResourcesPathHandler(@NonNull Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @Nullable
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            try {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), null, this.mAssetHelper.openResource(str));
            } catch (Resources.NotFoundException e10) {
                Log.e(WebViewAssetLoader.TAG, "Resource not found from the path: " + str, e10);
                return new WebResourceResponse(null, null, null);
            } catch (IOException e11) {
                Log.e(WebViewAssetLoader.TAG, "Error opening resource from the path: " + str, e11);
                return new WebResourceResponse(null, null, null);
            }
        }

        @VisibleForTesting
        ResourcesPathHandler(@NonNull AssetHelper assetHelper) {
            this.mAssetHelper = assetHelper;
        }
    }
}
