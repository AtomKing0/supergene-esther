package androidx.work;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DirectExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public enum DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        t.i(command, "command");
        command.run();
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return "DirectExecutor";
    }
}
