package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzepq implements zzhfc {
    private final zzhfu zza;

    public zzepq(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzepo zzb() {
        VersionInfoParcel versionInfoParcelZza = ((zzchc) this.zza).zza();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        return new zzepo(versionInfoParcelZza, zzgcuVar);
    }
}
