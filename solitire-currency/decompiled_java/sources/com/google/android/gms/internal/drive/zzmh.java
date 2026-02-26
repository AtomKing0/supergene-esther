package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
final class zzmh {
    private static final Class<?> zzuz = zzep();
    private static final zzmx<?, ?> zzva = zzf(false);
    private static final zzmx<?, ?> zzvb = zzf(true);
    private static final zzmx<?, ?> zzvc = new zzmz();

    public static void zza(int i10, List<Double> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzg(i10, list, z10);
    }

    public static void zzb(int i10, List<Float> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzf(i10, list, z10);
    }

    public static void zzc(int i10, List<Long> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzc(i10, list, z10);
    }

    public static void zzd(int i10, List<Long> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzd(i10, list, z10);
    }

    public static void zze(int i10, List<Long> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzn(i10, list, z10);
    }

    public static zzmx<?, ?> zzem() {
        return zzva;
    }

    public static zzmx<?, ?> zzen() {
        return zzvb;
    }

    public static zzmx<?, ?> zzeo() {
        return zzvc;
    }

    private static Class<?> zzep() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzeq() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzf(int i10, List<Long> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zze(i10, list, z10);
    }

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzkk.class.isAssignableFrom(cls) && (cls2 = zzuz) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzh(int i10, List<Integer> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zza(i10, list, z10);
    }

    public static void zzi(int i10, List<Integer> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzj(i10, list, z10);
    }

    public static void zzj(int i10, List<Integer> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzm(i10, list, z10);
    }

    public static void zzk(int i10, List<Integer> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzb(i10, list, z10);
    }

    public static void zzl(int i10, List<Integer> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzk(i10, list, z10);
    }

    public static void zzm(int i10, List<Integer> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzh(i10, list, z10);
    }

    public static void zzn(int i10, List<Boolean> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzi(i10, list, z10);
    }

