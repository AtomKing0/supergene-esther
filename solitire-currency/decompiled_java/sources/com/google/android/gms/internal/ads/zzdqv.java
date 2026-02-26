package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqv implements zzhfc {
    private final zzhfu zza;

    public zzdqv(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzet)).booleanValue() ? Collections.singleton(new zzdei(((zzdro) this.zza).zzb(), zzgcuVar)) : Collections.emptySet();
        zzhfk.zzb(setSingleton);
        return setSingleton;
    }
}
