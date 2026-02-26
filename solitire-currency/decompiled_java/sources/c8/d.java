package c8;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExceptionUtilsJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    @NotNull
    public static final Throwable a(@NotNull Throwable th) {
        t.i(th, "<this>");
        Throwable cause = th;
        while (cause instanceof CancellationException) {
            CancellationException cancellationException = (CancellationException) cause;
            if (t.d(cause, cancellationException.getCause())) {
                return th;
            }
            cause = cancellationException.getCause();
        }
        return cause == null ? th : cause;
    }
}
