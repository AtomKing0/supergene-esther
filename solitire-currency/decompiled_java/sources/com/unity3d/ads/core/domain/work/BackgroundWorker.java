package com.unity3d.ads.core.domain.work;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BackgroundWorker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BackgroundWorker {

    @NotNull
    private final WorkManager workManager;

    public BackgroundWorker(@NotNull Context applicationContext) {
        t.i(applicationContext, "applicationContext");
        WorkManager workManager = WorkManager.getInstance(applicationContext);
        t.h(workManager, "getInstance(applicationContext)");
        this.workManager = workManager;
    }

    @NotNull
    public final WorkManager getWorkManager() {
        return this.workManager;
    }

    public final /* synthetic */ <T extends UniversalRequestJob> void invoke(UniversalRequestWorkerData universalRequestWorkerData) {
        t.i(universalRequestWorkerData, "universalRequestWorkerData");
        Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        t.h(constraintsBuild, "Builder()\n            .s…TED)\n            .build()");
        t.o(4, "T");
        OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(ListenableWorker.class).setConstraints(constraintsBuild).setInputData(universalRequestWorkerData.invoke()).build();
        t.h(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…a())\n            .build()");
        getWorkManager().enqueue(oneTimeWorkRequestBuild);
    }
}
