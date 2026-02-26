package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.dash.DashMediaSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcdh implements zzkb {
    private final zzyk zza = new zzyk(true, 65536);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US;
    private int zzf;
    private boolean zzg;

    zzcdh() {
    }

    @VisibleForTesting
    final void zza(boolean z10) {
        this.zzf = 0;
        this.zzg = false;
        if (z10) {
            this.zza.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final long zzb(zznz zznzVar) {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zzc(zznz zznzVar) {
        zza(false);
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zzd(zznz zznzVar) {
        zza(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zze(zznz zznzVar) {
        zza(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zzf(zznz zznzVar, zzcc zzccVar, zzui zzuiVar, zzle[] zzleVarArr, zzwi zzwiVar, zzxv[] zzxvVarArr) {
        int i10 = 0;
        this.zzf = 0;
        while (true) {
            int length = zzleVarArr.length;
            if (i10 >= 2) {
                this.zza.zzf(this.zzf);
                return;
            } else {
                if (zzxvVarArr[i10] != null) {
                    this.zzf += zzleVarArr[i10].zzb() != 1 ? DefaultLoadControl.DEFAULT_VIDEO_BUFFER_SIZE : 13107200;
                }
                i10++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final boolean zzg(zznz zznzVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final boolean zzh(zzka zzkaVar) {
        long j10 = zzkaVar.zzb;
        boolean z10 = true;
        char c10 = j10 > this.zzc ? (char) 0 : j10 < this.zzb ? (char) 2 : (char) 1;
        int iZza = this.zza.zza();
        int i10 = this.zzf;
        if (c10 != 2 && (c10 != 1 || !this.zzg || iZza >= i10)) {
            z10 = false;
        }
        this.zzg = z10;
        return z10;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final boolean zzi(zzka zzkaVar) {
        long j10 = zzkaVar.zzd ? this.zze : this.zzd;
        return j10 <= 0 || zzkaVar.zzb >= j10;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final zzyk zzj() {
        return this.zza;
    }

    public final synchronized void zzk(int i10) {
        this.zzd = ((long) i10) * 1000;
    }

    public final synchronized void zzl(int i10) {
        this.zze = ((long) i10) * 1000;
    }

    public final synchronized void zzm(int i10) {
        this.zzc = ((long) i10) * 1000;
    }

    public final synchronized void zzn(int i10) {
        this.zzb = ((long) i10) * 1000;
    }
}
