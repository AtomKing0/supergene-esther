package com.google.android.gms.ads.nonagon.signalgeneration;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzdff;
import com.google.android.gms.internal.ads.zzgcf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzam implements zzgcf {
    final /* synthetic */ zzdff zza;

    zzam(zzdff zzdffVar) {
        this.zza = zzdffVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        this.zza.zzb(th.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* synthetic */ void zzb(@Nullable Object obj) {
        this.zza.zza((zzay) obj);
    }
}
