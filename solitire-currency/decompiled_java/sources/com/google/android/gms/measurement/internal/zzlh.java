package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlh implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzno zzc;
    private final /* synthetic */ zzla zzd;

    zzlh(zzla zzlaVar, zzn zznVar, boolean z10, zzno zznoVar) {
        this.zza = zznVar;
        this.zzb = z10;
        this.zzc = zznoVar;
        this.zzd = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzfq zzfqVar = this.zzd.zzb;
        if (zzfqVar == null) {
            this.zzd.zzj().zzg().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zzd.zza(zzfqVar, this.zzb ? null : this.zzc, this.zza);
        this.zzd.zzam();
    }
}
