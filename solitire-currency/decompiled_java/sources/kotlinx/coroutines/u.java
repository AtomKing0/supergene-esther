package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface u extends g1 {
    boolean a(@NotNull Throwable th);

    @Nullable
    b2 getParent();
}
