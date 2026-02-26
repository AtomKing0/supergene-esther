package d7;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: ScarBannerAdListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.unity3d.scar.adapter.common.g f24512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f24513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AdListener f24514d = new a();

    /* JADX INFO: compiled from: ScarBannerAdListener.java */
    class a extends AdListener {
        a() {
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
        public void onAdClicked() {
            super.onAdClicked();
            d.this.f24512b.onAdClicked();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            super.onAdClosed();
            d.this.f24512b.onAdClosed();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            d.this.f24513c.e();
            d.this.f24512b.onAdFailedToLoad(loadAdError.getCode(), loadAdError.getMessage());
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            super.onAdImpression();
            d.this.f24512b.onAdImpression();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            super.onAdLoaded();
            d.this.f24512b.onAdLoaded();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            super.onAdOpened();
            d.this.f24512b.onAdOpened();
        }
    }

    public d(com.unity3d.scar.adapter.common.g gVar, c cVar) {
        this.f24512b = gVar;
        this.f24513c = cVar;
    }

    public AdListener d() {
        return this.f24514d;
    }
}
