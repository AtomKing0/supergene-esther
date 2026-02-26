package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbil implements zzgcf {
    final /* synthetic */ zzcej zza;

    zzbil(zzcej zzcejVar) {
        this.zza = zzcejVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcej zzcejVar = this.zza;
        new com.google.android.gms.ads.internal.util.zzbw(zzcejVar.getContext(), zzcejVar.zzn().afmaVersion, (String) obj).zzb();
    }
}
