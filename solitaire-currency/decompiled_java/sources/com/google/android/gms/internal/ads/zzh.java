package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzh {
    public static final zzh zza = new zzh(0, 0, 1, 1, 0, null);

    @Nullable
    private zzf zzb;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    /* synthetic */ zzh(int i10, int i11, int i12, int i13, int i14, zzg zzgVar) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzh.class != obj.getClass()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 486696559;
    }

    @RequiresApi(21)
    public final zzf zza() {
        if (this.zzb == null) {
            this.zzb = new zzf(this, null);
        }
        return this.zzb;
    }
}
