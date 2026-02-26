package qa;

import ga.a0;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.p;

/* JADX INFO: compiled from: Jdk9Platform.kt */
/* JADX INFO: loaded from: classes5.dex */
public class h extends j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f33223d = new a(0 == true ? 1 : 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f33224e;

    /* JADX INFO: compiled from: Jdk9Platform.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @Nullable
        public final h a() {
            if (b()) {
                return new h();
            }
            return null;
        }

        public final boolean b() {
            return h.f33224e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String property = System.getProperty("java.specification.version");
        Integer numL = property != null ? p.l(property) : null;
        boolean z10 = true;
        if (numL == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
            } catch (NoSuchMethodException unused) {
                z10 = false;
            }
        } else if (numL.intValue() < 9) {
            z10 = false;
        }
        f33224e = z10;
    }

    @Override // qa.j
    public void e(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<a0> protocols) {
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
        SSLParameters sSLParameters = sslSocket.getSSLParameters();
        Object[] array = j.f33228a.b(protocols).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        sSLParameters.setApplicationProtocols((String[]) array);
        sslSocket.setSSLParameters(sSLParameters);
    }

    @Override // qa.j
    @Nullable
    public String h(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        try {
            String applicationProtocol = sslSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : t.d(applicationProtocol, "")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
