package h7;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: ScarBannerAdListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.unity3d.scar.adapter.common.g f26481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f26482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AdListener f26483d = new a();

    /* JADX INFO: compiled from: ScarBannerAdListener.java */
    class a extends AdListener {
        a() {
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
        public void onAdClicked() {
            super.onAdClicked();
            d.this.f26481b.onAdClicked();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            super.onAdClosed();
            d.this.f26481b.onAdClosed();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            d.this.f26482c.e();
            d.this.f26481b.onAdFailedToLoad(loadAdError.getCode(), loadAdError.getMessage());
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            super.onAdImpression();
            d.this.f26481b.onAdImpression();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            super.onAdLoaded();
            d.this.f26481b.onAdLoaded();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            super.onAdOpened();
            d.this.f26481b.onAdOpened();
        }
    }

    public d(com.unity3d.scar.adapter.common.g gVar, c cVar) {
        this.f26481b = gVar;
        this.f26482c = cVar;
    }

    public AdListener d() {
        return this.f26483d;
    }
}
