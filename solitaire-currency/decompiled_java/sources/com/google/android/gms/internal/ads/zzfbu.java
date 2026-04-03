package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfbu implements zzful {
    final /* synthetic */ zzfby zza;

    zzfbu(zzfby zzfbyVar) {
        this.zza = zzfbyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzful
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        com.google.android.gms.ads.internal.util.client.zzm.zzh("", (zzdyp) obj);
        com.google.android.gms.ads.internal.util.zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzfby zzfbyVar = this.zza;
        zzfbyVar.zzd = new zzfbx(null, zzfbyVar.zze(), null);
        return this.zza.zzd;
    }
}
