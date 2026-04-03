package com.ironsource.mediationsdk;

import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.b7;
import com.ironsource.el;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.f5;
import com.ironsource.i9;
import com.ironsource.ji;
import com.ironsource.kb;
import com.ironsource.l4;
import com.ironsource.le;
import com.ironsource.m5;
import com.ironsource.me;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mg;
import com.ironsource.mo;
import com.ironsource.nt;
import com.ironsource.pk;
import com.ironsource.q7;
import com.ironsource.qe;
import com.ironsource.t7;
import com.ironsource.ta;
import com.ironsource.u7;
import com.ironsource.v7;
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
public class w extends m implements mo, l4 {
    private ConcurrentHashMap<String, h.a> A;
    private long B;
    private final Object C;
    private ta D;
    private boolean E;
    private final boolean F;
    private final long G;
    private final Runnable H;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final mg f13915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final mg.a f13916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final qe f13917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final qe.a f13918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private k f13919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private i f13920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private pk f13921k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private IronSourceBannerLayout f13922l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b7 f13923m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f13924n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private x f13925o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f13926p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ConcurrentHashMap<String, x> f13927q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CopyOnWriteArrayList<x> f13928r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f13929s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private JSONObject f13930t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f13931u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13932v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.ironsource.mediationsdk.e f13933w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private f5 f13934x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private com.ironsource.mediationsdk.h f13935y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ConcurrentHashMap<String, f5> f13936z;

    class a implements l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b7 f13937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IronSourceBannerLayout f13938b;

