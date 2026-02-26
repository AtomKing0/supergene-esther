package k2;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;
import com.ironsource.r8;

/* JADX INFO: compiled from: WifiLockManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final WifiManager f29492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private WifiManager.WifiLock f29493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f29494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f29495d;

    public u3(Context context) {
        this.f29492a = (WifiManager) context.getApplicationContext().getSystemService(r8.f14655b);
    }

    private void c() {
        WifiManager.WifiLock wifiLock = this.f29493b;
        if (wifiLock == null) {
            return;
        }
        if (this.f29494c && this.f29495d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }

    public void a(boolean z10) {
        if (z10 && this.f29493b == null) {
            WifiManager wifiManager = this.f29492a;
            if (wifiManager == null) {
                a4.t.i("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.f29493b = wifiLockCreateWifiLock;
                wifiLockCreateWifiLock.setReferenceCounted(false);
            }
        }
        this.f29494c = z10;
        c();
    }

    public void b(boolean z10) {
        this.f29495d = z10;
        c();
    }
}
