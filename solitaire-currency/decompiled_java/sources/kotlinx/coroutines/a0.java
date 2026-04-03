package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CompletableJob.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface a0 extends b2 {
    boolean c(@NotNull Throwable th);

    boolean complete();
}
