package la;

import ga.l;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ConnectionSpecSelector.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<l> f30982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f30984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30985d;

    public b(@NotNull List<l> connectionSpecs) {
        t.i(connectionSpecs, "connectionSpecs");
        this.f30982a = connectionSpecs;
    }

    private final boolean c(SSLSocket sSLSocket) {
        int i10 = this.f30983b;
        int size = this.f30982a.size();
        while (i10 < size) {
            int i11 = i10 + 1;
            if (this.f30982a.get(i10).e(sSLSocket)) {
                return true;
            }
            i10 = i11;
        }
        return false;
    }

    @NotNull
    public final l a(@NotNull SSLSocket sslSocket) throws IOException {
        l lVar;
        t.i(sslSocket, "sslSocket");
        int i10 = this.f30983b;
        int size = this.f30982a.size();
        while (true) {
            if (i10 >= size) {
                lVar = null;
                break;
            }
            int i11 = i10 + 1;
            lVar = this.f30982a.get(i10);
            if (lVar.e(sslSocket)) {
                this.f30983b = i11;
                break;
            }
            i10 = i11;
        }
        if (lVar != null) {
            this.f30984c = c(sslSocket);
            lVar.c(sslSocket, this.f30985d);
            return lVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.f30985d);
        sb.append(", modes=");
        sb.append(this.f30982a);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        t.f(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        t.h(string, "toString(this)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    public final boolean b(@NotNull IOException e10) {
        t.i(e10, "e");
        this.f30985d = true;
        return (!this.f30984c || (e10 instanceof ProtocolException) || (e10 instanceof InterruptedIOException) || ((e10 instanceof SSLHandshakeException) && (e10.getCause() instanceof CertificateException)) || (e10 instanceof SSLPeerUnverifiedException) || !(e10 instanceof SSLException)) ? false : true;
    }
}
