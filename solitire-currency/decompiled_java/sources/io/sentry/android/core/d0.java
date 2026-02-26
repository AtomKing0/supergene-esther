package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import io.sentry.SentryLevel;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.replay.DefaultReplayBreadcrumbConverter;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.compose.gestures.ComposeGestureTargetLocator;
import io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter;
import io.sentry.d3;
import io.sentry.h3;
import io.sentry.h4;
import io.sentry.j3;
import io.sentry.k7;
import io.sentry.u4;
import io.sentry.util.r;
import io.sentry.y4;
import io.sentry.z4;
import java.io.File;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidOptionsInitializer.java */
/* JADX INFO: loaded from: classes5.dex */
final class d0 {
    @NotNull
    static File d(@NotNull Context context) {
        return new File(context.getCacheDir(), "sentry");
    }

    @NotNull
    private static String e(@NotNull PackageInfo packageInfo, @NotNull String str) {
        return packageInfo.packageName + "@" + packageInfo.versionName + "+" + str;
    }

    static void f(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull Context context, @NotNull w0 w0Var, @NotNull io.sentry.util.s sVar, @NotNull h hVar) {
        if (sentryAndroidOptions.getCacheDirPath() != null && (sentryAndroidOptions.getEnvelopeDiskCache() instanceof io.sentry.transport.t)) {
            sentryAndroidOptions.setEnvelopeDiskCache(new io.sentry.android.core.cache.b(sentryAndroidOptions));
        }
        if (sentryAndroidOptions.getConnectionStatusProvider() instanceof io.sentry.o2) {
            sentryAndroidOptions.setConnectionStatusProvider(new io.sentry.android.core.internal.util.a(context, sentryAndroidOptions.getLogger(), w0Var));
        }
        if (sentryAndroidOptions.getCacheDirPath() != null) {
            sentryAndroidOptions.addScopeObserver(new io.sentry.cache.w(sentryAndroidOptions));
            sentryAndroidOptions.addOptionsObserver(new io.sentry.cache.h(sentryAndroidOptions));
        }
        sentryAndroidOptions.addEventProcessor(new io.sentry.o(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new i1(context, w0Var, sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new a2(sentryAndroidOptions, hVar));
        sentryAndroidOptions.addEventProcessor(new ScreenshotEventProcessor(sentryAndroidOptions, w0Var));
        sentryAndroidOptions.addEventProcessor(new ViewHierarchyEventProcessor(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new n0(context, sentryAndroidOptions, w0Var));
        if (sentryAndroidOptions.getTransportGate() instanceof io.sentry.transport.v) {
            sentryAndroidOptions.setTransportGate(new j0(sentryAndroidOptions));
        }
        io.sentry.android.core.performance.h hVarQ = io.sentry.android.core.performance.h.q();
        io.sentry.k1 k1VarA = io.sentry.android.core.performance.h.f27458q.a();
        try {
            io.sentry.q1 q1VarJ = hVarQ.j();
            io.sentry.s0 s0VarI = hVarQ.i();
            hVarQ.A(null);
            hVarQ.z(null);
            if (k1VarA != null) {
                k1VarA.close();
            }
            m(sentryAndroidOptions, context, w0Var, q1VarJ, s0VarI);
            if (sentryAndroidOptions.getModulesLoader() instanceof io.sentry.internal.modules.e) {
                sentryAndroidOptions.setModulesLoader(new io.sentry.android.core.internal.modules.b(context, sentryAndroidOptions.getLogger()));
            }
            if (sentryAndroidOptions.getDebugMetaLoader() instanceof io.sentry.internal.debugmeta.b) {
                sentryAndroidOptions.setDebugMetaLoader(new io.sentry.android.core.internal.debugmeta.a(context, sentryAndroidOptions.getLogger()));
            }
            if (sentryAndroidOptions.getVersionDetector() instanceof j3) {
                sentryAndroidOptions.setVersionDetector(new io.sentry.t(sentryAndroidOptions));
            }
            boolean zB = sVar.b("androidx.core.view.ScrollingView", sentryAndroidOptions);
            boolean zB2 = sVar.b("androidx.compose.ui.node.Owner", sentryAndroidOptions);
            if (sentryAndroidOptions.getGestureTargetLocators().isEmpty()) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(new io.sentry.android.core.internal.gestures.a(zB));
                if (zB2 && sVar.b("io.sentry.compose.gestures.ComposeGestureTargetLocator", sentryAndroidOptions)) {
                    arrayList.add(new ComposeGestureTargetLocator(sentryAndroidOptions.getLogger()));
                }
                sentryAndroidOptions.setGestureTargetLocators(arrayList);
            }
            if (sentryAndroidOptions.getViewHierarchyExporters().isEmpty() && zB2 && sVar.b("io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter", sentryAndroidOptions)) {
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(new ComposeViewHierarchyExporter(sentryAndroidOptions.getLogger()));
                sentryAndroidOptions.setViewHierarchyExporters(arrayList2);
            }
            if (sentryAndroidOptions.getThreadChecker() instanceof io.sentry.util.thread.b) {
                sentryAndroidOptions.setThreadChecker(io.sentry.android.core.internal.util.d.e());
            }
            if (sentryAndroidOptions.getSocketTagger() instanceof d3) {
                sentryAndroidOptions.setSocketTagger(g0.c());
            }
            if (sentryAndroidOptions.getPerformanceCollectors().isEmpty()) {
                sentryAndroidOptions.addPerformanceCollector(new z());
                sentryAndroidOptions.addPerformanceCollector(new v(sentryAndroidOptions.getLogger()));
                if (sentryAndroidOptions.isEnablePerformanceV2()) {
                    sentryAndroidOptions.addPerformanceCollector(new k2(sentryAndroidOptions, (io.sentry.android.core.internal.util.v) io.sentry.util.w.c(sentryAndroidOptions.getFrameMetricsCollector(), "options.getFrameMetricsCollector is required")));
                }
            }
            if (sentryAndroidOptions.getCompositePerformanceCollector() instanceof io.sentry.n2) {
                sentryAndroidOptions.setCompositePerformanceCollector(new io.sentry.q(sentryAndroidOptions));
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

    static void g(@NotNull Context context, @NotNull final SentryAndroidOptions sentryAndroidOptions, @NotNull w0 w0Var, @NotNull io.sentry.util.s sVar, @NotNull h hVar, boolean z10, boolean z11, boolean z12) {
        io.sentry.util.r rVar = new io.sentry.util.r(new r.a() { // from class: io.sentry.android.core.a0
            @Override // io.sentry.util.r.a
            public final Object a() {
                return d0.h(sentryAndroidOptions);
            }
        });
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new y4(new u4() { // from class: io.sentry.android.core.b0
            @Override // io.sentry.u4
            public final String a() {
                return sentryAndroidOptions.getCacheDirPath();
            }
        }), rVar));
        sentryAndroidOptions.addIntegration(new NdkIntegration(sVar.c("io.sentry.android.ndk.SentryNdk", sentryAndroidOptions.getLogger())));
        sentryAndroidOptions.addIntegration(EnvelopeFileObserverIntegration.i());
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new z4(new u4() { // from class: io.sentry.android.core.c0
            @Override // io.sentry.u4
            public final String a() {
                return sentryAndroidOptions.getOutboxPath();
            }
        }), rVar));
        sentryAndroidOptions.addIntegration(new AppLifecycleIntegration());
        sentryAndroidOptions.addIntegration(m0.a(context, w0Var));
        if (context instanceof Application) {
            Application application = (Application) context;
            sentryAndroidOptions.addIntegration(new ActivityLifecycleIntegration(application, w0Var, hVar));
            sentryAndroidOptions.addIntegration(new ActivityBreadcrumbsIntegration(application));
            sentryAndroidOptions.addIntegration(new UserInteractionIntegration(application, sVar));
            if (z10) {
                sentryAndroidOptions.addIntegration(new FragmentLifecycleIntegration(application, true, true));
            }
        } else {
            sentryAndroidOptions.getLogger().c(SentryLevel.WARNING, "ActivityLifecycle, FragmentLifecycle and UserInteraction Integrations need an Application class to be installed.", new Object[0]);
        }
        if (z11) {
            sentryAndroidOptions.addIntegration(new SentryTimberIntegration());
        }
        sentryAndroidOptions.addIntegration(new AppComponentsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new SystemEventsBreadcrumbsIntegration(context));
        sentryAndroidOptions.addIntegration(new NetworkBreadcrumbsIntegration(context, w0Var, sentryAndroidOptions.getLogger()));
        if (z12) {
            ReplayIntegration replayIntegration = new ReplayIntegration(context, io.sentry.transport.n.b());
            replayIntegration.setBreadcrumbConverter(new DefaultReplayBreadcrumbConverter());
            sentryAndroidOptions.addIntegration(replayIntegration);
            sentryAndroidOptions.setReplayController(replayIntegration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean h(SentryAndroidOptions sentryAndroidOptions) {
        return Boolean.valueOf(io.sentry.android.core.cache.b.G(sentryAndroidOptions));
    }

    static void k(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull Context context, @NotNull io.sentry.w0 w0Var, @NotNull w0 w0Var2) {
        io.sentry.util.w.c(context, "The context is required.");
        Context contextH = e1.h(context);
        io.sentry.util.w.c(sentryAndroidOptions, "The options object is required.");
        io.sentry.util.w.c(w0Var, "The ILogger object is required.");
        sentryAndroidOptions.setLogger(w0Var);
        sentryAndroidOptions.setFatalLogger(new x());
        sentryAndroidOptions.setDefaultScopeType(h4.CURRENT);
        sentryAndroidOptions.setOpenTelemetryMode(k7.OFF);
        sentryAndroidOptions.setDateProvider(new h2());
        sentryAndroidOptions.setFlushTimeoutMillis(4000L);
        sentryAndroidOptions.setFrameMetricsCollector(new io.sentry.android.core.internal.util.v(contextH, w0Var, w0Var2));
        v1.a(contextH, sentryAndroidOptions, w0Var2);
        sentryAndroidOptions.setCacheDirPath(d(contextH).getAbsolutePath());
        l(sentryAndroidOptions, contextH, w0Var2);
    }

    private static void l(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull Context context, @NotNull w0 w0Var) {
        PackageInfo packageInfoQ = e1.q(context, w0Var);
        if (packageInfoQ != null) {
            if (sentryAndroidOptions.getRelease() == null) {
                sentryAndroidOptions.setRelease(e(packageInfoQ, e1.r(packageInfoQ, w0Var)));
            }
            String str = packageInfoQ.packageName;
            if (str != null && !str.startsWith("android.")) {
                sentryAndroidOptions.addInAppInclude(str);
            }
        }
        if (sentryAndroidOptions.getDistinctId() == null) {
            try {
                sentryAndroidOptions.setDistinctId(o1.a(context));
            } catch (RuntimeException e10) {
                sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Could not generate distinct Id.", e10);
            }
        }
    }

    private static void m(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull Context context, @NotNull w0 w0Var, @Nullable io.sentry.q1 q1Var, @Nullable io.sentry.s0 s0Var) {
        if (sentryAndroidOptions.isProfilingEnabled() || sentryAndroidOptions.getProfilesSampleRate() != null) {
            sentryAndroidOptions.setContinuousProfiler(io.sentry.p2.a());
            if (s0Var != null) {
                s0Var.b(true);
            }
            if (q1Var != null) {
                sentryAndroidOptions.setTransactionProfiler(q1Var);
                return;
            } else {
                sentryAndroidOptions.setTransactionProfiler(new i0(context, sentryAndroidOptions, w0Var, (io.sentry.android.core.internal.util.v) io.sentry.util.w.c(sentryAndroidOptions.getFrameMetricsCollector(), "options.getFrameMetricsCollector is required")));
                return;
            }
        }
        sentryAndroidOptions.setTransactionProfiler(h3.c());
        if (q1Var != null) {
            q1Var.close();
        }
        if (s0Var != null) {
            sentryAndroidOptions.setContinuousProfiler(s0Var);
        } else {
            sentryAndroidOptions.setContinuousProfiler(new u(w0Var, (io.sentry.android.core.internal.util.v) io.sentry.util.w.c(sentryAndroidOptions.getFrameMetricsCollector(), "options.getFrameMetricsCollector is required"), sentryAndroidOptions.getLogger(), sentryAndroidOptions.getProfilingTracesDirPath(), sentryAndroidOptions.getProfilingTracesHz(), sentryAndroidOptions.getExecutorService()));
        }
    }
}
