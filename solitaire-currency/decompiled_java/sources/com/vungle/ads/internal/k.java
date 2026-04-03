package com.vungle.ads.internal;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.g0;
import com.vungle.ads.internal.model.g;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.j1;
import com.vungle.ads.o;
import com.vungle.ads.t0;
import com.vungle.ads.v1;
import com.vungle.ads.w1;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.o0;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ConfigManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {
    private static final int CONFIG_ALL_DATA = 2;
    private static final int CONFIG_LAST_VALIDATED_TIMESTAMP_ONLY = 1;
    public static final long CONFIG_LAST_VALIDATE_TS_DEFAULT = -1;
    private static final int CONFIG_NOT_AVAILABLE = 0;
    private static final int DEFAULT_SESSION_TIMEOUT_SECONDS = 900;
    private static final int DEFAULT_SIGNALS_SESSION_TIMEOUT_SECONDS = 1800;

    @NotNull
    public static final String TAG = "ConfigManager";
    private static String applicationId;

    @Nullable
    private static com.vungle.ads.internal.model.g config;

    @Nullable
    private static String configExt;

    @Nullable
    private static g.f endpoints;

    @Nullable
    private static List<com.vungle.ads.internal.model.j> placements;

    @NotNull
    public static final k INSTANCE = new k();

    @NotNull
    private static final kotlinx.serialization.json.a json = kotlinx.serialization.json.m.b(null, e.INSTANCE, 1, null);

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class a extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.network.i> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.i, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.network.i invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.network.i.class);
        }
    }

    /* JADX INFO: compiled from: ConfigManager.kt */
    public static final class b implements com.vungle.ads.internal.network.b<com.vungle.ads.internal.model.g> {
        final /* synthetic */ Context $context;
        final /* synthetic */ w1 $initRequestToResponseMetric;
        final /* synthetic */ h9.l<Boolean, k0> $onComplete;

        /* JADX WARN: Multi-variable type inference failed */
        b(w1 w1Var, Context context, h9.l<? super Boolean, k0> lVar) {
            this.$initRequestToResponseMetric = w1Var;
            this.$context = context;
            this.$onComplete = lVar;
        }

        @Override // com.vungle.ads.internal.network.b
        public void onFailure(@Nullable com.vungle.ads.internal.network.a<com.vungle.ads.internal.model.g> aVar, @Nullable Throwable th) {
            this.$initRequestToResponseMetric.markEnd();
            com.vungle.ads.o.INSTANCE.logMetric$vungle_ads_release((t0) this.$initRequestToResponseMetric, (14 & 2) != 0 ? null : null, (14 & 4) != 0 ? null : null, (14 & 8) != 0 ? null : null, (14 & 16) != 0 ? null : com.vungle.ads.internal.network.i.Companion.getBASE_URL$vungle_ads_release());
            new g0().logErrorNoReturnValue$vungle_ads_release();
            p.a aVar2 = com.vungle.ads.internal.util.p.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("Error while fetching config: ");
            sb.append(th != null ? th.getMessage() : null);
            aVar2.e(k.TAG, sb.toString());
            this.$onComplete.invoke(Boolean.FALSE);
        }

        @Override // com.vungle.ads.internal.network.b
        public void onResponse(@Nullable com.vungle.ads.internal.network.a<com.vungle.ads.internal.model.g> aVar, @Nullable com.vungle.ads.internal.network.d<com.vungle.ads.internal.model.g> dVar) {
            this.$initRequestToResponseMetric.markEnd();
            com.vungle.ads.o.INSTANCE.logMetric$vungle_ads_release((t0) this.$initRequestToResponseMetric, (14 & 2) != 0 ? null : null, (14 & 4) != 0 ? null : null, (14 & 8) != 0 ? null : null, (14 & 16) != 0 ? null : com.vungle.ads.internal.network.i.Companion.getBASE_URL$vungle_ads_release());
            if (dVar == null || !dVar.isSuccessful() || dVar.body() == null) {
                new g0().logErrorNoReturnValue$vungle_ads_release();
                return;
            }
            k.INSTANCE.initWithConfig$vungle_ads_release(this.$context, dVar.body(), false, new v1(Sdk$SDKMetric.b.CONFIG_LOADED_FROM_INIT));
            this.$onComplete.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class c extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.persistence.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.persistence.b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.persistence.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.persistence.b.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class d extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.omsdk.c> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.omsdk.c, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.omsdk.c invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.omsdk.c.class);
        }
    }

    /* JADX INFO: compiled from: ConfigManager.kt */
    static final class e extends kotlin.jvm.internal.v implements h9.l<kotlinx.serialization.json.c, k0> {
        public static final e INSTANCE = new e();

        e() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            kotlin.jvm.internal.t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class f extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.persistence.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.persistence.b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.persistence.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.persistence.b.class);
        }
    }

    private k() {
    }

    /* JADX INFO: renamed from: fetchConfigAsync$lambda-0, reason: not valid java name */
    private static final com.vungle.ads.internal.network.i m4050fetchConfigAsync$lambda0(v8.l<com.vungle.ads.internal.network.i> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: initWithConfig$lambda-2, reason: not valid java name */
    private static final com.vungle.ads.internal.persistence.b m4051initWithConfig$lambda2(v8.l<com.vungle.ads.internal.persistence.b> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: initWithConfig$lambda-5, reason: not valid java name */
    private static final com.vungle.ads.internal.omsdk.c m4052initWithConfig$lambda5(v8.l<com.vungle.ads.internal.omsdk.c> lVar) {
        return lVar.getValue();
    }

    public static /* synthetic */ void initWithConfig$vungle_ads_release$default(k kVar, Context context, com.vungle.ads.internal.model.g gVar, boolean z10, v1 v1Var, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            v1Var = null;
        }
        kVar.initWithConfig$vungle_ads_release(context, gVar, z10, v1Var);
    }

    /* JADX INFO: renamed from: updateConfigExtension$lambda-1, reason: not valid java name */
    private static final com.vungle.ads.internal.persistence.b m4053updateConfigExtension$lambda1(v8.l<com.vungle.ads.internal.persistence.b> lVar) {
        return lVar.getValue();
    }

    public static /* synthetic */ boolean validateEndpoints$vungle_ads_release$default(k kVar, g.f fVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fVar = endpoints;
        }
        return kVar.validateEndpoints$vungle_ads_release(fVar);
    }

    public final long afterClickDuration() {
        g.b autoRedirect;
        Long afterClickDuration;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (autoRedirect = gVar.getAutoRedirect()) == null || (afterClickDuration = autoRedirect.getAfterClickDuration()) == null) {
            return Long.MAX_VALUE;
        }
        return afterClickDuration.longValue();
    }

    public final boolean allowAutoRedirects() {
        g.b autoRedirect;
        Boolean allowAutoRedirect;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (autoRedirect = gVar.getAutoRedirect()) == null || (allowAutoRedirect = autoRedirect.getAllowAutoRedirect()) == null) {
            return false;
        }
        return allowAutoRedirect.booleanValue();
    }

    @VisibleForTesting
    public final int checkConfigPayload$vungle_ads_release(@Nullable com.vungle.ads.internal.model.g gVar) {
        if (gVar == null || gVar.getConfigLastValidatedTimestamp() == null) {
            return 0;
        }
        Long configLastValidatedTimestamp = gVar.getConfigLastValidatedTimestamp();
        if (configLastValidatedTimestamp != null && configLastValidatedTimestamp.longValue() == -1) {
            return 0;
        }
        return gVar.getEndpoints() == null ? 1 : 2;
    }

    @VisibleForTesting
    public final void clearConfig$vungle_ads_release() {
        endpoints = null;
        placements = null;
        config = null;
    }

    public final long configLastValidatedTimestamp() {
        Long configLastValidatedTimestamp;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (configLastValidatedTimestamp = gVar.getConfigLastValidatedTimestamp()) == null) {
            return -1L;
        }
        return configLastValidatedTimestamp.longValue();
    }

    public final void fetchConfigAsync$vungle_ads_release(@NotNull Context context, @NotNull h9.l<? super Boolean, k0> onComplete) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(onComplete, "onComplete");
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.l lVarB = v8.n.b(v8.p.f35201a, new a(context));
        try {
            w1 w1Var = new w1(Sdk$SDKMetric.b.INIT_REQUEST_TO_RESPONSE_DURATION_MS);
            w1Var.markStart();
            com.vungle.ads.internal.network.a<com.vungle.ads.internal.model.g> aVarConfig = m4050fetchConfigAsync$lambda0(lVarB).config();
            if (aVarConfig != null) {
                aVarConfig.enqueue(new b(w1Var, context, onComplete));
            }
        } catch (Throwable th) {
            if (th instanceof UnknownHostException ? true : th instanceof SecurityException) {
                new j1().logErrorNoReturnValue$vungle_ads_release();
            } else {
                new g0().logErrorNoReturnValue$vungle_ads_release();
            }
            onComplete.invoke(Boolean.FALSE);
        }
    }

    public final boolean fpdEnabled() {
        Boolean fpdEnabled;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (fpdEnabled = gVar.getFpdEnabled()) == null) {
            return true;
        }
        return fpdEnabled.booleanValue();
    }

    @NotNull
    public final String getAdsEndpoint() {
        g.f fVar = endpoints;
        String adsEndpoint = fVar != null ? fVar.getAdsEndpoint() : null;
        String str = adsEndpoint == null || adsEndpoint.length() == 0 ? null : adsEndpoint;
        return str == null ? l.DEFAULT_ADS_ENDPOINT : str;
    }

    @Nullable
    public final com.vungle.ads.internal.model.g getCachedConfig(@NotNull com.vungle.ads.internal.persistence.b filePreferences, @NotNull String appId) {
        Long refreshTime;
        kotlin.jvm.internal.t.i(filePreferences, "filePreferences");
        kotlin.jvm.internal.t.i(appId, "appId");
        try {
            String string = filePreferences.getString("config_app_id");
            if (!(string == null || string.length() == 0) && p9.q.x(string, appId, true)) {
                String string2 = filePreferences.getString("config_response");
                if (string2 == null) {
                    return null;
                }
                long j10 = filePreferences.getLong("config_update_time", 0L);
                kotlinx.serialization.json.a aVar = json;
                KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), o0.j(com.vungle.ads.internal.model.g.class));
                kotlin.jvm.internal.t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                com.vungle.ads.internal.model.g gVar = (com.vungle.ads.internal.model.g) aVar.b(kSerializerB, string2);
                g.e configSettings = gVar.getConfigSettings();
                if (((configSettings == null || (refreshTime = configSettings.getRefreshTime()) == null) ? -1L : refreshTime.longValue()) + j10 < System.currentTimeMillis()) {
                    com.vungle.ads.internal.util.p.Companion.w(TAG, "cache config expired. re-config");
                    return null;
                }
                com.vungle.ads.internal.util.p.Companion.w(TAG, "use cache config.");
                return gVar;
            }
            com.vungle.ads.internal.util.p.Companion.w(TAG, "app id mismatch, re-config");
            return null;
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Error while parsing cached config: " + e10.getMessage());
            return null;
        }
    }

    public final int getCleverCacheDiskPercentage() {
        g.c cleverCache;
        Integer diskPercentage;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (cleverCache = gVar.getCleverCache()) == null || (diskPercentage = cleverCache.getDiskPercentage()) == null) {
            return 3;
        }
        return diskPercentage.intValue();
    }

    public final long getCleverCacheDiskSize() {
        g.c cleverCache;
        Long diskSize;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (cleverCache = gVar.getCleverCache()) == null || (diskSize = cleverCache.getDiskSize()) == null) {
            return 1048576000L;
        }
        long j10 = 1024;
        return diskSize.longValue() * j10 * j10;
    }

    @NotNull
    public final String getConfigExtension() {
        String str = configExt;
        return str == null ? "" : str;
    }

    @NotNull
    public final String getErrorLoggingEndpoint() {
        g.f fVar = endpoints;
        String errorLogsEndpoint = fVar != null ? fVar.getErrorLogsEndpoint() : null;
        String str = errorLogsEndpoint == null || errorLogsEndpoint.length() == 0 ? null : errorLogsEndpoint;
        return str == null ? l.DEFAULT_ERROR_LOGS_ENDPOINT : str;
    }

    @Nullable
    public final String getGDPRButtonAccept() {
        g.j userPrivacy;
        g.C0522g gdpr;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (userPrivacy = gVar.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null) {
            return null;
        }
        return gdpr.getButtonAccept();
    }

    @Nullable
    public final String getGDPRButtonDeny() {
        g.j userPrivacy;
        g.C0522g gdpr;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (userPrivacy = gVar.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null) {
            return null;
        }
        return gdpr.getButtonDeny();
    }

    @Nullable
    public final String getGDPRConsentMessage() {
        g.j userPrivacy;
        g.C0522g gdpr;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (userPrivacy = gVar.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null) {
            return null;
        }
        return gdpr.getConsentMessage();
    }

    @NotNull
    public final String getGDPRConsentMessageVersion() {
        g.j userPrivacy;
        g.C0522g gdpr;
        String consentMessageVersion;
        com.vungle.ads.internal.model.g gVar = config;
        return (gVar == null || (userPrivacy = gVar.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null || (consentMessageVersion = gdpr.getConsentMessageVersion()) == null) ? "" : consentMessageVersion;
    }

    @Nullable
    public final String getGDPRConsentTitle() {
        g.j userPrivacy;
        g.C0522g gdpr;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (userPrivacy = gVar.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null) {
            return null;
        }
        return gdpr.getConsentTitle();
    }

    public final boolean getGDPRIsCountryDataProtected() {
        g.j userPrivacy;
        g.C0522g gdpr;
        Boolean boolIsCountryDataProtected;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (userPrivacy = gVar.getUserPrivacy()) == null || (gdpr = userPrivacy.getGdpr()) == null || (boolIsCountryDataProtected = gdpr.isCountryDataProtected()) == null) {
            return false;
        }
        return boolIsCountryDataProtected.booleanValue();
    }

    public final int getLogLevel() {
        g.i logMetricsSettings;
        Integer errorLogLevel;
        com.vungle.ads.internal.model.g gVar = config;
        return (gVar == null || (logMetricsSettings = gVar.getLogMetricsSettings()) == null || (errorLogLevel = logMetricsSettings.getErrorLogLevel()) == null) ? o.a.ERROR_LOG_LEVEL_ERROR.getLevel() : errorLogLevel.intValue();
    }

    public final boolean getMetricsEnabled() {
        g.i logMetricsSettings;
        Boolean metricsEnabled;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (logMetricsSettings = gVar.getLogMetricsSettings()) == null || (metricsEnabled = logMetricsSettings.getMetricsEnabled()) == null) {
            return false;
        }
        return metricsEnabled.booleanValue();
    }

    @NotNull
    public final String getMetricsEndpoint() {
        g.f fVar = endpoints;
        String metricsEndpoint = fVar != null ? fVar.getMetricsEndpoint() : null;
        String str = metricsEndpoint == null || metricsEndpoint.length() == 0 ? null : metricsEndpoint;
        return str == null ? l.DEFAULT_METRICS_ENDPOINT : str;
    }

    @Nullable
    public final String getMraidEndpoint() {
        g.f fVar = endpoints;
        if (fVar != null) {
            return fVar.getMraidEndpoint();
        }
        return null;
    }

    @NotNull
    public final String getMraidJsVersion() {
        String mraidEndpoint = getMraidEndpoint();
        if (mraidEndpoint != null) {
            String str = "mraid_" + Uri.parse(mraidEndpoint).getLastPathSegment();
            if (str != null) {
                return str;
            }
        }
        return "mraid_1";
    }

    @Nullable
    public final com.vungle.ads.internal.model.j getPlacement(@NotNull String id) {
        kotlin.jvm.internal.t.i(id, "id");
        List<com.vungle.ads.internal.model.j> list = placements;
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (kotlin.jvm.internal.t.d(((com.vungle.ads.internal.model.j) next).getReferenceId(), id)) {
                obj = next;
                break;
            }
        }
        return (com.vungle.ads.internal.model.j) obj;
    }

    @Nullable
    public final String getRiEndpoint() {
        g.f fVar = endpoints;
        if (fVar != null) {
            return fVar.getRiEndpoint();
        }
        return null;
    }

    public final long getSessionTimeout() {
        Integer sessionTimeout;
        com.vungle.ads.internal.model.g gVar = config;
        return ((long) ((gVar == null || (sessionTimeout = gVar.getSessionTimeout()) == null) ? 900 : sessionTimeout.intValue())) * 1000;
    }

    public final long getSignalsSessionTimeout() {
        Integer signalSessionTimeout;
        com.vungle.ads.internal.model.g gVar = config;
        return ((long) ((gVar == null || (signalSessionTimeout = gVar.getSignalSessionTimeout()) == null) ? DEFAULT_SIGNALS_SESSION_TIMEOUT_SECONDS : signalSessionTimeout.intValue())) * 1000;
    }

    @Nullable
    public final g.h.c getTcfStatus() {
        g.j userPrivacy;
        g.h iab;
        g.h.c.a aVar = g.h.c.Companion;
        com.vungle.ads.internal.model.g gVar = config;
        return aVar.fromRawValue((gVar == null || (userPrivacy = gVar.getUserPrivacy()) == null || (iab = userPrivacy.getIab()) == null) ? null : iab.getTcfStatus());
    }

    public final synchronized void initWithConfig$vungle_ads_release(@NotNull Context context, @Nullable com.vungle.ads.internal.model.g gVar, boolean z10, @Nullable v1 v1Var) {
        kotlin.jvm.internal.t.i(context, "context");
        try {
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            v8.p pVar = v8.p.f35201a;
            v8.l lVarB = v8.n.b(pVar, new c(context));
            int iCheckConfigPayload$vungle_ads_release = checkConfigPayload$vungle_ads_release(gVar);
            if (iCheckConfigPayload$vungle_ads_release == 0) {
                com.vungle.ads.internal.util.p.Companion.e(TAG, "Config is not available.");
                return;
            }
            if (iCheckConfigPayload$vungle_ads_release == 1) {
                if (!z10 && gVar != null) {
                    Long configLastValidatedTimestamp = gVar.getConfigLastValidatedTimestamp();
                    long jLongValue = configLastValidatedTimestamp != null ? configLastValidatedTimestamp.longValue() : -1L;
                    com.vungle.ads.internal.model.g gVar2 = config;
                    if (gVar2 != null) {
                        gVar2.setConfigLastValidatedTimestamp(Long.valueOf(jLongValue));
                    }
                    com.vungle.ads.internal.model.g gVar3 = config;
                    if (gVar3 != null) {
                        INSTANCE.updateCachedConfig(gVar3, m4051initWithConfig$lambda2(lVarB));
                    }
                }
                return;
            }
            config = gVar;
            endpoints = gVar != null ? gVar.getEndpoints() : null;
            placements = gVar != null ? gVar.getPlacements() : null;
            com.vungle.ads.o oVar = com.vungle.ads.o.INSTANCE;
            oVar.updateErrorLevelAndMetricEnabled$vungle_ads_release(getLogLevel(), getMetricsEnabled());
            if (!z10 && gVar != null) {
                updateCachedConfig(gVar, m4051initWithConfig$lambda2(lVarB));
                String configExtension = gVar.getConfigExtension();
                if (configExtension != null) {
                    INSTANCE.updateConfigExtension$vungle_ads_release(context, configExtension);
                }
            }
            if (omEnabled()) {
                m4052initWithConfig$lambda5(v8.n.b(pVar, new d(context))).init();
            }
            if (v1Var != null) {
                oVar.logMetric$vungle_ads_release(v1Var, (30 & 2) != 0 ? null : null, (30 & 4) != 0 ? null : null, (30 & 8) != 0 ? null : null, (30 & 16) != 0 ? null : null);
            }
            q7.c.INSTANCE.updateDisableAdId(shouldDisableAdId());
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Error while validating config: " + e10.getMessage());
        }
    }

    public final boolean isCacheableAssetsRequired() {
        Boolean boolIsCacheableAssetsRequired;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (boolIsCacheableAssetsRequired = gVar.isCacheableAssetsRequired()) == null) {
            return false;
        }
        return boolIsCacheableAssetsRequired.booleanValue();
    }

    public final boolean isCleverCacheEnabled() {
        g.c cleverCache;
        Boolean enabled;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (cleverCache = gVar.getCleverCache()) == null || (enabled = cleverCache.getEnabled()) == null) {
            return false;
        }
        return enabled.booleanValue();
    }

    public final boolean isReportIncentivizedEnabled() {
        Boolean boolIsReportIncentivizedEnabled;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (boolIsReportIncentivizedEnabled = gVar.isReportIncentivizedEnabled()) == null) {
            return false;
        }
        return boolIsReportIncentivizedEnabled.booleanValue();
    }

    public final boolean omEnabled() {
        g.k viewAbility;
        Boolean om;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (viewAbility = gVar.getViewAbility()) == null || (om = viewAbility.getOm()) == null) {
            return false;
        }
        return om.booleanValue();
    }

    @Nullable
    public final List<com.vungle.ads.internal.model.j> placements() {
        return placements;
    }

    public final boolean rtaDebuggingEnabled() {
        Boolean rtaDebugging;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (rtaDebugging = gVar.getRtaDebugging()) == null) {
            return false;
        }
        return rtaDebugging.booleanValue();
    }

    public final void setAppId$vungle_ads_release(@NotNull String applicationId2) {
        kotlin.jvm.internal.t.i(applicationId2, "applicationId");
        applicationId = applicationId2;
    }

    public final boolean shouldDisableAdId() {
        Boolean disableAdId;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (disableAdId = gVar.getDisableAdId()) == null) {
            return true;
        }
        return disableAdId.booleanValue();
    }

    public final boolean signalsDisabled() {
        Boolean signalsDisabled;
        com.vungle.ads.internal.model.g gVar = config;
        if (gVar == null || (signalsDisabled = gVar.getSignalsDisabled()) == null) {
            return false;
        }
        return signalsDisabled.booleanValue();
    }

    public final void updateCachedConfig(@NotNull com.vungle.ads.internal.model.g config2, @NotNull com.vungle.ads.internal.persistence.b filePreferences) {
        kotlin.jvm.internal.t.i(config2, "config");
        kotlin.jvm.internal.t.i(filePreferences, "filePreferences");
        try {
            String str = applicationId;
            if (str == null) {
                kotlin.jvm.internal.t.A("applicationId");
                str = null;
            }
            filePreferences.put("config_app_id", str);
            filePreferences.put("config_update_time", System.currentTimeMillis());
            kotlinx.serialization.json.a aVar = json;
            KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), o0.j(com.vungle.ads.internal.model.g.class));
            kotlin.jvm.internal.t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            filePreferences.put("config_response", aVar.c(kSerializerB, config2));
            filePreferences.apply();
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Exception: " + e10.getMessage() + " for updating cached config");
        }
    }

    @VisibleForTesting
    public final void updateConfigExtension$vungle_ads_release(@NotNull Context context, @NotNull String ext) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(ext, "ext");
        configExt = ext;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        m4053updateConfigExtension$lambda1(v8.n.b(v8.p.f35201a, new f(context))).put("config_extension", ext).apply();
    }

    @VisibleForTesting
    public final boolean validateConfig$vungle_ads_release(@Nullable com.vungle.ads.internal.model.g gVar) {
        return ((gVar != null ? gVar.getEndpoints() : null) == null || !validateEndpoints$vungle_ads_release(gVar.getEndpoints()) || gVar.getPlacements() == null) ? false : true;
    }

    @VisibleForTesting
    public final boolean validateEndpoints$vungle_ads_release(@Nullable g.f fVar) {
        boolean z10;
        String adsEndpoint = fVar != null ? fVar.getAdsEndpoint() : null;
        if (adsEndpoint == null || adsEndpoint.length() == 0) {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(122, "The ads endpoint was not provided in the config.", (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
            z10 = false;
        } else {
            z10 = true;
        }
        String riEndpoint = fVar != null ? fVar.getRiEndpoint() : null;
        if (riEndpoint == null || riEndpoint.length() == 0) {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(123, "The ri endpoint was not provided in the config.", (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
        }
        String mraidEndpoint = fVar != null ? fVar.getMraidEndpoint() : null;
        if (mraidEndpoint == null || mraidEndpoint.length() == 0) {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(130, "The mraid endpoint was not provided in the config.", (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
            z10 = false;
        }
        String metricsEndpoint = fVar != null ? fVar.getMetricsEndpoint() : null;
        if (metricsEndpoint == null || metricsEndpoint.length() == 0) {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(125, "The metrics endpoint was not provided in the config.", (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
        }
        String errorLogsEndpoint = fVar != null ? fVar.getErrorLogsEndpoint() : null;
        if (errorLogsEndpoint == null || errorLogsEndpoint.length() == 0) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "The error logging endpoint was not provided in the config.");
        }
        return z10;
    }
}
