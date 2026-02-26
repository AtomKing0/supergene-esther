package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcwm implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzcwm(zzcwl zzcwlVar, zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    @Nullable
    public final /* synthetic */ Object zzb() {
        Context context = (Context) this.zza.zzb();
        VersionInfoParcel versionInfoParcelZza = ((zzchc) this.zzb).zza();
        zzfel zzfelVarZza = ((zzcsl) this.zzc).zza();
        zzbxh zzbxhVar = new zzbxh();
        zzbxi zzbxiVar = zzfelVarZza.zzA;
        if (zzbxiVar == null) {
            return null;
        }
        zzfeq zzfeqVar = zzfelVarZza.zzs;
        return new zzbxg(context, versionInfoParcelZza, zzbxiVar, zzfeqVar == null ? null : zzfeqVar.zzb, zzbxhVar);
    }
}
