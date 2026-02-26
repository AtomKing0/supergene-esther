package ra;

import ga.a0;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.t;
import org.conscrypt.Conscrypt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ra.l;

/* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f33433a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final l.a f33434b = new a();

    /* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
    public static final class a implements l.a {
        a() {
        }

        @Override // ra.l.a
        public boolean a(@NotNull SSLSocket sslSocket) {
            t.i(sslSocket, "sslSocket");
            return qa.d.f33210e.c() && Conscrypt.isConscrypt(sslSocket);
        }

        @Override // ra.l.a
        @NotNull
        public m b(@NotNull SSLSocket sslSocket) {
            t.i(sslSocket, "sslSocket");
            return new k();
        }
    }

    /* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final l.a a() {
            return k.f33434b;
        }
    }

    @Override // ra.m
    public boolean a(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket);
    }

    @Override // ra.m
    @Nullable
    public String b(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        if (a(sslSocket)) {
            return Conscrypt.getApplicationProtocol(sslSocket);
        }
        return null;
    }

    @Override // ra.m
    public void c(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends a0> protocols) {
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
        if (a(sslSocket)) {
            Conscrypt.setUseSessionTickets(sslSocket, true);
            Object[] array = qa.j.f33228a.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
        }
    }

    @Override // ra.m
    public boolean isSupported() {
        return qa.d.f33210e.c();
    }
}
