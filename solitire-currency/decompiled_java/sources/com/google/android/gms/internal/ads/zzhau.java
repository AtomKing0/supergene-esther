package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhau extends zzhas {
    zzhau() {
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzgxy zzgxyVar = (zzgxy) obj;
        zzhat zzhatVar = zzgxyVar.zzt;
        if (zzhatVar != zzhat.zzc()) {
            return zzhatVar;
        }
        zzhat zzhatVarZzf = zzhat.zzf();
        zzgxyVar.zzt = zzhatVarZzf;
        return zzhatVarZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final /* synthetic */ Object zzb() {
        return zzhat.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final /* synthetic */ Object zzc(Object obj) {
        ((zzhat) obj).zzh();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final /* bridge */ /* synthetic */ void zzd(Object obj, int i10, int i11) {
        ((zzhat) obj).zzj((i10 << 3) | 5, Integer.valueOf(i11));
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final /* bridge */ /* synthetic */ void zze(Object obj, int i10, long j10) {
        ((zzhat) obj).zzj((i10 << 3) | 1, Long.valueOf(j10));
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final /* bridge */ /* synthetic */ void zzf(Object obj, int i10, Object obj2) {
        ((zzhat) obj).zzj((i10 << 3) | 3, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final /* bridge */ /* synthetic */ void zzg(Object obj, int i10, zzgwm zzgwmVar) {
        ((zzhat) obj).zzj((i10 << 3) | 2, zzgwmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i10, long j10) {
        ((zzhat) obj).zzj(i10 << 3, Long.valueOf(j10));
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final void zzi(Object obj) {
        ((zzgxy) obj).zzt.zzh();
    }
}
