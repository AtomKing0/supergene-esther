package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpg extends zzgpj {
    private final int zza;
    private final int zzb;
    private final zzgpe zzc;
    private final zzgpd zzd;

    /* synthetic */ zzgpg(int i10, int i11, zzgpe zzgpeVar, zzgpd zzgpdVar, zzgpf zzgpfVar) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = zzgpeVar;
        this.zzd = zzgpdVar;
    }

    public static zzgpc zze() {
        return new zzgpc(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpg)) {
            return false;
        }
        zzgpg zzgpgVar = (zzgpg) obj;
        return zzgpgVar.zza == this.zza && zzgpgVar.zzd() == zzd() && zzgpgVar.zzc == this.zzc && zzgpgVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzgpg.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        zzgpd zzgpdVar = this.zzd;
        return "HMAC Parameters (variant: " + String.valueOf(this.zzc) + ", hashType: " + String.valueOf(zzgpdVar) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zzc != zzgpe.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgpe zzgpeVar = this.zzc;
        if (zzgpeVar == zzgpe.zzd) {
            return this.zzb;
        }
        if (zzgpeVar == zzgpe.zza || zzgpeVar == zzgpe.zzb || zzgpeVar == zzgpe.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgpd zzf() {
        return this.zzd;
    }

    public final zzgpe zzg() {
        return this.zzc;
    }
}
