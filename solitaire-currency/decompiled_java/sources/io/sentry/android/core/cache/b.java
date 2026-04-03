package io.sentry.android.core.cache;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.android.core.AnrV2Integration;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.performance.i;
import io.sentry.cache.f;
import io.sentry.l0;
import io.sentry.p5;
import io.sentry.transport.p;
import io.sentry.util.h;
import io.sentry.util.m;
import io.sentry.util.w;
import java.io.File;
import java.io.FileOutputStream;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidEnvelopeCache.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class b extends f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final p f27143i;

    public b(@NotNull SentryAndroidOptions sentryAndroidOptions) {
        this(sentryAndroidOptions, io.sentry.android.core.internal.util.b.b());
    }

    public static boolean G(@NotNull SentryOptions sentryOptions) {
        String outboxPath = sentryOptions.getOutboxPath();
        if (outboxPath == null) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Outbox path is null, the startup crash marker file does not exist", new Object[0]);
            return false;
        }
        File file = new File(outboxPath, "startup_crash");
        try {
            boolean zExists = file.exists();
            if (zExists && !file.delete()) {
                sentryOptions.getLogger().c(SentryLevel.ERROR, "Failed to delete the startup crash marker file. %s.", file.getAbsolutePath());
            }
            return zExists;
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error reading/deleting the startup crash marker file on the disk", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(SentryAndroidOptions sentryAndroidOptions, AnrV2Integration.b bVar) {
        Long lE = bVar.e();
        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Writing last reported ANR marker with timestamp %d", lE);
        J(lE);
    }

    @Nullable
    public static Long I(@NotNull SentryOptions sentryOptions) {
        File file = new File((String) w.c(sentryOptions.getCacheDirPath(), "Cache dir path should be set for getting ANRs reported"), "last_anr_report");
        try {
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Error reading last ANR marker", th);
        }
        if (!file.exists() || !file.canRead()) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Last ANR marker does not exist. %s.", file.getAbsolutePath());
            return null;
        }
        String strC = h.c(file);
        if (strC.equals("null")) {
            return null;
        }
        return Long.valueOf(Long.parseLong(strC.trim()));
    }

    private void J(@Nullable Long l10) {
        String cacheDirPath = this.f27652a.getCacheDirPath();
        if (cacheDirPath == null) {
            this.f27652a.getLogger().c(SentryLevel.DEBUG, "Cache dir path is null, the ANR marker will not be written", new Object[0]);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(cacheDirPath, "last_anr_report"));
            try {
                fileOutputStream.write(String.valueOf(l10).getBytes(f27651e));
                fileOutputStream.flush();
                fileOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            this.f27652a.getLogger().b(SentryLevel.ERROR, "Error writing the ANR marker to the disk", th);
        }
    }

    private void K() {
        String outboxPath = this.f27652a.getOutboxPath();
        if (outboxPath == null) {
            this.f27652a.getLogger().c(SentryLevel.DEBUG, "Outbox path is null, the startup crash marker file will not be written", new Object[0]);
            return;
        }
        try {
            new File(outboxPath, "startup_crash").createNewFile();
        } catch (Throwable th) {
            this.f27652a.getLogger().b(SentryLevel.ERROR, "Error writing the startup crash marker file to the disk", th);
        }
    }

    @Override // io.sentry.cache.f, io.sentry.cache.g
    public void L(@NotNull p5 p5Var, @NotNull l0 l0Var) {
        super.L(p5Var, l0Var);
        final SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.f27652a;
        i iVarR = io.sentry.android.core.performance.h.q().r();
        if (m.h(l0Var, UncaughtExceptionHandlerIntegration.a.class) && iVarR.n()) {
            long jA = this.f27143i.a() - iVarR.k();
            if (jA <= sentryAndroidOptions.getStartupCrashDurationThresholdMillis()) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Startup Crash detected %d milliseconds after SDK init. Writing a startup crash marker file to disk.", Long.valueOf(jA));
                K();
            }
        }
        m.o(l0Var, AnrV2Integration.b.class, new m.a() { // from class: io.sentry.android.core.cache.a
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                this.f27141a.H(sentryAndroidOptions, (AnrV2Integration.b) obj);
            }
        });
    }

    b(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull p pVar) {
        super(sentryAndroidOptions, (String) w.c(sentryAndroidOptions.getCacheDirPath(), "cacheDirPath must not be null"), sentryAndroidOptions.getMaxCacheItems());
        this.f27143i = pVar;
    }
}
