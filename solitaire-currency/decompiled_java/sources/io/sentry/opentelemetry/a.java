package io.sentry.opentelemetry;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.k7;
import io.sentry.s2;
import io.sentry.util.c0;
import io.sentry.util.s;
import io.sentry.util.y;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OpenTelemetryUtil.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a {
    @ApiStatus.Internal
    public static void a(@NotNull SentryOptions sentryOptions) {
        if (y.c()) {
            Iterator<String> it = b(sentryOptions).iterator();
            while (it.hasNext()) {
                sentryOptions.addIgnoredSpanOrigin(it.next());
            }
        }
    }

    @NotNull
    private static List<String> b(@NotNull SentryOptions sentryOptions) {
        k7 openTelemetryMode = sentryOptions.getOpenTelemetryMode();
        return k7.OFF.equals(openTelemetryMode) ? Collections.emptyList() : c0.a(openTelemetryMode);
    }

    @ApiStatus.Internal
    public static void c(@NotNull SentryOptions sentryOptions, @NotNull s sVar) {
        if (y.c()) {
            if (k7.AUTO.equals(sentryOptions.getOpenTelemetryMode())) {
                if (sVar.a("io.sentry.opentelemetry.agent.AgentMarker", s2.e())) {
                    sentryOptions.getLogger().c(SentryLevel.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENT", new Object[0]);
                    sentryOptions.setOpenTelemetryMode(k7.AGENT);
                } else if (sVar.a("io.sentry.opentelemetry.agent.AgentlessMarker", s2.e())) {
                    sentryOptions.getLogger().c(SentryLevel.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENTLESS", new Object[0]);
                    sentryOptions.setOpenTelemetryMode(k7.AGENTLESS);
                } else if (sVar.a("io.sentry.opentelemetry.agent.AgentlessSpringMarker", s2.e())) {
                    sentryOptions.getLogger().c(SentryLevel.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENTLESS_SPRING", new Object[0]);
                    sentryOptions.setOpenTelemetryMode(k7.AGENTLESS_SPRING);
                }
            }
        }
    }
}