    static int zzo(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzjr.zzab(i10));
    }

    static int zzp(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzjr.zzab(i10));
    }

    static int zzq(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzjr.zzab(i10));
    }

    static int zzr(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzjr.zzab(i10));
    }

    static int zzs(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjr.zzab(i10));
    }

    static int zzt(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzjr.zzab(i10));
    }

    static int zzu(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzjr.zzab(i10));
    }

    static int zzv(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjr.zzj(i10, 0);
    }

    static int zzw(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjr.zzg(i10, 0L);
    }

    static int zzx(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzjr.zzc(i10, true);
    }

    public static void zza(int i10, List<String> list, zzns zznsVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zza(i10, list);
    }

    public static void zzb(int i10, List<zzjc> list, zzns zznsVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzb(i10, list);
    }

    static int zzc(List<Long> list) {
        int iZzq;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzle) {
            zzle zzleVar = (zzle) list;
            iZzq = 0;
            while (i10 < size) {
                iZzq += zzjr.zzq(zzleVar.getLong(i10));
                i10++;
            }
        } else {
            iZzq = 0;
            while (i10 < size) {
                iZzq += zzjr.zzq(list.get(i10).longValue());
                i10++;
            }
        }
        return iZzq;
    }

    static int zzd(List<Integer> list) {
        int iZzah;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkl) {
            zzkl zzklVar = (zzkl) list;
            iZzah = 0;
            while (i10 < size) {
                iZzah += zzjr.zzah(zzklVar.getInt(i10));
                i10++;
            }
        } else {
            iZzah = 0;
            while (i10 < size) {
                iZzah += zzjr.zzah(list.get(i10).intValue());
                i10++;
            }
        }
        return iZzah;
    }

    static int zze(List<Integer> list) {
        int iZzac;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkl) {
            zzkl zzklVar = (zzkl) list;
            iZzac = 0;
            while (i10 < size) {
                iZzac += zzjr.zzac(zzklVar.getInt(i10));
                i10++;
            }
        } else {
            iZzac = 0;
            while (i10 < size) {
                iZzac += zzjr.zzac(list.get(i10).intValue());
                i10++;
            }
        }
        return iZzac;
    }

    static int zzf(List<Integer> list) {
        int iZzad;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkl) {
            zzkl zzklVar = (zzkl) list;
            iZzad = 0;
            while (i10 < size) {
                iZzad += zzjr.zzad(zzklVar.getInt(i10));
                i10++;
            }
        } else {
            iZzad = 0;
            while (i10 < size) {
                iZzad += zzjr.zzad(list.get(i10).intValue());
                i10++;
            }
        }
        return iZzad;
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    public static void zzg(int i10, List<Long> list, zzns zznsVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzl(i10, list, z10);
    }

    public static void zza(int i10, List<?> list, zzns zznsVar, zzmf zzmfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zza(i10, list, zzmfVar);
    }

    public static void zzb(int i10, List<?> list, zzns zznsVar, zzmf zzmfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zznsVar.zzb(i10, list, zzmfVar);
    }

    static int zzg(List<Integer> list) {
        int iZzae;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkl) {
            zzkl zzklVar = (zzkl) list;
            iZzae = 0;
            while (i10 < size) {
                iZzae += zzjr.zzae(zzklVar.getInt(i10));
                i10++;
            }
        } else {
            iZzae = 0;
            while (i10 < size) {
                iZzae += zzjr.zzae(list.get(i10).intValue());
                i10++;
            }
        }
        return iZzae;
    }

    static int zza(List<Long> list) {
        int iZzo;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzle) {
            zzle zzleVar = (zzle) list;
            iZzo = 0;
            while (i10 < size) {
                iZzo += zzjr.zzo(zzleVar.getLong(i10));
                i10++;
            }
        } else {
            iZzo = 0;
            while (i10 < size) {
                iZzo += zzjr.zzo(list.get(i10).longValue());
                i10++;
            }
        }
        return iZzo;
    }

    static int zzb(List<Long> list) {
        int iZzp;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzle) {
            zzle zzleVar = (zzle) list;
            iZzp = 0;
            while (i10 < size) {
                iZzp += zzjr.zzp(zzleVar.getLong(i10));
                i10++;
            }
        } else {
            iZzp = 0;
            while (i10 < size) {
                iZzp += zzjr.zzp(list.get(i10).longValue());
                i10++;
            }
        }
        return iZzp;
    }

    static int zzc(int i10, List<?> list) {
        int iZzm;
        int iZzm2;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzab = zzjr.zzab(i10) * size;
        if (list instanceof zzkz) {
            zzkz zzkzVar = (zzkz) list;
            while (i11 < size) {
                Object objZzao = zzkzVar.zzao(i11);
                if (objZzao instanceof zzjc) {
                    iZzm2 = zzjr.zzb((zzjc) objZzao);
                } else {
                    iZzm2 = zzjr.zzm((String) objZzao);
                }
                iZzab += iZzm2;
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof zzjc) {
                    iZzm = zzjr.zzb((zzjc) obj);
                } else {
                    iZzm = zzjr.zzm((String) obj);
                }
                iZzab += iZzm;
                i11++;
            }
        }
        return iZzab;
    }

    static int zzd(int i10, List<zzjc> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzab = size * zzjr.zzab(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            iZzab += zzjr.zzb(list.get(i11));
        }
        return iZzab;
    }

    private static zzmx<?, ?> zzf(boolean z10) {
        try {
            Class<?> clsZzeq = zzeq();
            if (clsZzeq == null) {
                return null;
            }
            return (zzmx) clsZzeq.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z10));
        } catch (Throwable unused) {
            return null;
        }
    }

    static <T> void zza(zzll zzllVar, T t10, T t11, long j10) {
        zznd.zza(t10, j10, zzllVar.zzb(zznd.zzo(t10, j10), zznd.zzo(t11, j10)));
    }

    static int zzd(int i10, List<zzlq> list, zzmf zzmfVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i11 = 0; i11 < size; i11++) {
            iZzc += zzjr.zzc(i10, list.get(i11), zzmfVar);
        }
        return iZzc;
    }

    static boolean zzd(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T, FT extends zzkd<FT>> void zza(zzjy<FT> zzjyVar, T t10, T t11) {
        zzkb<T> zzkbVarZzb = zzjyVar.zzb(t11);
        if (zzkbVarZzb.zzos.isEmpty()) {
            return;
        }
        zzjyVar.zzc(t10).zza(zzkbVarZzb);
    }

    static <T, UT, UB> void zza(zzmx<UT, UB> zzmxVar, T t10, T t11) {
        zzmxVar.zze(t10, zzmxVar.zzg(zzmxVar.zzr(t10), zzmxVar.zzr(t11)));
    }

    static int zzc(int i10, Object obj, zzmf zzmfVar) {
        if (obj instanceof zzkx) {
            return zzjr.zza(i10, (zzkx) obj);
        }
        return zzjr.zzb(i10, (zzlq) obj, zzmfVar);
    }

    static <UT, UB> UB zza(int i10, List<Integer> list, zzko zzkoVar, UB ub, zzmx<UT, UB> zzmxVar) {
        if (zzkoVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int iIntValue = list.get(i12).intValue();
                if (zzkoVar.zzan(iIntValue)) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(iIntValue));
                    }
                    i11++;
                } else {
                    ub = (UB) zza(i10, iIntValue, ub, zzmxVar);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!zzkoVar.zzan(iIntValue2)) {
                    ub = (UB) zza(i10, iIntValue2, ub, zzmxVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static int zzc(int i10, List<?> list, zzmf zzmfVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzab = zzjr.zzab(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof zzkx) {
                iZza = zzjr.zza((zzkx) obj);
            } else {
                iZza = zzjr.zza((zzlq) obj, zzmfVar);
            }
            iZzab += iZza;
        }
        return iZzab;
    }

    private static <UT, UB> UB zza(int i10, int i11, UB ub, zzmx<UT, UB> zzmxVar) {
        if (ub == null) {
            ub = zzmxVar.zzez();
        }
        zzmxVar.zza(ub, i10, i11);
        return ub;
    }
}
