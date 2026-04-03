package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzvh {
    public final int zza;
    public final boolean zzb;

    public zzvh(int i10, boolean z10) {
        this.zza = i10;
        this.zzb = z10;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzvh.class == obj.getClass()) {
            zzvh zzvhVar = (zzvh) obj;
            if (this.zza == zzvhVar.zza && this.zzb == zzvhVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
