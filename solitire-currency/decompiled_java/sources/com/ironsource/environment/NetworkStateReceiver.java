package com.ironsource.environment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.i9;
import com.ironsource.vm;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConnectivityManager f11965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private vm f11966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11967c = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NetworkStateReceiver.this.f11966b != null) {
                NetworkStateReceiver.this.f11966b.a(NetworkStateReceiver.this.f11967c);
            }
        }
    }

    public NetworkStateReceiver(Context context, vm vmVar) {
        this.f11966b = vmVar;
        if (context != null) {
            this.f11965a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        a();
    }

    private void b() {
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getExtras() == null || !a()) {
            return;
        }
        b();
    }

    private boolean a() {
        boolean z10 = this.f11967c;
        ConnectivityManager connectivityManager = this.f11965a;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                this.f11967c = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
            } catch (Exception e10) {
                i9.d().a(e10);
                this.f11967c = false;
            }
        } else {
            this.f11967c = false;
        }
        return z10 != this.f11967c;
    }
}
