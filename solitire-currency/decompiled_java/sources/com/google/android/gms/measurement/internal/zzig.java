package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzig implements Runnable {
    private final /* synthetic */ zzbf zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzhs zzc;

    zzig(zzhs zzhsVar, zzbf zzbfVar, zzn zznVar) {
        this.zza = zzbfVar;
        this.zzb = zznVar;
        this.zzc = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzc(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
