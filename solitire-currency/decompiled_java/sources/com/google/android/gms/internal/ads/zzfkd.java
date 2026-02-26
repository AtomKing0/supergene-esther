package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfkd implements zzgcf {
    final /* synthetic */ zzfkf zza;
    final /* synthetic */ zzfju zzb;

    zzfkd(zzfkf zzfkfVar, zzfju zzfjuVar) {
        this.zza = zzfkfVar;
        this.zzb = zzfjuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzfju zzfjuVar = this.zzb;
        zzfjuVar.zzh(th);
        zzfjuVar.zzg(false);
        this.zza.zza(zzfjuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
    }
}
