package io.sentry;

import io.sentry.e8;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PreviousSessionFinalizer.java */
/* JADX INFO: loaded from: classes5.dex */
final class s3 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Charset f28219c = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final f1 f28221b;

    s3(@NotNull SentryOptions sentryOptions, @NotNull f1 f1Var) {
        this.f28220a = sentryOptions;
        this.f28221b = f1Var;
    }

    @Nullable
    private Date a(@NotNull File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), f28219c));
            try {
                String line = bufferedReader.readLine();
                this.f28220a.getLogger().c(SentryLevel.DEBUG, "Crash marker file has %s timestamp.", line);
                Date dateF = n.f(line);
                bufferedReader.close();
                return dateF;
            } finally {
            }
        } catch (IOException e10) {
            this.f28220a.getLogger().b(SentryLevel.ERROR, "Error reading the crash marker file.", e10);
            return null;
        } catch (IllegalArgumentException e11) {
            this.f28220a.getLogger().a(SentryLevel.ERROR, e11, "Error converting the crash timestamp.", new Object[0]);
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String cacheDirPath = this.f28220a.getCacheDirPath();
        if (cacheDirPath == null) {
            this.f28220a.getLogger().c(SentryLevel.INFO, "Cache dir is not set, not finalizing the previous session.", new Object[0]);
            return;
        }
        if (!this.f28220a.isEnableAutoSessionTracking()) {
            this.f28220a.getLogger().c(SentryLevel.DEBUG, "Session tracking is disabled, bailing from previous session finalizer.", new Object[0]);
            return;
        }
        io.sentry.cache.g envelopeDiskCache = this.f28220a.getEnvelopeDiskCache();
        if ((envelopeDiskCache instanceof io.sentry.cache.f) && !((io.sentry.cache.f) envelopeDiskCache).B()) {
            this.f28220a.getLogger().c(SentryLevel.WARNING, "Timed out waiting to flush previous session to its own file in session finalizer.", new Object[0]);
            return;
        }
        File fileX = io.sentry.cache.f.x(cacheDirPath);
        l1 serializer = this.f28220a.getSerializer();
        if (fileX.exists()) {
            this.f28220a.getLogger().c(SentryLevel.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileX), f28219c));
                try {
                    e8 e8Var = (e8) serializer.c(bufferedReader, e8.class);
                    if (e8Var == null) {
                        this.f28220a.getLogger().c(SentryLevel.ERROR, "Stream from path %s resulted in a null envelope.", fileX.getAbsolutePath());
                    } else {
                        File file = new File(this.f28220a.getCacheDirPath(), ".sentry-native/last_crash");
                        Date date = null;
                        if (file.exists()) {
                            this.f28220a.getLogger().c(SentryLevel.INFO, "Crash marker file exists, last Session is gonna be Crashed.", new Object[0]);
                            Date dateA = a(file);
                            if (!file.delete()) {
                                this.f28220a.getLogger().c(SentryLevel.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                            }
                            e8Var.p(e8.b.Crashed, null, true);
                            date = dateA;
                        }
                        if (e8Var.f() == null) {
                            e8Var.d(date);
                        }
                        this.f28221b.z(p5.a(serializer, e8Var, this.f28220a.getSdkVersion()));
                    }
                    bufferedReader.close();
                } finally {
                }
            } catch (Throwable th) {
                this.f28220a.getLogger().b(SentryLevel.ERROR, "Error processing previous session.", th);
            }
            if (fileX.delete()) {
                return;
            }
            this.f28220a.getLogger().c(SentryLevel.WARNING, "Failed to delete the previous session file.", new Object[0]);
        }
    }
}
