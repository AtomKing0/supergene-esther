package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class zzcaa {
    private final zzbzt zza;
    private final AtomicInteger zzb;

    public zzcaa() {
        zzbzt zzbztVar = new zzbzt();
        this.zza = zzbztVar;
        this.zzb = new AtomicInteger(0);
        zzgcj.zzr(zzbztVar, new zzbzy(this), zzbzo.zzf);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final void zzh(Throwable th, String str) {
        this.zza.zzd(th);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgS)).booleanValue()) {
            com.google.android.gms.ads.internal.zzu.zzo().zzv(th, str);
        }
    }

    @Deprecated
    public final void zzi(Object obj) {
        this.zza.zzc(obj);
    }

    @Deprecated
    public final void zzj(zzbzx zzbzxVar, zzbzv zzbzvVar) {
        zzgcj.zzr(this.zza, new zzbzz(this, zzbzxVar, zzbzvVar), zzbzo.zzf);
    }
}
