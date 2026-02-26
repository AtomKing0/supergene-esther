package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgws extends zzgww {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    /* synthetic */ zzgws(InputStream inputStream, int i10, zzgwr zzgwrVar) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        byte[] bArr = zzgyl.zzb;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzI(int i10) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i10 > 0) {
            int iMin = Math.min(i10, 4096);
            byte[] bArr = new byte[iMin];
            int i11 = 0;
            while (i11 < iMin) {
                int i12 = this.zze.read(bArr, i11, iMin - i11);
                if (i12 == -1) {
                    throw zzgyn.zzi();
                }
                this.zzk += i12;
                i11 += i12;
            }
            i10 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzJ() {
        int i10 = this.zzg + this.zzh;
        this.zzg = i10;
        int i11 = this.zzk + i10;
        int i12 = this.zzl;
        if (i11 <= i12) {
            this.zzh = 0;
            return;
        }
        int i13 = i11 - i12;
        this.zzh = i13;
        this.zzg = i10 - i13;
    }

    private final void zzK(int i10) throws IOException {
        if (zzL(i10)) {
            return;
        }
        if (i10 <= (Integer.MAX_VALUE - this.zzk) - this.zzi) {
            throw zzgyn.zzi();
        }
        throw zzgyn.zzh();
    }

    private final boolean zzL(int i10) throws IOException {
        int i11 = this.zzi;
        int i12 = i11 + i10;
        int i13 = this.zzg;
        if (i12 <= i13) {
            throw new IllegalStateException("refillBuffer() called when " + i10 + " bytes were already available in buffer");
        }
        int i14 = this.zzk;
        if (i10 > (Integer.MAX_VALUE - i14) - i11 || i14 + i11 + i10 > this.zzl) {
            return false;
        }
        if (i11 > 0) {
            if (i13 > i11) {
                byte[] bArr = this.zzf;
                System.arraycopy(bArr, i11, bArr, 0, i13 - i11);
            }
            i14 = this.zzk + i11;
            this.zzk = i14;
            i13 = this.zzg - i11;
            this.zzg = i13;
            this.zzi = 0;
        }
        try {
            int i15 = this.zze.read(this.zzf, i13, Math.min(4096 - i13, (Integer.MAX_VALUE - i14) - i13));
            if (i15 == 0 || i15 < -1 || i15 > 4096) {
                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + i15 + "\nThe InputStream implementation is buggy.");
            }
            if (i15 <= 0) {
                return false;
            }
            this.zzg += i15;
            zzJ();
            if (this.zzg >= i10) {
                return true;
            }
            return zzL(i10);
        } catch (zzgyn e10) {
            e10.zzj();
            throw e10;
        }
    }

    private final byte[] zzM(int i10, boolean z10) throws IOException {
        byte[] bArrZzN = zzN(i10);
        if (bArrZzN != null) {
            return bArrZzN;
        }
        int i11 = this.zzi;
        int i12 = this.zzg;
        int i13 = i12 - i11;
        this.zzk += i12;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzI = zzI(i10 - i13);
        byte[] bArr = new byte[i10];
        System.arraycopy(this.zzf, i11, bArr, 0, i13);
        for (byte[] bArr2 : listZzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i13, length);
            i13 += length;
        }
        return bArr;
    }

    private final byte[] zzN(int i10) throws IOException {
        if (i10 == 0) {
            return zzgyl.zzb;
        }
        int i11 = this.zzk;
        int i12 = this.zzi;
        int i13 = i11 + i12 + i10;
        if (C.RATE_UNSET_INT + i13 > 0) {
            throw zzgyn.zzh();
        }
        int i14 = this.zzl;
        if (i13 > i14) {
            zzC((i14 - i11) - i12);
            throw zzgyn.zzi();
        }
        int i15 = this.zzg - i12;
        int i16 = i10 - i15;
        if (i16 >= 4096) {
            try {
                if (i16 > this.zze.available()) {
                    return null;
                }
            } catch (zzgyn e10) {
                e10.zzj();
                throw e10;
            }
        }
        byte[] bArr = new byte[i10];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i15);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i15 < i10) {
            try {
                int i17 = this.zze.read(bArr, i15, i10 - i15);
                if (i17 == -1) {
                    throw zzgyn.zzi();
                }
                this.zzk += i17;
                i15 += i17;
            } catch (zzgyn e11) {
                e11.zzj();
                throw e11;
            }
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzA() throws IOException {
        return this.zzi == this.zzg && !zzL(1);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzB() throws IOException {
        return zzq() != 0;
    }

    public final void zzC(int i10) throws IOException {
        int i11 = this.zzg;
        int i12 = this.zzi;
        int i13 = i11 - i12;
        if (i10 <= i13 && i10 >= 0) {
            this.zzi = i12 + i10;
            return;
        }
        if (i10 < 0) {
            throw zzgyn.zzf();
        }
        int i14 = this.zzk;
        int i15 = i14 + i12;
        int i16 = this.zzl;
        if (i15 + i10 > i16) {
            zzC((i16 - i14) - i12);
            throw zzgyn.zzi();
        }
        this.zzk = i15;
        this.zzg = 0;
        this.zzi = 0;
        while (i13 < i10) {
            try {
                long j10 = i10 - i13;
                try {
                    long jSkip = this.zze.skip(j10);
                    if (jSkip < 0 || jSkip > j10) {
                        throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i13 += (int) jSkip;
                    }
                } catch (zzgyn e10) {
                    e10.zzj();
                    throw e10;
                }
            } finally {
                this.zzk += i13;
                zzJ();
            }
        }
        if (i13 >= i10) {
            return;
        }
        int i17 = this.zzg;
        int i18 = i17 - this.zzi;
        this.zzi = i17;
        zzK(1);
        while (true) {
            int i19 = i10 - i18;
            int i20 = this.zzg;
            if (i19 <= i20) {
                this.zzi = i19;
                return;
            } else {
                i18 += i20;
                this.zzi = i20;
                zzK(1);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzp());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzh());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzc() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzd(int i10) throws zzgyn {
        if (i10 < 0) {
            throw zzgyn.zzf();
        }
        int i11 = i10 + this.zzk + this.zzi;
        if (i11 < 0) {
            throw zzgyn.zzg();
        }
        int i12 = this.zzl;
        if (i11 > i12) {
            throw zzgyn.zzi();
        }
        this.zzl = i11;
        zzJ();
        return i12;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zze() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzf() throws IOException {
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzg() throws IOException {
        return zzi();
    }

    public final int zzh() throws IOException {
        int i10 = this.zzi;
        if (this.zzg - i10 < 4) {
            zzK(4);
            i10 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i10 + 4;
        int i11 = bArr[i10] & 255;
        int i12 = bArr[i10 + 1] & 255;
        int i13 = bArr[i10 + 2] & 255;
        return ((bArr[i10 + 3] & 255) << 24) | (i12 << 8) | i11 | (i13 << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (r2[r3] < 0) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzi() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 != r0) goto L7
            goto L6d
        L7:
            byte[] r2 = r5.zzf
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.zzi = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6d
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L23
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L6a
        L23:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L30
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2e:
            r1 = r3
            goto L6a
        L30:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L6a
        L3e:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L6a
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L6a
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L6a
            goto L6d
        L6a:
            r5.zzi = r1
            return r0
        L6d:
            long r0 = r5.zzr()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgws.zzi():int");
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzj() throws IOException {
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzk() throws IOException {
        return zzgww.zzD(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzl() throws IOException {
        if (zzA()) {
            this.zzj = 0;
            return 0;
        }
        int iZzi = zzi();
        this.zzj = iZzi;
        if ((iZzi >>> 3) != 0) {
            return iZzi;
        }
        throw zzgyn.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzm() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzn() throws IOException {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzo() throws IOException {
        return zzq();
    }

    public final long zzp() throws IOException {
        int i10 = this.zzi;
        if (this.zzg - i10 < 8) {
            zzK(8);
            i10 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i10 + 8;
        long j10 = bArr[i10];
        long j11 = (((long) bArr[i10 + 1]) & 255) << 8;
        long j12 = bArr[i10 + 2];
        long j13 = bArr[i10 + 3];
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (j10 & 255) | j11 | ((j12 & 255) << 16) | ((j13 & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }

    public final long zzq() throws IOException {
        long j10;
        long j11;
        long j12;
        long j13;
        int i10;
        int i11 = this.zzi;
        int i12 = this.zzg;
        if (i12 != i11) {
            byte[] bArr = this.zzf;
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 >= 0) {
                this.zzi = i13;
                return b10;
            }
            if (i12 - i13 >= 9) {
                int i14 = i13 + 1;
                int i15 = b10 ^ (bArr[i13] << 7);
                if (i15 >= 0) {
                    int i16 = i14 + 1;
                    int i17 = i15 ^ (bArr[i14] << 14);
                    if (i17 >= 0) {
                        j10 = i17 ^ 16256;
                    } else {
                        i14 = i16 + 1;
                        int i18 = i17 ^ (bArr[i16] << 21);
                        if (i18 < 0) {
                            i10 = i18 ^ (-2080896);
                        } else {
                            i16 = i14 + 1;
                            long j14 = ((long) i18) ^ (((long) bArr[i14]) << 28);
                            if (j14 < 0) {
                                int i19 = i16 + 1;
                                long j15 = j14 ^ (((long) bArr[i16]) << 35);
                                if (j15 < 0) {
                                    j12 = -34093383808L;
                                } else {
                                    i16 = i19 + 1;
                                    j14 = j15 ^ (((long) bArr[i19]) << 42);
                                    if (j14 >= 0) {
                                        j13 = 4363953127296L;
                                    } else {
                                        i19 = i16 + 1;
                                        j15 = j14 ^ (((long) bArr[i16]) << 49);
                                        if (j15 < 0) {
                                            j12 = -558586000294016L;
                                        } else {
                                            i16 = i19 + 1;
                                            j10 = (j15 ^ (((long) bArr[i19]) << 56)) ^ 71499008037633920L;
                                            if (j10 < 0) {
                                                i19 = i16 + 1;
                                                if (bArr[i16] >= 0) {
                                                    j11 = j10;
                                                    i14 = i19;
                                                    this.zzi = i14;
                                                    return j11;
                                                }
                                            }
                                        }
                                    }
                                }
                                j11 = j12 ^ j15;
                                i14 = i19;
                                this.zzi = i14;
                                return j11;
                            }
                            j13 = 266354560;
                            j10 = j14 ^ j13;
                        }
                    }
                    i14 = i16;
                    j11 = j10;
                    this.zzi = i14;
                    return j11;
                }
                i10 = i15 ^ (-128);
                j11 = i10;
                this.zzi = i14;
                return j11;
            }
        }
        return zzr();
    }

    final long zzr() throws IOException {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            if (this.zzi == this.zzg) {
                zzK(1);
            }
            byte[] bArr = this.zzf;
            int i11 = this.zzi;
            this.zzi = i11 + 1;
            byte b10 = bArr[i11];
            j10 |= ((long) (b10 & 127)) << i10;
            if ((b10 & 128) == 0) {
                return j10;
            }
        }
        throw zzgyn.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzs() throws IOException {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzt() throws IOException {
        return zzgww.zzF(zzq());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzu() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final zzgwm zzv() throws IOException {
        int iZzi = zzi();
        int i10 = this.zzg;
        int i11 = this.zzi;
        if (iZzi <= i10 - i11 && iZzi > 0) {
            zzgwm zzgwmVarZzv = zzgwm.zzv(this.zzf, i11, iZzi);
            this.zzi += iZzi;
            return zzgwmVarZzv;
        }
        if (iZzi == 0) {
            return zzgwm.zzb;
        }
        if (iZzi < 0) {
            throw zzgyn.zzf();
        }
        byte[] bArrZzN = zzN(iZzi);
        if (bArrZzN != null) {
            return zzgwm.zzv(bArrZzN, 0, bArrZzN.length);
        }
        int i12 = this.zzi;
        int i13 = this.zzg;
        int i14 = i13 - i12;
        this.zzk += i13;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzI = zzI(iZzi - i14);
        byte[] bArr = new byte[iZzi];
        System.arraycopy(this.zzf, i12, bArr, 0, i14);
        for (byte[] bArr2 : listZzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i14, length);
            i14 += length;
        }
        return new zzgwk(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzw() throws IOException {
        int iZzi = zzi();
        if (iZzi > 0) {
            int i10 = this.zzg;
            int i11 = this.zzi;
            if (iZzi <= i10 - i11) {
                String str = new String(this.zzf, i11, iZzi, zzgyl.zza);
                this.zzi += iZzi;
                return str;
            }
        }
        if (iZzi == 0) {
            return "";
        }
        if (iZzi < 0) {
            throw zzgyn.zzf();
        }
        if (iZzi > this.zzg) {
            return new String(zzM(iZzi, false), zzgyl.zza);
        }
        zzK(iZzi);
        String str2 = new String(this.zzf, this.zzi, iZzi, zzgyl.zza);
        this.zzi += iZzi;
        return str2;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzx() throws IOException {
        byte[] bArrZzM;
        int iZzi = zzi();
        int i10 = this.zzi;
        int i11 = this.zzg;
        if (iZzi <= i11 - i10 && iZzi > 0) {
            bArrZzM = this.zzf;
            this.zzi = i10 + iZzi;
        } else {
            if (iZzi == 0) {
                return "";
            }
            if (iZzi < 0) {
                throw zzgyn.zzf();
            }
            i10 = 0;
            if (iZzi <= i11) {
                zzK(iZzi);
                bArrZzM = this.zzf;
                this.zzi = iZzi;
            } else {
                bArrZzM = zzM(iZzi, false);
            }
        }
        return zzhbe.zzh(bArrZzM, i10, iZzi);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final void zzy(int i10) throws zzgyn {
        if (this.zzj != i10) {
            throw zzgyn.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final void zzz(int i10) {
        this.zzl = i10;
        zzJ();
    }
}
