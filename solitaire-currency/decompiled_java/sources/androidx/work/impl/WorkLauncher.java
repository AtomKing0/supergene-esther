package androidx.work.impl;

import androidx.work.WorkerParameters;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WorkLauncher.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface WorkLauncher {
    void startWork(@NotNull StartStopToken startStopToken);

    void startWork(@NotNull StartStopToken startStopToken, @Nullable WorkerParameters.RuntimeExtras runtimeExtras);

    void stopWork(@NotNull StartStopToken startStopToken);

    void stopWork(@NotNull StartStopToken startStopToken, int i10);

    void stopWorkWithReason(@NotNull StartStopToken startStopToken, int i10);
}
