package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: WithinAppServiceConnection.java */
/* JADX INFO: loaded from: classes3.dex */
class m1 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f10451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f10452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue<a> f10453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private j1 f10454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f10455f;

    /* JADX INFO: compiled from: WithinAppServiceConnection.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f10456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TaskCompletionSource<Void> f10457b = new TaskCompletionSource<>();

        a(Intent intent) {
            this.f10456a = intent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            Log.w("FirebaseMessaging", "Service took too long to process intent: " + this.f10456a.getAction() + " finishing.");
            d();
        }

        void c(ScheduledExecutorService scheduledExecutorService) {
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable() { // from class: com.google.firebase.messaging.k1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10443a.f();
                }
            }, 20L, TimeUnit.SECONDS);
            e().addOnCompleteListener(scheduledExecutorService, new OnCompleteListener() { // from class: com.google.firebase.messaging.l1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    scheduledFutureSchedule.cancel(false);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d() {
            this.f10457b.trySetResult(null);
        }

        Task<Void> e() {
            return this.f10457b.getTask();
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    m1(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    @GuardedBy("this")
    private void a() {
        while (!this.f10453d.isEmpty()) {
            this.f10453d.poll().d();
        }
    }

    private synchronized void b() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "flush queue called");
        }
        while (!this.f10453d.isEmpty()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "found intent to be delivered");
            }
            j1 j1Var = this.f10454e;
            if (j1Var == null || !j1Var.isBinderAlive()) {
                d();
                return;
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
            }
            this.f10454e.c(this.f10453d.poll());
        }
    }

    @GuardedBy("this")
    private void d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("binder is dead. start connection? ");
            sb.append(!this.f10455f);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.f10455f) {
            return;
        }
        this.f10455f = true;
        try {
            if (ConnectionTracker.getInstance().bindService(this.f10450a, this.f10451b, this, 65)) {
                return;
            } else {
                Log.e("FirebaseMessaging", "binding to the service failed");
            }
        } catch (SecurityException e10) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e10);
        }
        this.f10455f = false;
        a();
    }

    synchronized Task<Void> c(Intent intent) {
        a aVar;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
        }
        aVar = new a(intent);
        aVar.c(this.f10452c);
        this.f10453d.add(aVar);
        b();
        return aVar.e();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
        }
        this.f10455f = false;
        if (iBinder instanceof j1) {
            this.f10454e = (j1) iBinder;
            b();
            return;
        }
        Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
        a();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        b();
    }

    @VisibleForTesting
    m1(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f10453d = new ArrayDeque();
        this.f10455f = false;
        Context applicationContext = context.getApplicationContext();
        this.f10450a = applicationContext;
        this.f10451b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f10452c = scheduledExecutorService;
    }
}
