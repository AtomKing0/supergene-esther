package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzefu implements zzeet {
    private final zzcql zza;
    private final Context zzb;
    private final zzdpl zzc;
    private final zzffg zzd;
    private final Executor zze;
    private final zzful zzf;

    public zzefu(zzcql zzcqlVar, Context context, Executor executor, zzdpl zzdplVar, zzffg zzffgVar, zzful zzfulVar) {
        this.zzb = context;
        this.zza = zzcqlVar;
        this.zze = executor;
        this.zzc = zzdplVar;
        this.zzd = zzffgVar;
        this.zzf = zzfulVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final m zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        return zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzeft
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzc(zzfexVar, zzfelVar, obj);
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        zzfeq zzfeqVar = zzfelVar.zzs;
        return (zzfeqVar == null || zzfeqVar.zza == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ m zzc(zzfex zzfexVar, zzfel zzfelVar, Object obj) throws Exception {
        com.google.android.gms.ads.internal.client.zzq zzqVarZza = zzffm.zza(this.zzb, zzfelVar.zzu);
        final zzcej zzcejVarZza = this.zzc.zza(zzqVarZza, zzfelVar, zzfexVar.zzb.zzb);
        zzcejVarZza.zzac(zzfelVar.zzW);
        final zzcpl zzcplVarZza = this.zza.zza(new zzcsk(zzfexVar, zzfelVar, null), new zzcpr((((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) ? zzcrg.zza(this.zzb, (View) zzcejVarZza, zzfelVar) : new zzdpo(this.zzb, (View) zzcejVarZza, (com.google.android.gms.ads.internal.util.zzau) this.zzf.apply(zzfelVar)), zzcejVarZza, new zzcrs() { // from class: com.google.android.gms.internal.ads.zzefo
            @Override // com.google.android.gms.internal.ads.zzcrs
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return zzcejVarZza.zzq();
            }
        }, zzffm.zzb(zzqVarZza)));
        zzcplVarZza.zzh().zzi(zzcejVarZza, false, null);
        zzcxi zzcxiVarZzc = zzcplVarZza.zzc();
        zzcxk zzcxkVar = new zzcxk() { // from class: com.google.android.gms.internal.ads.zzefp
            @Override // com.google.android.gms.internal.ads.zzcxk
            public final void zzr() {
                zzcej zzcejVar = zzcejVarZza;
                if (zzcejVar.zzN() != null) {
                    zzcejVar.zzN().zzr();
                }
            }
        };
        zzgcu zzgcuVar = zzbzo.zzf;
        zzcxiVarZzc.zzo(zzcxkVar, zzgcuVar);
        String strZzb = zzfelVar.zzs.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeC)).booleanValue() && zzcplVarZza.zzi().zze(true)) {
            strZzb = zzcfu.zzb(strZzb, zzcfu.zza(zzfelVar));
        }
        zzcplVarZza.zzh();
        m mVarZzj = zzdpk.zzj(zzcejVarZza, zzfelVar.zzs.zzb, strZzb);
        if (zzfelVar.zzM) {
            mVarZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefq
                @Override // java.lang.Runnable
                public final void run() {
                    zzcejVarZza.zzah();
                }
            }, this.zze);
        }
        mVarZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefr
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd(zzcejVarZza);
            }
        }, this.zze);
        return zzgcj.zzm(mVarZzj, new zzful() { // from class: com.google.android.gms.internal.ads.zzefs
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj2) {
                return zzcplVarZza.zza();
            }
        }, zzgcuVar);
    }

    final /* synthetic */ void zzd(zzcej zzcejVar) {
        zzcejVar.zzab();
        zzcfl zzcflVarZzq = zzcejVar.zzq();
        com.google.android.gms.ads.internal.client.zzfk zzfkVar = this.zzd.zza;
        if (zzfkVar != null && zzcflVarZzq != null) {
            zzcflVarZzq.zzs(zzfkVar);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzaZ)).booleanValue() || zzcejVar.isAttachedToWindow()) {
            return;
        }
        zzcejVar.onPause();
        zzcejVar.zzav(true);
    }
}
