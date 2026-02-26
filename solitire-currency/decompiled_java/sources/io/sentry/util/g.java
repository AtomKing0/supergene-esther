package io.sentry.util;

import java.util.Set;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExceptionUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class g {
    @NotNull
    public static Throwable a(@NotNull Throwable th) {
        w.c(th, "throwable cannot be null");
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }

    @ApiStatus.Internal
    public static boolean b(@NotNull Set<Class<? extends Throwable>> set, @NotNull Throwable th) {
        return set.contains(th.getClass());
    }
}
