package io.sentry;

import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SendCachedEnvelopeFireAndForgetIntegration.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class w4 {
    public static boolean a(x4 x4Var, @Nullable String str, @NotNull w0 w0Var) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        w0Var.c(SentryLevel.INFO, "No cached dir path is defined in options.", new Object[0]);
        return false;
    }

    @NotNull
    public static t4 b(x4 x4Var, @NotNull final w wVar, @NotNull final String str, @NotNull final w0 w0Var) {
        final File file = new File(str);
        return new t4() { // from class: io.sentry.v4
            @Override // io.sentry.t4
            public final void a() {
                w4.c(w0Var, str, wVar, file);
            }
        };
    }

    public static /* synthetic */ void c(w0 w0Var, String str, w wVar, File file) {
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        w0Var.c(sentryLevel, "Started processing cached files from %s", str);
        wVar.e(file);
        w0Var.c(sentryLevel, "Finished processing cached files from %s", str);
    }
}
