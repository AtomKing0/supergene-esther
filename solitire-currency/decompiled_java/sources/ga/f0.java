package ga;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Route.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final a f26057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Proxy f26058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final InetSocketAddress f26059c;

    public f0(@NotNull a address, @NotNull Proxy proxy, @NotNull InetSocketAddress socketAddress) {
        kotlin.jvm.internal.t.i(address, "address");
        kotlin.jvm.internal.t.i(proxy, "proxy");
        kotlin.jvm.internal.t.i(socketAddress, "socketAddress");
        this.f26057a = address;
        this.f26058b = proxy;
        this.f26059c = socketAddress;
    }

    @NotNull
    public final a a() {
        return this.f26057a;
    }

    @NotNull
    public final Proxy b() {
        return this.f26058b;
    }

    public final boolean c() {
        return this.f26057a.k() != null && this.f26058b.type() == Proxy.Type.HTTP;
    }

    @NotNull
    public final InetSocketAddress d() {
        return this.f26059c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof f0) {
            f0 f0Var = (f0) obj;
            if (kotlin.jvm.internal.t.d(f0Var.f26057a, this.f26057a) && kotlin.jvm.internal.t.d(f0Var.f26058b, this.f26058b) && kotlin.jvm.internal.t.d(f0Var.f26059c, this.f26059c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f26057a.hashCode()) * 31) + this.f26058b.hashCode()) * 31) + this.f26059c.hashCode();
    }

    @NotNull
    public String toString() {
        return "Route{" + this.f26059c + '}';
    }
}
