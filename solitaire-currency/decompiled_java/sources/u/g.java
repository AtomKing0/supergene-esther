package u;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import u.e;

/* JADX INFO: compiled from: NetworkObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"MissingPermission"})
final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ConnectivityManager f34220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final e.a f34221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final a f34222c;

    /* JADX INFO: compiled from: NetworkObserver.kt */
    public static final class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NotNull Network network) {
            g.this.d(network, true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NotNull Network network) {
            g.this.d(network, false);
        }
    }

    public g(@NotNull ConnectivityManager connectivityManager, @NotNull e.a aVar) {
        this.f34220a = connectivityManager;
        this.f34221b = aVar;
        a aVar2 = new a();
        this.f34222c = aVar2;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), aVar2);
    }

    private final boolean c(Network network) {
        NetworkCapabilities networkCapabilities = this.f34220a.getNetworkCapabilities(network);
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Network network, boolean z10) {
        Network[] allNetworks = this.f34220a.getAllNetworks();
        int length = allNetworks.length;
        boolean z11 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            Network network2 = allNetworks[i10];
            if (t.d(network2, network) ? z10 : c(network2)) {
                z11 = true;
                break;
            }
            i10++;
        }
        this.f34221b.a(z11);
    }

    @Override // u.e
    public boolean a() {
        for (Network network : this.f34220a.getAllNetworks()) {
            if (c(network)) {
                return true;
            }
        }
        return false;
    }

    @Override // u.e
    public void shutdown() {
        this.f34220a.unregisterNetworkCallback(this.f34222c);
    }
}
