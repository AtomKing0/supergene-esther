package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfbg implements zzfho {
    private final zzfcc zza;

    public zzfbg(zzfcc zzfccVar) {
        this.zza = zzfccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfho
    public final m zza(zzfhp zzfhpVar) {
        zzfbh zzfbhVar = (zzfbh) zzfhpVar;
        return ((zzfbd) this.zza).zzb(zzfbhVar.zzb, zzfbhVar.zza, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfho
    public final void zzb(zzfhd zzfhdVar) {
        zzfhdVar.zza = ((zzfbd) this.zza).zza();
    }
}
