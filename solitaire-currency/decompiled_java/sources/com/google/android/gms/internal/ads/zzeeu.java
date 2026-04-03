package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeeu implements zzeet {

    @VisibleForTesting
    public final zzeet zza;
    private final zzful zzb;

    public zzeeu(zzeet zzeetVar, zzful zzfulVar) {
        this.zza = zzeetVar;
        this.zzb = zzfulVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final m zza(zzfex zzfexVar, zzfel zzfelVar) {
        return zzgcj.zzm(this.zza.zza(zzfexVar, zzfelVar), this.zzb, zzbzo.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        return this.zza.zzb(zzfexVar, zzfelVar);
    }
}
