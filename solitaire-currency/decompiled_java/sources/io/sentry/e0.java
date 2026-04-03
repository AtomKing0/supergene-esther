package io.sentry;

import io.sentry.util.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EnvelopeSender.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class e0 extends w implements u0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final f1 f27770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final l1 f27771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final w0 f27772g;

    public e0(@NotNull f1 f1Var, @NotNull l1 l1Var, @NotNull w0 w0Var, long j10, int i10) {
        super(f1Var, w0Var, j10, i10);
        this.f27770e = (f1) io.sentry.util.w.c(f1Var, "Scopes are required.");
        this.f27771f = (l1) io.sentry.util.w.c(l1Var, "Serializer is required.");
        this.f27772g = (w0) io.sentry.util.w.c(w0Var, "Logger is required.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(io.sentry.hints.i iVar) {
        if (iVar.g()) {
            return;
        }
        this.f27772g.c(SentryLevel.WARNING, "Timed out waiting for envelope submission.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Throwable th, File file, io.sentry.hints.k kVar) {
        kVar.d(false);
        this.f27772g.a(SentryLevel.INFO, th, "File '%s' won't retry.", file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(File file, io.sentry.hints.k kVar) {
        if (kVar.a()) {
            this.f27772g.c(SentryLevel.INFO, "File not deleted since retry was marked. %s.", file.getAbsolutePath());
        } else {
            m(file, "after trying to capture it");
            this.f27772g.c(SentryLevel.DEBUG, "Deleted file %s.", file.getAbsolutePath());
        }
    }

    private void m(@NotNull File file, @NotNull String str) {
        try {
            if (file.delete()) {
                return;
            }
            this.f27772g.c(SentryLevel.ERROR, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        } catch (Throwable th) {
            this.f27772g.a(SentryLevel.ERROR, th, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        }
    }

    @Override // io.sentry.u0
    public void a(@NotNull String str, @NotNull l0 l0Var) {
        io.sentry.util.w.c(str, "Path is required.");
        f(new File(str), l0Var);
    }

    @Override // io.sentry.w
    protected boolean c(@NotNull String str) {
        return str.endsWith(".envelope");
    }

    @Override // io.sentry.w
    public /* bridge */ /* synthetic */ void e(@NotNull File file) {
        super.e(file);
    }

    @Override // io.sentry.w
    protected void f(@NotNull final File file, @NotNull l0 l0Var) {
        w0 w0Var;
        m.a aVar;
        if (!file.isFile()) {
            this.f27772g.c(SentryLevel.DEBUG, "'%s' is not a file.", file.getAbsolutePath());
            return;
        }
        if (!c(file.getName())) {
            this.f27772g.c(SentryLevel.DEBUG, "File '%s' doesn't match extension expected.", file.getAbsolutePath());
            return;
        }
        try {
            if (!file.getParentFile().canWrite()) {
                this.f27772g.c(SentryLevel.WARNING, "File '%s' cannot be deleted so it will not be processed.", file.getAbsolutePath());
                return;
            }
            try {
                try {
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            p5 p5VarD = this.f27771f.d(bufferedInputStream);
                            if (p5VarD == null) {
                                this.f27772g.c(SentryLevel.ERROR, "Failed to deserialize cached envelope %s", file.getAbsolutePath());
                            } else {
                                this.f27770e.i(p5VarD, l0Var);
                            }
                            io.sentry.util.m.q(l0Var, io.sentry.hints.i.class, this.f27772g, new m.a() { // from class: io.sentry.b0
                                @Override // io.sentry.util.m.a
                                public final void accept(Object obj) {
                                    this.f27588a.j((io.sentry.hints.i) obj);
                                }
                            });
                            bufferedInputStream.close();
                            w0Var = this.f27772g;
                            aVar = new m.a() { // from class: io.sentry.c0
                                @Override // io.sentry.util.m.a
                                public final void accept(Object obj) {
                                    this.f27627a.l(file, (io.sentry.hints.k) obj);
                                }
                            };
                        } catch (Throwable th) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (IOException e10) {
                        this.f27772g.a(SentryLevel.ERROR, e10, "I/O on file '%s' failed.", file.getAbsolutePath());
                        w0Var = this.f27772g;
                        aVar = new m.a() { // from class: io.sentry.c0
                            @Override // io.sentry.util.m.a
                            public final void accept(Object obj) {
                                this.f27627a.l(file, (io.sentry.hints.k) obj);
                            }
                        };
                    }
                } catch (FileNotFoundException e11) {
                    this.f27772g.a(SentryLevel.ERROR, e11, "File '%s' cannot be found.", file.getAbsolutePath());
                    w0Var = this.f27772g;
                    aVar = new m.a() { // from class: io.sentry.c0
                        @Override // io.sentry.util.m.a
                        public final void accept(Object obj) {
                            this.f27627a.l(file, (io.sentry.hints.k) obj);
                        }
                    };
                }
            } catch (Throwable th3) {
                this.f27772g.a(SentryLevel.ERROR, th3, "Failed to capture cached envelope %s", file.getAbsolutePath());
                io.sentry.util.m.q(l0Var, io.sentry.hints.k.class, this.f27772g, new m.a() { // from class: io.sentry.d0
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        this.f27752a.k(th3, file, (io.sentry.hints.k) obj);
                    }
                });
                w0Var = this.f27772g;
                aVar = new m.a() { // from class: io.sentry.c0
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        this.f27627a.l(file, (io.sentry.hints.k) obj);
                    }
                };
            }
            io.sentry.util.m.q(l0Var, io.sentry.hints.k.class, w0Var, aVar);
        } catch (Throwable th4) {
            io.sentry.util.m.q(l0Var, io.sentry.hints.k.class, this.f27772g, new m.a() { // from class: io.sentry.c0
                @Override // io.sentry.util.m.a
                public final void accept(Object obj) {
                    this.f27627a.l(file, (io.sentry.hints.k) obj);
                }
            });
            throw th4;
        }
    }
}
