package ra;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import android.os.Build;
import ga.a0;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Android10SocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"NewApi"})
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f33411a = new a(null);

    /* JADX INFO: compiled from: Android10SocketAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final m a() {
            if (b()) {
                return new c();
            }
            return null;
        }

        public final boolean b() {
            return qa.j.f33228a.h() && Build.VERSION.SDK_INT >= 29;
        }
    }

    @Override // ra.m
    public boolean a(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sslSocket);
    }

    @Override // ra.m
    @SuppressLint({"NewApi"})
    @Nullable
    public String b(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        String applicationProtocol = sslSocket.getApplicationProtocol();
        if (applicationProtocol == null ? true : t.d(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // ra.m
    @SuppressLint({"NewApi"})
    public void c(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends a0> protocols) throws IOException {
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sslSocket, true);
            SSLParameters sSLParameters = sslSocket.getSSLParameters();
            Object[] array = qa.j.f33228a.b(protocols).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            sSLParameters.setApplicationProtocols((String[]) array);
            sslSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e10) {
            throw new IOException("Android internal error", e10);
        }
    }

    @Override // ra.m
    public boolean isSupported() {
        return f33411a.b();
    }
}
