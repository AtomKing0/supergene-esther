package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhag {
    public static final /* synthetic */ int zza = 0;
    private static final zzhas zzb;

    static {
        int i10 = zzgzt.zza;
        zzb = new zzhau();
    }

    public static void zzA(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzu(i10, list, z10);
    }

    public static void zzB(int i10, List list, zzhbh zzhbhVar, zzhae zzhaeVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((zzgxe) zzhbhVar).zzv(i10, list.get(i11), zzhaeVar);
        }
    }

    public static void zzC(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzy(i10, list, z10);
    }

    public static void zzD(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzA(i10, list, z10);
    }

    public static void zzE(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzC(i10, list, z10);
    }

    public static void zzF(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzE(i10, list, z10);
    }

    public static void zzG(int i10, List list, zzhbh zzhbhVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzH(i10, list);
    }

    public static void zzH(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzJ(i10, list, z10);
    }

    public static void zzI(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzL(i10, list, z10);
    }

    static boolean zzJ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int iZzE;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            iZzE = 0;
            while (i10 < size) {
                iZzE += zzgxd.zzE(zzgxzVar.zzd(i10));
                i10++;
            }
        } else {
            iZzE = 0;
            while (i10 < size) {
                iZzE += zzgxd.zzE(((Integer) list.get(i10)).intValue());
                i10++;
            }
        }
        return iZzE;
    }

    static int zzb(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgxd.zzD(i10 << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgxd.zzD(i10 << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int iZzE;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            iZzE = 0;
            while (i10 < size) {
                iZzE += zzgxd.zzE(zzgxzVar.zzd(i10));
                i10++;
            }
        } else {
            iZzE = 0;
            while (i10 < size) {
                iZzE += zzgxd.zzE(((Integer) list.get(i10)).intValue());
                i10++;
            }
        }
        return iZzE;
    }

    static int zzg(List list) {
        int iZzE;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyy) {
            zzgyy zzgyyVar = (zzgyy) list;
            iZzE = 0;
            while (i10 < size) {
                iZzE += zzgxd.zzE(zzgyyVar.zza(i10));
                i10++;
            }
        } else {
            iZzE = 0;
            while (i10 < size) {
                iZzE += zzgxd.zzE(((Long) list.get(i10)).longValue());
                i10++;
            }
        }
        return iZzE;
    }

    static int zzh(int i10, Object obj, zzhae zzhaeVar) {
        int i11 = i10 << 3;
        if (!(obj instanceof zzgyu)) {
            return zzgxd.zzD(i11) + zzgxd.zzA((zzgzj) obj, zzhaeVar);
        }
        int iZzD = zzgxd.zzD(i11);
        int iZza = ((zzgyu) obj).zza();
        return iZzD + zzgxd.zzD(iZza) + iZza;
    }

    static int zzi(List list) {
        int iZzD;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            iZzD = 0;
            while (i10 < size) {
                int iZzd = zzgxzVar.zzd(i10);
                iZzD += zzgxd.zzD((iZzd >> 31) ^ (iZzd + iZzd));
                i10++;
            }
        } else {
            iZzD = 0;
            while (i10 < size) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                iZzD += zzgxd.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i10++;
            }
        }
        return iZzD;
    }

    static int zzj(List list) {
        int iZzE;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyy) {
            zzgyy zzgyyVar = (zzgyy) list;
            iZzE = 0;
            while (i10 < size) {
                long jZza = zzgyyVar.zza(i10);
                iZzE += zzgxd.zzE((jZza >> 63) ^ (jZza + jZza));
                i10++;
            }
        } else {
            iZzE = 0;
            while (i10 < size) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                iZzE += zzgxd.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i10++;
            }
        }
        return iZzE;
    }

    static int zzk(List list) {
        int iZzD;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxz) {
            zzgxz zzgxzVar = (zzgxz) list;
            iZzD = 0;
            while (i10 < size) {
                iZzD += zzgxd.zzD(zzgxzVar.zzd(i10));
                i10++;
            }
        } else {
            iZzD = 0;
            while (i10 < size) {
                iZzD += zzgxd.zzD(((Integer) list.get(i10)).intValue());
                i10++;
            }
        }
        return iZzD;
    }

    static int zzl(List list) {
        int iZzE;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyy) {
            zzgyy zzgyyVar = (zzgyy) list;
            iZzE = 0;
            while (i10 < size) {
                iZzE += zzgxd.zzE(zzgyyVar.zza(i10));
                i10++;
            }
        } else {
            iZzE = 0;
            while (i10 < size) {
                iZzE += zzgxd.zzE(((Long) list.get(i10)).longValue());
                i10++;
            }
        }
        return iZzE;
    }

    public static zzhas zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i10, List list, zzgye zzgyeVar, Object obj2, zzhas zzhasVar) {
        if (zzgyeVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int iIntValue = ((Integer) list.get(i12)).intValue();
                if (zzgyeVar.zza(iIntValue)) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(iIntValue));
                    }
                    i11++;
                } else {
                    obj2 = zzo(obj, i10, iIntValue, obj2, zzhasVar);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzgyeVar.zza(iIntValue2)) {
                    obj2 = zzo(obj, i10, iIntValue2, obj2, zzhasVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzo(Object obj, int i10, int i11, Object obj2, zzhas zzhasVar) {
        if (obj2 == null) {
            obj2 = zzhasVar.zza(obj);
        }
        zzhasVar.zzh(obj2, i10, i11);
        return obj2;
    }

    static void zzp(zzgxj zzgxjVar, Object obj, Object obj2) {
        if (((zzgxu) obj2).zza.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzq(zzhas zzhasVar, Object obj, Object obj2) {
        zzgxy zzgxyVar = (zzgxy) obj;
        zzhat zzhatVarZze = zzgxyVar.zzt;
        zzhat zzhatVar = ((zzgxy) obj2).zzt;
        if (!zzhat.zzc().equals(zzhatVar)) {
            if (zzhat.zzc().equals(zzhatVarZze)) {
                zzhatVarZze = zzhat.zze(zzhatVarZze, zzhatVar);
            } else {
                zzhatVarZze.zzd(zzhatVar);
            }
        }
        zzgxyVar.zzt = zzhatVarZze;
    }

    public static void zzr(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzc(i10, list, z10);
    }

    public static void zzs(int i10, List list, zzhbh zzhbhVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zze(i10, list);
    }

    public static void zzt(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzg(i10, list, z10);
    }

    public static void zzu(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzj(i10, list, z10);
    }

    public static void zzv(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzl(i10, list, z10);
    }

    public static void zzw(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzn(i10, list, z10);
    }

    public static void zzx(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzp(i10, list, z10);
    }

    public static void zzy(int i10, List list, zzhbh zzhbhVar, zzhae zzhaeVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((zzgxe) zzhbhVar).zzq(i10, list.get(i11), zzhaeVar);
        }
    }

    public static void zzz(int i10, List list, zzhbh zzhbhVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbhVar.zzs(i10, list, z10);
    }
}
