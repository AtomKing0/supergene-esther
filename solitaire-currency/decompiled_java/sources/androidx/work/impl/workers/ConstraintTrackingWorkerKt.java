package androidx.work.impl.workers;

import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.utils.futures.SettableFuture;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConstraintTrackingWorkerKt {

    @NotNull
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";

    @NotNull
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("ConstraintTrkngWrkr");
        t.h(strTagWithPrefix, "tagWithPrefix(\"ConstraintTrkngWrkr\")");
        TAG = strTagWithPrefix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setFailed(SettableFuture<ListenableWorker.Result> settableFuture) {
        return settableFuture.set(ListenableWorker.Result.failure());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setRetry(SettableFuture<ListenableWorker.Result> settableFuture) {
        return settableFuture.set(ListenableWorker.Result.retry());
    }
}
