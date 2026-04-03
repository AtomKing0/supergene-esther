package com.google.android.gms.internal.location;

/* JADX INFO: compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzer {
    public static void zza(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z10, Object obj) {
        if (!z10) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static int zzc(int i10, int i11, String str) {
        String strZza;
        if (i10 >= 0 && i10 < i11) {
            return i10;
        }
        if (i10 < 0) {
            strZza = zzes.zza("%s (%s) must not be negative", "index", Integer.valueOf(i10));
        } else {
            if (i11 < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + 15);
                sb.append("negative size: ");
                sb.append(i11);
                throw new IllegalArgumentException(sb.toString());
            }
            strZza = zzes.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzd(int i10, int i11, String str) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(zzf(i10, i11, "index"));
        }
        return i10;
    }

    public static void zze(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException((i10 < 0 || i10 > i12) ? zzf(i10, i12, "start index") : (i11 < 0 || i11 > i12) ? zzf(i11, i12, "end index") : zzes.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    private static String zzf(int i10, int i11, String str) {
        if (i10 < 0) {
            return zzes.zza("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return zzes.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + 15);
        sb.append("negative size: ");
        sb.append(i11);
        throw new IllegalArgumentException(sb.toString());
    }
}
