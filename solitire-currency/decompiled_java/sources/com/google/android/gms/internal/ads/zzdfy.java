package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdfy implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzdfy(zzdfs zzdfsVar, zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final VersionInfoParcel versionInfoParcelZza = ((zzchc) this.zzb).zza();
        final zzfel zzfelVarZza = ((zzcsl) this.zzc).zza();
        final zzffg zzffgVarZza = ((zzcwh) this.zzd).zza();
        return new zzdei(new zzcye() { // from class: com.google.android.gms.internal.ads.zzdfq
            @Override // com.google.android.gms.internal.ads.zzcye
            public final void zzs() {
                com.google.android.gms.ads.internal.zzu.zzs().zzn(context, versionInfoParcelZza.afmaVersion, zzfelVarZza.zzC.toString(), zzffgVarZza.zzf);
            }
        }, zzbzo.zzf);
    }
}
