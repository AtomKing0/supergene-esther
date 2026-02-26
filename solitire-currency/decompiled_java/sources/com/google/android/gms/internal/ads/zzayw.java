package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzayw {
    private final float zza;
    private final float zzb;
    private final float zzc;
    private final float zzd;
    private final int zze;

    @VisibleForTesting
    public zzayw(float f10, float f11, float f12, float f13, int i10) {
        this.zza = f10;
        this.zzb = f11;
        this.zzc = f10 + f12;
        this.zzd = f11 + f13;
        this.zze = i10;
    }

    final float zza() {
        return this.zzd;
    }

    final float zzb() {
        return this.zza;
    }

    final float zzc() {
        return this.zzc;
    }

    final float zzd() {
        return this.zzb;
    }

    final int zze() {
        return this.zze;
    }
}
