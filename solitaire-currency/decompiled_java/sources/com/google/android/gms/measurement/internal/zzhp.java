package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhp implements Runnable {
    private final /* synthetic */ zziw zza;
    private final /* synthetic */ zzho zzb;

    zzhp(zzho zzhoVar, zziw zziwVar) {
        this.zza = zziwVar;
        this.zzb = zzhoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzho.zza(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
