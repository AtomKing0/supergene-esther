package com.applovin.impl.mediation.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.applovin.impl.f6;
import com.applovin.impl.g3;
import com.applovin.impl.h;
import com.applovin.impl.k0;
import com.applovin.impl.l2;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.q2;
import com.applovin.impl.q7;
import com.applovin.impl.r5;
import com.applovin.impl.r7;
import com.applovin.impl.s2;
import com.applovin.impl.s7;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.w4;
import com.applovin.impl.y1;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxAdViewConfiguration;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdViewImpl extends com.applovin.impl.mediation.ads.a implements f.a, s7.a, h.b {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaxAdView f5967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f5969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private s2 f5971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f5972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f5973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MaxAdViewConfiguration f5974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b f5975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d f5976k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.applovin.impl.sdk.f f5977l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final r7 f5978m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final s7 f5979n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Object f5980o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Object f5981p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private s2 f5982q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MaxAd f5983r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f5984s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f5985t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f5986u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final AtomicBoolean f5987v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f5988w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f5989x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f5990y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f5991z;

    private class b extends c {
        private b() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
            }
            l2.a(MaxAdViewImpl.this.adListener, str, maxError, true);
            MaxAdViewImpl.this.a(maxError);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.a()) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Precache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.Q().destroyAd(maxAd);
                return;
            }
            s2 s2Var = (s2) maxAd;
            s2Var.g(MaxAdViewImpl.this.f5972g);
            s2Var.f(MaxAdViewImpl.this.f5973h);
            if (s2Var.y() == null) {
                MaxAdViewImpl.this.sdk.Q().destroyAd(s2Var);
                onAdLoadFailed(s2Var.getAdUnitId(), new MaxErrorImpl(-5001, "Ad view not fully loaded"));
                return;
            }
            if (s2Var.o0()) {
                long jJ0 = s2Var.j0();
                MaxAdViewImpl.this.sdk.I();
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl.this.sdk.I().a(MaxAdViewImpl.this.tag, "Scheduling banner ad refresh " + jJ0 + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                }
                MaxAdViewImpl.this.f5977l.a(jJ0);
                if (MaxAdViewImpl.this.f5977l.g() || MaxAdViewImpl.this.f5986u) {
                    com.applovin.impl.sdk.n nVar2 = MaxAdViewImpl.this.logger;
                    if (com.applovin.impl.sdk.n.a()) {
                        MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                        maxAdViewImpl2.logger.a(maxAdViewImpl2.tag, "Pausing ad refresh for publisher");
                    }
                    MaxAdViewImpl.this.f5977l.j();
                }
            }
            com.applovin.impl.sdk.n nVar3 = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl3 = MaxAdViewImpl.this;
                maxAdViewImpl3.logger.a(maxAdViewImpl3.tag, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
            }
            l2.f(MaxAdViewImpl.this.adListener, maxAd, true);
            MaxAdViewImpl.this.d(s2Var);
        }
    }

    private abstract class c implements MaxAdListener, MaxAdViewAdListener, MaxAdRevenueListener, a.InterfaceC0165a {
        private c() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f5982q)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                l2.a(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(((Boolean) MaxAdViewImpl.this.sdk.a(g3.f5234j7)).booleanValue() ? MaxAdViewImpl.this.f5983r : MaxAdViewImpl.this.f5982q)) {
                MaxAdViewImpl.this.f5983r = null;
                if ((MaxAdViewImpl.this.f5982q.p0() || MaxAdViewImpl.this.B) && MaxAdViewImpl.this.f5984s) {
                    MaxAdViewImpl.this.f5984s = false;
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdViewAdListener.onAdCollapsed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                l2.b(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            if (maxAd.equals(MaxAdViewImpl.this.f5982q)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                l2.a(MaxAdViewImpl.this.adListener, maxAd, maxError, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f5982q)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                l2.c(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f5982q)) {
                if (((Boolean) MaxAdViewImpl.this.sdk.a(g3.f5234j7)).booleanValue()) {
                    MaxAdViewImpl.this.f5983r = maxAd;
                }
                if ((MaxAdViewImpl.this.f5982q.p0() || MaxAdViewImpl.this.B) && !MaxAdViewImpl.this.f5977l.g()) {
                    MaxAdViewImpl.this.f5984s = true;
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdViewAdListener.onAdExpanded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                l2.d(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f5982q)) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                l2.e(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxAdViewImpl.this.requestListener);
            }
            l2.a(MaxAdViewImpl.this.requestListener, str, true);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.revenueListener);
            }
            l2.a(MaxAdViewImpl.this.revenueListener, maxAd, true);
        }
    }

    private class d extends c {
        private d() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Failed to precache ad for refresh with error code: " + maxError.getCode());
            }
            MaxAdViewImpl.this.a(maxError);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (!MaxAdViewImpl.this.f5989x) {
                com.applovin.impl.sdk.n nVar = MaxAdViewImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Successfully precached ad for refresh");
                }
                if (((Boolean) MaxAdViewImpl.this.sdk.a(g3.P6)).booleanValue()) {
                    MaxAdViewImpl.this.b(maxAd);
                    return;
                } else {
                    MaxAdViewImpl.this.a(maxAd);
                    return;
                }
            }
            com.applovin.impl.sdk.n nVar2 = MaxAdViewImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                maxAdViewImpl2.logger.a(maxAdViewImpl2.tag, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
            }
            MaxAdViewImpl.this.sdk.Q().destroyAd(maxAd);
        }
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdViewConfiguration maxAdViewConfiguration, MaxAdView maxAdView, View view, Context context) {
        super(str, maxAdFormat, "MaxAdView", AppLovinSdk.getInstance(context).a());
        this.f5968c = UUID.randomUUID().toString().toLowerCase(Locale.US);
        this.f5970e = Long.MAX_VALUE;
        this.f5980o = new Object();
        this.f5981p = new Object();
        this.f5982q = null;
        this.f5983r = null;
        this.f5987v = new AtomicBoolean();
        this.f5989x = false;
        this.f5966a = context.getApplicationContext();
        this.f5967b = maxAdView;
        this.f5969d = view;
        this.f5975j = new b();
        this.f5976k = new d();
        this.f5977l = new com.applovin.impl.sdk.f(this.sdk, this);
        this.f5978m = new r7(maxAdView, this.sdk);
        this.f5979n = new s7(maxAdView, this.sdk, this);
        this.f5974i = maxAdViewConfiguration;
        this.sdk.j().a(this);
        if (maxAdViewConfiguration != null && maxAdViewConfiguration.getAdaptiveType() != MaxAdViewConfiguration.AdaptiveType.NONE) {
            setExtraParameter("adaptive_banner", Boolean.toString(true));
            setLocalExtraParameter("adaptive_banner_type", maxAdViewConfiguration.getAdaptiveType().toString());
            int adaptiveWidth = maxAdViewConfiguration.getAdaptiveWidth();
            if (adaptiveWidth > 0) {
                setLocalExtraParameter("adaptive_banner_width", Integer.valueOf(adaptiveWidth));
            }
            int inlineMaximumHeight = maxAdViewConfiguration.getInlineMaximumHeight();
            if (inlineMaximumHeight > 0) {
                setLocalExtraParameter("inline_adaptive_banner_max_height", Integer.valueOf(inlineMaximumHeight));
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Created new MaxAdView (" + this + ")");
        }
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        if (((Boolean) this.sdk.a(g3.Q6)).booleanValue()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6041a.g();
                }
            });
        } else {
            g();
        }
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public String getPlacement() {
        return this.f5972g;
    }

    public void loadAd() {
        loadAd(d.b.PUBLISHER_INITIATED);
    }

    @Override // com.applovin.impl.sdk.f.a
    public void onAdRefresh() {
        if (((Boolean) this.sdk.a(g3.P6)).booleanValue()) {
            f();
        } else {
            e();
        }
    }

    @Override // com.applovin.impl.h.b
    public void onCreativeIdGenerated(String str, String str2) {
        s2 s2Var = this.f5982q;
        if (s2Var != null && s2Var.N().equalsIgnoreCase(str)) {
            this.f5982q.h(str2);
            l2.b(this.adReviewListener, str2, this.f5982q);
            return;
        }
        s2 s2Var2 = this.f5971f;
        if (s2Var2 == null || !s2Var2.N().equalsIgnoreCase(str)) {
            return;
        }
        this.f5971f.h(str2);
    }

    @Override // com.applovin.impl.s7.a
    public void onLogVisibilityImpression() {
        a(this.f5982q, this.f5978m.a(this.f5982q));
    }

    public void onWindowVisibilityChanged(int i10) {
        if (((Boolean) this.sdk.a(g3.M6)).booleanValue() && this.f5977l.h()) {
            if (q7.b(i10)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Ad view visible");
                }
                this.f5977l.d();
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Ad view hidden");
                }
                this.f5977l.c();
            }
        }
    }

    public void setCustomData(String str) {
        if (this.f5982q != null && com.applovin.impl.sdk.n.a()) {
            this.logger.k(this.tag, "Setting custom data (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
        }
        z6.b(str, this.tag);
        this.f5973h = str;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void setExtraParameter(String str, String str2) {
        super.setExtraParameter(str, str2);
        a(str, str2);
    }

    public void setPlacement(String str) {
        if (this.f5982q != null && com.applovin.impl.sdk.n.a()) {
            this.logger.k(this.tag, "Setting placement (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
        }
        this.f5972g = str;
    }

    public void setPublisherBackgroundColor(int i10) {
        this.f5970e = i10;
    }

    public void startAutoRefresh() {
        this.f5986u = false;
        if (!this.f5977l.g()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Ignoring call to startAutoRefresh() - ad refresh is not paused");
                return;
            }
            return;
        }
        this.f5977l.m();
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Resumed auto-refresh with remaining time: " + this.f5977l.b() + "ms");
        }
    }

    public void stopAutoRefresh() {
        if (this.f5982q == null) {
            if (this.f5990y || ((Boolean) this.sdk.a(g3.O6)).booleanValue()) {
                this.f5986u = true;
                return;
            } else {
                com.applovin.impl.sdk.n.j(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
                return;
            }
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Pausing auto-refresh with remaining time: " + this.f5977l.b() + "ms");
        }
        this.f5977l.j();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MaxAdView{adUnitId='");
        sb.append(this.adUnitId);
        sb.append('\'');
        sb.append(", adListener=");
        Object obj = this.adListener;
        if (obj == this.f5967b) {
            obj = "this";
        }
        sb.append(obj);
        sb.append(", isDestroyed=");
        sb.append(a());
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final s2 s2Var) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f6047a.b(s2Var);
            }
        });
    }

    private void e() {
        this.f5987v.set(false);
        if (this.f5971f != null) {
            i();
            return;
        }
        if (!b()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refreshing ad from network...");
            }
            loadAd(d.b.REFRESH);
        } else if (this.f5985t) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refreshing ad from network due to viewability requirements not met for refresh request...");
            }
            loadAd(d.b.REFRESH);
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            }
            this.f5987v.set(true);
        }
    }

    private void f() {
        boolean z10;
        boolean z11;
        synchronized (this.f5981p) {
            z10 = false;
            this.f5987v.set(false);
            z11 = this.f5971f != null;
            if (!z11) {
                if (b()) {
                    if (!this.f5985t) {
                        if (com.applovin.impl.sdk.n.a()) {
                            this.logger.b(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
                        }
                        this.f5987v.set(true);
                    } else if (com.applovin.impl.sdk.n.a()) {
                        this.logger.a(this.tag, "Refreshing ad from network due to viewability requirements not met for refresh request...");
                    }
                } else if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Refreshing ad from network...");
                }
                z10 = true;
            }
        }
        if (z11) {
            i();
        } else if (z10) {
            loadAd(d.b.REFRESH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        h();
        if (this.f5971f != null) {
            this.sdk.Q().destroyAd(this.f5971f);
        }
        synchronized (this.f5980o) {
            this.f5989x = true;
        }
        this.f5977l.a();
        this.sdk.j().b(this);
        this.sdk.K().c(this.adUnitId, this.f5968c);
        super.destroy();
    }

    private void h() {
        s2 s2Var;
        MaxAdView maxAdView = this.f5967b;
        if (maxAdView != null) {
            com.applovin.impl.q.a(maxAdView, this.f5969d);
        }
        this.f5979n.b();
        synchronized (this.f5980o) {
            s2Var = this.f5982q;
        }
        MaxAd maxAd = this.f5983r;
        if (maxAd != null && maxAd.equals(s2Var)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Collapsing ad manually for removed ad.");
            }
            l2.b(this.f5975j, maxAd);
        }
        if (s2Var != null) {
            this.sdk.Q().destroyAd(s2Var);
        }
    }

    private void i() {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Rendering for cached ad: " + this.f5971f + "...");
        }
        this.f5975j.onAdLoaded(this.f5971f);
        this.f5971f = null;
    }

    public void loadAd(d.b bVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "" + this + " Loading ad for " + this.adUnitId + "...");
        }
        boolean z10 = this.f5990y || ((Boolean) this.sdk.a(g3.O6)).booleanValue();
        if (z10 && !this.f5977l.g() && this.f5977l.h()) {
            com.applovin.impl.sdk.n.h(this.tag, "Unable to load a new ad. An ad refresh has already been scheduled in " + TimeUnit.MILLISECONDS.toSeconds(this.f5977l.b()) + " seconds.");
            return;
        }
        if (!z10) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Loading ad...");
            }
            a(bVar, this.f5975j);
        } else if (this.f5971f != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Rendering cached ad");
            }
            i();
        } else if (this.f5988w) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Waiting for precache ad to load to render");
            }
            this.f5987v.set(true);
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Loading ad...");
            }
            a(bVar, this.f5975j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading ad for precache request...");
        }
        a(d.b.SEQUENTIAL_OR_PRECACHE, this.f5976k);
    }

    private void d() {
        if (b()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Scheduling refresh precache request now");
            }
            this.f5988w = true;
            this.sdk.j0().a((w4) new f6(this.sdk, "loadMaxAdForPrecacheRequest", new Runnable() { // from class: com.applovin.impl.mediation.ads.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6049a.c();
                }
            }), r5.b.MEDIATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final s2 s2Var) {
        View viewY = s2Var.y();
        String str = viewY == null ? "MaxAdView does not have a loaded ad view" : null;
        MaxAdView maxAdView = this.f5967b;
        if (maxAdView == null) {
            str = "MaxAdView does not have a parent view";
        }
        if (str != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, str);
            }
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, str);
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + s2Var + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            l2.a(this.adListener, (MaxAd) s2Var, (MaxError) maxErrorImpl, true);
            this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, s2Var);
            return;
        }
        h();
        a((q2) s2Var);
        if (s2Var.i0()) {
            this.f5979n.a(s2Var);
        }
        maxAdView.setDescendantFocusability(393216);
        if (s2Var.k0() != Long.MAX_VALUE) {
            this.f5969d.setBackgroundColor((int) s2Var.k0());
        } else {
            long j10 = this.f5970e;
            if (j10 != Long.MAX_VALUE) {
                this.f5969d.setBackgroundColor((int) j10);
            } else {
                this.f5969d.setBackgroundColor(0);
            }
        }
        maxAdView.addView(viewY);
        a(viewY, s2Var);
        this.sdk.w().d(s2Var);
        c(s2Var);
        synchronized (this.f5980o) {
            this.f5982q = s2Var;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Scheduling impression for ad manually...");
        }
        this.sdk.Q().processRawAdImpression(s2Var, this.f5975j);
        if (StringUtils.isValidString(this.f5982q.getAdReviewCreativeId())) {
            l2.a(this.adReviewListener, this.f5982q.getAdReviewCreativeId(), (MaxAd) this.f5982q, true);
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.ads.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f6045a.a(s2Var);
            }
        }, s2Var.m0());
    }

    private void c(s2 s2Var) {
        int height = this.f5967b.getHeight();
        int width = this.f5967b.getWidth();
        if (height > 0 || width > 0) {
            int iPxToDp = AppLovinSdkUtils.pxToDp(this.f5966a, height);
            int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.f5966a, width);
            MaxAdFormat format = s2Var.getFormat();
            int height2 = (this.D ? format.getAdaptiveSize(iPxToDp2, this.f5967b.getContext()) : format.getSize()).getHeight();
            int iMin = Math.min(format.getSize().getWidth(), k0.b(this.f5966a).x);
            if (iPxToDp < height2 || iPxToDp2 < iMin) {
                StringBuilder sb = new StringBuilder();
                sb.append("\n**************************************************\n`MaxAdView` size ");
                sb.append(iPxToDp2);
                sb.append(ViewHierarchyNode.JsonKeys.X);
                sb.append(iPxToDp);
                sb.append(" dp smaller than required ");
                sb.append(this.D ? "adaptive " : "");
                sb.append("size: ");
                sb.append(iMin);
                sb.append(ViewHierarchyNode.JsonKeys.X);
                sb.append(height2);
                sb.append(" dp\nSome mediated networks (e.g. Google Ad Manager) may not render correctly\n**************************************************\n");
                String string = sb.toString();
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.b("AppLovinSdk", string);
                }
            }
        }
    }

    private void a(final d.b bVar, final a.InterfaceC0165a interfaceC0165a) {
        if (a()) {
            boolean zC = z6.c(this.sdk);
            this.sdk.A().a(y1.f7798o0, "attemptingToLoadDestroyedAdView", CollectionUtils.hashMap("details", "debug=" + zC));
            if (!zC) {
                com.applovin.impl.sdk.n.h(this.tag, "Failed to load new ad - this instance is already destroyed");
                return;
            }
            throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
        }
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.mediation.ads.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f6042a.a(interfaceC0165a, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a.InterfaceC0165a interfaceC0165a, d.b bVar) {
        int adaptiveWidth;
        s2 s2Var = this.f5982q;
        if (s2Var != null) {
            long jA = this.f5978m.a(s2Var);
            this.extraParameters.put("visible_ad_ad_unit_id", this.f5982q.getAdUnitId());
            this.extraParameters.put("viewability_flags", Long.valueOf(jA));
        } else {
            this.extraParameters.remove("visible_ad_ad_unit_id");
            this.extraParameters.remove("viewability_flags");
        }
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.f5967b.getContext(), this.f5967b.getWidth());
        int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.f5967b.getContext(), this.f5967b.getHeight());
        this.extraParameters.put("viewport_width", Integer.valueOf(iPxToDp));
        this.extraParameters.put("viewport_height", Integer.valueOf(iPxToDp2));
        this.extraParameters.put("auto_refresh_stopped", Boolean.valueOf(this.f5977l.g() || this.f5986u));
        this.extraParameters.put("auto_retries_disabled", Boolean.valueOf(this.f5991z));
        MaxAdViewConfiguration maxAdViewConfiguration = this.f5974i;
        if (maxAdViewConfiguration != null && (adaptiveWidth = maxAdViewConfiguration.getAdaptiveWidth()) > 0 && iPxToDp != adaptiveWidth) {
            com.applovin.impl.sdk.n.j(this.tag, "The requested adaptive ad view width (" + adaptiveWidth + " dp) is different from the MaxAdView width (" + iPxToDp + " dp).");
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading " + this.adFormat.getLabel().toLowerCase(Locale.ENGLISH) + " ad for '" + this.adUnitId + "' and notifying " + interfaceC0165a + "...");
        }
        this.sdk.Q().loadAd(this.adUnitId, this.f5968c, this.adFormat, bVar, this.localExtraParameters, this.extraParameters, this.f5966a, interfaceC0165a);
    }

    private void a(String str, String str2) {
        if ("allow_pause_auto_refresh_immediately".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated allow immediate auto-refresh pause and ad load to: " + str2);
            }
            this.f5990y = Boolean.parseBoolean(str2);
            return;
        }
        if ("disable_auto_retries".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated disable auto-retries to: " + str2);
            }
            this.f5991z = Boolean.parseBoolean(str2);
            return;
        }
        if ("disable_precache".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated precached disabled to: " + str2);
            }
            this.A = Boolean.parseBoolean(str2);
            return;
        }
        if ("should_stop_auto_refresh_on_ad_expand".equals(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated should stop auto-refresh on ad expand to: " + str2);
            }
            this.B = Boolean.parseBoolean(str2);
            return;
        }
        if ("force_precache".equals(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated force precache to: " + str2);
            }
            this.C = Boolean.parseBoolean(str2);
            return;
        }
        if ("adaptive_banner".equalsIgnoreCase(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Updated is adaptive banner to: " + str2);
            }
            if (this.f5974i == null) {
                com.applovin.impl.sdk.n.h(this.tag, "You configured adaptive banners incorrectly by setting extra parameters to the MaxAdView! Please configure adaptive banners via MaxAdViewConfiguration instead. Learn more: https://developers.applovin.com/en/max/android/ad-formats/banner-and-mrec-ads#adaptive-banners");
            }
            this.D = Boolean.parseBoolean(str2);
            setLocalExtraParameter(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MaxAd maxAd) {
        boolean zCompareAndSet;
        this.f5988w = false;
        synchronized (this.f5981p) {
            zCompareAndSet = this.f5987v.compareAndSet(true, false);
            if (!zCompareAndSet) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Saving precache ad...");
                }
                s2 s2Var = (s2) maxAd;
                this.f5971f = s2Var;
                s2Var.g(this.f5972g);
                this.f5971f.f(this.f5973h);
            }
        }
        if (zCompareAndSet) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
            }
            this.f5975j.onAdLoaded(maxAd);
        }
    }

    private boolean b() {
        if (this.A) {
            return false;
        }
        return ((Boolean) this.sdk.a(g3.V6)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(s2 s2Var) {
        long jA = this.f5978m.a(s2Var);
        if (!s2Var.i0()) {
            a(s2Var, jA);
        }
        a(jA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxError maxError) {
        if (a()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Ad load failure with ad unit ID '" + this.adUnitId + "' occured after MaxAdView was destroyed.");
                return;
            }
            return;
        }
        if (this.sdk.c(g3.I6).contains(String.valueOf(maxError.getCode()))) {
            this.sdk.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.sdk.I().a(this.tag, "Ignoring banner ad refresh for error code " + maxError.getCode());
                return;
            }
            return;
        }
        if (!this.f5986u && !this.f5977l.g()) {
            this.f5985t = true;
            this.f5988w = false;
            long jLongValue = ((Long) this.sdk.a(g3.H6)).longValue();
            if (jLongValue >= 0) {
                this.sdk.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.sdk.I().a(this.tag, "Scheduling failed banner ad refresh " + jLongValue + " milliseconds from now for '" + this.adUnitId + "'...");
                }
                this.f5977l.a(jLongValue);
                return;
            }
            return;
        }
        if (this.f5988w) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refresh precache failed when auto-refresh is stopped");
            }
            this.f5988w = false;
        }
        if (this.f5987v.get()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Refresh precache failed - MaxAdListener.onAdLoadFailed(adUnitId=" + this.adUnitId + ", error=" + maxError + "), listener=" + this.adListener);
            }
            l2.a(this.adListener, this.adUnitId, maxError, true);
        }
    }

    private void a(View view, s2 s2Var) {
        int iN0 = s2Var.n0();
        int iL0 = s2Var.l0();
        int iDpToPx = iN0 == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), iN0);
        int iDpToPx2 = iL0 != -1 ? AppLovinSdkUtils.dpToPx(view.getContext(), iL0) : -1;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(iDpToPx, iDpToPx2);
        } else {
            layoutParams.width = iDpToPx;
            layoutParams.height = iDpToPx2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Pinning ad view to MAX ad view with width: " + iDpToPx + " and height: " + iDpToPx2 + ".");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int i10 : q7.a(this.f5967b.getGravity(), 10, 14)) {
                layoutParams2.addRule(i10);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    private void a(s2 s2Var, long j10) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Scheduling viewability impression for ad...");
        }
        this.sdk.Q().processViewabilityAdImpressionPostback(s2Var, j10, this.f5975j);
    }

    private void a(long j10) {
        if (z6.a(j10, ((Long) this.sdk.a(g3.U6)).longValue()) && !this.C) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Undesired flags matched - current: " + Long.toBinaryString(j10) + ", undesired: " + Long.toBinaryString(j10));
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Waiting for refresh timer to manually fire request");
            }
            this.f5985t = true;
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "No undesired viewability flags matched or forcing precache - scheduling viewability");
        }
        this.f5985t = false;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.f5988w = false;
        if (this.f5987v.compareAndSet(true, false)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
            }
            this.f5975j.onAdLoaded(maxAd);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Saving precache ad...");
        }
        s2 s2Var = (s2) maxAd;
        this.f5971f = s2Var;
        s2Var.g(this.f5972g);
        this.f5971f.f(this.f5973h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        boolean z10;
        synchronized (this.f5980o) {
            z10 = this.f5989x;
        }
        return z10;
    }
}
