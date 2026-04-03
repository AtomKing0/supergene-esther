package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdiv implements zzgcf {
    final /* synthetic */ View zza;
    final /* synthetic */ zzdiw zzb;

    zzdiv(zzdiw zzdiwVar, View view) {
        this.zza = view;
        this.zzb = zzdiwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeI)).booleanValue()) {
            com.google.android.gms.ads.internal.zzu.zzo().zzv(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzac(this.zza, (zzeeo) obj);
    }
}
