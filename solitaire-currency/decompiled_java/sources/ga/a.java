package ga;

import androidx.webkit.ProxyConfig;
import com.ironsource.mediationsdk.logger.IronSourceError;
import ga.v;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Address.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final q f25923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SocketFactory f25924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final SSLSocketFactory f25925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final HostnameVerifier f25926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final g f25927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final b f25928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final Proxy f25929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final ProxySelector f25930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final v f25931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final List<a0> f25932j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final List<l> f25933k;

    public a(@NotNull String uriHost, int i10, @NotNull q dns, @NotNull SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable g gVar, @NotNull b proxyAuthenticator, @Nullable Proxy proxy, @NotNull List<? extends a0> protocols, @NotNull List<l> connectionSpecs, @NotNull ProxySelector proxySelector) {
        kotlin.jvm.internal.t.i(uriHost, "uriHost");
        kotlin.jvm.internal.t.i(dns, "dns");
        kotlin.jvm.internal.t.i(socketFactory, "socketFactory");
        kotlin.jvm.internal.t.i(proxyAuthenticator, "proxyAuthenticator");
        kotlin.jvm.internal.t.i(protocols, "protocols");
        kotlin.jvm.internal.t.i(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.t.i(proxySelector, "proxySelector");
        this.f25923a = dns;
        this.f25924b = socketFactory;
        this.f25925c = sSLSocketFactory;
        this.f25926d = hostnameVerifier;
        this.f25927e = gVar;
        this.f25928f = proxyAuthenticator;
        this.f25929g = proxy;
        this.f25930h = proxySelector;
        this.f25931i = new v.a().x(sSLSocketFactory != null ? "https" : ProxyConfig.MATCH_HTTP).n(uriHost).t(i10).c();
        this.f25932j = ha.d.T(protocols);
        this.f25933k = ha.d.T(connectionSpecs);
    }

    @Nullable
    public final g a() {
        return this.f25927e;
    }

    @NotNull
    public final List<l> b() {
        return this.f25933k;
    }

    @NotNull
    public final q c() {
        return this.f25923a;
    }

    public final boolean d(@NotNull a that) {
        kotlin.jvm.internal.t.i(that, "that");
        return kotlin.jvm.internal.t.d(this.f25923a, that.f25923a) && kotlin.jvm.internal.t.d(this.f25928f, that.f25928f) && kotlin.jvm.internal.t.d(this.f25932j, that.f25932j) && kotlin.jvm.internal.t.d(this.f25933k, that.f25933k) && kotlin.jvm.internal.t.d(this.f25930h, that.f25930h) && kotlin.jvm.internal.t.d(this.f25929g, that.f25929g) && kotlin.jvm.internal.t.d(this.f25925c, that.f25925c) && kotlin.jvm.internal.t.d(this.f25926d, that.f25926d) && kotlin.jvm.internal.t.d(this.f25927e, that.f25927e) && this.f25931i.n() == that.f25931i.n();
    }

    @Nullable
    public final HostnameVerifier e() {
        return this.f25926d;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (kotlin.jvm.internal.t.d(this.f25931i, aVar.f25931i) && d(aVar)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<a0> f() {
        return this.f25932j;
    }

    @Nullable
    public final Proxy g() {
        return this.f25929g;
    }

    @NotNull
    public final b h() {
        return this.f25928f;
    }

    public int hashCode() {
        return ((((((((((((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f25931i.hashCode()) * 31) + this.f25923a.hashCode()) * 31) + this.f25928f.hashCode()) * 31) + this.f25932j.hashCode()) * 31) + this.f25933k.hashCode()) * 31) + this.f25930h.hashCode()) * 31) + Objects.hashCode(this.f25929g)) * 31) + Objects.hashCode(this.f25925c)) * 31) + Objects.hashCode(this.f25926d)) * 31) + Objects.hashCode(this.f25927e);
    }

    @NotNull
    public final ProxySelector i() {
        return this.f25930h;
    }

    @NotNull
    public final SocketFactory j() {
        return this.f25924b;
    }

    @Nullable
    public final SSLSocketFactory k() {
        return this.f25925c;
    }

    @NotNull
    public final v l() {
        return this.f25931i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f25931i.i());
        sb.append(':');
        sb.append(this.f25931i.n());
        sb.append(", ");
        Proxy proxy = this.f25929g;
        sb.append(proxy != null ? kotlin.jvm.internal.t.r("proxy=", proxy) : kotlin.jvm.internal.t.r("proxySelector=", this.f25930h));
        sb.append('}');
        return sb.toString();
    }
}
