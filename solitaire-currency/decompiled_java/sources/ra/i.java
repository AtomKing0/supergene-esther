package ra;

import ga.a0;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.t;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ra.l;

/* JADX INFO: compiled from: BouncyCastleSocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f33427a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final l.a f33428b = new a();

    /* JADX INFO: compiled from: BouncyCastleSocketAdapter.kt */
    public static final class a implements l.a {
        a() {
        }

        @Override // ra.l.a
        public boolean a(@NotNull SSLSocket sslSocket) {
            t.i(sslSocket, "sslSocket");
            return qa.c.f33207e.b() && (sslSocket instanceof BCSSLSocket);
        }

        @Override // ra.l.a
        @NotNull
        public m b(@NotNull SSLSocket sslSocket) {
            t.i(sslSocket, "sslSocket");
            return new i();
        }
    }

    /* JADX INFO: compiled from: BouncyCastleSocketAdapter.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final l.a a() {
            return i.f33428b;
        }
    }

    @Override // ra.m
    public boolean a(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        return sslSocket instanceof BCSSLSocket;
    }

    @Override // ra.m
    @Nullable
    public String b(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : t.d(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // ra.m
    public void c(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends a0> protocols) {
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
        if (a(sslSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sslSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            Object[] array = qa.j.f33228a.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
        }
    }

    @Override // ra.m
    public boolean isSupported() {
        return qa.c.f33207e.b();
    }
}
