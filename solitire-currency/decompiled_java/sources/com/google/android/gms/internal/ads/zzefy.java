package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.m;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzefy implements zzeez {
    private final Context zza;
    private final zzcql zzb;
    private final Executor zzc;

    public zzefy(Context context, zzcql zzcqlVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcqlVar;
        this.zzc = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, final zzfel zzfelVar, zzeew zzeewVar) throws zzffn, zzeir {
        final View viewZza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) {
            zzbov zzbovVarZzc = ((zzfge) zzeewVar.zzb).zzc();
            if (zzbovVarZzc == null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
                throw new zzffn(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
            }
            try {
                viewZza = (View) ObjectWrapper.unwrap(zzbovVarZzc.zze());
                boolean zZzf = zzbovVarZzc.zzf();
                if (viewZza == null) {
                    throw new zzffn(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        viewZza = (View) zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzefw
                            @Override // com.google.android.gms.internal.ads.zzgbq
                            public final m zza(Object obj) {
                                return this.zza.zzc(viewZza, zzfelVar, obj);
                            }
                        }, zzbzo.zze).get();
                    } catch (InterruptedException | ExecutionException e10) {
                        throw new zzffn(e10);
                    }
                }
            } catch (RemoteException e11) {
                throw new zzffn(e11);
            }
        } else {
            viewZza = ((zzfge) zzeewVar.zzb).zza();
        }
        zzcql zzcqlVar = this.zzb;
        zzcsk zzcskVar = new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza);
        final zzfge zzfgeVar = (zzfge) zzeewVar.zzb;
        Objects.requireNonNull(zzfgeVar);
        zzcpl zzcplVarZza = zzcqlVar.zza(zzcskVar, new zzcpr(viewZza, null, new zzcrs() { // from class: com.google.android.gms.internal.ads.zzefx
            @Override // com.google.android.gms.internal.ads.zzcrs
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return zzfgeVar.zzb();
            }
        }, (zzfem) zzfelVar.zzu.get(0)));
        zzcplVarZza.zzg().zza(viewZza);
        zzcplVarZza.zzd().zzo(new zzcmy((zzfge) zzeewVar.zzb), this.zzc);
        ((zzegp) zzeewVar.zzc).zzc(zzcplVarZza.zzk());
        return zzcplVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        com.google.android.gms.ads.internal.client.zzq zzqVar;
        com.google.android.gms.ads.internal.client.zzq zzqVar2 = zzfexVar.zza.zza.zze;
        if (zzqVar2.zzn) {
            zzqVar = new com.google.android.gms.ads.internal.client.zzq(this.zza, com.google.android.gms.ads.zzb.zzd(zzqVar2.zze, zzqVar2.zzb));
        } else {
            zzqVar = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) ? new com.google.android.gms.ads.internal.client.zzq(this.zza, com.google.android.gms.ads.zzb.zze(zzqVar2.zze, zzqVar2.zzb)) : zzffm.zza(this.zza, zzfelVar.zzu);
        }
        com.google.android.gms.ads.internal.client.zzq zzqVar3 = zzqVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) {
            Object obj = zzeewVar.zzb;
            ((zzfge) obj).zzn(this.zza, zzqVar3, zzfexVar.zza.zza.zzd, zzfelVar.zzv.toString(), com.google.android.gms.ads.internal.util.zzbs.zzm(zzfelVar.zzs), (zzbos) zzeewVar.zzc);
            return;
        }
        Object obj2 = zzeewVar.zzb;
        ((zzfge) obj2).zzm(this.zza, zzqVar3, zzfexVar.zza.zza.zzd, zzfelVar.zzv.toString(), com.google.android.gms.ads.internal.util.zzbs.zzm(zzfelVar.zzs), (zzbos) zzeewVar.zzc);
    }

    final /* synthetic */ m zzc(View view, zzfel zzfelVar, Object obj) throws Exception {
        return zzgcj.zzh(zzcrg.zza(this.zza, view, zzfelVar));
    }
}
