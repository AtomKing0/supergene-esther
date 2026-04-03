package t9;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FlowExceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final transient s9.i<?> f34107a;

    public a(@NotNull s9.i<?> iVar) {
        super("Flow was aborted, no more elements needed");
        this.f34107a = iVar;
    }

    @Override // java.lang.Throwable
    @NotNull
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
