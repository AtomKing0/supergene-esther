package com.unity3d.player;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkConnectivityNougat extends NetworkConnectivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConnectivityManager.NetworkCallback f23972c;

    public NetworkConnectivityNougat(Context context) {
        super(context);
        this.f23971b = 0;
        A a10 = new A(this);
        this.f23972c = a10;
        if (this.f23970a == null) {
            return;
        }
        this.f23971b = super.b();
        this.f23970a.registerDefaultNetworkCallback(a10);
    }

    @Override // com.unity3d.player.NetworkConnectivity
    public final void a() {
        ConnectivityManager connectivityManager = this.f23970a;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(this.f23972c);
    }

    @Override // com.unity3d.player.NetworkConnectivity
    public final int b() {
        return this.f23971b;
    }
}
