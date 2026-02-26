package com.google.android.gms.internal.ads;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzb {
    public static final zzb zza = new zzb(null, new zza[0], 0, C.TIME_UNSET, 0);
    private static final zza zze = new zza(0).zzb(0);
    private final zza[] zzf;
    public final long zzc = 0;
    public final int zzb = 0;
    public final int zzd = 0;

    static {
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    private zzb(@Nullable Object obj, zza[] zzaVarArr, long j10, long j11, int i10) {
        this.zzf = zzaVarArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzb.class == obj.getClass()) {
            zzb zzbVar = (zzb) obj;
            if (zzet.zzG(null, null) && Arrays.equals(this.zzf, zzbVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) C.TIME_UNSET) * 961) + Arrays.hashCode(this.zzf);
    }

    public final String toString() {
        return "AdPlaybackState(adsId=" + ((Object) null) + ", adResumePositionUs=0, adGroups=[])";
    }

    public final zza zza(@IntRange(from = 0) int i10) {
        return i10 < 0 ? zze : this.zzf[i10];
    }

    public final boolean zzb(int i10) {
        zza(-1);
        int i11 = zza.zzi;
        return false;
    }
}
