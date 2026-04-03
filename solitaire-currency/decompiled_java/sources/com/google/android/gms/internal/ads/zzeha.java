package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeha implements zzeez {
    private final Context zza;
    private final zzdgp zzb;
    private final VersionInfoParcel zzc;
    private final Executor zzd;

    public zzeha(Context context, VersionInfoParcel versionInfoParcel, zzdgp zzdgpVar, Executor executor) {
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = zzdgpVar;
        this.zzd = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, final zzeew zzeewVar) throws zzffn, zzeir {
        zzdfp zzdfpVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdfs(new zzdgx() { // from class: com.google.android.gms.internal.ads.zzegz
            @Override // com.google.android.gms.internal.ads.zzdgx
            public final void zza(boolean z10, Context context, zzcxd zzcxdVar) throws zzdgw {
                this.zza.zzc(zzeewVar, z10, context, zzcxdVar);
            }
        }, null));
        zzdfpVarZze.zzd().zzo(new zzcmy((zzfge) zzeewVar.zzb), this.zzd);
        ((zzegp) zzeewVar.zzc).zzc(zzdfpVarZze.zzk());
        return zzdfpVarZze.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        zzfge zzfgeVar = (zzfge) zzeewVar.zzb;
        zzffg zzffgVar = zzfexVar.zza.zza;
        zzfgeVar.zzo(this.zza, zzffgVar.zzd, zzfelVar.zzv.toString(), com.google.android.gms.ads.internal.util.zzbs.zzm(zzfelVar.zzs), (zzbos) zzeewVar.zzc);
    }

    final /* synthetic */ void zzc(zzeew zzeewVar, boolean z10, Context context, zzcxd zzcxdVar) throws zzdgw {
        try {
            ((zzfge) zzeewVar.zzb).zzv(z10);
            if (this.zzc.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzaz)).intValue()) {
                ((zzfge) zzeewVar.zzb).zzx();
            } else {
                ((zzfge) zzeewVar.zzb).zzy(context);
            }
        } catch (zzffn e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzi("Cannot show interstitial.");
            throw new zzdgw(e10.getCause());
        }
    }
}
