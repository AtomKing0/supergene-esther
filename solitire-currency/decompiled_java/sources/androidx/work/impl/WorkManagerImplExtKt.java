package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.R;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import h9.t;
import java.util.List;
import kotlin.collections.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkManagerImplExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkManagerImplExtKt {

    /* JADX INFO: renamed from: androidx.work.impl.WorkManagerImplExtKt$schedulers$1, reason: invalid class name */
    /* JADX INFO: compiled from: WorkManagerImplExt.kt */
    static final class AnonymousClass1 extends v implements t<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<? extends Scheduler>> {
        final /* synthetic */ Scheduler[] $schedulers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Scheduler[] schedulerArr) {
            super(6);
            this.$schedulers = schedulerArr;
        }

        @Override // h9.t
        @NotNull
        public final List<Scheduler> invoke(@NotNull Context context, @NotNull Configuration configuration, @NotNull TaskExecutor taskExecutor, @NotNull WorkDatabase workDatabase, @NotNull Trackers trackers, @NotNull Processor processor) {
            kotlin.jvm.internal.t.i(context, "<anonymous parameter 0>");
            kotlin.jvm.internal.t.i(configuration, "<anonymous parameter 1>");
            kotlin.jvm.internal.t.i(taskExecutor, "<anonymous parameter 2>");
            kotlin.jvm.internal.t.i(workDatabase, "<anonymous parameter 3>");
            kotlin.jvm.internal.t.i(trackers, "<anonymous parameter 4>");
            kotlin.jvm.internal.t.i(processor, "<anonymous parameter 5>");
            return p.o0(this.$schedulers);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Scheduler> createSchedulers(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        Scheduler schedulerCreateBestAvailableBackgroundScheduler = Schedulers.createBestAvailableBackgroundScheduler(context, workDatabase, configuration);
        kotlin.jvm.internal.t.h(schedulerCreateBestAvailableBackgroundScheduler, "createBestAvailableBackg…kDatabase, configuration)");
        return kotlin.collections.v.n(schedulerCreateBestAvailableBackgroundScheduler, new GreedyScheduler(context, configuration, trackers, processor, new WorkLauncherImpl(processor, taskExecutor), taskExecutor));
    }

    @NotNull
    public static final WorkManagerImpl createTestWorkManager(@NotNull Context context, @NotNull Configuration configuration, @NotNull TaskExecutor workTaskExecutor) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(configuration, "configuration");
        kotlin.jvm.internal.t.i(workTaskExecutor, "workTaskExecutor");
        WorkDatabase.Companion companion = WorkDatabase.Companion;
        SerialExecutor serialTaskExecutor = workTaskExecutor.getSerialTaskExecutor();
        kotlin.jvm.internal.t.h(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
        return createWorkManager$default(context, configuration, workTaskExecutor, companion.create(context, serialTaskExecutor, configuration.getClock(), true), null, null, null, 112, null);
    }

    @NotNull
    public static final WorkManagerImpl createWorkManager(@NotNull Context context, @NotNull Configuration configuration) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(configuration, "configuration");
        return createWorkManager$default(context, configuration, null, null, null, null, null, 124, null);
    }

    public static /* synthetic */ WorkManagerImpl createWorkManager$default(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, t tVar, int i10, Object obj) {
        WorkDatabase workDatabaseCreate;
        Trackers trackers2;
        TaskExecutor workManagerTaskExecutor = (i10 & 4) != 0 ? new WorkManagerTaskExecutor(configuration.getTaskExecutor()) : taskExecutor;
        if ((i10 & 8) != 0) {
            WorkDatabase.Companion companion = WorkDatabase.Companion;
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.t.h(applicationContext, "context.applicationContext");
            SerialExecutor serialTaskExecutor = workManagerTaskExecutor.getSerialTaskExecutor();
            kotlin.jvm.internal.t.h(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
            workDatabaseCreate = companion.create(applicationContext, serialTaskExecutor, configuration.getClock(), context.getResources().getBoolean(R.bool.workmanager_test_configuration));
        } else {
            workDatabaseCreate = workDatabase;
        }
        if ((i10 & 16) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            kotlin.jvm.internal.t.h(applicationContext2, "context.applicationContext");
            trackers2 = new Trackers(applicationContext2, workManagerTaskExecutor, null, null, null, null, 60, null);
        } else {
            trackers2 = trackers;
        }
        return createWorkManager(context, configuration, workManagerTaskExecutor, workDatabaseCreate, trackers2, (i10 & 32) != 0 ? new Processor(context.getApplicationContext(), configuration, workManagerTaskExecutor, workDatabaseCreate) : processor, (i10 & 64) != 0 ? WorkManagerImplExtKt$WorkManagerImpl$1.INSTANCE : tVar);
    }

    @NotNull
    public static final t<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<Scheduler>> schedulers(@NotNull Scheduler... schedulers) {
        kotlin.jvm.internal.t.i(schedulers, "schedulers");
        return new AnonymousClass1(schedulers);
    }

    @NotNull
    public static final WorkManagerImpl createWorkManager(@NotNull Context context, @NotNull Configuration configuration, @NotNull TaskExecutor workTaskExecutor) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(configuration, "configuration");
        kotlin.jvm.internal.t.i(workTaskExecutor, "workTaskExecutor");
        return createWorkManager$default(context, configuration, workTaskExecutor, null, null, null, null, 120, null);
    }

    @NotNull
    public static final WorkManagerImpl createWorkManager(@NotNull Context context, @NotNull Configuration configuration, @NotNull TaskExecutor workTaskExecutor, @NotNull WorkDatabase workDatabase) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(configuration, "configuration");
        kotlin.jvm.internal.t.i(workTaskExecutor, "workTaskExecutor");
        kotlin.jvm.internal.t.i(workDatabase, "workDatabase");
        return createWorkManager$default(context, configuration, workTaskExecutor, workDatabase, null, null, null, 112, null);
    }

    @NotNull
    public static final WorkManagerImpl createWorkManager(@NotNull Context context, @NotNull Configuration configuration, @NotNull TaskExecutor workTaskExecutor, @NotNull WorkDatabase workDatabase, @NotNull Trackers trackers) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(configuration, "configuration");
        kotlin.jvm.internal.t.i(workTaskExecutor, "workTaskExecutor");
        kotlin.jvm.internal.t.i(workDatabase, "workDatabase");
        kotlin.jvm.internal.t.i(trackers, "trackers");
        return createWorkManager$default(context, configuration, workTaskExecutor, workDatabase, trackers, null, null, 96, null);
    }

    @NotNull
    public static final WorkManagerImpl createWorkManager(@NotNull Context context, @NotNull Configuration configuration, @NotNull TaskExecutor workTaskExecutor, @NotNull WorkDatabase workDatabase, @NotNull Trackers trackers, @NotNull Processor processor) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(configuration, "configuration");
        kotlin.jvm.internal.t.i(workTaskExecutor, "workTaskExecutor");
        kotlin.jvm.internal.t.i(workDatabase, "workDatabase");
        kotlin.jvm.internal.t.i(trackers, "trackers");
        kotlin.jvm.internal.t.i(processor, "processor");
        return createWorkManager$default(context, configuration, workTaskExecutor, workDatabase, trackers, processor, null, 64, null);
    }

    @NotNull
    public static final WorkManagerImpl createWorkManager(@NotNull Context context, @NotNull Configuration configuration, @NotNull TaskExecutor workTaskExecutor, @NotNull WorkDatabase workDatabase, @NotNull Trackers trackers, @NotNull Processor processor, @NotNull t<? super Context, ? super Configuration, ? super TaskExecutor, ? super WorkDatabase, ? super Trackers, ? super Processor, ? extends List<? extends Scheduler>> schedulersCreator) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(configuration, "configuration");
        kotlin.jvm.internal.t.i(workTaskExecutor, "workTaskExecutor");
        kotlin.jvm.internal.t.i(workDatabase, "workDatabase");
        kotlin.jvm.internal.t.i(trackers, "trackers");
        kotlin.jvm.internal.t.i(processor, "processor");
        kotlin.jvm.internal.t.i(schedulersCreator, "schedulersCreator");
        return new WorkManagerImpl(context.getApplicationContext(), configuration, workTaskExecutor, workDatabase, schedulersCreator.invoke(context, configuration, workTaskExecutor, workDatabase, trackers, processor), processor, trackers);
    }
}
