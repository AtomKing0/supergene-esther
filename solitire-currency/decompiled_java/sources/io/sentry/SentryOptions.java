package io.sentry;

import androidx.media3.common.C;
import androidx.media3.exoplayer.ExoPlayer;
import io.sentry.protocol.SdkVersion;
import io.sentry.util.r;
import java.io.File;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.net.ssl.SSLSocketFactory;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
public class SentryOptions {
    static final SentryLevel DEFAULT_DIAGNOSTIC_LEVEL = SentryLevel.DEBUG;
    private static final String DEFAULT_ENVIRONMENT = "production";

    @ApiStatus.Internal
    @NotNull
    public static final String DEFAULT_PROPAGATION_TARGETS = ".*";
    private boolean attachServerName;
    private boolean attachStacktrace;
    private boolean attachThreads;

    @ApiStatus.Experimental
    @NotNull
    private io.sentry.backpressure.b backpressureMonitor;

    @Nullable
    private a beforeBreadcrumb;

    @Nullable
    private b beforeEnvelopeCallback;

    @Nullable
    private c beforeSend;

    @Nullable
    private c beforeSendFeedback;

    @Nullable
    private d beforeSendReplay;

    @Nullable
    private e beforeSendTransaction;

    @NotNull
    private final Set<String> bundleIds;

    @Nullable
    private String cacheDirPath;

    @ApiStatus.Experimental
    private boolean captureOpenTelemetryEvents;

    @NotNull
    io.sentry.clientreport.h clientReportRecorder;

    @NotNull
    private io.sentry.j compositePerformanceCollector;

    @NotNull
    private r0 connectionStatusProvider;
    private int connectionTimeoutMillis;

    @NotNull
    private final List<String> contextTags;

    @NotNull
    private s0 continuousProfiler;

    @ApiStatus.Experimental
    @Nullable
    private f cron;

    @ApiStatus.Internal
    @NotNull
    private final io.sentry.util.r<o5> dateProvider;
    private boolean debug;

    @NotNull
    private io.sentry.internal.debugmeta.a debugMetaLoader;

    @NotNull
    private h4 defaultScopeType;

    @NotNull
    private final List<String> defaultTracePropagationTargets;

    @NotNull
    private SentryLevel diagnosticLevel;

    @Nullable
    private String dist;

    @Nullable
    private String distinctId;

    @Nullable
    private String dsn;

    @Nullable
    private String dsnHash;
    private boolean enableAppStartProfiling;
    private boolean enableAutoSessionTracking;
    private boolean enableBackpressureHandling;
    private boolean enableDeduplication;
    private boolean enableExternalConfiguration;
    private boolean enablePrettySerializationOutput;
    private boolean enableScopePersistence;

    @ApiStatus.Experimental
    private boolean enableScreenTracking;
    private boolean enableShutdownHook;
    private boolean enableSpotlight;
    private boolean enableTimeToFullDisplayTracing;
    private boolean enableUncaughtExceptionHandler;
    private boolean enableUserInteractionBreadcrumbs;
    private boolean enableUserInteractionTracing;
    private boolean enabled;

    @NotNull
    private io.sentry.cache.g envelopeDiskCache;

    @NotNull
    private final io.sentry.util.r<t0> envelopeReader;

    @Nullable
    private String environment;

    @NotNull
    private final List<g0> eventProcessors;

    @NotNull
    private j1 executorService;

    @NotNull
    private final h0 experimental;

    @ApiStatus.Experimental
    @NotNull
    private w0 fatalLogger;

    @NotNull
    private u6 feedbackOptions;
    private long flushTimeoutMillis;
    private boolean forceInit;

    @NotNull
    private k0 fullyDisplayedReporter;

    @NotNull
    private final List<io.sentry.internal.gestures.a> gestureTargetLocators;

    @Nullable
    private Boolean globalHubMode;

    @Nullable
    private Long idleTimeout;

    @ApiStatus.Experimental
    @Nullable
    private List<j0> ignoredCheckIns;

    @Nullable
    private List<j0> ignoredErrors;

    @NotNull
    private final Set<Class<? extends Throwable>> ignoredExceptionsForType;

    @ApiStatus.Experimental
    @Nullable
    private List<j0> ignoredSpanOrigins;

    @Nullable
    private List<j0> ignoredTransactions;

    @NotNull
    private final List<String> inAppExcludes;

    @NotNull
    private final List<String> inAppIncludes;

    @NotNull
    private t1 initPriority;

    @NotNull
    private u1 instrumenter;

    @NotNull
    private final List<v1> integrations;

    @Nullable
    private volatile w8 internalTracesSampler;

    @NotNull
    protected final io.sentry.util.a lock;

    @NotNull
    private w0 logger;

    @NotNull
    private g logs;
    private long maxAttachmentSize;
    private int maxBreadcrumbs;
    private int maxCacheItems;
    private int maxDepth;
    private int maxQueueSize;

    @NotNull
    private j maxRequestBodySize;
    private int maxSpans;
    private long maxTraceFileSize;

    @NotNull
    private io.sentry.internal.modules.b modulesLoader;

    @NotNull
    private final List<d1> observers;

    @NotNull
    private k7 openTelemetryMode;

    @NotNull
    private final List<x0> optionsObservers;

    @NotNull
    private final io.sentry.util.r<y> parsedDsn;

    @NotNull
    private final List<y0> performanceCollectors;
    private boolean printUncaughtStackTrace;

    @NotNull
    private v3 profileLifecycle;

    @Nullable
    private Double profileSessionSampleRate;

    @Nullable
    private Double profilesSampleRate;

    @Nullable
    private h profilesSampler;
    private int profilingTracesHz;

    @Nullable
    private String proguardUuid;

    @Nullable
    private i proxy;
    private int readTimeoutMillis;

    @Nullable
    private String release;

    @NotNull
    private a4 replayController;

    @Nullable
    private Double sampleRate;

    @Nullable
    private SdkVersion sdkVersion;
    private boolean sendClientReports;
    private boolean sendDefaultPii;
    private boolean sendModules;

    @Nullable
    private String sentryClientName;

    @NotNull
    private final io.sentry.util.r<l1> serializer;

    @Nullable
    private String serverName;
    private long sessionFlushTimeoutMillis;

    @NotNull
    private q7 sessionReplay;
    private long sessionTrackingIntervalMillis;
    private long shutdownTimeoutMillis;

    @NotNull
    private m1 socketTagger;

    @NotNull
    private o1 spanFactory;

    @Nullable
    private String spotlightConnectionUrl;

