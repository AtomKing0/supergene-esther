package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcma implements zzcly {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    public zzcma(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcly
    public final void zza(Map map) {
        this.zza.zzy(Boolean.parseBoolean((String) map.get("content_url_opted_out")));
    }
}
