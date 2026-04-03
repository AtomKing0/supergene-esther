package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbzy implements zzgcf {
    final /* synthetic */ zzcaa zza;

    zzbzy(zzcaa zzcaaVar) {
        this.zza = zzcaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        this.zza.zzb.set(-1);
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(@Nullable Object obj) {
        this.zza.zzb.set(1);
    }
}
