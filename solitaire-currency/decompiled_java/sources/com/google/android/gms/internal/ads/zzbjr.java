package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbjr implements zzbix {
    private final zzdvi zza;

    public zzbjr(zzdvi zzdviVar) {
        Preconditions.checkNotNull(zzdviVar, "The Inspector Manager must not be null");
        this.zza = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        if (map == null || !map.containsKey("extras")) {
            return;
        }
        long j10 = Long.MAX_VALUE;
        if (map.containsKey("expires")) {
            try {
                j10 = Long.parseLong((String) map.get("expires"));
            } catch (NumberFormatException unused) {
            }
        }
        this.zza.zzi((String) map.get("extras"), j10);
    }
}
