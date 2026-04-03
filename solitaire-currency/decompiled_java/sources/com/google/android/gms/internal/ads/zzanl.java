package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.media3.extractor.ts.TsExtractor;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzanl {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzer zza = new zzer(0);
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private final zzek zzb = new zzek();

    zzanl(int i10) {
    }

    private final int zze(zzacl zzaclVar) {
        byte[] bArr = zzet.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzaclVar.zzj();
        return 0;
    }

    public final int zza(zzacl zzaclVar, zzadf zzadfVar, int i10) throws IOException {
        if (i10 <= 0) {
            zze(zzaclVar);
            return 0;
        }
        boolean z10 = this.zze;
        long j10 = C.TIME_UNSET;
        if (!z10) {
            long jZzd = zzaclVar.zzd();
            int iMin = (int) Math.min(112800L, jZzd);
            long j11 = jZzd - ((long) iMin);
            if (zzaclVar.zzf() == j11) {
                this.zzb.zzH(iMin);
                zzaclVar.zzj();
                ((zzaby) zzaclVar).zzm(this.zzb.zzM(), 0, iMin, false);
                zzek zzekVar = this.zzb;
                int iZzd = zzekVar.zzd();
                int iZze = zzekVar.zze();
                int i11 = iZze - 188;
                while (true) {
                    if (i11 < iZzd) {
                        break;
                    }
                    byte[] bArrZzM = zzekVar.zzM();
                    int i12 = -4;
                    int i13 = 0;
                    while (true) {
                        if (i12 > 4) {
                            break;
                        }
                        int i14 = (i12 * TsExtractor.TS_PACKET_SIZE) + i11;
                        if (i14 < iZzd || i14 >= iZze || bArrZzM[i14] != 71) {
                            i13 = 0;
                        } else {
                            i13++;
                            if (i13 == 5) {
                                long jZzb = zzanu.zzb(zzekVar, i11, i10);
                                if (jZzb != C.TIME_UNSET) {
                                    j10 = jZzb;
                                    break;
                                }
                            }
                        }
                        i12++;
                    }
                    i11--;
                }
                this.zzg = j10;
                this.zze = true;
                return 0;
            }
            zzadfVar.zza = j11;
        } else {
            if (this.zzg == C.TIME_UNSET) {
                zze(zzaclVar);
                return 0;
            }
            if (this.zzd) {
                long j12 = this.zzf;
                if (j12 == C.TIME_UNSET) {
                    zze(zzaclVar);
                    return 0;
                }
                zzer zzerVar = this.zza;
                this.zzh = zzerVar.zzc(this.zzg) - zzerVar.zzb(j12);
                zze(zzaclVar);
                return 0;
            }
            int iMin2 = (int) Math.min(112800L, zzaclVar.zzd());
            if (zzaclVar.zzf() == 0) {
                this.zzb.zzH(iMin2);
                zzaclVar.zzj();
                ((zzaby) zzaclVar).zzm(this.zzb.zzM(), 0, iMin2, false);
                zzek zzekVar2 = this.zzb;
                int iZzd2 = zzekVar2.zzd();
                int iZze2 = zzekVar2.zze();
                while (true) {
                    if (iZzd2 >= iZze2) {
                        break;
                    }
                    if (zzekVar2.zzM()[iZzd2] == 71) {
                        long jZzb2 = zzanu.zzb(zzekVar2, iZzd2, i10);
                        if (jZzb2 != C.TIME_UNSET) {
                            j10 = jZzb2;
                            break;
                        }
                    }
                    iZzd2++;
                }
                this.zzf = j10;
                this.zzd = true;
                return 0;
            }
            zzadfVar.zza = 0L;
        }
        return 1;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzer zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
