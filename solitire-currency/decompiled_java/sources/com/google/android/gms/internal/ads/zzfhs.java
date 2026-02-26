package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfhs {
    private final long zza;
    private long zzc;
    private final zzfhr zzb = new zzfhr();
    private int zzd = 0;
    private int zze = 0;
    private int zzf = 0;

    public zzfhs() {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
        this.zza = jCurrentTimeMillis;
        this.zzc = jCurrentTimeMillis;
    }

    public final int zza() {
        return this.zzd;
    }

    public final long zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final zzfhr zzd() {
        zzfhr zzfhrVar = this.zzb;
        zzfhr zzfhrVarClone = zzfhrVar.clone();
        zzfhrVar.zza = false;
        zzfhrVar.zzb = 0;
        return zzfhrVarClone;
    }

    public final String zze() {
        return "Created: " + this.zza + " Last accessed: " + this.zzc + " Accesses: " + this.zzd + "\nEntries retrieved: Valid: " + this.zze + " Stale: " + this.zzf;
    }

    public final void zzf() {
        this.zzc = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
        this.zzd++;
    }

    public final void zzg() {
        this.zzf++;
        this.zzb.zzb++;
    }

    public final void zzh() {
        this.zze++;
        this.zzb.zza = true;
    }
}
