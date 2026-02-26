package l8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StackTraceRecover.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    @NotNull
    public static final Throwable a(@NotNull Throwable exception, @NotNull z8.d<?> continuation) {
        t.i(exception, "exception");
        t.i(continuation, "continuation");
        try {
            return j.a(exception, exception.getCause());
        } catch (Throwable unused) {
            return exception;
        }
    }
}
