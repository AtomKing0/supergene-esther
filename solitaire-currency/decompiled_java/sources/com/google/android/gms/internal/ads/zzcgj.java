package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcgj implements zzclv {
    private static zzcgj zza;

    private static synchronized zzcgj zzD(Context context, zzbom zzbomVar, int i10, boolean z10, int i11, zzchn zzchnVar) {
        zzcgj zzcgjVar = zza;
        if (zzcgjVar != null) {
            return zzcgjVar;
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
        zzbbw.zza(context);
        if (((Boolean) zzbdk.zze.zze()).booleanValue()) {
            zzbbg.zzd(context);
        }
        zzfgc zzfgcVarZzd = zzfgc.zzd(context);
        VersionInfoParcel versionInfoParcelZzc = zzfgcVarZzd.zzc(242402000, false, i11);
        zzfgcVarZzd.zzf(zzbomVar);
        zzcjb zzcjbVar = new zzcjb(null);
        zzcgk zzcgkVar = new zzcgk();
        zzcgkVar.zzf(versionInfoParcelZzc);
        zzcgkVar.zze(context);
        zzcgkVar.zzd(jCurrentTimeMillis);
        zzcjbVar.zzb(new zzcgm(zzcgkVar, null));
        zzcjbVar.zzc(new zzcko(zzchnVar));
        zzcgj zzcgjVarZza = zzcjbVar.zza();
        com.google.android.gms.ads.internal.zzu.zzo().zzu(context, versionInfoParcelZzc);
        com.google.android.gms.ads.internal.zzu.zzc().zzi(context);
        com.google.android.gms.ads.internal.zzu.zzp().zzl(context);
        com.google.android.gms.ads.internal.zzu.zzp().zzk(context);
        com.google.android.gms.ads.internal.util.zzd.zza(context);
        com.google.android.gms.ads.internal.zzu.zzb().zzd(context);
        com.google.android.gms.ads.internal.zzu.zzv().zzb(context);
        zzcgjVarZza.zza().zzc();
        zzbyb.zzd(context);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfB)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzap)).booleanValue()) {
                new zzecu(context, versionInfoParcelZzc, new zzbav(new zzbbb(context)), new zzebz(new zzebv(context), zzcgjVarZza.zzA())).zzb(com.google.android.gms.ads.internal.zzu.zzo().zzi().zzS());
            }
        }
        zza = zzcgjVarZza;
        return zzcgjVarZza;
    }

    public static zzcgj zzb(Context context, zzbom zzbomVar, int i10) {
        return zzD(context, zzbomVar, 242402000, false, i10, new zzchn());
    }

    public abstract zzgcu zzA();

    public abstract Executor zzB();

    public abstract ScheduledExecutorService zzC();

    public abstract com.google.android.gms.ads.internal.util.zzcb zza();

    public abstract zzcky zzc();

    public abstract zzcox zzd();

    public abstract zzcqk zze();

    public abstract zzczj zzf();

    public abstract zzdgo zzg();

    public abstract zzdhk zzh();

    public abstract zzdot zzi();

    public abstract zzdsk zzj();

    public abstract zzdtt zzk();

    public abstract zzdvi zzl();

    public abstract zzdwf zzm();

    public abstract zzeds zzn();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzl zzo();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzr zzp();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzak zzq();

    @Override // com.google.android.gms.internal.ads.zzclv
    public final zzewr zzr(zzbvb zzbvbVar, int i10) {
        return zzs(new zzeyq(zzbvbVar, i10));
    }

    protected abstract zzewr zzs(zzeyq zzeyqVar);

    public abstract zzezl zzt();

    public abstract zzfaz zzu();

    public abstract zzfcq zzv();

    public abstract zzfee zzw();

    public abstract zzffv zzx();

    public abstract zzfgf zzy();

    public abstract zzfki zzz();
}
