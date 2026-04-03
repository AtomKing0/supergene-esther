package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.f6;
import com.applovin.impl.g3;
import com.applovin.impl.h;
import com.applovin.impl.l2;
import com.applovin.impl.m1;
import com.applovin.impl.m3;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.q2;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.t2;
import com.applovin.impl.y1;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class MaxFullscreenAdImpl extends com.applovin.impl.mediation.ads.a implements a.InterfaceC0171a, h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f5995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f5996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f5997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.applovin.impl.mediation.b f5998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f5999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private t2 f6000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f6001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f6002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f6003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6004j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6005k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f6006l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f6007m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private WeakReference f6008n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private WeakReference f6009o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private WeakReference f6010p;

    public interface a {
        Activity getActivity();
    }

    protected class b implements MaxAdListener, MaxAdRevenueListener, a.InterfaceC0165a {
        protected b() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            l2.a(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(final MaxAd maxAd, final MaxError maxError) {
            final boolean z10 = MaxFullscreenAdImpl.this.f6005k;
            MaxFullscreenAdImpl.this.f6005k = false;
            final t2 t2Var = (t2) maxAd;
            MaxFullscreenAdImpl.this.a(c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6071a.a(maxAd, z10, t2Var, maxError);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            final t2 t2Var = (t2) maxAd;
            MaxFullscreenAdImpl.this.f6005k = false;
            MaxFullscreenAdImpl.this.sdk.f().a(t2Var);
            if (((Integer) MaxFullscreenAdImpl.this.sdk.a(g3.f5248v7)).intValue() > 0) {
                MaxFullscreenAdImpl.this.sdk.j0().b(new f6(MaxFullscreenAdImpl.this.sdk, "ReportAdHiddenCallbackNotCalled", new Runnable() { // from class: com.applovin.impl.mediation.ads.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6078a.a(t2Var);
                    }
                }), r5.b.TIMEOUT, TimeUnit.SECONDS.toMillis(r1.intValue()));
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            l2.c(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f6005k = false;
            MaxFullscreenAdImpl.this.a(c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6081a.a(maxAd);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, final MaxError maxError) {
            MaxFullscreenAdImpl.this.c();
            MaxFullscreenAdImpl.this.a(c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6083a.a(str, maxError);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(final MaxAd maxAd) {
            t2 t2Var;
            synchronized (MaxFullscreenAdImpl.this.f5999e) {
                t2Var = MaxFullscreenAdImpl.this.f6000f;
            }
            MaxFullscreenAdImpl.this.sdk.D().a(MaxFullscreenAdImpl.this.adUnitId);
            MaxFullscreenAdImpl.this.a((t2) maxAd);
            if (!MaxFullscreenAdImpl.this.f6002h.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.a(c.READY, new Runnable() { // from class: com.applovin.impl.mediation.ads.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6076a.b(maxAd);
                    }
                });
                return;
            }
            MaxFullscreenAdImpl.this.extraParameters.remove("expired_ad_ad_unit_id");
            if (MaxFullscreenAdImpl.this.f6003i.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.d();
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onExpiredAdReloaded(expiredAd=" + t2Var + ", newAd=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.expirationListener);
            }
            l2.a(MaxFullscreenAdImpl.this.expirationListener, (MaxAd) t2Var, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxFullscreenAdImpl.this.requestListener);
            }
            l2.a(MaxFullscreenAdImpl.this.requestListener, str, true);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.revenueListener);
            }
            l2.a(MaxFullscreenAdImpl.this.revenueListener, maxAd, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, MaxError maxError) {
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            l2.a(MaxFullscreenAdImpl.this.adListener, str, maxError, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(MaxAd maxAd) {
            if (MaxFullscreenAdImpl.this.f6005k) {
                MaxFullscreenAdImpl.this.d();
                return;
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            l2.f(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(t2 t2Var) {
            if (t2Var.w().get()) {
                return;
            }
            MaxFullscreenAdImpl.this.sdk.J().a(y1.X, t2Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.a(maxAd);
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            l2.e(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd, boolean z10, t2 t2Var, MaxError maxError) {
            MaxFullscreenAdImpl.this.a(maxAd);
            if (!z10 && t2Var.p0() && MaxFullscreenAdImpl.this.sdk.K().d(MaxFullscreenAdImpl.this.adUnitId)) {
                AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.mediation.ads.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6080a.a();
                    }
                });
                return;
            }
            com.applovin.impl.sdk.n nVar = MaxFullscreenAdImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.logger.a(maxFullscreenAdImpl.tag, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            l2.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxError, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            MaxFullscreenAdImpl.this.f6005k = true;
            MaxFullscreenAdImpl.this.loadAd();
        }
    }

    public enum c {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, a aVar, String str2, com.applovin.impl.sdk.j jVar, Context context) {
        super(str, maxAdFormat, str2, jVar);
        this.f5999e = new Object();
        this.f6000f = null;
        this.f6001g = c.IDLE;
        this.f6002h = new AtomicBoolean();
        this.f6003i = new AtomicBoolean();
        this.f6008n = new WeakReference(null);
        this.f6009o = new WeakReference(null);
        this.f6010p = new WeakReference(null);
        this.f5995a = aVar;
        this.f5997c = createAdListenerWrapper();
        this.f5998d = new com.applovin.impl.mediation.b(jVar);
        this.f5996b = new WeakReference(context);
        jVar.j().a(this);
        com.applovin.impl.sdk.n.g(str2, "Created new " + str2 + " (" + this + ")");
    }

    protected b createAdListenerWrapper() {
        return new b();
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        a(c.DESTROYED, new Runnable() { // from class: com.applovin.impl.mediation.ads.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f6050a.b();
            }
        });
    }

    public boolean isReady() {
        boolean z10;
        synchronized (this.f5999e) {
            t2 t2Var = this.f6000f;
            z10 = t2Var != null && t2Var.T() && this.f6001g == c.READY;
        }
        if (!z10) {
            this.sdk.D().c(this.adUnitId);
        }
        return z10;
    }

    public void loadAd() {
        loadAd(d.b.PUBLISHER_INITIATED);
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0171a
    public void onAdExpired(m1 m1Var) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Ad expired " + getAdUnitId());
        }
        this.f6002h.set(true);
        a aVar = this.f5995a;
        Activity activity = aVar != null ? aVar.getActivity() : null;
        if (activity == null && (activity = this.sdk.e().b()) == null) {
            c();
            this.f5997c.onAdLoadFailed(this.adUnitId, MaxAdapterError.MISSING_ACTIVITY);
        } else {
            this.extraParameters.put("expired_ad_ad_unit_id", getAdUnitId());
            this.sdk.Q().loadAd(this.adUnitId, null, this.adFormat, d.b.EXPIRED, this.localExtraParameters, this.extraParameters, activity, this.f5997c);
        }
    }

    @Override // com.applovin.impl.h.b
    public void onCreativeIdGenerated(String str, String str2) {
        t2 t2Var = this.f6000f;
        if (t2Var == null || !t2Var.N().equalsIgnoreCase(str)) {
            return;
        }
        this.f6000f.h(str2);
        l2.b(this.adReviewListener, str2, this.f6000f);
    }

    public void showAd(final String str, final String str2, final Activity activity) {
        t2 t2Var;
        List listB = this.sdk.l0().b();
        if (!this.sdk.l0().d() || listB == null || (t2Var = this.f6000f) == null || listB.contains(t2Var.c())) {
            if (activity == null) {
                activity = this.sdk.n0();
            }
            if (a(activity, str)) {
                a(c.SHOWING, new Runnable() { // from class: com.applovin.impl.mediation.ads.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6067a.a(str, str2, activity);
                    }
                });
                return;
            }
            return;
        }
        final String str3 = "Attempting to show ad from <" + this.f6000f.c() + "> which is not in the list of selected ad networks " + listB;
        com.applovin.impl.sdk.n.h(this.tag, str3);
        a(c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f6065a.b(str3);
            }
        });
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tag);
        sb.append("{adUnitId='");
        sb.append(this.adUnitId);
        sb.append('\'');
        sb.append(", adListener=");
        Object obj = this.adListener;
        if (obj == this.f5995a) {
            obj = "this";
        }
        sb.append(obj);
        sb.append(", revenueListener=");
        sb.append(this.revenueListener);
        sb.append(", requestListener");
        sb.append(this.requestListener);
        sb.append(", adReviewListener");
        sb.append(this.adReviewListener);
        sb.append(", isReady=");
        sb.append(isReady());
        sb.append('}');
        return sb.toString();
    }

    public void loadAd(final d.b bVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading ad for '" + this.adUnitId + "'...");
        }
        if (this.f6001g == c.DESTROYED) {
            boolean zC = z6.c(this.sdk);
            this.sdk.A().a(y1.f7798o0, "attemptingToLoadDestroyedAd", CollectionUtils.hashMap("details", "debug=" + zC));
            if (zC) {
                throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
            }
        }
        if (!isReady()) {
            a aVar = this.f5995a;
            final Activity activity = aVar != null ? aVar.getActivity() : null;
            final Context context = (Context) this.f5996b.get();
            a(c.LOADING, new Runnable() { // from class: com.applovin.impl.mediation.ads.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6061a.a(activity, context, bVar);
                }
            });
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "An ad is already loaded for '" + this.adUnitId + "'");
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdLoaded(ad=" + this.f6000f + "), listener=" + this.adListener);
        }
        l2.f(this.adListener, (MaxAd) this.f6000f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        synchronized (this.f5999e) {
            if (this.f6000f != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Destroying ad for '" + this.adUnitId + "'; current ad: " + this.f6000f + "...");
                }
                this.sdk.Q().destroyAd(this.f6000f);
            }
        }
        this.sdk.j().b(this);
        this.f5998d.a();
        super.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        t2 t2Var = this.f6000f;
        a((MaxAd) t2Var);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + t2Var + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
        }
        l2.a(this.adListener, (MaxAd) t2Var, (MaxError) maxErrorImpl, true);
        this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, t2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Activity activityN0 = (Activity) this.f6008n.get();
        if (activityN0 == null) {
            activityN0 = this.sdk.n0();
        }
        Activity activity = activityN0;
        if (this.f6004j) {
            showAd(this.f6006l, this.f6007m, (ViewGroup) this.f6009o.get(), (Lifecycle) this.f6010p.get(), activity);
        } else {
            showAd(this.f6006l, this.f6007m, activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, Context context, d.b bVar) {
        Context context2;
        Context contextN = activity;
        if (activity != null) {
            context2 = contextN;
        } else if (context != null) {
            context2 = context;
        } else {
            if (this.sdk.n0() != null) {
                contextN = this.sdk.n0();
            } else {
                contextN = com.applovin.impl.sdk.j.n();
            }
            context2 = contextN;
        }
        this.sdk.Q().loadAd(this.adUnitId, null, this.adFormat, bVar, this.localExtraParameters, this.extraParameters, context2, this.f5997c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        t2 t2Var;
        if (this.f6002h.compareAndSet(true, false)) {
            synchronized (this.f5999e) {
                t2Var = this.f6000f;
                this.f6000f = null;
            }
            this.sdk.Q().destroyAd(t2Var);
            this.extraParameters.remove("expired_ad_ad_unit_id");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Activity activity) {
        a(str, str2);
        this.f6004j = false;
        this.f6008n = new WeakReference(activity);
        this.sdk.Q().showFullscreenAd(this.f6000f, activity, this.f5997c);
    }

    public void showAd(final String str, final String str2, final ViewGroup viewGroup, final Lifecycle lifecycle, Activity activity) {
        t2 t2Var;
        if (viewGroup != null && lifecycle != null) {
            if (!viewGroup.isShown() && ((Boolean) this.sdk.a(g3.f5241q7)).booleanValue()) {
                com.applovin.impl.sdk.n.h(this.tag, "Attempting to show ad when containerView and/or its ancestors are not visible");
                MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, "Attempting to show ad when containerView and/or its ancestors are not visible");
                l2.a(this.adListener, (MaxAd) this.f6000f, (MaxError) maxErrorImpl, true);
                this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.f6000f);
                return;
            }
            List listB = this.sdk.l0().b();
            if (this.sdk.l0().d() && listB != null && (t2Var = this.f6000f) != null && !listB.contains(t2Var.c())) {
                final String str3 = "Attempting to show ad from <" + this.f6000f.c() + "> which is not in the list of selected ad networks " + listB;
                com.applovin.impl.sdk.n.h(this.tag, str3);
                a(c.IDLE, new Runnable() { // from class: com.applovin.impl.mediation.ads.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6051a.c(str3);
                    }
                });
                return;
            }
            if (activity == null) {
                activity = this.sdk.n0();
            }
            final Activity activity2 = activity;
            if (a(activity2, str)) {
                a(c.SHOWING, new Runnable() { // from class: com.applovin.impl.mediation.ads.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6053a.a(str, str2, activity2, viewGroup, lifecycle);
                    }
                });
                return;
            }
            return;
        }
        com.applovin.impl.sdk.n.h(this.tag, "Attempting to show ad with null containerView or lifecycle.");
        MaxErrorImpl maxErrorImpl2 = new MaxErrorImpl(-1, "Attempting to show ad with null containerView or lifecycle.");
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.f6000f + ", error=" + maxErrorImpl2 + "), listener=" + this.adListener);
        }
        l2.a(this.adListener, (MaxAd) this.f6000f, (MaxError) maxErrorImpl2, true);
        this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl2, this.f6000f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        t2 t2Var = this.f6000f;
        a((MaxAd) t2Var);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + t2Var + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
        }
        l2.a(this.adListener, (MaxAd) t2Var, (MaxError) maxErrorImpl, true);
        this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, t2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Activity activity, ViewGroup viewGroup, Lifecycle lifecycle) {
        a(str, str2);
        this.f6004j = true;
        this.f6008n = new WeakReference(activity);
        this.f6009o = new WeakReference(viewGroup);
        this.f6010p = new WeakReference(lifecycle);
        this.sdk.Q().showFullscreenAd(this.f6000f, viewGroup, lifecycle, activity, this.f5997c);
    }

    private boolean a(Activity activity, final String str) {
        if (activity == null && MaxAdFormat.APP_OPEN != this.adFormat) {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        }
        if (this.f6001g == c.DESTROYED) {
            boolean zC = z6.c(this.sdk);
            this.sdk.A().a(y1.f7798o0, "attemptingToShowDestroyedAd", CollectionUtils.hashMap("details", "debug=" + zC));
            if (zC) {
                throw new IllegalStateException("Attempting to show ad that is destroyed for ad unit ID: " + this.adUnitId);
            }
        }
        if (!isReady()) {
            String str2 = "Attempting to show ad before it is ready - please check ad readiness using " + this.tag + "#isReady()";
            com.applovin.impl.sdk.n.h(this.tag, str2);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-24, str2);
            m3 m3Var = new m3(this.adUnitId, this.adFormat, str);
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + m3Var + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            l2.a(this.adListener, (MaxAd) m3Var, (MaxError) maxErrorImpl, true);
            if (this.f6000f != null) {
                this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.f6000f);
            }
            return false;
        }
        Long l10 = (Long) this.sdk.a(g3.f5228d7);
        Long l11 = (Long) this.sdk.a(g3.W6);
        if (l10.longValue() > 0 && (this.f6000f.getTimeToLiveMillis() < l11.longValue() || this.f6002h.get())) {
            this.f6003i.set(true);
            this.sdk.j0().a(new f6(this.sdk, "handleShowOnLoadTimeoutError", new Runnable() { // from class: com.applovin.impl.mediation.ads.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6059a.a(str);
                }
            }), r5.b.TIMEOUT, l10.longValue());
            return false;
        }
        if (z6.a(com.applovin.impl.sdk.j.n()) != 0 && this.sdk.g0().shouldFailAdDisplayIfDontKeepActivitiesIsEnabled()) {
            if (!z6.c(this.sdk)) {
                if (((Boolean) this.sdk.a(g3.f5240p7)).booleanValue()) {
                    com.applovin.impl.sdk.n.h(this.tag, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                    MaxErrorImpl maxErrorImpl2 = new MaxErrorImpl(-5602, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                    if (com.applovin.impl.sdk.n.a()) {
                        this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.f6000f + ", error=" + maxErrorImpl2 + "), listener=" + this.adListener);
                    }
                    l2.a(this.adListener, (MaxAd) this.f6000f, (MaxError) maxErrorImpl2, true);
                    this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl2, this.f6000f);
                    return false;
                }
            } else {
                throw new IllegalStateException("Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
            }
        }
        if (!this.sdk.D().d() && !this.sdk.D().c()) {
            return true;
        }
        com.applovin.impl.sdk.n.h(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
        MaxErrorImpl maxErrorImpl3 = new MaxErrorImpl(-23, "Attempting to show ad when another fullscreen ad is already showing");
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.f6000f + ", error=" + maxErrorImpl3 + "), listener=" + this.adListener);
        }
        l2.a(this.adListener, (MaxAd) this.f6000f, (MaxError) maxErrorImpl3, true);
        this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl3, this.f6000f);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (this.f6003i.compareAndSet(true, false)) {
            com.applovin.impl.sdk.n.h(this.tag, "Failed to show an ad. Failed to load an ad in time to show.");
            this.sdk.D().c(this.adUnitId);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-24, "Failed to show an ad. Failed to load an ad in time to show.");
            m3 m3Var = new m3(this.adUnitId, this.adFormat, str);
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + m3Var + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            l2.a(this.adListener, (MaxAd) m3Var, (MaxError) maxErrorImpl, true);
            if (this.f6000f != null) {
                this.sdk.Q().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.f6000f);
            }
        }
    }

    private void a(String str, String str2) {
        this.f5998d.e(this.f6000f);
        this.f6000f.g(str);
        this.f6000f.f(str2);
        this.f6006l = str;
        this.f6007m = str2;
        this.sdk.w().d(this.f6000f);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Showing ad for '" + this.adUnitId + "'; loaded ad: " + this.f6000f + "...");
        }
        a((q2) this.f6000f);
    }

    private void a() {
        t2 t2Var;
        synchronized (this.f5999e) {
            t2Var = this.f6000f;
            this.f6000f = null;
        }
        this.sdk.Q().destroyAd(t2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t2 t2Var) {
        if (this.sdk.f().a(t2Var, this)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.a(this.tag, "Handle ad loaded for regular ad: " + t2Var);
            }
            this.f6000f = t2Var;
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loaded an expired ad, running expire logic...");
        }
        onAdExpired(t2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, Runnable runnable) {
        boolean z10;
        c cVar2 = this.f6001g;
        synchronized (this.f5999e) {
            c cVar3 = c.IDLE;
            if (cVar2 == cVar3) {
                if (cVar == c.LOADING || cVar == c.DESTROYED) {
                    z10 = true;
                } else {
                    if (cVar == c.SHOWING) {
                        com.applovin.impl.sdk.n.h(this.tag, "No ad is loading or loaded");
                    } else if (com.applovin.impl.sdk.n.a()) {
                        this.logger.b(this.tag, "Unable to transition to: " + cVar);
                    }
                    z10 = false;
                }
            } else {
                c cVar4 = c.LOADING;
                if (cVar2 == cVar4) {
                    if (cVar != cVar3) {
                        if (cVar == cVar4) {
                            com.applovin.impl.sdk.n.h(this.tag, "An ad is already loading");
                        } else if (cVar != c.READY) {
                            if (cVar == c.SHOWING) {
                                com.applovin.impl.sdk.n.h(this.tag, "An ad is not ready to be shown yet");
                            } else if (cVar != c.DESTROYED) {
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.logger.b(this.tag, "Unable to transition to: " + cVar);
                                }
                            }
                        }
                        z10 = false;
                    }
                    z10 = true;
                } else {
                    c cVar5 = c.READY;
                    if (cVar2 == cVar5) {
                        if (cVar != cVar3) {
                            if (cVar == cVar4) {
                                com.applovin.impl.sdk.n.h(this.tag, "An ad is already loaded");
                            } else if (cVar == cVar5) {
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.logger.b(this.tag, "An ad is already marked as ready");
                                }
                            } else if (cVar != c.SHOWING && cVar != c.DESTROYED) {
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.logger.b(this.tag, "Unable to transition to: " + cVar);
                                }
                            }
                            z10 = false;
                        }
                        z10 = true;
                    } else {
                        c cVar6 = c.SHOWING;
                        if (cVar2 == cVar6) {
                            if (cVar != cVar3) {
                                if (cVar == cVar4) {
                                    com.applovin.impl.sdk.n.h(this.tag, "Can not load another ad while the ad is showing");
                                } else if (cVar == cVar5) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.logger.b(this.tag, "An ad is already showing, ignoring");
                                    }
                                } else if (cVar == cVar6) {
                                    com.applovin.impl.sdk.n.h(this.tag, "The ad is already showing, not showing another one");
                                } else if (cVar != c.DESTROYED) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.logger.b(this.tag, "Unable to transition to: " + cVar);
                                    }
                                }
                            }
                            z10 = true;
                        } else if (cVar2 == c.DESTROYED) {
                            com.applovin.impl.sdk.n.h(this.tag, "No operations are allowed on a destroyed instance");
                        } else if (com.applovin.impl.sdk.n.a()) {
                            this.logger.b(this.tag, "Unknown state: " + this.f6001g);
                        }
                        z10 = false;
                    }
                }
            }
            if (z10) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Transitioning from " + this.f6001g + " to " + cVar + "...");
                }
                this.f6001g = cVar;
            } else if (com.applovin.impl.sdk.n.a()) {
                this.logger.k(this.tag, "Not allowed to transition from " + this.f6001g + " to " + cVar);
            }
        }
        if (z10) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.sdk.f().a((t2) maxAd);
        this.f5998d.a();
        a();
        this.sdk.T().a((q2) maxAd);
    }
}
