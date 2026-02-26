package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbhj implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzbu zzb;
    final /* synthetic */ zzbhk zzc;

    zzbhj(zzbhk zzbhkVar, AdManagerAdView adManagerAdView, com.google.android.gms.ads.internal.client.zzbu zzbuVar) {
        this.zza = adManagerAdView;
        this.zzb = zzbuVar;
        this.zzc = zzbhkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.zza.zzb(this.zzb)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not bind.");
            return;
        }
        zzbhk zzbhkVar = this.zzc;
        zzbhkVar.zza.onAdManagerAdViewLoaded(this.zza);
    }
}
