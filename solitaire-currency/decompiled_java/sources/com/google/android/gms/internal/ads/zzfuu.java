package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfuu {
    public static int zza(int i10, int i11, String str) {
        String strZzb;
        if (i10 >= 0 && i10 < i11) {
            return i10;
        }
        if (i10 < 0) {
            strZzb = zzfvj.zzb("%s (%s) must not be negative", "index", Integer.valueOf(i10));
        } else {
            if (i11 < 0) {
                throw new IllegalArgumentException("negative size: " + i11);
            }
            strZzb = zzfvj.zzb("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IndexOutOfBoundsException(strZzb);
    }

    public static int zzb(int i10, int i11, String str) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(zzl(i10, i11, "index"));
        }
        return i10;
    }

    public static Object zzc(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static Object zzd(Object obj, String str, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(zzfvj.zzb(str, obj2));
    }

    public static void zze(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzf(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzg(boolean z10, String str, long j10) {
        if (!z10) {
            throw new IllegalArgumentException(zzfvj.zzb(str, Long.valueOf(j10)));
        }
    }

    public static void zzh(boolean z10, String str, int i10, int i11) {
        if (!z10) {
            throw new IllegalArgumentException(zzfvj.zzb(str, Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    public static void zzi(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException((i10 < 0 || i10 > i12) ? zzl(i10, i12, "start index") : (i11 < 0 || i11 > i12) ? zzl(i11, i12, "end index") : zzfvj.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    public static void zzj(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    public static void zzk(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzl(int i10, int i11, String str) {
        if (i10 < 0) {
            return zzfvj.zzb("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return zzfvj.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IllegalArgumentException("negative size: " + i11);
    }
}
