package com.braze;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import bo.app.a0;
import bo.app.a1;
import bo.app.a5;
import bo.app.a6;
import bo.app.ac0;
import bo.app.am;
import bo.app.b0;
import bo.app.b4;
import bo.app.b5;
import bo.app.b6;
import bo.app.c0;
import bo.app.c2;
import bo.app.c6;
import bo.app.c7;
import bo.app.ch0;
import bo.app.ci0;
import bo.app.d3;
import bo.app.d30;
import bo.app.d4;
import bo.app.d5;
import bo.app.dc0;
import bo.app.ds;
import bo.app.e3;
import bo.app.e4;
import bo.app.e5;
import bo.app.e50;
import bo.app.e7;
import bo.app.ec0;
import bo.app.eh0;
import bo.app.es;
import bo.app.f3;
import bo.app.f5;
import bo.app.f6;
import bo.app.f7;
import bo.app.g3;
import bo.app.g4;
import bo.app.g5;
import bo.app.gb0;
import bo.app.gw;
import bo.app.h00;
import bo.app.h2;
import bo.app.h3;
import bo.app.h4;
import bo.app.h5;
import bo.app.hr;
import bo.app.hx;
import bo.app.hy;
import bo.app.i2;
import bo.app.i4;
import bo.app.i5;
import bo.app.iw;
import bo.app.ix;
import bo.app.j4;
import bo.app.j5;
import bo.app.j50;
import bo.app.j6;
import bo.app.j7;
import bo.app.j80;
import bo.app.jx;
import bo.app.k1;
import bo.app.k3;
import bo.app.k4;
import bo.app.k6;
import bo.app.k7;
import bo.app.ka0;
import bo.app.kx;
import bo.app.l10;
import bo.app.l3;
import bo.app.l4;
import bo.app.l6;
import bo.app.l7;
import bo.app.lw;
import bo.app.m1;
import bo.app.m3;
import bo.app.m4;
import bo.app.m7;
import bo.app.n3;
import bo.app.n4;
import bo.app.n5;
import bo.app.n7;
import bo.app.o0;
import bo.app.o00;
import bo.app.o2;
import bo.app.o3;
import bo.app.o4;
import bo.app.o5;
import bo.app.p0;
import bo.app.p00;
import bo.app.p2;
import bo.app.p3;
import bo.app.p4;
import bo.app.q2;
import bo.app.qa0;
import bo.app.r0;
import bo.app.r2;
import bo.app.r4;
import bo.app.s0;
import bo.app.s60;
import bo.app.t0;
import bo.app.t3;
import bo.app.t5;
import bo.app.t80;
import bo.app.tf;
import bo.app.tr;
import bo.app.u0;
import bo.app.u2;
import bo.app.u4;
import bo.app.u5;
import bo.app.u6;
import bo.app.uc0;
import bo.app.uh0;
import bo.app.uz;
import bo.app.v0;
import bo.app.v00;
import bo.app.v40;
import bo.app.v5;
import bo.app.v80;
import bo.app.ve0;
import bo.app.vw;
import bo.app.w6;
import bo.app.x3;
import bo.app.x4;
import bo.app.x5;
import bo.app.x6;
import bo.app.xe0;
import bo.app.y4;
import bo.app.y5;
import bo.app.z00;
import bo.app.z4;
import bo.app.z5;
import com.braze.Braze;
import com.braze.configuration.BrazeConfig;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.configuration.RuntimeAppConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazePushEventType;
import com.braze.enums.GeofenceTransitionType;
import com.braze.events.BrazePushEvent;
import com.braze.events.BrazeUserChangeEvent;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.FeedUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.IValueCallback;
import com.braze.events.InAppMessageEvent;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.images.DefaultBrazeImageLoader;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.IBrazeLocation;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.support.BrazeLogger;
import com.braze.support.PermissionUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.d0;
import kotlin.collections.y0;
import kotlin.collections.z0;
import v8.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class Braze {
    private static boolean areOutboundNetworkRequestsOffline;
    private static IBrazeNotificationFactory customBrazeNotificationFactory;
    private static o00 deviceDataProvider;
    private static IBrazeEndpointProvider endpointProvider;
    private static volatile Braze instance;
    private static ka0 sdkEnablementProvider;
    private static boolean shouldMockNetworkRequestsAndDropEvents;
    private static v00 staticExternalIEventMessenger;
    private Context applicationContext;
    private BrazeUser brazeUser;
    public BrazeConfigurationProvider configurationProvider;
    public p00 deviceIdProvider;
    private v00 externalIEventMessenger;
    public IBrazeImageLoader imageLoader;
    private Boolean isApiKeyPresent;
    private boolean isInstanceStopped;
    private e50 offlineUserStorageProvider;
    public s60 pushDeliveryManager;
    private z00 registrationDataProvider;
    public l10 udm;
    public static final Companion Companion = new Companion(null);
    private static final ReentrantLock brazeClassLock = new ReentrantLock();
    private static final Set<String> KNOWN_APP_CRAWLER_DEVICE_MODELS = y0.c("calypso appcrawler");
    private static final Set<String> NECESSARY_BRAZE_SDK_PERMISSIONS = z0.h("android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET");
    private static final ReentrantLock endpointProviderLock = new ReentrantLock();
    private static boolean shouldRequestFrameworkListenToNetworkUpdates = true;
    private static final List<BrazeConfig> pendingConfigurations = new ArrayList();
    private static final BrazeConfig clearConfigSentinel = new BrazeConfig.Builder().build();

    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ka0 getSdkEnablementProvider(Context context) {
            ka0 sdkEnablementProvider$android_sdk_base_release = getSdkEnablementProvider$android_sdk_base_release();
            if (sdkEnablementProvider$android_sdk_base_release != null) {
                return sdkEnablementProvider$android_sdk_base_release;
            }
            ka0 ka0Var = new ka0(context);
            setSdkEnablementProvider$android_sdk_base_release(ka0Var);
            return ka0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Uri setConfiguredCustomEndpoint$lambda$12$lambda$11(String str, Uri brazeEndpoint) {
            kotlin.jvm.internal.t.i(brazeEndpoint, "brazeEndpoint");
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String encodedAuthority = uri.getEncodedAuthority();
            Uri.Builder builderBuildUpon = brazeEndpoint.buildUpon();
            if (scheme == null || p9.q.z(scheme) || encodedAuthority == null || p9.q.z(encodedAuthority)) {
                return builderBuildUpon.encodedAuthority(str).build();
            }
            builderBuildUpon.encodedAuthority(encodedAuthority);
            builderBuildUpon.scheme(scheme);
            return builderBuildUpon.build();
        }

        private final boolean shouldAllowSingletonInitialization() {
            Braze braze = Braze.instance;
            if (braze == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) w.f8154a, 6, (Object) null);
                return true;
            }
            if (braze.isInstanceStopped) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) x.f8155a, 7, (Object) null);
                return true;
            }
            if (!kotlin.jvm.internal.t.d(Boolean.FALSE, braze.isApiKeyPresent$android_sdk_base_release())) {
                return false;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) y.f8156a, 7, (Object) null);
            return true;
        }

        public final boolean configure(Context context, BrazeConfig brazeConfig) {
            kotlin.jvm.internal.t.i(context, "context");
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.Priority priority = BrazeLogger.Priority.I;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new d(brazeConfig), 6, (Object) null);
            ReentrantLock reentrantLock = Braze.brazeClassLock;
            reentrantLock.lock();
            try {
                Braze braze = Braze.instance;
                if (braze != null && !braze.isInstanceStopped && kotlin.jvm.internal.t.d(Boolean.TRUE, braze.isApiKeyPresent$android_sdk_base_release())) {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) Braze.Companion, priority, (Throwable) null, false, (h9.a) e.f8067a, 6, (Object) null);
                    reentrantLock.unlock();
                    return false;
                }
                if (brazeConfig != null) {
                    Braze.pendingConfigurations.add(brazeConfig);
                } else {
                    BrazeLogger.brazelog$default(brazeLogger, (Object) Braze.Companion, priority, (Throwable) null, false, (h9.a) f.f8070a, 6, (Object) null);
                    Braze.pendingConfigurations.add(Braze.clearConfigSentinel);
                }
                reentrantLock.unlock();
                return true;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final boolean enableMockNetworkRequestsAndDropEventsMode() {
            if (Braze.instance == null) {
                ReentrantLock reentrantLock = Braze.brazeClassLock;
                reentrantLock.lock();
                try {
                    if (Braze.instance == null) {
                        if (Braze.shouldMockNetworkRequestsAndDropEvents) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) i.f8076a, 6, (Object) null);
                        } else {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) j.f8079a, 6, (Object) null);
                            Braze.shouldMockNetworkRequestsAndDropEvents = true;
                        }
                        return true;
                    }
                    k0 k0Var = k0.f35197a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) k.f8080a, 6, (Object) null);
            return false;
        }

        public final Uri getApiEndpoint(Uri brazeEndpoint) {
            kotlin.jvm.internal.t.i(brazeEndpoint, "brazeEndpoint");
            ReentrantLock reentrantLock = Braze.endpointProviderLock;
            reentrantLock.lock();
            try {
                IBrazeEndpointProvider iBrazeEndpointProvider = Braze.endpointProvider;
                if (iBrazeEndpointProvider != null) {
                    try {
                        Uri apiEndpoint = iBrazeEndpointProvider.getApiEndpoint(brazeEndpoint);
                        if (apiEndpoint != null) {
                            return apiEndpoint;
                        }
                    } catch (Exception e10) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) Braze.Companion, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) n.f8107a, 4, (Object) null);
                    }
                }
                return brazeEndpoint;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final String getConfiguredApiKey(BrazeConfigurationProvider configurationProvider) {
            kotlin.jvm.internal.t.i(configurationProvider, "configurationProvider");
            try {
                return configurationProvider.getBrazeApiKey().f3835a;
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) o.f8108a, 4, (Object) null);
                return null;
            }
        }

        public final IBrazeNotificationFactory getCustomBrazeNotificationFactory() {
            return Braze.customBrazeNotificationFactory;
        }

        public final Braze getInstance(Context context) {
            kotlin.jvm.internal.t.i(context, "context");
            if (shouldAllowSingletonInitialization()) {
                ReentrantLock reentrantLock = Braze.brazeClassLock;
                reentrantLock.lock();
                try {
                    Companion companion = Braze.Companion;
                    if (companion.shouldAllowSingletonInitialization()) {
                        if (companion.getStaticExternalIEventMessenger$android_sdk_base_release() == null) {
                            companion.setStaticExternalIEventMessenger$android_sdk_base_release(new vw(new ka0(context), false));
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) companion, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) p.f8109a, 6, (Object) null);
                        }
                        Braze braze = new Braze(context);
                        braze.isInstanceStopped = false;
                        Braze.instance = braze;
                        return braze;
                    }
                    k0 k0Var = k0.f35197a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            Braze braze2 = Braze.instance;
            kotlin.jvm.internal.t.g(braze2, "null cannot be cast to non-null type com.braze.Braze");
            return braze2;
        }

        public final boolean getOutboundNetworkRequestsOffline() {
            return Braze.areOutboundNetworkRequestsOffline;
        }

        public final ka0 getSdkEnablementProvider$android_sdk_base_release() {
            return Braze.sdkEnablementProvider;
        }

        public final boolean getShouldRequestFrameworkListenToNetworkUpdates$android_sdk_base_release() {
            return Braze.shouldRequestFrameworkListenToNetworkUpdates;
        }

        public final v00 getStaticExternalIEventMessenger$android_sdk_base_release() {
            return Braze.staticExternalIEventMessenger;
        }

        public final boolean isDisabled() {
            ka0 sdkEnablementProvider$android_sdk_base_release = getSdkEnablementProvider$android_sdk_base_release();
            if (sdkEnablementProvider$android_sdk_base_release == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) q.f8110a, 7, (Object) null);
                return false;
            }
            Braze braze = Braze.instance;
            if (braze != null && kotlin.jvm.internal.t.d(Boolean.FALSE, braze.isApiKeyPresent$android_sdk_base_release())) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) s.f8111a, 6, (Object) null);
                return true;
            }
            boolean zA = sdkEnablementProvider$android_sdk_base_release.a();
            if (zA) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) t.f8125a, 6, (Object) null);
            }
            return zA;
        }

        public final void requestTriggersIfInAppMessageTestPush$android_sdk_base_release(Intent intent, h00 brazeManager) {
            kotlin.jvm.internal.t.i(intent, "intent");
            kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
            String stringExtra = intent.getStringExtra("ab_push_fetch_test_triggers_key");
            if (stringExtra == null || !kotlin.jvm.internal.t.d(stringExtra, com.ironsource.mediationsdk.metadata.a.f13688g)) {
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) v.f8153a, 6, (Object) null);
            j50 j50Var = new j50();
            j50Var.f3124c = Boolean.TRUE;
            ((tf) brazeManager).a(j50Var);
        }

        public final void setConfiguredCustomEndpoint$android_sdk_base_release(final String str) {
            ReentrantLock reentrantLock = Braze.endpointProviderLock;
            reentrantLock.lock();
            try {
                Braze.Companion.setEndpointProvider(new IBrazeEndpointProvider() { // from class: d0.a
                    @Override // com.braze.IBrazeEndpointProvider
                    public final Uri getApiEndpoint(Uri uri) {
                        return Braze.Companion.setConfiguredCustomEndpoint$lambda$12$lambda$11(str, uri);
                    }
                });
                k0 k0Var = k0.f35197a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void setCustomBrazeNotificationFactory(IBrazeNotificationFactory iBrazeNotificationFactory) {
            Braze.customBrazeNotificationFactory = iBrazeNotificationFactory;
        }

        public final void setEndpointProvider(IBrazeEndpointProvider iBrazeEndpointProvider) {
            ReentrantLock reentrantLock = Braze.endpointProviderLock;
            reentrantLock.lock();
            try {
                Braze.endpointProvider = iBrazeEndpointProvider;
                k0 k0Var = k0.f35197a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void setOutboundNetworkRequestsOffline(boolean z10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new u(z10), 6, (Object) null);
            ReentrantLock reentrantLock = Braze.brazeClassLock;
            reentrantLock.lock();
            try {
                Braze.areOutboundNetworkRequestsOffline = z10;
                Braze braze = Braze.instance;
                if (braze != null) {
                    braze.setSyncPolicyOfflineStatus(z10);
                    k0 k0Var = k0.f35197a;
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void setSdkEnablementProvider$android_sdk_base_release(ka0 ka0Var) {
            Braze.sdkEnablementProvider = ka0Var;
        }

        public final void setStaticExternalIEventMessenger$android_sdk_base_release(v00 v00Var) {
            Braze.staticExternalIEventMessenger = v00Var;
        }

        private Companion() {
        }
    }

    public Braze(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        long jNanoTime = System.nanoTime();
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) a0.f2341a, 7, (Object) null);
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.t.h(applicationContext, "context.applicationContext");
        this.applicationContext = applicationContext;
        String str = Build.MODEL;
        if (str != null) {
            Set<String> set = KNOWN_APP_CRAWLER_DEVICE_MODELS;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (set.contains(lowerCase)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new b0(str), 6, (Object) null);
                Companion.enableMockNetworkRequestsAndDropEventsMode();
            }
        }
        setImageLoader(new DefaultBrazeImageLoader(this.applicationContext));
        v00 v00Var = staticExternalIEventMessenger;
        this.externalIEventMessenger = v00Var == null ? new vw(new ka0(this.applicationContext)) : v00Var;
        run$android_sdk_base_release(c0.f2478a, false, false, new a(this, context));
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new o0(System.nanoTime(), jNanoTime), 7, (Object) null);
    }

    public static final boolean configure(Context context, BrazeConfig brazeConfig) {
        return Companion.configure(context, brazeConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o00 getDeviceDataProvider() {
        o00 hrVar = deviceDataProvider;
        if (hrVar == null) {
            hrVar = new hr(this.applicationContext, getConfigurationProvider$android_sdk_base_release());
        }
        deviceDataProvider = hrVar;
        return hrVar;
    }

    public static final Braze getInstance(Context context) {
        return Companion.getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEphemeralEventKey(String str) {
        if (!getConfigurationProvider$android_sdk_base_release().isEphemeralEventsEnabled()) {
            return false;
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) p2.f3599a, 6, (Object) null);
        Set<String> ephemeralEventKeys = getConfigurationProvider$android_sdk_base_release().getEphemeralEventKeys();
        boolean zContains = ephemeralEventKeys.contains(str);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new q2(str, ephemeralEventKeys, zContains), 6, (Object) null);
        return zContains;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void publishError(Throwable th) {
        if (this.udm == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, th, false, (h9.a) j4.f3115a, 4, (Object) null);
            return;
        }
        try {
            ((ci0) getUdm$android_sdk_base_release()).f2559k.b(Throwable.class, th);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new k4(th), 4, (Object) null);
        }
    }

    public static /* synthetic */ void run$android_sdk_base_release$default(Braze braze, h9.a aVar, boolean z10, boolean z11, h9.a aVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            z11 = true;
        }
        braze.run$android_sdk_base_release(aVar, z10, z11, aVar2);
    }

    private final <T> T runForResult(T t10, h9.a<String> aVar, boolean z10, boolean z11, h9.p<? super kotlinx.coroutines.o0, ? super z8.d<? super T>, ? extends Object> pVar) {
        if (z10) {
            try {
                if (Companion.isDisabled()) {
                    return t10;
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) aVar, 4, (Object) null);
                publishError(e10);
                return t10;
            }
        }
        return (T) kotlinx.coroutines.j.b(null, new j6(z11, this, t10, pVar, aVar, null), 1, null);
    }

    public static /* synthetic */ Object runForResult$default(Braze braze, Object obj, h9.a aVar, boolean z10, boolean z11, h9.p pVar, int i10, Object obj2) {
        return braze.runForResult(obj, aVar, (i10 & 4) != 0 ? true : z10, (i10 & 8) != 0 ? true : z11, pVar);
    }

    public static final void setCustomBrazeNotificationFactory(IBrazeNotificationFactory iBrazeNotificationFactory) {
        Companion.setCustomBrazeNotificationFactory(iBrazeNotificationFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSyncPolicyOfflineStatus(boolean z10) {
        run$android_sdk_base_release$default(this, new u6(z10), false, false, new w6(this, z10), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUserSpecificMemberVariablesAndStartDispatch(ci0 ci0Var) {
        setUdm$android_sdk_base_release(ci0Var);
        qa0 qa0Var = qa0.f3696a;
        qa0.f3697b = ((ci0) getUdm$android_sdk_base_release()).f2559k;
        uh0 uh0VarX = ((ci0) getUdm$android_sdk_base_release()).x();
        tf tfVar = ((ci0) getUdm$android_sdk_base_release()).f2570v;
        e50 e50Var = this.offlineUserStorageProvider;
        BrazeUser brazeUser = null;
        if (e50Var == null) {
            kotlin.jvm.internal.t.A("offlineUserStorageProvider");
            e50Var = null;
        }
        this.brazeUser = new BrazeUser(uh0VarX, tfVar, e50Var.a(), ((ci0) getUdm$android_sdk_base_release()).f2573y, ((ci0) getUdm$android_sdk_base_release()).f2556h);
        iw iwVar = ((ci0) getUdm$android_sdk_base_release()).f2561m;
        vw eventMessenger = ((ci0) getUdm$android_sdk_base_release()).f2559k;
        iwVar.getClass();
        kotlin.jvm.internal.t.i(eventMessenger, "eventMessenger");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) iwVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new gw(eventMessenger), 7, (Object) null);
        eventMessenger.c(iwVar.b(), ds.class);
        eventMessenger.c(iwVar.c(), es.class);
        eventMessenger.c(iwVar.j(), ac0.class);
        eventMessenger.c(iwVar.l(), ec0.class);
        eventMessenger.c(iwVar.k(), dc0.class);
        eventMessenger.c(iwVar.n(), ve0.class);
        eventMessenger.c(iwVar.i(), gb0.class);
        eventMessenger.c(iwVar.d(), Throwable.class);
        eventMessenger.c(iwVar.m(), uc0.class);
        eventMessenger.c(iwVar.q(), eh0.class);
        eventMessenger.c(iwVar.h(), v40.class);
        eventMessenger.c(iwVar.f(), uz.class);
        eventMessenger.c(iwVar.e(), hy.class);
        eventMessenger.c(iwVar.o(), xe0.class);
        eventMessenger.c(iwVar.g(), d30.class);
        eventMessenger.c(iwVar.p(), ch0.class);
        eventMessenger.c(iwVar.a(), am.class);
        vw vwVar = ((ci0) getUdm$android_sdk_base_release()).f2559k;
        vwVar.getClass();
        BrazeLogger.brazelog$default(brazeLogger, (Object) vwVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) lw.f3352a, 7, (Object) null);
        vwVar.f4152h = true;
        ReentrantLock reentrantLock = vwVar.f4151g;
        reentrantLock.lock();
        try {
            for (Class eventClass : vwVar.f4148d.keySet()) {
                kotlin.jvm.internal.t.h(eventClass, "eventClass");
                vwVar.a(eventClass);
            }
            k0 k0Var = k0.f35197a;
            reentrantLock.unlock();
            kx kxVar = ((ci0) getUdm$android_sdk_base_release()).f2564p;
            vw internalEventPublisher = ((ci0) getUdm$android_sdk_base_release()).f2559k;
            kxVar.getClass();
            kotlin.jvm.internal.t.i(internalEventPublisher, "internalEventPublisher");
            if (kxVar.f3287b) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) kxVar, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) hx.f3007a, 6, (Object) null);
            } else {
                BrazeLogger brazeLogger2 = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger2, (Object) kxVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ix.f3108a, 7, (Object) null);
                List events = d0.P0(kxVar.f3286a.a());
                BrazeLogger.brazelog$default(brazeLogger2, (Object) kxVar, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new jx(events), 6, (Object) null);
                kotlin.jvm.internal.t.i(events, "events");
                internalEventPublisher.b(tr.class, new tr(2, events, null, null, 12));
            }
            v80 v80Var = ((ci0) getUdm$android_sdk_base_release()).E;
            v80Var.getClass();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) v80Var, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new t80(v80Var), 7, (Object) null);
            v80Var.f4087f = kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new j80(v80Var, null), 3, null);
            v00 v00Var = this.externalIEventMessenger;
            BrazeUser brazeUser2 = this.brazeUser;
            if (brazeUser2 == null) {
                kotlin.jvm.internal.t.A("brazeUser");
            } else {
                brazeUser = brazeUser2;
            }
            ((vw) v00Var).b(BrazeUserChangeEvent.class, new BrazeUserChangeEvent(brazeUser.getUserId()));
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifyProperSdkSetup() {
        boolean z10 = true;
        for (String str : NECESSARY_BRAZE_SDK_PERMISSIONS) {
            if (!PermissionUtils.hasPermission(this.applicationContext, str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new l7(str), 6, (Object) null);
                z10 = false;
            }
        }
        if (p9.q.z(getConfigurationProvider$android_sdk_base_release().getBrazeApiKey().f3835a)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) m7.f3394a, 6, (Object) null);
        } else if (z10) {
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) n7.f3471a, 6, (Object) null);
    }

    public final /* synthetic */ void addSerializedCardJsonToStorage$android_sdk_base_release(String serializedCardJson, String str) {
        kotlin.jvm.internal.t.i(serializedCardJson, "serializedCardJson");
        run$android_sdk_base_release$default(this, new p0(str, serializedCardJson), false, false, new r0(this, serializedCardJson, str), 6, null);
    }

    public <T> void addSingleSynchronousSubscription(IEventSubscriber<T> subscriber, Class<T> eventClass) {
        kotlin.jvm.internal.t.i(subscriber, "subscriber");
        kotlin.jvm.internal.t.i(eventClass, "eventClass");
        try {
            ((vw) this.externalIEventMessenger).c(subscriber, eventClass);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new s0(eventClass), 4, (Object) null);
            publishError(e10);
        }
    }

    public final /* synthetic */ void applyPendingRuntimeConfiguration$android_sdk_base_release() {
        ReentrantLock reentrantLock = brazeClassLock;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) t0.f3885a, 7, (Object) null);
            RuntimeAppConfigurationProvider runtimeAppConfigurationProvider = new RuntimeAppConfigurationProvider(this.applicationContext);
            for (BrazeConfig brazeConfig : pendingConfigurations) {
                if (kotlin.jvm.internal.t.d(brazeConfig, clearConfigSentinel)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) u0.f3979a, 6, (Object) null);
                    runtimeAppConfigurationProvider.clearAllConfigurationValues();
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new v0(brazeConfig), 6, (Object) null);
                    runtimeAppConfigurationProvider.setConfiguration(brazeConfig);
                }
            }
            pendingConfigurations.clear();
            k0 k0Var = k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void changeUser(String str) {
        changeUser(str, null);
    }

    public void closeSession(Activity activity) {
        run$android_sdk_base_release$default(this, k1.f3203a, false, false, new m1(activity, this), 6, null);
    }

    public final BrazeConfigurationProvider getConfigurationProvider$android_sdk_base_release() {
        BrazeConfigurationProvider brazeConfigurationProvider = this.configurationProvider;
        if (brazeConfigurationProvider != null) {
            return brazeConfigurationProvider;
        }
        kotlin.jvm.internal.t.A("configurationProvider");
        return null;
    }

    public final BrazeConfigurationProvider getConfigurationProviderSafe$android_sdk_base_release(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        if (this.configurationProvider != null) {
            return getConfigurationProvider$android_sdk_base_release();
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) c2.f2481a, 7, (Object) null);
        return new BrazeConfigurationProvider(context);
    }

    public void getCurrentUser(IValueCallback<BrazeUser> completionCallback) {
        kotlin.jvm.internal.t.i(completionCallback, "completionCallback");
        if (Companion.isDisabled()) {
            completionCallback.onError();
            return;
        }
        try {
            kotlinx.coroutines.k.d(qa0.f3696a, null, null, new h2(completionCallback, this, null), 3, null);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) i2.f3014a, 4, (Object) null);
            completionCallback.onError();
            publishError(e10);
        }
    }

    public final p00 getDeviceIdProvider$android_sdk_base_release() {
        p00 p00Var = this.deviceIdProvider;
        if (p00Var != null) {
            return p00Var;
        }
        kotlin.jvm.internal.t.A("deviceIdProvider");
        return null;
    }

    public final v00 getExternalIEventMessenger$android_sdk_base_release() {
        return this.externalIEventMessenger;
    }

    public IBrazeImageLoader getImageLoader() {
        IBrazeImageLoader iBrazeImageLoader = this.imageLoader;
        if (iBrazeImageLoader != null) {
            return iBrazeImageLoader;
        }
        kotlin.jvm.internal.t.A("imageLoader");
        return null;
    }

    public final s60 getPushDeliveryManager$android_sdk_base_release() {
        s60 s60Var = this.pushDeliveryManager;
        if (s60Var != null) {
            return s60Var;
        }
        kotlin.jvm.internal.t.A("pushDeliveryManager");
        return null;
    }

    public final l10 getUdm$android_sdk_base_release() {
        l10 l10Var = this.udm;
        if (l10Var != null) {
            return l10Var;
        }
        kotlin.jvm.internal.t.A("udm");
        return null;
    }

    public final /* synthetic */ void handleInAppMessageTestPush$android_sdk_base_release(Intent intent) {
        kotlin.jvm.internal.t.i(intent, "intent");
        run$android_sdk_base_release$default(this, o2.f3534a, false, false, new h0(intent, this), 6, null);
    }

    public final Boolean isApiKeyPresent$android_sdk_base_release() {
        return this.isApiKeyPresent;
    }

    public void logCustomEvent(String str, BrazeProperties brazeProperties) {
        run$android_sdk_base_release$default(this, new r2(str), false, false, new u2(str, this, brazeProperties != null ? brazeProperties.clone() : null), 6, null);
    }

    public void logFeedDisplayed() {
        run$android_sdk_base_release$default(this, d3.f2616a, false, false, new e3(this), 6, null);
    }

    public final /* synthetic */ void logLocationRecordedEventFromLocationUpdate$android_sdk_base_release(IBrazeLocation location) {
        kotlin.jvm.internal.t.i(location, "location");
        run$android_sdk_base_release$default(this, f3.f2764a, false, false, new g3(location, this), 6, null);
    }

    public void logPurchase(String str, String str2, BigDecimal bigDecimal, int i10, BrazeProperties brazeProperties) {
        run$android_sdk_base_release$default(this, new h3(str), false, false, new k3(str, str2, bigDecimal, i10, this, brazeProperties != null ? brazeProperties.clone() : null), 6, null);
    }

    public final /* synthetic */ void logPushDelivery$android_sdk_base_release(String campaignId, long j10) {
        kotlin.jvm.internal.t.i(campaignId, "campaignId");
        run$android_sdk_base_release$default(this, new l3(campaignId), false, false, new m3(this, campaignId, j10), 6, null);
    }

    public final /* synthetic */ void logPushMaxCampaign$android_sdk_base_release(String campaign) {
        kotlin.jvm.internal.t.i(campaign, "campaign");
        run$android_sdk_base_release$default(this, n3.f3462a, false, false, new o3(this, campaign), 6, null);
    }

    public void logPushNotificationActionClicked(String str, String str2, String str3) {
        run$android_sdk_base_release$default(this, p3.f3600a, false, false, new t3(str, this, str2, str3), 6, null);
    }

    public void logPushNotificationOpened(Intent intent) {
        run$android_sdk_base_release$default(this, new x3(intent), false, false, new i0(intent, this), 6, null);
    }

    public void logPushStoryPageClicked(String str, String str2) {
        run$android_sdk_base_release$default(this, new b4(str2, str), false, false, new d4(this, str, str2), 6, null);
    }

    public void openSession(Activity activity) {
        run$android_sdk_base_release$default(this, e4.f2702a, false, false, new g4(activity, this), 6, null);
    }

    public final /* synthetic */ void performPushDeliveryFlush$android_sdk_base_release() {
        run$android_sdk_base_release$default(this, h4.f2948a, false, false, new i4(this), 6, null);
    }

    public final /* synthetic */ void publishBrazePushAction$android_sdk_base_release(BrazePushEventType pushActionType, BrazeNotificationPayload payload) {
        kotlin.jvm.internal.t.i(pushActionType, "pushActionType");
        kotlin.jvm.internal.t.i(payload, "payload");
        ((vw) this.externalIEventMessenger).b(BrazePushEvent.class, new BrazePushEvent(pushActionType, payload));
    }

    public final /* synthetic */ void recordGeofenceTransition$android_sdk_base_release(String str, GeofenceTransitionType geofenceTransitionType) {
        run$android_sdk_base_release$default(this, l4.f3298a, false, false, new m4(str, geofenceTransitionType, this), 6, null);
    }

    public final void reenqueueInAppMessage$android_sdk_base_release(InAppMessageEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        run$android_sdk_base_release$default(this, new n4(event), false, false, new o4(this, event), 6, null);
    }

    public void refreshFeatureFlags() {
        run$android_sdk_base_release$default(this, p4.f3602a, false, false, new r4(this), 6, null);
    }

    public <T> void removeSingleSubscription(IEventSubscriber<T> iEventSubscriber, Class<T> eventClass) {
        kotlin.jvm.internal.t.i(eventClass, "eventClass");
        if (iEventSubscriber != null) {
            try {
                boolean zA = ((vw) this.externalIEventMessenger).a(iEventSubscriber, eventClass);
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.Priority priority = BrazeLogger.Priority.V;
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new y4(eventClass, iEventSubscriber, zA), 6, (Object) null);
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (h9.a) new z4(eventClass, iEventSubscriber, ((vw) this.externalIEventMessenger).b(iEventSubscriber, eventClass)), 6, (Object) null);
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) new a5(eventClass), 4, (Object) null);
                publishError(e10);
            }
        }
    }

    public void requestContentCardsRefresh() {
        run$android_sdk_base_release$default(this, b5.f2415a, false, false, new d5(this), 6, null);
    }

    public void requestContentCardsRefreshFromCache() {
        run$android_sdk_base_release$default(this, e5.f2703a, false, false, new f5(this), 6, null);
    }

    public void requestFeedRefresh() {
        run$android_sdk_base_release$default(this, g5.f2868a, false, false, new h5(this), 6, null);
    }

    public void requestFeedRefreshFromCache() {
        run$android_sdk_base_release$default(this, i5.f3020a, false, false, new j5(this), 6, null);
    }

    public final /* synthetic */ void requestGeofenceRefresh$android_sdk_base_release(boolean z10) {
        run$android_sdk_base_release$default(this, new n5(z10), false, false, new o5(this, z10), 6, null);
    }

    public final /* synthetic */ void requestGeofencesInitialization$android_sdk_base_release() {
        run$android_sdk_base_release$default(this, t5.f3895a, false, false, new u5(this), 6, null);
    }

    public void requestImmediateDataFlush() {
        run$android_sdk_base_release$default(this, v5.f4072a, false, false, new x5(this), 6, null);
    }

    public void requestLocationInitialization() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) y5.f4325a, 7, (Object) null);
        requestGeofencesInitialization$android_sdk_base_release();
        requestSingleLocationUpdate$android_sdk_base_release();
    }

    public final /* synthetic */ void requestSingleLocationUpdate$android_sdk_base_release() {
        run$android_sdk_base_release$default(this, z5.f4401a, false, false, new a6(this), 6, null);
    }

    public final /* synthetic */ void retryInAppMessage$android_sdk_base_release(InAppMessageEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        run$android_sdk_base_release$default(this, new b6(event), false, false, new c6(this, event), 6, null);
    }

    public final /* synthetic */ void run$android_sdk_base_release(h9.a errorLog, boolean z10, boolean z11, h9.a block) {
        kotlin.jvm.internal.t.i(errorLog, "errorLog");
        kotlin.jvm.internal.t.i(block, "block");
        if (z10) {
            try {
                if (Companion.isDisabled()) {
                    return;
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, errorLog, 4, (Object) null);
                publishError(e10);
                return;
            }
        }
        kotlinx.coroutines.k.d(qa0.f3696a, null, null, new f6(z11, this, block, errorLog, null), 3, null);
    }

    public final /* synthetic */ void schedulePushDelivery$android_sdk_base_release(long j10) {
        run$android_sdk_base_release$default(this, k6.f3218a, false, false, new l6(this, j10), 6, null);
    }

    public final void setApiKeyPresent$android_sdk_base_release(Boolean bool) {
        this.isApiKeyPresent = bool;
    }

    public final void setConfigurationProvider$android_sdk_base_release(BrazeConfigurationProvider brazeConfigurationProvider) {
        kotlin.jvm.internal.t.i(brazeConfigurationProvider, "<set-?>");
        this.configurationProvider = brazeConfigurationProvider;
    }

    public final void setDeviceIdProvider$android_sdk_base_release(p00 p00Var) {
        kotlin.jvm.internal.t.i(p00Var, "<set-?>");
        this.deviceIdProvider = p00Var;
    }

    public void setImageLoader(IBrazeImageLoader iBrazeImageLoader) {
        kotlin.jvm.internal.t.i(iBrazeImageLoader, "<set-?>");
        this.imageLoader = iBrazeImageLoader;
    }

    public final void setPushDeliveryManager$android_sdk_base_release(s60 s60Var) {
        kotlin.jvm.internal.t.i(s60Var, "<set-?>");
        this.pushDeliveryManager = s60Var;
    }

    public void setRegisteredPushToken(String str) {
        run$android_sdk_base_release$default(this, new u4(str), false, false, new x4(this, str), 6, null);
    }

    public final void setUdm$android_sdk_base_release(l10 l10Var) {
        kotlin.jvm.internal.t.i(l10Var, "<set-?>");
        this.udm = l10Var;
    }

    public void subscribeToContentCardsUpdates(IEventSubscriber<ContentCardsUpdatedEvent> subscriber) {
        kotlin.jvm.internal.t.i(subscriber, "subscriber");
        try {
            ((vw) this.externalIEventMessenger).d(subscriber, ContentCardsUpdatedEvent.class);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) x6.f4245a, 4, (Object) null);
            publishError(e10);
        }
    }

    public void subscribeToFeedUpdates(IEventSubscriber<FeedUpdatedEvent> subscriber) {
        kotlin.jvm.internal.t.i(subscriber, "subscriber");
        try {
            ((vw) this.externalIEventMessenger).d(subscriber, FeedUpdatedEvent.class);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) c7.f2488a, 4, (Object) null);
            publishError(e10);
        }
    }

    public void subscribeToNewInAppMessages(IEventSubscriber<InAppMessageEvent> subscriber) {
        kotlin.jvm.internal.t.i(subscriber, "subscriber");
        try {
            ((vw) this.externalIEventMessenger).d(subscriber, InAppMessageEvent.class);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) e7.f2711a, 4, (Object) null);
            publishError(e10);
        }
    }

    public void subscribeToNoMatchingTriggerForEvent(IEventSubscriber<NoMatchingTriggerEvent> subscriber) {
        kotlin.jvm.internal.t.i(subscriber, "subscriber");
        try {
            ((vw) this.externalIEventMessenger).d(subscriber, NoMatchingTriggerEvent.class);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (h9.a) f7.f2777a, 4, (Object) null);
            publishError(e10);
        }
    }

    public final /* synthetic */ boolean validateAndStorePushId$android_sdk_base_release(String pushId) {
        kotlin.jvm.internal.t.i(pushId, "pushId");
        return ((Boolean) runForResult$default(this, Boolean.TRUE, j7.f3134a, false, false, new k7(this, pushId, null), 12, null)).booleanValue();
    }

    public void changeUser(String str, String str2) {
        run$android_sdk_base_release$default(this, new a1(str), false, false, new g0(this, str, str2), 6, null);
    }
}
