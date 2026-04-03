package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeja implements zzeez {
    private final Context zza;
    private final Executor zzb;
    private final zzdou zzc;

    public zzeja(Context context, Executor executor, zzdou zzdouVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, final zzeew zzeewVar) throws zzffn, zzeir {
        zzdoq zzdoqVarZze = this.zzc.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdor(new zzdgx() { // from class: com.google.android.gms.internal.ads.zzeiz
            @Override // com.google.android.gms.internal.ads.zzdgx
            public final void zza(boolean z10, Context context, zzcxd zzcxdVar) throws zzdgw {
                zzeew zzeewVar2 = zzeewVar;
                try {
                    ((zzfge) zzeewVar2.zzb).zzv(z10);
                    ((zzfge) zzeewVar2.zzb).zzz(context);
                } catch (zzffn e10) {
                    throw new zzdgw(e10.getCause());
                }
            }
        }));
        zzdoqVarZze.zzd().zzo(new zzcmy((zzfge) zzeewVar.zzb), this.zzb);
        ((zzegp) zzeewVar.zzc).zzc(zzdoqVarZze.zzn());
        return zzdoqVarZze.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        try {
            zzffg zzffgVar = zzfexVar.zza.zza;
            if (zzffgVar.zzo.zza == 3) {
                ((zzfge) zzeewVar.zzb).zzr(this.zza, zzffgVar.zzd, zzfelVar.zzv.toString(), (zzbos) zzeewVar.zzc);
            } else {
                ((zzfge) zzeewVar.zzb).zzq(this.zza, zzffgVar.zzd, zzfelVar.zzv.toString(), (zzbos) zzeewVar.zzc);
            }
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzeewVar.zza)), e10);
        }
    }
}
