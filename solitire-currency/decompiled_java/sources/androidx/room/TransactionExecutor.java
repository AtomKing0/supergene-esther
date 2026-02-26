package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TransactionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TransactionExecutor implements Executor {

    @Nullable
    private Runnable active;

    @NotNull
    private final Executor executor;

    @NotNull
    private final Object syncLock;

    @NotNull
    private final ArrayDeque<Runnable> tasks;

    public TransactionExecutor(@NotNull Executor executor) {
        kotlin.jvm.internal.t.i(executor, "executor");
        this.executor = executor;
        this.tasks = new ArrayDeque<>();
        this.syncLock = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$1$lambda$0(Runnable command, TransactionExecutor this$0) {
        kotlin.jvm.internal.t.i(command, "$command");
        kotlin.jvm.internal.t.i(this$0, "this$0");
        try {
            command.run();
        } finally {
            this$0.scheduleNext();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull final Runnable command) {
        kotlin.jvm.internal.t.i(command, "command");
        synchronized (this.syncLock) {
            this.tasks.offer(new Runnable() { // from class: androidx.room.a0
                @Override // java.lang.Runnable
                public final void run() {
                    TransactionExecutor.execute$lambda$1$lambda$0(command, this);
                }
            });
            if (this.active == null) {
                scheduleNext();
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public final void scheduleNext() {
        synchronized (this.syncLock) {
            Runnable runnablePoll = this.tasks.poll();
            Runnable runnable = runnablePoll;
            this.active = runnable;
            if (runnablePoll != null) {
                this.executor.execute(runnable);
            }
            k0 k0Var = k0.f35197a;
        }
    }
}
