package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ConstraintTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConstraintTrackerKt {

    @NotNull
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("ConstraintTracker");
        t.h(strTagWithPrefix, "tagWithPrefix(\"ConstraintTracker\")");
        TAG = strTagWithPrefix;
    }
}
