package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.environment.workerthread.WorkerManager;
import com.ironsource.environment.workerthread.WorkerResult;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class t7 {

    class a implements WorkerManager.WorkEndedListener<u7> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f15387a;

        a(b bVar) {
            this.f15387a = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ironsource.environment.workerthread.WorkerManager.WorkEndedListener
        public void onWorkCompleted(List<WorkerResult<u7>> list, long j10) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (WorkerResult<u7> workerResult : list) {
                if (workerResult instanceof WorkerResult.Completed) {
                    arrayList2.add((u7) ((WorkerResult.Completed) workerResult).data);
                } else if (workerResult instanceof WorkerResult.Canceled) {
                    arrayList.add(((q7) ((WorkerResult.Canceled) workerResult).callable).c());
                } else if (workerResult instanceof WorkerResult.Failed) {
                    WorkerResult.Failed failed = (WorkerResult.Failed) workerResult;
                    q7 q7Var = (q7) failed.callable;
                    arrayList2.add(new u7(q7Var.d(), q7Var.c(), null, 0L, failed.exception.getMessage()));
                }
            }
            t7.this.a(arrayList2, arrayList, j10);
            this.f15387a.a(arrayList2, j10, arrayList);
        }

        @Override // com.ironsource.environment.workerthread.WorkerManager.WorkEndedListener
        public void onWorkFailed(String str) {
            String str2 = "failed to collect bidding data, error= " + str;
            IronLog.INTERNAL.verbose(str2);
            this.f15387a.onFailure(str2);
        }
    }

    public interface b {
        void a(@NotNull List<u7> list, long j10, @NotNull List<String> list2);

        void onFailure(String str);
    }

    public void a(@NotNull List<q7> list, @NotNull b bVar, long j10, @NotNull TimeUnit timeUnit) {
        try {
            if (list.isEmpty()) {
                IronLog.INTERNAL.verbose("BiddingDataCallable list is empty");
                return;
            }
            WorkerManager workerManager = new WorkerManager(IronSourceThreadManager.INSTANCE.getThreadPoolExecutor());
            Iterator<q7> it = list.iterator();
            while (it.hasNext()) {
                workerManager.addCallable(it.next());
            }
            IronLog.INTERNAL.verbose("instances=" + list.size() + ", timeout=" + j10 + " millis");
            workerManager.startWork(new a(bVar), j10, timeUnit);
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "Exception - failed to collect bidding data, error= " + th.getMessage();
            IronLog.INTERNAL.error(str);
            bVar.onFailure(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<u7> list, List<String> list2, long j10) {
        IronLog ironLog;
        StringBuilder sb;
        String strB;
        IronLog.INTERNAL.verbose("tokens received=" + list.size() + ", reached timeout=" + list2.size() + ", total duration=" + j10 + " millis");
        for (u7 u7Var : list) {
            if (u7Var.a() != null) {
                ironLog = IronLog.INTERNAL;
                sb = new StringBuilder();
                sb.append(u7Var.c());
                sb.append(" - success (");
                sb.append(u7Var.e());
                strB = " millis)";
            } else {
                ironLog = IronLog.INTERNAL;
                sb = new StringBuilder();
                sb.append(u7Var.c());
                sb.append(" - failed (");
                sb.append(u7Var.e());
                sb.append(" millis) error: ");
                strB = u7Var.b();
            }
            sb.append(strB);
            ironLog.verbose(sb.toString());
        }
        for (String str : list2) {
            IronLog.INTERNAL.verbose(str + " reached timeout");
        }
    }
}
