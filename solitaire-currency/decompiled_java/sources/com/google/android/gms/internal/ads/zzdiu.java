package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdiu implements zzgcf {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdiw zzb;

    zzdiu(zzdiw zzdiwVar, String str, boolean z10) {
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
        this.zzb.zzd.zzT((zzcej) obj);
        zzdiw zzdiwVar = this.zzb;
        zzbzt zzbztVarZzp = zzdiwVar.zzd.zzp();
        zzeeo zzeeoVarZzf = zzdiwVar.zzf(this.zza, true);
        if (zzeeoVarZzf != null && zzbztVarZzp != null) {
            zzbztVarZzp.zzc(zzeeoVarZzf);
        } else if (zzbztVarZzp != null) {
            zzbztVarZzp.cancel(false);
        }
    }
}
