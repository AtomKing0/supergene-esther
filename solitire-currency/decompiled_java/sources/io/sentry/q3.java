package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.util.m;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OutboxSender.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class q3 extends w implements u0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Charset f28094i = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final f1 f28095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final t0 f28096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final l1 f28097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final w0 f28098h;

    public q3(@NotNull f1 f1Var, @NotNull t0 t0Var, @NotNull l1 l1Var, @NotNull w0 w0Var, long j10, int i10) {
        super(f1Var, w0Var, j10, i10);
        this.f28095e = (f1) io.sentry.util.w.c(f1Var, "Scopes are required.");
        this.f28096f = (t0) io.sentry.util.w.c(t0Var, "Envelope reader is required.");
        this.f28097g = (l1) io.sentry.util.w.c(l1Var, "Serializer is required.");
        this.f28098h = (w0) io.sentry.util.w.c(w0Var, "Logger is required.");
    }

    @NotNull
    private x8 i(@Nullable v8 v8Var) {
        String strB;
        if (v8Var != null && (strB = v8Var.b()) != null) {
            try {
                Double dValueOf = Double.valueOf(Double.parseDouble(strB));
                if (io.sentry.util.a0.h(dValueOf, false)) {
                    String strA = v8Var.a();
                    if (strA != null) {
                        Double dValueOf2 = Double.valueOf(Double.parseDouble(strA));
                        if (io.sentry.util.a0.h(dValueOf2, false)) {
                            return new x8(Boolean.TRUE, dValueOf, dValueOf2);
                        }
                    }
                    return io.sentry.util.a0.a(new x8(Boolean.TRUE, dValueOf));
                }
                this.f28098h.c(SentryLevel.ERROR, "Invalid sample rate parsed from TraceContext: %s", strB);
            } catch (Exception unused) {
                this.f28098h.c(SentryLevel.ERROR, "Unable to parse sample rate from TraceContext: %s", strB);
            }
        }
        return new x8(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(File file, io.sentry.hints.k kVar) {
        if (kVar.a()) {
            return;
        }
        try {
            if (file.delete()) {
                return;
            }
            this.f28098h.c(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
        } catch (RuntimeException e10) {
            this.f28098h.a(SentryLevel.ERROR, e10, "Failed to delete: %s", file.getAbsolutePath());
        }
    }

    private void l(@NotNull p6 p6Var, int i10) {
        this.f28098h.c(SentryLevel.ERROR, "Item %d of type %s returned null by the parser.", Integer.valueOf(i10), p6Var.K().b());
    }

    private void m(int i10) {
        this.f28098h.c(SentryLevel.DEBUG, "Item %d is being captured.", Integer.valueOf(i10));
    }

    private void n(@Nullable SentryId sentryId) {
        this.f28098h.c(SentryLevel.WARNING, "Timed out waiting for event id submission: %s", sentryId);
    }

    private void o(@NotNull p5 p5Var, @Nullable SentryId sentryId, int i10) {
        this.f28098h.c(SentryLevel.ERROR, "Item %d of has a different event id (%s) to the envelope header (%s)", Integer.valueOf(i10), p5Var.b().a(), sentryId);
    }

    private void p(@NotNull p5 p5Var, @NotNull l0 l0Var) throws IOException {
        BufferedReader bufferedReader;
        Object objG;
        this.f28098h.c(SentryLevel.DEBUG, "Processing Envelope with %d item(s)", Integer.valueOf(io.sentry.util.c.e(p5Var.c())));
        int i10 = 0;
        for (p6 p6Var : p5Var.c()) {
            i10++;
            if (p6Var.K() == null) {
                this.f28098h.c(SentryLevel.ERROR, "Item %d has no header", Integer.valueOf(i10));
            } else if (b7.Event.equals(p6Var.K().b())) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(p6Var.I()), f28094i));
                } catch (Throwable th) {
                    this.f28098h.b(SentryLevel.ERROR, "Item failed to process.", th);
                }
                try {
                    r6 r6Var = (r6) this.f28097g.c(bufferedReader, r6.class);
                    if (r6Var == null) {
                        l(p6Var, i10);
                    } else {
                        if (r6Var.getSdk() != null) {
                            io.sentry.util.m.s(l0Var, r6Var.getSdk().getName());
                        }
                        if (p5Var.b().a() == null || p5Var.b().a().equals(r6Var.getEventId())) {
                            this.f28095e.E(r6Var, l0Var);
                            m(i10);
                            if (!q(l0Var)) {
                                n(r6Var.getEventId());
                                bufferedReader.close();
                                return;
                            }
                        } else {
                            o(p5Var, r6Var.getEventId(), i10);
                            bufferedReader.close();
                        }
                    }
                    bufferedReader.close();
                    objG = io.sentry.util.m.g(l0Var);
                    if (!(objG instanceof io.sentry.hints.p) && !((io.sentry.hints.p) objG).isSuccess()) {
                        this.f28098h.c(SentryLevel.WARNING, "Envelope had a failed capture at item %d. No more items will be sent.", Integer.valueOf(i10));
                        return;
                    }
                    io.sentry.util.m.o(l0Var, io.sentry.hints.j.class, new m.a() { // from class: io.sentry.p3
                        @Override // io.sentry.util.m.a
                        public final void accept(Object obj) {
                            ((io.sentry.hints.j) obj).reset();
                        }
                    });
                } finally {
                }
            } else {
                if (b7.Transaction.equals(p6Var.K().b())) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(p6Var.I()), f28094i));
                        try {
                            SentryTransaction sentryTransaction = (SentryTransaction) this.f28097g.c(bufferedReader, SentryTransaction.class);
                            if (sentryTransaction == null) {
                                l(p6Var, i10);
                            } else if (p5Var.b().a() == null || p5Var.b().a().equals(sentryTransaction.getEventId())) {
                                v8 v8VarC = p5Var.b().c();
                                if (sentryTransaction.getContexts().getTrace() != null) {
                                    sentryTransaction.getContexts().getTrace().s(i(v8VarC));
                                }
                                this.f28095e.m(sentryTransaction, v8VarC, l0Var);
                                m(i10);
                                if (!q(l0Var)) {
                                    n(sentryTransaction.getEventId());
                                    bufferedReader.close();
                                    return;
                                }
                            } else {
                                o(p5Var, sentryTransaction.getEventId(), i10);
                                bufferedReader.close();
                            }
                            bufferedReader.close();
                        } finally {
                        }
                    } catch (Throwable th2) {
                        this.f28098h.b(SentryLevel.ERROR, "Item failed to process.", th2);
                    }
                } else {
                    this.f28095e.i(new p5(p5Var.b().a(), p5Var.b().b(), p6Var), l0Var);
                    this.f28098h.c(SentryLevel.DEBUG, "%s item %d is being captured.", p6Var.K().b().getItemType(), Integer.valueOf(i10));
                    if (!q(l0Var)) {
                        this.f28098h.c(SentryLevel.WARNING, "Timed out waiting for item type submission: %s", p6Var.K().b().getItemType());
                        return;
                    }
                }
                objG = io.sentry.util.m.g(l0Var);
                if (!(objG instanceof io.sentry.hints.p)) {
                }
                io.sentry.util.m.o(l0Var, io.sentry.hints.j.class, new m.a() { // from class: io.sentry.p3
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        ((io.sentry.hints.j) obj).reset();
                    }
                });
            }
        }
    }

    private boolean q(@NotNull l0 l0Var) {
        Object objG = io.sentry.util.m.g(l0Var);
        if (objG instanceof io.sentry.hints.i) {
            return ((io.sentry.hints.i) objG).g();
        }
        io.sentry.util.t.a(io.sentry.hints.i.class, objG, this.f28098h);
        return true;
    }

    @Override // io.sentry.u0
    public void a(@NotNull String str, @NotNull l0 l0Var) {
        io.sentry.util.w.c(str, "Path is required.");
        f(new File(str), l0Var);
    }

    @Override // io.sentry.w
    protected boolean c(@Nullable String str) {
        return (str == null || str.startsWith("session") || str.startsWith("previous_session") || str.startsWith("startup_crash")) ? false : true;
    }

    @Override // io.sentry.w
    public /* bridge */ /* synthetic */ void e(@NotNull File file) {
        super.e(file);
    }

    @Override // io.sentry.w
    protected void f(@NotNull final File file, @NotNull l0 l0Var) {
        w0 w0Var;
        m.a aVar;
        BufferedInputStream bufferedInputStream;
        io.sentry.util.w.c(file, "File is required.");
        try {
            if (!c(file.getName())) {
                this.f28098h.c(SentryLevel.DEBUG, "File '%s' should be ignored.", file.getAbsolutePath());
                return;
            }
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (IOException e10) {
                this.f28098h.b(SentryLevel.ERROR, "Error processing envelope.", e10);
                w0Var = this.f28098h;
                aVar = new m.a() { // from class: io.sentry.o3
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        this.f28028a.k(file, (io.sentry.hints.k) obj);
                    }
                };
            }
            try {
                p5 p5VarA = this.f28096f.a(bufferedInputStream);
                if (p5VarA == null) {
                    this.f28098h.c(SentryLevel.ERROR, "Stream from path %s resulted in a null envelope.", file.getAbsolutePath());
                } else {
                    p(p5VarA, l0Var);
                    this.f28098h.c(SentryLevel.DEBUG, "File '%s' is done.", file.getAbsolutePath());
                }
                bufferedInputStream.close();
                w0Var = this.f28098h;
                aVar = new m.a() { // from class: io.sentry.o3
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        this.f28028a.k(file, (io.sentry.hints.k) obj);
                    }
                };
                io.sentry.util.m.q(l0Var, io.sentry.hints.k.class, w0Var, aVar);
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            io.sentry.util.m.q(l0Var, io.sentry.hints.k.class, this.f28098h, new m.a() { // from class: io.sentry.o3
                @Override // io.sentry.util.m.a
                public final void accept(Object obj) {
                    this.f28028a.k(file, (io.sentry.hints.k) obj);
                }
            });
            throw th3;
        }
    }
}
