package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzejw implements zzeez {
    private final Context zza;
    private final Executor zzb;
    private final zzdou zzc;

    public zzejw(Context context, Executor executor, zzdou zzdouVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdouVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zze(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) {
        try {
            ((zzfge) zzeewVar.zzb).zzk(zzfexVar.zza.zza.zzd, zzfelVar.zzv.toString());
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzeewVar.zza)), e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, zzfel zzfelVar, final zzeew zzeewVar) throws zzffn, zzeir {
        zzdoq zzdoqVarZze = this.zzc.zze(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzdor(new zzdgx() { // from class: com.google.android.gms.internal.ads.zzejs
            @Override // com.google.android.gms.internal.ads.zzdgx
            public final void zza(boolean z10, Context context, zzcxd zzcxdVar) throws zzdgw {
                zzeew zzeewVar2 = zzeewVar;
                try {
                    ((zzfge) zzeewVar2.zzb).zzv(z10);
                    ((zzfge) zzeewVar2.zzb).zzA();
                } catch (zzffn e10) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzk("Cannot show rewarded video.", e10);
                    throw new zzdgw(e10.getCause());
                }
            }
        }));
        zzdoqVarZze.zzd().zzo(new zzcmy((zzfge) zzeewVar.zzb), this.zzb);
        zzcxx zzcxxVarZze = zzdoqVarZze.zze();
        zzcwo zzcwoVarZzb = zzdoqVarZze.zzb();
        ((zzegq) zzeewVar.zzc).zzc(new zzejv(this, zzdoqVarZze.zza(), zzcwoVarZzb, zzcxxVarZze, zzdoqVarZze.zzg()));
        return zzdoqVarZze.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        if (((zzfge) zzeewVar.zzb).zzC()) {
            zze(zzfexVar, zzfelVar, zzeewVar);
            return;
        }
        ((zzegq) zzeewVar.zzc).zzd(new zzeju(this, zzfexVar, zzfelVar, zzeewVar));
        Object obj = zzeewVar.zzb;
        Context context = this.zza;
        zzffg zzffgVar = zzfexVar.zza.zza;
        ((zzfge) obj).zzh(context, zzffgVar.zzd, null, (zzbvy) zzeewVar.zzc, zzfelVar.zzv.toString());
    }
}
