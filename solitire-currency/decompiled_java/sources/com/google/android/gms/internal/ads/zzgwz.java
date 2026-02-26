package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgwz extends zzgxd {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    zzgwz(byte[] bArr, int i10, int i11) {
        super(null);
        int length = bArr.length;
        if (((length - i11) | i11) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i11)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzM(byte b10) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i10 = this.zzc;
            this.zzc = i10 + 1;
            bArr[i10] = b10;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzN(int i10, boolean z10) throws IOException {
        zzu(i10 << 3);
        zzM(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzO(int i10, zzgwm zzgwmVar) throws IOException {
        zzu((i10 << 3) | 2);
        zzu(zzgwmVar.zzd());
        zzgwmVar.zzo(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd, com.google.android.gms.internal.ads.zzgwd
    public final void zza(byte[] bArr, int i10, int i11) throws IOException {
        zze(bArr, i10, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i10, int i11) throws IOException {
        try {
            System.arraycopy(bArr, i10, this.zza, this.zzc, i11);
            this.zzc += i11;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i11)), e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzh(int i10, int i11) throws IOException {
        zzu((i10 << 3) | 5);
        zzi(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzi(int i10) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i11 = this.zzc;
            int i12 = i11 + 1;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.zzc = i14 + 1;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzj(int i10, long j10) throws IOException {
        zzu((i10 << 3) | 1);
        zzk(j10);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzk(long j10) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i10 = this.zzc;
            int i11 = i10 + 1;
            bArr[i10] = (byte) (((int) j10) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
            int i13 = i12 + 1;
            bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
            int i15 = i14 + 1;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i15 + 1;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.zzc = i17 + 1;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzl(int i10, int i11) throws IOException {
        zzu(i10 << 3);
        zzm(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzm(int i10) throws IOException {
        if (i10 >= 0) {
            zzu(i10);
        } else {
            zzw(i10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    final void zzn(int i10, zzgzj zzgzjVar, zzhae zzhaeVar) throws IOException {
        zzu((i10 << 3) | 2);
        zzu(((zzgvv) zzgzjVar).zzaM(zzhaeVar));
        zzhaeVar.zzj(zzgzjVar, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzo(int i10, zzgzj zzgzjVar) throws IOException {
        zzu(11);
        zzt(2, i10);
        zzu(26);
        zzu(zzgzjVar.zzaY());
        zzgzjVar.zzda(this);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzp(int i10, zzgwm zzgwmVar) throws IOException {
        zzu(11);
        zzt(2, i10);
        zzO(3, zzgwmVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzq(int i10, String str) throws IOException {
        zzu((i10 << 3) | 2);
        zzr(str);
    }

    public final void zzr(String str) throws IOException {
        int i10 = this.zzc;
        try {
            int iZzD = zzgxd.zzD(str.length() * 3);
            int iZzD2 = zzgxd.zzD(str.length());
            if (iZzD2 != iZzD) {
                zzu(zzhbe.zze(str));
                byte[] bArr = this.zza;
                int i11 = this.zzc;
                this.zzc = zzhbe.zzd(str, bArr, i11, this.zzb - i11);
                return;
            }
            int i12 = i10 + iZzD2;
            this.zzc = i12;
            int iZzd = zzhbe.zzd(str, this.zza, i12, this.zzb - i12);
            this.zzc = i10;
            zzu((iZzd - i10) - iZzD2);
            this.zzc = iZzd;
        } catch (zzhbd e10) {
            this.zzc = i10;
            zzH(str, e10);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzgxa(e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzs(int i10, int i11) throws IOException {
        zzu((i10 << 3) | i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzt(int i10, int i11) throws IOException {
        zzu(i10 << 3);
        zzu(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzu(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            try {
                byte[] bArr = this.zza;
                int i11 = this.zzc;
                this.zzc = i11 + 1;
                bArr[i11] = (byte) ((i10 | 128) & 255);
                i10 >>>= 7;
            } catch (IndexOutOfBoundsException e10) {
                throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e10);
            }
        }
        byte[] bArr2 = this.zza;
        int i12 = this.zzc;
        this.zzc = i12 + 1;
        bArr2[i12] = (byte) i10;
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzv(int i10, long j10) throws IOException {
        zzu(i10 << 3);
        zzw(j10);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzw(long j10) throws IOException {
        if (!zzgxd.zzb || this.zzb - this.zzc < 10) {
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zza;
                    int i10 = this.zzc;
                    this.zzc = i10 + 1;
                    bArr[i10] = (byte) ((((int) j10) | 128) & 255);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new zzgxa(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e10);
                }
            }
            byte[] bArr2 = this.zza;
            int i11 = this.zzc;
            this.zzc = i11 + 1;
            bArr2[i11] = (byte) j10;
            return;
        }
        while (true) {
            int i12 = (int) j10;
            if ((j10 & (-128)) == 0) {
                byte[] bArr3 = this.zza;
                int i13 = this.zzc;
                this.zzc = i13 + 1;
                zzhaz.zzq(bArr3, i13, (byte) i12);
                return;
            }
            byte[] bArr4 = this.zza;
            int i14 = this.zzc;
            this.zzc = i14 + 1;
            zzhaz.zzq(bArr4, i14, (byte) ((i12 | 128) & 255));
            j10 >>>= 7;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzL() {
    }
}