    @Nullable
    private SSLSocketFactory sslSocketFactory;
    private boolean startProfilerOnAppStart;

    @NotNull
    private final Map<String, String> tags;

    @NotNull
    private io.sentry.util.thread.a threadChecker;
    private boolean traceOptionsRequests;

    @Nullable
    private List<String> tracePropagationTargets;
    private boolean traceSampling;

    @Nullable
    private Double tracesSampleRate;

    @Nullable
    private k tracesSampler;

    @NotNull
    private q1 transactionProfiler;

    @NotNull
    private r1 transportFactory;

    @NotNull
    private io.sentry.transport.s transportGate;

    @NotNull
    private s1 versionDetector;

    @NotNull
    private final List<io.sentry.internal.viewhierarchy.a> viewHierarchyExporters;

    public interface a {
        @Nullable
        Breadcrumb a(@NotNull Breadcrumb breadcrumb, @NotNull l0 l0Var);
    }

    @ApiStatus.Internal
    public interface b {
        void a(@NotNull p5 p5Var, @Nullable l0 l0Var);
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private Long f26951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private Long f26952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private String f26953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private Long f26954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private Long f26955e;

        @Nullable
        public Long a() {
            return this.f26951a;
        }

        @Nullable
        public Long b() {
            return this.f26954d;
        }

        @Nullable
        public Long c() {
            return this.f26952b;
        }

        @Nullable
        public Long d() {
            return this.f26955e;
        }

        @Nullable
        public String e() {
            return this.f26953c;
        }

        public void f(@Nullable Long l10) {
            this.f26951a = l10;
        }

        public void g(@Nullable Long l10) {
            this.f26954d = l10;
        }

        public void h(@Nullable Long l10) {
            this.f26952b = l10;
        }

        public void i(@Nullable Long l10) {
            this.f26955e = l10;
        }

        public void j(@Nullable String str) {
            this.f26953c = str;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ApiStatus.Experimental
        private boolean f26956a = false;

        @ApiStatus.Experimental
        public boolean a() {
            return this.f26956a;
        }

        @ApiStatus.Experimental
        public void b(boolean z10) {
            this.f26956a = z10;
        }
    }

    public interface h {
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private String f26957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private String f26958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private String f26959c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private String f26960d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private Proxy.Type f26961e;

        public i(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this(str, str2, null, str3, str4);
        }

        @Nullable
        public String a() {
            return this.f26957a;
        }

        @Nullable
        public String b() {
            return this.f26960d;
        }

        @Nullable
        public String c() {
            return this.f26958b;
        }

        @Nullable
        public Proxy.Type d() {
            return this.f26961e;
        }

        @Nullable
        public String e() {
            return this.f26959c;
        }

        public i(@Nullable String str, @Nullable String str2, @Nullable Proxy.Type type, @Nullable String str3, @Nullable String str4) {
            this.f26957a = str;
            this.f26958b = str2;
            this.f26961e = type;
            this.f26959c = str3;
            this.f26960d = str4;
        }
    }

    public enum j {
        NONE,
        SMALL,
        MEDIUM,
        ALWAYS
    }

    public interface k {
    }

    public SentryOptions() {
        this(false);
    }

    private void addPackageInfo() {
        a7.d().b("maven:io.sentry:sentry", "8.14.0");
    }

    @NotNull
    private SdkVersion createSdkVersion() {
        SdkVersion sdkVersion = new SdkVersion("sentry.java", "8.14.0");
        sdkVersion.setVersion("8.14.0");
        return sdkVersion;
    }

