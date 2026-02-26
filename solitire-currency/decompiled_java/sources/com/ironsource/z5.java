package com.ironsource;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.g2;
import com.ironsource.h7;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z5 extends h7<d6, AdapterAdViewListener> implements o1, y5 {
    private u6 K;
    private boolean L;
    private IronSourceBannerLayout M;
    private View N;
    private k7<?> O;
    private FrameLayout.LayoutParams P;
    private final AtomicBoolean Q;
    private final AtomicBoolean R;

    class a implements v7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k7 f16382a;

        a(k7 k7Var) {
            this.f16382a = k7Var;
        }

        @Override // com.ironsource.v7
        public void a() {
            ((d6) this.f16382a).Q();
        }
    }

    class b implements v7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k7 f16384a;

        b(k7 k7Var) {
            this.f16384a = k7Var;
        }

        @Override // com.ironsource.v7
        public void a() {
            ((d6) this.f16384a).Q();
            z5 z5Var = z5.this;
            z5Var.f12419s.f16111j.j(z5Var.n());
            z5.this.Q.set(false);
            z5.this.W();
            IronLog.INTERNAL.verbose("start binding timer after impression, expected interval = " + z5.this.f12415o.i().b() + ", current timestamp = " + System.currentTimeMillis());
            z5.this.O().h();
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16386a;

        static {
            int[] iArr = new int[g2.a.values().length];
            f16386a = iArr;
            try {
                iArr[g2.a.MANUAL_WITH_AUTOMATIC_RELOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16386a[g2.a.MANUAL_WITH_LOAD_ON_SHOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public z5(List<NetworkSettings> list, n6 n6Var, String str, lj ljVar, IronSourceSegment ironSourceSegment) {
        super(new a6(str, list, n6Var), ljVar, ironSourceSegment);
        this.L = false;
        this.Q = new AtomicBoolean(true);
        this.R = new AtomicBoolean(false);
        this.K = N();
    }

    private void M() {
        int i10 = c.f16386a[this.f12417q.b().a().ordinal()];
        if (i10 == 1) {
            P().a();
        } else {
            if (i10 != 2) {
                return;
            }
            P().l();
            P().m();
            O().a();
            O().b();
        }
    }

    private u6 N() {
        return new u6(this.f12415o.i(), this.f12415o.h(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u6 O() {
        return this.K;
    }

    private a7 P() {
        return (a7) this.f12417q;
    }

    private ISBannerSize Q() {
        IronSourceBannerLayout ironSourceBannerLayout = this.M;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        return this.M.getSize().isSmart() ? AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? com.ironsource.mediationsdk.l.a() : ISBannerSize.BANNER : this.M.getSize();
    }

    private boolean S() {
        IronLog.INTERNAL.verbose(b(this.N + ", " + this.P + ", " + this.O));
        return (this.N == null || this.P == null || this.O == null) ? false : true;
    }

    private void U() {
        int i10 = c.f16386a[this.f12417q.b().a().ordinal()];
        if (i10 == 1) {
            P().k();
        } else {
            if (i10 != 2) {
                return;
            }
            P().r();
        }
    }

    private void V() {
        int i10 = c.f16386a[this.f12417q.b().a().ordinal()];
        if (i10 == 1) {
            P().k();
        } else {
            if (i10 != 2) {
                return;
            }
            P().q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.O = null;
        this.N = null;
        this.P = null;
    }

    boolean R() {
        IronLog ironLog;
        String str;
        if (!this.M.isShown()) {
            ironLog = IronLog.INTERNAL;
            str = "banner or one of its parents are INVISIBLE or GONE";
        } else {
            if (this.M.hasWindowFocus()) {
                boolean globalVisibleRect = this.M.getGlobalVisibleRect(new Rect());
                IronLog.INTERNAL.verbose("visible = " + globalVisibleRect);
                return globalVisibleRect;
            }
            ironLog = IronLog.INTERNAL;
            str = "banner has no window focus";
        }
        ironLog.verbose(str);
        return false;
    }

    public void T() {
        IronSourceBannerLayout ironSourceBannerLayout = this.M;
        if (ironSourceBannerLayout != null) {
            a(ironSourceBannerLayout);
        }
    }

    @Override // com.ironsource.h7
    protected /* bridge */ /* synthetic */ k7 a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i10, String str, f5 f5Var) {
        return b(networkSettings, (BaseAdAdapter<?, AdapterAdViewListener>) baseAdAdapter, i10, str, f5Var);
    }

    protected d6 b(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, int i10, String str, f5 f5Var) {
        return new d6(this, new i1(IronSource.AD_UNIT.BANNER, this.f12415o.p(), i10, this.f12407g, str, this.f12405e, this.f12406f, networkSettings, this.f12415o.o()), baseAdAdapter, this.M, this.f12409i, v(), f5Var, this);
    }

    @Override // com.ironsource.m2
    public void d(k7<?> k7Var) {
        IronLog.INTERNAL.verbose(b(k7Var.k()));
        this.f12420t.b(k7Var.f());
    }

    @Override // com.ironsource.y5
    public void e() {
        if (!R()) {
            IronLog.INTERNAL.verbose("banner is not visible, binding skipped");
            O().h();
            this.f12419s.f16108g.b(IronSourceError.ERROR_BN_BINDING_SKIP_INVISIBLE);
        } else {
            if (!S()) {
                IronLog.INTERNAL.verbose("Cannot bind banner view after interval, the next ad is not ready yet");
                this.Q.set(true);
                return;
            }
            IronLog.INTERNAL.verbose("done binding timer, binding view now, current timestamp = " + System.currentTimeMillis());
            c(this.O, this.N, this.P);
        }
    }

    @Override // com.ironsource.y5
    public void f() {
        if (!R()) {
            IronLog.INTERNAL.verbose("banner is not visible, starting the impression timeout timer again");
            O().e();
        } else if (this.R.compareAndSet(false, true)) {
            IronLog.INTERNAL.verbose("banner impression timeout reached, reloading banner manually");
            U();
            this.f12419s.f16112k.b("banner impression timeout reached, reloading banner manually");
        }
    }

    @Override // com.ironsource.h7
    protected e2 g() {
        return new v6();
    }

    @Override // com.ironsource.h7
    protected i2 h() {
        return new a7(this.f12415o.i(), this);
    }

    @Override // com.ironsource.h7
    protected String l() {
        return "BN";
    }

    @Override // com.ironsource.h7
    protected String o() {
        return IronSourceConstants.OPW_BN_MANAGER_NAME;
    }

    @Override // com.ironsource.h7
    protected boolean v() {
        return this.L;
    }

    @Override // com.ironsource.h7
    protected LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return ((AdapterSettingsInterface) adapterBaseInterface).getBannerLoadWhileShowSupportedState(networkSettings);
    }

    @Override // com.ironsource.h7
    protected JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getBannerSettings();
    }

    @Override // com.ironsource.m2
    public void c(k7<?> k7Var) {
        IronLog.INTERNAL.verbose(b(k7Var.k()));
        this.f12420t.e(k7Var.f());
    }

    @Override // com.ironsource.h7
    protected void g(k7<?> k7Var) {
    }

    @Override // com.ironsource.h7
    protected void h(k7<?> k7Var) {
    }

    private void c(k7<?> k7Var, View view, FrameLayout.LayoutParams layoutParams) {
        if (a(h7.f.READY_TO_SHOW, h7.f.SHOWING)) {
            this.R.set(false);
            O().e();
            ((d6) k7Var).R();
            com.ironsource.mediationsdk.l.a(this.M, view, layoutParams, new b(k7Var));
            return;
        }
        IronLog.INTERNAL.verbose("wrong state = " + this.f12416p);
    }

    @Override // com.ironsource.h7
    protected AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(b(networkSettings), this.f12415o.b(), str, this.M);
    }

    @Override // com.ironsource.h7, com.ironsource.j2
    public void b(k7<?> k7Var) {
        super.b(k7Var);
        if (P().o()) {
            if (!this.R.compareAndSet(false, true)) {
                IronLog.INTERNAL.verbose("Impression already recorded as receive, it can occur from network onAdOpened or from impression timeout timer - loading next ad already in progress");
            } else {
                O().b();
                U();
            }
        }
    }

    private void b(k7<?> k7Var, View view, FrameLayout.LayoutParams layoutParams) {
        ((d6) k7Var).R();
        com.ironsource.mediationsdk.l.a(this.M, view, layoutParams, new a(k7Var));
    }

    @Override // com.ironsource.h7, com.ironsource.w1
    public Map<String, Object> a(u1 u1Var) {
        Map<String, Object> mapA = super.a(u1Var);
        if (b(this.M)) {
            com.ironsource.mediationsdk.l.a(mapA, this.M.getSize());
        }
        if (this.f12409i != null) {
            mapA.put("placement", n());
        }
        return mapA;
    }

    @Override // com.ironsource.h7, com.ironsource.xk
    public void a() {
        boolean z10;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        try {
            if (this.M == null) {
                ironLog.error("mIronSourceBanner is null");
                this.f12419s.f16108g.b(IronSourceError.ERROR_BN_RELOAD_SKIP_BANNER_LAYOUT_IS_NULL);
                return;
            }
            if (!R()) {
                if (this.f12415o.i().a() == g2.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
                    ironLog.verbose("banner is not visible, reload skipped");
                    this.f12419s.f16108g.b(IronSourceError.ERROR_BN_RELOAD_SKIP_INVISIBLE);
                }
                U();
                return;
            }
            synchronized (this.f12424x) {
                if (a(h7.f.SHOWING, h7.f.READY_TO_LOAD)) {
                    ironLog.verbose("start reload");
                    z10 = true;
                    this.L = true;
                } else {
                    ironLog.error("wrong state = " + this.f12416p);
                    z10 = false;
                }
            }
            if (z10) {
                a(this.M, this.f12409i);
            }
        } catch (Throwable th) {
            i9.d().a(th);
            this.f12419s.f16112k.c(th.getMessage());
        }
    }

    boolean b(IronSourceBannerLayout ironSourceBannerLayout) {
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) ? false : true;
    }

    @Override // com.ironsource.h7
    protected void a(int i10, String str, boolean z10) {
        if (!v()) {
            super.a(i10, str, z10);
            return;
        }
        if (!z10) {
            this.f12419s.f16108g.b(ta.a(this.f12414n), i10, str);
            com.ironsource.mediationsdk.n.a().b(this.f12415o.b(), new IronSourceError(i10, str));
        }
        if (v()) {
            a(h7.f.SHOWING);
            V();
        }
    }

    @Override // com.ironsource.h7
    protected void a(Context context, com.ironsource.mediationsdk.i iVar, l4 l4Var) {
        if (this.f12403c == null) {
            IronLog.INTERNAL.error(b("mAuctionHandler is null"));
        } else {
            iVar.a(Q());
            this.f12403c.a(context, iVar, l4Var);
        }
    }

    @Override // com.ironsource.m2
    public void a(k7<?> k7Var) {
        IronLog.INTERNAL.verbose(b(k7Var.k()));
        this.f12420t.f(k7Var.f());
    }

    @Override // com.ironsource.o1
    public void a(k7<?> k7Var, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose("mState = " + this.f12416p);
        super.e(k7Var);
        if (this.f12415o.i().a() == g2.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
            if (!a(h7.f.READY_TO_SHOW, h7.f.SHOWING)) {
                return;
            }
            this.f12401a.a(k7Var);
            this.f12401a.b(k7Var);
            b(k7Var, view, layoutParams);
            P().k();
        } else {
            if (!P().o()) {
                return;
            }
            this.f12401a.b(k7Var);
            if (this.Q.get()) {
                c(k7Var, view, layoutParams);
            } else {
                this.O = k7Var;
                this.N = view;
                this.P = layoutParams;
            }
        }
        this.f12420t.c(k7Var.f());
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        try {
            if (!b(ironSourceBannerLayout)) {
                Object[] objArr = new Object[1];
                objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
                String str = String.format("can't destroy banner - %s", objArr);
                IronLog.API.error("destroy banner failed - errorMessage = " + str);
                return;
            }
            IronLog.INTERNAL.verbose("destroying banner");
            M();
            d6 d6Var = (d6) this.f12401a.d();
            if (d6Var != null) {
                this.f12419s.f16108g.a(d6Var.r() != null ? d6Var.r().intValue() : this.C.a(this.f12415o.b()));
                d6Var.P();
                this.f12401a.a(null);
                this.f12401a.b(null);
            }
            com.ironsource.mediationsdk.l.a(ironSourceBannerLayout);
            this.M = null;
            this.f12409i = null;
            this.L = false;
            if (P().o()) {
                this.Q.set(true);
                this.R.set(false);
                W();
            }
            a(h7.f.READY_TO_LOAD);
        } catch (Throwable th) {
            i9.d().a(th);
            String str2 = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.f12416p;
            IronLog.INTERNAL.error(b(str2));
            x1 x1Var = this.f12419s;
            if (x1Var != null) {
                x1Var.f16112k.f(str2);
            }
        }
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, Placement placement) {
        String str;
        IronLog.INTERNAL.verbose("placement = " + placement);
        int iB = 510;
        if (!b(ironSourceBannerLayout)) {
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            str = String.format("can't load banner - %s", objArr);
        } else if (placement == null || TextUtils.isEmpty(placement.getPlacementName())) {
            Object[] objArr2 = new Object[1];
            objArr2[0] = placement == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load banner - %s", objArr2);
            iB = t1.b(this.f12415o.b());
        } else if (this.E.b(ContextProvider.getInstance().getApplicationContext(), placement, this.f12415o.b())) {
            str = String.format("placement %s is capped", placement.getPlacementName());
            iB = t1.f(this.f12415o.b());
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            IronLog.API.error(b(str));
            a(iB, str, false);
        } else {
            com.ironsource.mediationsdk.l.b(ironSourceBannerLayout);
            this.M = ironSourceBannerLayout;
            this.f12409i = placement;
            A();
        }
    }
}
