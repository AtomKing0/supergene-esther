package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zza {
    public static final /* synthetic */ int zzi = 0;
    public final long zza;
    public final int zzb;

    @Deprecated
    public final Uri[] zzc;
    public final zzbc[] zzd;
    public final int[] zze;
    public final long[] zzf;
    public final long zzg;
    public final boolean zzh;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
    }

    public zza(long j10) {
        this(0L, -1, -1, new int[0], new zzbc[0], new long[0], 0L, false);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zza.class == obj.getClass()) {
            zza zzaVar = (zza) obj;
            if (this.zzb == zzaVar.zzb && Arrays.equals(this.zzd, zzaVar.zzd) && Arrays.equals(this.zze, zzaVar.zze) && Arrays.equals(this.zzf, zzaVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zzb * 31) - 1) * 961) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze)) * 31) + Arrays.hashCode(this.zzf)) * 961;
    }

    public final int zza(@IntRange(from = -1) int i10) {
        int i11;
        int i12 = i10 + 1;
        while (true) {
            int[] iArr = this.zze;
            if (i12 >= iArr.length || (i11 = iArr[i12]) == 0 || i11 == 1) {
                break;
            }
            i12++;
        }
        return i12;
    }

    @CheckResult
    public final zza zzb(int i10) {
        int[] iArr = this.zze;
        int length = iArr.length;
        int iMax = Math.max(0, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArr = this.zzf;
        int length2 = jArr.length;
        int iMax2 = Math.max(0, length2);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
        Arrays.fill(jArrCopyOf, length2, iMax2, C.TIME_UNSET);
        return new zza(0L, 0, -1, iArrCopyOf, (zzbc[]) Arrays.copyOf(this.zzd, 0), jArrCopyOf, 0L, false);
    }

    private zza(long j10, int i10, int i11, int[] iArr, zzbc[] zzbcVarArr, long[] jArr, long j11, boolean z10) {
        Uri uri;
        int length = iArr.length;
        int length2 = zzbcVarArr.length;
        int i12 = 0;
        zzdi.zzd(length == length2);
        this.zza = 0L;
        this.zzb = i10;
        this.zze = iArr;
        this.zzd = zzbcVarArr;
        this.zzf = jArr;
        this.zzg = 0L;
        this.zzh = false;
        this.zzc = new Uri[length2];
        while (true) {
            Uri[] uriArr = this.zzc;
            if (i12 >= uriArr.length) {
                return;
            }
            zzbc zzbcVar = zzbcVarArr[i12];
            if (zzbcVar == null) {
                uri = null;
            } else {
                zzax zzaxVar = zzbcVar.zzb;
                zzaxVar.getClass();
                uri = zzaxVar.zza;
            }
            uriArr[i12] = uri;
            i12++;
        }
    }
}
