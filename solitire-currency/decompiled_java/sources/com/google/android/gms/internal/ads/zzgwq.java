package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgwq extends zzgww {
    private final Iterable zze;
    private final Iterator zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    /* synthetic */ zzgwq(Iterable iterable, int i10, boolean z10, zzgwp zzgwpVar) {
        super(null);
        this.zzj = Integer.MAX_VALUE;
        this.zzh = i10;
        this.zze = iterable;
        this.zzf = iterable.iterator();
        this.zzl = 0;
        if (i10 != 0) {
            zzM();
            return;
        }
        this.zzg = zzgyl.zzc;
        this.zzm = 0L;
        this.zzn = 0L;
        this.zzo = 0L;
    }

    private final int zzI() {
        return (int) ((((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn);
    }

    private final void zzJ() throws zzgyn {
        if (!this.zzf.hasNext()) {
            throw zzgyn.zzi();
        }
        zzM();
    }

    private final void zzK(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 > zzI()) {
            if (i11 > 0) {
                throw zzgyn.zzi();
            }
            return;
        }
        int i12 = i11;
        while (i12 > 0) {
            if (this.zzo - this.zzm == 0) {
                zzJ();
            }
            int iMin = Math.min(i12, (int) (this.zzo - this.zzm));
            long j10 = iMin;
            zzhaz.zzo(this.zzm, bArr, i11 - i12, j10);
            i12 -= iMin;
            this.zzm += j10;
        }
    }

    private final void zzL() {
        int i10 = this.zzh + this.zzi;
        this.zzh = i10;
        int i11 = this.zzj;
        if (i10 <= i11) {
            this.zzi = 0;
            return;
        }
        int i12 = i10 - i11;
        this.zzi = i12;
        this.zzh = i10 - i12;
    }

    private final void zzM() {
        ByteBuffer byteBuffer = (ByteBuffer) this.zzf.next();
        this.zzg = byteBuffer;
        this.zzl += (int) (this.zzm - this.zzn);
        long jPosition = byteBuffer.position();
        this.zzm = jPosition;
        this.zzn = jPosition;
        this.zzo = this.zzg.limit();
        long jZze = zzhaz.zze(this.zzg);
        this.zzm += jZze;
        this.zzn += jZze;
        this.zzo += jZze;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzA() throws IOException {
        return (((long) this.zzl) + this.zzm) - this.zzn == ((long) this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzB() throws IOException {
        return zzr() != 0;
    }

    final long zzC() throws IOException {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            byte bZzh = zzh();
            j10 |= ((long) (bZzh & 127)) << i10;
            if ((bZzh & 128) == 0) {
                return j10;
            }
        }
        throw zzgyn.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final double zza() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final float zzb() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzc() {
        return (int) ((((long) this.zzl) + this.zzm) - this.zzn);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzd(int i10) throws zzgyn {
        if (i10 < 0) {
            throw zzgyn.zzf();
        }
        int iZzc = i10 + zzc();
        int i11 = this.zzj;
        if (iZzc > i11) {
            throw zzgyn.zzi();
        }
        this.zzj = iZzc;
        zzL();
        return i11;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zze() throws IOException {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzf() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzg() throws IOException {
        return zzp();
    }

    public final byte zzh() throws IOException {
        if (this.zzo - this.zzm == 0) {
            zzJ();
        }
        long j10 = this.zzm;
        this.zzm = 1 + j10;
        return zzhaz.zza(j10);
    }

    public final int zzi() throws IOException {
        long j10 = this.zzo;
        long j11 = this.zzm;
        if (j10 - j11 < 4) {
            int iZzh = zzh() & 255;
            int iZzh2 = (zzh() & 255) << 8;
            return iZzh | iZzh2 | ((zzh() & 255) << 16) | ((zzh() & 255) << 24);
        }
        this.zzm = 4 + j11;
        int iZza = zzhaz.zza(j11) & 255;
        int iZza2 = (zzhaz.zza(1 + j11) & 255) << 8;
        return iZza | iZza2 | ((zzhaz.zza(2 + j11) & 255) << 16) | ((zzhaz.zza(j11 + 3) & 255) << 24);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzj() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzk() throws IOException {
        return zzgww.zzD(zzp());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzl() throws IOException {
        if (zzA()) {
            this.zzk = 0;
            return 0;
        }
        int iZzp = zzp();
        this.zzk = iZzp;
        if ((iZzp >>> 3) != 0) {
            return iZzp;
        }
        throw zzgyn.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzm() throws IOException {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzn() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzo() throws IOException {
        return zzr();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        if (com.google.android.gms.internal.ads.zzhaz.zza(r4) >= 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzp() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.zzm
            long r2 = r10.zzo
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto La
            goto L8c
        La:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.android.gms.internal.ads.zzhaz.zza(r0)
            if (r0 < 0) goto L1a
            long r4 = r10.zzm
            long r4 = r4 + r2
            r10.zzm = r4
            return r0
        L1a:
            long r6 = r10.zzo
            long r8 = r10.zzm
            long r6 = r6 - r8
            r8 = 10
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L8c
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L33
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L89
        L33:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L42
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L40:
            r6 = r4
            goto L89
        L42:
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L52
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L89
        L52:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 >= 0) goto L89
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 >= 0) goto L89
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 < 0) goto L8c
        L89:
            r10.zzm = r6
            return r0
        L8c:
            long r0 = r10.zzC()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgwq.zzp():int");
    }

    public final long zzq() throws IOException {
        long j10 = this.zzo;
        long j11 = this.zzm;
        if (j10 - j11 < 8) {
            long jZzh = ((long) zzh()) & 255;
            long jZzh2 = (((long) zzh()) & 255) << 8;
            long jZzh3 = (((long) zzh()) & 255) << 16;
            long jZzh4 = (((long) zzh()) & 255) << 24;
            long jZzh5 = (((long) zzh()) & 255) << 32;
            long jZzh6 = (((long) zzh()) & 255) << 40;
            return jZzh | jZzh2 | jZzh3 | jZzh4 | jZzh5 | jZzh6 | ((((long) zzh()) & 255) << 48) | ((((long) zzh()) & 255) << 56);
        }
        this.zzm = 8 + j11;
        long jZza = ((long) zzhaz.zza(j11)) & 255;
        long jZza2 = (((long) zzhaz.zza(1 + j11)) & 255) << 8;
        long jZza3 = (((long) zzhaz.zza(j11 + 2)) & 255) << 16;
        long jZza4 = (((long) zzhaz.zza(3 + j11)) & 255) << 24;
        long jZza5 = (((long) zzhaz.zza(j11 + 4)) & 255) << 32;
        long jZza6 = (((long) zzhaz.zza(j11 + 5)) & 255) << 40;
        return jZza5 | jZza | jZza2 | jZza3 | jZza4 | jZza6 | ((((long) zzhaz.zza(j11 + 6)) & 255) << 48) | ((((long) zzhaz.zza(j11 + 7)) & 255) << 56);
    }

    public final long zzr() throws IOException {
        long jZza;
        long j10;
        long j11;
        int i10;
        long j12 = this.zzm;
        if (this.zzo != j12) {
            long j13 = j12 + 1;
            byte bZza = zzhaz.zza(j12);
            if (bZza >= 0) {
                this.zzm++;
                return bZza;
            }
            if (this.zzo - this.zzm >= 10) {
                long j14 = j13 + 1;
                int iZza = bZza ^ (zzhaz.zza(j13) << 7);
                if (iZza >= 0) {
                    long j15 = j14 + 1;
                    int iZza2 = iZza ^ (zzhaz.zza(j14) << 14);
                    if (iZza2 >= 0) {
                        jZza = iZza2 ^ 16256;
                    } else {
                        j14 = j15 + 1;
                        int iZza3 = iZza2 ^ (zzhaz.zza(j15) << 21);
                        if (iZza3 < 0) {
                            i10 = iZza3 ^ (-2080896);
                        } else {
                            j15 = j14 + 1;
                            long jZza2 = ((long) iZza3) ^ (((long) zzhaz.zza(j14)) << 28);
                            if (jZza2 < 0) {
                                long j16 = j15 + 1;
                                long jZza3 = jZza2 ^ (((long) zzhaz.zza(j15)) << 35);
                                if (jZza3 < 0) {
                                    j10 = -34093383808L;
                                } else {
                                    j15 = j16 + 1;
                                    jZza2 = jZza3 ^ (((long) zzhaz.zza(j16)) << 42);
                                    if (jZza2 >= 0) {
                                        j11 = 4363953127296L;
                                    } else {
                                        j16 = j15 + 1;
                                        jZza3 = jZza2 ^ (((long) zzhaz.zza(j15)) << 49);
                                        if (jZza3 >= 0) {
                                            j15 = j16 + 1;
                                            jZza = (jZza3 ^ (((long) zzhaz.zza(j16)) << 56)) ^ 71499008037633920L;
                                            if (jZza < 0) {
                                                long j17 = 1 + j15;
                                                if (zzhaz.zza(j15) >= 0) {
                                                    j14 = j17;
                                                }
                                            }
                                            this.zzm = j14;
                                            return jZza;
                                        }
                                        j10 = -558586000294016L;
                                    }
                                }
                                jZza = jZza3 ^ j10;
                                j14 = j16;
                                this.zzm = j14;
                                return jZza;
                            }
                            j11 = 266354560;
                            jZza = jZza2 ^ j11;
                        }
                    }
                    j14 = j15;
                    this.zzm = j14;
                    return jZza;
                }
                i10 = iZza ^ (-128);
                jZza = i10;
                this.zzm = j14;
                return jZza;
            }
        }
        return zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzs() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzt() throws IOException {
        return zzgww.zzF(zzr());
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final long zzu() throws IOException {
        return zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final zzgwm zzv() throws IOException {
        int iZzp = zzp();
        if (iZzp > 0) {
            long j10 = this.zzo;
            long j11 = this.zzm;
            long j12 = iZzp;
            if (j12 <= j10 - j11) {
                byte[] bArr = new byte[iZzp];
                zzhaz.zzo(j11, bArr, 0L, j12);
                this.zzm += j12;
                return new zzgwk(bArr);
            }
        }
        if (iZzp > 0 && iZzp <= zzI()) {
            byte[] bArr2 = new byte[iZzp];
            zzK(bArr2, 0, iZzp);
            return new zzgwk(bArr2);
        }
        if (iZzp == 0) {
            return zzgwm.zzb;
        }
        if (iZzp < 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzw() throws IOException {
        int iZzp = zzp();
        if (iZzp > 0) {
            long j10 = this.zzo;
            long j11 = this.zzm;
            long j12 = iZzp;
            if (j12 <= j10 - j11) {
                byte[] bArr = new byte[iZzp];
                zzhaz.zzo(j11, bArr, 0L, j12);
                String str = new String(bArr, zzgyl.zza);
                this.zzm += j12;
                return str;
            }
        }
        if (iZzp > 0 && iZzp <= zzI()) {
            byte[] bArr2 = new byte[iZzp];
            zzK(bArr2, 0, iZzp);
            return new String(bArr2, zzgyl.zza);
        }
        if (iZzp == 0) {
            return "";
        }
        if (iZzp < 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzx() throws IOException {
        int iZzp = zzp();
        if (iZzp > 0) {
            long j10 = this.zzo;
            long j11 = this.zzm;
            long j12 = iZzp;
            if (j12 <= j10 - j11) {
                String strZzg = zzhbe.zzg(this.zzg, (int) (j11 - this.zzn), iZzp);
                this.zzm += j12;
                return strZzg;
            }
        }
        if (iZzp >= 0 && iZzp <= zzI()) {
            byte[] bArr = new byte[iZzp];
            zzK(bArr, 0, iZzp);
            return zzhbe.zzh(bArr, 0, iZzp);
        }
        if (iZzp == 0) {
            return "";
        }
        if (iZzp <= 0) {
            throw zzgyn.zzf();
        }
        throw zzgyn.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final void zzy(int i10) throws zzgyn {
        if (this.zzk != i10) {
            throw zzgyn.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final void zzz(int i10) {
        this.zzj = i10;
        zzL();
    }
}
