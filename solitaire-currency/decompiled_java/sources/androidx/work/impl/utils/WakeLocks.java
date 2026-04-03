package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: WakeLocks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WakeLocks {

    @NotNull
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WakeLocks");
        t.h(strTagWithPrefix, "tagWithPrefix(\"WakeLocks\")");
        TAG = strTagWithPrefix;
    }

    public static final void checkWakeLocks() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        WakeLocksHolder wakeLocksHolder = WakeLocksHolder.INSTANCE;
        synchronized (wakeLocksHolder) {
            linkedHashMap.putAll(wakeLocksHolder.getWakeLocks());
            k0 k0Var = k0.f35197a;
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str = (String) entry.getValue();
            boolean z10 = false;
            if (wakeLock != null && wakeLock.isHeld()) {
                z10 = true;
            }
            if (z10) {
                Logger.get().warning(TAG, "WakeLock held for " + str);
            }
        }
    }

    @NotNull
    public static final PowerManager.WakeLock newWakeLock(@NotNull Context context, @NotNull String tag) {
        t.i(context, "context");
        t.i(tag, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        t.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String str = "WorkManager: " + tag;
        PowerManager.WakeLock wakeLock = ((PowerManager) systemService).newWakeLock(1, str);
        WakeLocksHolder wakeLocksHolder = WakeLocksHolder.INSTANCE;
        synchronized (wakeLocksHolder) {
            wakeLocksHolder.getWakeLocks().put(wakeLock, str);
        }
        t.h(wakeLock, "wakeLock");
        return wakeLock;
    }
}
