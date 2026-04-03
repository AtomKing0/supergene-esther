package com.google.ads.mediation;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.mediation.MediationBannerListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class b extends AdListener implements AppEventListener, zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    final AbstractAdViewAdapter f8286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    final MediationBannerListener f8287b;

    public b(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
        this.f8286a = abstractAdViewAdapter;
        this.f8287b = mediationBannerListener;
    }

    @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.f8287b.onAdClicked(this.f8286a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClosed() {
        this.f8287b.onAdClosed(this.f8286a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f8287b.onAdFailedToLoad(this.f8286a, loadAdError);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        this.f8287b.onAdLoaded(this.f8286a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        this.f8287b.onAdOpened(this.f8286a);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(String str, String str2) {
        this.f8287b.zzb(this.f8286a, str, str2);
    }
}
