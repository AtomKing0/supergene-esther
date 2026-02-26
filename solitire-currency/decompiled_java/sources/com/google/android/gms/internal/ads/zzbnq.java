package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbnq implements zzbzv {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzbmu zzb;

    zzbnq(zzbns zzbnsVar, zzbzt zzbztVar, zzbmu zzbmuVar) {
        this.zza = zzbztVar;
        this.zzb = zzbmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzv
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbnd("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
