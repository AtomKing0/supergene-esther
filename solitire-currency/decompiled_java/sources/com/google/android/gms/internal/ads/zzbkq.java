package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbkq implements zzgbq {
    final /* synthetic */ zzbki zza;

    zzbkq(zzbku zzbkuVar, zzbki zzbkiVar) {
        this.zza = zzbkiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbq
    public final /* bridge */ /* synthetic */ m zza(Object obj) throws Exception {
        zzbzt zzbztVar = new zzbzt();
        ((zzbko) obj).zze(this.zza, new zzbkp(this, zzbztVar));
        return zzbztVar;
    }
}
