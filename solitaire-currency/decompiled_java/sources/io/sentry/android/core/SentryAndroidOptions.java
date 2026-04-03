package io.sentry.android.core;

import androidx.media3.exoplayer.ExoPlayer;
import io.sentry.SentryOptions;
import io.sentry.protocol.SdkVersion;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryAndroidOptions extends SentryOptions {
    private boolean attachScreenshot;
    private boolean attachViewHierarchy;

    @Nullable
    private a beforeScreenshotCaptureCallback;

    @Nullable
    private a beforeViewHierarchyCaptureCallback;

    @Nullable
    private io.sentry.android.core.internal.util.v frameMetricsCollector;
    private boolean anrEnabled = true;
    private long anrTimeoutIntervalMillis = 5000;
    private boolean anrReportInDebug = false;
    private boolean enableActivityLifecycleBreadcrumbs = true;
    private boolean enableAppLifecycleBreadcrumbs = true;
    private boolean enableSystemEventBreadcrumbs = true;
    private boolean enableAppComponentBreadcrumbs = true;
    private boolean enableNetworkEventBreadcrumbs = true;
    private boolean enableAutoActivityLifecycleTracing = true;
    private boolean enableActivityLifecycleTracingAutoFinish = true;

    @NotNull
    private n1 debugImagesLoader = z1.a();
    private boolean collectAdditionalContext = true;
    private long startupCrashFlushTimeoutMillis = 5000;
    private final long startupCrashDurationThresholdMillis = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    private boolean enableFramesTracking = true;

    @Nullable
    private String nativeSdkName = null;
    private boolean enableRootCheck = true;
    private boolean enableNdk = true;

    @NotNull
    private w1 ndkHandlerStrategy = w1.SENTRY_HANDLER_STRATEGY_DEFAULT;
    private boolean enableScopeSync = true;
    private boolean enableAutoTraceIdGeneration = true;
    private boolean reportHistoricalAnrs = false;
    private boolean attachAnrThreadDump = false;
    private boolean enablePerformanceV2 = true;

    public interface a {
    }

    public SentryAndroidOptions() {
        setSentryClientName("sentry.java.android/8.14.0");
        setSdkVersion(createSdkVersion());
        setAttachServerName(false);
    }

    @NotNull
    private SdkVersion createSdkVersion() {
        SdkVersion sdkVersionUpdateSdkVersion = SdkVersion.updateSdkVersion(getSdkVersion(), "sentry.java.android", "8.14.0");
        sdkVersionUpdateSdkVersion.addPackage("maven:io.sentry:sentry-android-core", "8.14.0");
        return sdkVersionUpdateSdkVersion;
    }

    public void enableAllAutoBreadcrumbs(boolean z10) {
        this.enableActivityLifecycleBreadcrumbs = z10;
        this.enableAppComponentBreadcrumbs = z10;
        this.enableSystemEventBreadcrumbs = z10;
        this.enableAppLifecycleBreadcrumbs = z10;
        this.enableNetworkEventBreadcrumbs = z10;
        setEnableUserInteractionBreadcrumbs(z10);
    }

    public long getAnrTimeoutIntervalMillis() {
        return this.anrTimeoutIntervalMillis;
    }

    @Nullable
    public a getBeforeScreenshotCaptureCallback() {
        return null;
    }

    @Nullable
    public a getBeforeViewHierarchyCaptureCallback() {
        return null;
    }

    @NotNull
    public n1 getDebugImagesLoader() {
        return this.debugImagesLoader;
    }

    @ApiStatus.Internal
    @Nullable
    public io.sentry.android.core.internal.util.v getFrameMetricsCollector() {
        return this.frameMetricsCollector;
    }

    @ApiStatus.Internal
    @Nullable
    public String getNativeSdkName() {
        return this.nativeSdkName;
    }

    @ApiStatus.Internal
    public int getNdkHandlerStrategy() {
        return this.ndkHandlerStrategy.getValue();
    }

    @ApiStatus.Internal
    public long getStartupCrashDurationThresholdMillis() {
        return ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    }

    @ApiStatus.Internal
    long getStartupCrashFlushTimeoutMillis() {
        return this.startupCrashFlushTimeoutMillis;
    }

    public boolean isAnrEnabled() {
        return this.anrEnabled;
    }

    public boolean isAnrReportInDebug() {
        return this.anrReportInDebug;
    }

    public boolean isAttachAnrThreadDump() {
        return this.attachAnrThreadDump;
    }

    public boolean isAttachScreenshot() {
        return this.attachScreenshot;
    }

    public boolean isAttachViewHierarchy() {
        return this.attachViewHierarchy;
    }

    public boolean isCollectAdditionalContext() {
        return this.collectAdditionalContext;
    }

    public boolean isEnableActivityLifecycleBreadcrumbs() {
        return this.enableActivityLifecycleBreadcrumbs;
    }

    public boolean isEnableActivityLifecycleTracingAutoFinish() {
        return this.enableActivityLifecycleTracingAutoFinish;
    }

    public boolean isEnableAppComponentBreadcrumbs() {
        return this.enableAppComponentBreadcrumbs;
    }

    public boolean isEnableAppLifecycleBreadcrumbs() {
        return this.enableAppLifecycleBreadcrumbs;
    }

    public boolean isEnableAutoActivityLifecycleTracing() {
        return this.enableAutoActivityLifecycleTracing;
    }

    public boolean isEnableAutoTraceIdGeneration() {
        return this.enableAutoTraceIdGeneration;
    }

    public boolean isEnableFramesTracking() {
        return this.enableFramesTracking;
    }

    public boolean isEnableNdk() {
        return this.enableNdk;
    }

    public boolean isEnableNetworkEventBreadcrumbs() {
        return this.enableNetworkEventBreadcrumbs;
    }

    public boolean isEnablePerformanceV2() {
        return this.enablePerformanceV2;
    }

    public boolean isEnableRootCheck() {
        return this.enableRootCheck;
    }

    public boolean isEnableScopeSync() {
        return this.enableScopeSync;
    }

    public boolean isEnableSystemEventBreadcrumbs() {
        return this.enableSystemEventBreadcrumbs;
    }

    public boolean isReportHistoricalAnrs() {
        return this.reportHistoricalAnrs;
    }

    public void setAnrEnabled(boolean z10) {
        this.anrEnabled = z10;
    }

    public void setAnrReportInDebug(boolean z10) {
        this.anrReportInDebug = z10;
    }

    public void setAnrTimeoutIntervalMillis(long j10) {
        this.anrTimeoutIntervalMillis = j10;
    }

    public void setAttachAnrThreadDump(boolean z10) {
        this.attachAnrThreadDump = z10;
    }

    public void setAttachScreenshot(boolean z10) {
        this.attachScreenshot = z10;
    }

    public void setAttachViewHierarchy(boolean z10) {
        this.attachViewHierarchy = z10;
    }

    public void setCollectAdditionalContext(boolean z10) {
        this.collectAdditionalContext = z10;
    }

    public void setDebugImagesLoader(@NotNull n1 n1Var) {
        if (n1Var == null) {
            n1Var = z1.a();
        }
        this.debugImagesLoader = n1Var;
    }

    public void setEnableActivityLifecycleBreadcrumbs(boolean z10) {
        this.enableActivityLifecycleBreadcrumbs = z10;
    }

    public void setEnableActivityLifecycleTracingAutoFinish(boolean z10) {
        this.enableActivityLifecycleTracingAutoFinish = z10;
    }

    public void setEnableAppComponentBreadcrumbs(boolean z10) {
        this.enableAppComponentBreadcrumbs = z10;
    }

    public void setEnableAppLifecycleBreadcrumbs(boolean z10) {
        this.enableAppLifecycleBreadcrumbs = z10;
    }

    public void setEnableAutoActivityLifecycleTracing(boolean z10) {
        this.enableAutoActivityLifecycleTracing = z10;
    }

    public void setEnableAutoTraceIdGeneration(boolean z10) {
        this.enableAutoTraceIdGeneration = z10;
    }

    public void setEnableFramesTracking(boolean z10) {
        this.enableFramesTracking = z10;
    }

    public void setEnableNdk(boolean z10) {
        this.enableNdk = z10;
    }

    public void setEnableNetworkEventBreadcrumbs(boolean z10) {
        this.enableNetworkEventBreadcrumbs = z10;
    }

    public void setEnablePerformanceV2(boolean z10) {
        this.enablePerformanceV2 = z10;
    }

    public void setEnableRootCheck(boolean z10) {
        this.enableRootCheck = z10;
    }

    public void setEnableScopeSync(boolean z10) {
        this.enableScopeSync = z10;
    }

    public void setEnableSystemEventBreadcrumbs(boolean z10) {
        this.enableSystemEventBreadcrumbs = z10;
    }

    @ApiStatus.Internal
    public void setFrameMetricsCollector(@Nullable io.sentry.android.core.internal.util.v vVar) {
        this.frameMetricsCollector = vVar;
    }

    @ApiStatus.Internal
    public void setNativeHandlerStrategy(@NotNull w1 w1Var) {
        this.ndkHandlerStrategy = w1Var;
    }

    @ApiStatus.Internal
    public void setNativeSdkName(@Nullable String str) {
        this.nativeSdkName = str;
    }

    public void setReportHistoricalAnrs(boolean z10) {
        this.reportHistoricalAnrs = z10;
    }

    @TestOnly
    void setStartupCrashFlushTimeoutMillis(long j10) {
        this.startupCrashFlushTimeoutMillis = j10;
    }

    public void setBeforeScreenshotCaptureCallback(@NotNull a aVar) {
    }

    public void setBeforeViewHierarchyCaptureCallback(@NotNull a aVar) {
    }
}
