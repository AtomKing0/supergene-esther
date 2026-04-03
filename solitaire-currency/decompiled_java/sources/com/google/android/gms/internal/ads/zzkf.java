package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzkf {
    public final long zza;
    public final float zzb;
    public final long zzc;

    /* synthetic */ zzkf(zzkd zzkdVar, zzke zzkeVar) {
        this.zza = zzkdVar.zza;
        this.zzb = zzkdVar.zzb;
        this.zzc = zzkdVar.zzc;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkf)) {
            return false;
        }
        zzkf zzkfVar = (zzkf) obj;
        return this.zza == zzkfVar.zza && this.zzb == zzkfVar.zzb && this.zzc == zzkfVar.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc)});
    }

    public final zzkd zza() {
        return new zzkd(this, null);
    }
}
