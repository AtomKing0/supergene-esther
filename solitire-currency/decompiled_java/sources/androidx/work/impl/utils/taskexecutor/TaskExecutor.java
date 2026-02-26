package androidx.work.impl.utils.taskexecutor;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import kotlinx.coroutines.k0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface TaskExecutor {
    void executeOnTaskThread(@NonNull Runnable runnable);

    @NonNull
    Executor getMainThreadExecutor();

    @NonNull
    SerialExecutor getSerialTaskExecutor();

    @NonNull
    k0 getTaskCoroutineDispatcher();
}
