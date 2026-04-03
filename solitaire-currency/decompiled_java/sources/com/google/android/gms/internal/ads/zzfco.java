package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfco implements zzena {
    private final Context zza;
    private final Executor zzb;
    private final zzcgj zzc;
    private final zzemk zzd;
    private final zzfdo zze;

    @Nullable
    private zzbcr zzf;
    private final zzfki zzg;
    private final zzffe zzh;
    private m zzi;

    public zzfco(Context context, Executor executor, zzcgj zzcgjVar, zzemk zzemkVar, zzfdo zzfdoVar, zzffe zzffeVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgjVar;
        this.zzd = zzemkVar;
        this.zzh = zzffeVar;
        this.zze = zzfdoVar;
        this.zzg = zzcgjVar.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        m mVar = this.zzi;
        return (mVar == null || mVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzemy zzemyVar, zzemz zzemzVar) {
        zzdgp zzdgpVarZzf;
        zzfkf zzfkfVar;
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfci
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzh();
                }
            });
            return false;
        }
        if (zza()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzia)).booleanValue() && zzlVar.zzf) {
            this.zzc.zzl().zzo(true);
        }
        com.google.android.gms.ads.internal.client.zzq zzqVar = ((zzfch) zzemyVar).zza;
        Bundle bundleZza = zzdrv.zza(new Pair(zzdrt.PUBLIC_API_CALL.zza(), Long.valueOf(zzlVar.zzz)), new Pair(zzdrt.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis())));
        zzffe zzffeVar = this.zzh;
        zzffeVar.zzt(str);
        zzffeVar.zzs(zzqVar);
        zzffeVar.zzH(zzlVar);
        zzffeVar.zzA(bundleZza);
        Context context = this.zza;
        zzffg zzffgVarZzJ = zzffeVar.zzJ();
        zzfju zzfjuVarZzb = zzfjt.zzb(context, zzfke.zzf(zzffgVarZzJ), 4, zzlVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhr)).booleanValue()) {
            zzdgo zzdgoVarZzg = this.zzc.zzg();
            zzcvy zzcvyVar = new zzcvy();
            zzcvyVar.zze(this.zza);
            zzcvyVar.zzi(zzffgVarZzJ);
            zzdgoVarZzg.zze(zzcvyVar.zzj());
            zzdci zzdciVar = new zzdci();
            zzdciVar.zzj(this.zzd, this.zzb);
            zzdciVar.zzk(this.zzd, this.zzb);
            zzdgoVarZzg.zzd(zzdciVar.zzn());
            zzdgoVarZzg.zzc(new zzekt(this.zzf));
            zzdgpVarZzf = zzdgoVarZzg.zzh();
        } else {
            zzdci zzdciVar2 = new zzdci();
            zzfdo zzfdoVar = this.zze;
            if (zzfdoVar != null) {
                zzdciVar2.zze(zzfdoVar, this.zzb);
                zzdciVar2.zzf(this.zze, this.zzb);
                zzdciVar2.zzb(this.zze, this.zzb);
            }
            zzdgo zzdgoVarZzg2 = this.zzc.zzg();
            zzcvy zzcvyVar2 = new zzcvy();
            zzcvyVar2.zze(this.zza);
            zzcvyVar2.zzi(zzffgVarZzJ);
            zzdgoVarZzg2.zze(zzcvyVar2.zzj());
            zzdciVar2.zzj(this.zzd, this.zzb);
            zzdciVar2.zze(this.zzd, this.zzb);
            zzdciVar2.zzf(this.zzd, this.zzb);
            zzdciVar2.zzb(this.zzd, this.zzb);
            zzdciVar2.zza(this.zzd, this.zzb);
            zzdciVar2.zzl(this.zzd, this.zzb);
            zzdciVar2.zzk(this.zzd, this.zzb);
            zzdciVar2.zzi(this.zzd, this.zzb);
            zzdciVar2.zzc(this.zzd, this.zzb);
            zzdgoVarZzg2.zzd(zzdciVar2.zzn());
            zzdgoVarZzg2.zzc(new zzekt(this.zzf));
            zzdgpVarZzf = zzdgoVarZzg2.zzh();
        }
        zzdgp zzdgpVar = zzdgpVarZzf;
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzfkf zzfkfVarZzf = zzdgpVar.zzf();
            zzfkfVarZzf.zzi(4);
            zzfkfVarZzf.zzb(zzlVar.zzp);
            zzfkfVarZzf.zzf(zzlVar.zzm);
            zzfkfVar = zzfkfVarZzf;
        } else {
            zzfkfVar = null;
        }
        zzctc zzctcVarZza = zzdgpVar.zza();
        m mVarZzi = zzctcVarZza.zzi(zzctcVarZza.zzj());
        this.zzi = mVarZzi;
        zzgcj.zzr(mVarZzi, new zzfcn(this, zzemzVar, zzfkfVar, zzfjuVarZzb, zzdgpVar), this.zzb);
        return true;
    }

    final /* synthetic */ void zzh() {
        this.zzd.zzdB(zzfgi.zzd(6, null, null));
    }

    public final void zzi(zzbcr zzbcrVar) {
        this.zzf = zzbcrVar;
    }
}
