package com.vungle.ads.internal.task;

import android.os.Bundle;
import android.os.Process;
import com.vungle.ads.internal.util.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobRunnable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends h {

    @NotNull
    public static final a Companion = new a(null);
    private static final String TAG = e.class.getSimpleName();

    @NotNull
    private final c creator;

    @NotNull
    private final f jobRunner;

    @NotNull
    private final d jobinfo;

    @Nullable
    private final j threadPriorityHelper;

    /* JADX INFO: compiled from: JobRunnable.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public e(@NotNull d jobinfo, @NotNull c creator, @NotNull f jobRunner, @Nullable j jVar) {
        t.i(jobinfo, "jobinfo");
        t.i(creator, "creator");
        t.i(jobRunner, "jobRunner");
        this.jobinfo = jobinfo;
        this.creator = creator;
        this.jobRunner = jobRunner;
        this.threadPriorityHelper = jVar;
    }

    @Override // com.vungle.ads.internal.task.h
    public int getPriority() {
        return this.jobinfo.getPriority();
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar = this.threadPriorityHelper;
        if (jVar != null) {
            try {
                int iMakeAndroidThreadPriority = jVar.makeAndroidThreadPriority(this.jobinfo);
                Process.setThreadPriority(iMakeAndroidThreadPriority);
                p.a aVar = p.Companion;
                String TAG2 = TAG;
                t.h(TAG2, "TAG");
                aVar.d(TAG2, "Setting process thread prio = " + iMakeAndroidThreadPriority + " for " + this.jobinfo.getJobTag());
            } catch (Throwable unused) {
                p.a aVar2 = p.Companion;
                String TAG3 = TAG;
                t.h(TAG3, "TAG");
                aVar2.e(TAG3, "Error on setting process thread priority");
            }
        }
        try {
            String jobTag = this.jobinfo.getJobTag();
            Bundle extras = this.jobinfo.getExtras();
            p.a aVar3 = p.Companion;
            String TAG4 = TAG;
            t.h(TAG4, "TAG");
            aVar3.d(TAG4, "Start job " + jobTag + "Thread " + Thread.currentThread().getName());
            int iOnRunJob = this.creator.create(jobTag).onRunJob(extras, this.jobRunner);
            t.h(TAG4, "TAG");
            aVar3.d(TAG4, "On job finished " + jobTag + " with result " + iOnRunJob);
            if (iOnRunJob == 2) {
                long jMakeNextRescedule = this.jobinfo.makeNextRescedule();
                if (jMakeNextRescedule > 0) {
                    this.jobinfo.setDelay(jMakeNextRescedule);
                    this.jobRunner.execute(this.jobinfo);
                    t.h(TAG4, "TAG");
                    aVar3.d(TAG4, "Rescheduling " + jobTag + " in " + jMakeNextRescedule);
                }
            }
        } catch (Exception e10) {
            p.a aVar4 = p.Companion;
            String TAG5 = TAG;
            t.h(TAG5, "TAG");
            aVar4.e(TAG5, "Cannot create job" + e10.getLocalizedMessage());
        }
    }

    public static /* synthetic */ void getPriority$annotations() {
    }
}
