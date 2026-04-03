package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgxb extends zzgwy {
    private final OutputStream zzg;

    zzgxb(OutputStream outputStream, int i10) {
        super(i10);
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.zzg = outputStream;
    }

    private final void zzJ() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzK(int i10) throws IOException {
        if (this.zzb - this.zzc < i10) {
            zzJ();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzL() throws IOException {
        if (this.zzc > 0) {
            zzJ();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzM(byte b10) throws IOException {
        if (this.zzc == this.zzb) {
            zzJ();
        }
        zzc(b10);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzN(int i10, boolean z10) throws IOException {
        zzK(11);
        zzf(i10 << 3);
        zzc(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzO(int i10, zzgwm zzgwmVar) throws IOException {
        zzu((i10 << 3) | 2);
        zzu(zzgwmVar.zzd());
        zzgwmVar.zzo(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd, com.google.android.gms.internal.ads.zzgwd
    public final void zza(byte[] bArr, int i10, int i11) throws IOException {
        zzr(bArr, i10, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzh(int i10, int i11) throws IOException {
        zzK(14);
        zzf((i10 << 3) | 5);
        zzd(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzi(int i10) throws IOException {
        zzK(4);
        zzd(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzj(int i10, long j10) throws IOException {
        zzK(18);
        zzf((i10 << 3) | 1);
        zze(j10);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzk(long j10) throws IOException {
        zzK(8);
        zze(j10);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzl(int i10, int i11) throws IOException {
        zzK(20);
        zzf(i10 << 3);
        if (i11 >= 0) {
            zzf(i11);
        } else {
            zzg(i11);
        }
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
        zzx(str);
    }

    public final void zzr(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.zzb;
        int i13 = this.zzc;
        int i14 = i12 - i13;
        if (i14 >= i11) {
            System.arraycopy(bArr, i10, this.zza, i13, i11);
            this.zzc += i11;
            this.zzd += i11;
            return;
        }
        System.arraycopy(bArr, i10, this.zza, i13, i14);
        int i15 = i10 + i14;
        this.zzc = this.zzb;
        this.zzd += i14;
        zzJ();
        int i16 = i11 - i14;
        if (i16 <= this.zzb) {
            System.arraycopy(bArr, i15, this.zza, 0, i16);
            this.zzc = i16;
        } else {
            this.zzg.write(bArr, i15, i16);
        }
        this.zzd += i16;
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzs(int i10, int i11) throws IOException {
        zzu((i10 << 3) | i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzt(int i10, int i11) throws IOException {
        zzK(20);
        zzf(i10 << 3);
        zzf(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzu(int i10) throws IOException {
        zzK(5);
        zzf(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzv(int i10, long j10) throws IOException {
        zzK(20);
        zzf(i10 << 3);
        zzg(j10);
    }

    @Override // com.google.android.gms.internal.ads.zzgxd
    public final void zzw(long j10) throws IOException {
        zzK(10);
        zzg(j10);
    }

    public final void zzx(String str) throws IOException {
        int iZze;
        try {
            int length = str.length() * 3;
            int iZzD = zzgxd.zzD(length);
            int i10 = iZzD + length;
            int i11 = this.zzb;
            if (i10 > i11) {
                byte[] bArr = new byte[length];
                int iZzd = zzhbe.zzd(str, bArr, 0, length);
                zzu(iZzd);
                zzr(bArr, 0, iZzd);
                return;
            }
            if (i10 > i11 - this.zzc) {
                zzJ();
            }
            int iZzD2 = zzgxd.zzD(str.length());
            int i12 = this.zzc;
            try {
                if (iZzD2 == iZzD) {
                    int i13 = i12 + iZzD2;
                    this.zzc = i13;
                    int iZzd2 = zzhbe.zzd(str, this.zza, i13, this.zzb - i13);
                    this.zzc = i12;
                    iZze = (iZzd2 - i12) - iZzD2;
                    zzf(iZze);
                    this.zzc = iZzd2;
                } else {
                    iZze = zzhbe.zze(str);
                    zzf(iZze);
                    this.zzc = zzhbe.zzd(str, this.zza, this.zzc, iZze);
                }
                this.zzd += iZze;
            } catch (zzhbd e10) {
                this.zzd -= this.zzc - i12;
                this.zzc = i12;
                throw e10;
            } catch (ArrayIndexOutOfBoundsException e11) {
                throw new zzgxa(e11);
            }
        } catch (zzhbd e12) {
            zzH(str, e12);
        }
    }
}
