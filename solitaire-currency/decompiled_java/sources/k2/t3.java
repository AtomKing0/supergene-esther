package k2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: WakeLockManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class t3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final PowerManager f29485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private PowerManager.WakeLock f29486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f29487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f29488d;

    public t3(Context context) {
        this.f29485a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @SuppressLint({"WakelockTimeout"})
    private void c() {
        PowerManager.WakeLock wakeLock = this.f29486b;
        if (wakeLock == null) {
            return;
        }
        if (this.f29487c && this.f29488d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }

    public void a(boolean z10) {
        if (z10 && this.f29486b == null) {
            PowerManager powerManager = this.f29485a;
            if (powerManager == null) {
                a4.t.i("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.f29486b = wakeLockNewWakeLock;
                wakeLockNewWakeLock.setReferenceCounted(false);
            }
        }
        this.f29487c = z10;
        c();
    }

    public void b(boolean z10) {
        this.f29488d = z10;
        c();
    }
}
