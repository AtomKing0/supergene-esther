package l8;

import io.ktor.utils.io.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StackTraceRecoverJvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    @NotNull
    public static final Throwable a(@NotNull Throwable th, @Nullable Throwable th2) {
        Throwable thE;
        t.i(th, "<this>");
        if (th2 == null || t.d(th.getCause(), th2) || (thE = r.e(th, th2)) == null) {
            return th;
        }
        thE.setStackTrace(th.getStackTrace());
        return thE;
    }
}
