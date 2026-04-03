package com.google.android.gms.internal.drive;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
final class zziy {
    static int zza(byte[] bArr, int i10, zziz zzizVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return zza(b10, bArr, i11, zzizVar);
        }
        zzizVar.zznk = b10;
        return i11;
    }

    static int zzb(byte[] bArr, int i10, zziz zzizVar) {
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        if (j10 >= 0) {
            zzizVar.zznl = j10;
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
            b10 = b11;
            i12 = i14;
        }
        zzizVar.zznl = j11;
        return i12;
    }

    static double zzc(byte[] bArr, int i10) {
        return Double.longBitsToDouble(zzb(bArr, i10));
    }

    static float zzd(byte[] bArr, int i10) {
        return Float.intBitsToFloat(zza(bArr, i10));
    }

    static int zze(byte[] bArr, int i10, zziz zzizVar) throws zzkq {
        int iZza = zza(bArr, i10, zzizVar);
        int i11 = zzizVar.zznk;
        if (i11 < 0) {
            throw zzkq.zzdj();
        }
        if (i11 > bArr.length - iZza) {
            throw zzkq.zzdi();
        }
        if (i11 == 0) {
            zzizVar.zznm = zzjc.zznq;
            return iZza;
        }
        zzizVar.zznm = zzjc.zzb(bArr, iZza, i11);
        return iZza + i11;
    }

    static int zzc(byte[] bArr, int i10, zziz zzizVar) throws zzkq {
        int iZza = zza(bArr, i10, zzizVar);
        int i11 = zzizVar.zznk;
        if (i11 < 0) {
            throw zzkq.zzdj();
        }
        if (i11 == 0) {
            zzizVar.zznm = "";
            return iZza;
        }
        zzizVar.zznm = new String(bArr, iZza, i11, zzkm.UTF_8);
        return iZza + i11;
    }

    static int zzd(byte[] bArr, int i10, zziz zzizVar) throws zzkq {
        int iZza = zza(bArr, i10, zzizVar);
        int i11 = zzizVar.zznk;
        if (i11 < 0) {
            throw zzkq.zzdj();
        }
        if (i11 == 0) {
            zzizVar.zznm = "";
            return iZza;
        }
        zzizVar.zznm = zznf.zzg(bArr, iZza, i11);
        return iZza + i11;
    }

    static int zza(int i10, byte[] bArr, int i11, zziz zzizVar) {
        int i12 = i10 & 127;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            zzizVar.zznk = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & 127) << 7);
        int i15 = i13 + 1;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            zzizVar.zznk = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i15 + 1;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzizVar.zznk = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i17 + 1;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzizVar.zznk = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                zzizVar.zznk = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    static long zzb(byte[] bArr, int i10) {
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }

    static int zza(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    static int zza(zzmf zzmfVar, byte[] bArr, int i10, int i11, zziz zzizVar) throws IOException {
        int iZza = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iZza = zza(i12, bArr, iZza, zzizVar);
            i12 = zzizVar.zznk;
        }
        int i13 = iZza;
        if (i12 >= 0 && i12 <= i11 - i13) {
            Object objNewInstance = zzmfVar.newInstance();
            int i14 = i12 + i13;
            zzmfVar.zza(objNewInstance, bArr, i13, i14, zzizVar);
            zzmfVar.zzd(objNewInstance);
            zzizVar.zznm = objNewInstance;
            return i14;
        }
        throw zzkq.zzdi();
    }

    static int zza(zzmf zzmfVar, byte[] bArr, int i10, int i11, int i12, zziz zzizVar) throws IOException {
        zzlu zzluVar = (zzlu) zzmfVar;
        Object objNewInstance = zzluVar.newInstance();
        int iZza = zzluVar.zza(objNewInstance, bArr, i10, i11, i12, zzizVar);
        zzluVar.zzd(objNewInstance);
        zzizVar.zznm = objNewInstance;
        return iZza;
    }

    static int zza(int i10, byte[] bArr, int i11, int i12, zzkp<?> zzkpVar, zziz zzizVar) {
        zzkl zzklVar = (zzkl) zzkpVar;
        int iZza = zza(bArr, i11, zzizVar);
        zzklVar.zzam(zzizVar.zznk);
        while (iZza < i12) {
            int iZza2 = zza(bArr, iZza, zzizVar);
            if (i10 != zzizVar.zznk) {
                break;
            }
            iZza = zza(bArr, iZza2, zzizVar);
            zzklVar.zzam(zzizVar.zznk);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i10, zzkp<?> zzkpVar, zziz zzizVar) throws IOException {
        zzkl zzklVar = (zzkl) zzkpVar;
        int iZza = zza(bArr, i10, zzizVar);
        int i11 = zzizVar.zznk + iZza;
        while (iZza < i11) {
            iZza = zza(bArr, iZza, zzizVar);
            zzklVar.zzam(zzizVar.zznk);
        }
        if (iZza == i11) {
            return iZza;
        }
        throw zzkq.zzdi();
    }

    static int zza(zzmf<?> zzmfVar, int i10, byte[] bArr, int i11, int i12, zzkp<?> zzkpVar, zziz zzizVar) throws IOException {
        int iZza = zza(zzmfVar, bArr, i11, i12, zzizVar);
        zzkpVar.add(zzizVar.zznm);
        while (iZza < i12) {
            int iZza2 = zza(bArr, iZza, zzizVar);
            if (i10 != zzizVar.zznk) {
                break;
            }
            iZza = zza(zzmfVar, bArr, iZza2, i12, zzizVar);
            zzkpVar.add(zzizVar.zznm);
        }
        return iZza;
    }

    static int zza(int i10, byte[] bArr, int i11, int i12, zzmy zzmyVar, zziz zzizVar) throws zzkq {
        if ((i10 >>> 3) == 0) {
            throw zzkq.zzdk();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            int iZzb = zzb(bArr, i11, zzizVar);
            zzmyVar.zzb(i10, Long.valueOf(zzizVar.zznl));
            return iZzb;
        }
        if (i13 == 1) {
            zzmyVar.zzb(i10, Long.valueOf(zzb(bArr, i11)));
            return i11 + 8;
        }
        if (i13 == 2) {
            int iZza = zza(bArr, i11, zzizVar);
            int i14 = zzizVar.zznk;
            if (i14 >= 0) {
                if (i14 > bArr.length - iZza) {
                    throw zzkq.zzdi();
                }
                if (i14 == 0) {
                    zzmyVar.zzb(i10, zzjc.zznq);
                } else {
                    zzmyVar.zzb(i10, zzjc.zzb(bArr, iZza, i14));
                }
                return iZza + i14;
            }
            throw zzkq.zzdj();
        }
        if (i13 != 3) {
            if (i13 == 5) {
                zzmyVar.zzb(i10, Integer.valueOf(zza(bArr, i11)));
                return i11 + 4;
            }
            throw zzkq.zzdk();
        }
        zzmy zzmyVarZzfb = zzmy.zzfb();
        int i15 = (i10 & (-8)) | 4;
        int i16 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int iZza2 = zza(bArr, i11, zzizVar);
            int i17 = zzizVar.zznk;
            i16 = i17;
            if (i17 == i15) {
                i11 = iZza2;
                break;
            }
            int iZza3 = zza(i16, bArr, iZza2, i12, zzmyVarZzfb, zzizVar);
            i16 = i17;
            i11 = iZza3;
        }
        if (i11 <= i12 && i16 == i15) {
            zzmyVar.zzb(i10, zzmyVarZzfb);
            return i11;
        }
        throw zzkq.zzdm();
    }

    static int zza(int i10, byte[] bArr, int i11, int i12, zziz zzizVar) throws zzkq {
        if ((i10 >>> 3) == 0) {
            throw zzkq.zzdk();
        }
        int i13 = i10 & 7;
        if (i13 == 0) {
            return zzb(bArr, i11, zzizVar);
        }
        if (i13 == 1) {
            return i11 + 8;
        }
        if (i13 == 2) {
            return zza(bArr, i11, zzizVar) + zzizVar.zznk;
        }
        if (i13 != 3) {
            if (i13 == 5) {
                return i11 + 4;
            }
            throw zzkq.zzdk();
        }
        int i14 = (i10 & (-8)) | 4;
        int i15 = 0;
        while (i11 < i12) {
            i11 = zza(bArr, i11, zzizVar);
            i15 = zzizVar.zznk;
            if (i15 == i14) {
                break;
            }
            i11 = zza(i15, bArr, i11, i12, zzizVar);
        }
        if (i11 > i12 || i15 != i14) {
            throw zzkq.zzdm();
        }
        return i11;
    }
}
