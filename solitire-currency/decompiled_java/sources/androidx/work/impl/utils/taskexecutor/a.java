package androidx.work.impl.utils.taskexecutor;

import androidx.annotation.NonNull;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;

/* JADX INFO: compiled from: TaskExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a {
    public static void a(TaskExecutor taskExecutor, @NonNull Runnable runnable) {
        taskExecutor.getSerialTaskExecutor().execute(runnable);
    }

    @NonNull
    public static k0 b(TaskExecutor taskExecutor) {
        return s1.b(taskExecutor.getSerialTaskExecutor());
    }
}
