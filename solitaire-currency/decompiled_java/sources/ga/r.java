package ga;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EventListener.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f26196a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final r f26197b = new a();

    /* JADX INFO: compiled from: EventListener.kt */
    public static final class a extends r {
        a() {
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    public interface c {
        @NotNull
        r a(@NotNull e eVar);
    }

    public void A(@NotNull e call, @NotNull d0 response) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(response, "response");
    }

    public void B(@NotNull e call, @Nullable t tVar) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void C(@NotNull e call) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void a(@NotNull e call, @NotNull d0 cachedResponse) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(cachedResponse, "cachedResponse");
    }

    public void b(@NotNull e call, @NotNull d0 response) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(response, "response");
    }

    public void c(@NotNull e call) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void d(@NotNull e call) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void e(@NotNull e call, @NotNull IOException ioe) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(ioe, "ioe");
    }

    public void f(@NotNull e call) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void g(@NotNull e call) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void h(@NotNull e call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable a0 a0Var) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.t.i(proxy, "proxy");
    }

    public void i(@NotNull e call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable a0 a0Var, @NotNull IOException ioe) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.t.i(proxy, "proxy");
        kotlin.jvm.internal.t.i(ioe, "ioe");
    }

    public void j(@NotNull e call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.t.i(proxy, "proxy");
    }

    public void k(@NotNull e call, @NotNull j connection) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(connection, "connection");
    }

    public void l(@NotNull e call, @NotNull j connection) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(connection, "connection");
    }

    public void m(@NotNull e call, @NotNull String domainName, @NotNull List<InetAddress> inetAddressList) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(domainName, "domainName");
        kotlin.jvm.internal.t.i(inetAddressList, "inetAddressList");
    }

    public void n(@NotNull e call, @NotNull String domainName) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(domainName, "domainName");
    }

    public void o(@NotNull e call, @NotNull v url, @NotNull List<Proxy> proxies) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(url, "url");
        kotlin.jvm.internal.t.i(proxies, "proxies");
    }

    public void p(@NotNull e call, @NotNull v url) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(url, "url");
    }

    public void q(@NotNull e call, long j10) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void r(@NotNull e call) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void s(@NotNull e call, @NotNull IOException ioe) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(ioe, "ioe");
    }

    public void t(@NotNull e call, @NotNull b0 request) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(request, "request");
    }

    public void u(@NotNull e call) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void v(@NotNull e call, long j10) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void w(@NotNull e call) {
        kotlin.jvm.internal.t.i(call, "call");
    }

    public void x(@NotNull e call, @NotNull IOException ioe) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(ioe, "ioe");
    }

    public void y(@NotNull e call, @NotNull d0 response) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(response, "response");
    }

    public void z(@NotNull e call) {
        kotlin.jvm.internal.t.i(call, "call");
    }
}
