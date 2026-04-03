package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzchk implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzchk(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbuv zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        zzfki zzfkiVar = (zzfki) this.zzb.zzb();
        zzbno zzbnoVarZzb = com.google.android.gms.ads.internal.zzu.zzf().zzb(contextZza, VersionInfoParcel.forPackage(), zzfkiVar);
        zzbni zzbniVar = zzbnl.zza;
        zzbnoVarZzb.zza("google.afma.request.getAdDictionary", zzbniVar, zzbniVar);
        return new zzbux(contextZza, com.google.android.gms.ads.internal.zzu.zzf().zzb(contextZza, VersionInfoParcel.forPackage(), zzfkiVar).zza("google.afma.sdkConstants.getSdkConstants", zzbniVar, zzbniVar), VersionInfoParcel.forPackage());
    }
}
