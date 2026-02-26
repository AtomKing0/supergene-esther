package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BroadcastReceiverConstraintTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BroadcastReceiverConstraintTrackerKt {

    @NotNull
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("BrdcstRcvrCnstrntTrckr");
        t.h(strTagWithPrefix, "tagWithPrefix(\"BrdcstRcvrCnstrntTrckr\")");
        TAG = strTagWithPrefix;
    }
}
