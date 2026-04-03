package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcuj implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzcuj(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        zzfki zzfkiVar = (zzfki) this.zzb.zzb();
        VersionInfoParcel versionInfoParcelZza = ((zzchc) this.zzc).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzcui(contextZza, zzfkiVar, versionInfoParcelZza, zzgcuVar);
    }
}