    @ApiStatus.Internal
    @NotNull
    public static SentryOptions empty() {
        return new SentryOptions(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ y lambda$new$0() {
        return new y(this.dsn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ l1 lambda$new$1() {
        return new i2(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ t0 lambda$new$2() {
        return new a0(this.serializer.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o5 lambda$new$3() {
        return new h5();
    }

    public void addBundleId(@Nullable String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.bundleIds.add(strTrim);
        }
    }

    public void addContextTag(@NotNull String str) {
        this.contextTags.add(str);
    }

    public void addEventProcessor(@NotNull g0 g0Var) {
        this.eventProcessors.add(g0Var);
    }

    @ApiStatus.Experimental
    public void addIgnoredCheckIn(String str) {
        if (this.ignoredCheckIns == null) {
            this.ignoredCheckIns = new ArrayList();
        }
        this.ignoredCheckIns.add(new j0(str));
    }

    public void addIgnoredError(@NotNull String str) {
        if (this.ignoredErrors == null) {
            this.ignoredErrors = new ArrayList();
        }
        this.ignoredErrors.add(new j0(str));
    }

    public void addIgnoredExceptionForType(@NotNull Class<? extends Throwable> cls) {
        this.ignoredExceptionsForType.add(cls);
    }

    @ApiStatus.Experimental
    public void addIgnoredSpanOrigin(String str) {
        if (this.ignoredSpanOrigins == null) {
            this.ignoredSpanOrigins = new ArrayList();
        }
        this.ignoredSpanOrigins.add(new j0(str));
    }

    @ApiStatus.Experimental
    public void addIgnoredTransaction(String str) {
        if (this.ignoredTransactions == null) {
            this.ignoredTransactions = new ArrayList();
        }
        this.ignoredTransactions.add(new j0(str));
    }

    public void addInAppExclude(@NotNull String str) {
        this.inAppExcludes.add(str);
    }

    public void addInAppInclude(@NotNull String str) {
        this.inAppIncludes.add(str);
    }

    public void addIntegration(@NotNull v1 v1Var) {
        this.integrations.add(v1Var);
    }

    public void addOptionsObserver(@NotNull x0 x0Var) {
        this.optionsObservers.add(x0Var);
    }

    @ApiStatus.Internal
    public void addPerformanceCollector(@NotNull y0 y0Var) {
        this.performanceCollectors.add(y0Var);
    }

    public void addScopeObserver(@NotNull d1 d1Var) {
        this.observers.add(d1Var);
    }

    boolean containsIgnoredExceptionForType(@NotNull Throwable th) {
        return this.ignoredExceptionsForType.contains(th.getClass());
    }

    @ApiStatus.Internal
    @Nullable
    public io.sentry.cache.w findPersistingScopeObserver() {
        for (d1 d1Var : this.observers) {
            if (d1Var instanceof io.sentry.cache.w) {
                return (io.sentry.cache.w) d1Var;
            }
        }
        return null;
    }

    @ApiStatus.Internal
    @NotNull
    public io.sentry.backpressure.b getBackpressureMonitor() {
        return this.backpressureMonitor;
    }

    @Nullable
    public a getBeforeBreadcrumb() {
        return null;
    }

    @ApiStatus.Internal
    @Nullable
    public b getBeforeEnvelopeCallback() {
        return this.beforeEnvelopeCallback;
    }

    @Nullable
    public c getBeforeSend() {
        return null;
    }

    @Nullable
    public c getBeforeSendFeedback() {
        return null;
    }

    @Nullable
    public d getBeforeSendReplay() {
        return null;
    }

    @Nullable
    public e getBeforeSendTransaction() {
        return null;
    }

    @NotNull
    public Set<String> getBundleIds() {
        return this.bundleIds;
    }

    @Nullable
    public String getCacheDirPath() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.dsnHash != null ? new File(this.cacheDirPath, this.dsnHash).getAbsolutePath() : this.cacheDirPath;
    }

    @Nullable
    String getCacheDirPathWithoutDsn() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.cacheDirPath;
    }

    @ApiStatus.Internal
    @NotNull
    public io.sentry.clientreport.h getClientReportRecorder() {
        return this.clientReportRecorder;
    }

    @ApiStatus.Internal
    @NotNull
    public io.sentry.j getCompositePerformanceCollector() {
        return this.compositePerformanceCollector;
    }

    @NotNull
    public r0 getConnectionStatusProvider() {
        return this.connectionStatusProvider;
    }

    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    @NotNull
    public List<String> getContextTags() {
        return this.contextTags;
    }

    @NotNull
    public s0 getContinuousProfiler() {
        return this.continuousProfiler;
    }

    @Nullable
    public f getCron() {
        return this.cron;
    }

    @ApiStatus.Internal
    @NotNull
    public o5 getDateProvider() {
        return this.dateProvider.a();
    }

    @ApiStatus.Internal
    @NotNull
    public io.sentry.internal.debugmeta.a getDebugMetaLoader() {
        return this.debugMetaLoader;
    }

    @NotNull
    public h4 getDefaultScopeType() {
        return this.defaultScopeType;
    }

    @NotNull
    public SentryLevel getDiagnosticLevel() {
        return this.diagnosticLevel;
    }

    @Nullable
    public String getDist() {
        return this.dist;
    }

    @ApiStatus.Internal
    @Nullable
    public String getDistinctId() {
        return this.distinctId;
    }

    @Nullable
    public String getDsn() {
        return this.dsn;
    }

    @NotNull
    public io.sentry.cache.g getEnvelopeDiskCache() {
        return this.envelopeDiskCache;
    }

    @NotNull
    public t0 getEnvelopeReader() {
        return this.envelopeReader.a();
    }

    @Nullable
    public String getEnvironment() {
        String str = this.environment;
        return str != null ? str : DEFAULT_ENVIRONMENT;
    }

    @NotNull
    public List<g0> getEventProcessors() {
        return this.eventProcessors;
    }

    @ApiStatus.Internal
    @NotNull
    public j1 getExecutorService() {
        return this.executorService;
    }

    @NotNull
    public h0 getExperimental() {
        return this.experimental;
    }

    @ApiStatus.Experimental
    @NotNull
    public w0 getFatalLogger() {
        return this.fatalLogger;
    }

    @NotNull
    public u6 getFeedbackOptions() {
        return this.feedbackOptions;
    }

    public long getFlushTimeoutMillis() {
        return this.flushTimeoutMillis;
    }

    @ApiStatus.Internal
    @NotNull
    public k0 getFullyDisplayedReporter() {
        return this.fullyDisplayedReporter;
    }

    public List<io.sentry.internal.gestures.a> getGestureTargetLocators() {
        return this.gestureTargetLocators;
    }

    @Nullable
    public Long getIdleTimeout() {
        return this.idleTimeout;
    }

    @ApiStatus.Experimental
    @Nullable
    public List<j0> getIgnoredCheckIns() {
        return this.ignoredCheckIns;
    }

    @Nullable
    public List<j0> getIgnoredErrors() {
        return this.ignoredErrors;
    }

    @NotNull
    public Set<Class<? extends Throwable>> getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }

    @ApiStatus.Experimental
    @Nullable
    public List<j0> getIgnoredSpanOrigins() {
        return this.ignoredSpanOrigins;
    }

    @Nullable
    public List<j0> getIgnoredTransactions() {
        return this.ignoredTransactions;
    }

    @NotNull
    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }

    @NotNull
    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }

    @ApiStatus.Internal
    @NotNull
    public t1 getInitPriority() {
        return this.initPriority;
    }

    @NotNull
    public u1 getInstrumenter() {
        return this.instrumenter;
    }

    @NotNull
    public List<v1> getIntegrations() {
        return this.integrations;
    }

    @ApiStatus.Internal
    @NotNull
    public w8 getInternalTracesSampler() {
        if (this.internalTracesSampler == null) {
            k1 k1VarA = this.lock.a();
            try {
                if (this.internalTracesSampler == null) {
                    this.internalTracesSampler = new w8(this);
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
        return this.internalTracesSampler;
    }

    @NotNull
    public w0 getLogger() {
        return this.logger;
    }

    @ApiStatus.Experimental
    @NotNull
    public g getLogs() {
        return this.logs;
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public int getMaxCacheItems() {
        return this.maxCacheItems;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    @NotNull
    public j getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    @ApiStatus.Experimental
    public int getMaxSpans() {
        return this.maxSpans;
    }

    public long getMaxTraceFileSize() {
        return this.maxTraceFileSize;
    }

    @ApiStatus.Internal
    @NotNull
    public io.sentry.internal.modules.b getModulesLoader() {
        return this.modulesLoader;
    }

    @NotNull
    public k7 getOpenTelemetryMode() {
        return this.openTelemetryMode;
    }

    @NotNull
    public List<x0> getOptionsObservers() {
        return this.optionsObservers;
    }

    @Nullable
    public String getOutboxPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "outbox").getAbsolutePath();
    }

    @ApiStatus.Internal
    @NotNull
    public List<y0> getPerformanceCollectors() {
        return this.performanceCollectors;
    }

    @NotNull
    public v3 getProfileLifecycle() {
        return this.profileLifecycle;
    }

    @Nullable
    public Double getProfileSessionSampleRate() {
        return this.profileSessionSampleRate;
    }

    @Nullable
    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }

    @Nullable
    public h getProfilesSampler() {
        return null;
    }

    @Nullable
    public String getProfilingTracesDirPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "profiling_traces").getAbsolutePath();
    }

    @ApiStatus.Internal
    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }

    @Nullable
    public String getProguardUuid() {
        return this.proguardUuid;
    }

    @Nullable
    public i getProxy() {
        return this.proxy;
    }

    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Nullable
    public String getRelease() {
        return this.release;
    }

    @NotNull
    public a4 getReplayController() {
        return this.replayController;
    }

    @Nullable
    public Double getSampleRate() {
        return this.sampleRate;
    }

    @NotNull
    public List<d1> getScopeObservers() {
        return this.observers;
    }

    @Nullable
    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    @Nullable
    public String getSentryClientName() {
        return this.sentryClientName;
    }

    @NotNull
    public l1 getSerializer() {
        return this.serializer.a();
    }

    @Nullable
    public String getServerName() {
        return this.serverName;
    }

    @ApiStatus.Internal
    public long getSessionFlushTimeoutMillis() {
        return this.sessionFlushTimeoutMillis;
    }

    @NotNull
    public q7 getSessionReplay() {
        return this.sessionReplay;
    }

    public long getSessionTrackingIntervalMillis() {
        return this.sessionTrackingIntervalMillis;
    }

    public long getShutdownTimeoutMillis() {
        return this.shutdownTimeoutMillis;
    }

    @NotNull
    public m1 getSocketTagger() {
        return this.socketTagger;
    }

    @ApiStatus.Internal
    @NotNull
    public o1 getSpanFactory() {
        return this.spanFactory;
    }

    @ApiStatus.Experimental
    @Nullable
    public String getSpotlightConnectionUrl() {
        return this.spotlightConnectionUrl;
    }

    @Nullable
    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    @NotNull
    public Map<String, String> getTags() {
        return this.tags;
    }

    @NotNull
    public io.sentry.util.thread.a getThreadChecker() {
        return this.threadChecker;
    }

    @NotNull
    public List<String> getTracePropagationTargets() {
        List<String> list = this.tracePropagationTargets;
        return list == null ? this.defaultTracePropagationTargets : list;
    }

    @Nullable
    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    @Nullable
    public k getTracesSampler() {
        return null;
    }

    @NotNull
    public q1 getTransactionProfiler() {
        return this.transactionProfiler;
    }

    @NotNull
    public r1 getTransportFactory() {
        return this.transportFactory;
    }

    @NotNull
    public io.sentry.transport.s getTransportGate() {
        return this.transportGate;
    }

    @ApiStatus.Internal
    @NotNull
    public s1 getVersionDetector() {
        return this.versionDetector;
    }

    @NotNull
    public final List<io.sentry.internal.viewhierarchy.a> getViewHierarchyExporters() {
        return this.viewHierarchyExporters;
    }

    public boolean isAttachServerName() {
        return this.attachServerName;
    }

    public boolean isAttachStacktrace() {
        return this.attachStacktrace;
    }

    public boolean isAttachThreads() {
        return this.attachThreads;
    }

    @ApiStatus.Experimental
    public boolean isCaptureOpenTelemetryEvents() {
        return this.captureOpenTelemetryEvents;
    }

    @ApiStatus.Internal
    public boolean isContinuousProfilingEnabled() {
        Double d10;
        return this.profilesSampleRate == null && (d10 = this.profileSessionSampleRate) != null && d10.doubleValue() > 0.0d;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isEnableAppStartProfiling() {
        return (isProfilingEnabled() || isContinuousProfilingEnabled()) && this.enableAppStartProfiling;
    }

    public boolean isEnableAutoSessionTracking() {
        return this.enableAutoSessionTracking;
    }

    @ApiStatus.Experimental
    public boolean isEnableBackpressureHandling() {
        return this.enableBackpressureHandling;
    }

    public boolean isEnableDeduplication() {
        return this.enableDeduplication;
    }

    public boolean isEnableExternalConfiguration() {
        return this.enableExternalConfiguration;
    }

    public boolean isEnablePrettySerializationOutput() {
        return this.enablePrettySerializationOutput;
    }

    public boolean isEnableScopePersistence() {
        return this.enableScopePersistence;
    }

    @ApiStatus.Experimental
    public boolean isEnableScreenTracking() {
        return this.enableScreenTracking;
    }

    public boolean isEnableShutdownHook() {
        return this.enableShutdownHook;
    }

    @ApiStatus.Experimental
    public boolean isEnableSpotlight() {
        return this.enableSpotlight;
    }

    public boolean isEnableTimeToFullDisplayTracing() {
        return this.enableTimeToFullDisplayTracing;
    }

    public boolean isEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public boolean isEnableUserInteractionBreadcrumbs() {
        return this.enableUserInteractionBreadcrumbs;
    }

    public boolean isEnableUserInteractionTracing() {
        return this.enableUserInteractionTracing;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isForceInit() {
        return this.forceInit;
    }

    @Nullable
    public Boolean isGlobalHubMode() {
        return this.globalHubMode;
    }

    public boolean isPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }

    public boolean isProfilingEnabled() {
        Double d10 = this.profilesSampleRate;
        return d10 != null && d10.doubleValue() > 0.0d;
    }

    public boolean isSendClientReports() {
        return this.sendClientReports;
    }

    public boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public boolean isSendModules() {
        return this.sendModules;
    }

    public boolean isStartProfilerOnAppStart() {
        return this.startProfilerOnAppStart;
    }

    public boolean isTraceOptionsRequests() {
        return this.traceOptionsRequests;
    }

    @ApiStatus.Experimental
    public boolean isTraceSampling() {
        return this.traceSampling;
    }

    public boolean isTracingEnabled() {
        if (getTracesSampleRate() != null) {
            return true;
        }
        getTracesSampler();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadLazyFields() {
        getSerializer();
        retrieveParsedDsn();
        getEnvelopeReader();
        getDateProvider();
    }

    public void merge(@NotNull i0 i0Var) {
        if (i0Var.m() != null) {
            setDsn(i0Var.m());
        }
        if (i0Var.p() != null) {
            setEnvironment(i0Var.p());
        }
        if (i0Var.C() != null) {
            setRelease(i0Var.C());
        }
        if (i0Var.l() != null) {
            setDist(i0Var.l());
        }
        if (i0Var.E() != null) {
            setServerName(i0Var.E());
        }
        if (i0Var.B() != null) {
            setProxy(i0Var.B());
        }
        if (i0Var.o() != null) {
            setEnableUncaughtExceptionHandler(i0Var.o().booleanValue());
        }
        if (i0Var.y() != null) {
            setPrintUncaughtStackTrace(i0Var.y().booleanValue());
        }
        if (i0Var.I() != null) {
            setTracesSampleRate(i0Var.I());
        }
        if (i0Var.z() != null) {
            setProfilesSampleRate(i0Var.z());
        }
        if (i0Var.k() != null) {
            setDebug(i0Var.k().booleanValue());
        }
        if (i0Var.n() != null) {
            setEnableDeduplication(i0Var.n().booleanValue());
        }
        if (i0Var.D() != null) {
            setSendClientReports(i0Var.D().booleanValue());
        }
        if (i0Var.P() != null) {
            setForceInit(i0Var.P().booleanValue());
        }
        for (Map.Entry entry : new HashMap(i0Var.G()).entrySet()) {
            this.tags.put((String) entry.getKey(), (String) entry.getValue());
        }
        Iterator it = new ArrayList(i0Var.w()).iterator();
        while (it.hasNext()) {
            addInAppInclude((String) it.next());
        }
        Iterator it2 = new ArrayList(i0Var.v()).iterator();
        while (it2.hasNext()) {
            addInAppExclude((String) it2.next());
        }
        Iterator it3 = new HashSet(i0Var.t()).iterator();
        while (it3.hasNext()) {
            addIgnoredExceptionForType((Class) it3.next());
        }
        if (i0Var.H() != null) {
            setTracePropagationTargets(new ArrayList(i0Var.H()));
        }
        Iterator it4 = new ArrayList(i0Var.i()).iterator();
        while (it4.hasNext()) {
            addContextTag((String) it4.next());
        }
        if (i0Var.A() != null) {
            setProguardUuid(i0Var.A());
        }
        if (i0Var.q() != null) {
            setIdleTimeout(i0Var.q());
        }
        Iterator<String> it5 = i0Var.h().iterator();
        while (it5.hasNext()) {
            addBundleId(it5.next());
        }
        if (i0Var.O() != null) {
            setEnabled(i0Var.O().booleanValue());
        }
        if (i0Var.M() != null) {
            setEnablePrettySerializationOutput(i0Var.M().booleanValue());
        }
        if (i0Var.S() != null) {
            setSendModules(i0Var.S().booleanValue());
        }
        if (i0Var.r() != null) {
            setIgnoredCheckIns(new ArrayList(i0Var.r()));
        }
        if (i0Var.u() != null) {
            setIgnoredTransactions(new ArrayList(i0Var.u()));
        }
        if (i0Var.s() != null) {
            setIgnoredErrors(new ArrayList(i0Var.s()));
        }
        if (i0Var.K() != null) {
            setEnableBackpressureHandling(i0Var.K().booleanValue());
        }
        if (i0Var.x() != null) {
            setMaxRequestBodySize(i0Var.x());
        }
        if (i0Var.R() != null) {
            setSendDefaultPii(i0Var.R().booleanValue());
        }
        if (i0Var.J() != null) {
            setCaptureOpenTelemetryEvents(i0Var.J().booleanValue());
        }
        if (i0Var.N() != null) {
            setEnableSpotlight(i0Var.N().booleanValue());
        }
        if (i0Var.F() != null) {
            setSpotlightConnectionUrl(i0Var.F());
        }
        if (i0Var.Q() != null) {
            setGlobalHubMode(i0Var.Q());
        }
        if (i0Var.j() != null) {
            if (getCron() == null) {
                setCron(i0Var.j());
            } else {
                if (i0Var.j().a() != null) {
                    getCron().f(i0Var.j().a());
                }
                if (i0Var.j().c() != null) {
                    getCron().h(i0Var.j().c());
                }
                if (i0Var.j().e() != null) {
                    getCron().j(i0Var.j().e());
                }
                if (i0Var.j().b() != null) {
                    getCron().g(i0Var.j().b());
                }
                if (i0Var.j().d() != null) {
                    getCron().i(i0Var.j().d());
                }
            }
        }
        if (i0Var.L() != null) {
            getLogs().b(i0Var.L().booleanValue());
        }
    }

    @ApiStatus.Internal
    @NotNull
    y retrieveParsedDsn() throws IllegalArgumentException {
        return this.parsedDsn.a();
    }

    public void setAttachServerName(boolean z10) {
        this.attachServerName = z10;
    }

    public void setAttachStacktrace(boolean z10) {
        this.attachStacktrace = z10;
    }

    public void setAttachThreads(boolean z10) {
        this.attachThreads = z10;
    }

    @ApiStatus.Internal
    public void setBackpressureMonitor(@NotNull io.sentry.backpressure.b bVar) {
        this.backpressureMonitor = bVar;
    }

    @ApiStatus.Internal
    public void setBeforeEnvelopeCallback(@Nullable b bVar) {
        this.beforeEnvelopeCallback = bVar;
    }

    public void setCacheDirPath(@Nullable String str) {
        this.cacheDirPath = str;
    }

    @ApiStatus.Experimental
    public void setCaptureOpenTelemetryEvents(boolean z10) {
        this.captureOpenTelemetryEvents = z10;
    }

    @ApiStatus.Internal
    public void setCompositePerformanceCollector(@NotNull io.sentry.j jVar) {
        this.compositePerformanceCollector = jVar;
    }

    public void setConnectionStatusProvider(@NotNull r0 r0Var) {
        this.connectionStatusProvider = r0Var;
    }

    public void setConnectionTimeoutMillis(int i10) {
        this.connectionTimeoutMillis = i10;
    }

    public void setContinuousProfiler(@Nullable s0 s0Var) {
        if (this.continuousProfiler != p2.a() || s0Var == null) {
            return;
        }
        this.continuousProfiler = s0Var;
    }

    @ApiStatus.Experimental
    public void setCron(@Nullable f fVar) {
        this.cron = fVar;
    }

    @ApiStatus.Internal
    public void setDateProvider(@NotNull o5 o5Var) {
        this.dateProvider.c(o5Var);
    }

    public void setDebug(boolean z10) {
        this.debug = z10;
    }

    @ApiStatus.Internal
    public void setDebugMetaLoader(@Nullable io.sentry.internal.debugmeta.a aVar) {
        if (aVar == null) {
            aVar = io.sentry.internal.debugmeta.b.b();
        }
        this.debugMetaLoader = aVar;
    }

    public void setDefaultScopeType(@NotNull h4 h4Var) {
        this.defaultScopeType = h4Var;
    }

    public void setDiagnosticLevel(@Nullable SentryLevel sentryLevel) {
        if (sentryLevel == null) {
            sentryLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        }
        this.diagnosticLevel = sentryLevel;
    }

    public void setDist(@Nullable String str) {
        this.dist = str;
    }

    @ApiStatus.Internal
    public void setDistinctId(@Nullable String str) {
        this.distinctId = str;
    }

    public void setDsn(@Nullable String str) {
        this.dsn = str;
        this.parsedDsn.b();
        this.dsnHash = io.sentry.util.d0.a(this.dsn, this.logger);
    }

    public void setEnableAppStartProfiling(boolean z10) {
        this.enableAppStartProfiling = z10;
    }

    public void setEnableAutoSessionTracking(boolean z10) {
        this.enableAutoSessionTracking = z10;
    }

    @ApiStatus.Experimental
    public void setEnableBackpressureHandling(boolean z10) {
        this.enableBackpressureHandling = z10;
    }

    public void setEnableDeduplication(boolean z10) {
        this.enableDeduplication = z10;
    }

    public void setEnableExternalConfiguration(boolean z10) {
        this.enableExternalConfiguration = z10;
    }

    public void setEnablePrettySerializationOutput(boolean z10) {
        this.enablePrettySerializationOutput = z10;
    }

    public void setEnableScopePersistence(boolean z10) {
        this.enableScopePersistence = z10;
    }

    @ApiStatus.Experimental
    public void setEnableScreenTracking(boolean z10) {
        this.enableScreenTracking = z10;
    }

    public void setEnableShutdownHook(boolean z10) {
        this.enableShutdownHook = z10;
    }

    @ApiStatus.Experimental
    public void setEnableSpotlight(boolean z10) {
        this.enableSpotlight = z10;
    }

    public void setEnableTimeToFullDisplayTracing(boolean z10) {
        this.enableTimeToFullDisplayTracing = z10;
    }

    public void setEnableUncaughtExceptionHandler(boolean z10) {
        this.enableUncaughtExceptionHandler = z10;
    }

    public void setEnableUserInteractionBreadcrumbs(boolean z10) {
        this.enableUserInteractionBreadcrumbs = z10;
    }

    public void setEnableUserInteractionTracing(boolean z10) {
        this.enableUserInteractionTracing = z10;
    }

    public void setEnabled(boolean z10) {
        this.enabled = z10;
    }

    public void setEnvelopeDiskCache(@Nullable io.sentry.cache.g gVar) {
        if (gVar == null) {
            gVar = io.sentry.transport.t.a();
        }
        this.envelopeDiskCache = gVar;
    }

    public void setEnvelopeReader(@Nullable t0 t0Var) {
        io.sentry.util.r<t0> rVar = this.envelopeReader;
        if (t0Var == null) {
            t0Var = q2.b();
        }
        rVar.c(t0Var);
    }

    public void setEnvironment(@Nullable String str) {
        this.environment = str;
    }

    @TestOnly
    @ApiStatus.Internal
    public void setExecutorService(@NotNull j1 j1Var) {
        if (j1Var != null) {
            this.executorService = j1Var;
        }
    }

    @ApiStatus.Experimental
    public void setFatalLogger(@Nullable w0 w0Var) {
        if (w0Var == null) {
            w0Var = s2.e();
        }
        this.fatalLogger = w0Var;
    }

    public void setFeedbackOptions(@NotNull u6 u6Var) {
        this.feedbackOptions = u6Var;
    }

    public void setFlushTimeoutMillis(long j10) {
        this.flushTimeoutMillis = j10;
    }

    public void setForceInit(boolean z10) {
        this.forceInit = z10;
    }

    @TestOnly
    @ApiStatus.Internal
    public void setFullyDisplayedReporter(@NotNull k0 k0Var) {
        this.fullyDisplayedReporter = k0Var;
    }

    public void setGestureTargetLocators(@NotNull List<io.sentry.internal.gestures.a> list) {
        this.gestureTargetLocators.clear();
        this.gestureTargetLocators.addAll(list);
    }

    public void setGlobalHubMode(@Nullable Boolean bool) {
        this.globalHubMode = bool;
    }

    public void setIdleTimeout(@Nullable Long l10) {
        this.idleTimeout = l10;
    }

    @ApiStatus.Experimental
    public void setIgnoredCheckIns(@Nullable List<String> list) {
        if (list == null) {
            this.ignoredCheckIns = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(new j0(str));
            }
        }
        this.ignoredCheckIns = arrayList;
    }

    public void setIgnoredErrors(@Nullable List<String> list) {
        if (list == null) {
            this.ignoredErrors = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new j0(str));
            }
        }
        this.ignoredErrors = arrayList;
    }

