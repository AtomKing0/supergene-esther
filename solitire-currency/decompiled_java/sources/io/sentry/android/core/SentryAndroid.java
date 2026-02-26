package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.ScopeCallback;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.e8;
import io.sentry.n3;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryAndroid {
    private static final String FRAGMENT_CLASS_NAME = "androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks";
    static final String SENTRY_FRAGMENT_INTEGRATION_CLASS_NAME = "io.sentry.android.fragment.FragmentLifecycleIntegration";
    static final String SENTRY_REPLAY_INTEGRATION_CLASS_NAME = "io.sentry.android.replay.ReplayIntegration";
    static final String SENTRY_TIMBER_INTEGRATION_CLASS_NAME = "io.sentry.android.timber.SentryTimberIntegration";
    private static final String TIMBER_CLASS_NAME = "timber.log.Timber";
    private static final long sdkInitMillis = SystemClock.uptimeMillis();

    @NotNull
    protected static final io.sentry.util.a staticLock = new io.sentry.util.a();

    private SentryAndroid() {
    }

    private static void deduplicateIntegrations(@NotNull SentryOptions sentryOptions, boolean z10, boolean z11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (io.sentry.v1 v1Var : sentryOptions.getIntegrations()) {
            if (z10 && (v1Var instanceof FragmentLifecycleIntegration)) {
                arrayList2.add(v1Var);
            }
            if (z11 && (v1Var instanceof SentryTimberIntegration)) {
                arrayList.add(v1Var);
            }
        }
        if (arrayList2.size() > 1) {
            for (int i10 = 0; i10 < arrayList2.size() - 1; i10++) {
                sentryOptions.getIntegrations().remove((io.sentry.v1) arrayList2.get(i10));
            }
        }
        if (arrayList.size() > 1) {
            for (int i11 = 0; i11 < arrayList.size() - 1; i11++) {
                sentryOptions.getIntegrations().remove((io.sentry.v1) arrayList.get(i11));
            }
        }
    }

    public static void init(@NotNull Context context) {
        init(context, new y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$init$1(io.sentry.w0 w0Var, Context context, Sentry.OptionsConfiguration optionsConfiguration, SentryAndroidOptions sentryAndroidOptions) {
        io.sentry.util.s sVar = new io.sentry.util.s();
        boolean zB = sVar.b(TIMBER_CLASS_NAME, sentryAndroidOptions);
        boolean z10 = sVar.b(FRAGMENT_CLASS_NAME, sentryAndroidOptions) && sVar.b(SENTRY_FRAGMENT_INTEGRATION_CLASS_NAME, sentryAndroidOptions);
        boolean z11 = zB && sVar.b(SENTRY_TIMBER_INTEGRATION_CLASS_NAME, sentryAndroidOptions);
        boolean zB2 = sVar.b(SENTRY_REPLAY_INTEGRATION_CLASS_NAME, sentryAndroidOptions);
        w0 w0Var2 = new w0(w0Var);
        io.sentry.util.s sVar2 = new io.sentry.util.s();
        h hVar = new h(sVar2, sentryAndroidOptions);
        d0.k(sentryAndroidOptions, context, w0Var, w0Var2);
        d0.g(context, sentryAndroidOptions, w0Var2, sVar2, hVar, z10, z11, zB2);
        try {
            optionsConfiguration.configure(sentryAndroidOptions);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th);
        }
        io.sentry.android.core.performance.h hVarQ = io.sentry.android.core.performance.h.q();
        if (sentryAndroidOptions.isEnablePerformanceV2() && w0Var2.d() >= 24) {
            io.sentry.android.core.performance.i iVarL = hVarQ.l();
            if (iVarL.l()) {
                iVarL.q(Process.getStartUptimeMillis());
            }
        }
        if (context.getApplicationContext() instanceof Application) {
            hVarQ.y((Application) context.getApplicationContext());
        }
        io.sentry.android.core.performance.i iVarR = hVarQ.r();
        if (iVarR.l()) {
            iVarR.q(sdkInitMillis);
        }
        d0.f(sentryAndroidOptions, context, w0Var2, sVar2, hVar);
        deduplicateIntegrations(sentryAndroidOptions, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$init$2(AtomicBoolean atomicBoolean, io.sentry.c1 c1Var) {
        e8 session = c1Var.getSession();
        if (session == null || session.k() == null) {
            return;
        }
        atomicBoolean.set(true);
    }

    public static void init(@NotNull Context context, @NotNull io.sentry.w0 w0Var) {
        init(context, w0Var, new Sentry.OptionsConfiguration() { // from class: io.sentry.android.core.g2
            @Override // io.sentry.Sentry.OptionsConfiguration
            public final void configure(SentryOptions sentryOptions) {
                SentryAndroid.lambda$init$0((SentryAndroidOptions) sentryOptions);
            }
        });
    }

    public static void init(@NotNull Context context, @NotNull Sentry.OptionsConfiguration<SentryAndroidOptions> optionsConfiguration) {
        init(context, new y(), optionsConfiguration);
    }

    @SuppressLint({"NewApi"})
    public static void init(@NotNull final Context context, @NotNull final io.sentry.w0 w0Var, @NotNull final Sentry.OptionsConfiguration<SentryAndroidOptions> optionsConfiguration) {
        try {
            io.sentry.k1 k1VarA = staticLock.a();
            try {
                Sentry.init(n3.a(SentryAndroidOptions.class), new Sentry.OptionsConfiguration() { // from class: io.sentry.android.core.e2
                    @Override // io.sentry.Sentry.OptionsConfiguration
                    public final void configure(SentryOptions sentryOptions) {
                        SentryAndroid.lambda$init$1(w0Var, context, optionsConfiguration, (SentryAndroidOptions) sentryOptions);
                    }
                }, true);
                io.sentry.f1 currentScopes = Sentry.getCurrentScopes();
                if (e1.t()) {
                    if (currentScopes.getOptions().isEnableAutoSessionTracking()) {
                        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        currentScopes.n(new ScopeCallback() { // from class: io.sentry.android.core.f2
                            @Override // io.sentry.ScopeCallback
                            public final void run(io.sentry.c1 c1Var) {
                                SentryAndroid.lambda$init$2(atomicBoolean, c1Var);
                            }
                        });
                        if (!atomicBoolean.get()) {
                            currentScopes.startSession();
                        }
                    }
                    currentScopes.getOptions().getReplayController().start();
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
        } catch (IllegalAccessException e10) {
            w0Var.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e10);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e10);
        } catch (InstantiationException e11) {
            w0Var.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e11);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e11);
        } catch (NoSuchMethodException e12) {
            w0Var.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e12);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e12);
        } catch (InvocationTargetException e13) {
            w0Var.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e13);
            throw new RuntimeException("Failed to initialize Sentry's SDK", e13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$init$0(SentryAndroidOptions sentryAndroidOptions) {
    }
}
