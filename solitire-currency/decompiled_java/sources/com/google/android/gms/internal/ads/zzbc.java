package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbc {
    public final String zza;

    @Nullable
    public final zzax zzb;
    public final zzav zzc;
    public final zzbh zzd;
    public final zzap zze;
    public final zzaz zzf;

    static {
        new zzam().zzc();
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    /* synthetic */ zzbc(String str, zzar zzarVar, zzax zzaxVar, zzav zzavVar, zzbh zzbhVar, zzaz zzazVar, zzbb zzbbVar) {
        this.zza = str;
        this.zzb = zzaxVar;
        this.zzc = zzavVar;
        this.zzd = zzbhVar;
        this.zze = zzarVar;
        this.zzf = zzazVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbc)) {
            return false;
        }
        zzbc zzbcVar = (zzbc) obj;
        return zzet.zzG(this.zza, zzbcVar.zza) && this.zze.equals(zzbcVar.zze) && zzet.zzG(this.zzb, zzbcVar.zzb) && zzet.zzG(this.zzc, zzbcVar.zzc) && zzet.zzG(this.zzd, zzbcVar.zzd) && zzet.zzG(this.zzf, zzbcVar.zzf);
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() * 31;
        zzax zzaxVar = this.zzb;
        return (((((((iHashCode + (zzaxVar != null ? zzaxVar.hashCode() : 0)) * 31) + this.zzc.hashCode()) * 31) + this.zze.hashCode()) * 31) + this.zzd.hashCode()) * 31;
    }
}
