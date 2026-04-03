package io.sentry.android.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import io.sentry.SentryLevel;
import io.sentry.a7;
import io.sentry.protocol.SdkVersion;
import io.sentry.u6;
import io.sentry.v3;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ManifestMetadataReader.java */
/* JADX INFO: loaded from: classes5.dex */
final class v1 {
    static void a(@NotNull Context context, @NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull w0 w0Var) {
        io.sentry.util.w.c(context, "The application context is required.");
        io.sentry.util.w.c(sentryAndroidOptions, "The options object is required.");
        try {
            Bundle bundleB = b(context, sentryAndroidOptions.getLogger(), w0Var);
            io.sentry.w0 logger = sentryAndroidOptions.getLogger();
            if (bundleB != null) {
                sentryAndroidOptions.setDebug(d(bundleB, logger, "io.sentry.debug", sentryAndroidOptions.isDebug()));
                if (sentryAndroidOptions.isDebug()) {
                    String strName = sentryAndroidOptions.getDiagnosticLevel().name();
                    Locale locale = Locale.ROOT;
                    String strH = h(bundleB, logger, "io.sentry.debug.level", strName.toLowerCase(locale));
                    if (strH != null) {
                        sentryAndroidOptions.setDiagnosticLevel(SentryLevel.valueOf(strH.toUpperCase(locale)));
                    }
                }
                sentryAndroidOptions.setAnrEnabled(d(bundleB, logger, "io.sentry.anr.enable", sentryAndroidOptions.isAnrEnabled()));
                sentryAndroidOptions.setEnableAutoSessionTracking(d(bundleB, logger, "io.sentry.auto-session-tracking.enable", sentryAndroidOptions.isEnableAutoSessionTracking()));
                if (sentryAndroidOptions.getSampleRate() == null) {
                    double dE = e(bundleB, logger, "io.sentry.sample-rate");
                    if (dE != -1.0d) {
                        sentryAndroidOptions.setSampleRate(Double.valueOf(dE));
                    }
                }
                sentryAndroidOptions.setAnrReportInDebug(d(bundleB, logger, "io.sentry.anr.report-debug", sentryAndroidOptions.isAnrReportInDebug()));
                sentryAndroidOptions.setAnrTimeoutIntervalMillis(g(bundleB, logger, "io.sentry.anr.timeout-interval-millis", sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                sentryAndroidOptions.setAttachAnrThreadDump(d(bundleB, logger, "io.sentry.anr.attach-thread-dumps", sentryAndroidOptions.isAttachAnrThreadDump()));
                String strH2 = h(bundleB, logger, "io.sentry.dsn", sentryAndroidOptions.getDsn());
                boolean zD = d(bundleB, logger, "io.sentry.enabled", sentryAndroidOptions.isEnabled());
                if (!zD || (strH2 != null && strH2.isEmpty())) {
                    sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Sentry enabled flag set to false or DSN is empty: disabling sentry-android", new Object[0]);
                } else if (strH2 == null) {
                    sentryAndroidOptions.getLogger().c(SentryLevel.FATAL, "DSN is required. Use empty string to disable SDK.", new Object[0]);
                }
                sentryAndroidOptions.setEnabled(zD);
                sentryAndroidOptions.setDsn(strH2);
                sentryAndroidOptions.setEnableNdk(d(bundleB, logger, "io.sentry.ndk.enable", sentryAndroidOptions.isEnableNdk()));
                sentryAndroidOptions.setEnableScopeSync(d(bundleB, logger, "io.sentry.ndk.scope-sync.enable", sentryAndroidOptions.isEnableScopeSync()));
                sentryAndroidOptions.setRelease(h(bundleB, logger, "io.sentry.release", sentryAndroidOptions.getRelease()));
                sentryAndroidOptions.setEnvironment(h(bundleB, logger, "io.sentry.environment", sentryAndroidOptions.getEnvironment()));
                sentryAndroidOptions.setSessionTrackingIntervalMillis(g(bundleB, logger, "io.sentry.session-tracking.timeout-interval-millis", sentryAndroidOptions.getSessionTrackingIntervalMillis()));
                sentryAndroidOptions.setMaxBreadcrumbs((int) g(bundleB, logger, "io.sentry.max-breadcrumbs", sentryAndroidOptions.getMaxBreadcrumbs()));
                sentryAndroidOptions.setEnableActivityLifecycleBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.activity-lifecycle", sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableAppLifecycleBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.app-lifecycle", sentryAndroidOptions.isEnableAppLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableSystemEventBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.system-events", sentryAndroidOptions.isEnableSystemEventBreadcrumbs()));
                sentryAndroidOptions.setEnableAppComponentBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.app-components", sentryAndroidOptions.isEnableAppComponentBreadcrumbs()));
                sentryAndroidOptions.setEnableUserInteractionBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.user-interaction", sentryAndroidOptions.isEnableUserInteractionBreadcrumbs()));
                sentryAndroidOptions.setEnableNetworkEventBreadcrumbs(d(bundleB, logger, "io.sentry.breadcrumbs.network-events", sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
                sentryAndroidOptions.setEnableUncaughtExceptionHandler(d(bundleB, logger, "io.sentry.uncaught-exception-handler.enable", sentryAndroidOptions.isEnableUncaughtExceptionHandler()));
                sentryAndroidOptions.setAttachThreads(d(bundleB, logger, "io.sentry.attach-threads", sentryAndroidOptions.isAttachThreads()));
                sentryAndroidOptions.setAttachScreenshot(d(bundleB, logger, "io.sentry.attach-screenshot", sentryAndroidOptions.isAttachScreenshot()));
                sentryAndroidOptions.setAttachViewHierarchy(d(bundleB, logger, "io.sentry.attach-view-hierarchy", sentryAndroidOptions.isAttachViewHierarchy()));
                sentryAndroidOptions.setSendClientReports(d(bundleB, logger, "io.sentry.send-client-reports", sentryAndroidOptions.isSendClientReports()));
                if (d(bundleB, logger, "io.sentry.auto-init", true)) {
                    sentryAndroidOptions.setInitPriority(io.sentry.t1.LOW);
                }
                sentryAndroidOptions.setForceInit(d(bundleB, logger, "io.sentry.force-init", sentryAndroidOptions.isForceInit()));
                sentryAndroidOptions.setCollectAdditionalContext(d(bundleB, logger, "io.sentry.additional-context", sentryAndroidOptions.isCollectAdditionalContext()));
                if (sentryAndroidOptions.getTracesSampleRate() == null) {
                    double dE2 = e(bundleB, logger, "io.sentry.traces.sample-rate");
                    if (dE2 != -1.0d) {
                        sentryAndroidOptions.setTracesSampleRate(Double.valueOf(dE2));
                    }
                }
                sentryAndroidOptions.setTraceSampling(d(bundleB, logger, "io.sentry.traces.trace-sampling", sentryAndroidOptions.isTraceSampling()));
                sentryAndroidOptions.setEnableAutoActivityLifecycleTracing(d(bundleB, logger, "io.sentry.traces.activity.enable", sentryAndroidOptions.isEnableAutoActivityLifecycleTracing()));
                sentryAndroidOptions.setEnableActivityLifecycleTracingAutoFinish(d(bundleB, logger, "io.sentry.traces.activity.auto-finish.enable", sentryAndroidOptions.isEnableActivityLifecycleTracingAutoFinish()));
                if (sentryAndroidOptions.getProfilesSampleRate() == null) {
                    double dE3 = e(bundleB, logger, "io.sentry.traces.profiling.sample-rate");
                    if (dE3 != -1.0d) {
                        sentryAndroidOptions.setProfilesSampleRate(Double.valueOf(dE3));
                    }
                }
                if (sentryAndroidOptions.getProfileSessionSampleRate() == null) {
                    double dE4 = e(bundleB, logger, "io.sentry.traces.profiling.session-sample-rate");
                    if (dE4 != -1.0d) {
                        sentryAndroidOptions.setProfileSessionSampleRate(Double.valueOf(dE4));
                    }
                }
                String strName2 = sentryAndroidOptions.getProfileLifecycle().name();
                Locale locale2 = Locale.ROOT;
                String strH3 = h(bundleB, logger, "io.sentry.traces.profiling.lifecycle", strName2.toLowerCase(locale2));
                if (strH3 != null) {
                    sentryAndroidOptions.setProfileLifecycle(v3.valueOf(strH3.toUpperCase(locale2)));
                }
                sentryAndroidOptions.setStartProfilerOnAppStart(d(bundleB, logger, "io.sentry.traces.profiling.start-on-app-start", sentryAndroidOptions.isStartProfilerOnAppStart()));
                sentryAndroidOptions.setEnableUserInteractionTracing(d(bundleB, logger, "io.sentry.traces.user-interaction.enable", sentryAndroidOptions.isEnableUserInteractionTracing()));
                sentryAndroidOptions.setEnableTimeToFullDisplayTracing(d(bundleB, logger, "io.sentry.traces.time-to-full-display.enable", sentryAndroidOptions.isEnableTimeToFullDisplayTracing()));
                long jG = g(bundleB, logger, "io.sentry.traces.idle-timeout", -1L);
                if (jG != -1) {
                    sentryAndroidOptions.setIdleTimeout(Long.valueOf(jG));
                }
                List<String> listF = f(bundleB, logger, "io.sentry.traces.trace-propagation-targets");
                if (bundleB.containsKey("io.sentry.traces.trace-propagation-targets") && listF == null) {
                    sentryAndroidOptions.setTracePropagationTargets(Collections.emptyList());
                } else if (listF != null) {
                    sentryAndroidOptions.setTracePropagationTargets(listF);
                }
                sentryAndroidOptions.setEnableFramesTracking(d(bundleB, logger, "io.sentry.traces.frames-tracking", true));
                sentryAndroidOptions.setProguardUuid(h(bundleB, logger, "io.sentry.proguard-uuid", sentryAndroidOptions.getProguardUuid()));
                SdkVersion sdkVersion = sentryAndroidOptions.getSdkVersion();
                if (sdkVersion == null) {
                    sdkVersion = new SdkVersion("", "");
                }
                sdkVersion.setName(i(bundleB, logger, "io.sentry.sdk.name", sdkVersion.getName()));
                sdkVersion.setVersion(i(bundleB, logger, "io.sentry.sdk.version", sdkVersion.getVersion()));
                sentryAndroidOptions.setSdkVersion(sdkVersion);
                sentryAndroidOptions.setSendDefaultPii(d(bundleB, logger, "io.sentry.send-default-pii", sentryAndroidOptions.isSendDefaultPii()));
                List<String> listF2 = f(bundleB, logger, "io.sentry.gradle-plugin-integrations");
                if (listF2 != null) {
                    Iterator<String> it = listF2.iterator();
                    while (it.hasNext()) {
                        a7.d().a(it.next());
                    }
                }
                sentryAndroidOptions.setEnableRootCheck(d(bundleB, logger, "io.sentry.enable-root-check", sentryAndroidOptions.isEnableRootCheck()));
                sentryAndroidOptions.setSendModules(d(bundleB, logger, "io.sentry.send-modules", sentryAndroidOptions.isSendModules()));
                sentryAndroidOptions.setEnablePerformanceV2(d(bundleB, logger, "io.sentry.performance-v2.enable", sentryAndroidOptions.isEnablePerformanceV2()));
                sentryAndroidOptions.setEnableAppStartProfiling(d(bundleB, logger, "io.sentry.profiling.enable-app-start", sentryAndroidOptions.isEnableAppStartProfiling()));
                sentryAndroidOptions.setEnableScopePersistence(d(bundleB, logger, "io.sentry.enable-scope-persistence", sentryAndroidOptions.isEnableScopePersistence()));
                sentryAndroidOptions.setEnableAutoTraceIdGeneration(d(bundleB, logger, "io.sentry.traces.enable-auto-id-generation", sentryAndroidOptions.isEnableAutoTraceIdGeneration()));
                if (sentryAndroidOptions.getSessionReplay().e() == null) {
                    double dE5 = e(bundleB, logger, "io.sentry.session-replay.session-sample-rate");
                    if (dE5 != -1.0d) {
                        sentryAndroidOptions.getSessionReplay().k(Double.valueOf(dE5));
                    }
                }
                if (sentryAndroidOptions.getSessionReplay().c() == null) {
                    double dE6 = e(bundleB, logger, "io.sentry.session-replay.on-error-sample-rate");
                    if (dE6 != -1.0d) {
                        sentryAndroidOptions.getSessionReplay().i(Double.valueOf(dE6));
                    }
                }
                sentryAndroidOptions.getSessionReplay().h(d(bundleB, logger, "io.sentry.session-replay.mask-all-text", true));
                sentryAndroidOptions.getSessionReplay().g(d(bundleB, logger, "io.sentry.session-replay.mask-all-images", true));
                sentryAndroidOptions.getSessionReplay().f(d(bundleB, logger, "io.sentry.session-replay.debug", false));
                sentryAndroidOptions.setIgnoredErrors(f(bundleB, logger, "io.sentry.ignored-errors"));
                List<String> listF3 = f(bundleB, logger, "io.sentry.in-app-includes");
                if (listF3 != null && !listF3.isEmpty()) {
                    Iterator<String> it2 = listF3.iterator();
                    while (it2.hasNext()) {
                        sentryAndroidOptions.addInAppInclude(it2.next());
                    }
                }
                List<String> listF4 = f(bundleB, logger, "io.sentry.in-app-excludes");
                if (listF4 != null && !listF4.isEmpty()) {
                    Iterator<String> it3 = listF4.iterator();
                    while (it3.hasNext()) {
                        sentryAndroidOptions.addInAppExclude(it3.next());
                    }
                }
                sentryAndroidOptions.getLogs().b(d(bundleB, logger, "io.sentry.logs.enabled", sentryAndroidOptions.getLogs().a()));
                u6 feedbackOptions = sentryAndroidOptions.getFeedbackOptions();
                feedbackOptions.h(d(bundleB, logger, "io.sentry.feedback.is-name-required", feedbackOptions.b()));
                feedbackOptions.k(d(bundleB, logger, "io.sentry.feedback.show-name", feedbackOptions.e()));
                feedbackOptions.g(d(bundleB, logger, "io.sentry.feedback.is-email-required", feedbackOptions.a()));
                feedbackOptions.j(d(bundleB, logger, "io.sentry.feedback.show-email", feedbackOptions.d()));
                feedbackOptions.l(d(bundleB, logger, "io.sentry.feedback.use-sentry-user", feedbackOptions.f()));
                feedbackOptions.i(d(bundleB, logger, "io.sentry.feedback.show-branding", feedbackOptions.c()));
            }
            sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "Retrieving configuration from AndroidManifest.xml", new Object[0]);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed to read configuration from android manifest metadata.", th);
        }
    }

    @Nullable
    private static Bundle b(@NotNull Context context, @NotNull io.sentry.w0 w0Var, @Nullable w0 w0Var2) {
        if (w0Var2 == null) {
            w0Var2 = new w0(w0Var);
        }
        ApplicationInfo applicationInfoI = e1.i(context, w0Var2);
        if (applicationInfoI != null) {
            return applicationInfoI.metaData;
        }
        return null;
    }

    static boolean c(@NotNull Context context, @NotNull io.sentry.w0 w0Var) {
        io.sentry.util.w.c(context, "The application context is required.");
        try {
            Bundle bundleB = b(context, w0Var, null);
            if (bundleB != null) {
                return d(bundleB, w0Var, "io.sentry.auto-init", true);
            }
            return true;
        } catch (Throwable th) {
            w0Var.b(SentryLevel.ERROR, "Failed to read auto-init from android manifest metadata.", th);
            return true;
        }
    }

    private static boolean d(@NotNull Bundle bundle, @NotNull io.sentry.w0 w0Var, @NotNull String str, boolean z10) {
        boolean z11 = bundle.getBoolean(str, z10);
        w0Var.c(SentryLevel.DEBUG, str + " read: " + z11, new Object[0]);
        return z11;
    }

    private static double e(@NotNull Bundle bundle, @NotNull io.sentry.w0 w0Var, @NotNull String str) {
        double dDoubleValue = Float.valueOf(bundle.getFloat(str, -1.0f)).doubleValue();
        if (dDoubleValue == -1.0d) {
            dDoubleValue = Integer.valueOf(bundle.getInt(str, -1)).doubleValue();
        }
        w0Var.c(SentryLevel.DEBUG, str + " read: " + dDoubleValue, new Object[0]);
        return dDoubleValue;
    }

    @Nullable
    private static List<String> f(@NotNull Bundle bundle, @NotNull io.sentry.w0 w0Var, @NotNull String str) {
        String string = bundle.getString(str);
        w0Var.c(SentryLevel.DEBUG, str + " read: " + string, new Object[0]);
        if (string != null) {
            return Arrays.asList(string.split(",", -1));
        }
        return null;
    }

    private static long g(@NotNull Bundle bundle, @NotNull io.sentry.w0 w0Var, @NotNull String str, long j10) {
        long j11 = bundle.getInt(str, (int) j10);
        w0Var.c(SentryLevel.DEBUG, str + " read: " + j11, new Object[0]);
        return j11;
    }

    @Nullable
    private static String h(@NotNull Bundle bundle, @NotNull io.sentry.w0 w0Var, @NotNull String str, @Nullable String str2) {
        String string = bundle.getString(str, str2);
        w0Var.c(SentryLevel.DEBUG, str + " read: " + string, new Object[0]);
        return string;
    }

    @NotNull
    private static String i(@NotNull Bundle bundle, @NotNull io.sentry.w0 w0Var, @NotNull String str, @NotNull String str2) {
        String string = bundle.getString(str, str2);
        w0Var.c(SentryLevel.DEBUG, str + " read: " + string, new Object[0]);
        return string;
    }
}
