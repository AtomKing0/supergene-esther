package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public final class zzuc extends zzcc {
    private final zzbc zzb;

    public zzuc(zzbc zzbcVar) {
        this.zzb = zzbcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zza(Object obj) {
        return obj == zzub.zzc ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzb() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final int zzc() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final zzca zzd(int i10, zzca zzcaVar, boolean z10) {
        zzcaVar.zzl(z10 ? 0 : null, z10 ? zzub.zzc : null, 0, C.TIME_UNSET, 0L, zzb.zza, true);
        return zzcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final zzcb zze(int i10, zzcb zzcbVar, long j10) {
        zzcbVar.zza(zzcb.zza, this.zzb, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, null, 0L, C.TIME_UNSET, 0, 0, 0L);
        zzcbVar.zzk = true;
        return zzcbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final Object zzf(int i10) {
        return zzub.zzc;
    }
}
