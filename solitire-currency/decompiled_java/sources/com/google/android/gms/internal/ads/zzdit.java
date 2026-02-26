package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdit implements zzaxw {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdiw zzb;

    zzdit(zzdiw zzdiwVar, String str) {
        this.zza = str;
        this.zzb = zzdiwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxw
    public final void zzdp(zzaxv zzaxvVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbz)).booleanValue()) {
            if (zzaxvVar.zzj) {
                zzdiw zzdiwVar = this.zzb;
                zzdiwVar.zzx.put(this.zza, Boolean.TRUE);
                zzdiw zzdiwVar2 = this.zzb;
                zzdiwVar2.zzB(zzdiwVar2.zzn.zzf(), this.zzb.zzn.zzl(), this.zzb.zzn.zzm(), true);
                return;
            }
            return;
        }
        synchronized (this) {
            if (zzaxvVar.zzj) {
                zzdiw zzdiwVar3 = this.zzb;
                if (zzdiwVar3.zzn == null) {
                    return;
                }
                zzdiwVar3.zzx.put(this.zza, Boolean.TRUE);
                zzdiw zzdiwVar4 = this.zzb;
                zzdiwVar4.zzB(zzdiwVar4.zzn.zzf(), this.zzb.zzn.zzl(), this.zzb.zzn.zzm(), true);
            }
        }
    }
}
