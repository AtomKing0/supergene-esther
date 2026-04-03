package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.b7;
import com.ironsource.gs;
import com.ironsource.hj;
import com.ironsource.i9;
import com.ironsource.ji;
import com.ironsource.kb;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mo;
import com.ironsource.s7;
import com.ironsource.ta;
import com.ironsource.v2;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class x extends y implements BannerSmashListener, gs.a, s7 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private k f13962h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private gs f13963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f13964j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private mo f13965k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private IronSourceBannerLayout f13966l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f13967m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private JSONObject f13968n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f13969o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f13970p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private b7 f13971q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Object f13972r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ta f13973s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f13974t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f13975u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private JSONObject f13976v;

    protected enum a {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    x(k kVar, mo moVar, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i10, String str, JSONObject jSONObject, int i11, String str2, boolean z10) {
        super(new v2(networkSettings, networkSettings.getBannerSettings(), IronSource.AD_UNIT.BANNER), abstractAdapter);
        this.f13972r = new Object();
        this.f13964j = a.NONE;
        this.f13962h = kVar;
        this.f13963i = new gs(kVar.e());
        this.f13965k = moVar;
        this.f13990f = i10;
        this.f13967m = str;
        this.f13969o = i11;
        this.f13970p = str2;
        this.f13968n = jSONObject;
        this.f13974t = z10;
        this.f13976v = null;
        if (r()) {
            u();
        }
    }

    private void A() {
        IronLog.INTERNAL.verbose();
        a(a.INIT_IN_PROGRESS);
        F();
        try {
            if (this.f13985a != null) {
                if (p()) {
                    this.f13985a.initBannerForBidding(this.f13962h.a(), this.f13962h.j(), this.f13988d, this);
                } else {
                    this.f13985a.initBanners(this.f13962h.a(), this.f13962h.j(), this.f13988d, this);
                }
            }
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to init banner from " + this.f13985a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            onBannerInitFailed(new IronSourceError(612, th.getLocalizedMessage()));
            a(IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    private boolean B() {
        boolean z10;
        synchronized (this.f13972r) {
            z10 = this.f13964j == a.DESTROYED;
        }
        return z10;
    }

    private boolean C() {
        boolean z10;
        synchronized (this.f13972r) {
            z10 = this.f13964j == a.LOADED;
        }
        return z10;
    }

    private void F() {
        if (this.f13985a == null) {
            return;
        }
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (TextUtils.isEmpty(pluginType)) {
                return;
            }
            this.f13985a.setPluginData(pluginType);
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to set custom params from " + this.f13985a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            a(IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_internal)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    private boolean b(int i10) {
        return i10 == 3005 || i10 == 3002 || i10 == 3012 || i10 == 3015 || i10 == 3008 || i10 == 3305 || i10 == 3300 || i10 == 3306 || i10 == 3307 || i10 == 3302 || i10 == 3303 || i10 == 3304 || i10 == 3009;
    }

    private void u() {
        IronLog.INTERNAL.verbose("isBidder = " + p() + ", shouldEarlyInit = " + s());
        this.f13975u = true;
        A();
    }

    public void D() {
        this.f13985a.onBannerViewBound(this.f13986b.h().getBannerSettings());
    }

    public void E() {
        this.f13985a.onBannerViewWillBind(this.f13986b.h().getBannerSettings());
    }

    @Override // com.ironsource.s7
    public Map<String, Object> a(AdData adData) {
        AbstractAdapter abstractAdapter;
        JSONObject jSONObjectA = adData != null ? hj.a(adData.getAdUnitData()) : null;
        if (!p() || (abstractAdapter = this.f13985a) == null) {
            return null;
        }
        return abstractAdapter.getBannerBiddingData(this.f13988d, jSONObjectA);
    }

    @Override // com.ironsource.mediationsdk.y
    public IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.BANNER;
    }

    @Override // com.ironsource.mediationsdk.y
    public String k() {
        return "ProgBannerSmash";
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
        IronLog.INTERNAL.verbose(f());
        a(3008);
        mo moVar = this.f13965k;
        if (moVar != null) {
            moVar.b(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
        IronLog.INTERNAL.verbose(f());
        a(3304);
        mo moVar = this.f13965k;
        if (moVar != null) {
            moVar.c(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose(y() + "error = " + ironSourceError);
        this.f13963i.e();
        if (a(a.LOADING, a.LOAD_FAILED)) {
            a(ironSourceError);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose(f());
        this.f13963i.e();
        if (!a(a.LOADING, a.LOADED)) {
            a(this.f13974t ? IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS : IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS);
            return;
        }
        a(this.f13974t ? IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS : 3005, new Object[][]{new Object[]{"duration", Long.valueOf(ta.a(this.f13973s))}});
        mo moVar = this.f13965k;
        if (moVar != null) {
            moVar.a(this, view, layoutParams);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenDismissed() {
        IronLog.INTERNAL.verbose(f());
        a(IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN);
        mo moVar = this.f13965k;
        if (moVar != null) {
            moVar.e(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
        IronLog.INTERNAL.verbose(f());
        a(IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN);
        mo moVar = this.f13965k;
        if (moVar != null) {
            moVar.d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdShown() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (C()) {
            a(3009);
            mo moVar = this.f13965k;
            if (moVar != null) {
                moVar.a(this);
                return;
            }
            return;
        }
        ironLog.warning("wrong state - mState = " + this.f13964j);
        a(IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1}, new Object[]{"reason", "Wrong State - " + this.f13964j}, new Object[]{IronSourceConstants.EVENTS_EXT1, c()}});
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(y() + "error = " + ironSourceError);
        this.f13963i.e();
        if (a(a.INIT_IN_PROGRESS, a.NONE)) {
            mo moVar = this.f13965k;
            if (moVar != null) {
                moVar.a(ironSourceError, this, false);
                return;
            }
            return;
        }
        ironLog.warning("wrong state - mState = " + this.f13964j);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose(f());
        if (a(a.INIT_IN_PROGRESS, a.READY_TO_LOAD)) {
            if (this.f13975u) {
                this.f13975u = false;
            } else {
                if (p()) {
                    return;
                }
                if (l.c(this.f13966l)) {
                    a((String) null, this.f13976v);
                } else {
                    this.f13965k.a(new IronSourceError(605, this.f13966l == null ? "banner is null" : "banner is destroyed"), this, false);
                }
            }
        }
    }

    @Override // com.ironsource.mediationsdk.y
    public void q() {
        this.f13963i.d();
        super.q();
    }

    public void t() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        a(3305);
        a(a.DESTROYED);
        AbstractAdapter abstractAdapter = this.f13985a;
        if (abstractAdapter == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            abstractAdapter.destroyBanner(this.f13986b.h().getBannerSettings());
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to destroy banner from " + this.f13985a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            a(IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_destroy)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    public String v() {
        return !TextUtils.isEmpty(this.f13986b.h().getAdSourceNameForEvents()) ? this.f13986b.h().getAdSourceNameForEvents() : i();
    }

    public AbstractAdapter w() {
        return this.f13985a;
    }

    public String x() {
        return this.f13967m;
    }

    public String y() {
        return String.format("%s - ", f());
    }

    public String z() {
        return this.f13986b.i();
    }

    x(k kVar, mo moVar, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i10, boolean z10) {
        this(kVar, moVar, networkSettings, abstractAdapter, i10, "", null, 0, "", z10);
    }

    @Override // com.ironsource.gs.a
    public void a() {
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        a aVar = a.INIT_IN_PROGRESS;
        a aVar2 = a.LOAD_FAILED;
        if (a(aVar, aVar2)) {
            ironLog.verbose("init timed out");
            ironSourceError = new IronSourceError(607, "Timed out");
        } else {
            if (!a(a.LOADING, aVar2)) {
                ironLog.error("unexpected state - " + this.f13964j);
                return;
            }
            ironLog.verbose("load timed out");
            ironSourceError = new IronSourceError(608, "Timed out");
        }
        a(ironSourceError);
    }

    public void a(int i10) {
        a(i10, (Object[][]) null);
    }

    public void a(int i10, Object[][] objArr) {
        Map<String, Object> mapM = m();
        if (B()) {
            mapM.put("reason", "banner is destroyed");
        } else {
            IronSourceBannerLayout ironSourceBannerLayout = this.f13966l;
            if (ironSourceBannerLayout != null) {
                l.a(mapM, ironSourceBannerLayout.getSize());
            }
        }
        if (!TextUtils.isEmpty(this.f13967m)) {
            mapM.put("auctionId", this.f13967m);
        }
        JSONObject jSONObject = this.f13968n;
        if (jSONObject != null && jSONObject.length() > 0) {
            mapM.put("genericParams", this.f13968n);
        }
        b7 b7Var = this.f13971q;
        if (b7Var != null) {
            mapM.put("placement", b7Var.getPlacementName());
        }
        if (b(i10)) {
            ji.i().a(mapM, this.f13969o, this.f13970p);
        }
        mapM.put("sessionDepth", Integer.valueOf(this.f13990f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapM.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(c() + " smash: BN sendMediationEvent " + Log.getStackTraceString(e10));
            }
        }
        ji.i().a(new kb(i10, new JSONObject(mapM)));
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, b7 b7Var, String str, JSONObject jSONObject) {
        mo moVar;
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        this.f13971q = b7Var;
        this.f13976v = jSONObject;
        if (!l.c(ironSourceBannerLayout)) {
            String str2 = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            ironLog.verbose(str2);
            moVar = this.f13965k;
            ironSourceError = new IronSourceError(610, str2);
        } else {
            if (this.f13985a != null) {
                this.f13966l = ironSourceBannerLayout;
                this.f13963i.a((gs.a) this);
                try {
                    if (p()) {
                        a(str, this.f13976v);
                    } else {
                        A();
                    }
                    return;
                } catch (Throwable th) {
                    i9.d().a(th);
                    IronLog.INTERNAL.error("exception = " + th.getLocalizedMessage());
                    onBannerAdLoadFailed(new IronSourceError(605, th.getLocalizedMessage()));
                    return;
                }
            }
            ironLog.verbose("mAdapter is null");
            moVar = this.f13965k;
            ironSourceError = new IronSourceError(611, "mAdapter is null");
        }
        moVar.a(ironSourceError, this, false);
    }

    @Override // com.ironsource.s7
    public void a(AdData adData, @NotNull BiddingDataCallback biddingDataCallback) {
        a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN);
        try {
            this.f13985a.collectBannerBiddingData(this.f13988d, adData != null ? hj.a(adData.getAdUnitData()) : null, biddingDataCallback);
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.error("Exception while trying to collectBannerBiddingData from " + this.f13985a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
        }
    }

    private void a(IronSourceError ironSourceError) {
        boolean z10 = ironSourceError.getErrorCode() == 606;
        boolean z11 = this.f13974t;
        if (z10) {
            a(z11 ? IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL : 3306, new Object[][]{new Object[]{"duration", Long.valueOf(ta.a(this.f13973s))}});
        } else {
            a(z11 ? IronSourceConstants.BN_INSTANCE_RELOAD_ERROR : 3300, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(ta.a(this.f13973s))}});
        }
        mo moVar = this.f13965k;
        if (moVar != null) {
            moVar.a(ironSourceError, this, z10);
        }
    }

    private void a(a aVar) {
        IronLog.INTERNAL.verbose(y() + "state = " + aVar.name());
        synchronized (this.f13972r) {
            this.f13964j = aVar;
        }
    }

    private void a(String str, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(f());
        if (!a(a.READY_TO_LOAD, a.LOADING)) {
            ironLog.error("wrong state - state = " + this.f13964j);
            return;
        }
        this.f13973s = new ta();
        a(this.f13974t ? IronSourceConstants.BN_INSTANCE_RELOAD : 3002);
        if (this.f13985a != null) {
            try {
                if (p()) {
                    this.f13985a.loadBannerForBidding(this.f13988d, this.f13976v, str, this.f13966l, this);
                } else {
                    this.f13985a.loadBanner(this.f13988d, this.f13976v, this.f13966l, this);
                }
            } catch (Throwable th) {
                i9.d().a(th);
                IronLog.INTERNAL.error("Exception while trying to load banner from " + this.f13985a.getProviderName() + ", exception =  " + th.getLocalizedMessage());
                onBannerAdLoadFailed(new IronSourceError(605, th.getLocalizedMessage()));
                a(IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_loadException)}, new Object[]{"reason", th.getLocalizedMessage()}});
            }
        }
    }

    private boolean a(a aVar, a aVar2) {
        boolean z10;
        synchronized (this.f13972r) {
            if (this.f13964j == aVar) {
                IronLog.INTERNAL.verbose(y() + "set state from '" + this.f13964j + "' to '" + aVar2 + "'");
                this.f13964j = aVar2;
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }
}
