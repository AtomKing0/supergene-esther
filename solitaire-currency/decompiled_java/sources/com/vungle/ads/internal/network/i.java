package com.vungle.ads.internal.network;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.security.NetworkSecurityPolicy;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.URLUtil;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.ironsource.nb;
import com.unity3d.services.UnityAdsConstants;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.VungleAds;
import com.vungle.ads.internal.load.d;
import com.vungle.ads.internal.model.f;
import com.vungle.ads.internal.model.h;
import com.vungle.ads.internal.protos.Sdk$MetricBatch;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKErrorBatch;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.o;
import com.vungle.ads.w1;
import com.vungle.ads.z1;
import ga.a0;
import ga.b0;
import ga.c0;
import ga.d0;
import ga.e0;
import ga.w;
import ga.x;
import ga.z;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.u;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import q7.c;
import ua.o;
import v8.k0;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: VungleApiClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    @NotNull
    private static final String BASE_URL;

    @NotNull
    public static final b Companion;

    @NotNull
    private static final String MANUFACTURER_AMAZON = "Amazon";

    @NotNull
    private static final String TAG = "VungleApiClient";

    @NotNull
    private static String headerUa;

    @NotNull
    private static final kotlinx.serialization.json.a json;

    @NotNull
    private static final Set<w> logInterceptors;

    @NotNull
    private static final Set<w> networkInterceptors;

    @Nullable
    private com.vungle.ads.internal.model.c advertisingInfo;

    @NotNull
    private VungleApi api;

    @Nullable
    private com.vungle.ads.internal.model.d appBody;

    @NotNull
    private final Context applicationContext;

    @Nullable
    private com.vungle.ads.internal.model.h baseDeviceInfo;

    @NotNull
    private final com.vungle.ads.internal.persistence.b filePreferences;

    @NotNull
    private VungleApi gzipApi;

    @Nullable
    private Boolean isGooglePlayServicesAvailable;

    @NotNull
    private final com.vungle.ads.internal.platform.d platform;

    @NotNull
    private w responseInterceptor;

    @NotNull
    private Map<String, Long> retryAfterDataMap;

    @NotNull
    private final l signalManager$delegate;

    @Nullable
    private String uaString;

    /* JADX INFO: compiled from: VungleApiClient.kt */
    static final class a extends v implements h9.l<kotlinx.serialization.json.c, k0> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
        }
    }

    /* JADX INFO: compiled from: VungleApiClient.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String defaultHeader() {
            StringBuilder sb = new StringBuilder();
            sb.append(t.d("Amazon", Build.MANUFACTURER) ? "VungleAmazon/" : "VungleDroid/");
            sb.append("7.4.2");
            return sb.toString();
        }

        @NotNull
        public final String getBASE_URL$vungle_ads_release() {
            return i.BASE_URL;
        }

        @NotNull
        public final String getHeaderUa() {
            return i.headerUa;
        }

        public final void reset$vungle_ads_release() {
            setHeaderUa(defaultHeader());
        }

        public final void setHeaderUa(@NotNull String str) {
            t.i(str, "<set-?>");
            i.headerUa = str;
        }
    }

    /* JADX INFO: compiled from: VungleApiClient.kt */
    public static final class c implements w {

        @NotNull
        private static final String CONTENT_ENCODING = "Content-Encoding";

        @NotNull
        public static final a Companion = new a(null);

        @NotNull
        private static final String GZIP = "gzip";

        /* JADX INFO: compiled from: VungleApiClient.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(k kVar) {
                this();
            }
        }

        /* JADX INFO: compiled from: VungleApiClient.kt */
        public static final class b extends c0 {
            final /* synthetic */ ua.c $output;
            final /* synthetic */ c0 $requestBody;

            b(c0 c0Var, ua.c cVar) {
                this.$requestBody = c0Var;
                this.$output = cVar;
            }

            @Override // ga.c0
            public long contentLength() {
                return this.$output.size();
            }

            @Override // ga.c0
            @Nullable
            public x contentType() {
                return this.$requestBody.contentType();
            }

            @Override // ga.c0
            public void writeTo(@NotNull ua.d sink) throws IOException {
                t.i(sink, "sink");
                sink.I(this.$output.M0());
            }
        }

        private final c0 gzip(c0 c0Var) throws IOException {
            ua.c cVar = new ua.c();
            ua.d dVarC = ua.k0.c(new o(cVar));
            c0Var.writeTo(dVarC);
            dVarC.close();
            return new b(c0Var, cVar);
        }

        @Override // ga.w
        @NotNull
        public d0 intercept(@NotNull w.a chain) throws IOException {
            t.i(chain, "chain");
            b0 b0VarA = chain.a();
            c0 c0VarA = b0VarA.a();
            return (c0VarA == null || b0VarA.d(CONTENT_ENCODING) != null) ? chain.b(b0VarA) : chain.b(b0VarA.i().g(CONTENT_ENCODING, GZIP).i(b0VarA.h(), gzip(c0VarA)).b());
        }
    }

    /* JADX INFO: compiled from: VungleApiClient.kt */
    public static final class d extends ProxySelector {
        d() {
        }

        @Override // java.net.ProxySelector
        public void connectFailed(@Nullable URI uri, @Nullable SocketAddress socketAddress, @Nullable IOException iOException) {
            try {
                ProxySelector.getDefault().connectFailed(uri, socketAddress, iOException);
            } catch (Exception unused) {
            }
        }

        @Override // java.net.ProxySelector
        @NotNull
        public List<Proxy> select(@Nullable URI uri) {
            try {
                List<Proxy> listSelect = ProxySelector.getDefault().select(uri);
                t.h(listSelect, "{\n                      …ri)\n                    }");
                return listSelect;
            } catch (Exception unused) {
                return u.e(Proxy.NO_PROXY);
            }
        }
    }

    /* JADX INFO: compiled from: VungleApiClient.kt */
    public static final class e implements Consumer<String> {
        final /* synthetic */ w1 $uaMetric;
        final /* synthetic */ i this$0;

        e(w1 w1Var, i iVar) {
            this.$uaMetric = w1Var;
            this.this$0 = iVar;
        }

        @Override // androidx.core.util.Consumer
        public void accept(@Nullable String str) {
            if (str == null) {
                p.Companion.e(i.TAG, "Cannot Get UserAgent. Setting Default Device UserAgent");
                com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(7, "Fail to get user agent.", (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
            } else {
                this.$uaMetric.markEnd();
                com.vungle.ads.o.INSTANCE.logMetric$vungle_ads_release(this.$uaMetric.getMetricType(), (34 & 2) != 0 ? 0L : this.$uaMetric.calculateIntervalDuration(), (34 & 4) != 0 ? null : null, (34 & 8) != 0 ? null : null, (34 & 16) != 0 ? null : null, (34 & 32) == 0 ? null : null);
                this.this$0.uaString = str;
            }
        }
    }

    /* JADX INFO: compiled from: VungleApiClient.kt */
    public static final class f implements com.vungle.ads.internal.network.b<Void> {
        final /* synthetic */ o.b $requestListener;

        f(o.b bVar) {
            this.$requestListener = bVar;
        }

        @Override // com.vungle.ads.internal.network.b
        public void onFailure(@Nullable com.vungle.ads.internal.network.a<Void> aVar, @Nullable Throwable th) {
            this.$requestListener.onFailure();
        }

        @Override // com.vungle.ads.internal.network.b
        public void onResponse(@Nullable com.vungle.ads.internal.network.a<Void> aVar, @Nullable com.vungle.ads.internal.network.d<Void> dVar) {
            this.$requestListener.onSuccess();
        }
    }

    /* JADX INFO: compiled from: VungleApiClient.kt */
    public static final class g implements com.vungle.ads.internal.network.b<Void> {
        final /* synthetic */ o.b $requestListener;

        g(o.b bVar) {
            this.$requestListener = bVar;
        }

        @Override // com.vungle.ads.internal.network.b
        public void onFailure(@Nullable com.vungle.ads.internal.network.a<Void> aVar, @Nullable Throwable th) {
            this.$requestListener.onFailure();
        }

        @Override // com.vungle.ads.internal.network.b
        public void onResponse(@Nullable com.vungle.ads.internal.network.a<Void> aVar, @Nullable com.vungle.ads.internal.network.d<Void> dVar) {
            this.$requestListener.onSuccess();
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.network.i$i, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class C0524i extends v implements h9.a<com.vungle.ads.internal.signals.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0524i(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.signals.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.signals.b.class);
        }
    }

    static {
        b bVar = new b(null);
        Companion = bVar;
        BASE_URL = "https://config.ads.vungle.com/";
        headerUa = bVar.defaultHeader();
        networkInterceptors = new HashSet();
        logInterceptors = new HashSet();
        json = m.b(null, a.INSTANCE, 1, null);
    }

    public i(@NotNull Context applicationContext, @NotNull com.vungle.ads.internal.platform.d platform, @NotNull com.vungle.ads.internal.persistence.b filePreferences) {
        t.i(applicationContext, "applicationContext");
        t.i(platform, "platform");
        t.i(filePreferences, "filePreferences");
        this.applicationContext = applicationContext;
        this.platform = platform;
        this.filePreferences = filePreferences;
        this.uaString = System.getProperty("http.agent");
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.signalManager$delegate = n.b(v8.p.f35201a, new C0524i(applicationContext));
        this.retryAfterDataMap = new ConcurrentHashMap();
        this.responseInterceptor = new w() { // from class: com.vungle.ads.internal.network.h
            @Override // ga.w
            public final d0 intercept(w.a aVar) {
                return i.m4068responseInterceptor$lambda0(this.f24356a, aVar);
            }
        };
        z.a aVarK = new z.a().a(this.responseInterceptor).K(new d());
        z zVarB = aVarK.b();
        z zVarB2 = aVarK.a(new c()).b();
        this.api = new j(zVarB);
        this.gzipApi = new j(zVarB2);
    }

    private final String bodyToString(c0 c0Var) {
        try {
            ua.c cVar = new ua.c();
            if (c0Var == null) {
                return "";
            }
            c0Var.writeTo(cVar);
            return cVar.K0();
        } catch (Exception unused) {
            return "";
        }
    }

    private final d0 defaultErrorResponse(b0 b0Var) {
        return new d0.a().s(b0Var).g(500).q(a0.HTTP_1_1).n("Server is busy").b(e0.Companion.e("{\"Error\":\"Server is busy\"}", x.f26237e.b("application/json; charset=utf-8"))).c();
    }

    private final com.vungle.ads.internal.model.h getBasicDeviceBody(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        t.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        String MANUFACTURER = Build.MANUFACTURER;
        t.h(MANUFACTURER, "MANUFACTURER");
        String MODEL = Build.MODEL;
        t.h(MODEL, "MODEL");
        String RELEASE = Build.VERSION.RELEASE;
        t.h(RELEASE, "RELEASE");
        com.vungle.ads.internal.model.h hVar = new com.vungle.ads.internal.model.h(MANUFACTURER, MODEL, RELEASE, com.vungle.ads.internal.platform.c.Companion.getCarrierName$vungle_ads_release(context), t.d("Amazon", MANUFACTURER) ? "amazon" : "android", displayMetrics.widthPixels, displayMetrics.heightPixels, this.uaString, (String) null, (Integer) null, (h.c) null, 1792, (k) null);
        try {
            String userAgent = this.platform.getUserAgent();
            this.uaString = userAgent;
            hVar.setUa(userAgent);
            initUserAgentLazy();
            com.vungle.ads.internal.model.c advertisingInfo = this.advertisingInfo;
            if (advertisingInfo == null) {
                advertisingInfo = this.platform.getAdvertisingInfo();
            }
            this.advertisingInfo = advertisingInfo;
        } catch (Exception e10) {
            p.Companion.e(TAG, "Cannot Get UserAgent. Setting Default Device UserAgent." + e10.getLocalizedMessage());
        }
        return hVar;
    }

    private final String getConnectionType() {
        if (PermissionChecker.checkCallingOrSelfPermission(this.applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        Object systemService = this.applicationContext.getSystemService("connectivity");
        t.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "NONE";
        }
        int type = activeNetworkInfo.getType();
        return type != 0 ? (type == 1 || type == 6) ? "WIFI" : type != 7 ? type != 9 ? "UNKNOWN" : "ETHERNET" : "BLUETOOTH" : "MOBILE";
    }

    private final com.vungle.ads.internal.model.h getDeviceBody() throws IllegalStateException {
        return getDeviceBody$vungle_ads_release(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.vungle.ads.internal.model.f.h getExtBody(boolean r8) {
        /*
            r7 = this;
            com.vungle.ads.internal.k r0 = com.vungle.ads.internal.k.INSTANCE
            java.lang.String r0 = r0.getConfigExtension()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L17
            int r3 = r0.length()
            if (r3 != 0) goto L12
            r3 = r1
            goto L13
        L12:
            r3 = r2
        L13:
            if (r3 != r1) goto L17
            r3 = r1
            goto L18
        L17:
            r3 = r2
        L18:
            if (r3 == 0) goto L22
            com.vungle.ads.internal.persistence.b r0 = r7.filePreferences
            java.lang.String r3 = "config_extension"
            java.lang.String r0 = r0.getString(r3)
        L22:
            r3 = 0
            if (r8 != 0) goto L27
        L25:
            r8 = r3
            goto L4e
        L27:
            com.vungle.ads.internal.signals.b r8 = r7.getSignalManager()     // Catch: java.lang.Exception -> L30
            java.lang.String r8 = r8.generateSignals()     // Catch: java.lang.Exception -> L30
            goto L4e
        L30:
            r8 = move-exception
            com.vungle.ads.internal.util.p$a r4 = com.vungle.ads.internal.util.p.Companion
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Couldn't convert signals for sending. Error: "
            r5.append(r6)
            java.lang.String r8 = r8.getMessage()
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            java.lang.String r5 = "VungleApiClient"
            r4.e(r5, r8)
            goto L25
        L4e:
            if (r0 == 0) goto L59
            int r4 = r0.length()
            if (r4 != 0) goto L57
            goto L59
        L57:
            r4 = r2
            goto L5a
        L59:
            r4 = r1
        L5a:
            if (r4 == 0) goto L69
            if (r8 == 0) goto L66
            int r4 = r8.length()
            if (r4 != 0) goto L65
            goto L66
        L65:
            r1 = r2
        L66:
            if (r1 == 0) goto L69
            return r3
        L69:
            com.vungle.ads.internal.model.f$h r1 = new com.vungle.ads.internal.model.f$h
            com.vungle.ads.internal.k r2 = com.vungle.ads.internal.k.INSTANCE
            long r2 = r2.configLastValidatedTimestamp()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.<init>(r0, r8, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.i.getExtBody(boolean):com.vungle.ads.internal.model.f$h");
    }

    static /* synthetic */ f.h getExtBody$default(i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return iVar.getExtBody(z10);
    }

    private final String getPlacementID(c0 c0Var) {
        List<String> placements;
        try {
            kotlinx.serialization.json.a aVar = json;
            String strBodyToString = bodyToString(c0Var);
            KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), o0.j(com.vungle.ads.internal.model.f.class));
            t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            f.i request = ((com.vungle.ads.internal.model.f) aVar.b(kSerializerB, strBodyToString)).getRequest();
            if (request == null || (placements = request.getPlacements()) == null) {
                return "";
            }
            String str = placements.get(0);
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    private final com.vungle.ads.internal.signals.b getSignalManager() {
        return (com.vungle.ads.internal.signals.b) this.signalManager$delegate.getValue();
    }

    private final f.j getUserBody(boolean z10) {
        f.j jVar = new f.j((f.C0520f) null, (f.c) null, (f.d) null, (o7.c) null, (f.g) null, 31, (k) null);
        q7.c cVar = q7.c.INSTANCE;
        jVar.setGdpr(new f.C0520f(cVar.getConsentStatus(), cVar.getConsentSource(), cVar.getConsentTimestamp(), cVar.getConsentMessageVersion()));
        jVar.setCcpa(new f.c(cVar.getCcpaStatus()));
        if (cVar.getCoppaStatus() != q7.a.COPPA_NOTSET) {
            jVar.setCoppa(new f.d(cVar.getCoppaStatus().getValue()));
        }
        if (cVar.shouldSendTCFString()) {
            jVar.setIab(new f.g(cVar.getIABTCFString()));
        }
        if (z10) {
            jVar.setFpd(VungleAds.firstPartyData);
        }
        return jVar;
    }

    static /* synthetic */ f.j getUserBody$default(i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return iVar.getUserBody(z10);
    }

    private final void initUserAgentLazy() {
        w1 w1Var = new w1(Sdk$SDKMetric.b.USER_AGENT_LOAD_DURATION_MS);
        w1Var.markStart();
        this.platform.getUserAgentLazy(new e(w1Var, this));
    }

    public static /* synthetic */ com.vungle.ads.internal.model.f requestBody$default(i iVar, boolean z10, boolean z11, int i10, Object obj) throws IllegalStateException {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        return iVar.requestBody(z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: responseInterceptor$lambda-0, reason: not valid java name */
    public static final d0 m4068responseInterceptor$lambda0(i this$0, w.a chain) {
        t.i(this$0, "this$0");
        t.i(chain, "chain");
        b0 b0VarA = chain.a();
        try {
            try {
                d0 d0VarB = chain.b(b0VarA);
                String strA = d0VarB.L().a("Retry-After");
                boolean z10 = true;
                if (strA == null || strA.length() == 0) {
                    return d0VarB;
                }
                try {
                    long j10 = Long.parseLong(strA);
                    if (j10 <= 0) {
                        return d0VarB;
                    }
                    String strD = b0VarA.k().d();
                    long jCurrentTimeMillis = (j10 * ((long) 1000)) + System.currentTimeMillis();
                    if (!q.w(strD, "ads", false, 2, null)) {
                        return d0VarB;
                    }
                    String placementID = this$0.getPlacementID(b0VarA.a());
                    if (placementID.length() <= 0) {
                        z10 = false;
                    }
                    if (!z10) {
                        return d0VarB;
                    }
                    this$0.retryAfterDataMap.put(placementID, Long.valueOf(jCurrentTimeMillis));
                    return d0VarB;
                } catch (Exception unused) {
                    p.Companion.d(TAG, "Retry-After value is not an valid value");
                    return d0VarB;
                }
            } catch (Exception e10) {
                p.Companion.e(TAG, "Exception: " + e10.getMessage() + " for " + b0VarA.k());
                return this$0.defaultErrorResponse(b0VarA);
            }
        } catch (OutOfMemoryError unused2) {
            p.Companion.e(TAG, "OOM for " + b0VarA.k());
            return this$0.defaultErrorResponse(b0VarA);
        }
    }

    @VisibleForTesting
    public final void addPlaySvcAvailabilityInCookie(boolean z10) {
        this.filePreferences.put("isPlaySvcAvailable", z10).apply();
    }

    public final boolean checkIsRetryAfterActive(@NotNull String placementID) {
        t.i(placementID, "placementID");
        Long l10 = this.retryAfterDataMap.get(placementID);
        if ((l10 != null ? l10.longValue() : 0L) > System.currentTimeMillis()) {
            return true;
        }
        this.retryAfterDataMap.remove(placementID);
        return false;
    }

    @Nullable
    public final com.vungle.ads.internal.network.a<com.vungle.ads.internal.model.g> config() throws IOException {
        com.vungle.ads.internal.model.d dVar = this.appBody;
        if (dVar == null) {
            return null;
        }
        com.vungle.ads.internal.model.f fVar = new com.vungle.ads.internal.model.f(getDeviceBody$vungle_ads_release(true), dVar, getUserBody$default(this, false, 1, null), (f.h) null, (f.i) null, 24, (k) null);
        f.h extBody$default = getExtBody$default(this, false, 1, null);
        if (extBody$default != null) {
            fVar.setExt(extBody$default);
        }
        com.vungle.ads.internal.util.i iVar = com.vungle.ads.internal.util.i.INSTANCE;
        String str = BASE_URL;
        if (!iVar.isValidUrl(str)) {
            str = "https://config.ads.vungle.com/";
        }
        if (!q.w(str, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, false, 2, null)) {
            str = str + '/';
        }
        return this.api.config(headerUa, str + "config", fVar);
    }

    @Nullable
    public final com.vungle.ads.internal.model.d getAppBody$vungle_ads_release() {
        return this.appBody;
    }

    @NotNull
    public final String getConnectionTypeDetail(int i10) {
        if (i10 == 1) {
            return "gprs";
        }
        if (i10 == 2) {
            return "edge";
        }
        if (i10 == 20) {
            return "5g";
        }
        switch (i10) {
            case 4:
                return "wcdma";
            case 5:
                return "cdma_evdo_0";
            case 6:
                return "cdma_evdo_a";
            case 7:
                return "cdma_1xrtt";
            case 8:
                return "hsdpa";
            case 9:
                return "hsupa";
            default:
                switch (i10) {
                    case 12:
                        return "cdma_evdo_b";
                    case 13:
                        return "lte";
                    case 14:
                        return "hrpd";
                    default:
                        return "unknown";
                }
        }
    }

    @VisibleForTesting
    @NotNull
    public final synchronized com.vungle.ads.internal.model.h getDeviceBody$vungle_ads_release(boolean z10) throws IllegalStateException {
        com.vungle.ads.internal.model.h hVarCopy;
        h.c cVar;
        String str;
        boolean zHasSystemFeature;
        com.vungle.ads.internal.model.h basicDeviceBody = this.baseDeviceInfo;
        if (basicDeviceBody == null) {
            basicDeviceBody = getBasicDeviceBody(this.applicationContext);
            this.baseDeviceInfo = basicDeviceBody;
        }
        com.vungle.ads.internal.model.h hVar = basicDeviceBody;
        hVarCopy = hVar.copy((2047 & 1) != 0 ? hVar.make : null, (2047 & 2) != 0 ? hVar.model : null, (2047 & 4) != 0 ? hVar.osv : null, (2047 & 8) != 0 ? hVar.carrier : null, (2047 & 16) != 0 ? hVar.os : null, (2047 & 32) != 0 ? hVar.f24350w : 0, (2047 & 64) != 0 ? hVar.f24348h : 0, (2047 & 128) != 0 ? hVar.f24349ua : null, (2047 & 256) != 0 ? hVar.ifa : null, (2047 & 512) != 0 ? hVar.lmt : null, (2047 & 1024) != 0 ? hVar.ext : null);
        h.c cVar2 = new h.c(false, (String) null, (Integer) null, 0.0f, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, false, 0, false, (String) null, (String) null, 262143, (k) null);
        com.vungle.ads.internal.model.c advertisingInfo = this.advertisingInfo;
        if (advertisingInfo == null) {
            advertisingInfo = this.platform.getAdvertisingInfo();
        }
        this.advertisingInfo = advertisingInfo;
        String advertisingId = advertisingInfo != null ? advertisingInfo.getAdvertisingId() : null;
        com.vungle.ads.internal.model.c cVar3 = this.advertisingInfo;
        Boolean boolValueOf = cVar3 != null ? Boolean.valueOf(cVar3.getLimitAdTracking()) : null;
        q7.c cVar4 = q7.c.INSTANCE;
        if (!cVar4.shouldSendAdIds()) {
            cVar = cVar2;
        } else if (advertisingId != null) {
            if (t.d("Amazon", Build.MANUFACTURER)) {
                cVar = cVar2;
                cVar.setAmazonAdvertisingId(advertisingId);
            } else {
                cVar = cVar2;
                cVar.setGaid(advertisingId);
            }
            hVarCopy.setIfa(advertisingId);
        } else {
            cVar = cVar2;
            hVarCopy.setIfa("");
        }
        if (z10 || !cVar4.shouldSendAdIds()) {
            hVarCopy.setIfa(null);
            cVar.setGaid(null);
            cVar.setAmazonAdvertisingId(null);
        }
        Boolean bool = Boolean.TRUE;
        hVarCopy.setLmt(t.d(boolValueOf, bool) ? 1 : 0);
        cVar.setGooglePlayServicesAvailable(t.d(bool, isGooglePlayServicesAvailable()));
        if (cVar4.allowDeviceIDFromTCF() != c.a.DISABLE_ID) {
            String appSetId = this.platform.getAppSetId();
            if (appSetId != null) {
                cVar.setAppSetId(appSetId);
            }
            Integer appSetIdScope = this.platform.getAppSetIdScope();
            if (appSetIdScope != null) {
                cVar.setAppSetIdScope(Integer.valueOf(appSetIdScope.intValue()));
            }
        }
        Intent intentRegisterReceiver = this.applicationContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            int intExtra = intentRegisterReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
            int intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
            if (intExtra > 0 && intExtra2 > 0) {
                cVar.setBatteryLevel(intExtra / intExtra2);
            }
            int intExtra3 = intentRegisterReceiver.getIntExtra("status", -1);
            if (intExtra3 == -1) {
                str = "UNKNOWN";
            } else if (intExtra3 == 2 || intExtra3 == 5) {
                int intExtra4 = intentRegisterReceiver.getIntExtra("plugged", -1);
                str = intExtra4 != 1 ? intExtra4 != 2 ? intExtra4 != 4 ? "BATTERY_PLUGGED_OTHERS" : "BATTERY_PLUGGED_WIRELESS" : "BATTERY_PLUGGED_USB" : "BATTERY_PLUGGED_AC";
            } else {
                str = "NOT_CHARGING";
            }
        } else {
            str = "UNKNOWN";
        }
        cVar.setBatteryState(str);
        Object systemService = this.applicationContext.getSystemService("power");
        t.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        cVar.setBatterySaverEnabled(((PowerManager) systemService).isPowerSaveMode() ? 1 : 0);
        String connectionType = getConnectionType();
        if (connectionType != null) {
            cVar.setConnectionType(connectionType);
        }
        String connectionTypeDetail = getConnectionTypeDetail();
        if (connectionTypeDetail != null) {
            cVar.setConnectionTypeDetail(connectionTypeDetail);
        }
        cVar.setLocale(Locale.getDefault().toString());
        cVar.setLanguage(Locale.getDefault().getLanguage());
        cVar.setTimeZone(TimeZone.getDefault().getID());
        cVar.setVolumeLevel(this.platform.getVolumeLevel());
        cVar.setSoundEnabled(this.platform.isSoundEnabled() ? 1 : 0);
        if (t.d("Amazon", Build.MANUFACTURER)) {
            zHasSystemFeature = this.applicationContext.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
        } else {
            Object systemService2 = this.applicationContext.getSystemService("uimode");
            t.g(systemService2, "null cannot be cast to non-null type android.app.UiModeManager");
            zHasSystemFeature = ((UiModeManager) systemService2).getCurrentModeType() == 4;
        }
        cVar.setTv(zHasSystemFeature);
        cVar.setSideloadEnabled(this.platform.isSideLoaded());
        cVar.setSdCardAvailable(this.platform.isSdCardPresent() ? 1 : 0);
        hVarCopy.setUa(this.uaString);
        hVarCopy.setExt(cVar);
        return hVarCopy;
    }

    @NotNull
    public final VungleApi getGzipApi$vungle_ads_release() {
        return this.gzipApi;
    }

    @VisibleForTesting
    @Nullable
    public final Boolean getPlayServicesAvailabilityFromAPI() {
        Boolean boolValueOf = null;
        try {
            GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
            t.h(googleApiAvailabilityLight, "getInstance()");
            boolValueOf = Boolean.valueOf(googleApiAvailabilityLight.isGooglePlayServicesAvailable(this.applicationContext) == 0);
            addPlaySvcAvailabilityInCookie(boolValueOf.booleanValue());
            return boolValueOf;
        } catch (Exception unused) {
            p.Companion.w(TAG, "Unexpected exception from Play services lib.");
            return boolValueOf;
        } catch (NoClassDefFoundError unused2) {
            p.Companion.w(TAG, "Play services Not available");
            Boolean bool = Boolean.FALSE;
            try {
                addPlaySvcAvailabilityInCookie(false);
                return bool;
            } catch (Exception unused3) {
                p.Companion.w(TAG, "Failure to write GPS availability to DB");
                return bool;
            }
        }
    }

    @VisibleForTesting
    @Nullable
    public final Boolean getPlayServicesAvailabilityFromCookie() {
        return this.filePreferences.getBoolean("isPlaySvcAvailable");
    }

    @NotNull
    public final w getResponseInterceptor$vungle_ads_release() {
        return this.responseInterceptor;
    }

    @NotNull
    public final Map<String, Long> getRetryAfterDataMap$vungle_ads_release() {
        return this.retryAfterDataMap;
    }

    public final long getRetryAfterHeaderValue(@NotNull String placementID) {
        t.i(placementID, "placementID");
        Long l10 = this.retryAfterDataMap.get(placementID);
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }

    public final synchronized void initialize(@NotNull String appId) {
        PackageInfo packageInfo;
        t.i(appId, "appId");
        this.api.setAppId(appId);
        this.gzipApi.setAppId(appId);
        String str = "1.0";
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = this.applicationContext.getPackageManager().getPackageInfo(this.applicationContext.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
                t.h(packageInfo, "{\n                    ap…      )\n                }");
            } else {
                packageInfo = this.applicationContext.getPackageManager().getPackageInfo(this.applicationContext.getPackageName(), 0);
                t.h(packageInfo, "{\n                    ap…      )\n                }");
            }
            String str2 = packageInfo.versionName;
            t.h(str2, "packageInfo.versionName");
            str = str2;
        } catch (Exception unused) {
        }
        this.baseDeviceInfo = getBasicDeviceBody(this.applicationContext);
        String packageName = this.applicationContext.getPackageName();
        t.h(packageName, "applicationContext.packageName");
        this.appBody = new com.vungle.ads.internal.model.d(packageName, str, appId);
        this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
    }

    @VisibleForTesting
    @Nullable
    public final Boolean isGooglePlayServicesAvailable() {
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromCookie();
        }
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        }
        return this.isGooglePlayServicesAvailable;
    }

    @Nullable
    public final d.b pingTPAT(@NotNull String url) {
        d0 d0VarRaw;
        t.i(url, "url");
        if ((url.length() == 0) || ga.v.f26216k.f(url) == null) {
            return new d.b(121, "Invalid URL : " + url, null, true, 4, null);
        }
        try {
            if (!(Build.VERSION.SDK_INT >= 24 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(new URL(url).getHost()) : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) && URLUtil.isHttpUrl(url)) {
                return new d.b(121, "Clear Text Traffic is blocked", null, false, 12, null);
            }
            try {
                String str = this.uaString;
                if (str == null) {
                    str = "";
                }
                com.vungle.ads.internal.network.d<Void> dVarExecute = this.api.pingTPAT(str, url).execute();
                Integer numValueOf = null;
                if (dVarExecute != null && dVarExecute.isSuccessful()) {
                    return null;
                }
                if (dVarExecute != null && (d0VarRaw = dVarExecute.raw()) != null) {
                    numValueOf = Integer.valueOf(d0VarRaw.q());
                }
                if (!kotlin.collections.d0.b0(kotlin.collections.v.n(301, 302, 307, 308), numValueOf)) {
                    return new d.b(121, "Tpat ping was not successful", null, false, 12, null);
                }
                return new d.b(29, "Tpat ping was redirected with code " + numValueOf, null, false, 12, null);
            } catch (Exception e10) {
                int i10 = 121;
                String localizedMessage = e10.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "IOException";
                }
                return new d.b(i10, localizedMessage, null, false, 12, null);
            }
        } catch (MalformedURLException e11) {
            int i11 = 121;
            String localizedMessage2 = e11.getLocalizedMessage();
            if (localizedMessage2 == null) {
                localizedMessage2 = "MalformedURLException";
            }
            return new d.b(i11, localizedMessage2, null, true, 4, null);
        }
    }

    public final void reportErrors(@NotNull BlockingQueue<Sdk$SDKError.a> errors, @NotNull o.b requestListener) {
        t.i(errors, "errors");
        t.i(requestListener, "requestListener");
        String errorLoggingEndpoint = com.vungle.ads.internal.k.INSTANCE.getErrorLoggingEndpoint();
        if (errorLoggingEndpoint == null || errorLoggingEndpoint.length() == 0) {
            requestListener.onFailure();
            return;
        }
        for (Sdk$SDKError.a aVar : errors) {
            String connectionType = getConnectionType();
            if (connectionType != null) {
                aVar.setConnectionType(connectionType);
            }
            String connectionTypeDetail = getConnectionTypeDetail();
            if (connectionTypeDetail != null) {
                aVar.setConnectionTypeDetail(connectionTypeDetail);
                aVar.setConnectionTypeDetailAndroid(connectionTypeDetail);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Sdk$SDKError.a> it = errors.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().build());
        }
        Sdk$SDKErrorBatch sdk$SDKErrorBatchBuild = Sdk$SDKErrorBatch.newBuilder().addAllErrors(arrayList).build();
        c0.a aVar2 = c0.Companion;
        byte[] byteArray = sdk$SDKErrorBatchBuild.toByteArray();
        t.h(byteArray, "batch.toByteArray()");
        this.api.sendErrors(headerUa, errorLoggingEndpoint, aVar2.m(byteArray, x.f26237e.b("application/x-protobuf"), 0, sdk$SDKErrorBatchBuild.toByteArray().length)).enqueue(new f(requestListener));
    }

    public final void reportMetrics(@NotNull BlockingQueue<Sdk$SDKMetric.a> metrics, @NotNull o.b requestListener) {
        t.i(metrics, "metrics");
        t.i(requestListener, "requestListener");
        String metricsEndpoint = com.vungle.ads.internal.k.INSTANCE.getMetricsEndpoint();
        if (metricsEndpoint == null || metricsEndpoint.length() == 0) {
            requestListener.onFailure();
            return;
        }
        for (Sdk$SDKMetric.a aVar : metrics) {
            String connectionType = getConnectionType();
            if (connectionType != null) {
                aVar.setConnectionType(connectionType);
            }
            String connectionTypeDetail = getConnectionTypeDetail();
            if (connectionTypeDetail != null) {
                aVar.setConnectionTypeDetail(connectionTypeDetail);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Sdk$SDKMetric.a> it = metrics.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().build());
        }
        Sdk$MetricBatch sdk$MetricBatchBuild = Sdk$MetricBatch.newBuilder().addAllMetrics(arrayList).build();
        c0.a aVar2 = c0.Companion;
        x xVarB = x.f26237e.b("application/x-protobuf");
        byte[] byteArray = sdk$MetricBatchBuild.toByteArray();
        t.h(byteArray, "batch.toByteArray()");
        this.api.sendMetrics(headerUa, metricsEndpoint, c0.a.n(aVar2, xVarB, byteArray, 0, 0, 12, null)).enqueue(new g(requestListener));
    }

    @Nullable
    public final com.vungle.ads.internal.network.a<com.vungle.ads.internal.model.b> requestAd(@NotNull String placement, @Nullable z1 z1Var) throws IllegalStateException {
        t.i(placement, "placement");
        com.vungle.ads.internal.k kVar = com.vungle.ads.internal.k.INSTANCE;
        String adsEndpoint = kVar.getAdsEndpoint();
        if (adsEndpoint == null || adsEndpoint.length() == 0) {
            return null;
        }
        com.vungle.ads.internal.model.f fVarRequestBody = requestBody(true ^ kVar.signalsDisabled(), kVar.fpdEnabled());
        f.i iVar = new f.i(u.e(placement), (f.b) null, (Long) null, (String) null, (String) null, (String) null, 62, (k) null);
        if (z1Var != null) {
            iVar.setAdSize(new f.b(z1Var.getWidth(), z1Var.getHeight()));
        }
        fVarRequestBody.setRequest(iVar);
        return this.gzipApi.ads(headerUa, adsEndpoint, fVarRequestBody);
    }

    @NotNull
    public final com.vungle.ads.internal.model.f requestBody(boolean z10, boolean z11) throws IllegalStateException {
        com.vungle.ads.internal.model.f fVar = new com.vungle.ads.internal.model.f(getDeviceBody(), this.appBody, getUserBody(z11), (f.h) null, (f.i) null, 24, (k) null);
        f.h extBody = getExtBody(z10);
        if (extBody != null) {
            fVar.setExt(extBody);
        }
        return fVar;
    }

    @Nullable
    public final com.vungle.ads.internal.network.a<Void> ri(@NotNull f.i request) {
        com.vungle.ads.internal.model.d dVar;
        t.i(request, "request");
        String riEndpoint = com.vungle.ads.internal.k.INSTANCE.getRiEndpoint();
        if ((riEndpoint == null || riEndpoint.length() == 0) || (dVar = this.appBody) == null) {
            return null;
        }
        com.vungle.ads.internal.model.f fVar = new com.vungle.ads.internal.model.f(getDeviceBody(), dVar, getUserBody$default(this, false, 1, null), (f.h) null, (f.i) null, 24, (k) null);
        fVar.setRequest(request);
        f.h extBody$default = getExtBody$default(this, false, 1, null);
        if (extBody$default != null) {
            fVar.setExt(extBody$default);
        }
        return this.api.ri(headerUa, riEndpoint, fVar);
    }

    public final void sendAdMarkup(@NotNull String adMarkup, @NotNull String endpoint) {
        t.i(adMarkup, "adMarkup");
        t.i(endpoint, "endpoint");
        this.api.sendAdMarkup(endpoint, c0.Companion.h(adMarkup, x.f26237e.b(nb.L))).enqueue(new h());
    }

    public final void setAppBody$vungle_ads_release(@Nullable com.vungle.ads.internal.model.d dVar) {
        this.appBody = dVar;
    }

    public final void setGzipApi$vungle_ads_release(@NotNull VungleApi vungleApi) {
        t.i(vungleApi, "<set-?>");
        this.gzipApi = vungleApi;
    }

    public final void setResponseInterceptor$vungle_ads_release(@NotNull w wVar) {
        t.i(wVar, "<set-?>");
        this.responseInterceptor = wVar;
    }

    public final void setRetryAfterDataMap$vungle_ads_release(@NotNull Map<String, Long> map) {
        t.i(map, "<set-?>");
        this.retryAfterDataMap = map;
    }

    @Nullable
    public final String getConnectionTypeDetail() {
        if (PermissionChecker.checkCallingOrSelfPermission(this.applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        Object systemService = this.applicationContext.getSystemService("connectivity");
        t.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null ? getConnectionTypeDetail(activeNetworkInfo.getSubtype()) : "unknown";
    }

    @VisibleForTesting
    public static /* synthetic */ void getAppBody$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getGzipApi$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getResponseInterceptor$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRetryAfterDataMap$vungle_ads_release$annotations() {
    }

    /* JADX INFO: compiled from: VungleApiClient.kt */
    public static final class h implements com.vungle.ads.internal.network.b<Void> {
        h() {
        }

        @Override // com.vungle.ads.internal.network.b
        public void onFailure(@Nullable com.vungle.ads.internal.network.a<Void> aVar, @Nullable Throwable th) {
        }

        @Override // com.vungle.ads.internal.network.b
        public void onResponse(@Nullable com.vungle.ads.internal.network.a<Void> aVar, @Nullable com.vungle.ads.internal.network.d<Void> dVar) {
        }
    }
}
