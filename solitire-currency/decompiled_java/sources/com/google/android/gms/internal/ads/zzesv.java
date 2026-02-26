package com.google.android.gms.internal.ads;

import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesv implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzesv(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzest zzb() {
        return new zzest(((zzcgp) this.zza).zza(), (Intent) this.zzb.zzb());
    }
}
