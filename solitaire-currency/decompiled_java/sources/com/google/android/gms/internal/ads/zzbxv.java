package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbxv extends zzbyb {
    private final Clock zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;
    private final zzhfl zzi;
    private final zzhfl zzj;

    /* synthetic */ zzbxv(Context context, Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbya zzbyaVar, zzbxu zzbxuVar) {
        this.zzb = clock;
        zzhfc zzhfcVarZza = zzhfd.zza(context);
        this.zzc = zzhfcVarZza;
        zzhfc zzhfcVarZza2 = zzhfd.zza(zzgVar);
        this.zzd = zzhfcVarZza2;
        this.zze = zzhfb.zzc(new zzbxn(zzhfcVarZza, zzhfcVarZza2));
        zzhfc zzhfcVarZza3 = zzhfd.zza(clock);
        this.zzf = zzhfcVarZza3;
        zzhfc zzhfcVarZza4 = zzhfd.zza(zzbyaVar);
        this.zzg = zzhfcVarZza4;
        zzhfl zzhflVarZzc = zzhfb.zzc(new zzbxp(zzhfcVarZza3, zzhfcVarZza2, zzhfcVarZza4));
        this.zzh = zzhflVarZzc;
        zzbxr zzbxrVar = new zzbxr(zzhfcVarZza3, zzhflVarZzc);
        this.zzi = zzbxrVar;
        this.zzj = zzhfb.zzc(new zzbyg(zzhfcVarZza, zzbxrVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbyb
    final zzbxm zza() {
        return (zzbxm) this.zze.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbyb
    final zzbxq zzb() {
        return new zzbxq(this.zzb, (zzbxo) this.zzh.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzbyb
    final zzbyf zzc() {
        return (zzbyf) this.zzj.zzb();
    }
}
