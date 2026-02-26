package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeq {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzff zzc;
    private static final zzff zzd;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzff zzffVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzffVar = (zzff) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzffVar;
        zzd = new zzfh();
    }

    public static void zzA(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzy(i10, list, z10);
    }

    public static void zzB(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzA(i10, list, z10);
    }

    public static void zzC(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzC(i10, list, z10);
    }

    public static void zzD(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzE(i10, list, z10);
    }

    public static void zzE(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzJ(i10, list, z10);
    }

    public static void zzF(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzL(i10, list, z10);
    }

    static boolean zzG(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int iZzx;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzct) {
            zzct zzctVar = (zzct) list;
            iZzx = 0;
            while (i10 < size) {
                iZzx += zzby.zzx(zzctVar.zze(i10));
                i10++;
            }
        } else {
            iZzx = 0;
            while (i10 < size) {
                iZzx += zzby.zzx(((Integer) list.get(i10)).intValue());
                i10++;
            }
        }
        return iZzx;
    }

    static int zzb(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzby.zzw(i10 << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzby.zzw(i10 << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int iZzx;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzct) {
            zzct zzctVar = (zzct) list;
            iZzx = 0;
            while (i10 < size) {
                iZzx += zzby.zzx(zzctVar.zze(i10));
                i10++;
            }
        } else {
            iZzx = 0;
            while (i10 < size) {
                iZzx += zzby.zzx(((Integer) list.get(i10)).intValue());
                i10++;
            }
        }
        return iZzx;
    }

    static int zzg(List list) {
        int iZzx;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdr) {
            zzdr zzdrVar = (zzdr) list;
            iZzx = 0;
            while (i10 < size) {
                iZzx += zzby.zzx(zzdrVar.zze(i10));
                i10++;
            }
        } else {
            iZzx = 0;
            while (i10 < size) {
                iZzx += zzby.zzx(((Long) list.get(i10)).longValue());
                i10++;
            }
        }
        return iZzx;
    }

    static int zzh(int i10, Object obj, zzeo zzeoVar) {
        int i11 = i10 << 3;
        if (!(obj instanceof zzdi)) {
            return zzby.zzw(i11) + zzby.zzu((zzec) obj, zzeoVar);
        }
        int iZzw = zzby.zzw(i11);
        int iZza = ((zzdi) obj).zza();
        return iZzw + zzby.zzw(iZza) + iZza;
    }

    static int zzi(List list) {
        int iZzw;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzct) {
            zzct zzctVar = (zzct) list;
            iZzw = 0;
            while (i10 < size) {
                int iZze = zzctVar.zze(i10);
                iZzw += zzby.zzw((iZze >> 31) ^ (iZze + iZze));
                i10++;
            }
        } else {
            iZzw = 0;
            while (i10 < size) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                iZzw += zzby.zzw((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i10++;
            }
        }
        return iZzw;
    }

    static int zzj(List list) {
        int iZzx;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdr) {
            zzdr zzdrVar = (zzdr) list;
            iZzx = 0;
            while (i10 < size) {
                long jZze = zzdrVar.zze(i10);
                iZzx += zzby.zzx((jZze >> 63) ^ (jZze + jZze));
                i10++;
            }
        } else {
            iZzx = 0;
            while (i10 < size) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                iZzx += zzby.zzx((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i10++;
            }
        }
        return iZzx;
    }

    static int zzk(List list) {
        int iZzw;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzct) {
            zzct zzctVar = (zzct) list;
            iZzw = 0;
            while (i10 < size) {
                iZzw += zzby.zzw(zzctVar.zze(i10));
                i10++;
            }
        } else {
            iZzw = 0;
            while (i10 < size) {
                iZzw += zzby.zzw(((Integer) list.get(i10)).intValue());
                i10++;
            }
        }
        return iZzw;
    }

    static int zzl(List list) {
        int iZzx;
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdr) {
            zzdr zzdrVar = (zzdr) list;
            iZzx = 0;
            while (i10 < size) {
                iZzx += zzby.zzx(zzdrVar.zze(i10));
                i10++;
            }
        } else {
            iZzx = 0;
            while (i10 < size) {
                iZzx += zzby.zzx(((Long) list.get(i10)).longValue());
                i10++;
            }
        }
        return iZzx;
    }

    public static zzff zzm() {
        return zzc;
    }

    public static zzff zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i10, int i11, Object obj2, zzff zzffVar) {
        if (obj2 == null) {
            obj2 = zzffVar.zzc(obj);
        }
        zzffVar.zzf(obj2, i10, i11);
        return obj2;
    }

    static void zzp(zzce zzceVar, Object obj, Object obj2) {
        zzci zzciVarZzb = zzceVar.zzb(obj2);
        if (zzciVarZzb.zza.isEmpty()) {
            return;
        }
        zzceVar.zzc(obj).zzh(zzciVarZzb);
    }

    static void zzq(zzff zzffVar, Object obj, Object obj2) {
        zzffVar.zzh(obj, zzffVar.zze(zzffVar.zzd(obj), zzffVar.zzd(obj2)));
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzcs.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzs(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzc(i10, list, z10);
    }

    public static void zzt(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzg(i10, list, z10);
    }

    public static void zzu(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzj(i10, list, z10);
    }

    public static void zzv(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzl(i10, list, z10);
    }

    public static void zzw(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzn(i10, list, z10);
    }

    public static void zzx(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzp(i10, list, z10);
    }

    public static void zzy(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzs(i10, list, z10);
    }

    public static void zzz(int i10, List list, zzfx zzfxVar, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzfxVar.zzu(i10, list, z10);
    }
}
