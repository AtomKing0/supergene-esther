package la;

import ga.f0;
import ga.r;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.a0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f31069i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ga.a f31070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h f31071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ga.e f31072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final r f31073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private List<? extends Proxy> f31074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f31075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private List<? extends InetSocketAddress> f31076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final List<f0> f31077h;

    /* JADX INFO: compiled from: RouteSelector.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @NotNull
        public final String a(@NotNull InetSocketAddress inetSocketAddress) {
            t.i(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                t.h(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            t.h(hostAddress, "address.hostAddress");
            return hostAddress;
        }
    }

    /* JADX INFO: compiled from: RouteSelector.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<f0> f31078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f31079b;

        public b(@NotNull List<f0> routes) {
            t.i(routes, "routes");
            this.f31078a = routes;
        }

        @NotNull
        public final List<f0> a() {
            return this.f31078a;
        }

        public final boolean b() {
            return this.f31079b < this.f31078a.size();
        }

        @NotNull
        public final f0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<f0> list = this.f31078a;
            int i10 = this.f31079b;
            this.f31079b = i10 + 1;
            return list.get(i10);
        }
    }

    public j(@NotNull ga.a address, @NotNull h routeDatabase, @NotNull ga.e call, @NotNull r eventListener) {
        t.i(address, "address");
        t.i(routeDatabase, "routeDatabase");
        t.i(call, "call");
        t.i(eventListener, "eventListener");
        this.f31070a = address;
        this.f31071b = routeDatabase;
        this.f31072c = call;
        this.f31073d = eventListener;
        this.f31074e = v.l();
        this.f31076g = v.l();
        this.f31077h = new ArrayList();
        f(address.l(), address.g());
    }

    private final boolean b() {
        return this.f31075f < this.f31074e.size();
    }

    private final Proxy d() throws IOException {
        if (b()) {
            List<? extends Proxy> list = this.f31074e;
            int i10 = this.f31075f;
            this.f31075f = i10 + 1;
            Proxy proxy = list.get(i10);
            e(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f31070a.l().i() + "; exhausted proxy configurations: " + this.f31074e);
    }

    private final void e(Proxy proxy) throws IOException {
        String strI;
        int iN;
        ArrayList arrayList = new ArrayList();
        this.f31076g = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strI = this.f31070a.l().i();
            iN = this.f31070a.l().n();
        } else {
            SocketAddress proxyAddress = proxy.address();
            if (!(proxyAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(t.r("Proxy.address() is not an InetSocketAddress: ", proxyAddress.getClass()).toString());
            }
            a aVar = f31069i;
            t.h(proxyAddress, "proxyAddress");
            InetSocketAddress inetSocketAddress = (InetSocketAddress) proxyAddress;
            strI = aVar.a(inetSocketAddress);
            iN = inetSocketAddress.getPort();
        }
        boolean z10 = false;
        if (1 <= iN && iN < 65536) {
            z10 = true;
        }
        if (!z10) {
            throw new SocketException("No route to " + strI + ':' + iN + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(strI, iN));
            return;
        }
        this.f31073d.n(this.f31072c, strI);
        List<InetAddress> listA = this.f31070a.c().a(strI);
        if (listA.isEmpty()) {
            throw new UnknownHostException(this.f31070a.c() + " returned no addresses for " + strI);
        }
        this.f31073d.m(this.f31072c, strI, listA);
        Iterator<InetAddress> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(new InetSocketAddress(it.next(), iN));
        }
    }

    private final void f(ga.v vVar, Proxy proxy) {
        this.f31073d.p(this.f31072c, vVar);
        List<Proxy> listG = g(proxy, vVar, this);
        this.f31074e = listG;
        this.f31075f = 0;
        this.f31073d.o(this.f31072c, vVar, listG);
    }

    private static final List<Proxy> g(Proxy proxy, ga.v vVar, j jVar) {
        if (proxy != null) {
            return u.e(proxy);
        }
        URI uriS = vVar.s();
        if (uriS.getHost() == null) {
            return ha.d.w(Proxy.NO_PROXY);
        }
        List<Proxy> proxiesOrNull = jVar.f31070a.i().select(uriS);
        List<Proxy> list = proxiesOrNull;
        if (list == null || list.isEmpty()) {
            return ha.d.w(Proxy.NO_PROXY);
        }
        t.h(proxiesOrNull, "proxiesOrNull");
        return ha.d.T(proxiesOrNull);
    }

    public final boolean a() {
        return b() || (this.f31077h.isEmpty() ^ true);
    }

    @NotNull
    public final b c() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy proxyD = d();
            Iterator<? extends InetSocketAddress> it = this.f31076g.iterator();
            while (it.hasNext()) {
                f0 f0Var = new f0(this.f31070a, proxyD, it.next());
                if (this.f31071b.c(f0Var)) {
                    this.f31077h.add(f0Var);
                } else {
                    arrayList.add(f0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            a0.B(arrayList, this.f31077h);
            this.f31077h.clear();
        }
        return new b(arrayList);
    }
}
