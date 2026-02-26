package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbxf implements zzgcf {
    final /* synthetic */ m zza;

    zzbxf(zzbxg zzbxgVar, m mVar) {
        this.zza = mVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzbxg.zzc.remove(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbxg.zzc.remove(this.zza);
    }
}
