package com.king.amp.sa;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f16701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private AtomicLong f16702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private ConnectivityManager.NetworkCallback f16703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicInteger f16704d = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    private AtomicBoolean f16705e = new AtomicBoolean(false);

    class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            super.onAvailable(network);
            if (Build.VERSION.SDK_INT >= 26) {
                Log.d("NetworkListener", "Available: " + network.toString());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
        @Override // android.net.ConnectivityManager.NetworkCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onCapabilitiesChanged(@androidx.annotation.NonNull android.net.Network r4, @androidx.annotation.NonNull android.net.NetworkCapabilities r5) {
            /*
                r3 = this;
                super.onCapabilitiesChanged(r4, r5)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Capabilities changed for: "
                r0.append(r1)
                java.lang.String r4 = r4.toString()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                java.lang.String r0 = "NetworkListener"
                android.util.Log.d(r0, r4)
                r4 = 1
                boolean r0 = r5.hasTransport(r4)
                r1 = 0
                if (r0 == 0) goto L28
                r0 = 2
            L26:
                r2 = r4
                goto L43
            L28:
                boolean r0 = r5.hasTransport(r1)
                if (r0 == 0) goto L31
                r0 = r4
            L2f:
                r2 = r0
                goto L43
            L31:
                r0 = 3
                boolean r2 = r5.hasTransport(r0)
                if (r2 == 0) goto L39
            L38:
                goto L26
            L39:
                r0 = 4
                boolean r2 = r5.hasTransport(r0)
                if (r2 == 0) goto L41
                goto L38
            L41:
                r0 = r1
                goto L2f
            L43:
                if (r2 == 0) goto L75
                r2 = 12
                boolean r2 = r5.hasCapability(r2)
                if (r2 == 0) goto L56
                r2 = 16
                boolean r5 = r5.hasCapability(r2)
                if (r5 == 0) goto L56
                goto L57
            L56:
                r4 = r1
            L57:
                com.king.amp.sa.NetworkListener r5 = com.king.amp.sa.NetworkListener.this
                java.util.concurrent.atomic.AtomicBoolean r5 = com.king.amp.sa.NetworkListener.a(r5)
                boolean r5 = r5.get()
                if (r4 != r5) goto L6f
                com.king.amp.sa.NetworkListener r5 = com.king.amp.sa.NetworkListener.this
                java.util.concurrent.atomic.AtomicInteger r5 = com.king.amp.sa.NetworkListener.b(r5)
                int r5 = r5.get()
                if (r0 == r5) goto L7a
            L6f:
                com.king.amp.sa.NetworkListener r5 = com.king.amp.sa.NetworkListener.this
                r5.e(r0, r4)
                goto L7a
            L75:
                com.king.amp.sa.NetworkListener r4 = com.king.amp.sa.NetworkListener.this
                r4.e(r1, r1)
            L7a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.king.amp.sa.NetworkListener.a.onCapabilitiesChanged(android.net.Network, android.net.NetworkCapabilities):void");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(@NonNull Network network, int i10) {
            super.onLosing(network, i10);
            Log.d("NetworkListener", "Losing: " + network.toString());
            NetworkListener.this.e(0, false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            super.onLost(network);
            Log.d("NetworkListener", "Lost: " + network.toString());
            NetworkListener.this.e(0, false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            Log.d("NetworkListener", "Unavailable");
            NetworkListener.this.e(0, false);
        }
    }

    @RequiresApi(api = 24)
    public NetworkListener(@NonNull Context context, long j10) {
        Log.d("NetworkListener", "Create NetworkListener");
        this.f16701a = new WeakReference<>(context);
        this.f16704d.set(d());
        this.f16705e.set(this.f16704d.get() != 0);
        AtomicLong atomicLong = new AtomicLong(j10);
        this.f16702b = atomicLong;
        NativeNetworkStatusCallback(atomicLong.get(), this.f16704d.get(), this.f16705e.get());
        c(context);
    }

    @RequiresApi(24)
    private void c(@NonNull Context context) {
        Log.d("NetworkListener", "Register listener");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
        a aVar = new a();
        this.f16703c = aVar;
        if (Build.VERSION.SDK_INT >= 24) {
            connectivityManager.registerDefaultNetworkCallback(aVar);
            return;
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addCapability(16).addTransportType(1).addTransportType(4).addTransportType(0).addTransportType(3).build();
        connectivityManager.registerNetworkCallback(networkRequestBuild, this.f16703c);
        connectivityManager.requestNetwork(networkRequestBuild, this.f16703c);
    }

    private int d() {
        Context context = this.f16701a.get();
        if (context != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    return 1;
                }
                if (type == 1) {
                    return 2;
                }
                if (type == 9) {
                    return 3;
                }
                if (type == 17) {
                    return 4;
                }
            }
        }
        return 0;
    }

    public native void NativeNetworkStatusCallback(long j10, int i10, boolean z10);

    public void e(int i10, boolean z10) {
        Log.d("NetworkListener", "Network status changed: [" + i10 + "], connected: [" + z10 + "], mNetworkType: " + p1.a(i10));
        this.f16704d.set(i10);
        this.f16705e.set(z10);
        NativeNetworkStatusCallback(this.f16702b.get(), this.f16704d.get(), z10);
    }

    void f() {
        Context context;
        Log.d("NetworkListener", "Uninitializing NetworkListener");
        this.f16702b.set(0L);
        if (this.f16703c != null && (context = this.f16701a.get()) != null) {
            ((ConnectivityManager) context.getSystemService(ConnectivityManager.class)).unregisterNetworkCallback(this.f16703c);
        }
        this.f16703c = null;
    }
}
