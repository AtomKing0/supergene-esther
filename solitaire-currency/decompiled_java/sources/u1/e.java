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
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.vungle.ads.b2;
import com.vungle.ads.q1;
import com.vungle.ads.s1;
import com.vungle.ads.u;

/* JADX INFO: compiled from: VungleRtbRewardedAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements MediationRewardedAd, s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final MediationRewardedAdConfiguration f34484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> f34485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private MediationRewardedAdCallback f34486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private q1 f34487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.ads.mediation.vungle.b f34488e;

    /* JADX INFO: compiled from: VungleRtbRewardedAd.java */
    class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f34489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.vungle.ads.c f34491c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f34492d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f34493e;

        a(Context context, String str, com.vungle.ads.c cVar, String str2, String str3) {
            this.f34489a = context;
            this.f34490b = str;
            this.f34491c = cVar;
            this.f34492d = str2;
            this.f34493e = str3;
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void a(AdError adError) {
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            e.this.f34485b.onFailure(adError);
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void onInitializeSuccess() {
            e eVar = e.this;
            eVar.f34487d = eVar.f34488e.e(this.f34489a, this.f34490b, this.f34491c);
            e.this.f34487d.setAdListener(e.this);
            if (!TextUtils.isEmpty(this.f34492d)) {
                e.this.f34487d.setUserId(this.f34492d);
            }
            e.this.f34487d.load(this.f34493e);
        }
    }

    public e(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, com.google.ads.mediation.vungle.b bVar) {
        this.f34484a = mediationRewardedAdConfiguration;
        this.f34485b = mediationAdLoadCallback;
        this.f34488e = bVar;
    }

    public void e() {
        Bundle mediationExtras = this.f34484a.getMediationExtras();
        Bundle serverParameters = this.f34484a.getServerParameters();
        String string = mediationExtras.getString("userId");
        String string2 = serverParameters.getString("appid");
        if (TextUtils.isEmpty(string2)) {
            AdError adError = new AdError(101, "Failed to load bidding rewarded ad from Liftoff Monetize. Missing or invalid App ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.f34485b.onFailure(adError);
            return;
        }
        String string3 = serverParameters.getString("placementID");
        if (TextUtils.isEmpty(string3)) {
            AdError adError2 = new AdError(101, "Failed to load bidding rewarded ad from Liftoff Monetize. Missing or invalid Placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError2.toString());
            this.f34485b.onFailure(adError2);
            return;
        }
        String bidResponse = this.f34484a.getBidResponse();
        com.vungle.ads.c cVarA = this.f34488e.a();
        if (mediationExtras.containsKey("adOrientation")) {
            cVarA.setAdOrientation(mediationExtras.getInt("adOrientation", 2));
        }
        String watermark = this.f34484a.getWatermark();
        if (!TextUtils.isEmpty(watermark)) {
            cVarA.setWatermark(watermark);
        }
        Context context = this.f34484a.getContext();
        com.google.ads.mediation.vungle.c.a().b(string2, context, new a(context, string3, cVarA, string, bidResponse));
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdClicked(@NonNull u uVar) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f34486c;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdEnd(@NonNull u uVar) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f34486c;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdFailedToLoad(@NonNull u uVar, @NonNull b2 b2Var) {
        AdError adError = VungleMediationAdapter.getAdError(b2Var);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        this.f34485b.onFailure(adError);
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdFailedToPlay(@NonNull u uVar, @NonNull b2 b2Var) {
        AdError adError = VungleMediationAdapter.getAdError(b2Var);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f34486c;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdFailedToShow(adError);
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdImpression(@NonNull u uVar) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f34486c;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onVideoStart();
            this.f34486c.reportAdImpression();
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdLoaded(@NonNull u uVar) {
        this.f34486c = this.f34485b.onSuccess(this);
    }

    @Override // com.vungle.ads.s1
    public void onAdRewarded(@NonNull u uVar) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f34486c;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onVideoComplete();
            this.f34486c.onUserEarnedReward(new VungleMediationAdapter.c("vungle", 1));
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdStart(@NonNull u uVar) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f34486c;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        q1 q1Var = this.f34487d;
        if (q1Var != null) {
            q1Var.play(context);
        } else if (this.f34486c != null) {
            AdError adError = new AdError(107, "Failed to show bidding rewardedad from Liftoff Monetize.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.f34486c.onAdFailedToShow(adError);
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdLeftApplication(@NonNull u uVar) {
    }
}
