package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdlo implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdlo(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        com.google.android.gms.ads.internal.util.zzbo zzboVar = (com.google.android.gms.ads.internal.util.zzbo) this.zza.zzb();
        Clock clock = (Clock) this.zzb.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzdln(zzboVar, clock, zzgcuVar);
    }
}
