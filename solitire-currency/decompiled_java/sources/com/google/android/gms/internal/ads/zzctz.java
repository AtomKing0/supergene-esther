package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzctz implements zzdce, zzcye {
    private final Clock zza;
    private final zzcub zzb;
    private final zzffg zzc;
    private final String zzd;

    zzctz(Clock clock, zzcub zzcubVar, zzffg zzffgVar, String str) {
        this.zza = clock;
        this.zzb = zzcubVar;
        this.zzc = zzffgVar;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdce
    public final void zza() {
        this.zzb.zze(this.zzd, this.zza.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        zzffg zzffgVar = this.zzc;
        this.zzb.zzd(zzffgVar.zzf, this.zzd, this.zza.elapsedRealtime());
    }
}
