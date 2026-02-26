package androidx.work;

import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.media3.exoplayer.DefaultLivePlaybackSpeedControl;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Configuration {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int MIN_SCHEDULER_LIMIT = 20;

    @NotNull
    private final Clock clock;
    private final int contentUriTriggerWorkersLimit;

    @Nullable
    private final String defaultProcessName;

    @NotNull
    private final Executor executor;

    @Nullable
    private final Consumer<Throwable> initializationExceptionHandler;

    @NotNull
    private final InputMergerFactory inputMergerFactory;
    private final boolean isUsingDefaultTaskExecutor;
    private final int maxJobSchedulerId;
    private final int maxSchedulerLimit;
    private final int minJobSchedulerId;
    private final int minimumLoggingLevel;

    @NotNull
    private final RunnableScheduler runnableScheduler;

    @Nullable
    private final Consumer<Throwable> schedulingExceptionHandler;

    @NotNull
    private final Executor taskExecutor;

    @NotNull
    private final WorkerFactory workerFactory;

    /* JADX INFO: compiled from: Configuration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: Configuration.kt */
    public interface Provider {
        @NotNull
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(@NotNull Builder builder) {
        t.i(builder, "builder");
        Executor executor$work_runtime_release = builder.getExecutor$work_runtime_release();
        this.executor = executor$work_runtime_release == null ? ConfigurationKt.createDefaultExecutor(false) : executor$work_runtime_release;
        this.isUsingDefaultTaskExecutor = builder.getTaskExecutor$work_runtime_release() == null;
        Executor taskExecutor$work_runtime_release = builder.getTaskExecutor$work_runtime_release();
        this.taskExecutor = taskExecutor$work_runtime_release == null ? ConfigurationKt.createDefaultExecutor(true) : taskExecutor$work_runtime_release;
        Clock clock$work_runtime_release = builder.getClock$work_runtime_release();
        this.clock = clock$work_runtime_release == null ? new SystemClock() : clock$work_runtime_release;
        WorkerFactory workerFactory$work_runtime_release = builder.getWorkerFactory$work_runtime_release();
        if (workerFactory$work_runtime_release == null) {
            workerFactory$work_runtime_release = WorkerFactory.getDefaultWorkerFactory();
            t.h(workerFactory$work_runtime_release, "getDefaultWorkerFactory()");
        }
        this.workerFactory = workerFactory$work_runtime_release;
        InputMergerFactory inputMergerFactory$work_runtime_release = builder.getInputMergerFactory$work_runtime_release();
        this.inputMergerFactory = inputMergerFactory$work_runtime_release == null ? NoOpInputMergerFactory.INSTANCE : inputMergerFactory$work_runtime_release;
        RunnableScheduler runnableScheduler$work_runtime_release = builder.getRunnableScheduler$work_runtime_release();
        this.runnableScheduler = runnableScheduler$work_runtime_release == null ? new DefaultRunnableScheduler() : runnableScheduler$work_runtime_release;
        this.minimumLoggingLevel = builder.getLoggingLevel$work_runtime_release();
        this.minJobSchedulerId = builder.getMinJobSchedulerId$work_runtime_release();
        this.maxJobSchedulerId = builder.getMaxJobSchedulerId$work_runtime_release();
        this.maxSchedulerLimit = Build.VERSION.SDK_INT == 23 ? builder.getMaxSchedulerLimit$work_runtime_release() / 2 : builder.getMaxSchedulerLimit$work_runtime_release();
        this.initializationExceptionHandler = builder.getInitializationExceptionHandler$work_runtime_release();
        this.schedulingExceptionHandler = builder.getSchedulingExceptionHandler$work_runtime_release();
        this.defaultProcessName = builder.getDefaultProcessName$work_runtime_release();
        this.contentUriTriggerWorkersLimit = builder.getContentUriTriggerWorkersLimit$work_runtime_release();
    }

    @NotNull
    public final Clock getClock() {
        return this.clock;
    }

    public final int getContentUriTriggerWorkersLimit() {
        return this.contentUriTriggerWorkersLimit;
    }

    @Nullable
    public final String getDefaultProcessName() {
        return this.defaultProcessName;
    }

    @NotNull
    public final Executor getExecutor() {
        return this.executor;
    }

    @Nullable
    public final Consumer<Throwable> getInitializationExceptionHandler() {
        return this.initializationExceptionHandler;
    }

    @NotNull
    public final InputMergerFactory getInputMergerFactory() {
        return this.inputMergerFactory;
    }

    public final int getMaxJobSchedulerId() {
        return this.maxJobSchedulerId;
    }

    @IntRange(from = DefaultLivePlaybackSpeedControl.DEFAULT_MAX_LIVE_OFFSET_ERROR_MS_FOR_UNIT_SPEED, to = 50)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMaxSchedulerLimit() {
        return this.maxSchedulerLimit;
    }

    public final int getMinJobSchedulerId() {
        return this.minJobSchedulerId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMinimumLoggingLevel() {
        return this.minimumLoggingLevel;
    }

    @NotNull
    public final RunnableScheduler getRunnableScheduler() {
        return this.runnableScheduler;
    }

    @Nullable
    public final Consumer<Throwable> getSchedulingExceptionHandler() {
        return this.schedulingExceptionHandler;
    }

    @NotNull
    public final Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    @NotNull
    public final WorkerFactory getWorkerFactory() {
        return this.workerFactory;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isUsingDefaultTaskExecutor() {
        return this.isUsingDefaultTaskExecutor;
    }

    /* JADX INFO: compiled from: Configuration.kt */
    public static final class Builder {

        @Nullable
        private Clock clock;
        private int contentUriTriggerWorkersLimit;

        @Nullable
        private String defaultProcessName;

        @Nullable
        private Executor executor;

        @Nullable
        private Consumer<Throwable> initializationExceptionHandler;

        @Nullable
        private InputMergerFactory inputMergerFactory;
        private int loggingLevel;
        private int maxJobSchedulerId;
        private int maxSchedulerLimit;
        private int minJobSchedulerId;

        @Nullable
        private RunnableScheduler runnableScheduler;

        @Nullable
        private Consumer<Throwable> schedulingExceptionHandler;

        @Nullable
        private Executor taskExecutor;

        @Nullable
        private WorkerFactory workerFactory;

        public Builder() {
            this.loggingLevel = 4;
            this.maxJobSchedulerId = Integer.MAX_VALUE;
            this.maxSchedulerLimit = 20;
            this.contentUriTriggerWorkersLimit = ConfigurationKt.getDEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT();
        }

        @NotNull
        public final Configuration build() {
            return new Configuration(this);
        }

        @Nullable
        public final Clock getClock$work_runtime_release() {
            return this.clock;
        }

        public final int getContentUriTriggerWorkersLimit$work_runtime_release() {
            return this.contentUriTriggerWorkersLimit;
        }

        @Nullable
        public final String getDefaultProcessName$work_runtime_release() {
            return this.defaultProcessName;
        }

        @Nullable
        public final Executor getExecutor$work_runtime_release() {
            return this.executor;
        }

        @Nullable
        public final Consumer<Throwable> getInitializationExceptionHandler$work_runtime_release() {
            return this.initializationExceptionHandler;
        }

        @Nullable
        public final InputMergerFactory getInputMergerFactory$work_runtime_release() {
            return this.inputMergerFactory;
        }

        public final int getLoggingLevel$work_runtime_release() {
            return this.loggingLevel;
        }

        public final int getMaxJobSchedulerId$work_runtime_release() {
            return this.maxJobSchedulerId;
        }

        public final int getMaxSchedulerLimit$work_runtime_release() {
            return this.maxSchedulerLimit;
        }

        public final int getMinJobSchedulerId$work_runtime_release() {
            return this.minJobSchedulerId;
        }

        @Nullable
        public final RunnableScheduler getRunnableScheduler$work_runtime_release() {
            return this.runnableScheduler;
        }

        @Nullable
        public final Consumer<Throwable> getSchedulingExceptionHandler$work_runtime_release() {
            return this.schedulingExceptionHandler;
        }

        @Nullable
        public final Executor getTaskExecutor$work_runtime_release() {
            return this.taskExecutor;
        }

        @Nullable
        public final WorkerFactory getWorkerFactory$work_runtime_release() {
            return this.workerFactory;
        }

        @NotNull
        public final Builder setClock(@NotNull Clock clock) {
            t.i(clock, "clock");
            this.clock = clock;
            return this;
        }

        public final void setClock$work_runtime_release(@Nullable Clock clock) {
            this.clock = clock;
        }

        @NotNull
        public final Builder setContentUriTriggerWorkersLimit(int i10) {
            this.contentUriTriggerWorkersLimit = Math.max(i10, 0);
            return this;
        }

        public final void setContentUriTriggerWorkersLimit$work_runtime_release(int i10) {
            this.contentUriTriggerWorkersLimit = i10;
        }

        @NotNull
        public final Builder setDefaultProcessName(@NotNull String processName) {
            t.i(processName, "processName");
            this.defaultProcessName = processName;
            return this;
        }

        public final void setDefaultProcessName$work_runtime_release(@Nullable String str) {
            this.defaultProcessName = str;
        }

        @NotNull
        public final Builder setExecutor(@NotNull Executor executor) {
            t.i(executor, "executor");
            this.executor = executor;
            return this;
        }

        public final void setExecutor$work_runtime_release(@Nullable Executor executor) {
            this.executor = executor;
        }

        @NotNull
        public final Builder setInitializationExceptionHandler(@NotNull Consumer<Throwable> exceptionHandler) {
            t.i(exceptionHandler, "exceptionHandler");
            this.initializationExceptionHandler = exceptionHandler;
            return this;
        }

        public final void setInitializationExceptionHandler$work_runtime_release(@Nullable Consumer<Throwable> consumer) {
            this.initializationExceptionHandler = consumer;
        }

        @NotNull
        public final Builder setInputMergerFactory(@NotNull InputMergerFactory inputMergerFactory) {
            t.i(inputMergerFactory, "inputMergerFactory");
            this.inputMergerFactory = inputMergerFactory;
            return this;
        }

        public final void setInputMergerFactory$work_runtime_release(@Nullable InputMergerFactory inputMergerFactory) {
            this.inputMergerFactory = inputMergerFactory;
        }

        @NotNull
        public final Builder setJobSchedulerJobIdRange(int i10, int i11) {
            if (!(i11 - i10 >= 1000)) {
                throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.".toString());
            }
            this.minJobSchedulerId = i10;
            this.maxJobSchedulerId = i11;
            return this;
        }

        public final void setLoggingLevel$work_runtime_release(int i10) {
            this.loggingLevel = i10;
        }

        public final void setMaxJobSchedulerId$work_runtime_release(int i10) {
            this.maxJobSchedulerId = i10;
        }

        @NotNull
        public final Builder setMaxSchedulerLimit(int i10) {
            if (!(i10 >= 20)) {
                throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.".toString());
            }
            this.maxSchedulerLimit = Math.min(i10, 50);
            return this;
        }

        public final void setMaxSchedulerLimit$work_runtime_release(int i10) {
            this.maxSchedulerLimit = i10;
        }

        public final void setMinJobSchedulerId$work_runtime_release(int i10) {
            this.minJobSchedulerId = i10;
        }

        @NotNull
        public final Builder setMinimumLoggingLevel(int i10) {
            this.loggingLevel = i10;
            return this;
        }

        @NotNull
        public final Builder setRunnableScheduler(@NotNull RunnableScheduler runnableScheduler) {
            t.i(runnableScheduler, "runnableScheduler");
            this.runnableScheduler = runnableScheduler;
            return this;
        }

        public final void setRunnableScheduler$work_runtime_release(@Nullable RunnableScheduler runnableScheduler) {
            this.runnableScheduler = runnableScheduler;
        }

        @NotNull
        public final Builder setSchedulingExceptionHandler(@NotNull Consumer<Throwable> schedulingExceptionHandler) {
            t.i(schedulingExceptionHandler, "schedulingExceptionHandler");
            this.schedulingExceptionHandler = schedulingExceptionHandler;
            return this;
        }

        public final void setSchedulingExceptionHandler$work_runtime_release(@Nullable Consumer<Throwable> consumer) {
            this.schedulingExceptionHandler = consumer;
        }

        @NotNull
        public final Builder setTaskExecutor(@NotNull Executor taskExecutor) {
            t.i(taskExecutor, "taskExecutor");
            this.taskExecutor = taskExecutor;
            return this;
        }

        public final void setTaskExecutor$work_runtime_release(@Nullable Executor executor) {
            this.taskExecutor = executor;
        }

        @NotNull
        public final Builder setWorkerFactory(@NotNull WorkerFactory workerFactory) {
            t.i(workerFactory, "workerFactory");
            this.workerFactory = workerFactory;
            return this;
        }

        public final void setWorkerFactory$work_runtime_release(@Nullable WorkerFactory workerFactory) {
            this.workerFactory = workerFactory;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@NotNull Configuration configuration) {
            t.i(configuration, "configuration");
            this.loggingLevel = 4;
            this.maxJobSchedulerId = Integer.MAX_VALUE;
            this.maxSchedulerLimit = 20;
            this.contentUriTriggerWorkersLimit = ConfigurationKt.getDEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT();
            this.executor = configuration.getExecutor();
            this.workerFactory = configuration.getWorkerFactory();
            this.inputMergerFactory = configuration.getInputMergerFactory();
            this.taskExecutor = configuration.getTaskExecutor();
            this.clock = configuration.getClock();
            this.loggingLevel = configuration.getMinimumLoggingLevel();
            this.minJobSchedulerId = configuration.getMinJobSchedulerId();
            this.maxJobSchedulerId = configuration.getMaxJobSchedulerId();
            this.maxSchedulerLimit = configuration.getMaxSchedulerLimit();
            this.runnableScheduler = configuration.getRunnableScheduler();
            this.initializationExceptionHandler = configuration.getInitializationExceptionHandler();
            this.schedulingExceptionHandler = configuration.getSchedulingExceptionHandler();
            this.defaultProcessName = configuration.getDefaultProcessName();
        }
    }
}
