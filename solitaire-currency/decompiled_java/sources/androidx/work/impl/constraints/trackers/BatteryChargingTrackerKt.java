package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BatteryChargingTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BatteryChargingTrackerKt {

    @NotNull
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("BatteryChrgTracker");
        t.h(strTagWithPrefix, "tagWithPrefix(\"BatteryChrgTracker\")");
        TAG = strTagWithPrefix;
    }
}
