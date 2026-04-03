package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetw implements zzevo {
    private final zzevo zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzetw(zzevo zzevoVar, long j10, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzevoVar;
        this.zzb = j10;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        m mVarZzb = this.zza.zzb();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbX)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j10 = this.zzb;
        if (j10 > 0) {
            mVarZzb = zzgcj.zzo(mVarZzb, j10, timeUnit, this.zzc);
        }
        return zzgcj.zzf(mVarZzb, Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzetv
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzc((Throwable) obj);
            }
        }, zzbzo.zzf);
    }

    final /* synthetic */ m zzc(Throwable th) throws Exception {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbW)).booleanValue()) {
            zzevo zzevoVar = this.zza;
            com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "OptionalSignalTimeout:" + zzevoVar.zza());
        }
        return zzgcj.zzh(null);
    }
}
