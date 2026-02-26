package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbms implements zzbzx {
    final /* synthetic */ zzbmu zza;

    zzbms(zzbmu zzbmuVar) {
        this.zza = zzbmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("Releasing engine reference.");
        this.zza.zzb.zzd();
    }
}
