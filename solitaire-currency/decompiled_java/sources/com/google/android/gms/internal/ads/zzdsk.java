package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdsk {
    private final zzdsp zza;
    private final Executor zzb;
    private final Map zzc;

    public zzdsk(zzdsp zzdspVar, Executor executor) {
        this.zza = zzdspVar;
        this.zzc = zzdspVar.zza();
        this.zzb = executor;
    }

    public final zzdsj zza() {
        zzdsj zzdsjVar = new zzdsj(this);
        zzdsj.zza(zzdsjVar);
        return zzdsjVar;
    }

    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkK)).booleanValue()) {
            zzdsj zzdsjVarZza = zza();
            zzdsjVarZza.zzb("action", "pecr");
            zzdsjVarZza.zzf();
        }
    }
}
