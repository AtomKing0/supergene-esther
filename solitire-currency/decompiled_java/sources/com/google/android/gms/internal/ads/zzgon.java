package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgon extends zzgpj {
    private final int zza;
    private final int zzb;
    private final zzgol zzc;

    /* synthetic */ zzgon(int i10, int i11, zzgol zzgolVar, zzgom zzgomVar) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = zzgolVar;
    }

    public static zzgok zze() {
        return new zzgok(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgon)) {
            return false;
        }
        zzgon zzgonVar = (zzgon) obj;
        return zzgonVar.zza == this.zza && zzgonVar.zzd() == zzd() && zzgonVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Objects.hash(zzgon.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + String.valueOf(this.zzc) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zzc != zzgol.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgol zzgolVar = this.zzc;
        if (zzgolVar == zzgol.zzd) {
            return this.zzb;
        }
        if (zzgolVar == zzgol.zza || zzgolVar == zzgol.zzb || zzgolVar == zzgol.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgol zzf() {
        return this.zzc;
    }
}
