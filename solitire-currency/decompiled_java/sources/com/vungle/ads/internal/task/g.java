package com.vungle.ads.internal.task;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JobRunnerThreadPriorityHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements j {
    @Override // com.vungle.ads.internal.task.j
    public int makeAndroidThreadPriority(@NotNull d jobInfo) {
        t.i(jobInfo, "jobInfo");
        return Math.min(19, Math.abs(Math.min(0, jobInfo.getPriority() - 2)) + 10);
    }
}
