package io.sentry;

import io.sentry.protocol.SentryPackage;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryIntegrationPackageStorage.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private static volatile a7 f26979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final io.sentry.util.a f26980d = new io.sentry.util.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private static volatile Boolean f26981e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final io.sentry.util.a f26982f = new io.sentry.util.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f26983a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<SentryPackage> f26984b = new CopyOnWriteArraySet();

    private a7() {
    }

    @NotNull
    public static a7 d() {
        if (f26979c == null) {
            k1 k1VarA = f26980d.a();
            try {
                if (f26979c == null) {
                    f26979c = new a7();
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
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
        return f26979c;
    }

    public void a(@NotNull String str) {
        io.sentry.util.w.c(str, "integration is required.");
        this.f26983a.add(str);
    }

    public void b(@NotNull String str, @NotNull String str2) {
        io.sentry.util.w.c(str, "name is required.");
        io.sentry.util.w.c(str2, "version is required.");
        this.f26984b.add(new SentryPackage(str, str2));
        k1 k1VarA = f26982f.a();
        try {
            f26981e = null;
            if (k1VarA != null) {
                k1VarA.close();
            }
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

    public boolean c(@NotNull w0 w0Var) {
        Boolean bool = f26981e;
        if (bool != null) {
            return bool.booleanValue();
        }
        k1 k1VarA = f26982f.a();
        try {
            boolean z10 = false;
            for (SentryPackage sentryPackage : this.f26984b) {
                if (sentryPackage.getName().startsWith("maven:io.sentry:") && !"8.14.0".equalsIgnoreCase(sentryPackage.getVersion())) {
                    w0Var.c(SentryLevel.ERROR, "The Sentry SDK has been configured with mixed versions. Expected %s to match core SDK version %s but was %s", sentryPackage.getName(), "8.14.0", sentryPackage.getVersion());
                    z10 = true;
                }
            }
            if (z10) {
                SentryLevel sentryLevel = SentryLevel.ERROR;
                w0Var.c(sentryLevel, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
                w0Var.c(sentryLevel, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
                w0Var.c(sentryLevel, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
                w0Var.c(sentryLevel, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
            }
            f26981e = Boolean.valueOf(z10);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return z10;
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
    public Set<String> e() {
        return this.f26983a;
    }

    @NotNull
    public Set<SentryPackage> f() {
        return this.f26984b;
    }
}
