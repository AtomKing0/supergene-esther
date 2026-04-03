package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.el;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.f5;
import com.ironsource.h5;
import com.ironsource.hr;
import com.ironsource.i9;
import com.ironsource.kb;
import com.ironsource.kj;
import com.ironsource.l4;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.pp;
import com.ironsource.q7;
import com.ironsource.qe;
import com.ironsource.rp;
import com.ironsource.se;
import com.ironsource.t7;
import com.ironsource.to;
import com.ironsource.tp;
import com.ironsource.u7;
import com.ironsource.uj;
import com.ironsource.up;
import com.ironsource.vj;
import com.ironsource.vm;
import com.ironsource.yb;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class q extends m implements uj, up, l4, se, vm, com.ironsource.o {
    private long A;
    private Boolean B;
    private final Object C;
    private yb D;
    private final boolean E;
    private final long F;
    private final qe.a G;
    private final qe H;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private vj f13783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, f5> f13784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, h.a> f13785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private f5 f13786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h f13787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.ironsource.mediationsdk.e f13788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private JSONObject f13789k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private tp f13790l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f13791m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f13792n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f13793o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f13794p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private NetworkStateReceiver f13795q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f13796r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ConcurrentHashMap<String, r> f13797s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private hr f13798t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f13799u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f13800v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f13801w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f13802x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f13803y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private e f13804z;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f13805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ pp f13806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f13807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f13808d;

        a(NetworkSettings networkSettings, pp ppVar, String str, String str2) {
            this.f13805a = networkSettings;
            this.f13806b = ppVar;
            this.f13807c = str;
            this.f13808d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.a(this.f13805a, this.f13806b, this.f13807c, this.f13808d);
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            q.this.j();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.d("makeAuction()");
            q.this.f13792n = new Date().getTime();
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            q.this.b(map, arrayList, sb, arrayList2);
            if (q.this.E) {
                q.this.a(map, arrayList, sb, arrayList2);
            } else {
                q.this.a(map, arrayList, sb.toString());
            }
        }
    }

    class d implements t7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f13812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f13813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f13814c;

        d(Map map, StringBuilder sb, List list) {
            this.f13812a = map;
            this.f13813b = sb;
            this.f13814c = list;
        }

        @Override // com.ironsource.t7.b
        public void a(@NotNull List<u7> list, long j10, @NotNull List<String> list2) {
            q.this.c(IronSourceConstants.RV_COLLECT_TOKENS_COMPLETED, kj.a(new Object[][]{new Object[]{"duration", Long.valueOf(j10)}}));
            for (u7 u7Var : list) {
                r rVar = (r) q.this.f13797s.get(u7Var.c());
                if (u7Var.a() != null) {
                    this.f13812a.put(u7Var.c(), u7Var.a());
                    StringBuilder sb = this.f13813b;
                    sb.append(u7Var.d());
                    sb.append(u7Var.c());
                    sb.append(",");
                    if (rVar != null) {
                        rVar.a(1021, new Object[][]{new Object[]{"duration", Long.valueOf(u7Var.e())}});
                    }
                } else if (rVar != null) {
                    rVar.a(1022, new Object[][]{new Object[]{"duration", Long.valueOf(u7Var.e())}, new Object[]{"reason", u7Var.b()}});
                }
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                r rVar2 = (r) q.this.f13797s.get(it.next());
                if (rVar2 != null) {
                    rVar2.a(1023, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}});
                }
            }
            q.this.a((Map<String, Object>) this.f13812a, (List<String>) this.f13814c, this.f13813b.toString());
        }

        @Override // com.ironsource.t7.b
        public void onFailure(String str) {
            q.this.c(IronSourceConstants.RV_COLLECT_TOKENS_FAILED, kj.a(new Object[][]{new Object[]{"reason", str}}));
            q.this.a((Map<String, Object>) this.f13812a, (List<String>) this.f13814c, this.f13813b.toString());
        }
    }

    private enum e {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    public q(List<NetworkSettings> list, pp ppVar, String str, String str2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        this.f13793o = "";
        this.f13796r = false;
        this.f13799u = 1;
        this.C = new Object();
        this.G = el.I().m();
        this.H = el.N().x();
        long time = new Date().getTime();
        c(IronSourceConstants.RV_MANAGER_INIT_STARTED, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.LWS_RV_MANAGER_NAME}}));
        a(e.RV_STATE_INITIATING);
        this.B = null;
        this.f13801w = ppVar.g();
        this.f13802x = ppVar.j();
        this.f13800v = "";
        this.f13789k = null;
        h5 h5VarK = ppVar.k();
        this.f13803y = false;
        this.f13783e = new vj(ppVar.k().f(), ppVar.k().i());
        this.f13784f = new ConcurrentHashMap<>();
        this.f13785g = new ConcurrentHashMap<>();
        this.A = new Date().getTime();
        boolean z10 = h5VarK.g() > 0;
        this.f13791m = z10;
        if (z10) {
            this.f13788j = new com.ironsource.mediationsdk.e(IronSource.AD_UNIT.REWARDED_VIDEO, h5VarK, this);
        }
        this.f13790l = new tp(h5VarK, this);
        ConcurrentHashMap<String, r> concurrentHashMap = new ConcurrentHashMap<>();
        this.f13797s = concurrentHashMap;
        a(list, ppVar, str, str2);
        this.f13787i = new h(list, h5VarK.c());
        hr hrVar = new hr();
        this.f13798t = hrVar;
        hrVar.a(new ArrayList(concurrentHashMap.values()));
        this.D = new yb(ppVar.c(), this);
        this.E = ppVar.l();
        this.F = ppVar.m();
        c(IronSourceConstants.RV_MANAGER_INIT_ENDED, kj.a(new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}}));
        a(h5VarK.k());
    }

    private List<f5> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (r rVar : this.f13797s.values()) {
            if (!rVar.p() && !this.f13798t.b(rVar) && this.f13783e.b(rVar)) {
                copyOnWriteArrayList.add(new f5(rVar.c()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void h() {
        a(e.RV_STATE_NOT_LOADED);
        if (!this.f13803y) {
            b(false);
        }
        this.f13790l.a();
    }

    private void i() {
        if (this.f13783e.c().isEmpty()) {
            d("loadSmashes -  waterfall is empty");
            a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{"reason", "waterfall is empty"}}));
            h();
            return;
        }
        a(e.RV_STATE_LOADING_SMASHES);
        int i10 = 0;
        for (int i11 = 0; i11 < this.f13783e.c().size() && i10 < this.f13801w; i11++) {
            r rVar = this.f13783e.c().get(i11);
            if (rVar.h()) {
                if (this.f13802x && rVar.p()) {
                    if (i10 != 0) {
                        String str = "Advanced Loading: Won't start loading bidder " + rVar.c() + " as a non bidder is being loaded";
                        d(str);
                        IronSourceUtils.sendAutomationLog(str);
                        return;
                    }
                    String str2 = "Advanced Loading: Starting to load bidder " + rVar.c() + ". No other instances will be loaded at the same time.";
                    d(str2);
                    IronSourceUtils.sendAutomationLog(str2);
                    g(rVar);
                    return;
                }
                g(rVar);
                i10++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this.C) {
            e eVar = this.f13804z;
            e eVar2 = e.RV_STATE_AUCTION_IN_PROGRESS;
            if (eVar != eVar2) {
                a(eVar2);
                AsyncTask.execute(new c());
            }
        }
    }

    private void k() {
        a(g(), "fallback_" + System.currentTimeMillis(), this.f13789k);
    }

    @Override // com.ironsource.o
    public void b() {
        a(e.RV_STATE_NOT_LOADED);
        a(false, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{"reason", "loaded ads are expired"}}));
        a(0L);
    }

    @Override // com.ironsource.uj
    public void d(r rVar) {
        this.f13783e.a(rVar);
        this.f13799u++;
        a(rVar, "onRewardedVideoAdOpened");
        if (this.f13791m) {
            f5 f5Var = this.f13784f.get(rVar.c());
            if (f5Var != null) {
                vj vjVar = this.f13783e;
                vjVar.a(vjVar.d(), f5Var.a(this.f13800v));
                this.f13788j.a(f5Var, rVar.g(), this.f13786h, this.f13800v);
                this.f13785g.put(rVar.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
                a(f5Var, this.f13800v);
            } else {
                String strC = rVar.c();
                c("onRewardedVideoAdOpened showing instance " + strC + " missing from waterfall");
                a(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1011}, new Object[]{"reason", "Showing missing " + this.f13804z}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}}));
            }
        }
        to.a().c(this.f13783e.a(rVar.u()));
        b(false);
        this.f13790l.c();
    }

    @Override // com.ironsource.uj
    public void e(r rVar) {
        synchronized (this.C) {
            a(rVar, "onLoadSuccess mState=" + this.f13804z);
            if (rVar.u() == this.f13783e.d() && this.f13804z != e.RV_STATE_AUCTION_IN_PROGRESS) {
                this.f13785g.put(rVar.c(), h.a.ISAuctionPerformanceLoadedSuccessfully);
                e eVar = this.f13804z;
                e eVar2 = e.RV_STATE_LOADING_SMASHES;
                if (eVar == eVar2) {
                    a(e.RV_STATE_READY_TO_SHOW);
                    a(1003, kj.a(new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - this.f13792n)}}));
                    this.D.a(0L);
                    if (this.f13791m) {
                        f5 f5Var = this.f13784f.get(rVar.c());
                        if (f5Var != null) {
                            vj vjVar = this.f13783e;
                            vjVar.a(vjVar.d(), f5Var.a(""));
                            this.f13788j.a(f5Var, rVar.g(), this.f13786h);
                            this.f13788j.a(this.f13783e.c(), this.f13784f, rVar.g(), this.f13786h, f5Var);
                        } else {
                            String strC = rVar.c();
                            c("onLoadSuccess winner instance " + strC + " missing from waterfall. auctionId: " + rVar.u() + " and the current id is " + this.f13783e.d());
                            Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, 1010};
                            StringBuilder sb = new StringBuilder();
                            sb.append("Loaded missing ");
                            sb.append(eVar2);
                            a(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, kj.a(new Object[][]{objArr, new Object[]{"reason", sb.toString()}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}}));
                        }
                    }
                    b(true);
                }
                return;
            }
            d("onLoadSuccess was invoked with auctionId: " + rVar.u() + " and the current id is " + this.f13783e.d());
            Object[] objArr2 = {IronSourceConstants.EVENTS_ERROR_CODE, 2};
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onLoadSuccess wrong auction ID ");
            sb2.append(this.f13804z);
            rVar.a(IronSourceConstants.RV_MANAGER_UNEXPECTED_STATE, new Object[][]{objArr2, new Object[]{"reason", sb2.toString()}});
        }
    }

    @Override // com.ironsource.uj
    public void f(r rVar) {
        a(rVar, "onRewardedVideoAdEnded");
        to.a().b();
    }

    private String a(f5 f5Var) {
        r rVar = this.f13797s.get(f5Var.c());
        return (rVar != null ? Integer.toString(rVar.g()) : TextUtils.isEmpty(f5Var.j()) ? "1" : "2") + f5Var.c();
    }

    private void b(int i10) {
        a(i10, (Map<String, Object>) null, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i10, Map<String, Object> map) {
        a(i10, map, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: " + str, 0);
    }

    private void g(r rVar) {
        String strJ = this.f13784f.get(rVar.c()).j();
        JSONObject jSONObjectA = this.f13784f.get(rVar.c()).a();
        rVar.c(strJ);
        rVar.a(strJ, jSONObjectA);
    }

    private void b(int i10, Map<String, Object> map) {
        a(i10, map, true, true);
    }

    @Override // com.ironsource.up
    public void a() {
        d("onLoadTriggered: RV load was triggered in " + this.f13804z + " state");
        a(0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0058 A[SYNTHETIC] */
    @Override // com.ironsource.uj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(com.ironsource.mediationsdk.r r12) {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.q.c(com.ironsource.mediationsdk.r):void");
    }

    @Override // com.ironsource.se
    public boolean d() {
        if ((!this.f13796r || IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) && this.f13804z == e.RV_STATE_READY_TO_SHOW && !this.f13803y) {
            Iterator<r> it = this.f13783e.c().iterator();
            while (it.hasNext()) {
                if (it.next().A()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(int i10) {
        a(i10, (Map<String, Object>) null, true, true);
    }

    private void c(r rVar, Placement placement) {
        d("showVideo()");
        this.f13798t.a(rVar);
        if (this.f13798t.b(rVar)) {
            rVar.B();
            IronSourceUtils.sendAutomationLog(rVar.c() + " rewarded video is now session capped");
        }
        qe.a aVar = this.G;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        String placementName = placement.getPlacementName();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        aVar.a(applicationContext, placementName, ad_unit);
        if (this.H.b(ContextProvider.getInstance().getApplicationContext(), placement, ad_unit)) {
            a(IronSourceConstants.RV_CAP_PLACEMENT);
        }
        this.D.a();
        rVar.a(placement);
    }

    private void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: " + str, 3);
    }

    @Override // com.ironsource.l4
    public void a(int i10, String str, int i11, String str2, long j10) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i10 + " - " + str + ")";
        d(str3);
        IronSourceUtils.sendAutomationLog("RV: " + str3);
        this.f13794p = i11;
        this.f13793o = str2;
        this.f13789k = null;
        k();
        a(1301, TextUtils.isEmpty(str) ? kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10)}, new Object[]{"duration", Long.valueOf(j10)}}) : kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j10)}}));
        i();
    }

    @Override // com.ironsource.uj
    public void b(r rVar) {
        a(rVar, "onRewardedVideoAdClosed, mediation state: " + this.f13804z.name());
        to.a().b(this.f13783e.a(rVar.u()));
        this.f13803y = false;
        boolean z10 = this.f13804z == e.RV_STATE_READY_TO_SHOW;
        StringBuilder sb = new StringBuilder();
        if (z10) {
            for (r rVar2 : this.f13783e.c()) {
                if (rVar2.y()) {
                    sb.append(rVar2.c() + ";");
                }
            }
        }
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = IronSourceConstants.EVENTS_EXT1;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("otherRVAvailable = ");
        sb2.append(sb.length() > 0 ? "true|" + ((Object) sb) : "false");
        objArr2[1] = sb2.toString();
        objArr[0] = objArr2;
        rVar.b(1203, objArr);
        if (rVar.equals(this.f13783e.f())) {
            this.f13783e.a((r) null);
            if (this.f13804z != e.RV_STATE_READY_TO_SHOW) {
                b(false);
            }
        }
    }

    private void a(int i10, Map<String, Object> map) {
        a(i10, map, false, true);
    }

    private boolean c(int i10) {
        return i10 == 1003 || i10 == 1302 || i10 == 1301 || i10 == 1303;
    }

    @Override // com.ironsource.uj
    public void b(r rVar, Placement placement) {
        a(rVar, "onRewardedVideoAdClicked");
        to.a().a(placement, this.f13783e.a(rVar.u()));
    }

    private void a(int i10, Map<String, Object> map, boolean z10, boolean z11) {
        HashMap map2 = new HashMap();
        map2.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        map2.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 2);
        if (z11 && !TextUtils.isEmpty(this.f13783e.d())) {
            map2.put("auctionId", this.f13783e.d());
        }
        JSONObject jSONObject = this.f13789k;
        if (jSONObject != null && jSONObject.length() > 0) {
            map2.put("genericParams", this.f13789k);
        }
        if (z10 && !TextUtils.isEmpty(this.f13800v)) {
            map2.put("placement", this.f13800v);
        }
        if (c(i10)) {
            rp.i().a(map2, this.f13794p, this.f13793o);
        }
        map2.put("sessionDepth", Integer.valueOf(this.f13799u));
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    map2.putAll(map);
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e10), 3);
            }
        }
        rp.i().a(new kb(i10, new JSONObject(map2)));
    }

    private void b(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 0);
    }

    private boolean c(boolean z10) {
        Boolean bool = this.B;
        if (bool == null) {
            return false;
        }
        return (z10 && !bool.booleanValue() && d()) || (!z10 && this.B.booleanValue());
    }

    private void a(long j10) {
        Map<String, Object> mapA;
        if (this.f13798t.a()) {
            d("all smashes are capped");
            mapA = kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED)}, new Object[]{"reason", "all smashes are capped"}});
        } else {
            a(IronSource.AD_UNIT.REWARDED_VIDEO);
            if (this.f13791m) {
                if (!this.f13785g.isEmpty()) {
                    this.f13787i.a(this.f13785g);
                    this.f13785g.clear();
                }
                new Timer().schedule(new b(), j10);
                return;
            }
            d("auction fallback flow starting");
            k();
            if (!this.f13783e.c().isEmpty()) {
                b(1000);
                i();
                return;
            } else {
                d("loadSmashes -  waterfall is empty");
                mapA = kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{"reason", "waterfall is empty"}});
            }
        }
        a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, mapA);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<q7> list2) {
        for (r rVar : this.f13797s.values()) {
            if (!this.f13798t.b(rVar) && this.f13783e.b(rVar)) {
                if (!rVar.p()) {
                    list.add(rVar.c());
                    sb.append(rVar.g() + rVar.c() + ",");
                } else if (this.E) {
                    list2.add(new q7(rVar.g(), rVar.c(), null, rVar, null, null));
                } else {
                    try {
                        Map<String, Object> mapA = rVar.a((AdData) null);
                        if (mapA != null) {
                            map.put(rVar.c(), mapA);
                            sb.append(rVar.g() + rVar.c() + ",");
                        } else {
                            rVar.a(IronSourceConstants.TROUBLESHOOTING_RV_BIDDING_DATA_MISSING, new Object[][]{new Object[]{"reason", "Missing bidding data"}});
                        }
                    } catch (Exception e10) {
                        i9.d().a(e10);
                        String str = "prepareAuctionCandidates - exception while calling smash.getBiddingData - " + e10.getMessage();
                        IronLog.INTERNAL.error(str);
                        rVar.a(IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR, new Object[][]{new Object[]{"reason", str}});
                    } catch (NoClassDefFoundError e11) {
                        i9.d().a(e11);
                        String str2 = "prepareAuctionCandidates - error while calling smash.getBiddingData - " + e11.getMessage();
                        IronLog.INTERNAL.error(str2);
                        rVar.a(IronSourceConstants.TROUBLESHOOTING_RV_INTERNAL_ERROR, new Object[][]{new Object[]{"reason", str2}});
                    }
                }
            }
        }
    }

    private void b(boolean z10) {
        a(z10, (Map<String, Object>) null);
    }

    @Override // com.ironsource.se
    public void a(Activity activity, Placement placement) {
        synchronized (this.C) {
            if (placement == null) {
                a("showRewardedVideo error: empty default placement");
                IronSourceError ironSourceError = new IronSourceError(1021, "showRewardedVideo error: empty default placement");
                to toVarA = to.a();
                vj vjVar = this.f13783e;
                toVarA.a(ironSourceError, vjVar.a(vjVar.d()));
                a(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1021}, new Object[]{"reason", "showRewardedVideo error: empty default placement"}}), false, true);
                return;
            }
            this.f13800v = placement.getPlacementName();
            b("showRewardedVideo(" + placement + ")");
            r rVar = null;
            b(IronSourceConstants.RV_API_SHOW_CALLED, activity != null ? kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.EVENTS_INIT_CONTEXT_FLOW}}) : null);
            if (this.f13803y) {
                a("showRewardedVideo error: can't show ad while an ad is already showing");
                IronSourceError ironSourceError2 = new IronSourceError(1022, "showRewardedVideo error: can't show ad while an ad is already showing");
                to toVarA2 = to.a();
                vj vjVar2 = this.f13783e;
                toVarA2.a(ironSourceError2, vjVar2.a(vjVar2.d()));
                b(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1022}, new Object[]{"reason", "showRewardedVideo error: can't show ad while an ad is already showing"}}));
                return;
            }
            if (this.f13804z != e.RV_STATE_READY_TO_SHOW) {
                a("showRewardedVideo error: show called while no ads are available");
                IronSourceError ironSourceError3 = new IronSourceError(1023, "showRewardedVideo error: show called while no ads are available");
                to toVarA3 = to.a();
                vj vjVar3 = this.f13783e;
                toVarA3.a(ironSourceError3, vjVar3.a(vjVar3.d()));
                b(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1023}, new Object[]{"reason", "showRewardedVideo error: show called while no ads are available"}}));
                return;
            }
            if (this.H.b(ContextProvider.getInstance().getApplicationContext(), placement, IronSource.AD_UNIT.REWARDED_VIDEO)) {
                String str = "showRewardedVideo error: placement " + this.f13800v + " is capped";
                a(str);
                IronSourceError ironSourceError4 = new IronSourceError(IronSourceError.ERROR_PLACEMENT_CAPPED, str);
                to toVarA4 = to.a();
                vj vjVar4 = this.f13783e;
                toVarA4.a(ironSourceError4, vjVar4.a(vjVar4.d()));
                b(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_PLACEMENT_CAPPED)}, new Object[]{"reason", str}}));
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<r> it = this.f13783e.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                r next = it.next();
                if (next.A()) {
                    this.f13803y = true;
                    next.b(true);
                    a(e.RV_STATE_NOT_LOADED);
                    rVar = next;
                    break;
                }
                if (next.e() != null) {
                    stringBuffer.append(next.c() + ":" + next.e() + ",");
                }
                next.b(false);
            }
            if (rVar != null) {
                c(rVar, placement);
                return;
            }
            d("showRewardedVideo(): No ads to show");
            to toVarA5 = to.a();
            IronSourceError ironSourceErrorBuildNoAdsToShowError = ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
            vj vjVar5 = this.f13783e;
            toVarA5.a(ironSourceErrorBuildNoAdsToShowError, vjVar5.a(vjVar5.d()));
            HashMap map = new HashMap();
            map.put(IronSourceConstants.EVENTS_ERROR_CODE, 509);
            map.put("reason", "showRewardedVideo(): No ads to show");
            if (stringBuffer.length() != 0) {
                map.put(IronSourceConstants.EVENTS_EXT1, stringBuffer.toString());
            }
            b(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, map);
            this.f13790l.b();
        }
    }

    @Override // com.ironsource.se
    public void a(Context context, boolean z10) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager Should Track Network State: " + z10, 0);
        try {
            this.f13796r = z10;
            if (z10) {
                if (this.f13795q == null) {
                    this.f13795q = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.f13795q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.f13795q != null) {
                context.getApplicationContext().unregisterReceiver(this.f13795q);
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("Got an error from receiver with message: " + e10.getMessage());
        }
    }

    @Override // com.ironsource.uj
    public void a(IronSourceError ironSourceError, r rVar) {
        f5 f5Var;
        if (this.f13791m && (f5Var = this.f13784f.get(rVar.c())) != null) {
            vj vjVar = this.f13783e;
            vjVar.a(vjVar.d(), f5Var.a(this.f13800v));
        }
        a(rVar, "onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.f13803y = false;
        b(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}}));
        to.a().a(ironSourceError, this.f13783e.a(rVar.u()));
        this.f13785g.put(rVar.c(), h.a.ISAuctionPerformanceFailedToShow);
        if (this.f13804z != e.RV_STATE_READY_TO_SHOW) {
            b(false);
        }
        this.f13790l.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkSettings networkSettings, pp ppVar, String str, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(String.format("Start initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName()));
        AbstractAdapter abstractAdapterA = com.ironsource.mediationsdk.c.b().a(networkSettings, networkSettings.getRewardedVideoSettings(), false);
        if (abstractAdapterA != null) {
            r rVar = new r(str, str2, networkSettings, this, ppVar.h(), abstractAdapterA, this.f13799u);
            this.f13797s.put(rVar.c(), rVar);
        }
        ironLog.verbose(String.format("Done initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName()));
    }

    private void a(e eVar) {
        d("current state=" + this.f13804z + ", new state=" + eVar);
        this.f13804z = eVar;
    }

    @Override // com.ironsource.uj
    public void a(r rVar) {
        a(rVar, "onRewardedVideoAdStarted");
        to.a().c();
    }

    @Override // com.ironsource.uj
    public void a(r rVar, Placement placement) {
        a(rVar, "onRewardedVideoAdRewarded");
        to.a().b(placement, this.f13783e.a(rVar.u()));
    }

    private void a(r rVar, String str) {
        String str2 = rVar.c() + " : " + str;
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "LWSProgRvManager: " + str2, 0);
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private void a(List<NetworkSettings> list, pp ppVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<NetworkSettings> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new a(it.next(), ppVar, str, str2));
        }
        IronSourceThreadManager.INSTANCE.executeTasks(ppVar.f(), ppVar.p(), arrayList);
    }

    @Override // com.ironsource.l4
    public void a(List<f5> list, String str, f5 f5Var, JSONObject jSONObject, JSONObject jSONObject2, int i10, long j10, int i11, String str2) {
        d("makeAuction(): success");
        this.f13786h = f5Var;
        this.f13794p = i10;
        this.f13789k = jSONObject;
        this.f13793o = "";
        if (!TextUtils.isEmpty(str2)) {
            a(88002, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i11)}, new Object[]{"reason", str2}}));
        }
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        a(jSONObject2, ad_unit);
        if (this.f13675b.a(ad_unit)) {
            a(IronSourceConstants.RV_AD_UNIT_CAPPED, kj.a(new Object[][]{new Object[]{"auctionId", str}}));
            h();
        } else {
            a(list, str, this.f13789k);
            a(IronSourceConstants.RV_AUCTION_SUCCESS, kj.a(new Object[][]{new Object[]{"duration", Long.valueOf(j10)}}));
            i();
        }
    }

    private void a(List<f5> list, String str, JSONObject jSONObject) {
        this.f13784f.clear();
        this.f13785g.clear();
        CopyOnWriteArrayList<r> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (f5 f5Var : list) {
            sb.append(a(f5Var) + ",");
            r rVar = this.f13797s.get(f5Var.c());
            if (rVar != null) {
                AbstractAdapter abstractAdapterA = com.ironsource.mediationsdk.c.b().a(rVar.f13986b.h());
                if (abstractAdapterA != null) {
                    r rVar2 = new r(rVar, this, abstractAdapterA, this.f13799u, str, jSONObject, this.f13794p, this.f13793o);
                    rVar2.a(true);
                    copyOnWriteArrayList.add(rVar2);
                    this.f13784f.put(rVar2.c(), f5Var);
                    this.f13785g.put(f5Var.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                }
            } else {
                d("updateWaterfall() - could not find matching smash for auction response item " + f5Var.c());
            }
        }
        this.f13783e.a(copyOnWriteArrayList, str);
        if (this.f13783e.a()) {
            a(IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, kj.a(new Object[][]{new Object[]{"reason", "waterfalls hold too many with size=" + this.f13783e.e()}}));
        }
        d("updateWaterfall() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            d("Updated waterfall is empty");
        }
        a(IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        if (map.keySet().size() == 0 && list.size() == 0) {
            c(1301, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{"duration", 0}}));
            d("makeAuction() failed - No candidates available for auctioning");
            h();
            return;
        }
        d("makeAuction() - request waterfall is: " + str);
        b(1000);
        b(IronSourceConstants.RV_AUCTION_REQUEST);
        c(IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, kj.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, str.toString()}}));
        this.f13788j.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.f13787i, this.f13799u, this.f13676c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<q7> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb.toString());
            return;
        }
        t7 t7Var = new t7();
        d dVar = new d(map, sb, list);
        b(IronSourceConstants.RV_COLLECT_TOKENS);
        t7Var.a(list2, dVar, this.F, TimeUnit.MILLISECONDS);
    }

    @Override // com.ironsource.vm
    public void a(boolean z10) {
        if (this.f13796r) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "Network Availability Changed To: " + z10, 0);
            if (c(z10)) {
                b(z10);
            }
        }
    }

    private void a(boolean z10, Map<String, Object> map) {
        synchronized (this.C) {
            Boolean bool = this.B;
            if (bool == null || bool.booleanValue() != z10) {
                this.B = Boolean.valueOf(z10);
                long time = new Date().getTime() - this.A;
                this.A = new Date().getTime();
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("duration", Long.valueOf(time));
                a(z10 ? IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE : IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, map);
                to toVarA = to.a();
                vj vjVar = this.f13783e;
                toVarA.a(z10, vjVar.a(vjVar.d()));
            }
        }
    }
}
