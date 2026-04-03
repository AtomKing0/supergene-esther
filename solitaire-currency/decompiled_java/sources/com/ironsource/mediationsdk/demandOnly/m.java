package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import com.ironsource.adapters.ironsource.IronSourceLoadParameters;
import com.ironsource.aj;
import com.ironsource.i9;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.v2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AbstractAdapter f13530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected v2 f13531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected JSONObject f13532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f13533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Timer f13534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f13535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f13536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected JSONObject f13537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected List<String> f13538i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f13539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f13540k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f13541l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final IronSource.AD_UNIT f13542m;

    protected enum a {
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS
    }

    public m(v2 v2Var, AbstractAdapter abstractAdapter) {
        this.f13531b = v2Var;
        this.f13542m = v2Var.b();
        this.f13530a = abstractAdapter;
        JSONObject jSONObjectC = v2Var.c();
        this.f13532c = jSONObjectC;
        try {
            jSONObjectC.put(IronSourceLoadParameters.Constants.DEMAND_ONLY, true);
        } catch (JSONException e10) {
            i9.d().a(e10);
        }
        this.f13533d = a.NOT_LOADED;
        this.f13534e = null;
        this.f13536g = "";
        this.f13537h = null;
        this.f13538i = new ArrayList();
    }

    a a(a[] aVarArr, a aVar) {
        a aVar2;
        synchronized (this.f13540k) {
            aVar2 = this.f13533d;
            if (Arrays.asList(aVarArr).contains(this.f13533d)) {
                b(aVar);
            }
        }
        return aVar2;
    }

    void b(a aVar) {
        IronLog.INTERNAL.verbose("DemandOnlySmash " + this.f13531b.f() + ": current state=" + this.f13533d + ", new state=" + aVar);
        synchronized (this.f13540k) {
            this.f13533d = aVar;
        }
    }

    public v2 f() {
        return this.f13531b;
    }

    public String g() {
        return this.f13536g;
    }

    public String h() {
        return this.f13531b.f();
    }

    public int i() {
        return this.f13531b.d();
    }

    public Map<String, Object> j() {
        HashMap map = new HashMap();
        try {
            AbstractAdapter abstractAdapter = this.f13530a;
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, abstractAdapter != null ? abstractAdapter.getVersion() : "");
            AbstractAdapter abstractAdapter2 = this.f13530a;
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, abstractAdapter2 != null ? abstractAdapter2.getCoreSDKVersion() : "");
            map.put("spId", this.f13531b.i());
            map.put(IronSourceConstants.EVENTS_PROVIDER, this.f13531b.a());
            map.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            map.put("instanceType", Integer.valueOf(this.f13531b.d()));
            if (!TextUtils.isEmpty(this.f13536g)) {
                map.put("auctionId", this.f13536g);
            }
            JSONObject jSONObject = this.f13537h;
            if (jSONObject != null && jSONObject.length() > 0) {
                map.put("genericParams", this.f13537h);
            }
            if (!TextUtils.isEmpty(this.f13539j)) {
                map.put("dynamicDemandSource", this.f13539j);
            }
            if (o()) {
                map.put("isOneFlow", 1);
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getProviderEventData " + h() + ")", e10);
        }
        return map;
    }

    String k() {
        a aVar = this.f13533d;
        return aVar == null ? "null" : aVar.toString();
    }

    public String l() {
        return this.f13531b.i();
    }

    public List<String> m() {
        return this.f13538i;
    }

    public boolean n() {
        return this.f13531b.j();
    }

    public boolean o() {
        return this.f13532c.optBoolean("isOneFlow", false);
    }

    void p() {
        synchronized (this.f13541l) {
            Timer timer = this.f13534e;
            if (timer != null) {
                timer.cancel();
                this.f13534e = null;
            }
        }
    }

    public void a(String str) {
        this.f13536g = str;
    }

    public void b(String str) {
        this.f13539j = com.ironsource.mediationsdk.d.b().c(str);
    }

    protected void a(List<String> list, String str, int i10, String str2, String str3) {
        Iterator it = ((List) aj.a((ArrayList) list, new ArrayList())).iterator();
        while (it.hasNext()) {
            com.ironsource.mediationsdk.d.b().a(str3, str, com.ironsource.mediationsdk.d.b().a((String) it.next(), str, i10, str2, "", "", "", ""));
        }
    }

    void a(TimerTask timerTask) {
        synchronized (this.f13541l) {
            p();
            Timer timer = new Timer();
            this.f13534e = timer;
            timer.schedule(timerTask, this.f13535f);
        }
    }

    public void a(JSONObject jSONObject) {
        this.f13537h = jSONObject;
    }

    public void a(boolean z10) {
        try {
            this.f13532c.put("isOneFlow", z10);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.verbose("Can't set isOneFlow = " + z10 + ". Error: " + e10.getMessage());
        }
    }

    boolean a(a aVar) {
        boolean z10;
        synchronized (this.f13540k) {
            z10 = this.f13533d == aVar;
        }
        return z10;
    }

    boolean a(a aVar, a aVar2) {
        synchronized (this.f13540k) {
            if (this.f13533d != aVar) {
                return false;
            }
            b(aVar2);
            return true;
        }
    }
}
