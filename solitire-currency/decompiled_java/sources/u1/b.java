package u1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.ads.mediation.vungle.c;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.vungle.ads.a2;
import com.vungle.ads.b2;
import com.vungle.ads.r;
import com.vungle.ads.u;
import com.vungle.ads.z1;
import com.vungle.mediation.VungleInterstitialAdapter;

/* JADX INFO: compiled from: VungleRtbBannerAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements MediationBannerAd, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationBannerAdConfiguration f34448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> f34449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediationBannerAdCallback f34450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a2 f34451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RelativeLayout f34452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.ads.mediation.vungle.b f34453f;

    /* JADX INFO: compiled from: VungleRtbBannerAd.java */
    class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f34454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AdSize f34456c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ z1 f34457d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f34458e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f34459f;

        a(Context context, String str, AdSize adSize, z1 z1Var, String str2, String str3) {
            this.f34454a = context;
            this.f34455b = str;
            this.f34456c = adSize;
            this.f34457d = z1Var;
            this.f34458e = str2;
            this.f34459f = str3;
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void a(AdError adError) {
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            b.this.f34449b.onFailure(adError);
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void onInitializeSuccess() {
            b.this.c(this.f34454a, this.f34455b, this.f34456c, this.f34457d, this.f34458e, this.f34459f);
        }
    }

    public b(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, com.google.ads.mediation.vungle.b bVar) {
        this.f34448a = mediationBannerAdConfiguration;
        this.f34449b = mediationAdLoadCallback;
        this.f34453f = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, AdSize adSize, z1 z1Var, String str2, String str3) {
        this.f34452e = new RelativeLayout(context);
        int heightInPixels = adSize.getHeightInPixels(context);
        if (heightInPixels <= 0) {
            heightInPixels = Math.round(z1Var.getHeight() * context.getResources().getDisplayMetrics().density);
        }
        this.f34452e.setLayoutParams(new RelativeLayout.LayoutParams(adSize.getWidthInPixels(context), heightInPixels));
        a2 a2VarB = this.f34453f.b(context, str, z1Var);
        this.f34451d = a2VarB;
        a2VarB.setAdListener(this);
        if (!TextUtils.isEmpty(str3)) {
            this.f34451d.getAdConfig().setWatermark(str3);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.f34452e.addView(this.f34451d, layoutParams);
        this.f34451d.load(str2);
    }

    public void d() {
        Bundle serverParameters = this.f34448a.getServerParameters();
        String string = serverParameters.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Failed to load bidding banner ad from Liftoff Monetize. Missing or invalid App ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.e(VungleMediationAdapter.TAG, adError.getMessage());
            this.f34449b.onFailure(adError);
            return;
        }
        String string2 = serverParameters.getString("placementID");
        if (TextUtils.isEmpty(string2)) {
            AdError adError2 = new AdError(101, "Failed to load bidding banner ad from Liftoff Monetize. Missing or Invalid Placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.e(VungleMediationAdapter.TAG, adError2.getMessage());
            this.f34449b.onFailure(adError2);
        } else {
            Context context = this.f34448a.getContext();
            AdSize adSize = this.f34448a.getAdSize();
            com.google.ads.mediation.vungle.c.a().b(string, context, new a(context, string2, adSize, VungleInterstitialAdapter.getVungleBannerAdSizeFromGoogleAdSize(adSize, string2), this.f34448a.getBidResponse(), this.f34448a.getWatermark()));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    @NonNull
    public View getView() {
        return this.f34452e;
    }

    @Override // com.vungle.ads.r, com.vungle.ads.v
    public void onAdClicked(@NonNull u uVar) {
        MediationBannerAdCallback mediationBannerAdCallback = this.f34450c;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdClicked();
            this.f34450c.onAdOpened();
        }
    }

    @Override // com.vungle.ads.r, com.vungle.ads.v
    public void onAdFailedToLoad(@NonNull u uVar, @NonNull b2 b2Var) {
        AdError adError = VungleMediationAdapter.getAdError(b2Var);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        this.f34449b.onFailure(adError);
    }

    @Override // com.vungle.ads.r, com.vungle.ads.v
    public void onAdFailedToPlay(@NonNull u uVar, @NonNull b2 b2Var) {
        Log.w(VungleMediationAdapter.TAG, VungleMediationAdapter.getAdError(b2Var).toString());
    }

    @Override // com.vungle.ads.r, com.vungle.ads.v
    public void onAdImpression(@NonNull u uVar) {
        MediationBannerAdCallback mediationBannerAdCallback = this.f34450c;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdImpression();
        }
    }

    @Override // com.vungle.ads.r, com.vungle.ads.v
    public void onAdLeftApplication(@NonNull u uVar) {
        MediationBannerAdCallback mediationBannerAdCallback = this.f34450c;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdLeftApplication();
        }
    }

    @Override // com.vungle.ads.r, com.vungle.ads.v
    public void onAdLoaded(@NonNull u uVar) {
        this.f34450c = this.f34449b.onSuccess(this);
    }

    @Override // com.vungle.ads.r, com.vungle.ads.v
    public void onAdEnd(@NonNull u uVar) {
    }

    @Override // com.vungle.ads.r, com.vungle.ads.v
    public void onAdStart(@NonNull u uVar) {
    }
}
