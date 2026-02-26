package t9;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FlowExceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends CancellationException {
    public j() {
        super("Child of the scoped flow was cancelled");
    }

    @Override // java.lang.Throwable
    @NotNull
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
