package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzuu implements zzxv {
    private final zzxv zza;
    private final zzcd zzb;

    public zzuu(zzxv zzxvVar, zzcd zzcdVar) {
        this.zza = zzxvVar;
        this.zzb = zzcdVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzuu)) {
            return false;
        }
        zzuu zzuuVar = (zzuu) obj;
        return this.zza.equals(zzuuVar.zza) && this.zzb.equals(zzuuVar.zzb);
    }

    public final int hashCode() {
        return ((this.zzb.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final int zza(int i10) {
        return this.zza.zza(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final int zzb(int i10) {
        return this.zza.zzb(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final int zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzaf zzd(int i10) {
        return this.zzb.zzb(this.zza.zza(i10));
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzcd zze() {
        return this.zzb;
    }
}
