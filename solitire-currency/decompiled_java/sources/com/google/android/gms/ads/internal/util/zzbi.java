package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzapq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbi implements zzapl {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbl zzb;

    zzbi(zzbo zzboVar, String str, zzbl zzblVar) {
        this.zza = str;
        this.zzb = zzblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapl
    public final void zza(zzapq zzapqVar) {
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to load URL: " + this.zza + "\n" + zzapqVar.toString());
        this.zzb.zza((Object) null);
    }
}
