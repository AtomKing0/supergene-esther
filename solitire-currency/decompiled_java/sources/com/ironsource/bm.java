package com.ironsource;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class bm implements yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11436a = bm.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11437b = 23;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zd f11438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f11439d;

    class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11440a;

        a(Context context) {
            this.f11440a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (network != null) {
                bm.this.f11438c.a(s8.a(network, this.f11440a), s8.a(this.f11440a, network));
                return;
            }
            zd zdVar = bm.this.f11438c;
            String strB = s8.b(this.f11440a);
            Context context = this.f11440a;
            zdVar.a(strB, s8.a(context, s8.a(context)));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (network != null) {
                bm.this.f11438c.b(s8.a(network, this.f11440a), s8.a(this.f11440a, network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            if (network != null) {
                bm.this.f11438c.b(s8.a(network, this.f11440a), s8.a(this.f11440a, network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (s8.b(this.f11440a).equals("none")) {
                bm.this.f11438c.a();
            }
        }
    }

    public bm(zd zdVar) {
        this.f11438c = zdVar;
    }

    @Override // com.ironsource.yd
    @SuppressLint({"NewApi", "MissingPermission"})
    public void b(Context context) {
        if (Build.VERSION.SDK_INT >= this.f11437b) {
            a(context);
            if (s8.b(context).equals("none")) {
                this.f11438c.a();
            }
            if (this.f11439d == null) {
                this.f11439d = new a(context);
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(networkRequestBuild, this.f11439d);
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                Log.e(this.f11436a, "NetworkCallback was not able to register");
            }
        }
    }

    @Override // com.ironsource.yd
    public JSONObject c(Context context) {
        return s8.a(context, s8.a(context));
    }

    @Override // com.ironsource.yd
    public void a() {
        this.f11439d = null;
    }

    @Override // com.ironsource.yd
    @SuppressLint({"NewApi"})
    public void a(Context context) {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT < this.f11437b || this.f11439d == null || context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(this.f11439d);
        } catch (Exception e10) {
            i9.d().a(e10);
            Log.e(this.f11436a, "NetworkCallback for was not registered or already unregistered");
        }
    }
}
