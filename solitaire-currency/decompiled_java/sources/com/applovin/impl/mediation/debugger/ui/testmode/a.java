package com.applovin.impl.mediation.debugger.ui.testmode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.d3;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.u;
import com.applovin.impl.v;
import com.applovin.impl.v2;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends d3 implements MaxRewardedAdListener, MaxAdViewAdListener, AdControlButton.a, MaxAdRevenueListener, u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private v2 f6151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f6152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MaxAdView f6153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MaxAdView f6154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MaxInterstitialAd f6155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxAppOpenAd f6156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxRewardedAd f6157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MaxAd f6158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MaxNativeAdLoader f6159i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List f6160j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f6161k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AdControlButton f6162l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private AdControlButton f6163m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AdControlButton f6164n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AdControlButton f6165o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AdControlButton f6166p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AdControlButton f6167q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Button f6168r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Button f6169s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private FrameLayout f6170t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private FrameLayout f6171u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Switch f6172v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Switch f6173w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Map f6174x;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.ui.testmode.a$a, reason: collision with other inner class name */
    class C0167a extends MaxNativeAdListener {
        C0167a() {
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdClicked(MaxAd maxAd) {
            a.this.onAdClicked(maxAd);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoadFailed(String str, MaxError maxError) {
            a.this.onAdLoadFailed(str, maxError);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
            if (a.this.f6158h != null) {
                a.this.f6159i.destroy(a.this.f6158h);
            }
            a.this.f6158h = maxAd;
            a.this.f6171u.removeAllViews();
            a.this.f6171u.addView(maxNativeAdView);
            a.this.onAdLoaded(maxAd);
        }
    }

    private void e() {
        List listR = this.f6151a.r();
        MaxAdFormat maxAdFormat = MaxAdFormat.REWARDED;
        if (!listR.contains(maxAdFormat)) {
            findViewById(R.id.rewarded_control_view).setVisibility(8);
            return;
        }
        String str = "test_mode_rewarded_" + this.f6151a.m();
        this.f6161k = str;
        MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(str, this.f6152b.r0(), this);
        this.f6157g = maxRewardedAd;
        maxRewardedAd.setExtraParameter("disable_auto_retries", com.ironsource.mediationsdk.metadata.a.f13688g);
        this.f6157g.setListener(this);
        AdControlButton adControlButton = (AdControlButton) findViewById(R.id.rewarded_control_button);
        this.f6166p = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f6166p.setFormat(maxAdFormat);
    }

    @Override // com.applovin.impl.d3
    protected j getSdk() {
        return this.f6152b;
    }

    public String getTestModeNetwork(MaxAdFormat maxAdFormat) {
        return (this.f6151a.x() == null || !this.f6151a.x().containsKey(maxAdFormat)) ? this.f6151a.m() : (String) this.f6151a.x().get(maxAdFormat);
    }

    public void initialize(v2 v2Var) {
        this.f6151a = v2Var;
        this.f6152b = v2Var.o();
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
    public void onAdDisplayFailed(@NonNull MaxAd maxAd, @NonNull MaxError maxError) {
        a(maxAd.getAdUnitId()).setControlState(AdControlButton.b.LOAD);
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
        AdControlButton adControlButtonA = a(str);
        adControlButtonA.setControlState(AdControlButton.b.LOAD);
        z6.a(maxError, adControlButtonA.getFormat().getLabel(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(@NonNull MaxAd maxAd) {
        AdControlButton adControlButtonA = a(maxAd.getAdUnitId());
        if (maxAd.getFormat().isAdViewAd() || maxAd.getFormat().equals(MaxAdFormat.NATIVE)) {
            adControlButtonA.setControlState(AdControlButton.b.LOAD);
        } else {
            adControlButtonA.setControlState(AdControlButton.b.SHOW);
        }
    }

    @Override // com.applovin.impl.u.a
    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.f6153c.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            this.f6154d.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f6155e.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f6156f.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f6157g.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f6159i.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        }
        a(maxAdFormat);
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(@NonNull MaxAd maxAd) {
        z6.a("onAdRevenuePaid", maxAd, this);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton.a
    public void onClick(AdControlButton adControlButton) {
        MaxAdFormat format = adControlButton.getFormat();
        AdControlButton.b bVar = AdControlButton.b.LOAD;
        if (bVar != adControlButton.getControlState()) {
            if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
                adControlButton.setControlState(bVar);
                b(format);
                return;
            }
            return;
        }
        adControlButton.setControlState(AdControlButton.b.LOADING);
        Map map = this.f6174x;
        if (map == null || map.get(format) == null) {
            a(format);
        } else {
            ((u) this.f6174x.get(format)).a();
        }
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f6151a == null) {
            n.h("MaxDebuggerMultiAdActivity", "Failed to initialize activity with a network model.");
            return;
        }
        setContentView(R.layout.mediation_debugger_multi_ad_activity);
        setTitle(this.f6151a.g() + " Test Ads");
        this.f6160j = this.f6152b.l0().b();
        a();
        c();
        b();
        e();
        d();
        findViewById(R.id.app_open_ad_control_view).setVisibility(8);
        this.f6168r = (Button) findViewById(R.id.show_mrec_button);
        this.f6169s = (Button) findViewById(R.id.show_native_button);
        if (this.f6151a.J() && this.f6151a.r().contains(MaxAdFormat.MREC)) {
            this.f6171u.setVisibility(8);
            this.f6168r.setBackgroundColor(-1);
            this.f6169s.setBackgroundColor(-3355444);
            this.f6168r.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f6176a.a(view);
                }
            });
            this.f6169s.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f6177a.b(view);
                }
            });
        } else {
            this.f6168r.setVisibility(8);
            this.f6169s.setVisibility(8);
        }
        this.f6172v = (Switch) findViewById(R.id.native_banner_switch);
        this.f6173w = (Switch) findViewById(R.id.native_mrec_switch);
        if (this.f6151a.K()) {
            this.f6172v.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f6178a.c(view);
                }
            });
            this.f6173w.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f6179a.d(view);
                }
            });
        } else {
            this.f6172v.setVisibility(8);
            this.f6173w.setVisibility(8);
        }
        if (StringUtils.isValidString(this.f6151a.e()) && this.f6151a.d() != null && this.f6151a.d().size() > 0) {
            AdRegistration.getInstance(this.f6151a.e(), this);
            AdRegistration.enableTesting(true);
            AdRegistration.enableLogging(true);
            HashMap map = new HashMap(this.f6151a.d().size());
            for (MaxAdFormat maxAdFormat : this.f6151a.d().keySet()) {
                map.put(maxAdFormat, new u((v) this.f6151a.d().get(maxAdFormat), maxAdFormat, getApplicationContext(), this));
            }
            this.f6174x = map;
        }
        try {
            setRequestedOrientation(7);
        } catch (Throwable th) {
            n.c("AppLovinSdk", "Failed to set portrait orientation", th);
        }
    }

    @Override // com.applovin.impl.d3, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f6152b.l0().a(this.f6160j);
        MaxAdView maxAdView = this.f6153c;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxAdView maxAdView2 = this.f6154d;
        if (maxAdView2 != null) {
            maxAdView2.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f6155e;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f6157g;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.f6159i;
        if (maxNativeAdLoader != null) {
            MaxAd maxAd = this.f6158h;
            if (maxAd != null) {
                maxNativeAdLoader.destroy(maxAd);
            }
            this.f6159i.destroy();
        }
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onUserRewarded(@NonNull MaxAd maxAd, @NonNull MaxReward maxReward) {
        z6.a("onUserRewarded", maxAd, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        this.f6154d.removeAllViews();
        this.f6163m.setControlState(AdControlButton.b.LOAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f6171u.setVisibility(0);
        this.f6170t.setVisibility(8);
        this.f6169s.setBackgroundColor(-1);
        this.f6168r.setBackgroundColor(-3355444);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.f6153c.removeAllViews();
        this.f6162l.setControlState(AdControlButton.b.LOAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f6170t.setVisibility(0);
        this.f6171u.setVisibility(8);
        this.f6168r.setBackgroundColor(-1);
        this.f6169s.setBackgroundColor(-3355444);
    }

    private void d() {
        this.f6171u = (FrameLayout) findViewById(R.id.native_ad_view_container);
        if (this.f6151a.J()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader("test_mode_native", this.f6152b.r0(), this);
            this.f6159i = maxNativeAdLoader;
            maxNativeAdLoader.setExtraParameter("disable_auto_retries", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f6159i.setNativeAdListener(new C0167a());
            this.f6159i.setRevenueListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.native_control_button);
            this.f6167q = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f6167q.setFormat(MaxAdFormat.NATIVE);
            return;
        }
        findViewById(R.id.native_control_view).setVisibility(8);
        this.f6171u.setVisibility(8);
    }

    @Override // com.applovin.impl.u.a
    public void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.BANNER != maxAdFormat && MaxAdFormat.LEADER != maxAdFormat) {
            if (MaxAdFormat.MREC == maxAdFormat) {
                this.f6154d.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
                this.f6155e.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
                this.f6156f.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.REWARDED == maxAdFormat) {
                this.f6157g.setLocalExtraParameter("amazon_ad_error", adError);
            } else if (MaxAdFormat.NATIVE == maxAdFormat) {
                this.f6159i.setLocalExtraParameter("amazon_ad_error", adError);
            }
        } else {
            this.f6153c.setLocalExtraParameter("amazon_ad_error", adError);
        }
        a(maxAdFormat);
    }

    private void c() {
        this.f6170t = (FrameLayout) findViewById(R.id.mrec_ad_view_container);
        List listR = this.f6151a.r();
        MaxAdFormat maxAdFormat = MaxAdFormat.MREC;
        if (listR.contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView("test_mode_mrec", maxAdFormat, this.f6152b.r0(), this);
            this.f6154d = maxAdView;
            maxAdView.setExtraParameter("disable_auto_retries", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f6154d.setExtraParameter("disable_precache", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f6154d.setExtraParameter("allow_pause_auto_refresh_immediately", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f6154d.stopAutoRefresh();
            this.f6154d.setListener(this);
            this.f6170t.addView(this.f6154d, new FrameLayout.LayoutParams(-1, -1));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.mrec_control_button);
            this.f6163m = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f6163m.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.mrec_control_view).setVisibility(8);
        this.f6170t.setVisibility(8);
    }

    private void b() {
        List listR = this.f6151a.r();
        MaxAdFormat maxAdFormat = MaxAdFormat.INTERSTITIAL;
        if (listR.contains(maxAdFormat)) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd("test_mode_interstitial", this.f6152b.r0(), this);
            this.f6155e = maxInterstitialAd;
            maxInterstitialAd.setExtraParameter("disable_auto_retries", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f6155e.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.interstitial_control_button);
            this.f6164n = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f6164n.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.interstitial_control_view).setVisibility(8);
    }

    private void a() {
        MaxAdFormat maxAdFormat;
        String str;
        boolean zIsTablet = AppLovinSdkUtils.isTablet(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_ad_view_container);
        if (zIsTablet) {
            maxAdFormat = MaxAdFormat.LEADER;
            ((TextView) findViewById(R.id.banner_label)).setText("Leader");
            str = "test_mode_leader";
        } else {
            maxAdFormat = MaxAdFormat.BANNER;
            str = "test_mode_banner";
        }
        if (this.f6151a.r().contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView(str, maxAdFormat, this.f6152b.r0(), this);
            this.f6153c = maxAdView;
            maxAdView.setExtraParameter("adaptive_banner", "false");
            this.f6153c.setExtraParameter("disable_auto_retries", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f6153c.setExtraParameter("disable_precache", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f6153c.setExtraParameter("allow_pause_auto_refresh_immediately", com.ironsource.mediationsdk.metadata.a.f13688g);
            this.f6153c.stopAutoRefresh();
            this.f6153c.setListener(this);
            frameLayout.addView(this.f6153c, new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getHeight())));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.banner_control_button);
            this.f6162l = adControlButton;
            adControlButton.setOnClickListener(this);
            this.f6162l.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.banner_control_view).setVisibility(8);
        frameLayout.setVisibility(8);
    }

    private void b(MaxAdFormat maxAdFormat) {
        n.g("MaxDebuggerMultiAdActivity", "Showing test " + maxAdFormat.getDisplayName() + " Ad from " + this.f6151a.g());
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f6155e.showAd();
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f6156f.showAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f6157g.showAd();
        }
    }

    private void a(MaxAdFormat maxAdFormat) {
        n.g("MaxDebuggerMultiAdActivity", "Loading test " + maxAdFormat.getDisplayName() + " Ad from " + this.f6151a.g());
        MaxAdFormat maxAdFormat2 = MaxAdFormat.BANNER;
        boolean z10 = (maxAdFormat2 == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) && this.f6172v.isChecked();
        MaxAdFormat maxAdFormat3 = MaxAdFormat.MREC;
        boolean z11 = maxAdFormat3 == maxAdFormat && this.f6173w.isChecked();
        if (!z10 && !z11) {
            this.f6152b.l0().a(getTestModeNetwork(maxAdFormat));
        } else {
            this.f6152b.l0().a(this.f6151a.w());
        }
        if (maxAdFormat2 == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.f6153c.loadAd();
            return;
        }
        if (maxAdFormat3 == maxAdFormat) {
            this.f6154d.loadAd();
            this.f6168r.callOnClick();
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f6155e.loadAd();
            return;
        }
        if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f6156f.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f6157g.loadAd();
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f6159i.loadAd();
            this.f6169s.callOnClick();
        }
    }

    private AdControlButton a(String str) {
        if (!str.equals("test_mode_banner") && !str.equals("test_mode_leader")) {
            if (str.equals("test_mode_mrec")) {
                return this.f6163m;
            }
            if (str.equals("test_mode_interstitial")) {
                return this.f6164n;
            }
            if (str.equals("test_mode_app_open")) {
                return this.f6165o;
            }
            if (str.equals(this.f6161k)) {
                return this.f6166p;
            }
            if (str.equals("test_mode_native")) {
                return this.f6167q;
            }
            throw new IllegalArgumentException("Invalid test mode ad unit identifier provided " + str);
        }
        return this.f6162l;
    }
}
