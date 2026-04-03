package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzffr implements zzgcf {
    final /* synthetic */ zzffs zza;
    final /* synthetic */ int zzb;

    zzffr(zzffs zzffsVar, int i10) {
        this.zzb = i10;
        this.zza = zzffsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "BufferingUrlPinger.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i10 = this.zzb;
        this.zza.zzb((String) obj, i10);
    }
}
