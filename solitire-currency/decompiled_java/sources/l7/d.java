package l7;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: ScarBannerAdListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.unity3d.scar.adapter.common.g f30917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f30918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AdListener f30919d = new a();

    /* JADX INFO: compiled from: ScarBannerAdListener.java */
    class a extends AdListener {
        a() {
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
        public void onAdClicked() {
            super.onAdClicked();
            d.this.f30917b.onAdClicked();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            super.onAdClosed();
            d.this.f30917b.onAdClosed();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            d.this.f30918c.e();
            d.this.f30917b.onAdFailedToLoad(loadAdError.getCode(), loadAdError.getMessage());
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            super.onAdImpression();
            d.this.f30917b.onAdImpression();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            super.onAdLoaded();
            d.this.f30917b.onAdLoaded();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            super.onAdOpened();
            d.this.f30917b.onAdOpened();
        }
    }

    public d(com.unity3d.scar.adapter.common.g gVar, c cVar) {
        this.f30917b = gVar;
        this.f30918c = cVar;
    }

    public AdListener d() {
        return this.f30919d;
    }
}
