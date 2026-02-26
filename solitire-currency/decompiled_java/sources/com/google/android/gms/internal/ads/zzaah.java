package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaah {
    private final zzaag zza;
    private final zzaal zzb;
    private boolean zzc;
    private long zzf;
    private boolean zzi;
    private int zzd = 0;
    private long zze = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private float zzj = 1.0f;

    public zzaah(Context context, zzaag zzaagVar, long j10) {
        this.zza = zzaagVar;
        this.zzb = new zzaal(context);
    }

    private final void zzp(int i10) {
        this.zzd = Math.min(this.zzd, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        if (r15 > androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        if (r20 >= r24) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
    
        if (r17.zzc != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(long r18, long r20, long r22, long r24, boolean r26, com.google.android.gms.internal.ads.zzaaf r27) throws com.google.android.gms.internal.ads.zzhw {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaah.zza(long, long, long, long, boolean, com.google.android.gms.internal.ads.zzaaf):int");
    }

    public final void zzb() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final void zzc(boolean z10) {
        this.zzi = z10;
        this.zzh = C.TIME_UNSET;
    }

    public final void zzd() {
        zzp(0);
    }

    public final void zze(boolean z10) {
        this.zzd = z10 ? 1 : 0;
    }

    public final void zzf() {
        zzp(2);
    }

    public final void zzg() {
        this.zzc = true;
        this.zzf = zzet.zzr(SystemClock.elapsedRealtime());
        this.zzb.zzg();
    }

    public final void zzh() {
        this.zzc = false;
        this.zzh = C.TIME_UNSET;
        this.zzb.zzh();
    }

    public final void zzi() {
        this.zzb.zzf();
        this.zzg = C.TIME_UNSET;
        this.zze = C.TIME_UNSET;
        zzp(1);
        this.zzh = C.TIME_UNSET;
    }

    public final void zzj(int i10) {
        this.zzb.zzj(i10);
    }

    public final void zzk(float f10) {
        this.zzb.zzc(f10);
    }

    public final void zzl(@Nullable Surface surface) {
        this.zzb.zzi(surface);
        zzp(1);
    }

    public final void zzm(float f10) {
        this.zzj = f10;
        this.zzb.zze(f10);
    }

    public final boolean zzn(boolean z10) {
        boolean z11 = true;
        if (z10 && this.zzd == 3) {
            this.zzh = C.TIME_UNSET;
        } else {
            if (this.zzh == C.TIME_UNSET) {
                return false;
            }
            if (SystemClock.elapsedRealtime() >= this.zzh) {
                z11 = false;
                this.zzh = C.TIME_UNSET;
            }
        }
        return z11;
    }

    public final boolean zzo() {
        int i10 = this.zzd;
        this.zzd = 3;
        this.zzf = zzet.zzr(SystemClock.elapsedRealtime());
        return i10 != 3;
    }
}
