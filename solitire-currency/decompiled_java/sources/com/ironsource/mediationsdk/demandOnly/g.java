package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.el;
import com.ironsource.environment.ContextProvider;
import com.ironsource.f5;
import com.ironsource.i9;
import com.ironsource.ji;
import com.ironsource.kb;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.demandOnly.a;
import com.ironsource.mediationsdk.demandOnly.e;
import com.ironsource.mediationsdk.demandOnly.m;
import com.ironsource.mediationsdk.demandOnly.n;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mg;
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
public class g extends m implements n.a, InterstitialSmashListener, t4 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ta f13456n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ta f13457o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ISDemandOnlyInterstitialListener f13458p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private v4 f13459q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.ironsource.mediationsdk.e f13460r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private p f13461s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final mg f13462t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final mg.a f13463u;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("load timed out state=" + g.this.k());
            g.this.a(new IronSourceError(1052, "load timed out"));
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("load timed out state=" + g.this.k());
            g.this.a(new IronSourceError(1052, "load timed out"));
        }
    }

    public g(String str, String str2, NetworkSettings networkSettings, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener, long j10, AbstractAdapter abstractAdapter, com.ironsource.mediationsdk.e eVar) {
        super(new v2(networkSettings, networkSettings.getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), abstractAdapter);
        this.f13461s = new p.b();
        this.f13462t = el.N().k();
        this.f13463u = el.I().e();
        this.f13458p = iSDemandOnlyInterstitialListener;
        this.f13535f = j10;
        this.f13460r = eVar;
        this.f13530a.initInterstitial(str, str2, this.f13532c, this);
    }

    private com.ironsource.mediationsdk.i q() {
        String str = i() + h();
        com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(this.f13542m);
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(true);
        iVar.c(true);
        iVar.d(str);
        iVar.c(l());
        iVar.a(this.f13462t.a(this.f13542m));
        y4 y4Var = new y4(h(), false);
        y4Var.a(this.f13461s.value());
        Map<String, Object> interstitialBiddingData = this.f13530a.getInterstitialBiddingData(this.f13532c, new JSONObject());
        if (interstitialBiddingData != null) {
            y4Var.b(interstitialBiddingData);
        }
        iVar.a(y4Var);
        return iVar;
    }

    private void r() {
        this.f13457o = new ta();
        this.f13530a.loadInterstitial(this.f13532c, null, this);
    }

    private void s() {
        if (!this.f13460r.a()) {
            IronLog.INTERNAL.verbose("can't load the interstitial the auction isn't enabled");
            a(new IronSourceError(1063, "Missing server configuration"));
            return;
        }
        a(82500, (Object[][]) null);
        com.ironsource.mediationsdk.i iVarQ = q();
        IronLog.INTERNAL.verbose("auction waterfallString = " + iVarQ.q());
        a(82510, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, iVarQ.q()}});
        this.f13460r.a(ContextProvider.getInstance().getApplicationContext(), iVarQ, this);
    }

    private void t() {
        this.f13536g = null;
        this.f13537h = null;
        this.f13539j = null;
        this.f13459q = new v4();
    }

    private void u() {
        this.f13456n = new ta();
        a(new b());
        if (n()) {
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial must be called by non bidder instances");
            a(2303, (Object[][]) null);
            a(ironSourceErrorBuildLoadFailedError);
        } else if (o()) {
            s();
        } else {
            r();
        }
    }

    @Override // com.ironsource.l4
    public void a(int i10, String str, int i11, String str2, long j10) {
        IronLog.INTERNAL.verbose("error " + i10 + " - " + str);
        this.f13536g = null;
        this.f13537h = null;
        a(82300, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j10)}, new Object[]{IronSourceConstants.EVENTS_EXT1, k()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(e.a.f13424j, "No available ad to load"));
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.a
    public void b() {
        IronLog.INTERNAL.verbose("instanceName = " + h() + ", state=" + k());
        a(2201, (Object[][]) null);
        m.a aVar = m.a.LOADED;
        m.a aVar2 = m.a.SHOW_IN_PROGRESS;
        if (a(aVar, aVar2)) {
            this.f13530a.showInterstitial(this.f13532c, this);
        } else {
            onInterstitialAdShowFailed(a(aVar2) ? new IronSourceError(1064, "showInterstitial error: can't show ad while an ad is already showing") : a(m.a.LOAD_IN_PROGRESS) ? new IronSourceError(1065, "showInterstitial error: can't show ad while an ad is loading") : new IronSourceError(1066, "showInterstitial error: no available ads to show"));
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.a
    public void c() {
        IronLog.INTERNAL.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a aVarA = a(new m.a[]{aVar, aVar2}, aVar3);
        if (aVarA != aVar && aVarA != aVar2) {
            this.f13458p.onInterstitialAdLoadFailed(l(), new IronSourceError(1050, aVarA == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
            return;
        }
        t();
        a(2002, (Object[][]) null);
        u();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(2006, new Object[0][]);
        this.f13458p.onInterstitialAdClicked(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClosed() {
        b(m.a.NOT_LOADED);
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(2204, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(this.f13462t.a(this.f13542m))}});
        this.f13463u.b(this.f13542m);
        this.f13458p.onInterstitialAdClosed(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose("error=" + ironSourceError.getErrorMessage() + " instance name= " + h() + " state=" + k());
        a(e.c.f13446d, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(ta.a(this.f13457o))}});
        a(ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(2005, new Object[0][]);
        a(this.f13459q.a(), IronSourceUtils.getCurrentMethodName());
        this.f13458p.onInterstitialAdOpened(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdReady() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h() + " state=" + k());
        p();
        a(e.c.f13445c, new Object[][]{new Object[]{"duration", Long.valueOf(ta.a(this.f13457o))}});
        if (a(m.a.LOAD_IN_PROGRESS, m.a.LOADED)) {
            a(2003, new Object[][]{new Object[]{"duration", Long.valueOf(ta.a(this.f13456n))}});
            a(this.f13459q.c(), IronSourceUtils.getCurrentMethodName());
            this.f13458p.onInterstitialAdReady(l());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose("error=" + ironSourceError.toString() + " instance name= " + h() + " state=" + k());
        b(m.a.NOT_LOADED);
        a(2203, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        this.f13458p.onInterstitialAdShowFailed(l(), ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdVisible() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(2210, new Object[0][]);
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
        ji.i().a(new kb(i10, new JSONObject(mapJ)));
    }

    private void c(o oVar) {
        this.f13456n = new ta();
        a(new a());
        if (!n()) {
            a(new IronSourceError(2303, "loadInterstitialWithAdm: must be called by bidder instance"));
            return;
        }
        try {
            d.a aVar = (d.a) oVar.a(new ya());
            f5 f5VarA = new a.C0259a(aVar.h()).a(h());
            if (f5VarA == null) {
                IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm invalid enriched adm");
                a(2303, (Object[][]) null);
                a(ironSourceErrorBuildLoadFailedError);
                return;
            }
            String strJ = f5VarA.j();
            if (strJ == null) {
                IronLog.INTERNAL.error("serverData is null");
                a(new IronSourceError(e.a.f13423i, "No available ad to load"));
                return;
            }
            b(strJ);
            a(aVar.a());
            a(aVar.f());
            a(82002, (Object[][]) null);
            this.f13459q.a(f5VarA.b());
            this.f13457o = new ta();
            this.f13530a.loadInterstitialForBidding(this.f13532c, null, strJ, this);
        } catch (Exception e10) {
            i9.d().a(e10);
            a(ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm: Exception= " + e10.getMessage()));
        }
    }

    private void c(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (str == null) {
                ironLog.verbose("serverData is null");
                a(new IronSourceError(e.a.f13423i, "No available ad to load"));
            } else {
                a(82002, (Object[][]) null);
                this.f13530a.loadInterstitialForBidding(this.f13532c, null, str, this);
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
        this.f13461s = aVar.a(l());
        a.C0259a c0259a = new a.C0259a(aVar.h());
        if (c0259a.isEmpty()) {
            strJ = "";
        } else {
            f5 f5Var = c0259a.get(0);
            this.f13459q.a(f5Var.b());
            this.f13459q.c(f5Var.g());
            this.f13459q.b(f5Var.f());
            strJ = f5Var.j();
            b(strJ);
        }
        if (!TextUtils.isEmpty(str)) {
            a(88002, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i11)}, new Object[]{"reason", str}});
        }
        a(82301, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}});
        a(82302, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, c0259a.b()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (!c0259a.isEmpty()) {
                c(strJ);
                return;
            }
            IronSourceError ironSourceError = new IronSourceError(1158, "There is no available ad to load");
            ironLog.error("interstitial - empty waterfall");
            a(ironSourceError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.a
    public void a(o oVar) {
        IronLog.INTERNAL.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a aVarA = a(new m.a[]{aVar, aVar2}, aVar3);
        if (aVarA != aVar && aVarA != aVar2) {
            a(new IronSourceError(1050, aVarA == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
            return;
        }
        t();
        a(2002, (Object[][]) null);
        c(oVar);
    }

    void a(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose("instanceName = " + h() + ", error = " + ironSourceError.getErrorMessage());
        p();
        if (a(m.a.LOAD_IN_PROGRESS, m.a.NOT_LOADED)) {
            a(ironSourceError, ta.a(this.f13456n));
            a(this.f13459q.b(), IronSourceUtils.getCurrentMethodName());
            this.f13458p.onInterstitialAdLoadFailed(l(), ironSourceError);
        }
    }

    private void a(IronSourceError ironSourceError, long j10) {
        if (ironSourceError.getErrorCode() == 1158) {
            a(2213, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}});
        } else {
            a(2200, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        }
    }

    private void a(List<String> list, String str) {
        a(list, h(), i(), this.f13539j, str);
    }

    @Override // com.ironsource.l4
    public void a(List<f5> list, String str, f5 f5Var, JSONObject jSONObject, JSONObject jSONObject2, int i10, long j10, int i11, String str2) {
        IronLog.INTERNAL.error("Deprecated: Please use onAuctionSuccess(AuctionDataUtils.AuctionData auctionData, int auctionTrial, long elapsedTime, int troubleshootingErrorCode, String troubleshootingErrorMessage)");
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.a
    public boolean a() {
        boolean zIsInterstitialReady = false;
        if (!a(m.a.LOADED)) {
            a(2212, (Object[][]) null);
            return false;
        }
        try {
            zIsInterstitialReady = this.f13530a.isInterstitialReady(this.f13532c);
            a(zIsInterstitialReady ? 2211 : 2212, (Object[][]) null);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("exception=" + e10.getMessage());
        }
        return zIsInterstitialReady;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowSucceeded() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitFailed(IronSourceError ironSourceError) {
    }
}
