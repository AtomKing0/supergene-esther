package qa;

import ga.a0;
import ga.z;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.w;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f33228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static volatile j f33229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f33230c;

    /* JADX INFO: compiled from: Platform.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        private final j d() {
            ra.e.f33415a.b();
            j jVarA = qa.a.f33198e.a();
            if (jVarA != null) {
                return jVarA;
            }
            j jVarA2 = b.f33201f.a();
            t.f(jVarA2);
            return jVarA2;
        }

        private final j e() {
            i iVarA;
            c cVarA;
            d dVarB;
            if (j() && (dVarB = d.f33210e.b()) != null) {
                return dVarB;
            }
            if (i() && (cVarA = c.f33207e.a()) != null) {
                return cVarA;
            }
            if (k() && (iVarA = i.f33225e.a()) != null) {
                return iVarA;
            }
            h hVarA = h.f33223d.a();
            if (hVarA != null) {
                return hVarA;
            }
            j jVarA = e.f33214i.a();
            return jVarA != null ? jVarA : new j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final j f() {
            return h() ? d() : e();
        }

        private final boolean i() {
            return t.d("BC", Security.getProviders()[0].getName());
        }

        private final boolean j() {
            return t.d("Conscrypt", Security.getProviders()[0].getName());
        }

        private final boolean k() {
            return t.d("OpenJSSE", Security.getProviders()[0].getName());
        }

        @NotNull
        public final List<String> b(@NotNull List<? extends a0> protocols) {
            t.i(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((a0) obj) != a0.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(w.v(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((a0) it.next()).toString());
            }
            return arrayList2;
        }

        @NotNull
        public final byte[] c(@NotNull List<? extends a0> protocols) {
            t.i(protocols, "protocols");
            ua.c cVar = new ua.c();
            for (String str : b(protocols)) {
                cVar.writeByte(str.length());
                cVar.E(str);
            }
            return cVar.l0();
        }

        @NotNull
        public final j g() {
            return j.f33229b;
        }

        public final boolean h() {
            return t.d("Dalvik", System.getProperty("java.vm.name"));
        }
    }

    static {
        a aVar = new a(null);
        f33228a = aVar;
        f33229b = aVar.f();
        f33230c = Logger.getLogger(z.class.getName());
    }

    public static /* synthetic */ void l(j jVar, String str, int i10, Throwable th, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i11 & 2) != 0) {
            i10 = 4;
        }
        if ((i11 & 4) != 0) {
            th = null;
        }
        jVar.k(str, i10, th);
    }

    public void b(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
    }

    @NotNull
    public ta.c c(@NotNull X509TrustManager trustManager) {
        t.i(trustManager, "trustManager");
        return new ta.a(d(trustManager));
    }

    @NotNull
    public ta.e d(@NotNull X509TrustManager trustManager) {
        t.i(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        t.h(acceptedIssuers, "trustManager.acceptedIssuers");
        return new ta.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void e(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<a0> protocols) {
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
    }

    public void f(@NotNull Socket socket, @NotNull InetSocketAddress address, int i10) throws IOException {
        t.i(socket, "socket");
        t.i(address, "address");
        socket.connect(address, i10);
    }

    @NotNull
    public final String g() {
        return "OkHttp";
    }

    @Nullable
    public String h(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        return null;
    }

    @Nullable
    public Object i(@NotNull String closer) {
        t.i(closer, "closer");
        if (f33230c.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean j(@NotNull String hostname) {
        t.i(hostname, "hostname");
        return true;
    }

    public void k(@NotNull String message, int i10, @Nullable Throwable th) {
        t.i(message, "message");
        f33230c.log(i10 == 5 ? Level.WARNING : Level.INFO, message, th);
    }

    public void m(@NotNull String message, @Nullable Object obj) {
        t.i(message, "message");
        if (obj == null) {
            message = t.r(message, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        k(message, 5, (Throwable) obj);
    }

    @NotNull
    public SSLContext n() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        t.h(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    @NotNull
    public SSLSocketFactory o(@NotNull X509TrustManager trustManager) {
        t.i(trustManager, "trustManager");
        try {
            SSLContext sSLContextN = n();
            sSLContextN.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextN.getSocketFactory();
            t.h(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e10) {
            throw new AssertionError(t.r("No System TLS: ", e10), e10);
        }
    }

    @NotNull
    public X509TrustManager p() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    @NotNull
    public String toString() {
        String simpleName = getClass().getSimpleName();
        t.h(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
