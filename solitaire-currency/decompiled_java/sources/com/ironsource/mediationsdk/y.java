package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.i9;
import com.ironsource.lg;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.v2;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y implements lg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected AbstractAdapter f13985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected v2 f13986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected JSONObject f13988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f13989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f13990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Long f13991g = null;

    y(v2 v2Var, AbstractAdapter abstractAdapter) {
        this.f13986b = v2Var;
        this.f13985a = abstractAdapter;
        this.f13988d = v2Var.c();
    }

    public void a(String str) {
        a(str, 0);
    }

    @Override // com.ironsource.lg.b
    public int b() {
        return this.f13986b.e();
    }

    @Override // com.ironsource.lg.b
    public String c() {
        return this.f13986b.f();
    }

    public abstract IronSource.AD_UNIT d();

    public Long e() {
        return this.f13991g;
    }

    public String f() {
        return String.format("%s %s", i(), Integer.valueOf(hashCode()));
    }

    public int g() {
        return this.f13986b.d();
    }

    public boolean h() {
        return this.f13987c;
    }

    public String i() {
        return this.f13986b.h().isMultipleInstances() ? this.f13986b.h().getProviderTypeForReflection() : this.f13986b.h().getProviderName();
    }

    public String j() {
        return this.f13986b.g();
    }

    public abstract String k();

    public int l() {
        return 1;
    }

    public Map<String, Object> m() {
        HashMap map = new HashMap();
        try {
            AbstractAdapter abstractAdapter = this.f13985a;
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, abstractAdapter != null ? abstractAdapter.getVersion() : "");
            AbstractAdapter abstractAdapter2 = this.f13985a;
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, abstractAdapter2 != null ? abstractAdapter2.getCoreSDKVersion() : "");
            map.put("spId", this.f13986b.i());
            map.put(IronSourceConstants.EVENTS_PROVIDER, this.f13986b.a());
            map.put("instanceType", Integer.valueOf(p() ? 2 : 1));
            map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(l()));
            if (!TextUtils.isEmpty(this.f13989e)) {
                map.put("dynamicDemandSource", this.f13989e);
            }
        } catch (Throwable th) {
            i9.d().a(th);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getProviderEventData " + c() + ")", th);
        }
        return map;
    }

    public int n() {
        return this.f13990f;
    }

    public boolean o() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        try {
            if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !this.f13985a.isUsingActivityBeforeImpression(d())) {
                return false;
            }
            ironLog.verbose(c() + " - is using activity before impression and activity is null");
            return true;
        } catch (Throwable th) {
            i9.d().a(th);
            b("Exception while calling adapter.isUsingActivityBeforeImpression() - " + th.getLocalizedMessage());
            return true;
        }
    }

    public boolean p() {
        return this.f13986b.j();
    }

    public void q() {
        try {
            AbstractAdapter abstractAdapter = this.f13985a;
            if (abstractAdapter != null) {
                abstractAdapter.releaseMemory(this.f13986b.b(), this.f13988d);
            }
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.INTERNAL.error("exception - " + th.getMessage());
        }
        this.f13985a = null;
    }

    public boolean r() {
        if (o()) {
            return false;
        }
        return p() || s();
    }

    public boolean s() {
        return this.f13986b.k();
    }

    private void a(String str, int i10) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, k() + " " + c() + " : " + str, i10);
    }

    public void b(String str) {
        a(str, 3);
    }

    public void c(String str) {
        this.f13989e = d.b().c(str);
    }

    public void a(boolean z10) {
        this.f13987c = z10;
    }
}
