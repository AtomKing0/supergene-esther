package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhw extends zzbp {
    public final int zzc;

    @Nullable
    public final String zzd;
    public final int zze;

    @Nullable
    public final zzaf zzf;
    public final int zzg;

    @Nullable
    public final zzui zzh;
    final boolean zzi;

    static {
        Integer.toString(1001, 36);
        Integer.toString(1002, 36);
        Integer.toString(1003, 36);
        Integer.toString(1004, 36);
        Integer.toString(1005, 36);
        Integer.toString(1006, 36);
    }

    private zzhw(int i10, Throwable th, int i11) {
        this(i10, th, null, i11, null, -1, null, 4, false);
    }

    public static zzhw zzb(Throwable th, String str, int i10, @Nullable zzaf zzafVar, int i11, boolean z10, int i12) {
        return new zzhw(1, th, null, i12, str, i10, zzafVar, zzafVar == null ? 4 : i11, z10);
    }

    public static zzhw zzc(IOException iOException, int i10) {
        return new zzhw(0, iOException, i10);
    }

    public static zzhw zzd(RuntimeException runtimeException, int i10) {
        return new zzhw(2, runtimeException, i10);
    }

    @CheckResult
    final zzhw zza(@Nullable zzui zzuiVar) {
        String message = getMessage();
        int i10 = zzet.zza;
        return new zzhw(message, getCause(), this.zza, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, zzuiVar, this.zzb, this.zzi);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private zzhw(int i10, @Nullable Throwable th, @Nullable String str, int i11, @Nullable String str2, int i12, @Nullable zzaf zzafVar, int i13, boolean z10) {
        String str3;
        String str4;
        if (i10 == 0) {
            str3 = "Source error";
        } else if (i10 != 1) {
            str3 = "Unexpected runtime error";
        } else {
            String strValueOf = String.valueOf(zzafVar);
            int i14 = zzet.zza;
            if (i13 == 0) {
                str4 = "NO";
            } else if (i13 == 1) {
                str4 = "NO_UNSUPPORTED_TYPE";
            } else if (i13 == 2) {
                str4 = "NO_UNSUPPORTED_DRM";
            } else if (i13 == 3) {
                str4 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i13 != 4) {
                    throw new IllegalStateException();
                }
                str4 = "YES";
            }
            str3 = str2 + " error, index=" + i12 + ", format=" + strValueOf + ", format_supported=" + str4;
        }
        this(TextUtils.isEmpty(null) ? str3 : str3.concat(": null"), th, i11, i10, str2, i12, zzafVar, i13, null, SystemClock.elapsedRealtime(), z10);
    }

    private zzhw(String str, @Nullable Throwable th, int i10, int i11, @Nullable String str2, int i12, @Nullable zzaf zzafVar, int i13, @Nullable zzui zzuiVar, long j10, boolean z10) {
        int i14;
        boolean z11;
        super(str, th, i10, j10);
        if (z10) {
            i14 = i11;
            if (i14 == 1) {
                i14 = 1;
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            i14 = i11;
            z11 = true;
        }
        zzdi.zzd(z11);
        zzdi.zzd(th != null);
        this.zzc = i14;
        this.zzd = str2;
        this.zze = i12;
        this.zzf = zzafVar;
        this.zzg = i13;
        this.zzh = zzuiVar;
        this.zzi = z10;
    }
}
