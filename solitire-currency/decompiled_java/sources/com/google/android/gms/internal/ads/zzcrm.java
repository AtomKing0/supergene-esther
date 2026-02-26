package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcrm {
    private final zzczj zza;

    @Nullable
    private final zzdbp zzb;

    public zzcrm(zzczj zzczjVar, @Nullable zzdbp zzdbpVar) {
        this.zza = zzczjVar;
        this.zzb = zzdbpVar;
    }

    public final zzczj zza() {
        return this.zza;
    }

    @Nullable
    final zzdbp zzb() {
        return this.zzb;
    }

    final zzdei zzc() {
        zzdbp zzdbpVar = this.zzb;
        return zzdbpVar != null ? new zzdei(zzdbpVar, zzbzo.zzf) : new zzdei(new zzcrl(this), zzbzo.zzf);
    }
}
