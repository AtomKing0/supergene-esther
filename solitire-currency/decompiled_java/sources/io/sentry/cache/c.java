package io.sentry.cache;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.b7;
import io.sentry.e8;
import io.sentry.l1;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.util.r;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CacheStrategy.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Charset f27651e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    protected SentryOptions f27652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    protected final io.sentry.util.r<l1> f27653b = new io.sentry.util.r<>(new r.a() { // from class: io.sentry.cache.a
        @Override // io.sentry.util.r.a
        public final Object a() {
            return this.f27650a.j();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    protected final File f27654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f27655d;

    c(@NotNull SentryOptions sentryOptions, @NotNull String str, int i10) {
        io.sentry.util.w.c(str, "Directory is required.");
        this.f27652a = (SentryOptions) io.sentry.util.w.c(sentryOptions, "SentryOptions is required.");
        this.f27654c = new File(str);
        this.f27655d = i10;
    }

    @NotNull
    private p5 d(@NotNull p5 p5Var, @NotNull p6 p6Var) {
        ArrayList arrayList = new ArrayList();
        Iterator<p6> it = p5Var.c().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add(p6Var);
        return new p5(p5Var.b(), arrayList);
    }

    @Nullable
    private e8 e(@NotNull p5 p5Var) {
        for (p6 p6Var : p5Var.c()) {
            if (g(p6Var)) {
                return n(p6Var);
            }
        }
        return null;
    }

    private boolean g(@Nullable p6 p6Var) {
        if (p6Var == null) {
            return false;
        }
        return p6Var.K().b().equals(b7.Session);
    }

    private boolean h(@NotNull p5 p5Var) {
        return p5Var.c().iterator().hasNext();
    }

    private boolean i(@NotNull e8 e8Var) {
        return e8Var.l().equals(e8.b.Ok) && e8Var.j() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ l1 j() {
        return this.f27652a.getSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int k(File file, File file2) {
        return Long.compare(file.lastModified(), file2.lastModified());
    }

    private void l(@NotNull File file, @NotNull File[] fileArr) {
        Boolean boolG;
        p6 p6VarF;
        e8 e8VarN;
        p5 p5VarM = m(file);
        if (p5VarM == null || !h(p5VarM)) {
            return;
        }
        this.f27652a.getClientReportRecorder().b(io.sentry.clientreport.f.CACHE_OVERFLOW, p5VarM);
        e8 e8VarE = e(p5VarM);
        if (e8VarE == null || !i(e8VarE) || (boolG = e8VarE.g()) == null || !boolG.booleanValue()) {
            return;
        }
        for (File file2 : fileArr) {
            p5 p5VarM2 = m(file2);
            if (p5VarM2 != null && h(p5VarM2)) {
                Iterator<p6> it = p5VarM2.c().iterator();
                while (true) {
                    p6VarF = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    p6 next = it.next();
                    if (g(next) && (e8VarN = n(next)) != null && i(e8VarN)) {
                        Boolean boolG2 = e8VarN.g();
                        if (boolG2 != null && boolG2.booleanValue()) {
                            this.f27652a.getLogger().c(SentryLevel.ERROR, "Session %s has 2 times the init flag.", e8VarE.j());
                            return;
                        }
                        if (e8VarE.j() != null && e8VarE.j().equals(e8VarN.j())) {
                            e8VarN.n();
                            try {
                                p6VarF = p6.F(this.f27653b.a(), e8VarN);
                                it.remove();
                                break;
                            } catch (IOException e10) {
                                this.f27652a.getLogger().a(SentryLevel.ERROR, e10, "Failed to create new envelope item for the session %s", e8VarE.j());
                            }
                        }
                    }
                }
                if (p6VarF != null) {
                    p5 p5VarD = d(p5VarM2, p6VarF);
                    long jLastModified = file2.lastModified();
                    if (!file2.delete()) {
                        this.f27652a.getLogger().c(SentryLevel.WARNING, "File can't be deleted: %s", file2.getAbsolutePath());
                    }
                    p(p5VarD, file2, jLastModified);
                    return;
                }
            }
        }
    }

    @Nullable
    private p5 m(@NotNull File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                p5 p5VarD = this.f27653b.a().d(bufferedInputStream);
                bufferedInputStream.close();
                return p5VarD;
            } finally {
            }
        } catch (IOException e10) {
            this.f27652a.getLogger().b(SentryLevel.ERROR, "Failed to deserialize the envelope.", e10);
            return null;
        }
    }

    @Nullable
    private e8 n(@NotNull p6 p6Var) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(p6Var.I()), f27651e));
            try {
                e8 e8Var = (e8) this.f27653b.a().c(bufferedReader, e8.class);
                bufferedReader.close();
                return e8Var;
            } finally {
            }
        } catch (Throwable th) {
            this.f27652a.getLogger().b(SentryLevel.ERROR, "Failed to deserialize the session.", th);
            return null;
        }
    }

    private void p(@NotNull p5 p5Var, @NotNull File file, long j10) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                this.f27653b.a().b(p5Var, fileOutputStream);
                file.setLastModified(j10);
                fileOutputStream.close();
            } finally {
            }
        } catch (Throwable th) {
            this.f27652a.getLogger().b(SentryLevel.ERROR, "Failed to serialize the new envelope to the disk.", th);
        }
    }

    private void q(@NotNull File[] fileArr) {
        if (fileArr.length > 1) {
            Arrays.sort(fileArr, new Comparator() { // from class: io.sentry.cache.b
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return c.k((File) obj, (File) obj2);
                }
            });
        }
    }

    protected boolean f() {
        if (this.f27654c.isDirectory() && this.f27654c.canWrite() && this.f27654c.canRead()) {
            return true;
        }
        this.f27652a.getLogger().c(SentryLevel.ERROR, "The directory for caching files is inaccessible.: %s", this.f27654c.getAbsolutePath());
        return false;
    }

    protected void o(@NotNull File[] fileArr) {
        int length = fileArr.length;
        if (length >= this.f27655d) {
            this.f27652a.getLogger().c(SentryLevel.WARNING, "Cache folder if full (respecting maxSize). Rotating files", new Object[0]);
            int i10 = (length - this.f27655d) + 1;
            q(fileArr);
            File[] fileArr2 = (File[]) Arrays.copyOfRange(fileArr, i10, length);
            for (int i11 = 0; i11 < i10; i11++) {
                File file = fileArr[i11];
                l(file, fileArr2);
                if (!file.delete()) {
                    this.f27652a.getLogger().c(SentryLevel.WARNING, "File can't be deleted: %s", file.getAbsolutePath());
                }
            }
        }
    }
}
