package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzggb extends zzgex {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzgfz zzd;

    /* synthetic */ zzggb(int i10, int i11, int i12, zzgfz zzgfzVar, zzgga zzggaVar) {
        this.zza = i10;
        this.zzb = i11;
        this.zzd = zzgfzVar;
    }

    public static zzgfy zzd() {
        return new zzgfy(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzggb)) {
            return false;
        }
        zzggb zzggbVar = (zzggb) obj;
        return zzggbVar.zza == this.zza && zzggbVar.zzb == this.zzb && zzggbVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzggb.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        return "AesEax Parameters (variant: " + String.valueOf(this.zzd) + ", " + this.zzb + "-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zzd != zzgfz.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzgfz zze() {
        return this.zzd;
    }
}
