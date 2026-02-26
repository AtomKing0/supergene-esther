package io.sentry.util;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.j3;
import io.sentry.k2;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InitUtil.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class o {
    public static boolean a(@Nullable SentryOptions sentryOptions, @NotNull SentryOptions sentryOptions2, boolean z10) {
        if (y.c() && (sentryOptions2.getVersionDetector() instanceof j3)) {
            sentryOptions2.setVersionDetector(new k2(sentryOptions2));
        }
        if (!sentryOptions2.getVersionDetector().a()) {
            return !z10 || sentryOptions == null || sentryOptions2.isForceInit() || sentryOptions.getInitPriority().ordinal() <= sentryOptions2.getInitPriority().ordinal();
        }
        sentryOptions2.getLogger().c(SentryLevel.ERROR, "Not initializing Sentry because mixed SDK versions have been detected.", new Object[0]);
        throw new IllegalStateException("Sentry SDK has detected a mix of versions. This is not supported and likely leads to crashes. Please always use the same version of all SDK modules (dependencies). See " + (y.a() ? "https://docs.sentry.io/platforms/android/troubleshooting/mixed-versions" : "https://docs.sentry.io/platforms/java/troubleshooting/mixed-versions") + " for more details.");
    }
}
