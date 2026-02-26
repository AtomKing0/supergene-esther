package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcgw implements zzhfc {
    private final zzhfu zza;

    public zzcgw(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdup zzdupVar = (zzdup) this.zza.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbt)).booleanValue() ? Collections.singleton(new zzdei(zzdupVar, zzgcuVar)) : Collections.emptySet();
        zzhfk.zzb(setSingleton);
        return setSingleton;
    }
}
