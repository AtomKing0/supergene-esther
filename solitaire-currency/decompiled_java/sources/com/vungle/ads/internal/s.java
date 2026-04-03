package com.vungle.ads.internal;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.VungleAds;
import com.vungle.ads.b2;
import com.vungle.ads.i1;
import com.vungle.ads.internal.network.i;
import com.vungle.ads.internal.task.a;
import com.vungle.ads.l0;
import com.vungle.ads.m1;
import com.vungle.ads.r0;
import com.vungle.ads.u1;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: VungleInitializer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class s {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String TAG = "VungleInitializer";

    @NotNull
    private AtomicBoolean isInitialized = new AtomicBoolean(false);

    @NotNull
    private final CopyOnWriteArrayList<l0> initializationCallbackArray = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: VungleInitializer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class b extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.network.i> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
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
    public static final class d extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.executor.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.a, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.a invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.a.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class e extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.signals.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
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

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class f extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.task.f> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.task.f, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.task.f invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.task.f.class);
        }
    }

    /* JADX INFO: compiled from: VungleInitializer.kt */
    static final class g extends kotlin.jvm.internal.v implements h9.l<Boolean, k0> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return k0.f35197a;
        }

        public final void invoke(boolean z10) {
            if (z10) {
                s.this.downloadMraidJs(this.$context);
            }
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class h extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.util.q> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.q, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.util.q invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.util.q.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class i extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.downloader.e> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.downloader.e, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.downloader.e invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.downloader.e.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class j extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.executor.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.a, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.a invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.a.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class k extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.platform.d> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.platform.d, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.platform.d invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.platform.d.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class l extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.executor.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.a, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.a invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.a.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class m extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.network.i> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Context context) {
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

    private final void configure(Context context, String str) {
        boolean z10;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.p pVar = v8.p.f35201a;
        v8.l lVarB = v8.n.b(pVar, new b(context));
        try {
            v8.l lVarB2 = v8.n.b(pVar, new c(context));
            com.vungle.ads.internal.k kVar = com.vungle.ads.internal.k.INSTANCE;
            com.vungle.ads.internal.model.g cachedConfig = kVar.getCachedConfig(m4084configure$lambda6(lVarB2), str);
            if (cachedConfig != null) {
                com.vungle.ads.internal.k.initWithConfig$vungle_ads_release$default(kVar, context, cachedConfig, true, null, 8, null);
                z10 = true;
            } else {
                z10 = false;
            }
            com.vungle.ads.o.INSTANCE.init$vungle_ads_release(m4083configure$lambda5(lVarB), m4085configure$lambda7(v8.n.b(pVar, new d(context))).getLoggerExecutor(), kVar.getLogLevel(), kVar.getMetricsEnabled(), m4086configure$lambda8(v8.n.b(pVar, new e(context))));
            this.isInitialized.set(true);
            onInitSuccess();
            com.vungle.ads.internal.util.p.Companion.d(TAG, "Running cleanup and resend tpat jobs. " + Thread.currentThread().getId());
            v8.l lVarB3 = v8.n.b(pVar, new f(context));
            m4087configure$lambda9(lVarB3).execute(a.C0531a.makeJobInfo$default(com.vungle.ads.internal.task.a.Companion, null, 1, null));
            m4087configure$lambda9(lVarB3).execute(com.vungle.ads.internal.task.i.Companion.makeJobInfo());
            if (z10) {
                downloadMraidJs(context);
            } else {
                kVar.fetchConfigAsync$vungle_ads_release(context, new g(context));
            }
        } catch (Throwable th) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Cannot get config", th);
        }
    }

    /* JADX INFO: renamed from: configure$lambda-5, reason: not valid java name */
    private static final com.vungle.ads.internal.network.i m4083configure$lambda5(v8.l<com.vungle.ads.internal.network.i> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: configure$lambda-6, reason: not valid java name */
    private static final com.vungle.ads.internal.persistence.b m4084configure$lambda6(v8.l<com.vungle.ads.internal.persistence.b> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: configure$lambda-7, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.a m4085configure$lambda7(v8.l<? extends com.vungle.ads.internal.executor.a> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: configure$lambda-8, reason: not valid java name */
    private static final com.vungle.ads.internal.signals.b m4086configure$lambda8(v8.l<com.vungle.ads.internal.signals.b> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: configure$lambda-9, reason: not valid java name */
    private static final com.vungle.ads.internal.task.f m4087configure$lambda9(v8.l<? extends com.vungle.ads.internal.task.f> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadMraidJs(Context context) {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.p pVar = v8.p.f35201a;
        com.vungle.ads.internal.load.k.downloadJs$default(com.vungle.ads.internal.load.k.INSTANCE, m4088downloadMraidJs$lambda10(v8.n.b(pVar, new h(context))), m4089downloadMraidJs$lambda11(v8.n.b(pVar, new i(context))), m4090downloadMraidJs$lambda12(v8.n.b(pVar, new j(context))).getBackgroundExecutor(), null, 8, null);
    }

    /* JADX INFO: renamed from: downloadMraidJs$lambda-10, reason: not valid java name */
    private static final com.vungle.ads.internal.util.q m4088downloadMraidJs$lambda10(v8.l<com.vungle.ads.internal.util.q> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: downloadMraidJs$lambda-11, reason: not valid java name */
    private static final com.vungle.ads.internal.downloader.e m4089downloadMraidJs$lambda11(v8.l<? extends com.vungle.ads.internal.downloader.e> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: downloadMraidJs$lambda-12, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.a m4090downloadMraidJs$lambda12(v8.l<? extends com.vungle.ads.internal.executor.a> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    private static final com.vungle.ads.internal.platform.d m4091init$lambda0(v8.l<? extends com.vungle.ads.internal.platform.d> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: init$lambda-1, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.a m4092init$lambda1(v8.l<? extends com.vungle.ads.internal.executor.a> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: init$lambda-2, reason: not valid java name */
    private static final com.vungle.ads.internal.network.i m4093init$lambda2(v8.l<com.vungle.ads.internal.network.i> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: init$lambda-3, reason: not valid java name */
    public static final void m4094init$lambda3(Context context, String appId, s this$0, v8.l vungleApiClient$delegate) {
        kotlin.jvm.internal.t.i(context, "$context");
        kotlin.jvm.internal.t.i(appId, "$appId");
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(vungleApiClient$delegate, "$vungleApiClient$delegate");
        q7.c.INSTANCE.init(context);
        m4093init$lambda2(vungleApiClient$delegate).initialize(appId);
        this$0.configure(context, appId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: init$lambda-4, reason: not valid java name */
    public static final void m4095init$lambda4(s this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.onInitError(new m1("Config: Out of Memory").logError$vungle_ads_release());
    }

    private final boolean isAppIdInvalid(String str) {
        return p9.q.z(str);
    }

    private final void onInitError(final b2 b2Var) {
        com.vungle.ads.internal.util.v.INSTANCE.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.r
            @Override // java.lang.Runnable
            public final void run() {
                s.m4096onInitError$lambda14(this.f24383a, b2Var);
            }
        });
        String localizedMessage = b2Var.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "Exception code is " + b2Var.getCode();
        }
        com.vungle.ads.internal.util.p.Companion.e(TAG, localizedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onInitError$lambda-14, reason: not valid java name */
    public static final void m4096onInitError$lambda14(s this$0, b2 exception) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(exception, "$exception");
        com.vungle.ads.internal.util.p.Companion.e(TAG, "onError");
        Iterator<T> it = this$0.initializationCallbackArray.iterator();
        while (it.hasNext()) {
            ((l0) it.next()).onError(exception);
        }
        this$0.initializationCallbackArray.clear();
    }

    private final void onInitSuccess() {
        com.vungle.ads.internal.util.p.Companion.d(TAG, "onSuccess " + Thread.currentThread().getId());
        com.vungle.ads.internal.util.v.INSTANCE.runOnUiThread(new Runnable() { // from class: com.vungle.ads.internal.q
            @Override // java.lang.Runnable
            public final void run() {
                s.m4097onInitSuccess$lambda16(this.f24382a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onInitSuccess$lambda-16, reason: not valid java name */
    public static final void m4097onInitSuccess$lambda16(s this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        Iterator<T> it = this$0.initializationCallbackArray.iterator();
        while (it.hasNext()) {
            ((l0) it.next()).onSuccess();
        }
        this$0.initializationCallbackArray.clear();
    }

    public final void deInit$vungle_ads_release() {
        ServiceLocator.Companion.deInit();
        com.vungle.ads.internal.network.i.Companion.reset$vungle_ads_release();
        this.isInitialized.set(false);
    }

    public final void init(@NotNull final String appId, @NotNull final Context context, @NotNull l0 initializationCallback) {
        kotlin.jvm.internal.t.i(appId, "appId");
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(initializationCallback, "initializationCallback");
        this.initializationCallbackArray.add(initializationCallback);
        com.vungle.ads.internal.util.c.Companion.init(context);
        if (isAppIdInvalid(appId)) {
            onInitError(new r0().logError$vungle_ads_release());
            return;
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.p pVar = v8.p.f35201a;
        if (!m4091init$lambda0(v8.n.b(pVar, new k(context))).isAtLeastMinimumSDK()) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "SDK is supported only for API versions 21 and above");
            onInitError(new u1().logError$vungle_ads_release());
            return;
        }
        com.vungle.ads.internal.k.INSTANCE.setAppId$vungle_ads_release(appId);
        if (this.isInitialized.get()) {
            com.vungle.ads.internal.util.p.Companion.d(TAG, "init already complete");
            onInitSuccess();
        } else if (PermissionChecker.checkCallingOrSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0 || PermissionChecker.checkCallingOrSelfPermission(context, "android.permission.INTERNET") != 0) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Network permissions not granted");
            onInitError(new i1());
        } else {
            v8.l lVarB = v8.n.b(pVar, new l(context));
            final v8.l lVarB2 = v8.n.b(pVar, new m(context));
            m4092init$lambda1(lVarB).getBackgroundExecutor().execute(new Runnable() { // from class: com.vungle.ads.internal.o
                @Override // java.lang.Runnable
                public final void run() {
                    s.m4094init$lambda3(context, appId, this, lVarB2);
                }
            }, new Runnable() { // from class: com.vungle.ads.internal.p
                @Override // java.lang.Runnable
                public final void run() {
                    s.m4095init$lambda4(this.f24362a);
                }
            });
        }
    }

    public final boolean isInitialized() {
        return this.isInitialized.get();
    }

    @NotNull
    public final AtomicBoolean isInitialized$vungle_ads_release() {
        return this.isInitialized;
    }

    public final void setInitialized$vungle_ads_release(@NotNull AtomicBoolean atomicBoolean) {
        kotlin.jvm.internal.t.i(atomicBoolean, "<set-?>");
        this.isInitialized = atomicBoolean;
    }

    public final void setIntegrationName(@NotNull VungleAds.WrapperFramework wrapperFramework, @NotNull String wrapperFrameworkVersion) {
        String str;
        kotlin.jvm.internal.t.i(wrapperFramework, "wrapperFramework");
        kotlin.jvm.internal.t.i(wrapperFrameworkVersion, "wrapperFrameworkVersion");
        if (wrapperFramework == VungleAds.WrapperFramework.none) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Wrapper is null or is none");
            return;
        }
        i.b bVar = com.vungle.ads.internal.network.i.Companion;
        String headerUa = bVar.getHeaderUa();
        if (wrapperFrameworkVersion.length() > 0) {
            str = '/' + wrapperFrameworkVersion;
        } else {
            str = "";
        }
        String str2 = wrapperFramework.name() + str;
        if (p9.r.P(headerUa, str2, false, 2, null)) {
            com.vungle.ads.internal.util.p.Companion.w(TAG, "Wrapper info already set");
            return;
        }
        bVar.setHeaderUa(headerUa + ';' + str2);
        if (isInitialized()) {
            com.vungle.ads.internal.util.p.Companion.w(TAG, "VUNGLE WARNING: SDK already initialized, you should've set wrapper info before");
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void isInitialized$vungle_ads_release$annotations() {
    }
}
