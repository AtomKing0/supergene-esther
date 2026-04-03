package g8;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Throwable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    @Nullable
    public static final Throwable a(@NotNull Throwable th) {
        kotlin.jvm.internal.t.i(th, "<this>");
        while (true) {
            if ((th != null ? th.getCause() : null) == null) {
                return th;
            }
            th = th.getCause();
        }
    }
}
