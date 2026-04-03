package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgnt {
    private final Class zza;
    private final zzgvr zzb;

    /* synthetic */ zzgnt(Class cls, zzgvr zzgvrVar, zzgns zzgnsVar) {
        this.zza = cls;
        this.zzb = zzgvrVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnt)) {
            return false;
        }
        zzgnt zzgntVar = (zzgnt) obj;
        return zzgntVar.zza.equals(this.zza) && zzgntVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        zzgvr zzgvrVar = this.zzb;
        return this.zza.getSimpleName() + ", object identifier: " + String.valueOf(zzgvrVar);
    }
}
