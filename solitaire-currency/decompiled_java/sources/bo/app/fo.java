package bo.app;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: classes2.dex */
public final class fo extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zo f2838a;

    public fo(zo zoVar) {
        this.f2838a = zoVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        kotlin.jvm.internal.t.i(network, "network");
        kotlin.jvm.internal.t.i(networkCapabilities, "networkCapabilities");
        super.onCapabilitiesChanged(network, networkCapabilities);
        this.f2838a.a(networkCapabilities);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        kotlin.jvm.internal.t.i(network, "network");
        super.onLost(network);
        Network activeNetwork = this.f2838a.f4464i.getActiveNetwork();
        zo zoVar = this.f2838a;
        zoVar.a(zoVar.f4464i.getNetworkCapabilities(activeNetwork));
    }
}
