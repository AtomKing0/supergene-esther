package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzadr {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzadr(byte[] bArr) {
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final int zza() {
        return (this.zzc * 8) + this.zzd;
    }

    public final int zzb(int i10) {
        int i11 = this.zzc;
        int i12 = 8 - this.zzd;
        int i13 = i11 + 1;
        byte[] bArr = this.zza;
        int iMin = Math.min(i10, i12);
        int i14 = ((bArr[i11] & 255) >> this.zzd) & (255 >> (8 - iMin));
        while (iMin < i10) {
            i14 |= (this.zza[i13] & 255) << iMin;
            iMin += 8;
            i13++;
        }
        int i15 = i14 & ((-1) >>> (32 - i10));
        zzc(i10);
        return i15;
    }

    public final void zzc(int i10) {
        int i11;
        int i12 = i10 / 8;
        int i13 = this.zzc + i12;
        this.zzc = i13;
        int i14 = this.zzd + (i10 - (i12 * 8));
        this.zzd = i14;
        if (i14 > 7) {
            i13++;
            this.zzc = i13;
            i14 -= 8;
            this.zzd = i14;
        }
        boolean z10 = false;
        if (i13 >= 0 && (i13 < (i11 = this.zzb) || (i13 == i11 && i14 == 0))) {
            z10 = true;
        }
        zzdi.zzf(z10);
    }

    public final boolean zzd() {
        int i10 = (this.zza[this.zzc] & 255) >> this.zzd;
        zzc(1);
        return 1 == (i10 & 1);
    }
}
