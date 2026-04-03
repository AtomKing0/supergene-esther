package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzck {
    public static final zzck zza = new zzck(zzfxr.zzm());
    private final zzfxr zzb;

    static {
        Integer.toString(0, 36);
    }

    public zzck(List list) {
        this.zzb = zzfxr.zzk(list);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzck.class != obj.getClass()) {
            return false;
        }
        return this.zzb.equals(((zzck) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final zzfxr zza() {
        return this.zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzb(int i10) {
        for (int i11 = 0; i11 < this.zzb.size(); i11++) {
            zzcj zzcjVar = (zzcj) this.zzb.get(i11);
            if (zzcjVar.zzc() && zzcjVar.zza() == i10) {
                return true;
            }
        }
        return false;
    }
}
