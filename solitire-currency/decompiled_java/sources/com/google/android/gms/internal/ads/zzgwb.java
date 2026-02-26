package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgwb {
    static int zza(byte[] bArr, int i10, zzgwa zzgwaVar) throws zzgyn {
        int iZzh = zzh(bArr, i10, zzgwaVar);
        int i11 = zzgwaVar.zza;
        if (i11 < 0) {
            throw zzgyn.zzf();
        }
        if (i11 > bArr.length - iZzh) {
            throw zzgyn.zzi();
        }
        if (i11 == 0) {
            zzgwaVar.zzc = zzgwm.zzb;
            return iZzh;
        }
        zzgwaVar.zzc = zzgwm.zzv(bArr, iZzh, i11);
        return iZzh + i11;
    }

    static int zzb(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = bArr[i10 + 1] & 255;
        int i13 = bArr[i10 + 2] & 255;
        return ((bArr[i10 + 3] & 255) << 24) | (i12 << 8) | i11 | (i13 << 16);
    }

    static int zzc(zzhae zzhaeVar, byte[] bArr, int i10, int i11, int i12, zzgwa zzgwaVar) throws IOException {
        Object objZze = zzhaeVar.zze();
        int iZzl = zzl(objZze, zzhaeVar, bArr, i10, i11, i12, zzgwaVar);
        zzhaeVar.zzf(objZze);
        zzgwaVar.zzc = objZze;
        return iZzl;
    }

    static int zzd(zzhae zzhaeVar, byte[] bArr, int i10, int i11, zzgwa zzgwaVar) throws IOException {
        Object objZze = zzhaeVar.zze();
        int iZzm = zzm(objZze, zzhaeVar, bArr, i10, i11, zzgwaVar);
        zzhaeVar.zzf(objZze);
        zzgwaVar.zzc = objZze;
        return iZzm;
    }

    static int zze(zzhae zzhaeVar, int i10, byte[] bArr, int i11, int i12, zzgyk zzgykVar, zzgwa zzgwaVar) throws IOException {
        int iZzd = zzd(zzhaeVar, bArr, i11, i12, zzgwaVar);
        zzgykVar.add(zzgwaVar.zzc);
        while (iZzd < i12) {
            int iZzh = zzh(bArr, iZzd, zzgwaVar);
            if (i10 != zzgwaVar.zza) {
                break;
            }
            iZzd = zzd(zzhaeVar, bArr, iZzh, i12, zzgwaVar);
            zzgykVar.add(zzgwaVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i10, zzgyk zzgykVar, zzgwa zzgwaVar) throws IOException {
        zzgxz zzgxzVar = (zzgxz) zzgykVar;
        int iZzh = zzh(bArr, i10, zzgwaVar);
        int i11 = zzgwaVar.zza + iZzh;
        while (iZzh < i11) {
            iZzh = zzh(bArr, iZzh, zzgwaVar);
            zzgxzVar.zzi(zzgwaVar.zza);
        }
        if (iZzh == i11) {
            return iZzh;
        }
        throw zzgyn.zzi();
    }

    static int zzg(int i10, byte[] bArr, int i11, int i12, zzhat zzhatVar, zzgwa zzgwaVar) throws zzgyn {
        if ((i10 >>> 3) == 0) {
            throw zzgyn.zzc();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int iZzk = zzk(bArr, i11, zzgwaVar);
            zzhatVar.zzj(i10, Long.valueOf(zzgwaVar.zzb));
            return iZzk;
        }
        if (i13 == 1) {
            zzhatVar.zzj(i10, Long.valueOf(zzn(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int iZzh = zzh(bArr, i11, zzgwaVar);
            int i14 = zzgwaVar.zza;
            if (i14 < 0) {
                throw zzgyn.zzf();
            }
            if (i14 > bArr.length - iZzh) {
                throw zzgyn.zzi();
            }
            if (i14 == 0) {
                zzhatVar.zzj(i10, zzgwm.zzb);
            } else {
                zzhatVar.zzj(i10, zzgwm.zzv(bArr, iZzh, i14));
            }
            return iZzh + i14;
        }
        if (i13 != 3) {
            if (i13 != 5) {
                throw zzgyn.zzc();
            }
            zzhatVar.zzj(i10, Integer.valueOf(zzb(bArr, i11)));
            return i11 + 4;
        }
        int i15 = (i10 & (-8)) | 4;
        zzhat zzhatVarZzf = zzhat.zzf();
        int i16 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int iZzh2 = zzh(bArr, i11, zzgwaVar);
            int i17 = zzgwaVar.zza;
            i16 = i17;
            if (i17 == i15) {
                i11 = iZzh2;
                break;
            }
            int iZzg = zzg(i16, bArr, iZzh2, i12, zzhatVarZzf, zzgwaVar);
            i16 = i17;
            i11 = iZzg;
        }
        if (i11 > i12 || i16 != i15) {
            throw zzgyn.zzg();
        }
        zzhatVar.zzj(i10, zzhatVarZzf);
        return i11;
    }

    static int zzh(byte[] bArr, int i10, zzgwa zzgwaVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return zzi(b10, bArr, i11, zzgwaVar);
        }
        zzgwaVar.zza = b10;
        return i11;
    }

    static int zzi(int i10, byte[] bArr, int i11, zzgwa zzgwaVar) {
        byte b10 = bArr[i11];
        int i12 = i11 + 1;
        int i13 = i10 & 127;
        if (b10 >= 0) {
            zzgwaVar.zza = i13 | (b10 << 7);
            return i12;
        }
        int i14 = i13 | ((b10 & 127) << 7);
        int i15 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzgwaVar.zza = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i15 + 1;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzgwaVar.zza = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i17 + 1;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzgwaVar.zza = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                zzgwaVar.zza = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    static int zzj(int i10, byte[] bArr, int i11, int i12, zzgyk zzgykVar, zzgwa zzgwaVar) {
        zzgxz zzgxzVar = (zzgxz) zzgykVar;
        int iZzh = zzh(bArr, i11, zzgwaVar);
        zzgxzVar.zzi(zzgwaVar.zza);
        while (iZzh < i12) {
            int iZzh2 = zzh(bArr, iZzh, zzgwaVar);
            if (i10 != zzgwaVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzgwaVar);
            zzgxzVar.zzi(zzgwaVar.zza);
        }
        return iZzh;
    }

    static int zzk(byte[] bArr, int i10, zzgwa zzgwaVar) {
        long j10 = bArr[i10];
        int i11 = i10 + 1;
        if (j10 >= 0) {
            zzgwaVar.zzb = j10;
            return i11;
        }
        int i12 = i11 + 1;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | (((long) (b10 & 127)) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            byte b11 = bArr[i12];
            i13 += 7;
            j11 |= ((long) (b11 & 127)) << i13;
            i12 = i14;
            b10 = b11;
        }
        zzgwaVar.zzb = j11;
        return i12;
    }

    static int zzl(Object obj, zzhae zzhaeVar, byte[] bArr, int i10, int i11, int i12, zzgwa zzgwaVar) throws IOException {
        int iZzc = ((zzgzm) zzhaeVar).zzc(obj, bArr, i10, i11, i12, zzgwaVar);
        zzgwaVar.zzc = obj;
        return iZzc;
    }

    static int zzm(Object obj, zzhae zzhaeVar, byte[] bArr, int i10, int i11, zzgwa zzgwaVar) throws IOException {
        int iZzi = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iZzi = zzi(i12, bArr, iZzi, zzgwaVar);
            i12 = zzgwaVar.zza;
        }
        int i13 = iZzi;
        if (i12 < 0 || i12 > i11 - i13) {
            throw zzgyn.zzi();
        }
        int i14 = i12 + i13;
        zzhaeVar.zzi(obj, bArr, i13, i14, zzgwaVar);
        zzgwaVar.zzc = obj;
        return i14;
    }

    static long zzn(byte[] bArr, int i10) {
        return (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48) | ((((long) bArr[i10 + 7]) & 255) << 56);
    }
}
