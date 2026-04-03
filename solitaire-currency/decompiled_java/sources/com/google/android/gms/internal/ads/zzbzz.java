package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbzz implements zzgcf {
    final /* synthetic */ zzbzx zza;
    final /* synthetic */ zzbzv zzb;

    zzbzz(zzcaa zzcaaVar, zzbzx zzbzxVar, zzbzv zzbzvVar) {
        this.zza = zzbzxVar;
        this.zzb = zzbzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(@Nullable Object obj) {
        this.zza.zza(obj);
    }
}
