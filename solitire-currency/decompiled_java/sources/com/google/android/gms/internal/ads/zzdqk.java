package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqk implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzdqk(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3, zzhfu zzhfuVar4, zzhfu zzhfuVar5) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
        this.zzd = zzhfuVar4;
        this.zze = zzhfuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcgp) this.zza).zza();
        final String strZzb = ((zzdxd) this.zzb).zzb();
        VersionInfoParcel versionInfoParcelZza = ((zzchc) this.zzc).zza();
        final zzbbc.zza.EnumC0191zza enumC0191zza = (zzbbc.zza.EnumC0191zza) this.zzd.zzb();
        final String str = (String) this.zze.zzb();
        zzbav zzbavVar = new zzbav(new zzbbb(contextZza));
        zzbbc.zzar.zza zzaVarZzd = zzbbc.zzar.zzd();
        zzaVarZzd.zzg(versionInfoParcelZza.buddyApkVersion);
        zzaVarZzd.zzi(versionInfoParcelZza.clientJarVersion);
        zzaVarZzd.zzh(true != versionInfoParcelZza.isClientJar ? 2 : 0);
        final zzbbc.zzar zzarVarZzbr = zzaVarZzd.zzbr();
        zzbavVar.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzdqj
            @Override // com.google.android.gms.internal.ads.zzbau
            public final void zza(zzbbc.zzt.zza zzaVar) {
                zzbbc.zza.zzb zzbVarZzbM = zzaVar.zze().zzbM();
                zzbVarZzbM.zzH(enumC0191zza);
                zzaVar.zzG(zzbVarZzbM);
                zzbbc.zzm.zza zzaVarZzbM = zzaVar.zzg().zzbM();
                zzaVarZzbM.zzm(strZzb);
                zzaVarZzbM.zzw(zzarVarZzbr);
                zzaVar.zzK(zzaVarZzbM);
                zzaVar.zzO(str);
            }
        });
        return zzbavVar;
    }
}
