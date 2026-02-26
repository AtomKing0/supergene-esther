package com.google.ads.mediation;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.zzf;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.formats.zzi;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.internal.ads.zzbfy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class e extends AdListener implements zzi, zzg, zzf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    final AbstractAdViewAdapter f8292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    final MediationNativeListener f8293b;

    public e(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.f8292a = abstractAdViewAdapter;
        this.f8293b = mediationNativeListener;
    }

    @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.f8293b.onAdClicked(this.f8292a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClosed() {
        this.f8293b.onAdClosed(this.f8292a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f8293b.onAdFailedToLoad(this.f8292a, loadAdError);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdImpression() {
        this.f8293b.onAdImpression(this.f8292a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        this.f8293b.onAdOpened(this.f8292a);
    }

    @Override // com.google.android.gms.ads.formats.zzi
    public final void zza(UnifiedNativeAd unifiedNativeAd) {
        this.f8293b.onAdLoaded(this.f8292a, new a(unifiedNativeAd));
    }

    @Override // com.google.android.gms.ads.formats.zzf
    public final void zzb(zzbfy zzbfyVar, String str) {
        this.f8293b.zze(this.f8292a, zzbfyVar, str);
    }

    @Override // com.google.android.gms.ads.formats.zzg
    public final void zzc(zzbfy zzbfyVar) {
        this.f8293b.zzd(this.f8292a, zzbfyVar);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
    }
}
