package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfce implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzfce(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfcc zzb() {
        Context context = (Context) this.zza.zzb();
        zzfgq zzfgqVar = (zzfgq) this.zzb.zzb();
        zzfhi zzfhiVar = (zzfhi) this.zzc.zzb();
        zzbyy zzbyyVarZzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfG)).booleanValue() ? com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh() : com.google.android.gms.ads.internal.zzu.zzo().zzi().zzi();
        boolean z10 = false;
        if (zzbyyVarZzh != null && zzbyyVarZzh.zzh()) {
            z10 = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfW)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfF)).booleanValue() || z10) {
                zzfhh zzfhhVarZza = zzfhiVar.zza(zzfgy.AppOpen, context, zzfgqVar, new zzfbg(new zzfbd()));
                zzfbs zzfbsVar = new zzfbs(new zzfbr());
                zzfgu zzfguVar = zzfhhVarZza.zza;
                zzgcu zzgcuVar = zzbzo.zza;
                return new zzfbi(zzfbsVar, new zzfbo(zzfguVar, zzgcuVar), zzfhhVarZza.zzb, zzfhhVarZza.zza.zza().zzf, zzgcuVar);
            }
        }
        return new zzfbr();
    }
}
