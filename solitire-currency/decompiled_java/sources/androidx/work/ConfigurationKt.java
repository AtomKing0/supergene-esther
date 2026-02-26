package androidx.work;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfigurationKt {
    private static final int DEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Executor createDefaultExecutor(final boolean z10) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.ConfigurationKt$createDefaultExecutor$factory$1

            @NotNull
            private final AtomicInteger threadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            @NotNull
            public Thread newThread(@NotNull Runnable runnable) {
                t.i(runnable, "runnable");
                return new Thread(runnable, (z10 ? "WM.task-" : "androidx.work-") + this.threadCount.incrementAndGet());
            }
        });
        t.h(executorServiceNewFixedThreadPool, "newFixedThreadPool(\n    …)),\n        factory\n    )");
        return executorServiceNewFixedThreadPool;
    }

    public static final int getDEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT() {
        return DEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT;
    }
}
