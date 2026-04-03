package u9;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final transient z8.g f34661a;

    public i(@NotNull z8.g gVar) {
        this.f34661a = gVar;
    }

    @Override // java.lang.Throwable
    @NotNull
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getLocalizedMessage() {
        return this.f34661a.toString();
    }
}
