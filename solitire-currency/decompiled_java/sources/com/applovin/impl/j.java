package com.applovin.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.d;
import com.applovin.impl.k;
import com.applovin.impl.k2;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.impl.u;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.ironsource.bt;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends d3 implements AdControlButton.a, MaxRewardedAdListener, MaxAdViewAdListener, MaxAdRevenueListener, u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f5411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l f5412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private u7 f5413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k f5414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MaxAdView f5415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxInterstitialAd f5416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxAppOpenAd f5417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MaxRewardedAd f5418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MaxNativeAdView f5419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaxNativeAdLoader f5420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaxAd f5421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private p f5422l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private List f5423m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ListView f5424n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f5425o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AdControlButton f5426p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f5427q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private u f5428r;

    class a extends MaxNativeAdListener {
        a() {
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdClicked(MaxAd maxAd) {
            j.this.onAdClicked(maxAd);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoadFailed(String str, MaxError maxError) {
            j.this.onAdLoadFailed(str, maxError);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
            if (j.this.f5421k != null) {
                j.this.f5420j.destroy(j.this.f5421k);
            }
            j.this.f5421k = maxAd;
            if (maxNativeAdView != null) {
                j.this.f5419i = maxNativeAdView;
            } else {
                j jVar = j.this;
                com.applovin.impl.sdk.j unused = j.this.f5411a;
                jVar.f5419i = new MaxNativeAdView(MaxNativeAdView.MEDIUM_TEMPLATE_1, com.applovin.impl.sdk.j.n());
                j.this.f5420j.render(j.this.f5419i, maxAd);
            }
            j.this.onAdLoaded(maxAd);
        }
    }

    @Override // com.applovin.impl.d3
    protected com.applovin.impl.sdk.j getSdk() {
        return this.f5411a;
    }

    public void initialize(final l lVar, @Nullable final m mVar, @Nullable u7 u7Var, final com.applovin.impl.sdk.j jVar) {
        List listA;
        this.f5411a = jVar;
        this.f5412b = lVar;
        this.f5413c = u7Var;
        this.f5423m = jVar.l0().b();
        k kVar = new k(lVar, mVar, u7Var, this);
        this.f5414d = kVar;
        kVar.a(new k2.a() { // from class: com.applovin.impl.y9
            @Override // com.applovin.impl.k2.a
            public final void a(d2 d2Var, j2 j2Var) {
                this.f7846a.a(jVar, lVar, mVar, d2Var, j2Var);
            }
        });
        b();
        if (lVar.f().f()) {
            if ((u7Var != null && !u7Var.b().d().D()) || (listA = jVar.N().a(lVar.c())) == null || listA.isEmpty()) {
                return;
            }
            this.f5428r = new u(listA, lVar.a(), getApplicationContext(), this);
        }
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdClicked(@NonNull MaxAd maxAd) {
        z6.a(bt.f11466f, maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdCollapsed(@NonNull MaxAd maxAd) {
        z6.a("onAdCollapsed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        this.f5426p.setControlState(AdControlButton.b.LOAD);
        this.f5427q.setText("");
        z6.a("Failed to display " + maxAd.getFormat().getDisplayName(), "MAX Error\nCode: " + maxError.getCode() + "\nMessage: " + maxError.getMessage() + "\n\n" + maxAd.getNetworkName() + " Display Error\nCode: " + maxError.getMediatedNetworkErrorCode() + "\nMessage: " + maxError.getMediatedNetworkErrorMessage(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayed(@NonNull MaxAd maxAd) {
        z6.a("onAdDisplayed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdExpanded(@NonNull MaxAd maxAd) {
        z6.a("onAdExpanded", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdHidden(@NonNull MaxAd maxAd) {
        z6.a("onAdHidden", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoadFailed(@NonNull String str, @NonNull MaxError maxError) {
        this.f5426p.setControlState(AdControlButton.b.LOAD);
        this.f5427q.setText("");
        if (204 == maxError.getCode()) {
            z6.a("No Fill", "No fills often happen in live environments. Please make sure to use the Mediation Debugger test mode before you go live.", this);
            return;
        }
        z6.a("", "Failed to load with error code: " + maxError.getCode(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(@NonNull MaxAd maxAd) {
        this.f5427q.setText(maxAd.getNetworkName() + " ad loaded");
        this.f5426p.setControlState(AdControlButton.b.SHOW);
        if (maxAd.getFormat().isAdViewAd()) {
            a(this.f5415e, maxAd.getFormat().getSize());
        } else if (MaxAdFormat.NATIVE == this.f5412b.a()) {
            a(this.f5419i, MaxAdFormat.MREC.getSize());
        }
    }

    @Override // com.applovin.impl.u.a
    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            this.f5415e.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f5416f.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f5417g.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f5418h.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f5420j.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        }
        a(maxAdFormat);
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(@NonNull MaxAd maxAd) {
        z6.a("onAdRevenuePaid", maxAd, this);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton.a
    public void onClick(AdControlButton adControlButton) {
        if (this.f5411a.l0().c()) {
            z6.a("Not Supported", "Ad loads are not supported while Test Mode is enabled. Please restart the app.", this);
            return;
        }
        if (this.f5414d.j() != this.f5412b.f()) {
            z6.a("Not Supported", "You cannot load an ad from this waterfall because it does not target the current device. To load an ad, please select the targeted waterfall.", this);
            return;
        }
        MaxAdFormat maxAdFormatA = this.f5412b.a();
        AdControlButton.b bVar = AdControlButton.b.LOAD;
        if (bVar == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOADING);
            u uVar = this.f5428r;
            if (uVar != null) {
                uVar.a();
                return;
            } else {
                a(maxAdFormatA);
                return;
            }
        }
        if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
            if (!maxAdFormatA.isAdViewAd() && maxAdFormatA != MaxAdFormat.NATIVE) {
                adControlButton.setControlState(bVar);
            }
            b(maxAdFormatA);
        }
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_ad_unit_detail_activity);
        setTitle(this.f5414d.k());
        this.f5424n = (ListView) findViewById(R.id.listView);
        this.f5425o = findViewById(R.id.ad_presenter_view);
        this.f5426p = (AdControlButton) findViewById(R.id.ad_control_button);
        this.f5427q = (TextView) findViewById(R.id.status_textview);
        this.f5424n.setAdapter((ListAdapter) this.f5414d);
        this.f5427q.setText(a());
        this.f5427q.setTypeface(Typeface.DEFAULT_BOLD);
        this.f5426p.setOnClickListener(this);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 10, 0, 0);
        shapeDrawable.getPaint().setColor(-1);
        shapeDrawable.getPaint().setShadowLayer(10, 0.0f, -10, 855638016);
        shapeDrawable.setShape(new RectShape());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable});
        layerDrawable.setLayerInset(0, 0, 10, 0, 0);
        this.f5425o.setBackground(layerDrawable);
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f5413c != null) {
            this.f5411a.l0().a(this.f5423m);
        }
        MaxAdView maxAdView = this.f5415e;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f5416f;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxAppOpenAd maxAppOpenAd = this.f5417g;
        if (maxAppOpenAd != null) {
            maxAppOpenAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f5418h;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.f5420j;
        if (maxNativeAdLoader != null) {
            MaxAd maxAd = this.f5421k;
            if (maxAd != null) {
                maxNativeAdLoader.destroy(maxAd);
            }
            this.f5420j.destroy();
        }
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onUserRewarded(@NonNull MaxAd maxAd, @NonNull MaxReward maxReward) {
        z6.a("onUserRewarded", maxAd, this);
    }

    private void b() {
        String strC = this.f5412b.c();
        if (this.f5412b.a().isAdViewAd()) {
            MaxAdView maxAdView = new MaxAdView(strC, this.f5412b.a(), this.f5411a.r0(), this);
            this.f5415e = maxAdView;
            maxAdView.setExtraParameter("adaptive_banner", "false");
            this.f5415e.setExtraParameter("disable_auto_retries", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f5415e.setExtraParameter("disable_precache", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f5415e.setExtraParameter("allow_pause_auto_refresh_immediately", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f5415e.stopAutoRefresh();
            this.f5415e.setListener(this);
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == this.f5412b.a()) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(strC, this.f5411a.r0(), this);
            this.f5416f = maxInterstitialAd;
            maxInterstitialAd.setExtraParameter("disable_auto_retries", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f5416f.setListener(this);
            return;
        }
        if (MaxAdFormat.APP_OPEN == this.f5412b.a()) {
            MaxAppOpenAd maxAppOpenAd = new MaxAppOpenAd(strC, this.f5411a.r0());
            this.f5417g = maxAppOpenAd;
            maxAppOpenAd.setExtraParameter("disable_auto_retries", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f5417g.setListener(this);
            return;
        }
        if (MaxAdFormat.REWARDED == this.f5412b.a()) {
            MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(strC, this.f5411a.r0(), this);
            this.f5418h = maxRewardedAd;
            maxRewardedAd.setExtraParameter("disable_auto_retries", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f5418h.setListener(this);
            return;
        }
        if (MaxAdFormat.NATIVE == this.f5412b.a()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(strC, this.f5411a.r0(), this);
            this.f5420j = maxNativeAdLoader;
            maxNativeAdLoader.setExtraParameter("disable_auto_retries", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f5420j.setNativeAdListener(new a());
            this.f5420j.setRevenueListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.applovin.impl.sdk.j jVar, final l lVar, final m mVar, d2 d2Var, final j2 j2Var) {
        if (j2Var instanceof k.b) {
            d.a(this, MaxDebuggerAdUnitDetailActivity.class, jVar.e(), new d.b() { // from class: com.applovin.impl.z9
                @Override // com.applovin.impl.d.b
                public final void a(Activity activity) {
                    j.a(j2Var, lVar, mVar, jVar, (MaxDebuggerAdUnitDetailActivity) activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(j2 j2Var, l lVar, m mVar, com.applovin.impl.sdk.j jVar, MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
        maxDebuggerAdUnitDetailActivity.initialize(lVar, mVar, ((k.b) j2Var).v(), jVar);
    }

    @Override // com.applovin.impl.u.a
    public void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            this.f5415e.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f5416f.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f5417g.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f5418h.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f5420j.setLocalExtraParameter("amazon_ad_error", adError);
        }
        a(maxAdFormat);
    }

    private void a(MaxAdFormat maxAdFormat) {
        StringBuilder sb = new StringBuilder();
        sb.append("Loading live ");
        sb.append(maxAdFormat.getDisplayName());
        sb.append(" Ad from ");
        u7 u7Var = this.f5413c;
        sb.append(u7Var != null ? u7Var.b().a() : this.f5414d.j().c());
        com.applovin.impl.sdk.n.g("MaxDebuggerAdUnitDetailActivity", sb.toString());
        if (this.f5413c != null) {
            this.f5411a.l0().a(this.f5413c.b().b());
        }
        if (maxAdFormat.isAdViewAd()) {
            this.f5415e.setPlacement("[Mediation Debugger Live Ad]");
            this.f5415e.loadAd();
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == this.f5412b.a()) {
            this.f5416f.loadAd();
            return;
        }
        if (MaxAdFormat.APP_OPEN == this.f5412b.a()) {
            this.f5417g.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED == this.f5412b.a()) {
            this.f5418h.loadAd();
        } else if (MaxAdFormat.NATIVE == this.f5412b.a()) {
            this.f5420j.setPlacement("[Mediation Debugger Live Ad]");
            this.f5420j.loadAd();
        } else {
            z6.a("Live ads currently unavailable for ad format", this);
        }
    }

    private void a(ViewGroup viewGroup, AppLovinSdkUtils.Size size) {
        if (this.f5422l != null) {
            return;
        }
        p pVar = new p(viewGroup, size, this);
        this.f5422l = pVar;
        pVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.aa
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f4737a.a(dialogInterface);
            }
        });
        this.f5422l.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.f5422l = null;
    }

    private String a() {
        return this.f5411a.l0().c() ? "Not supported while Test Mode is enabled" : this.f5414d.j() != this.f5412b.f() ? "This waterfall is not targeted for the current device" : "Tap to load an ad";
    }

    private void b(MaxAdFormat maxAdFormat) {
        StringBuilder sb = new StringBuilder();
        sb.append("Showing live ");
        sb.append(maxAdFormat.getDisplayName());
        sb.append(" Ad from ");
        u7 u7Var = this.f5413c;
        sb.append(u7Var != null ? u7Var.b().a() : this.f5414d.j().c());
        com.applovin.impl.sdk.n.g("MaxDebuggerAdUnitDetailActivity", sb.toString());
        if (maxAdFormat.isAdViewAd()) {
            a(this.f5415e, maxAdFormat.getSize());
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == this.f5412b.a()) {
            this.f5416f.showAd("[Mediation Debugger Live Ad]");
            return;
        }
        if (MaxAdFormat.APP_OPEN == this.f5412b.a()) {
            this.f5417g.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.REWARDED == this.f5412b.a()) {
            this.f5418h.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.NATIVE == this.f5412b.a()) {
            a(this.f5419i, MaxAdFormat.MREC.getSize());
        }
    }
}
