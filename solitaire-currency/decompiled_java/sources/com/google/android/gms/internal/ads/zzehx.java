package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzehx {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcrx zzc;
    private final zzein zzd;
    private final zzflh zze;
    private final zzgdc zzf = zzgdc.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    private zzehy zzh;
    private zzfex zzi;

    zzehx(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcrx zzcrxVar, zzein zzeinVar, zzflh zzflhVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcrxVar;
        this.zzd = zzeinVar;
        this.zze = zzflhVar;
    }

    private final synchronized m zzd(zzfel zzfelVar) {
        Iterator it = zzfelVar.zza.iterator();
        while (it.hasNext()) {
            zzeet zzeetVarZza = this.zzc.zza(zzfelVar.zzb, (String) it.next());
            if (zzeetVarZza != null && zzeetVarZza.zzb(this.zzi, zzfelVar)) {
                return zzgcj.zzo(zzeetVarZza.zza(this.zzi, zzfelVar), zzfelVar.zzR, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgcj.zzg(new zzdwl(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(@Nullable zzfel zzfelVar) {
        m mVarZzd = zzd(zzfelVar);
        this.zzd.zzf(this.zzi, zzfelVar, mVarZzd, this.zze);
        zzgcj.zzr(mVarZzd, new zzehw(this, zzfelVar), this.zza);
    }

    public final synchronized m zzb(zzfex zzfexVar) {
        if (!this.zzg.getAndSet(true)) {
            if (zzfexVar.zzb.zza.isEmpty()) {
                this.zzf.zzd(new zzeir(3, zzeiu.zzc(zzfexVar)));
            } else {
                this.zzi = zzfexVar;
                this.zzh = new zzehy(zzfexVar, this.zzd, this.zzf);
                this.zzd.zzk(zzfexVar.zzb.zza);
                zzfel zzfelVarZza = this.zzh.zza();
                while (zzfelVarZza != null) {
                    zze(zzfelVarZza);
                    zzfelVarZza = this.zzh.zza();
                }
            }
        }
        return this.zzf;
    }
}
