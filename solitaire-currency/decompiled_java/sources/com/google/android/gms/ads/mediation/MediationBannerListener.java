package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface MediationBannerListener {
    void onAdClicked(@NonNull MediationBannerAdapter mediationBannerAdapter);

    void onAdClosed(@NonNull MediationBannerAdapter mediationBannerAdapter);

    @Deprecated
    void onAdFailedToLoad(@NonNull MediationBannerAdapter mediationBannerAdapter, int i10);

    void onAdFailedToLoad(@NonNull MediationBannerAdapter mediationBannerAdapter, @NonNull AdError adError);

    void onAdLeftApplication(@NonNull MediationBannerAdapter mediationBannerAdapter);

    void onAdLoaded(@NonNull MediationBannerAdapter mediationBannerAdapter);

    void onAdOpened(@NonNull MediationBannerAdapter mediationBannerAdapter);

    void zzb(@NonNull MediationBannerAdapter mediationBannerAdapter, @NonNull String str, @NonNull String str2);
}
