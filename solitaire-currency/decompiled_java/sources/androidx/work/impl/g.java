package androidx.work.impl;

import androidx.work.WorkInfo;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkLauncher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g {
    public static void a(WorkLauncher workLauncher, @NotNull StartStopToken workSpecId) {
        t.i(workSpecId, "workSpecId");
        workLauncher.startWork(workSpecId, null);
    }

    public static void b(WorkLauncher workLauncher, @NotNull StartStopToken workSpecId) {
        t.i(workSpecId, "workSpecId");
        workLauncher.stopWork(workSpecId, WorkInfo.STOP_REASON_UNKNOWN);
    }

    public static void c(WorkLauncher workLauncher, @NotNull StartStopToken workSpecId, int i10) {
        t.i(workSpecId, "workSpecId");
        workLauncher.stopWork(workSpecId, i10);
    }
}
