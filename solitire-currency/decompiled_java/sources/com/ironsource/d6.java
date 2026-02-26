package com.ironsource;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.environment.ContextProvider;
import com.ironsource.k7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class d6 extends k7<o1> implements BannerAdListener {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f11768t = "bannerLayout";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f11769u = "bannerSize";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final IronSourceBannerLayout f11770r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f11771s;

    class a extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f11772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout.LayoutParams f11773b;

        a(View view, FrameLayout.LayoutParams layoutParams) {
            this.f11772a = view;
            this.f11773b = layoutParams;
        }

        @Override // com.ironsource.yp
        public void a() {
            d6.this.a(this.f11772a, this.f11773b);
        }
    }

    class b extends yp {
        b() {
        }

        @Override // com.ironsource.yp
        public void a() {
            d6.this.J();
        }
    }

    public d6(ko koVar, i1 i1Var, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, IronSourceBannerLayout ironSourceBannerLayout, Placement placement, boolean z10, f5 f5Var, o1 o1Var) {
        super(koVar, i1Var, baseAdAdapter, new v2(i1Var.g(), i1Var.g().getBannerSettings(), IronSource.AD_UNIT.BANNER), f5Var, o1Var);
        this.f11770r = ironSourceBannerLayout;
        this.f12823g = placement;
        this.f11771s = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        if (y()) {
            super.onAdOpened();
        } else {
            if (this.f12821e == k7.h.FAILED) {
                return;
            }
            ironLog.error(String.format("unexpected onAdOpened for %s, state - %s", k(), this.f12821e));
            if (this.f12820d != null) {
                this.f12820d.f16112k.o(String.format("unexpected onAdOpened, state - %s", this.f12821e));
            }
        }
    }

    @Override // com.ironsource.k7
    protected void G() {
        Object obj = this.f12819c;
        if (obj instanceof AdapterBannerInterface) {
            ((AdapterBannerInterface) obj).loadAd(this.f12827k, ContextProvider.getInstance().getCurrentActiveActivity(), this.f11770r.getSize(), this);
        } else {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterBannerInterface"));
        }
    }

    @Override // com.ironsource.k7
    protected boolean O() {
        return false;
    }

    public void P() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(k());
        a(k7.h.NONE);
        Object obj = this.f12819c;
        if (obj == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            if (obj instanceof AdapterBannerInterface) {
                ((AdapterBannerInterface) obj).destroyAd(this.f12827k);
            } else {
                ironLog.error(a("adapter not instance of AdapterBannerInterface"));
            }
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.f12821e;
            IronLog.INTERNAL.error(a(str));
            x1 x1Var = this.f12820d;
            if (x1Var != null) {
                x1Var.f16112k.f(str);
            }
        }
        x1 x1Var2 = this.f12820d;
        if (x1Var2 != null) {
            x1Var2.f16108g.a(r().intValue());
        }
    }

    public void Q() {
        Object obj = this.f12819c;
        if (obj instanceof AdapterBindAdViewInterface) {
            ((AdapterBindAdViewInterface) obj).onAdViewBound(this.f12827k);
        }
    }

    public void R() {
        Object obj = this.f12819c;
        if (obj instanceof AdapterBindAdViewInterface) {
            ((AdapterBindAdViewInterface) obj).onAdViewWillBind(this.f12827k);
        }
    }

    @Override // com.ironsource.k7
    protected AdData a(String str, Map<String, Object> map) {
        return new AdData(str, q(), a(map));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLeftApplication() {
        x1 x1Var;
        Placement placement = this.f12823g;
        if (placement != null && (x1Var = this.f12820d) != null) {
            x1Var.f16111j.f(placement.getPlacementName());
        }
        Listener listener = this.f12818b;
        if (listener != 0) {
            ((o1) listener).d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.BannerAdListener, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLoadSuccess(@NotNull View view, @NotNull FrameLayout.LayoutParams layoutParams) {
        if (u().c()) {
            u().a(new a(view, layoutParams));
        } else {
            a(view, layoutParams);
        }
    }

    @Override // com.ironsource.k7, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        if (u().c()) {
            u().a(new b());
        } else {
            J();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenDismissed() {
        x1 x1Var;
        Placement placement = this.f12823g;
        if (placement != null && (x1Var = this.f12820d) != null) {
            x1Var.f16111j.c(placement.getPlacementName());
        }
        Listener listener = this.f12818b;
        if (listener != 0) {
            ((o1) listener).c(this);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenPresented() {
        x1 x1Var;
        Placement placement = this.f12823g;
        if (placement != null && (x1Var = this.f12820d) != null) {
            x1Var.f16111j.h(placement.getPlacementName());
        }
        Listener listener = this.f12818b;
        if (listener != 0) {
            ((o1) listener).a(this);
        }
    }

    @Override // com.ironsource.k7
    protected boolean v() {
        return this.f11771s;
    }

    @Override // com.ironsource.k7, com.ironsource.w1
    public Map<String, Object> a(u1 u1Var) {
        Map<String, Object> mapA = super.a(u1Var);
        IronSourceBannerLayout ironSourceBannerLayout = this.f11770r;
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            com.ironsource.mediationsdk.l.a(mapA, this.f11770r.getSize());
        }
        if (this.f12823g != null) {
            mapA.put("placement", j());
        }
        return mapA;
    }

    @Override // com.ironsource.k7
    protected Map<String, Object> a(Map<String, Object> map) {
        Map<String, Object> mapA = super.a(map);
        i1 i1Var = this.f12817a;
        if (i1Var != null && this.f11770r != null && TextUtils.isEmpty(i1Var.g().getCustomNetwork())) {
            mapA.put("bannerLayout", this.f11770r);
        }
        return mapA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NotNull View view, @NotNull FrameLayout.LayoutParams layoutParams) {
        Listener listener;
        super.onAdLoadSuccess();
        if (!y() || (listener = this.f12818b) == 0) {
            return;
        }
        ((o1) listener).a(this, view, layoutParams);
    }
}
