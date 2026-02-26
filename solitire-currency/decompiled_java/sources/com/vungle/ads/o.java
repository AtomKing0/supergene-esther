package com.vungle.ads;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.ironsource.v8;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.c;
import com.vungle.ads.internal.util.p;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnalyticsClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    @NotNull
    public static final o INSTANCE = new o();

    @NotNull
    private static final String TAG;

    @NotNull
    private static final BlockingQueue<Sdk$SDKError.a> errors;

    @Nullable
    private static com.vungle.ads.internal.executor.i executor = null;

    @NotNull
    private static a logLevel = null;
    private static final int maxBatchSize = 20;

    @NotNull
    private static final BlockingQueue<Sdk$SDKMetric.a> metrics;
    private static boolean metricsEnabled = false;
    private static boolean paused = false;

    @NotNull
    private static final BlockingQueue<Sdk$SDKError.a> pendingErrors;

    @NotNull
    private static final BlockingQueue<Sdk$SDKMetric.a> pendingMetrics;
    private static boolean refreshEnabled = false;
    private static final long refreshTimeMillis = 5000;

    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static com.vungle.ads.internal.signals.b signalManager;

    @Nullable
    private static com.vungle.ads.internal.network.i vungleApiClient;

    /* JADX INFO: compiled from: AnalyticsClient.kt */
    public enum a {
        ERROR_LOG_LEVEL_OFF(0),
        ERROR_LOG_LEVEL_ERROR(1),
        ERROR_LOG_LEVEL_DEBUG(2);


        @NotNull
        public static final C0536a Companion = new C0536a(null);
        private final int level;

        /* JADX INFO: renamed from: com.vungle.ads.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AnalyticsClient.kt */
        public static final class C0536a {
            private C0536a() {
            }

            public /* synthetic */ C0536a(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final a fromValue(int i10) {
                a aVar = a.ERROR_LOG_LEVEL_DEBUG;
                if (i10 == aVar.getLevel()) {
                    return aVar;
                }
                a aVar2 = a.ERROR_LOG_LEVEL_ERROR;
                if (i10 == aVar2.getLevel()) {
                    return aVar2;
                }
                a aVar3 = a.ERROR_LOG_LEVEL_OFF;
                return i10 == aVar3.getLevel() ? aVar3 : aVar2;
            }
        }

        a(int i10) {
            this.level = i10;
        }

        public final int getLevel() {
            return this.level;
        }
    }

    /* JADX INFO: compiled from: AnalyticsClient.kt */
    public interface b {
        void onFailure();

        void onSuccess();
    }

    /* JADX INFO: compiled from: AnalyticsClient.kt */
    public static final class c implements b {
        final /* synthetic */ BlockingQueue<Sdk$SDKError.a> $currentSendingErrors;

        c(BlockingQueue<Sdk$SDKError.a> blockingQueue) {
            this.$currentSendingErrors = blockingQueue;
        }

        @Override // com.vungle.ads.o.b
        public void onFailure() {
            com.vungle.ads.internal.util.p.Companion.d(o.TAG, "Failed to send " + this.$currentSendingErrors.size() + " errors");
            o.INSTANCE.getErrors$vungle_ads_release().addAll(this.$currentSendingErrors);
        }

        @Override // com.vungle.ads.o.b
        public void onSuccess() {
            com.vungle.ads.internal.util.p.Companion.d(o.TAG, "Sent " + this.$currentSendingErrors.size() + " errors");
        }
    }

    /* JADX INFO: compiled from: AnalyticsClient.kt */
    public static final class d implements b {
        final /* synthetic */ BlockingQueue<Sdk$SDKMetric.a> $currentSendingMetrics;

        d(BlockingQueue<Sdk$SDKMetric.a> blockingQueue) {
            this.$currentSendingMetrics = blockingQueue;
        }

        @Override // com.vungle.ads.o.b
        public void onFailure() {
            com.vungle.ads.internal.util.p.Companion.d(o.TAG, "Failed to send " + this.$currentSendingMetrics.size() + " metrics");
            o.INSTANCE.getMetrics$vungle_ads_release().addAll(this.$currentSendingMetrics);
        }

        @Override // com.vungle.ads.o.b
        public void onSuccess() {
            com.vungle.ads.internal.util.p.Companion.d(o.TAG, "Sent " + this.$currentSendingMetrics.size() + " metrics");
        }
    }

    /* JADX INFO: compiled from: AnalyticsClient.kt */
    public static final class e extends c.C0535c {
        e() {
        }

        @Override // com.vungle.ads.internal.util.c.C0535c
        public void onPause() {
            super.onPause();
            o.INSTANCE.pause();
        }

        @Override // com.vungle.ads.internal.util.c.C0535c
        public void onResume() {
            super.onResume();
            o.INSTANCE.resume();
        }
    }

    static {
        String simpleName = o.class.getSimpleName();
        kotlin.jvm.internal.t.h(simpleName, "AnalyticsClient::class.java.simpleName");
        TAG = simpleName;
        errors = new LinkedBlockingQueue();
        metrics = new LinkedBlockingQueue();
        pendingErrors = new LinkedBlockingQueue();
        pendingMetrics = new LinkedBlockingQueue();
        logLevel = a.ERROR_LOG_LEVEL_ERROR;
        refreshEnabled = true;
    }

    private o() {
    }

    @WorkerThread
    private final void flushErrors() {
        com.vungle.ads.internal.network.i iVar;
        p.a aVar = com.vungle.ads.internal.util.p.Companion;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Sending ");
        BlockingQueue<Sdk$SDKError.a> blockingQueue = errors;
        sb.append(blockingQueue.size());
        sb.append(" errors");
        aVar.d(str, sb.toString());
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        blockingQueue.drainTo(linkedBlockingQueue);
        if (linkedBlockingQueue.isEmpty() || (iVar = vungleApiClient) == null) {
            return;
        }
        iVar.reportErrors(linkedBlockingQueue, new c(linkedBlockingQueue));
    }

    @WorkerThread
    private final void flushMetrics() {
        com.vungle.ads.internal.network.i iVar;
        p.a aVar = com.vungle.ads.internal.util.p.Companion;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Sending ");
        BlockingQueue<Sdk$SDKMetric.a> blockingQueue = metrics;
        sb.append(blockingQueue.size());
        sb.append(" metrics");
        aVar.d(str, sb.toString());
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        blockingQueue.drainTo(linkedBlockingQueue);
        if (linkedBlockingQueue.isEmpty() || (iVar = vungleApiClient) == null) {
            return;
        }
        iVar.reportMetrics(linkedBlockingQueue, new d(linkedBlockingQueue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Sdk$SDKMetric.a genMetric(Sdk$SDKMetric.b bVar, long j10, String str, String str2, String str3, String str4) {
        String uuid;
        Sdk$SDKMetric.a osVersion = Sdk$SDKMetric.newBuilder().setType(bVar).setValue(j10).setMake(Build.MANUFACTURER).setModel(Build.MODEL).setOs(v8.f15653d).setOsVersion(String.valueOf(Build.VERSION.SDK_INT));
        String str5 = "";
        if (str == null) {
            str = "";
        }
        Sdk$SDKMetric.a placementReferenceId = osVersion.setPlacementReferenceId(str);
        if (str2 == null) {
            str2 = "";
        }
        Sdk$SDKMetric.a creativeId = placementReferenceId.setCreativeId(str2);
        if (str3 == null) {
            str3 = "";
        }
        Sdk$SDKMetric.a eventId = creativeId.setEventId(str3);
        if (str4 == null) {
            str4 = "";
        }
        Sdk$SDKMetric.a meta = eventId.setMeta(str4);
        com.vungle.ads.internal.signals.b bVar2 = signalManager;
        if (bVar2 != null && (uuid = bVar2.getUuid()) != null) {
            str5 = uuid;
        }
        Sdk$SDKMetric.a sessionId = meta.setSessionId(str5);
        kotlin.jvm.internal.t.h(sessionId, "newBuilder()\n           …ignalManager?.uuid ?: \"\")");
        return sessionId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Sdk$SDKError.a genSDKError(Sdk$SDKError.b bVar, String str, String str2, String str3, String str4) {
        String uuid;
        Sdk$SDKError.a at = Sdk$SDKError.newBuilder().setOs(v8.f15653d).setOsVersion(String.valueOf(Build.VERSION.SDK_INT)).setMake(Build.MANUFACTURER).setModel(Build.MODEL).setReason(bVar).setMessage(str).setAt(System.currentTimeMillis());
        String str5 = "";
        if (str2 == null) {
            str2 = "";
        }
        Sdk$SDKError.a placementReferenceId = at.setPlacementReferenceId(str2);
        if (str3 == null) {
            str3 = "";
        }
        Sdk$SDKError.a creativeId = placementReferenceId.setCreativeId(str3);
        if (str4 == null) {
            str4 = "";
        }
        Sdk$SDKError.a eventId = creativeId.setEventId(str4);
        com.vungle.ads.internal.signals.b bVar2 = signalManager;
        if (bVar2 != null && (uuid = bVar2.getUuid()) != null) {
            str5 = uuid;
        }
        Sdk$SDKError.a sessionId = eventId.setSessionId(str5);
        kotlin.jvm.internal.t.h(sessionId, "newBuilder()\n           …ignalManager?.uuid ?: \"\")");
        return sessionId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: init$lambda-1, reason: not valid java name */
    public static final void m4126init$lambda1(com.vungle.ads.internal.executor.i executor2) {
        kotlin.jvm.internal.t.i(executor2, "$executor");
        executor2.execute(new Runnable() { // from class: com.vungle.ads.k
            @Override // java.lang.Runnable
            public final void run() {
                o.m4127init$lambda1$lambda0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: init$lambda-1$lambda-0, reason: not valid java name */
    public static final void m4127init$lambda1$lambda0() {
        INSTANCE.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: logError$lambda-2, reason: not valid java name */
    public static final void m4128logError$lambda2(Sdk$SDKError.b reason, String message, String str, String str2, String str3) {
        kotlin.jvm.internal.t.i(reason, "$reason");
        kotlin.jvm.internal.t.i(message, "$message");
        INSTANCE.logErrorInSameThread(reason, message, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void logErrorInSameThread(Sdk$SDKError.b bVar, String str, String str2, String str3, String str4) {
        if (logLevel == a.ERROR_LOG_LEVEL_OFF) {
            return;
        }
        try {
            Sdk$SDKError.a aVarGenSDKError = genSDKError(bVar, str, str2, str3, str4);
            BlockingQueue<Sdk$SDKError.a> blockingQueue = errors;
            blockingQueue.put(aVarGenSDKError);
            com.vungle.ads.internal.util.p.Companion.w(TAG, "Logging error: " + bVar + " with message: " + str);
            if (blockingQueue.size() >= 20) {
                report();
            }
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Cannot logError", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: logMetric$lambda-3, reason: not valid java name */
    public static final void m4129logMetric$lambda3(Sdk$SDKMetric.b metricType, long j10, String str, String str2, String str3, String str4) {
        kotlin.jvm.internal.t.i(metricType, "$metricType");
        INSTANCE.logMetricInSameThread(metricType, j10, str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void logMetricInSameThread(Sdk$SDKMetric.b bVar, long j10, String str, String str2, String str3, String str4) {
        if (metricsEnabled) {
            try {
                Sdk$SDKMetric.a aVarGenMetric = genMetric(bVar, j10, str, str2, str3, str4);
                BlockingQueue<Sdk$SDKMetric.a> blockingQueue = metrics;
                blockingQueue.put(aVarGenMetric);
                com.vungle.ads.internal.util.p.Companion.d(TAG, "Logging Metric " + bVar + " with value " + j10 + " for placement " + str);
                if (blockingQueue.size() >= 20) {
                    report();
                }
            } catch (Exception e10) {
                com.vungle.ads.internal.util.p.Companion.e(TAG, "Cannot logMetrics", e10);
            }
        }
    }

    private final synchronized void report() {
        if (paused) {
            return;
        }
        if (logLevel != a.ERROR_LOG_LEVEL_OFF && errors.size() > 0) {
            flushErrors();
        }
        if (metricsEnabled && metrics.size() > 0) {
            flushMetrics();
        }
    }

    @NotNull
    public final BlockingQueue<Sdk$SDKError.a> getErrors$vungle_ads_release() {
        return errors;
    }

    @Nullable
    public final com.vungle.ads.internal.executor.i getExecutor$vungle_ads_release() {
        return executor;
    }

    @NotNull
    public final BlockingQueue<Sdk$SDKMetric.a> getMetrics$vungle_ads_release() {
        return metrics;
    }

    public final boolean getMetricsEnabled$vungle_ads_release() {
        return metricsEnabled;
    }

    @NotNull
    public final BlockingQueue<Sdk$SDKError.a> getPendingErrors$vungle_ads_release() {
        return pendingErrors;
    }

    @NotNull
    public final BlockingQueue<Sdk$SDKMetric.a> getPendingMetrics$vungle_ads_release() {
        return pendingMetrics;
    }

    public final boolean getRefreshEnabled$vungle_ads_release() {
        return refreshEnabled;
    }

    @Nullable
    public final com.vungle.ads.internal.signals.b getSignalManager$vungle_ads_release() {
        return signalManager;
    }

    @Nullable
    public final com.vungle.ads.internal.network.i getVungleApiClient$vungle_ads_release() {
        return vungleApiClient;
    }

    public final void init$vungle_ads_release(@NotNull com.vungle.ads.internal.network.i vungleApiClient2, @NotNull final com.vungle.ads.internal.executor.i executor2, int i10, boolean z10, @NotNull com.vungle.ads.internal.signals.b signalManager2) {
        kotlin.jvm.internal.t.i(vungleApiClient2, "vungleApiClient");
        kotlin.jvm.internal.t.i(executor2, "executor");
        kotlin.jvm.internal.t.i(signalManager2, "signalManager");
        signalManager = signalManager2;
        executor = executor2;
        vungleApiClient = vungleApiClient2;
        try {
            BlockingQueue<Sdk$SDKError.a> blockingQueue = pendingErrors;
            if (!blockingQueue.isEmpty()) {
                blockingQueue.drainTo(errors);
            }
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Failed to add pendingErrors to errors queue.", e10);
        }
        try {
            BlockingQueue<Sdk$SDKMetric.a> blockingQueue2 = pendingMetrics;
            if (!blockingQueue2.isEmpty()) {
                blockingQueue2.drainTo(metrics);
            }
        } catch (Exception e11) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Failed to add pendingMetrics to metrics queue.", e11);
        }
        if (refreshEnabled) {
            Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new Runnable() { // from class: com.vungle.ads.l
                @Override // java.lang.Runnable
                public final void run() {
                    o.m4126init$lambda1(executor2);
                }
            }, 0L, 5000L, TimeUnit.MILLISECONDS);
        }
        updateErrorLevelAndMetricEnabled$vungle_ads_release(i10, z10);
        if (i10 == a.ERROR_LOG_LEVEL_DEBUG.getLevel()) {
            com.vungle.ads.internal.util.p.Companion.enable(true);
        } else if (i10 == a.ERROR_LOG_LEVEL_ERROR.getLevel() || i10 == a.ERROR_LOG_LEVEL_OFF.getLevel()) {
            com.vungle.ads.internal.util.p.Companion.enable(false);
        }
        com.vungle.ads.internal.util.c.Companion.addLifecycleListener(new e());
    }

    public final synchronized void logError$vungle_ads_release(@NotNull final Sdk$SDKError.b reason, @NotNull final String message, @Nullable final String str, @Nullable final String str2, @Nullable final String str3) {
        com.vungle.ads.internal.executor.i iVar;
        kotlin.jvm.internal.t.i(reason, "reason");
        kotlin.jvm.internal.t.i(message, "message");
        try {
            iVar = executor;
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Cannot logError " + reason + ", " + message + ", " + str + ", " + str2 + ',' + str3, e10);
        }
        if (iVar == null) {
            pendingErrors.put(genSDKError(reason, message, str, str2, str3));
        } else {
            if (iVar != null) {
                iVar.execute(new Runnable() { // from class: com.vungle.ads.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.m4128logError$lambda2(reason, message, str, str2, str3);
                    }
                });
            }
        }
    }

    public final synchronized void logMetric$vungle_ads_release(@NotNull final Sdk$SDKMetric.b metricType, final long j10, @Nullable final String str, @Nullable final String str2, @Nullable final String str3, @Nullable final String str4) {
        com.vungle.ads.internal.executor.i iVar;
        kotlin.jvm.internal.t.i(metricType, "metricType");
        try {
            iVar = executor;
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Cannot logMetric " + metricType + ", " + j10 + ", " + str + ", " + str2 + ',' + str3 + ", " + str4, e10);
        }
        if (iVar == null) {
            pendingMetrics.put(genMetric(metricType, j10, str, str2, str3, str4));
        } else {
            if (iVar != null) {
                iVar.execute(new Runnable() { // from class: com.vungle.ads.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.m4129logMetric$lambda3(metricType, j10, str, str2, str3, str4);
                    }
                });
            }
        }
    }

    public final void pause() {
        paused = true;
    }

    public final void resume() {
        paused = false;
    }

    public final void setExecutor$vungle_ads_release(@Nullable com.vungle.ads.internal.executor.i iVar) {
        executor = iVar;
    }

    public final void setMetricsEnabled$vungle_ads_release(boolean z10) {
        metricsEnabled = z10;
    }

    public final void setRefreshEnabled$vungle_ads_release(boolean z10) {
        refreshEnabled = z10;
    }

    public final void setSignalManager$vungle_ads_release(@Nullable com.vungle.ads.internal.signals.b bVar) {
        signalManager = bVar;
    }

    public final void setVungleApiClient$vungle_ads_release(@Nullable com.vungle.ads.internal.network.i iVar) {
        vungleApiClient = iVar;
    }

    public final synchronized void updateErrorLevelAndMetricEnabled$vungle_ads_release(int i10, boolean z10) {
        logLevel = a.Companion.fromValue(i10);
        metricsEnabled = z10;
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(o oVar, w1 w1Var, String str, String str2, String str3, String str4, int i10, Object obj) {
        String str5 = (i10 & 2) != 0 ? null : str;
        String str6 = (i10 & 4) != 0 ? null : str2;
        String str7 = (i10 & 8) != 0 ? null : str3;
        if ((i10 & 16) != 0) {
            str4 = w1Var.getMeta();
        }
        oVar.logMetric$vungle_ads_release(w1Var, str5, str6, str7, str4);
    }

    public final synchronized void logError$vungle_ads_release(int i10, @NotNull String message, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        kotlin.jvm.internal.t.i(message, "message");
        Sdk$SDKError.b bVarForNumber = Sdk$SDKError.b.forNumber(i10);
        kotlin.jvm.internal.t.h(bVarForNumber, "forNumber(reasonCode)");
        logError$vungle_ads_release(bVarForNumber, message, str, str2, str3);
    }

    public final synchronized void logMetric$vungle_ads_release(@NotNull t0 metric, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        kotlin.jvm.internal.t.i(metric, "metric");
        Sdk$SDKMetric.b metricType = metric.getMetricType();
        long value = metric.getValue();
        if (str4 == null) {
            str4 = metric.getMeta();
        }
        logMetric$vungle_ads_release(metricType, value, str, str2, str3, str4);
    }

    public final synchronized void logMetric$vungle_ads_release(@NotNull v1 singleValueMetric, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        kotlin.jvm.internal.t.i(singleValueMetric, "singleValueMetric");
        logMetric$vungle_ads_release((t0) singleValueMetric, str, str2, str3, str4);
    }

    @VisibleForTesting
    public static /* synthetic */ void getErrors$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getExecutor$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMetrics$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMetricsEnabled$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getPendingErrors$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getPendingMetrics$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshEnabled$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getSignalManager$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getVungleApiClient$vungle_ads_release$annotations() {
    }

    public final synchronized void logMetric$vungle_ads_release(@NotNull w1 timeIntervalMetric, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        kotlin.jvm.internal.t.i(timeIntervalMetric, "timeIntervalMetric");
        logMetric$vungle_ads_release((t0) timeIntervalMetric, str, str2, str3, str4);
    }

    public final synchronized void logMetric$vungle_ads_release(@NotNull l1 oneShotTimeIntervalMetric, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        kotlin.jvm.internal.t.i(oneShotTimeIntervalMetric, "oneShotTimeIntervalMetric");
        if (!oneShotTimeIntervalMetric.isLogged()) {
            logMetric$vungle_ads_release((w1) oneShotTimeIntervalMetric, str, str2, str3, str4);
            oneShotTimeIntervalMetric.markLogged();
        }
    }
}
