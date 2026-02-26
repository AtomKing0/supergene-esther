package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdpl {
    private final Context zza;
    private final zzauo zzb;
    private final zzbcz zzc;
    private final VersionInfoParcel zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbav zzf;
    private final zzczj zzg;
    private final zzeds zzh;
    private final zzffk zzi;

    public zzdpl(zzcew zzcewVar, Context context, zzauo zzauoVar, zzbcz zzbczVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbav zzbavVar, zzczj zzczjVar, zzeds zzedsVar, zzffk zzffkVar) {
        this.zza = context;
        this.zzb = zzauoVar;
        this.zzc = zzbczVar;
        this.zzd = versionInfoParcel;
        this.zze = zzaVar;
        this.zzf = zzbavVar;
        this.zzg = zzczjVar;
        this.zzh = zzedsVar;
        this.zzi = zzffkVar;
    }

    public final zzcej zza(com.google.android.gms.ads.internal.client.zzq zzqVar, zzfel zzfelVar, zzfeo zzfeoVar) throws zzcev {
        zzcgd zzcgdVarZzc = zzcgd.zzc(zzqVar);
        String str = zzqVar.zza;
        zzdpa zzdpaVar = new zzdpa(this);
        zzeds zzedsVar = this.zzh;
        zzffk zzffkVar = this.zzi;
        com.google.android.gms.ads.internal.zza zzaVar = this.zze;
        zzbav zzbavVar = this.zzf;
        return zzcew.zza(this.zza, zzcgdVarZzc, str, false, false, this.zzb, this.zzc, this.zzd, null, zzdpaVar, zzaVar, zzbavVar, zzfelVar, zzfeoVar, zzedsVar, zzffkVar);
    }
}
