package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import androidx.media3.datasource.cache.ContentMetadata;
import com.ironsource.el;
import com.ironsource.hj;
import com.ironsource.i9;
import com.ironsource.kb;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mg;
import com.ironsource.rp;
import com.ironsource.s7;
import com.ironsource.uj;
import com.ironsource.v2;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class r extends y implements RewardedVideoSmashListener, s7 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f13822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private uj f13823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Timer f13824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f13825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f13826l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f13827m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Placement f13828n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f13829o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f13830p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private JSONObject f13831q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f13832r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f13833s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Object f13834t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Object f13835u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f13836v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final mg.a f13837w;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i10;
            boolean z10;
            b bVar = r.this.f13822h;
            b bVar2 = b.LOAD_IN_PROGRESS;
            String str = "Rewarded Video - load instance time out";
            if (bVar == bVar2 || r.this.f13822h == b.INIT_IN_PROGRESS) {
                if (r.this.f13822h == bVar2) {
                    i10 = 1025;
                } else {
                    i10 = 1032;
                    str = "Rewarded Video - init instance time out";
                }
                r.this.a(b.NOT_LOADED);
                z10 = true;
            } else {
                i10 = 510;
                z10 = false;
            }
            r.this.a(str);
            if (!z10) {
                r.this.a(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{"duration", Long.valueOf(r.this.v())}, new Object[]{IronSourceConstants.EVENTS_EXT1, r.this.f13822h.name()}});
                return;
            }
            r.this.a(1200, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10)}, new Object[]{"duration", Long.valueOf(r.this.v())}});
            r.this.a(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(r.this.v())}});
            r.this.f13823i.c(r.this);
        }
    }

    protected enum b {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS,
        ENDED
    }

    public r(r rVar, uj ujVar, AbstractAdapter abstractAdapter, int i10, String str, JSONObject jSONObject, int i11, String str2) {
        this(rVar.f13826l, rVar.f13827m, rVar.f13986b.h(), ujVar, rVar.f13825k, abstractAdapter, i10);
        this.f13830p = str;
        this.f13831q = jSONObject;
        this.f13832r = i11;
        this.f13833s = str2;
    }

    private void C() {
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (TextUtils.isEmpty(pluginType)) {
                return;
            }
            this.f13985a.setPluginData(pluginType);
        } catch (Throwable th) {
            i9.d().a(th);
            a("setCustomParams() " + th.getMessage());
        }
    }

    private void D() {
        synchronized (this.f13835u) {
            Timer timer = new Timer();
            this.f13824j = timer;
            timer.schedule(new a(), this.f13825k * 1000);
        }
    }

    private void E() {
        synchronized (this.f13835u) {
            Timer timer = this.f13824j;
            if (timer != null) {
                timer.cancel();
                this.f13824j = null;
            }
        }
    }

    private void t() {
        a("isBidder = " + p() + ", shouldEarlyInit = " + s());
        a(b.INIT_IN_PROGRESS);
        C();
        try {
            this.f13985a.initRewardedVideoWithCallback(this.f13826l, this.f13827m, this.f13988d, this);
        } catch (Throwable th) {
            i9.d().a(th);
            b("initForBidding exception: " + th.getLocalizedMessage());
            onRewardedVideoInitFailed(new IronSourceError(IronSourceError.ERROR_RV_INSTANCE_INIT_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long v() {
        return new Date().getTime() - this.f13829o;
    }

    public boolean A() {
        if (this.f13822h != b.LOADED) {
            return false;
        }
        try {
            return this.f13985a.isRewardedVideoAvailable(this.f13988d);
        } catch (Throwable th) {
            i9.d().a(th);
            b("isReadyToShow exception: " + th.getLocalizedMessage());
            a(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 5002}, new Object[]{"reason", th.getLocalizedMessage()}});
            return false;
        }
    }

    public void B() {
        a(IronSourceConstants.RV_CAP_SESSION);
    }

    @Override // com.ironsource.mediationsdk.y
    public IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.REWARDED_VIDEO;
    }

    @Override // com.ironsource.mediationsdk.y
    public String k() {
        return "LWSProgRvSmash";
    }

    @Override // com.ironsource.mediationsdk.y
    public int l() {
        return 2;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
        a("onRewardedVideoAdClicked");
        this.f13823i.b(this, this.f13828n);
        b(1006);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
        a("onRewardedVideoAdClosed");
        synchronized (this.f13834t) {
            if (this.f13822h == b.SHOW_IN_PROGRESS) {
                a(b.ENDED);
                this.f13836v = new Date().getTime();
                this.f13823i.b(this);
            } else {
                b(1203);
                a(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_adClosed)}, new Object[]{"reason", "adClosed: " + this.f13822h}});
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
        a("onRewardedVideoAdEnded");
        this.f13823i.f(this);
        b(IronSourceConstants.RV_INSTANCE_ENDED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened() {
        a("onRewardedVideoAdOpened");
        this.f13823i.d(this);
        b(1005);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
        a("onRewardedVideoAdRewarded");
        long time = new Date().getTime();
        this.f13823i.a(this, this.f13828n);
        Map<String, Object> mapM = m();
        Placement placement = this.f13828n;
        if (placement != null) {
            mapM.put("placement", placement.getPlacementName());
            mapM.put(IronSourceConstants.EVENTS_REWARD_NAME, this.f13828n.getRewardName());
            mapM.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.f13828n.getRewardAmount()));
        }
        if (!TextUtils.isEmpty(p.m().l())) {
            mapM.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, p.m().l());
        }
        if (p.m().s() != null) {
            for (String str : p.m().s().keySet()) {
                mapM.put(ContentMetadata.KEY_CUSTOM_PREFIX + str, p.m().s().get(str));
            }
        }
        if (!TextUtils.isEmpty(this.f13830p)) {
            mapM.put("auctionId", this.f13830p);
        }
        JSONObject jSONObject = this.f13831q;
        if (jSONObject != null && jSONObject.length() > 0) {
            mapM.put("genericParams", this.f13831q);
        }
        if (c(1010)) {
            rp.i().a(mapM, this.f13832r, this.f13833s);
        }
        mapM.put("sessionDepth", Integer.valueOf(this.f13990f));
        kb kbVar = new kb(1010, new JSONObject(mapM));
        kbVar.a(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId(kbVar.d(), c()));
        long j10 = this.f13836v;
        if (j10 != 0) {
            long j11 = time - j10;
            a("onRewardedVideoAdRewarded timeAfterClosed=" + j11);
            kbVar.a("duration", Long.valueOf(j11));
        }
        rp.i().a(kbVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        a("onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        b(1202, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        synchronized (this.f13834t) {
            if (this.f13822h == b.SHOW_IN_PROGRESS) {
                a(b.ENDED);
                this.f13823i.a(ironSourceError, this);
                return;
            }
            a(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_showFailed)}, new Object[]{"reason", "showFailed: " + this.f13822h}});
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
        a("onRewardedVideoAdStarted");
        this.f13823i.a(this);
        b(IronSourceConstants.RV_INSTANCE_STARTED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
        a("onRewardedVideoAdVisible");
        b(1206);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAvailabilityChanged(boolean z10) {
        boolean z11;
        a("onRewardedVideoAvailabilityChanged available=" + z10 + " state=" + this.f13822h.name());
        synchronized (this.f13834t) {
            if (this.f13822h == b.LOAD_IN_PROGRESS) {
                a(z10 ? b.LOADED : b.NOT_LOADED);
                z11 = false;
            } else {
                z11 = true;
            }
        }
        if (z11) {
            if (z10) {
                a(IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.f13822h.name()}});
                return;
            } else {
                a(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK)}, new Object[]{"duration", Long.valueOf(v())}, new Object[]{IronSourceConstants.EVENTS_EXT1, this.f13822h.name()}});
                return;
            }
        }
        E();
        a(z10 ? 1002 : 1200, new Object[][]{new Object[]{"duration", Long.valueOf(v())}});
        if (z10) {
            this.f13823i.e(this);
        } else {
            this.f13823i.c(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        a("onRewardedVideoInitFailed error=" + ironSourceError.getErrorMessage());
        E();
        a(1200, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT)}, new Object[]{"duration", Long.valueOf(v())}});
        a(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(v())}});
        synchronized (this.f13834t) {
            if (this.f13822h == b.INIT_IN_PROGRESS) {
                a(b.NO_INIT);
                this.f13823i.c(this);
                return;
            }
            a(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)}, new Object[]{"reason", "initFailed: " + this.f13822h}});
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
        a("onRewardedVideoInitSuccess");
        synchronized (this.f13834t) {
            if (this.f13822h == b.INIT_IN_PROGRESS) {
                a(b.NOT_LOADED);
                return;
            }
            a(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initSuccess)}, new Object[]{"reason", "initSuccess: " + this.f13822h}});
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        if (ironSourceError.getErrorCode() == 1058) {
            a(1213, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"duration", Long.valueOf(v())}});
            return;
        }
        if (ironSourceError.getErrorCode() == 1057) {
            this.f13991g = Long.valueOf(System.currentTimeMillis());
        }
        a(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(v())}});
    }

    public String u() {
        return this.f13830p;
    }

    public LoadWhileShowSupportState w() {
        try {
            return this.f13985a.getLoadWhileShowSupportState(this.f13988d);
        } catch (Throwable th) {
            i9.d().a(th);
            b("Exception while calling adapter.getLoadWhileShowSupportState() - " + th.getLocalizedMessage());
            return LoadWhileShowSupportState.NONE;
        }
    }

    public Placement x() {
        return this.f13828n;
    }

    public boolean y() {
        return this.f13822h == b.LOADED;
    }

    public boolean z() {
        b bVar = this.f13822h;
        return bVar == b.INIT_IN_PROGRESS || bVar == b.LOAD_IN_PROGRESS;
    }

    public r(String str, String str2, NetworkSettings networkSettings, uj ujVar, int i10, AbstractAdapter abstractAdapter, int i11) {
        super(new v2(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), abstractAdapter);
        this.f13834t = new Object();
        this.f13835u = new Object();
        this.f13837w = el.I().e();
        this.f13826l = str;
        this.f13827m = str2;
        this.f13823i = ujVar;
        this.f13824j = null;
        this.f13825k = i10;
        this.f13990f = i11;
        this.f13822h = b.NO_INIT;
        this.f13836v = 0L;
        if (r()) {
            t();
        }
    }

    private void b(int i10) {
        b(i10, null);
    }

    private boolean c(int i10) {
        return i10 == 1001 || i10 == 1002 || i10 == 1200 || i10 == 1212 || i10 == 1213 || i10 == 1005 || i10 == 1203 || i10 == 1201 || i10 == 1202 || i10 == 1006 || i10 == 1010;
    }

    @Override // com.ironsource.s7
    public Map<String, Object> a(AdData adData) {
        JSONObject jSONObjectA = adData != null ? hj.a(adData.getAdUnitData()) : null;
        if (p()) {
            return this.f13985a.getRewardedVideoBiddingData(this.f13988d, jSONObjectA);
        }
        return null;
    }

    public void a(int i10) {
        a(i10, null, false);
    }

    public void b(int i10, Object[][] objArr) {
        a(i10, objArr, true);
    }

    public void a(int i10, Object[][] objArr) {
        a(i10, objArr, false);
    }

    public void b(boolean z10) {
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = "status";
        objArr2[1] = z10 ? com.ironsource.mediationsdk.metadata.a.f13688g : "false";
        objArr[0] = objArr2;
        b(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE, objArr);
    }

    private void a(int i10, Object[][] objArr, boolean z10) {
        Placement placement;
        Map<String, Object> mapM = m();
        if (!TextUtils.isEmpty(this.f13830p)) {
            mapM.put("auctionId", this.f13830p);
        }
        JSONObject jSONObject = this.f13831q;
        if (jSONObject != null && jSONObject.length() > 0) {
            mapM.put("genericParams", this.f13831q);
        }
        if (z10 && (placement = this.f13828n) != null && !TextUtils.isEmpty(placement.getPlacementName())) {
            mapM.put("placement", this.f13828n.getPlacementName());
        }
        if (c(i10)) {
            rp.i().a(mapM, this.f13832r, this.f13833s);
        }
        mapM.put("sessionDepth", Integer.valueOf(this.f13990f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapM.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, c() + " smash: RV sendProviderEvent " + Log.getStackTraceString(e10), 3);
            }
        }
        rp.i().a(new kb(i10, new JSONObject(mapM)));
        if (i10 == 1203) {
            this.f13837w.b(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
    }

    @Override // com.ironsource.s7
    public void a(AdData adData, @NotNull BiddingDataCallback biddingDataCallback) {
        a(1020);
        try {
            this.f13985a.collectRewardedVideoBiddingData(this.f13988d, adData != null ? hj.a(adData.getAdUnitData()) : null, biddingDataCallback);
        } catch (Throwable th) {
            i9.d().a(th);
            b("collectBiddingData exception: " + th.getLocalizedMessage());
            IronLog.INTERNAL.error(th.toString());
        }
    }

    public void a(Placement placement) {
        E();
        a("showVideo()");
        this.f13828n = placement;
        a(b.SHOW_IN_PROGRESS);
        b(1201);
        try {
            this.f13985a.showRewardedVideo(this.f13988d, this);
        } catch (Throwable th) {
            i9.d().a(th);
            b("showVideo exception: " + th.getLocalizedMessage());
            onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_RV_SHOW_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        a("current state=" + this.f13822h + ", new state=" + bVar);
        synchronized (this.f13834t) {
            this.f13822h = bVar;
        }
    }

    public void a(String str, JSONObject jSONObject) {
        b bVar;
        b bVar2;
        a("loadVideo() auctionId: " + this.f13830p + " state: " + this.f13822h);
        this.f13991g = null;
        a(false);
        synchronized (this.f13834t) {
            bVar = this.f13822h;
            bVar2 = b.LOAD_IN_PROGRESS;
            if (bVar != bVar2 && bVar != b.SHOW_IN_PROGRESS) {
                a(bVar2);
            }
        }
        if (bVar == bVar2) {
            a(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 5003}, new Object[]{"reason", "load during load"}});
            return;
        }
        if (bVar == b.SHOW_IN_PROGRESS) {
            a(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_showInProgress)}, new Object[]{"reason", "load during show"}});
            return;
        }
        D();
        this.f13829o = new Date().getTime();
        a(1001);
        try {
            if (p()) {
                this.f13985a.loadRewardedVideoForBidding(this.f13988d, jSONObject, str, this);
            } else {
                C();
                this.f13985a.initAndLoadRewardedVideo(this.f13826l, this.f13827m, this.f13988d, jSONObject, this);
            }
        } catch (Throwable th) {
            i9.d().a(th);
            b("loadVideo exception: " + th.getLocalizedMessage());
            a(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(p() ? IronSourceConstants.errorCode_loadException : IronSourceConstants.errorCode_initFailed)}, new Object[]{"reason", th.getLocalizedMessage()}});
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
    }
}
