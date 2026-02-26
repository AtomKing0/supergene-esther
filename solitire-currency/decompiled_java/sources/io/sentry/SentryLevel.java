package io.sentry;

import java.io.IOException;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public enum SentryLevel implements h2 {
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL;

    public static final class a implements x1<SentryLevel> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SentryLevel deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            return SentryLevel.valueOf(l3Var.e0().toUpperCase(Locale.ROOT));
        }
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.g(name().toLowerCase(Locale.ROOT));
    }
}
