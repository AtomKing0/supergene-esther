package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StopWorkRunnable.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StopWorkRunnable implements Runnable {

    @NotNull
    private final Processor processor;
    private final int reason;
    private final boolean stopInForeground;

    @NotNull
    private final StartStopToken token;

    public StopWorkRunnable(@NotNull Processor processor, @NotNull StartStopToken token, boolean z10, int i10) {
        t.i(processor, "processor");
        t.i(token, "token");
        this.processor = processor;
        this.token = token;
        this.stopInForeground = z10;
        this.reason = i10;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zStopForegroundWork = this.stopInForeground ? this.processor.stopForegroundWork(this.token, this.reason) : this.processor.stopWork(this.token, this.reason);
        Logger.get().debug(Logger.tagWithPrefix("StopWorkRunnable"), "StopWorkRunnable for " + this.token.getId().getWorkSpecId() + "; Processor.stopWork = " + zStopForegroundWork);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StopWorkRunnable(@NotNull Processor processor, @NotNull StartStopToken token, boolean z10) {
        this(processor, token, z10, WorkInfo.STOP_REASON_UNKNOWN);
        t.i(processor, "processor");
        t.i(token, "token");
    }
}
