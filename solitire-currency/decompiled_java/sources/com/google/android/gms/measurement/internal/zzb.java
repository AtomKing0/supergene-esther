package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzb implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zza zzc;

    zzb(zza zzaVar, String str, long j10) {
        this.zza = str;
        this.zzb = j10;
        this.zzc = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zza.zzb(this.zzc, this.zza, this.zzb);
    }
}
