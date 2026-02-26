package io.sentry;

import com.google.android.gms.common.Scopes;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Sentry {

    @ApiStatus.Internal
    @NotNull
    public static final String APP_START_PROFILING_CONFIG_FILE_NAME = "app_start_profiling_config";
    private static final boolean GLOBAL_HUB_DEFAULT_MODE = false;

    @NotNull
    private static volatile g1 scopesStorage = x2.c();

    @NotNull
    private static volatile f1 rootScopes = v2.a();

    @NotNull
    private static final c1 globalScope = new Scope(SentryOptions.empty());
    private static volatile boolean globalHubMode = false;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final long classCreationTimestamp = System.currentTimeMillis();
    private static final io.sentry.util.a lock = new io.sentry.util.a();

    public interface OptionsConfiguration<T extends SentryOptions> {
        void configure(@NotNull T t10);
    }

    private Sentry() {
    }

    public static void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable l0 l0Var) {
        getCurrentScopes().addBreadcrumb(breadcrumb, l0Var);
    }

    private static <T extends SentryOptions> void applyOptionsConfiguration(OptionsConfiguration<T> optionsConfiguration, T t10) {
        try {
            optionsConfiguration.configure(t10);
        } catch (Throwable th) {
            t10.getLogger().b(SentryLevel.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th);
        }
    }

    public static void bindClient(@NotNull i1 i1Var) {
        getCurrentScopes().bindClient(i1Var);
    }

    @ApiStatus.Experimental
    @NotNull
    public static SentryId captureCheckIn(@NotNull f fVar) {
        return getCurrentScopes().T(fVar);
    }

    @NotNull
    public static SentryId captureEvent(@NotNull r6 r6Var) {
        return getCurrentScopes().H(r6Var);
    }

    @NotNull
    public static SentryId captureException(@NotNull Throwable th) {
        return getCurrentScopes().Q(th);
    }

    @NotNull
    public static SentryId captureFeedback(@NotNull Feedback feedback) {
        return getCurrentScopes().b0(feedback);
    }

    @NotNull
    public static SentryId captureMessage(@NotNull String str) {
        return getCurrentScopes().w(str);
    }

    public static void captureUserFeedback(@NotNull c9 c9Var) {
        getCurrentScopes().j(c9Var);
    }

    public static void clearBreadcrumbs() {
        getCurrentScopes().clearBreadcrumbs();
    }

    public static void close() {
        k1 k1VarA = lock.a();
        try {
            f1 currentScopes = getCurrentScopes();
            rootScopes = v2.a();
            getScopesStorage().close();
            currentScopes.b(false);
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

    public static void configureScope(@NotNull ScopeCallback scopeCallback) {
        configureScope(null, scopeCallback);
    }

    @Nullable
    public static y8 continueTrace(@Nullable String str, @Nullable List<String> list) {
        return getCurrentScopes().R(str, list);
    }

    public static void endSession() {
        getCurrentScopes().endSession();
    }

    private static void finalizePreviousSession(@NotNull SentryOptions sentryOptions, @NotNull f1 f1Var) {
        try {
            sentryOptions.getExecutorService().submit(new s3(sentryOptions, f1Var));
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.DEBUG, "Failed to finalize previous session.", th);
        }
    }

    public static void flush(long j10) {
        getCurrentScopes().f(j10);
    }

    @NotNull
    public static f1 forkedCurrentScope(@NotNull String str) {
        return getCurrentScopes().r(str);
    }

    @ApiStatus.Internal
    @NotNull
    public static f1 forkedRootScopes(@NotNull String str) {
        return globalHubMode ? rootScopes : rootScopes.Z(str);
    }

    @NotNull
    public static f1 forkedScopes(@NotNull String str) {
        return getCurrentScopes().Z(str);
    }

    @Nullable
    public static e getBaggage() {
        return getCurrentScopes().W();
    }

    @ApiStatus.Internal
    @Deprecated
    @NotNull
    public static v0 getCurrentHub() {
        return new q0(getCurrentScopes());
    }

    @ApiStatus.Internal
    @NotNull
    public static f1 getCurrentScopes() {
        if (globalHubMode) {
            return rootScopes;
        }
        f1 f1Var = getScopesStorage().get();
        if (f1Var != null && !f1Var.g()) {
            return f1Var;
        }
        f1 f1VarZ = rootScopes.Z("getCurrentScopes");
        getScopesStorage().b(f1VarZ);
        return f1VarZ;
    }

    @NotNull
    public static c1 getGlobalScope() {
        return globalScope;
    }

    @NotNull
    public static SentryId getLastEventId() {
        return getCurrentScopes().getLastEventId();
    }

    @NotNull
    private static g1 getScopesStorage() {
        return scopesStorage;
    }

    @Nullable
    public static n1 getSpan() {
        return (globalHubMode && io.sentry.util.y.a()) ? getCurrentScopes().getTransaction() : getCurrentScopes().getSpan();
    }

    @Nullable
    public static u7 getTraceparent() {
        return getCurrentScopes().a0();
    }

    private static void handleAppStartProfilingConfig(@NotNull final SentryOptions sentryOptions, @NotNull j1 j1Var) {
        try {
            j1Var.submit(new Runnable() { // from class: io.sentry.e5
                @Override // java.lang.Runnable
                public final void run() {
                    Sentry.lambda$handleAppStartProfilingConfig$3(sentryOptions);
                }
            });
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. App start profiling config will not be changed. Did you call Sentry.close()?", th);
        }
    }

    public static void init() {
        init((OptionsConfiguration<SentryOptions>) new OptionsConfiguration() { // from class: io.sentry.c5
            @Override // io.sentry.Sentry.OptionsConfiguration
            public final void configure(SentryOptions sentryOptions) {
                sentryOptions.setEnableExternalConfiguration(true);
            }
        }, false);
    }

    private static void initConfigurations(@NotNull SentryOptions sentryOptions) {
        w0 logger = sentryOptions.getLogger();
        SentryLevel sentryLevel = SentryLevel.INFO;
        logger.c(sentryLevel, "Initializing SDK with DSN: '%s'", sentryOptions.getDsn());
        String outboxPath = sentryOptions.getOutboxPath();
        if (outboxPath != null) {
            new File(outboxPath).mkdirs();
        } else {
            logger.c(sentryLevel, "No outbox dir path is defined in options.", new Object[0]);
        }
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath != null) {
            new File(cacheDirPath).mkdirs();
            if (sentryOptions.getEnvelopeDiskCache() instanceof io.sentry.transport.t) {
                sentryOptions.setEnvelopeDiskCache(io.sentry.cache.f.t(sentryOptions));
            }
        }
        String profilingTracesDirPath = sentryOptions.getProfilingTracesDirPath();
        if ((sentryOptions.isProfilingEnabled() || sentryOptions.isContinuousProfilingEnabled()) && profilingTracesDirPath != null) {
            final File file = new File(profilingTracesDirPath);
            file.mkdirs();
            try {
                sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.a5
                    @Override // java.lang.Runnable
                    public final void run() {
                        Sentry.lambda$initConfigurations$5(file);
                    }
                });
            } catch (RejectedExecutionException e10) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Old profiles will not be deleted. Did you call Sentry.close()?", e10);
            }
        }
        io.sentry.internal.modules.b modulesLoader = sentryOptions.getModulesLoader();
        if (!sentryOptions.isSendModules()) {
            sentryOptions.setModulesLoader(io.sentry.internal.modules.e.b());
        } else if (modulesLoader instanceof io.sentry.internal.modules.e) {
            sentryOptions.setModulesLoader(new io.sentry.internal.modules.a(Arrays.asList(new io.sentry.internal.modules.c(sentryOptions.getLogger()), new io.sentry.internal.modules.f(sentryOptions.getLogger())), sentryOptions.getLogger()));
        }
        if (sentryOptions.getDebugMetaLoader() instanceof io.sentry.internal.debugmeta.b) {
            sentryOptions.setDebugMetaLoader(new io.sentry.internal.debugmeta.c(sentryOptions.getLogger()));
        }
        io.sentry.util.d.c(sentryOptions, sentryOptions.getDebugMetaLoader().a());
        if (sentryOptions.getThreadChecker() instanceof io.sentry.util.thread.b) {
            sentryOptions.setThreadChecker(io.sentry.util.thread.c.d());
        }
        if (sentryOptions.getPerformanceCollectors().isEmpty()) {
            sentryOptions.addPerformanceCollector(new w1());
        }
        if (sentryOptions.isEnableBackpressureHandling() && io.sentry.util.y.c()) {
            if (sentryOptions.getBackpressureMonitor() instanceof io.sentry.backpressure.c) {
                sentryOptions.setBackpressureMonitor(new io.sentry.backpressure.a(sentryOptions, r4.a()));
            }
            sentryOptions.getBackpressureMonitor().start();
        }
    }

    private static void initFatalLogger(@NotNull SentryOptions sentryOptions) {
        if (sentryOptions.getFatalLogger() instanceof s2) {
            sentryOptions.setFatalLogger(new u8());
        }
    }

    private static void initForOpenTelemetryMaybe(SentryOptions sentryOptions) {
        io.sentry.opentelemetry.a.c(sentryOptions, new io.sentry.util.s());
        if (k7.OFF == sentryOptions.getOpenTelemetryMode()) {
            sentryOptions.setSpanFactory(new s());
        }
        initScopesStorage(sentryOptions);
        io.sentry.opentelemetry.a.a(sentryOptions);
    }

    private static void initLogger(@NotNull SentryOptions sentryOptions) {
        if (sentryOptions.isDebug() && (sentryOptions.getLogger() instanceof s2)) {
            sentryOptions.setLogger(new u8());
        }
    }

    private static void initScopesStorage(SentryOptions sentryOptions) {
        getScopesStorage().close();
        if (k7.OFF == sentryOptions.getOpenTelemetryMode()) {
            scopesStorage = new r();
        } else {
            scopesStorage = s4.a(new io.sentry.util.s(), s2.e());
        }
    }

    @Nullable
    public static Boolean isCrashedLastRun() {
        return getCurrentScopes().L();
    }

    public static boolean isEnabled() {
        return getCurrentScopes().isEnabled();
    }

    public static boolean isHealthy() {
        return getCurrentScopes().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleAppStartProfilingConfig$3(SentryOptions sentryOptions) {
        String cacheDirPathWithoutDsn = sentryOptions.getCacheDirPathWithoutDsn();
        if (cacheDirPathWithoutDsn != null) {
            File file = new File(cacheDirPathWithoutDsn, APP_START_PROFILING_CONFIG_FILE_NAME);
            try {
                io.sentry.util.h.a(file);
                if (sentryOptions.isEnableAppStartProfiling() || sentryOptions.isStartProfilerOnAppStart()) {
                    if (!sentryOptions.isStartProfilerOnAppStart() && !sentryOptions.isTracingEnabled()) {
                        sentryOptions.getLogger().c(SentryLevel.INFO, "Tracing is disabled and app start profiling will not start.", new Object[0]);
                        return;
                    }
                    if (file.createNewFile()) {
                        g5 g5Var = new g5(sentryOptions, sentryOptions.isEnableAppStartProfiling() ? sampleAppStartProfiling(sentryOptions) : new x8(Boolean.FALSE));
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, UTF_8));
                            try {
                                sentryOptions.getSerializer().a(g5Var, bufferedWriter);
                                bufferedWriter.close();
                                fileOutputStream.close();
                            } finally {
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "Unable to create app start profiling config file. ", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initConfigurations$5(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.lastModified() < classCreationTimestamp - TimeUnit.MINUTES.toMillis(5L)) {
                io.sentry.util.h.a(file2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyOptionsObservers$4(SentryOptions sentryOptions) {
        for (x0 x0Var : sentryOptions.getOptionsObservers()) {
            x0Var.g(sentryOptions.getRelease());
            x0Var.e(sentryOptions.getProguardUuid());
            x0Var.f(sentryOptions.getSdkVersion());
            x0Var.b(sentryOptions.getDist());
            x0Var.d(sentryOptions.getEnvironment());
            x0Var.a(sentryOptions.getTags());
            x0Var.c(sentryOptions.getSessionReplay().c());
        }
        io.sentry.cache.w wVarFindPersistingScopeObserver = sentryOptions.findPersistingScopeObserver();
        if (wVarFindPersistingScopeObserver != null) {
            wVarFindPersistingScopeObserver.P();
        }
    }

    @ApiStatus.Experimental
    @NotNull
    public static io.sentry.logger.a logger() {
        return getCurrentScopes().q();
    }

    private static void notifyOptionsObservers(@NotNull final SentryOptions sentryOptions) {
        try {
            sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.f5
                @Override // java.lang.Runnable
                public final void run() {
                    Sentry.lambda$notifyOptionsObservers$4(sentryOptions);
                }
            });
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.DEBUG, "Failed to notify options observers.", th);
        }
    }

    @Deprecated
    public static void popScope() {
        if (globalHubMode) {
            return;
        }
        getCurrentScopes().t();
    }

    private static boolean preInitConfigurations(@NotNull SentryOptions sentryOptions) {
        if (sentryOptions.isEnableExternalConfiguration()) {
            sentryOptions.merge(i0.g(io.sentry.config.h.a(), sentryOptions.getLogger()));
        }
        String dsn = sentryOptions.getDsn();
        if (!sentryOptions.isEnabled() || (dsn != null && dsn.isEmpty())) {
            close();
            return false;
        }
        if (dsn == null) {
            throw new IllegalArgumentException("DSN is required. Use empty string or set enabled to false in SentryOptions to disable SDK.");
        }
        sentryOptions.retrieveParsedDsn();
        return true;
    }

    @NotNull
    public static k1 pushIsolationScope() {
        return !globalHubMode ? getCurrentScopes().Y() : w2.a();
    }

    @NotNull
    public static k1 pushScope() {
        return !globalHubMode ? getCurrentScopes().p() : w2.a();
    }

    public static void removeExtra(@Nullable String str) {
        getCurrentScopes().removeExtra(str);
    }

    public static void removeTag(@Nullable String str) {
        getCurrentScopes().removeTag(str);
    }

    @NotNull
    public static b1 replay() {
        return getCurrentScopes().getScope().getOptions().getReplayController();
    }

    public static void reportFullyDisplayed() {
        getCurrentScopes().I();
    }

    @NotNull
    private static x8 sampleAppStartProfiling(@NotNull SentryOptions sentryOptions) {
        y8 y8Var = new y8("app.launch", Scopes.PROFILE);
        y8Var.z(true);
        return sentryOptions.getInternalTracesSampler().a(new e4(y8Var, null, Double.valueOf(io.sentry.util.b0.a().d()), null));
    }

    @ApiStatus.Internal
    @Deprecated
    @NotNull
    public static k1 setCurrentHub(@NotNull v0 v0Var) {
        return setCurrentScopes(v0Var);
    }

    @ApiStatus.Internal
    @NotNull
    public static k1 setCurrentScopes(@NotNull f1 f1Var) {
        return getScopesStorage().b(f1Var);
    }

    public static void setExtra(@Nullable String str, @Nullable String str2) {
        getCurrentScopes().setExtra(str, str2);
    }

    public static void setFingerprint(@NotNull List<String> list) {
        getCurrentScopes().setFingerprint(list);
    }

    public static void setLevel(@Nullable SentryLevel sentryLevel) {
        getCurrentScopes().setLevel(sentryLevel);
    }

    public static void setTag(@Nullable String str, @Nullable String str2) {
        getCurrentScopes().setTag(str, str2);
    }

    public static void setTransaction(@Nullable String str) {
        getCurrentScopes().setTransaction(str);
    }

    public static void setUser(@Nullable User user) {
        getCurrentScopes().setUser(user);
    }

    @ApiStatus.Experimental
    public static void startProfiler() {
        getCurrentScopes().D();
    }

    public static void startSession() {
        getCurrentScopes().startSession();
    }

    @NotNull
    public static p1 startTransaction(@NotNull String str, @NotNull String str2) {
        return getCurrentScopes().G(str, str2);
    }

    @ApiStatus.Experimental
    public static void stopProfiler() {
        getCurrentScopes().k();
    }

    public static void withIsolationScope(@NotNull ScopeCallback scopeCallback) {
        getCurrentScopes().B(scopeCallback);
    }

    public static void withScope(@NotNull ScopeCallback scopeCallback) {
        getCurrentScopes().O(scopeCallback);
    }

    public static void addBreadcrumb(@NotNull Breadcrumb breadcrumb) {
        getCurrentScopes().c(breadcrumb);
    }

    @NotNull
    public static SentryId captureEvent(@NotNull r6 r6Var, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().C(r6Var, scopeCallback);
    }

    @NotNull
    public static SentryId captureException(@NotNull Throwable th, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().K(th, scopeCallback);
    }

    @NotNull
    public static SentryId captureFeedback(@NotNull Feedback feedback, @Nullable l0 l0Var) {
        return getCurrentScopes().A(feedback, l0Var);
    }

    @NotNull
    public static SentryId captureMessage(@NotNull String str, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().v(str, scopeCallback);
    }

    public static void configureScope(@Nullable h4 h4Var, @NotNull ScopeCallback scopeCallback) {
        getCurrentScopes().o(h4Var, scopeCallback);
    }

    public static void init(@NotNull final String str) {
        init((OptionsConfiguration<SentryOptions>) new OptionsConfiguration() { // from class: io.sentry.d5
            @Override // io.sentry.Sentry.OptionsConfiguration
            public final void configure(SentryOptions sentryOptions) {
                sentryOptions.setDsn(str);
            }
        });
    }

    @NotNull
    public static p1 startTransaction(@NotNull String str, @NotNull String str2, @NotNull a9 a9Var) {
        return getCurrentScopes().V(str, str2, a9Var);
    }

    public static void addBreadcrumb(@NotNull String str) {
        getCurrentScopes().u(str);
    }

    @NotNull
    public static SentryId captureEvent(@NotNull r6 r6Var, @Nullable l0 l0Var) {
        return getCurrentScopes().E(r6Var, l0Var);
    }

    @NotNull
    public static SentryId captureException(@NotNull Throwable th, @Nullable l0 l0Var) {
        return getCurrentScopes().S(th, l0Var);
    }

    @NotNull
    public static SentryId captureFeedback(@NotNull Feedback feedback, @Nullable l0 l0Var, @Nullable ScopeCallback scopeCallback) {
        return getCurrentScopes().s(feedback, l0Var, scopeCallback);
    }

    @NotNull
    public static SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel) {
        return getCurrentScopes().x(str, sentryLevel);
    }

    public static <T extends SentryOptions> void init(@NotNull n3<T> n3Var, @NotNull OptionsConfiguration<T> optionsConfiguration) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        init(n3Var, optionsConfiguration, false);
    }

    @NotNull
    public static p1 startTransaction(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull a9 a9Var) {
        p1 p1VarV = getCurrentScopes().V(str, str2, a9Var);
        p1VarV.e(str3);
        return p1VarV;
    }

    public static void addBreadcrumb(@NotNull String str, @NotNull String str2) {
        getCurrentScopes().U(str, str2);
    }

    @NotNull
    public static SentryId captureEvent(@NotNull r6 r6Var, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().M(r6Var, l0Var, scopeCallback);
    }

    @NotNull
    public static SentryId captureException(@NotNull Throwable th, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().l(th, l0Var, scopeCallback);
    }

    @NotNull
    public static SentryId captureMessage(@NotNull String str, @NotNull SentryLevel sentryLevel, @NotNull ScopeCallback scopeCallback) {
        return getCurrentScopes().P(str, sentryLevel, scopeCallback);
    }

    public static <T extends SentryOptions> void init(@NotNull n3<T> n3Var, @NotNull OptionsConfiguration<T> optionsConfiguration, boolean z10) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        T tB = n3Var.b();
        applyOptionsConfiguration(optionsConfiguration, tB);
        init(tB, z10);
    }

    @NotNull
    public static p1 startTransaction(@NotNull y8 y8Var) {
        return getCurrentScopes().F(y8Var);
    }

    @NotNull
    public static p1 startTransaction(@NotNull y8 y8Var, @NotNull a9 a9Var) {
        return getCurrentScopes().J(y8Var, a9Var);
    }

    public static void init(@NotNull OptionsConfiguration<SentryOptions> optionsConfiguration) {
        init(optionsConfiguration, false);
    }

    public static void init(@NotNull OptionsConfiguration<SentryOptions> optionsConfiguration, boolean z10) {
        SentryOptions sentryOptions = new SentryOptions();
        applyOptionsConfiguration(optionsConfiguration, sentryOptions);
        init(sentryOptions, z10);
    }

    @ApiStatus.Internal
    public static void init(@NotNull SentryOptions sentryOptions) {
        init(sentryOptions, false);
    }

    private static void init(@NotNull final SentryOptions sentryOptions, boolean z10) {
        k1 k1VarA = lock.a();
        try {
            if (!sentryOptions.getClass().getName().equals("io.sentry.android.core.SentryAndroidOptions") && io.sentry.util.y.a()) {
                throw new IllegalArgumentException("You are running Android. Please, use SentryAndroid.init. " + sentryOptions.getClass().getName());
            }
            if (!preInitConfigurations(sentryOptions)) {
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            Boolean boolIsGlobalHubMode = sentryOptions.isGlobalHubMode();
            if (boolIsGlobalHubMode != null) {
                z10 = boolIsGlobalHubMode.booleanValue();
            }
            sentryOptions.getLogger().c(SentryLevel.INFO, "GlobalHubMode: '%s'", String.valueOf(z10));
            globalHubMode = z10;
            initFatalLogger(sentryOptions);
            if (io.sentry.util.o.a(globalScope.getOptions(), sentryOptions, isEnabled())) {
                if (isEnabled()) {
                    sentryOptions.getLogger().c(SentryLevel.WARNING, "Sentry has been already initialized. Previous configuration will be overwritten.", new Object[0]);
                }
                try {
                    sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.b5
                        @Override // java.lang.Runnable
                        public final void run() {
                            sentryOptions.loadLazyFields();
                        }
                    });
                } catch (RejectedExecutionException e10) {
                    sentryOptions.getLogger().b(SentryLevel.DEBUG, "Failed to call the executor. Lazy fields will not be loaded. Did you call Sentry.close()?", e10);
                }
                getCurrentScopes().b(true);
                c1 c1Var = globalScope;
                c1Var.replaceOptions(sentryOptions);
                rootScopes = new q4(new Scope(sentryOptions), new Scope(sentryOptions), c1Var, "Sentry.init");
                initLogger(sentryOptions);
                initForOpenTelemetryMaybe(sentryOptions);
                getScopesStorage().b(rootScopes);
                initConfigurations(sentryOptions);
                c1Var.bindClient(new l5(sentryOptions));
                if (sentryOptions.getExecutorService().isClosed()) {
                    sentryOptions.setExecutorService(new t6());
                }
                for (v1 v1Var : sentryOptions.getIntegrations()) {
                    try {
                        v1Var.c(r4.a(), sentryOptions);
                    } catch (Throwable th) {
                        sentryOptions.getLogger().b(SentryLevel.WARNING, "Failed to register the integration " + v1Var.getClass().getName(), th);
                    }
                }
                notifyOptionsObservers(sentryOptions);
                finalizePreviousSession(sentryOptions, r4.a());
                handleAppStartProfilingConfig(sentryOptions, sentryOptions.getExecutorService());
                w0 logger = sentryOptions.getLogger();
                SentryLevel sentryLevel = SentryLevel.DEBUG;
                logger.c(sentryLevel, "Using openTelemetryMode %s", sentryOptions.getOpenTelemetryMode());
                sentryOptions.getLogger().c(sentryLevel, "Using span factory %s", sentryOptions.getSpanFactory().getClass().getName());
                sentryOptions.getLogger().c(sentryLevel, "Using scopes storage %s", scopesStorage.getClass().getName());
            } else {
                sentryOptions.getLogger().c(SentryLevel.WARNING, "This init call has been ignored due to priority being too low.", new Object[0]);
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th2) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }
}
