package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.webkit.internal.ProfileStoreImpl;
import androidx.webkit.internal.WebViewFeatureInternal;

/* JADX INFO: compiled from: ProfileStore.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a {
    @NonNull
    public static ProfileStore a() {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return ProfileStoreImpl.getInstance();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
