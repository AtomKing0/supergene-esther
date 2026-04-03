package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeht implements zzeez {
    private final Context zza;
    private final zzdhl zzb;
    private zzbpb zzc;
    private final VersionInfoParcel zzd;

    public zzeht(Context context, zzdhl zzdhlVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzdhlVar;
        this.zzd = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzeir, zzffn {
        if (!zzfexVar.zza.zza.zzg.contains(Integer.toString(6))) {
            throw new zzeir(2, "Unified must be used for RTB.");
        }
        zzdjb zzdjbVarZzt = zzdjb.zzt(this.zzc);
        zzffg zzffgVar = zzfexVar.zza.zza;
        if (!zzffgVar.zzg.contains(Integer.toString(zzdjbVarZzt.zzc()))) {
            throw new zzeir(1, "No corresponding native ad listener");
        }
        zzdjd zzdjdVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdjn(zzdjbVarZzt), new zzdle(null, null, this.zzc));
        ((zzegp) zzeewVar.zzc).zzc(zzdjdVarZze.zzj());
        return zzdjdVarZze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        try {
            ((zzbql) zzeewVar.zzb).zzq(zzfelVar.zzZ);
            zzehr zzehrVar = null;
            if (this.zzd.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbx)).intValue()) {
                ((zzbql) zzeewVar.zzb).zzm(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehs(this, zzeewVar, zzehrVar), (zzbos) zzeewVar.zzc);
            } else {
                ((zzbql) zzeewVar.zzb).zzn(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehs(this, zzeewVar, zzehrVar), (zzbos) zzeewVar.zzc, zzfexVar.zza.zza.zzi);
            }
        } catch (RemoteException e10) {
            throw new zzffn(e10);
        }
    }
}
