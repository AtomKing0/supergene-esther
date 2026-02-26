package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzffq implements zzgcf {
    final /* synthetic */ zzcej zza;
    final /* synthetic */ zzcni zzb;
    final /* synthetic */ zzfll zzc;
    final /* synthetic */ zzedh zzd;

    zzffq(zzcej zzcejVar, zzcni zzcniVar, zzfll zzfllVar, zzedh zzedhVar) {
        this.zza = zzcejVar;
        this.zzb = zzcniVar;
        this.zzc = zzfllVar;
        this.zzd = zzedhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzD().zzai) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjg)).booleanValue() && this.zzb != null && zzcni.zzj(str)) {
                this.zzb.zzi(str, this.zzc, com.google.android.gms.ads.internal.client.zzay.zze());
                return;
            } else {
                this.zzc.zzc(str, null);
                return;
            }
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
        String str2 = this.zza.zzR().zzb;
        int i10 = 2;
        if (!com.google.android.gms.ads.internal.zzu.zzo().zzA(this.zza.getContext())) {
            if ((!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfD)).booleanValue() || !this.zza.zzD().zzS) && this.zza.zzD().zzad == null) {
                i10 = 1;
            }
        }
        this.zzd.zzd(new zzedj(jCurrentTimeMillis, str2, str, i10));
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
    }
}
