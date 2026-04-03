package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgwu extends zzgww {
    private final ByteBuffer zze;
    private final long zzf;
    private long zzg;
    private long zzh;
    private final long zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    /* synthetic */ zzgwu(ByteBuffer byteBuffer, boolean z10, zzgwt zzgwtVar) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        this.zze = byteBuffer;
        long jZze = zzhaz.zze(byteBuffer);
        this.zzf = jZze;
        this.zzg = ((long) byteBuffer.limit()) + jZze;
        long jPosition = jZze + ((long) byteBuffer.position());
        this.zzh = jPosition;
        this.zzi = jPosition;
    }

    private final int zzC() {
        return (int) (this.zzg - this.zzh);
    }

    private final void zzI() {
        long j10 = this.zzg + ((long) this.zzj);
        this.zzg = j10;
        int i10 = (int) (j10 - this.zzi);
        int i11 = this.zzl;
        if (i10 <= i11) {
            this.zzj = 0;
            return;
        }
        int i12 = i10 - i11;
        this.zzj = i12;
        this.zzg = j10 - ((long) i12);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzA() throws IOException {
        return this.zzh == this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final boolean zzB() throws IOException {
        return zzq() != 0;
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
        return (int) (this.zzh - this.zzi);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final int zzd(int i10) throws zzgyn {
        if (i10 < 0) {
            throw zzgyn.zzf();
        }
        int iZzc = i10 + zzc();
        int i11 = this.zzl;
        if (iZzc > i11) {
            throw zzgyn.zzi();
        }
        this.zzl = iZzc;
        zzI();
        return i11;
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
        long j10 = this.zzh;
        if (this.zzg - j10 < 4) {
            throw zzgyn.zzi();
        }
        this.zzh = 4 + j10;
        int iZza = zzhaz.zza(j10) & 255;
        int iZza2 = zzhaz.zza(1 + j10) & 255;
        int iZza3 = zzhaz.zza(2 + j10) & 255;
        return ((zzhaz.zza(j10 + 3) & 255) << 24) | (iZza2 << 8) | iZza | (iZza3 << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        if (com.google.android.gms.internal.ads.zzhaz.zza(r4) >= 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzi() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.zzh
            long r2 = r10.zzg
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto La
            goto L87
        La:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.android.gms.internal.ads.zzhaz.zza(r0)
            if (r0 < 0) goto L17
            r10.zzh = r4
            return r0
        L17:
            long r6 = r10.zzg
            long r6 = r6 - r4
            r8 = 9
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L87
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L2e
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L84
        L2e:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L3d
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L3b:
            r6 = r4
            goto L84
        L3d:
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L4d
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L84
        L4d:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L3b
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 >= 0) goto L84
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            if (r1 >= 0) goto L3b
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 >= 0) goto L84
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r6)
            if (r1 >= 0) goto L3b
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzhaz.zza(r4)
            if (r1 < 0) goto L87
        L84:
            r10.zzh = r6
            return r0
        L87:
            long r0 = r10.zzr()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgwu.zzi():int");
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
            this.zzk = 0;
            return 0;
        }
        int iZzi = zzi();
        this.zzk = iZzi;
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
        long j10 = this.zzh;
        if (this.zzg - j10 < 8) {
            throw zzgyn.zzi();
        }
        this.zzh = 8 + j10;
        long jZza = zzhaz.zza(j10);
        long jZza2 = zzhaz.zza(1 + j10);
        long jZza3 = zzhaz.zza(2 + j10);
        long jZza4 = zzhaz.zza(3 + j10);
        long jZza5 = zzhaz.zza(4 + j10);
        return ((((long) zzhaz.zza(j10 + 7)) & 255) << 56) | (jZza & 255) | ((jZza2 & 255) << 8) | ((jZza3 & 255) << 16) | ((jZza4 & 255) << 24) | ((jZza5 & 255) << 32) | ((zzhaz.zza(5 + j10) & 255) << 40) | ((zzhaz.zza(6 + j10) & 255) << 48);
    }

    public final long zzq() throws IOException {
        long jZza;
        long j10;
        long j11;
        int i10;
        long j12 = this.zzh;
        if (this.zzg != j12) {
            long j13 = j12 + 1;
            byte bZza = zzhaz.zza(j12);
            if (bZza >= 0) {
                this.zzh = j13;
                return bZza;
            }
            if (this.zzg - j13 >= 9) {
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
                                            this.zzh = j14;
                                            return jZza;
                                        }
                                        j10 = -558586000294016L;
                                    }
                                }
                                jZza = jZza3 ^ j10;
                                j14 = j16;
                                this.zzh = j14;
                                return jZza;
                            }
                            j11 = 266354560;
                            jZza = jZza2 ^ j11;
                        }
                    }
                    j14 = j15;
                    this.zzh = j14;
                    return jZza;
                }
                i10 = iZza ^ (-128);
                jZza = i10;
                this.zzh = j14;
                return jZza;
            }
        }
        return zzr();
    }

    final long zzr() throws IOException {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            long j11 = this.zzh;
            if (j11 == this.zzg) {
                throw zzgyn.zzi();
            }
            this.zzh = 1 + j11;
            byte bZza = zzhaz.zza(j11);
            j10 |= ((long) (bZza & 127)) << i10;
            if ((bZza & 128) == 0) {
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
        if (iZzi <= 0 || iZzi > zzC()) {
            if (iZzi == 0) {
                return zzgwm.zzb;
            }
            if (iZzi < 0) {
                throw zzgyn.zzf();
            }
            throw zzgyn.zzi();
        }
        byte[] bArr = new byte[iZzi];
        long j10 = iZzi;
        zzhaz.zzo(this.zzh, bArr, 0L, j10);
        this.zzh += j10;
        return new zzgwk(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzw() throws IOException {
        int iZzi = zzi();
        if (iZzi <= 0 || iZzi > zzC()) {
            if (iZzi == 0) {
                return "";
            }
            if (iZzi < 0) {
                throw zzgyn.zzf();
            }
            throw zzgyn.zzi();
        }
        byte[] bArr = new byte[iZzi];
        long j10 = iZzi;
        zzhaz.zzo(this.zzh, bArr, 0L, j10);
        String str = new String(bArr, zzgyl.zza);
        this.zzh += j10;
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final String zzx() throws IOException {
        int iZzi = zzi();
        if (iZzi > 0 && iZzi <= zzC()) {
            String strZzg = zzhbe.zzg(this.zze, (int) (this.zzh - this.zzf), iZzi);
            this.zzh += (long) iZzi;
            return strZzg;
        }
        if (iZzi == 0) {
            return "";
        }
        if (iZzi <= 0) {
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
        this.zzl = i10;
        zzI();
    }
}
