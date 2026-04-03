package io.sentry.util;

import androidx.compose.material.TextFieldImplKt;
import io.sentry.SentryLevel;
import io.sentry.w0;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LogUtils.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class t {
    public static void a(@NotNull Class<?> cls, @Nullable Object obj, @NotNull w0 w0Var) {
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        Object[] objArr = new Object[2];
        objArr[0] = obj != null ? obj.getClass().getCanonicalName() : TextFieldImplKt.PlaceholderId;
        objArr[1] = cls.getCanonicalName();
        w0Var.c(sentryLevel, "%s is not %s", objArr);
    }
}
