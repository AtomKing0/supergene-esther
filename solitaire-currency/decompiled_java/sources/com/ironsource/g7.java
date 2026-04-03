package com.ironsource;

import android.app.Activity;
import com.ironsource.c2;
import com.ironsource.k7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g7<Listener extends c2> extends k7<Listener> implements AdapterAdInteractionListener {

    class a extends yp {
        a() {
        }

        @Override // com.ironsource.yp
        public void a() {
            g7.this.P();
        }
    }

    class b extends yp {
        b() {
        }

        @Override // com.ironsource.yp
        public void a() {
            g7.this.S();
        }
    }

    class c extends yp {
        c() {
        }

        @Override // com.ironsource.yp
        public void a() {
            g7.this.Q();
        }
    }

    class d extends yp {
        d() {
        }

        @Override // com.ironsource.yp
        public void a() {
            g7.this.T();
        }
    }

    class e extends yp {
        e() {
        }

        @Override // com.ironsource.yp
        public void a() {
            g7.this.R();
        }
    }

    class f extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f12221b;

        f(int i10, String str) {
            this.f12220a = i10;
            this.f12221b = str;
        }

        @Override // com.ironsource.yp
        public void a() {
            g7.this.b(this.f12220a, this.f12221b);
        }
    }

    public g7(ko koVar, i1 i1Var, BaseAdAdapter<?, ?> baseAdAdapter, v2 v2Var, f5 f5Var, Listener listener) {
        super(koVar, i1Var, baseAdAdapter, v2Var, f5Var, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        String str;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        synchronized (this.f12833q) {
            if (this.f12821e != k7.h.SHOWING) {
                ironLog.error("unexpected ad closed for " + k() + " - state = " + this.f12821e);
                x1 x1Var = this.f12820d;
                if (x1Var != null) {
                    x1Var.f16112k.j("unexpected ad closed - state = " + this.f12821e);
                }
                return;
            }
            a(k7.h.NONE);
            if (this.f12820d != null) {
                String string = "";
                if (this.f12817a.a() == IronSource.AD_UNIT.REWARDED_VIDEO) {
                    String strD = ((c2) this.f12818b).d();
                    StringBuilder sb = new StringBuilder();
                    sb.append("otherInstanceAvailable = ");
                    if (strD.length() > 0) {
                        str = "true|" + strD;
                    } else {
                        str = "false";
                    }
                    sb.append(str);
                    string = sb.toString();
                }
                this.f12820d.f16111j.a(j(), string);
            }
            ((c2) this.f12818b).a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        IronLog.INTERNAL.verbose(d());
        x1 x1Var = this.f12820d;
        if (x1Var != null) {
            x1Var.f16111j.d(j());
        }
        ((c2) this.f12818b).c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        IronLog.INTERNAL.verbose(d());
        x1 x1Var = this.f12820d;
        if (x1Var != null) {
            x1Var.f16111j.l(j());
        }
        ((c2) this.f12818b).b((g7<?>) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        IronLog.INTERNAL.verbose(d());
        x1 x1Var = this.f12820d;
        if (x1Var != null) {
            x1Var.f16111j.i(j());
        }
        ((c2) this.f12818b).d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        IronLog.INTERNAL.verbose(d());
        x1 x1Var = this.f12820d;
        if (x1Var != null) {
            x1Var.f16111j.k(j());
        }
    }

    static String a(k7.h hVar, int i10, String str) {
        return String.format(Locale.ENGLISH, "unexpected show failed, state - %s, error - %d %s", hVar, Integer.valueOf(i10), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i10, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("error = " + i10 + ", " + str));
        k7.h hVar = this.f12821e;
        if (hVar == k7.h.SHOWING) {
            a(k7.h.FAILED);
            x1 x1Var = this.f12820d;
            if (x1Var != null) {
                x1Var.f16111j.a(j(), i10, str, "");
            }
            ((c2) this.f12818b).a(new IronSourceError(i10, str), (g7<?>) this);
            return;
        }
        String strA = a(hVar, i10, str);
        ironLog.error(a(strA));
        x1 x1Var2 = this.f12820d;
        if (x1Var2 != null) {
            x1Var2.f16112k.r(strA);
        }
    }

    @Override // com.ironsource.k7
    public boolean B() {
        Object obj;
        if (this.f12827k == null || !y()) {
            return false;
        }
        try {
            obj = this.f12819c;
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "isReadyToShow - exception = " + th.getMessage() + " - state = " + this.f12821e;
            IronLog.INTERNAL.error(a(str));
            x1 x1Var = this.f12820d;
            if (x1Var != null) {
                x1Var.f16112k.f(str);
            }
        }
        if (obj instanceof AdapterAdFullScreenInterface) {
            return ((AdapterAdFullScreenInterface) obj).isAdAvailable(this.f12827k);
        }
        IronLog.INTERNAL.error(a("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface"));
        x1 x1Var2 = this.f12820d;
        if (x1Var2 != null) {
            x1Var2.f16112k.f("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface");
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        if (u().c()) {
            u().a(new a());
        } else {
            P();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdEnded() {
        if (u().c()) {
            u().a(new c());
        } else {
            Q();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowFailed(int i10, String str) {
        if (u().c()) {
            u().a(new f(i10, str));
        } else {
            b(i10, str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowSuccess() {
        if (u().c()) {
            u().a(new e());
        } else {
            R();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdStarted() {
        if (u().c()) {
            u().a(new b());
        } else {
            S();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdVisible() {
        if (u().c()) {
            u().a(new d());
        } else {
            T();
        }
    }

    public void a(Activity activity, Placement placement) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("placementName = " + placement.getPlacementName()));
        try {
            this.f12823g = placement;
            a(k7.h.SHOWING);
            this.f12820d.f16111j.a(activity, j());
            Object obj = this.f12819c;
            if (obj instanceof AdapterAdFullScreenInterface) {
                ((AdapterAdFullScreenInterface) obj).showAd(this.f12827k, this);
            } else {
                ironLog.error(a("showAd - adapter not instance of AdapterAdFullScreenInterface"));
                x1 x1Var = this.f12820d;
                if (x1Var != null) {
                    x1Var.f16112k.f("showAd - adapter not instance of AdapterAdFullScreenInterface");
                }
            }
        } catch (Throwable th) {
            i9.d().a(th);
            a(k7.h.FAILED);
            String str = "showAd - exception = " + th.getMessage() + " - state = " + this.f12821e;
            IronLog.INTERNAL.error(a(str));
            x1 x1Var2 = this.f12820d;
            if (x1Var2 != null) {
                x1Var2.f16112k.f(str);
            }
            onAdShowFailed(t1.h(this.f12817a.a()), str);
        }
    }

    public void b(boolean z10) {
        x1 x1Var = this.f12820d;
        if (x1Var != null) {
            x1Var.f16111j.a(z10);
        }
    }
}