    @ApiStatus.Experimental
    public void setIgnoredSpanOrigins(@Nullable List<String> list) {
        if (list == null) {
            this.ignoredSpanOrigins = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new j0(str));
            }
        }
        this.ignoredSpanOrigins = arrayList;
    }

    @ApiStatus.Experimental
    public void setIgnoredTransactions(@Nullable List<String> list) {
        if (list == null) {
            this.ignoredTransactions = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new j0(str));
            }
        }
        this.ignoredTransactions = arrayList;
    }

    @ApiStatus.Internal
    public void setInitPriority(@NotNull t1 t1Var) {
        this.initPriority = t1Var;
    }

    @Deprecated
    public void setInstrumenter(@NotNull u1 u1Var) {
        this.instrumenter = u1Var;
    }

    public void setLogger(@Nullable w0 w0Var) {
        this.logger = w0Var == null ? s2.e() : new u(this, w0Var);
    }

    @ApiStatus.Experimental
    public void setLogs(@NotNull g gVar) {
        this.logs = gVar;
    }

    public void setMaxAttachmentSize(long j10) {
        this.maxAttachmentSize = j10;
    }

    public void setMaxBreadcrumbs(int i10) {
        this.maxBreadcrumbs = i10;
    }

    public void setMaxCacheItems(int i10) {
        this.maxCacheItems = i10;
    }

    public void setMaxDepth(int i10) {
        this.maxDepth = i10;
    }

    public void setMaxQueueSize(int i10) {
        if (i10 > 0) {
            this.maxQueueSize = i10;
        }
    }

    public void setMaxRequestBodySize(@NotNull j jVar) {
        this.maxRequestBodySize = jVar;
    }

    @ApiStatus.Experimental
    public void setMaxSpans(int i10) {
        this.maxSpans = i10;
    }

    public void setMaxTraceFileSize(long j10) {
        this.maxTraceFileSize = j10;
    }

    @ApiStatus.Internal
    public void setModulesLoader(@Nullable io.sentry.internal.modules.b bVar) {
        if (bVar == null) {
            bVar = io.sentry.internal.modules.e.b();
        }
        this.modulesLoader = bVar;
    }

    public void setOpenTelemetryMode(@NotNull k7 k7Var) {
        this.openTelemetryMode = k7Var;
    }

    public void setPrintUncaughtStackTrace(boolean z10) {
        this.printUncaughtStackTrace = z10;
    }

    public void setProfileLifecycle(@NotNull v3 v3Var) {
        this.profileLifecycle = v3Var;
        if (v3Var != v3.TRACE || isTracingEnabled()) {
            return;
        }
        this.logger.c(SentryLevel.WARNING, "Profiling lifecycle is set to TRACE but tracing is disabled. Profiling will not be started automatically.", new Object[0]);
    }

    public void setProfileSessionSampleRate(@Nullable Double d10) {
        if (io.sentry.util.a0.c(d10)) {
            this.profileSessionSampleRate = d10;
            return;
        }
        throw new IllegalArgumentException("The value " + d10 + " is not valid. Use values between 0.0 and 1.0.");
    }

    public void setProfilesSampleRate(@Nullable Double d10) {
        if (io.sentry.util.a0.d(d10)) {
            this.profilesSampleRate = d10;
            return;
        }
        throw new IllegalArgumentException("The value " + d10 + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    @ApiStatus.Internal
    public void setProfilingTracesHz(int i10) {
        this.profilingTracesHz = i10;
    }

    public void setProguardUuid(@Nullable String str) {
        this.proguardUuid = str;
    }

    public void setProxy(@Nullable i iVar) {
        this.proxy = iVar;
    }

    public void setReadTimeoutMillis(int i10) {
        this.readTimeoutMillis = i10;
    }

    public void setRelease(@Nullable String str) {
        this.release = str;
    }

    public void setReplayController(@Nullable a4 a4Var) {
        if (a4Var == null) {
            a4Var = t2.b();
        }
        this.replayController = a4Var;
    }

    public void setSampleRate(Double d10) {
        if (io.sentry.util.a0.f(d10)) {
            this.sampleRate = d10;
            return;
        }
        throw new IllegalArgumentException("The value " + d10 + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }

    @ApiStatus.Internal
    public void setSdkVersion(@Nullable SdkVersion sdkVersion) {
        SdkVersion sdkVersionD = getSessionReplay().d();
        SdkVersion sdkVersion2 = this.sdkVersion;
        if (sdkVersion2 != null && sdkVersionD != null && sdkVersion2.equals(sdkVersionD)) {
            getSessionReplay().j(sdkVersion);
        }
        this.sdkVersion = sdkVersion;
    }

    public void setSendClientReports(boolean z10) {
        this.sendClientReports = z10;
        if (z10) {
            this.clientReportRecorder = new io.sentry.clientreport.e(this);
        } else {
            this.clientReportRecorder = new io.sentry.clientreport.j();
        }
    }

    public void setSendDefaultPii(boolean z10) {
        this.sendDefaultPii = z10;
    }

    public void setSendModules(boolean z10) {
        this.sendModules = z10;
    }

    public void setSentryClientName(@Nullable String str) {
        this.sentryClientName = str;
    }

    public void setSerializer(@Nullable l1 l1Var) {
        io.sentry.util.r<l1> rVar = this.serializer;
        if (l1Var == null) {
            l1Var = c3.g();
        }
        rVar.c(l1Var);
    }

    public void setServerName(@Nullable String str) {
        this.serverName = str;
    }

    @ApiStatus.Internal
    public void setSessionFlushTimeoutMillis(long j10) {
        this.sessionFlushTimeoutMillis = j10;
    }

    public void setSessionReplay(@NotNull q7 q7Var) {
        this.sessionReplay = q7Var;
    }

    public void setSessionTrackingIntervalMillis(long j10) {
        this.sessionTrackingIntervalMillis = j10;
    }

    public void setShutdownTimeoutMillis(long j10) {
        this.shutdownTimeoutMillis = j10;
    }

    public void setSocketTagger(@Nullable m1 m1Var) {
        if (m1Var == null) {
            m1Var = d3.c();
        }
        this.socketTagger = m1Var;
    }

    @ApiStatus.Internal
    public void setSpanFactory(@NotNull o1 o1Var) {
        this.spanFactory = o1Var;
    }

    @ApiStatus.Experimental
    public void setSpotlightConnectionUrl(@Nullable String str) {
        this.spotlightConnectionUrl = str;
    }

    public void setSslSocketFactory(@Nullable SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setStartProfilerOnAppStart(boolean z10) {
        this.startProfilerOnAppStart = z10;
    }

    public void setTag(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            this.tags.remove(str);
        } else {
            this.tags.put(str, str2);
        }
    }

    public void setThreadChecker(@NotNull io.sentry.util.thread.a aVar) {
        this.threadChecker = aVar;
    }

    public void setTraceOptionsRequests(boolean z10) {
        this.traceOptionsRequests = z10;
    }

    public void setTracePropagationTargets(@Nullable List<String> list) {
        if (list == null) {
            this.tracePropagationTargets = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(str);
            }
        }
        this.tracePropagationTargets = arrayList;
    }

    @Deprecated
    public void setTraceSampling(boolean z10) {
        this.traceSampling = z10;
    }

    public void setTracesSampleRate(@Nullable Double d10) {
        if (io.sentry.util.a0.g(d10)) {
            this.tracesSampleRate = d10;
            return;
        }
        throw new IllegalArgumentException("The value " + d10 + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public void setTransactionProfiler(@Nullable q1 q1Var) {
        if (this.transactionProfiler != h3.c() || q1Var == null) {
            return;
        }
        this.transactionProfiler = q1Var;
    }

    public void setTransportFactory(@Nullable r1 r1Var) {
        if (r1Var == null) {
            r1Var = i3.b();
        }
        this.transportFactory = r1Var;
    }

    public void setTransportGate(@Nullable io.sentry.transport.s sVar) {
        if (sVar == null) {
            sVar = io.sentry.transport.v.a();
        }
        this.transportGate = sVar;
    }

    @ApiStatus.Internal
    public void setVersionDetector(@NotNull s1 s1Var) {
        this.versionDetector = s1Var;
    }

    public void setViewHierarchyExporters(@NotNull List<io.sentry.internal.viewhierarchy.a> list) {
        this.viewHierarchyExporters.clear();
        this.viewHierarchyExporters.addAll(list);
    }

    private SentryOptions(boolean z10) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.eventProcessors = copyOnWriteArrayList;
        this.ignoredExceptionsForType = new CopyOnWriteArraySet();
        this.ignoredErrors = null;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.integrations = copyOnWriteArrayList2;
        this.bundleIds = new CopyOnWriteArraySet();
        this.parsedDsn = new io.sentry.util.r<>(new r.a() { // from class: io.sentry.l7
            @Override // io.sentry.util.r.a
            public final Object a() {
                return this.f27985a.lambda$new$0();
            }
        });
        this.shutdownTimeoutMillis = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        this.flushTimeoutMillis = 15000L;
        this.sessionFlushTimeoutMillis = 15000L;
        this.logger = s2.e();
        this.fatalLogger = s2.e();
        this.diagnosticLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        this.serializer = new io.sentry.util.r<>(new r.a() { // from class: io.sentry.m7
            @Override // io.sentry.util.r.a
            public final Object a() {
                return this.f28007a.lambda$new$1();
            }
        });
        this.envelopeReader = new io.sentry.util.r<>(new r.a() { // from class: io.sentry.n7
            @Override // io.sentry.util.r.a
            public final Object a() {
                return this.f28014a.lambda$new$2();
            }
        });
        this.maxDepth = 100;
        this.maxCacheItems = 30;
        this.maxQueueSize = 30;
        this.maxBreadcrumbs = 100;
        this.inAppExcludes = new CopyOnWriteArrayList();
        this.inAppIncludes = new CopyOnWriteArrayList();
        this.transportFactory = i3.b();
        this.transportGate = io.sentry.transport.v.a();
        this.attachStacktrace = true;
        this.enableAutoSessionTracking = true;
        this.sessionTrackingIntervalMillis = 30000L;
        this.attachServerName = true;
        this.enableUncaughtExceptionHandler = true;
        this.printUncaughtStackTrace = false;
        this.executorService = b3.e();
        this.connectionTimeoutMillis = 30000;
        this.readTimeoutMillis = 30000;
        this.envelopeDiskCache = io.sentry.transport.t.a();
        this.sendDefaultPii = false;
        this.observers = new CopyOnWriteArrayList();
        this.optionsObservers = new CopyOnWriteArrayList();
        this.tags = new ConcurrentHashMap();
        this.maxAttachmentSize = 20971520L;
        this.enableDeduplication = true;
        this.maxSpans = 1000;
        this.enableShutdownHook = true;
        this.maxRequestBodySize = j.NONE;
        this.traceSampling = true;
        this.maxTraceFileSize = 5242880L;
        this.transactionProfiler = h3.c();
        this.continuousProfiler = p2.a();
        this.tracePropagationTargets = null;
        this.defaultTracePropagationTargets = Collections.singletonList(DEFAULT_PROPAGATION_TARGETS);
        this.idleTimeout = Long.valueOf(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        this.contextTags = new CopyOnWriteArrayList();
        this.sendClientReports = true;
        this.clientReportRecorder = new io.sentry.clientreport.e(this);
        this.modulesLoader = io.sentry.internal.modules.e.b();
        this.debugMetaLoader = io.sentry.internal.debugmeta.b.b();
        this.enableUserInteractionTracing = false;
        this.enableUserInteractionBreadcrumbs = true;
        this.instrumenter = u1.SENTRY;
        this.gestureTargetLocators = new ArrayList();
        this.viewHierarchyExporters = new ArrayList();
        this.threadChecker = io.sentry.util.thread.b.d();
        this.traceOptionsRequests = true;
        this.dateProvider = new io.sentry.util.r<>(new r.a() { // from class: io.sentry.o7
            @Override // io.sentry.util.r.a
            public final Object a() {
                return SentryOptions.lambda$new$3();
            }
        });
        this.performanceCollectors = new ArrayList();
        this.compositePerformanceCollector = n2.g();
        this.enableTimeToFullDisplayTracing = false;
        this.fullyDisplayedReporter = k0.a();
        this.connectionStatusProvider = new o2();
        this.enabled = true;
        this.enablePrettySerializationOutput = true;
        this.sendModules = true;
        this.enableSpotlight = false;
        this.enableScopePersistence = true;
        this.ignoredCheckIns = null;
        this.ignoredSpanOrigins = null;
        this.ignoredTransactions = null;
        this.backpressureMonitor = io.sentry.backpressure.c.b();
        this.enableBackpressureHandling = true;
        this.enableAppStartProfiling = false;
        this.spanFactory = f3.b();
        this.profilingTracesHz = 101;
        this.cron = null;
        this.replayController = t2.b();
        this.enableScreenTracking = true;
        this.defaultScopeType = h4.ISOLATION;
        this.initPriority = t1.MEDIUM;
        this.forceInit = false;
        this.globalHubMode = null;
        this.lock = new io.sentry.util.a();
        this.openTelemetryMode = k7.AUTO;
        this.captureOpenTelemetryEvents = false;
        this.versionDetector = j3.b();
        this.profileLifecycle = v3.MANUAL;
        this.startProfilerOnAppStart = false;
        this.logs = new g();
        this.socketTagger = d3.c();
        SdkVersion sdkVersionCreateSdkVersion = createSdkVersion();
        this.experimental = new h0(z10, sdkVersionCreateSdkVersion);
        this.sessionReplay = new q7(z10, sdkVersionCreateSdkVersion);
        this.feedbackOptions = new u6();
        if (z10) {
            return;
        }
        setSpanFactory(k8.a(new io.sentry.util.s(), s2.e()));
        this.executorService = new t6();
        copyOnWriteArrayList2.add(new UncaughtExceptionHandlerIntegration());
        copyOnWriteArrayList2.add(new ShutdownHookIntegration());
        copyOnWriteArrayList2.add(new SpotlightIntegration());
        copyOnWriteArrayList.add(new j2(this));
        copyOnWriteArrayList.add(new z(this));
        if (io.sentry.util.y.c()) {
            copyOnWriteArrayList.add(new r7());
        }
        setSentryClientName("sentry.java/8.14.0");
        setSdkVersion(sdkVersionCreateSdkVersion);
        addPackageInfo();
    }

    public void setBeforeBreadcrumb(@Nullable a aVar) {
    }

    public void setBeforeSend(@Nullable c cVar) {
    }

    public void setBeforeSendFeedback(@Nullable c cVar) {
    }

    public void setBeforeSendReplay(@Nullable d dVar) {
    }

    public void setBeforeSendTransaction(@Nullable e eVar) {
    }

    public void setProfilesSampler(@Nullable h hVar) {
    }

    public void setTracesSampler(@Nullable k kVar) {
    }
}
