package l7;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

/* JADX INFO: compiled from: ScarInterstitialAdListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends l7.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f30921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.unity3d.scar.adapter.common.h f30922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterstitialAdLoadCallback f30923d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FullScreenContentCallback f30924e = new b();

    /* JADX INFO: compiled from: ScarInterstitialAdListener.java */
    class a extends InterstitialAdLoadCallback {
        a() {
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
            super.onAdLoaded(interstitialAd);
            f.this.f30922c.onAdLoaded();
            interstitialAd.setFullScreenContentCallback(f.this.f30924e);
            f.this.f30921b.d(interstitialAd);
            a7.b bVar = f.this.f30912a;
            if (bVar != null) {
                bVar.onAdLoaded();
            }
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            f.this.f30922c.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }
    }

    /* JADX INFO: compiled from: ScarInterstitialAdListener.java */
    class b extends FullScreenContentCallback {
        b() {
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            super.onAdClicked();
            f.this.f30922c.onAdClicked();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            f.this.f30922c.onAdClosed();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            f.this.f30922c.onAdFailedToShow(adError.getCode(), adError.toString());
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
            super.onAdImpression();
            f.this.f30922c.onAdImpression();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            f.this.f30922c.onAdOpened();
        }
    }

    public f(com.unity3d.scar.adapter.common.h hVar, e eVar) {
        this.f30922c = hVar;
        this.f30921b = eVar;
    }

    public InterstitialAdLoadCallback e() {
        return this.f30923d;
    }
}
