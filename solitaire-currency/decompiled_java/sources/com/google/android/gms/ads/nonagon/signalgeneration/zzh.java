package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfk;
import com.google.android.gms.internal.ads.zzhfu;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzh implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzh(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        zzdsp zzdspVar = (zzdsp) this.zzb.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zze(contextZza, zzdspVar, zzgcuVar);
    }
}
