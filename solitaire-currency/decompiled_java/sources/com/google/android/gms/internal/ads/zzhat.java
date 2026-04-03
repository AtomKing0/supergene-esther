package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhat {
    private static final zzhat zza = new zzhat(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhat(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.zze = -1;
        this.zzb = i10;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z10;
    }

    public static zzhat zzc() {
        return zza;
    }

    static zzhat zze(zzhat zzhatVar, zzhat zzhatVar2) {
        int i10 = zzhatVar.zzb + zzhatVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzhatVar.zzc, i10);
        System.arraycopy(zzhatVar2.zzc, 0, iArrCopyOf, zzhatVar.zzb, zzhatVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzhatVar.zzd, i10);
        System.arraycopy(zzhatVar2.zzd, 0, objArrCopyOf, zzhatVar.zzb, zzhatVar2.zzb);
        return new zzhat(i10, iArrCopyOf, objArrCopyOf, true);
    }

    static zzhat zzf() {
        return new zzhat();
    }

    private final void zzn(int i10) {
        int[] iArr = this.zzc;
        if (i10 > iArr.length) {
            int i11 = this.zzb;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i10);
            this.zzd = Arrays.copyOf(this.zzd, i10);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhat)) {
            return false;
        }
        zzhat zzhatVar = (zzhat) obj;
        int i10 = this.zzb;
        if (i10 == zzhatVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhatVar.zzc;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhatVar.zzd;
                    int i12 = this.zzb;
                    for (int i13 = 0; i13 < i12; i13++) {
                        if (objArr[i13].equals(objArr2[i13])) {
                        }
                    }
                    return true;
                }
                if (iArr[i11] != iArr2[i11]) {
                    break;
                }
                i11++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zzb;
        int i11 = i10 + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = ((i11 * 31) + i12) * 31;
        Object[] objArr = this.zzd;
        int i15 = this.zzb;
        for (int i16 = 0; i16 < i15; i16++) {
            iHashCode = (iHashCode * 31) + objArr[i16].hashCode();
        }
        return i14 + iHashCode;
    }

    public final int zza() {
        int iZzD;
        int iZzE;
        int iZzD2;
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzb; i12++) {
            int i13 = this.zzc[i12];
            int i14 = i13 >>> 3;
            int i15 = i13 & 7;
            if (i15 != 0) {
                if (i15 == 1) {
                    ((Long) this.zzd[i12]).longValue();
                    iZzD2 = zzgxd.zzD(i14 << 3) + 8;
                } else if (i15 == 2) {
                    int i16 = i14 << 3;
                    zzgwm zzgwmVar = (zzgwm) this.zzd[i12];
                    int iZzD3 = zzgxd.zzD(i16);
                    int iZzd = zzgwmVar.zzd();
                    iZzD2 = iZzD3 + zzgxd.zzD(iZzd) + iZzd;
                } else if (i15 == 3) {
                    int iZzD4 = zzgxd.zzD(i14 << 3);
                    iZzD = iZzD4 + iZzD4;
                    iZzE = ((zzhat) this.zzd[i12]).zza();
                } else {
                    if (i15 != 5) {
                        throw new IllegalStateException(zzgyn.zza());
                    }
                    ((Integer) this.zzd[i12]).intValue();
                    iZzD2 = zzgxd.zzD(i14 << 3) + 4;
                }
                i11 += iZzD2;
            } else {
                int i17 = i14 << 3;
                long jLongValue = ((Long) this.zzd[i12]).longValue();
                iZzD = zzgxd.zzD(i17);
                iZzE = zzgxd.zzE(jLongValue);
            }
            iZzD2 = iZzD + iZzE;
            i11 += iZzD2;
        }
        this.zze = i11;
        return i11;
    }

    public final int zzb() {
        int i10 = this.zze;
        if (i10 != -1) {
            return i10;
        }
        int iZzD = 0;
        for (int i11 = 0; i11 < this.zzb; i11++) {
            int i12 = this.zzc[i11] >>> 3;
            zzgwm zzgwmVar = (zzgwm) this.zzd[i11];
            int iZzD2 = zzgxd.zzD(8);
            int iZzD3 = zzgxd.zzD(16) + zzgxd.zzD(i12);
            int iZzD4 = zzgxd.zzD(24);
            int iZzd = zzgwmVar.zzd();
            iZzD += iZzD2 + iZzD2 + iZzD3 + iZzD4 + zzgxd.zzD(iZzd) + iZzd;
        }
        this.zze = iZzD;
        return iZzD;
    }

    final zzhat zzd(zzhat zzhatVar) {
        if (zzhatVar.equals(zza)) {
            return this;
        }
        zzg();
        int i10 = this.zzb + zzhatVar.zzb;
        zzn(i10);
        System.arraycopy(zzhatVar.zzc, 0, this.zzc, this.zzb, zzhatVar.zzb);
        System.arraycopy(zzhatVar.zzd, 0, this.zzd, this.zzb, zzhatVar.zzb);
        this.zzb = i10;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            zzgzl.zzb(sb, i10, String.valueOf(this.zzc[i11] >>> 3), this.zzd[i11]);
        }
    }

    final void zzj(int i10, Object obj) {
        zzg();
        zzn(this.zzb + 1);
        int[] iArr = this.zzc;
        int i11 = this.zzb;
        iArr[i11] = i10;
        this.zzd[i11] = obj;
        this.zzb = i11 + 1;
    }

    final void zzk(zzhbh zzhbhVar) throws IOException {
        for (int i10 = 0; i10 < this.zzb; i10++) {
            zzhbhVar.zzw(this.zzc[i10] >>> 3, this.zzd[i10]);
        }
    }

    public final void zzl(zzhbh zzhbhVar) throws IOException {
        if (this.zzb != 0) {
            for (int i10 = 0; i10 < this.zzb; i10++) {
                int i11 = this.zzc[i10];
                Object obj = this.zzd[i10];
                int i12 = i11 & 7;
                int i13 = i11 >>> 3;
                if (i12 == 0) {
                    zzhbhVar.zzt(i13, ((Long) obj).longValue());
                } else if (i12 == 1) {
                    zzhbhVar.zzm(i13, ((Long) obj).longValue());
                } else if (i12 == 2) {
                    zzhbhVar.zzd(i13, (zzgwm) obj);
                } else if (i12 == 3) {
                    zzhbhVar.zzF(i13);
                    ((zzhat) obj).zzl(zzhbhVar);
                    zzhbhVar.zzh(i13);
                } else {
                    if (i12 != 5) {
                        throw new RuntimeException(zzgyn.zza());
                    }
                    zzhbhVar.zzk(i13, ((Integer) obj).intValue());
                }
            }
        }
    }

    final boolean zzm(int i10, zzgww zzgwwVar) throws IOException {
        int iZzl;
        zzg();
        int i11 = i10 & 7;
        if (i11 == 0) {
            zzj(i10, Long.valueOf(zzgwwVar.zzo()));
            return true;
        }
        if (i11 == 1) {
            zzj(i10, Long.valueOf(zzgwwVar.zzn()));
            return true;
        }
        if (i11 == 2) {
            zzj(i10, zzgwwVar.zzv());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw zzgyn.zza();
            }
            zzj(i10, Integer.valueOf(zzgwwVar.zzf()));
            return true;
        }
        zzhat zzhatVar = new zzhat();
        do {
            iZzl = zzgwwVar.zzl();
            if (iZzl == 0) {
                break;
            }
        } while (zzhatVar.zzm(iZzl, zzgwwVar));
        zzgwwVar.zzy(4 | ((i10 >>> 3) << 3));
        zzj(i10, zzhatVar);
        return true;
    }

    private zzhat() {
        this(0, new int[8], new Object[8], true);
    }
}
