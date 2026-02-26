package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcgd {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcgd(int i10, int i11, int i12) {
        this.zzc = i10;
        this.zzb = i11;
        this.zza = i12;
    }

    public static zzcgd zza() {
        return new zzcgd(0, 0, 0);
    }

    public static zzcgd zzb(int i10, int i11) {
        return new zzcgd(1, i10, i11);
    }

    public static zzcgd zzc(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        return zzqVar.zzd ? new zzcgd(3, 0, 0) : zzqVar.zzi ? new zzcgd(2, 0, 0) : zzqVar.zzh ? zza() : zzb(zzqVar.zzf, zzqVar.zzc);
    }

    public static zzcgd zzd() {
        return new zzcgd(5, 0, 0);
    }

    public static zzcgd zze() {
        return new zzcgd(4, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 0;
    }

    public final boolean zzg() {
        return this.zzc == 2;
    }

    public final boolean zzh() {
        return this.zzc == 5;
    }

    public final boolean zzi() {
        return this.zzc == 3;
    }

    public final boolean zzj() {
        return this.zzc == 4;
    }
}
