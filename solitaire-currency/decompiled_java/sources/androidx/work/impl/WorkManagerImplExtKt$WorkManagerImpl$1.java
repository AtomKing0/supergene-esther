package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import h9.t;
import java.util.List;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkManagerImplExt.kt */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class WorkManagerImplExtKt$WorkManagerImpl$1 extends q implements t<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<? extends Scheduler>> {
    public static final WorkManagerImplExtKt$WorkManagerImpl$1 INSTANCE = new WorkManagerImplExtKt$WorkManagerImpl$1();

    WorkManagerImplExtKt$WorkManagerImpl$1() {
        super(6, WorkManagerImplExtKt.class, "createSchedulers", "createSchedulers(Landroid/content/Context;Landroidx/work/Configuration;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/WorkDatabase;Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/Processor;)Ljava/util/List;", 1);
    }

    @Override // h9.t
    @NotNull
    public final List<Scheduler> invoke(@NotNull Context p02, @NotNull Configuration p12, @NotNull TaskExecutor p22, @NotNull WorkDatabase p32, @NotNull Trackers p42, @NotNull Processor p52) {
        kotlin.jvm.internal.t.i(p02, "p0");
        kotlin.jvm.internal.t.i(p12, "p1");
        kotlin.jvm.internal.t.i(p22, "p2");
        kotlin.jvm.internal.t.i(p32, "p3");
        kotlin.jvm.internal.t.i(p42, "p4");
        kotlin.jvm.internal.t.i(p52, "p5");
        return WorkManagerImplExtKt.createSchedulers(p02, p12, p22, p32, p42, p52);
    }
}
