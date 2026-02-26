package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.ProxyControllerImpl;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ProxyController {

    private static class LAZY_HOLDER {
        static final ProxyController INSTANCE = new ProxyControllerImpl();

        private LAZY_HOLDER() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ProxyController() {
    }

    @NonNull
    public static ProxyController getInstance() {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE)) {
            return LAZY_HOLDER.INSTANCE;
        }
        throw new UnsupportedOperationException("Proxy override not supported");
    }

    public abstract void clearProxyOverride(@NonNull Executor executor, @NonNull Runnable runnable);

    public abstract void setProxyOverride(@NonNull ProxyConfig proxyConfig, @NonNull Executor executor, @NonNull Runnable runnable);
}
