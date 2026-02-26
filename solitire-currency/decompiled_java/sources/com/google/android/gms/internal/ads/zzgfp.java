package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgfp extends zzgex {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzgfn zze;
    private final zzgfm zzf;

    /* synthetic */ zzgfp(int i10, int i11, int i12, int i13, zzgfn zzgfnVar, zzgfm zzgfmVar, zzgfo zzgfoVar) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = zzgfnVar;
        this.zzf = zzgfmVar;
    }

    public static zzgfl zzf() {
        return new zzgfl(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfp)) {
            return false;
        }
        zzgfp zzgfpVar = (zzgfp) obj;
        return zzgfpVar.zza == this.zza && zzgfpVar.zzb == this.zzb && zzgfpVar.zzc == this.zzc && zzgfpVar.zzd == this.zzd && zzgfpVar.zze == this.zze && zzgfpVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(zzgfp.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        zzgfm zzgfmVar = this.zzf;
        return "AesCtrHmacAead Parameters (variant: " + String.valueOf(this.zze) + ", hashType: " + String.valueOf(zzgfmVar) + ", " + this.zzc + "-byte IV, and " + this.zzd + "-byte tags, and " + this.zza + "-byte AES key, and " + this.zzb + "-byte HMAC key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgen
    public final boolean zza() {
        return this.zze != zzgfn.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzgfm zzg() {
        return this.zzf;
    }

    public final zzgfn zzh() {
        return this.zze;
    }
}
