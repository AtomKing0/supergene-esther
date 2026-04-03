package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;

/* JADX INFO: compiled from: TopicsSyncTask.java */
/* JADX INFO: loaded from: classes3.dex */
class f1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f10410f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    private static Boolean f10411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    private static Boolean f10412h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j0 f10414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PowerManager.WakeLock f10415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e1 f10416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f10417e;

    /* JADX INFO: compiled from: TopicsSyncTask.java */
    @VisibleForTesting
    class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        @GuardedBy("this")
        private f1 f10418a;

        public a(f1 f1Var) {
            this.f10418a = f1Var;
        }

        public void a() {
            if (f1.j()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            f1.this.f10413a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            f1 f1Var = this.f10418a;
            if (f1Var == null) {
                return;
            }
            if (f1Var.i()) {
                if (f1.j()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.f10418a.f10416d.m(this.f10418a, 0L);
                context.unregisterReceiver(this);
                this.f10418a = null;
            }
        }
    }

    f1(e1 e1Var, Context context, j0 j0Var, long j10) {
        this.f10416d = e1Var;
        this.f10413a = context;
        this.f10417e = j10;
        this.f10414b = j0Var;
        this.f10415c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    private static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    private static boolean f(Context context) {
        boolean zBooleanValue;
        synchronized (f10410f) {
            Boolean bool = f10412h;
            Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
            f10412h = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
        }
        return zBooleanValue;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z10 = context.checkCallingOrSelfPermission(str) == 0;
        if (!z10 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", e(str));
        }
        return z10;
    }

    private static boolean h(Context context) {
        boolean zBooleanValue;
        synchronized (f10410f) {
            Boolean bool = f10411g;
            Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
            f10411g = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
        }
        return zBooleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean i() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.Context r0 = r2.f10413a     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L20
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L12
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L20
            goto L13
        L12:
            r0 = 0
        L13:
            if (r0 == 0) goto L1d
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L1d
            r0 = 1
            goto L1e
        L1d:
            r0 = 0
        L1e:
            monitor-exit(r2)
            return r0
        L20:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.f1.i():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        PowerManager.WakeLock wakeLock;
        if (h(this.f10413a)) {
            this.f10415c.acquire(d.f10380a);
        }
        try {
            try {
                try {
                    this.f10416d.o(true);
                } catch (Throwable th) {
                    if (h(this.f10413a)) {
                        try {
                            this.f10415c.release();
                        } catch (RuntimeException unused) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                    throw th;
                }
            } catch (IOException e10) {
                Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e10.getMessage());
                this.f10416d.o(false);
                if (!h(this.f10413a)) {
                    return;
                } else {
                    wakeLock = this.f10415c;
                }
            }
            if (!this.f10414b.g()) {
                this.f10416d.o(false);
                if (h(this.f10413a)) {
                    try {
                        this.f10415c.release();
                        return;
                    } catch (RuntimeException unused2) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                }
                return;
            }
            if (f(this.f10413a) && !i()) {
                new a(this).a();
                if (h(this.f10413a)) {
                    try {
                        this.f10415c.release();
                        return;
                    } catch (RuntimeException unused3) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                }
                return;
            }
            if (this.f10416d.s()) {
                this.f10416d.o(false);
            } else {
                this.f10416d.t(this.f10417e);
            }
            if (h(this.f10413a)) {
                wakeLock = this.f10415c;
                wakeLock.release();
            }
        } catch (RuntimeException unused4) {
            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
        }
    }
}
