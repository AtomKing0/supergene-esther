package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.m;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeuv implements zzevo {
    private final String zza;
    private final zzgcu zzb;
    private final ScheduledExecutorService zzc;
    private final Context zzd;
    private final zzffg zze;
    private final zzcgj zzf;

    zzeuv(zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, String str, Context context, zzffg zzffgVar, zzcgj zzcgjVar) {
        this.zzb = zzgcuVar;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = context;
        this.zze = zzffgVar;
        this.zzf = zzcgjVar;
    }

    public static /* synthetic */ m zzc(zzeuv zzeuvVar) {
        com.google.android.gms.ads.nonagon.signalgeneration.zzr zzrVarZzp = zzeuvVar.zzf.zzp();
        zzcvy zzcvyVar = new zzcvy();
        zzcvyVar.zze(zzeuvVar.zzd);
        zzffe zzffeVar = new zzffe();
        zzffeVar.zzt("adUnitId");
        zzffeVar.zzH(zzeuvVar.zze.zzd);
        zzffeVar.zzs(new com.google.android.gms.ads.internal.client.zzq());
        zzffeVar.zzz(true);
        zzcvyVar.zzi(zzffeVar.zzJ());
        zzrVarZzp.zza(zzcvyVar.zzj());
        com.google.android.gms.ads.nonagon.signalgeneration.zzan zzanVar = new com.google.android.gms.ads.nonagon.signalgeneration.zzan();
        zzanVar.zza(zzeuvVar.zza);
        zzrVarZzp.zzb(zzanVar.zzb());
        new zzdci();
        return zzgcj.zze(zzgcj.zzm((zzgca) zzgcj.zzo(zzgca.zzu(zzrVarZzp.zzc().zzb()), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgt)).longValue(), TimeUnit.MILLISECONDS, zzeuvVar.zzc), new zzful() { // from class: com.google.android.gms.internal.ads.zzeus
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                com.google.android.gms.ads.nonagon.signalgeneration.zzay zzayVar = (com.google.android.gms.ads.nonagon.signalgeneration.zzay) obj;
                return zzayVar != null ? new zzeuw(zzayVar.zza) : new zzeuw(null);
            }
        }, zzeuvVar.zzb), Exception.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzeut
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", (Exception) obj);
                return new zzeuw(null);
            }
        }, zzeuvVar.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 33;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgs)).booleanValue() || this.zze.zzr) ? zzgcj.zzh(new zzeuw(null)) : zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzeuu
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final m zza() {
                return zzeuv.zzc(this.zza);
            }
        }, this.zzb);
    }
}
