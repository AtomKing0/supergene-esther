package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.a2;
import com.applovin.impl.a3;
import com.applovin.impl.b6;
import com.applovin.impl.g3;
import com.applovin.impl.g4;
import com.applovin.impl.h3;
import com.applovin.impl.h6;
import com.applovin.impl.i3;
import com.applovin.impl.l2;
import com.applovin.impl.l4;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.p4;
import com.applovin.impl.p5;
import com.applovin.impl.q2;
import com.applovin.impl.q4;
import com.applovin.impl.r4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t2;
import com.applovin.impl.v1;
import com.applovin.impl.w4;
import com.applovin.impl.w5;
import com.applovin.impl.y1;
import com.applovin.impl.y2;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.w8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f5947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f5948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p4 f5949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference f5950d = new AtomicReference();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5951a;

        static {
            int[] iArr = new int[MaxAdapter.InitializationStatus.values().length];
            f5951a = iArr;
            try {
                iArr[MaxAdapter.InitializationStatus.DOES_NOT_APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5951a[MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5951a[MaxAdapter.InitializationStatus.INITIALIZED_UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5951a[MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5951a[MaxAdapter.InitializationStatus.NOT_INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5951a[MaxAdapter.InitializationStatus.INITIALIZING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class b implements MaxAdListener, MaxRewardedAdListener, MaxAdViewAdListener, MaxAdRevenueListener, a.InterfaceC0165a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q2 f5952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a.InterfaceC0165a f5953b;

        public b(q2 q2Var, a.InterfaceC0165a interfaceC0165a) {
            this.f5952a = q2Var;
            this.f5953b = interfaceC0165a;
        }

        public void b(MaxAd maxAd, Bundle bundle) {
            this.f5952a.a(bundle);
            l2.b(this.f5953b, maxAd);
        }

        public void c(MaxAd maxAd, Bundle bundle) {
            this.f5952a.a(bundle);
            com.applovin.impl.sdk.n unused = MediationServiceImpl.this.f5948b;
            if (com.applovin.impl.sdk.n.a()) {
                MediationServiceImpl.this.f5948b.a("MediationService", "Scheduling impression for ad via callback...");
            }
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.f5952a, this.f5953b);
            if (!((Boolean) MediationServiceImpl.this.f5947a.a(g3.f5254y7)).booleanValue() || this.f5952a.u().compareAndSet(false, true)) {
                MediationServiceImpl.this.f5947a.l().a(this.f5952a, g.c.SHOW);
                MediationServiceImpl.this.f5947a.E().c(v1.f7556f);
                MediationServiceImpl.this.f5947a.E().c(v1.f7559i);
                MediationServiceImpl.this.f5947a.r().b(this.f5952a, "DID_DISPLAY");
                MediationServiceImpl.this.f5947a.o().maybeSendAdEvent(this.f5952a, "DID_DISPLAY");
                if (maxAd.getFormat().isFullscreenAd()) {
                    MediationServiceImpl.this.f5947a.D().a(this.f5952a);
                }
                l2.c(this.f5953b, maxAd);
            }
        }

        public void d(MaxAd maxAd, Bundle bundle) {
            this.f5952a.a(bundle);
            l2.d(this.f5953b, maxAd);
        }

        public void e(final MaxAd maxAd, Bundle bundle) {
            this.f5952a.a(bundle);
            MediationServiceImpl.this.f5947a.J().a(y1.W, this.f5952a);
            MediationServiceImpl.this.f5947a.l().a(this.f5952a, g.c.HIDE);
            q2 q2Var = (q2) maxAd;
            MediationServiceImpl.this.f5947a.r().b(q2Var, "DID_HIDE");
            MediationServiceImpl.this.f5947a.o().maybeSendAdEvent(q2Var, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6307a.a(maxAd);
                }
            }, maxAd instanceof t2 ? ((t2) maxAd).d0() : 0L);
        }

        public void f(MaxAd maxAd, Bundle bundle) {
            this.f5952a.a(bundle);
            this.f5952a.W();
            MediationServiceImpl.this.f5947a.l().a(this.f5952a, g.c.LOAD);
            MediationServiceImpl.this.a(this.f5952a);
            l2.f(this.f5953b, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            a(maxAd, (Bundle) null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            b(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            a(maxAd, maxError, (Bundle) null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            c(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            d(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            e(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            this.f5952a.W();
            MediationServiceImpl.this.b(this.f5952a, maxError, this.f5953b);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            f(maxAd, null);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            a(maxAd, maxReward, (Bundle) null);
        }

        public void a(a.InterfaceC0165a interfaceC0165a) {
            this.f5953b = interfaceC0165a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.f5947a.D().b(maxAd);
            }
            l2.e(this.f5953b, maxAd);
        }

        public void a(MaxAd maxAd, Bundle bundle) {
            this.f5952a.a(bundle);
            MediationServiceImpl.this.f5947a.l().a(this.f5952a, g.c.CLICK);
            MediationServiceImpl.this.a(this.f5952a, this.f5953b);
            l2.a((MaxAdListener) this.f5953b, maxAd);
        }

        public void a(MaxAd maxAd, MaxError maxError, Bundle bundle) {
            this.f5952a.a(bundle);
            MediationServiceImpl.this.a(this.f5952a, maxError, this.f5953b);
            if (maxAd.getFormat() == MaxAdFormat.REWARDED && (maxAd instanceof t2)) {
                ((t2) maxAd).b0();
            }
        }

        public void a(MaxAd maxAd, MaxReward maxReward, Bundle bundle) {
            this.f5952a.a(bundle);
            l2.a(this.f5953b, maxAd, maxReward);
            MediationServiceImpl.this.f5947a.j0().a((w4) new b6((t2) maxAd, MediationServiceImpl.this.f5947a), r5.b.OTHER);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }
    }

    public MediationServiceImpl(com.applovin.impl.sdk.j jVar) {
        this.f5947a = jVar;
        this.f5948b = jVar.I();
        this.f5949c = new p4(jVar);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    public void collectSignal(final String str, final MaxAdFormat maxAdFormat, final r4 r4Var, Context context, final q4.a aVar) {
        if (r4Var == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        q4 q4VarB = this.f5949c.b(r4Var, str, maxAdFormat);
        if (q4VarB != null) {
            aVar.a(q4.a(q4VarB));
            return;
        }
        final g gVarA = this.f5947a.M().a(r4Var, r4Var.z());
        if (gVarA == null) {
            aVar.a(q4.a(r4Var, new MaxErrorImpl("Could not load adapter")));
            return;
        }
        final g4 g4Var = new g4("SignalCollection:" + r4Var.c());
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        Executor executor = g4.f5258i;
        g4Var.a(executor, new g4.b() { // from class: com.applovin.impl.mediation.l
            @Override // com.applovin.impl.g4.b
            public final void a(boolean z10, Object obj, Object obj2) {
                this.f6279a.a(jElapsedRealtime, gVarA, str, r4Var, maxAdFormat, aVar, z10, (String) obj, (MaxError) obj2);
            }
        });
        w5.a(r4Var.m(), g4Var, new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + r4Var.c() + ") timed out collecting signal"), "MediationService", this.f5947a);
        final Activity activityN0 = context instanceof Activity ? (Activity) context : this.f5947a.n0();
        final MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(r4Var, str, maxAdFormat);
        if (r4Var.v()) {
            g4 g4VarA = this.f5947a.L().a(r4Var, activityN0);
            g4VarA.a(executor, new Runnable() { // from class: com.applovin.impl.mediation.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6288a.a(g4Var, gVarA, maxAdapterParametersImplA, r4Var, activityN0);
                }
            });
            g4VarA.a(executor, new g4.a() { // from class: com.applovin.impl.mediation.n
                @Override // com.applovin.impl.g4.a
                public final void a(Object obj) {
                    this.f6296a.a(gVarA, g4Var, (String) obj);
                }
            });
            return;
        }
        if (r4Var.w()) {
            g4 g4VarA2 = this.f5947a.L().a(r4Var, activityN0);
            if (g4VarA2.d() && !r4Var.y()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5948b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + gVarA.g());
                }
                g4Var.a(new MaxErrorImpl("Could not initialize adapter: " + ((String) g4VarA2.a())));
                return;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f5948b.a("MediationService", "Collecting signal for adapter: " + gVarA.g());
        }
        gVarA.a(maxAdapterParametersImplA, r4Var, activityN0, g4Var);
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof q2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f5948b.d("MediationService", "Destroying " + maxAd);
            }
            q2 q2Var = (q2) maxAd;
            g gVarA = q2Var.A();
            if (gVarA != null) {
                gVarA.a();
                q2Var.t();
            }
            this.f5947a.j().c(q2Var.N());
            this.f5947a.l().a(q2Var, g.c.DESTROY);
        }
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return (JSONObject) this.f5950d.getAndSet(null);
    }

    public void loadAd(String str, @Nullable String str2, MaxAdFormat maxAdFormat, d.b bVar, Map<String, Object> map, Map<String, Object> map2, Context context, a.InterfaceC0165a interfaceC0165a) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No Ad Unit ID specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (interfaceC0165a == null) {
            throw new IllegalArgumentException("No listener specified");
        }
        if (TextUtils.isEmpty(this.f5947a.O())) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Mediation provider is null. Please set the mediation provider in the AppLovinSdkInitializationConfiguration.Builder when initializing the AppLovinSDK.");
        }
        if (!this.f5947a.u0()) {
            com.applovin.impl.sdk.n.j("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        List<String> adUnitIds = this.f5947a.G() != null ? this.f5947a.G().getAdUnitIds() : null;
        boolean zStartsWith = str.startsWith("test_mode");
        if (adUnitIds != null && adUnitIds.size() > 0 && !adUnitIds.contains(str) && !zStartsWith) {
            if (z6.c(this.f5947a)) {
                String str3 = "Ad Unit ID " + str + " has not been initialized. When you use selective init, any ad units that you do not explicitly specify are excluded from serving ads for the current session. For more information visit our docs: https://developers.applovin.com/en/max/android/overview/advanced-settings#selective-init";
                if (((Boolean) this.f5947a.a(l4.P5)).booleanValue()) {
                    throw new RuntimeException(str3);
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5948b.b("MediationService", str3);
                }
            }
            this.f5947a.A().a(y1.f7798o0, "uninitialized_ad_unit_id", CollectionUtils.hashMap("ad_unit_id", str), "uninitialized_ad_unit_id" + str);
        }
        this.f5947a.c();
        if (str.length() != 16 && !zStartsWith && !this.f5947a.b0().startsWith("05TMD")) {
            com.applovin.impl.sdk.n.h("MediationService", "Ad unit ID provided for " + maxAdFormat.getLabel() + " is invalid (" + str + "). Expected length: 16 characters.\n\nStack trace:\n" + Log.getStackTraceString(new Throwable()));
        }
        if (!this.f5947a.a(maxAdFormat)) {
            this.f5947a.O0();
            l2.a((MaxAdRequestListener) interfaceC0165a, str, true);
            this.f5947a.K().a(str, str2, maxAdFormat, bVar, map, map2, context, interfaceC0165a);
            return;
        }
        com.applovin.impl.sdk.n.h("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
        l2.a(interfaceC0165a, str, new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
    }

    public void loadThirdPartyMediatedAd(final String str, final q2 q2Var, final Activity activity, final a.InterfaceC0165a interfaceC0165a) {
        g4 g4VarA;
        if (q2Var == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f5948b.a("MediationService", "Loading " + q2Var + "...");
        }
        this.f5947a.J().a(y1.O, q2Var);
        this.f5947a.l().a(q2Var, g.c.LOADING);
        this.f5947a.r().b(q2Var, "WILL_LOAD");
        this.f5947a.o().maybeSendAdEvent(q2Var, "WILL_LOAD");
        final g gVarA = this.f5947a.M().a(q2Var);
        if (gVarA == null) {
            String str2 = "Failed to load " + q2Var + ": adapter not loaded";
            com.applovin.impl.sdk.n.h("MediationService", str2);
            b(q2Var, new MaxErrorImpl(-5001, str2), interfaceC0165a);
            return;
        }
        final MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(q2Var);
        if (q2Var.U()) {
            g4VarA = this.f5947a.L().a(q2Var, activity);
        } else {
            if (q2Var.V()) {
                this.f5947a.L().a(q2Var, activity);
            }
            g4VarA = null;
        }
        g4 g4Var = g4VarA;
        final q2 q2VarA = q2Var.a(gVarA);
        gVarA.a(str, q2VarA);
        q2VarA.X();
        if (g4Var == null) {
            gVarA.a(str, maxAdapterParametersImplA, q2VarA, activity, new b(q2VarA, interfaceC0165a));
            return;
        }
        Executor executor = g4.f5258i;
        g4Var.a(executor, new g4.a() { // from class: com.applovin.impl.mediation.i
            @Override // com.applovin.impl.g4.a
            public final void a(Object obj) {
                this.f6254a.a(q2Var, interfaceC0165a, (String) obj);
            }
        });
        g4Var.a(executor, new Runnable() { // from class: com.applovin.impl.mediation.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f6259a.a(gVarA, str, maxAdapterParametersImplA, q2VarA, activity, interfaceC0165a);
            }
        });
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, @Nullable Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object objA = this.f5947a.D().a();
            if (objA instanceof q2) {
                a((MaxError) MaxAdapterError.WEBVIEW_ERROR, (q2) objA, true);
            }
        }
    }

    public void processAdDisplayErrorPostbackForUserError(MaxError maxError, q2 q2Var) {
        a(maxError, q2Var, false);
    }

    public void processAdapterInitializationPostback(a3 a3Var, long j10, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap map = new HashMap(2);
        map.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        map.put("{INIT_TIME_MS}", String.valueOf(j10));
        a("minit", map, new MaxErrorImpl(str), a3Var);
        Map mapA = a2.a(a3Var);
        CollectionUtils.putStringIfValid("adapter_init_status", String.valueOf(initializationStatus.getCode()), mapA);
        CollectionUtils.putStringIfValid("error_message", str, mapA);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j10), mapA);
        switch (a.f5951a[initializationStatus.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.f5947a.J().d(y1.H, mapA);
                break;
            case 4:
                this.f5947a.J().d(y1.I, mapA);
                break;
            case 5:
            case 6:
                this.f5947a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5947a.I().k("MediationService", "Adapter init postback called while the adapter is not fully initialized.");
                }
                this.f5947a.A().a(y1.f7775d, "adapterNotInitializedForPostback", mapA);
                break;
        }
    }

    public void processCallbackAdImpressionPostback(q2 q2Var, a.InterfaceC0165a interfaceC0165a) {
        if (q2Var.L().endsWith("cimp")) {
            this.f5947a.r().b(q2Var);
            l2.a((MaxAdRevenueListener) interfaceC0165a, (MaxAd) q2Var);
        }
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f5947a.p0().c());
        if (!((Boolean) this.f5947a.a(l4.f5746t3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mcimp", map, q2Var);
        this.f5947a.J().a(y1.T, q2Var);
    }

    public void processRawAdImpression(q2 q2Var, a.InterfaceC0165a interfaceC0165a) {
        this.f5947a.r().b(q2Var, "WILL_DISPLAY");
        this.f5947a.o().maybeSendAdEvent(q2Var, "WILL_DISPLAY");
        if (q2Var.L().endsWith("mimp")) {
            this.f5947a.r().b(q2Var);
            l2.a((MaxAdRevenueListener) interfaceC0165a, (MaxAd) q2Var);
        }
        if (((Boolean) this.f5947a.a(l4.f5651h4)).booleanValue()) {
            this.f5947a.R().a(h3.f5331d, i3.a(q2Var), Long.valueOf(System.currentTimeMillis() - this.f5947a.H()));
        }
        HashMap map = new HashMap(2);
        if (q2Var instanceof t2) {
            map.put("{TIME_TO_SHOW_MS}", String.valueOf(((t2) q2Var).h0()));
        }
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f5947a.p0().c());
        if (!((Boolean) this.f5947a.a(l4.f5746t3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mimp", map, q2Var);
        this.f5947a.J().a(y1.S, q2Var);
    }

    public void processViewabilityAdImpressionPostback(y2 y2Var, long j10, a.InterfaceC0165a interfaceC0165a) {
        if (y2Var.L().endsWith("vimp")) {
            this.f5947a.r().b(y2Var);
            l2.a((MaxAdRevenueListener) interfaceC0165a, (MaxAd) y2Var);
        }
        HashMap map = new HashMap(3);
        map.put("{VIEWABILITY_FLAGS}", String.valueOf(j10));
        map.put("{USED_VIEWABILITY_TIMER}", String.valueOf(y2Var.i0()));
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f5947a.p0().c());
        if (!((Boolean) this.f5947a.a(l4.f5746t3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mvimp", map, y2Var);
        this.f5947a.J().a(y1.U, y2Var);
    }

    public void processWaterfallInfoPostback(String str, MaxAdFormat maxAdFormat, MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl, @Nullable MaxError maxError, long j10, long j11) {
        HashMap map = new HashMap();
        CollectionUtils.putStringIfValid("ad_format", maxAdFormat.getLabel(), map);
        CollectionUtils.putStringIfValid("ad_unit_id", str, map);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(j11), map);
        if (maxError != null) {
            map.putAll(a2.a(maxError));
        }
        this.f5947a.J().d(y1.R, map);
        if (CollectionUtils.isEmpty(maxAdWaterfallInfoImpl.getPostbackUrls())) {
            return;
        }
        HashMap map2 = new HashMap(8);
        CollectionUtils.putStringIfValid("mcode", maxAdWaterfallInfoImpl.getMCode(), map2);
        CollectionUtils.putStringIfValid("ad_unit_id", str, map2);
        CollectionUtils.putStringIfValid("ad_format", maxAdFormat.getLabel(), map2);
        CollectionUtils.putStringIfValid("name", maxAdWaterfallInfoImpl.getName(), map2);
        CollectionUtils.putLongIfValid("request_latency_ms", Long.valueOf(j11), map2);
        CollectionUtils.putLongIfValid("request_start_timestamp_ms", Long.valueOf(j10), map2);
        CollectionUtils.putLongIfValid("wf_latency_ms", Long.valueOf(maxAdWaterfallInfoImpl.getLatencyMillis()), map2);
        List<MaxNetworkResponseInfo> networkResponses = maxAdWaterfallInfoImpl.getNetworkResponses();
        ArrayList arrayList = new ArrayList(networkResponses.size());
        for (MaxNetworkResponseInfo maxNetworkResponseInfo : networkResponses) {
            MaxMediatedNetworkInfo mediatedNetwork = maxNetworkResponseInfo.getMediatedNetwork();
            HashMap map3 = new HashMap(5);
            CollectionUtils.putStringIfValid("bcode", ((MaxNetworkResponseInfoImpl) maxNetworkResponseInfo).getBCode(), map3);
            map3.put("name", mediatedNetwork.getName());
            CollectionUtils.putLongIfValid("latency_ms", Long.valueOf(maxNetworkResponseInfo.getLatencyMillis()), map3);
            map3.put("load_state", Integer.valueOf(maxNetworkResponseInfo.getAdLoadState().ordinal()));
            MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxNetworkResponseInfo.getError();
            if (maxErrorImpl != null) {
                HashMap map4 = new HashMap(4);
                map4.put("error_code", Integer.valueOf(maxErrorImpl.getCode()));
                map4.put("error_message", maxErrorImpl.getMessage());
                map4.put("third_party_sdk_error_code", Integer.valueOf(maxErrorImpl.getMediatedNetworkErrorCode()));
                map4.put("third_party_sdk_error_message", maxErrorImpl.getMediatedNetworkErrorMessage());
                map3.put("error_info", map4);
            }
            arrayList.add(map3);
        }
        map2.put("ads_info", arrayList);
        a("mwf_info", maxAdWaterfallInfoImpl.getPostbackUrls(), Collections.EMPTY_MAP, map2, null, null, false);
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.f5950d.set(jSONObject);
    }

    public void showFullscreenAd(final t2 t2Var, final Activity activity, final a.InterfaceC0165a interfaceC0165a) {
        if (t2Var == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity == null && MaxAdFormat.APP_OPEN != t2Var.getFormat()) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f5947a.D().a(true);
        final g gVarB = b(t2Var);
        long jJ0 = t2Var.j0();
        if (com.applovin.impl.sdk.n.a()) {
            this.f5948b.d("MediationService", "Showing ad " + t2Var.getAdUnitId() + " with delay of " + jJ0 + "ms...");
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f6248a.a(t2Var, gVarB, activity, interfaceC0165a);
            }
        }, jJ0);
    }

    private g b(t2 t2Var) {
        g gVarA = t2Var.A();
        if (gVarA != null) {
            return gVarA;
        }
        this.f5947a.D().a(false);
        if (com.applovin.impl.sdk.n.a()) {
            this.f5948b.k("MediationService", "Failed to show " + t2Var + ": adapter not found");
        }
        com.applovin.impl.sdk.n.h("MediationService", "There may be an integration problem with the adapter for Ad Unit ID '" + t2Var.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(t2 t2Var, g gVar, Activity activity, a.InterfaceC0165a interfaceC0165a) {
        a(t2Var);
        gVar.b(t2Var, activity);
        a(t2Var, interfaceC0165a);
    }

    public void showFullscreenAd(final t2 t2Var, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity, final a.InterfaceC0165a interfaceC0165a) {
        if (t2Var == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity != null) {
            this.f5947a.D().a(true);
            final g gVarB = b(t2Var);
            long jJ0 = t2Var.j0();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5948b.d("MediationService", "Showing ad " + t2Var.getAdUnitId() + " with delay of " + jJ0 + "ms...");
            }
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6270a.a(t2Var, gVarB, viewGroup, lifecycle, activity, interfaceC0165a);
                }
            }, jJ0);
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(t2 t2Var, g gVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, a.InterfaceC0165a interfaceC0165a) {
        a(t2Var);
        gVar.a(t2Var, viewGroup, lifecycle, activity);
        a(t2Var, interfaceC0165a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(q2 q2Var, MaxError maxError, MaxAdListener maxAdListener) {
        a(maxError, q2Var);
        destroyAd(q2Var);
        l2.a(maxAdListener, q2Var.getAdUnitId(), maxError);
    }

    private void a(t2 t2Var) {
        if (t2Var.getFormat() == MaxAdFormat.REWARDED) {
            this.f5947a.j0().a((w4) new h6(t2Var, this.f5947a), r5.b.OTHER);
        }
    }

    private void a(t2 t2Var, a.InterfaceC0165a interfaceC0165a) {
        this.f5947a.D().a(false);
        a(t2Var, (MaxAdListener) interfaceC0165a);
        if (com.applovin.impl.sdk.n.a()) {
            this.f5948b.a("MediationService", "Scheduling impression for ad manually...");
        }
        processRawAdImpression(t2Var, interfaceC0165a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(q2 q2Var, a.InterfaceC0165a interfaceC0165a, String str) {
        String str2 = "Failed to load " + q2Var + ": adapter init failed with error: " + str;
        if (com.applovin.impl.sdk.n.a()) {
            this.f5948b.k("MediationService", str2);
        }
        b(q2Var, new MaxErrorImpl(MaxAdapterError.NOT_INITIALIZED.getErrorCode(), "Adapter initialization failed"), interfaceC0165a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(g gVar, String str, MaxAdapterParametersImpl maxAdapterParametersImpl, q2 q2Var, Activity activity, a.InterfaceC0165a interfaceC0165a) {
        gVar.a(str, maxAdapterParametersImpl, q2Var, activity, new b(q2Var, interfaceC0165a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j10, g gVar, String str, r4 r4Var, MaxAdFormat maxAdFormat, q4.a aVar, boolean z10, String str2, MaxError maxError) {
        q4 q4VarA;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j10;
        if (z10) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f5948b.a("MediationService", "Signal collection successful from: " + gVar.g() + " for Ad Unit ID: " + str + " with signal: \"" + str2 + "\"");
            }
            q4VarA = q4.a(r4Var, gVar, str2, j10, jElapsedRealtime);
            this.f5949c.a(q4VarA, r4Var, str, maxAdFormat);
            HashMap map = new HashMap();
            CollectionUtils.putStringIfValid("network_name", r4Var.c(), map);
            CollectionUtils.putStringIfValid("adapter_class", r4Var.b(), map);
            CollectionUtils.putStringIfValid("adapter_version", gVar.b(), map);
            CollectionUtils.putStringIfValid("duration_ms", String.valueOf(jElapsedRealtime), map);
            CollectionUtils.putStringIfValid("ad_format", String.valueOf(maxAdFormat.getLabel()), map);
            CollectionUtils.putStringIfValid("ad_unit_id", str, map);
            this.f5947a.J().d(y1.J, map);
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f5948b.b("MediationService", "Signal collection failed from: " + gVar.g() + " for Ad Unit ID: " + str + " with error message: \"" + maxError.getMessage() + "\"");
            }
            q4VarA = q4.a(r4Var, gVar, maxError, j10, jElapsedRealtime);
            a(q4VarA, r4Var, gVar);
        }
        aVar.a(q4VarA);
        gVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(g4 g4Var, g gVar, MaxAdapterParametersImpl maxAdapterParametersImpl, r4 r4Var, Activity activity) {
        if (g4Var.c()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f5948b.a("MediationService", "Collecting signal for now-initialized adapter: " + gVar.g());
        }
        gVar.a(maxAdapterParametersImpl, r4Var, activity, g4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(g gVar, g4 g4Var, String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f5948b.b("MediationService", "Skip collecting signal for failed-initialized adapter: " + gVar.g());
        }
        g4Var.a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_NOT_INITIALIZED, "Could not initialize adapter: " + str));
    }

    private void a(final t2 t2Var, final MaxAdListener maxAdListener) {
        final Long l10 = (Long) this.f5947a.a(g3.f5227c7);
        if (l10.longValue() <= 0) {
            return;
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f6301a.a(t2Var, l10, maxAdListener);
            }
        }, l10.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(t2 t2Var, Long l10, MaxAdListener maxAdListener) {
        if (t2Var.u().get()) {
            return;
        }
        String str = "Ad (" + t2Var.k() + ") has not been displayed after " + l10 + "ms. Failing ad display...";
        com.applovin.impl.sdk.n.h("MediationService", str);
        a(t2Var, new MaxErrorImpl(-1, str), maxAdListener);
        this.f5947a.D().b(t2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q2 q2Var, MaxError maxError, MaxAdListener maxAdListener) {
        this.f5947a.l().a(q2Var, g.c.SHOW_ERROR);
        this.f5947a.r().b(q2Var, "DID_FAIL_DISPLAY");
        this.f5947a.o().maybeSendAdEvent(q2Var, "DID_FAIL_DISPLAY");
        a(maxError, q2Var, true);
        if (q2Var.u().compareAndSet(false, true)) {
            l2.a(maxAdListener, q2Var, maxError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q2 q2Var) {
        this.f5947a.r().b(q2Var, "DID_LOAD");
        this.f5947a.o().maybeSendAdEvent(q2Var, "DID_LOAD");
        if (q2Var.L().endsWith("load")) {
            this.f5947a.r().b(q2Var);
        }
        HashMap map = new HashMap(3);
        long jG = q2Var.G();
        map.put("{LOAD_TIME_MS}", String.valueOf(jG));
        if (q2Var.getFormat().isFullscreenAd()) {
            m.a aVarB = this.f5947a.D().b(q2Var.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarB.a()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarB.b()));
        }
        a("load", map, q2Var);
        Map mapA = a2.a(q2Var);
        mapA.put("duration_ms", String.valueOf(jG));
        this.f5947a.J().d(y1.P, mapA);
    }

    private void a(MaxError maxError, q2 q2Var) {
        HashMap map = new HashMap(3);
        long jG = q2Var.G();
        map.put("{LOAD_TIME_MS}", String.valueOf(jG));
        if (q2Var.getFormat().isFullscreenAd()) {
            m.a aVarB = this.f5947a.D().b(q2Var.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarB.a()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarB.b()));
        }
        a("mlerr", map, maxError, q2Var);
        Map mapA = a2.a(q2Var);
        mapA.putAll(a2.a(maxError));
        mapA.put("duration_ms", String.valueOf(jG));
        this.f5947a.J().d(y1.Q, mapA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q2 q2Var, a.InterfaceC0165a interfaceC0165a) {
        this.f5947a.r().b(q2Var, "DID_CLICKED");
        this.f5947a.r().b(q2Var, "DID_CLICK");
        this.f5947a.o().maybeSendAdEvent(q2Var, "DID_CLICK");
        if (q2Var.L().endsWith(w8.f16021d)) {
            this.f5947a.r().b(q2Var);
            l2.a((MaxAdRevenueListener) interfaceC0165a, (MaxAd) q2Var);
        }
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.f5947a.p0().c());
        if (!((Boolean) this.f5947a.a(l4.f5746t3)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mclick", map, q2Var);
    }

    private void a(MaxError maxError, q2 q2Var, boolean z10) {
        a("mierr", Collections.EMPTY_MAP, maxError, q2Var, z10);
        if (!z10 || q2Var == null) {
            return;
        }
        this.f5947a.J().a(y1.V, q2Var, maxError);
    }

    private void a(q4 q4Var, r4 r4Var, g gVar) {
        long jB = q4Var.b();
        HashMap map = new HashMap(3);
        map.put("{LOAD_TIME_MS}", String.valueOf(jB));
        CollectionUtils.putStringIfValid("{ADAPTER_VERSION}", gVar.b(), map);
        CollectionUtils.putStringIfValid("{SDK_VERSION}", gVar.i(), map);
        a("serr", map, q4Var.c(), r4Var);
        Map mapA = a2.a(q4Var.c());
        CollectionUtils.putStringIfValid("network_name", r4Var.c(), mapA);
        CollectionUtils.putStringIfValid("adapter_class", r4Var.b(), mapA);
        CollectionUtils.putStringIfValid("adapter_version", gVar.b(), mapA);
        CollectionUtils.putStringIfValid("duration_ms", String.valueOf(jB), mapA);
        this.f5947a.J().d(y1.K, mapA);
    }

    private void a(String str, Map map, a3 a3Var) {
        a(str, map, (MaxError) null, a3Var);
    }

    private void a(String str, Map map, MaxError maxError, a3 a3Var) {
        a(str, map, maxError, a3Var, true);
    }

    private void a(String str, Map map, MaxError maxError, a3 a3Var, boolean z10) {
        Map map2 = CollectionUtils.map(map);
        map2.put("{PLACEMENT}", z10 ? StringUtils.emptyIfNull(a3Var.getPlacement()) : "");
        map2.put("{CUSTOM_DATA}", z10 ? StringUtils.emptyIfNull(a3Var.e()) : "");
        if (a3Var instanceof q2) {
            map2.put("{CREATIVE_ID}", z10 ? StringUtils.emptyIfNull(((q2) a3Var).getCreativeId()) : "");
        }
        a(str, null, map2, null, maxError, a3Var, z10);
    }

    private void a(String str, List list, Map map, Map map2, MaxError maxError, a3 a3Var, boolean z10) {
        this.f5947a.j0().a((w4) new p5(str, list, map, map2, maxError, a3Var, this.f5947a, z10), r5.b.OTHER);
    }
}
