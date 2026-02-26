package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzkd {
    private long zza;
    private float zzb;
    private long zzc;

    public zzkd() {
        this.zza = C.TIME_UNSET;
        this.zzb = -3.4028235E38f;
        this.zzc = C.TIME_UNSET;
    }

    public final zzkd zzd(long j10) {
        boolean z10 = true;
        if (j10 < 0) {
            if (j10 == C.TIME_UNSET) {
                j10 = -9223372036854775807L;
            } else {
                z10 = false;
            }
        }
        zzdi.zzd(z10);
        this.zzc = j10;
        return this;
    }

    public final zzkd zze(long j10) {
        this.zza = j10;
        return this;
    }

    public final zzkd zzf(float f10) {
        boolean z10 = true;
        if (f10 <= 0.0f && f10 != -3.4028235E38f) {
            z10 = false;
        }
        zzdi.zzd(z10);
        this.zzb = f10;
        return this;
    }

    public final zzkf zzg() {
        return new zzkf(this, null);
    }

    /* synthetic */ zzkd(zzkf zzkfVar, zzkc zzkcVar) {
        this.zza = zzkfVar.zza;
        this.zzb = zzkfVar.zzb;
        this.zzc = zzkfVar.zzc;
    }
}
