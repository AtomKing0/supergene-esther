package com.ironsource;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.l0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.ng;
import com.ironsource.qf;
import com.ironsource.sdk.controller.FeaturesManager;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.v8;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class qi implements xp, p9, o9, m9, n9, wi, gn {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f14494l = "IronSourceAdsPublisherAgent";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static qi f14495m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ironsource.sdk.controller.e f14496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ia f14499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private hm f14500e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private y8 f14502g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14501f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FeaturesManager f14503h = FeaturesManager.getInstance();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ng.a f14504i = el.I().g();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private l0.a f14505j = el.I().A();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private l0 f14506k = el.N().B();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ha f14509c;

        a(String str, String str2, ha haVar) {
            this.f14507a = str;
            this.f14508b = str2;
            this.f14509c = haVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            qi.this.f14496a.a(this.f14507a, this.f14508b, this.f14509c, (p9) qi.this);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f14511a;

        b(JSONObject jSONObject) {
            this.f14511a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            qi.this.f14496a.a(this.f14511a, (p9) qi.this);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ha f14515c;

        c(String str, String str2, ha haVar) {
            this.f14513a = str;
            this.f14514b = str2;
            this.f14515c = haVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            qi.this.f14496a.a(this.f14513a, this.f14514b, this.f14515c, (o9) qi.this);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14517a;

        d(String str) {
            this.f14517a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            qi.this.f14496a.a(this.f14517a, qi.this);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f14519a;

        e(JSONObject jSONObject) {
            this.f14519a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            qi.this.f14496a.a(this.f14519a, (o9) qi.this);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ mi f14521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f14522b;

        f(mi miVar, Map map) {
            this.f14521a = miVar;
            this.f14522b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            qf.e eVar = this.f14521a.i() ? qf.e.Banner : qf.e.Interstitial;
            ha haVarA = qi.this.f14499d.a(eVar, this.f14521a);
            sf sfVar = new sf();
            sfVar.a(nb.f14126x, Boolean.valueOf(this.f14521a.j())).a(nb.G, Boolean.valueOf(this.f14521a.m())).a(nb.f14124v, this.f14521a.g()).a(nb.f14125w, xi.a(this.f14521a)).a(nb.I, Long.valueOf(i0.f12521a.b(this.f14521a.e())));
            xf.a(vp.f15940h, sfVar.a());
            if (eVar == qf.e.Banner) {
                qi.this.f14496a.a(qi.this.f14497b, qi.this.f14498c, haVarA, (n9) qi.this);
                qi.this.f14496a.a(haVarA, this.f14522b, (n9) qi.this);
            } else {
                qi.this.f14496a.a(qi.this.f14497b, qi.this.f14498c, haVarA, (o9) qi.this);
                qi.this.f14496a.b(haVarA, this.f14522b, qi.this);
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ha f14524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f14525b;

        g(ha haVar, Map map) {
            this.f14524a = haVar;
            this.f14525b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            qi.this.f14496a.a(this.f14524a, this.f14525b, (o9) qi.this);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ mi f14527a;

        h(mi miVar) {
            this.f14527a = miVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            qf.e eVar = this.f14527a.i() ? qf.e.Banner : qf.e.Interstitial;
            ha haVarA = qi.this.f14499d.a(eVar, this.f14527a);
            sf sfVar = new sf();
            sfVar.a(nb.f14126x, Boolean.valueOf(this.f14527a.j())).a(nb.f14124v, this.f14527a.g()).a(nb.f14125w, xi.a(this.f14527a)).a("isMultipleAdObjects", Boolean.valueOf(this.f14527a.l()));
            xf.a(vp.f15945m, sfVar.a());
            if (eVar == qf.e.Banner) {
                qi.this.f14496a.a(haVarA);
            } else {
                haVarA.a(false);
                qi.this.f14496a.b(haVarA);
            }
        }
    }

    private qi(Context context, int i10) {
        b(context);
    }

    private bn a(ha haVar) {
        if (haVar == null) {
            return null;
        }
        return (bn) haVar.i();
    }

    private dn b(ha haVar) {
        if (haVar == null) {
            return null;
        }
        return (dn) haVar.i();
    }

    private in c(ha haVar) {
        if (haVar == null) {
            return null;
        }
        return (in) haVar.i();
    }

    private ha d(qf.e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f14499d.a(eVar, str);
    }

    @Override // com.ironsource.o9
    public void onInterstitialAdRewarded(String str, int i10) {
        ha haVarD = d(qf.e.Interstitial, str);
        dn dnVarB = b(haVarD);
        if (haVarD == null || dnVarB == null) {
            return;
        }
        dnVarB.onInterstitialAdRewarded(str, i10);
    }

    @Override // com.ironsource.xp, com.ironsource.wi
    public void onPause(Activity activity) {
        if (this.f14501f) {
            return;
        }
        b(activity);
    }

    @Override // com.ironsource.xp, com.ironsource.wi
    public void onResume(Activity activity) {
        if (this.f14501f) {
            return;
        }
        c(activity);
    }

    qi(String str, String str2, Context context) {
        this.f14497b = str;
        this.f14498c = str2;
        b(context);
    }

    public static synchronized qi a(Context context) throws Exception {
        return a(context, 0);
    }

    public static synchronized qi a(Context context, int i10) throws Exception {
        Logger.i(f14494l, "getInstance()");
        if (f14495m == null) {
            f14495m = new qi(context, i10);
        }
        return f14495m;
    }

    @Override // com.ironsource.gn
    public void b(Activity activity) {
        try {
            this.f14496a.d();
            this.f14496a.a((Context) activity);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    @Override // com.ironsource.gn
    public void c(Activity activity) {
        this.f14502g.a(activity);
        this.f14496a.f();
        this.f14496a.b(activity);
    }

    @Override // com.ironsource.p9
    public void d(String str, String str2) {
        in inVarC;
        ha haVarD = d(qf.e.RewardedVideo, str);
        if (haVarD == null || (inVarC = c(haVarD)) == null) {
            return;
        }
        inVarC.a(str2);
    }

    private void c(mi miVar, Map<String, String> map) {
        try {
            map = a(map);
        } catch (Exception e10) {
            i9.d().a(e10);
            sf sfVarA = new sf().a(nb.A, e10.getMessage()).a(nb.f14126x, Boolean.valueOf(miVar.j())).a(nb.G, Boolean.valueOf(miVar.m())).a(nb.f14124v, miVar.g()).a(nb.f14125w, xi.a(miVar)).a(nb.I, Long.valueOf(i0.f12521a.b(miVar.e())));
            i0.f12521a.a(miVar.e());
            xf.a(vp.f15943k, sfVarA.a());
            IronLog.INTERNAL.error(e10.toString());
            Logger.d(f14494l, "loadInAppBiddingAd failed decoding  ADM " + e10.getMessage());
        }
        b(miVar, map);
    }

    @Override // com.ironsource.wi
    public com.ironsource.sdk.controller.e a() {
        return this.f14496a;
    }

    @Override // com.ironsource.yi
    public void b(Activity activity, mi miVar, Map<String, String> map) {
        this.f14502g.a(activity);
        a(miVar, map);
    }

    private void b(Context context) {
        try {
            JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
            dj.a(context);
            IronSourceStorageUtils.initializeCacheDirectory(context, new hs(SDKUtils.getNetworkConfiguration().optJSONObject(v8.a.f15683j)));
            dj.e().d(SDKUtils.getSDKVersion());
            this.f14499d = new ia();
            y8 y8Var = new y8();
            this.f14502g = y8Var;
            if (context instanceof Activity) {
                y8Var.a((Activity) context);
            }
            int debugMode = this.f14503h.getDebugMode();
            this.f14500e = new hm();
            this.f14496a = new com.ironsource.sdk.controller.e(context, this.f14502g, this.f14499d, ve.f15889a, debugMode, this.f14503h.getDataManagerConfig(), this.f14497b, this.f14498c, this.f14500e);
            Logger.enableLogging(debugMode);
            Logger.i(f14494l, "C'tor");
            a(context, networkConfiguration);
            this.f14500e.d();
            this.f14500e.e();
            this.f14500e.a(context);
            this.f14500e.b();
            this.f14500e.a();
            this.f14500e.b(context);
            this.f14500e.c();
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    @Override // com.ironsource.m9
    public void c(qf.e eVar, String str) {
        bn bnVarA;
        ha haVarD = d(eVar, str);
        if (haVarD != null) {
            if (eVar == qf.e.RewardedVideo) {
                in inVarC = c(haVarD);
                if (inVarC != null) {
                    inVarC.d();
                    return;
                }
                return;
            }
            if (eVar == qf.e.Interstitial) {
                dn dnVarB = b(haVarD);
                if (dnVarB != null) {
                    dnVarB.onInterstitialClick();
                    return;
                }
                return;
            }
            if (eVar != qf.e.Banner || (bnVarA = a(haVarD)) == null) {
                return;
            }
            bnVarA.onBannerClick();
        }
    }

    public static wi a(Context context, String str, String str2) {
        return a(str, str2, context);
    }

    @Override // com.ironsource.yi
    public void b(mi miVar) {
        Logger.d(f14494l, "destroyInstance " + miVar.e());
        if (c(miVar)) {
            this.f14505j.a(j1.DESTROYED, miVar.e());
            this.f14504i.a(new nr(this.f14506k.a(miVar.e())));
        }
        this.f14496a.a(new h(miVar));
    }

    @Override // com.ironsource.p9
    public void c(String str) {
        in inVarC;
        ha haVarD = d(qf.e.RewardedVideo, str);
        if (haVarD == null || (inVarC = c(haVarD)) == null) {
            return;
        }
        inVarC.b();
    }

    public static synchronized wi a(String str, String str2, Context context) {
        if (f14495m == null) {
            xf.a(vp.f15933a);
            f14495m = new qi(str, str2, context);
        }
        return f14495m;
    }

    private void b(mi miVar, Map<String, String> map) {
        Logger.d(f14494l, "loadOnNewInstance " + miVar.e());
        this.f14496a.a(new f(miVar, map));
    }

    @Override // com.ironsource.o9
    public void c(String str, String str2) {
        qf.e eVar = qf.e.Interstitial;
        ha haVarD = d(eVar, str);
        sf sfVar = new sf();
        sfVar.a(nb.A, str2).a(nb.f14124v, str);
        if (haVarD != null) {
            sf sfVarA = sfVar.a(nb.f14125w, yf.a(haVarD, eVar)).a(nb.f14127y, haVarD.e() == 2 ? nb.E : nb.F).a(nb.f14126x, Boolean.valueOf(yf.a(haVarD)));
            i0 i0Var = i0.f12521a;
            sfVarA.a(nb.I, Long.valueOf(i0Var.b(haVarD.h())));
            i0Var.a(haVarD.h());
            dn dnVarB = b(haVarD);
            if (dnVarB != null) {
                dnVarB.onInterstitialLoadFailed(str2);
            }
        }
        xf.a(vp.f15939g, sfVar.a());
    }

    private Map<String, String> a(Map<String, String> map) {
        map.put("adm", SDKUtils.decodeString(map.get("adm")));
        return map;
    }

    @Override // com.ironsource.m9
    public void b(qf.e eVar, String str) {
        in inVarC;
        ha haVarD = d(eVar, str);
        if (haVarD != null) {
            if (eVar == qf.e.Interstitial) {
                dn dnVarB = b(haVarD);
                if (dnVarB != null) {
                    dnVarB.onInterstitialOpen();
                    return;
                }
                return;
            }
            if (eVar != qf.e.RewardedVideo || (inVarC = c(haVarD)) == null) {
                return;
            }
            inVarC.a();
        }
    }

    @Override // com.ironsource.xp
    public void c(JSONObject jSONObject) {
        this.f14496a.a(new e(jSONObject));
    }

    @Override // com.ironsource.xp, com.ironsource.wi
    public void a(Activity activity) {
        try {
            Logger.i(f14494l, "release()");
            la.g();
            this.f14502g.b();
            this.f14496a.a((Context) activity);
            this.f14496a.destroy();
            this.f14496a = null;
        } catch (Exception e10) {
            i9.d().a(e10);
        }
        f14495m = null;
    }

    @Override // com.ironsource.o9
    public void b(String str) {
        ha haVarD = d(qf.e.Interstitial, str);
        if (haVarD != null) {
            mi miVarC = haVarD.c();
            this.f14505j.a(j1.SHOW_SUCCESS, miVarC.e());
            if (c(miVarC)) {
                this.f14504i.a(new rr(this.f14506k.a(miVarC.e())));
            }
            dn dnVarB = b(haVarD);
            if (dnVarB != null) {
                dnVarB.onInterstitialShowSuccess();
            }
        }
    }

    public boolean c(mi miVar) {
        return miVar.l() && !miVar.i() && a(miVar);
    }

    @Override // com.ironsource.yi
    public void a(Activity activity, mi miVar, Map<String, String> map) {
        this.f14502g.a(activity);
        Logger.i(f14494l, "showAd " + miVar.e());
        ha haVarA = this.f14499d.a(qf.e.Interstitial, miVar.e());
        if (haVarA == null) {
            return;
        }
        this.f14496a.a(new g(haVarA, map));
    }

    @Override // com.ironsource.o9
    public void b(String str, String str2) {
        ha haVarD = d(qf.e.Interstitial, str);
        if (haVarD != null) {
            mi miVarC = haVarD.c();
            this.f14505j.a(j1.SHOW_FAIL, miVarC.e());
            if (c(miVarC)) {
                this.f14504i.a(new qr(this.f14506k.a(miVarC.e())));
            }
            dn dnVarB = b(haVarD);
            if (dnVarB != null) {
                dnVarB.onInterstitialShowFailed(str2);
            }
        }
    }

    public void a(Context context, JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean(v8.a.f15679f, false);
        this.f14501f = zOptBoolean;
        if (zOptBoolean) {
            try {
                ((Application) context).registerActivityLifecycleCallbacks(new i(this));
            } catch (Throwable th) {
                i9.d().a(th);
                sf sfVar = new sf();
                sfVar.a(nb.f14127y, th.getMessage());
                xf.a(vp.f15953u, sfVar.a());
            }
        }
    }

    @Override // com.ironsource.xp
    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("demandSourceName");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        this.f14496a.a(new d(strOptString));
    }

    @Override // com.ironsource.yi
    public void a(mi miVar, Map<String, String> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        map.put(v8.h.f15828y0, String.valueOf(jCurrentTimeMillis));
        i0.f12521a.a(miVar.e(), jCurrentTimeMillis);
        sf sfVar = new sf();
        sfVar.a(nb.f14126x, Boolean.valueOf(miVar.j())).a(nb.G, Boolean.valueOf(miVar.m())).a(nb.f14124v, miVar.g()).a(nb.f14125w, xi.a(miVar)).a(nb.I, Long.valueOf(jCurrentTimeMillis));
        xf.a(vp.f15938f, sfVar.a());
        Logger.d(f14494l, "loadAd " + miVar.e());
        k0 k0Var = new k0(miVar);
        this.f14505j.a(k0Var);
        this.f14505j.a(new JSONObject(map), j1.LOAD_REQUEST, k0Var.c());
        if (c(miVar)) {
            this.f14504i.a(new or(k0Var));
        }
        if (miVar.k()) {
            c(miVar, map);
        } else {
            b(miVar, map);
        }
    }

    @Override // com.ironsource.m9
    public void a(qf.e eVar, String str) {
        dn dnVarB;
        ha haVarD = d(eVar, str);
        if (haVarD != null) {
            if (eVar == qf.e.RewardedVideo) {
                in inVarC = c(haVarD);
                if (inVarC != null) {
                    inVarC.c();
                    return;
                }
                return;
            }
            if (eVar != qf.e.Interstitial || (dnVarB = b(haVarD)) == null) {
                return;
            }
            dnVarB.onInterstitialClose();
        }
    }

    @Override // com.ironsource.m9
    public void a(qf.e eVar, String str, s2 s2Var) {
        bn bnVarA;
        ha haVarD = d(eVar, str);
        if (haVarD != null) {
            haVarD.b(2);
            if (eVar == qf.e.RewardedVideo) {
                in inVarC = c(haVarD);
                if (inVarC != null) {
                    inVarC.a(s2Var);
                    return;
                }
                return;
            }
            if (eVar == qf.e.Interstitial) {
                dn dnVarB = b(haVarD);
                if (dnVarB != null) {
                    dnVarB.onInterstitialInitSuccess();
                    return;
                }
                return;
            }
            if (eVar != qf.e.Banner || (bnVarA = a(haVarD)) == null) {
                return;
            }
            bnVarA.onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.m9
    public void a(qf.e eVar, String str, String str2) {
        bn bnVarA;
        ha haVarD = d(eVar, str);
        sf sfVarA = new sf().a(nb.f14124v, str).a(nb.f14125w, eVar).a(nb.A, str2);
        if (haVarD != null) {
            i0 i0Var = i0.f12521a;
            sfVarA.a(nb.I, Long.valueOf(i0Var.b(haVarD.h())));
            sfVarA.a(nb.f14126x, Boolean.valueOf(yf.a(haVarD)));
            i0Var.a(haVarD.h());
            haVarD.b(3);
            if (eVar == qf.e.RewardedVideo) {
                in inVarC = c(haVarD);
                if (inVarC != null) {
                    inVarC.b(str2);
                }
            } else if (eVar == qf.e.Interstitial) {
                dn dnVarB = b(haVarD);
                if (dnVarB != null) {
                    dnVarB.onInterstitialInitFailed(str2);
                }
            } else if (eVar == qf.e.Banner && (bnVarA = a(haVarD)) != null) {
                bnVarA.onBannerLoadFail(str2);
            }
        }
        xf.a(vp.f15941i, sfVarA.a());
    }

    @Override // com.ironsource.m9
    public void a(qf.e eVar, String str, String str2, JSONObject jSONObject) {
        bn bnVarA;
        ha haVarD = d(eVar, str);
        if (haVarD == null || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            Logger.i(f14494l, "Received Event Notification: " + str2 + " for demand source: " + haVarD.f());
            if (eVar == qf.e.Interstitial) {
                dn dnVarB = b(haVarD);
                if (dnVarB != null) {
                    jSONObject.put("demandSourceName", str);
                    dnVarB.onInterstitialEventNotificationReceived(str2, jSONObject);
                }
            } else if (eVar == qf.e.RewardedVideo) {
                in inVarC = c(haVarD);
                if (inVarC != null) {
                    jSONObject.put("demandSourceName", str);
                    inVarC.a(str2, jSONObject);
                }
            } else if (eVar == qf.e.Banner && (bnVarA = a(haVarD)) != null) {
                jSONObject.put("demandSourceName", str);
                if (str2.equalsIgnoreCase("impressions")) {
                    bnVarA.onBannerShowSuccess();
                }
            }
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    @Override // com.ironsource.p9
    public void a(String str, int i10) {
        in inVarC;
        ha haVarD = d(qf.e.RewardedVideo, str);
        if (haVarD == null || (inVarC = c(haVarD)) == null) {
            return;
        }
        inVarC.a(i10);
    }

    @Override // com.ironsource.n9
    public void a(String str, jf jfVar) {
        bn bnVarA;
        ha haVarD = d(qf.e.Banner, str);
        if (haVarD == null || (bnVarA = a(haVarD)) == null) {
            return;
        }
        bnVarA.onBannerLoadSuccess(haVarD.c(), jfVar);
    }

    @Override // com.ironsource.n9
    public void a(String str, String str2) {
        bn bnVarA;
        ha haVarD = d(qf.e.Banner, str);
        if (haVarD == null || (bnVarA = a(haVarD)) == null) {
            return;
        }
        bnVarA.onBannerLoadFail(str2);
    }

    @Override // com.ironsource.xp
    public void a(String str, String str2, int i10) {
        qf.e productType;
        ha haVarA;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (productType = SDKUtils.getProductType(str)) == null || (haVarA = this.f14499d.a(productType, str2)) == null) {
            return;
        }
        haVarA.c(i10);
    }

    @Override // com.ironsource.xp
    public void a(String str, String str2, String str3, Map<String, String> map, dn dnVar) {
        this.f14497b = str;
        this.f14498c = str2;
        this.f14496a.a(new c(str, str2, this.f14499d.a(qf.e.Interstitial, str3, map, dnVar)));
    }

    @Override // com.ironsource.xp
    public void a(String str, String str2, String str3, Map<String, String> map, in inVar) {
        this.f14497b = str;
        this.f14498c = str2;
        this.f14496a.a(new a(str, str2, this.f14499d.a(qf.e.RewardedVideo, str3, map, inVar)));
    }

    @Override // com.ironsource.o9
    public void a(String str, JSONObject jSONObject) {
        qf.e eVar = qf.e.Interstitial;
        ha haVarD = d(eVar, str);
        sf sfVarA = new sf().a(nb.f14124v, str);
        if (haVarD != null) {
            mi miVarC = haVarD.c();
            this.f14505j.a(jSONObject, j1.LOAD_SUCCESS, miVarC.e());
            if (c(miVarC)) {
                this.f14504i.a(new pr(this.f14506k.a(miVarC.e())));
            }
            sf sfVarA2 = sfVarA.a(nb.f14125w, yf.a(haVarD, eVar)).a(nb.f14126x, Boolean.valueOf(yf.a(haVarD)));
            i0 i0Var = i0.f12521a;
            sfVarA2.a(nb.I, Long.valueOf(i0Var.b(haVarD.h())));
            i0Var.a(haVarD.h());
            dn dnVarB = b(haVarD);
            if (dnVarB != null) {
                dnVarB.onInterstitialLoadSuccess(haVarD.c());
            }
        }
        xf.a(vp.f15944l, sfVarA.a());
    }

    @Override // com.ironsource.xp
    public void a(JSONObject jSONObject) {
        this.f14496a.a(new b(jSONObject));
    }

    @Override // com.ironsource.yi
    public boolean a(mi miVar) {
        Logger.d(f14494l, "isAdAvailable " + miVar.e());
        ha haVarA = this.f14499d.a(qf.e.Interstitial, miVar.e());
        if (haVarA == null) {
            return false;
        }
        return haVarA.d();
    }

    @Override // com.ironsource.xp
    public boolean a(String str) {
        return this.f14496a.a(str);
    }
}
