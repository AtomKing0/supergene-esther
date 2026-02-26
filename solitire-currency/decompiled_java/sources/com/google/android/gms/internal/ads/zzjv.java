package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzjv {
    public zzkx zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    public boolean zze;
    public int zzf;
    private boolean zzg;

    public zzjv(zzkx zzkxVar) {
        this.zza = zzkxVar;
    }

    public final void zza(int i10) {
        this.zzg = 1 == ((this.zzg ? 1 : 0) | i10);
        this.zzb += i10;
    }

    public final void zzb(int i10) {
        this.zzg = true;
        this.zze = true;
        this.zzf = i10;
    }

    public final void zzc(zzkx zzkxVar) {
        this.zzg |= this.zza != zzkxVar;
        this.zza = zzkxVar;
    }

    public final void zzd(int i10) {
        if (this.zzc && this.zzd != 5) {
            zzdi.zzd(i10 == 5);
            return;
        }
        this.zzg = true;
        this.zzc = true;
        this.zzd = i10;
    }
}
