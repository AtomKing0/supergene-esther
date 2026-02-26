package io.sentry.cache;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.b7;
import io.sentry.c8;
import io.sentry.e8;
import io.sentry.k1;
import io.sentry.l0;
import io.sentry.m5;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.w0;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnvelopeCache.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class f extends c implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CountDownLatch f27657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final Map<p5, String> f27658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    protected final io.sentry.util.a f27659h;

    public f(@NotNull SentryOptions sentryOptions, @NotNull String str, int i10) {
        super(sentryOptions, str, i10);
        this.f27658g = new WeakHashMap();
        this.f27659h = new io.sentry.util.a();
        this.f27657f = new CountDownLatch(1);
    }

    private void A(@NotNull File file, @NotNull p5 p5Var) {
        Iterable<p6> iterableC = p5Var.c();
        if (!iterableC.iterator().hasNext()) {
            this.f27652a.getLogger().c(SentryLevel.INFO, "Current envelope %s is empty", file.getAbsolutePath());
            return;
        }
        p6 next = iterableC.iterator().next();
        if (!b7.Session.equals(next.K().b())) {
            this.f27652a.getLogger().c(SentryLevel.INFO, "Current envelope has a different envelope type %s", next.K().b());
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(next.I()), c.f27651e));
            try {
                e8 e8Var = (e8) this.f27653b.a().c(bufferedReader, e8.class);
                if (e8Var == null) {
                    this.f27652a.getLogger().c(SentryLevel.ERROR, "Item of type %s returned null by the parser.", next.K().b());
                } else {
                    E(file, e8Var);
                }
                bufferedReader.close();
            } finally {
            }
        } catch (Throwable th) {
            this.f27652a.getLogger().b(SentryLevel.ERROR, "Item failed to process.", th);
        }
    }

    private void C() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f27652a.getCacheDirPath(), "last_crash"));
            try {
                fileOutputStream.write(io.sentry.n.h(io.sentry.n.d()).getBytes(c.f27651e));
                fileOutputStream.flush();
                fileOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            this.f27652a.getLogger().b(SentryLevel.ERROR, "Error writing the crash marker file to the disk", th);
        }
    }

    private void D(@NotNull File file, @NotNull p5 p5Var) {
        if (file.exists()) {
            this.f27652a.getLogger().c(SentryLevel.DEBUG, "Overwriting envelope to offline storage: %s", file.getAbsolutePath());
            if (!file.delete()) {
                this.f27652a.getLogger().c(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                this.f27653b.a().b(p5Var, fileOutputStream);
                fileOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            this.f27652a.getLogger().a(SentryLevel.ERROR, th, "Error writing Envelope %s to offline storage", file.getAbsolutePath());
        }
    }

    private void E(@NotNull File file, @NotNull e8 e8Var) {
        if (file.exists()) {
            this.f27652a.getLogger().c(SentryLevel.DEBUG, "Overwriting session to offline storage: %s", e8Var.j());
            if (!file.delete()) {
                this.f27652a.getLogger().c(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, c.f27651e));
                try {
                    this.f27653b.a().a(e8Var, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            this.f27652a.getLogger().a(SentryLevel.ERROR, th, "Error writing Session to offline storage: %s", e8Var.j());
        }
    }

    @NotNull
    private File[] s() {
        File[] fileArrListFiles;
        return (!f() || (fileArrListFiles = this.f27654c.listFiles(new FilenameFilter() { // from class: io.sentry.cache.e
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return f.y(file, str);
            }
        })) == null) ? new File[0] : fileArrListFiles;
    }

    @NotNull
    public static g t(@NotNull SentryOptions sentryOptions) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        int maxCacheItems = sentryOptions.getMaxCacheItems();
        if (cacheDirPath != null) {
            return new f(sentryOptions, cacheDirPath, maxCacheItems);
        }
        sentryOptions.getLogger().c(SentryLevel.WARNING, "cacheDirPath is null, returning NoOpEnvelopeCache", new Object[0]);
        return io.sentry.transport.t.a();
    }

    @NotNull
    public static File v(@NotNull String str) {
        return new File(str, "session.json");
    }

    @NotNull
    private File w(@NotNull p5 p5Var) {
        String str;
        k1 k1VarA = this.f27659h.a();
        try {
            if (this.f27658g.containsKey(p5Var)) {
                str = this.f27658g.get(p5Var);
            } else {
                String str2 = c8.a() + ".envelope";
                this.f27658g.put(p5Var, str2);
                str = str2;
            }
            File file = new File(this.f27654c.getAbsolutePath(), str);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return file;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @NotNull
    public static File x(@NotNull String str) {
        return new File(str, "previous_session.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean y(File file, String str) {
        return str.endsWith(".envelope");
    }

    private void z(@NotNull l0 l0Var) {
        Date dateE;
        Object objG = io.sentry.util.m.g(l0Var);
        if (objG instanceof io.sentry.hints.a) {
            File fileX = x(this.f27654c.getAbsolutePath());
            if (!fileX.exists()) {
                this.f27652a.getLogger().c(SentryLevel.DEBUG, "No previous session file to end.", new Object[0]);
                return;
            }
            w0 logger = this.f27652a.getLogger();
            SentryLevel sentryLevel = SentryLevel.WARNING;
            logger.c(sentryLevel, "Previous session is not ended, we'd need to end it.", new Object[0]);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileX), c.f27651e));
                try {
                    e8 e8Var = (e8) this.f27653b.a().c(bufferedReader, e8.class);
                    if (e8Var != null) {
                        io.sentry.hints.a aVar = (io.sentry.hints.a) objG;
                        Long lE = aVar.e();
                        if (lE != null) {
                            dateE = io.sentry.n.e(lE.longValue());
                            Date dateK = e8Var.k();
                            if (dateK == null || dateE.before(dateK)) {
                                this.f27652a.getLogger().c(sentryLevel, "Abnormal exit happened before previous session start, not ending the session.", new Object[0]);
                                bufferedReader.close();
                                return;
                            }
                        } else {
                            dateE = null;
                        }
                        e8Var.q(e8.b.Abnormal, null, true, aVar.h());
                        e8Var.d(dateE);
                        E(fileX, e8Var);
                    }
                    bufferedReader.close();
                } finally {
                }
            } catch (Throwable th) {
                this.f27652a.getLogger().b(SentryLevel.ERROR, "Error processing previous session.", th);
            }
        }
    }

    public boolean B() {
        try {
            return this.f27657f.await(this.f27652a.getSessionFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.f27652a.getLogger().c(SentryLevel.DEBUG, "Timed out waiting for previous session to flush.", new Object[0]);
            return false;
        }
    }

    public void L(@NotNull p5 p5Var, @NotNull l0 l0Var) {
        io.sentry.util.w.c(p5Var, "Envelope is required.");
        o(s());
        File fileV = v(this.f27654c.getAbsolutePath());
        File fileX = x(this.f27654c.getAbsolutePath());
        if (io.sentry.util.m.h(l0Var, io.sentry.hints.l.class) && !fileV.delete()) {
            this.f27652a.getLogger().c(SentryLevel.WARNING, "Current envelope doesn't exist.", new Object[0]);
        }
        if (io.sentry.util.m.h(l0Var, io.sentry.hints.a.class)) {
            z(l0Var);
        }
        if (io.sentry.util.m.h(l0Var, io.sentry.hints.n.class)) {
            if (fileV.exists()) {
                this.f27652a.getLogger().c(SentryLevel.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileV), c.f27651e));
                    try {
                        e8 e8Var = (e8) this.f27653b.a().c(bufferedReader, e8.class);
                        if (e8Var != null) {
                            E(fileX, e8Var);
                        }
                        bufferedReader.close();
                    } finally {
                    }
                } catch (Throwable th) {
                    this.f27652a.getLogger().b(SentryLevel.ERROR, "Error processing session.", th);
                }
            }
            A(fileV, p5Var);
            boolean zExists = new File(this.f27652a.getCacheDirPath(), ".sentry-native/last_crash").exists();
            if (!zExists) {
                File file = new File(this.f27652a.getCacheDirPath(), "last_crash");
                if (file.exists()) {
                    this.f27652a.getLogger().c(SentryLevel.INFO, "Crash marker file exists, crashedLastRun will return true.", new Object[0]);
                    if (!file.delete()) {
                        this.f27652a.getLogger().c(SentryLevel.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                    }
                    zExists = true;
                }
            }
            m5.a().c(zExists);
            u();
        }
        File fileW = w(p5Var);
        if (fileW.exists()) {
            this.f27652a.getLogger().c(SentryLevel.WARNING, "Not adding Envelope to offline storage because it already exists: %s", fileW.getAbsolutePath());
            return;
        }
        this.f27652a.getLogger().c(SentryLevel.DEBUG, "Adding Envelope to offline storage: %s", fileW.getAbsolutePath());
        D(fileW, p5Var);
        if (io.sentry.util.m.h(l0Var, UncaughtExceptionHandlerIntegration.a.class)) {
            C();
        }
    }

    @Override // io.sentry.cache.g
    public void c(@NotNull p5 p5Var) {
        io.sentry.util.w.c(p5Var, "Envelope is required.");
        File fileW = w(p5Var);
        if (!fileW.exists()) {
            this.f27652a.getLogger().c(SentryLevel.DEBUG, "Envelope was not cached: %s", fileW.getAbsolutePath());
            return;
        }
        this.f27652a.getLogger().c(SentryLevel.DEBUG, "Discarding envelope from cache: %s", fileW.getAbsolutePath());
        if (fileW.delete()) {
            return;
        }
        this.f27652a.getLogger().c(SentryLevel.ERROR, "Failed to delete envelope: %s", fileW.getAbsolutePath());
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<p5> iterator() {
        File[] fileArrS = s();
        ArrayList arrayList = new ArrayList(fileArrS.length);
        for (File file : fileArrS) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    arrayList.add(this.f27653b.a().d(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused) {
                this.f27652a.getLogger().c(SentryLevel.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", file.getAbsolutePath());
            } catch (IOException e10) {
                this.f27652a.getLogger().b(SentryLevel.ERROR, String.format("Error while reading cached envelope from file %s", file.getAbsolutePath()), e10);
            }
        }
        return arrayList.iterator();
    }

    public void u() {
        this.f27657f.countDown();
    }
}
