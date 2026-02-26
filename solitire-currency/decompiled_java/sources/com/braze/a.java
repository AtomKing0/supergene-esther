package com.braze;

import android.content.Context;
import bo.app.ci0;
import bo.app.d0;
import bo.app.e0;
import bo.app.e50;
import bo.app.f0;
import bo.app.g;
import bo.app.i70;
import bo.app.j0;
import bo.app.jr;
import bo.app.k0;
import bo.app.l;
import bo.app.l0;
import bo.app.m0;
import bo.app.mz;
import bo.app.n0;
import bo.app.p00;
import bo.app.s60;
import bo.app.v00;
import bo.app.yy;
import bo.app.z00;
import com.amazon.device.messaging.development.ADMManifest;
import com.braze.Braze;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f8062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f8063b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Braze braze, Context context) {
        super(0);
        this.f8062a = braze;
        this.f8063b = context;
    }

    @Override // h9.a
    public final Object invoke() {
        e50 e50Var;
        z00 z00Var;
        this.f8062a.applyPendingRuntimeConfiguration$android_sdk_base_release();
        this.f8062a.setConfigurationProvider$android_sdk_base_release(new BrazeConfigurationProvider(this.f8062a.applicationContext));
        Braze braze = this.f8062a;
        Braze.Companion companion = Braze.Companion;
        String configuredApiKey = companion.getConfiguredApiKey(braze.getConfigurationProvider$android_sdk_base_release());
        braze.setApiKeyPresent$android_sdk_base_release(Boolean.valueOf(!(configuredApiKey == null || p9.q.z(configuredApiKey))));
        BrazeLogger.setInitialLogLevelFromConfiguration(this.f8062a.getConfigurationProvider$android_sdk_base_release().getLoggerInitialLogLevel());
        BrazeLogger.checkForSystemLogLevelProperty$default(false, 1, null);
        if (companion.getSdkEnablementProvider(this.f8063b).a()) {
            companion.setOutboundNetworkRequestsOffline(true);
        }
        String str = this.f8062a.getConfigurationProvider$android_sdk_base_release().getBrazeApiKey().f3835a;
        Braze braze2 = this.f8062a;
        braze2.setPushDeliveryManager$android_sdk_base_release(new s60(braze2.applicationContext, str));
        Braze braze3 = this.f8062a;
        braze3.setDeviceIdProvider$android_sdk_base_release(new jr(braze3.applicationContext, str));
        Braze braze4 = this.f8062a;
        braze4.offlineUserStorageProvider = new e50(braze4.applicationContext);
        Braze braze5 = this.f8062a;
        braze5.registrationDataProvider = new i70(braze5.applicationContext, this.f8062a.getConfigurationProvider$android_sdk_base_release());
        String customEndpoint = this.f8062a.getConfigurationProvider$android_sdk_base_release().getCustomEndpoint();
        if (customEndpoint != null && !p9.q.z(customEndpoint)) {
            companion.setConfiguredCustomEndpoint$android_sdk_base_release(this.f8062a.getConfigurationProvider$android_sdk_base_release().getCustomEndpoint());
        }
        try {
            if (this.f8062a.getConfigurationProvider$android_sdk_base_release().isFirebaseCloudMessagingRegistrationEnabled()) {
                Context context = this.f8063b;
                z00 z00Var2 = this.f8062a.registrationDataProvider;
                if (z00Var2 == null) {
                    kotlin.jvm.internal.t.A("registrationDataProvider");
                    z00Var2 = null;
                }
                mz mzVar = new mz(context, z00Var2);
                if (!h.a(context)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) mzVar, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) yy.f4386a, 6, (Object) null);
                } else if (((Boolean) mzVar.f3457c.getValue()).booleanValue() || ((Boolean) mzVar.f3456b.getValue()).booleanValue()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8062a, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) bo.app.g0.f2851a, 6, (Object) null);
                    String firebaseCloudMessagingSenderIdKey = this.f8062a.getConfigurationProvider$android_sdk_base_release().getFirebaseCloudMessagingSenderIdKey();
                    if (firebaseCloudMessagingSenderIdKey != null) {
                        mzVar.a(firebaseCloudMessagingSenderIdKey);
                    }
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8062a, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) bo.app.h0.f2941a, 6, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8062a, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) bo.app.i0.f3010a, 6, (Object) null);
            }
            if (this.f8062a.getConfigurationProvider$android_sdk_base_release().isAdmMessagingRegistrationEnabled()) {
                bo.app.i iVar = l.f3290c;
                Context context2 = this.f8062a.applicationContext;
                kotlin.jvm.internal.t.i(context2, "context");
                try {
                    Class.forName("com.amazon.device.messaging.ADM");
                } catch (Exception unused) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) iVar, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) g.f2850a, 6, (Object) null);
                }
                try {
                    ADMManifest.checkManifestAuthoredProperly(context2);
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8062a, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) j0.f3111a, 6, (Object) null);
                    Context context3 = this.f8062a.applicationContext;
                    z00 z00Var3 = this.f8062a.registrationDataProvider;
                    if (z00Var3 == null) {
                        kotlin.jvm.internal.t.A("registrationDataProvider");
                        z00Var3 = null;
                    }
                    new l(context3, z00Var3).a();
                } catch (Exception e10) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) iVar, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new bo.app.h(e10), 6, (Object) null);
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8062a, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) k0.f3187a, 6, (Object) null);
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8062a, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) l0.f3293a, 6, (Object) null);
            }
            this.f8062a.verifyProperSdkSetup();
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8062a, BrazeLogger.Priority.E, (Throwable) e11, false, (h9.a) m0.f3381a, 4, (Object) null);
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        Braze braze6 = this.f8062a;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) braze6, priority, (Throwable) null, false, (h9.a) n0.f3460a, 6, (Object) null);
        try {
            Braze braze7 = this.f8062a;
            Context context4 = braze7.applicationContext;
            e50 e50Var2 = this.f8062a.offlineUserStorageProvider;
            if (e50Var2 == null) {
                kotlin.jvm.internal.t.A("offlineUserStorageProvider");
                e50Var = null;
            } else {
                e50Var = e50Var2;
            }
            BrazeConfigurationProvider configurationProvider$android_sdk_base_release = this.f8062a.getConfigurationProvider$android_sdk_base_release();
            v00 externalIEventMessenger$android_sdk_base_release = this.f8062a.getExternalIEventMessenger$android_sdk_base_release();
            p00 deviceIdProvider$android_sdk_base_release = this.f8062a.getDeviceIdProvider$android_sdk_base_release();
            z00 z00Var4 = this.f8062a.registrationDataProvider;
            if (z00Var4 == null) {
                kotlin.jvm.internal.t.A("registrationDataProvider");
                z00Var = null;
            } else {
                z00Var = z00Var4;
            }
            braze7.setUserSpecificMemberVariablesAndStartDispatch(new ci0(context4, e50Var, configurationProvider$android_sdk_base_release, externalIEventMessenger$android_sdk_base_release, deviceIdProvider$android_sdk_base_release, z00Var, this.f8062a.getPushDeliveryManager$android_sdk_base_release(), Braze.shouldMockNetworkRequestsAndDropEvents, Braze.areOutboundNetworkRequestsOffline, this.f8062a.getDeviceDataProvider(), Braze.Companion.getShouldRequestFrameworkListenToNetworkUpdates$android_sdk_base_release()));
            BrazeLogger.brazelog$default(brazeLogger, (Object) this.f8062a, priority, (Throwable) null, false, (h9.a) d0.f2612a, 6, (Object) null);
        } catch (Exception e12) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8062a, BrazeLogger.Priority.E, (Throwable) e12, false, (h9.a) e0.f2696a, 4, (Object) null);
            this.f8062a.publishError(e12);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8062a, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) f0.f2761a, 6, (Object) null);
        return v8.k0.f35197a;
    }
}
