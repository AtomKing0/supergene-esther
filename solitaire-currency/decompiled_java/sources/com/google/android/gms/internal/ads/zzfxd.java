package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfxd extends zzfxg {
    zzfxd() {
        super(null);
    }

    static final zzfxg zzf(int i10) {
        return i10 < 0 ? zzfxg.zzb : i10 > 0 ? zzfxg.zzc : zzfxg.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final zzfxg zzb(int i10, int i11) {
        return zzf(i10 < i11 ? -1 : i10 > i11 ? 1 : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final zzfxg zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final zzfxg zzd(boolean z10, boolean z11) {
        return zzf(zzgal.zza(z10, z11));
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final zzfxg zze(boolean z10, boolean z11) {
        return zzf(zzgal.zza(z11, z10));
    }
}
