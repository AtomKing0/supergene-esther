package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgxh {
    private final Object zza;
    private final int zzb;

    zzgxh(Object obj, int i10) {
        this.zza = obj;
        this.zzb = i10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgxh)) {
            return false;
        }
        zzgxh zzgxhVar = (zzgxh) obj;
        return this.zza == zzgxhVar.zza && this.zzb == zzgxhVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
