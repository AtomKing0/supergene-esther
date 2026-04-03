package io.sentry.cache;

import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.c1;
import io.sentry.cache.tape.c;
import io.sentry.cache.tape.d;
import io.sentry.g4;
import io.sentry.j8;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.util.r;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PersistingScopeObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public final class w extends g4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Charset f27716c = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private SentryOptions f27717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.r<io.sentry.cache.tape.c<Breadcrumb>> f27718b = new io.sentry.util.r<>(new r.a() { // from class: io.sentry.cache.l
        @Override // io.sentry.util.r.a
        public final Object a() {
            return this.f27666a.B();
        }
    });

    /* JADX INFO: compiled from: PersistingScopeObserver.java */
    class a implements c.a<Breadcrumb> {
        a() {
        }

        @Override // io.sentry.cache.tape.c.a
        @Nullable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Breadcrumb b(byte[] bArr) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), w.f27716c));
                try {
                    Breadcrumb breadcrumb = (Breadcrumb) w.this.f27717a.getSerializer().c(bufferedReader, Breadcrumb.class);
                    bufferedReader.close();
                    return breadcrumb;
                } finally {
                }
            } catch (Throwable th) {
                w.this.f27717a.getLogger().a(SentryLevel.ERROR, th, "Error reading entity from scope cache", new Object[0]);
                return null;
            }
        }

        @Override // io.sentry.cache.tape.c.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(Breadcrumb breadcrumb, OutputStream outputStream) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, w.f27716c));
            try {
                w.this.f27717a.getSerializer().a(breadcrumb, bufferedWriter);
                bufferedWriter.close();
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public w(@NotNull SentryOptions sentryOptions) {
        this.f27717a = sentryOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(Breadcrumb breadcrumb) {
        try {
            this.f27718b.a().a(breadcrumb);
        } catch (IOException e10) {
            this.f27717a.getLogger().b(SentryLevel.ERROR, "Failed to add breadcrumb to file queue", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ io.sentry.cache.tape.c B() {
        io.sentry.cache.tape.d dVarA;
        File fileB = d.b(this.f27717a, ".scope-cache");
        if (fileB == null) {
            this.f27717a.getLogger().c(SentryLevel.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
            return io.sentry.cache.tape.c.q();
        }
        File file = new File(fileB, "breadcrumbs.json");
        try {
            try {
                dVarA = new d.a(file).b(this.f27717a.getMaxBreadcrumbs()).a();
            } catch (IOException e10) {
                this.f27717a.getLogger().b(SentryLevel.ERROR, "Failed to create breadcrumbs queue", e10);
                return io.sentry.cache.tape.c.q();
            }
        } catch (IOException unused) {
            file.delete();
            dVarA = new d.a(file).b(this.f27717a.getMaxBreadcrumbs()).a();
        }
        return io.sentry.cache.tape.c.n(dVarA, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            this.f27717a.getLogger().b(SentryLevel.ERROR, "Serialization task failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        try {
            this.f27718b.a().clear();
        } catch (IOException e10) {
            this.f27717a.getLogger().b(SentryLevel.ERROR, "Failed to clear breadcrumbs from file queue", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(Contexts contexts) {
        S(contexts, "contexts.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(Map map) {
        S(map, "extras.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(Collection collection) {
        S(collection, "fingerprint.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(SentryLevel sentryLevel) {
        if (sentryLevel == null) {
            z("level.json");
        } else {
            S(sentryLevel, "level.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(SentryId sentryId) {
        S(sentryId, "replay.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(Request request) {
        if (request == null) {
            z("request.json");
        } else {
            S(request, "request.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(Map map) {
        S(map, "tags.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(j8 j8Var, c1 c1Var) {
        if (j8Var == null) {
            S(c1Var.getPropagationContext().j(), "trace.json");
        } else {
            S(j8Var, "trace.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(String str) {
        if (str == null) {
            z("transaction.json");
        } else {
            S(str, "transaction.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(User user) {
        if (user == null) {
            z("user.json");
        } else {
            S(user, "user.json");
        }
    }

    private void Q(@NotNull final Runnable runnable) {
        if (this.f27717a.isEnableScopePersistence()) {
            if (Thread.currentThread().getName().contains("SentryExecutor")) {
                try {
                    runnable.run();
                    return;
                } catch (Throwable th) {
                    this.f27717a.getLogger().b(SentryLevel.ERROR, "Serialization task failed", th);
                    return;
                }
            }
            try {
                this.f27717a.getExecutorService().submit(new Runnable() { // from class: io.sentry.cache.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27667a.C(runnable);
                    }
                });
            } catch (Throwable th2) {
                this.f27717a.getLogger().b(SentryLevel.ERROR, "Serialization task could not be scheduled", th2);
            }
        }
    }

    public static <T> void R(@NotNull SentryOptions sentryOptions, @NotNull T t10, @NotNull String str) {
        d.d(sentryOptions, t10, ".scope-cache", str);
    }

    private <T> void S(@NotNull T t10, @NotNull String str) {
        R(this.f27717a, t10, str);
    }

    private void z(@NotNull String str) {
        d.a(this.f27717a, ".scope-cache", str);
    }

    @Nullable
    public <T> T O(@NotNull SentryOptions sentryOptions, @NotNull String str, @NotNull Class<T> cls) {
        if (!str.equals("breadcrumbs.json")) {
            return (T) d.c(sentryOptions, ".scope-cache", str, cls, null);
        }
        try {
            return cls.cast(this.f27718b.a().i());
        } catch (IOException unused) {
            sentryOptions.getLogger().c(SentryLevel.ERROR, "Unable to read serialized breadcrumbs from QueueFile", new Object[0]);
            return null;
        }
    }

    public void P() {
        try {
            this.f27718b.a().clear();
        } catch (IOException e10) {
            this.f27717a.getLogger().b(SentryLevel.ERROR, "Failed to clear breadcrumbs from file queue", e10);
        }
        z("user.json");
        z("level.json");
        z("request.json");
        z("fingerprint.json");
        z("contexts.json");
        z("extras.json");
        z("tags.json");
        z("trace.json");
        z("transaction.json");
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void a(@NotNull final Map<String, String> map) {
        Q(new Runnable() { // from class: io.sentry.cache.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f27676a.K(map);
            }
        });
    }

    @Override // io.sentry.d1
    public void c(@NotNull final Breadcrumb breadcrumb) {
        Q(new Runnable() { // from class: io.sentry.cache.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f27714a.A(breadcrumb);
            }
        });
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void d(@NotNull Collection<Breadcrumb> collection) {
        if (collection.isEmpty()) {
            Q(new Runnable() { // from class: io.sentry.cache.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27663a.D();
                }
            });
        }
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void e(@NotNull final Collection<String> collection) {
        Q(new Runnable() { // from class: io.sentry.cache.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f27678a.G(collection);
            }
        });
    }

    @Override // io.sentry.d1
    public void f(@Nullable final j8 j8Var, @NotNull final c1 c1Var) {
        Q(new Runnable() { // from class: io.sentry.cache.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f27671a.L(j8Var, c1Var);
            }
        });
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void g(@NotNull final Contexts contexts) {
        Q(new Runnable() { // from class: io.sentry.cache.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f27682a.E(contexts);
            }
        });
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void h(@Nullable final Request request) {
        Q(new Runnable() { // from class: io.sentry.cache.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f27680a.J(request);
            }
        });
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void i(@NotNull final Map<String, Object> map) {
        Q(new Runnable() { // from class: io.sentry.cache.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f27669a.F(map);
            }
        });
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void j(@NotNull final SentryId sentryId) {
        Q(new Runnable() { // from class: io.sentry.cache.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f27674a.I(sentryId);
            }
        });
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void setLevel(@Nullable final SentryLevel sentryLevel) {
        Q(new Runnable() { // from class: io.sentry.cache.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f27661a.H(sentryLevel);
            }
        });
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void setTransaction(@Nullable final String str) {
        Q(new Runnable() { // from class: io.sentry.cache.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f27664a.M(str);
            }
        });
    }

    @Override // io.sentry.d1
    public void setUser(@Nullable final User user) {
        Q(new Runnable() { // from class: io.sentry.cache.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f27712a.N(user);
            }
        });
    }
}
