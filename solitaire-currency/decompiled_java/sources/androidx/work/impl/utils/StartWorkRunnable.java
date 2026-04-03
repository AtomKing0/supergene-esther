package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StartWorkRunnable.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StartWorkRunnable implements Runnable {

    @NotNull
    private final Processor processor;

    @Nullable
    private final WorkerParameters.RuntimeExtras runtimeExtras;

    @NotNull
    private final StartStopToken startStopToken;

    public StartWorkRunnable(@NotNull Processor processor, @NotNull StartStopToken startStopToken, @Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
        t.i(processor, "processor");
        t.i(startStopToken, "startStopToken");
        this.processor = processor;
        this.startStopToken = startStopToken;
        this.runtimeExtras = runtimeExtras;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.processor.startWork(this.startStopToken, this.runtimeExtras);
    }
}
