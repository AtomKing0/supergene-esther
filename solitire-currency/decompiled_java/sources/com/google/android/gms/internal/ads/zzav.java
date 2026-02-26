package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzav {
    public final long zza = C.TIME_UNSET;
    public final long zzb = C.TIME_UNSET;
    public final long zzc = C.TIME_UNSET;
    public final float zzd = -3.4028235E38f;
    public final float zze = -3.4028235E38f;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    /* synthetic */ zzav(zzat zzatVar, zzau zzauVar) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzav)) {
            return false;
        }
        long j10 = ((zzav) obj).zza;
        return true;
    }

    public final int hashCode() {
        int i10 = (int) (-9223372034707292159L);
        return (((((((i10 * 31) + i10) * 31) + i10) * 31) + Float.floatToIntBits(-3.4028235E38f)) * 31) + Float.floatToIntBits(-3.4028235E38f);
    }
}
