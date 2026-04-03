package h1;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import h1.c;

/* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
/* JADX INFO: loaded from: classes2.dex */
final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f26390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final c.a f26391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f26392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f26394e = new a();

    /* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z10 = eVar.f26392c;
            eVar.f26392c = eVar.h(context);
            if (z10 != e.this.f26392c) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f26392c);
                }
                e eVar2 = e.this;
                eVar2.f26391b.a(eVar2.f26392c);
            }
        }
    }

    e(@NonNull Context context, @NonNull c.a aVar) {
        this.f26390a = context.getApplicationContext();
        this.f26391b = aVar;
    }

    private void i() {
        if (this.f26393d) {
            return;
        }
        this.f26392c = h(this.f26390a);
        try {
            this.f26390a.registerReceiver(this.f26394e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f26393d = true;
        } catch (SecurityException e10) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e10);
            }
        }
    }

    private void j() {
        if (this.f26393d) {
            this.f26390a.unregisterReceiver(this.f26394e);
            this.f26393d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    boolean h(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) o1.j.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e10) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e10);
            }
            return true;
        }
    }

    @Override // h1.i
    public void onStart() {
        i();
    }

    @Override // h1.i
    public void onStop() {
        j();
    }

    @Override // h1.i
    public void onDestroy() {
    }
}
