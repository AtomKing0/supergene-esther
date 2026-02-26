package ra;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends ta.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f33412d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final X509TrustManager f33413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final X509TrustManagerExtensions f33414c;

    /* JADX INFO: compiled from: AndroidCertificateChainCleaner.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final d a(@NotNull X509TrustManager trustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            t.i(trustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new d(trustManager, x509TrustManagerExtensions);
            }
            return null;
        }
    }

    public d(@NotNull X509TrustManager trustManager, @NotNull X509TrustManagerExtensions x509TrustManagerExtensions) {
        t.i(trustManager, "trustManager");
        t.i(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f33413b = trustManager;
        this.f33414c = x509TrustManagerExtensions;
    }

    @Override // ta.c
    @NotNull
    public List<Certificate> a(@NotNull List<? extends Certificate> chain, @NotNull String hostname) throws SSLPeerUnverifiedException {
        t.i(chain, "chain");
        t.i(hostname, "hostname");
        Object[] array = chain.toArray(new X509Certificate[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        try {
            List<X509Certificate> listCheckServerTrusted = this.f33414c.checkServerTrusted((X509Certificate[]) array, "RSA", hostname);
            t.h(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e10) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e10.getMessage());
            sSLPeerUnverifiedException.initCause(e10);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof d) && ((d) obj).f33413b == this.f33413b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f33413b);
    }
}
