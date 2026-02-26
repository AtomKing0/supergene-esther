package com.vungle.ads.internal.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.ironsource.v8;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.f0;
import com.vungle.ads.internal.executor.i;
import com.vungle.ads.internal.k;
import com.vungle.ads.internal.model.j;
import com.vungle.ads.internal.model.m;
import com.vungle.ads.internal.omsdk.d;
import com.vungle.ads.internal.presenter.l;
import com.vungle.ads.internal.presenter.q;
import com.vungle.ads.internal.ui.view.b;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.internal.util.s;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.n;

/* JADX INFO: compiled from: AdActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends Activity {

    @NotNull
    public static final C0532a Companion = new C0532a(null);

    @NotNull
    public static final String REQUEST_KEY_EVENT_ID_EXTRA = "request_eventId";

    @NotNull
    public static final String REQUEST_KEY_EXTRA = "request";

    @NotNull
    private static final String TAG = "AdActivity";

    @Nullable
    private static com.vungle.ads.internal.model.b advertisement;

    @Nullable
    private static com.vungle.ads.internal.model.e bidPayload;

    @Nullable
    private static com.vungle.ads.internal.presenter.a eventListener;

    @Nullable
    private static q presenterDelegate;
    private boolean isReceiverRegistered;

    @Nullable
    private com.vungle.ads.internal.ui.view.b mraidAdWidget;

    @Nullable
    private l mraidPresenter;

    @NotNull
    private String placementRefId = "";

    @NotNull
    private final s ringerModeReceiver = new s();

    @Nullable
    private m unclosedAd;

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class b extends v implements h9.a<com.vungle.ads.internal.signals.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
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
    public static final class c extends v implements h9.a<com.vungle.ads.internal.executor.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
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
    public static final class d extends v implements h9.a<com.vungle.ads.internal.platform.d> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
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
    public static final class e extends v implements h9.a<d.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.omsdk.d$b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final d.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(d.b.class);
        }
    }

    /* JADX INFO: compiled from: AdActivity.kt */
    public static final class f implements b.a {
        final /* synthetic */ v8.l<com.vungle.ads.internal.signals.b> $signalManager$delegate;

        f(v8.l<com.vungle.ads.internal.signals.b> lVar) {
            this.$signalManager$delegate = lVar;
        }

        @Override // com.vungle.ads.internal.ui.view.b.a
        public void close() {
            m mVar = a.this.unclosedAd;
            if (mVar != null) {
                a.m4107onCreate$lambda2(this.$signalManager$delegate).removeUnclosedAd(mVar);
            }
            a.this.finish();
        }
    }

    /* JADX INFO: compiled from: AdActivity.kt */
    public static final class g implements b.d {
        g() {
        }

        @Override // com.vungle.ads.internal.ui.view.b.d
        public boolean onTouch(@Nullable MotionEvent motionEvent) {
            l mraidPresenter$vungle_ads_release = a.this.getMraidPresenter$vungle_ads_release();
            if (mraidPresenter$vungle_ads_release == null) {
                return false;
            }
            mraidPresenter$vungle_ads_release.onViewTouched(motionEvent);
            return false;
        }
    }

    /* JADX INFO: compiled from: AdActivity.kt */
    public static final class h implements b.e {
        h() {
        }

        @Override // com.vungle.ads.internal.ui.view.b.e
        public void setOrientation(int i10) {
            a.this.setRequestedOrientation(i10);
        }
    }

    private final void hideSystemUi() {
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        t.h(insetsController, "getInsetsController(window, window.decorView)");
        insetsController.setSystemBarsBehavior(2);
        insetsController.hide(WindowInsetsCompat.Type.systemBars());
    }

    private final void onConcurrentPlaybackError(String str) {
        f0 f0Var = new f0();
        com.vungle.ads.internal.presenter.a aVar = eventListener;
        if (aVar != null) {
            aVar.onError(f0Var, str);
        }
        f0Var.setPlacementId(this.placementRefId);
        com.vungle.ads.internal.model.b bVar = advertisement;
        f0Var.setCreativeId(bVar != null ? bVar.getCreativeId() : null);
        com.vungle.ads.internal.model.b bVar2 = advertisement;
        f0Var.setEventId(bVar2 != null ? bVar2.eventId() : null);
        f0Var.logErrorNoReturnValue$vungle_ads_release();
        p.Companion.e(TAG, "onConcurrentPlaybackError: " + f0Var.getLocalizedMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCreate$lambda-2, reason: not valid java name */
    public static final com.vungle.ads.internal.signals.b m4107onCreate$lambda2(v8.l<com.vungle.ads.internal.signals.b> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: onCreate$lambda-6, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.a m4108onCreate$lambda6(v8.l<? extends com.vungle.ads.internal.executor.a> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: onCreate$lambda-7, reason: not valid java name */
    private static final com.vungle.ads.internal.platform.d m4109onCreate$lambda7(v8.l<? extends com.vungle.ads.internal.platform.d> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: onCreate$lambda-8, reason: not valid java name */
    private static final d.b m4110onCreate$lambda8(v8.l<d.b> lVar) {
        return lVar.getValue();
    }

    @VisibleForTesting(otherwise = 4)
    public boolean canRotate$vungle_ads_release() {
        return false;
    }

    @Nullable
    public final com.vungle.ads.internal.ui.view.b getMraidAdWidget$vungle_ads_release() {
        return this.mraidAdWidget;
    }

    @Nullable
    public final l getMraidPresenter$vungle_ads_release() {
        return this.mraidPresenter;
    }

    @NotNull
    public final String getPlacementRefId$vungle_ads_release() {
        return this.placementRefId;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        l lVar = this.mraidPresenter;
        if (lVar != null) {
            lVar.handleExit();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        t.i(newConfig, "newConfig");
        try {
            super.onConfigurationChanged(newConfig);
            int i10 = newConfig.orientation;
            if (i10 == 2) {
                p.Companion.d(TAG, v8.h.C);
            } else if (i10 == 1) {
                p.Companion.d(TAG, v8.h.D);
            }
            l lVar = this.mraidPresenter;
            if (lVar != null) {
                lVar.onViewConfigurationChanged();
            }
        } catch (Exception e10) {
            p.Companion.e(TAG, "onConfigurationChanged: " + e10.getLocalizedMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String, kotlin.jvm.internal.k] */
    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        String watermark$vungle_ads_release;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(16777216, 16777216);
        C0532a c0532a = Companion;
        Intent intent = getIntent();
        t.h(intent, "intent");
        String strValueOf = String.valueOf(c0532a.getPlacement(intent));
        this.placementRefId = strValueOf;
        com.vungle.ads.internal.model.b bVar = advertisement;
        k kVar = k.INSTANCE;
        j placement = kVar.getPlacement(strValueOf);
        if (placement == null || bVar == null) {
            com.vungle.ads.internal.presenter.a aVar = eventListener;
            if (aVar != null) {
                aVar.onError(new com.vungle.ads.h(), this.placementRefId);
            }
            finish();
            return;
        }
        getWindow().getDecorView().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        try {
            com.vungle.ads.internal.ui.view.b bVar2 = new com.vungle.ads.internal.ui.view.b(this);
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            v8.p pVar = v8.p.f35201a;
            v8.l lVarB = n.b(pVar, new b(this));
            Intent intent2 = getIntent();
            t.h(intent2, "intent");
            String eventId = c0532a.getEventId(intent2);
            m mVar = eventId != null ? new m(eventId, (String) str, 2, (kotlin.jvm.internal.k) str) : null;
            this.unclosedAd = mVar;
            if (mVar != null) {
                m4107onCreate$lambda2(lVarB).recordUnclosedAd(mVar);
            }
            bVar2.setCloseDelegate(new f(lVarB));
            bVar2.setOnViewTouchListener(new g());
            bVar2.setOrientationDelegate(new h());
            v8.l lVarB2 = n.b(pVar, new c(this));
            v8.l lVarB3 = n.b(pVar, new d(this));
            com.vungle.ads.internal.ui.f fVar = new com.vungle.ads.internal.ui.f(bVar, placement, m4108onCreate$lambda6(lVarB2).getOffloadExecutor(), m4107onCreate$lambda2(lVarB), m4109onCreate$lambda7(lVarB3));
            com.vungle.ads.internal.omsdk.d dVarMake = m4110onCreate$lambda8(n.b(pVar, new e(this))).make(kVar.omEnabled() && bVar.omEnabled());
            i jobExecutor = m4108onCreate$lambda6(lVarB2).getJobExecutor();
            fVar.setWebViewObserver(dVarMake);
            this.ringerModeReceiver.setWebClient(fVar);
            l lVar = new l(bVar2, bVar, placement, fVar, jobExecutor, dVarMake, bidPayload, m4109onCreate$lambda7(lVarB3));
            lVar.setEventListener(eventListener);
            lVar.setPresenterDelegate$vungle_ads_release(presenterDelegate);
            lVar.prepare();
            setContentView(bVar2, bVar2.getLayoutParams());
            com.vungle.ads.c adConfig = bVar.getAdConfig();
            if (adConfig != null && (watermark$vungle_ads_release = adConfig.getWatermark$vungle_ads_release()) != null) {
                com.vungle.ads.internal.ui.g gVar = new com.vungle.ads.internal.ui.g(this, watermark$vungle_ads_release);
                ((FrameLayout) getWindow().getDecorView().findViewById(R.id.content)).addView(gVar);
                gVar.bringToFront();
            }
            this.mraidAdWidget = bVar2;
            this.mraidPresenter = lVar;
        } catch (InstantiationException unused) {
            com.vungle.ads.internal.presenter.a aVar2 = eventListener;
            if (aVar2 != null) {
                com.vungle.ads.b bVar3 = new com.vungle.ads.b();
                bVar3.setPlacementId$vungle_ads_release(this.placementRefId);
                com.vungle.ads.internal.model.b bVar4 = advertisement;
                bVar3.setEventId$vungle_ads_release(bVar4 != null ? bVar4.eventId() : null);
                com.vungle.ads.internal.model.b bVar5 = advertisement;
                bVar3.setCreativeId$vungle_ads_release(bVar5 != null ? bVar5.getCreativeId() : 0);
                aVar2.onError(bVar3.logError$vungle_ads_release(), this.placementRefId);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        l lVar = this.mraidPresenter;
        if (lVar != null) {
            lVar.detach((isChangingConfigurations() ? 1 : 0) | 2);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(@NotNull Intent intent) {
        t.i(intent, "intent");
        super.onNewIntent(intent);
        C0532a c0532a = Companion;
        Intent intent2 = getIntent();
        t.h(intent2, "getIntent()");
        String placement = c0532a.getPlacement(intent2);
        String placement2 = c0532a.getPlacement(intent);
        Intent intent3 = getIntent();
        t.h(intent3, "getIntent()");
        String eventId = c0532a.getEventId(intent3);
        String eventId2 = c0532a.getEventId(intent);
        if ((placement == null || placement2 == null || t.d(placement, placement2)) && (eventId == null || eventId2 == null || t.d(eventId, eventId2))) {
            return;
        }
        p.Companion.d(TAG, "Tried to play another placement " + placement2 + " while playing " + placement);
        onConcurrentPlaybackError(placement2);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            if (this.isReceiverRegistered) {
                unregisterReceiver(this.ringerModeReceiver);
                this.isReceiverRegistered = false;
                p.Companion.d(TAG, "unregisterReceiver(): " + this.ringerModeReceiver.hashCode());
            }
        } catch (Exception e10) {
            p.Companion.e(TAG, "unregisterReceiver error: " + e10.getLocalizedMessage());
        }
        l lVar = this.mraidPresenter;
        if (lVar != null) {
            lVar.stop();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        hideSystemUi();
        try {
            if (!this.isReceiverRegistered) {
                registerReceiver(this.ringerModeReceiver, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
                this.isReceiverRegistered = true;
                p.Companion.d(TAG, "registerReceiver(): " + this.ringerModeReceiver.hashCode());
            }
        } catch (Exception e10) {
            p.Companion.e(TAG, "registerReceiver error: " + e10.getLocalizedMessage());
        }
        l lVar = this.mraidPresenter;
        if (lVar != null) {
            lVar.start();
        }
    }

    public final void setMraidAdWidget$vungle_ads_release(@Nullable com.vungle.ads.internal.ui.view.b bVar) {
        this.mraidAdWidget = bVar;
    }

    public final void setMraidPresenter$vungle_ads_release(@Nullable l lVar) {
        this.mraidPresenter = lVar;
    }

    public final void setPlacementRefId$vungle_ads_release(@NotNull String str) {
        t.i(str, "<set-?>");
        this.placementRefId = str;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i10) {
        if (canRotate$vungle_ads_release()) {
            super.setRequestedOrientation(i10);
        }
    }

    /* JADX INFO: renamed from: com.vungle.ads.internal.ui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdActivity.kt */
    public static final class C0532a {
        private C0532a() {
        }

        public /* synthetic */ C0532a(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getEventId(Intent intent) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    return extras.getString(a.REQUEST_KEY_EVENT_ID_EXTRA);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getPlacement(Intent intent) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    return extras.getString(a.REQUEST_KEY_EXTRA);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        @NotNull
        public final Intent createIntent(@Nullable Context context, @NotNull String placement, @Nullable String str) {
            t.i(placement, "placement");
            Intent intent = new Intent(context, (Class<?>) VungleActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            Bundle bundle = new Bundle();
            bundle.putString(a.REQUEST_KEY_EXTRA, placement);
            bundle.putString(a.REQUEST_KEY_EVENT_ID_EXTRA, str);
            intent.putExtras(bundle);
            return intent;
        }

        @Nullable
        public final com.vungle.ads.internal.model.b getAdvertisement$vungle_ads_release() {
            return a.advertisement;
        }

        @Nullable
        public final com.vungle.ads.internal.model.e getBidPayload$vungle_ads_release() {
            return a.bidPayload;
        }

        @VisibleForTesting
        @Nullable
        public final com.vungle.ads.internal.presenter.a getEventListener$vungle_ads_release() {
            return a.eventListener;
        }

        @Nullable
        public final q getPresenterDelegate$vungle_ads_release() {
            return a.presenterDelegate;
        }

        public final void setAdvertisement$vungle_ads_release(@Nullable com.vungle.ads.internal.model.b bVar) {
            a.advertisement = bVar;
        }

        public final void setBidPayload$vungle_ads_release(@Nullable com.vungle.ads.internal.model.e eVar) {
            a.bidPayload = eVar;
        }

        public final void setEventListener$vungle_ads_release(@Nullable com.vungle.ads.internal.presenter.a aVar) {
            a.eventListener = aVar;
        }

        public final void setPresenterDelegate$vungle_ads_release(@Nullable q qVar) {
            a.presenterDelegate = qVar;
        }

        @VisibleForTesting
        public static /* synthetic */ void getREQUEST_KEY_EVENT_ID_EXTRA$vungle_ads_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getREQUEST_KEY_EXTRA$vungle_ads_release$annotations() {
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getMraidAdWidget$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMraidPresenter$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getPlacementRefId$vungle_ads_release$annotations() {
    }
}
