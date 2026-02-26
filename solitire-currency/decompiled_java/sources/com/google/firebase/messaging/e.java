package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.c;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: DisplayNotification.java */
/* JADX INFO: loaded from: classes3.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f10387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f10388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k0 f10389c;

    public e(Context context, k0 k0Var, ExecutorService executorService) {
        this.f10387a = executorService;
        this.f10388b = context;
        this.f10389c = k0Var;
    }

    private boolean b() {
        if (((KeyguardManager) this.f10388b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!PlatformVersion.isAtLeastLollipop()) {
            SystemClock.sleep(10L);
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f10388b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    private void c(c.a aVar) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f10388b.getSystemService("notification")).notify(aVar.f10374b, aVar.f10375c, aVar.f10373a.build());
    }

    @Nullable
    private g0 d() {
        g0 g0VarN = g0.n(this.f10389c.p("gcm.n.image"));
        if (g0VarN != null) {
            g0VarN.z(this.f10387a);
        }
        return g0VarN;
    }

    private void e(NotificationCompat.Builder builder, @Nullable g0 g0Var) {
        if (g0Var == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(g0Var.q(), 5L, TimeUnit.SECONDS);
            builder.setLargeIcon(bitmap);
            builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon((Bitmap) null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            g0Var.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e10) {
            Log.w("FirebaseMessaging", "Failed to download image: " + e10.getCause());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            g0Var.close();
        }
    }

    boolean a() {
        if (this.f10389c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        g0 g0VarD = d();
        c.a aVarE = c.e(this.f10388b, this.f10389c);
        e(aVarE.f10373a, g0VarD);
        c(aVarE);
        return true;
    }
}
