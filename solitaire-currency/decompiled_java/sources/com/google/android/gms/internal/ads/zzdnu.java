package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdnu implements zzgcf {
    final /* synthetic */ zzfel zza;
    final /* synthetic */ zzfeo zzb;
    final /* synthetic */ zzcni zzc;
    final /* synthetic */ zzdoa zzd;

    zzdnu(zzdoa zzdoaVar, zzfel zzfelVar, zzfeo zzfeoVar, zzcni zzcniVar) {
        this.zza = zzfelVar;
        this.zzb = zzfeoVar;
        this.zzc = zzcniVar;
        this.zzd = zzdoaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcej zzcejVar = (zzcej) obj;
        zzcejVar.zzW(this.zza, this.zzb);
        zzcgb zzcgbVarZzN = zzcejVar.zzN();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjk)).booleanValue() || zzcgbVarZzN == null) {
            return;
        }
        zzcni zzcniVar = this.zzc;
        zzdoa zzdoaVar = this.zzd;
        zzcgbVarZzN.zzI(zzcniVar, zzdoaVar.zzi, zzdoaVar.zzj);
        zzcni zzcniVar2 = this.zzc;
        zzdoa zzdoaVar2 = this.zzd;
        zzcgbVarZzN.zzK(zzcniVar2, zzdoaVar2.zzi, zzdoaVar2.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
    }
}
