package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcsj {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final m zzc;
    private volatile boolean zzd = true;

    public zzcsj(Executor executor, ScheduledExecutorService scheduledExecutorService, m mVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = mVar;
    }

    static /* bridge */ /* synthetic */ void zzb(final zzcsj zzcsjVar, List list, final zzgcf zzgcfVar) {
        if (list == null || list.isEmpty()) {
            zzcsjVar.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcse
                @Override // java.lang.Runnable
                public final void run() {
                    zzgcfVar.zza(new zzdwl(3));
                }
            });
            return;
        }
        m mVarZzh = zzgcj.zzh(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final m mVar = (m) it.next();
            mVarZzh = zzgcj.zzn(zzgcj.zzf(mVarZzh, Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsf
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final m zza(Object obj) {
                    zzgcfVar.zza((Throwable) obj);
                    return zzgcj.zzh(null);
                }
            }, zzcsjVar.zza), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsg
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final m zza(Object obj) {
                    return this.zza.zza(zzgcfVar, mVar, (zzcru) obj);
                }
            }, zzcsjVar.zza);
        }
        zzgcj.zzr(mVarZzh, new zzcsi(zzcsjVar, zzgcfVar), zzcsjVar.zza);
    }

    final /* synthetic */ m zza(zzgcf zzgcfVar, m mVar, zzcru zzcruVar) throws Exception {
        if (zzcruVar != null) {
            zzgcfVar.zzb(zzcruVar);
        }
        return zzgcj.zzo(mVar, ((Long) zzbef.zza.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzgcf zzgcfVar) {
        zzgcj.zzr(this.zzc, new zzcsh(this, zzgcfVar), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
