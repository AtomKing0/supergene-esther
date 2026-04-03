package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.qf;
import com.ironsource.sdk.controller.FeaturesManager;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class wu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f16053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private y8 f16054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ia f16055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ra f16057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f16059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f16060i = wu.class.getSimpleName();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f16061j;

    protected enum a {
        NOT_RECOVERED,
        RECOVERED,
        IN_RECOVERING,
        NOT_ALLOWED
    }

    public wu(Context context, y8 y8Var, ia iaVar, int i10, ra raVar, String str) {
        a aVarH = h();
        this.f16061j = aVarH;
        if (aVarH != a.NOT_ALLOWED) {
            this.f16053b = context;
            this.f16054c = y8Var;
            this.f16055d = iaVar;
            this.f16056e = i10;
            this.f16057f = raVar;
            this.f16058g = 0;
        }
        this.f16052a = str;
    }

    private a h() {
        this.f16059h = FeaturesManager.getInstance().getInitRecoverTrials();
        Logger.i(this.f16060i, "getInitialState mMaxAllowedTrials: " + this.f16059h);
        if (this.f16059h > 0) {
            return a.NOT_RECOVERED;
        }
        Logger.i(this.f16060i, "recovery is not allowed by config");
        return a.NOT_ALLOWED;
    }

    private void j() {
        if (this.f16058g != this.f16059h) {
            this.f16061j = a.NOT_RECOVERED;
            return;
        }
        Logger.i(this.f16060i, "handleRecoveringEndedFailed | Reached max trials");
        this.f16061j = a.NOT_ALLOWED;
        a();
    }

    private void k() {
        a();
        this.f16061j = a.RECOVERED;
    }

    public void a() {
        this.f16053b = null;
        this.f16054c = null;
        this.f16055d = null;
        this.f16057f = null;
    }

    public Context b() {
        return this.f16053b;
    }

    public String c() {
        return this.f16052a;
    }

    public y8 d() {
        return this.f16054c;
    }

    public int e() {
        return this.f16056e;
    }

    public ia f() {
        return this.f16055d;
    }

    public ra g() {
        return this.f16057f;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(v8.h.A0, m());
            jSONObject.put(v8.h.B0, this.f16058g);
            jSONObject.put(v8.h.C0, this.f16059h);
        } catch (JSONException e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
        return jSONObject;
    }

    public boolean l() {
        return this.f16061j == a.IN_RECOVERING;
    }

    public boolean m() {
        return this.f16061j == a.RECOVERED;
    }

    public void n() {
        a aVar = this.f16061j;
        a aVar2 = a.IN_RECOVERING;
        if (aVar != aVar2) {
            this.f16058g++;
            Logger.i(this.f16060i, "recoveringStarted - trial number " + this.f16058g);
            this.f16061j = aVar2;
        }
    }

    public void a(boolean z10) {
        if (this.f16061j != a.IN_RECOVERING) {
            return;
        }
        if (z10) {
            k();
        } else {
            j();
        }
    }

    public boolean a(qf.c cVar, qf.b bVar) {
        Logger.i(this.f16060i, "shouldRecoverWebController: ");
        a aVar = this.f16061j;
        if (aVar == a.NOT_ALLOWED) {
            Logger.i(this.f16060i, "shouldRecoverWebController: false | recover is not allowed");
            return false;
        }
        if (cVar != qf.c.Native) {
            Logger.i(this.f16060i, "shouldRecoverWebController: false | current controller type is: " + cVar);
            return false;
        }
        if (bVar == qf.b.Loading || bVar == qf.b.None) {
            Logger.i(this.f16060i, "shouldRecoverWebController: false | a Controller is currently loading");
            return false;
        }
        if (aVar == a.RECOVERED) {
            Logger.i(this.f16060i, "shouldRecoverWebController: false | already recovered");
            return false;
        }
        if (aVar == a.IN_RECOVERING) {
            Logger.i(this.f16060i, "shouldRecoverWebController: false | currently in recovering");
            return false;
        }
        if (this.f16053b == null || this.f16054c == null || this.f16055d == null) {
            Logger.i(this.f16060i, "shouldRecoverWebController: false | missing mandatory param");
            return false;
        }
        Logger.i(this.f16060i, "shouldRecoverWebController: true | allow recovering ");
        return true;
    }
}
