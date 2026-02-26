package u1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.ads.mediation.vungle.c;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.vungle.ads.b2;
import com.vungle.ads.n0;
import com.vungle.ads.p0;
import com.vungle.ads.u;

/* JADX INFO: compiled from: VungleRtbInterstitialAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements MediationInterstitialAd, p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final MediationInterstitialAdConfiguration f34461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> f34462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private MediationInterstitialAdCallback f34463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n0 f34464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.ads.mediation.vungle.b f34465e;

    /* JADX INFO: compiled from: VungleRtbInterstitialAd.java */
    class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f34466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.vungle.ads.c f34468c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f34469d;

        a(Context context, String str, com.vungle.ads.c cVar, String str2) {
            this.f34466a = context;
            this.f34467b = str;
            this.f34468c = cVar;
            this.f34469d = str2;
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void a(AdError adError) {
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            c.this.f34462b.onFailure(adError);
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void onInitializeSuccess() {
            c cVar = c.this;
            cVar.f34464d = cVar.f34465e.c(this.f34466a, this.f34467b, this.f34468c);
            c.this.f34464d.setAdListener(c.this);
            c.this.f34464d.load(this.f34469d);
        }
    }

    public c(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, com.google.ads.mediation.vungle.b bVar) {
        this.f34461a = mediationInterstitialAdConfiguration;
        this.f34462b = mediationAdLoadCallback;
        this.f34465e = bVar;
    }

    public void e() {
        Bundle mediationExtras = this.f34461a.getMediationExtras();
        Bundle serverParameters = this.f34461a.getServerParameters();
        String string = serverParameters.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Failed to load bidding interstitial ad from Liftoff Monetize. Missing or invalid App ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.f34462b.onFailure(adError);
            return;
        }
        String string2 = serverParameters.getString("placementID");
        if (TextUtils.isEmpty(string2)) {
            AdError adError2 = new AdError(101, "Failed to load bidding interstitial ad from Liftoff Monetize. Missing or Invalid Placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError2.toString());
            this.f34462b.onFailure(adError2);
            return;
        }
        String bidResponse = this.f34461a.getBidResponse();
        com.vungle.ads.c cVarA = this.f34465e.a();
        if (mediationExtras.containsKey("adOrientation")) {
            cVarA.setAdOrientation(mediationExtras.getInt("adOrientation", 2));
        }
        String watermark = this.f34461a.getWatermark();
        if (!TextUtils.isEmpty(watermark)) {
            cVarA.setWatermark(watermark);
        }
        Context context = this.f34461a.getContext();
        com.google.ads.mediation.vungle.c.a().b(string, context, new a(context, string2, cVarA, bidResponse));
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdClicked(@NonNull u uVar) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f34463c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdClicked();
        }
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdEnd(@NonNull u uVar) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f34463c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdFailedToLoad(@NonNull u uVar, @NonNull b2 b2Var) {
        AdError adError = VungleMediationAdapter.getAdError(b2Var);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        this.f34462b.onFailure(adError);
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdFailedToPlay(@NonNull u uVar, @NonNull b2 b2Var) {
        AdError adError = VungleMediationAdapter.getAdError(b2Var);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f34463c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adError);
        }
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdImpression(@NonNull u uVar) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f34463c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdImpression();
        }
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdLeftApplication(@NonNull u uVar) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f34463c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdLeftApplication();
        }
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdLoaded(@NonNull u uVar) {
        this.f34463c = this.f34462b.onSuccess(this);
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdStart(@NonNull u uVar) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f34463c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(@NonNull Context context) {
        n0 n0Var = this.f34464d;
        if (n0Var != null) {
            n0Var.play(context);
        } else if (this.f34463c != null) {
            AdError adError = new AdError(107, "Failed to show bidding rewarded ad from Liftoff Monetize.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.f34463c.onAdFailedToShow(adError);
        }
    }
}
