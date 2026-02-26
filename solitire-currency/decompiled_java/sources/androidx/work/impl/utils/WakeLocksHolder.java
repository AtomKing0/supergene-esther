package androidx.work.impl.utils;

import android.os.PowerManager;
import java.util.WeakHashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WakeLocks.kt */
/* JADX INFO: loaded from: classes2.dex */
final class WakeLocksHolder {

    @NotNull
    public static final WakeLocksHolder INSTANCE = new WakeLocksHolder();

    @NotNull
    private static final WeakHashMap<PowerManager.WakeLock, String> wakeLocks = new WeakHashMap<>();

    private WakeLocksHolder() {
    }

    @NotNull
    public final WeakHashMap<PowerManager.WakeLock, String> getWakeLocks() {
        return wakeLocks;
    }
}
