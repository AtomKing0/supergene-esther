package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeje implements zzeez {
    private final Context zza;
    private final zzdou zzb;

    public zzeje(Context context, zzdou zzdouVar) {
        this.zza = context;
        this.zzb = zzdouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn, zzeir {
        zzegy zzegyVar = new zzegy(zzfelVar, (zzbql) zzeewVar.zzb, AdFormat.REWARDED);
        zzdoq zzdoqVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdor(zzegyVar));
        zzegyVar.zzb(zzdoqVarZze.zzc());
        ((zzegp) zzeewVar.zzc).zzc(zzdoqVarZze.zzo());
        return zzdoqVarZze.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        try {
            ((zzbql) zzeewVar.zzb).zzq(zzfelVar.zzZ);
            if (zzfexVar.zza.zza.zzo.zza == 3) {
                ((zzbql) zzeewVar.zzb).zzo(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejd(this, zzeewVar, null), (zzbos) zzeewVar.zzc);
            } else {
                ((zzbql) zzeewVar.zzb).zzp(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejd(this, zzeewVar, null), (zzbos) zzeewVar.zzc);
            }
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a rewarded RTB ad", e10);
        }
    }
}
