package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzek {
    private static final char[] zza = {'\r', '\n'};
    private static final char[] zzb = {'\n'};
    private static final zzfxw zzc = zzfxw.zzr(zzfuj.zza, zzfuj.zzc, zzfuj.zzf, zzfuj.zzd, zzfuj.zze);
    private byte[] zzd;
    private int zze;
    private int zzf;

    public zzek(byte[] bArr, int i10) {
        this.zzd = bArr;
        this.zzf = i10;
    }

    private final char zzN(Charset charset, char[] cArr) {
        int iZzO = zzO(charset);
        if (iZzO != 0) {
            int i10 = iZzO >> 16;
            for (char c10 : cArr) {
                char c11 = (char) i10;
                if (c10 == c11) {
                    this.zze += (char) iZzO;
                    return c11;
                }
            }
        }
        return (char) 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzO(java.nio.charset.Charset r5) {
        /*
            r4 = this;
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfuj.zzc
            boolean r0 = r5.equals(r0)
            r1 = 1
            if (r0 != 0) goto L11
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfuj.zza
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L25
        L11:
            int r0 = r4.zzf
            int r2 = r4.zze
            int r0 = r0 - r2
            if (r0 <= 0) goto L25
            byte[] r5 = r4.zzd
            r5 = r5[r2]
            r5 = r5 & 255(0xff, float:3.57E-43)
            long r2 = (long) r5
            char r5 = com.google.android.gms.internal.ads.zzgam.zza(r2)
            byte r5 = (byte) r5
            goto L67
        L25:
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfuj.zzf
            boolean r0 = r5.equals(r0)
            r2 = 2
            if (r0 != 0) goto L36
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfuj.zzd
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L4b
        L36:
            int r0 = r4.zzf
            int r3 = r4.zze
            int r0 = r0 - r3
            if (r0 < r2) goto L4b
            byte[] r5 = r4.zzd
            r0 = r5[r3]
            int r3 = r3 + r1
            r5 = r5[r3]
            char r5 = com.google.android.gms.internal.ads.zzgam.zzb(r0, r5)
        L48:
            byte r5 = (byte) r5
            r1 = r2
            goto L67
        L4b:
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfuj.zze
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L70
            int r5 = r4.zzf
            int r0 = r4.zze
            int r5 = r5 - r0
            if (r5 < r2) goto L70
            byte[] r5 = r4.zzd
            int r1 = r0 + 1
            r1 = r5[r1]
            r5 = r5[r0]
            char r5 = com.google.android.gms.internal.ads.zzgam.zzb(r1, r5)
            goto L48
        L67:
            long r2 = (long) r5
            char r5 = com.google.android.gms.internal.ads.zzgam.zza(r2)
            int r5 = r5 << 16
            int r5 = r5 + r1
            return r5
        L70:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzek.zzO(java.nio.charset.Charset):int");
    }

    public final String zzA(int i10, Charset charset) {
        byte[] bArr = this.zzd;
        int i11 = this.zze;
        String str = new String(bArr, i11, i10, charset);
        this.zze = i11 + i10;
        return str;
    }

    @Nullable
    public final Charset zzB() {
        int i10 = this.zzf;
        int i11 = this.zze;
        int i12 = i10 - i11;
        if (i12 >= 3) {
            byte[] bArr = this.zzd;
            if (bArr[i11] == -17 && bArr[i11 + 1] == -69 && bArr[i11 + 2] == -65) {
                this.zze = i11 + 3;
                return zzfuj.zzc;
            }
        }
        if (i12 < 2) {
            return null;
        }
        byte[] bArr2 = this.zzd;
        byte b10 = bArr2[i11];
        if (b10 == -2) {
            if (bArr2[i11 + 1] != -1) {
                return null;
            }
            this.zze = i11 + 2;
            return zzfuj.zzd;
        }
        if (b10 != -1 || bArr2[i11 + 1] != -2) {
            return null;
        }
        this.zze = i11 + 2;
        return zzfuj.zze;
    }

    public final short zzC() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        this.zze = i11 + 1;
        return (short) (((bArr[i11] & 255) << 8) | i12);
    }

    public final short zzD() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        this.zze = i11 + 1;
        return (short) ((bArr[i11] & 255) | (i12 << 8));
    }

    public final void zzE(int i10) {
        byte[] bArr = this.zzd;
        if (i10 > bArr.length) {
            this.zzd = Arrays.copyOf(bArr, i10);
        }
    }

    public final void zzF(zzej zzejVar, int i10) {
        zzG(zzejVar.zza, 0, i10);
        zzejVar.zzl(0);
    }

    public final void zzG(byte[] bArr, int i10, int i11) {
        System.arraycopy(this.zzd, this.zze, bArr, i10, i11);
        this.zze += i11;
    }

    public final void zzH(int i10) {
        byte[] bArr = this.zzd;
        if (bArr.length < i10) {
            bArr = new byte[i10];
        }
        zzI(bArr, i10);
    }

    public final void zzI(byte[] bArr, int i10) {
        this.zzd = bArr;
        this.zzf = i10;
        this.zze = 0;
    }

    public final void zzJ(int i10) {
        boolean z10 = false;
        if (i10 >= 0 && i10 <= this.zzd.length) {
            z10 = true;
        }
        zzdi.zzd(z10);
        this.zzf = i10;
    }

    public final void zzK(int i10) {
        boolean z10 = false;
        if (i10 >= 0 && i10 <= this.zzf) {
            z10 = true;
        }
        zzdi.zzd(z10);
        this.zze = i10;
    }

    public final void zzL(int i10) {
        zzK(this.zze + i10);
    }

    public final byte[] zzM() {
        return this.zzd;
    }

    public final char zza(Charset charset) {
        zzdi.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(charset)));
        return (char) (zzO(charset) >> 16);
    }

    public final int zzb() {
        return this.zzf - this.zze;
    }

    public final int zzc() {
        return this.zzd.length;
    }

    public final int zzd() {
        return this.zze;
    }

    public final int zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzd[this.zze] & 255;
    }

    public final int zzg() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        int i13 = i11 + 1;
        int i14 = bArr[i11] & 255;
        int i15 = i13 + 1;
        int i16 = bArr[i13] & 255;
        this.zze = i15 + 1;
        return (bArr[i15] & 255) | (i12 << 24) | (i14 << 16) | (i16 << 8);
    }

    public final int zzh() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        int i13 = i11 + 1;
        int i14 = bArr[i11] & 255;
        this.zze = i13 + 1;
        return (bArr[i13] & 255) | ((i12 << 24) >> 8) | (i14 << 8);
    }

    public final int zzi() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        int i13 = i11 + 1;
        int i14 = bArr[i11] & 255;
        int i15 = i13 + 1;
        int i16 = bArr[i13] & 255;
        this.zze = i15 + 1;
        return ((bArr[i15] & 255) << 24) | i12 | (i14 << 8) | (i16 << 16);
    }

    public final int zzj() {
        int iZzi = zzi();
        if (iZzi >= 0) {
            return iZzi;
        }
        throw new IllegalStateException("Top bit not zero: " + iZzi);
    }

    public final int zzk() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        this.zze = i11 + 1;
        return ((bArr[i11] & 255) << 8) | i12;
    }

    public final int zzl() {
        return (zzm() << 21) | (zzm() << 14) | (zzm() << 7) | zzm();
    }

    public final int zzm() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        this.zze = i10 + 1;
        return bArr[i10] & 255;
    }

    public final int zzn() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        int i13 = bArr[i11] & 255;
        this.zze = i11 + 1 + 2;
        return i13 | (i12 << 8);
    }

    public final int zzo() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        int i13 = i11 + 1;
        int i14 = bArr[i11] & 255;
        this.zze = i13 + 1;
        return (bArr[i13] & 255) | (i12 << 16) | (i14 << 8);
    }

    public final int zzp() {
        int iZzg = zzg();
        if (iZzg >= 0) {
            return iZzg;
        }
        throw new IllegalStateException("Top bit not zero: " + iZzg);
    }

    public final int zzq() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        this.zze = i11 + 1;
        return (bArr[i11] & 255) | (i12 << 8);
    }

    public final long zzr() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        int i12 = i11 + 1;
        long j11 = bArr[i11];
        int i13 = i12 + 1;
        long j12 = bArr[i12];
        int i14 = i13 + 1;
        long j13 = bArr[i13];
        int i15 = i14 + 1;
        long j14 = bArr[i14];
        int i16 = i15 + 1;
        long j15 = bArr[i15];
        int i17 = i16 + 1;
        long j16 = bArr[i16];
        this.zze = i17 + 1;
        return ((bArr[i17] & 255) << 56) | ((j16 & 255) << 48) | (j10 & 255) | ((j11 & 255) << 8) | ((j12 & 255) << 16) | ((j13 & 255) << 24) | ((j14 & 255) << 32) | ((j15 & 255) << 40);
    }

    public final long zzs() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        int i12 = i11 + 1;
        long j11 = bArr[i11];
        int i13 = i12 + 1;
        long j12 = bArr[i12];
        this.zze = i13 + 1;
        return ((((long) bArr[i13]) & 255) << 24) | (j10 & 255) | ((j11 & 255) << 8) | ((j12 & 255) << 16);
    }

    public final long zzt() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        int i12 = i11 + 1;
        long j11 = bArr[i11];
        int i13 = i12 + 1;
        long j12 = bArr[i12];
        int i14 = i13 + 1;
        long j13 = bArr[i13];
        int i15 = i14 + 1;
        long j14 = bArr[i14];
        int i16 = i15 + 1;
        long j15 = bArr[i15];
        int i17 = i16 + 1;
        long j16 = bArr[i16];
        this.zze = i17 + 1;
        return (((long) bArr[i17]) & 255) | ((j10 & 255) << 56) | ((j11 & 255) << 48) | ((j12 & 255) << 40) | ((j13 & 255) << 32) | ((j14 & 255) << 24) | ((j15 & 255) << 16) | ((j16 & 255) << 8);
    }

    public final long zzu() {
        byte[] bArr = this.zzd;
        int i10 = this.zze;
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        int i12 = i11 + 1;
        long j11 = bArr[i11];
        int i13 = i12 + 1;
        long j12 = bArr[i12];
        this.zze = i13 + 1;
        return (((long) bArr[i13]) & 255) | ((j10 & 255) << 24) | ((j11 & 255) << 16) | ((j12 & 255) << 8);
    }

    public final long zzv() {
        long jZzt = zzt();
        if (jZzt >= 0) {
            return jZzt;
        }
        throw new IllegalStateException("Top bit not zero: " + jZzt);
    }

    public final long zzw() {
        int i10;
        int i11;
        long j10 = this.zzd[this.zze];
        int i12 = 7;
        while (true) {
            i10 = 0;
            if (i12 < 0) {
                break;
            }
            int i13 = 1 << i12;
            if ((((long) i13) & j10) != 0) {
                i12--;
            } else if (i12 < 6) {
                j10 &= (long) (i13 - 1);
                i10 = 7 - i12;
            } else if (i12 == 7) {
                i10 = 1;
            }
        }
        if (i10 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j10);
        }
        for (i11 = 1; i11 < i10; i11++) {
            byte b10 = this.zzd[this.zze + i11];
            if ((b10 & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j10);
            }
            j10 = (j10 << 6) | ((long) (b10 & 63));
        }
        this.zze += i10;
        return j10;
    }

    @Nullable
    public final String zzx(char c10) {
        int i10 = this.zzf;
        int i11 = this.zze;
        if (i10 - i11 == 0) {
            return null;
        }
        while (i11 < this.zzf && this.zzd[i11] != 0) {
            i11++;
        }
        byte[] bArr = this.zzd;
        int i12 = this.zze;
        String strZzB = zzet.zzB(bArr, i12, i11 - i12);
        this.zze = i11;
        if (i11 < this.zzf) {
            this.zze = i11 + 1;
        }
        return strZzB;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zzy(java.nio.charset.Charset r5) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzek.zzy(java.nio.charset.Charset):java.lang.String");
    }

    public final String zzz(int i10) {
        if (i10 == 0) {
            return "";
        }
        int i11 = this.zze;
        int i12 = (i11 + i10) - 1;
        String strZzB = zzet.zzB(this.zzd, i11, (i12 >= this.zzf || this.zzd[i12] != 0) ? i10 : i10 - 1);
        this.zze += i10;
        return strZzB;
    }

    public zzek() {
        this.zzd = zzet.zzf;
    }

    public zzek(int i10) {
        this.zzd = new byte[i10];
        this.zzf = i10;
    }

    public zzek(byte[] bArr) {
        this.zzd = bArr;
        this.zzf = bArr.length;
    }
}
