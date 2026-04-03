package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StorageNotLowTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorageNotLowTrackerKt {

    @NotNull
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("StorageNotLowTracker");
        t.h(strTagWithPrefix, "tagWithPrefix(\"StorageNotLowTracker\")");
        TAG = strTagWithPrefix;
    }
}
