package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SyncTask.java */
/* JADX INFO: loaded from: classes3.dex */
class a1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PowerManager.WakeLock f10361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FirebaseMessaging f10362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"ThreadPoolCreation"})
    @VisibleForTesting
    ExecutorService f10363d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));

    /* JADX INFO: compiled from: SyncTask.java */
    @VisibleForTesting
    static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private a1 f10364a;

        public a(a1 a1Var) {
            this.f10364a = a1Var;
        }

        public void a() {
            if (a1.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            this.f10364a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a1 a1Var = this.f10364a;
            if (a1Var != null && a1Var.d()) {
                if (a1.c()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.f10364a.f10362c.enqueueTaskWithDelaySeconds(this.f10364a, 0L);
                this.f10364a.b().unregisterReceiver(this);
                this.f10364a = null;
            }
        }
    }

    @SuppressLint({"InvalidWakeLockTag"})
    @VisibleForTesting
    public a1(FirebaseMessaging firebaseMessaging, long j10) {
        this.f10362c = firebaseMessaging;
        this.f10360a = j10;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f10361b = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    static boolean c() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    Context b() {
        return this.f10362c.getApplicationContext();
    }

    boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @VisibleForTesting
    boolean e() throws IOException {
        try {
            if (this.f10362c.blockingGetToken() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e10) {
            if (!e0.h(e10.getMessage())) {
                if (e10.getMessage() != null) {
                    throw e10;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e10.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"WakelockTimeout"})
    public void run() {
        if (w0.b().e(b())) {
            this.f10361b.acquire();
        }
        try {
            try {
                this.f10362c.setSyncScheduledOrRunning(true);
            } catch (IOException e10) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e10.getMessage() + ". Won't retry the operation.");
                this.f10362c.setSyncScheduledOrRunning(false);
                if (!w0.b().e(b())) {
                    return;
                }
            }
            if (!this.f10362c.isGmsCorePresent()) {
                this.f10362c.setSyncScheduledOrRunning(false);
                if (w0.b().e(b())) {
                    this.f10361b.release();
                    return;
                }
                return;
            }
            if (w0.b().d(b()) && !d()) {
                new a(this).a();
                if (w0.b().e(b())) {
                    this.f10361b.release();
                    return;
                }
                return;
            }
            if (e()) {
                this.f10362c.setSyncScheduledOrRunning(false);
            } else {
                this.f10362c.syncWithDelaySecondsInternal(this.f10360a);
            }
            if (!w0.b().e(b())) {
                return;
            }
            this.f10361b.release();
        } catch (Throwable th) {
            if (w0.b().e(b())) {
                this.f10361b.release();
            }
            throw th;
        }
    }
}
