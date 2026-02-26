package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdwc extends AdListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdwf zzb;

    zzdwc(zzdwf zzdwfVar, String str) {
        this.zza = str;
        this.zzb = zzdwfVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.zzm(zzdwf.zzl(loadAdError), this.zza);
    }
}
