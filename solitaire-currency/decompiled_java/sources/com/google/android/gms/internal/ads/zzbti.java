package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbti extends zzbtb {
    final /* synthetic */ List zza;

    zzbti(zzbtk zzbtkVar, List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zze(String str) {
        com.google.android.gms.ads.internal.util.client.zzm.zzg("Error recording click: ".concat(String.valueOf(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzf(List list) {
        com.google.android.gms.ads.internal.util.client.zzm.zzi("Recorded click: ".concat(this.zza.toString()));
    }
}
