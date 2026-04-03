package ia;

import ga.b;
import ga.b0;
import ga.f0;
import ga.h;
import ga.o;
import ga.q;
import ga.v;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JavaNetAuthenticator.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final q f26633d;

    /* JADX INFO: renamed from: ia.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JavaNetAuthenticator.kt */
    public /* synthetic */ class C0572a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26634a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            f26634a = iArr;
        }
    }

    public a(@NotNull q defaultDns) {
        t.i(defaultDns, "defaultDns");
        this.f26633d = defaultDns;
    }

    private final InetAddress b(Proxy proxy, v vVar, q qVar) throws IOException {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : C0572a.f26634a[type.ordinal()]) == 1) {
            return (InetAddress) d0.i0(qVar.a(vVar.i()));
        }
        SocketAddress socketAddressAddress = proxy.address();
        if (socketAddressAddress == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        t.h(address, "address() as InetSocketAddress).address");
        return address;
    }

    @Override // ga.b
    @Nullable
    public b0 a(@Nullable f0 f0Var, @NotNull ga.d0 response) throws IOException {
        ga.a aVarA;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        t.i(response, "response");
        List<h> listN = response.n();
        b0 b0VarI0 = response.I0();
        v vVarK = b0VarI0.k();
        boolean z10 = response.q() == 407;
        Proxy proxy = f0Var == null ? null : f0Var.b();
        if (proxy == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (h hVar : listN) {
            if (p9.q.x("Basic", hVar.c(), true)) {
                q qVarC = (f0Var == null || (aVarA = f0Var.a()) == null) ? null : aVarA.c();
                if (qVarC == null) {
                    qVarC = this.f26633d;
                }
                if (z10) {
                    SocketAddress socketAddressAddress = proxy.address();
                    if (socketAddressAddress == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                    String hostName = inetSocketAddress.getHostName();
                    t.h(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, vVarK, qVarC), inetSocketAddress.getPort(), vVarK.r(), hVar.b(), hVar.c(), vVarK.t(), Authenticator.RequestorType.PROXY);
                } else {
                    String strI = vVarK.i();
                    t.h(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(strI, b(proxy, vVarK, qVarC), vVarK.n(), vVarK.r(), hVar.b(), hVar.c(), vVarK.t(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    String str = z10 ? "Proxy-Authorization" : "Authorization";
                    String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    t.h(userName, "auth.userName");
                    char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    t.h(password, "auth.password");
                    return b0VarI0.i().g(str, o.a(userName, new String(password), hVar.a())).b();
                }
            }
        }
        return null;
    }

    public /* synthetic */ a(q qVar, int i10, k kVar) {
        this((i10 & 1) != 0 ? q.f26194b : qVar);
    }
}
