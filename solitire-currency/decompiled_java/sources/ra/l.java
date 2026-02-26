package ra;

import ga.a0;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DeferredSocketAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final a f33435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private m f33436b;

    /* JADX INFO: compiled from: DeferredSocketAdapter.kt */
    public interface a {
        boolean a(@NotNull SSLSocket sSLSocket);

        @NotNull
        m b(@NotNull SSLSocket sSLSocket);
    }

    public l(@NotNull a socketAdapterFactory) {
        t.i(socketAdapterFactory, "socketAdapterFactory");
        this.f33435a = socketAdapterFactory;
    }

    private final synchronized m d(SSLSocket sSLSocket) {
        if (this.f33436b == null && this.f33435a.a(sSLSocket)) {
            this.f33436b = this.f33435a.b(sSLSocket);
        }
        return this.f33436b;
    }

    @Override // ra.m
    public boolean a(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        return this.f33435a.a(sslSocket);
    }

    @Override // ra.m
    @Nullable
    public String b(@NotNull SSLSocket sslSocket) {
        t.i(sslSocket, "sslSocket");
        m mVarD = d(sslSocket);
        if (mVarD == null) {
            return null;
        }
        return mVarD.b(sslSocket);
    }

    @Override // ra.m
    public void c(@NotNull SSLSocket sslSocket, @Nullable String str, @NotNull List<? extends a0> protocols) {
        t.i(sslSocket, "sslSocket");
        t.i(protocols, "protocols");
        m mVarD = d(sslSocket);
        if (mVarD == null) {
            return;
        }
        mVarD.c(sslSocket, str, protocols);
    }

    @Override // ra.m
    public boolean isSupported() {
        return true;
    }
}
