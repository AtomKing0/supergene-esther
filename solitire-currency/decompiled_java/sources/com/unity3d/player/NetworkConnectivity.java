package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkConnectivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ConnectivityManager f23970a;

    public NetworkConnectivity(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f23970a = connectivityManager;
        if (connectivityManager == null) {
            AbstractC3275z.Log(6, "NetworkConnectivity: ConnectivityManager not found");
        }
    }

    public int b() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.f23970a;
        if (connectivityManager == null) {
            return 0;
        }
        if (PlatformSupport.MARSHMALLOW_SUPPORT) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = this.f23970a.getNetworkCapabilities(activeNetwork)) != null) {
                return networkCapabilities.hasTransport(0) ? 1 : 2;
            }
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 0 ? 1 : 2;
            }
        }
        return 0;
    }

    public void a() {
    }
}
