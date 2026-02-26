package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import android.util.Log;
import androidx.media3.datasource.cache.ContentMetadata;
import com.ironsource.el;
import com.ironsource.environment.ContextProvider;
import com.ironsource.f5;
import com.ironsource.i9;
import com.ironsource.kb;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.demandOnly.a;
import com.ironsource.mediationsdk.demandOnly.j;
import com.ironsource.mediationsdk.demandOnly.m;
import com.ironsource.mediationsdk.demandOnly.n;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mg;
import com.ironsource.rp;
import com.ironsource.t4;
import com.ironsource.ta;
import com.ironsource.v2;
import com.ironsource.v4;
import com.ironsource.y4;
import com.ironsource.ya;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class l extends m implements n.b, RewardedVideoSmashListener, t4 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ta f13521n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ta f13522o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ISDemandOnlyRewardedVideoListener f13523p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private v4 f13524q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.ironsource.mediationsdk.e f13525r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private p f13526s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final mg f13527t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final mg.a f13528u;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("load timed out state=" + l.this.k());
            l.this.a(new IronSourceError(1055, "load timed out"));
        }
    }

    l(String str, String str2, NetworkSettings networkSettings, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener, long j10, AbstractAdapter abstractAdapter, com.ironsource.mediationsdk.e eVar) {
        super(new v2(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), abstractAdapter);
        this.f13526s = new p.b();
        this.f13527t = el.N().k();
        this.f13528u = el.I().e();
        this.f13523p = iSDemandOnlyRewardedVideoListener;
        this.f13535f = j10;
        this.f13525r = eVar;
        this.f13530a.initRewardedVideoForDemandOnly(str, str2, this.f13532c, this);
    }

    private void c(o oVar) {
        this.f13521n = new ta();
        a(s());
        if (!n()) {
            a(new IronSourceError(j.a.f13490k, "loadRewardedVideoWithAdm: must be called by bidder instance"));
            return;
        }
        try {
            d.a aVar = (d.a) oVar.a(new ya());
            f5 f5VarA = new a.C0259a(aVar.h()).a(h());
            if (f5VarA == null) {
                IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm invalid enriched adm");
                a(j.a.f13490k, (Object[][]) null);
                a(ironSourceErrorBuildLoadFailedError);
                return;
            }
            String strJ = f5VarA.j();
            if (strJ == null) {
                IronLog.INTERNAL.error("serverData is null");
                a(new IronSourceError(1062, "No available ad to load"));
                return;
            }
            b(strJ);
            a(aVar.a());
            a(aVar.f());
            a(81002, (Object[][]) null);
            this.f13524q.a(f5VarA.b());
            this.f13522o = new ta();
            this.f13530a.loadRewardedVideoForBidding(this.f13532c, null, strJ, this);
        } catch (Exception e10) {
            i9.d().a(e10);
            a(ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm: Exception= " + e10.getMessage()));
        }
    }

    private IronSourceError q() {
        return a(m.a.SHOW_IN_PROGRESS) ? new IronSourceError(1067, "showRewardedVideo error: can't show ad while an ad is already showing") : a(m.a.LOAD_IN_PROGRESS) ? new IronSourceError(1068, "showRewardedVideo error: can't show ad while an ad is loading") : new IronSourceError(1069, "showRewardedVideo error: no available ads to show");
    }

    private com.ironsource.mediationsdk.i r() {
        String str = i() + h();
        com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(this.f13542m);
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(true);
        iVar.c(true);
        iVar.d(str);
        iVar.c(l());
        iVar.a(this.f13527t.a(this.f13542m));
        y4 y4Var = new y4(h(), false);
        y4Var.a(this.f13526s.value());
        Map<String, Object> rewardedVideoBiddingData = this.f13530a.getRewardedVideoBiddingData(this.f13532c, new JSONObject());
        if (rewardedVideoBiddingData != null) {
            y4Var.b(rewardedVideoBiddingData);
        }
        iVar.a(y4Var);
        return iVar;
    }

    private TimerTask s() {
        return new a();
    }

    private void t() {
        this.f13522o = new ta();
        this.f13530a.loadRewardedVideo(this.f13532c, null, this);
    }

    private void u() {
        if (!this.f13525r.a()) {
            IronLog.INTERNAL.verbose("can't load the rewarded video the auction isn't enabled");
            a(new IronSourceError(1063, "Missing server configuration"));
            return;
        }
        a(81500, (Object[][]) null);
        com.ironsource.mediationsdk.i iVarR = r();
        IronLog.INTERNAL.verbose("auction waterfallString = " + iVarR.q());
        a(81510, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, iVarR.q()}});
        this.f13525r.a(ContextProvider.getInstance().getApplicationContext(), iVarR, this);
    }

    private void v() {
        this.f13536g = null;
        this.f13537h = null;
        this.f13539j = null;
        this.f13524q = new v4();
    }

    private void w() {
        this.f13521n = new ta();
        a(s());
        if (n()) {
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideo must be called by non bidder instances");
            a(j.a.f13490k, (Object[][]) null);
            a(ironSourceErrorBuildLoadFailedError);
        } else if (o()) {
            u();
        } else {
            t();
        }
    }

    @Override // com.ironsource.l4
    public void a(int i10, String str, int i11, String str2, long j10) {
        IronLog.INTERNAL.verbose("Auction failed. error " + i10 + " - " + str);
        this.f13536g = null;
        this.f13537h = null;
        a(81300, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j10)}, new Object[]{IronSourceConstants.EVENTS_EXT1, k()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(j.a.f13489j, "No available ad to load"));
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.b
    public void b(o oVar) {
        IronLog.INTERNAL.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a aVarA = a(new m.a[]{aVar, aVar2}, aVar3);
        if (aVarA != aVar && aVarA != aVar2) {
            a(new IronSourceError(1053, aVarA == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
            return;
        }
        v();
        a(1001, (Object[][]) null);
        c(oVar);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.b
    public void d() {
        IronLog.INTERNAL.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a aVarA = a(new m.a[]{aVar, aVar2}, aVar3);
        if (aVarA != aVar && aVarA != aVar2) {
            this.f13523p.onRewardedVideoAdLoadFailed(l(), new IronSourceError(1053, aVarA == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
            return;
        }
        v();
        a(1001, (Object[][]) null);
        w();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.b
    public void e() {
        IronLog.INTERNAL.verbose("instanceName = " + h() + ", state=" + k());
        a(1201, (Object[][]) null);
        if (a(m.a.LOADED, m.a.SHOW_IN_PROGRESS)) {
            this.f13530a.showRewardedVideo(this.f13532c, this);
        } else {
            onRewardedVideoAdShowFailed(q());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(1006, new Object[0][]);
        this.f13523p.onRewardedVideoAdClicked(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
        b(m.a.NOT_LOADED);
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(1203, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(this.f13527t.a(this.f13542m))}});
        this.f13528u.b(this.f13542m);
        this.f13523p.onRewardedVideoAdClosed(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(1005, new Object[0][]);
        a(this.f13524q.a(), IronSourceUtils.getCurrentMethodName());
        this.f13523p.onRewardedVideoAdOpened(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        Map<String, Object> mapJ = j();
        if (!TextUtils.isEmpty(com.ironsource.mediationsdk.p.m().l())) {
            mapJ.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, com.ironsource.mediationsdk.p.m().l());
        }
        if (com.ironsource.mediationsdk.p.m().s() != null) {
            for (String str : com.ironsource.mediationsdk.p.m().s().keySet()) {
                mapJ.put(ContentMetadata.KEY_CUSTOM_PREFIX + str, com.ironsource.mediationsdk.p.m().s().get(str));
            }
        }
        Placement placementA = com.ironsource.mediationsdk.p.m().h().c().f().a();
        if (placementA != null) {
            mapJ.put("placement", placementA.getPlacementName());
            mapJ.put(IronSourceConstants.EVENTS_REWARD_NAME, placementA.getRewardName());
            mapJ.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(placementA.getRewardAmount()));
        } else {
            IronLog.INTERNAL.error("defaultPlacement is null");
        }
        kb kbVar = new kb(1010, new JSONObject(mapJ));
        kbVar.a(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId(kbVar.d(), h()));
        rp.i().a(kbVar);
        this.f13523p.onRewardedVideoAdRewarded(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose("error=" + ironSourceError.toString() + " instance name= " + h() + " state=" + k());
        b(m.a.NOT_LOADED);
        a(1202, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        this.f13523p.onRewardedVideoAdShowFailed(l(), ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(1206, new Object[0][]);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose("error=" + ironSourceError.getErrorMessage() + "instance name= " + h() + " state=" + k());
        a(j.c.f13511d, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(ta.a(this.f13522o))}});
        a(ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h() + " state=" + k());
        p();
        a(j.c.f13510c, new Object[][]{new Object[]{"duration", Long.valueOf(ta.a(this.f13522o))}});
        if (a(m.a.LOAD_IN_PROGRESS, m.a.LOADED)) {
            a(1002, new Object[][]{new Object[]{"duration", Long.valueOf(ta.a(this.f13521n))}});
            a(this.f13524q.c(), IronSourceUtils.getCurrentMethodName());
            this.f13523p.onRewardedVideoAdLoadSuccess(l());
        }
    }

    private void a(int i10, Object[][] objArr) {
        Map<String, Object> mapJ = j();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    mapJ.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error("Exception: " + Log.getStackTraceString(e10));
            }
        }
        rp.i().a(new kb(i10, new JSONObject(mapJ)));
    }

    private void c(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (str == null) {
                ironLog.verbose("serverData is null");
                a(new IronSourceError(1062, "No available ad to load"));
            } else {
                a(81002, (Object[][]) null);
                this.f13530a.loadRewardedVideoForBidding(this.f13532c, null, str, this);
            }
        }
    }

    @Override // com.ironsource.t4
    public void a(d.a aVar, int i10, long j10, int i11, String str) {
        String strJ;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        this.f13536g = aVar.a();
        this.f13537h = aVar.f();
        this.f13526s = aVar.a(l());
        a.C0259a c0259a = new a.C0259a(aVar.h());
        if (c0259a.isEmpty()) {
            strJ = "";
        } else {
            f5 f5Var = c0259a.get(0);
            this.f13524q.a(f5Var.b());
            this.f13524q.c(f5Var.g());
            this.f13524q.b(f5Var.f());
            strJ = f5Var.j();
            b(strJ);
        }
        if (!TextUtils.isEmpty(str)) {
            a(88002, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i11)}, new Object[]{"reason", str}});
        }
        a(81301, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}});
        a(81302, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, c0259a.b()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (!c0259a.isEmpty()) {
                c(strJ);
                return;
            }
            IronSourceError ironSourceError = new IronSourceError(1058, "There is no available ad to load");
            ironLog.error("rewardedVideo - empty waterfall");
            a(ironSourceError);
        }
    }

    void a(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose("instanceName = " + h() + ", error = " + ironSourceError.getErrorMessage());
        p();
        if (a(m.a.LOAD_IN_PROGRESS, m.a.NOT_LOADED)) {
            a(ironSourceError, ta.a(this.f13521n));
            a(this.f13524q.b(), IronSourceUtils.getCurrentMethodName());
            this.f13523p.onRewardedVideoAdLoadFailed(l(), ironSourceError);
        }
    }

    private void a(IronSourceError ironSourceError, long j10) {
        if (ironSourceError.getErrorCode() == 1058) {
            a(1213, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}});
        } else {
            a(1200, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        }
    }

    private void a(List<String> list, String str) {
        a(list, h(), i(), this.f13539j, str);
    }

    @Override // com.ironsource.l4
    public void a(List<f5> list, String str, f5 f5Var, JSONObject jSONObject, JSONObject jSONObject2, int i10, long j10, int i11, String str2) {
        IronLog.INTERNAL.error("Deprecated: Please use onAuctionSuccess(AuctionDataUtils.AuctionData auctionData, int auctionTrial, long elapsedTime, int troubleshootingErrorCode, String troubleshootingErrorMessage)");
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.b
    public boolean a() {
        boolean zIsRewardedVideoAvailable = false;
        if (!a(m.a.LOADED)) {
            a(1211, (Object[][]) null);
            return false;
        }
        try {
            zIsRewardedVideoAvailable = this.f13530a.isRewardedVideoAvailable(this.f13532c);
            a(zIsRewardedVideoAvailable ? 1210 : 1211, (Object[][]) null);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("exception=" + e10.getMessage());
        }
        return zIsRewardedVideoAvailable;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAvailabilityChanged(boolean z10) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }
}
