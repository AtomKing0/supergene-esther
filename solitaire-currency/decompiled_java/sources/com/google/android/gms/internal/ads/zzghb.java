package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzghb extends zzgex {
    private final int zza;
    private final zzggz zzb;

    /* synthetic */ zzghb(int i10, zzggz zzggzVar, zzgha zzghaVar) {
        this.zza = i10;
        this.zzb = zzggzVar;
    }

    public static zzggy zzc() {
        return new zzggy(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghb)) {
            return false;
        }
        zzghb zzghbVar = (zzghb) obj;
        return zzghbVar.zza == this.zza && zzghbVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzghb.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        return "AesGcmSiv Parameters (variant: " + String.valueOf(this.zzb) + ", " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zzb != zzggz.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzggz zzd() {
        return this.zzb;
    }
}
