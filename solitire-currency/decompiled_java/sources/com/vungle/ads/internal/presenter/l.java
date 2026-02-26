package com.vungle.ads.internal.presenter;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import androidx.annotation.VisibleForTesting;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.b2;
import com.vungle.ads.internal.model.f;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.ui.view.d;
import com.vungle.ads.internal.util.u;
import com.vungle.ads.m0;
import com.vungle.ads.v1;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: MRAIDPresenter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l implements d.a, d.b {

    @NotNull
    private static final String ACTION = "action";

    @NotNull
    public static final String ACTION_WITH_VALUE = "actionWithValue";

    @NotNull
    public static final String CLOSE = "close";

    @NotNull
    public static final String CONSENT_ACTION = "consentAction";

    @NotNull
    public static final String CREATIVE_HEARTBEAT = "creativeHeartbeat";

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    public static final String ERROR = "error";

    @NotNull
    public static final String GET_AVAILABLE_DISK_SPACE = "getAvailableDiskSpace";
    private static final double HEARTBEAT_INTERVAL = 6.0d;

    @NotNull
    public static final String OPEN = "open";

    @NotNull
    private static final String OPEN_NON_MRAID = "openNonMraid";

    @NotNull
    public static final String OPEN_PRIVACY = "openPrivacy";

    @NotNull
    public static final String SET_ORIENTATION_PROPERTIES = "setOrientationProperties";

    @NotNull
    public static final String SUCCESSFUL_VIEW = "successfulView";

    @NotNull
    private static final String TAG = "MRAIDPresenter";

    @NotNull
    public static final String TPAT = "tpat";

    @NotNull
    public static final String UPDATE_SIGNALS = "updateSignals";

    @NotNull
    private static final String USE_CUSTOM_CLOSE = "useCustomClose";

    @NotNull
    private static final String USE_CUSTOM_PRIVACY = "useCustomPrivacy";

    @NotNull
    public static final String VIDEO_LENGTH = "videoLength";

    @NotNull
    public static final String VIDEO_VIEWED = "videoViewed";

    @Nullable
    private Long adStartTime;
    private boolean adViewed;

    @NotNull
    private final com.vungle.ads.internal.ui.view.b adWidget;

    @NotNull
    private final com.vungle.ads.internal.model.b advertisement;
    private boolean backEnabled;

    @Nullable
    private final com.vungle.ads.internal.model.e bidPayload;

    @Nullable
    private com.vungle.ads.internal.presenter.a bus;

    @NotNull
    private final v8.l clickCoordinateTracker$delegate;

    @NotNull
    private Executor executor;

    @NotNull
    private final v8.l executors$delegate;
    private boolean heartbeatEnabled;

    @NotNull
    private final AtomicBoolean isDestroying;
    private long lastUserInteractionTimestamp;

    @NotNull
    private final com.vungle.ads.internal.omsdk.d omTracker;

    @NotNull
    private final v8.l pathProvider$delegate;

    @NotNull
    private final com.vungle.ads.internal.model.j placement;

    @NotNull
    private final com.vungle.ads.internal.platform.d platform;

    @Nullable
    private q presenterDelegate;

    @NotNull
    private final v8.l scheduler$delegate;

    @NotNull
    private final AtomicBoolean sendReportIncentivized;

    @NotNull
    private final v8.l signalManager$delegate;

    @NotNull
    private final v8.l suspendableTimer$delegate;

    @Nullable
    private String userId;

    @NotNull
    private final v8.l vungleApiClient$delegate;

    @NotNull
    private final com.vungle.ads.internal.ui.f vungleWebClient;

    /* JADX INFO: compiled from: MRAIDPresenter.kt */
    static final class b extends v implements h9.a<com.vungle.ads.internal.j> {
        b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.j invoke() {
            Context context = l.this.adWidget.getContext();
            t.h(context, "adWidget.context");
            return new com.vungle.ads.internal.j(context, l.this.advertisement, l.this.executor);
        }
    }

    /* JADX INFO: compiled from: MRAIDPresenter.kt */
    public static final class c implements com.vungle.ads.internal.ui.b {
        c() {
        }

        @Override // com.vungle.ads.internal.ui.b
        public void onDeeplinkClick(boolean z10) {
            List tpatUrls$default = com.vungle.ads.internal.model.b.getTpatUrls$default(l.this.advertisement, com.vungle.ads.internal.l.DEEPLINK_CLICK, String.valueOf(z10), null, 4, null);
            com.vungle.ads.internal.network.g gVar = new com.vungle.ads.internal.network.g(l.this.getVungleApiClient$vungle_ads_release(), l.this.placement.getReferenceId(), l.this.advertisement.getCreativeId(), l.this.advertisement.eventId(), l.this.getExecutors().getIoExecutor(), l.this.getPathProvider(), l.this.getSignalManager());
            if (tpatUrls$default != null) {
                l lVar = l.this;
                Iterator it = tpatUrls$default.iterator();
                while (it.hasNext()) {
                    gVar.sendTpat((String) it.next(), lVar.executor);
                }
            }
        }
    }

    /* JADX INFO: compiled from: MRAIDPresenter.kt */
    public static final class d implements com.vungle.ads.internal.network.b<Void> {
        d() {
        }

        @Override // com.vungle.ads.internal.network.b
        public void onFailure(@Nullable com.vungle.ads.internal.network.a<Void> aVar, @Nullable Throwable th) {
            com.vungle.ads.internal.util.p.Companion.d(l.TAG, "send RI Failure");
        }

        @Override // com.vungle.ads.internal.network.b
        public void onResponse(@Nullable com.vungle.ads.internal.network.a<Void> aVar, @Nullable com.vungle.ads.internal.network.d<Void> dVar) {
            com.vungle.ads.internal.util.p.Companion.d(l.TAG, "send RI success");
        }
    }

    /* JADX INFO: compiled from: MRAIDPresenter.kt */
    static final class e extends v implements h9.a<com.vungle.ads.internal.util.j> {
        public static final e INSTANCE = new e();

        e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.util.j invoke() {
            return new com.vungle.ads.internal.util.j();
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class f extends v implements h9.a<com.vungle.ads.internal.network.i> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context) {
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
    public static final class g extends v implements h9.a<com.vungle.ads.internal.executor.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context) {
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
    public static final class h extends v implements h9.a<com.vungle.ads.internal.util.q> {
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
    public static final class i extends v implements h9.a<com.vungle.ads.internal.signals.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Context context) {
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

    /* JADX INFO: compiled from: MRAIDPresenter.kt */
    static final class j extends v implements h9.a<u> {

        /* JADX INFO: compiled from: MRAIDPresenter.kt */
        static final class a extends v implements h9.a<k0> {
            final /* synthetic */ l this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(l lVar) {
                super(0);
                this.this$0 = lVar;
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                invoke2();
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(318, "Error ad template missing Heartbeat", this.this$0.placement.getReferenceId(), this.this$0.advertisement.getCreativeId(), this.this$0.advertisement.eventId());
                this.this$0.reportErrorAndCloseAd(new m0(b2.HEARTBEAT_ERROR, null, 2, null));
            }
        }

        j() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final u invoke() {
            return new u(l.HEARTBEAT_INTERVAL, true, null, new a(l.this), 4, null);
        }
    }

    public l(@NotNull com.vungle.ads.internal.ui.view.b adWidget, @NotNull com.vungle.ads.internal.model.b advertisement, @NotNull com.vungle.ads.internal.model.j placement, @NotNull com.vungle.ads.internal.ui.f vungleWebClient, @NotNull Executor executor, @NotNull com.vungle.ads.internal.omsdk.d omTracker, @Nullable com.vungle.ads.internal.model.e eVar, @NotNull com.vungle.ads.internal.platform.d platform) {
        t.i(adWidget, "adWidget");
        t.i(advertisement, "advertisement");
        t.i(placement, "placement");
        t.i(vungleWebClient, "vungleWebClient");
        t.i(executor, "executor");
        t.i(omTracker, "omTracker");
        t.i(platform, "platform");
        this.adWidget = adWidget;
        this.advertisement = advertisement;
        this.placement = placement;
        this.vungleWebClient = vungleWebClient;
        this.executor = executor;
        this.omTracker = omTracker;
        this.bidPayload = eVar;
        this.platform = platform;
        this.isDestroying = new AtomicBoolean(false);
        this.sendReportIncentivized = new AtomicBoolean(false);
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Context context = adWidget.getContext();
        t.h(context, "adWidget.context");
        v8.p pVar = v8.p.f35201a;
        this.vungleApiClient$delegate = v8.n.b(pVar, new f(context));
        Context context2 = adWidget.getContext();
        t.h(context2, "adWidget.context");
        this.executors$delegate = v8.n.b(pVar, new g(context2));
        Context context3 = adWidget.getContext();
        t.h(context3, "adWidget.context");
        this.pathProvider$delegate = v8.n.b(pVar, new h(context3));
        Context context4 = adWidget.getContext();
        t.h(context4, "adWidget.context");
        this.signalManager$delegate = v8.n.b(pVar, new i(context4));
        this.scheduler$delegate = v8.n.a(e.INSTANCE);
        this.suspendableTimer$delegate = v8.n.a(new j());
        this.clickCoordinateTracker$delegate = v8.n.a(new b());
    }

    private final void closeView() {
        Long l10 = this.adStartTime;
        if (l10 != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - l10.longValue();
            com.vungle.ads.internal.network.g gVar = new com.vungle.ads.internal.network.g(getVungleApiClient$vungle_ads_release(), this.placement.getReferenceId(), this.advertisement.getCreativeId(), this.advertisement.eventId(), getExecutors().getIoExecutor(), getPathProvider(), getSignalManager());
            List<String> tpatUrls = this.advertisement.getTpatUrls(com.vungle.ads.internal.l.AD_CLOSE_TPAT_KEY, String.valueOf(jCurrentTimeMillis), String.valueOf(this.platform.getVolumeLevel()));
            if (tpatUrls != null) {
                gVar.sendTpats(tpatUrls, this.executor);
            }
        }
        this.adWidget.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.vungle.ads.internal.executor.a getExecutors() {
        return (com.vungle.ads.internal.executor.a) this.executors$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.vungle.ads.internal.util.q getPathProvider() {
        return (com.vungle.ads.internal.util.q) this.pathProvider$delegate.getValue();
    }

    private final com.vungle.ads.internal.util.j getScheduler() {
        return (com.vungle.ads.internal.util.j) this.scheduler$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.vungle.ads.internal.signals.b getSignalManager() {
        return (com.vungle.ads.internal.signals.b) this.signalManager$delegate.getValue();
    }

    private final void handleWebViewException(b2 b2Var, boolean z10, String str) {
        com.vungle.ads.internal.util.p.Companion.e(TAG, "handleWebViewException: " + b2Var.getLocalizedMessage() + ", fatal: " + z10 + ", errorMsg: " + str);
        if (z10) {
            makeBusError(b2Var);
            closeView();
        }
    }

    static /* synthetic */ void handleWebViewException$default(l lVar, b2 b2Var, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = null;
        }
        lVar.handleWebViewException(b2Var, z10, str);
    }

    private final boolean loadMraid(File file) {
        File file2 = new File(file.getPath(), com.vungle.ads.internal.l.AD_INDEX_FILE_NAME);
        if (file2.exists()) {
            this.adWidget.showWebsite(com.vungle.ads.internal.model.b.FILE_SCHEME + file2.getPath());
            return true;
        }
        com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(310, "Fail to load html " + file2.getPath(), this.placement.getReferenceId(), this.advertisement.getCreativeId(), this.advertisement.eventId());
        return false;
    }

    private final void makeBusError(b2 b2Var) {
        com.vungle.ads.internal.presenter.a aVar = this.bus;
        if (aVar != null) {
            aVar.onError(b2Var, this.placement.getReferenceId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepare$lambda-14, reason: not valid java name */
    public static final void m4073prepare$lambda14(l this$0) {
        t.i(this$0, "this$0");
        this$0.backEnabled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: processCommand$lambda-10, reason: not valid java name */
    public static final void m4074processCommand$lambda10(l this$0, boolean z10, String str, String str2) {
        t.i(this$0, "this$0");
        this$0.handleWebViewException(new m0(b2.CREATIVE_ERROR, null, 2, null), z10, str + " : " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: processCommand$lambda-11, reason: not valid java name */
    public static final void m4075processCommand$lambda11(l this$0) {
        t.i(this$0, "this$0");
        this$0.getSuspendableTimer$vungle_ads_release().reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: processCommand$lambda-12, reason: not valid java name */
    public static final void m4076processCommand$lambda12(l this$0, long j10) {
        t.i(this$0, "this$0");
        this$0.vungleWebClient.notifyDiskAvailableSize(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: processCommand$lambda-3, reason: not valid java name */
    public static final void m4077processCommand$lambda3(l this$0) {
        t.i(this$0, "this$0");
        this$0.closeView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: processCommand$lambda-6, reason: not valid java name */
    public static final void m4078processCommand$lambda6(l this$0) {
        t.i(this$0, "this$0");
        this$0.vungleWebClient.notifyPropertiesChange(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: processCommand$lambda-7, reason: not valid java name */
    public static final void m4079processCommand$lambda7(l this$0) {
        t.i(this$0, "this$0");
        this$0.adWidget.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: processCommand$lambda-9, reason: not valid java name */
    public static final void m4080processCommand$lambda9(l this$0) {
        t.i(this$0, "this$0");
        String referenceId = this$0.placement.getReferenceId();
        List list = null;
        f.b bVar = null;
        com.vungle.ads.internal.network.a<Void> aVarRi = this$0.getVungleApiClient$vungle_ads_release().ri(new f.i(list, bVar, this$0.adStartTime, this$0.advertisement.advAppId(), referenceId, this$0.userId, 3, (kotlin.jvm.internal.k) null));
        if (aVarRi == null) {
            com.vungle.ads.internal.util.p.Companion.e(TAG, "Invalid ri call.");
        } else {
            aVarRi.enqueue(new d());
        }
    }

    private final void recordPlayAssetMetric() {
        com.vungle.ads.o.INSTANCE.logMetric$vungle_ads_release(new v1(this.advertisement.getAssetsFullyDownloaded() ? Sdk$SDKMetric.b.LOCAL_ASSETS_USED : Sdk$SDKMetric.b.REMOTE_ASSETS_USED), (30 & 2) != 0 ? null : this.placement.getReferenceId(), (30 & 4) != 0 ? null : this.advertisement.getCreativeId(), (30 & 8) != 0 ? null : this.advertisement.eventId(), (30 & 16) != 0 ? null : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportErrorAndCloseAd(b2 b2Var) {
        makeBusError(b2Var);
        closeView();
    }

    public final void detach(int i10) {
        com.vungle.ads.internal.presenter.a aVar;
        com.vungle.ads.internal.util.p.Companion.d(TAG, "detach()");
        boolean z10 = (i10 & 1) != 0;
        boolean z11 = (i10 & 2) != 0;
        this.vungleWebClient.setWebViewObserver(null);
        this.vungleWebClient.setMraidDelegate(null);
        if (!z10 && z11 && !this.isDestroying.getAndSet(true) && (aVar = this.bus) != null) {
            aVar.onNext(TtmlNode.END, null, this.placement.getReferenceId());
        }
        this.adWidget.destroyWebView(this.omTracker.stop());
        if (this.heartbeatEnabled) {
            getSuspendableTimer$vungle_ads_release().cancel();
        }
    }

    @Nullable
    public final Long getAdStartTime$vungle_ads_release() {
        return this.adStartTime;
    }

    public final boolean getBackEnabled$vungle_ads_release() {
        return this.backEnabled;
    }

    @Nullable
    public final com.vungle.ads.internal.presenter.a getBus() {
        return this.bus;
    }

    @NotNull
    public final com.vungle.ads.internal.j getClickCoordinateTracker$vungle_ads_release() {
        return (com.vungle.ads.internal.j) this.clickCoordinateTracker$delegate.getValue();
    }

    public final boolean getHeartbeatEnabled$vungle_ads_release() {
        return this.heartbeatEnabled;
    }

    public final long getLastUserInteractionTimestamp$vungle_ads_release() {
        return this.lastUserInteractionTimestamp;
    }

    @NotNull
    public final u getSuspendableTimer$vungle_ads_release() {
        return (u) this.suspendableTimer$delegate.getValue();
    }

    @Nullable
    public final String getUserId$vungle_ads_release() {
        return this.userId;
    }

    @NotNull
    public final com.vungle.ads.internal.network.i getVungleApiClient$vungle_ads_release() {
        return (com.vungle.ads.internal.network.i) this.vungleApiClient$delegate.getValue();
    }

    public final void handleExit() {
        if (this.backEnabled) {
            this.adWidget.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
        }
    }

    @NotNull
    public final AtomicBoolean isDestroying$vungle_ads_release() {
        return this.isDestroying;
    }

    @Override // com.vungle.ads.internal.ui.view.d.b
    public void onReceivedError(@NotNull String errorDesc, boolean z10) {
        t.i(errorDesc, "errorDesc");
        if (z10) {
            reportErrorAndCloseAd(new m0(b2.AD_RENDER_NETWORK_ERROR, null, 2, null));
        }
    }

    @Override // com.vungle.ads.internal.ui.view.d.b
    public void onRenderProcessUnresponsive(@Nullable WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException$default(this, new m0(b2.WEBVIEW_RENDER_UNRESPONSIVE, null, 2, null), true, null, 4, null);
    }

    public final void onViewConfigurationChanged() {
        this.vungleWebClient.notifyPropertiesChange(true);
    }

    public final void onViewTouched(@Nullable MotionEvent motionEvent) {
        if (motionEvent != null) {
            com.vungle.ads.internal.util.p.Companion.d(TAG, "user interaction");
            this.lastUserInteractionTimestamp = System.currentTimeMillis();
            getClickCoordinateTracker$vungle_ads_release().trackCoordinate(motionEvent);
        }
    }

    @Override // com.vungle.ads.internal.ui.view.d.b
    public boolean onWebRenderingProcessGone(@Nullable WebView webView, @Nullable Boolean bool) {
        handleWebViewException$default(this, new m0(b2.WEB_CRASH, null, 2, null), true, null, 4, null);
        return true;
    }

    public final void prepare() {
        String alertTitleText;
        String alertBodyText;
        String alertContinueButtonText;
        String alertCloseButtonText;
        int settings;
        boolean z10 = false;
        this.isDestroying.set(false);
        this.adWidget.linkWebView(this.vungleWebClient);
        com.vungle.ads.c adConfig = this.advertisement.getAdConfig();
        if (adConfig != null && (settings = adConfig.getSettings()) > 0) {
            this.backEnabled = (settings & 2) == 2;
        }
        this.heartbeatEnabled = this.advertisement.heartbeatEnabled();
        com.vungle.ads.c adConfig2 = this.advertisement.getAdConfig();
        Integer numValueOf = adConfig2 != null ? Integer.valueOf(adConfig2.getAdOrientation()) : null;
        this.adWidget.setOrientation((numValueOf != null && numValueOf.intValue() == 0) ? 7 : (numValueOf != null && numValueOf.intValue() == 1) ? 6 : 4);
        this.omTracker.start();
        this.vungleWebClient.setMraidDelegate(this);
        this.vungleWebClient.setErrorHandler(this);
        File assetDirectory = this.advertisement.getAssetDirectory();
        if (assetDirectory == null || !assetDirectory.exists()) {
            reportErrorAndCloseAd(new com.vungle.ads.h());
            return;
        }
        if (!loadMraid(assetDirectory)) {
            reportErrorAndCloseAd(new com.vungle.ads.h());
            return;
        }
        this.adStartTime = Long.valueOf(System.currentTimeMillis());
        q qVar = this.presenterDelegate;
        this.userId = qVar != null ? qVar.getUserId() : null;
        q qVar2 = this.presenterDelegate;
        if (qVar2 == null || (alertTitleText = qVar2.getAlertTitleText()) == null) {
            alertTitleText = "";
        }
        q qVar3 = this.presenterDelegate;
        if (qVar3 == null || (alertBodyText = qVar3.getAlertBodyText()) == null) {
            alertBodyText = "";
        }
        q qVar4 = this.presenterDelegate;
        if (qVar4 == null || (alertContinueButtonText = qVar4.getAlertContinueButtonText()) == null) {
            alertContinueButtonText = "";
        }
        q qVar5 = this.presenterDelegate;
        if (qVar5 == null || (alertCloseButtonText = qVar5.getAlertCloseButtonText()) == null) {
            alertCloseButtonText = "";
        }
        this.advertisement.setIncentivizedText(alertTitleText, alertBodyText, alertContinueButtonText, alertCloseButtonText);
        com.vungle.ads.internal.k kVar = com.vungle.ads.internal.k.INSTANCE;
        if (kVar.getGDPRIsCountryDataProtected() && t.d("unknown", q7.c.INSTANCE.getConsentStatus())) {
            z10 = true;
        }
        this.vungleWebClient.setConsentStatus(z10, kVar.getGDPRConsentTitle(), kVar.getGDPRConsentMessage(), kVar.getGDPRButtonAccept(), kVar.getGDPRButtonDeny());
        if (z10) {
            q7.c.INSTANCE.updateGdprConsent("opted_out_by_timeout", "vungle_modal", "");
        }
        int showCloseDelay = this.advertisement.getShowCloseDelay(Boolean.valueOf(this.placement.isRewardedVideo()));
        if (showCloseDelay > 0) {
            getScheduler().schedule(new Runnable() { // from class: com.vungle.ads.internal.presenter.d
                @Override // java.lang.Runnable
                public final void run() {
                    l.m4073prepare$lambda14(this.f24368a);
                }
            }, showCloseDelay);
        } else {
            this.backEnabled = true;
        }
        com.vungle.ads.internal.presenter.a aVar = this.bus;
        if (aVar != null) {
            aVar.onNext(TtmlNode.START, null, this.placement.getReferenceId());
        }
        if (this.heartbeatEnabled) {
            getSuspendableTimer$vungle_ads_release().start();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0260, code lost:
    
        if (r11 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0266, code lost:
    
        if (r11.length() != 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0269, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x026b, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x026c, code lost:
    
        if (r2 == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x026e, code lost:
    
        if (r1 == null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0274, code lost:
    
        if (r1.length() != 0) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0276, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0277, code lost:
    
        if (r10 == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0279, code lost:
    
        com.vungle.ads.internal.util.p.Companion.e(com.vungle.ads.internal.presenter.l.TAG, "CTA destination URL is not configured properly");
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0281, code lost:
    
        r2 = r21.adWidget.getContext();
        kotlin.jvm.internal.t.h(r2, "adWidget.context");
        com.vungle.ads.internal.util.f.launch(r11, r1, r2, new com.vungle.ads.internal.ui.c(r21.bus, r21.placement.getReferenceId()), new com.vungle.ads.internal.presenter.l.c(r21));
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x029f, code lost:
    
        r1 = r21.bus;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02a1, code lost:
    
        if (r1 == null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02a3, code lost:
    
        r1.onNext("open", "adClick", r21.placement.getReferenceId());
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0204, code lost:
    
        if (r22.equals("open") == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0219, code lost:
    
        if (r22.equals(com.vungle.ads.internal.presenter.l.OPEN_NON_MRAID) == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x021d, code lost:
    
        r1 = r21.advertisement.adUnit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0223, code lost:
    
        if (r1 == null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0225, code lost:
    
        r11 = r1.getDeeplinkUrl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0229, code lost:
    
        r1 = com.vungle.ads.internal.util.o.INSTANCE.getContentStringValue(r23, "url");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0235, code lost:
    
        if (shouldBlockAutoRedirect$vungle_ads_release() == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0237, code lost:
    
        r21.lastUserInteractionTimestamp = 0;
        com.vungle.ads.o.INSTANCE.logMetric$vungle_ads_release(new com.vungle.ads.v1(com.vungle.ads.internal.protos.Sdk$SDKMetric.b.BANNER_AUTO_REDIRECT), (30 & 2) != 0 ? null : r21.placement.getReferenceId(), (30 & 4) != 0 ? null : r21.advertisement.getCreativeId(), (30 & 8) != 0 ? null : r21.advertisement.eventId(), (30 & 16) != 0 ? null : null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x025e, code lost:
    
        r21.lastUserInteractionTimestamp = 0;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x039f  */
    @Override // com.vungle.ads.internal.ui.view.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean processCommand(@org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.NotNull kotlinx.serialization.json.JsonObject r23) {
        /*
            Method dump skipped, instruction units count: 1224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.presenter.l.processCommand(java.lang.String, kotlinx.serialization.json.JsonObject):boolean");
    }

    public final void setAdStartTime$vungle_ads_release(@Nullable Long l10) {
        this.adStartTime = l10;
    }

    public final void setAdVisibility(boolean z10) {
        this.vungleWebClient.setAdVisibility(z10);
    }

    public final void setBackEnabled$vungle_ads_release(boolean z10) {
        this.backEnabled = z10;
    }

    public final void setBus(@Nullable com.vungle.ads.internal.presenter.a aVar) {
        this.bus = aVar;
    }

    public final void setEventListener(@Nullable com.vungle.ads.internal.presenter.a aVar) {
        this.bus = aVar;
    }

    public final void setHeartbeatEnabled$vungle_ads_release(boolean z10) {
        this.heartbeatEnabled = z10;
    }

    public final void setLastUserInteractionTimestamp$vungle_ads_release(long j10) {
        this.lastUserInteractionTimestamp = j10;
    }

    public final void setPresenterDelegate$vungle_ads_release(@Nullable q qVar) {
        this.presenterDelegate = qVar;
    }

    public final void setUserId$vungle_ads_release(@Nullable String str) {
        this.userId = str;
    }

    public final boolean shouldBlockAutoRedirect$vungle_ads_release() {
        com.vungle.ads.internal.k kVar = com.vungle.ads.internal.k.INSTANCE;
        if (kVar.allowAutoRedirects()) {
            return false;
        }
        if (this.placement.isBanner() || this.placement.isMREC() || this.placement.isInline()) {
            return this.lastUserInteractionTimestamp == 0 || System.currentTimeMillis() - this.lastUserInteractionTimestamp > kVar.afterClickDuration();
        }
        return false;
    }

    public final void start() {
        com.vungle.ads.internal.util.p.Companion.d(TAG, "start()");
        this.adWidget.resumeWeb();
        setAdVisibility(true);
        if (this.advertisement.adLoadOptimizationEnabled()) {
            recordPlayAssetMetric();
        }
    }

    public final void stop() {
        com.vungle.ads.internal.util.p.Companion.d(TAG, "stop()");
        this.adWidget.pauseWeb();
        setAdVisibility(false);
    }

    /* JADX INFO: compiled from: MRAIDPresenter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getACTION_WITH_VALUE$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getCLOSE$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getCONSENT_ACTION$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getCREATIVE_HEARTBEAT$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getERROR$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getGET_AVAILABLE_DISK_SPACE$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getOPEN$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getOPEN_PRIVACY$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getSET_ORIENTATION_PROPERTIES$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getSUCCESSFUL_VIEW$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getTPAT$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getUPDATE_SIGNALS$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getVIDEO_LENGTH$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getVIDEO_VIEWED$vungle_ads_release$annotations() {
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getAdStartTime$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBackEnabled$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBus$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getClickCoordinateTracker$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getHeartbeatEnabled$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLastUserInteractionTimestamp$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getSuspendableTimer$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getUserId$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getVungleApiClient$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void isDestroying$vungle_ads_release$annotations() {
    }
}
