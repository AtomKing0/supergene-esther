package io.sentry;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DirectoryProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final f1 f28440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final w0 f28441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f28442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue<String> f28443d;

    /* JADX INFO: compiled from: DirectoryProcessor.java */
    private static final class a implements io.sentry.hints.e, io.sentry.hints.k, io.sentry.hints.p, io.sentry.hints.i, io.sentry.hints.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f28444a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f28445b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CountDownLatch f28446c = new CountDownLatch(1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f28447d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private final w0 f28448e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        private final String f28449f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        private final Queue<String> f28450g;

        public a(long j10, @NotNull w0 w0Var, @NotNull String str, @NotNull Queue<String> queue) {
            this.f28447d = j10;
            this.f28449f = str;
            this.f28450g = queue;
            this.f28448e = w0Var;
        }

        @Override // io.sentry.hints.k
        public boolean a() {
            return this.f28444a;
        }

        @Override // io.sentry.hints.g
        public void b() {
            this.f28450g.add(this.f28449f);
        }

        @Override // io.sentry.hints.p
        public void c(boolean z10) {
            this.f28445b = z10;
            this.f28446c.countDown();
        }

        @Override // io.sentry.hints.k
        public void d(boolean z10) {
            this.f28444a = z10;
        }

        @Override // io.sentry.hints.i
        public boolean g() {
            try {
                return this.f28446c.await(this.f28447d, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                this.f28448e.b(SentryLevel.ERROR, "Exception while awaiting on lock.", e10);
                return false;
            }
        }

        @Override // io.sentry.hints.p
        public boolean isSuccess() {
            return this.f28445b;
        }
    }

    w(@NotNull f1 f1Var, @NotNull w0 w0Var, long j10, int i10) {
        this.f28440a = f1Var;
        this.f28441b = w0Var;
        this.f28442c = j10;
        this.f28443d = t8.d(new g(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d(File file, String str) {
        return c(str);
    }

    protected abstract boolean c(String str);

    public void e(@NotNull File file) {
        try {
            w0 w0Var = this.f28441b;
            SentryLevel sentryLevel = SentryLevel.DEBUG;
            w0Var.c(sentryLevel, "Processing dir. %s", file.getAbsolutePath());
            if (!file.exists()) {
                this.f28441b.c(SentryLevel.WARNING, "Directory '%s' doesn't exist. No cached events to send.", file.getAbsolutePath());
                return;
            }
            if (!file.isDirectory()) {
                this.f28441b.c(SentryLevel.ERROR, "Cache dir %s is not a directory.", file.getAbsolutePath());
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                this.f28441b.c(SentryLevel.ERROR, "Cache dir %s is null.", file.getAbsolutePath());
                return;
            }
            File[] fileArrListFiles2 = file.listFiles(new FilenameFilter() { // from class: io.sentry.v
                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str) {
                    return this.f28382a.d(file2, str);
                }
            });
            w0 w0Var2 = this.f28441b;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(fileArrListFiles2 != null ? fileArrListFiles2.length : 0);
            objArr[1] = file.getAbsolutePath();
            w0Var2.c(sentryLevel, "Processing %d items from cache dir %s", objArr);
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    String absolutePath = file2.getAbsolutePath();
                    if (this.f28443d.contains(absolutePath)) {
                        this.f28441b.c(SentryLevel.DEBUG, "File '%s' has already been processed so it will not be processed again.", absolutePath);
                    } else {
                        io.sentry.transport.b0 b0VarE = this.f28440a.e();
                        if (b0VarE != null && b0VarE.J(m.All)) {
                            this.f28441b.c(SentryLevel.INFO, "DirectoryProcessor, rate limiting active.", new Object[0]);
                            return;
                        } else {
                            this.f28441b.c(SentryLevel.DEBUG, "Processing file: %s", absolutePath);
                            f(file2, io.sentry.util.m.e(new a(this.f28442c, this.f28441b, absolutePath, this.f28443d)));
                            Thread.sleep(100L);
                        }
                    }
                } else {
                    this.f28441b.c(SentryLevel.DEBUG, "File %s is not a File.", file2.getAbsolutePath());
                }
            }
        } catch (Throwable th) {
            this.f28441b.a(SentryLevel.ERROR, th, "Failed processing '%s'", file.getAbsolutePath());
        }
    }

    protected abstract void f(@NotNull File file, @NotNull l0 l0Var);
}
