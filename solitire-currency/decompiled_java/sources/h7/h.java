package h7;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.unity3d.scar.adapter.common.i;

/* JADX INFO: compiled from: ScarRewardedAdListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class h extends h7.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f26491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f26492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RewardedAdLoadCallback f26493d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final OnUserEarnedRewardListener f26494e = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FullScreenContentCallback f26495f = new c();

    /* JADX INFO: compiled from: ScarRewardedAdListener.java */
    class a extends RewardedAdLoadCallback {
        a() {
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
            super.onAdLoaded(rewardedAd);
            h.this.f26492c.onAdLoaded();
            rewardedAd.setFullScreenContentCallback(h.this.f26495f);
            h.this.f26491b.d(rewardedAd);
            a7.b bVar = h.this.f26476a;
            if (bVar != null) {
                bVar.onAdLoaded();
            }
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            h.this.f26492c.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }
    }

    /* JADX INFO: compiled from: ScarRewardedAdListener.java */
    class b implements OnUserEarnedRewardListener {
        b() {
        }

        @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
            h.this.f26492c.onUserEarnedReward();
        }
    }

    /* JADX INFO: compiled from: ScarRewardedAdListener.java */
    class c extends FullScreenContentCallback {
        c() {
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            super.onAdClicked();
            h.this.f26492c.onAdClicked();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            h.this.f26492c.onAdClosed();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            h.this.f26492c.onAdFailedToShow(adError.getCode(), adError.toString());
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
            super.onAdImpression();
            h.this.f26492c.onAdImpression();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            h.this.f26492c.onAdOpened();
        }
    }

    public h(i iVar, g gVar) {
        this.f26492c = iVar;
        this.f26491b = gVar;
    }

    public RewardedAdLoadCallback e() {
        return this.f26493d;
    }

    public OnUserEarnedRewardListener f() {
        return this.f26494e;
    }
}
