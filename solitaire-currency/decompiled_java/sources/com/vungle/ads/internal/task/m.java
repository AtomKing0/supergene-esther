package com.vungle.ads.internal.task;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.internal.util.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleJobRunner.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m implements f {

    @NotNull
    private final com.vungle.ads.internal.task.c creator;

    @NotNull
    private final Executor executor;
    private long nextCheck;

    @NotNull
    private final List<b> pendingJobs;

    @NotNull
    private final Runnable pendingRunnable;

    @Nullable
    private final j threadPriorityHelper;

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final String TAG = m.class.getSimpleName();

    /* JADX INFO: compiled from: VungleJobRunner.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: VungleJobRunner.kt */
    private static final class b {

        @Nullable
        private d info;
        private final long uptimeMillis;

        public b(long j10, @Nullable d dVar) {
            this.uptimeMillis = j10;
            this.info = dVar;
        }

        @Nullable
        public final d getInfo() {
            return this.info;
        }

        public final long getUptimeMillis() {
            return this.uptimeMillis;
        }

        public final void setInfo(@Nullable d dVar) {
            this.info = dVar;
        }
    }

    /* JADX INFO: compiled from: VungleJobRunner.kt */
    private static final class c implements Runnable {

        @NotNull
        private WeakReference<m> runner;

        public c(@NotNull WeakReference<m> runner) {
            t.i(runner, "runner");
            this.runner = runner;
        }

        @NotNull
        public final WeakReference<m> getRunner() {
            return this.runner;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar = this.runner.get();
            if (mVar != null) {
                mVar.executePendingJobs();
            }
        }

        public final void setRunner(@NotNull WeakReference<m> weakReference) {
            t.i(weakReference, "<set-?>");
            this.runner = weakReference;
        }
    }

    public m(@NotNull com.vungle.ads.internal.task.c creator, @NotNull Executor executor, @Nullable j jVar) {
        t.i(creator, "creator");
        t.i(executor, "executor");
        this.creator = creator;
        this.executor = executor;
        this.threadPriorityHelper = jVar;
        this.nextCheck = Long.MAX_VALUE;
        this.pendingJobs = new CopyOnWriteArrayList();
        this.pendingRunnable = new c(new WeakReference(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void executePendingJobs() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jMin = Long.MAX_VALUE;
        for (b bVar : this.pendingJobs) {
            if (jUptimeMillis >= bVar.getUptimeMillis()) {
                this.pendingJobs.remove(bVar);
                d info = bVar.getInfo();
                if (info != null) {
                    this.executor.execute(new e(info, this.creator, this, this.threadPriorityHelper));
                }
            } else {
                jMin = Math.min(jMin, bVar.getUptimeMillis());
            }
        }
        if (jMin != Long.MAX_VALUE && jMin != this.nextCheck) {
            Handler handler2 = handler;
            handler2.removeCallbacks(this.pendingRunnable);
            handler2.postAtTime(this.pendingRunnable, TAG, jMin);
        }
        this.nextCheck = jMin;
    }

    @Override // com.vungle.ads.internal.task.f
    public synchronized void cancelPendingJob(@NotNull String tag) {
        t.i(tag, "tag");
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.pendingJobs) {
            d info = bVar.getInfo();
            if (t.d(info != null ? info.getJobTag() : null, tag)) {
                arrayList.add(bVar);
            }
        }
        this.pendingJobs.removeAll(arrayList);
    }

    @Override // com.vungle.ads.internal.task.f
    public synchronized void execute(@NotNull d jobInfo) {
        t.i(jobInfo, "jobInfo");
        d dVarCopy = jobInfo.copy();
        if (dVarCopy != null) {
            String jobTag = dVarCopy.getJobTag();
            long delay = dVarCopy.getDelay();
            dVarCopy.setDelay(0L);
            if (dVarCopy.getUpdateCurrent()) {
                for (b bVar : this.pendingJobs) {
                    d info = bVar.getInfo();
                    if (t.d(info != null ? info.getJobTag() : null, jobTag)) {
                        p.a aVar = p.Companion;
                        String TAG2 = TAG;
                        t.h(TAG2, "TAG");
                        aVar.d(TAG2, "replacing pending job with new " + jobTag);
                        this.pendingJobs.remove(bVar);
                    }
                }
            }
            this.pendingJobs.add(new b(SystemClock.uptimeMillis() + delay, dVarCopy));
            executePendingJobs();
        }
    }

    @VisibleForTesting
    public final int getPendingJobSize$vungle_ads_release() {
        return this.pendingJobs.size();
    }
}
