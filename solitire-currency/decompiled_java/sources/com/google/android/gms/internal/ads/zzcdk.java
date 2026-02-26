package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcdk implements zzfs {
    private final zzfs zza;
    private final long zzb;
    private final zzfs zzc;
    private long zzd;
    private Uri zze;

    zzcdk(zzfs zzfsVar, int i10, zzfs zzfsVar2) {
        this.zza = zzfsVar;
        this.zzb = i10;
        this.zzc = zzfsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        long j10 = this.zzd;
        long j11 = this.zzb;
        if (j10 < j11) {
            int iZza = this.zza.zza(bArr, i10, (int) Math.min(i11, j11 - j10));
            long j12 = this.zzd + ((long) iZza);
            this.zzd = j12;
            i12 = iZza;
            j10 = j12;
        } else {
            i12 = 0;
        }
        if (j10 < this.zzb) {
            return i12;
        }
        int iZza2 = this.zzc.zza(bArr, i10 + i12, i11 - i12);
        int i13 = i12 + iZza2;
        this.zzd += (long) iZza2;
        return i13;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws IOException {
        zzfy zzfyVar2;
        this.zze = zzfyVar.zza;
        long j10 = zzfyVar.zze;
        long j11 = this.zzb;
        zzfy zzfyVar3 = null;
        if (j10 >= j11) {
            zzfyVar2 = null;
        } else {
            long j12 = zzfyVar.zzf;
            long jMin = j11 - j10;
            if (j12 != -1) {
                jMin = Math.min(j12, jMin);
            }
            zzfyVar2 = new zzfy(zzfyVar.zza, j10, jMin, null);
        }
        long j13 = zzfyVar.zzf;
        if (j13 == -1 || zzfyVar.zze + j13 > this.zzb) {
            long jMax = Math.max(this.zzb, zzfyVar.zze);
            long j14 = zzfyVar.zzf;
            zzfyVar3 = new zzfy(zzfyVar.zza, jMax, j14 != -1 ? Math.min(j14, (zzfyVar.zze + j14) - this.zzb) : -1L, null);
        }
        long jZzb = zzfyVar2 != null ? this.zza.zzb(zzfyVar2) : 0L;
        long jZzb2 = zzfyVar3 != null ? this.zzc.zzb(zzfyVar3) : 0L;
        this.zzd = zzfyVar.zze;
        if (jZzb == -1 || jZzb2 == -1) {
            return -1L;
        }
        return jZzb + jZzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Map zze() {
        return zzfxu.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzf(zzgu zzguVar) {
    }
}
