package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzegn implements zzeet {
    private final zzcql zza;
    private final zzefu zzb;
    private final zzgcu zzc;
    private final zzcws zzd;
    private final ScheduledExecutorService zze;
    private final zzdsf zzf;

    public zzegn(zzcql zzcqlVar, zzefu zzefuVar, zzcws zzcwsVar, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcuVar, zzdsf zzdsfVar) {
        this.zza = zzcqlVar;
        this.zzb = zzefuVar;
        this.zzd = zzcwsVar;
        this.zze = scheduledExecutorService;
        this.zzc = zzgcuVar;
        this.zzf = zzdsfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final m zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        return this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzegl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc(zzfexVar, zzfelVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        zzbgu zzbguVarZza = zzfexVar.zza.zza.zza();
        boolean zZzb = this.zzb.zzb(zzfexVar, zzfelVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkZ)).booleanValue()) {
            this.zzf.zzb().put("has_dbl", zzbguVarZza != null ? "1" : "0");
            this.zzf.zzb().put("crdb", true != zZzb ? "0" : "1");
        }
        return zzbguVarZza != null && zZzb;
    }

    final /* synthetic */ zzcpk zzc(final zzfex zzfexVar, final zzfel zzfelVar) throws Exception {
        return this.zza.zzb(new zzcsk(zzfexVar, zzfelVar, null), new zzcrc(zzfexVar.zza.zza.zza(), new Runnable() { // from class: com.google.android.gms.internal.ads.zzegk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf(zzfexVar, zzfelVar);
            }
        })).zza();
    }

    final /* synthetic */ void zzf(zzfex zzfexVar, zzfel zzfelVar) {
        zzgcj.zzr(zzgcj.zzo(this.zzb.zza(zzfexVar, zzfelVar), zzfelVar.zzR, TimeUnit.SECONDS, this.zze), new zzegm(this), this.zzc);
    }
}
