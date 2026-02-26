package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryThread;
import io.sentry.r6;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"NewApi"})
public class AnrV2Integration implements io.sentry.v1, Closeable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final long f27023d = TimeUnit.DAYS.toMillis(91);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.transport.p f27025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private SentryAndroidOptions f27026c;

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Context f27027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final io.sentry.f1 f27028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final SentryAndroidOptions f27029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f27030d;

        a(@NotNull Context context, @NotNull io.sentry.f1 f1Var, @NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull io.sentry.transport.p pVar) {
            this.f27027a = context;
            this.f27028b = f1Var;
            this.f27029c = sentryAndroidOptions;
            this.f27030d = pVar.a() - AnrV2Integration.f27023d;
        }

        private byte[] a(@NotNull InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = inputStream.read(bArr, 0, 1024);
                    if (i10 == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        @NotNull
        private c b(@NotNull ApplicationExitInfo applicationExitInfo, boolean z10) {
            try {
                InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
                try {
                    if (traceInputStream == null) {
                        c cVar = new c(c.a.NO_DUMP);
                        if (traceInputStream != null) {
                            traceInputStream.close();
                        }
                        return cVar;
                    }
                    byte[] bArrA = a(traceInputStream);
                    traceInputStream.close();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArrA)));
                        try {
                            io.sentry.android.core.internal.threaddump.b bVarC = io.sentry.android.core.internal.threaddump.b.c(bufferedReader);
                            io.sentry.android.core.internal.threaddump.c cVar2 = new io.sentry.android.core.internal.threaddump.c(this.f27029c, z10);
                            cVar2.i(bVarC);
                            List<SentryThread> listF = cVar2.f();
                            List<DebugImage> listC = cVar2.c();
                            if (listF.isEmpty()) {
                                c cVar3 = new c(c.a.NO_DUMP);
                                bufferedReader.close();
                                return cVar3;
                            }
                            c cVar4 = new c(c.a.DUMP, bArrA, listF, listC);
                            bufferedReader.close();
                            return cVar4;
                        } finally {
                        }
                    } catch (Throwable th) {
                        this.f27029c.getLogger().b(SentryLevel.WARNING, "Failed to parse ANR thread dump", th);
                        return new c(c.a.ERROR, bArrA);
                    }
                } finally {
                }
            } catch (Throwable th2) {
                this.f27029c.getLogger().b(SentryLevel.WARNING, "Failed to read ANR thread dump", th2);
                return new c(c.a.NO_DUMP);
            }
        }

        private void c(@NotNull ApplicationExitInfo applicationExitInfo, boolean z10) {
            byte[] bArr;
            long timestamp = applicationExitInfo.getTimestamp();
            boolean z11 = applicationExitInfo.getImportance() != 100;
            c cVarB = b(applicationExitInfo, z11);
            if (cVarB.f27034a == c.a.NO_DUMP) {
                this.f27029c.getLogger().c(SentryLevel.WARNING, "Not reporting ANR event as there was no thread dump for the ANR %s", applicationExitInfo.toString());
                return;
            }
            b bVar = new b(this.f27029c.getFlushTimeoutMillis(), this.f27029c.getLogger(), timestamp, z10, z11);
            io.sentry.l0 l0VarE = io.sentry.util.m.e(bVar);
            r6 r6Var = new r6();
            c.a aVar = cVarB.f27034a;
            if (aVar == c.a.ERROR) {
                Message message = new Message();
                message.setFormatted("Sentry Android SDK failed to parse system thread dump for this ANR. We recommend enabling [SentryOptions.isAttachAnrThreadDump] option to attach the thread dump as plain text and report this issue on GitHub.");
                r6Var.w(message);
            } else if (aVar == c.a.DUMP) {
                r6Var.y(cVarB.f27036c);
                if (cVarB.f27037d != null) {
                    DebugMeta debugMeta = new DebugMeta();
                    debugMeta.setImages(cVarB.f27037d);
                    r6Var.setDebugMeta(debugMeta);
                }
            }
            r6Var.v(SentryLevel.FATAL);
            r6Var.z(io.sentry.n.e(timestamp));
            if (this.f27029c.isAttachAnrThreadDump() && (bArr = cVarB.f27035b) != null) {
                l0VarE.l(io.sentry.b.b(bArr));
            }
            if (this.f27028b.E(r6Var, l0VarE).equals(SentryId.EMPTY_ID) || bVar.g()) {
                return;
            }
            this.f27029c.getLogger().c(SentryLevel.WARNING, "Timed out waiting to flush ANR event to disk. Event: %s", r6Var.getEventId());
        }

        private void d(@NotNull List<ApplicationExitInfo> list, @Nullable Long l10) {
            Collections.reverse(list);
            for (ApplicationExitInfo applicationExitInfo : list) {
                if (applicationExitInfo.getReason() == 6) {
                    if (applicationExitInfo.getTimestamp() < this.f27030d) {
                        this.f27029c.getLogger().c(SentryLevel.DEBUG, "ANR happened too long ago %s.", applicationExitInfo);
                    } else if (l10 == null || applicationExitInfo.getTimestamp() > l10.longValue()) {
                        c(applicationExitInfo, false);
                    } else {
                        this.f27029c.getLogger().c(SentryLevel.DEBUG, "ANR has already been reported %s.", applicationExitInfo);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        @SuppressLint({"NewApi"})
        public void run() {
            ApplicationExitInfo applicationExitInfo = null;
            List historicalProcessExitReasons = ((ActivityManager) this.f27027a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
            if (historicalProcessExitReasons.size() == 0) {
                this.f27029c.getLogger().c(SentryLevel.DEBUG, "No records in historical exit reasons.", new Object[0]);
                return;
            }
            io.sentry.cache.g envelopeDiskCache = this.f27029c.getEnvelopeDiskCache();
            if ((envelopeDiskCache instanceof io.sentry.cache.f) && this.f27029c.isEnableAutoSessionTracking()) {
                io.sentry.cache.f fVar = (io.sentry.cache.f) envelopeDiskCache;
                if (!fVar.B()) {
                    this.f27029c.getLogger().c(SentryLevel.WARNING, "Timed out waiting to flush previous session to its own file.", new Object[0]);
                    fVar.u();
                }
            }
            ArrayList arrayList = new ArrayList(historicalProcessExitReasons);
            Long lI = io.sentry.android.core.cache.b.I(this.f27029c);
            Iterator<ApplicationExitInfo> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ApplicationExitInfo next = it.next();
                if (next.getReason() == 6) {
                    arrayList.remove(next);
                    applicationExitInfo = next;
                    break;
                }
            }
            if (applicationExitInfo == null) {
                this.f27029c.getLogger().c(SentryLevel.DEBUG, "No ANRs have been found in the historical exit reasons list.", new Object[0]);
                return;
            }
            if (applicationExitInfo.getTimestamp() < this.f27030d) {
                this.f27029c.getLogger().c(SentryLevel.DEBUG, "Latest ANR happened too long ago, returning early.", new Object[0]);
                return;
            }
            if (lI != null && applicationExitInfo.getTimestamp() <= lI.longValue()) {
                this.f27029c.getLogger().c(SentryLevel.DEBUG, "Latest ANR has already been reported, returning early.", new Object[0]);
                return;
            }
            if (this.f27029c.isReportHistoricalAnrs()) {
                d(arrayList, lI);
            }
            c(applicationExitInfo, true);
        }
    }

    public AnrV2Integration(@NotNull Context context) {
        this(context, io.sentry.transport.n.b());
    }

    @Override // io.sentry.v1
    @SuppressLint({"NewApi"})
    public void c(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.w.c(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.f27026c = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "AnrIntegration enabled: %s", Boolean.valueOf(this.f27026c.isAnrEnabled()));
        if (this.f27026c.getCacheDirPath() == null) {
            this.f27026c.getLogger().c(SentryLevel.INFO, "Cache dir is not set, unable to process ANRs", new Object[0]);
            return;
        }
        if (this.f27026c.isAnrEnabled()) {
            try {
                sentryOptions.getExecutorService().submit(new a(this.f27024a, f1Var, this.f27026c, this.f27025b));
            } catch (Throwable th) {
                sentryOptions.getLogger().b(SentryLevel.DEBUG, "Failed to start AnrProcessor.", th);
            }
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "AnrV2Integration installed.", new Object[0]);
            io.sentry.util.p.a("AnrV2");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SentryAndroidOptions sentryAndroidOptions = this.f27026c;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "AnrV2Integration removed.", new Object[0]);
        }
    }

    AnrV2Integration(@NotNull Context context, @NotNull io.sentry.transport.p pVar) {
        this.f27024a = e1.h(context);
        this.f27025b = pVar;
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f27034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[] f27035b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        final List<SentryThread> f27036c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        final List<DebugImage> f27037d;

        enum a {
            DUMP,
            NO_DUMP,
            ERROR
        }

        c(@NotNull a aVar) {
            this.f27034a = aVar;
            this.f27035b = null;
            this.f27036c = null;
            this.f27037d = null;
        }

        c(@NotNull a aVar, byte[] bArr) {
            this.f27034a = aVar;
            this.f27035b = bArr;
            this.f27036c = null;
            this.f27037d = null;
        }

        c(@NotNull a aVar, byte[] bArr, @Nullable List<SentryThread> list, @Nullable List<DebugImage> list2) {
            this.f27034a = aVar;
            this.f27035b = bArr;
            this.f27036c = list;
            this.f27037d = list2;
        }
    }

    @ApiStatus.Internal
    public static final class b extends io.sentry.hints.d implements io.sentry.hints.c, io.sentry.hints.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f27031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f27032e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f27033f;

        public b(long j10, @NotNull io.sentry.w0 w0Var, long j11, boolean z10, boolean z11) {
            super(j10, w0Var);
            this.f27031d = j11;
            this.f27032e = z10;
            this.f27033f = z11;
        }

        @Override // io.sentry.hints.c
        public boolean a() {
            return this.f27032e;
        }

        @Override // io.sentry.hints.f
        public boolean b(@Nullable SentryId sentryId) {
            return true;
        }

        @Override // io.sentry.hints.a
        public Long e() {
            return Long.valueOf(this.f27031d);
        }

        @Override // io.sentry.hints.a
        public boolean f() {
            return false;
        }

        @Override // io.sentry.hints.a
        public String h() {
            return this.f27033f ? "anr_background" : "anr_foreground";
        }

        @Override // io.sentry.hints.f
        public void c(@NotNull SentryId sentryId) {
        }
    }
}
