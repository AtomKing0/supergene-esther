package io.sentry.util;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.w0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LoadClass.java */
/* JADX INFO: loaded from: classes5.dex */
public class s {
    public boolean a(@NotNull String str, @Nullable w0 w0Var) {
        return c(str, w0Var) != null;
    }

    public boolean b(@NotNull String str, @Nullable SentryOptions sentryOptions) {
        return a(str, sentryOptions != null ? sentryOptions.getLogger() : null);
    }

    @Nullable
    public Class<?> c(@NotNull String str, @Nullable w0 w0Var) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            if (w0Var == null) {
                return null;
            }
            w0Var.c(SentryLevel.INFO, "Class not available: " + str, new Object[0]);
            return null;
        } catch (UnsatisfiedLinkError e10) {
            if (w0Var == null) {
                return null;
            }
            w0Var.b(SentryLevel.ERROR, "Failed to load (UnsatisfiedLinkError) " + str, e10);
            return null;
        } catch (Throwable th) {
            if (w0Var == null) {
                return null;
            }
            w0Var.b(SentryLevel.ERROR, "Failed to initialize " + str, th);
            return null;
        }
    }
}
