package com.unity3d.player;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: classes4.dex */
final class A extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ NetworkConnectivityNougat f23913a;

    A(NetworkConnectivityNougat networkConnectivityNougat) {
        this.f23913a = networkConnectivityNougat;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        NetworkConnectivityNougat networkConnectivityNougat;
        int i10;
        super.onCapabilitiesChanged(network, networkCapabilities);
        if (networkCapabilities.hasTransport(0)) {
            networkConnectivityNougat = this.f23913a;
            i10 = 1;
        } else {
            networkConnectivityNougat = this.f23913a;
            i10 = 2;
        }
        networkConnectivityNougat.f23971b = i10;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        super.onLost(network);
        this.f23913a.f23971b = 0;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        super.onUnavailable();
        this.f23913a.f23971b = 0;
    }
}
