package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.g5;
import io.sentry.t6;
import io.sentry.w8;
import io.sentry.x8;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class SentryPerformanceProvider extends k1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f27088f = SystemClock.uptimeMillis();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Application f27089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.w0 f27090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final w0 f27091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27092e = new io.sentry.util.a();

    public SentryPerformanceProvider() {
        y yVar = new y();
        this.f27090c = yVar;
        this.f27091d = new w0(yVar);
    }

    private void a(@NotNull Context context, @NotNull g5 g5Var, @NotNull io.sentry.android.core.performance.h hVar) {
        if (!g5Var.f()) {
            this.f27090c.c(SentryLevel.DEBUG, "App start profiling was not sampled. It will not start.", new Object[0]);
            return;
        }
        u uVar = new u(this.f27091d, new io.sentry.android.core.internal.util.v(context.getApplicationContext(), this.f27090c, this.f27091d), this.f27090c, g5Var.c(), g5Var.d(), new t6());
        hVar.A(null);
        hVar.z(uVar);
        this.f27090c.c(SentryLevel.DEBUG, "App start continuous profiling started.", new Object[0]);
        SentryOptions sentryOptionsEmpty = SentryOptions.empty();
        sentryOptionsEmpty.setProfileSessionSampleRate(Double.valueOf(g5Var.f() ? 1.0d : 0.0d));
        uVar.c(g5Var.a(), new w8(sentryOptionsEmpty));
    }

    private void b(@NotNull Context context, @NotNull g5 g5Var, @NotNull io.sentry.android.core.performance.h hVar) {
        x8 x8Var = new x8(Boolean.valueOf(g5Var.l()), g5Var.e(), Boolean.valueOf(g5Var.i()), g5Var.b());
        hVar.B(x8Var);
        if (!x8Var.b().booleanValue() || !x8Var.e().booleanValue()) {
            this.f27090c.c(SentryLevel.DEBUG, "App start profiling was not sampled. It will not start.", new Object[0]);
            return;
        }
        i0 i0Var = new i0(context, this.f27091d, new io.sentry.android.core.internal.util.v(context, this.f27090c, this.f27091d), this.f27090c, g5Var.c(), g5Var.j(), g5Var.d(), new t6());
        hVar.z(null);
        hVar.A(i0Var);
        this.f27090c.c(SentryLevel.DEBUG, "App start profiling started.", new Object[0]);
        i0Var.start();
    }

    private void c(@NotNull io.sentry.android.core.performance.h hVar) {
        Context context = getContext();
        if (context == null) {
            this.f27090c.c(SentryLevel.FATAL, "App. Context from ContentProvider is null", new Object[0]);
            return;
        }
        File file = new File(d0.d(context), Sentry.APP_START_PROFILING_CONFIG_FILE_NAME);
        if (file.exists() && file.canRead()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    g5 g5Var = (g5) new io.sentry.i2(SentryOptions.empty()).c(bufferedReader, g5.class);
                    if (g5Var == null) {
                        this.f27090c.c(SentryLevel.WARNING, "Unable to deserialize the SentryAppStartProfilingOptions. App start profiling will not start.", new Object[0]);
                        bufferedReader.close();
                        return;
                    }
                    if (g5Var.g() && g5Var.k()) {
                        a(context, g5Var, hVar);
                        bufferedReader.close();
                    } else if (!g5Var.j()) {
                        this.f27090c.c(SentryLevel.INFO, "Profiling is not enabled. App start profiling will not start.", new Object[0]);
                        bufferedReader.close();
                    } else {
                        if (g5Var.h()) {
                            b(context, g5Var, hVar);
                        }
                        bufferedReader.close();
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e10) {
                this.f27090c.b(SentryLevel.ERROR, "App start profiling config file not found. ", e10);
            } catch (Throwable th3) {
                this.f27090c.b(SentryLevel.ERROR, "Error reading app start profiling config file. ", th3);
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void d(@Nullable Context context, @NotNull io.sentry.android.core.performance.h hVar) {
        hVar.r().q(f27088f);
        if (this.f27091d.d() >= 24) {
            hVar.l().q(Process.getStartUptimeMillis());
        }
        if (context instanceof Application) {
            this.f27089b = (Application) context;
        }
        Application application = this.f27089b;
        if (application == null) {
            return;
        }
        hVar.y(application);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (SentryPerformanceProvider.class.getName().equals(providerInfo.authority)) {
            throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        io.sentry.android.core.performance.h hVarQ = io.sentry.android.core.performance.h.q();
        d(getContext(), hVarQ);
        c(hVarQ);
        return true;
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        io.sentry.k1 k1VarA = io.sentry.android.core.performance.h.f27458q.a();
        try {
            io.sentry.q1 q1VarJ = io.sentry.android.core.performance.h.q().j();
            if (q1VarJ != null) {
                q1VarJ.close();
            }
            io.sentry.s0 s0VarI = io.sentry.android.core.performance.h.q().i();
            if (s0VarI != null) {
                s0VarI.b(true);
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
}
