package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: WakeLockHolder.java */
/* JADX INFO: loaded from: classes3.dex */
final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f10427a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f10428b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("WakeLockHolder.syncObject")
    private static WakeLock f10429c;

    @GuardedBy("WakeLockHolder.syncObject")
    private static void b(Context context) {
        if (f10429c == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f10429c = wakeLock;
            wakeLock.setReferenceCounted(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(@NonNull Intent intent) {
        synchronized (f10428b) {
            if (f10429c != null && d(intent)) {
                g(intent, false);
                f10429c.release();
            }
        }
    }

    @VisibleForTesting
    static boolean d(@NonNull Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    @SuppressLint({"TaskMainThread"})
    static void f(Context context, m1 m1Var, final Intent intent) {
        synchronized (f10428b) {
            b(context);
            boolean zD = d(intent);
            g(intent, true);
            if (!zD) {
                f10429c.acquire(f10427a);
            }
            m1Var.c(intent).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.messaging.g1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    h1.c(intent);
                }
            });
        }
    }

    private static void g(@NonNull Intent intent, boolean z10) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z10);
    }

    static ComponentName h(@NonNull Context context, @NonNull Intent intent) {
        synchronized (f10428b) {
            b(context);
            boolean zD = d(intent);
            g(intent, true);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            if (!zD) {
                f10429c.acquire(f10427a);
            }
            return componentNameStartService;
        }
    }
}
