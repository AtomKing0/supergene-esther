package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzzv {
    private boolean zzc;
    private int zze;
    private zzzu zza = new zzzu();
    private zzzu zzb = new zzzu();
    private long zzd = C.TIME_UNSET;

    public final float zza() {
        if (this.zza.zzf()) {
            return (float) (1.0E9d / this.zza.zza());
        }
        return -1.0f;
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc() {
        return this.zza.zzf() ? this.zza.zza() : C.TIME_UNSET;
    }

    public final long zzd() {
        return this.zza.zzf() ? this.zza.zzb() : C.TIME_UNSET;
    }

    public final void zze(long j10) {
        this.zza.zzc(j10);
        if (this.zza.zzf()) {
            this.zzc = false;
        } else if (this.zzd != C.TIME_UNSET) {
            if (!this.zzc || this.zzb.zze()) {
                this.zzb.zzd();
                this.zzb.zzc(this.zzd);
            }
            this.zzc = true;
            this.zzb.zzc(j10);
        }
        if (this.zzc && this.zzb.zzf()) {
            zzzu zzzuVar = this.zza;
            this.zza = this.zzb;
            this.zzb = zzzuVar;
            this.zzc = false;
        }
        this.zzd = j10;
        this.zze = this.zza.zzf() ? 0 : this.zze + 1;
    }

    public final void zzf() {
        this.zza.zzd();
        this.zzb.zzd();
        this.zzc = false;
        this.zzd = C.TIME_UNSET;
        this.zze = 0;
    }

    public final boolean zzg() {
        return this.zza.zzf();
    }
}
