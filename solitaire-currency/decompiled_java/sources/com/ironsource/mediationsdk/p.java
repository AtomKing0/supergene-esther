package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.a4;
import com.ironsource.af;
import com.ironsource.ah;
import com.ironsource.aj;
import com.ironsource.b7;
import com.ironsource.ca;
import com.ironsource.ce;
import com.ironsource.ch;
import com.ironsource.cr;
import com.ironsource.d4;
import com.ironsource.da;
import com.ironsource.e1;
import com.ironsource.el;
import com.ironsource.en;
import com.ironsource.environment.ContextProvider;
import com.ironsource.fd;
import com.ironsource.fl;
import com.ironsource.fo;
import com.ironsource.g1;
import com.ironsource.gf;
import com.ironsource.hi;
import com.ironsource.i9;
import com.ironsource.is;
import com.ironsource.ja;
import com.ironsource.jg;
import com.ironsource.ji;
import com.ironsource.jl;
import com.ironsource.kb;
import com.ironsource.kp;
import com.ironsource.l8;
import com.ironsource.lj;
import com.ironsource.m8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adquality.AdQualityBridge;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.events.ISErrorListener;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.s;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.n6;
import com.ironsource.os;
import com.ironsource.pp;
import com.ironsource.ps;
import com.ironsource.qe;
import com.ironsource.qq;
import com.ironsource.rk;
import com.ironsource.rp;
import com.ironsource.rq;
import com.ironsource.rt;
import com.ironsource.sd;
import com.ironsource.se;
import com.ironsource.sl;
import com.ironsource.st;
import com.ironsource.t8;
import com.ironsource.te;
import com.ironsource.to;
import com.ironsource.ts;
import com.ironsource.ui;
import com.ironsource.ul;
import com.ironsource.vi;
import com.ironsource.wa;
import com.ironsource.wm;
import com.ironsource.x7;
import com.ironsource.xa;
import com.ironsource.xh;
import com.ironsource.yc;
import com.ironsource.z5;
import com.ironsource.zb;
import com.ironsource.zn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class p implements ui, en, ca, ca.b, ca.c, ca.a {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static boolean f13732t0 = false;
    private Set<IronSource.AD_UNIT> A;
    private boolean B;
    private IronSourceSegment C;
    private final String D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private Boolean M;
    private IronSourceBannerLayout N;
    private String O;
    private Boolean P;
    private se Q;
    private w R;
    private xh S;
    private kp T;
    private z5 U;
    private InitializationListener V;
    private wm W;
    private AtomicBoolean X;
    private boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13733a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f13734a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13735b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f13736b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ce f13737c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean f13738c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ce.a f13739d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f13740d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final qe f13741e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final ConcurrentHashMap<String, h.d> f13742e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final sd f13743f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final ConcurrentHashMap<String, h.b> f13744f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final jg.a f13745g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final ConcurrentHashMap<String, h.d> f13746g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private IronSourceLoggerManager f13747h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private com.ironsource.mediationsdk.demandOnly.f f13748h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private rk f13749i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private com.ironsource.mediationsdk.demandOnly.k f13750i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.ironsource.mediationsdk.logger.b f13751j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private com.ironsource.mediationsdk.demandOnly.c f13752j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AtomicBoolean f13753k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private zb f13754k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f13755l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private vi f13756l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private cr f13757m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private fd f13758m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f13759n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f13760n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f13761o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private AdQualityBridge f13762o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f13763p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final AtomicBoolean f13764p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f13765q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    ISErrorListener f13766q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<String, String> f13767r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    af<ISDemandOnlyInterstitialListener> f13768r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f13769s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    af<ISDemandOnlyRewardedVideoListener> f13770s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private AtomicBoolean f13771t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f13772u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List<IronSource.AD_UNIT> f13773v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f13774w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Context f13775x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Boolean f13776y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Set<IronSource.AD_UNIT> f13777z;

    class a implements ISErrorListener {
        a() {
        }

        @Override // com.ironsource.mediationsdk.events.ISErrorListener
        public void onError(Throwable th) {
            IronLog.INTERNAL.error(th.getMessage());
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f13780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f13781c;

        static {
            int[] iArr = new int[fo.b.values().length];
            f13781c = iArr;
            try {
                iArr[fo.b.CAPPED_PER_DELIVERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13781c[fo.b.CAPPED_PER_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13781c[fo.b.CAPPED_PER_PACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13781c[fo.b.NOT_CAPPED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[s.d.values().length];
            f13780b = iArr2;
            try {
                iArr2[s.d.INIT_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13780b[s.d.INIT_IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[IronSource.AD_UNIT.values().length];
            f13779a = iArr3;
            try {
                iArr3[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13779a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13779a[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13779a[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public interface c {
        void a(String str);
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static volatile p f13782a = new p(null);

        private d() {
        }
    }

    private p() {
        this(el.N().f(), el.I().b(), el.N().x(), el.N().t(), el.I().o());
    }

    private boolean A() {
        cr crVar = this.f13757m;
        return (crVar == null || crVar.j() == null || this.f13757m.j().a() == null || this.f13757m.j().a().size() <= 0) ? false : true;
    }

    private synchronized boolean C() {
        return this.f13772u;
    }

    private boolean D() {
        cr crVar = this.f13757m;
        return (crVar == null || crVar.c() == null || this.f13757m.c().d() == null) ? false : true;
    }

    private boolean E() {
        return D() && G();
    }

    private boolean G() {
        cr crVar = this.f13757m;
        return (crVar == null || crVar.j() == null || this.f13757m.j().b() == null || this.f13757m.j().b().size() <= 0) ? false : true;
    }

    private boolean H() {
        cr crVar = this.f13757m;
        return (crVar == null || crVar.c() == null || this.f13757m.c().e() == null) ? false : true;
    }

    private boolean I() {
        return H() && J();
    }

    private boolean J() {
        cr crVar = this.f13757m;
        return (crVar == null || crVar.j() == null || this.f13757m.j().c() == null || this.f13757m.j().c().isEmpty()) ? false : true;
    }

    private boolean L() {
        cr crVar = this.f13757m;
        return (crVar == null || crVar.c() == null || this.f13757m.c().f() == null) ? false : true;
    }

    private boolean M() {
        return L() && N();
    }

    private boolean N() {
        cr crVar = this.f13757m;
        return (crVar == null || crVar.j() == null || this.f13757m.j().d() == null || this.f13757m.j().d().size() <= 0) ? false : true;
    }

    private void T() {
        if (this.V == null || !this.X.compareAndSet(false, true)) {
            return;
        }
        IronLog.CALLBACK.verbose("onInitializationCompleted()");
        rp.i().a(new kb(IronSourceConstants.TROUBLESHOOTING_INIT_COMPLETED, IronSourceUtils.getMediationAdditionalData(false)));
        this.V.onInitializationComplete();
    }

    private void V() {
        ConcurrentHashMap<String, List<String>> concurrentHashMapC = lj.b().c();
        if (concurrentHashMapC.containsKey(com.ironsource.mediationsdk.metadata.a.f13684c)) {
            if (TextUtils.isEmpty(concurrentHashMapC.get(com.ironsource.mediationsdk.metadata.a.f13684c).get(0))) {
                return;
            }
            ja.f12717a.b(!MetaDataUtils.getMetaDataBooleanValue(r0));
        }
    }

    private boolean W() {
        return this.f13762o0 == null && this.f13764p0.get() && this.f13757m.c().a().a() && AdQualityBridge.adQualityAvailable();
    }

    private void X() {
        if (this.H) {
            Z();
            return;
        }
        boolean zH = this.f13757m.c().c().d().h();
        this.f13738c0 = zH;
        if (zH) {
            Y();
        } else {
            f0();
        }
    }

    private void Y() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.f13757m.j().a());
        if (listA.size() > 0) {
            this.U = new z5(listA, this.f13757m.c().c(), IronSourceUtils.getUserIdForNetworks(), lj.b(), this.C);
            v();
        } else {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.BANNER, false);
        }
    }

    private void Z() {
        this.f13747h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f13757m.j().a().size(); i10++) {
            String str = this.f13757m.j().a().get(i10);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.f13757m.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.BANNER, false);
            return;
        }
        synchronized (this.f13744f0) {
            n6 n6VarC = this.f13757m.c().c();
            da.a aVar = new da.a("Mediation");
            if (n6VarC.l()) {
                aVar.a("isOneFlow", 1);
            }
            this.f13752j0 = new com.ironsource.mediationsdk.demandOnly.c(arrayList, n6VarC, n(), o(), new da.b(ji.i(), aVar));
        }
        for (h.b bVar : this.f13744f0.values()) {
            this.f13752j0.a(bVar.g(), bVar.c());
        }
        this.f13744f0.clear();
    }

    private int a(pp ppVar) {
        return !this.f13734a0 && !this.Y && ppVar.k().e() ? 2 : 1;
    }

    private void a0() {
        this.f13747h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f13757m.j().b().size(); i10++) {
            String str = this.f13757m.j().b().get(i10);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.f13757m.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.INTERSTITIAL, false);
            return;
        }
        synchronized (this.f13742e0) {
            this.f13748h0 = a((List<NetworkSettings>) arrayList);
        }
        Iterator<h.d> it = this.f13742e0.values().iterator();
        while (it.hasNext()) {
            this.f13748h0.a(it.next());
        }
        this.f13742e0.clear();
    }

    private void b0() {
        this.f13747h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f13757m.j().d().size(); i10++) {
            String str = this.f13757m.j().d().get(i10);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.f13757m.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        synchronized (this.f13746g0) {
            this.f13750i0 = b(arrayList);
        }
        if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        Iterator<h.d> it = this.f13746g0.values().iterator();
        while (it.hasNext()) {
            this.f13750i0.a(it.next());
        }
        this.f13746g0.clear();
    }

    private void c0() {
        if (this.G) {
            a0();
        } else {
            d0();
        }
    }

    private void d0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.f13757m.j().b());
        if (listA.size() <= 0) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.INTERSTITIAL, false);
            return;
        }
        xh xhVar = new xh(listA, this.f13757m.c().d(), IronSourceUtils.getUserIdForNetworks(), lj.b(), this.C);
        this.S = xhVar;
        Boolean bool = this.f13776y;
        if (bool != null) {
            xhVar.a(this.f13775x, bool.booleanValue());
        }
        if (this.f13736b0) {
            this.f13736b0 = false;
            this.S.A();
        }
    }

    private void e0() {
        this.f13747h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in programmatic mode", 0);
        List<NetworkSettings> listA = a(this.f13757m.j().d());
        if (listA.size() <= 0) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.f13740d0);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            b(IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        q qVar = new q(listA, this.f13757m.c().f(), n(), IronSourceUtils.getUserIdForNetworks(), lj.b().a(), this.C);
        this.Q = qVar;
        Boolean bool = this.f13776y;
        if (bool != null) {
            qVar.a(this.f13775x, bool.booleanValue());
        }
    }

    private void f0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.f13757m.j().a());
        if (listA.size() > 0) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in programmatic mode", 0);
            this.R = new w(listA, new k(n(), IronSourceUtils.getUserIdForNetworks(), this.f13757m.c().c()), lj.b().a(), this.C);
            v();
        } else {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            a(IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.BANNER, false);
        }
    }

    private void g0() {
        if (this.F) {
            b0();
            return;
        }
        pp ppVarF = this.f13757m.c().f();
        this.f13734a0 = ppVarF.k().h();
        this.f13740d0 = a(ppVarF);
        if (this.Y || this.f13734a0) {
            h0();
        } else {
            e0();
        }
    }

    private void h0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.f13757m.j().d());
        if (listA.size() <= 0) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.f13740d0);
            a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
            b(IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        kp kpVar = new kp(listA, this.f13757m.c().f(), IronSourceUtils.getUserIdForNetworks(), this.Y, lj.b(), this.C);
        this.T = kpVar;
        Boolean bool = this.f13776y;
        if (bool != null) {
            kpVar.a(this.f13775x, bool.booleanValue());
        }
        if (this.Z && this.Y) {
            this.Z = false;
            this.T.A();
        }
    }

    private InterstitialPlacement i() {
        hi hiVarD = this.f13757m.c().d();
        if (hiVarD != null) {
            return hiVarD.a();
        }
        return null;
    }

    private Placement j() {
        pp ppVarF = this.f13757m.c().f();
        if (ppVarF != null) {
            return ppVarF.a();
        }
        return null;
    }

    private b7 k(String str) {
        b7 b7VarA;
        n6 n6VarC = this.f13757m.c().c();
        return n6VarC == null ? new wa() : (TextUtils.isEmpty(str) || (b7VarA = n6VarC.a(str)) == null) ? n6VarC.j() : b7VarA;
    }

    private fo.b l(String str) {
        InterstitialPlacement interstitialPlacementM;
        cr crVar = this.f13757m;
        if (crVar == null || crVar.c() == null || this.f13757m.c().d() == null) {
            return fo.b.NOT_CAPPED;
        }
        try {
            interstitialPlacementM = m(str);
            if (interstitialPlacementM == null) {
                try {
                    interstitialPlacementM = i();
                    if (interstitialPlacementM == null) {
                        this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
                    }
                } catch (Exception e10) {
                    e = e10;
                    i9.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        } catch (Exception e11) {
            e = e11;
            interstitialPlacementM = null;
        }
        return interstitialPlacementM == null ? fo.b.NOT_CAPPED : a(interstitialPlacementM);
    }

    private InterstitialPlacement m(String str) {
        hi hiVarD = this.f13757m.c().d();
        if (hiVarD != null) {
            return hiVarD.a(str);
        }
        return null;
    }

    private fo.b o(String str) {
        Placement placementP;
        cr crVar = this.f13757m;
        if (crVar == null || crVar.c() == null || this.f13757m.c().f() == null) {
            return fo.b.NOT_CAPPED;
        }
        try {
            placementP = p(str);
            if (placementP == null) {
                try {
                    placementP = j();
                    if (placementP == null) {
                        this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
                    }
                } catch (Exception e10) {
                    e = e10;
                    i9.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        } catch (Exception e11) {
            e = e11;
            placementP = null;
        }
        return placementP == null ? fo.b.NOT_CAPPED : a(placementP);
    }

    private Placement p(String str) {
        pp ppVarF = this.f13757m.c().f();
        if (ppVarF != null) {
            return ppVarF.a(str);
        }
        return null;
    }

    private synchronized wm r() {
        return this.W;
    }

    private l8 v(String str) {
        IronSourceError ironSourceError;
        String str2;
        l8 l8Var = new l8();
        if (str != null) {
            if (a(str, 5, 10)) {
                str2 = u(str) ? "length should be between 5-10 characters" : "should contain only english characters and numbers";
                return l8Var;
            }
            ironSourceError = ErrorBuilder.buildInvalidCredentialsError("appKey", str, str2);
        } else {
            ironSourceError = new IronSourceError(506, "Init Fail - appKey is missing");
        }
        l8Var.a(ironSourceError);
        return l8Var;
    }

    private void w() {
        this.f13747h = IronSourceLoggerManager.getLogger(0);
        com.ironsource.mediationsdk.logger.b bVar = new com.ironsource.mediationsdk.logger.b(null, 1);
        this.f13751j = bVar;
        this.f13747h.addLogger(bVar);
        this.f13749i = new rk();
    }

    private boolean x() {
        try {
            Class<?> cls = Class.forName("com.ironsource.adqualitysdk.sdk.IronSourceAdQuality");
            IronLog.INTERNAL.verbose("AdQuality SDK exist: " + cls.getName());
            return true;
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.verbose("No AdQuality SDK found");
            return false;
        }
    }

    private boolean y() {
        cr crVar = this.f13757m;
        return (crVar == null || crVar.c() == null || this.f13757m.c().c() == null) ? false : true;
    }

    private boolean z() {
        return y() && A();
    }

    boolean B() {
        return this.F || this.G || this.H;
    }

    public boolean F() {
        boolean z10;
        try {
            if (this.G) {
                this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead", 3);
                return false;
            }
            xh xhVar = this.S;
            boolean z11 = xhVar != null && xhVar.u();
            try {
                ji.i().a(new kb(z11 ? IronSourceConstants.IS_CHECK_READY_TRUE : IronSourceConstants.IS_CHECK_READY_FALSE, IronSourceUtils.getMediationAdditionalData(false, true, 1)));
                this.f13747h.log(IronSourceLogger.IronSourceTag.API, "isInterstitialReady():" + z11, 1);
                return z11;
            } catch (Throwable th) {
                z10 = z11;
                th = th;
                i9.d().a(th);
                IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.log(ironSourceTag, "isInterstitialReady():" + z10, 1);
                this.f13747h.logException(ironSourceTag, "isInterstitialReady()", th);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            z10 = false;
        }
    }

    public boolean K() {
        boolean z10;
        boolean z11;
        try {
            if (this.F) {
                this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use isISDemandOnlyRewardedVideoAvailable instead", 3);
                return false;
            }
            if (this.Y || this.f13734a0) {
                kp kpVar = this.T;
                z11 = kpVar != null && kpVar.u();
            } else {
                se seVar = this.Q;
                if (seVar != null && seVar.d()) {
                }
            }
            try {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(this.f13740d0)}});
                rp.i().a(new kb(z11 ? IronSourceConstants.RV_API_HAS_AVAILABILITY_TRUE : IronSourceConstants.RV_API_HAS_AVAILABILITY_FALSE, mediationAdditionalData));
                this.f13747h.log(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable():" + z11, 1);
                return z11;
            } catch (Throwable th) {
                z10 = z11;
                th = th;
                i9.d().a(th);
                IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.log(ironSourceTag, "isRewardedVideoAvailable():" + z10, 1);
                this.f13747h.logException(ironSourceTag, "isRewardedVideoAvailable()", th);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            z10 = false;
        }
    }

    public boolean O() {
        return C();
    }

    public void P() {
        IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "loadInterstitial()", 1);
        try {
            if (this.G) {
                this.f13747h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", "Interstitial"));
                return;
            }
            if (!this.J) {
                this.f13747h.log(ironSourceTag, "init() must be called before loadInterstitial()", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() must be called before loadInterstitial()", "Interstitial"));
                return;
            }
            s.d dVarA = s.c().a();
            if (dVarA == s.d.INIT_FAILED) {
                this.f13747h.log(ironSourceTag, "init() had failed", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                return;
            }
            if (dVarA == s.d.INIT_IN_PROGRESS) {
                if (!s.c().d()) {
                    this.f13736b0 = true;
                    return;
                } else {
                    this.f13747h.log(ironSourceTag, "init() had failed", 3);
                    n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                    return;
                }
            }
            if (!E()) {
                this.f13747h.log(ironSourceTag, "No interstitial configurations found", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
                return;
            }
            xh xhVar = this.S;
            if (xhVar == null) {
                this.f13736b0 = true;
            } else {
                xhVar.A();
            }
        } catch (Throwable th) {
            i9.d().a(th);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", th);
            n.a().b(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(510, th.getMessage()));
        }
    }

    public void Q() {
        IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "loadRewardedVideo()", 1);
        try {
            if (this.F) {
                this.f13747h.log(ironSourceTag, "Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            if (!this.Y && !this.f13760n0) {
                this.f13747h.log(ironSourceTag, "Rewarded Video is not initiated with manual load", 3);
                return;
            }
            if (!this.I) {
                this.f13747h.log(ironSourceTag, "init() must be called before loadRewardedVideo()", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() must be called before loadRewardedVideo()", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            s.d dVarA = s.c().a();
            if (dVarA == s.d.INIT_FAILED) {
                this.f13747h.log(ironSourceTag, "init() had failed", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            if (dVarA == s.d.INIT_IN_PROGRESS) {
                if (!s.c().d()) {
                    this.Z = true;
                    return;
                } else {
                    this.f13747h.log(ironSourceTag, "init() had failed", 3);
                    n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                    return;
                }
            }
            if (!M()) {
                this.f13747h.log(ironSourceTag, "No rewarded video configurations found", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            kp kpVar = this.T;
            if (kpVar == null) {
                this.Z = true;
            } else {
                kpVar.A();
            }
        } catch (Throwable th) {
            i9.d().a(th);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, "loadRewardedVideo()", th);
            n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, new IronSourceError(510, th.getMessage()));
        }
    }

    public void R() {
        xh xhVar = this.S;
        if (xhVar != null) {
            xhVar.a((ts) null);
        }
        kp kpVar = this.T;
        if (kpVar != null) {
            kpVar.a((ts) null);
        }
        z5 z5Var = this.U;
        if (z5Var != null) {
            z5Var.a((ts) null);
        }
        this.f13760n0 = false;
    }

    public void S() {
        IronLog.API.info("removing all impression data listeners");
        lj.b().d();
        se seVar = this.Q;
        if (seVar != null) {
            seVar.c();
        }
        w wVar = this.R;
        if (wVar != null) {
            wVar.c();
        }
    }

    public void U() {
        if (f13732t0) {
            return;
        }
        f13732t0 = true;
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put("status", "false");
            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, 1);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        rp.i().a(new kb(114, mediationAdditionalData));
    }

    cr b(Context context, String str, c cVar) {
        synchronized (this.f13755l) {
            cr crVar = this.f13757m;
            if (crVar != null) {
                return new cr(crVar);
            }
            cr crVarA = a(context, str, cVar);
            if (crVarA == null || !crVarA.p()) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                logger.log(ironSourceTag, "Null or invalid response. Trying to get cached response", 0);
                crVarA = a(context, n());
                if (crVarA != null) {
                    IronSourceError ironSourceErrorBuildUsingCachedConfigurationError = ErrorBuilder.buildUsingCachedConfigurationError(n(), str);
                    this.f13747h.log(ironSourceTag, ironSourceErrorBuildUsingCachedConfigurationError.toString() + ": " + crVarA.toString(), 1);
                    rp.i().a(new kb(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, IronSourceUtils.getMediationAdditionalData(false)));
                }
            }
            if (crVarA != null) {
                this.f13757m = crVarA;
                IronSourceUtils.saveLastResponse(context, crVarA.toString());
                b(this.f13757m, context);
                ji.i().c(true);
                rp.i().c(true);
                zn.P.c(true);
            }
            return crVarA;
        }
    }

    @Override // com.ironsource.ui
    public void c() {
        this.f13747h.log(IronSourceLogger.IronSourceTag.API, "removeRewardedVideoListener()", 1);
        to.a().a((LevelPlayRewardedVideoBaseListener) null);
    }

    @Override // com.ironsource.ui
    public void d() {
        this.f13747h.log(IronSourceLogger.IronSourceTag.API, "removeInterstitialListener()", 1);
        gf.a().a((LevelPlayInterstitialListener) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String e() {
        /*
            r3 = this;
            boolean r0 = r3.L
            if (r0 != 0) goto L7
            java.lang.String r0 = "init() must be called first"
            goto L2c
        L7:
            com.ironsource.mediationsdk.s r0 = com.ironsource.mediationsdk.s.c()
            int[] r1 = com.ironsource.mediationsdk.p.b.f13780b
            com.ironsource.mediationsdk.s$d r2 = r0.a()
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L2a
            r2 = 2
            if (r1 == r2) goto L20
            java.lang.String r0 = ""
            goto L2c
        L20:
            boolean r0 = r0.d()
            if (r0 == 0) goto L27
            goto L2a
        L27:
            java.lang.String r0 = "init() not finished yet"
            goto L2c
        L2a:
            java.lang.String r0 = "init() had failed"
        L2c:
            boolean r1 = r3.I()
            if (r1 != 0) goto L3a
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L3a
            java.lang.String r0 = "No Native Ad configurations found"
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.e():java.lang.String");
    }

    public sl f() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.f13757m.j().c());
        if (listA.size() > 0) {
            return new sl(listA, this.f13757m.c().e(), IronSourceUtils.getUserIdForNetworks(), lj.b(), this.C);
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        a(IronSourceConstants.TROUBLESHOOTING_NT_INIT_FAILED, mediationAdditionalData);
        return null;
    }

    @Override // com.ironsource.ui
    public InterstitialPlacement g(String str) {
        InterstitialPlacement interstitialPlacementM;
        try {
            interstitialPlacementM = m(str);
            if (interstitialPlacementM == null) {
                try {
                    this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    interstitialPlacementM = i();
                } catch (Exception e10) {
                    e = e10;
                    i9.d().a(e);
                }
            }
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "getPlacementInfo(placement: " + str + "):" + interstitialPlacementM, 1);
        } catch (Exception e11) {
            e = e11;
            interstitialPlacementM = null;
        }
        return interstitialPlacementM;
    }

    public cr h() {
        return this.f13757m;
    }

    public ul n(String str) {
        ul ulVarA;
        jl jlVarE = this.f13757m.c().e();
        if (jlVarE == null) {
            return null;
        }
        return (TextUtils.isEmpty(str) || (ulVarA = jlVarE.a(str)) == null) ? jlVarE.e() : ulVarA;
    }

    public String q() {
        return this.f13769s;
    }

    public Map<String, String> s() {
        return this.f13767r;
    }

    public IronSourceSegment t() {
        return this.C;
    }

    public String u() {
        return this.f13774w;
    }

    p(ce ceVar, ce.a aVar, qe qeVar, sd sdVar, jg.a aVar2) {
        this.f13733a = getClass().getName();
        this.f13735b = "!SDK-VERSION-STRING!:com.ironsource:mediationsdk:\u200b8.4.0";
        this.f13755l = new Object();
        this.f13757m = null;
        this.f13759n = null;
        this.f13761o = "";
        this.f13763p = null;
        this.f13765q = null;
        this.f13767r = null;
        this.f13769s = null;
        this.f13772u = false;
        this.f13776y = null;
        this.B = true;
        this.D = "sessionDepth";
        this.P = null;
        this.f13760n0 = false;
        this.f13737c = ceVar;
        this.f13739d = aVar;
        this.f13741e = qeVar;
        this.f13743f = sdVar;
        this.f13745g = aVar2;
        w();
        this.f13753k = new AtomicBoolean();
        this.f13777z = new HashSet();
        this.A = new HashSet();
        this.G = false;
        this.F = false;
        this.H = false;
        this.f13771t = new AtomicBoolean(true);
        this.X = new AtomicBoolean(false);
        this.f13764p0 = new AtomicBoolean(false);
        this.E = 0;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.f13774w = IronSourceUtils.getSessionId();
        this.M = Boolean.FALSE;
        this.f13736b0 = false;
        this.O = null;
        this.Q = null;
        this.V = null;
        this.W = null;
        this.R = null;
        this.Y = false;
        this.f13742e0 = new ConcurrentHashMap<>();
        this.f13746g0 = new ConcurrentHashMap<>();
        this.f13744f0 = new ConcurrentHashMap<>();
        this.f13748h0 = null;
        this.f13750i0 = null;
        this.f13752j0 = null;
        this.f13740d0 = 1;
        this.f13754k0 = new zb();
        vi viVar = new vi();
        this.f13756l0 = viVar;
        this.f13758m0 = new fd(viVar);
        this.f13766q0 = new a();
        this.f13762o0 = null;
        this.f13768r0 = new af.a();
        this.f13770s0 = new af.b();
    }

    private void e(Activity activity) {
        ContextProvider.getInstance().updateActivity(activity);
        IronLog.INTERNAL.verbose("activity is updated to: " + activity.hashCode());
    }

    private da k() {
        return new da.b(rp.i(), new da.a("IronSource"));
    }

    public static p m() {
        return d.f13782a;
    }

    private boolean u(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    private void v() {
        if (this.M.booleanValue()) {
            IronLog.INTERNAL.verbose("load banner after init");
            this.M = Boolean.FALSE;
            a(this.N, this.O);
            this.N = null;
            this.O = null;
        }
    }

    public cr a(Context context, String str) {
        if (ch.a(context)) {
            x7 x7VarC = ch.c(context);
            String strD = x7VarC.d();
            String strF = x7VarC.f();
            String strE = x7VarC.e();
            if (strD.equals(str)) {
                cr crVar = new cr(context, strD, strF, strE);
                crVar.a(cr.a.CACHE);
                return crVar;
            }
        }
        return null;
    }

    public IronSourceBannerLayout b(Activity activity, ISBannerSize iSBannerSize) {
        IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "createBanner()", 1);
        if (activity == null) {
            this.f13747h.log(ironSourceTag, "createBanner() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new IronSourceBannerLayout(activity, iSBannerSize);
    }

    public void c(Activity activity) {
        IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showInterstitial()", 1);
        try {
            if (this.G) {
                this.f13747h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                gf.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else {
                if (!D()) {
                    gf.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"), (AdInfo) null);
                    return;
                }
                InterstitialPlacement interstitialPlacementI = i();
                if (interstitialPlacementI != null) {
                    c(activity, interstitialPlacementI.getPlacementName());
                } else {
                    gf.a().a(new IronSourceError(1020, "showInterstitial error: empty default placement in response"), (AdInfo) null);
                }
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, "showInterstitial()", e10);
            gf.a().a(new IronSourceError(510, e10.getMessage()), (AdInfo) null);
        }
    }

    public void d(Activity activity) {
        if (!L()) {
            to.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            this.f13747h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", 3);
            return;
        }
        Placement placementJ = j();
        if (placementJ != null) {
            f(activity, placementJ.getPlacementName());
            return;
        }
        this.f13747h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo error: empty default placement in response", 3);
        to.a().a(new IronSourceError(1021, "showRewardedVideo error: empty default placement in response"), (AdInfo) null);
    }

    public void f(Activity activity, String str) {
        String str2 = "showRewardedVideo(" + str + ")";
        IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, str2, 1);
        try {
            if (this.F) {
                this.f13747h.log(ironSourceTag, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
                to.a().a(ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            } else if (L()) {
                e(activity, str);
            } else {
                to.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, str2, e10);
            to.a().a(new IronSourceError(510, e10.getMessage()), (AdInfo) null);
        }
    }

    Boolean g() {
        return this.P;
    }

    @Override // com.ironsource.ui
    public void h(String str) {
        try {
            String str2 = this.f13733a + ":setMediationType(mediationType:" + str + ")";
            IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, str2, 1);
            if (a(str, 1, 64) && u(str)) {
                this.f13769s = str;
                this.f13756l0.e(str);
            } else {
                this.f13747h.log(ironSourceTag, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, this.f13733a + ":setMediationType(mediationType:" + str + ")", e10);
        }
    }

    @Override // com.ironsource.ui
    public Placement i(String str) {
        Placement placementP;
        try {
            placementP = p(str);
            if (placementP == null) {
                try {
                    this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    placementP = j();
                } catch (Exception e10) {
                    e = e10;
                    i9.d().a(e);
                }
            }
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "getPlacementInfo(placement: " + str + "):" + placementP, 1);
        } catch (Exception e11) {
            e = e11;
            placementP = null;
        }
        return placementP;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    @Override // com.ironsource.ca.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean j(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.ironsource.mediationsdk.demandOnly.k r0 = r1.f13750i0     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            boolean r2 = r0.a(r2)     // Catch: java.lang.Throwable -> L10
            if (r2 == 0) goto Ld
            r2 = 1
            goto Le
        Ld:
            r2 = 0
        Le:
            monitor-exit(r1)
            return r2
        L10:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.j(java.lang.String):boolean");
    }

    public String l() {
        return this.f13765q;
    }

    public String n() {
        return this.f13759n;
    }

    public String o() {
        return this.f13761o;
    }

    public List<IronSource.AD_UNIT> p() {
        ArrayList arrayList = new ArrayList();
        Set<IronSource.AD_UNIT> set = this.f13777z;
        if (set != null) {
            arrayList.addAll(set);
        }
        return arrayList;
    }

    boolean q(String str) {
        if (!y()) {
            return false;
        }
        b7 b7VarA = null;
        try {
            b7VarA = this.f13757m.c().c().a(str);
            if (b7VarA == null && (b7VarA = this.f13757m.c().c().j()) == null) {
                this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Banner default placement was not found", 3);
                return false;
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        if (b7VarA == null) {
            return false;
        }
        return a(b7VarA);
    }

    boolean r(String str) {
        if (this.G) {
            return false;
        }
        boolean z10 = l(str) != fo.b.NOT_CAPPED;
        if (z10) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.G, true, 1);
            try {
                mediationAdditionalData.put("placement", str);
                mediationAdditionalData.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
            } catch (Exception e10) {
                i9.d().a(e10);
            }
            ji.i().a(new kb(IronSourceConstants.IS_CHECK_CAPPED_TRUE, mediationAdditionalData));
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean s(java.lang.String r4) {
        /*
            r3 = this;
            com.ironsource.fo$b r0 = r3.o(r4)
            if (r0 == 0) goto L17
            int[] r1 = com.ironsource.mediationsdk.p.b.f13781c
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L18
            r2 = 2
            if (r0 == r2) goto L18
            r2 = 3
            if (r0 == r2) goto L18
        L17:
            r1 = 0
        L18:
            r3.a(r1, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.s(java.lang.String):boolean");
    }

    public void t(String str) {
        IronLog.API.verbose("userId = " + str);
        this.f13761o = str;
        rp.i().a(new kb(52, IronSourceUtils.getJsonForUserId(false)));
        AdQualityBridge adQualityBridge = this.f13762o0;
        if (adQualityBridge != null) {
            adQualityBridge.changeUserId(str);
        }
    }

    /* synthetic */ p(a aVar) {
        this();
    }

    private cr a(Context context, String str, c cVar) {
        cr crVar = null;
        if (!IronSourceUtils.isNetworkConnected(context)) {
            return null;
        }
        try {
            String strB = b(context);
            if (TextUtils.isEmpty(strB)) {
                strB = this.f13737c.J(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String str2 = strB;
            IronSourceSegment ironSourceSegment = this.C;
            String strSendPostRequest = HttpFunctions.sendPostRequest(ServerURL.buildInitURL(context, n(), str, str2, q(), this.Y, ironSourceSegment != null ? ironSourceSegment.getSegmentData() : null, B()), ah.a().toString(), cVar);
            if (strSendPostRequest == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return null;
            }
            if (IronSourceUtils.isEncryptedResponse()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("encrypt");
                JSONObject jSONObject = new JSONObject(strSendPostRequest);
                String strOptString = jSONObject.optString("response", null);
                if (TextUtils.isEmpty(strOptString)) {
                    ironLog.warning("encryptedResponse is empty - return null");
                    return null;
                }
                strSendPostRequest = a(strOptString, Boolean.valueOf(jSONObject.optBoolean("compression", false)));
                if (TextUtils.isEmpty(strSendPostRequest)) {
                    ironLog.warning("encoded response invalid - return null");
                    U();
                    return null;
                }
            }
            cr crVar2 = new cr(context, n(), str, strSendPostRequest);
            try {
                crVar2.a(cr.a.SERVER);
                if (crVar2.p()) {
                    return crVar2;
                }
                IronLog.INTERNAL.warning("response invalid - return null");
                return null;
            } catch (Exception e10) {
                e = e10;
                crVar = crVar2;
                i9.d().a(e);
                IronLog.INTERNAL.warning("exception = " + e);
                return crVar;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    private com.ironsource.mediationsdk.demandOnly.k b(List<NetworkSettings> list) {
        pp ppVarF = this.f13757m.c().f();
        da.a aVar = new da.a("Mediation");
        if (ppVarF.d()) {
            aVar.a("isOneFlow", 1);
        }
        return new com.ironsource.mediationsdk.demandOnly.k(list, ppVarF, com.ironsource.mediationsdk.c.b(), this.f13770s0, n(), o(), new da.b(rp.i(), aVar));
    }

    private void d(Activity activity, String str) {
        try {
            InterstitialPlacement interstitialPlacementM = m(str);
            if (interstitialPlacementM == null) {
                interstitialPlacementM = i();
            }
            if (interstitialPlacementM == null) {
                this.f13747h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticInterstitial error: empty default placement in response", 3);
                gf.a().a(new IronSourceError(1020, "showProgrammaticInterstitial error: empty default placement in response"), (AdInfo) null);
                return;
            }
            if (activity != null) {
                e(activity);
            } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Activity must be provided in showInterstitial when initializing SDK with context", 3);
                gf.a().a(new IronSourceError(510, "Activity must be provided in showInterstitial when initializing SDK with context"), (AdInfo) null);
                return;
            }
            this.S.a(activity, new Placement(interstitialPlacementM));
        } catch (Exception e10) {
            i9.d().a(e10);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticInterstitial()", e10);
        }
    }

    private void e(Activity activity, String str) {
        Placement placementP;
        try {
            placementP = p(str);
            if (placementP == null) {
                try {
                    placementP = j();
                } catch (Exception e10) {
                    e = e10;
                    i9.d().a(e);
                    this.f13747h.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticRewardedVideo()", e);
                }
            }
            if (placementP == null) {
                this.f13747h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticRewardedVideo error: empty default placement in response", 3);
                to.a().a(new IronSourceError(1021, "showProgrammaticRewardedVideo error: empty default placement in response"), (AdInfo) null);
                return;
            }
        } catch (Exception e11) {
            e = e11;
            placementP = null;
        }
        if (activity != null) {
            e(activity);
        } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Activity must be provided in showRewardedVideo when initializing SDK with context", 3);
            to.a().a(ErrorBuilder.buildInitFailedError("Activity must be provided in showRewardedVideo when initializing SDK with context", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            return;
        }
        kp kpVar = this.T;
        if (kpVar != null && (this.Y || this.f13734a0)) {
            kpVar.a(activity, placementP);
            return;
        }
        se seVar = this.Q;
        if (seVar != null) {
            seVar.a(activity, placementP);
            return;
        }
        this.f13747h.log(IronSourceLogger.IronSourceTag.API, "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet", 3);
        to.a().a(new IronSourceError(1023, "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet"), (AdInfo) null);
    }

    public void c(Activity activity, String str) {
        String str2 = "showInterstitial(" + str + ")";
        IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, str2, 1);
        try {
            if (this.G) {
                this.f13747h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                gf.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else if (D()) {
                d(activity, str);
            } else {
                gf.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"), (AdInfo) null);
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, str2, e10);
            gf.a().a(new IronSourceError(510, e10.getMessage()), (AdInfo) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    @Override // com.ironsource.ca.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean f(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.ironsource.mediationsdk.demandOnly.f r0 = r1.f13748h0     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            boolean r2 = r0.b(r2)     // Catch: java.lang.Throwable -> L10
            if (r2 == 0) goto Ld
            r2 = 1
            goto Le
        Ld:
            r2 = 0
        Le:
            monitor-exit(r1)
            return r2
        L10:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.f(java.lang.String):boolean");
    }

    private void d(Context context) {
        AtomicBoolean atomicBoolean = this.f13753k;
        if (atomicBoolean == null || !atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        is.a().a(new yc(context));
        ji.i().a(context, this.C);
        rp.i().a(context, this.C);
        zn.P.a(context, this.C);
    }

    fo.b a(InterstitialPlacement interstitialPlacement) {
        return this.f13741e.a(ContextProvider.getInstance().getApplicationContext(), interstitialPlacement, IronSource.AD_UNIT.INTERSTITIAL);
    }

    @Override // com.ironsource.ui
    public String b(Context context) {
        String strP = this.f13737c.p(context);
        return !TextUtils.isEmpty(strP) ? strP : "";
    }

    public void c(@NotNull Context context) {
        os osVar = os.f14268a;
        osVar.b();
        if (!C()) {
            osVar.a(IronSourceConstants.errorCode_TEST_SUITE_SDK_NOT_INITIALIZED);
            IronLog.API.error("TestSuite cannot be launched, SDK not initialized");
            return;
        }
        if (!b(this.f13757m)) {
            osVar.a(IronSourceConstants.errorCode_TEST_SUITE_DISABLED);
            IronLog.API.error("TestSuite cannot be launched, Please contact your account manager to enable it");
            return;
        }
        if (!IronSourceUtils.isNetworkConnected(context)) {
            osVar.a(IronSourceConstants.errorCode_TEST_SUITE_NO_NETWORK_CONNECTIVITY);
            IronLog.API.error("TestSuite cannot be launched, No network connectivity");
            return;
        }
        xh xhVar = this.S;
        if (xhVar != null) {
            xhVar.J();
        }
        kp kpVar = this.T;
        if (kpVar != null) {
            kpVar.J();
        }
        z5 z5Var = this.U;
        if (z5Var != null) {
            z5Var.J();
            this.U.T();
        }
        new ps().a(context, n(), this.f13757m.i(), IronSourceUtils.getSDKVersion(), this.f13757m.c().g().b(), g(), this.Y);
        this.f13760n0 = true;
        osVar.c();
    }

    @Override // com.ironsource.ui
    public boolean e(String str) {
        try {
            String str2 = this.f13733a + ":setDynamicUserId(dynamicUserId:" + str + ")";
            IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, str2, 1);
            l8 l8Var = new l8();
            a(str, l8Var);
            if (!l8Var.b()) {
                IronSourceLoggerManager.getLogger().log(ironSourceTag, l8Var.a().toString(), 2);
                return false;
            }
            this.f13765q = str;
            rp.i().a(new kb(52, IronSourceUtils.getJsonForUserId(true)));
            return true;
        } catch (Exception e10) {
            i9.d().a(e10);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, this.f13733a + ":setDynamicUserId(dynamicUserId:" + str + ")", e10);
            return false;
        }
    }

    fo.b a(Placement placement) {
        return this.f13741e.a(ContextProvider.getInstance().getApplicationContext(), placement, IronSource.AD_UNIT.REWARDED_VIDEO);
    }

    @Override // com.ironsource.ui
    public void b() {
        this.f13767r = null;
    }

    @Override // com.ironsource.ca.a
    public void c(String str) {
        this.f13747h.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            com.ironsource.mediationsdk.demandOnly.c cVar = this.f13752j0;
            if (cVar != null) {
                cVar.a(str);
            }
        } catch (Throwable th) {
            i9.d().a(th);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, "destroyISDemandOnlyBanner()", th);
        }
    }

    @Override // com.ironsource.en
    public void d(String str) {
        try {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "onInitFailed(reason:" + str + ")", 1);
            IronSourceUtils.sendAutomationLog("Mediation init failed");
            if (this.f13749i != null) {
                Iterator<IronSource.AD_UNIT> it = this.f13777z.iterator();
                while (it.hasNext()) {
                    a(it.next(), true);
                }
            }
            wm wmVarR = r();
            if (wmVarR != null) {
                wmVarR.onInitFailed(new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_FAILED, "Legacy init failed"));
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    private void b(int i10, JSONObject jSONObject) {
        rp.i().a(new kb(i10, jSONObject));
    }

    private synchronized void c(boolean z10) {
        this.f13772u = z10;
    }

    @Override // com.ironsource.ca.a
    public ISDemandOnlyBannerLayout a(Activity activity, ISBannerSize iSBannerSize) {
        IronSourceLoggerManager ironSourceLoggerManager = this.f13747h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "createBannerForDemandOnly()", 1);
        if (activity == null) {
            this.f13747h.log(ironSourceTag, "createBannerForDemandOnly() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new ISDemandOnlyBannerLayout(activity, iSBannerSize);
    }

    private com.ironsource.mediationsdk.demandOnly.f a(List<NetworkSettings> list) {
        hi hiVarD = this.f13757m.c().d();
        da.a aVar = new da.a("Mediation");
        if (hiVarD.k()) {
            aVar.a("isOneFlow", 1);
        }
        return new com.ironsource.mediationsdk.demandOnly.f(list, hiVarD, com.ironsource.mediationsdk.c.b(), this.f13768r0, n(), o(), new da.b(ji.i(), aVar));
    }

    public void b(Activity activity) {
        try {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "onResume()", 1);
            ContextProvider.getInstance().onResume(activity);
        } catch (Throwable th) {
            i9.d().a(th);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, "onResume()", th);
        }
    }

    public synchronized IronSourceError a(Context context, String str, boolean z10, InitializationListener initializationListener, wm wmVar, IronSource.AD_UNIT... ad_unitArr) {
        IronLog.INTERNAL.verbose("GitHash: 8b48d21");
        com.ironsource.j.f12678a.a(context);
        if (!aj.a((Object) context, "Init Failed - provided context is null")) {
            d("Provided context is null");
            return new IronSourceError(2000, "Provided context is null");
        }
        this.f13745g.a(context);
        boolean z11 = context instanceof Activity;
        if (z11) {
            e((Activity) context);
        }
        if (initializationListener != null) {
            this.V = initializationListener;
        }
        if (!z10) {
            this.f13764p0.set(true);
        }
        AtomicBoolean atomicBoolean = this.f13771t;
        if (atomicBoolean == null || !atomicBoolean.compareAndSet(true, false)) {
            if (ad_unitArr != null) {
                a(z11, z10, wmVar != null, ad_unitArr);
                if (C() && !z10) {
                    T();
                }
            } else {
                this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Multiple calls to init without ad units are not allowed", 3);
            }
            qq qqVarB = rq.f14723a.b();
            if (C()) {
                return new IronSourceError(IronSourceError.ERROR_INIT_ALREADY_FINISHED, "Already finished init");
            }
            if (qqVarB == qq.INIT_FAILED) {
                return new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_FAILED, "Legacy init failed");
            }
            if (qqVarB == qq.NOT_INIT) {
                return new IronSourceError(2020, "Already called new init");
            }
            if (wmVar != null) {
                a(wmVar);
            }
            return new IronSourceError(IronSourceError.ERROR_OLD_API_INIT_IN_PROGRESS, "Old Api init in progress");
        }
        rq.f14723a.a(wmVar == null);
        if ((ad_unitArr == null || ad_unitArr.length == 0) && wmVar == null) {
            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                this.f13777z.add(ad_unit);
            }
            this.I = true;
            this.J = true;
            this.K = true;
            this.L = true;
        } else {
            for (IronSource.AD_UNIT ad_unit2 : ad_unitArr) {
                this.f13777z.add(ad_unit2);
                this.A.add(ad_unit2);
                if (ad_unit2.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                    this.J = true;
                }
                if (ad_unit2.equals(IronSource.AD_UNIT.BANNER)) {
                    this.K = true;
                }
                if (ad_unit2.equals(IronSource.AD_UNIT.NATIVE_AD)) {
                    this.L = true;
                }
                if (ad_unit2.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                    this.I = true;
                }
            }
        }
        IronLog.API.info("init(appKey:" + str + ")");
        l8 l8VarV = v(str);
        if (l8VarV.b()) {
            this.f13759n = str;
        }
        cr crVarA = a(context, this.f13759n);
        if (crVarA != null) {
            IronLog.INTERNAL.verbose("init cache exists");
            a(crVarA.c().b().e());
        } else {
            IronLog.INTERNAL.verbose("init cache does not exist");
        }
        ContextProvider.getInstance().updateAppContext(context.getApplicationContext());
        this.f13739d.a(context.getApplicationContext(), TimeUnit.HOURS.toMillis(ja.f12717a.d()));
        this.f13756l0.f(IronSourceUtils.getSDKVersion());
        this.f13756l0.a(te.a());
        this.f13756l0.b(IronSourceUtils.isGooglePlayInstalled(context));
        this.f13756l0.a(g1.a());
        V();
        d(context);
        if (this.f13759n == null) {
            s.c().f();
            if (this.f13777z.contains(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                to.a().a(false, (AdInfo) null);
            }
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, l8VarV.a().toString(), 1);
            return new IronSourceError(IronSourceError.ERROR_OLD_INIT_API_APP_KEY_IS_NULL, "App key is null");
        }
        this.f13756l0.a(context);
        this.f13756l0.b(this.f13759n);
        this.f13756l0.h(this.f13774w);
        this.f13756l0.g(ConfigFile.getConfigFile().getPluginType());
        if (this.B) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z10);
            if (ad_unitArr != null) {
                for (IronSource.AD_UNIT ad_unit3 : ad_unitArr) {
                    try {
                        mediationAdditionalData.put(ad_unit3.toString(), true);
                    } catch (Exception e10) {
                        i9.d().a(e10);
                    }
                }
            }
            int i10 = this.E + 1;
            this.E = i10;
            a(z11, z10, i10, mediationAdditionalData, wmVar != null);
            this.B = false;
        }
        return null;
    }

    @Override // com.ironsource.ca.c
    public synchronized void b(Activity activity, String str) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.REWARDED_VIDEO).b(), this.f13770s0.a(str));
    }

    @Nullable
    private IronSourceError a(s.d dVar) {
        if (!this.K) {
            return new IronSourceError(510, "ironSource SDK was not initialized");
        }
        if (!this.H) {
            return new IronSourceError(510, "ironSource SDK was not initialized using Demand Only mode");
        }
        if (dVar == s.d.INIT_FAILED) {
            return new IronSourceError(510, "ironSource initialization failed");
        }
        if (dVar == s.d.INIT_IN_PROGRESS && s.c().d()) {
            return new IronSourceError(510, "ironSource initialization in progress");
        }
        return null;
    }

    @Override // com.ironsource.ca.b
    public synchronized void b(Activity activity, String str, String str2) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.INTERSTITIAL).a(true).a(str2).b(), this.f13768r0.a(str));
    }

    private void b(a4 a4Var, Context context, cr crVar) {
        rp.i().a(a4Var.c(), context);
        rp.i().b(a4Var.d(), context);
        rp.i().b(a4Var.f());
        rp.i().a(a4Var.e());
        rp.i().c(a4Var.a());
        rp.i().c(a4Var.i(), context);
        rp.i().a(a4Var.h(), context);
        rp.i().b(a4Var.j(), context);
        rp.i().d(a4Var.g(), context);
        rp.i().a(crVar.c().b().i());
        rp.i().a(a4Var.k());
        rp.i().d(a4Var.b());
    }

    @Override // com.ironsource.ca
    @Nullable
    public String a(@NotNull Context context) throws JSONException {
        st stVarJ;
        da daVarK = k();
        qq qqVarA = rq.f14723a.a();
        daVarK.a(IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_IN_INIT_STATUS, qqVarA);
        if (context == null) {
            IronLog.API.error("bidding data cannot be retrieved, context required");
            daVarK.a(IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_WITHOUT_CONTEXT, (qq) null);
            return null;
        }
        if (qqVarA == qq.NOT_INIT) {
            IronLog.API.error("bidding data cannot be retrieved, SDK not initialized");
            return null;
        }
        s.c().g();
        cr crVar = this.f13757m;
        boolean zE = (crVar == null || (stVarJ = crVar.c().b().j()) == null) ? true : stVarJ.e();
        JSONObject jSONObjectA = new rt().a(context);
        com.ironsource.mediationsdk.d.b().a(jSONObjectA, true);
        String string = jSONObjectA.toString();
        String strCompressAndEncrypt = zE ? IronSourceAES.compressAndEncrypt(string) : IronSourceAES.encrypt(string);
        if (strCompressAndEncrypt == null) {
            daVarK.a(IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (qq) null);
        }
        return strCompressAndEncrypt;
    }

    String a(String str, fo.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i10 = b.f13781c[bVar.ordinal()];
        if (i10 != 1 && i10 != 2 && i10 != 3) {
            return null;
        }
        return "placement " + str + " is capped";
    }

    public void b(cr crVar, Context context) {
        a(crVar);
        a(crVar, context);
    }

    private String a(String str, Boolean bool) {
        return bool.booleanValue() ? IronSourceAES.decryptAndDecompress(xa.b().c(), str) : IronSourceAES.decode(xa.b().c(), str);
    }

    private void b(IronSource.AD_UNIT ad_unit) {
        int i10 = b.f13779a[ad_unit.ordinal()];
        if (i10 == 1) {
            g0();
        } else if (i10 == 2) {
            c0();
        } else {
            if (i10 != 3) {
                return;
            }
            X();
        }
    }

    HashSet<String> a(String str, String str2) {
        cr crVar = this.f13757m;
        return crVar == null ? new HashSet<>() : crVar.k().a(str, str2);
    }

    public void b(IronSourceBannerLayout ironSourceBannerLayout) {
        a(ironSourceBannerLayout, "");
    }

    public synchronized List<IronSource.AD_UNIT> a(Context context, String str, boolean z10, IronSource.AD_UNIT... ad_unitArr) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if ((ad_unitArr == null || ad_unitArr.length == 0) && z10) {
            if (this.I) {
                a(IronSource.AD_UNIT.REWARDED_VIDEO);
            } else {
                this.F = true;
                arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
            }
            if (this.J) {
                a(IronSource.AD_UNIT.INTERSTITIAL);
            } else {
                this.G = true;
                arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
            }
            if (this.K) {
                a(IronSource.AD_UNIT.BANNER);
            } else {
                this.H = true;
                arrayList.add(IronSource.AD_UNIT.BANNER);
            }
        } else {
            for (IronSource.AD_UNIT ad_unit : ad_unitArr) {
                if (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                    if (this.J) {
                        a(ad_unit);
                    } else {
                        this.G = true;
                        if (!arrayList.contains(ad_unit)) {
                            arrayList.add(ad_unit);
                        }
                    }
                }
                if (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                    if (this.I) {
                        a(ad_unit);
                    } else {
                        this.F = true;
                        if (!arrayList.contains(ad_unit)) {
                            arrayList.add(ad_unit);
                        }
                    }
                }
                if (ad_unit.equals(IronSource.AD_UNIT.BANNER)) {
                    if (this.K) {
                        a(ad_unit);
                    } else {
                        this.H = true;
                        if (!arrayList.contains(ad_unit)) {
                            arrayList.add(ad_unit);
                        }
                    }
                }
            }
        }
        if (context != null) {
            if (context instanceof Activity) {
                e((Activity) context);
            }
            ContextProvider.getInstance().updateAppContext(context.getApplicationContext());
        }
        return arrayList;
    }

    @Override // com.ironsource.tg
    public void b(@NotNull ImpressionDataListener impressionDataListener) {
        if (aj.a((Object) impressionDataListener, "addImpressionDataListener - listener is null")) {
            lj.b().a(impressionDataListener);
            se seVar = this.Q;
            if (seVar != null) {
                seVar.b(impressionDataListener);
            }
            w wVar = this.R;
            if (wVar != null) {
                wVar.b(impressionDataListener);
            }
            IronLog.API.info("add impression data listener to " + impressionDataListener.getClass().getSimpleName());
        }
    }

    private List<NetworkSettings> a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            String str = arrayList.get(i10);
            if (!TextUtils.isEmpty(str)) {
                arrayList2.add(this.f13757m.k().b(str));
            }
        }
        return arrayList2;
    }

    @Override // com.ironsource.ca.b
    public void b(String str) {
        this.f13747h.log(IronSourceLogger.IronSourceTag.API, "showDemandOnlyInterstitial() instanceId=" + str, 1);
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListenerA = this.f13768r0.a(str);
        try {
            if (!this.G) {
                IronLog.API.error("Interstitial was initialized in mediation mode. Use showInterstitial instead");
                iSDemandOnlyInterstitialListenerA.onInterstitialAdShowFailed(str, new IronSourceError(508, "Interstitial was initialized in mediation mode. Use showInterstitial instead"));
                return;
            }
            com.ironsource.mediationsdk.demandOnly.f fVar = this.f13748h0;
            if (fVar != null) {
                fVar.a(str);
            } else {
                IronLog.API.error("Interstitial was not initiated");
                iSDemandOnlyInterstitialListenerA.onInterstitialAdShowFailed(str, new IronSourceError(508, "Interstitial was not initiated"));
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.API.error(e10.getMessage());
            if (iSDemandOnlyInterstitialListenerA != null) {
                iSDemandOnlyInterstitialListenerA.onInterstitialAdShowFailed(str, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
            }
        }
    }

    @Override // com.ironsource.en
    public void a() {
        if (this.M.booleanValue()) {
            this.M = Boolean.FALSE;
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(603, "init() had failed"));
            this.N = null;
            this.O = null;
        }
        if (this.f13736b0) {
            this.f13736b0 = false;
            n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
        }
        if (this.Z) {
            this.Z = false;
            n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        synchronized (this.f13742e0) {
            Iterator<h.d> it = this.f13742e0.values().iterator();
            while (it.hasNext()) {
                String strC = it.next().c();
                this.f13768r0.a(strC).onInterstitialAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            }
            this.f13742e0.clear();
        }
        synchronized (this.f13746g0) {
            Iterator<h.d> it2 = this.f13746g0.values().iterator();
            while (it2.hasNext()) {
                String strC2 = it2.next().c();
                this.f13770s0.a(strC2).onRewardedVideoAdLoadFailed(strC2, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            this.f13746g0.clear();
        }
        synchronized (this.f13744f0) {
            for (h.b bVar : this.f13744f0.values()) {
                ISDemandOnlyBannerLayout iSDemandOnlyBannerLayoutG = bVar.g();
                if (iSDemandOnlyBannerLayoutG != null) {
                    iSDemandOnlyBannerLayoutG.getListener().a(bVar.c(), ErrorBuilder.buildInitFailedError("init() had failed", "Banner"));
                }
            }
            this.f13744f0.clear();
        }
    }

    public void b(@NotNull String str, @NotNull JSONObject jSONObject) {
        v vVar = new v(str, jSONObject);
        IronLog.API.verbose(vVar.toString());
        com.ironsource.mediationsdk.c.b().a(vVar);
    }

    private void a(int i10, JSONObject jSONObject) {
        ji.i().a(new kb(i10, jSONObject));
    }

    public void b(boolean z10) {
        this.P = Boolean.valueOf(z10);
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "setConsent : " + z10, 1);
        com.ironsource.mediationsdk.c.b().b(z10);
        this.f13756l0.a(z10);
        rp.i().a(new kb(z10 ? 40 : 41, IronSourceUtils.getMediationAdditionalData(false)));
    }

    private boolean b(cr crVar) {
        return crVar != null && crVar.o();
    }

    public void a(long j10, cr.a aVar) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(B());
        try {
            mediationAdditionalData.put("duration", j10);
            mediationAdditionalData.put("sessionDepth", this.E);
            mediationAdditionalData.put(IronSourceConstants.EVENTS_EXT1, aVar.a());
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        rp.i().a(new kb(IronSourceConstants.INIT_COMPLETE, mediationAdditionalData));
    }

    private boolean b(h.b bVar) {
        synchronized (this.f13744f0) {
            if (this.f13752j0 != null) {
                return false;
            }
            this.f13744f0.put(bVar.c(), bVar);
            return true;
        }
    }

    public void a(Activity activity) {
        try {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "onPause()", 1);
            ContextProvider.getInstance().onPause(activity);
        } catch (Throwable th) {
            i9.d().a(th);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, "onPause()", th);
        }
    }

    private boolean b(List<IronSource.AD_UNIT> list, boolean z10, m8 m8Var) {
        IronLog.INTERNAL.verbose();
        try {
            this.f13751j.a(m8Var.b().g().d());
            this.f13773v = list;
            c(true);
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            IronSourceUtils.sendAutomationLog("init success");
            if (z10) {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                try {
                    mediationAdditionalData.put("revived", true);
                } catch (JSONException e10) {
                    i9.d().a(e10);
                    IronLog.INTERNAL.error(e10.toString());
                }
                rp.i().a(new kb(114, mediationAdditionalData));
            }
            int iB = m8Var.b().e().b();
            if (iB >= 0) {
                t8 t8Var = new t8();
                t8Var.a(iB);
                t8Var.a(iB, this.f13757m.k().d());
            }
            ji.i().h();
            rp.i().h();
            com.ironsource.mediationsdk.c.b().b(n(), o());
            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                if (this.f13777z.contains(ad_unit)) {
                    if (list.contains(ad_unit)) {
                        b(ad_unit);
                    } else {
                        a(ad_unit, false);
                    }
                }
            }
            if (x() && W()) {
                AdQualityBridge adQualityBridge = new AdQualityBridge(ContextProvider.getInstance().getApplicationContext(), n(), o(), new e1(), this.f13757m.c().b().g().a());
                this.f13762o0 = adQualityBridge;
                IronSourceSegment ironSourceSegment = this.C;
                if (ironSourceSegment != null) {
                    adQualityBridge.setSegment(ironSourceSegment);
                }
            }
            T();
            wm wmVarR = r();
            if (wmVarR != null) {
                wmVarR.a(this.f13757m);
            }
            return true;
        } catch (Exception e11) {
            i9.d().a(e11);
            IronLog.INTERNAL.error(e11.toString());
            wm wmVarR2 = r();
            if (wmVarR2 != null) {
                wmVarR2.onInitFailed(new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_POST_FAILED, "onInitSuccess() had failed"));
            }
            return false;
        }
    }

    @Override // com.ironsource.ca.a
    public synchronized void a(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        h.b bVarA = new h.c().b(str).a(activity).a(iSDemandOnlyBannerLayout).a(IronSource.AD_UNIT.BANNER).a();
        IronSourceError ironSourceErrorA = bVarA.a();
        if (ironSourceErrorA != null) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, ironSourceErrorA.getErrorMessage(), 3);
            if (iSDemandOnlyBannerLayout != null) {
                iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorA);
            }
            return;
        }
        IronSourceError ironSourceErrorA2 = a(s.c().a());
        if (ironSourceErrorA2 != null) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, ironSourceErrorA2.getErrorMessage(), 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorA2);
            return;
        }
        ContextProvider.getInstance().updateActivity(activity);
        if (a(bVarA)) {
            return;
        }
        if (!z()) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ErrorBuilder.buildInitFailedError("the server response does not contain banner data", "Banner"));
        } else {
            if (b(bVarA)) {
                return;
            }
            this.f13752j0.a(iSDemandOnlyBannerLayout, str);
        }
    }

    @Override // com.ironsource.ca.a
    public synchronized void a(@NotNull Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str, String str2) {
        h.b bVarA = new h.c().b(str).a(activity).a(true).a(str2).a(iSDemandOnlyBannerLayout).a(IronSource.AD_UNIT.BANNER).a();
        IronSourceError ironSourceErrorA = bVarA.a();
        if (ironSourceErrorA != null) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, ironSourceErrorA.getErrorMessage(), 3);
            if (iSDemandOnlyBannerLayout != null) {
                iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorA);
            }
            return;
        }
        IronSourceError ironSourceErrorA2 = a(s.c().a());
        if (ironSourceErrorA2 != null) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, ironSourceErrorA2.getErrorMessage(), 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorA2);
            return;
        }
        ContextProvider.getInstance().updateActivity(activity);
        if (a(bVarA)) {
            return;
        }
        if (!z()) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ErrorBuilder.buildInitFailedError("the server response does not contain banner data", "Banner"));
        } else {
            if (b(bVarA)) {
                return;
            }
            this.f13752j0.a(iSDemandOnlyBannerLayout, str, str2);
        }
    }

    @Override // com.ironsource.ca.b
    public synchronized void a(Activity activity, String str) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.INTERSTITIAL).b(), this.f13768r0.a(str));
    }

    @Override // com.ironsource.ca.c
    public synchronized void a(Activity activity, String str, String str2) {
        a(new h.c().b(str).a(str2).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(true).a(IronSource.AD_UNIT.REWARDED_VIDEO).b(), this.f13770s0.a(str));
    }

    public synchronized void a(Context context, String str, boolean z10, InitializationListener initializationListener, IronSource.AD_UNIT... ad_unitArr) {
        if (a(context, str, z10, initializationListener, null, ad_unitArr) == null) {
            s.c().a(this);
            s.c().a(this.f13754k0);
            s.c().a(context, str, this.f13761o, ad_unitArr);
        }
    }

    @Override // com.ironsource.ca
    public synchronized void a(Context context, String str, IronSource.AD_UNIT... ad_unitArr) {
        List<IronSource.AD_UNIT> listA = a(context, str, true, ad_unitArr);
        if (!listA.isEmpty()) {
            a(context, str, true, (InitializationListener) null, (IronSource.AD_UNIT[]) listA.toArray(new IronSource.AD_UNIT[listA.size()]));
        }
    }

    @Override // com.ironsource.ui
    public void a(Context context, boolean z10) {
        this.f13775x = context;
        this.f13776y = Boolean.valueOf(z10);
        xh xhVar = this.S;
        if (xhVar != null) {
            xhVar.a(context, z10);
        }
        if (this.f13734a0) {
            kp kpVar = this.T;
            if (kpVar != null) {
                kpVar.a(context, z10);
                return;
            }
            return;
        }
        se seVar = this.Q;
        if (seVar != null) {
            seVar.a(context, z10);
        }
    }

    private void a(a4 a4Var, Context context, cr crVar) {
        ji.i().a(a4Var.c(), context);
        ji.i().b(a4Var.d(), context);
        ji.i().b(a4Var.f());
        ji.i().a(a4Var.e());
        ji.i().c(a4Var.a());
        ji.i().c(a4Var.i(), context);
        ji.i().a(a4Var.h(), context);
        ji.i().b(a4Var.j(), context);
        ji.i().d(a4Var.g(), context);
        ji.i().a(crVar.c().b().i());
        ji.i().a(a4Var.k());
        ji.i().d(a4Var.b());
    }

    private void a(cr crVar) {
        this.f13751j.setDebugLevel(crVar.c().b().g().b());
        this.f13747h.setLoggerDebugLevel("console", crVar.c().b().g().a());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.ironsource.cr r8, android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(com.ironsource.cr, android.content.Context):void");
    }

    private void a(d4 d4Var) {
        ja jaVar = ja.f12717a;
        jaVar.c(d4Var.g());
        jaVar.a(d4Var.f());
        jaVar.a(d4Var.j());
        this.f13743f.a(d4Var);
    }

    private void a(IronSource.AD_UNIT ad_unit) {
        String str = ad_unit + " ad unit has already been initialized";
        this.f13747h.log(IronSourceLogger.IronSourceTag.API, str, 3);
        IronSourceUtils.sendAutomationLog(str);
    }

    public void a(IronSource.AD_UNIT ad_unit, WaterfallConfiguration waterfallConfiguration) {
        if (ad_unit == null) {
            IronLog.API.error("AdUnit should not be null.");
            return;
        }
        IronLog ironLog = IronLog.API;
        Object[] objArr = new Object[2];
        objArr[0] = ad_unit.name();
        objArr[1] = waterfallConfiguration == null ? "NULL" : waterfallConfiguration.toString();
        ironLog.info(String.format("(%s, %s)", objArr));
        kb kbVar = new kb(53, IronSourceUtils.getMediationAdditionalData(false));
        kbVar.a(IronSourceConstants.EVENTS_EXT1, waterfallConfiguration == null ? "" : waterfallConfiguration.toJsonString());
        rp.i().a(kbVar, ad_unit);
        this.f13756l0.a(ad_unit, waterfallConfiguration);
    }

    public void a(IronSource.AD_UNIT ad_unit, @Nullable ts tsVar) {
        z5 z5Var;
        kp kpVar;
        xh xhVar;
        if (this.f13760n0) {
            if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL && (xhVar = this.S) != null) {
                xhVar.a(tsVar);
            }
            if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO && (kpVar = this.T) != null) {
                kpVar.a(tsVar);
            }
            if (ad_unit != IronSource.AD_UNIT.BANNER || (z5Var = this.U) == null) {
                return;
            }
            z5Var.a(tsVar);
        }
    }

    private void a(IronSource.AD_UNIT ad_unit, boolean z10) {
        ConcurrentHashMap concurrentHashMap;
        int i10 = b.f13779a[ad_unit.ordinal()];
        if (i10 == 1) {
            if (!this.F) {
                if (this.Y) {
                    if (this.Z) {
                        this.Z = false;
                        n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                        return;
                    }
                    return;
                }
                if (z10 || L() || this.A.contains(ad_unit)) {
                    to.a().a(false, (AdInfo) null);
                    return;
                }
                return;
            }
            Iterator<h.d> it = this.f13746g0.values().iterator();
            while (it.hasNext()) {
                String strC = it.next().c();
                this.f13770s0.a(strC).onRewardedVideoAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            concurrentHashMap = this.f13746g0;
        } else if (i10 != 2) {
            if (i10 != 3) {
                return;
            }
            if (!this.H) {
                if (this.M.booleanValue()) {
                    this.M = Boolean.FALSE;
                    n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(602, "init() had failed"));
                    this.N = null;
                    this.O = null;
                    return;
                }
                return;
            }
            for (h.b bVar : this.f13744f0.values()) {
                ISDemandOnlyBannerLayout iSDemandOnlyBannerLayoutG = bVar.g();
                if (iSDemandOnlyBannerLayoutG != null) {
                    iSDemandOnlyBannerLayoutG.getListener().a(bVar.c(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Banner"));
                }
            }
            concurrentHashMap = this.f13744f0;
        } else {
            if (!this.G) {
                if (this.f13736b0) {
                    this.f13736b0 = false;
                    n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                    return;
                }
                return;
            }
            Iterator<h.d> it2 = this.f13742e0.values().iterator();
            while (it2.hasNext()) {
                String strC2 = it2.next().c();
                this.f13768r0.a(strC2).onInterstitialAdLoadFailed(strC2, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Interstitial"));
            }
            concurrentHashMap = this.f13742e0;
        }
        concurrentHashMap.clear();
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        z5 z5Var;
        this.f13747h.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            if (!this.f13738c0 || (z5Var = this.U) == null) {
                w wVar = this.R;
                if (wVar != null) {
                    wVar.a(ironSourceBannerLayout);
                }
            } else {
                z5Var.a(ironSourceBannerLayout);
            }
        } catch (Throwable th) {
            i9.d().a(th);
            this.f13747h.logException(IronSourceLogger.IronSourceTag.API, "destroyBanner()", th);
        }
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        IronLog.INTERNAL.verbose("placementName = " + str);
        if (this.H) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildInitFailedError("Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", "Banner"));
            return;
        }
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            StringBuilder sb = new StringBuilder();
            sb.append("loadBanner can't be called - ");
            sb.append(ironSourceBannerLayout == null ? "banner layout is null " : "banner layout is destroyed");
            String string = sb.toString();
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, string, 3);
            n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildLoadFailedError(string));
            return;
        }
        if (!this.K) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadBanner()", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildLoadFailedError("init() must be called before loadBanner()"));
            return;
        }
        if (ironSourceBannerLayout.getSize().getDescription().equals("CUSTOM") && (ironSourceBannerLayout.getSize().getWidth() <= 0 || ironSourceBannerLayout.getSize().getHeight() <= 0)) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "loadBanner: Unsupported banner size. Height and width must be bigger than 0", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.unsupportedBannerSize(""));
            return;
        }
        s.d dVarA = s.c().a();
        if (dVarA == s.d.INIT_FAILED) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(600, "Init() had failed"));
            return;
        }
        if (dVarA == s.d.INIT_IN_PROGRESS) {
            if (s.c().d()) {
                this.f13747h.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(601, "Init() had failed"));
                return;
            } else {
                this.N = ironSourceBannerLayout;
                this.M = Boolean.TRUE;
                this.O = str;
                return;
            }
        }
        if (!z()) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(IronSourceError.ERROR_BN_LOAD_NO_CONFIG, "the server response does not contain banner data"));
            return;
        }
        w wVar = this.R;
        if (wVar == null && this.U == null) {
            this.N = ironSourceBannerLayout;
            this.M = Boolean.TRUE;
            this.O = str;
        } else if (this.f13738c0) {
            this.U.a(ironSourceBannerLayout, new Placement(k(str)));
        } else {
            wVar.a(ironSourceBannerLayout, k(str));
        }
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.C = ironSourceSegment;
        kp kpVar = this.T;
        if (kpVar != null) {
            kpVar.a(ironSourceSegment);
        }
        se seVar = this.Q;
        if (seVar != null) {
            seVar.a(ironSourceSegment);
        }
        xh xhVar = this.S;
        if (xhVar != null) {
            xhVar.a(ironSourceSegment);
        }
        w wVar = this.R;
        if (wVar != null) {
            wVar.a(ironSourceSegment);
        }
        z5 z5Var = this.U;
        if (z5Var != null) {
            z5Var.a(ironSourceSegment);
        }
        AdQualityBridge adQualityBridge = this.f13762o0;
        if (adQualityBridge != null) {
            adQualityBridge.setSegment(ironSourceSegment);
        }
        ji.i().a(this.C);
        rp.i().a(this.C);
        zn.P.a(this.C);
    }

    @Override // com.ironsource.ca.b
    public void a(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        this.f13768r0.a(iSDemandOnlyInterstitialListener);
    }

    @Override // com.ironsource.ca.c
    public void a(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        this.f13770s0.a(iSDemandOnlyRewardedVideoListener);
    }

    private synchronized void a(h.d dVar, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        String strC = dVar.c();
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + strC);
        try {
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.API.error(th.getMessage());
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, new IronSourceError(510, th.getMessage()));
        }
        if (!this.J) {
            ironLog.error("initISDemandOnly() must be called before loadISDemandOnlyInterstitial()");
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, new IronSourceError(510, "initISDemandOnly() must be called before loadISDemandOnlyInterstitial()"));
            return;
        }
        if (!this.G) {
            ironLog.error("Interstitial was initialized in mediation mode. Use loadInterstitial instead");
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, new IronSourceError(510, "Interstitial was initialized in mediation mode. Use loadInterstitial instead"));
            return;
        }
        s.d dVarA = s.c().a();
        if (dVarA == s.d.INIT_FAILED) {
            ironLog.error("init() had failed");
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            return;
        }
        IronSourceError ironSourceErrorA = dVar.a();
        if (ironSourceErrorA != null) {
            if (ironSourceErrorA.getErrorCode() == 1060) {
                b(IronSourceConstants.TROUBLESHOOTING_DO_CALLED_IS_LOAD_WITH_NO_ACTIVITY, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
            }
            ironLog.error(ironSourceErrorA.toString());
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, ironSourceErrorA);
            return;
        }
        e(dVar.e());
        if (dVarA == s.d.INIT_IN_PROGRESS) {
            if (s.c().d()) {
                ironLog.error("init() had failed");
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            } else {
                synchronized (this.f13742e0) {
                    this.f13742e0.put(dVar.c(), dVar);
                }
                if (!TextUtils.isEmpty(dVar.c())) {
                    a(83003, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
                }
            }
            return;
        }
        if (!E()) {
            ironLog.error("No interstitial configurations found");
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
            return;
        }
        synchronized (this.f13742e0) {
            com.ironsource.mediationsdk.demandOnly.f fVar = this.f13748h0;
            if (fVar != null) {
                fVar.a(dVar);
                return;
            }
            this.f13742e0.put(dVar.c(), dVar);
            if (!TextUtils.isEmpty(dVar.b())) {
                a(83003, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
            }
            return;
        }
    }

    void a(h.d dVar, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        String strC = dVar.c();
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + strC);
        try {
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.API.error(th.getMessage());
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, new IronSourceError(510, th.getMessage()));
        }
        if (!this.I) {
            ironLog.error("initISDemandOnly() must be called before loadDemandOnlyRewardedVideo()");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, new IronSourceError(510, "initISDemandOnly() must be called before loadDemandOnlyRewardedVideo()"));
            return;
        }
        if (!this.F) {
            ironLog.error("Rewarded video was initialized in mediation mode");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, new IronSourceError(510, "Rewarded video was initialized in mediation mode"));
            return;
        }
        s.d dVarA = s.c().a();
        if (dVarA == s.d.INIT_FAILED) {
            ironLog.error("init() had failed");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        IronSourceError ironSourceErrorA = dVar.a();
        if (ironSourceErrorA != null) {
            if (ironSourceErrorA.getErrorCode() == 1060) {
                b(81321, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
            }
            ironLog.error(ironSourceErrorA.toString());
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, ironSourceErrorA);
            return;
        }
        e(dVar.e());
        if (dVarA == s.d.INIT_IN_PROGRESS) {
            if (s.c().d()) {
                ironLog.error("init() had failed");
                iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            synchronized (this.f13746g0) {
                this.f13746g0.put(strC, dVar);
            }
            if (TextUtils.isEmpty(dVar.b())) {
                return;
            }
            b(IronSourceConstants.TROUBLESHOOTING_DO_IAB_RV_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
            return;
        }
        if (!M()) {
            ironLog.error("No rewarded video configurations found");
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        synchronized (this.f13746g0) {
            com.ironsource.mediationsdk.demandOnly.k kVar = this.f13750i0;
            if (kVar != null) {
                kVar.a(dVar);
                return;
            }
            this.f13746g0.put(strC, dVar);
            if (!TextUtils.isEmpty(dVar.b())) {
                b(IronSourceConstants.TROUBLESHOOTING_DO_IAB_RV_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.b()), 1));
            }
            return;
        }
        i9.d().a(th);
        IronLog.API.error(th.getMessage());
        iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, new IronSourceError(510, th.getMessage()));
    }

    @Override // com.ironsource.tg
    public void a(@NotNull ImpressionDataListener impressionDataListener) {
        if (aj.a((Object) impressionDataListener, "removeImpressionDataListener - listener is null")) {
            lj.b().b(impressionDataListener);
            se seVar = this.Q;
            if (seVar != null) {
                seVar.a(impressionDataListener);
            }
            w wVar = this.R;
            if (wVar != null) {
                wVar.a(impressionDataListener);
            }
            IronLog.API.info("remove impression data listener from " + impressionDataListener.getClass().getSimpleName());
        }
    }

    @Override // com.ironsource.al
    public void a(LogListener logListener) {
        if (logListener == null) {
            this.f13747h.log(IronSourceLogger.IronSourceTag.API, "setLogListener(LogListener:null)", 1);
            return;
        }
        this.f13751j.a(logListener);
        this.f13747h.log(IronSourceLogger.IronSourceTag.API, "setLogListener(LogListener:" + logListener.getClass().getSimpleName() + ")", 1);
    }

    public void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        IronLog.API.info();
        gf.a().a(levelPlayInterstitialListener);
    }

    public void a(LevelPlayRewardedVideoListener levelPlayRewardedVideoListener) {
        IronLog.API.info();
        to.a().a(levelPlayRewardedVideoListener);
    }

    public synchronized void a(LevelPlayRewardedVideoManualListener levelPlayRewardedVideoManualListener) {
        String str;
        IronLog ironLog = IronLog.API;
        ironLog.info();
        if (!this.I) {
            if (levelPlayRewardedVideoManualListener == null) {
                this.Y = false;
                str = "Disabling rewarded video manual mode";
            } else {
                this.Y = true;
                str = "Enabling rewarded video manual mode";
            }
            ironLog.info(str);
        }
        to.a().a(levelPlayRewardedVideoManualListener);
    }

    void a(SegmentListener segmentListener) {
        rk rkVar = this.f13749i;
        if (rkVar != null) {
            rkVar.a(segmentListener);
            s.c().a(this.f13749i);
        }
    }

    private synchronized void a(wm wmVar) {
        this.W = wmVar;
    }

    @Override // com.ironsource.ca.c
    public synchronized void a(String str) {
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + str);
        ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListenerA = this.f13770s0.a(str);
        try {
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.API.error(e10.getMessage());
            if (iSDemandOnlyRewardedVideoListenerA != null) {
                iSDemandOnlyRewardedVideoListenerA.onRewardedVideoAdShowFailed(str, new IronSourceError(510, e10.getMessage()));
            }
        }
        if (!this.F) {
            ironLog.error("Rewarded video was initialized in mediation mode. Use showRewardedVideo instead");
            iSDemandOnlyRewardedVideoListenerA.onRewardedVideoAdShowFailed(str, new IronSourceError(508, "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead"));
            return;
        }
        com.ironsource.mediationsdk.demandOnly.k kVar = this.f13750i0;
        if (kVar != null) {
            kVar.b(str);
        } else {
            ironLog.error("Rewarded video was not initiated");
            iSDemandOnlyRewardedVideoListenerA.onRewardedVideoAdShowFailed(str, new IronSourceError(508, "Rewarded video was not initiated"));
        }
    }

    private void a(String str, l8 l8Var) {
        if (a(str, 1, 128)) {
            return;
        }
        l8Var.a(ErrorBuilder.buildInvalidKeyValueError(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, "dynamicUserId is invalid, should be between 1-128 chars in length."));
    }

    public void a(String str, List<String> list) {
        IronLog ironLog = IronLog.API;
        ironLog.verbose("key = " + str + ", values = " + list.toString());
        String strCheckMetaDataKeyValidity = MetaDataUtils.checkMetaDataKeyValidity(str);
        String strCheckMetaDataValueValidity = MetaDataUtils.checkMetaDataValueValidity(list);
        if (strCheckMetaDataKeyValidity.length() > 0) {
            ironLog.verbose(strCheckMetaDataKeyValidity);
            return;
        }
        if (strCheckMetaDataValueValidity.length() > 0) {
            ironLog.verbose(strCheckMetaDataValueValidity);
            return;
        }
        MetaData metaData = MetaDataUtils.formatMetaData(str, list);
        String metaDataKey = metaData.getMetaDataKey();
        List<String> metaDataValue = metaData.getMetaDataValue();
        if (!MetaDataUtils.isMediationOnlyKey(metaDataKey)) {
            com.ironsource.mediationsdk.c.b().a(metaDataKey, metaDataValue);
        } else if (C() && MetaDataUtils.isMediationKeysBeforeInit(metaDataKey)) {
            ironLog.error("setMetaData with key = " + metaDataKey + " must to be called before init");
        } else {
            lj.b().a(metaDataKey, metaDataValue);
        }
        try {
            ConcurrentHashMap<String, List<String>> concurrentHashMapC = com.ironsource.mediationsdk.c.b().c();
            concurrentHashMapC.putAll(lj.b().c());
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, List<String>> entry : concurrentHashMapC.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.f13758m0.a(jSONObject);
            this.f13756l0.a(jSONObject);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("got the following error " + e10.getMessage());
        }
        rp.i().a(new kb(C() ? 51 : 50, IronSourceUtils.getJsonForMetaData(str, list, metaDataValue)));
    }

    public void a(String str, JSONObject jSONObject) {
        if (aj.a((Object) jSONObject, "setAdRevenueData - impressionData is null") && aj.a((Object) str, "setAdRevenueData - dataSource is null")) {
            this.f13754k0.a(str, jSONObject);
        }
    }

    @Override // com.ironsource.en
    public void a(List<IronSource.AD_UNIT> list, boolean z10, m8 m8Var) {
        b(list, z10, m8Var);
    }

    @Override // com.ironsource.ui
    public void a(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return;
                }
                this.f13747h.log(IronSourceLogger.IronSourceTag.API, this.f13733a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", 1);
                this.f13767r = new HashMap(map);
            } catch (Exception e10) {
                i9.d().a(e10);
                this.f13747h.logException(IronSourceLogger.IronSourceTag.API, this.f13733a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", e10);
            }
        }
    }

    private void a(JSONObject jSONObject, Object[][] objArr) {
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObject.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IronSourceObject addToDictionary: " + Log.getStackTraceString(e10), 3);
            }
        }
    }

    @Override // com.ironsource.ui
    public void a(boolean z10) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "setAdaptersDebug : " + z10, 1);
        com.ironsource.mediationsdk.c.b().a(z10);
    }

    private void a(boolean z10, String str) {
        if (z10) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.F, true, this.f13740d0);
            if (str != null) {
                a(mediationAdditionalData, new Object[][]{new Object[]{"placement", str}});
            }
            b(IronSourceConstants.RV_API_IS_CAPPED_TRUE, mediationAdditionalData);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(boolean r6, boolean r7, int r8, org.json.JSONObject r9, boolean r10) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L63
            r0.<init>()     // Catch: java.lang.Exception -> L63
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L25
            java.lang.String r6 = ",Activity=%s"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L63
            com.ironsource.environment.ContextProvider r4 = com.ironsource.environment.ContextProvider.getInstance()     // Catch: java.lang.Exception -> L63
            android.app.Activity r4 = r4.getCurrentActiveActivity()     // Catch: java.lang.Exception -> L63
            if (r4 == 0) goto L19
            r4 = r2
            goto L1a
        L19:
            r4 = r1
        L1a:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Exception -> L63
            r3[r1] = r4     // Catch: java.lang.Exception -> L63
            java.lang.String r6 = java.lang.String.format(r6, r3)     // Catch: java.lang.Exception -> L63
            goto L2e
        L25:
            if (r6 != 0) goto L31
            java.lang.String r6 = ","
            r0.append(r6)     // Catch: java.lang.Exception -> L63
            java.lang.String r6 = "init_context_flow"
        L2e:
            r0.append(r6)     // Catch: java.lang.Exception -> L63
        L31:
            java.lang.String r6 = ",cachedUserAgent=%s"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L63
            com.ironsource.ce r4 = r5.f13737c     // Catch: java.lang.Exception -> L63
            boolean r4 = r4.q()     // Catch: java.lang.Exception -> L63
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Exception -> L63
            r3[r1] = r4     // Catch: java.lang.Exception -> L63
            java.lang.String r6 = java.lang.String.format(r6, r3)     // Catch: java.lang.Exception -> L63
            r0.append(r6)     // Catch: java.lang.Exception -> L63
            java.lang.String r6 = "ext1"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L63
            r9.put(r6, r0)     // Catch: java.lang.Exception -> L63
            java.lang.String r6 = "sessionDepth"
            r9.put(r6, r8)     // Catch: java.lang.Exception -> L63
            if (r10 == 0) goto L74
            if (r7 == 0) goto L5d
            java.lang.String r6 = "isMultipleAdObjects"
            goto L5f
        L5d:
            java.lang.String r6 = "isMultipleAdUnits"
        L5f:
            r9.put(r6, r2)     // Catch: java.lang.Exception -> L63
            goto L74
        L63:
            r6 = move-exception
            com.ironsource.i9 r7 = com.ironsource.i9.d()
            r7.a(r6)
            com.ironsource.mediationsdk.logger.IronLog r7 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r6 = r6.toString()
            r7.error(r6)
        L74:
            com.ironsource.kb r6 = new com.ironsource.kb
            r7 = 14
            r6.<init>(r7, r9)
            com.ironsource.rp r7 = com.ironsource.rp.i()
            r7.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.p.a(boolean, boolean, int, org.json.JSONObject, boolean):void");
    }

    private synchronized void a(boolean z10, boolean z11, boolean z12, IronSource.AD_UNIT... ad_unitArr) {
        JSONObject mediationAdditionalData;
        int i10 = 0;
        for (IronSource.AD_UNIT ad_unit : ad_unitArr) {
            if (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                this.J = true;
            } else if (ad_unit.equals(IronSource.AD_UNIT.BANNER)) {
                this.K = true;
            } else if (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                this.I = true;
            } else if (ad_unit.equals(IronSource.AD_UNIT.NATIVE_AD)) {
                this.L = true;
            }
        }
        if (s.c().a() == s.d.INIT_FAILED) {
            try {
                if (this.f13749i != null) {
                    int length = ad_unitArr.length;
                    while (i10 < length) {
                        IronSource.AD_UNIT ad_unit2 = ad_unitArr[i10];
                        if (!this.f13777z.contains(ad_unit2)) {
                            a(ad_unit2, true);
                        }
                        i10++;
                    }
                }
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }
        if (!C()) {
            mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z11);
            int length2 = ad_unitArr.length;
            while (i10 < length2) {
                IronSource.AD_UNIT ad_unit3 = ad_unitArr[i10];
                if (this.f13777z.contains(ad_unit3)) {
                    this.f13747h.log(IronSourceLogger.IronSourceTag.API, ad_unit3 + " ad unit has started initializing.", 3);
                } else {
                    this.f13777z.add(ad_unit3);
                    this.A.add(ad_unit3);
                    try {
                        mediationAdditionalData.put(ad_unit3.toString(), true);
                    } catch (Exception e11) {
                        i9.d().a(e11);
                        IronLog.INTERNAL.error(e11.toString());
                    }
                }
                i10++;
            }
            JSONObject jSONObject = mediationAdditionalData;
            int i11 = 1 + this.E;
            this.E = i11;
            a(z10, z11, i11, jSONObject, z12);
        } else {
            if (this.f13773v == null) {
                return;
            }
            try {
                new fl().a(this.f13757m.c().b().d().b(), B());
            } catch (Exception e12) {
                i9.d().a(e12);
                IronLog.INTERNAL.error(e12.toString());
            }
            mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z11);
            for (IronSource.AD_UNIT ad_unit4 : ad_unitArr) {
                if (this.f13777z.contains(ad_unit4)) {
                    a(ad_unit4);
                } else {
                    this.f13777z.add(ad_unit4);
                    this.A.add(ad_unit4);
                    try {
                        mediationAdditionalData.put(ad_unit4.toString(), true);
                    } catch (Exception e13) {
                        i9.d().a(e13);
                        IronLog.INTERNAL.error(e13.toString());
                    }
                    List<IronSource.AD_UNIT> list = this.f13773v;
                    if (list == null || !list.contains(ad_unit4)) {
                        a(ad_unit4, false);
                    } else {
                        b(ad_unit4);
                    }
                }
            }
            JSONObject jSONObject2 = mediationAdditionalData;
            int i112 = 1 + this.E;
            this.E = i112;
            a(z10, z11, i112, jSONObject2, z12);
        }
    }

    boolean a(b7 b7Var) {
        return this.f13741e.b(ContextProvider.getInstance().getApplicationContext(), b7Var, IronSource.AD_UNIT.BANNER);
    }

    private boolean a(h.b bVar) {
        if (s.c().a() != s.d.INIT_IN_PROGRESS) {
            return false;
        }
        synchronized (this.f13744f0) {
            this.f13744f0.put(bVar.c(), bVar);
        }
        return true;
    }

    private boolean a(String str, int i10, int i11) {
        return str != null && str.length() >= i10 && str.length() <= i11;
    }

    public boolean a(boolean z10, cr crVar) {
        if (C()) {
            return true;
        }
        synchronized (this.f13755l) {
            this.f13757m = crVar;
        }
        return b(crVar.g(), z10, crVar.c());
    }
}
