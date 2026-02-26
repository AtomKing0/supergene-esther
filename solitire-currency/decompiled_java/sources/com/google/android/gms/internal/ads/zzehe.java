package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzehe implements zzeez {
    private final Context zza;
    private final zzdgp zzb;

    public zzehe(Context context, zzdgp zzdgpVar) {
        this.zza = context;
        this.zzb = zzdgpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn, zzeir {
        zzegy zzegyVar = new zzegy(zzfelVar, (zzbql) zzeewVar.zzb, AdFormat.INTERSTITIAL);
        zzdfp zzdfpVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdfs(zzegyVar, null));
        zzegyVar.zzb(zzdfpVarZze.zzc());
        ((zzegp) zzeewVar.zzc).zzc(zzdfpVarZze.zzj());
        return zzdfpVarZze.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        try {
            ((zzbql) zzeewVar.zzb).zzq(zzfelVar.zzZ);
            ((zzbql) zzeewVar.zzb).zzl(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehd(this, zzeewVar, null), (zzbos) zzeewVar.zzc);
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a interstitial RTB ad", e10);
            throw new zzffn(e10);
        }
    }
}
