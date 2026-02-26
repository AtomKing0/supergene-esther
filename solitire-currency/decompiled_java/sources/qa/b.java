package qa;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import ga.a0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ra.l;
import ra.m;
import ra.n;

/* JADX INFO: compiled from: AndroidPlatform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f33201f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f33202g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<m> f33203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final ra.j f33204e;

    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @Nullable
        public final j a() {
            if (b()) {
                return new b();
            }
            return null;
        }

        public final boolean b() {
            return b.f33202g;
        }
    }

    /* JADX INFO: renamed from: qa.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class C0663b implements ta.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final X509TrustManager f33205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final Method f33206b;

        public C0663b(@NotNull X509TrustManager trustManager, @NotNull Method findByIssuerAndSignatureMethod) {
            t.i(trustManager, "trustManager");
            t.i(findByIssuerAndSignatureMethod, "findByIssuerAndSignatureMethod");
            this.f33205a = trustManager;
            this.f33206b = findByIssuerAndSignatureMethod;
        }

        @Override // ta.e
        @Nullable
        public X509Certificate a(@NotNull X509Certificate cert) {
            t.i(cert, "cert");
            try {
                Object objInvoke = this.f33206b.invoke(this.f33205a, cert);
                if (objInvoke != null) {
                    return ((TrustAnchor) objInvoke).getTrustedCert();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e10) {
                throw new AssertionError("unable to get issues and signature", e10);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0663b)) {
                return false;
            }
            C0663b c0663b = (C0663b) obj;
            return t.d(this.f33205a, c0663b.f33205a) && t.d(this.f33206b, c0663b.f33206b);
        }

        public int hashCode() {
            return (this.f33205a.hashCode() * 31) + this.f33206b.hashCode();
        }

        @NotNull
        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f33205a + ", findByIssuerAndSignatureMethod=" + this.f33206b + ')';
        }
    }

    static {
        boolean z10 = false;
        if (j.f33228a.h() && Build.VERSION.SDK_INT < 30) {
            z10 = true;
        }
        f33202g = z10;
    }

    public b() {
        List listP = v.p(n.a.b(n.f33437j, null, 1, null), new l(ra.h.f33419f.d()), new l(ra.k.f33433a.a()), new l(ra.i.f33427a.a()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listP) {
            if (((m) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.f33203d = arrayList;
        this.f33204e = ra.j.f33429d.a();
    }

    @Override // qa.j
    @NotNull
    public ta.c c(@NotNull X509TrustManager trustManager) {
        t.i(trustManager, "trustManager");
        ra.d dVarA = ra.d.f33412d.a(trustManager);
        return dVarA == null ? super.c(trustManager) : dVarA;
    }

    @Override // qa.j
    @NotNull
    public ta.e d(@NotNull X509TrustManager trustManager) {
        t.i(trustManager, "trustManager");
        try {
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            method.setAccessible(true);
            t.h(method, "method");
            return new C0663b(trustManager, method);
        } catch (NoSuchMethodException unused) {
            return super.d(trustManager);
        }
    }

    @Override // qa.j
    public void e(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<a0> protocols) {
        Object next;
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
        Iterator<T> it = this.f33203d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((m) next).a(sslSocket)) {
                    break;
                }
            }
        }
        m mVar = (m) next;
        if (mVar == null) {
            return;
        }
        mVar.c(sslSocket, str, protocols);
    }

    @Override // qa.j
    public void f(@NotNull Socket socket, @NotNull InetSocketAddress address, int i10) throws IOException {
        t.i(socket, "socket");
        t.i(address, "address");
        try {
            socket.connect(address, i10);
        } catch (ClassCastException e10) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e10;
            }
            throw new IOException("Exception in connect", e10);
        }
    }

    @Override // qa.j
    @Nullable
    public String h(@NotNull SSLSocket sslSocket) {
        Object next;
        t.i(sslSocket, "sslSocket");
        Iterator<T> it = this.f33203d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((m) next).a(sslSocket)) {
                break;
            }
        }
        m mVar = (m) next;
        if (mVar == null) {
            return null;
        }
        return mVar.b(sslSocket);
    }

    @Override // qa.j
    @Nullable
    public Object i(@NotNull String closer) {
        t.i(closer, "closer");
        return this.f33204e.a(closer);
    }

    @Override // qa.j
    public boolean j(@NotNull String hostname) {
        t.i(hostname, "hostname");
        return Build.VERSION.SDK_INT >= 24 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname) : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    @Override // qa.j
    public void m(@NotNull String message, @Nullable Object obj) {
        t.i(message, "message");
        if (this.f33204e.b(obj)) {
            return;
        }
        j.l(this, message, 5, null, 4, null);
    }
}
