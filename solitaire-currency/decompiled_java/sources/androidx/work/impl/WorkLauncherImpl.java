package androidx.work.impl;

import androidx.work.WorkerParameters;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WorkLauncher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkLauncherImpl implements WorkLauncher {

    @NotNull
    private final Processor processor;

    @NotNull
    private final TaskExecutor workTaskExecutor;

    public WorkLauncherImpl(@NotNull Processor processor, @NotNull TaskExecutor workTaskExecutor) {
        t.i(processor, "processor");
        t.i(workTaskExecutor, "workTaskExecutor");
        this.processor = processor;
        this.workTaskExecutor = workTaskExecutor;
    }

    @NotNull
    public final Processor getProcessor() {
        return this.processor;
    }

    @NotNull
    public final TaskExecutor getWorkTaskExecutor() {
        return this.workTaskExecutor;
    }

    @Override // androidx.work.impl.WorkLauncher
    public /* synthetic */ void startWork(StartStopToken startStopToken) {
        g.a(this, startStopToken);
    }

    @Override // androidx.work.impl.WorkLauncher
    public /* synthetic */ void stopWork(StartStopToken startStopToken) {
        g.b(this, startStopToken);
    }

    @Override // androidx.work.impl.WorkLauncher
    public /* synthetic */ void stopWorkWithReason(StartStopToken startStopToken, int i10) {
        g.c(this, startStopToken, i10);
    }

    @Override // androidx.work.impl.WorkLauncher
    public void startWork(@NotNull StartStopToken workSpecId, @Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
        t.i(workSpecId, "workSpecId");
        this.workTaskExecutor.executeOnTaskThread(new StartWorkRunnable(this.processor, workSpecId, runtimeExtras));
    }

    @Override // androidx.work.impl.WorkLauncher
    public void stopWork(@NotNull StartStopToken workSpecId, int i10) {
        t.i(workSpecId, "workSpecId");
        this.workTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this.processor, workSpecId, false, i10));
    }
}
