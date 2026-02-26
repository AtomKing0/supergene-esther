package com.vungle.ads.internal.presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.b2;
import com.vungle.ads.internal.model.b;
import com.vungle.ads.p1;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeAdPresenter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    public static final String DOWNLOAD = "download";

    @NotNull
    public static final String OPEN_PRIVACY = "openPrivacy";

    @NotNull
    private static final String TAG = "NativeAdPresenter";

    @NotNull
    public static final String TPAT = "tpat";

    @NotNull
    public static final String VIDEO_VIEWED = "videoViewed";

    @Nullable
    private Long adStartTime;
    private boolean adViewed;

    @Nullable
    private final com.vungle.ads.internal.model.b advertisement;

    @Nullable
    private com.vungle.ads.internal.presenter.a bus;

    @NotNull
    private final Context context;

    @Nullable
    private Dialog currentDialog;

    @NotNull
    private final p delegate;

    @NotNull
    private Executor executor;

    @NotNull
    private final v8.l executors$delegate;

    @Nullable
    private com.vungle.ads.internal.omsdk.a omTracker;

    @NotNull
    private final v8.l pathProvider$delegate;

    @NotNull
    private final com.vungle.ads.internal.platform.d platform;

    @NotNull
    private final v8.l signalManager$delegate;

    @NotNull
    private final v8.l vungleApiClient$delegate;

    /* JADX INFO: compiled from: NativeAdPresenter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: NativeAdPresenter.kt */
    public static final class b implements com.vungle.ads.internal.ui.b {
        final /* synthetic */ com.vungle.ads.internal.network.g $tpatSender;

        b(com.vungle.ads.internal.network.g gVar) {
            this.$tpatSender = gVar;
        }

        @Override // com.vungle.ads.internal.ui.b
        public void onDeeplinkClick(boolean z10) {
            com.vungle.ads.internal.model.b bVar = o.this.advertisement;
            List tpatUrls$default = bVar != null ? com.vungle.ads.internal.model.b.getTpatUrls$default(bVar, com.vungle.ads.internal.l.DEEPLINK_CLICK, String.valueOf(z10), null, 4, null) : null;
            if (tpatUrls$default != null) {
                com.vungle.ads.internal.network.g gVar = this.$tpatSender;
                o oVar = o.this;
                Iterator it = tpatUrls$default.iterator();
                while (it.hasNext()) {
                    gVar.sendTpat((String) it.next(), oVar.executor);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class c extends v implements h9.a<com.vungle.ads.internal.network.i> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
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
    public static final class d extends v implements h9.a<com.vungle.ads.internal.executor.a> {
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
    public static final class e extends v implements h9.a<com.vungle.ads.internal.util.q> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
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
    public static final class f extends v implements h9.a<com.vungle.ads.internal.signals.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context) {
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

    public o(@NotNull Context context, @NotNull p delegate, @Nullable com.vungle.ads.internal.model.b bVar, @NotNull Executor executor, @NotNull com.vungle.ads.internal.platform.d platform) {
        t.i(context, "context");
        t.i(delegate, "delegate");
        t.i(executor, "executor");
        t.i(platform, "platform");
        this.context = context;
        this.delegate = delegate;
        this.advertisement = bVar;
        this.executor = executor;
        this.platform = platform;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.p pVar = v8.p.f35201a;
        this.vungleApiClient$delegate = v8.n.b(pVar, new c(context));
        this.executors$delegate = v8.n.b(pVar, new d(context));
        this.pathProvider$delegate = v8.n.b(pVar, new e(context));
        this.signalManager$delegate = v8.n.b(pVar, new f(context));
    }

    private final com.vungle.ads.internal.executor.a getExecutors() {
        return (com.vungle.ads.internal.executor.a) this.executors$delegate.getValue();
    }

    private final com.vungle.ads.internal.util.q getPathProvider() {
        return (com.vungle.ads.internal.util.q) this.pathProvider$delegate.getValue();
    }

    private final com.vungle.ads.internal.signals.b getSignalManager() {
        return (com.vungle.ads.internal.signals.b) this.signalManager$delegate.getValue();
    }

    private final com.vungle.ads.internal.network.i getVungleApiClient() {
        return (com.vungle.ads.internal.network.i) this.vungleApiClient$delegate.getValue();
    }

    private final boolean needShowGdpr() {
        return com.vungle.ads.internal.k.INSTANCE.getGDPRIsCountryDataProtected() && t.d("unknown", q7.c.INSTANCE.getConsentStatus());
    }

    private final void onDownload(String str) {
        b.c cVarAdUnit;
        com.vungle.ads.internal.model.b bVar = this.advertisement;
        List tpatUrls$default = bVar != null ? com.vungle.ads.internal.model.b.getTpatUrls$default(bVar, "clickUrl", null, null, 6, null) : null;
        com.vungle.ads.internal.network.i vungleApiClient = getVungleApiClient();
        String placementRefId = this.delegate.getPlacementRefId();
        com.vungle.ads.internal.model.b bVar2 = this.advertisement;
        String creativeId = bVar2 != null ? bVar2.getCreativeId() : null;
        com.vungle.ads.internal.model.b bVar3 = this.advertisement;
        com.vungle.ads.internal.network.g gVar = new com.vungle.ads.internal.network.g(vungleApiClient, placementRefId, creativeId, bVar3 != null ? bVar3.eventId() : null, getExecutors().getIoExecutor(), getPathProvider(), getSignalManager());
        List list = tpatUrls$default;
        if (list == null || list.isEmpty()) {
            com.vungle.ads.o oVar = com.vungle.ads.o.INSTANCE;
            String placementRefId2 = this.delegate.getPlacementRefId();
            com.vungle.ads.internal.model.b bVar4 = this.advertisement;
            oVar.logError$vungle_ads_release(129, "Empty tpat key: clickUrl", (28 & 4) != 0 ? null : placementRefId2, (28 & 8) != 0 ? null : bVar4 != null ? bVar4.getCreativeId() : null, (28 & 16) != 0 ? null : null);
        } else {
            Iterator it = tpatUrls$default.iterator();
            while (it.hasNext()) {
                gVar.sendTpat((String) it.next(), this.executor);
            }
        }
        if (str != null) {
            gVar.sendTpat(str, this.executor);
        }
        com.vungle.ads.internal.model.b bVar5 = this.advertisement;
        com.vungle.ads.internal.util.f.launch((bVar5 == null || (cVarAdUnit = bVar5.adUnit()) == null) ? null : cVarAdUnit.getDeeplinkUrl(), str, this.context, new com.vungle.ads.internal.ui.c(this.bus, null), new b(gVar));
        com.vungle.ads.internal.presenter.a aVar = this.bus;
        if (aVar != null) {
            aVar.onNext("open", "adClick", this.delegate.getPlacementRefId());
        }
    }

    private final void onPrivacy(String str) {
        if (str != null) {
            if (com.vungle.ads.internal.util.i.INSTANCE.isValidUrl(str)) {
                if (com.vungle.ads.internal.util.f.launch(null, str, this.context, new com.vungle.ads.internal.ui.c(this.bus, this.delegate.getPlacementRefId()), null)) {
                    return;
                }
                new p1(str).logErrorNoReturnValue$vungle_ads_release();
            } else {
                b2 placementId$vungle_ads_release = new p1(str).setPlacementId$vungle_ads_release(this.delegate.getPlacementRefId());
                com.vungle.ads.internal.model.b bVar = this.advertisement;
                b2 creativeId$vungle_ads_release = placementId$vungle_ads_release.setCreativeId$vungle_ads_release(bVar != null ? bVar.getCreativeId() : null);
                com.vungle.ads.internal.model.b bVar2 = this.advertisement;
                creativeId$vungle_ads_release.setEventId$vungle_ads_release(bVar2 != null ? bVar2.eventId() : null).logErrorNoReturnValue$vungle_ads_release();
            }
        }
    }

    public static /* synthetic */ void processCommand$default(o oVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        oVar.processCommand(str, str2);
    }

    private final void showGdpr() {
        q7.c.INSTANCE.updateGdprConsent("opted_out_by_timeout", "vungle_modal", null);
        if (!(this.context instanceof Activity)) {
            com.vungle.ads.internal.util.p.Companion.w(TAG, "We can not show GDPR dialog with application context.");
            return;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.vungle.ads.internal.presenter.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                o.m4081showGdpr$lambda8(this.f24380a, dialogInterface, i10);
            }
        };
        com.vungle.ads.internal.k kVar = com.vungle.ads.internal.k.INSTANCE;
        String gDPRConsentTitle = kVar.getGDPRConsentTitle();
        String gDPRConsentMessage = kVar.getGDPRConsentMessage();
        String gDPRButtonAccept = kVar.getGDPRButtonAccept();
        String gDPRButtonDeny = kVar.getGDPRButtonDeny();
        Context context = this.context;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, ((Activity) context).getApplicationInfo().theme));
        boolean z10 = true;
        if (!(gDPRConsentTitle == null || gDPRConsentTitle.length() == 0)) {
            builder.setTitle(gDPRConsentTitle);
        }
        if (gDPRConsentMessage != null && gDPRConsentMessage.length() != 0) {
            z10 = false;
        }
        if (!z10) {
            builder.setMessage(gDPRConsentMessage);
        }
        builder.setPositiveButton(gDPRButtonAccept, onClickListener);
        builder.setNegativeButton(gDPRButtonDeny, onClickListener);
        builder.setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.vungle.ads.internal.presenter.n
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                o.m4082showGdpr$lambda9(this.f24381a, dialogInterface);
            }
        });
        this.currentDialog = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showGdpr$lambda-8, reason: not valid java name */
    public static final void m4081showGdpr$lambda8(o this$0, DialogInterface dialogInterface, int i10) {
        t.i(this$0, "this$0");
        q7.c.INSTANCE.updateGdprConsent(i10 != -2 ? i10 != -1 ? "opted_out_by_timeout" : q7.b.OPT_IN.getValue() : q7.b.OPT_OUT.getValue(), "vungle_modal", null);
        this$0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showGdpr$lambda-9, reason: not valid java name */
    public static final void m4082showGdpr$lambda9(o this$0, DialogInterface dialogInterface) {
        t.i(this$0, "this$0");
        this$0.currentDialog = null;
    }

    private final void start() {
        if (needShowGdpr()) {
            showGdpr();
        }
    }

    public final void detach() {
        List<String> tpatUrls;
        com.vungle.ads.internal.omsdk.a aVar = this.omTracker;
        if (aVar != null) {
            aVar.stop();
        }
        Dialog dialog = this.currentDialog;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        Long l10 = this.adStartTime;
        if (l10 != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - l10.longValue();
            com.vungle.ads.internal.network.i vungleApiClient = getVungleApiClient();
            com.vungle.ads.internal.model.b bVar = this.advertisement;
            String strPlacementId = bVar != null ? bVar.placementId() : null;
            com.vungle.ads.internal.model.b bVar2 = this.advertisement;
            String creativeId = bVar2 != null ? bVar2.getCreativeId() : null;
            com.vungle.ads.internal.model.b bVar3 = this.advertisement;
            com.vungle.ads.internal.network.g gVar = new com.vungle.ads.internal.network.g(vungleApiClient, strPlacementId, creativeId, bVar3 != null ? bVar3.eventId() : null, getExecutors().getIoExecutor(), getPathProvider(), getSignalManager());
            com.vungle.ads.internal.model.b bVar4 = this.advertisement;
            if (bVar4 != null && (tpatUrls = bVar4.getTpatUrls(com.vungle.ads.internal.l.AD_CLOSE_TPAT_KEY, String.valueOf(jCurrentTimeMillis), String.valueOf(this.platform.getVolumeLevel()))) != null) {
                gVar.sendTpats(tpatUrls, this.executor);
            }
        }
        com.vungle.ads.internal.presenter.a aVar2 = this.bus;
        if (aVar2 != null) {
            aVar2.onNext(TtmlNode.END, null, this.delegate.getPlacementRefId());
        }
    }

    public final void initOMTracker(@NotNull String omSdkData) {
        t.i(omSdkData, "omSdkData");
        com.vungle.ads.internal.model.b bVar = this.advertisement;
        boolean zOmEnabled = bVar != null ? bVar.omEnabled() : false;
        if ((omSdkData.length() > 0) && com.vungle.ads.internal.k.INSTANCE.omEnabled() && zOmEnabled) {
            this.omTracker = new com.vungle.ads.internal.omsdk.a(omSdkData);
        }
    }

    public final void onImpression() {
        com.vungle.ads.internal.omsdk.a aVar = this.omTracker;
        if (aVar != null) {
            aVar.impressionOccurred();
        }
    }

    public final void prepare() {
        start();
        com.vungle.ads.internal.presenter.a aVar = this.bus;
        if (aVar != null) {
            aVar.onNext(TtmlNode.START, null, this.delegate.getPlacementRefId());
        }
        this.adStartTime = Long.valueOf(System.currentTimeMillis());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void processCommand(@org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.Nullable java.lang.String r21) {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.presenter.o.processCommand(java.lang.String, java.lang.String):void");
    }

    public final void setEventListener(@Nullable com.vungle.ads.internal.presenter.a aVar) {
        this.bus = aVar;
    }

    public final void startTracking(@NotNull View rootView) {
        t.i(rootView, "rootView");
        com.vungle.ads.internal.omsdk.a aVar = this.omTracker;
        if (aVar != null) {
            aVar.start(rootView);
        }
    }
}
