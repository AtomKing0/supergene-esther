package com.google.android.gms.internal.ads;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcp {
    public static final zzcp zza = new zzcp(0, 0, 0, 1.0f);

    @IntRange(from = 0)
    public final int zzb;

    @IntRange(from = 0)
    public final int zzc;

    @IntRange(from = 0, to = 359)
    public final int zzd = 0;

    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float zze;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
    }

    public zzcp(@IntRange(from = 0) int i10, @IntRange(from = 0) int i11, @IntRange(from = 0, to = 359) int i12, @FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        this.zzb = i10;
        this.zzc = i11;
        this.zze = f10;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcp) {
            zzcp zzcpVar = (zzcp) obj;
            if (this.zzb == zzcpVar.zzb && this.zzc == zzcpVar.zzc && this.zze == zzcpVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzb + 217) * 31) + this.zzc) * 961) + Float.floatToRawIntBits(this.zze);
    }
}