        a(b7 b7Var, IronSourceBannerLayout ironSourceBannerLayout) {
            this.f13937a = b7Var;
            this.f13938b = ironSourceBannerLayout;
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a() {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("placement = " + this.f13937a.getPlacementName());
            l.b(this.f13938b);
            w.this.f13922l = this.f13938b;
            w.this.f13923m = this.f13937a;
            qe qeVar = w.this.f13917g;
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            b7 b7Var = this.f13937a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            if (!qeVar.b(applicationContext, b7Var, ad_unit)) {
                w.this.b(false);
                return;
            }
            ironLog.verbose("placement is capped");
            n.a().b(ad_unit, new IronSourceError(604, "placement " + this.f13937a.getPlacementName() + " is capped"));
            w.this.a(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 604}});
            w.this.a(i.READY_TO_LOAD);
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a(String str) {
            IronLog.API.error("can't load banner - errorMessage = " + str);
        }
    }

    class b implements l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceBannerLayout f13940a;

        b(IronSourceBannerLayout ironSourceBannerLayout) {
            this.f13940a = ironSourceBannerLayout;
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a() {
            IronLog.INTERNAL.verbose("destroying banner");
            w.this.f13921k.b();
            w.this.a(IronSourceConstants.BN_DESTROY, (Object[][]) null, w.this.f13925o != null ? w.this.f13925o.n() : w.this.f13926p);
            w.this.h();
            this.f13940a.a();
            w.this.f13922l = null;
            w.this.f13923m = null;
            w.this.a(i.READY_TO_LOAD);
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a(String str) {
            IronLog.API.error("destroy banner failed - errorMessage = " + str);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (w.this.f13922l == null) {
                    IronLog.INTERNAL.verbose("mIronSourceBanner is null");
                    w.this.a(IronSourceConstants.BN_SKIP_RELOAD, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_BN_RELOAD_SKIP_BANNER_LAYOUT_IS_NULL)}});
                } else {
                    if (w.this.o()) {
                        w.this.v();
                        return;
                    }
                    IronLog.INTERNAL.verbose("banner is not visible, reload skipped");
                    w.this.a(IronSourceConstants.BN_SKIP_RELOAD, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_BN_RELOAD_SKIP_INVISIBLE)}});
                    w.this.f13921k.a(TimeUnit.SECONDS.toMillis(w.this.f13919i.f()));
                }
            } catch (Throwable th) {
                i9.d().a(th);
                w.this.a(IronSourceConstants.TROUBLESHOOTING_BN_RELOAD_EXCEPTION, new Object[][]{new Object[]{"reason", th.getMessage()}});
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.w();
            if (w.this.y()) {
                return;
            }
            w.this.a(IronSourceConstants.BN_AUCTION_REQUEST);
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            w.this.b(map, arrayList, sb, arrayList2);
            if (w.this.F) {
                w.this.a(map, arrayList, sb, arrayList2);
            } else {
                w.this.a(map, arrayList, sb);
            }
        }
    }

    class e implements t7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f13944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f13945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f13946c;

        e(Map map, StringBuilder sb, List list) {
            this.f13944a = map;
            this.f13945b = sb;
            this.f13946c = list;
        }

        @Override // com.ironsource.t7.b
        public void a(@NotNull List<u7> list, long j10, @NotNull List<String> list2) {
            w.this.a(IronSourceConstants.BN_COLLECT_TOKENS_COMPLETED, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}});
            for (u7 u7Var : list) {
                if (u7Var.a() != null) {
                    this.f13944a.put(u7Var.c(), u7Var.a());
                    StringBuilder sb = this.f13945b;
                    sb.append(u7Var.d());
                    sb.append(u7Var.c());
                    sb.append(",");
                    ((x) w.this.f13927q.get(u7Var.c())).a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(u7Var.e())}});
                } else {
                    ((x) w.this.f13927q.get(u7Var.c())).a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(u7Var.e())}, new Object[]{"reason", u7Var.b()}});
                }
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                ((x) w.this.f13927q.get(it.next())).a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}});
            }
            w.this.a((Map<String, Object>) this.f13944a, (List<String>) this.f13946c, this.f13945b);
        }

        @Override // com.ironsource.t7.b
        public void onFailure(String str) {
            w.this.a(IronSourceConstants.BN_COLLECT_TOKENS_FAILED, new Object[][]{new Object[]{"duration", str}});
            w.this.a((Map<String, Object>) this.f13944a, (List<String>) this.f13946c, this.f13945b);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f13948a;

        f(NetworkSettings networkSettings) {
            this.f13948a = networkSettings;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.a(this.f13948a);
        }
    }

    class g implements v7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f13950a;

        g(x xVar) {
            this.f13950a = xVar;
        }

        @Override // com.ironsource.v7
        public void a() {
            this.f13950a.D();
        }
    }

    class h extends TimerTask {
        h() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            w.this.u();
        }
    }

    enum i {
        NONE,
        READY_TO_LOAD,
        STARTED_LOADING,
        FIRST_AUCTION,
        AUCTION,
        LOADING,
        RELOADING,
        LOADED
    }

    w(me meVar, le leVar, List<NetworkSettings> list, k kVar, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        this.f13920j = i.NONE;
        this.f13931u = "";
        this.C = new Object();
        this.E = false;
        c cVar = new c();
        this.H = cVar;
        mg mgVarK = meVar.k();
        this.f13915e = mgVarK;
        this.f13916f = leVar.e();
        this.f13917g = meVar.x();
        this.f13918h = leVar.m();
        long time = new Date().getTime();
        a(IronSourceConstants.BN_MANAGER_INIT_STARTED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.PROG_BN_MANAGER_NAME}});
        IronLog.INTERNAL.verbose("isAuctionEnabled = " + kVar.k());
        this.f13919i = kVar;
        this.f13927q = new ConcurrentHashMap<>();
        this.f13928r = new CopyOnWriteArrayList<>();
        this.f13936z = new ConcurrentHashMap<>();
        this.A = new ConcurrentHashMap<>();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        this.f13926p = mgVarK.a(ad_unit);
        n.a().a(ad_unit, this.f13919i.d());
        if (this.f13919i.k()) {
            this.f13933w = new com.ironsource.mediationsdk.e(ad_unit, this.f13919i.b(), this);
        }
        this.f13935y = new com.ironsource.mediationsdk.h(list, this.f13919i.b().c());
        a(list, kVar);
        this.B = new Date().getTime();
        a(i.READY_TO_LOAD);
        this.F = kVar.g();
        this.G = kVar.h();
        this.f13921k = new pk(cVar, com.ironsource.lifecycle.b.d(), new nt());
        a(IronSourceConstants.BN_MANAGER_INIT_ENDED, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}});
    }

    private String b(f5 f5Var) {
        x xVar = this.f13927q.get(f5Var.c());
        return ((xVar == null ? !TextUtils.isEmpty(f5Var.j()) : xVar.p()) ? "2" : "1") + f5Var.c();
    }

    private void f(x xVar) {
        String strJ;
        IronSourceBannerLayout ironSourceBannerLayout = this.f13922l;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            return;
        }
        IronSourceBannerLayout ironSourceBannerLayoutB = null;
        if (xVar.p()) {
            strJ = this.f13936z.get(xVar.c()).j();
            xVar.c(strJ);
        } else {
            strJ = null;
        }
        JSONObject jSONObjectA = this.f13936z.get(xVar.c()).a();
        try {
            ironSourceBannerLayoutB = this.f13922l.b();
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.verbose("Failed to make copy of banner layout: " + e10.getMessage());
        }
        xVar.a(ironSourceBannerLayoutB, this.f13923m, strJ, jSONObjectA);
    }

    private List<f5> i() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (x xVar : this.f13927q.values()) {
            if (!xVar.p() && !this.f13917g.b(ContextProvider.getInstance().getApplicationContext(), this.f13923m, IronSource.AD_UNIT.BANNER)) {
                copyOnWriteArrayList.add(new f5(xVar.c()));
            }
        }
        return copyOnWriteArrayList;
    }

    private ISBannerSize j() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f13922l;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        return this.f13922l.getSize().isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? ISBannerSize.f13242e : ISBannerSize.BANNER : this.f13922l.getSize();
    }

    private ISBannerSize k() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f13922l;
        if (ironSourceBannerLayout != null) {
            return ironSourceBannerLayout.getSize();
        }
        return null;
    }

    private void n() {
        String strL = l();
        qe.a aVar = this.f13918h;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        aVar.a(applicationContext, strL, ad_unit);
        if (this.f13917g.b(ContextProvider.getInstance().getApplicationContext(), this.f13923m, ad_unit)) {
            a(IronSourceConstants.BN_PLACEMENT_CAPPED);
        }
    }

    private boolean p() {
        i iVar = this.f13920j;
        return iVar == i.RELOADING || iVar == i.AUCTION;
    }

    private boolean q() {
        boolean z10;
        synchronized (this.C) {
            z10 = this.f13920j == i.LOADED;
        }
        return z10;
    }

    private boolean r() {
        boolean z10;
        synchronized (this.C) {
            i iVar = this.f13920j;
            z10 = iVar == i.FIRST_AUCTION || iVar == i.AUCTION;
        }
        return z10;
    }

    private boolean s() {
        boolean z10;
        synchronized (this.C) {
            i iVar = this.f13920j;
            z10 = iVar == i.LOADING || iVar == i.RELOADING;
        }
        return z10;
    }

    private void t() {
        try {
            for (int i10 = this.f13924n; i10 < this.f13928r.size(); i10++) {
                x xVar = this.f13928r.get(i10);
                if (xVar.h()) {
                    IronLog.INTERNAL.verbose("loading smash - " + xVar.f());
                    this.f13924n = i10 + 1;
                    f(xVar);
                    return;
                }
            }
            m();
        } catch (Exception e10) {
            i9.d().a(e10);
            a(IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, "loadNextSmash"}, new Object[]{"reason", Log.getStackTraceString(e10)}});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        IronLog.INTERNAL.verbose();
        AsyncTask.execute(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("");
        if (a(i.LOADED, i.STARTED_LOADING)) {
            b(true);
            return;
        }
        ironLog.error("wrong state = " + this.f13920j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.A.isEmpty()) {
            return;
        }
        this.f13935y.a(this.A);
        this.A.clear();
    }

    private void x() {
        List<f5> listI = i();
        this.f13929s = e();
        a(listI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        long jA = l.a(this.B, this.f13919i.i());
        if (jA <= 0) {
            return false;
        }
        IronLog.INTERNAL.verbose("waiting before auction - timeToWaitBeforeAuction = " + jA);
        new Timer().schedule(new h(), jA);
        return true;
    }

    public void g(x xVar) {
        for (x xVar2 : this.f13928r) {
            if (!xVar2.equals(xVar)) {
                xVar2.q();
            }
        }
    }

    public boolean o() {
        IronLog ironLog;
        String str;
        if (!this.f13922l.isShown()) {
            ironLog = IronLog.INTERNAL;
            str = "banner or one of its parents are INVISIBLE or GONE";
        } else {
            if (this.f13922l.hasWindowFocus()) {
                boolean globalVisibleRect = this.f13922l.getGlobalVisibleRect(new Rect());
                IronLog.INTERNAL.verbose("visible = " + globalVisibleRect);
                return globalVisibleRect;
            }
            ironLog = IronLog.INTERNAL;
            str = "banner has no window focus";
        }
        ironLog.verbose(str);
        return false;
    }

    public w(List<NetworkSettings> list, k kVar, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        this(el.N(), el.I(), list, kVar, hashSet, ironSourceSegment);
    }

    private boolean g() {
        IronSourceBannerLayout ironSourceBannerLayout = this.f13922l;
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f13925o != null) {
            IronLog.INTERNAL.verbose("mActiveSmash = " + this.f13925o.f());
            this.f13925o.t();
            this.f13925o = null;
        }
    }

    private String l() {
        b7 b7Var = this.f13923m;
        return b7Var != null ? b7Var.getPlacementName() : "";
    }

    private void m() {
        String str = this.f13928r.isEmpty() ? "Empty waterfall" : "Mediation No fill";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("errorReason = " + str);
        g((x) null);
        i iVar = i.LOADING;
        i iVar2 = i.READY_TO_LOAD;
        if (a(iVar, iVar2)) {
            a(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 606}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(ta.a(this.D))}});
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(606, str));
        } else if (a(i.RELOADING, i.LOADED)) {
            a(IronSourceConstants.BN_CALLBACK_RELOAD_ERROR, new Object[][]{new Object[]{"duration", Long.valueOf(ta.a(this.D))}});
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(606, str));
            this.f13921k.a(TimeUnit.SECONDS.toMillis(this.f13919i.f()));
        } else {
            a(iVar2);
            ironLog.error("wrong state = " + this.f13920j);
        }
    }

    @Override // com.ironsource.mo
    public void c(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            m5.a().c(this.f13677d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(IronSourceConstants.BN_CALLBACK_LEAVE_APP, objArr, xVar.n());
    }

    @Override // com.ironsource.mo
    public void d(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            m5.a().f(this.f13677d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, objArr, xVar.n());
    }

    @Override // com.ironsource.mo
    public void e(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            m5.a().e(this.f13677d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, objArr, xVar.n());
    }

    private String a(List<f5> list) {
        IronLog.INTERNAL.verbose("waterfall.size() = " + list.size());
        this.f13928r.clear();
        this.f13936z.clear();
        this.A.clear();
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < list.size(); i10++) {
            f5 f5Var = list.get(i10);
            a(f5Var);
            sb.append(b(f5Var));
            if (i10 != list.size() - 1) {
                sb.append(",");
            }
        }
        IronLog.INTERNAL.verbose("updateWaterfall() - next waterfall is " + sb.toString());
        return sb.toString();
    }

    @Override // com.ironsource.mo
    public void b(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            m5.a().b(this.f13677d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(IronSourceConstants.BN_CALLBACK_CLICK, objArr, xVar.n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        a(i10, (Object[][]) null);
    }

    private void b(x xVar, View view, FrameLayout.LayoutParams layoutParams) {
        if (this.f13922l != null) {
            xVar.E();
            l.a(this.f13922l, view, layoutParams, new g(xVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<q7> list2) {
        if (this.f13917g.b(ContextProvider.getInstance().getApplicationContext(), this.f13923m, IronSource.AD_UNIT.BANNER)) {
            return;
        }
        for (x xVar : this.f13927q.values()) {
            AdData adDataCreateAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(xVar.f13988d, IronSource.AD_UNIT.BANNER, null, this.f13922l);
            if (xVar.p()) {
                if (this.F) {
                    list2.add(new q7(xVar.g(), xVar.c(), adDataCreateAdDataForNetworkAdapter, xVar, null, null));
                } else {
                    try {
                        Map<String, Object> mapA = xVar.a(adDataCreateAdDataForNetworkAdapter);
                        if (mapA != null) {
                            map.put(xVar.c(), mapA);
                            sb.append(xVar.g() + xVar.c() + ",");
                        } else {
                            xVar.a(IronSourceConstants.TROUBLESHOOTING_BN_BIDDING_DATA_MISSING, new Object[][]{new Object[]{"reason", "Missing bidding data"}});
                        }
                    } catch (Exception e10) {
                        i9.d().a(e10);
                        String str = "prepareAuctionCandidates - exception while calling smash.getBiddingData - " + e10.getMessage();
                        IronLog.INTERNAL.error(str);
                        xVar.a(IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, new Object[][]{new Object[]{"reason", str}});
                    } catch (NoClassDefFoundError e11) {
                        i9.d().a(e11);
                        String str2 = "prepareAuctionCandidates - error while calling smash.getBiddingData - " + e11.getMessage();
                        IronLog.INTERNAL.error(str2);
                        xVar.a(IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, new Object[][]{new Object[]{"reason", str2}});
                    }
                }
            } else if (!xVar.p()) {
                list.add(xVar.c());
                sb.append(xVar.g() + xVar.c() + ",");
            }
        }
    }

    @Override // com.ironsource.l4
    public void a(int i10, String str, int i11, String str2, long j10) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i10 + " - " + str + ")";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(str3);
        IronSourceUtils.sendAutomationLog("BN: " + str3);
        if (!r()) {
            ironLog.warning("wrong state - mCurrentState = " + this.f13920j);
            return;
        }
        this.f13931u = str2;
        this.f13932v = i11;
        this.f13930t = null;
        x();
        a(IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10)}, new Object[]{"reason", str}});
        a(this.f13920j == i.FIRST_AUCTION ? i.LOADING : i.RELOADING);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, Object[][] objArr) {
        a(i10, objArr, this.f13926p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z10) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("current state = " + this.f13920j);
        if (!a(i.STARTED_LOADING, this.f13919i.k() ? z10 ? i.AUCTION : i.FIRST_AUCTION : z10 ? i.RELOADING : i.LOADING)) {
            ironLog.error("wrong state - " + this.f13920j);
            return;
        }
        this.D = new ta();
        this.f13929s = "";
        this.f13930t = null;
        this.f13924n = 0;
        this.f13926p = this.f13915e.a(IronSource.AD_UNIT.BANNER);
        a(z10 ? IronSourceConstants.BN_RELOAD : 3001);
        if (this.f13919i.k()) {
            u();
        } else {
            x();
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, Object[][] objArr, int i11) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        try {
            ISBannerSize iSBannerSizeK = k();
            if (iSBannerSizeK != null) {
                a(mediationAdditionalData, iSBannerSizeK);
            }
            if (this.f13923m != null) {
                mediationAdditionalData.put("placement", l());
            }
            mediationAdditionalData.put("sessionDepth", i11);
            if (!TextUtils.isEmpty(this.f13929s)) {
                mediationAdditionalData.put("auctionId", this.f13929s);
            }
            JSONObject jSONObject = this.f13930t;
            if (jSONObject != null && jSONObject.length() > 0) {
                mediationAdditionalData.put("genericParams", this.f13930t);
            }
            if (b(i10)) {
                mediationAdditionalData.put(IronSourceConstants.AUCTION_TRIALS, this.f13932v);
                if (!TextUtils.isEmpty(this.f13931u)) {
                    mediationAdditionalData.put(IronSourceConstants.AUCTION_FALLBACK, this.f13931u);
                }
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(Log.getStackTraceString(e10));
        }
        ji.i().a(new kb(i10, mediationAdditionalData));
    }

    private boolean b(int i10) {
        return i10 == 3201 || i10 == 3110 || i10 == 3111 || i10 == 3116 || i10 == 3119 || i10 == 3112 || i10 == 3115 || i10 == 3501 || i10 == 3502 || i10 == 3506;
    }

    private void a(f5 f5Var) {
        x xVar = this.f13927q.get(f5Var.c());
        if (xVar == null) {
            IronLog.INTERNAL.error("could not find matching smash for auction response item - item = " + f5Var.c());
            return;
        }
        AbstractAdapter abstractAdapterA = com.ironsource.mediationsdk.c.b().a(xVar.f13986b.h());
        if (abstractAdapterA != null) {
            x xVar2 = new x(this.f13919i, this, xVar.f13986b.h(), abstractAdapterA, this.f13926p, this.f13929s, this.f13930t, this.f13932v, this.f13931u, p());
            xVar2.a(true);
            this.f13928r.add(xVar2);
            this.f13936z.put(xVar2.c(), f5Var);
            this.A.put(f5Var.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
        }
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        IronLog.INTERNAL.verbose();
        l.a(ironSourceBannerLayout, new b(ironSourceBannerLayout));
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, b7 b7Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        a(ad_unit);
        f();
        if (!a(i.READY_TO_LOAD, i.STARTED_LOADING)) {
            IronLog.API.error("can't load banner - loadBanner already called and still in progress");
        } else if (n.a().b(ad_unit)) {
            ironLog.verbose("can't load banner - already has pending invocation");
        } else {
            l.a(ironSourceBannerLayout, b7Var, new a(b7Var, ironSourceBannerLayout));
        }
    }

    @Override // com.ironsource.mo
    public void a(IronSourceError ironSourceError, x xVar, boolean z10) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + ironSourceError);
        if (xVar.x() == this.f13929s) {
            if (s()) {
                this.A.put(xVar.c(), h.a.ISAuctionPerformanceFailedToLoad);
                t();
                return;
            } else {
                ironLog.warning("wrong state - mCurrentState = " + this.f13920j);
                return;
            }
        }
        ironLog.error("invoked with auctionId: " + xVar.x() + " and the current id is " + this.f13929s);
        xVar.a(IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 3}, new Object[]{"reason", "Wrong auction " + xVar.x() + " State - " + this.f13920j}, new Object[]{IronSourceConstants.EVENTS_EXT1, xVar.c()}});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkSettings networkSettings) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(String.format("Start initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName()));
        AbstractAdapter abstractAdapterA = com.ironsource.mediationsdk.c.b().a(networkSettings, networkSettings.getBannerSettings(), false);
        if (abstractAdapterA != null) {
            x xVar = new x(this.f13919i, this, networkSettings, abstractAdapterA, this.f13926p, p());
            this.f13927q.put(xVar.c(), xVar);
        } else {
            ironLog.verbose(networkSettings.getProviderInstanceName() + " can't load adapter");
        }
        ironLog.verbose(String.format("Done initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        IronLog.INTERNAL.verbose("from '" + this.f13920j + "' to '" + iVar + "'");
        synchronized (this.C) {
            this.f13920j = iVar;
        }
    }

    @Override // com.ironsource.mo
    public void a(x xVar) {
        f5 f5Var;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(xVar.f());
        if (q()) {
            if (this.f13919i.k() && this.f13919i.b().p() && (f5Var = this.f13936z.get(xVar.c())) != null) {
                a(xVar, f5Var);
            }
            a(IronSourceConstants.BN_CALLBACK_SHOW);
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.f13920j);
        String strC = xVar.c();
        a(IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1}, new Object[]{"reason", "Wrong State - " + this.f13920j}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}});
    }

    @Override // com.ironsource.mo
    public void a(x xVar, View view, FrameLayout.LayoutParams layoutParams) {
        Object[][] objArr;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + xVar.f());
        if (xVar.x() != this.f13929s) {
            ironLog.error("invoked with auctionId: " + xVar.x() + " and the current id is " + this.f13929s);
            xVar.a(IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 2}, new Object[]{"reason", "Wrong auction id " + xVar.x() + " State - " + this.f13920j}, new Object[]{IronSourceConstants.EVENTS_EXT1, xVar.c()}});
            return;
        }
        if (s()) {
            x xVar2 = this.f13925o;
            if (xVar2 != null) {
                xVar2.q();
            }
            g(xVar);
            this.f13925o = xVar;
            b(xVar, view, layoutParams);
            this.A.put(xVar.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
            if (this.f13919i.k()) {
                f5 f5Var = this.f13936z.get(xVar.c());
                if (f5Var != null) {
                    a(f5Var.a(l()));
                    this.f13933w.a(f5Var, xVar.g(), this.f13934x);
                    this.f13933w.a(this.f13928r, this.f13936z, xVar.g(), this.f13934x, f5Var);
                    if (!this.f13919i.b().p()) {
                        a(xVar, f5Var);
                    }
                } else {
                    String strC = xVar.c();
                    ironLog.error("onLoadSuccess winner instance " + strC + " missing from waterfall. auctionId = " + this.f13929s);
                    a(IronSourceConstants.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}, new Object[]{"reason", "Loaded missing"}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}});
                }
            }
            if (this.f13920j == i.LOADING) {
                if (g()) {
                    m5.a().d(this.f13677d);
                    objArr = new Object[][]{new Object[]{"duration", Long.valueOf(ta.a(this.D))}};
                } else {
                    objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}, new Object[]{"duration", Long.valueOf(ta.a(this.D))}};
                }
                a(IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, objArr);
            } else {
                if (g()) {
                    m5.a().d(this.f13677d);
                }
                IronSourceUtils.sendAutomationLog("bannerReloadSucceeded");
                a(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(ta.a(this.D))}});
            }
            n();
            this.f13916f.b(IronSource.AD_UNIT.BANNER);
            a(i.LOADED);
            this.f13921k.a(TimeUnit.SECONDS.toMillis(this.f13919i.f()));
            return;
        }
        ironLog.warning("wrong state - mCurrentState = " + this.f13920j);
    }

    private void a(x xVar, f5 f5Var) {
        this.f13933w.a(f5Var, xVar.g(), this.f13934x, l());
        a(this.f13936z.get(xVar.c()), l());
    }

    private void a(List<NetworkSettings> list, k kVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<NetworkSettings> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new f(it.next()));
        }
        IronSourceThreadManager.INSTANCE.executeTasks(kVar.c().m(), kVar.c().o(), arrayList);
    }

    @Override // com.ironsource.l4
    public void a(List<f5> list, String str, f5 f5Var, JSONObject jSONObject, JSONObject jSONObject2, int i10, long j10, int i11, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auctionId = " + str);
        if (!r()) {
            ironLog.warning("wrong state - mCurrentState = " + this.f13920j);
            return;
        }
        this.f13931u = "";
        this.f13929s = str;
        this.f13932v = i10;
        this.f13934x = f5Var;
        this.f13930t = jSONObject;
        if (!TextUtils.isEmpty(str2)) {
            a(88002, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i11)}, new Object[]{"reason", str2}});
        }
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        a(jSONObject2, ad_unit);
        if (!this.f13675b.a(ad_unit)) {
            a(IronSourceConstants.BN_AUCTION_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(j10)}});
            a(this.f13920j == i.FIRST_AUCTION ? i.LOADING : i.RELOADING);
            a(IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, a(list)}});
            t();
            return;
        }
        a(IronSourceConstants.BN_AD_UNIT_CAPPED, new Object[][]{new Object[]{"auctionId", str}});
        i iVar = this.f13920j;
        a(i.READY_TO_LOAD);
        if (iVar == i.FIRST_AUCTION) {
            n.a().b(ad_unit, new IronSourceError(IronSourceError.ERROR_AD_FORMAT_CAPPED, "Ad unit is capped"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auction waterfallString = " + ((Object) sb));
        if (map.size() != 0 || list.size() != 0) {
            a(IronSourceConstants.BN_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}});
            com.ironsource.mediationsdk.e eVar = this.f13933w;
            if (eVar != null) {
                eVar.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.f13935y, this.f13926p, this.f13676c, j());
                return;
            } else {
                ironLog.error("mAuctionHandler is null");
                return;
            }
        }
        a(IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{"duration", 0}});
        if (a(i.AUCTION, i.LOADED)) {
            this.f13921k.a(TimeUnit.SECONDS.toMillis(this.f13919i.f()));
            return;
        }
        n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(1005, "No candidates available for auctioning"));
        a(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}});
        a(i.READY_TO_LOAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<q7> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb);
            return;
        }
        t7 t7Var = new t7();
        e eVar = new e(map, sb, list);
        a(IronSourceConstants.BN_COLLECT_TOKENS);
        t7Var.a(list2, eVar, this.G, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(org.json.JSONObject r7, com.ironsource.mediationsdk.ISBannerSize r8) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.w.a(org.json.JSONObject, com.ironsource.mediationsdk.ISBannerSize):void");
    }

    private boolean a(i iVar, i iVar2) {
        boolean z10;
        synchronized (this.C) {
            if (this.f13920j == iVar) {
                IronLog.INTERNAL.verbose("set state from '" + this.f13920j + "' to '" + iVar2 + "'");
                this.f13920j = iVar2;
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }
}
