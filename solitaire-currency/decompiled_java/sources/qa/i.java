package qa;

import ga.a0;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: compiled from: OpenJSSEPlatform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f33225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f33226f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Provider f33227d;

    /* JADX INFO: compiled from: OpenJSSEPlatform.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @Nullable
        public final i a() {
            k kVar = null;
            if (b()) {
                return new i(kVar);
            }
            return null;
        }

        public final boolean b() {
            return i.f33226f;
        }
    }

    static {
        a aVar = new a(null);
        f33225e = aVar;
        boolean z10 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, aVar.getClass().getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        f33226f = z10;
    }

    public /* synthetic */ i(k kVar) {
        this();
    }

    @Override // qa.j
    public void e(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<a0> protocols) {
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
        if (!(sslSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            super.e(sslSocket, str, protocols);
            return;
        }
        org.openjsse.javax.net.ssl.SSLSocket sSLSocket = (org.openjsse.javax.net.ssl.SSLSocket) sslSocket;
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        if (sSLParameters instanceof SSLParameters) {
            SSLParameters sSLParameters2 = sSLParameters;
            Object[] array = j.f33228a.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            sSLParameters2.setApplicationProtocols((String[]) array);
            sSLSocket.setSSLParameters(sSLParameters);
        }
    }

    @Override // qa.j
    @Nullable
    public String h(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        if (!(sslSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            return super.h(sslSocket);
        }
        String applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : t.d(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // qa.j
    @NotNull
    public SSLContext n() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f33227d);
        t.h(sSLContext, "getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // qa.j
    @NotNull
    public X509TrustManager p() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f33227d);
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        t.f(trustManagers);
        if (!(trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager))) {
            String string = Arrays.toString(trustManagers);
            t.h(string, "toString(this)");
            throw new IllegalStateException(t.r("Unexpected default trust managers: ", string).toString());
        }
        TrustManager trustManager = trustManagers[0];
        if (trustManager != null) {
            return (X509TrustManager) trustManager;
        }
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    }

    private i() {
        this.f33227d = new OpenJSSE();
    }
}
