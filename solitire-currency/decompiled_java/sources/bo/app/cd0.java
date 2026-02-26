package bo.app;

import com.braze.support.BrazeLogger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class cd0 extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f2505a;

    public cd0() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, null, null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        kotlin.jvm.internal.t.h(socketFactory, "sslContext.socketFactory");
        this.f2505a = socketFactory;
    }

    public final Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ArrayList arrayList = new ArrayList();
            SSLSocket sSLSocket = (SSLSocket) socket;
            String[] supportedProtocols = sSLSocket.getSupportedProtocols();
            kotlin.jvm.internal.t.h(supportedProtocols, "socket.supportedProtocols");
            for (String protocol : supportedProtocols) {
                if (!kotlin.jvm.internal.t.d(protocol, "SSLv3")) {
                    kotlin.jvm.internal.t.h(protocol, "protocol");
                    arrayList.add(protocol);
                }
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new bd0(arrayList), 6, (Object) null);
            sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[0]));
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        Socket socketCreateSocket = this.f2505a.createSocket();
        kotlin.jvm.internal.t.h(socketCreateSocket, "internalSSLSocketFactory.createSocket()");
        return a(socketCreateSocket);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        String[] defaultCipherSuites = this.f2505a.getDefaultCipherSuites();
        kotlin.jvm.internal.t.h(defaultCipherSuites, "internalSSLSocketFactory.defaultCipherSuites");
        return defaultCipherSuites;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        String[] supportedCipherSuites = this.f2505a.getSupportedCipherSuites();
        kotlin.jvm.internal.t.h(supportedCipherSuites, "internalSSLSocketFactory.supportedCipherSuites");
        return supportedCipherSuites;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String host, int i10) throws IOException {
        kotlin.jvm.internal.t.i(host, "host");
        Socket socketCreateSocket = this.f2505a.createSocket(host, i10);
        kotlin.jvm.internal.t.h(socketCreateSocket, "internalSSLSocketFactory.createSocket(host, port)");
        return a(socketCreateSocket);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String host, int i10, InetAddress localHost, int i11) throws IOException {
        kotlin.jvm.internal.t.i(host, "host");
        kotlin.jvm.internal.t.i(localHost, "localHost");
        Socket socketCreateSocket = this.f2505a.createSocket(host, i10, localHost, i11);
        kotlin.jvm.internal.t.h(socketCreateSocket, "internalSSLSocketFactory…rt, localHost, localPort)");
        return a(socketCreateSocket);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress host, int i10) throws IOException {
        kotlin.jvm.internal.t.i(host, "host");
        Socket socketCreateSocket = this.f2505a.createSocket(host, i10);
        kotlin.jvm.internal.t.h(socketCreateSocket, "internalSSLSocketFactory.createSocket(host, port)");
        return a(socketCreateSocket);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress address, int i10, InetAddress localAddress, int i11) throws IOException {
        kotlin.jvm.internal.t.i(address, "address");
        kotlin.jvm.internal.t.i(localAddress, "localAddress");
        Socket socketCreateSocket = this.f2505a.createSocket(address, i10, localAddress, i11);
        kotlin.jvm.internal.t.h(socketCreateSocket, "internalSSLSocketFactory… localAddress, localPort)");
        return a(socketCreateSocket);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String host, int i10, boolean z10) throws IOException {
        kotlin.jvm.internal.t.i(socket, "socket");
        kotlin.jvm.internal.t.i(host, "host");
        Socket socketCreateSocket = this.f2505a.createSocket(socket, host, i10, z10);
        kotlin.jvm.internal.t.h(socketCreateSocket, "internalSSLSocketFactory…t, host, port, autoClose)");
        return a(socketCreateSocket);
    }
}
