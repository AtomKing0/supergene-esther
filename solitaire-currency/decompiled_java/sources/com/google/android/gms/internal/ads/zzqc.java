package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzqc {
    public final zzaf zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzcq zzi;
    public final boolean zzj = false;
    public final boolean zzk = false;
    public final boolean zzl = false;

    public zzqc(zzaf zzafVar, int i10, int i11, int i12, int i13, int i14, int i15, int i16, zzcq zzcqVar, boolean z10, boolean z11, boolean z12) {
        this.zza = zzafVar;
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = i14;
        this.zzg = i15;
        this.zzh = i16;
        this.zzi = zzcqVar;
    }

    public final AudioTrack zza(zzh zzhVar, int i10) throws zzph {
        AudioTrack audioTrack;
        try {
            if (zzet.zza >= 29) {
                audioTrack = new AudioTrack.Builder().setAudioAttributes(zzhVar.zza().zza).setAudioFormat(zzet.zzw(this.zze, this.zzf, this.zzg)).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(i10).setOffloadedPlayback(this.zzc == 1).build();
            } else {
                audioTrack = new AudioTrack(zzhVar.zza().zza, zzet.zzw(this.zze, this.zzf, this.zzg), this.zzh, 1, i10);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new zzph(state, this.zze, this.zzf, this.zzh, this.zza, zzc(), null);
        } catch (IllegalArgumentException | UnsupportedOperationException e10) {
            throw new zzph(0, this.zze, this.zzf, this.zzh, this.zza, zzc(), e10);
        }
    }

    public final zzpf zzb() {
        boolean z10 = this.zzc == 1;
        return new zzpf(this.zzg, this.zze, this.zzf, false, z10, this.zzh);
    }

    public final boolean zzc() {
        return this.zzc == 1;
    }
}
