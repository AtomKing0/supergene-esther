package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzand {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzer zza = new zzer(0);
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private final zzek zzb = new zzek();

    zzand() {
    }

    public static long zzc(zzek zzekVar) {
        int iZzd = zzekVar.zzd();
        if (zzekVar.zzb() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        zzekVar.zzG(bArr, 0, 9);
        zzekVar.zzK(iZzd);
        byte b10 = bArr[0];
        if ((b10 & 196) != 68) {
            return C.TIME_UNSET;
        }
        byte b11 = bArr[2];
        if ((b11 & 4) != 4) {
            return C.TIME_UNSET;
        }
        byte b12 = bArr[4];
        if ((b12 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return C.TIME_UNSET;
        }
        long j10 = b10;
        long j11 = b11;
        long j12 = (248 & j11) >> 3;
        long j13 = (j11 & 3) << 13;
        return j13 | ((bArr[1] & 255) << 20) | ((j10 & 3) << 28) | (((j10 & 56) >> 3) << 30) | (j12 << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b12) & 248) >> 3);
    }

    private final int zzf(zzacl zzaclVar) {
        byte[] bArr = zzet.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzaclVar.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    public final int zza(zzacl zzaclVar, zzadf zzadfVar) throws IOException {
        boolean z10 = this.zze;
        long j10 = C.TIME_UNSET;
        if (!z10) {
            long jZzd = zzaclVar.zzd();
            int iMin = (int) Math.min(20000L, jZzd);
            long j11 = jZzd - ((long) iMin);
            if (zzaclVar.zzf() != j11) {
                zzadfVar.zza = j11;
                return 1;
            }
            this.zzb.zzH(iMin);
            zzaclVar.zzj();
            ((zzaby) zzaclVar).zzm(this.zzb.zzM(), 0, iMin, false);
            zzek zzekVar = this.zzb;
            int iZzd = zzekVar.zzd();
            int iZze = zzekVar.zze() - 4;
            while (true) {
                if (iZze < iZzd) {
                    break;
                }
                if (zzg(zzekVar.zzM(), iZze) == 442) {
                    zzekVar.zzK(iZze + 4);
                    long jZzc = zzc(zzekVar);
                    if (jZzc != C.TIME_UNSET) {
                        j10 = jZzc;
                        break;
                    }
                }
                iZze--;
            }
            this.zzg = j10;
            this.zze = true;
        } else {
            if (this.zzg == C.TIME_UNSET) {
                zzf(zzaclVar);
                return 0;
            }
            if (this.zzd) {
                long j12 = this.zzf;
                if (j12 == C.TIME_UNSET) {
                    zzf(zzaclVar);
                    return 0;
                }
                zzer zzerVar = this.zza;
                this.zzh = zzerVar.zzc(this.zzg) - zzerVar.zzb(j12);
                zzf(zzaclVar);
                return 0;
            }
            int iMin2 = (int) Math.min(20000L, zzaclVar.zzd());
            if (zzaclVar.zzf() != 0) {
                zzadfVar.zza = 0L;
                return 1;
            }
            this.zzb.zzH(iMin2);
            zzaclVar.zzj();
            ((zzaby) zzaclVar).zzm(this.zzb.zzM(), 0, iMin2, false);
            zzek zzekVar2 = this.zzb;
            int iZzd2 = zzekVar2.zzd();
            int iZze2 = zzekVar2.zze();
            while (true) {
                if (iZzd2 >= iZze2 - 3) {
                    break;
                }
                if (zzg(zzekVar2.zzM(), iZzd2) == 442) {
                    zzekVar2.zzK(iZzd2 + 4);
                    long jZzc2 = zzc(zzekVar2);
                    if (jZzc2 != C.TIME_UNSET) {
                        j10 = jZzc2;
                        break;
                    }
                }
                iZzd2++;
            }
            this.zzf = j10;
            this.zzd = true;
        }
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzer zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
