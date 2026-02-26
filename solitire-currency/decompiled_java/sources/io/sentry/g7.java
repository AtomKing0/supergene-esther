package io.sentry;

import java.io.IOException;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SentryLogLevel.java */
/* JADX INFO: loaded from: classes5.dex */
public enum g7 implements h2 {
    TRACE(1),
    DEBUG(5),
    INFO(9),
    WARN(13),
    ERROR(17),
    FATAL(21);

    private final int severityNumber;

    /* JADX INFO: compiled from: SentryLogLevel.java */
    public static final class a implements x1<g7> {
        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g7 deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            return g7.valueOf(l3Var.e0().toUpperCase(Locale.ROOT));
        }
    }

    g7(int i10) {
        this.severityNumber = i10;
    }

    public int getSeverityNumber() {
        return this.severityNumber;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.g(name().toLowerCase(Locale.ROOT));
    }
}
