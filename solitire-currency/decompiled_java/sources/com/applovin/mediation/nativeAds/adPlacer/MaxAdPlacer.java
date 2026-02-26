package com.applovin.mediation.nativeAds.adPlacer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.o2;
import com.applovin.impl.p2;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.u2;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdPlacer implements p2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppLovinSdkUtils.Size f8002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MaxNativeAdViewBinder f8003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o2 f8004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p2 f8005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Listener f8006e;
    protected final n logger;
    protected final j sdk;

    public interface Listener {
        void onAdClicked(MaxAd maxAd);

        void onAdLoaded(int i10);

        void onAdRemoved(int i10);

        void onAdRevenuePaid(MaxAd maxAd);
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, Context context) {
        this(maxAdPlacerSettings, AppLovinSdk.getInstance(context), context);
    }

    public void clearAds() {
        a(this.f8004c.b(), new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f8030a.b();
            }
        });
    }

    public Collection<Integer> clearTrailingAds(final int i10) {
        final Collection<Integer> collectionE = this.f8004c.e(i10);
        if (!collectionE.isEmpty()) {
            a(collectionE, new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8025a.a(i10, collectionE);
                }
            });
        }
        return collectionE;
    }

    public void destroy() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Destroying ad placer");
        }
        clearAds();
        this.f8005d.c();
    }

    public long getAdItemId(int i10) {
        if (isFilledPosition(i10)) {
            return -System.identityHashCode(this.f8004c.a(i10));
        }
        return 0L;
    }

    public AppLovinSdkUtils.Size getAdSize(int i10, int i11) {
        if (isFilledPosition(i10)) {
            AppLovinSdkUtils.Size size = this.f8002a;
            boolean z10 = size != AppLovinSdkUtils.Size.ZERO;
            int iMin = Math.min(z10 ? size.getWidth() : 360, i11);
            u2 u2Var = (u2) this.f8004c.a(i10);
            if ("small_template_1".equalsIgnoreCase(u2Var.n0())) {
                return new AppLovinSdkUtils.Size(iMin, z10 ? this.f8002a.getHeight() : 120);
            }
            if (MaxNativeAdView.MEDIUM_TEMPLATE_1.equalsIgnoreCase(u2Var.n0())) {
                return new AppLovinSdkUtils.Size(iMin, (int) (((double) iMin) / (z10 ? ((double) this.f8002a.getWidth()) / ((double) this.f8002a.getHeight()) : 1.2d)));
            }
            if (z10) {
                return this.f8002a;
            }
            if (u2Var.k0() != null) {
                View mainView = u2Var.k0().getMainView();
                return new AppLovinSdkUtils.Size(mainView.getMeasuredWidth(), mainView.getMeasuredHeight());
            }
        }
        return AppLovinSdkUtils.Size.ZERO;
    }

    public int getAdjustedCount(int i10) {
        return this.f8004c.b(i10);
    }

    public int getAdjustedPosition(int i10) {
        return this.f8004c.c(i10);
    }

    public int getOriginalPosition(int i10) {
        return this.f8004c.d(i10);
    }

    public void insertItem(int i10) {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Inserting item at position: " + i10);
        }
        this.f8004c.f(i10);
    }

    public boolean isAdPosition(int i10) {
        return this.f8004c.g(i10);
    }

    public boolean isFilledPosition(int i10) {
        return this.f8004c.h(i10);
    }

    public void loadAds() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Loading ads");
        }
        this.f8005d.e();
    }

    public void moveItem(int i10, int i11) {
        this.f8004c.b(i10, i11);
    }

    @Override // com.applovin.impl.p2.a
    public void onAdRevenuePaid(MaxAd maxAd) {
        Listener listener = this.f8006e;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }

    @Override // com.applovin.impl.p2.a
    public void onNativeAdClicked(MaxAd maxAd) {
        Listener listener = this.f8006e;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    @Override // com.applovin.impl.p2.a
    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        if (n.a()) {
            this.logger.b("MaxAdPlacer", "Native ad failed to load: " + maxError);
        }
    }

    @Override // com.applovin.impl.p2.a
    public void onNativeAdLoaded() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Native ad enqueued");
        }
        a();
    }

    public void removeItem(final int i10) {
        a(isFilledPosition(i10) ? Collections.singletonList(Integer.valueOf(i10)) : Collections.emptyList(), new Runnable() { // from class: com.applovin.mediation.nativeAds.adPlacer.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f8028a.a(i10);
            }
        });
    }

    public void renderAd(int i10, ViewGroup viewGroup) {
        MaxAd maxAdA = this.f8004c.a(i10);
        if (maxAdA == null) {
            if (n.a()) {
                this.logger.a("MaxAdPlacer", "An ad is not available for position: " + i10);
                return;
            }
            return;
        }
        MaxNativeAdView maxNativeAdViewK0 = ((u2) maxAdA).k0();
        if (maxNativeAdViewK0 == null) {
            if (this.f8003b == null) {
                if (n.a()) {
                    this.logger.b("MaxAdPlacer", "Unable to render ad at position: " + i10 + ". If you're using a custom ad template, check that nativeAdViewBinder is set.");
                    return;
                }
                return;
            }
            maxNativeAdViewK0 = new MaxNativeAdView(this.f8003b, viewGroup.getContext());
            if (this.f8005d.a(maxNativeAdViewK0, maxAdA)) {
                if (n.a()) {
                    this.logger.a("MaxAdPlacer", "Rendered ad at position: " + i10);
                }
            } else if (n.a()) {
                this.logger.b("MaxAdPlacer", "Unable to render ad at position: " + i10);
            }
        } else if (n.a()) {
            this.logger.a("MaxAdPlacer", "Using pre-rendered ad at position: " + i10);
        }
        for (int childCount = viewGroup.getChildCount(); childCount >= 0; childCount--) {
            if (viewGroup.getChildAt(childCount) instanceof MaxNativeAdView) {
                viewGroup.removeViewAt(childCount);
            }
        }
        if (maxNativeAdViewK0.getParent() != null) {
            ((ViewGroup) maxNativeAdViewK0.getParent()).removeView(maxNativeAdViewK0);
        }
        viewGroup.addView(maxNativeAdViewK0, -1, -1);
    }

    public void setAdSize(int i10, int i11) {
        this.f8002a = new AppLovinSdkUtils.Size(i10, i11);
    }

    public void setListener(Listener listener) {
        this.f8006e = listener;
    }

    public void setNativeAdViewBinder(MaxNativeAdViewBinder maxNativeAdViewBinder) {
        this.f8003b = maxNativeAdViewBinder;
    }

    public void updateFillablePositions(int i10, int i11) {
        this.f8004c.c(i10, i11);
        if (i10 == -1 || i11 == -1) {
            return;
        }
        a();
    }

    public MaxAdPlacer(MaxAdPlacerSettings maxAdPlacerSettings, AppLovinSdk appLovinSdk, Context context) {
        this.f8002a = AppLovinSdkUtils.Size.ZERO;
        j jVarA = appLovinSdk.a();
        this.sdk = jVarA;
        n nVarI = jVarA.I();
        this.logger = nVarI;
        this.f8004c = new o2(maxAdPlacerSettings);
        this.f8005d = new p2(maxAdPlacerSettings, context, this);
        if (n.a()) {
            nVarI.a("MaxAdPlacer", "Initializing ad placer with settings: " + maxAdPlacerSettings);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i10, Collection collection) {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Clearing trailing ads after position " + i10);
        }
        this.f8004c.a(collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Clearing all cached ads");
        }
        this.f8004c.a();
        this.f8005d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i10) {
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Removing item at position: " + i10);
        }
        this.f8004c.i(i10);
    }

    private void a() {
        int iC;
        while (this.f8005d.d() && (iC = this.f8004c.c()) != -1) {
            if (n.a()) {
                this.logger.a("MaxAdPlacer", "Placing ad at position: " + iC);
            }
            this.f8004c.a(this.f8005d.b(), iC);
            Listener listener = this.f8006e;
            if (listener != null) {
                listener.onAdLoaded(iC);
            }
        }
    }

    private void a(Collection collection, Runnable runnable) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.f8005d.a(this.f8004c.a(((Integer) it.next()).intValue()));
        }
        runnable.run();
        if (collection.isEmpty()) {
            return;
        }
        if (n.a()) {
            this.logger.a("MaxAdPlacer", "Removed " + collection.size() + " ads from stream: " + collection);
        }
        if (this.f8006e != null) {
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                this.f8006e.onAdRemoved(((Integer) it2.next()).intValue());
            }
        }
    }
}
