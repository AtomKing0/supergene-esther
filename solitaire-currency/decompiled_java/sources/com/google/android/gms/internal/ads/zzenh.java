package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenh implements zzena {
    private final zzffe zza;
    private final zzcgj zzb;
    private final Context zzc;
    private final zzemx zzd;
    private final zzfki zze;

    @Nullable
    private zzcsj zzf;

    public zzenh(zzcgj zzcgjVar, Context context, zzemx zzemxVar, zzffe zzffeVar) {
        this.zzb = zzcgjVar;
        this.zzc = context;
        this.zzd = zzemxVar;
        this.zza = zzffeVar;
        this.zze = zzcgjVar.zzz();
        zzffeVar.zzv(zzemxVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        zzcsj zzcsjVar = this.zzf;
        return zzcsjVar != null && zzcsjVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzemy zzemyVar, zzemz zzemzVar) throws RemoteException {
        zzfkf zzfkfVar;
        com.google.android.gms.ads.internal.zzu.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzH(this.zzc) && zzlVar.zzs == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzenc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzf();
                }
            });
            return false;
        }
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzend
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzg();
                }
            });
            return false;
        }
        zzfgd.zza(this.zzc, zzlVar.zzf);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzia)).booleanValue() && zzlVar.zzf) {
            this.zzb.zzl().zzo(true);
        }
        int i10 = ((zzenb) zzemyVar).zza;
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
        String strZza = zzdrt.PUBLIC_API_CALL.zza();
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        Bundle bundleZza = zzdrv.zza(new Pair(strZza, lValueOf), new Pair(zzdrt.DYNAMITE_ENTER.zza(), lValueOf));
        zzffe zzffeVar = this.zza;
        zzffeVar.zzH(zzlVar);
        zzffeVar.zzA(bundleZza);
        zzffeVar.zzC(i10);
        Context context = this.zzc;
        zzffg zzffgVarZzJ = zzffeVar.zzJ();
        zzfju zzfjuVarZzb = zzfjt.zzb(context, zzfke.zzf(zzffgVarZzJ), 8, zzlVar);
        com.google.android.gms.ads.internal.client.zzcb zzcbVar = zzffgVarZzJ.zzn;
        if (zzcbVar != null) {
            this.zzd.zzd().zzm(zzcbVar);
        }
        zzdhk zzdhkVarZzh = this.zzb.zzh();
        zzcvy zzcvyVar = new zzcvy();
        zzcvyVar.zze(this.zzc);
        zzcvyVar.zzi(zzffgVarZzJ);
        zzdhkVarZzh.zzf(zzcvyVar.zzj());
        zzdci zzdciVar = new zzdci();
        zzdciVar.zzk(this.zzd.zzd(), this.zzb.zzB());
        zzdhkVarZzh.zze(zzdciVar.zzn());
        zzdhkVarZzh.zzd(this.zzd.zzc());
        zzdhkVarZzh.zzc(new zzcph(null));
        zzdhl zzdhlVarZzh = zzdhkVarZzh.zzh();
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzfkf zzfkfVarZzf = zzdhlVarZzh.zzf();
            zzfkfVarZzf.zzi(8);
            zzfkfVarZzf.zzb(zzlVar.zzp);
            zzfkfVarZzf.zzf(zzlVar.zzm);
            zzfkfVar = zzfkfVarZzf;
        } else {
            zzfkfVar = null;
        }
        this.zzb.zzy().zzc(1);
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        ScheduledExecutorService scheduledExecutorServiceZzC = this.zzb.zzC();
        zzctc zzctcVarZza = zzdhlVarZzh.zza();
        zzcsj zzcsjVar = new zzcsj(zzgcuVar, scheduledExecutorServiceZzC, zzctcVarZza.zzi(zzctcVarZza.zzj()));
        this.zzf = zzcsjVar;
        zzcsjVar.zze(new zzeng(this, zzemzVar, zzfkfVar, zzfjuVarZzb, zzdhlVarZzh));
        return true;
    }

    final /* synthetic */ void zzf() {
        this.zzd.zza().zzdB(zzfgi.zzd(4, null, null));
    }

    final /* synthetic */ void zzg() {
        this.zzd.zza().zzdB(zzfgi.zzd(6, null, null));
    }
}
