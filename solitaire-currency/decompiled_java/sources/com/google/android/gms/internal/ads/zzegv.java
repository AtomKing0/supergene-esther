package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzegv implements zzdgx {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final m zzc;
    private final zzfel zzd;
    private final zzcej zze;
    private final zzffg zzf;
    private final zzbja zzg;
    private final boolean zzh;
    private final zzeds zzi;

    zzegv(Context context, VersionInfoParcel versionInfoParcel, m mVar, zzfel zzfelVar, zzcej zzcejVar, zzffg zzffgVar, boolean z10, zzbja zzbjaVar, zzeds zzedsVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = mVar;
        this.zzd = zzfelVar;
        this.zze = zzcejVar;
        this.zzf = zzffgVar;
        this.zzg = zzbjaVar;
        this.zzh = z10;
        this.zzi = zzedsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final void zza(boolean z10, Context context, zzcxd zzcxdVar) {
        zzdfp zzdfpVar = (zzdfp) zzgcj.zzq(this.zzc);
        this.zze.zzaq(true);
        boolean zZze = this.zzh ? this.zzg.zze(false) : false;
        com.google.android.gms.ads.internal.zzu.zzp();
        com.google.android.gms.ads.internal.zzk zzkVar = new com.google.android.gms.ads.internal.zzk(zZze, com.google.android.gms.ads.internal.util.zzt.zzI(this.zza), this.zzh ? this.zzg.zzd() : false, this.zzh ? this.zzg.zza() : 0.0f, -1, z10, this.zzd.zzO, false);
        if (zzcxdVar != null) {
            zzcxdVar.zzf();
        }
        com.google.android.gms.ads.internal.zzu.zzi();
        zzdgm zzdgmVarZzh = zzdfpVar.zzh();
        zzcej zzcejVar = this.zze;
        zzfel zzfelVar = this.zzd;
        VersionInfoParcel versionInfoParcel = this.zzb;
        int i10 = zzfelVar.zzQ;
        String str = zzfelVar.zzB;
        zzfeq zzfeqVar = zzfelVar.zzs;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel((com.google.android.gms.ads.internal.client.zza) null, zzdgmVarZzh, (com.google.android.gms.ads.internal.overlay.zzaa) null, zzcejVar, i10, versionInfoParcel, str, zzkVar, zzfeqVar.zzb, zzfeqVar.zza, this.zzf.zzf, zzcxdVar, zzfelVar.zzai ? this.zzi : null), true);
    }
}
